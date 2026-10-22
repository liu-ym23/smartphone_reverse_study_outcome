package com.obric.aikernel;

import android.os.Bundle;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.event.EnsureReportData;
import com.obric.aee.res.TimePair;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.middleware.api.appcontext.receiver.ChargingStateListener;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.traker.ITrackerApi;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.aikernel.request.TimerLogger;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.aikernel.runtime.VmEngine;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class RequestTracker implements com.obric.aikernel.request.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f4406c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aikernel.request.a f4407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l0 f4408b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(b r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            int r11 = r10.d();
            if (r11 == 0) goto L22;
            boolean r12 = false;
            if (r11 == 500) goto L14;
            String r13 = r10.c().getString(ApiPerfDetails.exceptionInfo);
            if (r13 != null) goto L9;
            r13 = r10.e();
        L9:
            Intrinsics.checkNotNullExpressionValue(r13, "info.contextExtra.getStr…ionInfo) ?: info.errorMsg");
            if (r13.length() <= 0) goto L12;
            r12 = true;
        L12:
            if (r12 == false) goto L22;
            String r14 = com.bytedance.common.utility.a.a(r13);
            r10.f().put(ApiPerfDetails.exceptionHash, r14);
            TrackerApi r15 = TrackerApi.INSTANCE;
            JSONObject r16 = new JSONObject();
            r16.put(ApiPerfDetails.exceptionHash, r14);
            r16.put(ApiPerfDetails.exceptionInfo, r13);
            Unit r17 = Unit.INSTANCE;
            String r18 = "custom_exception";
        L21:
            r15.onEvent(r18, r16);
            goto L22
        L14:
            String r19 = r10.c().getString(ApiPerfDetails.exceptionInfo);
            if (r19 != null) goto L17;
        L18:
            r12 = true;
        L19:
            if (r12 == true) goto L22;
            String r20 = com.bytedance.common.utility.a.a(r19);
            JSONObject r21 = r10.f();
            r21.put(ApiPerfDetails.exceptionType, r10.c().getString(ApiPerfDetails.exceptionType));
            r21.put(ApiPerfDetails.exceptionHash, r20);
            r15 = TrackerApi.INSTANCE;
            r16 = new JSONObject();
            r16.put(ApiPerfDetails.exceptionHash, r20);
            r16.put("stack", r19);
            Unit r22 = Unit.INSTANCE;
            r18 = "pyvm_exception";
            goto L21
        L17:
            if (r19.length() != 0) goto L19;
        L22:
            TrackerApi.INSTANCE.onEvent("api_request_event", r10.f());
        }

        public final JSONObject b(JSONObject r10, JSONObject r11, JSONObject r12) {
            Intrinsics.checkNotNullParameter(r10, EventBody.KEY_CATEGORY);
            Intrinsics.checkNotNullParameter(r11, "metrics");
            JSONObject r13 = new JSONObject();
            Iterator<String> r14 = r10.keys();
            Intrinsics.checkNotNullExpressionValue(r14, "category.keys()");
        L4:
            if (r14.hasNext() == false) goto L6;
            String r15 = r14.next();
            r13.put(r15, r10.get(r15));
            goto L4
        L6:
            Iterator<String> r16 = r11.keys();
            Intrinsics.checkNotNullExpressionValue(r16, "metrics.keys()");
        L8:
            if (r16.hasNext() == false) goto L10;
            String r17 = r16.next();
            r13.put(r17, r11.get(r17));
            goto L8
        L10:
            if (r12 == null) goto L16;
            Iterator<String> r18 = r12.keys();
            if (r18 == null) goto L16;
        L14:
            if (r18.hasNext() == false) goto L16;
            String r19 = r18.next();
            r13.put(r19, r12.get(r19));
        L16:
            return r13;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final JSONObject f4411c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ApiPerfDetails f4412d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f4413e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f4414f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f4415g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f4416h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f4417i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f4418j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final boolean f4419k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final Bundle f4420l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final boolean f4421m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final Bundle f4422n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final String f4423o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f4424p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final Integer f4425q;

        public b(String r10, String r11, RequestParams r12, Bundle r13, JSONObject r14) {
            Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
            Intrinsics.checkNotNullParameter(r11, "biz");
            Intrinsics.checkNotNullParameter(r12, "params");
            Intrinsics.checkNotNullParameter(r13, "ret");
            Intrinsics.checkNotNullParameter(r14, "events");
            this.f4409a = r10;
            this.f4410b = r11;
            this.f4411c = r14;
            new JSONObject();
            new JSONObject();
            ApiPerfDetails.a r15 = ApiPerfDetails.Companion;
            this.f4412d = r15.a(r12, r11);
            this.f4413e = com.obric.aikernel.middleware.api.appcontext.receiver.e.f4540a.d();
            this.f4414f = ChargingStateListener.f4508a.e();
            this.f4415g = r12.getTraceIdStr();
            this.f4416h = e8.a.k(r12.getBackend());
            this.f4417i = e8.a.f(r13);
            this.f4418j = e8.a.g(r13);
            this.f4419k = r12.getBackend().getBoolean(IdlKeys.Args_StreamingCall);
            this.f4420l = r15.d(r12.getBackend());
            this.f4421m = r12.getBackend().getBoolean(IdlKeys.Args_UseCloud);
            this.f4422n = r15.b(r12.getBackend());
            this.f4423o = com.obric.aikernel.utils.b.a(r12.getBackend());
            this.f4424p = r12.getBackend().getInt(IdlKeys.Args_Priority);
            this.f4425q = VmEngine.f5343d.b(r12);
        }

        public /* synthetic */ b(String r10, String r11, RequestParams r12, Bundle r13, JSONObject r14, int r15, DefaultConstructorMarker r16) {
            if ((r15 & 16) == 0) goto L5;
            r14 = new JSONObject();
        L5:
            this(r10, r11, r12, r13, r14);
        }

        public static /* synthetic */ void b(b r10, long r11, String r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r11 = 0;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r12 = null;
        L8:
            r10.a(r11, r12);
        }

        public final void a(long r21, String r23) {
            JSONObject r10 = this.f4411c;
            r10.put(EnsureReportData.METHOD, this.f4409a);
            r10.put("pre_screen_on", this.f4413e);
            r10.put("pre_charging", this.f4414f);
            r10.put("biz", this.f4410b);
            r10.put("caller", this.f4412d.getCaller());
            r10.put(ITrackerApi.CALLER_PKG, this.f4412d.getCaller());
            r10.put("sdk_ver", this.f4416h);
            r10.put("status", this.f4417i);
            int r11 = 0;
            r10.put("is_cloud", this.f4422n.getBoolean("is_cloud", false));
            int r12 = 1;
            r10.put("model_quota_state", this.f4422n.getInt("model_quota_state", 1));
            r10.put(IdlKeys.Args_Priority, this.f4424p);
            r10.put("model_quota_count", this.f4422n.getInt("model_quota_count"));
            r10.put("use_cloud", this.f4421m);
            r10.put("is_stream", this.f4419k);
            String r13 = this.f4422n.getString("version");
            if (r13 == null) goto L5;
            r10.put("version", r13);
        L5:
            if (r23 == null) goto L7;
            r10.put("ab_tag", r23);
        L7:
            String r14 = this.f4423o;
            if (r14 == null) goto L10;
            r10.put("lora_type", r14);
        L10:
            Bundle r15 = this.f4420l;
            if (r15 != null) goto L13;
        L22:
            Long r16 = this.f4412d.getTraceStat().f();
            if (r16 == null) goto L25;
            long r17 = r16.longValue();
        L26:
            r10.put("duration", r17);
            Boolean r18 = Boolean.valueOf(this.f4422n.containsKey("server_time"));
            if (r18.booleanValue() == true) goto L30;
            r18 = null;
        L30:
            if (r18 == null) goto L32;
            r18.booleanValue();
            r10.put("server_time", this.f4422n.getLong("server_time"));
        L32:
            Boolean r19 = Boolean.valueOf(this.f4422n.containsKey("log_id"));
            if (r19.booleanValue() == true) goto L36;
            r19 = null;
        L36:
            if (r19 == null) goto L38;
            r19.booleanValue();
            r10.put("log_id", this.f4422n.getString("log_id"));
        L38:
            Long r20 = this.f4412d.getTraceStat().d();
            if (r20 == null) goto L41;
            r10.put("dur_binder_in", r20.longValue());
        L41:
            Long r22 = this.f4412d.getTraceStat().b();
            if (r22 == null) goto L44;
            r10.put("dur_start_coroutine", r22.longValue());
        L44:
            Long r24 = this.f4412d.getTraceStat().c();
            if (r24 == null) goto L47;
            r10.put("dur_pre_proc", r24.longValue());
        L47:
            Long r25 = this.f4412d.getTraceStat().g();
            if (r25 == null) goto L50;
            r10.put("dur_process", r25.longValue());
        L50:
            Long r26 = this.f4412d.getTraceStat().a();
            if (r26 == null) goto L53;
            r10.put("dur_post_proc", r26.longValue());
        L53:
            Long r27 = this.f4412d.getTraceStat().e();
            if (r27 == null) goto L56;
            r10.put("dur_binder_out", r27.longValue());
        L56:
            Long r28 = this.f4412d.getVmStat().g();
            if (r28 == null) goto L59;
            r10.put("dur_vm_total", r28.longValue());
        L59:
            Long r29 = this.f4412d.getVmStat().f();
            if (r29 == null) goto L62;
            r10.put("dur_vm_py", r29.longValue());
        L62:
            Long r30 = this.f4412d.getVmStat().e();
            if (r30 == null) goto L65;
            r10.put("dur_vm_py_kotlin", r30.longValue());
        L65:
            Long r31 = this.f4412d.getVmStat().c();
            if (r31 == null) goto L68;
            r10.put("dur_vm_py_call", r31.longValue());
        L68:
            Long r32 = this.f4412d.getVmStat().d();
            if (r32 == null) goto L71;
            r10.put("dur_vm_py_dispatch", r32.longValue());
        L71:
            Long r33 = this.f4412d.getVmStat().b();
            if (r33 == null) goto L74;
            r10.put("dur_vm_session", r33.longValue());
        L74:
            Long r34 = this.f4412d.getVmStat().a();
            if (r34 == null) goto L77;
            r10.put("dur_vm_load", r34.longValue());
        L77:
            Iterator<String> r35 = this.f4412d.getCommonTrace().keys();
            Intrinsics.checkNotNullExpressionValue(r35, "apiPerfDetails.commonTrace.keys()");
        L79:
            if (r35.hasNext() == false) goto L81;
            String r36 = r35.next();
            r10.put(r36, this.f4412d.getCommonTrace().get(r36));
            goto L79
        L81:
            Bundle r37 = this.f4420l;
            if (r37 == null) goto L84;
            ArrayList r38 = r37.getParcelableArrayList("tp_model");
        L85:
            LinkedHashMap r39 = new LinkedHashMap();
            if (r38 == null) goto L131;
            Iterator r40 = r38.iterator();
            long r41 = 0;
            long r110 = 0;
        L89:
            if (r40.hasNext() == false) goto L126;
            TimePair r42 = (TimePair) r40.next();
            LinkedHashMap r111 = new LinkedHashMap();
            LinkedHashMap r112 = new LinkedHashMap();
            if ((r42 instanceof TimePair) == true) goto L94;
            r42 = null;
        L94:
            if (r42 != null) goto L96;
        L109:
            Iterator r43 = r111.keySet().iterator();
        L111:
            if (r43.hasNext() == false) goto L125;
            String r113 = (String) r43.next();
            Integer r44 = (Integer) r111.get(r113);
            if (r44 == null) goto L115;
            int r45 = r44.intValue();
        L116:
            Long r46 = (Long) r112.get(r113);
            if (r46 == null) goto L119;
            long r47 = r46.longValue();
        L120:
            char[] r114 = new char[r12];
            r114[r11] = '@';
            List r115 = StringsKt.split$default(r113, r114, false, 0, 6, null);
            if (r115.size() != 3) goto L124;
            String r48 = (String) r115.get(r11);
            String r49 = (String) r115.get(1);
            String r116 = (String) r115.get(2);
            this.f4411c.put(r48 + "_version", r49);
            String r50 = r48 + '@' + r116;
            this.f4411c.put(r50 + "_count", r45);
            this.f4411c.put(r50 + "_time", r47);
            r39.put(r116, Long.valueOf(((Number) r39.getOrDefault(r116, 0L)).longValue() + r47));
        L124:
            r40 = r40;
            r43 = r43;
            r11 = 0;
            r12 = 1;
            goto L111
        L119:
            r47 = 0;
            goto L120
        L115:
            r45 = r11;
            goto L116
        L125:
            r41 = 0;
            goto L89
        L96:
            if (r42.getStart() != r41) goto L98;
        L108:
            Unit r51 = Unit.INSTANCE;
            goto L109
        L98:
            if (r42.getFinish() < r42.getStart()) goto L108;
            long r117 = r42.getFinish() - r42.getStart();
            r110 = r110 + r117;
            String r52 = r42.getKey();
            Integer r53 = (Integer) r111.get(r42.getKey());
            if (r53 == null) goto L102;
            int r54 = r53.intValue();
        L103:
            r111.put(r52, Integer.valueOf(r54 + r12));
            String r55 = r42.getKey();
            Long r56 = (Long) r112.get(r42.getKey());
            if (r56 == null) goto L106;
            long r57 = r56.longValue();
        L107:
            r112.put(r55, Long.valueOf(r57 + r117));
            goto L108
        L106:
            r57 = 0;
            goto L107
        L102:
            r54 = r11;
            goto L103
        L126:
            Unit r58 = Unit.INSTANCE;
            Iterator r59 = r39.entrySet().iterator();
        L128:
            if (r59.hasNext() == false) goto L130;
            Map.Entry r60 = (Map.Entry) r59.next();
            String r61 = (String) r60.getKey();
            r10.put("dur_vm_model_" + r61, ((Number) r60.getValue()).longValue());
            goto L128
        L130:
            r10.put("dur_vm_model_all", r110);
        L131:
            r10.put("get_vm_package", this.f4422n.getLong("get_vm_package"));
            r10.put("wait_vm_init", this.f4422n.getLong("wait_vm_init"));
            r10.put("wait_preinit_app", this.f4422n.getLong("wait_preinit_app"));
            r10.put("set_inr_watcher", this.f4422n.getLong("set_inr_watcher"));
            r10.put("split_vm_input", this.f4422n.getLong("split_vm_input"));
            if (this.f4422n.containsKey("session_retry_round") == false) goto L134;
            r10.put("session_retry_round", this.f4422n.getInt("session_retry_round"));
        L134:
            Integer r62 = this.f4425q;
            if (r62 == null) goto L137;
            r10.put("k_session_id", r62.intValue());
            Unit r63 = Unit.INSTANCE;
        L137:
            this.f4411c.put("trace_id", this.f4415g);
            return;
        L84:
            r38 = null;
            goto L85
        L25:
            r17 = r21;
            goto L26
        L13:
            if (r15.containsKey(ApiPerfDetails.FLAG_LOAD_MODEL) == false) goto L16;
            r10.put("vm_model_load", r15.getBoolean(ApiPerfDetails.FLAG_LOAD_MODEL));
        L16:
            if (r15.containsKey(ApiPerfDetails.FLAG_RUN_MODEL) == false) goto L19;
            r10.put("vm_run_model", r15.getBoolean(ApiPerfDetails.FLAG_RUN_MODEL));
        L19:
            if (r15.containsKey(ApiPerfDetails.FLAG_NEW_SERVICE) == false) goto L21;
            r10.put("vm_new_service", r15.getBoolean(ApiPerfDetails.FLAG_NEW_SERVICE));
        L21:
            Unit r64 = Unit.INSTANCE;
            goto L22
        }

        public final Bundle c() {
            return this.f4422n;
        }

        public final int d() {
            return this.f4417i;
        }

        public final String e() {
            return this.f4418j;
        }

        public final JSONObject f() {
            return this.f4411c;
        }
    }

    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class c extends AbstractCoroutineContextElement implements h0 {
        public c(h0.a r10) {
            super(r10);
        }

        @Override // kotlinx.coroutines.h0
        public void V(CoroutineContext r10, Throwable r11) {
            AIKLog.INSTANCE.e("trace-perf-track", r10 + " crashed " + ExceptionsKt.stackTraceToString(r11));
        }
    }

    static {
        f4406c = new a(null);
    }

    public RequestTracker(com.obric.aikernel.request.a r10) {
        Intrinsics.checkNotNullParameter(r10, "decor");
        this.f4407a = r10;
        this.f4408b = m0.a(new k0("api-tracer").plus(z0.b()).plus(q2.b(null, 1, null)).plus(new c(h0.f10523d)));
    }

    public static final /* synthetic */ com.obric.aikernel.request.a i(RequestTracker r10) {
        return r10.f4407a;
    }

    public static final /* synthetic */ Object j(RequestTracker r10, String r11, String r12, Function1 r13, Continuation r14) {
        return r10.k(r11, r12, r13, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> Object k(String r16, String r17, Function1<? super Continuation<? super Pair<? extends T, ? extends Function1<? super T, b>>>, ? extends Object> r18, Continuation<? super T> r19) {
        RequestTracker r10 = this;
        if ((r19 instanceof RequestTracker$trackBizCall$1) == false) goto L7;
        RequestTracker$trackBizCall$1 r11 = (RequestTracker$trackBizCall$1) r19;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        boolean r20 = true;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        long r21 = r11.J$0;
        Ref.BooleanRef r22 = (Ref.BooleanRef) r11.L$5;
        Ref.ObjectRef r23 = (Ref.ObjectRef) r11.L$4;
        Ref.ObjectRef r24 = (Ref.ObjectRef) r11.L$3;
        String r25 = (String) r11.L$2;
        String r26 = (String) r11.L$1;
        RequestTracker r27 = (RequestTracker) r11.L$0;
        ResultKt.throwOnFailure(r13);
        Ref.BooleanRef r28 = r22;
        r10 = r27;
        Object r29 = r13;
        Ref.ObjectRef r30 = r23;
        String r31 = r26;
        Ref.ObjectRef r32 = r24;
        long r33 = r21;
    L18:
        Pair r34 = (Pair) r29;
        T r110 = (T) r34.getFirst();
        r32.element = r110;
        if ((r110 instanceof com.obric.aikernel.request.b) == false) goto L21;
        r20 = ((com.obric.aikernel.request.b) r110).f();
    L21:
        r28.element = r20;
        r30.element = (T) r34.getSecond();
        long r111 = System.currentTimeMillis() - r33;
        if (r28.element == false) goto L25;
        AIKLog.INSTANCE.i("trace-perf-track", r31 + ' ' + r25 + " cost " + r111 + " ms");
        h.d(r10.f4408b, null, null, new RequestTracker$trackBizCall$2((b) ((Function1) r30.element).invoke(r32.element), r111, null), 3, null);
    L25:
        return r32.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        Ref.ObjectRef r35 = new Ref.ObjectRef();
        Ref.ObjectRef r36 = new Ref.ObjectRef();
        r28 = new Ref.BooleanRef();
        long r37 = System.currentTimeMillis();
        r11.L$0 = r10;
        r31 = r16;
        r11.L$1 = r31;
        r11.L$2 = r17;
        r11.L$3 = r35;
        r11.L$4 = r36;
        r11.L$5 = r28;
        r11.J$0 = r37;
        r11.label = 1;
        r29 = r18.invoke(r11);
        if (r29 != r14) goto L17;
        return r14;
    L17:
        r30 = r36;
        r32 = r35;
        r33 = r37;
        r25 = r17;
    L7:
        r11 = new RequestTracker$trackBizCall$1(this, r19);
        goto L8
    }

    @Override // com.obric.aikernel.request.a
    public Object a(String r10, RequestParams r11, Continuation<? super com.obric.aikernel.request.b> r12) {
        return TimerLogger.f4838a.b("InferEntry", "getPackageUpdateProgress " + r10, new RequestTracker$getPackageUpdateProgress$2(this, r10, r11, null), r12);
    }

    @Override // com.obric.aikernel.request.a
    public Object b(String r10, RequestParams r11, Continuation<? super PackageResource> r12) {
        return TimerLogger.f4838a.b("updatePackage", r10, new RequestTracker$updatePackage$4(this, r10, r11, null), r12);
    }

    @Override // com.obric.aikernel.request.a
    public Object c(List<String> r10, RequestParams r11, com.obric.aikernel.b r12, Continuation<? super com.obric.aikernel.request.b> r13) {
        TimerLogger.Companion r14 = TimerLogger.f4838a;
        return r14.b("InferEntry", "getPackages " + r14.a(r10), new RequestTracker$getPackage$2(r10, this, r11, r12, null), r13);
    }

    @Override // com.obric.aikernel.request.a
    public Object d(String r10, RequestParams r11, com.obric.aikernel.b r12, Continuation<? super com.obric.aikernel.request.b> r13) {
        return k("unloadPackage", r10, new RequestTracker$unloadPackage$2(this, r10, r11, r12, "unloadPackage", null), r13);
    }

    @Override // com.obric.aikernel.request.a
    public Object e(String r10, RequestParams r11, Continuation<? super PackageResource> r12) {
        return TimerLogger.f4838a.b("getPackage", r10, new RequestTracker$getPackage$4(this, r10, r11, null), r12);
    }

    @Override // com.obric.aikernel.request.a
    public Object f(List<String> r10, RequestParams r11, com.obric.aikernel.b r12, Continuation<? super com.obric.aikernel.request.b> r13) {
        TimerLogger.Companion r14 = TimerLogger.f4838a;
        return r14.b("InferEntry", "updatePackages " + r14.a(r10), new RequestTracker$updatePackage$2(r10, this, r11, r12, null), r13);
    }

    @Override // com.obric.aikernel.request.a
    public Object g(String r10, RequestParams r11, com.obric.aikernel.b r12, Continuation<? super com.obric.aikernel.request.b> r13) {
        return k("runPackage", r10, new RequestTracker$runPackage$2(this, r10, r11, r12, "runPackage", null), r13);
    }

    @Override // com.obric.aikernel.request.a
    public Object h(String r10, RequestParams r11, com.obric.aikernel.b r12, Continuation<? super com.obric.aikernel.request.b> r13) {
        return k("loadPackage", r10, new RequestTracker$loadPackage$2(this, r10, r11, r12, "loadPackage", null), r13);
    }
}
