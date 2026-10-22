package com.larus.common_ui.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0014J\b\u0010!\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\u0018\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/larus/common_ui/view/NoSpaceTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "refreshMeasure", "", "value", "isRemoveExtraSpaceEnabled", "()Z", "setRemoveExtraSpaceEnabled", "(Z)V", "originalPaddingRecorded", "originalPaddingLeft", "originalPaddingTop", "originalPaddingRight", "originalPaddingBottom", "setText", "", "text", "", "type", "Landroid/widget/TextView$BufferType;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "recordOriginalPaddingIfNeeded", "restoreOriginalPadding", "removeSpace", "widthSpc", "heightSpc", "linesText", "", "", "getLinesText", "()[Ljava/lang/String;", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoSpaceTextView extends AppCompatTextView {
    public boolean a;
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String[] getLinesText() {
        String[] r0 = new String[getLineCount()];
        String r1 = getText().toString();
        Layout r2 = getLayout();
        int r3 = getLineCount();
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r3) goto L5;
        int r6 = r2.getLineEnd(r4);
        r0[r4] = r1.substring(r5, r6);
        r4 = r4 + 1;
        r5 = r6;
        goto L3
    L5:
        return r0;
    }

    public NoSpaceTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setRemoveExtraSpaceEnabled(boolean r4) {
        if (this.b != r4) goto L5;
        return;
    L5:
        this.b = r4;
        this.a = r4;
        if (r4 == false) goto L8;
    L11:
        requestLayout();
        return;
    L8:
        if (this.c == false) goto L11;
        setPadding(this.d, this.e, this.f, this.g);
        goto L11
    }

    public NoSpaceTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r11, int r12) {
        super.onMeasure(r11, r12);
        if (this.b == false) goto L29;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        if (this.c == true) goto L8;
        this.c = true;     // Catch: Throwable -> L19
        this.d = getPaddingLeft();     // Catch: Throwable -> L19
        this.e = getPaddingTop();     // Catch: Throwable -> L19
        this.f = getPaddingRight();     // Catch: Throwable -> L19
        this.g = getPaddingBottom();     // Catch: Throwable -> L19
    L8:
        String[] r1 = getLinesText();     // Catch: Throwable -> L19
        TextPaint r2 = getPaint();     // Catch: Throwable -> L19
        Rect r3 = new Rect();     // Catch: Throwable -> L19
        String r5 = r1[0];     // Catch: Throwable -> L19
        if (r5 == null) goto L30;
        r2.getTextBounds(r5, 0, r5.length(), r3);     // Catch: Throwable -> L19
        Paint.FontMetricsInt r6 = new Paint.FontMetricsInt();     // Catch: Throwable -> L19
        r2.getFontMetricsInt(r6);     // Catch: Throwable -> L19
        setPadding(getLeftPaddingOffset(), (r6.top - r3.top) + getTopPaddingOffset(), getRightPaddingOffset(), getBottomPaddingOffset());     // Catch: Throwable -> L19
        String r4 = r1[r1.length - 1];     // Catch: Throwable -> L19
        if (r4 == null) goto L31;
        r2.getTextBounds(r4, 0, r4.length(), r3);     // Catch: Throwable -> L19
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() - (r6.bottom - r3.bottom));     // Catch: Throwable -> L19
        if (this.a == false) goto L17;
        this.a = false;     // Catch: Throwable -> L19
        measure(r11, r12);     // Catch: Throwable -> L19
    L17:
        Object r13 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L19
    L21:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L25;
        FLogger.a.e("NoSpaceTextView", "removeSpace failed:" + r14);
        r13 = Boolean.FALSE;
    L25:
        ((Boolean) r13).booleanValue();
        return;
    L31:
        return;
    L30:
        return;
    L19:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r2, TextView.BufferType r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "type");
        super/*android.widget.TextView*/.setText(r2, r3);
        this.a = this.b;
    }

    public NoSpaceTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = true;
    }
}
