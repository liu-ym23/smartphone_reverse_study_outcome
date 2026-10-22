package com.bytedance.android.live.recharge.platform.core.keyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.e4;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B\u001b\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014B#\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0013\u0010\u0017J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/core/keyboard/LiveRechargeKeyBoardView;", "Landroid/inputmethodservice/KeyboardView;", "Landroid/inputmethodservice/KeyboardView$OnKeyboardActionListener;", "Ldx0/a;", "listener", "", "setKeyboardListener", "", "label", "setDoneLabel", "", "inputEmpty", "setInputStatus", "showFastPayment", "setShowFastPayment", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveRechargeKeyBoardView extends KeyboardView implements KeyboardView.OnKeyboardActionListener {
    public static final int l = 0;
    public static final int m = 0;
    public static final int n = 0;
    public static final int o = 0;
    public static final int p = 0;
    public static final int q = 0;
    public static final int r = 0;
    public static final int s = 0;
    public Paint a;
    public Rect b;
    public int c;
    public final int d;
    public final int e;
    public final Typeface f;
    public final Typeface g;
    public String h;
    public boolean i;
    public dx0.a j;
    public boolean k;

    public static final class a {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onRelease(int r1) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeDown() {
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeLeft() {
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeRight() {
    }

    @Override // android.inputmethodservice.KeyboardView, android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeUp() {
    }

    static {
        l = s1.f(18.0f);
        m = s1.f(15.0f);
        n = s1.f(20.0f);
        o = s1.f(15.0f);
        p = s1.f(6.0f);
        q = s1.f(10.0f);
        r = -1;
        s = s1.h(2131108129);
    }

    public final void c(Context r3) {
        setKeyboard(new Keyboard(r3, 2132082743));
        setEnabled(true);
        setFocusable(true);
        setPreviewEnabled(false);
        setOnKeyboardActionListener(this);
        Paint r0 = new Paint(1);
        this.a = r0;
        r0.setTextAlign(Paint.Align.CENTER);
        Paint r4 = this.a;
        if (r4 == null) goto L5;
        r4.setTextSize(this.d);
    L5:
        Paint r5 = this.a;
        if (r5 == null) goto L8;
        r5.setColor(this.e);
    L8:
        Paint r6 = this.a;
        if (r6 == null) goto L11;
        r6.setTypeface(this.f);
    L11:
        setDoneLabel(e4.a());
    }

    @Override // android.inputmethodservice.KeyboardView, android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        Iterator<Keyboard.Key> r0 = getKeyboard().getKeys().iterator();
    L4:
        if (r0.hasNext() == false) goto L45;
        Keyboard.Key r1 = r0.next();
        int r2 = r1.codes[0];
        if (r2 == (-5)) goto L7;
        if (r2 == (-4)) goto L38;
        b(r1, r10);
        a(r1, r10, l, s);
        goto L4
    L38:
        if (StringsKt.isBlank(this.h) == true) goto L40;
        r1.label = this.h;
    L40:
        boolean r3 = this.i;
        Drawable r4 = s1.m(2131249023);
        int r5 = r1.x;
        int r6 = r1.y;
        r4.setBounds(r5, r6, r1.width + r5, r1.height + r6);
        r4.draw(r10);
        Drawable r7 = s1.m(2131249021);
        if (r3 == false) goto L43;
        r7 = s1.m(2131249022);
    L43:
        int r8 = r1.x;
        int r9 = r1.y;
        r7.setBounds(r8, r9, r1.width + r8, r1.height + r9);
        r7.setState(r1.getCurrentDrawableState());
        r7.draw(r10);
        a(r1, r10, m, r);
        goto L4
    L7:
        b(r1, r10);
        Drawable r12 = s1.m(2131250298);
        int r13 = o;
        int r14 = n;
        if (r12 == null) goto L4;
        Rect r15 = this.b;
        if (r15 != null) goto L13;
    L14:
        if (r14 > 0) goto L17;
        r14 = r12.getIntrinsicWidth();
    L17:
        if (r13 > 0) goto L20;
        r13 = r12.getIntrinsicHeight();
    L20:
        int r16 = r1.width;
        if (r14 <= r16) goto L23;
        r13 = (int) (((r16 * 1.0f) / r14) * r13);
        r14 = r16;
    L26:
        int r17 = (r1.x + (r16 / 2)) - (r14 / 2);
        int r18 = (r1.y + (r1.height / 2)) - (r13 / 2);
        this.b = new Rect(r17, r18, r14 + r17, r13 + r18);
    L27:
        Rect r19 = this.b;
        if (r19 == null) goto L4;
        if (r19.isEmpty() == true) goto L4;
        Rect r20 = this.b;
        if (r20 == null) goto L34;
        r12.setBounds(r20);
    L34:
        r12.draw(r10);
        goto L4
    L23:
        int r22 = r1.height;
        if (r13 <= r22) goto L26;
        r14 = (int) (((r22 * 1.0f) / r13) * r14);
        r13 = r22;
        goto L26
    L13:
        if (r15.isEmpty() != true) goto L27;
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onPress(int r1) {
        dx0.a r2 = this.j;
        if (r2 == null) goto L6;
        r2.a();
        return;
    }

    public final void setDoneLabel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "label");
        this.h = r2;
        invalidate();
    }

    public final void setInputStatus(boolean r1) {
        this.i = r1;
    }

    public final void setKeyboardListener(dx0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.j = r2;
    }

    public final void setShowFastPayment(boolean r1) {
        this.k = r1;
    }

    public LiveRechargeKeyBoardView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.d = s1.f(18.0f);
        this.e = s1.h(2131108129);
        this.f = Typeface.DEFAULT_BOLD;
        this.g = Typeface.create(Typeface.SANS_SERIF, 0);
        this.h = "";
        c(r2);
    }

    public final void b(Keyboard.Key r6, Canvas r7) {
        int r0 = r6.codes[0];
        if (r0 != 51) goto L5;
        this.c = r6.x + r6.width;
    L5:
        int r1 = r6.x + r6.width;
        if (r0 != 48) goto L8;
        r1 = this.c;
    L8:
        Drawable r2 = s1.m(2131249023);
        int r3 = r6.x;
        int r4 = r6.y;
        r2.setBounds(r3, r4, r1, r6.height + r4);
        r2.draw(r7);
        Drawable r5 = s1.m(2131249024);
        int r8 = r6.x;
        int r9 = r6.y;
        r5.setBounds(r8, r9, r1, r6.height + r9);
        r5.setState(r6.getCurrentDrawableState());
        r5.draw(r7);
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onKey(int r2, int[] r3) {
        Intrinsics.checkNotNullParameter(r3, "keyCodes");
        char r4 = (char) r2;
        if (r2 != (-5)) goto L5;
        dx0.a r5 = this.j;
        if (r5 == null) goto L20;
        r5.onDelete();
        return;
    L20:
        return;
    L5:
        if (r2 == (-4)) goto L9;
        dx0.a r6 = this.j;
        if (r6 == null) goto L16;
        r6.onInput(String.valueOf(r4));
        return;
    L16:
        return;
    L9:
        dx0.a r7 = this.j;
        if (r7 == null) goto L18;
        r7.onDone();
        return;
    }

    public LiveRechargeKeyBoardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = s1.f(18.0f);
        this.e = s1.h(2131108129);
        this.f = Typeface.DEFAULT_BOLD;
        this.g = Typeface.create(Typeface.SANS_SERIF, 0);
        this.h = "";
        c(r2);
    }

    public final void a(Keyboard.Key r20, Canvas r22, int r23, int r24) {
        Canvas r2 = r22;
        if (TextUtils.isEmpty(r20.label) == true) goto L38;
        Paint r3 = this.a;
        if (r3 == null) goto L43;
        float r4 = r23;
        r3.setTextSize(r4);
        r3.setColor(r24);
        r3.setTypeface(this.f);
        Paint.FontMetrics r5 = r3.getFontMetrics();
        float r6 = r5.bottom - r5.top;
        List r7 = StringsKt.split$default(r20.label.toString(), new String[]{"\n"}, false, 0, 6, null);
        int r9 = 1;
        if ((!r7.isEmpty()) == false) goto L9;
        List r8 = r7;
    L10:
        if (r8 == null) goto L44;
        Iterator r10 = r8.iterator();
        int r12 = 0;
    L13:
        if (r10.hasNext() == false) goto L45;
        Object r13 = r10.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        String r15 = (String) r13;
        int r16 = r20.width;
        Paint r17 = this.a;
        if (r17 == null) goto L23;
        r17.setTextSize(r4);
    L21:
        if (r17.measureText(r15) <= (r16 - (p * 2))) goto L23;
        r17.setTextSize(r17.getTextSize() - r9);
        r4 = r4;
    L23:
        float r18 = r4;
        if ((r7.size() % 2) != r9) goto L26;
        Paint r19 = r3;
        r22.drawText(r15, (r20.x + (r20.width / 2)) + 0, (float) ((((((double) r20.y) + (((double) r20.height) / 2.0d)) + ((double) (r6 / 2))) - ((double) r5.bottom)) + ((double) ((r12 - (r7.size() / 2)) * r6))), r19);
        r10 = r10;
        Canvas r25 = r22;
    L37:
        r2 = r25;
        r3 = r19;
        r12 = r14;
        r4 = r18;
        r10 = r10;
        r9 = 1;
        goto L13
    L26:
        r19 = r3;
        if (r20.codes[0] != (-4)) goto L33;
        if (this.k == false) goto L33;
        if (r12 <= 0) goto L33;
        r19.setTypeface(this.g);
        r19.setTextSize(q);
    L33:
        if (r12 >= (r7.size() / 2)) goto L35;
        double r26 = ((((double) r20.y) + (((double) r20.height) / 2.0d)) - ((double) r5.bottom)) - ((double) ((((r7.size() / 2) - r12) - 1) * r6));
        int r27 = 2;
    L36:
        r25 = r22;
        r25.drawText(r15, (r20.x + (r20.width / r27)) + 0, (float) r26, r19);
        goto L37
    L35:
        r27 = 2;
        r26 = ((((double) r20.y) + (((double) r20.height) / 2.0d)) + ((double) Math.abs(r5.top))) + ((double) ((r12 - (r7.size() / 2)) * r6));
        goto L36
    L45:
        return;
    L44:
        return;
    L9:
        r8 = null;
        goto L10
    L43:
        return;
    }
}
