package com.larus.bmhome.view.actionbar.custom;

import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBarNormalHolder$handleLottieJob$1$3", f = "CustomActionBarHolder.kt", i = {}, l = {274}, m = "invokeSuspend", n = {}, s = {})
final class CustomActionBarNormalHolder$handleLottieJob$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $data;
    int label;
    final /* synthetic */ CustomActionBarNormalHolder this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CustomActionBarNormalHolder a;
        public final /* synthetic */ com.larus.bmhome.actionbar.model.z0 b;

        public a(CustomActionBarNormalHolder r1, com.larus.bmhome.actionbar.model.z0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r3, Continuation r4) {
            boolean r5 = ((Boolean) r3).booleanValue();
            FLogger.a.d("CustomActionBarNormalHolder", "voiceInputStatusFlow status = " + r5);
            if (CustomActionBarNormalHolder.U3(this.a, this.b) == false) goto L6;
            this.a.b4(this.b, r5);
            this.a.c4(this.b, false);
        L6:
            return Unit.INSTANCE;
        }
    }

    public CustomActionBarNormalHolder$handleLottieJob$1$3(CustomActionBarNormalHolder r1, com.larus.bmhome.actionbar.model.z0 r2, Continuation<? super CustomActionBarNormalHolder$handleLottieJob$1$3> r3) {
        this.this$0 = r1;
        this.$data = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CustomActionBarNormalHolder$handleLottieJob$1$3(this.this$0, this.$data, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L18;
        r7.N();
        kotlinx.coroutines.flow.i1 r8 = com.larus.home.impl.sdk.n1.a.u();
        if (r8 == null) goto L18;
        a r2 = new a(this.this$0, this.$data);
        this.label = 1;
        if (r8.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
