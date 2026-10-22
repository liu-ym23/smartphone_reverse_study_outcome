package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.noties.markwon.core.spans.CustomLinkSpan;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import wsc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/UnderlineTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "", "weight", "", "setBottomLineWeight", "", "a", "I", "getLineColor", "()I", "setLineColor", "(I)V", "lineColor", "", "b", "Z", "getDrawLine", "()Z", "setDrawLine", "(Z)V", "drawLine", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "markdown-impl_release"}, k = 1, mv = {1, 7, 1})
public class UnderlineTextView extends AppCompatTextView {
    public int a;
    public boolean b;
    public final Paint c;

    public UnderlineTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public UnderlineTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public boolean getDrawLine() {
        return this.b;
    }

    public int getLineColor() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r25) {
        Intrinsics.checkNotNullParameter(r25, "canvas");
        super/*android.widget.TextView*/.onDraw(r25);
        Layout r1 = getLayout();
        if (r1 != null) goto L5;
        return;
    L5:
        int r9 = 0;
        if (getDrawLine() == false) goto L10;
        this.c.setColor(getLineColor());
        Paint.FontMetricsInt r2 = getPaint().getFontMetricsInt();
        int r3 = Math.abs((r2.bottom - r2.ascent) - getLineHeight());
        int r4 = r2.bottom;
        int r5 = r2.descent;
        int r10 = (r3 - (r4 - r5)) + (Math.abs(r5) / 2);
        int r11 = getLineCount();
    L8:
        if (r9 >= r11) goto L80;
        float r6 = getPaddingLeft() + r1.getLineLeft(r9);
        float r7 = r1.getLineRight(r9) + getPaddingLeft();
        float r8 = (r1.getLineBottom(r9) + getPaddingTop()) - r10;
        r25.drawLine(r6, r8, r7, r8, this.c);
        r9 = r9 + 1;
        goto L8
    L80:
        return;
    L10:
        CharSequence r12 = getText();
        if ((r12 instanceof Spanned) == false) goto L13;
        Spanned r13 = (Spanned) r12;
    L14:
        if (r13 == null) goto L70;
        this.c.setColor(getLineColor());
        Object[] r14 = r13.getSpans(0, r13.length(), CustomLinkSpan.class);
        ArrayList r15 = new ArrayList();
        int r16 = r14.length;
        int r17 = 0;
    L16:
        if (r17 >= r16) goto L21;
        Object r18 = r14[r17];
        if (((CustomLinkSpan) r18).h == false) goto L20;
        r15.add(r18);
    L20:
        r17 = r17 + 1;
        goto L16
    L21:
        Paint.FontMetricsInt r19 = getPaint().getFontMetricsInt();
        int r20 = Math.abs((r19.bottom - r19.ascent) - getLineHeight());
        int r21 = r19.bottom;
        int r22 = r19.descent;
        int r110 = (r20 - (r21 - r22)) + (Math.abs(r22) / 2);
        int r111 = r15.size();
        int r23 = 0;
    L22:
        if (r23 >= r111) goto L81;
        CustomLinkSpan r24 = (CustomLinkSpan) ListProtector.get(r15, r23);
        int r26 = r13.getSpanStart(r24);
        int r27 = r13.getSpanEnd(r24);
        int r28 = r1.getLineForOffset(r26);
        int r29 = r1.getLineForOffset(r27);
        float r112 = r1.getPrimaryHorizontal(r26);
        float r113 = r1.getPrimaryHorizontal(r27);
        int r30 = getLineCount();
        int r31 = 0;
    L24:
        if (r31 >= r30) goto L69;
        if (r31 < r28) goto L67;
        if (r31 > r29) goto L67;
        Object[] r32 = r13.getSpans(r1.getLineStart(r31), r1.getLineEnd(r31), f.class);
        if (r32.length != 0) goto L31;
        boolean r33 = true;
    L32:
        if (r33 == false) goto L34;
        int r210 = r30;
        int r114 = r23;
        Integer r34 = null;
    L54:
        Integer r35 = r34;
        if (r35 == null) goto L57;
        int r36 = r35.intValue();
    L58:
        float r37 = RangesKt.coerceAtLeast((r36 - (r19.descent - r19.ascent)) / 2, 0);
        float r38 = getPaddingLeft();
        if (r31 != r28) goto L61;
        float r39 = r112;
    L62:
        float r40 = r38 + r39;
        float r41 = getPaddingLeft();
        if (r31 != r29) goto L65;
        float r42 = r113;
    L66:
        float r43 = r41 + r42;
        float r44 = ((getPaddingTop() + r110) + r1.getLineBaseline(r31)) + r37;
        int r45 = r114;
        r25.drawLine(r40, r44, r43, r44, this.c);
    L68:
        r31 = r31 + 1;
        r23 = r45;
        r30 = r210;
        r29 = r29;
        r28 = r28;
        goto L24
    L65:
        r42 = r1.getLineMax(r31);
        goto L66
    L61:
        r39 = r1.getPrimaryHorizontal(r1.getLineStart(r31));
        goto L62
    L57:
        r36 = 0;
        goto L58
    L34:
        f r46 = (f) r32[0];
        Drawable r115 = r46.b.e;
        if (r115 == null) goto L39;
        Rect r116 = r115.getBounds();
        if (r116 == null) goto L39;
        int r47 = r116.height();
    L40:
        r34 = Integer.valueOf(r47);
        int r117 = ArraysKt.getLastIndex(r32);
        r210 = r30;
        int r48 = 1;
        if (1 > r117) goto L53;
    L42:
        Object[] r211 = r32;
        f r49 = (f) r32[r48];
        r114 = r23;
        Drawable r50 = r49.b.e;
        if (r50 == null) goto L47;
        Rect r51 = r50.getBounds();
        if (r51 == null) goto L47;
        int r52 = r51.height();
    L48:
        Integer r53 = Integer.valueOf(r52);
        if (r34.compareTo(r53) >= 0) goto L51;
        r34 = r53;
    L51:
        if (r48 == r117) goto L54;
        r48 = r48 + 1;
        r23 = r114;
        r32 = r211;
    L47:
        r52 = r49.b.getBounds().height();
        goto L48
    L53:
        r114 = r23;
    L39:
        r47 = r46.b.getBounds().height();
        goto L40
    L31:
        r33 = false;
    L67:
        r210 = r30;
        r45 = r23;
        goto L68
    L69:
        r23 = r23 + 1;
        goto L22
    L81:
        return;
    L70:
        return;
    L13:
        r13 = null;
        goto L14
    }

    public void setBottomLineWeight(float r2) {
        this.c.setStrokeWidth(r2);
    }

    public void setDrawLine(boolean r1) {
        this.b = r1;
    }

    public void setLineColor(int r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UnderlineTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = ContextCompat.getColor(getContext(), 2131105594);
        this.c = new Paint();
    }

    public /* synthetic */ UnderlineTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
