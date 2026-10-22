package com.obric.memorydata.memory.tracker;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.constants.DevTrackerEventId;
import com.obric.memorydata.utils.ah;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001LB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u0007J\u0014\u00103\u001a\u000204*\u00020,2\b\u00105\u001a\u0004\u0018\u000106J\n\u00107\u001a\u000204*\u00020,J\n\u00108\u001a\u000204*\u00020,J\n\u00109\u001a\u000204*\u00020,Jq\u0010:\u001a\u0002042\b\b\u0002\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020=2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020C2\u0006\u0010F\u001a\u00020\u00072\b\u0010G\u001a\u0004\u0018\u00010=2\b\b\u0002\u0010H\u001a\u00020\u0007¢\u0006\u0002\u0010IJ\u0016\u0010J\u001a\u0002042\u0006\u0010<\u001a\u00020=2\u0006\u0010K\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryExtractTracker;", "", "<init>", "()V", "TAG", "", "INVOKE_SOURCE_ASSISTANT_AUTO_MEMORY", "", "INVOKE_SOURCE_ASSISTANT_MEMORY", "INVOKE_SOURCE_SMART_MEMORY", "INVOKE_SOURCE_SCREEN_MEMORY", "INVOKE_SOURCE_COMPONENT_MEMORY", "INVOKE_SOURCE_GESTURE_MEMORY", "INVOKE_SOURCE_KEY_MEMORY", "INVOKE_SOURCE_SHARE_MEMORY", "UNKNOWN_APP_NAME", "CODE_RET_SUCCESS", "CODE_NO_ERROR_CODE", "CODE_NETWORK_UNAVAILABLE", "CODE_INPUT_ERROR", "CODE_MODEL_BRIDGE_ERROR", "CODE_MEMORY_INVALID", "CODE_MODEL_RESULT_INVALID", "CODE_IGNORE_EXPIRED", "CODE_SERVICE_ERROR", "CODE_TIME_OUT", "MSG_NETWORK_UNAVAILABLE", "KEY_IS_SUCCESS", "KEY_HAS_SCREENSHOT", "KEY_APP_NAME", "KEY_MEMORY_TYPE", "KEY_TOTAL_TIME", "KEY_EXTRACT_MEMORY_TIME", "KEY_CLOUD_TIME", "KEY_INVOKE_SOURCE", "KEY_QUERY", "KEY_PACKAGE_NAME", "KEY_USE_CLOUD_MODEL", "KEY_ERROR_CODE", "KEY_ERROR_MSG", "KEY_SERVICE_RESULT_CODE", "KEY_SERVICE_RESULT_MSG", "eventPool", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/memory/tracker/MemoryExtractTracker$TrackingEvent;", "ID_ASSISTANT_AUTO_MEMORY", "ID_ASSISTANT_MEMORY", "idGenerator", "Ljava/util/concurrent/atomic/AtomicInteger;", "obtainTrackingEvent", "originalType", "extractedErrorCode", "", "memoryJson", "Lorg/json/JSONObject;", "reset", "updateBeginExtract", "updateEndExtract", "trackerMemoryBuild", OaidModel.KEY_ID, "isSuccess", "", "invokeSource", "appName", "hasScreenshot", "memoryType", "sumTime", "", "extractMemoryTime", "cloudTime", "errorCode", "useCloudModel", "serviceResultCode", "(IZILjava/lang/String;ZLjava/lang/String;JJJILjava/lang/Boolean;I)V", "trackAppLinkJump", ObricMemoryConstants.KEY_PACKAGE_NAME, "TrackingEvent", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10533a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, a> f10534b = null;
    private static final AtomicInteger c = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b<\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\t\u0010?\u001a\u00020\u0006HÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\t\u0010A\u001a\u00020\rHÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\u0095\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0006HÆ\u0001J\u0013\u0010H\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010JHÖ\u0003J\t\u0010K\u001a\u00020\u0003HÖ\u0001J\t\u0010L\u001a\u00020\rHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0017\"\u0004\b6\u0010\u0019R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001e¨\u0006M"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryExtractTracker$TrackingEvent;", "Lcom/obric/memorydata/memory/strategy/MemoryTrackingEvent;", OaidModel.KEY_ID, "", "invokeSource", "isSuccess", "", "finishInputTs", "", "beginExtractTs", "endExtractTs", "hasScreenshot", "appName", "", "memoryType", "cloudTime", "dataIsValid", "errorCode", "serviceResultCode", "useCloudModel", "<init>", "(IIZJJJZLjava/lang/String;Ljava/lang/String;JZIIZ)V", "getId", "()I", "setId", "(I)V", "getInvokeSource", "setInvokeSource", "()Z", "setSuccess", "(Z)V", "getFinishInputTs", "()J", "setFinishInputTs", "(J)V", "getBeginExtractTs", "setBeginExtractTs", "getEndExtractTs", "setEndExtractTs", "getHasScreenshot", "setHasScreenshot", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getMemoryType", "setMemoryType", "getCloudTime", "setCloudTime", "getDataIsValid", "setDataIsValid", "getErrorCode", "setErrorCode", "getServiceResultCode", "setServiceResultCode", "getUseCloudModel", "setUseCloudModel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.memory.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f10536b;
        private boolean c;
        private long d;
        private long e;
        private long f;
        private boolean g;
        private String h;
        private String i;
        private long j;
        private boolean k;
        private int l;
        private int m;
        private boolean n;

        public a(int r6, int r7, boolean r8, long r9, long r11, long r13, boolean r15, String r16, String r17, long r18, boolean r20, int r21, int r22, boolean r23) {
            Intrinsics.checkNotNullParameter(r16, "appName");
            Intrinsics.checkNotNullParameter(r17, "memoryType");
            this.f10535a = r6;
            this.f10536b = r7;
            this.c = r8;
            this.d = r9;
            this.e = r11;
            this.f = r13;
            this.g = r15;
            this.h = r16;
            this.i = r17;
            this.j = r18;
            this.k = r20;
            this.l = r21;
            this.m = r22;
            this.n = r23;
        }

        public /* synthetic */ a(int r19, int r20, boolean r21, long r22, long r24, long r26, boolean r28, String r29, String r30, long r31, boolean r33, int r34, int r35, boolean r36, int r37, DefaultConstructorMarker r38) {
            if ((r37 & 2) == 0) goto L5;
            int r1 = 0;
        L7:
            if ((r37 & 4) == 0) goto L9;
            boolean r3 = false;
        L10:
            long r5 = 0;
            if ((r37 & 8) == 0) goto L13;
            long r7 = 0;
        L15:
            if ((r37 & 16) == 0) goto L17;
            long r9 = 0;
        L19:
            if ((r37 & 32) == 0) goto L21;
            long r11 = 0;
        L23:
            if ((r37 & 64) == 0) goto L25;
            boolean r4 = false;
        L26:
            String r14 = "";
            if ((r37 & 128) == 0) goto L29;
            String r13 = "";
        L31:
            if ((r37 & 256) != 0) goto L35;
            r14 = r30;
        L35:
            if ((r37 & 512) != 0) goto L38;
            r5 = r31;
        L38:
            boolean r16 = true;
            if ((r37 & 1024) == 0) goto L41;
            boolean r15 = true;
        L43:
            if ((r37 & 2048) == 0) goto L45;
            int r2 = 0;
        L46:
            int r17 = r2;
            if ((r37 & 4096) == 0) goto L49;
            int r6 = 0;
        L51:
            if ((r37 & 8192) != 0) goto L54;
            r16 = r36;
        L54:
            this(r19, r1, r3, r7, r9, r11, r4, r13, r14, r5, r15, r17, r6, r16);
            return;
        L49:
            r6 = r35;
            goto L51
        L45:
            r2 = r34;
            goto L46
        L41:
            r15 = r33;
            goto L43
        L29:
            r13 = r29;
            goto L31
        L25:
            r4 = r28;
            goto L26
        L21:
            r11 = r26;
            goto L23
        L17:
            r9 = r24;
            goto L19
        L13:
            r7 = r22;
            goto L15
        L9:
            r3 = r21;
            goto L10
        L5:
            r1 = r20;
            goto L7
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            if (this.f10535a == r10.f10535a) goto L12;
            return false;
        L12:
            if (this.f10536b == r10.f10536b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L27;
            return false;
        L27:
            if (this.g == r10.g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
            return false;
        L36:
            if (this.j == r10.j) goto L39;
            return false;
        L39:
            if (this.k == r10.k) goto L42;
            return false;
        L42:
            if (this.l == r10.l) goto L45;
            return false;
        L45:
            if (this.m == r10.m) goto L48;
            return false;
        L48:
            if (this.n == r10.n) goto L50;
            return false;
        L50:
            return true;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((Integer.hashCode(this.f10535a) * 31) + Integer.hashCode(this.f10536b)) * 31) + Boolean.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + Long.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31) + Integer.hashCode(this.l)) * 31) + Integer.hashCode(this.m)) * 31) + Boolean.hashCode(this.n);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("TrackingEvent(id=").append(this.f10535a).append(", invokeSource=").append(this.f10536b).append(", isSuccess=").append(this.c).append(", finishInputTs=").append(this.d).append(", beginExtractTs=").append(this.e).append(", endExtractTs=").append(this.f).append(", hasScreenshot=").append(this.g).append(", appName=").append(this.h).append(", memoryType=").append(this.i).append(", cloudTime=").append(this.j).append(", dataIsValid=").append(this.k).append(", errorCode=");
            r0.append(this.l).append(", serviceResultCode=").append(this.m).append(", useCloudModel=").append(this.n).append(')');
            return r0.toString();
        }
    }

    static {
        f10533a = new c();
        f10534b = new ConcurrentHashMap();
        c = new AtomicInteger(1);
    }

    private c() {
    }

    private static final a a(int r22, long r23, Integer r25) {
        Intrinsics.checkNotNullParameter(r25, "key");
        return new a(r25.intValue(), r22, false, r23, r23, 0, false, null, null, 0, false, 0, 0, false, 16356, null);
    }

    private static final a a(Function1 r2, Object r3) {
        return (a) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), a.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ a lambda$JmQ4xiMzH9WhEnmo2PUodlvoloY(int r0, long r1, Integer r3) {
        return a(r0, r1, r3);
    }

    public static /* synthetic */ a lambda$ueMwiPlMSCNrmlWwZrQUPYHPTqw(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a a(final int r30) {
        final long r6 = System.currentTimeMillis();
        String r4 = "com.obric.memorydata.plugin";
        if (r30 != 0) goto L5;
        ConcurrentMap r5 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(f10534b, ConcurrentMap.class, "com.obric.memorydata.plugin");
        Integer r15 = Integer.valueOf(r30);
        Object r0 = r5.get(r15);
        if (r0 != null) goto L21;
        String r28 = "com.obric.memorydata.plugin";
        Object[] r16 = 0 == true ? 1 : 0;
        a r13 = new a(0, r30, false, r6, r6, 0, false, null, null, 0, false, r16, 0, false, 16356, null);
        r0 = r5.putIfAbsent(r15, r13);
        if (r0 != null) goto L22;
        r0 = r13;
    L22:
        Intrinsics.checkNotNull(r0);
        Object r1 = ZeusTransformUtils.preCheckCast(r0, a.class, r28);
    L23:
        return (a) r1;
    L21:
        r28 = "com.obric.memorydata.plugin";
        goto L22
    L5:
        if (r30 == 1) goto L9;
        ConcurrentHashMap<Integer, a> r2 = f10534b;
        Integer r3 = Integer.valueOf(c.incrementAndGet());
        final Function1 r7 = new $$Lambda$c$JmQ4xiMzH9WhEnmo2PUodlvoloY(r30, r6);
        Object r8 = r2.computeIfAbsent(r3, new $$Lambda$c$ueMwiPlMSCNrmlWwZrQUPYHPTqw(r7));
        Intrinsics.checkNotNull(r8);
        Class<a> r9 = a.class;
    L7:
        r1 = ZeusTransformUtils.preCheckCast(r8, r9, r4);
        goto L23
    L9:
        ConcurrentMap r10 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(f10534b, ConcurrentMap.class, "com.obric.memorydata.plugin");
        Integer r17 = Integer.valueOf(r30);
        r8 = r10.get(r17);
        if (r8 != null) goto L14;
        String r24 = "com.obric.memorydata.plugin";
        Object[] r18 = 0 == true ? 1 : 0;
        a r14 = new a(1, r30, false, r6, r6, 0, false, null, null, 0, false, r18, 0, false, 16356, null);
        r8 = r10.putIfAbsent(r17, r14);
        if (r8 != null) goto L15;
        r8 = r14;
    L15:
        Intrinsics.checkNotNull(r8);
        r9 = a.class;
        r4 = r24;
        goto L7
    L14:
        r24 = "com.obric.memorydata.plugin";
        goto L15
    }

    public final void a(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        JSONObject r0 = new JSONObject();
        r0.put("isSuccess", r3);
        r0.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r4);
        ah.a(DevTrackerEventId.MEMORY_SOURCE_LINK_JUMP, r0);
    }
}
