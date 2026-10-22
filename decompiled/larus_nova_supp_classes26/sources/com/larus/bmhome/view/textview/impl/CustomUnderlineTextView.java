package com.larus.bmhome.view.textview.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.noties.markwon.core.spans.CustomLinkSpan;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c;
import wsc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0000H\u0016R\u001a\u0010\u000b\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/bmhome/view/textview/impl/CustomUnderlineTextView;", "Lcom/larus/bmhome/view/textview/impl/SelectorTextView;", "Lcom/larus/bmhome/view/textview/api/ICustomUnderlineTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lineColor", "getLineColor", "()I", "setLineColor", "(I)V", "drawLine", "", "getDrawLine", "()Z", "setDrawLine", "(Z)V", "useSubscribedColor", "getUseSubscribedColor", "setUseSubscribedColor", "linePaint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setBottomLineWeight", "weight", "", "asTextView", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CustomUnderlineTextView extends SelectorTextView {
    public int f;
    public boolean g;
    public boolean h;
    public final Paint i;

    public CustomUnderlineTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomUnderlineTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public boolean getDrawLine() {
        return this.g;
    }

    public int getLineColor() {
        return this.f;
    }

    public boolean getUseSubscribedColor() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas r25) {
        Intrinsics.checkNotNullParameter(r25, "canvas");
        super/*android.widget.TextView*/.onDraw(r25);
        Layout r1 = getLayout();
        if (r1 != null) goto L5;
        return;
    L5:
        int r9 = 0;
        if (getDrawLine() == false) goto L10;
        this.i.setColor(getLineColor());
        int r10 = getLineCount();
    L8:
        if (r9 >= r10) goto L84;
        float r3 = getPaddingLeft() + r1.getLineLeft(r9);
        float r5 = r1.getLineRight(r9) + getPaddingLeft();
        float r6 = (r1.getLineBaseline(r9) + getPaint().getFontMetricsInt().descent) + getPaddingTop();
        r25.drawLine(r3, r6, r5, r6, this.i);
        r9 = r9 + 1;
        goto L8
    L84:
        return;
    L10:
        CharSequence r2 = getText();
        if ((r2 instanceof Spanned) == false) goto L13;
        Spanned r11 = (Spanned) r2;
    L14:
        if (r11 == null) goto L74;
        Paint r4 = this.i;
        Context r7 = getContext();
        if (getUseSubscribedColor() == false) goto L18;
        int r8 = 2130968760;
        int r12 = 2131100139;
    L19:
        r4.setColor(ContextCompat.getColor(r7, c.b(r8, null, r12)));
        Object[] r13 = r11.getSpans(0, r11.length(), CustomLinkSpan.class);
        ArrayList r14 = new ArrayList();
        int r15 = r13.length;
        int r16 = 0;
    L20:
        if (r16 >= r15) goto L25;
        Object r17 = r13[r16];
        if (((CustomLinkSpan) r17).h == false) goto L24;
        r14.add(r17);
    L24:
        r16 = r16 + 1;
        goto L20
    L25:
        Paint.FontMetricsInt r18 = getPaint().getFontMetricsInt();
        int r19 = Math.abs((r18.bottom - r18.ascent) - getLineHeight());
        int r20 = r18.bottom;
        int r21 = r18.descent;
        int r110 = (r19 - (r20 - r21)) + (Math.abs(r21) / 2);
        int r111 = r14.size();
        int r22 = 0;
    L26:
        if (r22 >= r111) goto L85;
        CustomLinkSpan r23 = (CustomLinkSpan) ListProtector.get(r14, r22);
        int r24 = r11.getSpanStart(r23);
        int r26 = r11.getSpanEnd(r23);
        int r27 = r1.getLineForOffset(r24);
        int r28 = r1.getLineForOffset(r26);
        float r112 = r1.getPrimaryHorizontal(r24);
        float r113 = r1.getPrimaryHorizontal(r26);
        int r29 = getLineCount();
        int r30 = 0;
    L28:
        if (r30 >= r29) goto L73;
        if (r30 < r27) goto L71;
        if (r30 > r28) goto L71;
        Object[] r31 = r11.getSpans(r1.getLineStart(r30), r1.getLineEnd(r30), f.class);
        if (r31.length != 0) goto L35;
        boolean r32 = true;
    L36:
        if (r32 == false) goto L38;
        int r210 = r29;
        int r114 = r22;
        Integer r33 = null;
    L58:
        Integer r34 = r33;
        if (r34 == null) goto L61;
        int r35 = r34.intValue();
    L62:
        float r36 = RangesKt.coerceAtLeast((r35 - (r18.descent - r18.ascent)) / 2, 0);
        float r37 = getPaddingLeft();
        if (r30 != r27) goto L65;
        float r38 = r112;
    L66:
        float r39 = r37 + r38;
        float r40 = getPaddingLeft();
        if (r30 != r28) goto L69;
        float r41 = r113;
    L70:
        float r42 = r40 + r41;
        float r43 = ((getPaddingTop() + r110) + r1.getLineBaseline(r30)) + r36;
        int r44 = r114;
        r25.drawLine(r39, r43, r42, r43, this.i);
    L72:
        r30 = r30 + 1;
        r22 = r44;
        r29 = r210;
        r28 = r28;
        r27 = r27;
        goto L28
    L69:
        r41 = r1.getLineMax(r30);
        goto L70
    L65:
        r38 = r1.getPrimaryHorizontal(r1.getLineStart(r30));
        goto L66
    L61:
        r35 = 0;
        goto L62
    L38:
        f r45 = (f) r31[0];
        Drawable r115 = r45.b.e;
        if (r115 == null) goto L43;
        Rect r116 = r115.getBounds();
        if (r116 == null) goto L43;
        int r46 = r116.height();
    L44:
        r33 = Integer.valueOf(r46);
        int r117 = ArraysKt.getLastIndex(r31);
        r210 = r29;
        int r47 = 1;
        if (1 > r117) goto L57;
    L46:
        Object[] r211 = r31;
        f r48 = (f) r31[r47];
        r114 = r22;
        Drawable r49 = r48.b.e;
        if (r49 == null) goto L51;
        Rect r50 = r49.getBounds();
        if (r50 == null) goto L51;
        int r51 = r50.height();
    L52:
        Integer r52 = Integer.valueOf(r51);
        if (r33.compareTo(r52) >= 0) goto L55;
        r33 = r52;
    L55:
        if (r47 == r117) goto L58;
        r47 = r47 + 1;
        r22 = r114;
        r31 = r211;
    L51:
        r51 = r48.b.getBounds().height();
        goto L52
    L57:
        r114 = r22;
    L43:
        r46 = r45.b.getBounds().height();
        goto L44
    L35:
        r32 = false;
    L71:
        r210 = r29;
        r44 = r22;
        goto L72
    L73:
        r22 = r22 + 1;
        goto L26
    L85:
        return;
    L18:
        r8 = 2130973613;
        r12 = 2131105594;
        goto L19
    L74:
        return;
    L13:
        r11 = null;
        goto L14
    }

    public void setBottomLineWeight(float r2) {
        this.i.setStrokeWidth(r2);
    }

    public void setDrawLine(boolean r1) {
        this.g = r1;
    }

    public void setLineColor(int r1) {
        this.f = r1;
    }

    public void setUseSubscribedColor(boolean r1) {
        this.h = r1;
    }

    public CustomUnderlineTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.i = new Paint();
    }

    public /* synthetic */ CustomUnderlineTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
