package com.obric.aikernel.request.track;

import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.aikernel.runtime.utils.RuntimeMetrics;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.request.track.VMStartupInfo$report$1", f = "VMStartupInfo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VMStartupInfo$report$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $duration;
    final /* synthetic */ long $startMills;
    int label;

    VMStartupInfo$report$1(long r10, long r11, Continuation<? super VMStartupInfo$report$1> r12) {
        this.$duration = r10;
        this.$startMills = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new VMStartupInfo$report$1(this.$duration, this.$startMills, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((VMStartupInfo$report$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r10);
        TrackerApi r11 = TrackerApi.INSTANCE;
        JSONObject r12 = new JSONObject();
        long r13 = this.$duration;
        long r14 = this.$startMills;
        r12.put("duration", r13);
        VMStartupInfo r15 = VMStartupInfo.f4878a;
        long r16 = r15.d();
        AppContext r17 = AppContext.INSTANCE;
        r12.put("init_delay", r16 - r17.getAppStartTime());
        if (VMStartupInfo.c() <= 0) goto L7;
        r12.put("vm_init_time", VMStartupInfo.c() - r14);
    L7:
        r12.put("is_first_cold_boot", com.obric.aikernel.utils.a.c(Boxing.boxBoolean(r17.isFirstColdBoot())));
        Long r18 = Boxing.boxLong(VMStartupInfo.b() - r14);
        if (r18.longValue() <= 0) goto L10;
        boolean r19 = true;
    L11:
        if (r19 == true) goto L14;
        r18 = null;
    L14:
        if (r18 == null) goto L18;
        r12.put("res_init_time", r18.longValue());
        if (VMStartupInfo.a() <= 0) goto L18;
        r12.put("res_load_count", VMStartupInfo.a());
    L18:
        r12.put("dur_get_infer_binder", r15.g() - r15.h());
        r12.put("dur_init_runtime_service", r15.m() - r15.n());
        r12.put("dur_init_infer_runtime", r15.i() - r15.j());
        r12.put("dur_builder_runtime_config", r15.k() - r15.l());
        r12.put("dur_init_fbe", r15.e() - r15.f());
        RuntimeMetrics r20 = RuntimeMetrics.f5408a;
        r12.put("dur_init_engine_res", r20.a() - r20.b());
        r12.put("dur_init_add_package", r20.c() - r20.d());
        r12.put("dur_init_res_manager", r20.e() - r20.f());
        Unit r21 = Unit.INSTANCE;
        r11.onEvent("vm_init_event", r12);
        return r21;
    L10:
        r19 = false;
        goto L11
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
