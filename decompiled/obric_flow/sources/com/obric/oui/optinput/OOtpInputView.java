package com.obric.oui.optinput;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import jm.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import wr.b;
import wr.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00030)7B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u000b2\b\b\u0001\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\rJ\u0015\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010!J\u0015\u0010#\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b#\u0010!J\u0017\u0010$\u001a\u00020\u000b2\b\b\u0001\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b$\u0010\rJ\u0017\u0010%\u001a\u00020\u000b2\b\b\u0001\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b%\u0010\rJ\u0015\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u001e¢\u0006\u0004\b'\u0010!J\u0017\u0010(\u001a\u00020\u000b2\b\b\u0001\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b(\u0010\rR$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "length", "", "setCodeLength", "(I)V", "getCodeLength", "()I", "", "getCode", "()Ljava/lang/String;", "code", "setCode", "(Ljava/lang/String;)V", "", "enabled", "setPasswordMode", "(Z)V", "visible", "setCursorVisible", "color", "setCursorColor", "", "px", "setCellSpacing", "(F)V", "setCellCornerRadius", "setCellStrokeWidth", "setCellStrokeColor", "setCellBackgroundColor", "sp", "setTextSizeSp", "setTextColor", "Lwr/b;", "onCodeCompleteListener", "Lwr/b;", "getOnCodeCompleteListener", "()Lwr/b;", "setOnCodeCompleteListener", "(Lwr/b;)V", "Lwr/a;", "onCodeChangeListener", "Lwr/a;", "getOnCodeChangeListener", "()Lwr/a;", "setOnCodeChangeListener", "(Lwr/a;)V", "wr/c", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OOtpInputView extends View {
    public float A;
    public float B;
    public float C;
    public boolean D;
    public boolean E;
    public final a F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public char[] f13681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13682c;
    public final float d;
    public final float e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f13683h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13684i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13685j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13686k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f13687l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13688m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13689n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13690o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint f13691p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint f13692q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Paint f13693r;
    public final Paint s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RectF f13694t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Paint.FontMetrics f13695u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f13696v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final char[] f13697w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f13698x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f13699y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f13700z;

    @JvmOverloads
    public OOtpInputView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final void a(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.CONTENT_TYPE_TEXT);
        if (this.f13682c < this.f13680a) goto L5;
        return;
    L5:
        int r5 = 0;
        boolean r11 = false;
    L7:
        if (r5 >= r10.length()) goto L16;
        char r12 = r10.charAt(r5);
        r5 = r5 + 1;
        if (Character.isDigit(r12) == false) goto L7;
        int r13 = this.f13682c;
        int r14 = this.f13680a;
        if (r13 >= r14) goto L16;
        this.f13681b[r13] = r12;
        int r15 = r13 + 1;
        this.f13682c = r15;
        r11 = true;
        if (r15 < r14) goto L7;
    L16:
        if (r11 == false) goto L26;
        invalidate();
        return;
    }

    public final boolean b() {
        int r5 = this.f13682c;
        boolean r10 = false;
        if (r5 <= 0) goto L17;
        int r11 = RangesKt.coerceAtLeast(r5 - 1, 0);
        char[] r12 = this.f13681b;
        if (r12[r11] != 0) goto L16;
        if (r11 < 0) goto L15;
    L8:
        int r13 = r11 - 1;
        char[] r14 = this.f13681b;
        if (r14[r11] != 0) goto L10;
        if (r13 < 0) goto L15;
        r11 = r13;
        goto L8
    L10:
        r14[r11] = 0;
        this.f13682c = r11;
    L11:
        r10 = true;
    L15:
        this.f13682c = 0;
        goto L17
    L16:
        r12[r11] = 0;
        this.f13682c = r11;
    L17:
        if (r10 == false) goto L19;
        invalidate();
    L19:
        return r10;
    }

    public final void c() {
        Object r5 = getContext().getSystemService("input_method");
        if ((r5 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r10 = (InputMethodManager) r5;
    L6:
        if (r10 == null) goto L10;
        r10.showSoftInput(this, 1);
        return;
    L10:
        return;
    L5:
        r10 = null;
        goto L6
    }

    public final void d() {
        if (this.E == false) goto L5;
        return;
    L5:
        this.E = true;
        this.D = true;
        a r5 = this.F;
        removeCallbacks(r5);
        postDelayed(r5, 500);
    }

    public final String getCode() {
        StringBuilder r5 = new StringBuilder(this.f13680a);
        int r10 = this.f13680a;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        int r12 = r11 + 1;
        char r13 = this.f13681b[r11];
        if (r13 == 0) goto L8;
        r5.append(r13);
        r11 = r12;
    L8:
        return r5.toString();
    }

    public final int getCodeLength() {
        return this.f13680a;
    }

    public final wr.a getOnCodeChangeListener() {
        return null;
    }

    public final b getOnCodeCompleteListener() {
        return null;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isFocusable() == false) goto L10;
        if (isFocusableInTouchMode() == false) goto L10;
        if (isInEditMode() == true) goto L10;
        requestFocus();
        c();
    L10:
        if (hasFocus() == true) goto L12;
        return;
    L12:
        if (this.f13690o == false) goto L16;
        d();
        return;
    }

    @Override // android.view.View
    public final boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        this.B = com.lynx.tasm.utils.a.D(4.0f, this);
        this.C = com.lynx.tasm.utils.a.D(1.0f, this);
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "outAttrs");
        if (this.f13689n == false) goto L5;
        int r10 = 16;
    L6:
        r5.inputType = r10 | 2;
        r5.imeOptions = 268435462;
        int r11 = this.f13682c;
        r5.initialSelStart = r11;
        r5.initialSelEnd = r11;
        return new c(this);
    L5:
        r10 = 0;
        goto L6
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.E = false;
        removeCallbacks(this.F);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r14) {
        Intrinsics.checkNotNullParameter(r14, "canvas");
        super.onDraw(r14);
        Paint r10 = this.f13691p;
        r10.setColor(this.f13684i);
        Paint r11 = this.f13692q;
        r11.setColor(this.f13685j);
        int r12 = this.f13680a;
        int r5 = 0;
    L3:
        float r13 = this.e;
        float r15 = this.d;
        if (r5 >= r12) goto L16;
        int r16 = r5 + 1;
        float r17 = ((this.A + r15) * r5) + this.f13698x;
        float r18 = this.f13699y;
        RectF r19 = this.f13694t;
        r19.set(r17, r18, r15 + r17, r13 + r18);
        float r20 = this.g;
        r14.drawRoundRect(r19, r20, r20, r10);
        float r21 = this.f13683h;
        if (r21 <= 0.0f) goto L8;
        float r22 = r21 / 2.0f;
        float r23 = RangesKt.coerceAtLeast(this.g - r22, 0.0f);
        r19.inset(r22, r22);
        r14.drawRoundRect(r19, r23, r23, r11);
        float r24 = -r22;
        r19.inset(r24, r24);
    L8:
        char r25 = this.f13681b[r5];
        if (r25 == 0) goto L14;
        float r26 = r19.centerX();
        boolean r27 = this.f13689n;
        Paint r28 = this.f13693r;
        if (r27 == false) goto L13;
        r14.drawCircle(r26, this.f13700z, this.B, r28);
        goto L14
    L13:
        char[] r29 = this.f13697w;
        r29[0] = r25;
        r14.drawText(r29, 0, 1, r26, this.f13700z + this.f13696v, r28);
    L14:
        r5 = r16;
        goto L3
    L16:
        if (isFocused() == true) goto L18;
        return;
    L18:
        if (this.f13690o == true) goto L21;
        return;
    L21:
        if (this.D == false) goto L34;
        int r30 = this.f13682c;
        int r31 = this.f13680a;
        if (r30 >= r31) goto L35;
        int r32 = RangesKt.coerceIn(r30, 0, r31 - 1);
        float r33 = ((this.A + r15) * r32) + this.f13698x;
        float r34 = ((r15 + r33) + r33) / 2.0f;
        float r35 = this.f13700z;
        float r36 = (r13 * 0.375f) / 2.0f;
        float r37 = r35 - r36;
        float r38 = r35 + r36;
        float r39 = this.C;
        r14.drawRect(r34 - r39, r37, r34 + r39, r38, this.s);
        return;
    L35:
        return;
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean r5, int r10, Rect r11) {
        super.onFocusChanged(r5, r10, r11);
        if (r5 == true) goto L5;
        this.E = false;
        removeCallbacks(this.F);
        Object r12 = getContext().getSystemService("input_method");
        if ((r12 instanceof InputMethodManager) == false) goto L11;
        InputMethodManager r13 = (InputMethodManager) r12;
    L12:
        if (r13 == null) goto L15;
        r13.hideSoftInputFromWindow(getWindowToken(), 0);
    L15:
        invalidate();
        return;
    L11:
        r13 = null;
        goto L12
    L5:
        if (this.f13690o == false) goto L7;
        d();
    L7:
        c();
        goto L15
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r5, KeyEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (r5 != 67) goto L8;
        if (b() == false) goto L8;
        return true;
    L8:
        if (r5 < 7) goto L14;
        if (r5 > 16) goto L14;
        a(String.valueOf((char) (r5 + 41)));
        return true;
    L14:
        if (r5 < 144) goto L20;
        if (r5 > 153) goto L20;
        a(String.valueOf((char) (r5 - 96)));
        return true;
    L20:
        return super.onKeyDown(r5, r10);
    }

    @Override // android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        int r14 = ((r12 - r10) - getPaddingLeft()) - getPaddingRight();
        int r15 = ((r13 - r11) - getPaddingTop()) - getPaddingBottom();
        float r16 = this.f;
        int r17 = this.f13680a;
        float r18 = this.d;
        float r19 = r14;
        if ((((r17 - 1) * r16) + (r17 * r18)) <= r19) goto L8;
        if (r17 <= 1) goto L8;
        r16 = (r19 - (r17 * r18)) / (r17 - 1);
        if (r16 >= 0.0f) goto L8;
        r16 = 0.0f;
    L8:
        this.A = r16;
        this.f13698x = androidx.constraintlayout.motion.widget.a.a(r19, (r16 * (r17 - 1)) + (r18 * r17), 2.0f, getPaddingLeft());
        float r20 = getPaddingTop();
        float r21 = this.e;
        float r22 = androidx.constraintlayout.motion.widget.a.a(r15, r21, 2.0f, r20);
        this.f13699y = r22;
        this.f13700z = (r21 / 2.0f) + r22;
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r10) {
        int r11 = this.f13680a;
        setMeasuredDimension(View.resolveSize((int) ((getPaddingRight() + getPaddingLeft()) + ((this.f * (r11 - 1)) + (this.d * r11))), r5), View.resolveSize((int) ((getPaddingBottom() + getPaddingTop()) + this.e), r10));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r10 = r5.getAction();
        if (r10 == 0) goto L9;
        if (r10 != 1) goto L6;
        super.performClick();
        return true;
    L6:
        return super.onTouchEvent(r5);
    L9:
        requestFocus();
        c();
        return true;
    }

    @Override // android.view.View
    public final boolean performClick() {
        super.performClick();
        return true;
    }

    public final void setCellBackgroundColor(@ColorInt int r5) {
        if (this.f13684i != r5) goto L5;
        return;
    L5:
        this.f13684i = r5;
        invalidate();
    }

    public final void setCellCornerRadius(float r5) {
        if (this.g != r5) goto L5;
        return;
    L5:
        this.g = r5;
        invalidate();
    }

    public final void setCellSpacing(float r5) {
        if (this.f != r5) goto L5;
        return;
    L5:
        this.f = r5;
        requestLayout();
    }

    public final void setCellStrokeColor(@ColorInt int r5) {
        if (this.f13685j != r5) goto L5;
        return;
    L5:
        this.f13685j = r5;
        invalidate();
    }

    public final void setCellStrokeWidth(float r5) {
        if (this.f13683h != r5) goto L5;
        return;
    L5:
        this.f13683h = r5;
        this.f13692q.setStrokeWidth(r5);
        invalidate();
    }

    public final void setCode(String r10) {
        int r5 = this.f13680a;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L5;
        this.f13681b[r12] = 0;
        r12 = r12 + 1;
        goto L3
    L5:
        this.f13682c = 0;
        if (r10 != null) goto L8;
    L22:
        invalidate();
        return;
    L8:
        if (r10.length() == 0) goto L22;
        int r13 = 0;
    L12:
        if (r11 >= r10.length()) goto L20;
        char r14 = r10.charAt(r11);
        r11 = r11 + 1;
        if (Character.isDigit(r14) == false) goto L12;
        if (r13 >= this.f13680a) goto L20;
        this.f13681b[r13] = r14;
        r13 = r13 + 1;
    L20:
        this.f13682c = r13;
        invalidate();
    }

    public final void setCodeLength(int r10) {
        int r11 = RangesKt.coerceIn(r10, 1, 6);
        if (r11 != this.f13680a) goto L5;
        return;
    L5:
        this.f13680a = r11;
        char[] r5 = this.f13681b;
        this.f13681b = new char[r11];
        int r12 = Math.min(r5.length, r11);
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L8;
        this.f13681b[r14] = r5[r14];
        r14 = r14 + 1;
        goto L6
    L8:
        int r15 = this.f13680a;
    L9:
        if (r13 >= r15) goto L14;
        int r16 = r13 + 1;
        if (this.f13681b[r13] == 0) goto L15;
        r13 = r16;
    L15:
        this.f13682c = r13;
        requestLayout();
        invalidate();
        return;
    L14:
        r13 = this.f13680a;
        goto L15
    }

    public final void setCursorColor(@ColorInt int r5) {
        if (this.f13688m != r5) goto L5;
        return;
    L5:
        this.f13688m = r5;
        this.s.setColor(r5);
        invalidate();
    }

    public final void setCursorVisible(boolean r5) {
        if (this.f13690o != r5) goto L5;
        return;
    L5:
        this.f13690o = r5;
        if (r5 == true) goto L9;
        this.E = false;
        removeCallbacks(this.F);
    L11:
        invalidate();
        return;
    L9:
        if (hasFocus() == false) goto L11;
        d();
        goto L11
    }

    public final void setOnCodeChangeListener(wr.a r5) {
    }

    public final void setOnCodeCompleteListener(b r5) {
    }

    public final void setPasswordMode(boolean r5) {
        if (this.f13689n != r5) goto L5;
        return;
    L5:
        this.f13689n = r5;
        invalidate();
        Object r10 = getContext().getSystemService("input_method");
        if ((r10 instanceof InputMethodManager) == false) goto L8;
        InputMethodManager r11 = (InputMethodManager) r10;
    L9:
        if (r11 == null) goto L13;
        r11.restartInput(this);
        return;
    L13:
        return;
    L8:
        r11 = null;
        goto L9
    }

    public final void setTextColor(@ColorInt int r5) {
        if (this.f13686k != r5) goto L5;
        return;
    L5:
        this.f13686k = r5;
        this.f13693r.setColor(r5);
        invalidate();
    }

    public final void setTextSizeSp(float r5) {
        float r10 = com.lynx.tasm.utils.a.G(r5, this);
        if (this.f13687l != r10) goto L5;
        return;
    L5:
        this.f13687l = r10;
        Paint r11 = this.f13693r;
        r11.setTextSize(r10);
        Paint.FontMetrics r12 = this.f13695u;
        r11.getFontMetrics(r12);
        this.f13696v = -((r12.ascent + r12.descent) / 2.0f);
        invalidate();
    }

    @JvmOverloads
    public OOtpInputView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OOtpInputView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OOtpInputView(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        this.f13680a = 6;
        this.f13681b = new char[6];
        Paint r5 = new Paint(1);
        this.f13691p = r5;
        Paint r10 = new Paint(1);
        this.f13692q = r10;
        Paint r11 = new Paint(1);
        this.f13693r = r11;
        Paint r15 = new Paint(1);
        this.s = r15;
        this.f13694t = new RectF();
        Paint.FontMetrics r16 = new Paint.FontMetrics();
        this.f13695u = r16;
        this.f13697w = new char[1];
        this.D = true;
        this.F = new a(this, 17);
        this.B = com.lynx.tasm.utils.a.D(4.0f, this);
        this.C = com.lynx.tasm.utils.a.D(1.0f, this);
        float r17 = com.lynx.tasm.utils.a.D(42.0f, this);
        this.d = r17;
        float r18 = com.lynx.tasm.utils.a.D(48.0f, this);
        this.e = r18;
        this.f = com.lynx.tasm.utils.a.D(12.0f, this);
        this.g = com.lynx.tasm.utils.a.D(10.0f, this);
        this.f13683h = com.lynx.tasm.utils.a.D(1.0f, this);
        this.f13687l = com.lynx.tasm.utils.a.G(20.0f, this);
        this.f13684i = ContextCompat.getColor(r12, R$color.oui_advanced_fill_list_item_card);
        this.f13685j = ContextCompat.getColor(r12, R$color.oui_advanced_fill_list_item_card);
        this.f13686k = ContextCompat.getColor(r12, R$color.oui_basic_text_1);
        this.f13688m = ContextCompat.getColor(r12, R$color.oui_functional_blue_6);
        this.f13689n = false;
        this.f13690o = true;
        if (r13 == null) goto L14;
        TypedArray r19 = r12.obtainStyledAttributes(r13, R$styleable.OOtpInputView, r14, 0);
        int r110 = RangesKt.coerceIn(r19.getInt(R$styleable.OOtpInputView_o_otpCodeLength, 6), 1, 6);     // Catch: Throwable -> L11
        if (r110 == this.f13680a) goto L9;
        this.f13680a = r110;     // Catch: Throwable -> L11
        this.f13681b = new char[r110];     // Catch: Throwable -> L11
        this.f13682c = 0;     // Catch: Throwable -> L11
    L9:
        this.d = r19.getDimension(R$styleable.OOtpInputView_o_otpCellWidth, r17);     // Catch: Throwable -> L11
        this.e = r19.getDimension(R$styleable.OOtpInputView_o_otpCellHeight, r18);     // Catch: Throwable -> L11
        this.f = r19.getDimension(R$styleable.OOtpInputView_o_otpCellSpacing, this.f);     // Catch: Throwable -> L11
        this.g = r19.getDimension(R$styleable.OOtpInputView_o_otpCellCornerRadius, this.g);     // Catch: Throwable -> L11
        this.f13683h = r19.getDimension(R$styleable.OOtpInputView_o_otpCellStrokeWidth, this.f13683h);     // Catch: Throwable -> L11
        this.f13684i = r19.getColor(R$styleable.OOtpInputView_o_otpCellBackgroundColor, this.f13684i);     // Catch: Throwable -> L11
        this.f13685j = r19.getColor(R$styleable.OOtpInputView_o_otpCellStrokeColor, this.f13685j);     // Catch: Throwable -> L11
        this.f13686k = r19.getColor(R$styleable.OOtpInputView_o_otpTextColor, this.f13686k);     // Catch: Throwable -> L11
        this.f13687l = r19.getDimension(R$styleable.OOtpInputView_o_otpTextSize, this.f13687l);     // Catch: Throwable -> L11
        this.f13688m = r19.getColor(R$styleable.OOtpInputView_o_otpCursorColor, this.f13688m);     // Catch: Throwable -> L11
        this.f13689n = r19.getBoolean(R$styleable.OOtpInputView_o_otpPasswordMode, this.f13689n);     // Catch: Throwable -> L11
        this.f13690o = r19.getBoolean(R$styleable.OOtpInputView_o_otpCursorVisible, this.f13690o);     // Catch: Throwable -> L11
        r19.recycle();
    L11:
        th = move-exception;
        r19.recycle();
        throw th;
    L14:
        setFocusable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        Paint.Style r111 = Paint.Style.FILL;
        r5.setStyle(r111);
        r10.setStyle(Paint.Style.STROKE);
        r10.setStrokeWidth(this.f13683h);
        r11.setColor(this.f13686k);
        r11.setTextSize(this.f13687l);
        r11.setTextAlign(Paint.Align.CENTER);
        r11.setTypeface(Typeface.create(Typeface.DEFAULT, 400, false));
        r15.setColor(this.f13688m);
        r15.setStyle(r111);
        r11.getFontMetrics(r16);
        this.f13696v = -((r16.ascent + r16.descent) / 2.0f);
    }
}
