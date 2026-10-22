package com.larus.camera.impl.ui.component.generalonly;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.larus.camera.impl.ui.component.generalonly.CaptureCameraTipsComponent$setupTips$1$1", f = "CaptureCameraTipsComponent.kt", i = {0, 0}, l = {115}, m = "invokeSuspend", n = {"fadeOutAnimation", "recorderTips"}, s = {"L$0", "L$1"})
final class CaptureCameraTipsComponent$setupTips$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ q this$0;

    public static final class a implements Animation.AnimationListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ q b;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            this.a.setVisibility(8);
            q.p(this.b);
        }

        public a(TextView r1, q r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public CaptureCameraTipsComponent$setupTips$1$1(q r1, Continuation<? super CaptureCameraTipsComponent$setupTips$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CaptureCameraTipsComponent$setupTips$1$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        TextView r2 = (TextView) this.L$1;
        Animation r3 = (Animation) this.L$0;
        ResultKt.throwOnFailure(r8);
    L19:
        r3.setAnimationListener(new a(r2, this.this$0));
        r2.startAnimation(r3);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        if (zx8.b.e == true) goto L11;
    L13:
        boolean r9 = false;
    L14:
        if (r9 == false) goto L20;
        q r10 = this.this$0;
        int r4 = q.t;
        Animation r11 = AnimationUtils.loadAnimation(r10.getContext(), 2130772386);
        TextView r5 = (TextView) this.this$0.h(2131365103);
        e1.x(r5);
        FLogger.a.i("CameraRecordConfigManager", "tipsHasShown");
        zx8.b.e = false;
        this.L$0 = r11;
        this.L$1 = r5;
        this.label = 1;
        if (DelayKt.delay(5000, this) != r0) goto L18;
        return r0;
    L18:
        r3 = r11;
        r2 = r5;
        goto L19
    L20:
        q.p(this.this$0);
        goto L22
    L11:
        if (zx8.b.b() == false) goto L13;
        r9 = true;
        goto L14
    }
}
