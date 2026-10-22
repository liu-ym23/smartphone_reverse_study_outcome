package com.larus.camera.impl.ui.component.result.general;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultMarkedTipsComponent$hideMarkedTipsWithAnimation$1", f = "ResultMarkedTipsComponent.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
final class ResultMarkedTipsComponent$hideMarkedTipsWithAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ p this$0;

    public static final class a implements Animation.AnimationListener {
        public final /* synthetic */ p a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public a(p r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            p r3 = this.a;
            int r0 = p.o;
            com.larus.utils.e1.o(r3.p());
            this.a.p().setAlpha(1.0f);
        }
    }

    public ResultMarkedTipsComponent$hideMarkedTipsWithAnimation$1(p r1, Continuation<? super ResultMarkedTipsComponent$hideMarkedTipsWithAnimation$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ResultMarkedTipsComponent$hideMarkedTipsWithAnimation$1(this.this$0, r3);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        p r7 = this.this$0;
        int r3 = p.o;
        if (r7.p().getVisibility() == 0) goto L15;
        r2 = false;
    L15:
        if (r2 == false) goto L17;
        AlphaAnimation r8 = new AlphaAnimation(1.0f, 0.0f);
        r8.setDuration(500);
        r8.setAnimationListener(new a(this.this$0));
        this.this$0.p().startAnimation(r8);
        return Unit.INSTANCE;
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(5000, this) != r0) goto L11;
        return r0;
    }
}
