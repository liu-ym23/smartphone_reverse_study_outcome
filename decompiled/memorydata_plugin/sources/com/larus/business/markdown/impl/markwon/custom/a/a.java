package com.larus.business.markdown.impl.markwon.custom.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J@\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0002Jn\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J@\u0010%\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/custom/quote/CustomBlockQuoteSpan;", "Landroid/text/style/LeadingMarginSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "lineCornerRadius", "", "blockMargin", "(Lio/noties/markwon/core/MarkwonTheme;II)V", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/Rect;", "drawBottomRoundRect", "", "c", "Landroid/graphics/Canvas;", "left", "", "top", "right", "bottom", "cornerRadius", "drawLeadingMargin", "p", "x", "dir", "baseline", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "first", "", "layout", "Landroid/text/Layout;", "drawTopRoundRect", "getLeadingMargin", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f5227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5228b;
    private final int c;
    private final Rect d;
    private final Paint e;
    private final Path f;

    public a(c r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        this.f5227a = r2;
        this.f5228b = r3;
        this.c = r4;
        this.d = new Rect();
        this.e = new Paint();
        this.f = new Path();
    }

    private final void a(Canvas r4, float r5, float r6, float r7, float r8, float r9, Path r10) {
        this.e.setAntiAlias(true);
        this.e.setDither(true);
        r10.reset();
        r10.moveTo(r5, r8);
        r10.lineTo(r7, r8);
        float r11 = r6 + r9;
        r10.lineTo(r7, r11);
        r10.arcTo(new RectF(r7 - r9, r6, r7, r11), 0.0f, -90.0f, false);
        float r12 = r9 + r5;
        r10.lineTo(r12, r6);
        r10.arcTo(new RectF(r5, r6, r12, r11), 270.0f, -90.0f, false);
        r10.close();
        r4.drawPath(r10, this.e);
    }

    private final void b(Canvas r4, float r5, float r6, float r7, float r8, float r9, Path r10) {
        this.e.setAntiAlias(true);
        this.e.setDither(true);
        r10.reset();
        r10.moveTo(r5, r6);
        r10.lineTo(r7, r6);
        float r11 = r8 - r9;
        r10.lineTo(r7, r11);
        r10.arcTo(new RectF(r7 - r9, r11, r7, r8), 0.0f, 90.0f, false);
        float r12 = r9 + r5;
        r10.lineTo(r12, r8);
        r10.arcTo(new RectF(r5, r11, r12, r8), 90.0f, 90.0f, false);
        r10.close();
        r4.drawPath(r10, this.e);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r11, Paint r12, int r13, int r14, int r15, int r16, int r17, CharSequence r18, int r19, int r20, boolean r21, Layout r22) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r18, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "c");
        int r7 = this.f5227a.b();
        this.e.set(r12);
        this.f5227a.b(this.e);
        a r8 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");
        int r9 = (r7 * r14) + r13;
        int r10 = RangesKt.coerceAtMost(r13, r9);
        int r2 = RangesKt.coerceAtLeast(r13, r9);
        if (this.f5228b > 0) goto L5;
    L12:
        this.d.set(r10, r15, r2, r17);
        r11.drawRect(this.d, this.e);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, Spanned.class) == false) goto L12;
        if (((Spanned) ZeusTransformUtils.preCheckCast(r5, Spanned.class, "com.obric.memorydata.plugin")).getSpanStart(this) != r19) goto L10;
        a(r11, r10, r15, r2, r17, this.f5228b, this.f);
        return;
    L10:
        if (((Spanned) ZeusTransformUtils.preCheckCast(r5, Spanned.class, "com.obric.memorydata.plugin")).getSpanEnd(this) != r20) goto L12;
        b(r11, r10, r15, r2, r17, this.f5228b, this.f);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r1) {
        int r2 = this.c;
        if (r2 <= 0) goto L6;
        return r2;
    L6:
        return this.f5227a.a();
    }
}
