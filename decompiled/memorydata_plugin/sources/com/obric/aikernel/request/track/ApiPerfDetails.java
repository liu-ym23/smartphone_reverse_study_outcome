package com.obric.aikernel.request.track;

import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0005./012BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003JY\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00063"}, d2 = {"Lcom/obric/aikernel/request/track/ApiPerfDetails;", "", "biz", "", "caller", "traceId", "traceInfo", "Lcom/obric/aikernel/request/track/ApiPerfDetails$TraceInfo;", "vmInfo", "Lcom/obric/aikernel/request/track/ApiPerfDetails$VmInfo;", "vmStat", "Lcom/obric/aikernel/request/track/ApiPerfDetails$VmStat;", "traceStat", "Lcom/obric/aikernel/request/track/ApiPerfDetails$TraceStat;", "commonTrace", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/aikernel/request/track/ApiPerfDetails$TraceInfo;Lcom/obric/aikernel/request/track/ApiPerfDetails$VmInfo;Lcom/obric/aikernel/request/track/ApiPerfDetails$VmStat;Lcom/obric/aikernel/request/track/ApiPerfDetails$TraceStat;Lorg/json/JSONObject;)V", "getBiz", "()Ljava/lang/String;", "getCaller", "getCommonTrace", "()Lorg/json/JSONObject;", "getTraceId", "getTraceInfo", "()Lcom/obric/aikernel/request/track/ApiPerfDetails$TraceInfo;", "getTraceStat", "()Lcom/obric/aikernel/request/track/ApiPerfDetails$TraceStat;", "getVmInfo", "()Lcom/obric/aikernel/request/track/ApiPerfDetails$VmInfo;", "getVmStat", "()Lcom/obric/aikernel/request/track/ApiPerfDetails$VmStat;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "TraceInfo", "TraceStat", "VmInfo", "VmStat", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ApiPerfDetails {
    public static final String COMMON_TRACE_PREFIX = "track_";
    public static final a Companion = null;
    public static final String FLAG_LOAD_MODEL = "flag_load_model";
    public static final String FLAG_NEW_SERVICE = "flag_new_service";
    public static final String FLAG_RUN_MODEL = "flag_run_model";
    public static final String InterceptExceptionType = "quota_exceed_type";
    public static final String KEY_CONTEXT = "@ctx";
    public static final String KEY_KERNEL_SESSION = "_k_session_id";
    public static final String KEY_VM_ARGS = "@vm_args";
    public static final String KEY_VM_CONTEXT = "@vm_ctx";
    public static final String exceptionHash = "error_hash";
    public static final String exceptionInfo = "error_info";
    public static final String exceptionType = "exception_type";
    public static final String onCallbackClient = "occ";
    public static final String onEndApi = "oea";
    public static final String onEndApiElapse = "oea_e";
    public static final String onEndVmRun = "oevr";
    public static final String onLoadServiceEnd = "tp_load_service_finish";
    public static final String onLoadServiceStart = "tp_load_service_start";
    public static final String onReceiveBinderRequest = "orbr";
    public static final String onReceiveBinderRequestElapse = "orbre";
    public static final String onStartApiCoroutine = "osac";
    public static final String onStartVmRun = "osvr";
    public static final String onVmEnd = "tp_package_finish";
    public static final String onVmPyEnd = "tp_python_finish";
    public static final String onVmPyStart = "tp_python_start";
    public static final String onVmRun = "tp_package_start";
    public static final String onVmSessionBefore = "tp_session_before";
    public static final String onVmSessionDispatch = "tp_session_dispatch";
    public static final String onVmSessionEnd = "tp_session_after";
    public static final String onVmSessionStart = "tp_session_start";
    private final String biz;
    private final String caller;
    private final JSONObject commonTrace;
    private final String traceId;
    private final TraceInfo traceInfo;
    private final b traceStat;
    private final VmInfo vmInfo;
    private final c vmStat;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003Jc\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006("}, d2 = {"Lcom/obric/aikernel/request/track/ApiPerfDetails$TraceInfo;", "", "clientRequestElapse", "", "binderRequestTime", "binderRequestTimeElapse", "startInferCoroutineTime", "vmStartTime", "vmEndTime", "startCallbackClientTime", "inferEndTime", "inferEndElapse", "(JJJJJJJJJ)V", "getBinderRequestTime", "()J", "getBinderRequestTimeElapse", "getClientRequestElapse", "getInferEndElapse", "getInferEndTime", "getStartCallbackClientTime", "getStartInferCoroutineTime", "getVmEndTime", "getVmStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class TraceInfo {
        private final long binderRequestTime;
        private final long binderRequestTimeElapse;
        private final long clientRequestElapse;
        private final long inferEndElapse;
        private final long inferEndTime;
        private final long startCallbackClientTime;
        private final long startInferCoroutineTime;
        private final long vmEndTime;
        private final long vmStartTime;

        public TraceInfo(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20) {
            this.clientRequestElapse = r4;
            this.binderRequestTime = r6;
            this.binderRequestTimeElapse = r8;
            this.startInferCoroutineTime = r10;
            this.vmStartTime = r12;
            this.vmEndTime = r14;
            this.startCallbackClientTime = r16;
            this.inferEndTime = r18;
            this.inferEndElapse = r20;
        }

        public static /* synthetic */ TraceInfo copy$default(TraceInfo r16, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, int r35, Object r36) {
            if ((r35 & 1) == 0) goto L5;
            long r2 = r16.clientRequestElapse;
        L7:
            if ((r35 & 2) == 0) goto L9;
            long r4 = r16.binderRequestTime;
        L11:
            if ((r35 & 4) == 0) goto L13;
            long r6 = r16.binderRequestTimeElapse;
        L15:
            if ((r35 & 8) == 0) goto L17;
            long r8 = r16.startInferCoroutineTime;
        L19:
            if ((r35 & 16) == 0) goto L21;
            long r10 = r16.vmStartTime;
        L23:
            if ((r35 & 32) == 0) goto L25;
            long r12 = r16.vmEndTime;
        L27:
            if ((r35 & 64) == 0) goto L29;
            long r14 = r16.startCallbackClientTime;
        L30:
            long r210 = r14;
            if ((r35 & 128) == 0) goto L33;
            long r15 = r16.inferEndTime;
        L34:
            long r32 = r15;
            if ((r35 & 256) == 0) goto L37;
            long r18 = r16.inferEndElapse;
        L39:
            return r16.copy(r2, r4, r6, r8, r10, r12, r210, r32, r18);
        L37:
            r18 = r33;
            goto L39
        L33:
            r15 = r31;
            goto L34
        L29:
            r14 = r29;
            goto L30
        L25:
            r12 = r27;
            goto L27
        L21:
            r10 = r25;
            goto L23
        L17:
            r8 = r23;
            goto L19
        L13:
            r6 = r21;
            goto L15
        L9:
            r4 = r19;
            goto L11
        L5:
            r2 = r17;
            goto L7
        }

        public final long component1() {
            return this.clientRequestElapse;
        }

        public final long component2() {
            return this.binderRequestTime;
        }

        public final long component3() {
            return this.binderRequestTimeElapse;
        }

        public final long component4() {
            return this.startInferCoroutineTime;
        }

        public final long component5() {
            return this.vmStartTime;
        }

        public final long component6() {
            return this.vmEndTime;
        }

        public final long component7() {
            return this.startCallbackClientTime;
        }

        public final long component8() {
            return this.inferEndTime;
        }

        public final long component9() {
            return this.inferEndElapse;
        }

        public final TraceInfo copy(long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37) {
            return new TraceInfo(r21, r23, r25, r27, r29, r31, r33, r35, r37);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, TraceInfo.class) == true) goto L8;
            return false;
        L8:
            TraceInfo r10 = (TraceInfo) ZeusTransformUtils.preCheckCast(r9, TraceInfo.class, "com.obric.memorydata.plugin");
            if (this.clientRequestElapse == r10.clientRequestElapse) goto L12;
            return false;
        L12:
            if (this.binderRequestTime == r10.binderRequestTime) goto L15;
            return false;
        L15:
            if (this.binderRequestTimeElapse == r10.binderRequestTimeElapse) goto L18;
            return false;
        L18:
            if (this.startInferCoroutineTime == r10.startInferCoroutineTime) goto L21;
            return false;
        L21:
            if (this.vmStartTime == r10.vmStartTime) goto L24;
            return false;
        L24:
            if (this.vmEndTime == r10.vmEndTime) goto L27;
            return false;
        L27:
            if (this.startCallbackClientTime == r10.startCallbackClientTime) goto L30;
            return false;
        L30:
            if (this.inferEndTime == r10.inferEndTime) goto L33;
            return false;
        L33:
            if (this.inferEndElapse == r10.inferEndElapse) goto L35;
            return false;
        L35:
            return true;
        }

        public final long getBinderRequestTime() {
            return this.binderRequestTime;
        }

        public final long getBinderRequestTimeElapse() {
            return this.binderRequestTimeElapse;
        }

        public final long getClientRequestElapse() {
            return this.clientRequestElapse;
        }

        public final long getInferEndElapse() {
            return this.inferEndElapse;
        }

        public final long getInferEndTime() {
            return this.inferEndTime;
        }

        public final long getStartCallbackClientTime() {
            return this.startCallbackClientTime;
        }

        public final long getStartInferCoroutineTime() {
            return this.startInferCoroutineTime;
        }

        public final long getVmEndTime() {
            return this.vmEndTime;
        }

        public final long getVmStartTime() {
            return this.vmStartTime;
        }

        public int hashCode() {
            return (((((((((((((((Long.hashCode(this.clientRequestElapse) * 31) + Long.hashCode(this.binderRequestTime)) * 31) + Long.hashCode(this.binderRequestTimeElapse)) * 31) + Long.hashCode(this.startInferCoroutineTime)) * 31) + Long.hashCode(this.vmStartTime)) * 31) + Long.hashCode(this.vmEndTime)) * 31) + Long.hashCode(this.startCallbackClientTime)) * 31) + Long.hashCode(this.inferEndTime)) * 31) + Long.hashCode(this.inferEndElapse);
        }

        public String toString() {
            return "TraceInfo(clientRequestElapse=" + this.clientRequestElapse + ", binderRequestTime=" + this.binderRequestTime + ", binderRequestTimeElapse=" + this.binderRequestTimeElapse + ", startInferCoroutineTime=" + this.startInferCoroutineTime + ", vmStartTime=" + this.vmStartTime + ", vmEndTime=" + this.vmEndTime + ", startCallbackClientTime=" + this.startCallbackClientTime + ", inferEndTime=" + this.inferEndTime + ", inferEndElapse=" + this.inferEndElapse + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006+"}, d2 = {"Lcom/obric/aikernel/request/track/ApiPerfDetails$VmInfo;", "", "vmRunStartTime", "", "vmLoadServiceStartTime", "vmLoadServiceEndTime", "vmPyStartTime", "vmSessionDispatchTime", "vmSessionPrepareTime", "vmSessionStartTime", "vmSessionEndTime", "vmPyEndTime", "vmRunEndTime", "(JJJJJJJJJJ)V", "getVmLoadServiceEndTime", "()J", "getVmLoadServiceStartTime", "getVmPyEndTime", "getVmPyStartTime", "getVmRunEndTime", "getVmRunStartTime", "getVmSessionDispatchTime", "getVmSessionEndTime", "getVmSessionPrepareTime", "getVmSessionStartTime", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class VmInfo {
        private final long vmLoadServiceEndTime;
        private final long vmLoadServiceStartTime;
        private final long vmPyEndTime;
        private final long vmPyStartTime;
        private final long vmRunEndTime;
        private final long vmRunStartTime;
        private final long vmSessionDispatchTime;
        private final long vmSessionEndTime;
        private final long vmSessionPrepareTime;
        private final long vmSessionStartTime;

        public VmInfo(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22) {
            this.vmRunStartTime = r4;
            this.vmLoadServiceStartTime = r6;
            this.vmLoadServiceEndTime = r8;
            this.vmPyStartTime = r10;
            this.vmSessionDispatchTime = r12;
            this.vmSessionPrepareTime = r14;
            this.vmSessionStartTime = r16;
            this.vmSessionEndTime = r18;
            this.vmPyEndTime = r20;
            this.vmRunEndTime = r22;
        }

        public static /* synthetic */ VmInfo copy$default(VmInfo r16, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, int r37, Object r38) {
            if ((r37 & 1) == 0) goto L5;
            long r2 = r16.vmRunStartTime;
        L7:
            if ((r37 & 2) == 0) goto L9;
            long r4 = r16.vmLoadServiceStartTime;
        L11:
            if ((r37 & 4) == 0) goto L13;
            long r6 = r16.vmLoadServiceEndTime;
        L15:
            if ((r37 & 8) == 0) goto L17;
            long r8 = r16.vmPyStartTime;
        L19:
            if ((r37 & 16) == 0) goto L21;
            long r10 = r16.vmSessionDispatchTime;
        L23:
            if ((r37 & 32) == 0) goto L25;
            long r12 = r16.vmSessionPrepareTime;
        L27:
            if ((r37 & 64) == 0) goto L29;
            long r14 = r16.vmSessionStartTime;
        L30:
            long r210 = r14;
            if ((r37 & 128) == 0) goto L33;
            long r15 = r16.vmSessionEndTime;
        L34:
            long r32 = r15;
            if ((r37 & 256) == 0) goto L37;
            long r18 = r16.vmPyEndTime;
        L38:
            long r34 = r18;
            if ((r37 & 512) == 0) goto L41;
            long r110 = r16.vmRunEndTime;
        L43:
            return r16.copy(r2, r4, r6, r8, r10, r12, r210, r32, r34, r110);
        L41:
            r110 = r35;
            goto L43
        L37:
            r18 = r33;
            goto L38
        L33:
            r15 = r31;
            goto L34
        L29:
            r14 = r29;
            goto L30
        L25:
            r12 = r27;
            goto L27
        L21:
            r10 = r25;
            goto L23
        L17:
            r8 = r23;
            goto L19
        L13:
            r6 = r21;
            goto L15
        L9:
            r4 = r19;
            goto L11
        L5:
            r2 = r17;
            goto L7
        }

        public final long component1() {
            return this.vmRunStartTime;
        }

        public final long component10() {
            return this.vmRunEndTime;
        }

        public final long component2() {
            return this.vmLoadServiceStartTime;
        }

        public final long component3() {
            return this.vmLoadServiceEndTime;
        }

        public final long component4() {
            return this.vmPyStartTime;
        }

        public final long component5() {
            return this.vmSessionDispatchTime;
        }

        public final long component6() {
            return this.vmSessionPrepareTime;
        }

        public final long component7() {
            return this.vmSessionStartTime;
        }

        public final long component8() {
            return this.vmSessionEndTime;
        }

        public final long component9() {
            return this.vmPyEndTime;
        }

        public final VmInfo copy(long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41) {
            return new VmInfo(r23, r25, r27, r29, r31, r33, r35, r37, r39, r41);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, VmInfo.class) == true) goto L8;
            return false;
        L8:
            VmInfo r10 = (VmInfo) ZeusTransformUtils.preCheckCast(r9, VmInfo.class, "com.obric.memorydata.plugin");
            if (this.vmRunStartTime == r10.vmRunStartTime) goto L12;
            return false;
        L12:
            if (this.vmLoadServiceStartTime == r10.vmLoadServiceStartTime) goto L15;
            return false;
        L15:
            if (this.vmLoadServiceEndTime == r10.vmLoadServiceEndTime) goto L18;
            return false;
        L18:
            if (this.vmPyStartTime == r10.vmPyStartTime) goto L21;
            return false;
        L21:
            if (this.vmSessionDispatchTime == r10.vmSessionDispatchTime) goto L24;
            return false;
        L24:
            if (this.vmSessionPrepareTime == r10.vmSessionPrepareTime) goto L27;
            return false;
        L27:
            if (this.vmSessionStartTime == r10.vmSessionStartTime) goto L30;
            return false;
        L30:
            if (this.vmSessionEndTime == r10.vmSessionEndTime) goto L33;
            return false;
        L33:
            if (this.vmPyEndTime == r10.vmPyEndTime) goto L36;
            return false;
        L36:
            if (this.vmRunEndTime == r10.vmRunEndTime) goto L38;
            return false;
        L38:
            return true;
        }

        public final long getVmLoadServiceEndTime() {
            return this.vmLoadServiceEndTime;
        }

        public final long getVmLoadServiceStartTime() {
            return this.vmLoadServiceStartTime;
        }

        public final long getVmPyEndTime() {
            return this.vmPyEndTime;
        }

        public final long getVmPyStartTime() {
            return this.vmPyStartTime;
        }

        public final long getVmRunEndTime() {
            return this.vmRunEndTime;
        }

        public final long getVmRunStartTime() {
            return this.vmRunStartTime;
        }

        public final long getVmSessionDispatchTime() {
            return this.vmSessionDispatchTime;
        }

        public final long getVmSessionEndTime() {
            return this.vmSessionEndTime;
        }

        public final long getVmSessionPrepareTime() {
            return this.vmSessionPrepareTime;
        }

        public final long getVmSessionStartTime() {
            return this.vmSessionStartTime;
        }

        public int hashCode() {
            return (((((((((((((((((Long.hashCode(this.vmRunStartTime) * 31) + Long.hashCode(this.vmLoadServiceStartTime)) * 31) + Long.hashCode(this.vmLoadServiceEndTime)) * 31) + Long.hashCode(this.vmPyStartTime)) * 31) + Long.hashCode(this.vmSessionDispatchTime)) * 31) + Long.hashCode(this.vmSessionPrepareTime)) * 31) + Long.hashCode(this.vmSessionStartTime)) * 31) + Long.hashCode(this.vmSessionEndTime)) * 31) + Long.hashCode(this.vmPyEndTime)) * 31) + Long.hashCode(this.vmRunEndTime);
        }

        public String toString() {
            return "VmInfo(vmRunStartTime=" + this.vmRunStartTime + ", vmLoadServiceStartTime=" + this.vmLoadServiceStartTime + ", vmLoadServiceEndTime=" + this.vmLoadServiceEndTime + ", vmPyStartTime=" + this.vmPyStartTime + ", vmSessionDispatchTime=" + this.vmSessionDispatchTime + ", vmSessionPrepareTime=" + this.vmSessionPrepareTime + ", vmSessionStartTime=" + this.vmSessionStartTime + ", vmSessionEndTime=" + this.vmSessionEndTime + ", vmPyEndTime=" + this.vmPyEndTime + ", vmRunEndTime=" + this.vmRunEndTime + ')';
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u001d\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(¢\u0006\u0002\u0010+J\n\u0010,\u001a\u00020-*\u00020-J\u0012\u0010.\u001a\u00020(*\u00020-2\u0006\u0010/\u001a\u00020\u0004J\f\u00100\u001a\u0004\u0018\u00010-*\u00020-J\u0012\u00101\u001a\u00020(*\u00020-2\u0006\u0010/\u001a\u00020\u0004J\n\u00102\u001a\u000203*\u00020-J\u0016\u00104\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-05*\u00020-J\u001c\u00106\u001a\u000203*\u00020-2\u0006\u0010/\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u000208R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/aikernel/request/track/ApiPerfDetails$Companion;", "", "()V", "COMMON_TRACE_PREFIX", "", "FLAG_LOAD_MODEL", "FLAG_NEW_SERVICE", "FLAG_RUN_MODEL", "InterceptExceptionType", "KEY_CONTEXT", "KEY_KERNEL_SESSION", "KEY_VM_ARGS", "KEY_VM_CONTEXT", "exceptionHash", "exceptionInfo", "exceptionType", "onCallbackClient", "onEndApi", "onEndApiElapse", "onEndVmRun", "onLoadServiceEnd", "onLoadServiceStart", "onReceiveBinderRequest", "onReceiveBinderRequestElapse", "onStartApiCoroutine", "onStartVmRun", "onVmEnd", "onVmPyEnd", "onVmPyStart", "onVmRun", "onVmSessionBefore", "onVmSessionDispatch", "onVmSessionEnd", "onVmSessionStart", "build", "Lcom/obric/aikernel/request/track/ApiPerfDetails;", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "biz", "timeDiff", "", "end", CommonConsts.APM_INNER_EVENT_COST_START, "(JJ)Ljava/lang/Long;", "getContext", "Landroid/os/Bundle;", "getTimestamp", LocationMonitorConst.TAG, "getVmExtra", "getVmTimestamp", "newContext", "", "newVmContext", "Lkotlin/Pair;", "timestamp", "elapse", "", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void a(a r0, Bundle r1, String r2, boolean r3, int r4, Object r5) {
            if ((r4 & 2) == 0) goto L5;
            r3 = false;
        L5:
            r0.a(r1, r2, r3);
        }

        public final long a(Bundle r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            Bundle r0 = r1.getBundle(ApiPerfDetails.KEY_CONTEXT);
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getLong(r2);
        }

        public final Long a(long r3, long r5) {
            if (r5 == 0) goto L9;
            if (r5 > r3) goto L9;
            return Long.valueOf(r3 - r5);
        L9:
            return (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.memorydata.plugin");
        }

        public final void a(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            r2.putBundle(ApiPerfDetails.KEY_CONTEXT, new Bundle());
        }

        public final void a(Bundle r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "<this>");
            Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
            Bundle r2 = r3.getBundle(ApiPerfDetails.KEY_CONTEXT);
            if (r2 == null) goto L9;
            if (r5 == false) goto L6;
            long r0 = SystemClock.elapsedRealtime();
        L7:
            r2.putLong(r4, r0);
            return;
        L6:
            r0 = System.currentTimeMillis();
            goto L7
        }

        public final Pair<Bundle, Bundle> b(Bundle r8) {
            Intrinsics.checkNotNullParameter(r8, "<this>");
            r8.remove(ApiPerfDetails.KEY_KERNEL_SESSION);
            Bundle r7 = new Bundle();
            Bundle r0 = new Bundle();
            r7.putAll(r8);
            r0.putAll(r8);
            Set<String> r1 = r8.keySet();
            Intrinsics.checkNotNullExpressionValue(r1, "keySet()");
            Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r2.hasNext() == false) goto L20;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r3, "key");
            Character r4 = StringsKt.firstOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
            if (r4 == null) goto L14;
            if (r4.charValue() != '_') goto L14;
            if (AIInferRuntime.f6160a.a().contains(r3) == true) goto L4;
            r7.remove(r3);
        L14:
            if (r4 != null) goto L17;
        L19:
            r0.remove(r3);
            goto L4
        L17:
            if (r4.charValue() != '@') goto L19;
            r7.remove(r3);
            goto L19
        L20:
            String r5 = r8.getString(IdlKeys.Args_TraceId);
            if (r5 == null) goto L23;
            r0.putString("_session", r5);
        L23:
            r8.putBundle(ApiPerfDetails.KEY_VM_ARGS, r7);
            r8.putBundle(ApiPerfDetails.KEY_VM_CONTEXT, r0);
            return new Pair(r7, r0);
        }

        public final Bundle c(Bundle r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            Bundle r0 = r1.getBundle(ApiPerfDetails.KEY_VM_CONTEXT);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getBundle(WsConstants.KEY_EXTRA);
        }

        public final Bundle getContext(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Bundle r0 = r2.getBundle(ApiPerfDetails.KEY_CONTEXT);
            if (r0 != null) goto L9;
            ApiPerfDetails.Companion.a(r2);
            r0 = r2.getBundle(ApiPerfDetails.KEY_CONTEXT);
            if (r0 == null) goto L8;
            Intrinsics.checkNotNullExpressionValue(r0, "requireNotNull(getBundle(KEY_CONTEXT))");
            goto L9
        L8:
            throw new IllegalArgumentException("Required value was null.".toString());
        L9:
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJb\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\f¨\u0006$"}, d2 = {"Lcom/obric/aikernel/request/track/ApiPerfDetails$TraceStat;", "", "binderRequestDuration", "", "beforeStartCoroutineDuration", "beforeVmRunDuration", "vmRunDuration", "afterVmDuration", "callbackClientDuration", "totalDuration", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getAfterVmDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBeforeStartCoroutineDuration", "getBeforeVmRunDuration", "getBinderRequestDuration", "getCallbackClientDuration", "getTotalDuration", "getVmRunDuration", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/obric/aikernel/request/track/ApiPerfDetails$TraceStat;", "equals", "", "other", "hashCode", "", "toString", "", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Long f5993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f5994b;
        private final Long c;
        private final Long d;
        private final Long e;
        private final Long f;
        private final Long g;

        public b(Long r1, Long r2, Long r3, Long r4, Long r5, Long r6, Long r7) {
            this.f5993a = r1;
            this.f5994b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f5993a, r6.f5993a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f5994b, r6.f5994b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            Long r0 = this.f5993a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Long r4 = this.f5994b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Long r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Long r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Long r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Long r16 = this.f;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            Long r19 = this.g;
            if (r19 == null) goto L31;
            r1 = r19.hashCode();
        L31:
            return r18 + r1;
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "TraceStat(binderRequestDuration=" + this.f5993a + ", beforeStartCoroutineDuration=" + this.f5994b + ", beforeVmRunDuration=" + this.c + ", vmRunDuration=" + this.d + ", afterVmDuration=" + this.e + ", callbackClientDuration=" + this.f + ", totalDuration=" + this.g + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJb\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\f¨\u0006$"}, d2 = {"Lcom/obric/aikernel/request/track/ApiPerfDetails$VmStat;", "", "vmPyKotlinDuration", "", "vmPyCallDuration", "vmPyDispatchDuration", "vmPackageSessionDuration", "vmLoadServiceDuration", "vmPyScriptDuration", "vmTotalDuration", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getVmLoadServiceDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVmPackageSessionDuration", "getVmPyCallDuration", "getVmPyDispatchDuration", "getVmPyKotlinDuration", "getVmPyScriptDuration", "getVmTotalDuration", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/obric/aikernel/request/track/ApiPerfDetails$VmStat;", "equals", "", "other", "hashCode", "", "toString", "", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Long f5995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f5996b;
        private final Long c;
        private final Long d;
        private final Long e;
        private final Long f;
        private final Long g;

        public c(Long r1, Long r2, Long r3, Long r4, Long r5, Long r6, Long r7) {
            this.f5995a = r1;
            this.f5996b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f5995a, r6.f5995a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f5996b, r6.f5996b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            Long r0 = this.f5995a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Long r4 = this.f5996b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Long r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Long r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Long r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Long r16 = this.f;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            Long r19 = this.g;
            if (r19 == null) goto L31;
            r1 = r19.hashCode();
        L31:
            return r18 + r1;
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "VmStat(vmPyKotlinDuration=" + this.f5995a + ", vmPyCallDuration=" + this.f5996b + ", vmPyDispatchDuration=" + this.c + ", vmPackageSessionDuration=" + this.d + ", vmLoadServiceDuration=" + this.e + ", vmPyScriptDuration=" + this.f + ", vmTotalDuration=" + this.g + ')';
        }
    }

    static {
        Companion = new a(null);
    }

    public ApiPerfDetails(String r2, String r3, String r4, TraceInfo r5, VmInfo r6, c r7, b r8, JSONObject r9) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        Intrinsics.checkNotNullParameter(r3, "caller");
        Intrinsics.checkNotNullParameter(r4, "traceId");
        Intrinsics.checkNotNullParameter(r5, "traceInfo");
        Intrinsics.checkNotNullParameter(r6, "vmInfo");
        Intrinsics.checkNotNullParameter(r7, "vmStat");
        Intrinsics.checkNotNullParameter(r8, "traceStat");
        Intrinsics.checkNotNullParameter(r9, "commonTrace");
        this.biz = r2;
        this.caller = r3;
        this.traceId = r4;
        this.traceInfo = r5;
        this.vmInfo = r6;
        this.vmStat = r7;
        this.traceStat = r8;
        this.commonTrace = r9;
    }

    public /* synthetic */ ApiPerfDetails(String r24, String r25, String r26, TraceInfo r27, VmInfo r28, c r29, b r30, JSONObject r31, int r32, DefaultConstructorMarker r33) {
        if ((r32 & 32) == 0) goto L5;
        a r1 = Companion;
        Long r11 = r1.a(r28.getVmLoadServiceEndTime(), r28.getVmLoadServiceStartTime());
        Long r7 = r1.a(r28.getVmPyStartTime(), r28.getVmRunStartTime());
        Long r12 = r1.a(r28.getVmPyEndTime(), r28.getVmPyStartTime());
        c r20 = new c(r7, r1.a(r28.getVmSessionDispatchTime(), r28.getVmPyStartTime()), r1.a(r28.getVmSessionPrepareTime(), r28.getVmSessionDispatchTime()), r1.a(r28.getVmSessionEndTime(), r28.getVmSessionStartTime()), r11, r12, r1.a(r28.getVmRunEndTime(), r28.getVmRunStartTime()));
    L7:
        if ((r32 & 64) == 0) goto L9;
        a r2 = Companion;
        b r21 = new b(r2.a(r27.getBinderRequestTimeElapse(), r27.getClientRequestElapse()), r2.a(r27.getStartInferCoroutineTime(), r27.getBinderRequestTime()), r2.a(r27.getVmStartTime(), r27.getStartInferCoroutineTime()), r2.a(r27.getVmEndTime(), r27.getVmStartTime()), r2.a(r27.getInferEndTime(), r27.getVmEndTime()), r2.a(r27.getInferEndTime(), r27.getStartCallbackClientTime()), r2.a(r27.getInferEndElapse(), r27.getClientRequestElapse()));
    L11:
        if ((r32 & 128) == 0) goto L13;
        JSONObject r22 = new JSONObject();
    L14:
        this(r24, r25, r26, r27, r28, r20, r21, r22);
        return;
    L13:
        r22 = r31;
        goto L14
    L9:
        r21 = r30;
        goto L11
    L5:
        r20 = r29;
        goto L7
    }

    public static /* synthetic */ ApiPerfDetails copy$default(ApiPerfDetails r9, String r10, String r11, String r12, TraceInfo r13, VmInfo r14, c r15, b r16, JSONObject r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.biz;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.caller;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.traceId;
    L15:
        if ((r18 & 8) == 0) goto L17;
        TraceInfo r5 = r9.traceInfo;
    L19:
        if ((r18 & 16) == 0) goto L21;
        VmInfo r6 = r9.vmInfo;
    L23:
        if ((r18 & 32) == 0) goto L25;
        c r7 = r9.vmStat;
    L27:
        if ((r18 & 64) == 0) goto L29;
        b r8 = r9.traceStat;
    L31:
        if ((r18 & 128) == 0) goto L33;
        JSONObject r1 = r9.commonTrace;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.biz;
    }

    public final String component2() {
        return this.caller;
    }

    public final String component3() {
        return this.traceId;
    }

    public final TraceInfo component4() {
        return this.traceInfo;
    }

    public final VmInfo component5() {
        return this.vmInfo;
    }

    public final c component6() {
        return this.vmStat;
    }

    public final b component7() {
        return this.traceStat;
    }

    public final JSONObject component8() {
        return this.commonTrace;
    }

    public final ApiPerfDetails copy(String r11, String r12, String r13, TraceInfo r14, VmInfo r15, c r16, b r17, JSONObject r18) {
        Intrinsics.checkNotNullParameter(r11, "biz");
        Intrinsics.checkNotNullParameter(r12, "caller");
        Intrinsics.checkNotNullParameter(r13, "traceId");
        Intrinsics.checkNotNullParameter(r14, "traceInfo");
        Intrinsics.checkNotNullParameter(r15, "vmInfo");
        Intrinsics.checkNotNullParameter(r16, "vmStat");
        Intrinsics.checkNotNullParameter(r17, "traceStat");
        Intrinsics.checkNotNullParameter(r18, "commonTrace");
        return new ApiPerfDetails(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ApiPerfDetails.class) == true) goto L8;
        return false;
    L8:
        ApiPerfDetails r6 = (ApiPerfDetails) ZeusTransformUtils.preCheckCast(r5, ApiPerfDetails.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.biz, r6.biz) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.caller, r6.caller) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.traceId, r6.traceId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.traceInfo, r6.traceInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.vmInfo, r6.vmInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.vmStat, r6.vmStat) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.traceStat, r6.traceStat) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.commonTrace, r6.commonTrace) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getBiz() {
        return this.biz;
    }

    public final String getCaller() {
        return this.caller;
    }

    public final JSONObject getCommonTrace() {
        return this.commonTrace;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final TraceInfo getTraceInfo() {
        return this.traceInfo;
    }

    public final b getTraceStat() {
        return this.traceStat;
    }

    public final VmInfo getVmInfo() {
        return this.vmInfo;
    }

    public final c getVmStat() {
        return this.vmStat;
    }

    public int hashCode() {
        return (((((((((((((this.biz.hashCode() * 31) + this.caller.hashCode()) * 31) + this.traceId.hashCode()) * 31) + this.traceInfo.hashCode()) * 31) + this.vmInfo.hashCode()) * 31) + this.vmStat.hashCode()) * 31) + this.traceStat.hashCode()) * 31) + this.commonTrace.hashCode();
    }

    public String toString() {
        return "ApiPerfDetails(biz=" + this.biz + ", caller=" + this.caller + ", traceId=" + this.traceId + ", traceInfo=" + this.traceInfo + ", vmInfo=" + this.vmInfo + ", vmStat=" + this.vmStat + ", traceStat=" + this.traceStat + ", commonTrace=" + this.commonTrace + ')';
    }
}
