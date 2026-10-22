package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.keyboard.event.ImeState;
import com.ss.android.lark.keyboard.ime.ExtensionImeKt;
import com.ss.android.lark.keyboard.ime.ImeStateDetail;
import com.ss.android.lark.keyboard.ime.ImeWrapper;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.ImeWrapperMotionScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.StatusBarUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoiceImeWrapperUseCase {
    public final ImeWrapper a;
    public final com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a b;
    public final Fragment c;
    public final Lazy d;
    public final ImeWrapperMotionScene e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final int k;
    public final Lazy l;
    public final Lazy m;
    public final e n;
    public final c o;
    public final d p;

    public static final class a implements com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.g {
        public final /* synthetic */ VoiceImeWrapperUseCase a;

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.g
        public final Pair<String, Integer> a() {
            AppCompatEditText r0 = this.a.b.a();
            return TuplesKt.to(r0.getEditableText().toString(), Integer.valueOf(r0.getSelectionStart()));
        }

        public a(VoiceImeWrapperUseCase r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    public static final class c implements com.ss.android.lark.keyboard.ime.i {
        public final /* synthetic */ VoiceImeWrapperUseCase a;

        public c(VoiceImeWrapperUseCase r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.keyboard.ime.i
        public final void u(ImeState r2, ImeState r3) {
            Intrinsics.checkNotNullParameter(r2, "from");
            Intrinsics.checkNotNullParameter(r3, "to");
        }

        @Override // com.ss.android.lark.keyboard.ime.i
        public final void B(ImeStateDetail r3, ImeStateDetail r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "from");
            Intrinsics.checkNotNullParameter(r4, "to");
            if (r4 != ImeStateDetail.Exit) goto L6;
            this.a.b.a().clearFocus();
        L6:
            if (r3 == ImeStateDetail.Show) goto L8;
            return;
        L8:
            if (r4 != ImeStateDetail.Hide) goto L12;
            VoiceImeWrapperUseCase r6 = this.a;
            ImeWrapperMotionScene.d(r6.e, false, null, r6.a().getImmersiveVoiceMode().b, 7);
            return;
        }
    }

    public static final class d implements com.ss.android.lark.keyboard.ime.i {
        public final /* synthetic */ VoiceImeWrapperUseCase a;

        public d(VoiceImeWrapperUseCase r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.keyboard.ime.i
        public final void u(ImeState r9, ImeState r10) {
            Intrinsics.checkNotNullParameter(r9, "from");
            Intrinsics.checkNotNullParameter(r10, "to");
            ImeState r0 = ImeState.NONE;
            boolean r5 = true;
            if (r10 != r0) goto L14;
            this.a.a().updateIsKeyboardShowing(false);
            VoiceImeWrapperUseCase.f(this.a, 0, false, 7);
            VoiceImeWrapperUseCase r11 = this.a;
            FrameLayout r1 = r11.b.f();
            Intrinsics.checkNotNullParameter(r1, "view");
            if (r1.getVisibility() == 4) goto L8;
            r5 = false;
        L8:
            if (r5 == false) goto L10;
        L13:
            VoiceImeWrapperUseCase r12 = this.a;
            ImeWrapperMotionScene.d(r12.e, false, null, r12.a().getImmersiveVoiceMode().b, 7);
            this.a.b.a().clearFocus();
            return;
        L10:
            if (r11.c() == true) goto L13;
            float r4 = r1.getHeight();
            ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r3.setDuration(96);
            r3.addUpdateListener(new m0(r1, r4));
            Intrinsics.checkNotNull(r3);
            r3.addListener(new n0(r1, r4, r11));
            r3.start();
            List<ValueAnimator> r13 = r11.b();
            Intrinsics.checkNotNull(r3);
            r13.add(r3);
            goto L13
        L14:
            if (r9 != r0) goto L26;
            this.a.a().updateIsKeyboardShowing(true);
            VoiceImeWrapperUseCase r14 = this.a;
            FrameLayout r15 = r14.b.f();
            Intrinsics.checkNotNullParameter(r15, "view");
            if (r15.getVisibility() == 0) goto L19;
            r5 = false;
        L19:
            if (r5 == false) goto L21;
            return;
        L21:
            if (r14.c() == true) goto L28;
            float r2 = r15.getHeight();
            ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r6.setDuration(96);
            r6.addUpdateListener(new p0(r15, r2));
            Intrinsics.checkNotNull(r6);
            r6.addListener(new o0(r15, r14, r15));
            r6.start();
            List<ValueAnimator> r16 = r14.b();
            Intrinsics.checkNotNull(r6);
            r16.add(r6);
            return;
        L28:
            return;
        }

        @Override // com.ss.android.lark.keyboard.ime.i
        public final void B(ImeStateDetail r2, ImeStateDetail r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "from");
            Intrinsics.checkNotNullParameter(r3, "to");
            Intrinsics.checkNotNullParameter(ImeWrapper.B, "<this>");
            if (r4 == 2) goto L5;
            return;
        L5:
            if (r3.isEnterOrShow() == false) goto L8;
            this.a.a().updateIsPanelShowing(true);
            return;
        L8:
            if (r3 != ImeStateDetail.Hide) goto L13;
            this.a.a().updateIsPanelShowing(false);
            return;
        }
    }

    public static final class e implements com.ss.android.lark.keyboard.ime.e {
        public final /* synthetic */ VoiceImeWrapperUseCase a;

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void J() {
        }

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void K(int r1, int r2, int r3, float r4, float r5) {
        }

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void a(int r1) {
        }

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void g(int r1, int r2, int r3, int r4, float r5) {
        }

        public e(VoiceImeWrapperUseCase r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void n(int r8, int r9, long r10, Interpolator r12) {
            Intrinsics.checkNotNullParameter(r12, "interpolator");
            boolean r0 = false;
            if (r8 >= r9) goto L8;
            this.a.a().updateIsKeyboardShowing(true);
            int r11 = RangesKt.coerceAtLeast(this.a.b.f().getHeight() - r8, 0);
            VoiceImeWrapperUseCase.f(this.a, r11 + r9, true, 4);
            VoiceImeWrapperUseCase r13 = this.a;
            ImeWrapperMotionScene r1 = r13.e;
            VoiceInputScene r5 = r13.a().getImmersiveVoiceMode().b;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r5, "scene");
            KeyboardVoiceFGUtils r14 = KeyboardVoiceFGUtils.a;
            if (KeyboardVoiceFGUtils.b() == false) goto L7;
            r1.c(true, null, false, null, r5, true);
            return;
        L7:
            r1.b(true, null);
            return;
        L8:
            if (r8 == r9) goto L10;
        L12:
            VoiceImeWrapperUseCase.f(this.a, 0, false, 7);
            VoiceImeWrapperUseCase r15 = this.a;
            ImeWrapperMotionScene r16 = r15.e;
            Boolean r17 = (Boolean) r15.a().isPanelShowing().getValue();
            if (r17 == null) goto L15;
            r0 = r17.booleanValue();
        L15:
            ImeWrapperMotionScene.d(r16, r0, Long.valueOf(r10), this.a.a().getImmersiveVoiceMode().b, 1);
            return;
        L10:
            if (KeyboardVoiceFGUtils.d() == false) goto L12;
        }
    }

    public static final class f implements TextWatcher {
        public final /* synthetic */ VoiceImeWrapperUseCase a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public f(VoiceImeWrapperUseCase r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r18) {
            AppCompatEditText r1 = this.a.b.a();
            int r2 = Build.VERSION.SDK_INT;
            if (r2 < 23) goto L17;
            VoiceImeWrapperUseCase r3 = this.a;
            int r5 = r1.getWidth();
            r3.getClass();
            CharSequence r4 = r1.getText();
            CharSequence r6 = r1.getText();
            if (r6 == null) goto L7;
            int r7 = r6.length();
        L8:
            StaticLayout.Builder r8 = StaticLayout.Builder.obtain(r4, 0, r7, r1.getPaint(), r5);
            r8.setAlignment(Layout.Alignment.ALIGN_NORMAL);
            r8.setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR);
            r8.setLineSpacing(r1.getLineSpacingExtra(), r1.getLineSpacingMultiplier());
            r8.setIncludePad(r1.getIncludeFontPadding());
            r8.setBreakStrategy(r1.getBreakStrategy());
            r8.setHyphenationFrequency(r1.getHyphenationFrequency());
            r8.setMaxLines(r1.getMaxLines());
            if (r2 < 26) goto L12;
            r8.setJustificationMode(r1.getJustificationMode());
        L12:
            if (r1.getEllipsize() != null) goto L14;
        L16:
            StaticLayout r9 = r8.build();
        L23:
            if (((r9.getLineCount() * r1.getLineHeight()) + ((r9.getLineCount() - 1) * r1.getLineSpacingExtra())) <= r1.getMaxHeight()) goto L25;
            VoiceImeWrapperUseCase r10 = this.a;
            r10.e(r10.b.f().getHeight(), true, true);
            return;
        L25:
            VoiceImeWrapperUseCase r11 = this.a;
            VoiceImeWrapperUseCase.f(r11, r11.b.f().getHeight(), false, 4);
            return;
        L14:
            if (r1.getKeyListener() == null) goto L16;
            r8.setEllipsize(r1.getEllipsize());
            r8.setEllipsizedWidth(r5);
            goto L16
        L7:
            r7 = 0;
            goto L8
        L17:
            VoiceImeWrapperUseCase r12 = this.a;
            int r16 = r1.getWidth();
            r12.getClass();
            CharSequence r13 = r1.getText();
            CharSequence r14 = r1.getText();
            if (r14 == null) goto L20;
            int r15 = r14.length();
        L21:
            r9 = new StaticLayout(r13, 0, r15, r1.getPaint(), r16, Layout.Alignment.ALIGN_NORMAL, r1.getLineSpacingMultiplier(), r1.getLineSpacingExtra(), r1.getIncludeFontPadding(), r1.getEllipsize(), r16);
            goto L23
        L20:
            r15 = 0;
            goto L21
        }
    }

    static {
    }

    public final ImmersiveVoiceViewModel a() {
        return (ImmersiveVoiceViewModel) this.m.getValue();
    }

    public final List<ValueAnimator> b() {
        return (List) this.d.getValue();
    }

    public final void d() {
        Log.d("VoiceImeWrapperUseCase", "clearAllAnimations");
        Iterator<T> r0 = b().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ValueAnimator) r0.next()).cancel();
        goto L4
    L6:
        b().clear();
        this.a.H(this.n);
        if (KeyboardVoiceFGUtils.d() == false) goto L9;
        ExtensionImeKt.b(this.a, this.p);
        return;
    L9:
        ExtensionImeKt.b(this.a, this.o);
    }

    public final boolean c() {
        List<ValueAnimator> r0 = b();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (((ValueAnimator) r1.next()).isRunning() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public final void e(int r10, boolean r11, boolean r12) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r0 = this.b;
        int r1 = r0.b.getHeight();
        int r2 = (((((Number) this.i.getValue()).intValue() * 2) + ((Number) this.l.getValue()).intValue()) + StatusBarUtil.getStatusBarHeight(r0.d().getContext())) + y9c.d.a(44);
        Integer r3 = Integer.valueOf(r0.m().getHeight());
        boolean r5 = true;
        int r6 = 0;
        if (r3.intValue() <= 0) goto L5;
        boolean r4 = true;
    L6:
        ViewGroup.MarginLayoutParams r7 = null;
        if (r4 == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L12;
        int r8 = r3.intValue();
    L13:
        Integer r9 = Integer.valueOf(r0.d().getHeight());
        if (r9.intValue() > 0) goto L17;
        r5 = false;
    L17:
        if (r5 == true) goto L20;
        r9 = null;
    L20:
        if (r9 == null) goto L22;
        int r13 = r9.intValue();
    L23:
        int r14 = ((r8 + r0.b().getHeight()) + r13) + r0.r().getHeight();
        ViewGroup.LayoutParams r15 = r0.d().getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
    L27:
        if (r16 == null) goto L29;
        int r17 = r16.topMargin;
    L30:
        ViewGroup.LayoutParams r18 = r0.d().getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L33;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
    L34:
        if (r19 == null) goto L36;
        int r20 = r19.bottomMargin;
    L37:
        int r21 = r17 + r20;
        ViewGroup.LayoutParams r22 = r0.m().getLayoutParams();
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == false) goto L40;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
    L41:
        if (r23 == null) goto L43;
        int r24 = r23.bottomMargin;
    L44:
        int r25 = r21 + r24;
        ViewGroup.LayoutParams r26 = r0.m().getLayoutParams();
        if ((r26 instanceof ViewGroup.MarginLayoutParams) == false) goto L47;
        r7 = (ViewGroup.MarginLayoutParams) r26;
    L47:
        if (r7 == null) goto L49;
        r6 = r7.topMargin;
    L49:
        int r27 = r25 + r6;
        if (r10 > 0) goto L52;
    L54:
        int r28 = ((r1 - (((this.k + ((Number) this.i.getValue()).intValue()) + ((Number) this.j.getValue()).intValue()) + (((Number) this.h.getValue()).intValue() * 2))) - r14) - r2;
    L55:
        int r29 = r28 - r27;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r110 = this.b;
        r110.a().setMaxHeight(r29);
        ConstraintSet r30 = new ConstraintSet();
        r30.clone(r110.o());
        if (r11 == false) goto L61;
        int r111 = Math.max(r110.a().getMinHeight(), r29);
        if (r110.a().getHeight() > r111) goto L60;
        if (r12 == true) goto L60;
        return;
    L60:
        r30.constrainHeight(r110.a().getId(), r111);
        r30.applyTo(r110.o());
        return;
    L61:
        r30.constrainHeight(r110.a().getId(), -2);
        r30.applyTo(r110.o());
        return;
    L52:
        if (Intrinsics.areEqual(a().isKeyboardShowing().getValue(), Boolean.TRUE) == false) goto L54;
        r28 = (((r1 - (((((Number) this.h.getValue()).intValue() * 2) + ((Number) this.i.getValue()).intValue()) + ((Number) this.j.getValue()).intValue())) - r14) - r2) - r10;
        goto L55
    L43:
        r24 = 0;
        goto L44
    L40:
        r23 = null;
        goto L41
    L36:
        r20 = 0;
        goto L37
    L33:
        r19 = null;
        goto L34
    L29:
        r17 = 0;
        goto L30
    L26:
        r16 = null;
        goto L27
    L22:
        r13 = r0.d().getLayoutParams().height;
        goto L23
    L12:
        r8 = r0.m().getDrawable().getIntrinsicHeight();
        goto L13
    L5:
        r4 = false;
        goto L6
    }

    public VoiceImeWrapperUseCase(ConstraintLayout r4, ImeWrapper r5, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "imeWrapper");
        Intrinsics.checkNotNullParameter(r6, "viewFinder");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = LazyKt.lazy(VoiceImeWrapperUseCase$runningAnimators$2.INSTANCE);
        this.e = new ImeWrapperMotionScene(r4);
        Lazy r0 = LazyKt.lazy(VoiceImeWrapperUseCase$distBubbleWithSend$2.INSTANCE);
        this.f = r0;
        Lazy r1 = LazyKt.lazy(VoiceImeWrapperUseCase$bottomMarginCancel$2.INSTANCE);
        this.g = r1;
        this.h = LazyKt.lazy(VoiceImeWrapperUseCase$dp8$2.INSTANCE);
        this.i = LazyKt.lazy(VoiceImeWrapperUseCase$dp16$2.INSTANCE);
        this.j = LazyKt.lazy(VoiceImeWrapperUseCase$dp18$2.INSTANCE);
        this.k = ((Number) r1.getValue()).intValue() + ((Number) r0.getValue()).intValue();
        this.l = LazyKt.lazy(new VoiceImeWrapperUseCase$navigationBarHeight$2(this));
        this.m = LazyKt.lazy(new VoiceImeWrapperUseCase$immersiveVoiceViewModel$2(this));
        e r2 = new e(this);
        this.n = r2;
        c r3 = new c(this);
        this.o = r3;
        d r8 = new d(this);
        this.p = r8;
        r5.l(r2);
        if (KeyboardVoiceFGUtils.d() == false) goto L5;
        ExtensionImeKt.a(r5, r8);
    L6:
        r5.setFocusDelegate(new VoiceImeWrapperUseCase$1$1(this));
        r5.setAnimationEnable(true);
        a().injectIGetEditTextAndSelectionDependency(new a(this));
        r6.a().addTextChangedListener(new f(this));
        Context r9 = r4.getContext();
        if (r7 != null) goto L10;
        Intrinsics.checkNotNull(r9);
        Activity r10 = ContextsKt.findActivity(r9);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r7 = (LifecycleOwner) r10;
    L10:
        a().getAsrResultFocused().observe(r7, new l0(this));
        return;
    L5:
        ExtensionImeKt.a(r5, r3);
        goto L6
    }

    public static /* synthetic */ void f(VoiceImeWrapperUseCase r2, int r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = false;
    L8:
        r2.e(r3, r4, false);
    }
}
