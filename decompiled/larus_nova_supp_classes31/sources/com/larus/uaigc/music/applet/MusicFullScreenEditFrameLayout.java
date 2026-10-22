package com.larus.uaigc.music.applet;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.UIUtils;
import com.larus.bmhome.utils.x1;
import com.larus.uaigc.impl.databinding.LarusLayoutMusicFullScreenEditBinding;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.v5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJa\u0010'\u001a\u00020\u00152\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018¢\u0006\u0002\u0010+J\u0006\u0010,\u001a\u00020\u0015J\u0010\u0010-\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u00010\u0014J\u0010\u0010/\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u00010\u0014J\u000e\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u001bJ\u0010\u00102\u001a\u00020\u00152\b\b\u0002\u00103\u001a\u00020\u001bJ\u0006\u00104\u001a\u00020\u0015J\u0010\u00105\u001a\u00020\u00152\b\b\u0002\u00106\u001a\u00020\u0007J\u0010\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u0015H\u0014J\b\u0010;\u001a\u00020\u0015H\u0014J\u0010\u0010<\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u001bH\u0002J\b\u0010=\u001a\u00020\u0015H\u0002J\b\u0010>\u001a\u00020\u0015H\u0002J\b\u0010?\u001a\u00020\u0007H\u0002J\b\u0010@\u001a\u00020\u0015H\u0002J\b\u0010A\u001a\u00020\u0015H\u0002J\u0010\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u0007H\u0002J\u0012\u0010D\u001a\u00020\u00152\b\b\u0002\u00103\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/larus/uaigc/music/applet/MusicFullScreenEditFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutMusicFullScreenEditBinding;", "lastTouchX", "", "lastTouchY", "startTopMargin", "textWatcher", "Landroid/text/TextWatcher;", "onUpdateInputText", "Lkotlin/Function1;", "", "", "onAiGenerate", "onClosing", "Lkotlin/Function0;", "onDismiss", "isClosing", "", "isAiGenerating", "aiGeneratingAnimator", "Landroid/animation/ObjectAnimator;", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "getImeManager", "()Lcom/larus/bmhome/utils/ImeManager;", "imeManager$delegate", "Lkotlin/Lazy;", "showImeRunnable", "Ljava/lang/Runnable;", "init", "inputFilters", "", "Landroid/text/InputFilter;", "([Landroid/text/InputFilter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "dealClickEvent", "setInputText", "text", "appendInputText", "setAiGenerating", "generating", "dismiss", "updateInputText", "removeView", "adaptPadding", "margin", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onAttachedToWindow", "onDetachedFromWindow", "updateAiGeneratingIcon", "startAiGeneratingAnimation", "stopAiGeneratingAnimation", "getImeHeight", "setupSendClick", "updateChatInputText", "dealOpenFullScreenEditView", "startMargin", "dealCloseFullScreenEditView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MusicFullScreenEditFrameLayout extends FrameLayout {
    public static final /* synthetic */ int m = 0;
    public final LarusLayoutMusicFullScreenEditBinding a;
    public float b;
    public b c;
    public Function1<? super String, Unit> d;
    public Function1<? super String, Unit> e;
    public Function0<Unit> f;
    public Function0<Unit> g;
    public boolean h;
    public boolean i;
    public ObjectAnimator j;
    public final Lazy k;
    public final y l;

    public static final class a {
    }

    public static final class b implements TextWatcher {
        public final /* synthetic */ MusicFullScreenEditFrameLayout a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public b(MusicFullScreenEditFrameLayout r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            MusicFullScreenEditFrameLayout r0 = this.a;
            AppCompatTextView r1 = r0.a.c;
            boolean r2 = false;
            if (r0.i == false) goto L5;
        L13:
            r1.setEnabled(r2);
            AppCompatTextView r5 = this.a.a.c;
            if (r5.isEnabled() == false) goto L16;
            float r3 = 1.0f;
        L17:
            r5.setAlpha(r3);
            return;
        L16:
            r3 = 0.4f;
            goto L17
        L5:
            if (r4 != null) goto L7;
        L10:
            boolean r6 = true;
        L11:
            if (r6 == true) goto L13;
            r2 = true;
            goto L13
        L7:
            if (StringsKt.isBlank(r4) == true) goto L10;
            r6 = false;
            goto L11
        }
    }

    static {
    }

    public MusicFullScreenEditFrameLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MusicFullScreenEditFrameLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static /* synthetic */ void b(MusicFullScreenEditFrameLayout r0) {
        setInputText$lambda$9(r0);
    }

    private final x1 getImeManager() {
        return (x1) this.k.getValue();
    }

    public final void e() {
        ObjectAnimator r0 = this.j;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        this.a.b.setRotation(0.0f);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.a.b, "rotation", new float[]{0.0f, 360.0f});
        r2.setDuration(1000);
        r2.setRepeatCount(-1);
        r2.setRepeatMode(1);
        r2.setInterpolator(new LinearInterpolator());
        r2.start();
        this.j = r2;
        return;
    L5:
        if (r0.isStarted() != true) goto L7;
        r1 = true;
        goto L7
    }

    private final int getImeHeight() {
        FragmentActivity r0 = getContext();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L7:
        if (r1 != null) goto L9;
        return 0;
    L9:
        Window r2 = r1.getWindow();
        if (r2 == null) goto L20;
        View r3 = r2.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L16;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L16;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L16:
        if (r3 == null) goto L20;
        Rect r5 = new Rect();
        r3.getWindowVisibleDisplayFrame(r5);
        int r6 = com.larus.utils.w0.a;
        return (com.larus.utils.w0.c(r1) - r5.bottom) - com.larus.utils.u.b(r1);
    L20:
        return 0;
    L5:
        r1 = null;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d(UIUtils.getScreenHeight(getContext()));
        com.larus.utils.e1.d(this.a.c, new p(this));
        v5 r0 = new v5();
        FrameLayout r1 = this.a.j;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L21;
        FragmentActivity r4 = null;
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L8:
        if (r3 == null) goto L10;
        r3.bottomMargin = getImeHeight();
    L10:
        r0.b = getImeHeight();
        r1.setLayoutParams(r2);
        Context r5 = getContext();
        if ((r5 instanceof FragmentActivity) == false) goto L13;
        r4 = (FragmentActivity) r5;
    L13:
        if (r4 == null) goto L15;
        r0.a(r4, getRootView(), new o(this));
    L15:
        EditText r6 = this.a.l;
        b r7 = new b(this);
        r6.addTextChangedListener(r7);
        this.c = r7;
        if (this.i == false) goto L18;
        e();
    L18:
        postDelayed(this.l, 300);
        return;
    L7:
        r3 = null;
        goto L8
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.l);
        ObjectAnimator r0 = this.j;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.j = null;
        this.a.b.setRotation(0.0f);
        b r1 = this.c;
        if (r1 == null) goto L9;
        this.a.l.removeTextChangedListener(r1);
        return;
    }

    public static void a(MusicFullScreenEditFrameLayout r1) {
        if (r1.isAttachedToWindow() == false) goto L7;
        r1.a.l.requestFocus();
        x1.d(r1.getImeManager(), 3);
        return;
    }

    private static final void setInputText$lambda$9(MusicFullScreenEditFrameLayout r1) {
        r1.a.i.fullScroll(130);
    }

    public final void c(boolean r8) {
        if (this.h == false) goto L5;
        return;
    L5:
        this.h = true;
        if (r8 == false) goto L16;
        Editable r9 = this.a.l.getText();
        if (r9 != null) goto L10;
    L13:
        boolean r10 = true;
    L14:
        if (r10 == true) goto L16;
        this.d.invoke(this.a.l.getText().toString());
        goto L16
    L10:
        if (StringsKt.isBlank(r9) == true) goto L13;
        r10 = false;
    L16:
        this.f.invoke();
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r2.setDuration(100);
        r2.addUpdateListener(new a0(this));
        ViewGroup.LayoutParams r3 = this.a.k.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        final ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        ValueAnimator r5 = ValueAnimator.ofInt(new int[]{r4.topMargin, UIUtils.getScreenHeight(getContext())});
        r5.setDuration(300);
        r5.addUpdateListener(new n(r4, this));
        AnimatorSet r6 = new AnimatorSet();
        r6.playTogether(new Animator[]{r5, r2});
        r6.start();
    }

    public final void d(int r7) {
        ViewGroup.LayoutParams r0 = this.a.k.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        final ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{r7, 0});
        r2.setDuration(300);
        r2.addUpdateListener(new m(r1, this));
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r3.setDuration(100);
        r3.setInterpolator(new AccelerateInterpolator());
        r3.addUpdateListener(new s(this));
        AnimatorSet r4 = new AnimatorSet();
        r4.playSequentially(new Animator[]{r2, r3});
        r4.start();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        r7.getRawX();
        float r0 = r7.getRawY();
        ViewGroup.LayoutParams r1 = this.a.k.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        int r8 = r7.getAction();
        if (r8 != 0) goto L5;
        this.b = r0;
    L24:
        return true;
    L5:
        if (r8 != 1) goto L7;
        int r9 = r2.topMargin;
        if (r9 < 400) goto L22;
        c(false);
        goto L24
    L22:
        d(r9);
        goto L24
    L7:
        if (r8 != 2) goto L24;
        float r10 = r0 - this.b;
        int r4 = r2.topMargin;
        if (r4 < 0) goto L15;
        if ((r4 + r10) < 0) goto L15;
        int r11 = (int) r10;
        r2.topMargin = r4 + r11;
        r2.bottomMargin -= r11;
        this.a.k.setLayoutParams(r2);
    L15:
        if (r2.topMargin <= 0) goto L17;
        this.a.d.setAlpha(0.0f);
    L18:
        this.b = r0;
        goto L24
    L17:
        this.a.d.setAlpha(1.0f);
        goto L18
    }

    public final void setAiGenerating(boolean r6) {
        this.i = r6;
        boolean r1 = !r6;
        this.a.b.setEnabled(r1);
        this.a.c.setEnabled(r1);
        this.a.l.setEnabled(r1);
        EditText r0 = this.a.l;
        Context r2 = getContext();
        if (r6 == false) goto L5;
        int r3 = 2130972081;
    L6:
        Context r4 = getContext();
        if (r6 == false) goto L9;
        int r5 = 2131103143;
    L10:
        r0.setTextColor(ContextCompat.getColor(r2, v19.c.b(r3, r4, r5)));
        EditText r7 = this.a.l;
        if (r6 == false) goto L13;
        int r8 = 2131907929;
    L14:
        r7.setHint(r8);
        if (r6 == false) goto L17;
        this.a.b.setImageResource(2131240816);
        e();
    L21:
        AppCompatImageView r9 = this.a.b;
        float r10 = 1.0f;
        if (r6 == false) goto L24;
        float r11 = 0.4f;
    L25:
        r9.setAlpha(r11);
        AppCompatTextView r12 = this.a.c;
        if (r12.isEnabled() == true) goto L29;
        r10 = 0.4f;
    L29:
        r12.setAlpha(r10);
        return;
    L24:
        r11 = 1.0f;
        goto L25
    L17:
        ObjectAnimator r13 = this.j;
        if (r13 == null) goto L20;
        r13.cancel();
    L20:
        this.j = null;
        this.a.b.setRotation(0.0f);
        this.a.b.setImageResource(2131240814);
        goto L21
    L13:
        r8 = 2131907931;
        goto L14
    L9:
        r5 = 2131103136;
        goto L10
    L5:
        r3 = 2130972079;
        goto L6
    }

    public final void setInputText(String r4) {
        this.a.l.setText(r4);
        EditText r0 = this.a.l;
        Editable r1 = r0.getText();
        boolean r2 = false;
        if (r1 == null) goto L5;
        int r3 = r1.length();
    L6:
        r0.setSelection(r3);
        this.a.l.setFocusable(true);
        AppCompatTextView r5 = this.a.c;
        if (r4 != null) goto L9;
    L10:
        r2 = true;
    L11:
        r5.setEnabled(!r2);
        AppCompatTextView r6 = this.a.c;
        if (r6.isEnabled() == false) goto L14;
        float r7 = 1.0f;
    L15:
        r6.setAlpha(r7);
        this.a.i.post(new z(this));
        return;
    L14:
        r7 = 0.4f;
        goto L15
    L9:
        if (StringsKt.isBlank(r4) == false) goto L11;
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [com.larus.uaigc.music.applet.y] */
    public MusicFullScreenEditFrameLayout(Context r19, AttributeSet r20, int r21) {
        Intrinsics.checkNotNullParameter(r19, "context");
        super(r19, r20, r21);
        View r1 = LayoutInflater.from(r19).inflate(2131562854, this, false);
        addView(r1);
        int r2 = 2131362038;
        AppCompatImageView r6 = ViewBindings.findChildViewById(r1, 2131362038);
        if (r6 == null) goto L29;
        r2 = 2131362081;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r1, 2131362081);
        if (r7 == null) goto L29;
        r2 = 2131362094;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r1, 2131362094);
        if (r8 == null) goto L29;
        r2 = 2131364510;
        View r9 = ViewBindings.findChildViewById(r1, 2131364510);
        if (r9 == null) goto L29;
        r2 = 2131366988;
        AppCompatImageView r10 = ViewBindings.findChildViewById(r1, 2131366988);
        if (r10 == null) goto L29;
        r2 = 2131367793;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131367793);
        if (r11 == null) goto L29;
        r2 = 2131371401;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131371401);
        if (r12 == null) goto L29;
        r2 = 2131371458;
        ScrollView r13 = (ScrollView) ViewBindings.findChildViewById(r1, 2131371458);
        if (r13 == null) goto L29;
        FrameLayout r14 = (FrameLayout) r1;
        r2 = 2131373350;
        ConstraintLayout r15 = ViewBindings.findChildViewById(r1, 2131373350);
        if (r15 == null) goto L29;
        r2 = 2131375366;
        EditText r16 = (EditText) ViewBindings.findChildViewById(r1, 2131375366);
        if (r16 == null) goto L29;
        r2 = 2131375385;
        if (ViewBindings.findChildViewById(r1, 2131375385) == null) goto L29;
        r2 = 2131392727;
        FrameLayout r17 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131392727);
        if (r17 == null) goto L29;
        this.a = new LarusLayoutMusicFullScreenEditBinding(r14, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
        this.d = new t();
        this.e = new u();
        this.f = new v();
        this.g = new w();
        this.k = LazyKt.lazy(new x(this));
        this.l = new y(this);
        return;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    public /* synthetic */ MusicFullScreenEditFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
