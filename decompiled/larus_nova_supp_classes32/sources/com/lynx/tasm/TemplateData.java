package com.lynx.tasm;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.common.NullableConcurrentHashMap;
import com.lynx.tasm.core.LynxThreadPool;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class TemplateData {
    private static final String TAG = "LynxTemplateData";
    private final AtomicBoolean mConsumed;
    private volatile Map<String, Object> mData;
    private final Object mDataLock;
    private volatile boolean mEnableJSData;
    private final AtomicBoolean mIsConcurrent;
    volatile long mJsNativeData;
    private final Object mJsNativeDataLock;
    private volatile long mNativeData;
    private final Object mNativeDataLock;
    private String mProcessorName;
    List<UpdateAction> mUpdateActions;
    private final Object mUpdateActionsLock;
    private volatile boolean readOnly;
    private WeakReference<LynxContext> weakContext;

    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType BYTE_BUFFER = null;
        public static final ActionType NATIVE_DATA = null;
        public static final ActionType REMOVE_DATA = null;
        public static final ActionType STRING_DATA = null;
        public static final /* synthetic */ ActionType[] a = null;

        static {
            ActionType r0 = new ActionType("STRING_DATA", 0);
            STRING_DATA = r0;
            ActionType r1 = new ActionType("BYTE_BUFFER", 1);
            BYTE_BUFFER = r1;
            ActionType r3 = new ActionType("NATIVE_DATA", 2);
            NATIVE_DATA = r3;
            ActionType r5 = new ActionType("REMOVE_DATA", 3);
            REMOVE_DATA = r5;
            a = new ActionType[]{r0, r1, r3, r5};
        }

        public static ActionType[] values() {
            return (ActionType[]) a.clone();
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) r27.a.a(ActionType.class, r1);
        }

        public ActionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class UpdateAction {
        public ActionType a;
        public ByteBuffer b;
        public String c;
        public String d;
        public long e;

        public UpdateAction() {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = 0;
        }

        public final void finalize() throws Throwable {
            super.finalize();
            long r0 = this.e;
            if (r0 == 0) goto L6;
            TemplateData.access$000(r0);
            return;
        }

        public long getNativeData() {
            return this.e;
        }

        public ActionType getType() {
            return this.a;
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ TemplateData a;

        @Override // java.lang.Runnable
        public final void run() {
            TemplateData.access$100(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(TemplateData r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ TemplateData a;

        @Override // java.lang.Runnable
        public final void run() {
            TemplateData.access$200(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(TemplateData r1) {
            this.a = r1;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ TemplateData a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getDataForJSThreadInner();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(TemplateData r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ActionType.values().length];
            a = r0;
            r0[ActionType.STRING_DATA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[ActionType.NATIVE_DATA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[ActionType.BYTE_BUFFER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[ActionType.REMOVE_DATA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private static native long nativeClone(long r0);

    private static native long nativeCreateObject();

    private static native long nativeCreateTemplateData(long r0, boolean r2, String r3, Object r4);

    public static native Object nativeGetData(long r0);

    public static native void nativeMergeTemplateData(long r0, long r2);

    private static native long nativeParseData(ByteBuffer r0, int r1);

    private static native long nativeParseStringData(String r0);

    private static native void nativeReleaseData(long r0);

    private static native void nativeReleaseTemplateData(long r0);

    private static native void nativeRemoveData(long r0, String r2);

    private static native long nativeShallowCopy(long r0);

    private static native void nativeUpdateData(long r0, ByteBuffer r2, int r3);

    public void markReadOnly() {
        this.readOnly = true;
    }

    public static TemplateData empty() {
        return new TemplateData();
    }

    private void ensureInternalMap() {
        if (this.mData != null) goto L18;
        Object r0 = this.mDataLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.mData == null) goto L9;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L9:
        if (this.mIsConcurrent.get() == false) goto L11;
        Map<String, Object> r1 = new NullableConcurrentHashMap();     // Catch: Throwable -> L15
    L12:
        this.mData = r1;     // Catch: Throwable -> L15
        goto L13
    L11:
        r1 = new HashMap();     // Catch: Throwable -> L15
        goto L12
    }

    private List<UpdateAction> obtainUpdateActions() {
        Object r0 = this.mUpdateActionsLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mUpdateActions);     // Catch: Throwable -> L7
        this.mUpdateActions.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void releaseJsData() {
        if (this.mJsNativeData != 0) goto L5;
        return;
    L5:
        Object r0 = this.mJsNativeDataLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (checkIfEnvPrepared() == true) goto L10;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L10:
        if (this.mJsNativeData == 0) goto L12;
        nativeReleaseData(this.mJsNativeData);     // Catch: Throwable -> L14
        this.mJsNativeData = 0;     // Catch: Throwable -> L14
        goto L12
    }

    private void releaseNativeData() {
        if (this.mNativeData != 0) goto L5;
        return;
    L5:
        Object r0 = this.mNativeDataLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (checkIfEnvPrepared() == true) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L12:
        if (this.mNativeData == 0) goto L14;
        nativeReleaseData(this.mNativeData);     // Catch: Throwable -> L16
        this.mNativeData = 0;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    public boolean checkIsLegalData() {
        if (this.mNativeData == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long getDataForJSThreadInner() {
        if (this.mEnableJSData == true) goto L5;
        return 0;
    L5:
        List<UpdateAction> r0 = obtainUpdateActions();
        if (r0.isEmpty() == false) goto L15;
        Object r3 = this.mJsNativeDataLock;
        monitor-enter(r3);
        long r1 = this.mJsNativeData;     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        return r1;
    L12:
        th = move-exception;
        throw th;
    L15:
        Object r4 = this.mJsNativeDataLock;
        monitor-enter(r4);
    L59:
        th = move-exception;
        throw th;
    L18:
        if (this.mJsNativeData != 0) goto L20;
        this.mJsNativeData = nativeCreateObject();     // Catch: Throwable -> L59
    L20:
        Iterator<UpdateAction> r2 = r0.iterator();     // Catch: Throwable -> L59
    L22:
        if (r2.hasNext() == false) goto L56;
        UpdateAction r5 = r2.next();     // Catch: Throwable -> L59
        int r6 = d.a[r5.getType().ordinal()];     // Catch: Throwable -> L59
        if (r6 != 1) goto L26;
        String r7 = r5.c;     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r7) == true) goto L22;
        long r8 = nativeParseStringData(r7);     // Catch: Throwable -> L50
        nativeMergeTemplateData(this.mJsNativeData, r8);     // Catch: Throwable -> L48
        if (r8 == 0) goto L22;
        nativeReleaseData(r8);     // Catch: Throwable -> L59
    L48:
        th = th;
    L53:
        if (r8 == 0) goto L55;
        nativeReleaseData(r8);     // Catch: Throwable -> L59
    L55:
        throw th;     // Catch: Throwable -> L59
    L50:
        th = th;
        r8 = 0;
        goto L53
    L26:
        if (r6 != 2) goto L28;
        nativeMergeTemplateData(this.mJsNativeData, r5.getNativeData());     // Catch: Throwable -> L59
        goto L22
    L28:
        if (r6 != 3) goto L30;
        ByteBuffer r9 = r5.b;     // Catch: Throwable -> L59
        if (r9 == null) goto L22;
        if (r9.position() == 0) goto L22;
        nativeUpdateData(this.mJsNativeData, r9, r9.position());     // Catch: Throwable -> L59
        goto L22
    L30:
        if (r6 != 4) goto L31;
        nativeRemoveData(this.mJsNativeData, r5.d);     // Catch: Throwable -> L59
        goto L22
    L31:
        LLog.e(TAG, "undefined action type: " + r5.getType());     // Catch: Throwable -> L59
        goto L22
    L56:
        long r10 = this.mJsNativeData;     // Catch: Throwable -> L59
        monitor-exit(r4);     // Catch: Throwable -> L59
        return r10;
    }

    public boolean isEmpty() {
        if (this.mNativeData != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void markConcurrent() {
        this.mIsConcurrent.set(true);
    }

    public void markConsumed() {
        this.mConsumed.set(true);
    }

    public void recycle() {
        WeakReference<LynxContext> r0 = this.weakContext;
        if (r0 == null) goto L8;
        LynxContext r1 = r0.get();
        if (r1 == null) goto L8;
        r1.runOnTasmThread(new a(this));
        return;
    L8:
        releaseNativeData();
    }

    public void recycleJsData() {
        WeakReference<LynxContext> r0 = this.weakContext;
        if (r0 == null) goto L8;
        LynxContext r1 = r0.get();
        if (r1 == null) goto L8;
        r1.runOnTasmThread(new b(this));
        return;
    L8:
        releaseJsData();
    }

    public TemplateData shallowClone() {
        TraceEvent.beginSection("TemplateData.ShallowClone");
        if (checkIfEnvPrepared() == true) goto L6;
        LLog.e(TAG, "shallowClone failed since env not ready!");
        TraceEvent.endSection("TemplateData.ShallowClone");
        return empty();
    L6:
        flush();
        TemplateData r1 = empty();
        if (this.mNativeData == 0) goto L9;
        r1.mNativeData = nativeShallowCopy(this.mNativeData);
    L9:
        r1.mProcessorName = this.mProcessorName;
        r1.readOnly = this.readOnly;
        r1.mIsConcurrent.set(this.mIsConcurrent.get());
        r1.addUpdateActions(copyUpdateActions(true));
        TraceEvent.endSection("TemplateData.ShallowClone");
        return r1;
    }

    public TemplateData() {
        this.mIsConcurrent = new AtomicBoolean(false);
        this.readOnly = false;
        this.mEnableJSData = true;
        this.mConsumed = new AtomicBoolean(false);
        this.mUpdateActionsLock = new Object();
        this.mDataLock = new Object();
        this.mJsNativeDataLock = new Object();
        this.mNativeDataLock = new Object();
        this.mUpdateActions = new ArrayList();
        LynxEnv.inst();
        this.mProcessorName = null;
    }

    private static boolean checkIfEnvPrepared() {
        return LynxEnv.inst().isNativeLibraryLoaded();
    }

    private void consumeUpdateActions() {
        LynxThreadPool.a().execute(new c(this));
    }

    public TemplateData deepClone() {
        if (checkIfEnvPrepared() == true) goto L6;
        LLog.e(TAG, "deepClone failed since env not ready!");
        return empty();
    L6:
        flush();
        TemplateData r0 = empty();
        if (this.mNativeData == 0) goto L9;
        r0.mNativeData = nativeClone(this.mNativeData);
    L9:
        r0.mProcessorName = this.mProcessorName;
        r0.readOnly = this.readOnly;
        r0.mIsConcurrent.set(this.mIsConcurrent.get());
        r0.addUpdateActions(copyUpdateActions(true));
        return r0;
    }

    public void finalize() throws Throwable {
        recycle();
        recycleJsData();
        super.finalize();
    }

    public void flush() {
        if (checkIfEnvPrepared() == true) goto L6;
        LLog.w(TAG, "Env not ready!");
        return;
    L6:
        Object r0 = this.mDataLock;
        monitor-enter(r0);
    L42:
        th = move-exception;
        throw th;
    L9:
        if (this.mData != null) goto L11;
    L31:
        Object r1 = this.mNativeDataLock;     // Catch: Throwable -> L42
        monitor-enter(r1);     // Catch: Throwable -> L42
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L34:
        if (this.mNativeData != 0) goto L36;
        this.mNativeData = nativeCreateObject();     // Catch: Throwable -> L39
    L36:
        monitor-exit(r1);     // Catch: Throwable -> L39
        monitor-exit(r0);     // Catch: Throwable -> L42
        return;
    L11:
        if (this.mData.isEmpty() == true) goto L31;
        HashMap r2 = new HashMap(this.mData);     // Catch: Throwable -> L42
        this.mData.clear();     // Catch: Throwable -> L42
        monitor-exit(r0);     // Catch: Throwable -> L42
        j7a.a.a.getClass();
        ByteBuffer r3 = j7a.a.b(r2);
        if (r3 != null) goto L18;
        return;
    L18:
        if (r3.position() <= 0) goto L50;
        LLog.i(TAG, "flush data." + this);
        UpdateAction r4 = new UpdateAction();
        r4.a = ActionType.BYTE_BUFFER;
        r4.b = r3;
        addUpdateAction(r4);
        Object r5 = this.mNativeDataLock;
        monitor-enter(r5);
    L27:
        th = move-exception;
        throw th;
    L22:
        if (this.mNativeData != 0) goto L24;
        this.mNativeData = nativeParseData(r3, r3.position());     // Catch: Throwable -> L27
    L25:
        monitor-exit(r5);     // Catch: Throwable -> L27
        return;
    L24:
        nativeUpdateData(this.mNativeData, r3, r3.position());     // Catch: Throwable -> L27
        goto L25
    }

    public long getDataForJSThread() {
        return getDataForJSThreadInner();
    }

    public TemplateData getTemplateDataForJSThread() {
        TemplateData r0 = empty();
        r0.mEnableJSData = true;
        Object r1 = this.mJsNativeDataLock;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mJsNativeData == 0) goto L7;
        r0.mJsNativeData = nativeClone(this.mJsNativeData);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r1);     // Catch: Throwable -> L10
        r0.addUpdateActions(copyUpdateActions(false));
        return r0;
    }

    public Map<Object, Object> toMap() {
        if (checkIfEnvPrepared() == true) goto L6;
        LLog.w(TAG, "toMap failed since env not ready.");
        return null;
    L6:
        flush();
        if (this.mNativeData != 0) goto L10;
        LLog.w(TAG, "toMap failed since mNativeData == 0.");
        return null;
    L10:
        Object r0 = nativeGetData(this.mNativeData);
        HashMap r1 = new HashMap();
        if ((r0 instanceof Map) == false) goto L13;
        r1.putAll((Map) r0);
    L13:
        return r1;
    }

    public long getNativePtr() {
        return this.mNativeData;
    }

    public long getNativeTemplateData() {
        return this.mNativeData;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public String processorName() {
        return this.mProcessorName;
    }

    private TemplateData(Map<String, Object> r3) {
        this.mIsConcurrent = new AtomicBoolean(false);
        this.readOnly = false;
        this.mEnableJSData = true;
        this.mConsumed = new AtomicBoolean(false);
        this.mUpdateActionsLock = new Object();
        this.mDataLock = new Object();
        this.mJsNativeDataLock = new Object();
        this.mNativeDataLock = new Object();
        this.mUpdateActions = new ArrayList();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L20;
        LynxEnv.inst();
        if (checkIfEnvPrepared() == true) goto L11;
        putSafely(r3);
        return;
    L11:
        j7a.a.a.getClass();
        ByteBuffer r4 = j7a.a.b(r3);
        if (r4 != null) goto L14;
        return;
    L14:
        if (r4.position() <= 0) goto L21;
        this.mNativeData = nativeParseData(r4, r4.position());
        this.mProcessorName = null;
        UpdateAction r0 = new UpdateAction();
        r0.a = ActionType.BYTE_BUFFER;
        r0.b = r4;
        addUpdateAction(r0);
        return;
    L21:
        return;
    }

    public static /* synthetic */ void access$000(long r0) {
        nativeReleaseData(r0);
    }

    public static /* synthetic */ void access$100(TemplateData r0) {
        r0.releaseNativeData();
    }

    public static /* synthetic */ void access$200(TemplateData r0) {
        r0.releaseJsData();
    }

    private void addUpdateAction(UpdateAction r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.mEnableJSData == true) goto L7;
        return;
    L7:
        Object r0 = this.mUpdateActionsLock;
        monitor-enter(r0);
        this.mUpdateActions.add(r3);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void addUpdateActions(List<UpdateAction> r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.mEnableJSData == true) goto L7;
        return;
    L7:
        Object r0 = this.mUpdateActionsLock;
        monitor-enter(r0);
        this.mUpdateActions.addAll(r3);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private List<UpdateAction> copyUpdateActions(boolean r8) {
        if (this.mEnableJSData == true) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Object r1 = this.mJsNativeDataLock;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (this.mJsNativeData == 0) goto L13;
        long r2 = nativeShallowCopy(this.mJsNativeData);     // Catch: Throwable -> L11
        UpdateAction r4 = new UpdateAction();     // Catch: Throwable -> L11
        r4.a = ActionType.NATIVE_DATA;     // Catch: Throwable -> L11
        r4.e = r2;     // Catch: Throwable -> L11
        r0.add(r4);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L11
        Object r3 = this.mUpdateActionsLock;
        monitor-enter(r3);
        r0.addAll(this.mUpdateActions);     // Catch: Throwable -> L21
        monitor-exit(r3);     // Catch: Throwable -> L21
        if (r8 == false) goto L20;
        consumeUpdateActions();
    L20:
        return r0;
    L21:
        th = move-exception;
        throw th;
    }

    public static TemplateData createForStaticPage(Map<String, Object> r1) {
        return new y1(r1);
    }

    public static long createNativeTemplateData(TemplateData r4) {
        r4.flush();
        return nativeCreateTemplateData(r4.getNativePtr(), r4.isReadOnly(), r4.processorName(), r4);
    }

    private static Object decodeByteBuffer(ByteBuffer r1) {
        if (r1 == null) goto L5;
        j7a.a.a.getClass();
        return j7a.a.a(r1);
    L5:
        return null;
    }

    public static TemplateData fromMap(Map<String, Object> r2) {
        TraceEvent.beginSection("TemplateData.FromMap");
        TemplateData r1 = new TemplateData(r2);
        TraceEvent.endSection("TemplateData.FromMap");
        return r1;
    }

    public static TemplateData fromNativeDataPtr(long r1) {
        return new TemplateData(r1);
    }

    public static TemplateData fromString(String r2) {
        TraceEvent.beginSection("TemplateData.FromString");
        TemplateData r1 = new TemplateData(r2);
        TraceEvent.endSection("TemplateData.FromString");
        return r1;
    }

    public static boolean isForStaticPage(TemplateData r0) {
        return r0 instanceof y1;
    }

    public static List<Object> jsonArrayToList(JSONArray r5) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r5.length()) goto L16;
        Object r2 = r5.get(r1);     // Catch: Throwable -> L13
        if ((r2 instanceof JSONObject) == false) goto L9;
        r2 = jsonToMap((JSONObject) r2);     // Catch: Throwable -> L13
    L11:
        r0.add(r2);     // Catch: Throwable -> L13
    L15:
        r1 = r1 + 1;
        goto L4
    L9:
        if ((r2 instanceof JSONArray) == false) goto L11;
        r2 = jsonArrayToList((JSONArray) r2);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        LLog.e(TAG, "Failed to parse JSONArray at index " + r1 + ": " + th.getMessage());
        goto L15
    L16:
        return r0;
    }

    public static Map<String, Object> jsonToMap(JSONObject r5) {
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r5.keys();     // Catch: Throwable -> L14
    L4:
        if (r1.hasNext() == false) goto L16;
        String r2 = r1.next();     // Catch: Throwable -> L14
        Object r3 = r5.get(r2);     // Catch: Throwable -> L14
        if ((r3 instanceof JSONObject) == false) goto L10;
        r3 = jsonToMap((JSONObject) r3);     // Catch: Throwable -> L14
    L12:
        r0.put(r2, r3);     // Catch: Throwable -> L14
        goto L4
    L10:
        if ((r3 instanceof JSONArray) == false) goto L12;
        r3 = jsonArrayToList((JSONArray) r3);     // Catch: Throwable -> L14
    L16:
        return r0;
    L14:
        th = move-exception;
        LLog.e(TAG, "Failed to parse JSONObject: " + th.getMessage());
        goto L16
    }

    private void putSafely(Map<String, Object> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L9;
        ensureInternalMap();
        this.mData.putAll(r2);
        return;
    }

    public static void releaseNativeTemplateData(long r0) {
        nativeReleaseTemplateData(r0);
    }

    public void bindContext(LynxContext r2) {
        this.weakContext = new WeakReference(r2);
    }

    public void markState(String r1) {
        this.mProcessorName = r1;
    }

    public void remove(String r6) {
        if (checkIfEnvPrepared() == true) goto L7;
        LLog.e(TAG, "remove failed since env not ready!");
        return;
    L7:
        if (this.readOnly == false) goto L11;
        LLog.w(TAG, "can not remove readOnly TemplateData");
        return;
    L11:
        if (this.mConsumed.get() == false) goto L13;
        LLog.w(TAG, "put data to consumed TemplateData,key:" + r6);
    L13:
        UpdateAction r0 = new UpdateAction();
        r0.a = ActionType.REMOVE_DATA;
        r0.d = r6;
        addUpdateAction(r0);
        if (this.mNativeData == 0) goto L17;
        nativeRemoveData(this.mNativeData, r6);
        return;
    }

    public void removeKey(String r2) {
        put(r2, null);
    }

    public void setEnableJSData(boolean r1) {
        this.mEnableJSData = r1;
    }

    public void updateData(Map<String, Object> r4) {
        if (this.readOnly == false) goto L7;
        LLog.e(TAG, "can not update readOnly TemplateData");
        return;
    L7:
        if (this.mConsumed.get() == false) goto L9;
        LLog.w(TAG, "updateData to consumed TemplateData, diff:" + r4.keySet());
    L9:
        putSafely(r4);
    }

    public void updateWithTemplateData(TemplateData r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (isForStaticPage(r6) == false) goto L8;
        LLog.e(TAG, "updateWithTemplateData is not supported for static-page data");
        return;
    L8:
        if (this != r6) goto L12;
        LLog.w(TAG, "can not update TemplateData with self");
        return;
    L12:
        if (this.readOnly == false) goto L16;
        LLog.w(TAG, "can not update readOnly TemplateData");
        return;
    L16:
        if (checkIfEnvPrepared() == true) goto L20;
        LLog.w(TAG, "updateWithTemplateData failed since env not ready.");
        return;
    L20:
        if (this.mConsumed.get() == false) goto L22;
        LLog.w(TAG, "updateWithTemplateData to consumed TemplateData, this:" + this + ",diff:" + r6);
    L22:
        flush();
        r6.flush();
        addUpdateActions(r6.copyUpdateActions(true));
        if (r6.getNativePtr() == 0) goto L26;
        nativeMergeTemplateData(getNativePtr(), r6.getNativePtr());
        return;
    }

    private TemplateData(String r3) {
        this.mIsConcurrent = new AtomicBoolean(false);
        this.readOnly = false;
        this.mEnableJSData = true;
        this.mConsumed = new AtomicBoolean(false);
        this.mUpdateActionsLock = new Object();
        this.mDataLock = new Object();
        this.mJsNativeDataLock = new Object();
        this.mNativeDataLock = new Object();
        this.mUpdateActions = new ArrayList();
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        LynxEnv.inst();
        if (checkIfEnvPrepared() == false) goto L14;
        this.mNativeData = nativeParseStringData(r3);
        this.mProcessorName = null;
        UpdateAction r0 = new UpdateAction();
        r0.a = ActionType.STRING_DATA;
        r0.c = r3;
        addUpdateAction(r0);
        return;
    L14:
        putSafely(jsonToMap(new JSONObject(r3)));     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    private TemplateData(long r4) {
        this.mIsConcurrent = new AtomicBoolean(false);
        this.readOnly = false;
        this.mEnableJSData = true;
        this.mConsumed = new AtomicBoolean(false);
        this.mUpdateActionsLock = new Object();
        this.mDataLock = new Object();
        this.mJsNativeDataLock = new Object();
        this.mNativeDataLock = new Object();
        this.mUpdateActions = new ArrayList();
        LynxEnv.inst();
        this.mNativeData = r4;
        this.readOnly = true;
        this.mProcessorName = null;
        if (this.mNativeData == 0) goto L6;
        long r5 = nativeShallowCopy(this.mNativeData);
        UpdateAction r0 = new UpdateAction();
        r0.a = ActionType.NATIVE_DATA;
        r0.e = r5;
        addUpdateAction(r0);
        return;
    }

    private void putSafely(String r2, Object r3) {
        ensureInternalMap();
        this.mData.put(r2, r3);
    }

    public void put(String r4, Object r5) {
        if (this.readOnly == false) goto L7;
        LLog.w(TAG, "can not update readOnly TemplateData");
        return;
    L7:
        if (this.mConsumed.get() == false) goto L9;
        LLog.w(TAG, "put data to consumed TemplateData,key:" + r4);
    L9:
        putSafely(r4, r5);
    }

    public void updateData(String r1, Object r2) {
        put(r1, r2);
    }
}
