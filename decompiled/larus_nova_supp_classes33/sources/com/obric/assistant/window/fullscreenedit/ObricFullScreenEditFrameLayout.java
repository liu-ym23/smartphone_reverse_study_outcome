package com.obric.assistant.window.fullscreenedit;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.UIUtils;
import com.larus.bmhome.chat.immerse.k0;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.LayoutObricChatFullScreenEditBinding;
import com.obric.cae.libs.useraware.ApWakeEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import v19.c7;
import zha.c;
import zha.d;
import zha.e;
import zha.f;
import zha.g;
import zha.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t*\u0001 \u0018\u0000 82\u00020\u0001:\u00018B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\\\u0010\"\u001a\u00020\u00152\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u001e\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010#\u001a\u00020\u0015J\u0010\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010\u0018J\u0006\u0010&\u001a\u00020\u0015J\u000e\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u000eJ\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020\u0015H\u0002J\u0006\u0010-\u001a\u00020\u0015J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u0015H\u0014J\b\u00102\u001a\u00020\u0015H\u0014J\b\u00103\u001a\u00020\u0015H\u0002J\b\u00104\u001a\u00020\u0015H\u0002J\u0010\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u000eH\u0002J\b\u00107\u001a\u00020\u0015H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u00069"}, d2 = {"Lcom/obric/assistant/window/fullscreenedit/ObricFullScreenEditFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/obric/assistant/impl/databinding/LayoutObricChatFullScreenEditBinding;", "lastTouchX", "", "lastTouchY", "startTopMargin", "", "isImmersive", "", "textWatcher", "Landroid/text/TextWatcher;", "onClickSend", "Lkotlin/Function1;", "", "onUpdateInputText", "Lkotlin/Function3;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "inModify", "onFold", "Lkotlin/Function0;", "imeHeight", "imeListener", "com/obric/assistant/window/fullscreenedit/ObricFullScreenEditFrameLayout$imeListener$1", "Lcom/obric/assistant/window/fullscreenedit/ObricFullScreenEditFrameLayout$imeListener$1;", "init", "dealClickEvent", "setInputText", "text", "setDarkMode", "setImmersiveStyle", "backgroundColor", "colorArrays", "", "color", "removeView", "adaptPadding", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onAttachedToWindow", "onDetachedFromWindow", "setupSendClick", "updateChatInputText", "dealOpenFullScreenEditView", "startMargin", "dealCloseFullScreenEditView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFullScreenEditFrameLayout extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public final LayoutObricChatFullScreenEditBinding a;
    public float b;
    public b c;
    public final zha.a d;
    public final CoroutineScope e;
    public final ObricFullScreenEditFrameLayout$imeListener$1 f;

    public static final class a {
    }

    public static final class b implements TextWatcher {
        public final /* synthetic */ ObricFullScreenEditFrameLayout a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public b(ObricFullScreenEditFrameLayout r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            AppCompatImageView r0 = this.a.a.c;
            boolean r1 = false;
            if (r4 != null) goto L5;
        L8:
            boolean r5 = true;
        L9:
            if (r5 == false) goto L11;
            this.a.getClass();
        L12:
            r0.setEnabled(r1);
            return;
        L11:
            r1 = true;
            goto L12
        L5:
            if (StringsKt.isBlank(r4) == true) goto L8;
            r5 = false;
            goto L9
        }
    }

    static {
    }

    public static /* synthetic */ void a(ObricFullScreenEditFrameLayout r0) {
        setInputText$lambda$3(r0);
    }

    public final void b() {
        FLogger.a.i("ObricFullScreenEditFrameLayout", "close full screen edit view");
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r1.setDuration(100);
        r1.addUpdateListener(new c(this));
        ViewGroup.LayoutParams r2 = this.a.i.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        final ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        ValueAnimator r4 = ValueAnimator.ofInt(new int[]{r3.topMargin, UIUtils.getScreenHeight(getContext())});
        r4.setDuration(300);
        r4.addUpdateListener(new d(r3, this));
        AnimatorSet r5 = new AnimatorSet();
        r5.playTogether(new Animator[]{r4, r1});
        r5.start();
        this.d.invoke(this.a.l.getText().toString(), Boolean.TRUE, Boolean.FALSE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FLogger.a.i("ObricFullScreenEditFrameLayout", "onAttachedToWindow");
        c(UIUtils.getScreenHeight(getContext()));
        e1.d(this.a.c, new h(this));
        FrameLayout r0 = this.a.h;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L7;
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        i0.a.getClass();
        r2.bottomMargin = RangesKt.coerceAtLeast(0 - i0.e(), 0);
        r0.setLayoutParams(r2);
        ViewCompat.setWindowInsetsAnimationCallback(this.a.h, this.f);
        EditText r3 = this.a.l;
        b r4 = new b(this);
        r3.addTextChangedListener(r4);
        this.c = r4;
        postDelayed(new zha.b(this), 300);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.a.i("ObricFullScreenEditFrameLayout", "onDetachedFromWindow");
        ViewCompat.setWindowInsetsAnimationCallback(this.a.h, null);
        b r0 = this.c;
        if (r0 == null) goto L6;
        this.a.l.removeTextChangedListener(r0);
        return;
    }

    public ObricFullScreenEditFrameLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private static final void setInputText$lambda$3(ObricFullScreenEditFrameLayout r1) {
        r1.a.g.fullScroll(ApWakeEvent.ACCELERATING_START);
    }

    public final void c(int r7) {
        FLogger.a.i("ObricFullScreenEditFrameLayout", "open full screen edit view");
        ViewGroup.LayoutParams r0 = this.a.i.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        final ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{r7, 0});
        r2.setDuration(300);
        r2.addUpdateListener(new f(r1, this));
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r3.setDuration(100);
        r3.setInterpolator(new AccelerateInterpolator());
        r3.addUpdateListener(new g(this));
        AnimatorSet r4 = new AnimatorSet();
        r4.playSequentially(new Animator[]{r2, r3});
        r4.start();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        r7.getRawX();
        float r0 = r7.getRawY();
        ViewGroup.LayoutParams r1 = this.a.i.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        int r8 = r7.getAction();
        if (r8 == 0) goto L22;
        if (r8 != 1) goto L6;
        int r9 = r2.topMargin;
        if (r9 < 400) goto L21;
        b();
    L23:
        return true;
    L21:
        c(r9);
        goto L23
    L6:
        if (r8 != 2) goto L23;
        float r10 = r0 - this.b;
        int r3 = r2.topMargin;
        if (r3 < 0) goto L14;
        if ((r3 + r10) < 0) goto L14;
        int r11 = (int) r10;
        r2.topMargin = r3 + r11;
        r2.bottomMargin -= r11;
        this.a.i.setLayoutParams(r2);
    L14:
        if (r2.topMargin <= 0) goto L16;
        this.a.b.setAlpha(0.0f);
    L17:
        this.b = r0;
        goto L23
    L16:
        this.a.b.setAlpha(1.0f);
        goto L17
    L22:
        this.b = r0;
        goto L23
    }

    public final void setImmersiveStyle(int r6) {
        FLogger.a.i("ObricFullScreenEditFrameLayout", "set immersive style");
        int r0 = k0.a(r6, 0.1f, 0.35f);
        GradientDrawable r1 = new GradientDrawable();
        r1.setShape(0);
        r1.setCornerRadius(c7.b(16));
        r1.setColor(r0);
        this.a.i.setBackground(r1);
        this.a.h.setBackground(new ColorDrawable(0));
        this.a.l.setHintTextColor(ve8.d.a(2131106539, getContext()));
        this.a.l.setTextColor(ve8.d.a(2131106521, getContext()));
        this.a.k.setImageResource(2131241431);
        e1.v(this.a.d, r0);
        FrameLayout r2 = this.a.m;
        GradientDrawable r3 = new GradientDrawable();
        r3.setShape(0);
        r3.setColors(new int[]{0, r6, r6, r6, r6, r6, r6, r6, r6, r6});
        r3.setAlpha(52);
        r2.setBackground(r3);
    }

    public final void setInputText(String r4) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("set input text = ");
        if (r4 == null) goto L5;
        Integer r2 = Integer.valueOf(r4.length());
    L6:
        r1.append(r2);
        r0.i("ObricFullScreenEditFrameLayout", r1.toString());
        this.a.l.setText(r4);
        EditText r3 = this.a.l;
        boolean r5 = false;
        if (r4 == null) goto L9;
        int r6 = r4.length();
    L10:
        r3.setSelection(r6);
        this.a.l.setFocusable(true);
        AppCompatImageView r7 = this.a.c;
        if (r4 != null) goto L13;
    L16:
        boolean r8 = true;
    L17:
        if (r8 == true) goto L20;
        r5 = true;
    L20:
        r7.setEnabled(r5);
        this.a.g.post(new e(this));
        return;
    L13:
        if (StringsKt.isBlank(r4) == true) goto L16;
        r8 = false;
        goto L17
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [com.obric.assistant.window.fullscreenedit.ObricFullScreenEditFrameLayout$imeListener$1] */
    public ObricFullScreenEditFrameLayout(Context r19, AttributeSet r20) {
        Intrinsics.checkNotNullParameter(r19, "context");
        super(r19, r20);
        View r1 = LayoutInflater.from(r19).inflate(2131563374, this, false);
        addView(r1);
        int r2 = 2131362094;
        ConstraintLayout r6 = ViewBindings.findChildViewById(r1, 2131362094);
        if (r6 == null) goto L31;
        r2 = 2131362132;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r1, 2131362132);
        if (r7 == null) goto L31;
        r2 = 2131362153;
        if (ViewBindings.findChildViewById(r1, 2131362153) == null) goto L31;
        r2 = 2131364510;
        View r8 = ViewBindings.findChildViewById(r1, 2131364510);
        if (r8 == null) goto L31;
        r2 = 2131367793;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131367793);
        if (r9 == null) goto L31;
        r2 = 2131371401;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131371401);
        if (r10 == null) goto L31;
        r2 = 2131371458;
        ScrollView r11 = (ScrollView) ViewBindings.findChildViewById(r1, 2131371458);
        if (r11 == null) goto L31;
        FrameLayout r12 = (FrameLayout) r1;
        r2 = 2131373350;
        ConstraintLayout r13 = ViewBindings.findChildViewById(r1, 2131373350);
        if (r13 == null) goto L31;
        r2 = 2131374688;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131374688);
        if (r14 == null) goto L31;
        r2 = 2131374689;
        AppCompatImageView r15 = ViewBindings.findChildViewById(r1, 2131374689);
        if (r15 == null) goto L31;
        r2 = 2131375366;
        EditText r16 = (EditText) ViewBindings.findChildViewById(r1, 2131375366);
        if (r16 == null) goto L31;
        r2 = 2131375385;
        if (ViewBindings.findChildViewById(r1, 2131375385) == null) goto L31;
        r2 = 2131392727;
        FrameLayout r17 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131392727);
        if (r17 == null) goto L31;
        this.a = new LayoutObricChatFullScreenEditBinding(r12, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
        this.d = new zha.a();
        this.e = CoroutineScopeKt.MainScope();
        this.f = new ObricFullScreenEditFrameLayout$imeListener$1(this);
        return;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }
}
