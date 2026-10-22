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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.CustomLinkSpan;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/UnderlineTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/larus/business/markdown/api/view/text/IUnderlineTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawLine", "", "getDrawLine", "()Z", "setDrawLine", "(Z)V", "lineColor", "getLineColor", "()I", "setLineColor", "(I)V", "linePaint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setBottomLineWeight", "weight", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class UnderlineTextView extends AppCompatTextView {
    private boolean drawLine;
    private int lineColor;
    private final Paint linePaint;

    public UnderlineTextView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public UnderlineTextView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public UnderlineTextView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.lineColor = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.primary_transparent_4, TypedValues.Custom.S_COLOR, "primary_transparent_4"));
        this.linePaint = new Paint();
    }

    public /* synthetic */ UnderlineTextView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public boolean getDrawLine() {
        return this.drawLine;
    }

    public int getLineColor() {
        return this.lineColor;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r26) {
        Intrinsics.checkNotNullParameter(r26, "canvas");
        super.onDraw(r26);
        Layout r1 = getLayout();
        if (r1 != null) goto L5;
        return;
    L5:
        int r9 = 0;
        if (getDrawLine() == false) goto L10;
        this.linePaint.setColor(getLineColor());
        Paint.FontMetricsInt r2 = getPaint().getFontMetricsInt();
        int r10 = (Math.abs((r2.bottom - r2.ascent) - getLineHeight()) - (r2.bottom - r2.descent)) + (Math.abs(r2.descent) / 2);
        int r11 = getLineCount();
    L8:
        if (r9 >= r11) goto L79;
        float r3 = getPaddingLeft() + r1.getLineLeft(r9);
        float r5 = r1.getLineRight(r9) + getPaddingLeft();
        float r6 = (r1.getLineBottom(r9) + getPaddingTop()) - r10;
        r26.drawLine(r3, r6, r5, r6, this.linePaint);
        r9 = r9 + 1;
        goto L8
    L79:
        return;
    L10:
        CharSequence r4 = getText();
        if (ZeusTransformUtils.instanceOf(r4, Spanned.class) == false) goto L13;
        Spanned r12 = (Spanned) ZeusTransformUtils.preCheckCast(r4, Spanned.class, "com.obric.memorydata.plugin");
    L14:
        if (r12 == null) goto L69;
        this.linePaint.setColor(getLineColor());
        Object[] r7 = r12.getSpans(0, r12.length(), CustomLinkSpan.class);
        Intrinsics.checkNotNullExpressionValue(r7, "getSpans(0, length, CustomLinkSpan::class.java)");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r13 = r7.length;
        int r14 = 0;
    L16:
        if (r14 >= r13) goto L21;
        Object r15 = r7[r14];
        if (((CustomLinkSpan) ZeusTransformUtils.preCheckCast(r15, CustomLinkSpan.class, "com.obric.memorydata.plugin")).getNeedUnderLine() == false) goto L20;
        r8.add(r15);
    L20:
        r14 = r14 + 1;
        goto L16
    L21:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        Paint.FontMetricsInt r17 = getPaint().getFontMetricsInt();
        int r18 = (Math.abs((r17.bottom - r17.ascent) - getLineHeight()) - (r17.bottom - r17.descent)) + (Math.abs(r17.descent) / 2);
        int r19 = r16.size();
        int r20 = 0;
    L22:
        if (r20 >= r19) goto L80;
        CustomLinkSpan r21 = (CustomLinkSpan) ZeusTransformUtils.preCheckCast(r16.get(r20), CustomLinkSpan.class, "com.obric.memorydata.plugin");
        int r22 = r12.getSpanStart(r21);
        int r23 = r12.getSpanEnd(r21);
        int r24 = r1.getLineForOffset(r22);
        int r25 = r1.getLineForOffset(r23);
        float r110 = r1.getPrimaryHorizontal(r22);
        float r111 = r1.getPrimaryHorizontal(r23);
        int r27 = getLineCount();
        int r28 = r9;
    L24:
        if (r28 >= r27) goto L68;
        if (r28 < r24) goto L66;
        if (r28 > r25) goto L66;
        Object[] r29 = r12.getSpans(r1.getLineStart(r28), r1.getLineEnd(r28), io.noties.markwon.a.d.class);
        Intrinsics.checkNotNullExpressionValue(r29, "getSpans(\n              …                        )");
        if (r29.length != 0) goto L31;
        boolean r30 = true;
    L32:
        if (r30 == false) goto L34;
        int r210 = r20;
        int r211 = r19;
        Comparable r31 = null;
    L53:
        Integer r32 = (Integer) ZeusTransformUtils.preCheckCast(r31, Integer.class, "com.obric.memorydata.plugin");
        if (r32 == null) goto L56;
        int r33 = r32.intValue();
    L57:
        int r112 = 0;
        float r34 = RangesKt.coerceAtLeast((r33 - (r17.descent - r17.ascent)) / 2, 0);
        float r35 = getPaddingLeft();
        if (r28 != r24) goto L60;
        float r36 = r110;
    L61:
        float r37 = r35 + r36;
        float r38 = getPaddingLeft();
        if (r28 != r25) goto L64;
        float r39 = r111;
    L65:
        float r40 = r38 + r39;
        float r41 = ((getPaddingTop() + r18) + r1.getLineBaseline(r28)) + r34;
        int r42 = r211;
        r26.drawLine(r37, r41, r40, r41, this.linePaint);
    L67:
        r28 = r28 + 1;
        r19 = r42;
        r9 = r112;
        r27 = r27;
        r20 = r210;
        r25 = r25;
        r24 = r24;
        goto L24
    L64:
        r39 = r1.getLineMax(r28);
        goto L65
    L60:
        r36 = r1.getPrimaryHorizontal(r1.getLineStart(r28));
        goto L61
    L56:
        r33 = 0;
        goto L57
    L34:
        io.noties.markwon.a.d r43 = (io.noties.markwon.a.d) ZeusTransformUtils.preCheckCast(r29[0], io.noties.markwon.a.d.class, "com.obric.memorydata.plugin");
        Drawable r113 = r43.a().f();
        if (r113 == null) goto L39;
        Rect r114 = r113.getBounds();
        if (r114 == null) goto L39;
        int r44 = r114.height();
    L40:
        r31 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r44), Comparable.class, "com.obric.memorydata.plugin");
        int r115 = ArraysKt.getLastIndex(r29);
        r210 = r20;
        int r45 = 1;
        r211 = r19;
        if (1 > r115) goto L53;
    L42:
        Object[] r212 = r29;
        io.noties.markwon.a.d r46 = (io.noties.markwon.a.d) ZeusTransformUtils.preCheckCast(r29[r45], io.noties.markwon.a.d.class, "com.obric.memorydata.plugin");
        Drawable r47 = r46.a().f();
        if (r47 == null) goto L47;
        Rect r48 = r47.getBounds();
        if (r48 == null) goto L47;
        int r49 = r48.height();
    L48:
        Comparable r50 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r49), Comparable.class, "com.obric.memorydata.plugin");
        if (r31.compareTo(r50) >= 0) goto L51;
        r31 = r50;
    L51:
        if (r45 == r115) goto L53;
        r45 = r45 + 1;
        r29 = r212;
    L47:
        r49 = r46.a().getBounds().height();
    L39:
        r44 = r43.a().getBounds().height();
        goto L40
    L31:
        r30 = false;
    L66:
        r210 = r20;
        r112 = r9;
        r42 = r19;
        goto L67
    L68:
        r20 = r20 + 1;
        r9 = r9;
        goto L22
    L80:
        return;
    L69:
        return;
    L13:
        r12 = null;
        goto L14
    }

    public void setBottomLineWeight(float r1) {
        this.linePaint.setStrokeWidth(r1);
    }

    public void setDrawLine(boolean r1) {
        this.drawLine = r1;
    }

    public void setLineColor(int r1) {
        this.lineColor = r1;
    }
}
