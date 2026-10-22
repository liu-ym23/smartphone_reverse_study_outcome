package com.obric.aikernel.request.track;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.sdk.config.RequestParams;
import java.util.Iterator;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
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

    @Keep
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

        public TraceInfo(long r10, long r11, long r12, long r13, long r14, long r15, long r16, long r18, long r20) {
            this.clientRequestElapse = r10;
            this.binderRequestTime = r11;
            this.binderRequestTimeElapse = r12;
            this.startInferCoroutineTime = r13;
            this.vmStartTime = r14;
            this.vmEndTime = r15;
            this.startCallbackClientTime = r16;
            this.inferEndTime = r18;
            this.inferEndElapse = r20;
        }

        public static /* synthetic */ TraceInfo copy$default(TraceInfo r16, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, int r35, Object r36) {
            if ((r35 & 1) == 0) goto L5;
            long r10 = r16.clientRequestElapse;
        L7:
            if ((r35 & 2) == 0) goto L9;
            long r11 = r16.binderRequestTime;
        L11:
            if ((r35 & 4) == 0) goto L13;
            long r12 = r16.binderRequestTimeElapse;
        L15:
            if ((r35 & 8) == 0) goto L17;
            long r13 = r16.startInferCoroutineTime;
        L19:
            if ((r35 & 16) == 0) goto L21;
            long r14 = r16.vmStartTime;
        L23:
            if ((r35 & 32) == 0) goto L25;
            long r15 = r16.vmEndTime;
        L27:
            if ((r35 & 64) == 0) goto L29;
            long r18 = r16.startCallbackClientTime;
        L30:
            long r210 = r18;
            if ((r35 & 128) == 0) goto L33;
            long r110 = r16.inferEndTime;
        L34:
            long r32 = r110;
            if ((r35 & 256) == 0) goto L37;
            long r111 = r16.inferEndElapse;
        L39:
            return r16.copy(r10, r11, r12, r13, r14, r15, r210, r32, r111);
        L37:
            r111 = r33;
            goto L39
        L33:
            r110 = r31;
            goto L34
        L29:
            r18 = r29;
            goto L30
        L25:
            r15 = r27;
            goto L27
        L21:
            r14 = r25;
            goto L23
        L17:
            r13 = r23;
            goto L19
        L13:
            r12 = r21;
            goto L15
        L9:
            r11 = r19;
            goto L11
        L5:
            r10 = r17;
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

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof TraceInfo) == true) goto L8;
            return false;
        L8:
            TraceInfo r11 = (TraceInfo) r10;
            if (this.clientRequestElapse == r11.clientRequestElapse) goto L12;
            return false;
        L12:
            if (this.binderRequestTime == r11.binderRequestTime) goto L15;
            return false;
        L15:
            if (this.binderRequestTimeElapse == r11.binderRequestTimeElapse) goto L18;
            return false;
        L18:
            if (this.startInferCoroutineTime == r11.startInferCoroutineTime) goto L21;
            return false;
        L21:
            if (this.vmStartTime == r11.vmStartTime) goto L24;
            return false;
        L24:
            if (this.vmEndTime == r11.vmEndTime) goto L27;
            return false;
        L27:
            if (this.startCallbackClientTime == r11.startCallbackClientTime) goto L30;
            return false;
        L30:
            if (this.inferEndTime == r11.inferEndTime) goto L33;
            return false;
        L33:
            if (this.inferEndElapse == r11.inferEndElapse) goto L35;
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

    @Keep
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

        public VmInfo(long r10, long r11, long r12, long r13, long r14, long r15, long r16, long r18, long r20, long r22) {
            this.vmRunStartTime = r10;
            this.vmLoadServiceStartTime = r11;
            this.vmLoadServiceEndTime = r12;
            this.vmPyStartTime = r13;
            this.vmSessionDispatchTime = r14;
            this.vmSessionPrepareTime = r15;
            this.vmSessionStartTime = r16;
            this.vmSessionEndTime = r18;
            this.vmPyEndTime = r20;
            this.vmRunEndTime = r22;
        }

        public static /* synthetic */ VmInfo copy$default(VmInfo r16, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, int r37, Object r38) {
            if ((r37 & 1) == 0) goto L5;
            long r10 = r16.vmRunStartTime;
        L7:
            if ((r37 & 2) == 0) goto L9;
            long r11 = r16.vmLoadServiceStartTime;
        L11:
            if ((r37 & 4) == 0) goto L13;
            long r12 = r16.vmLoadServiceEndTime;
        L15:
            if ((r37 & 8) == 0) goto L17;
            long r13 = r16.vmPyStartTime;
        L19:
            if ((r37 & 16) == 0) goto L21;
            long r14 = r16.vmSessionDispatchTime;
        L23:
            if ((r37 & 32) == 0) goto L25;
            long r15 = r16.vmSessionPrepareTime;
        L27:
            if ((r37 & 64) == 0) goto L29;
            long r18 = r16.vmSessionStartTime;
        L30:
            long r210 = r18;
            if ((r37 & 128) == 0) goto L33;
            long r110 = r16.vmSessionEndTime;
        L34:
            long r32 = r110;
            if ((r37 & 256) == 0) goto L37;
            long r111 = r16.vmPyEndTime;
        L38:
            long r34 = r111;
            if ((r37 & 512) == 0) goto L41;
            long r112 = r16.vmRunEndTime;
        L43:
            return r16.copy(r10, r11, r12, r13, r14, r15, r210, r32, r34, r112);
        L41:
            r112 = r35;
            goto L43
        L37:
            r111 = r33;
            goto L38
        L33:
            r110 = r31;
            goto L34
        L29:
            r18 = r29;
            goto L30
        L25:
            r15 = r27;
            goto L27
        L21:
            r14 = r25;
            goto L23
        L17:
            r13 = r23;
            goto L19
        L13:
            r12 = r21;
            goto L15
        L9:
            r11 = r19;
            goto L11
        L5:
            r10 = r17;
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

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof VmInfo) == true) goto L8;
            return false;
        L8:
            VmInfo r11 = (VmInfo) r10;
            if (this.vmRunStartTime == r11.vmRunStartTime) goto L12;
            return false;
        L12:
            if (this.vmLoadServiceStartTime == r11.vmLoadServiceStartTime) goto L15;
            return false;
        L15:
            if (this.vmLoadServiceEndTime == r11.vmLoadServiceEndTime) goto L18;
            return false;
        L18:
            if (this.vmPyStartTime == r11.vmPyStartTime) goto L21;
            return false;
        L21:
            if (this.vmSessionDispatchTime == r11.vmSessionDispatchTime) goto L24;
            return false;
        L24:
            if (this.vmSessionPrepareTime == r11.vmSessionPrepareTime) goto L27;
            return false;
        L27:
            if (this.vmSessionStartTime == r11.vmSessionStartTime) goto L30;
            return false;
        L30:
            if (this.vmSessionEndTime == r11.vmSessionEndTime) goto L33;
            return false;
        L33:
            if (this.vmPyEndTime == r11.vmPyEndTime) goto L36;
            return false;
        L36:
            if (this.vmRunEndTime == r11.vmRunEndTime) goto L38;
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

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ void j(a r10, Bundle r11, String r12, boolean r13, int r14, Object r15) {
            if ((r14 & 2) == 0) goto L5;
            r13 = false;
        L5:
            r10.i(r11, r12, r13);
        }

        public final ApiPerfDetails a(RequestParams r52, String r53) {
            Intrinsics.checkNotNullParameter(r52, "params");
            JSONObject r10 = new JSONObject();
            Bundle r11 = d(r52.getBackend());
            if (r11 == null) goto L12;
            Set<String> r12 = r11.keySet();
            Intrinsics.checkNotNullExpressionValue(r12, "it.keySet()");
            Iterator<T> r13 = r12.iterator();
        L6:
            if (r13.hasNext() == false) goto L12;
            String r14 = (String) r13.next();
            Intrinsics.checkNotNullExpressionValue(r14, "key");
            if (StringsKt.startsWith$default(r14, ApiPerfDetails.COMMON_TRACE_PREFIX, false, 2, null) == false) goto L6;
            String r15 = r14.substring(6);
            Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).substring(startIndex)");
            r10.put(r15, r11.get(r14));
        L12:
            if (r53 != null) goto L14;
            String r16 = e8.a.e(r52.getBackend());
        L16:
            return new ApiPerfDetails(r16, e8.a.j(r52.getBackend()), r52.getTraceIdStr(), new TraceInfo(r52.getReqTime(), c(r52.getBackend(), ApiPerfDetails.onReceiveBinderRequest), c(r52.getBackend(), ApiPerfDetails.onReceiveBinderRequestElapse), c(r52.getBackend(), ApiPerfDetails.onStartApiCoroutine), c(r52.getBackend(), ApiPerfDetails.onStartVmRun), c(r52.getBackend(), ApiPerfDetails.onEndVmRun), c(r52.getBackend(), ApiPerfDetails.onCallbackClient), c(r52.getBackend(), ApiPerfDetails.onEndApi), c(r52.getBackend(), ApiPerfDetails.onEndApiElapse)), new VmInfo(e(r52.getBackend(), ApiPerfDetails.onVmRun), e(r52.getBackend(), ApiPerfDetails.onLoadServiceStart), e(r52.getBackend(), ApiPerfDetails.onLoadServiceEnd), e(r52.getBackend(), ApiPerfDetails.onVmPyStart), e(r52.getBackend(), ApiPerfDetails.onVmSessionDispatch), e(r52.getBackend(), ApiPerfDetails.onVmSessionStart), e(r52.getBackend(), ApiPerfDetails.onVmSessionBefore), e(r52.getBackend(), ApiPerfDetails.onVmSessionEnd), e(r52.getBackend(), ApiPerfDetails.onVmPyEnd), e(r52.getBackend(), ApiPerfDetails.onVmEnd)), null, null, r10, 96, null);
        L14:
            r16 = r53;
            goto L16
        }

        public final Bundle b(Bundle r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Bundle r11 = r10.getBundle(ApiPerfDetails.KEY_CONTEXT);
            if (r11 != null) goto L9;
            ApiPerfDetails.Companion.f(r10);
            r11 = r10.getBundle(ApiPerfDetails.KEY_CONTEXT);
            if (r11 == null) goto L8;
            Intrinsics.checkNotNullExpressionValue(r11, "requireNotNull(getBundle(KEY_CONTEXT))");
            goto L9
        L8:
            throw new IllegalArgumentException("Required value was null.".toString());
        L9:
            return r11;
        }

        public final long c(Bundle r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "tag");
            Bundle r12 = r10.getBundle(ApiPerfDetails.KEY_CONTEXT);
            if (r12 != null) goto L7;
            return 0;
        L7:
            return r12.getLong(r11);
        }

        public final Bundle d(Bundle r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Bundle r11 = r10.getBundle(ApiPerfDetails.KEY_VM_CONTEXT);
            if (r11 != null) goto L7;
            return null;
        L7:
            return r11.getBundle(WsConstants.KEY_EXTRA);
        }

        public final long e(Bundle r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "tag");
            Bundle r12 = d(r10);
            if (r12 != null) goto L7;
            return 0;
        L7:
            return r12.getLong(r11);
        }

        public final void f(Bundle r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            r10.putBundle(ApiPerfDetails.KEY_CONTEXT, new Bundle());
        }

        public final Pair<Bundle, Bundle> g(Bundle r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            r10.remove(ApiPerfDetails.KEY_KERNEL_SESSION);
            Bundle r11 = new Bundle();
            Bundle r12 = new Bundle();
            r11.putAll(r10);
            r12.putAll(r10);
            Set<String> r13 = r10.keySet();
            Intrinsics.checkNotNullExpressionValue(r13, "keySet()");
            Iterator<T> r14 = r13.iterator();
        L4:
            if (r14.hasNext() == false) goto L20;
            String r15 = (String) r14.next();
            Intrinsics.checkNotNullExpressionValue(r15, "key");
            Character r16 = StringsKt.firstOrNull(r15);
            if (r16 == null) goto L14;
            if (r16.charValue() != '_') goto L14;
            if (AIInferRuntime.f5235t.b().contains(r15) == true) goto L4;
            r11.remove(r15);
        L14:
            if (r16 != null) goto L17;
        L19:
            r12.remove(r15);
            goto L4
        L17:
            if (r16.charValue() != '@') goto L19;
            r11.remove(r15);
            goto L19
        L20:
            String r17 = r10.getString(IdlKeys.Args_TraceId);
            if (r17 == null) goto L23;
            r12.putString("_session", r17);
        L23:
            r10.putBundle(ApiPerfDetails.KEY_VM_ARGS, r11);
            r10.putBundle(ApiPerfDetails.KEY_VM_CONTEXT, r12);
            return new Pair(r11, r12);
        }

        public final Long h(long r10, long r11) {
            if (r11 != 0) goto L5;
        L8:
            return null;
        L5:
            if (r11 > r10) goto L8;
            return Long.valueOf(r10 - r11);
        }

        public final void i(Bundle r10, String r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "tag");
            Bundle r13 = r10.getBundle(ApiPerfDetails.KEY_CONTEXT);
            if (r13 == null) goto L9;
            if (r12 == false) goto L6;
            long r14 = SystemClock.elapsedRealtime();
        L7:
            r13.putLong(r11, r14);
            return;
        L6:
            r14 = System.currentTimeMillis();
            goto L7
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Long f4847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f4848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Long f4849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Long f4850d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Long f4851e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Long f4852f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Long f4853g;

        public b(Long r10, Long r11, Long r12, Long r13, Long r14, Long r15, Long r16) {
            this.f4847a = r10;
            this.f4848b = r11;
            this.f4849c = r12;
            this.f4850d = r13;
            this.f4851e = r14;
            this.f4852f = r15;
            this.f4853g = r16;
        }

        public final Long a() {
            return this.f4851e;
        }

        public final Long b() {
            return this.f4848b;
        }

        public final Long c() {
            return this.f4849c;
        }

        public final Long d() {
            return this.f4847a;
        }

        public final Long e() {
            return this.f4852f;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.f4847a, r11.f4847a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f4848b, r11.f4848b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f4849c, r11.f4849c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f4850d, r11.f4850d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f4851e, r11.f4851e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f4852f, r11.f4852f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f4853g, r11.f4853g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final Long f() {
            return this.f4853g;
        }

        public final Long g() {
            return this.f4850d;
        }

        public int hashCode() {
            Long r10 = this.f4847a;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = r12 * 31;
            Long r14 = this.f4848b;
            if (r14 != null) goto L9;
            int r15 = 0;
        L10:
            int r16 = (r13 + r15) * 31;
            Long r17 = this.f4849c;
            if (r17 != null) goto L13;
            int r18 = 0;
        L14:
            int r19 = (r16 + r18) * 31;
            Long r20 = this.f4850d;
            if (r20 != null) goto L17;
            int r21 = 0;
        L18:
            int r22 = (r19 + r21) * 31;
            Long r23 = this.f4851e;
            if (r23 != null) goto L21;
            int r24 = 0;
        L22:
            int r25 = (r22 + r24) * 31;
            Long r26 = this.f4852f;
            if (r26 != null) goto L25;
            int r27 = 0;
        L26:
            int r28 = (r25 + r27) * 31;
            Long r29 = this.f4853g;
            if (r29 == null) goto L31;
            r11 = r29.hashCode();
        L31:
            return r28 + r11;
        L25:
            r27 = r26.hashCode();
            goto L26
        L21:
            r24 = r23.hashCode();
            goto L22
        L17:
            r21 = r20.hashCode();
            goto L18
        L13:
            r18 = r17.hashCode();
            goto L14
        L9:
            r15 = r14.hashCode();
            goto L10
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        public String toString() {
            return "TraceStat(binderRequestDuration=" + this.f4847a + ", beforeStartCoroutineDuration=" + this.f4848b + ", beforeVmRunDuration=" + this.f4849c + ", vmRunDuration=" + this.f4850d + ", afterVmDuration=" + this.f4851e + ", callbackClientDuration=" + this.f4852f + ", totalDuration=" + this.f4853g + ')';
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Long f4854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f4855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Long f4856c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Long f4857d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Long f4858e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Long f4859f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Long f4860g;

        public c(Long r10, Long r11, Long r12, Long r13, Long r14, Long r15, Long r16) {
            this.f4854a = r10;
            this.f4855b = r11;
            this.f4856c = r12;
            this.f4857d = r13;
            this.f4858e = r14;
            this.f4859f = r15;
            this.f4860g = r16;
        }

        public final Long a() {
            return this.f4858e;
        }

        public final Long b() {
            return this.f4857d;
        }

        public final Long c() {
            return this.f4855b;
        }

        public final Long d() {
            return this.f4856c;
        }

        public final Long e() {
            return this.f4854a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.f4854a, r11.f4854a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f4855b, r11.f4855b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f4856c, r11.f4856c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f4857d, r11.f4857d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f4858e, r11.f4858e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f4859f, r11.f4859f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f4860g, r11.f4860g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final Long f() {
            return this.f4859f;
        }

        public final Long g() {
            return this.f4860g;
        }

        public int hashCode() {
            Long r10 = this.f4854a;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = r12 * 31;
            Long r14 = this.f4855b;
            if (r14 != null) goto L9;
            int r15 = 0;
        L10:
            int r16 = (r13 + r15) * 31;
            Long r17 = this.f4856c;
            if (r17 != null) goto L13;
            int r18 = 0;
        L14:
            int r19 = (r16 + r18) * 31;
            Long r20 = this.f4857d;
            if (r20 != null) goto L17;
            int r21 = 0;
        L18:
            int r22 = (r19 + r21) * 31;
            Long r23 = this.f4858e;
            if (r23 != null) goto L21;
            int r24 = 0;
        L22:
            int r25 = (r22 + r24) * 31;
            Long r26 = this.f4859f;
            if (r26 != null) goto L25;
            int r27 = 0;
        L26:
            int r28 = (r25 + r27) * 31;
            Long r29 = this.f4860g;
            if (r29 == null) goto L31;
            r11 = r29.hashCode();
        L31:
            return r28 + r11;
        L25:
            r27 = r26.hashCode();
            goto L26
        L21:
            r24 = r23.hashCode();
            goto L22
        L17:
            r21 = r20.hashCode();
            goto L18
        L13:
            r18 = r17.hashCode();
            goto L14
        L9:
            r15 = r14.hashCode();
            goto L10
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        public String toString() {
            return "VmStat(vmPyKotlinDuration=" + this.f4854a + ", vmPyCallDuration=" + this.f4855b + ", vmPyDispatchDuration=" + this.f4856c + ", vmPackageSessionDuration=" + this.f4857d + ", vmLoadServiceDuration=" + this.f4858e + ", vmPyScriptDuration=" + this.f4859f + ", vmTotalDuration=" + this.f4860g + ')';
        }
    }

    static {
        Companion = new a(null);
    }

    public ApiPerfDetails(String r10, String r11, String r12, TraceInfo r13, VmInfo r14, c r15, b r16, JSONObject r17) {
        Intrinsics.checkNotNullParameter(r10, "biz");
        Intrinsics.checkNotNullParameter(r11, "caller");
        Intrinsics.checkNotNullParameter(r12, "traceId");
        Intrinsics.checkNotNullParameter(r13, "traceInfo");
        Intrinsics.checkNotNullParameter(r14, "vmInfo");
        Intrinsics.checkNotNullParameter(r15, "vmStat");
        Intrinsics.checkNotNullParameter(r16, "traceStat");
        Intrinsics.checkNotNullParameter(r17, "commonTrace");
        this.biz = r10;
        this.caller = r11;
        this.traceId = r12;
        this.traceInfo = r13;
        this.vmInfo = r14;
        this.vmStat = r15;
        this.traceStat = r16;
        this.commonTrace = r17;
    }

    public /* synthetic */ ApiPerfDetails(String r24, String r25, String r26, TraceInfo r27, VmInfo r28, c r29, b r30, JSONObject r31, int r32, DefaultConstructorMarker r33) {
        if ((r32 & 32) == 0) goto L5;
        a r10 = Companion;
        Long r11 = r10.h(r28.getVmLoadServiceEndTime(), r28.getVmLoadServiceStartTime());
        Long r12 = r10.h(r28.getVmPyStartTime(), r28.getVmRunStartTime());
        Long r13 = r10.h(r28.getVmPyEndTime(), r28.getVmPyStartTime());
        c r20 = new c(r12, r10.h(r28.getVmSessionDispatchTime(), r28.getVmPyStartTime()), r10.h(r28.getVmSessionPrepareTime(), r28.getVmSessionDispatchTime()), r10.h(r28.getVmSessionEndTime(), r28.getVmSessionStartTime()), r11, r13, r10.h(r28.getVmRunEndTime(), r28.getVmRunStartTime()));
    L7:
        if ((r32 & 64) == 0) goto L9;
        a r14 = Companion;
        b r21 = new b(r14.h(r27.getBinderRequestTimeElapse(), r27.getClientRequestElapse()), r14.h(r27.getStartInferCoroutineTime(), r27.getBinderRequestTime()), r14.h(r27.getVmStartTime(), r27.getStartInferCoroutineTime()), r14.h(r27.getVmEndTime(), r27.getVmStartTime()), r14.h(r27.getInferEndTime(), r27.getVmEndTime()), r14.h(r27.getInferEndTime(), r27.getStartCallbackClientTime()), r14.h(r27.getInferEndElapse(), r27.getClientRequestElapse()));
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

    public static /* synthetic */ ApiPerfDetails copy$default(ApiPerfDetails r10, String r11, String r12, String r13, TraceInfo r14, VmInfo r15, c r16, b r17, JSONObject r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r20 = r10.biz;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r21 = r10.caller;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r22 = r10.traceId;
    L15:
        if ((r19 & 8) == 0) goto L17;
        TraceInfo r23 = r10.traceInfo;
    L19:
        if ((r19 & 16) == 0) goto L21;
        VmInfo r24 = r10.vmInfo;
    L23:
        if ((r19 & 32) == 0) goto L25;
        c r25 = r10.vmStat;
    L27:
        if ((r19 & 64) == 0) goto L29;
        b r26 = r10.traceStat;
    L31:
        if ((r19 & 128) == 0) goto L33;
        JSONObject r27 = r10.commonTrace;
    L35:
        return r10.copy(r20, r21, r22, r23, r24, r25, r26, r27);
    L33:
        r27 = r18;
        goto L35
    L29:
        r26 = r17;
        goto L31
    L25:
        r25 = r16;
        goto L27
    L21:
        r24 = r15;
        goto L23
    L17:
        r23 = r14;
        goto L19
    L13:
        r22 = r13;
        goto L15
    L9:
        r21 = r12;
        goto L11
    L5:
        r20 = r11;
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

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ApiPerfDetails) == true) goto L8;
        return false;
    L8:
        ApiPerfDetails r11 = (ApiPerfDetails) r10;
        if (Intrinsics.areEqual(this.biz, r11.biz) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.caller, r11.caller) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.traceId, r11.traceId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.traceInfo, r11.traceInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.vmInfo, r11.vmInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.vmStat, r11.vmStat) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.traceStat, r11.traceStat) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.commonTrace, r11.commonTrace) == true) goto L32;
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
