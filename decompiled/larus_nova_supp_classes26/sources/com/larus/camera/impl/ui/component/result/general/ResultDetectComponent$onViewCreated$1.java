package com.larus.camera.impl.ui.component.result.general;

import android.widget.FrameLayout;
import com.larus.camera.impl.databinding.LarusLayoutViewResultDetectComponentBinding;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "status", "Lcom/larus/camera/impl/ui/component/result/general/ResultDetectStatus;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultDetectComponent$onViewCreated$1", f = "ResultDetectComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultDetectComponent$onViewCreated$1 extends SuspendLambda implements Function2<n, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultDetectComponent this$0;

    public ResultDetectComponent$onViewCreated$1(ResultDetectComponent r1, Continuation<? super ResultDetectComponent$onViewCreated$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultDetectComponent$onViewCreated$1 r0 = new ResultDetectComponent$onViewCreated$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(n r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((n) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r12);
        n r13 = (n) this.L$0;
        FLogger.a.i("ResultDetectComponent", "[captureDetectionStatus] update " + r13);
        final boolean r2 = true;
        if ((r13 instanceof n.a) == false) goto L16;
        ResultDetectComponent r0 = this.this$0;
        ix8.d r14 = ((n.a) r13).a;
        int r15 = ResultDetectComponent.p;
        LarusLayoutViewResultDetectComponentBinding r16 = r0.m;
        if (r16 == null) goto L11;
        FrameLayout r17 = r16.a;
        if (r17 == null) goto L11;
        final boolean r4 = false;
        r17.setOnTouchListener(new l(r4));
    L11:
        Job r18 = r0.n;
        if (r18 == null) goto L14;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);
    L14:
        BuildersKt.launch$default(r0.k(), null, null, new ResultDetectComponent$stopDetectAnimation$1(r0, null), 3, null);
    L29:
        return Unit.INSTANCE;
    L16:
        if (Intrinsics.areEqual(r13, n.b.a) == false) goto L23;
        ResultDetectComponent r19 = this.this$0;
        int r1 = ResultDetectComponent.p;
        LarusLayoutViewResultDetectComponentBinding r110 = r19.m;
        if (r110 == null) goto L29;
        FrameLayout r111 = r110.a;
        if (r111 == null) goto L29;
        r111.setOnTouchListener(new l(r2));
        goto L29
    L23:
        if (Intrinsics.areEqual(r13, n.c.a) == false) goto L31;
        ResultDetectComponent r112 = this.this$0;
        long r3 = ((oq9.j) r112.o.getValue()).e();
        Job r5 = r112.n;
        if (r5 == null) goto L27;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L27:
        r112.n = BuildersKt.launch$default(r112.k(), Dispatchers.getDefault(), null, new ResultDetectComponent$launchStartLoadingAnimationJob$1(r3, r112, null), 2, null);
        goto L29
    L31:
        throw new NoWhenBranchMatchedException();
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
