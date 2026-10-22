package com.qualcomm.qti.qesdk;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import com.qualcomm.qti.qesdkIntf.IQesdk;
import com.qualcomm.qti.qesdkIntf.IQesdkApiInfo;
import com.qualcomm.qti.qesdkIntf.IQesdkCallBack;
import com.qualcomm.qti.qesdkIntf.IQesdkEventCallBack;
import com.qualcomm.qti.qesdkIntf.IQesdkFunctionType;
import defpackage.b;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
abstract class QesdkBase implements IQesdk {
    protected static final String LICENSE_FILE_NAME = "license.qti";
    protected static final String LOG_TAG = "Qesdk Sdk";
    private static boolean isNDKLibLoaded = false;
    private static boolean isNDKSupported = false;
    protected static IQesdkEventCallBack mQesdkFwkEventCb = null;
    private static int ndk_platform_major_ver = -1;
    private static QesdkBase qesdManager;
    protected ThreadPoolExecutor execTaskPool;
    protected boolean isGlobalInit;
    protected boolean isSessionInit;
    private Context mContext;
    protected QesdkUtils.QesdkTimer mQesdkTimer;
    protected final QesdkRejectedTaskHandler mRejectedTaskHandler;
    protected QesdkUtils.QesdkThreadPoolStats mStats;
    protected final Map<Integer, QesdkFunctionTypeCallbackWrapper> mTaskMap;
    Map<Pair<Integer, Integer>, IQesdkEventCallBack> opcode_subsys_callback_map;
    protected int sessionId;

    public static final enum CallType extends Enum<CallType> {
        private static final /* synthetic */ CallType[] $VALUES = null;
        public static final CallType ASYNC = null;
        public static final CallType SYNC = null;

        static {
            CallType r8 = new CallType("ASYNC", 0);
            ASYNC = r8;
            CallType r10 = new CallType("SYNC", 1);
            SYNC = r10;
            $VALUES = new CallType[]{r8, r10};
        }

        private CallType(String r8, int r10) {
            super(r8, r10);
        }

        public static CallType valueOf(String r8) {
            return (CallType) Enum.valueOf(CallType.class, r8);
        }

        public static CallType[] values() {
            return (CallType[]) $VALUES.clone();
        }
    }

    public abstract class QesdkBaseTaskResultHandler implements Runnable {
        private String resultData;
        private int sId;
        final /* synthetic */ QesdkBase this$0;

        public QesdkBaseTaskResultHandler(QesdkBase r8, int r10, String r11) {
            this.this$0 = r8;
            this.resultData = r11;
            this.sId = r10;
        }

        private void handleCbResponse(QesdkFunctionTypeCallbackWrapper r8, QesdkOutputDataParser r10, IQesdkFunctionType r11) {
            Bundle r12 = new Bundle();
            if (this.this$0.buildAsyncResponse(r12, r10, r11) == false) goto L5;
            int r13 = 0;
        L6:
            r12.putInt("status", r13);
            if (r8.getCallback() == null) goto L10;
            r8.getCallback().onValues(r11, r12);
            return;
        L10:
            return;
        L5:
            r13 = r12.getInt("status");
            r12.clear();
            goto L6
        }

        public abstract void handleReturnResponse(QesdkFunctionTypeCallbackWrapper r8, QesdkOutputDataParser r10, IQesdkFunctionType r11);

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.mQesdkTimer.start();
            QesdkUtils.LOG.i(QesdkBase.LOG_TAG, "Got something from the transaction: " + this.resultData);
            if (this.this$0.sessionId == this.sId) goto L6;
            QesdkUtils.LOG.i(QesdkBase.LOG_TAG, "incoming session id: " + this.sId + " actual session id: " + this.this$0.sessionId);
            return;
        L6:
            QesdkOutputDataParser r8 = new QesdkOutputDataParser(this.resultData);
            if (r8.isDataSafe() == true) goto L10;
            QesdkUtils.LOG.e(QesdkBase.LOG_TAG, "Invalid response, dropping response!");
            return;
        L10:
            int r10 = r8.getTransactionId();
            QesdkFunctionTypeCallbackWrapper r11 = this.this$0.mTaskMap.get(Integer.valueOf(r10));
            if (r10 < 0) goto L20;
            if (r11 == null) goto L20;
            IQesdkFunctionType r12 = r11.getFunctionType();
            if (r8.isRetCb() == false) goto L17;
            handleCbResponse(r11, r8, r12);
        L18:
            this.this$0.mQesdkTimer.stop(QesdkBase.LOG_TAG, "handleCbResponse time taken");
            return;
        L17:
            handleReturnResponse(r11, r8, r12);
        L20:
            QesdkUtils.LOG.e(QesdkBase.LOG_TAG, "Invalid transaction, dropping response!");
        }
    }

    public class QesdkFunctionTypeCallbackWrapper {
        private IQesdkFunctionType functionType;
        private IQesdkCallBack iQesdkCallback;
        private QesdkTaskAck taskAck;
        final /* synthetic */ QesdkBase this$0;

        public QesdkFunctionTypeCallbackWrapper(QesdkBase r8) {
            this(r8, null, null, null);
        }

        public IQesdkCallBack getCallback() {
            return this.iQesdkCallback;
        }

        public IQesdkFunctionType getFunctionType() {
            return this.functionType;
        }

        public QesdkTaskAck getTaskAck() {
            return this.taskAck;
        }

        public void setCallback(IQesdkCallBack r8) {
            this.iQesdkCallback = r8;
        }

        public void setFunctionType(IQesdkFunctionType r8) {
            this.functionType = r8;
        }

        public void setTaskAck(QesdkTaskAck r8) {
            this.taskAck = r8;
        }

        public QesdkFunctionTypeCallbackWrapper(QesdkBase r8, IQesdkFunctionType r10, QesdkTaskAck r11, IQesdkCallBack r12) {
            this.this$0 = r8;
            this.functionType = r10;
            this.taskAck = r11;
            this.iQesdkCallback = r12;
        }
    }

    public class QesdkFwkEventResponse {
        public static final int OPCODE_NOT_FOUND = -1;
        private int event;
        private boolean isDataSafe;
        private JSONObject parsedData;
        final /* synthetic */ QesdkBase this$0;

        public QesdkFwkEventResponse(QesdkBase r8, int r10, String r11) {
            this.this$0 = r8;
            this.event = r10;
            this.isDataSafe = parseData(r11);
        }

        private JSONArray getOpcodes() {
            return this.parsedData.getJSONArray(QesdkUtils.TAGS.JSON_TAG_OPCODES);
        L4:
            e = move-exception;
            defpackage.a.k(e, new StringBuilder("Failed to get opcodes: "), QesdkBase.LOG_TAG);
            return null;
        }

        private JSONObject getSingleOpcode(int r8) {
            JSONArray r10 = getOpcodes();
            if (r10 == null) goto L11;
            return r10.getJSONObject(r8);
        L6:
            e = move-exception;
            defpackage.a.k(e, b.f("Failed to get opcode at ", r8, " "), QesdkBase.LOG_TAG);
            return null;
        L11:
            return null;
        }

        private JSONArray getSubsystems(JSONObject r8) {
            return r8.getJSONArray(QesdkUtils.TAGS.JSON_TAG_SUBSYSTEMS);
        L4:
            e = move-exception;
            defpackage.a.k(e, new StringBuilder("Failed to get subsystems "), QesdkBase.LOG_TAG);
            return null;
        }

        private boolean parseData(String r8) {
            this.parsedData = new JSONObject(r8);     // Catch: JSONException -> L5
            return true;
        L5:
            e = move-exception;
            defpackage.a.k(e, new StringBuilder("Failed to parse unexpected event data: "), QesdkBase.LOG_TAG);
            this.parsedData = null;
            return false;
        }

        public int getOpcode(int r8) {
            JSONObject r10 = getSingleOpcode(r8);
            if (r10 == null) goto L11;
            return r10.getInt(QesdkUtils.TAGS.JSON_TAG_OPCODE);
        L6:
            e = move-exception;
            defpackage.a.k(e, b.f("Failed to get opcode value at ", r8, " "), QesdkBase.LOG_TAG);
            return -1;
        L11:
            return -1;
        }

        public int[] getSubsystemsByIndex(int r8) {
            JSONObject r10 = getSingleOpcode(r8);
            if (r10 == null) goto L14;
            JSONArray r11 = getSubsystems(r10);
            if (r11 == null) goto L14;
            int r12 = r11.length();
            int[] r13 = new int[r12];
            int r14 = 0;
        L7:
            if (r14 >= r12) goto L13;
            r13[r14] = r11.getJSONObject(r14).getInt("id");     // Catch: JSONException -> L10
            r14 = r14 + 1;
        L10:
            e = move-exception;
            defpackage.a.k(e, b.f("Failed to get ss values at ", r8, " "), QesdkBase.LOG_TAG);
            return null;
        L13:
            return r13;
        L14:
            return null;
        }

        public boolean isDataSafe() {
            return this.isDataSafe;
        }

        public int length() {
            if (this.isDataSafe == false) goto L8;
            JSONArray r8 = getOpcodes();
            if (r8 != null) goto L7;
            return -1;
        L7:
            return r8.length();
        L8:
            return -1;
        }
    }

    public class QesdkFwkEventResponseHandler implements Runnable {
        private QesdkFwkEventResponse response;
        final /* synthetic */ QesdkBase this$0;

        public QesdkFwkEventResponseHandler(QesdkBase r8, QesdkFwkEventResponse r10) {
            this.this$0 = r8;
            this.response = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r8 = this.response.length();
            int r10 = 0;
        L3:
            if (r10 >= r8) goto L15;
            int r11 = this.response.getOpcode(r10);
            if (r11 == (-1)) goto L9;
            int[] r12 = this.response.getSubsystemsByIndex(r10);
            if (r12 == null) goto L9;
            QesdkBase.mQesdkFwkEventCb.onEvent(r11, r12);
            return;
        L9:
            r10 = r10 + 1;
            goto L3
        }
    }

    public class QesdkRejectedTaskHandler implements RejectedExecutionHandler {
        final /* synthetic */ QesdkBase this$0;

        public QesdkRejectedTaskHandler(QesdkBase r8) {
            this.this$0 = r8;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r8, ThreadPoolExecutor r10) {
            new Thread(r8, "Qesdk-rejected-task-exec").start();
        }
    }

    public final class QesdkTaskAck {
        private Bundle bndl;
        private final CountDownLatch cSignal;
        private boolean isTimedOut;
        final /* synthetic */ QesdkBase this$0;

        public QesdkTaskAck(QesdkBase r8, Bundle r10, CountDownLatch r11) {
            this.this$0 = r8;
            this.bndl = r10;
            this.cSignal = r11;
            this.isTimedOut = true;
        }

        public Bundle getBundle() {
            return this.bndl;
        }

        public CountDownLatch getLatch() {
            return this.cSignal;
        }

        public boolean isTimedOut() {
            return this.isTimedOut;
        }

        public void setIsTimedOut(boolean r8) {
            this.isTimedOut = r8;
        }
    }

    public QesdkBase(Context r8) {
        this.opcode_subsys_callback_map = new HashMap();
        this.mRejectedTaskHandler = new QesdkRejectedTaskHandler(this);
        this.mTaskMap = Collections.synchronizedMap(new HashMap());
        this.mQesdkTimer = new QesdkUtils.QesdkTimer("ms");
        this.isGlobalInit = false;
        this.mContext = r8;
        this.isSessionInit = false;
        this.sessionId = 0;
        this.execTaskPool = null;
        this.mStats = null;
    }

    public static /* synthetic */ Long[] a(int r8) {
        return lambda$buildDataFromVectorType$0(r8);
    }

    private boolean buildDataFromArgs(Bundle r16, JSONObject r17, String r18, IQesdkFunctionType r19, StringBuilder r20) {
        if (r16.containsKey(r18) == true) goto L104;
        StringBuilder r8 = new StringBuilder("Expected arg key not found: ");
        r8.append(r18);
    L57:
        String r10 = r8.toString();
    L98:
        QesdkUtils.LOG.e(LOG_TAG, r10);
        return false;
    L104:
        String r11 = r17.getString("type");     // Catch: Exception -> L96
        r20.append(",\"type\":\"" + r11 + "\",");
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_STRUCT) == true) goto L10;
        r20.append("\"value\":");
    L10:
        if (r11.length() < 3) goto L17;
        if (r11.substring(0, 3).equals(QesdkUtils.TYPES.DATA_TYPE_INT) == true) goto L95;
        if (r11.substring(0, 4).equals(QesdkUtils.TYPES.DATA_TYPE_UINT) == false) goto L17;
    L95:
        return buildDataFromIntArg(r16, r11, r18, r20);
    L17:
        if (r11.equals("boolean") == false) goto L20;
        r20.append(r16.getBoolean(r18));
    L112:
        return true;
    L20:
        if (r11.equals("string") == false) goto L25;
        String r12 = r16.getString(r18, "eulavtluafedsi");
        if (r12.equals("eulavtluafedsi") == true) goto L110;
        StringBuilder r13 = new StringBuilder("\"");
        r13.append(r12);
    L87:
        r13.append("\"");
        String r14 = r13.toString();
    L88:
        r20.append(r14);
        goto L112
    L110:
        return false;
    L25:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_CHAR) == false) goto L28;
        r13 = new StringBuilder("\"");
        r13.append(r16.getChar(r18));
        goto L87
    L28:
        if (r11.equals("float") == false) goto L31;
        r20.append(r16.getFloat(r18));
        goto L112
    L31:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_DOUBLE) == false) goto L40;
        if (r16.getDouble(r18) != Double.MIN_VALUE) goto L35;
    L38:
        r20.append(Double.valueOf(0.0d));
        goto L112
    L35:
        if (r16.getDouble(r18) == Double.MIN_NORMAL) goto L38;
        r20.append(r16.getDouble(r18));
        goto L112
    L40:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_ENUM) == false) goto L43;
        r20.append(r16.getInt(r18));
        goto L112
    L43:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_BNRY_BLB) == false) goto L46;
        r14 = b.d("\"", Base64.getEncoder().encodeToString(r16.getByteArray(r18)), "\"");
        goto L88
    L46:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_VECTOR) == false) goto L71;
        String r15 = r17.getString(QesdkUtils.TAGS.JSON_TAG_VEC_NAME);     // Catch: JSONException -> L68
        if (r15 != null) goto L50;
        return false;
    L50:
        int r21 = ndk_platform_major_ver;
        if (r21 < 5) goto L59;
        JSONObject r22 = getVector(r19, r15);
        JSONObject r23 = r22;
        String r110 = r22.getString("type");     // Catch: JSONException -> L55
    L62:
        if (r110 != null) goto L65;
        return false;
    L65:
        if (buildDataFromVectorType(r16, r110, r18, r23, r19, r20) == true) goto L67;
        r10 = "Couldn't build data from vector!";
        goto L98
    L67:
        r20.append(",\"vec_name\":\"" + r15 + "\"");
        r13 = new StringBuilder(",\"vec_type\":\"");
        r13.append(r110);
    L55:
        e = move-exception;
        r8 = new StringBuilder("Failed to get vector type! ");
        r8.append(e.getMessage());
        goto L57
    L59:
        if (r21 > 4) goto L61;
        r110 = getVectorType(r19, r15);
        r23 = null;
        goto L62
    L61:
        r23 = null;
        r110 = null;
    L68:
        e = e;
        StringBuilder r24 = new StringBuilder("Failed to get vector name! ");
    L94:
        r24.append(e.getMessage());
        r10 = r24.toString();
        goto L98
    L71:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_STRUCT) == false) goto L111;
        String r25 = r17.getString(QesdkUtils.TAGS.JSON_TAG_STRUCT_NAME);     // Catch: JSONException -> L92
        if (r25 != null) goto L75;
        return false;
    L75:
        JSONObject r26 = getStruct(r19, r25);
        if (r26 != null) goto L106;
        String r27 = "Couldn't find struct: ";
    L85:
        r10 = r27.concat(r25);
        goto L98
    L106:
        JSONArray r28 = r26.getJSONArray(QesdkUtils.TAGS.JSON_TAG_MEMBERS);     // Catch: JSONException -> L90
        Bundle r29 = r16.getBundle(r18);
        if (r29 != null) goto L83;
        r10 = "Couldn't find struct from arguments.";
        goto L98
    L83:
        if (buildDataFromStruct(r29, r28, r19, r20, 1) == true) goto L86;
        r27 = "Couldn't build data from struct: ";
        goto L85
    L86:
        r13 = new StringBuilder(",\"struct_name\":\"");
        r13.append(r25);
    L90:
        e = e;
        r24 = new StringBuilder("Couldn't get member description for struct: ");
    L92:
        e = e;
        r24 = new StringBuilder("Failed to get struct name! ");
        goto L94
    L111:
        return false;
    L96:
        e = move-exception;
        r10 = e.getMessage();
        goto L98
    }

    private boolean buildDataFromIntArg(Bundle r8, String r10, String r11, StringBuilder r12) {
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_8) == false) goto L10;
        int r13 = r8.getInt(r11);
        if (r13 < 0) goto L55;
        if (r13 > 255) goto L55;
    L8:
        r12.append(r13);
        return true;
    L55:
        return false;
    L10:
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_16) == false) goto L17;
        r13 = r8.getInt(r11);
        if (r13 < 0) goto L55;
        if (r13 > 65535) goto L55;
    L17:
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_32) == false) goto L19;
    L49:
        long r14 = r8.getLong(r11);
        if (r14 < 0) goto L55;
        if (r14 > QesdkUtils.LIMITS.UINT_32_UPPER) goto L55;
    L53:
        r12.append(r14);
        return true;
    L19:
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_UINT) == true) goto L49;
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_64) == false) goto L27;
        r14 = r8.getLong(r11);
        if (r14 < 0) goto L55;
    L27:
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_INT_8) == false) goto L34;
        r13 = r8.getInt(r11);
        if (r13 < (-128)) goto L55;
        if (r13 > 127) goto L55;
    L34:
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_INT_16) == false) goto L41;
        r13 = r8.getInt(r11);
        if (r13 < (-32768)) goto L55;
        if (r13 > 32767) goto L55;
    L41:
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_INT_32) == false) goto L43;
    L48:
        r13 = r8.getInt(r11);
        goto L8
    L43:
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_INT) == true) goto L48;
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_INT_64) == false) goto L55;
        r14 = r8.getLong(r11);
        goto L53
    }

    private boolean buildDataFromSingleStructMember(Bundle r16, JSONObject r17, IQesdkFunctionType r18, StringBuilder r19, int r20) {
        String r8 = r17.getString("type");     // Catch: JSONException -> L95
        int r10 = r17.getInt("id");     // Catch: JSONException -> L95
        if (r8 == null) goto L94;
        if (r10 < 0) goto L94;
        String r11 = String.valueOf(r10);
        r19.append("\"id\":" + r11);
        r19.append(",\"type\":\"" + r8 + "\",");
        if (r8.equals(QesdkUtils.TYPES.DATA_TYPE_STRUCT) == true) goto L11;
        r19.append("\"value\":");
    L11:
        if (r8.length() < 3) goto L20;
        if (r8.substring(0, 3).equals(QesdkUtils.TYPES.DATA_TYPE_INT) == true) goto L17;
        if (r8.substring(0, 4).equals(QesdkUtils.TYPES.DATA_TYPE_UINT) == false) goto L20;
    L17:
        if (buildDataFromIntArg(r16, r8, r11, r19) == true) goto L87;
        return false;
    L87:
        return true;
    L20:
        if (r8.equals("boolean") == false) goto L23;
        r19.append(r16.getBoolean(r11));
        goto L87
    L23:
        if (r8.equals("string") == false) goto L29;
        String r12 = r16.getString(r11, "eulavtluafedsi");
        if (r12.equals("eulavtluafedsi") == false) goto L27;
        return false;
    L27:
        StringBuilder r13 = new StringBuilder("\"");
        r13.append(r12);
    L85:
        r13.append("\"");
        String r14 = r13.toString();
    L86:
        r19.append(r14);
        goto L87
    L29:
        if (r8.equals(QesdkUtils.TYPES.DATA_TYPE_CHAR) == false) goto L32;
        r13 = new StringBuilder("\"");
        r13.append(r16.getChar(r11));
        goto L85
    L32:
        if (r8.equals("float") == false) goto L35;
        r19.append(r16.getFloat(r11));
        goto L87
    L35:
        if (r8.equals(QesdkUtils.TYPES.DATA_TYPE_DOUBLE) == false) goto L44;
        if (r16.getDouble(r11) != Double.MIN_VALUE) goto L39;
    L42:
        r19.append(Double.valueOf(0.0d));
        goto L87
    L39:
        if (r16.getDouble(r11) == Double.MIN_NORMAL) goto L42;
        r19.append(r16.getDouble(r11));
        goto L87
    L44:
        if (r8.equals(QesdkUtils.TYPES.DATA_TYPE_ENUM) == false) goto L51;
        r19.append(r16.getInt(r11));
        String r15 = r17.getString(QesdkUtils.TAGS.JSON_TAG_ENUM_NAME);     // Catch: JSONException -> L48
    L49:
        StringBuilder r21 = new StringBuilder(",\"enum_name\":\"");
    L53:
        r14 = android.aimedia.a.i(r21, r15, "\"");
    L48:
        QesdkUtils.LOG.e(LOG_TAG, "Couldn't find an enum name");
        r15 = null;
        goto L49
    L51:
        if (r8.equals(QesdkUtils.TYPES.DATA_TYPE_BNRY_BLB) == false) goto L55;
        r15 = Base64.getEncoder().encodeToString(r16.getByteArray(r11));
        r21 = new StringBuilder("\"");
        goto L53
    L55:
        if (r8.equals(QesdkUtils.TYPES.DATA_TYPE_VECTOR) == false) goto L69;
        String r110 = r17.getString(QesdkUtils.TAGS.JSON_TAG_VEC_NAME);     // Catch: JSONException -> L66
        if (r110 != null) goto L59;
        return false;
    L59:
        String r111 = getVectorType(r18, r110);
        if (r111 != null) goto L63;
        return false;
    L63:
        if (buildDataFromVectorType(r16, r111, r11, r17, r18, r19) == true) goto L65;
        String r22 = "Couldn't build data from vector!";
    L96:
        QesdkUtils.LOG.e(LOG_TAG, r22);
        return false;
    L65:
        r19.append(",\"vec_name\":\"" + r110 + "\"");
        r13 = new StringBuilder(",\"vec_type\":\"");
        r13.append(r111);
    L66:
        e = e;
        StringBuilder r23 = new StringBuilder("Failed to get vector name! ");
    L92:
        r23.append(e.getMessage());
        r22 = r23.toString();
        goto L96
    L69:
        if (r8.equals(QesdkUtils.TYPES.DATA_TYPE_STRUCT) == true) goto L102;
        r22 = "Unknown struct member type: ".concat(r8);
        goto L96
    L102:
        String r24 = r17.getString(QesdkUtils.TAGS.JSON_TAG_STRUCT_NAME);     // Catch: JSONException -> L90
        if (r24 != null) goto L73;
        return false;
    L73:
        JSONObject r25 = getStruct(r18, r24);
        if (r25 != null) goto L98;
        String r26 = "Couldn't find struct: ";
    L83:
        r22 = r26.concat(r24);
        goto L96
    L98:
        JSONArray r27 = r25.getJSONArray(QesdkUtils.TAGS.JSON_TAG_MEMBERS);     // Catch: JSONException -> L88
        Bundle r28 = r16.getBundle(r11);
        if (r28 != null) goto L81;
        r22 = "Couldn't find struct from arguments.";
        goto L96
    L81:
        if (buildDataFromStruct(r28, r27, r18, r19, r20 + 1) == true) goto L84;
        r26 = "Couldn't build data from struct: ";
        goto L83
    L84:
        r13 = new StringBuilder(",\"struct_name\":\"");
        r13.append(r24);
    L88:
        e = e;
        r23 = new StringBuilder("Couldn't get member description for struct: ");
    L90:
        e = e;
        r23 = new StringBuilder("Failed to get struct name! ");
    L94:
        r22 = "Not enough info to build data";
    L95:
        r22 = "Couldn't retrieve member type or id";
        goto L96
    }

    private boolean buildDataFromStruct(Bundle r16, JSONArray r17, IQesdkFunctionType r18, StringBuilder r19, int r20) {
        if (r20 <= 10) goto L6;
        r19.append("]");
        return false;
    L6:
        int r11 = r17.length();
        int r12 = r16.size();
        r19.append("\"members\":[");
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L24;
        if (r13 >= r12) goto L24;
        JSONObject r8 = r17.getJSONObject(r13);     // Catch: JSONException -> L20
        r19.append("{");
        if (buildDataFromSingleStructMember(r16, r8, r18, r19, r20) == false) goto L13;
        r19.append("}");
        if (r13 >= (r11 - 1)) goto L19;
        if (r13 >= (r12 - 1)) goto L19;
        r19.append(",");
    L19:
        r13 = r13 + 1;
        goto L7
    L13:
        String r10 = "Couldn't build data from single struct member";
    L22:
        QesdkUtils.LOG.e(LOG_TAG, r10);
        return false;
    L20:
        e = move-exception;
        r10 = "Couldn't get a single member of struct: " + e.getMessage();
    L24:
        r19.append("]");
        return true;
    }

    private boolean buildDataFromVectorType(Bundle r17, String r18, String r19, JSONObject r20, IQesdkFunctionType r21, StringBuilder r22) {
        if (r18.equals(QesdkUtils.TYPES.DATA_TYPE_ENUM) == false) goto L5;
        JSONArray r8 = new JSONArray(r17.getIntegerArrayList(r19));
    L109:
        String r10 = r8.toString();
    L110:
        r22.append(r10);
    L111:
        return true;
    L5:
        int r11 = 0;
        if (r18.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_8) == false) goto L8;
    L105:
        ArrayList<Integer> r12 = r17.getIntegerArrayList(r19);
        if (verifyIntVector(r12.toArray(), r18) == true) goto L108;
        return false;
    L108:
        r8 = new JSONArray(r12);
        goto L109
    L8:
        if (r18.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_16) == true) goto L105;
        if (r18.equals(QesdkUtils.TYPES.DATA_TYPE_INT_8) == true) goto L105;
        if (r18.equals(QesdkUtils.TYPES.DATA_TYPE_INT_16) == true) goto L105;
        if (r18.equals(QesdkUtils.TYPES.DATA_TYPE_INT_32) == true) goto L105;
        if (r18.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_64) == false) goto L19;
    L117:
        long[] r13 = r17.getLongArray(r19);     // Catch: JSONException -> L99
        if (verifyIntVector(Arrays.stream(r13).boxed().toArray(new a()), r18) == true) goto L97;
        return false;
    L97:
        r22.append(new JSONArray(r13).toString());     // Catch: JSONException -> L99
    L99:
        e = e;
        StringBuilder r14 = new StringBuilder("Couldn't build data from vector long type: ");
    L101:
        r14.append(r18);
        r14.append(" ");
    L102:
        r14.append(e.getMessage());
        String r15 = r14.toString();
    L103:
        QesdkUtils.LOG.e(LOG_TAG, r15);
        return false;
    L19:
        if (r18.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_32) == true) goto L117;
        if (r18.equals(QesdkUtils.TYPES.DATA_TYPE_INT_64) == true) goto L117;
        if (r18.equals("boolean") == false) goto L30;
        r22.append(new JSONArray(r17.getBooleanArray(r19)).toString());     // Catch: JSONException -> L27
    L27:
        e = e;
        r14 = new StringBuilder("Couldn't build data from vector boolean type: ");
        goto L101
    L30:
        if (r18.equals("string") == false) goto L33;
        r8 = new JSONArray(r17.getStringArrayList(r19));
        goto L109
    L33:
        if (r18.equals("float") == false) goto L39;
        r22.append(new JSONArray(r17.getFloatArray(r19)).toString());     // Catch: JSONException -> L36
    L36:
        e = e;
        r14 = new StringBuilder("Couldn't build data from vector float type: ");
        goto L101
    L39:
        if (r18.equals(QesdkUtils.TYPES.DATA_TYPE_DOUBLE) == false) goto L54;
        double[] r16 = r17.getDoubleArray(r19);     // Catch: JSONException -> L51
        int r23 = 0;
    L42:
        if (r23 >= r16.length) goto L49;
        double r24 = r16[r23];     // Catch: JSONException -> L51
        if (r24 != Double.MIN_VALUE) goto L46;
    L47:
        r16[r23] = 0.0d;     // Catch: JSONException -> L51
    L48:
        r23 = r23 + 1;     // Catch: JSONException -> L51
        goto L42
    L46:
        if (r24 != Double.MIN_NORMAL) goto L48;
    L49:
        r22.append(new JSONArray(r16).toString());     // Catch: JSONException -> L51
    L51:
        e = e;
        r14 = new StringBuilder("Couldn't build data from vector double type: ");
        goto L101
    L54:
        if (r18.equals(QesdkUtils.TYPES.DATA_TYPE_BNRY_BLB) == false) goto L63;
        Bundle r25 = r17.getBundle(r19);
        ArrayList r26 = new ArrayList();
        if (r25 != null) goto L58;
        r15 = "Couldn't find a blob argument.";
        goto L103
    L58:
        int r27 = r25.size();
    L59:
        if (r11 >= r27) goto L61;
        r26.add(Base64.getEncoder().encodeToString(r25.getByteArray(String.valueOf(r11))));
        r11 = r11 + 1;
        goto L59
    L61:
        r8 = new JSONArray(r26);
        goto L109
    L63:
        if (r18.equals(QesdkUtils.TYPES.DATA_TYPE_STRUCT) == false) goto L134;
        if (r20 != null) goto L66;
        r15 = "Failed to get vector description.";
        goto L103
    L66:
        Bundle r110 = r17.getBundle(r19);
        if (r110 != null) goto L113;
        r15 = "Couldn't find vector of structs from arguments.";
        goto L103
    L113:
        String r111 = r20.getString(QesdkUtils.TAGS.JSON_TAG_STRUCT_NAME);     // Catch: JSONException -> L92
        if (r111 != null) goto L72;
        return false;
    L72:
        JSONObject r28 = getStruct(r21, r111);
        if (r28 != null) goto L121;
        String r29 = "Couldn't find struct: ";
    L84:
        r15 = r29.concat(r111);
        goto L103
    L121:
        JSONArray r112 = r28.getJSONArray(QesdkUtils.TAGS.JSON_TAG_MEMBERS);     // Catch: JSONException -> L90
        int r113 = r110.size();
        r22.append("[");
        int r114 = 0;
    L77:
        if (r114 >= r113) goto L89;
        Bundle r30 = r110.getBundle(String.valueOf(r114));
        if (r30 == null) goto L80;
        r22.append("{");
        if (buildDataFromStruct(r30, r112, r21, r22, 1) == false) goto L83;
        r22.append("}");
        if (r114 >= (r113 - 1)) goto L88;
        r22.append(",");
    L88:
        r114 = r114 + 1;
        goto L77
    L83:
        r29 = "Couldn't build data from struct: ";
        goto L84
    L80:
        r15 = "Couldn't find struct from arguments.";
        goto L103
    L89:
        r10 = "]";
    L90:
        e = e;
        r14 = new StringBuilder("Couldn't get member description for struct: ");
    L92:
        e = e;
        r14 = new StringBuilder("Failed to get struct name! ");
        goto L102
    L134:
        return false;
    }

    private boolean buildResponseCommon(Bundle r12, QesdkDataParser r13, IQesdkFunctionType r14) {
        if (r13.isDataSafe() == true) goto L7;
        r12.putInt("status", -1);
        return false;
    L7:
        switch(r13.getStatus()) {
            case -9: goto L50;
            case -8: goto L48;
            case -7: goto L46;
            case -6: goto L44;
            case -5: goto L8;
            case -4: goto L42;
            case -3: goto L40;
            case -2: goto L38;
            case -1: goto L36;
            case 0: goto L10;
            default: goto L8;
        };
    L8:
        r12.putInt("status", -1);
        return false;
    L10:
        r12.putInt("status", 0);
        int r8 = r13.getNumberOfOutputs();
        JSONArray r15 = r13.getOutputs();
        if (r15 != null) goto L14;
        QesdkUtils.LOG.e(LOG_TAG, "No output responses found! dropping response.");
        r12.putInt("status", -1);
        return false;
    L14:
        int r10 = 0;
    L15:
        if (r10 >= r8) goto L34;
        JSONObject r11 = r15.getJSONObject(r10);     // Catch: JSONException -> L18
    L52:
    L24:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
    L26:
        if (r11 == null) goto L27;
        if (buildResponseFromOutput(r12, r11, r14) == false) goto L31;
        r10 = r10 + 1;
        goto L15
    L31:
        r12.putInt("status", -1);
        return false;
    L27:
        r12.putInt("status", -1);
        return false;
    L21:
        if (r11.getInt("status") != (-9)) goto L26;
        QesdkUtils.LOG.e(LOG_TAG, "API disabled by OEM");     // Catch: JSONException -> L24
        r12.putInt("status", -7);     // Catch: JSONException -> L24
        return false;
    L18:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        r11 = null;
        goto L52
    L34:
        return true;
    L36:
        r12.putInt("status", -1);
        return false;
    L38:
        r12.putInt("status", -2);
        return false;
    L40:
        r12.putInt("status", -3);
        return false;
    L42:
        r12.putInt("status", -9);
        return false;
    L44:
        r12.putInt("status", -5);
        return false;
    L46:
        r12.putInt("status", -4);
        return false;
    L48:
        r12.putInt("status", -8);
        return false;
    L50:
        QesdkUtils.LOG.e(LOG_TAG, "API disabled by OEM");
        r12.putInt("status", -7);
        return false;
    }

    private boolean buildResponseFromIntType(Bundle r8, String r10, int r11, JSONObject r12) {
        int r13 = 0;
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_8) == false) goto L14;
        int r14 = r12.getInt("value");     // Catch: JSONException -> L6
    L8:
        if (r14 >= 0) goto L10;
    L93:
        return false;
    L10:
        if (r14 > 255) goto L93;
        r8.putInt(String.valueOf(r11), r14);
        return true;
    L6:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        r14 = 0;
        goto L8
    L14:
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_16) == true) goto L100;
        long r15 = 0;
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_32) == false) goto L27;
    L104:
        long r16 = r12.getLong("value");     // Catch: JSONException -> L85
    L88:
        if (r16 < 0) goto L93;
        if (r16 > QesdkUtils.LIMITS.UINT_32_UPPER) goto L93;
        r8.putLong(String.valueOf(r11), r16);
        return true;
    L85:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        r16 = 0;
        goto L88
    L27:
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_UINT) == true) goto L104;
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_64) == false) goto L40;
        long r17 = r12.getLong("value");     // Catch: JSONException -> L33
    L36:
        if (r17 < 0) goto L93;
        r8.putLong(String.valueOf(r11), r17);
        return true;
    L33:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        r17 = 0;
        goto L36
    L40:
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_INT_8) == false) goto L52;
        int r18 = r12.getInt("value");     // Catch: JSONException -> L43
    L46:
        if (r18 < (-128)) goto L93;
        if (r18 > 127) goto L93;
        r8.putInt(String.valueOf(r11), r18);
        return true;
    L43:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        r18 = 0;
        goto L46
    L52:
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_INT_16) == false) goto L64;
        int r19 = r12.getInt("value");     // Catch: JSONException -> L55
    L58:
        if (r19 < (-32768)) goto L93;
        if (r19 > 32767) goto L93;
        r8.putInt(String.valueOf(r11), r19);
        return true;
    L55:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        r19 = 0;
        goto L58
    L64:
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_INT_32) == false) goto L66;
    L98:
        r13 = r12.getInt("value");     // Catch: JSONException -> L79
    L81:
        r8.putInt(String.valueOf(r11), r13);
        return true;
    L79:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        goto L81
    L66:
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_INT) == true) goto L98;
        if (r10.equals(QesdkUtils.TYPES.DATA_TYPE_INT_64) == true) goto L106;
        return false;
    L106:
        r15 = r12.getLong("value");     // Catch: JSONException -> L72
    L74:
        r8.putLong(String.valueOf(r11), r15);
        return true;
    L72:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        goto L74
    L100:
        int r20 = r12.getInt("value");     // Catch: JSONException -> L17
    L19:
        if (r20 < 0) goto L93;
        if (r20 > 65535) goto L93;
        r8.putInt(String.valueOf(r11), r20);
        return true;
    L17:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        r20 = 0;
        goto L19
    }

    private boolean buildResponseFromOutput(Bundle r8, JSONObject r10, IQesdkFunctionType r11) {
        String r12 = null;
        r12 = r10.getString("type");     // Catch: JSONException -> L5
        int r13 = r10.getInt("id");     // Catch: JSONException -> L5
    L8:
        if (r12 == null) goto L89;
        if (r13 != (-1)) goto L12;
        return false;
    L12:
        if (r12.length() < 3) goto L88;
        if (r12.substring(0, 3).equals(QesdkUtils.TYPES.DATA_TYPE_INT) == true) goto L18;
        if (r12.substring(0, 4).equals(QesdkUtils.TYPES.DATA_TYPE_UINT) == false) goto L88;
    L18:
        return buildResponseFromIntType(r8, r12, r13, r10);
    L88:
        if (r12.equals("boolean") == false) goto L26;
        r8.putBoolean(String.valueOf(r13), r10.getBoolean("value"));     // Catch: JSONException -> L23
        return true;
    L26:
        if (r12.equals("string") == false) goto L30;
        r8.putString(String.valueOf(r13), r10.getString("value"));     // Catch: JSONException -> L23
        return true;
    L30:
        if (r12.equals("float") == false) goto L34;
        r8.putFloat(String.valueOf(r13), (float) r10.getDouble("value"));     // Catch: JSONException -> L23
        return true;
    L34:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_DOUBLE) == false) goto L38;
        r8.putDouble(String.valueOf(r13), r10.getDouble("value"));     // Catch: JSONException -> L23
        return true;
    L38:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_ENUM) == false) goto L42;
        r8.putInt(String.valueOf(r13), r10.getInt("value"));     // Catch: JSONException -> L23
        return true;
    L42:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_BNRY_BLB) == false) goto L50;
        String r14 = r10.getString("value");     // Catch: JSONException -> L23
        if (r14 != null) goto L46;
        return false;
    L46:
        r8.putByteArray(String.valueOf(r13), Base64.getDecoder().decode(r14));
        return true;
    L50:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_VECTOR) == false) goto L69;
        String r15 = r10.getString(QesdkUtils.TAGS.JSON_TAG_VEC_NAME);     // Catch: JSONException -> L65
        if (r15 != null) goto L54;
        return false;
    L54:
        String r16 = getVectorType(r11, r15);
        if (r16 != null) goto L80;
        return false;
    L80:
        JSONArray r17 = r10.getJSONArray("value");     // Catch: JSONException -> L63
        if (r17 != null) goto L61;
        return false;
    L61:
        if (buildResponseFromVectorType(r8, r16, String.valueOf(r13), r17) == true) goto L91;
        String r18 = "Couldn't build response from vector!";
    L78:
        QesdkUtils.LOG.e(LOG_TAG, r18);
        return false;
    L91:
        return true;
    L63:
        e = e;
        StringBuilder r19 = new StringBuilder("Failed to get json array value ");
    L67:
        r19.append(e.getMessage());
        r18 = r19.toString();
    L65:
        e = e;
        r19 = new StringBuilder("Failed to get vector name ");
        goto L67
    L69:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_STRUCT) == false) goto L90;
        Bundle r110 = new Bundle();
        if (buildResponseFromStruct(r110, r10.getJSONArray(QesdkUtils.TAGS.JSON_TAG_MEMBERS), 1) == true) goto L75;
        r18 = "Couldn't build response from struct";
        goto L78
    L75:
        r8.putBundle(String.valueOf(r13), r110);
    L77:
        r18 = "Couldn't retrieve members of a struct";
        goto L78
    L90:
        return false;
    L23:
        e = move-exception;
        r18 = e.getMessage();
        goto L78
    L89:
        return false;
    L5:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        r13 = -1;
        goto L8
    }

    private boolean buildResponseFromSingleStructMember(Bundle r10, JSONObject r11, int r12) {
        String r8 = r11.getString("type");     // Catch: JSONException -> L90
        int r13 = r11.getInt("id");     // Catch: JSONException -> L90
        if (r8 == null) goto L88;
        if (r13 < 0) goto L88;
        String r14 = String.valueOf(r13);
        if (r8.length() < 3) goto L16;
        if (r8.substring(0, 3).equals(QesdkUtils.TYPES.DATA_TYPE_INT) == true) goto L14;
        if (r8.substring(0, 4).equals(QesdkUtils.TYPES.DATA_TYPE_UINT) == false) goto L16;
    L14:
        return buildResponseFromIntType(r10, r8, r13, r11);
    L16:
        if (r8.equals("boolean") == false) goto L23;
        r10.putBoolean(r14, r11.getBoolean("value"));     // Catch: JSONException -> L19
    L87:
        return true;
    L19:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        return false;
    L23:
        if (r8.equals("string") == false) goto L30;
        r10.putString(r14, r11.getString("value"));     // Catch: JSONException -> L26
    L26:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        return false;
    L30:
        if (r8.equals("float") == false) goto L37;
        r10.putFloat(r14, (float) r11.getDouble("value"));     // Catch: JSONException -> L33
    L33:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        return false;
    L37:
        if (r8.equals(QesdkUtils.TYPES.DATA_TYPE_DOUBLE) == false) goto L44;
        r10.putDouble(r14, r11.getDouble("value"));     // Catch: JSONException -> L40
    L40:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        return false;
    L44:
        if (r8.equals(QesdkUtils.TYPES.DATA_TYPE_ENUM) == false) goto L51;
        r10.putInt(r14, r11.getInt("value"));     // Catch: JSONException -> L47
    L47:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        return false;
    L51:
        if (r8.equals(QesdkUtils.TYPES.DATA_TYPE_BNRY_BLB) == false) goto L60;
        String r15 = r11.getString("value");     // Catch: JSONException -> L56
        if (r15 != null) goto L55;
        return false;
    L55:
        r10.putByteArray(r14, Base64.getDecoder().decode(r15));
    L56:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        return false;
    L60:
        if (r8.equals(QesdkUtils.TYPES.DATA_TYPE_VECTOR) == false) goto L76;
        String r16 = r11.getString(QesdkUtils.TAGS.JSON_TAG_VEC_TYPE);     // Catch: JSONException -> L72
        JSONArray r17 = r11.getJSONArray("value");     // Catch: JSONException -> L69
        if (r17 != null) goto L66;
        return false;
    L66:
        if (buildResponseFromVectorType(r10, r16, r14, r17) == true) goto L87;
        QesdkUtils.LOG.e(LOG_TAG, "Couldn't build data from vector!");
        return false;
    L69:
        e = move-exception;
        defpackage.a.k(e, new StringBuilder("Failed to get json array value "), LOG_TAG);
        return false;
    L72:
        e = move-exception;
        QesdkUtils.LOG.i(LOG_TAG, "Failed to get vector type: " + e.getMessage());
        return false;
    L76:
        if (r8.equals(QesdkUtils.TYPES.DATA_TYPE_STRUCT) == false) goto L86;
        Bundle r18 = new Bundle();
        if (buildResponseFromStruct(r18, r11.getJSONArray(QesdkUtils.TAGS.JSON_TAG_MEMBERS), r12 + 1) == true) goto L83;
        QesdkUtils.LOG.e(LOG_TAG, "Couldn't build response from struct");
        return false;
    L83:
        r10.putBundle(String.valueOf(r13), r18);
    L84:
        QesdkUtils.LOG.e(LOG_TAG, "Couldn't retrieve members of a struct");
        return false;
    L86:
        QesdkUtils.LOG.e(LOG_TAG, "Unknown struct member type found: ".concat(r8));
    L88:
        QesdkUtils.LOG.e(LOG_TAG, "Not enough info to build data");
        return false;
    L90:
        QesdkUtils.LOG.e(LOG_TAG, "Couldn't retrieve member type or id");
        return false;
    }

    private boolean buildResponseFromStruct(Bundle r8, JSONArray r10, int r11) {
        if (r11 <= 10) goto L5;
        String r12 = "Maximum nested structure count has exceeded";
    L14:
        QesdkUtils.LOG.e(LOG_TAG, r12);
        return false;
    L5:
        int r13 = r10.length();
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L16;
        if (buildResponseFromSingleStructMember(r8, r10.getJSONObject(r14), r11) == false) goto L10;
        r14 = r14 + 1;
        goto L6
    L10:
        r12 = "Couldn't build response from single struct member";
    L12:
        e = move-exception;
        r12 = "Couldn't get a single member of struct: " + e.getMessage();
        goto L14
    L16:
        return true;
    }

    private boolean buildResponseFromVectorType(Bundle r11, String r12, String r13, JSONArray r14) {
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_ENUM) == false) goto L12;
        ArrayList<Integer> r10 = new ArrayList();
        int r15 = 0;
    L6:
        if (r15 >= r14.length()) goto L186;
        r10.add(Integer.valueOf(r14.getInt(r15)));     // Catch: JSONException -> L9
        r15 = r15 + 1;
    L9:
        e = e;
        StringBuilder r16 = new StringBuilder("Failed to get enum from json array ");
    L183:
        r16.append(e.getMessage());
        String r17 = r16.toString();
    L184:
        QesdkUtils.LOG.e(LOG_TAG, r17);
        return false;
    L186:
        r11.putIntegerArrayList(r13, r10);
        return true;
    L12:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_8) == false) goto L26;
        r10 = new ArrayList();
        int r18 = 0;
    L15:
        if (r18 >= r14.length()) goto L186;
        int r8 = r14.getInt(r18);     // Catch: JSONException -> L23
        if (r8 < 0) goto L22;
        if (r8 > 255) goto L22;
        r10.add(Integer.valueOf(r8));     // Catch: JSONException -> L23
        r18 = r18 + 1;
    L22:
        return false;
    L23:
        e = e;
        r16 = new StringBuilder("Failed to get uint8 from json array ");
        goto L183
    L26:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_16) == false) goto L40;
        r10 = new ArrayList();
        int r19 = 0;
    L29:
        if (r19 >= r14.length()) goto L186;
        int r20 = r14.getInt(r19);     // Catch: JSONException -> L37
        if (r20 < 0) goto L36;
        if (r20 > 65535) goto L36;
        r10.add(Integer.valueOf(r20));     // Catch: JSONException -> L37
        r19 = r19 + 1;
    L36:
        return false;
    L37:
        e = e;
        r16 = new StringBuilder("Failed to get uint16 from json array ");
        goto L183
    L40:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_32) == false) goto L55;
        long[] r110 = new long[r14.length()];
        int r111 = 0;
    L43:
        if (r111 >= r14.length()) goto L53;
        long r21 = r14.getLong(r111);     // Catch: JSONException -> L51
        if (r21 < 0) goto L50;
        if (r21 > QesdkUtils.LIMITS.UINT_32_UPPER) goto L50;
        r110[r111] = r21;     // Catch: JSONException -> L51
        r111 = r111 + 1;
    L50:
        return false;
    L51:
        e = e;
        r16 = new StringBuilder("Failed to get uint32 from json array ");
        goto L183
    L53:
        r11.putLongArray(r13, r110);
        return true;
    L55:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_64) == false) goto L68;
        long[] r112 = new long[r14.length()];
        int r113 = 0;
    L58:
        if (r113 >= r14.length()) goto L66;
        long r22 = r14.getLong(r113);     // Catch: JSONException -> L64
        if (r22 < 0) goto L63;
        r112[r113] = r22;     // Catch: JSONException -> L64
        r113 = r113 + 1;
        goto L58
    L63:
        return false;
    L64:
        e = e;
        r16 = new StringBuilder("Failed to get uint64 from json array ");
        goto L183
    L66:
        r11.putLongArray(r13, r112);
        return true;
    L68:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_INT_8) == false) goto L82;
        r10 = new ArrayList();
        int r114 = 0;
    L71:
        if (r114 >= r14.length()) goto L186;
        int r23 = r14.getInt(r114);     // Catch: JSONException -> L79
        if (r23 < (-128)) goto L78;
        if (r23 > 127) goto L78;
        r10.add(Integer.valueOf(r23));     // Catch: JSONException -> L79
        r114 = r114 + 1;
    L78:
        return false;
    L79:
        e = e;
        r16 = new StringBuilder("Failed to get int8 from json array ");
        goto L183
    L82:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_INT_16) == false) goto L96;
        r10 = new ArrayList();
        int r115 = 0;
    L85:
        if (r115 >= r14.length()) goto L186;
        int r24 = r14.getInt(r115);     // Catch: JSONException -> L93
        if (r24 < (-32768)) goto L92;
        if (r24 > 32767) goto L92;
        r10.add(Integer.valueOf(r24));     // Catch: JSONException -> L93
        r115 = r115 + 1;
    L92:
        return false;
    L93:
        e = e;
        r16 = new StringBuilder("Failed to get int16 from json array ");
        goto L183
    L96:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_INT_32) == false) goto L98;
    L176:
        r10 = new ArrayList();
        int r116 = 0;
    L178:
        if (r116 >= r14.length()) goto L186;
        r10.add(Integer.valueOf(r14.getInt(r116)));     // Catch: JSONException -> L181
        r116 = r116 + 1;
    L181:
        e = e;
        r16 = new StringBuilder("Failed to get int32 from json array ");
        goto L183
    L98:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_INT) == true) goto L176;
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_INT_64) == false) goto L111;
        long[] r117 = new long[r14.length()];
        int r118 = 0;
    L104:
        if (r118 >= r14.length()) goto L109;
        r117[r118] = r14.getLong(r118);     // Catch: JSONException -> L107
        r118 = r118 + 1;
    L107:
        e = e;
        r16 = new StringBuilder("Failed to get int64 from json array ");
        goto L183
    L109:
        r11.putLongArray(r13, r117);
        return true;
    L111:
        if (r12.equals("boolean") == false) goto L120;
        int r119 = r14.length();
        boolean[] r120 = new boolean[r119];
        int r25 = 0;
    L113:
        if (r25 >= r119) goto L118;
        r120[r25] = r14.getBoolean(r25);     // Catch: JSONException -> L116
        r25 = r25 + 1;
    L116:
        e = e;
        r16 = new StringBuilder("Failed to get boolean from json array ");
        goto L183
    L118:
        r11.putBooleanArray(r13, r120);
        return true;
    L120:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_BNRY_BLB) == false) goto L132;
        Bundle r121 = new Bundle();
        int r122 = 0;
    L123:
        if (r122 >= r14.length()) goto L130;
        String r26 = r14.getString(r122);     // Catch: JSONException -> L128
        if (r26 == null) goto L126;
        r121.putByteArray(String.valueOf(r122), Base64.getDecoder().decode(r26));
        r122 = r122 + 1;
        goto L123
    L126:
        r17 = "encoded string is null";
    L128:
        e = e;
        r16 = new StringBuilder("Failed to get encoded string: ");
        goto L183
    L130:
        r11.putBundle(r13, r121);
        return true;
    L132:
        if (r12.equals("string") == false) goto L142;
        ArrayList<String> r123 = new ArrayList();
        int r124 = 0;
    L135:
        if (r124 >= r14.length()) goto L140;
        r123.add(r14.getString(r124));     // Catch: JSONException -> L138
        r124 = r124 + 1;
    L138:
        e = e;
        r16 = new StringBuilder("Failed to get string from json array ");
        goto L183
    L140:
        r11.putStringArrayList(r13, r123);
        return true;
    L142:
        if (r12.equals("float") == false) goto L151;
        int r125 = r14.length();
        float[] r126 = new float[r125];
        int r27 = 0;
    L144:
        if (r27 >= r125) goto L149;
        r126[r27] = new Double(r14.getDouble(r27)).floatValue();     // Catch: JSONException -> L147
        r27 = r27 + 1;
    L147:
        e = e;
        r16 = new StringBuilder("Failed to get float from json array ");
        goto L183
    L149:
        r11.putFloatArray(r13, r126);
        return true;
    L151:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_DOUBLE) == false) goto L160;
        int r127 = r14.length();
        double[] r128 = new double[r127];
        int r28 = 0;
    L153:
        if (r28 >= r127) goto L158;
        r128[r28] = r14.getDouble(r28);     // Catch: JSONException -> L156
        r28 = r28 + 1;
    L156:
        e = e;
        r16 = new StringBuilder("Failed to get double from json array ");
        goto L183
    L158:
        r11.putDoubleArray(r13, r128);
        return true;
    L160:
        if (r12.equals(QesdkUtils.TYPES.DATA_TYPE_STRUCT) == false) goto L257;
        Bundle r129 = new Bundle();
        int r29 = 0;
    L163:
        if (r29 >= r14.length()) goto L174;
        Bundle r30 = new Bundle();
        if (buildResponseFromStruct(r30, r14.getJSONObject(r29).getJSONArray(QesdkUtils.TAGS.JSON_TAG_MEMBERS), 1) == false) goto L169;
        r129.putBundle(String.valueOf(r29), r30);
        r29 = r29 + 1;
        goto L163
    L169:
        r17 = "Couldn't build response from struct";
    L171:
        r17 = "Couldn't retrieve members of a struct";
    L172:
        e = e;
        r16 = new StringBuilder("Failed to get struct from json array ");
        goto L183
    L174:
        r11.putBundle(String.valueOf(r13), r129);
        return true;
    L257:
        return false;
    }

    private boolean buildTaskArguments(String[] r17, Bundle r18, JSONArray r19, IQesdkFunctionType r20, StringBuilder r21) {
        int r8 = r18.size();
        int r10 = r19.length();
        int r11 = r17.length;
        if (r10 == r11) goto L6;
        QesdkUtils.LOG.e(LOG_TAG, "Number of arguments mismatched! ");
        return false;
    L6:
        if (r8 == r11) goto L13;
        if (r11 > r8) goto L9;
    L11:
        QesdkUtils.LOG.e(LOG_TAG, "Number of arguments mismatched! ");
        return false;
    L9:
        if (r8 != (r11 - 2)) goto L11;
        r10 = r10 - 2;
    L13:
        int r12 = r10;
        r21.append(r12);
        r21.append(", \"args\": [");
        if (r12 != 1) goto L26;
        r21.append("{\"id\":");
        r21.append(0);
        if (buildDataFromArgs(r18, r19.getJSONObject(0), "0", r20, r21) == false) goto L21;
        r21.append("}");
        return true;
    L21:
        return false;
    L26:
        int r14 = 0;
    L27:
        if (r14 >= r12) goto L37;
        r21.append("{\"id\":");
        r21.append(String.valueOf(r14));
        JSONObject r15 = r19.getJSONObject(r14);     // Catch: Exception -> L22
        if (buildDataFromArgs(r18, r15, String.valueOf(r14), r20, r21) == false) goto L32;
        r21.append("}");
        if (r14 == (r12 - 1)) goto L36;
        r21.append(",");
    L36:
        r14 = r14 + 1;
        goto L27
    L32:
        String r13 = "Failed building args for " + r15.toString();
    L24:
        QesdkUtils.LOG.e(LOG_TAG, r13);
        return false;
    L37:
        QesdkUtils.LOG.i(LOG_TAG, "Arguments built: " + r21.toString());
        return true;
    L22:
        e = move-exception;
        r13 = e.getMessage();
        goto L24
    }

    private void cleanUpTaskPool() {
        ThreadPoolExecutor r8 = this.execTaskPool;
        if (r8 == null) goto L5;
        r8.shutdown();
    L5:
        QesdkUtils.QesdkThreadPoolStats r10 = this.mStats;
        if (r10 == null) goto L9;
        r10.terminate();
        return;
    }

    public static synchronized QesdkBase getInstance(Context r8) {
        monitor-enter(QesdkBase.class);
        Log.i(LOG_TAG, "Build-Info: 16_321_484");     // Catch: Throwable -> L15
        Log.i(LOG_TAG, "Release Version: Internal");     // Catch: Throwable -> L15
        QesdkBase r10 = qesdManager;     // Catch: Throwable -> L15
        if (r10 != null) goto L12;
        if (r8 != null) goto L9;
        monitor-exit(QesdkBase.class);
        return r10;
    L9:
        loadLib();     // Catch: Throwable -> L15
        if (isNDKSupported == false) goto L12;
        QesdkUtils.LOG.i(LOG_TAG, "loading QesdkNative");     // Catch: Throwable -> L15
        qesdManager = QesdkNative.getInstance(r8);     // Catch: Throwable -> L15
    L12:
        QesdkBase r11 = qesdManager;     // Catch: Throwable -> L15
        monitor-exit(QesdkBase.class);
        return r11;
    L15:
        th = move-exception;
        throw th;
    }

    private String getLicenseInfo(String r8) {
        InputStream r10 = this.mContext.getAssets().open("license/" + r8);     // Catch: IOException -> L5
        byte[] r11 = new byte[r10.available()];     // Catch: IOException -> L5
        r10.read(r11);     // Catch: IOException -> L5
        r10.close();     // Catch: IOException -> L5
        return new String(r11);
    L5:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, "Failed to open license: " + e.getMessage());
        return null;
    }

    public static int getTransactionIdFromData(QesdkDataParser r8) {
        return r8.getTransactionId();
    }

    private void initDbgUtils() {
    }

    private static /* synthetic */ Long[] lambda$buildDataFromVectorType$0(int r8) {
        return new Long[r8];
    }

    public static void loadLib() {
        if (isNDKLibLoaded == true) goto L26;
        isNDKLibLoaded = true;
        QesdkUtils.LOG.i(LOG_TAG, "loading library..");     // Catch: Throwable -> L17
        System.loadLibrary("qesdk_ndk_platform.qti");     // Catch: Throwable -> L17
        isNDKSupported = true;     // Catch: Throwable -> L17
        QesdkNative.QesdkPlatVersion r8 = new QesdkNative.QesdkPlatVersion(-1, -1, -1);
        QesdkNative.getPlatformVersion(r8);     // Catch: Throwable -> L15
        int r10 = r8.getMajor();     // Catch: Throwable -> L15
        int r11 = r8.getMinor();     // Catch: Throwable -> L15
        int r12 = r8.getPatch();     // Catch: Throwable -> L15
        ndk_platform_major_ver = r10;     // Catch: Throwable -> L15
        if (r10 < 1) goto L13;
        if (r11 < 0) goto L13;
        if (r12 < 0) goto L13;
        QesdkUtils.LOG.i(LOG_TAG, "Platform lib with " + r10 + "." + r11 + "." + r12 + " loaded.");     // Catch: Throwable -> L15 Throwable -> L15
        QesdkNative.setVersion(r8);     // Catch: Throwable -> L15 Throwable -> L15
    L20:
        return;
    L13:
        QesdkUtils.LOG.i(LOG_TAG, "Invalid Platform lib version " + r10 + "." + r11 + "." + r12 + " loaded.");     // Catch: Throwable -> L15 Throwable -> L15
        isNDKSupported = false;     // Catch: Throwable -> L15 Throwable -> L15
    L15:
        e = move-exception;
        QesdkUtils.LOG.i(LOG_TAG, "NDK lib not supported: " + e.getMessage());
        isNDKSupported = false;
        return;
    L17:
        e = move-exception;
        QesdkUtils.LOG.i(LOG_TAG, "NDK lib not supported: " + e.getMessage());
        isNDKSupported = false;
        return;
    }

    private boolean verifyIntVector(Object[] r10, String r11) {
        if (r10.length != 0) goto L6;
        return true;
    L6:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_8) == false) goto L20;
        int r8 = r10.length;
        int r12 = 0;
        boolean r13 = false;
    L8:
        if (r12 >= r8) goto L119;
        Object r14 = r10[r12];
        if ((r14 instanceof Integer) == false) goto L11;
        int r15 = ((Integer) r14).intValue();
        if (r15 < 0) goto L17;
        if (r15 > 255) goto L17;
        r12 = r12 + 1;
        r13 = true;
    L17:
        return false;
    L11:
        return false;
    L119:
        return r13;
    L20:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_16) == false) goto L33;
        int r16 = r10.length;
        int r17 = 0;
        r13 = false;
    L22:
        if (r17 >= r16) goto L119;
        Object r18 = r10[r17];
        if ((r18 instanceof Integer) == false) goto L25;
        int r19 = ((Integer) r18).intValue();
        if (r19 < 0) goto L31;
        if (r19 > 65535) goto L31;
        r17 = r17 + 1;
        r13 = true;
    L31:
        return false;
    L25:
        return false;
    L33:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_32) == false) goto L35;
    L83:
        int r20 = r10.length;
        int r110 = 0;
        boolean r21 = false;
    L84:
        if (r110 >= r20) goto L95;
        Object r22 = r10[r110];
        if ((r22 instanceof Long) == false) goto L87;
        long r23 = ((Long) r22).longValue();
        if (r23 < 0) goto L93;
        if (r23 > QesdkUtils.LIMITS.UINT_32_UPPER) goto L93;
        r110 = r110 + 1;
        r21 = true;
    L93:
        return false;
    L87:
        return false;
    L95:
        return r21;
    L35:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_UINT) == true) goto L83;
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_UINT_64) == false) goto L49;
        int r24 = r10.length;
        int r111 = 0;
        r21 = false;
    L40:
        if (r111 >= r24) goto L95;
        Object r25 = r10[r111];
        if ((r25 instanceof Long) == false) goto L43;
        if (((Long) r25).longValue() < 0) goto L47;
        r111 = r111 + 1;
        r21 = true;
        goto L40
    L47:
        return false;
    L43:
        return false;
    L49:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_INT_8) == false) goto L62;
        int r26 = r10.length;
        int r112 = 0;
        r13 = false;
    L51:
        if (r112 >= r26) goto L119;
        Object r27 = r10[r112];
        if ((r27 instanceof Integer) == false) goto L54;
        int r28 = ((Integer) r27).intValue();
        if (r28 < (-128)) goto L60;
        if (r28 > 127) goto L60;
        r112 = r112 + 1;
        r13 = true;
    L60:
        return false;
    L54:
        return false;
    L62:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_INT_16) == false) goto L75;
        int r29 = r10.length;
        int r113 = 0;
        r13 = false;
    L64:
        if (r113 >= r29) goto L119;
        Object r30 = r10[r113];
        if ((r30 instanceof Integer) == false) goto L67;
        int r31 = ((Integer) r30).intValue();
        if (r31 < (-32768)) goto L73;
        if (r31 > 32767) goto L73;
        r113 = r113 + 1;
        r13 = true;
    L73:
        return false;
    L67:
        return false;
    L75:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_INT_32) == false) goto L77;
        return true;
    L77:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_INT) == false) goto L80;
        return true;
    L80:
        if (r11.equals(QesdkUtils.TYPES.DATA_TYPE_INT_64) == false) goto L121;
        return true;
    L121:
        return false;
    }

    public HashMap<Pair<String, Integer>, String[]> APIdetailsCommon() {
        return APIdetailsInternal();
    }

    public abstract HashMap<Pair<String, Integer>, String[]> APIdetailsInternal();

    public boolean buildAsyncResponse(Bundle r8, QesdkDataParser r10, IQesdkFunctionType r11) {
        return buildResponseCommon(r8, r10, r11);
    }

    public boolean buildSyncResponse(Bundle r8, QesdkDataParser r10, IQesdkFunctionType r11) {
        return buildResponseCommon(r8, r10, r11);
    }

    public String buildTaskInputData(IQesdkFunctionType r10, Bundle r11, JSONArray r12, CallType r13, int r14) {
        int r8 = r10.getNumberOfArgs();
        StringBuilder r15 = new StringBuilder();
        if (r13 != CallType.SYNC) goto L5;
        String r16 = QesdkUtils.TAGS.TAG_SYNC;
    L6:
        r15.append("{\"opcode\":");
        r15.append("\"" + r10.getOpCode());
        r15.append("\",\"subsys_id\":");
        r15.append(r10.getSSId());
        r15.append(",\"transac_id\":");
        r15.append(r14);
        r15.append(",\"session_id\":");
        r15.append(this.sessionId);
        r15.append(",\"req_type\":\"exec_task\",\"call_type\":");
        r15.append("\"".concat(r16));
        r15.append("\",\"func\": { \"name\":");
        r15.append("\"" + r10.getFunctionName());
        r15.append("\",\"version\":");
        r15.append(r10.getFunctionVersion());
        r15.append(",\"num_of_args\":");
        if (r8 != 0) goto L9;
        r15.append("0,\"args\": [");
    L13:
        r15.append("]}}");
        return r15.toString();
    L9:
        if (buildTaskArguments(r10.getArgNames(), r11, r12, r10, r15) == true) goto L13;
        return null;
    L5:
        r16 = QesdkUtils.TAGS.TAG_ASYNC;
        goto L6
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public boolean checkGlobalInit() {
        return this.isGlobalInit;
    }

    public synchronized void completeCleanUp() {
        monitor-enter(this);
        this.isSessionInit = false;     // Catch: Throwable -> L7
        this.sessionId = 0;     // Catch: Throwable -> L7
        mQesdkFwkEventCb = null;     // Catch: Throwable -> L7
        this.mTaskMap.clear();     // Catch: Throwable -> L7
        this.mContext = null;     // Catch: Throwable -> L7
        cleanUpTaskPool();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public int deinit() {
        return deinitInternal(0, 0);
    }

    public abstract int deinitInternal(int r8, int r10);

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public int getSessionId() {
        if (this.isSessionInit == true) goto L5;
        return -1;
    L5:
        return this.sessionId;
    }

    public abstract JSONObject getStruct(IQesdkFunctionType r8, String r10);

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public HashMap<Pair<String, Integer>, String[]> getSupportedAPI() {
        return APIdetailsCommon();
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public IQesdkApiInfo getSupportedApiInfo() {
        return new QesdkApiInfo(APIdetailsCommon());
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public Vector<String> getSupportedApinames(HashMap<Pair<String, Integer>, String[]> r8) {
        Vector<String> r10 = new Vector();
        if (r8 == null) goto L15;
        Iterator<Pair<String, Integer>> r11 = r8.keySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L15;
        String[] r12 = r8.get(r11.next());
        int r13 = 0;
    L9:
        if (r13 >= r12.length) goto L6;
        r10.add(new JSONObject(r12[r13]).getJSONObject(QesdkUtils.TAGS.JSON_TAG_FUNC).getString(QesdkUtils.TAGS.JSON_TAG_NAME));     // Catch: JSONException -> L12
    L14:
        r13 = r13 + 1;
    L12:
        e = move-exception;
        e.printStackTrace();
    L15:
        return r10;
    }

    public abstract JSONObject getVector(IQesdkFunctionType r8, String r10);

    public abstract String getVectorType(IQesdkFunctionType r8, String r10);

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public int init(IQesdkEventCallBack r8) {
        return initCommon(true, null, 0, 0, r8);
    }

    public int initCommon(boolean r8, String r10, int r11, int r12, IQesdkEventCallBack r13) {
        this.mQesdkTimer.start();
        if (r8 == false) goto L6;
        r10 = getLicenseInfo(LICENSE_FILE_NAME);
        QesdkUtils.LOG.i(LOG_TAG, "License content: " + r10);
    L6:
        if (r10 != null) goto L8;
    L9:
        r10 = "";
    L10:
        this.mQesdkTimer.stop(LOG_TAG, "initCommon ADK SDK license read time taken");
        int r14 = initInternal(r10, r11, r12);
        this.mQesdkTimer.start();
        if (r14 <= 0) goto L17;
        this.isSessionInit = true;
        this.sessionId = r14;
        this.opcode_subsys_callback_map.put(new Pair(Integer.valueOf(r11), Integer.valueOf(r12)), r13);
        mQesdkFwkEventCb = r13;
        if (r11 != 0) goto L16;
        if (r12 != 0) goto L16;
        this.isGlobalInit = true;
    L16:
        initTaskPool();
    L17:
        this.mQesdkTimer.stop(LOG_TAG, "initcommon ADK SDK register opcode & subsys time taken");
        return r14;
    L8:
        if (r10.isEmpty() == false) goto L10;
        goto L9
    }

    public abstract int initInternal(String r8, int r10, int r11);

    public void initTaskPool() {
        ThreadPoolExecutor r8 = this.execTaskPool;
        if (r8 != null) goto L5;
    L6:
        this.execTaskPool = new ThreadPoolExecutor(5, 20, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1), this.mRejectedTaskHandler);
    L7:
        initDbgUtils();
        return;
    L5:
        if (r8.isShutdown() == false) goto L7;
        goto L6
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public int deinit(int r8, int r10) {
        return deinitInternal(r8, r10);
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public int init(IQesdkEventCallBack r8, int r10, int r11) {
        return initCommon(false, null, r10, r11, r8);
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public int init(String r8, int r10, int r11, IQesdkEventCallBack r12) {
        if (r8 == null) goto L9;
        if (r8.isEmpty() == true) goto L9;
        return initCommon(false, r8, r10, r11, r12);
    L9:
        return initCommon(true, null, r10, r11, r12);
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public int init(String r8, IQesdkEventCallBack r10) {
        int r11 = 0;
        int r12 = 0;
        if (r8 != null) goto L5;
    L10:
        boolean r13 = true;
        String r14 = null;
        r11 = 0;
        r12 = 0;
    L9:
        return initCommon(r13, r14, r11, r12, r10);
    L5:
        if (r8.isEmpty() == true) goto L10;
        r13 = false;
        r14 = r8;
        goto L9
    }
}
