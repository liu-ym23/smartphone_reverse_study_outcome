package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class y extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f1316b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l f1317m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1318n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c f1319o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Future<h0.c> f1320p;

    public interface a {
        void a(int r8);

        void b(int r8);
    }

    public class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f1321a;

        public b(y r8) {
            this.f1321a = r8;
        }
    }

    public class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f1322b;

        public c(y r8) {
            this.f1322b = r8;
            super(r8);
        }

        @Override // androidx.appcompat.widget.y.a
        public final void a(int r8) {
            y.g(this.f1322b, r8);
        }

        @Override // androidx.appcompat.widget.y.a
        public final void b(int r8) {
            y.e(this.f1322b, r8);
        }
    }

    public y() {
        throw null;
    }

    public y(Context r8, AttributeSet r10) {
        this(r8, r10, R.attr.textViewStyle);
    }

    public static /* synthetic */ int d(y r8) {
        return super.getAutoSizeMaxTextSize();
    }

    public static /* synthetic */ void e(y r8, int r10) {
        super.setFirstBaselineToTopHeight(r10);
    }

    public static /* synthetic */ int f(y r8) {
        return super.getAutoSizeMinTextSize();
    }

    public static /* synthetic */ void g(y r8, int r10) {
        super.setLastBaselineToBottomHeight(r10);
    }

    private l getEmojiTextViewHelper() {
        if (this.f1317m != null) goto L6;
        this.f1317m = new l(this);
    L6:
        return this.f1317m;
    }

    public static /* synthetic */ int h(y r8) {
        return super.getAutoSizeStepGranularity();
    }

    public static /* synthetic */ int[] i(y r8) {
        return super.getAutoSizeTextAvailableSizes();
    }

    public static /* synthetic */ int j(y r8) {
        return super.getAutoSizeTextType();
    }

    public static /* synthetic */ TextClassifier k(y r8) {
        return super.getTextClassifier();
    }

    public static /* synthetic */ void l(y r8, int r10, int r11, int r12, int r13) {
        super.setAutoSizeTextTypeUniformWithConfiguration(r10, r11, r12, r13);
    }

    public static /* synthetic */ void m(y r8, int[] r10, int r11) {
        super.setAutoSizeTextTypeUniformWithPresetSizes(r10, r11);
    }

    public static /* synthetic */ void n(y r8, int r10) {
        super.setAutoSizeTextTypeWithDefaults(r10);
    }

    public static /* synthetic */ void o(y r8, TextClassifier r10) {
        super.setTextClassifier(r10);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        d r8 = this.f1315a;
        if (r8 == null) goto L5;
        r8.a();
    L5:
        w r10 = this.f1316b;
        if (r10 == null) goto L9;
        r10.b();
        return;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        Method r8 = b1.f1104a;
        return d(((b) getSuperCaller()).f1321a);
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        Method r8 = b1.f1104a;
        return f(((b) getSuperCaller()).f1321a);
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        Method r8 = b1.f1104a;
        return h(((b) getSuperCaller()).f1321a);
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        Method r8 = b1.f1104a;
        return i(((b) getSuperCaller()).f1321a);
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        Method r8 = b1.f1104a;
        if (j(((b) getSuperCaller()).f1321a) == 1) goto L7;
        return 0;
    L7:
        return 1;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        ActionMode.Callback r8 = super.getCustomSelectionActionModeCallback();
        if ((r8 instanceof androidx.core.widget.o) == false) goto L6;
        ((androidx.core.widget.o) r8).getClass();
        return null;
    L6:
        return r8;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public a getSuperCaller() {
        if (this.f1319o != null) goto L6;
        this.f1319o = new c(this);
    L6:
        return this.f1319o;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d r8 = this.f1315a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d r8 = this.f1315a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.c();
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1316b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1316b.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future<h0.c> r8 = this.f1320p;
        if (r8 == null) goto L7;
        this.f1320p = null;     // Catch: Throwable -> L8
        r8.get().getClass();     // Catch: Throwable -> L8
        setText(null);     // Catch: Throwable -> L8
    L7:
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return k(((b) getSuperCaller()).f1321a);
    }

    public h0.c.a getTextMetricsParamsCompat() {
        return new h0.c.a(androidx.core.widget.n.b(this));
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r8) {
        InputConnection r10 = super.onCreateInputConnection(r8);
        this.f1316b.getClass();
        defpackage.c.V(this, r8, r10);
        return r10;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        w r14 = this.f1316b;
        if (r14 == null) goto L6;
        r14.getClass();
        Method r15 = b1.f1104a;
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r8, int r10) {
        Future<h0.c> r11 = this.f1320p;
        if (r11 != null) goto L9;
    L6:
        super.onMeasure(r8, r10);
        return;
    L9:
        this.f1320p = null;     // Catch: Throwable -> L8
        r11.get().getClass();     // Catch: Throwable -> L8
        setText(null);     // Catch: Throwable -> L8
        goto L6
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r8, int r10, int r11, int r12) {
        super.onTextChanged(r8, r10, r11, r12);
        if (this.f1316b == null) goto L6;
        Method r13 = b1.f1104a;
        return;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r8) {
        super.setAllCaps(r8);
        getEmojiTextViewHelper().b(r8);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int r8, int r10, int r11, int r12) {
        Method r13 = b1.f1104a;
        l(((b) getSuperCaller()).f1321a, r8, r10, r11, r12);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] r8, int r10) {
        Method r11 = b1.f1104a;
        m(((b) getSuperCaller()).f1321a, r8, r10);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int r8) {
        Method r10 = b1.f1104a;
        n(((b) getSuperCaller()).f1321a, r8);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r8) {
        super.setBackgroundDrawable(r8);
        d r10 = this.f1315a;
        if (r10 == null) goto L6;
        r10.e();
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r8) {
        super.setBackgroundResource(r8);
        d r10 = this.f1315a;
        if (r10 == null) goto L6;
        r10.f(r8);
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawables(r8, r10, r11, r12);
        w r13 = this.f1316b;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawablesRelative(r8, r10, r11, r12);
        w r13 = this.f1316b;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int r8, int r10, int r11, int r12) {
        Context r13 = getContext();
        Drawable r14 = null;
        if (r8 == 0) goto L5;
        Drawable r15 = d.a.a(r13, r8);
    L6:
        if (r10 == 0) goto L8;
        Drawable r16 = d.a.a(r13, r10);
    L9:
        if (r11 == 0) goto L11;
        Drawable r17 = d.a.a(r13, r11);
    L12:
        if (r12 == 0) goto L14;
        r14 = d.a.a(r13, r12);
    L14:
        setCompoundDrawablesRelativeWithIntrinsicBounds(r15, r16, r17, r14);
        w r18 = this.f1316b;
        if (r18 == null) goto L18;
        r18.b();
        return;
    L18:
        return;
    L11:
        r17 = null;
        goto L12
    L8:
        r16 = null;
        goto L9
    L5:
        r15 = null;
        goto L6
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int r8, int r10, int r11, int r12) {
        Context r13 = getContext();
        Drawable r14 = null;
        if (r8 == 0) goto L5;
        Drawable r15 = d.a.a(r13, r8);
    L6:
        if (r10 == 0) goto L8;
        Drawable r16 = d.a.a(r13, r10);
    L9:
        if (r11 == 0) goto L11;
        Drawable r17 = d.a.a(r13, r11);
    L12:
        if (r12 == 0) goto L14;
        r14 = d.a.a(r13, r12);
    L14:
        setCompoundDrawablesWithIntrinsicBounds(r15, r16, r17, r14);
        w r18 = this.f1316b;
        if (r18 == null) goto L18;
        r18.b();
        return;
    L18:
        return;
    L11:
        r17 = null;
        goto L12
    L8:
        r16 = null;
        goto L9
    L5:
        r15 = null;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r8) {
        super.setCustomSelectionActionModeCallback(r8);
    }

    public void setEmojiCompatEnabled(boolean r8) {
        getEmojiTextViewHelper().c(r8);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] r8) {
        super.setFilters(getEmojiTextViewHelper().f1207b.f10113a.a(r8));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int r8) {
        getSuperCaller().b(r8);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int r8) {
        getSuperCaller().a(r8);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int r8) {
        t2.b.m(r8);
        int r10 = getPaint().getFontMetricsInt(null);
        if (r8 == r10) goto L6;
        setLineSpacing(r8 - r10, 1.0f);
        return;
    }

    public void setPrecomputedText(h0.c r8) {
        r8.getClass();
        setText(null);
    }

    public void setSupportBackgroundTintList(ColorStateList r8) {
        d r10 = this.f1315a;
        if (r10 == null) goto L6;
        r10.h(r8);
        return;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r8) {
        d r10 = this.f1315a;
        if (r10 == null) goto L6;
        r10.i(r8);
        return;
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList r8) {
        w r10 = this.f1316b;
        r10.h(r8);
        r10.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode r8) {
        w r10 = this.f1316b;
        r10.i(r8);
        r10.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r8, int r10) {
        super.setTextAppearance(r8, r10);
        w r11 = this.f1316b;
        if (r11 == null) goto L6;
        r11.g(r8, r10);
        return;
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier r8) {
        o(((b) getSuperCaller()).f1321a, r8);
    }

    public void setTextFuture(Future<h0.c> r8) {
        this.f1320p = r8;
        if (r8 == null) goto L6;
        requestLayout();
        return;
    }

    public void setTextMetricsParamsCompat(h0.c.a r8) {
        TextDirectionHeuristic r10 = r8.f7881b;
        if (r10 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L6;
    L26:
        int r11 = 1;
    L27:
        androidx.core.widget.l.h(this, r11);
        getPaint().set(r8.f7880a);
        androidx.core.widget.m.e(this, r8.f7882c);
        androidx.core.widget.m.h(this, r8.f7883d);
        return;
    L6:
        if (r10 == TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L26;
        if (r10 != TextDirectionHeuristics.ANYRTL_LTR) goto L12;
        r11 = 2;
        goto L27
    L12:
        if (r10 != TextDirectionHeuristics.LTR) goto L15;
        r11 = 3;
        goto L27
    L15:
        if (r10 != TextDirectionHeuristics.RTL) goto L18;
        r11 = 4;
        goto L27
    L18:
        if (r10 != TextDirectionHeuristics.LOCALE) goto L21;
        r11 = 5;
        goto L27
    L21:
        if (r10 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L24;
        r11 = 6;
        goto L27
    L24:
        if (r10 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L26;
        r11 = 7;
        goto L27
    }

    @Override // android.widget.TextView
    public final void setTextSize(int r8, float r10) {
        Method r11 = b1.f1104a;
        super.setTextSize(r8, r10);
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface r8, int r10) {
        if (this.f1318n == false) goto L5;
        return;
    L5:
        if (r8 == null) goto L12;
        if (r10 <= 0) goto L12;
        Context r11 = getContext();
        a0.f r12 = a0.e.f12a;
        if (r11 == null) goto L11;
        Typeface r13 = Typeface.create(r8, r10);
    L13:
        this.f1318n = true;
        if (r13 == null) goto L23;
        r8 = r13;
    L23:
        super.setTypeface(r8, r10);     // Catch: Throwable -> L20
        this.f1318n = false;
        return;
    L20:
        th = move-exception;
        this.f1318n = false;
        throw th;
    L11:
        throw new IllegalArgumentException("Context cannot be null");
    L12:
        r13 = null;
        goto L13
    }

    public y(Context r8, AttributeSet r10, int r11) {
        s0.a(r8);
        super(r8, r10, r11);
        this.f1318n = false;
        this.f1319o = null;
        q0.a(this, getContext());
        d r12 = new d(this);
        this.f1315a = r12;
        r12.d(r10, r11);
        w r13 = new w(this);
        this.f1316b = r13;
        r13.f(r10, r11);
        r13.b();
        new t2.b(this);
        getEmojiTextViewHelper().a(r10, r11);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r8, r10, r11, r12);
        w r13 = this.f1316b;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawablesWithIntrinsicBounds(r8, r10, r11, r12);
        w r13 = this.f1316b;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }
}
