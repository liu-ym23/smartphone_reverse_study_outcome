package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import android.util.TypedValue;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJR\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J4\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/HorizontalLineSpan;", "Landroid/text/style/ReplacementSpan;", "context", "Landroid/content/Context;", "startMargin", "", "lineHeight", "lineColor", "(Landroid/content/Context;III)V", "bottomExtraMargin", "realLineHeight", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5213b;
    private final int c;
    private final float d;
    private final int e;

    public g(Context r3, int r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Context r8 = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.f5212a = r8;
        this.f5213b = r4;
        this.c = r6;
        this.d = TypedValue.applyDimension(0, r5, ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin").getDisplayMetrics());
        this.e = com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(7, Number.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r7, CharSequence r8, int r9, int r10, float r11, int r12, int r13, int r14, Paint r15) {
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Intrinsics.checkNotNullParameter(r15, "paint");
        int r17 = r15.getColor();
        r15.setColor(this.c);
        r15.setStrokeWidth(this.d);
        boolean r18 = true;
        if (ZeusTransformUtils.getResources(this.f5212a, "com.obric.memorydata.plugin").getConfiguration().getLayoutDirection() == 1) goto L6;
        r18 = false;
    L6:
        if (r18 == false) goto L8;
        float r19 = r7.getWidth();
        int r6 = this.f5213b;
    L9:
        float r4 = r12;
        r7.drawLine(r19, r4, r6, r4, r15);
        r15.setColor(r17);
        return;
    L8:
        r19 = r11 - this.f5213b;
        r6 = r7.getWidth();
        goto L9
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "paint");
        if (r5 == null) goto L7;
        r5.ascent += (r5.descent - r5.ascent) - ((int) this.d);
        r5.top = r5.ascent;
        r5.descent = r5.ascent + ((int) (this.d + this.e));
        r5.bottom = r5.descent;
        return 0;
    L7:
        return 0;
    }
}
