package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.device.DoraDevice;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraHSimplifiedInterruptBinding;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020'2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010.\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020#H\u0016J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020%H\u0016J\b\u00102\u001a\u00020#H\u0002J\u0012\u00103\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u00104\u001a\u00020#H\u0002J\u0010\u00105\u001a\u00020#2\u0006\u00101\u001a\u00020%H\u0002J\b\u00106\u001a\u00020#H\u0002J\b\u00107\u001a\u00020#H\u0002J\b\u00108\u001a\u00020#H\u0002J\b\u00109\u001a\u00020#H\u0002J\b\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020#H\u0002J\b\u0010<\u001a\u00020#H\u0002J\u0010\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0018H\u0002J \u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020G2\u0006\u0010C\u001a\u00020\u0018H\u0002J\b\u0010H\u001a\u00020#H\u0002J\b\u0010I\u001a\u00020#H\u0002J\u0010\u0010J\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010K\u001a\u00020\u00182\u0006\u0010>\u001a\u00020?H\u0002J\u0012\u0010L\u001a\u0004\u0018\u00010\u001f2\u0006\u0010A\u001a\u00020BH\u0002J\u001a\u0010M\u001a\u00020#2\b\u0010N\u001a\u0004\u0018\u00010'2\u0006\u0010O\u001a\u00020\u0018H\u0002J\u0010\u0010P\u001a\u00020#2\u0006\u0010O\u001a\u00020\u0018H\u0002J\b\u0010Q\u001a\u00020#H\u0002J\b\u0010R\u001a\u00020#H\u0002J\b\u0010S\u001a\u00020#H\u0002J\b\u0010T\u001a\u00020#H\u0002J\b\u0010U\u001a\u00020#H\u0002J\b\u0010V\u001a\u00020#H\u0002J\b\u0010W\u001a\u00020#H\u0002J\b\u0010X\u001a\u00020YH\u0002J\b\u0010Z\u001a\u00020#H\u0016J\b\u0010[\u001a\u00020#H\u0016J\b\u0010\\\u001a\u00020\u001fH\u0016J\b\u0010]\u001a\u00020\u001fH\u0016J\b\u0010^\u001a\u00020\u0018H\u0002J\u0014\u0010_\u001a\u00020#*\u00020?2\u0006\u00101\u001a\u00020%H\u0002J\u000e\u0010`\u001a\u0004\u0018\u00010?*\u00020%H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedInterruptFragment;", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingBaseFragment;", "<init>", "()V", "simplifiedModel", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "getSimplifiedModel", "()Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "simplifiedModel$delegate", "Lkotlin/Lazy;", "_binding", "Lcom/larus/dora/impl/databinding/LarusDoraHSimplifiedInterruptBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraHSimplifiedInterruptBinding;", "navBackButton", "Landroidx/appcompat/widget/AppCompatImageView;", "getNavBackButton", "()Landroidx/appcompat/widget/AppCompatImageView;", "backgroundFadeAnimator", "Landroid/animation/ValueAnimator;", "cachedTypewriterExpandedHeight", "", "hasRevealedTypewriterContent", "", "hasConsumedInterruptEntryAnimation", "shouldPlayDeferredReplyEntryAnimation", "latestRenderedReplyRoundToken", "", "Ljava/lang/Long;", "latestRenderedReplyText", "", "interruptMvVideoPath", "interruptMvCoverPath", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "onSaveInstanceState", "outState", "setupTypewriterTextColor", "restoreInterruptUiStateIfNeeded", "restoreInterruptContentOnResume", "saveInterruptUiState", "restoreInterruptMvPlaybackOnResume", "prepareTypewriterContainerForSharedElement", "cacheExpandedTypewriterHeightIfNeeded", "applyFixedTypewriterHeightForSharedElement", "scheduleTypewriterContentRevealFallback", "setupInterruptMv", "setupObservers", "renderInterruptUiState", "state", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedInterruptUiState;", "renderQueryState", "queryState", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/StreamlinedQueryUiState;", "shouldPrepareEntryAnimation", "renderReplyState", "roundToken", "replyState", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/StreamlinedReplyUiState;", "startReplyLoadingIndicator", "stopReplyLoadingIndicator", "consumeEntryAnimationIfNeeded", "shouldPrepareWindowEntryAnimation", "resolveQueryText", "playEntryAnimation", "target", "shouldAnimate", "playReplyEntryAnimation", "setupBackButton", "hideBackButton", "setupListeners", "animateStaticContent", "animateEnterOverlayIfNeeded", "animateBackgroundFadeIn", "revealTypewriterContentAfterSharedElement", "buildSharedElementEnterTransition", "Landroid/transition/Transition;", "onDestroyView", "onSkipButtonClicked", "getCurrentPageName", "getCurrentCardName", "isUsingSharedElementTransition", "putIntoBundle", "toInterruptUiState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraHStreamlinedInterruptFragment extends DoraExternalOnboardingBaseFragment {
    public static final float z = 0.0f;
    public final Lazy o;
    public LarusDoraHSimplifiedInterruptBinding p;
    public ValueAnimator q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public Long v;
    public String w;
    public String x;
    public String y;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ DoraHStreamlinedInterruptFragment c;

        public b(View r1, boolean r2, DoraHStreamlinedInterruptFragment r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            boolean r5 = true;
            if (this.b == false) goto L105;
            DoraHStreamlinedInterruptFragment r0 = this.c;
            float r7 = DoraHStreamlinedInterruptFragment.z;
            Bundle r8 = r0.getArguments();
            if (r8 != null) goto L7;
        L9:
            boolean r9 = false;
        L10:
            ViewGroup.LayoutParams r10 = null;
            if (r9 == true) goto L49;
            LarusDoraHSimplifiedInterruptBinding r11 = r0.p;
            if (r11 == null) goto L49;
            FrameLayout r12 = r11.i;
            if (r12 == null) goto L49;
            AppCompatTextView r13 = r11.k;
            if (r13 == null) goto L49;
            SimpleDraweeView r14 = r11.h;
            if (r14 == null) goto L49;
            int r15 = RangesKt.coerceAtLeast(r13.getMaxLines(), 1);
            float r16 = (r13.getLineHeight() * r15) + (r13.getLineSpacingExtra() * (r15 - 1));
            ViewGroup.LayoutParams r17 = r13.getLayoutParams();
            if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
            ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        L28:
            ViewGroup.LayoutParams r110 = r14.getLayoutParams();
            if ((r110 instanceof ViewGroup.MarginLayoutParams) == false) goto L31;
            ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        L32:
            int r112 = (int) r16;
            if (r18 == null) goto L35;
            int r113 = r18.topMargin;
        L36:
            int r114 = r112 + r113;
            if (r18 == null) goto L39;
            int r115 = r18.bottomMargin;
        L40:
            int r116 = r114 + r115;
            int r20 = RangesKt.coerceAtLeast(r14.getHeight(), r14.getMinimumHeight());
            if (r111 == null) goto L43;
            int r117 = r111.topMargin;
        L44:
            int r21 = r20 + r117;
            if (r111 == null) goto L47;
            int r118 = r111.bottomMargin;
        L48:
            r0.r = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast((Math.max(r116, r21 + r118) + r12.getPaddingTop()) + r12.getPaddingBottom(), r12.getMinimumHeight()), c7.b(48));
            goto L49
        L47:
            r118 = 0;
            goto L48
        L43:
            r117 = 0;
            goto L44
        L39:
            r115 = 0;
            goto L40
        L35:
            r113 = 0;
            goto L36
        L31:
            r111 = null;
            goto L32
        L27:
            r18 = null;
        L49:
            DoraHStreamlinedInterruptFragment r1 = this.c;
            Bundle r22 = r1.getArguments();
            if (r22 != null) goto L52;
        L54:
            boolean r23 = false;
        L55:
            if (r23 == true) goto L73;
            Integer r24 = Integer.valueOf(r1.r);
            if (r24.intValue() <= 0) goto L60;
            boolean r25 = true;
        L61:
            if (r25 == true) goto L64;
            r24 = null;
        L64:
            if (r24 == null) goto L73;
            int r26 = r24.intValue();
            LarusDoraHSimplifiedInterruptBinding r2 = r1.p;
            if (r2 == null) goto L73;
            FrameLayout r3 = r2.i;
            if (r3 == null) goto L73;
            ViewGroup.LayoutParams r27 = r3.getLayoutParams();
            if (r27 == null) goto L72;
            r27.height = r26;
            r10 = r27;
        L72:
            r3.setLayoutParams(r10);
            goto L73
        L60:
            r25 = false;
        L73:
            this.c.startPostponedEnterTransition();
            final DoraHStreamlinedInterruptFragment r4 = this.c;
            Bundle r28 = r4.getArguments();
            if (r28 != null) goto L76;
        L78:
            boolean r30 = false;
        L79:
            if (r30 == true) goto L86;
            LarusDoraHSimplifiedInterruptBinding r31 = r4.p;
            if (r31 == null) goto L86;
            FrameLayout r32 = r31.i;
            if (r32 == null) goto L86;
            r32.postDelayed(new h(r4), 520);
        L86:
            DoraHStreamlinedInterruptFragment r6 = this.c;
            Bundle r33 = r6.getArguments();
            if (r33 != null) goto L89;
        L91:
            boolean r34 = false;
        L92:
            if (r34 == true) goto L105;
            LarusDoraHSimplifiedInterruptBinding r35 = r6.p;
            if (r35 == null) goto L105;
            ConstraintLayout r36 = r35.a;
            if (r36 == null) goto L105;
            ViewPropertyAnimator r37 = r36.animate();
            if (r37 == null) goto L105;
            ViewPropertyAnimator r38 = r37.alpha(1.0f);
            if (r38 == null) goto L105;
            ViewPropertyAnimator r40 = r38.setDuration(300);
            if (r40 == null) goto L105;
            r40.start();
            goto L105
        L89:
            if (r33.getBoolean("arg_is_from_skip") != true) goto L91;
            r34 = true;
            goto L92
        L76:
            if (r28.getBoolean("arg_is_from_skip") != true) goto L78;
            r30 = true;
            goto L79
        L52:
            if (r22.getBoolean("arg_is_from_skip") != true) goto L54;
            r23 = true;
            goto L55
        L7:
            if (r8.getBoolean("arg_is_from_skip") != true) goto L9;
            r9 = true;
        L105:
            DoraHStreamlinedInterruptFragment r41 = this.c;
            float r42 = DoraHStreamlinedInterruptFragment.z;
            Bundle r43 = r41.getArguments();
            if (r43 != null) goto L108;
        L110:
            r5 = false;
        L111:
            if (r5 == false) goto L125;
            LarusDoraHSimplifiedInterruptBinding r44 = r41.p;
            if (r44 == null) goto L125;
            ConstraintLayout r45 = r44.a;
            if (r45 == null) goto L125;
            Drawable r46 = r45.getBackground();
            if (r46 == null) goto L125;
            final Drawable r47 = r46.mutate();
            if (r47 == null) goto L125;
            ValueAnimator r48 = r41.q;
            if (r48 == null) goto L124;
            r48.cancel();
        L124:
            ValueAnimator r50 = ValueAnimator.ofInt(new int[]{0, 255});
            r50.setDuration(300);
            r50.addUpdateListener(new f(r47));
            r50.start();
            r41.q = r50;
        L125:
            LarusDoraHSimplifiedInterruptBinding r51 = r41.p;
            if (r51 == null) goto L130;
            VideoPlayView r52 = r51.b;
            if (r52 == null) goto L130;
            r52.setAlpha(0.0f);
            r52.setTranslationY(16.0f);
            r52.animate().alpha(1.0f).translationY(0.0f).setDuration(300).start();
        L130:
            LarusDoraHSimplifiedInterruptBinding r53 = r41.p;
            if (r53 == null) goto L136;
            AppCompatTextView r54 = r53.c;
            if (r54 == null) goto L137;
            r54.setAlpha(0.0f);
            r54.setTranslationY(16.0f);
            r54.animate().alpha(1.0f).translationY(0.0f).setDuration(300).start();
            return;
        L137:
            return;
        L136:
            return;
        L108:
            if (r43.getBoolean("arg_is_from_skip") != true) goto L110;
            goto L110
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final String V90() {
        return "new_interrupt_card";
    }

    public final String k() {
        return "dora_h_streamlined_interrupt";
    }

    static {
        z = c7.b(16);
    }

    public final DoraHStreamlinedOnboardingViewModel fa0() {
        return (DoraHStreamlinedOnboardingViewModel) this.o.getValue();
    }

    public final void ka0() {
        LarusDoraHSimplifiedInterruptBinding r0 = this.p;
        if (r0 == null) goto L14;
        AppCompatImageView r1 = r0.f;
        if (r1 == null) goto L15;
        Object r2 = r1.getDrawable();
        if ((r2 instanceof Animatable) == false) goto L9;
        Animatable r3 = (Animatable) r2;
    L10:
        if (r3 == null) goto L12;
        r3.stop();
    L12:
        r1.setVisibility(8);
        return;
    L9:
        r3 = null;
        goto L10
    L15:
        return;
    }

    public final void onDestroyView() {
        LarusDoraHSimplifiedInterruptBinding r0 = this.p;
        if (r0 == null) goto L7;
        VideoPlayView r1 = r0.b;
        if (r1 == null) goto L7;
        r1.N();
    L7:
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L10;
        AppCompatImageView r3 = r2.findViewById(2131369914);
    L11:
        if (r3 == null) goto L13;
        r3.animate().cancel();
        r3.clearAnimation();
        r3.setOnClickListener(null);
        r3.setAlpha(1.0f);
        r3.setTranslationX(0.0f);
        r3.setTranslationY(0.0f);
        r3.setVisibility(8);
    L13:
        ValueAnimator r4 = this.q;
        if (r4 == null) goto L16;
        r4.cancel();
    L16:
        this.q = null;
        this.r = 0;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = null;
        this.w = "";
        this.x = null;
        this.y = null;
        fa0().unregisterMessageObserver();
        fa0().unregisterVoiceCallback();
        super.onDestroyView();
        this.p = null;
        return;
    L10:
        r3 = null;
        goto L11
    }

    public final void onPause() {
        LarusDoraHSimplifiedInterruptBinding r0 = this.p;
        if (r0 == null) goto L7;
        VideoPlayView r1 = r0.b;
        if (r1 == null) goto L7;
        r1.N();
    L7:
        super.onPause();
    }

    public DoraHStreamlinedInterruptFragment() {
        this.o = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraHStreamlinedOnboardingViewModel.class), new DoraHStreamlinedInterruptFragment$special$$inlined$activityViewModels$default$1(this), new DoraHStreamlinedInterruptFragment$special$$inlined$activityViewModels$default$2(this));
        this.w = "";
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void aa0() {
        DoraHStreamlinedOnboardingViewModel.skipAndNext$default(fa0(), false, 1, null);
    }

    public final void ia0() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return;
    L11:
        if (this.s == false) goto L13;
        return;
    L13:
        this.s = true;
        LarusDoraHSimplifiedInterruptBinding r2 = this.p;
        FrameLayout r3 = null;
        if (r2 == null) goto L16;
        FrameLayout r4 = r2.j;
    L17:
        if (r4 == null) goto L22;
        ViewPropertyAnimator r5 = r4.animate();
        if (r5 == null) goto L22;
        r5.cancel();
    L22:
        if (this.u == false) goto L31;
        this.u = false;
        if (r4 == null) goto L26;
        r4.setAlpha(1.0f);
    L26:
        LarusDoraHSimplifiedInterruptBinding r6 = this.p;
        if (r6 == null) goto L29;
        r3 = r6.i;
    L29:
        ga0(r3, true);
        return;
    L31:
        if (r4 == null) goto L33;
        r4.setAlpha(0.0f);
    L33:
        if (r4 == null) goto L42;
        ViewPropertyAnimator r7 = r4.animate();
        if (r7 == null) goto L43;
        ViewPropertyAnimator r8 = r7.alpha(1.0f);
        if (r8 == null) goto L44;
        ViewPropertyAnimator r9 = r8.setDuration(300);
        if (r9 == null) goto L45;
        r9.start();
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L16:
        r4 = null;
        goto L17
    L5:
        if (r0.getBoolean("arg_is_from_skip") != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void ja0() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L5;
        AppCompatImageView r1 = r0.findViewById(2131369914);
    L6:
        if (r1 == null) goto L9;
        r1.animate().cancel();
        r1.clearAnimation();
        r1.setVisibility(0);
        r1.setAlpha(1.0f);
        r1.setTranslationX(0.0f);
        r1.setTranslationY(0.0f);
        e1.d(r1, new d(this));
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onResume() {
        super.onResume();
        ja0();
        o r1 = (o) fa0().getInterruptUiState().getValue();
        if (r1.a <= 0) goto L5;
    L9:
        ha0(o.a(r1, 0, null, null, 11));
    L10:
        LarusDoraHSimplifiedInterruptBinding r0 = this.p;
        if (r0 == null) goto L16;
        VideoPlayView r2 = r0.b;
        if (r2 == null) goto L17;
        r2.post(new g(this));
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if ((r1.b instanceof n0.a) == false) goto L9;
        if ((r1.d instanceof o0.b) == false) goto L9;
        goto L9
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void ha0(o r17) {
        if (this.t == false) goto L5;
    L14:
        boolean r2 = false;
    L15:
        n0 r6 = r17.b;
        n0.a r7 = n0.a.a;
        FrameLayout r9 = null;
        if (Intrinsics.areEqual(r6, r7) == false) goto L19;
        String r8 = null;
    L24:
        if (r8 == null) goto L26;
        String r10 = StringsKt.trim(r8).toString();
    L27:
        if (r10 != null) goto L29;
    L32:
        boolean r11 = true;
    L33:
        if (r11 == false) goto L36;
        r10 = null;
    L36:
        LarusDoraHSimplifiedInterruptBinding r12 = this.p;
        if (r12 == null) goto L65;
        AppCompatTextView r13 = r12.d;
        if (r13 == null) goto L65;
        if (r10 != null) goto L42;
        CharSequence r14 = "";
    L43:
        r13.setText(r14);
        if (r10 != null) goto L46;
    L49:
        boolean r15 = true;
    L50:
        if (r15 == false) goto L52;
        int r16 = 8;
    L53:
        r13.setVisibility(r16);
        if (r10 != null) goto L56;
    L59:
        boolean r18 = true;
    L60:
        if (r18 == false) goto L62;
        r13.setAlpha(1.0f);
        r13.setTranslationY(0.0f);
        goto L65
    L62:
        if (r2 == false) goto L64;
        r13.setAlpha(0.0f);
        r13.setTranslationY(z);
        goto L65
    L64:
        r13.setAlpha(1.0f);
        r13.setTranslationY(0.0f);
        goto L65
    L56:
        if (r10.length() == 0) goto L59;
        r18 = false;
        goto L60
    L52:
        r16 = 0;
        goto L53
    L46:
        if (r10.length() == 0) goto L49;
        r15 = false;
        goto L50
    L42:
        r14 = r10;
    L65:
        long r110 = r17.a;
        o0 r20 = r17.d;
        boolean r21 = !(r20 instanceof o0.b);
        LarusDoraHSimplifiedInterruptBinding r3 = this.p;
        if (r3 == null) goto L85;
        FrameLayout r4 = r3.i;
        if (r4 == null) goto L85;
        if (r21 == false) goto L71;
        int r111 = 0;
    L72:
        r4.setVisibility(r111);
        if (r21 == false) goto L77;
        if (r2 == false) goto L76;
        r4.setAlpha(0.0f);
        r4.setTranslationY(z);
        goto L85
    L76:
        r4.setAlpha(1.0f);
        r4.setTranslationY(0.0f);
        goto L85
    L77:
        Bundle r5 = getArguments();
        if (r5 != null) goto L80;
    L82:
        boolean r22 = false;
    L83:
        if (r22 == true) goto L85;
        r4.setAlpha(0.0f);
        r4.setTranslationY(0.0f);
        goto L85
    L80:
        if (r5.getBoolean("arg_is_from_skip") != true) goto L82;
        r22 = true;
        goto L83
    L71:
        r111 = 8;
    L85:
        LarusDoraHSimplifiedInterruptBinding r23 = this.p;
        if (r23 == null) goto L94;
        SimpleDraweeView r24 = r23.h;
        if (r24 == null) goto L94;
        if (r21 == false) goto L91;
        int r25 = 0;
    L92:
        r24.setVisibility(r25);
        goto L94
    L91:
        r25 = 8;
    L94:
        if (Intrinsics.areEqual(r20, o0.b.a) == false) goto L106;
        this.v = null;
        this.w = "";
        ka0();
        LarusDoraHSimplifiedInterruptBinding r26 = this.p;
        if (r26 == null) goto L100;
        AppCompatTextView r27 = r26.k;
        if (r27 == null) goto L100;
        r27.setVisibility(8);
    L100:
        LarusDoraHSimplifiedInterruptBinding r28 = this.p;
        if (r28 == null) goto L162;
        AppCompatTextView r30 = r28.k;
        if (r30 == null) goto L162;
        r30.setText("");
    L162:
        boolean r31 = false;
    L177:
        if (fa0().consumeEntryAnimation(Long.valueOf(r17.a)) == true) goto L180;
        return;
    L180:
        if (this.t == true) goto L253;
        Bundle r32 = getArguments();
        if (r32 != null) goto L184;
    L186:
        boolean r33 = false;
    L187:
        if (r33 == true) goto L261;
        n0 r34 = r17.b;
        if (Intrinsics.areEqual(r34, r7) == false) goto L193;
        String r35 = null;
    L198:
        if (r35 == null) goto L200;
        String r36 = StringsKt.trim(r35).toString();
    L201:
        if (r36 != null) goto L203;
    L206:
        boolean r37 = true;
    L207:
        if (r37 == false) goto L210;
        r36 = null;
    L210:
        if (r36 != null) goto L212;
    L215:
        boolean r38 = true;
    L216:
        boolean r40 = !r38;
        boolean r1 = !(r17.d instanceof o0.b);
        if (r40 == true) goto L220;
        if (r1 == true) goto L220;
        return;
    L220:
        this.t = true;
        LarusDoraHSimplifiedInterruptBinding r41 = this.p;
        if (r41 == null) goto L223;
        AppCompatTextView r42 = r41.d;
    L224:
        ga0(r42, r40);
        if (r1 == false) goto L263;
        Bundle r43 = getArguments();
        if (r43 != null) goto L230;
    L232:
        if (r31 == true) goto L242;
        Bundle r44 = getArguments();
        if (r44 == null) goto L236;
        boolean r45 = r44.getBoolean("arg_use_shared_element_transition", true);
    L237:
        if (r45 == false) goto L242;
        if (this.s == true) goto L242;
        this.u = true;
        return;
    L236:
        r45 = true;
    L242:
        LarusDoraHSimplifiedInterruptBinding r46 = this.p;
        if (r46 == null) goto L247;
        FrameLayout r47 = r46.j;
        if (r47 == null) goto L247;
        r47.setAlpha(1.0f);
    L247:
        LarusDoraHSimplifiedInterruptBinding r48 = this.p;
        if (r48 == null) goto L250;
        r9 = r48.i;
    L250:
        ga0(r9, true);
        return;
    L230:
        if (r43.getBoolean("arg_is_from_skip") != true) goto L232;
        r31 = true;
        goto L232
    L263:
        return;
    L223:
        r42 = null;
        goto L224
    L212:
        if (r36.length() == 0) goto L215;
        r38 = false;
        goto L216
    L203:
        if (r36.length() == 0) goto L206;
        r37 = false;
        goto L207
    L200:
        r36 = null;
        goto L201
    L193:
        if ((r34 instanceof n0.b) == false) goto L196;
        r35 = ((n0.b) r34).c;
        goto L198
    L196:
        if ((r34 instanceof n0.c) == false) goto L252;
        r35 = ((n0.c) r34).b;
        goto L198
    L252:
        throw new NoWhenBranchMatchedException();
    L261:
        return;
    L184:
        if (r32.getBoolean("arg_is_from_skip") != true) goto L186;
        r33 = true;
        goto L187
    L253:
        return;
    L106:
        if ((r20 instanceof o0.c) == false) goto L151;
        Long r50 = this.v;
        if (r50 != null) goto L111;
    L118:
        boolean r51 = false;
    L119:
        if (r51 == false) goto L130;
        ka0();
        LarusDoraHSimplifiedInterruptBinding r52 = this.p;
        if (r52 == null) goto L125;
        AppCompatTextView r53 = r52.k;
        if (r53 == null) goto L125;
        r53.setVisibility(0);
    L125:
        LarusDoraHSimplifiedInterruptBinding r54 = this.p;
        if (r54 == null) goto L162;
        AppCompatTextView r55 = r54.k;
        if (r55 == null) goto L162;
        r55.setText(this.w);
        goto L162
    L130:
        this.v = Long.valueOf(r110);
        this.w = "";
        LarusDoraHSimplifiedInterruptBinding r56 = this.p;
        if (r56 == null) goto L140;
        AppCompatImageView r57 = r56.f;
        if (r57 == null) goto L140;
        r57.setVisibility(0);
        Object r58 = r57.getDrawable();
        if ((r58 instanceof Animatable) == false) goto L137;
        Animatable r60 = (Animatable) r58;
    L138:
        if (r60 == null) goto L140;
        r60.start();
        goto L140
    L137:
        r60 = null;
    L140:
        LarusDoraHSimplifiedInterruptBinding r61 = this.p;
        if (r61 == null) goto L145;
        AppCompatTextView r62 = r61.k;
        if (r62 == null) goto L145;
        r62.setText("");
    L145:
        LarusDoraHSimplifiedInterruptBinding r63 = this.p;
        if (r63 == null) goto L162;
        AppCompatTextView r64 = r63.k;
        if (r64 == null) goto L162;
        r64.setVisibility(4);
        goto L162
    L111:
        if (r50.longValue() != r110) goto L118;
        if (this.w.length() <= 0) goto L115;
        boolean r65 = true;
    L116:
        if (r65 == false) goto L118;
        r51 = true;
        goto L119
    L115:
        r65 = false;
        goto L116
    L151:
        if ((r20 instanceof o0.d) == false) goto L164;
        this.v = Long.valueOf(r110);
        o0.d r66 = (o0.d) r20;
        this.w = r66.c;
        ka0();
        LarusDoraHSimplifiedInterruptBinding r67 = this.p;
        if (r67 == null) goto L157;
        AppCompatTextView r68 = r67.k;
        if (r68 == null) goto L157;
        r68.setVisibility(0);
    L157:
        LarusDoraHSimplifiedInterruptBinding r70 = this.p;
        if (r70 == null) goto L162;
        AppCompatTextView r71 = r70.k;
        if (r71 == null) goto L162;
        r71.setText(r66.c);
        goto L162
    L164:
        if ((r20 instanceof o0.a) == false) goto L255;
        this.v = Long.valueOf(r110);
        o0.a r72 = (o0.a) r20;
        this.w = r72.b;
        ka0();
        LarusDoraHSimplifiedInterruptBinding r73 = this.p;
        if (r73 == null) goto L170;
        AppCompatTextView r74 = r73.k;
        if (r74 == null) goto L170;
        r31 = false;
        r74.setVisibility(0);
    L171:
        LarusDoraHSimplifiedInterruptBinding r75 = this.p;
        if (r75 == null) goto L177;
        AppCompatTextView r76 = r75.k;
        if (r76 == null) goto L177;
        r76.setText(r72.b);
    L170:
        r31 = false;
        goto L171
    L255:
        throw new NoWhenBranchMatchedException();
    L29:
        if (r10.length() == 0) goto L32;
        r11 = false;
        goto L33
    L26:
        r10 = null;
        goto L27
    L19:
        if ((r6 instanceof n0.b) == false) goto L22;
        r8 = ((n0.b) r6).c;
        goto L24
    L22:
        if ((r6 instanceof n0.c) == false) goto L257;
        r8 = ((n0.c) r6).b;
        goto L24
    L257:
        throw new NoWhenBranchMatchedException();
    L5:
        if (r17.c == false) goto L14;
        Bundle r77 = getArguments();
        if (r77 != null) goto L9;
    L11:
        boolean r78 = false;
    L12:
        if (r78 == true) goto L14;
        r2 = true;
        goto L15
    L9:
        if (r77.getBoolean("arg_is_from_skip") != true) goto L11;
        r78 = true;
        goto L12
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        boolean r0 = true;
        if (r4 == null) goto L5;
        r0 = r4.getBoolean("arg_use_shared_element_transition", true);
    L5:
        if (r0 == false) goto L8;
        TransitionSet r5 = new TransitionSet();
        r5.setOrdering(0);
        r5.setDuration(520);
        r5.setInterpolator(new FastOutSlowInInterpolator());
        r5.addTransition(new ChangeBounds());
        r5.addTransition(new ChangeTransform());
        r5.addTransition(new ChangeClipBounds());
        r5.addListener(new j(this));
        setSharedElementEnterTransition(r5);
        Fade r6 = new Fade();
        r6.setDuration(300);
        setEnterTransition(r6);
        postponeEnterTransition();
        return;
    }

    public final void onSaveInstanceState(Bundle r8) {
        Intrinsics.checkNotNullParameter(r8, "outState");
        super.onSaveInstanceState(r8);
        o r0 = (o) fa0().getInterruptUiState().getValue();
        r8.putLong("state_round_token", r0.a);
        r8.putBoolean("state_should_play_entry_animation", r0.c);
        n0 r1 = r0.b;
        if (Intrinsics.areEqual(r1, n0.a.a) == false) goto L6;
        r8.putString("state_query_type", "hidden");
    L11:
        o0 r2 = r0.d;
        if (Intrinsics.areEqual(r2, o0.b.a) == false) goto L15;
        r8.putString("state_reply_type", "hidden");
    L23:
        r8.putString("state_interrupt_mv_video_path", this.x);
        r8.putString("state_interrupt_mv_cover_path", this.y);
        return;
    L15:
        if ((r2 instanceof o0.c) == false) goto L18;
        r8.putString("state_reply_type", "loading");
        r8.putString("state_reply_placeholder_text", ((o0.c) r2).b);
        goto L23
    L18:
        if ((r2 instanceof o0.d) == false) goto L21;
        r8.putString("state_reply_type", "typing");
        o0.d r3 = (o0.d) r2;
        r8.putString("state_reply_full_text", r3.b);
        r8.putString("state_reply_displayed_text", r3.c);
        goto L23
    L21:
        if ((r2 instanceof o0.a) == false) goto L26;
        r8.putString("state_reply_type", "completed");
        r8.putString("state_reply_text", ((o0.a) r2).b);
        goto L23
    L26:
        throw new NoWhenBranchMatchedException();
    L6:
        if ((r1 instanceof n0.b) == false) goto L9;
        r8.putString("state_query_type", "listening");
        n0.b r4 = (n0.b) r1;
        r8.putString("state_query_source", r4.b);
        r8.putString("state_query_text", r4.c);
        goto L11
    L9:
        if ((r1 instanceof n0.c) == false) goto L28;
        r8.putString("state_query_type", "submitted");
        n0.c r5 = (n0.c) r1;
        r8.putString("state_query_source", r5.c);
        r8.putString("state_query_text", r5.b);
        goto L11
    L28:
        throw new NoWhenBranchMatchedException();
    }

    public static void ga0(View r2, boolean r3) {
        if (r3 == true) goto L4;
        return;
    L4:
        if (r2 != null) goto L6;
        return;
    L6:
        r2.animate().cancel();
        r2.setVisibility(0);
        r2.setAlpha(0.0f);
        r2.setTranslationY(z);
        r2.animate().alpha(1.0f).translationY(0.0f).setDuration(300).setInterpolator(new FastOutSlowInInterpolator()).start();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super.onViewCreated(r20, r21);
        fa0().onInterruptPageShown();
        boolean r6 = false;
        if (r21 != null) goto L5;
    L72:
        Bundle r2 = getArguments();
        if (r2 == null) goto L75;
        boolean r3 = r2.getBoolean("arg_is_from_skip", false);
    L76:
        Bundle r7 = getArguments();
        if (r7 == null) goto L79;
        boolean r8 = r7.getBoolean("arg_use_shared_element_transition", true);
    L80:
        g49.d.d("DoraHStreamlinedInterruptFragment", "onViewCreated: isFromSkip=" + r3);
        LarusDoraHSimplifiedInterruptBinding r9 = this.p;
        if (r9 == null) goto L97;
        ConstraintLayout r10 = r9.a;
        if (r10 == null) goto L97;
        if (r3 == true) goto L88;
        if (r8 == false) goto L88;
        float r11 = 0.0f;
    L89:
        r10.setAlpha(r11);
        Drawable r12 = r10.getBackground();
        if (r12 == null) goto L97;
        Drawable r13 = r12.mutate();
        if (r13 == null) goto L97;
        if (r3 == false) goto L95;
        int r14 = 0;
    L96:
        r13.setAlpha(r14);
        goto L97
    L95:
        r14 = 255;
    L88:
        r11 = 1.0f;
    L97:
        if (r3 == false) goto L103;
        LarusDoraHSimplifiedInterruptBinding r15 = this.p;
        if (r15 == null) goto L126;
        FrameLayout r16 = r15.i;
        if (r16 == null) goto L126;
        r16.setVisibility(8);
    L126:
        LarusDoraHSimplifiedInterruptBinding r17 = this.p;
        if (r17 == null) goto L149;
        final VideoPlayView r18 = r17.b;
        if (r18 == null) goto L149;
        DoraDevice r22 = DoraAdapterExtKt.h(kj4.a.g());
        boolean r110 = v19.h.a;
        Context r111 = r18.getContext();
        if (r111 != null) goto L134;
        r111 = AppHost.a.getApplication();
    L134:
        if (v19.h.b(r111) == false) goto L136;
        String r112 = "dark";
    L137:
        final String r113 = this.x;
        if (r113 != null) goto L140;
        r113 = l59.a.a("https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4//h/onboarding/interrupt/${product}/v2/video_${sku}_${light_mode}.mp4", r22, r112);
    L140:
        final String r114 = this.y;
        if (r114 != null) goto L143;
        r114 = l59.a.a("https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4//h/onboarding/interrupt/${product}/v2/image_${sku}_${light_mode}.png", r22, r112);
    L143:
        this.x = r113;
        this.y = r114;
        StringBuilder r23 = new StringBuilder("setupInterruptMv: videoPath=");
        r23.append(r113);
        r23.append(", coverPath=");
        r23.append(r114);
        r23.append(", hasSavedVideoPath=");
        String r115 = this.x;
        if (r115 != null) goto L146;
    L147:
        r6 = true;
    L148:
        r23.append(true ^ r6);
        g49.d.d("DoraHStreamlinedInterruptFragment", r23.toString());
        r18.post(new i(r18, r113, r114));
        goto L149
    L146:
        if (r115.length() != 0) goto L148;
    L136:
        r112 = "light";
    L149:
        LarusDoraHSimplifiedInterruptBinding r4 = this.p;
        if (r4 == null) goto L154;
        AppCompatTextView r5 = r4.k;
        if (r5 == null) goto L154;
        r5.setTextColor(ColorUtils.setAlphaComponent(r5.getCurrentTextColor(), 179));
    L154:
        ja0();
        Lifecycle.State r24 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedInterruptFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r24, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedInterruptFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r24, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraHStreamlinedInterruptFragment$setupObservers$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r24, null, this), 3, null);
        TextView r25 = this.h;
        if (r25 == null) goto L157;
        e1.x(r25);
        int r26 = com.larus.utils.j0.a;
        r25.setText(com.larus.utils.j0.d(2131902338));
        e1.d(r25, new e(this));
    L157:
        if (r3 == true) goto L159;
        fa0().registerMessageObserver();
    L159:
        OneShotPreDrawListener.add(r20, new b(r20, r8, this));
        if (r3 == true) goto L164;
        fa0().registerVoiceCallback();
        return;
    L164:
        return;
    L103:
        if (r8 == false) goto L121;
        LarusDoraHSimplifiedInterruptBinding r27 = this.p;
        if (r27 == null) goto L109;
        FrameLayout r28 = r27.i;
        if (r28 == null) goto L109;
        r28.setAlpha(1.0f);
    L109:
        LarusDoraHSimplifiedInterruptBinding r30 = this.p;
        if (r30 == null) goto L114;
        FrameLayout r31 = r30.j;
        if (r31 == null) goto L114;
        r31.setAlpha(0.0f);
    L114:
        LarusDoraHSimplifiedInterruptBinding r32 = this.p;
        if (r32 == null) goto L120;
        FrameLayout r33 = r32.i;
        if (r33 == null) goto L163;
        ViewCompat.setTransitionName(r33, "dora_h_simplified_interrupt_card");
        goto L126
    L163:
        return;
    L120:
        return;
    L121:
        this.s = true;
        LarusDoraHSimplifiedInterruptBinding r34 = this.p;
        if (r34 == null) goto L126;
        FrameLayout r35 = r34.j;
        if (r35 == null) goto L126;
        r35.setAlpha(1.0f);
        goto L126
    L79:
        r8 = true;
        goto L80
    L75:
        r3 = false;
        goto L76
    L5:
        if (r21.containsKey("state_round_token") == true) goto L7;
        o r36 = null;
    L69:
        if (r36 == null) goto L72;
        g49.d.d("DoraHStreamlinedInterruptFragment", "restoreInterruptUiStateIfNeeded: roundToken=" + r36.a);
        fa0().restoreInterruptUiState(r36);
        this.x = r21.getString("state_interrupt_mv_video_path");
        this.y = r21.getString("state_interrupt_mv_cover_path");
        this.t = true;
        this.u = false;
        goto L72
    L7:
        long r116 = r21.getLong("state_round_token");
        String r37 = r21.getString("state_query_type");
        String r38 = "";
        if (r37 == null) goto L31;
        int r40 = r37.hashCode();
        if (r40 == (-1218715461)) goto L22;
        if (r40 != 348678395) goto L31;
        if (r37.equals("submitted") == false) goto L31;
        String r41 = r21.getString("state_query_text");
        String r117 = r21.getString("state_query_source");
        if (r117 != null) goto L20;
        r117 = "";
    L20:
        n0 r42 = new n0.c(r116, r41, r117);
    L32:
        n0 r118 = r42;
        String r43 = r21.getString("state_reply_type");
        if (r43 == null) goto L67;
        int r44 = r43.hashCode();
        if (r44 == (-1402931637)) goto L60;
        if (r44 == (-858798729)) goto L49;
        if (r44 != 336650556) goto L67;
        if (r43.equals("loading") == false) goto L67;
        String r45 = r21.getString("state_reply_placeholder_text");
        if (r45 == null) goto L47;
        r38 = r45;
    L47:
        o0 r46 = new o0.c(r116, r38);
    L68:
        r36 = new o(r116, r118, r21.getBoolean("state_should_play_entry_animation", false), r46);
        goto L69
    L49:
        if (r43.equals("typing") == false) goto L67;
        String r47 = r21.getString("state_reply_full_text");
        if (r47 != null) goto L54;
        r47 = "";
    L54:
        String r119 = r21.getString("state_reply_displayed_text");
        if (r119 == null) goto L58;
        r38 = r119;
    L58:
        r46 = new o0.d(r116, r47, r38);
        goto L68
    L60:
        if (r43.equals("completed") == false) goto L67;
        String r48 = r21.getString("state_reply_text");
        if (r48 == null) goto L66;
        r38 = r48;
    L66:
        r46 = new o0.a(r116, r38);
    L67:
        r46 = o0.b.a;
        goto L68
    L22:
        if (r37.equals("listening") == false) goto L31;
        String r50 = r21.getString("state_query_source");
        if (r50 != null) goto L27;
        r50 = "";
    L27:
        String r120 = r21.getString("state_query_text");
        if (r120 != null) goto L30;
        r120 = "";
    L30:
        r42 = new n0.b(r116, r50, r120);
    L31:
        r42 = n0.a.a;
        goto L32
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        ConstraintLayout r16 = r13.inflate(2131562207, r14, false);
        int r17 = 2131369894;
        VideoPlayView r2 = (VideoPlayView) ViewBindings.findChildViewById(r16, 2131369894);
        if (r2 == null) goto L27;
        r17 = 2131369895;
        DoraTextView r3 = (DoraTextView) ViewBindings.findChildViewById(r16, 2131369895);
        if (r3 == null) goto L27;
        r17 = 2131369919;
        DoraTextView r4 = (DoraTextView) ViewBindings.findChildViewById(r16, 2131369919);
        if (r4 == null) goto L27;
        r17 = 2131369929;
        if (((LinearLayout) ViewBindings.findChildViewById(r16, 2131369929)) == null) goto L27;
        r17 = 2131369930;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r16, 2131369930);
        if (r5 == null) goto L27;
        r17 = 2131369931;
        AppCompatImageView r6 = ViewBindings.findChildViewById(r16, 2131369931);
        if (r6 == null) goto L27;
        r17 = 2131369941;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r16, 2131369941);
        if (r7 == null) goto L27;
        r17 = 2131369942;
        CircleSimpleDraweeView r8 = (CircleSimpleDraweeView) ViewBindings.findChildViewById(r16, 2131369942);
        if (r8 == null) goto L27;
        r17 = 2131369943;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r16, 2131369943);
        if (r9 == null) goto L27;
        r17 = 2131369944;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r16, 2131369944);
        if (r10 == null) goto L27;
        r17 = 2131369945;
        DoraTextView r11 = (DoraTextView) ViewBindings.findChildViewById(r16, 2131369945);
        if (r11 == null) goto L27;
        ConstraintLayout r18 = r16;
        this.p = new LarusDoraHSimplifiedInterruptBinding(r18, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        return r18;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
