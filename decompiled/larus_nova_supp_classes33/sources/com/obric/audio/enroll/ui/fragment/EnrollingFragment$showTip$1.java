package com.obric.audio.enroll.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.audio.impl.databinding.SvaEnrollingFragmentBinding;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$showTip$1", f = "EnrollingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EnrollingFragment$showTip$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CountDownLatch $countDownLatch;
    final /* synthetic */ Ref.BooleanRef $errorTip;
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ EnrollingFragment this$0;

    public EnrollingFragment$showTip$1(Ref.BooleanRef r1, EnrollingFragment r2, String r3, CountDownLatch r4, Continuation<? super EnrollingFragment$showTip$1> r5) {
        this.$errorTip = r1;
        this.this$0 = r2;
        this.$text = r3;
        this.$countDownLatch = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new EnrollingFragment$showTip$1(this.$errorTip, this.this$0, this.$text, this.$countDownLatch, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [com.obric.audio.enroll.ui.fragment.e0, java.lang.Object] */
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r10);
        if (this.$errorTip.element == false) goto L14;
        Context r11 = this.this$0.getContext();
        if (r11 == null) goto L10;
        ria.a.a(r11);
    L10:
        if (this.this$0.j != EnrollingFragment.TipState.ERROR) goto L12;
        SvaEnrollingFragmentBinding r12 = this.this$0.e;
        Intrinsics.checkNotNull(r12);
        r12.b.setText(this.$text);
    L17:
        this.$countDownLatch.countDown();
        return Unit.INSTANCE;
    L12:
        this.this$0.j = EnrollingFragment.TipState.CHANGING;
        SvaEnrollingFragmentBinding r13 = this.this$0.e;
        Intrinsics.checkNotNull(r13);
        r13.b.setText(this.$text);
        SvaEnrollingFragmentBinding r14 = this.this$0.e;
        Intrinsics.checkNotNull(r14);
        r14.g.animate().alpha(0.0f).setDuration(200).start();
        SvaEnrollingFragmentBinding r15 = this.this$0.e;
        Intrinsics.checkNotNull(r15);
        AppCompatTextView r16 = r15.b;
        final EnrollingFragment r0 = this.this$0;
        ?? r3 = new e0(r0);
        int r1 = jia.b.a;
        Intrinsics.checkNotNullParameter(r16, "view");
        Intrinsics.checkNotNullParameter(r3, "end");
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r16, "alpha", new float[]{0.0f, 1.0f});
        r4.setDuration(200);
        r4.setInterpolator(new LinearInterpolator());
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r16, "alpha", new float[]{1.0f, 0.1f});
        r6.setStartDelay(100);
        r6.setDuration(200);
        r6.setInterpolator(new LinearInterpolator());
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r16, "alpha", new float[]{0.1f, 1.0f});
        r17.setDuration(200);
        r17.setInterpolator(new LinearInterpolator());
        Intrinsics.checkNotNull(r17);
        r17.addListener(new jia.a(r3));
        AnimatorSet r2 = new AnimatorSet();
        r2.playSequentially(new Animator[]{r4, r6, r17});
        r2.start();
        goto L17
    L14:
        if (this.this$0.j != EnrollingFragment.TipState.NORMAL) goto L16;
        SvaEnrollingFragmentBinding r18 = this.this$0.e;
        Intrinsics.checkNotNull(r18);
        r18.g.setText(this.$text);
        goto L17
    L16:
        this.this$0.j = EnrollingFragment.TipState.CHANGING;
        SvaEnrollingFragmentBinding r19 = this.this$0.e;
        Intrinsics.checkNotNull(r19);
        r19.g.setText(this.$text);
        SvaEnrollingFragmentBinding r110 = this.this$0.e;
        Intrinsics.checkNotNull(r110);
        ViewPropertyAnimator r111 = r110.g.animate().alpha(1.0f).setDuration(200);
        final EnrollingFragment r5 = this.this$0;
        ViewPropertyAnimator r112 = r111.withEndAction(new f0(r5));
        SvaEnrollingFragmentBinding r7 = this.this$0.e;
        Intrinsics.checkNotNull(r7);
        r7.b.animate().alpha(0.0f).setDuration(200).start();
        r112.start();
        goto L17
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
