package io.noties.markwon.core.spans.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002JH\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0002JH\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0002Jh\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0010H\u0016J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lio/noties/markwon/core/spans/codeblock/CodeBlockSpan2;", "Landroid/text/style/MetricAffectingSpan;", "Landroid/text/style/LeadingMarginSpan;", "Lio/noties/markwon/custom/TypingFreeSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "info", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockSpan2Info;", "(Lio/noties/markwon/core/MarkwonTheme;Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockSpan2Info;)V", "paint", "Landroid/graphics/Paint;", "rect", "Landroid/graphics/Rect;", "apply", "", "p", "Landroid/text/TextPaint;", "drawBackground", CommonConsts.APM_INNER_EVENT_COST_START, "", "end", "textPaint", "c", "Landroid/graphics/Canvas;", "left", "right", "top", "bottom", "drawBorder", "drawLeadingMargin", "x", "dir", "baseline", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "first", "", "layout", "Landroid/text/Layout;", "getLeadingMargin", "updateDrawState", "ds", "updateMeasureState", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a extends MetricAffectingSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.markwon.core.c f16444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.larus.business.markdown.impl.markwon.core.spans.codeblock.c f16445b;
    private final Rect c;
    private final Paint d;

    public a(io.noties.markwon.core.c r2, com.larus.business.markdown.impl.markwon.core.spans.codeblock.c r3) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        Intrinsics.checkNotNullParameter(r3, "info");
        this.f16444a = r2;
        this.f16445b = r3;
        this.c = new Rect();
        this.d = new Paint(1);
    }

    private final void a(int r3, int r4, Paint r5, Canvas r6, int r7, int r8, int r9, int r10) {
        this.d.setStyle(Paint.Style.FILL);
        this.d.setColor(this.f16444a.f(r5));
        Integer r11 = this.f16445b.a();
        if (r11 != null) goto L6;
    L9:
        Integer r12 = this.f16445b.b();
        if (r12 != null) goto L13;
    L15:
        this.c.set(r7, r9, r8, r10);
        r6.drawRect(this.c, this.d);
        return;
    L13:
        if (r4 != r12.intValue()) goto L15;
        Path r13 = new Path();
        float r14 = r8 - r7;
        float r15 = this.f16445b.d();
        r13.moveTo(r7, r9);
        r13.rLineTo(r14, 0.0f);
        float r16 = (r10 - r9) - r15;
        r13.rLineTo(0.0f, r16);
        float r17 = -r15;
        r13.rQuadTo(0.0f, r15, r17, r15);
        r13.rLineTo(-(r14 - (2 * r15)), 0.0f);
        r13.rQuadTo(r17, 0.0f, r17, r17);
        r13.rLineTo(0.0f, -r16);
        r13.close();
    L8:
        r6.drawPath(r13, this.d);
        return;
    L6:
        if (r3 != r11.intValue()) goto L9;
        r13 = new Path();
        float r18 = r8 - r7;
        float r19 = this.f16445b.d();
        r13.moveTo(r7 + r19, r9);
        r13.rLineTo(r18 - (2 * r19), 0.0f);
        r13.rQuadTo(r19, 0.0f, r19, r19);
        float r20 = (r10 - r9) - r19;
        r13.rLineTo(0.0f, r20);
        r13.rLineTo(-r18, 0.0f);
        r13.rLineTo(0.0f, -r20);
        float r21 = -r19;
        r13.rQuadTo(0.0f, r21, r19, r21);
        r13.close();
        this.d.setColor(this.f16445b.c());
        goto L8
    }

    private final void a(TextPaint r3) {
        this.f16444a.d((Paint) ZeusTransformUtils.preCheckCast(r3, Paint.class, "com.obric.memorydata.plugin"));
    }

    private final void b(int r7, int r8, Paint r9, Canvas r10, int r11, int r12, int r13, int r14) {
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(this.f16445b.e());
        this.d.setColor(this.f16445b.f());
        Integer r15 = this.f16445b.a();
        if (r15 != null) goto L6;
    L9:
        Integer r16 = this.f16445b.b();
        if (r16 != null) goto L13;
    L15:
        float r3 = r11;
        float r17 = r13;
        float r18 = r14;
        r10.drawLine(r3, r17, r3, r18, this.d);
        float r19 = r12;
        r10.drawLine(r19, r17, r19, r18, this.d);
        return;
    L13:
        if (r8 != r16.intValue()) goto L15;
        Path r20 = new Path();
        float r21 = r12 - r11;
        float r22 = this.f16445b.d();
        r20.moveTo(r11, r13);
        float r110 = (r14 - r13) - r22;
        r20.rLineTo(0.0f, r110);
        r20.rQuadTo(0.0f, r22, r22, r22);
        r20.rLineTo(r21 - (2 * r22), 0.0f);
        r20.rQuadTo(r22, 0.0f, r22, -r22);
        r20.rLineTo(0.0f, -r110);
    L8:
        r10.drawPath(r20, this.d);
        return;
    L6:
        if (r7 != r15.intValue()) goto L9;
        r20 = new Path();
        float r23 = r12 - r11;
        float r111 = this.f16445b.d();
        r20.moveTo(r11, r14);
        float r24 = (r14 - r13) - r111;
        r20.rLineTo(0.0f, -r24);
        float r112 = -r111;
        r20.rQuadTo(0.0f, r112, r111, r112);
        r20.rLineTo(r23 - (2 * r111), 0.0f);
        r20.rQuadTo(r111, 0.0f, r111, r111);
        r20.rLineTo(0.0f, r24);
        goto L8
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r15, Paint r16, int r17, int r18, int r19, int r20, int r21, CharSequence r22, int r23, int r24, boolean r25, Layout r26) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "c");
        Intrinsics.checkNotNullParameter(r16, "p");
        Intrinsics.checkNotNullParameter(r0, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r26, "layout");
        int r1 = r26.getWidth();
        if (r18 <= 0) goto L5;
        int r12 = r17;
        int r13 = r1;
    L7:
        if (this.f16445b.g() == false) goto L10;
        a(r23, r24, r16, r15, r12, r13, r19, r21);
    L10:
        if (this.f16445b.f() != 0) goto L12;
        return;
    L12:
        if (this.f16445b.e() != 0.0f) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L19;
        b(r23, r24, r16, r15, r12, r13, r19, r21);
        return;
    L19:
        return;
    L14:
        r2 = false;
        goto L15
    L5:
        r13 = r17;
        r12 = r17 - r1;
        goto L7
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r1) {
        return this.f16444a.c();
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        a(r2);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "p");
        a(r2);
    }
}
