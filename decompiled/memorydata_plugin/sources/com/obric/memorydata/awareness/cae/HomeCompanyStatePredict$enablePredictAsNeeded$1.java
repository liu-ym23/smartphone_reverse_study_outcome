package com.obric.memorydata.awareness.cae;

import android.os.Handler;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "ready", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.awareness.cae.HomeCompanyStatePredict$enablePredictAsNeeded$1", f = "HomeCompanyStatePredict.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HomeCompanyStatePredict$enablePredictAsNeeded$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ f this$0;

    HomeCompanyStatePredict$enablePredictAsNeeded$1(f r3, Continuation<? super HomeCompanyStatePredict$enablePredictAsNeeded$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    private static final void invokeSuspend$lambda$0(f r0) {
        r0.f();
    }

    public static /* synthetic */ void lambda$3D_swb6YFNXHLazy1U0stTOOebE(f r0) {
        invokeSuspend$lambda$0(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        HomeCompanyStatePredict$enablePredictAsNeeded$1 r0 = new HomeCompanyStatePredict$enablePredictAsNeeded$1(this.this$0, r5);
        r0.Z$0 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Boolean r3, Continuation<? super Unit> r4) {
        return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(boolean r3, Continuation<? super Unit> r4) {
        Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return ((HomeCompanyStatePredict$enablePredictAsNeeded$1) ZeusTransformUtils.preCheckCast(create(Boolean.valueOf(r3), r5), HomeCompanyStatePredict$enablePredictAsNeeded$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r9);
        if (this.Z$0 == false) goto L11;
        String r1 = null;
        f.a(this.this$0, null, 1, null);
        Handler r10 = f.a(this.this$0);
        final f r8 = this.this$0;
        r10.post(new $$Lambda$HomeCompanyStatePredict$enablePredictAsNeeded$1$3D_swb6YFNXHLazy1U0stTOOebE(r8));
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r11 = new StringBuilder().append("service is ready, currentFence: ");
        StarGeofence r12 = f.h();
        if (r12 == null) goto L9;
        r1 = r12.getGeofenceId();
    L9:
        IRunLog.a.a(r2, "HomeCompanyStatePredict", r11.append(r1).toString(), false, 4, null);
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
