package com.larus.dora.obric.device_management.explore;

import android.animation.Animator;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.LottieAnimationView;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.explore.DoraObricGlassesBasicDetailFragment$bindDetailLottie$1", f = "DoraObricGlassesBasicDetailFragment.kt", i = {0}, l = {1143}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class DoraObricGlassesBasicDetailFragment$bindDetailLottie$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatImageView $coverView;
    final /* synthetic */ String $localPath;
    final /* synthetic */ File $lottieFile;
    final /* synthetic */ LottieAnimationView $lottieView;
    final /* synthetic */ boolean $manualPlay;
    final /* synthetic */ View $playButton;
    final /* synthetic */ boolean $showFallbackCover;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ AppCompatImageView a;
        public final /* synthetic */ View b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ LottieAnimationView d;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.c == false) goto L8;
            this.d.setProgress(0.0f);
            View r3 = this.b;
            if (r3 == null) goto L9;
            r3.setVisibility(0);
            return;
        L9:
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setVisibility(8);
            View r3 = this.b;
            if (r3 == null) goto L6;
            r3.setVisibility(8);
            return;
        }

        public a(AppCompatImageView r1, View r2, boolean r3, LottieAnimationView r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public DoraObricGlassesBasicDetailFragment$bindDetailLottie$1(AppCompatImageView r1, boolean r2, LottieAnimationView r3, String r4, File r5, boolean r6, View r7, Continuation<? super DoraObricGlassesBasicDetailFragment$bindDetailLottie$1> r8) {
        this.$coverView = r1;
        this.$showFallbackCover = r2;
        this.$lottieView = r3;
        this.$localPath = r4;
        this.$lottieFile = r5;
        this.$manualPlay = r6;
        this.$playButton = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        DoraObricGlassesBasicDetailFragment$bindDetailLottie$1 r9 = new DoraObricGlassesBasicDetailFragment$bindDetailLottie$1(this.$coverView, this.$showFallbackCover, this.$lottieView, this.$localPath, this.$lottieFile, this.$manualPlay, this.$playButton, r12);
        r9.L$0 = r11;
        return r9;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r13);
    L11:
        String r14 = (String) r13;
        int r4 = 0;
        if (r14 != null) goto L14;
    L17:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L27;
        AppCompatImageView r15 = this.$coverView;
        if (this.$showFallbackCover == true) goto L24;
        r4 = 8;
    L24:
        r15.setVisibility(r4);
        return Unit.INSTANCE;
    L27:
        if (this.$lottieView.getParent() != null) goto L30;
        g49.d.e("DoraObricGlassesBasicDetailFragment", "skip media detail lottie because view is detached: path=" + this.$localPath);
        return Unit.INSTANCE;
    L30:
        LottieAnimationView r6 = this.$lottieView;
        File r7 = this.$lottieFile;
        boolean r8 = this.$manualPlay;
        final View r9 = this.$playButton;
        final AppCompatImageView r10 = this.$coverView;
        boolean r11 = this.$showFallbackCover;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L47
        r6.cancelAnimation();     // Catch: Throwable -> L47
        r6.removeAllAnimatorListeners();     // Catch: Throwable -> L47
        r6.setImageAssetsFolder(null);     // Catch: Throwable -> L47
        if (r11 == false) goto L34;
        final boolean r16 = true;
    L35:
        r6.setFailureListener(new w(r10, r16, r9));     // Catch: Throwable -> L47
        if (r8 == true) goto L39;
        r3 = false;
    L39:
        r6.addAnimatorListener(new a(r10, r9, r3, r6));     // Catch: Throwable -> L47
        r6.setAnimationFromJson(r14, r7.getAbsolutePath());     // Catch: Throwable -> L47
        if (r8 == false) goto L44;
        r6.setProgress(0.0f);     // Catch: Throwable -> L47
        r6.pauseAnimation();     // Catch: Throwable -> L47
        if (r9 == null) goto L45;
        r9.setVisibility(0);     // Catch: Throwable -> L47
    L45:
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        AppCompatImageView r18 = this.$coverView;
        boolean r20 = this.$showFallbackCover;
        View r21 = this.$playButton;
        Throwable r110 = Result.exceptionOrNull-impl(r17);
        if (r110 == null) goto L59;
        g49.d.b("DoraObricGlassesBasicDetailFragment", "play media detail lottie failed: " + r110.getMessage());
        if (r20 == true) goto L55;
        r4 = 8;
    L55:
        r18.setVisibility(r4);
        if (r21 == null) goto L59;
        r21.setVisibility(8);
    L59:
        return Unit.INSTANCE;
    L44:
        r6.playAnimation();     // Catch: Throwable -> L47
        goto L45
    L34:
        r16 = false;
    L47:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L14:
        if (StringsKt.isBlank(r14) == true) goto L17;
        r5 = false;
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        CoroutineDispatcher r23 = Dispatchers.getIO();
        DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1 r24 = new DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1(this.$lottieFile, null);
        this.L$0 = r111;
        this.label = 1;
        r13 = BuildersKt.withContext(r23, r24, this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
