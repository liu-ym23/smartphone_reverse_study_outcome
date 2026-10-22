package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.ReplacementSpan;
import android.text.style.UpdateAppearance;
import android.text.style.UpdateLayout;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020 H\u0002J\u0012\u0010.\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u000100H\u0002JR\u00101\u001a\u00020,2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>H\u0016Jh\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u0002032\u0006\u0010-\u001a\u00020>2\u0006\u00108\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u001eH\u0016J\u001a\u0010E\u001a\u0004\u0018\u00010\u001e2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0002J\u0010\u0010F\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u0013H\u0016J4\u0010G\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J \u0010J\u001a\u00020\u001e2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0002J \u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u0002052\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000bH\u0002J,\u0010O\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u00010P2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0016J<\u0010Q\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u00010P2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u000bH\u0016J,\u0010V\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u00010P2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0016J\u0010\u0010W\u001a\u00020,2\u0006\u0010X\u001a\u00020 H\u0016J\u0010\u0010Y\u001a\u00020,2\u0006\u0010-\u001a\u00020 H\u0016R\u001b\u0010\r\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000fR\u000e\u0010#\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b%\u0010\u000fR\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockWithLineNumberScrollableSpan;", "Landroid/text/style/ReplacementSpan;", "Landroid/text/style/LeadingMarginSpan;", "Lio/noties/markwon/StatusSpan;", "Landroid/text/SpanWatcher;", "Lcom/larus/business/markdown/api/model/ICodeBlockWithLineNumberScrollableSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "info", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockSpan2Info;", "screenWidth", "", "(Lio/noties/markwon/core/MarkwonTheme;Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockSpan2Info;I)V", "codeBlockWidth", "getCodeBlockWidth", "()I", "codeBlockWidth$delegate", "Lkotlin/Lazy;", "enableScroll", "", "getEnableScroll", "()Z", "enableScroll$delegate", "generating", "getGenerating", "setGenerating", "(Z)V", "layouts", "Ljava/util/TreeMap;", "Landroid/graphics/Point;", "Landroid/text/Layout;", "lineNumberPaint", "Landroid/text/TextPaint;", "lineNumberTotalWidth", "getLineNumberTotalWidth", "lineNumberWidth", "marginStart", "getMarginStart", "marginStart$delegate", "reLayout", "scrollBar", "Landroid/graphics/drawable/GradientDrawable;", "textPaint", "apply", "", "p", "checkLayout", "what", "", "draw", "canvas", "Landroid/graphics/Canvas;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "drawLeadingMargin", "c", "dir", "baseline", "first", "layout", "findLayout", "getLeadingMargin", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "makeNewLayout", "newLayout", Params.CONTENT, "width", "maxLine", "onSpanAdded", "Landroid/text/Spannable;", "onSpanChanged", "ostart", "oend", "nstart", "nend", "onSpanRemoved", "updateDrawState", "ds", "updateMeasureState", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e extends ReplacementSpan implements SpanWatcher, LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.markwon.core.c f5208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f5209b;
    private final int c;
    private boolean d;
    private boolean e;
    private final GradientDrawable f;
    private final TextPaint g;
    private final TextPaint h;
    private final int i;
    private final TreeMap<Point, Layout> j;
    private final Lazy k;
    private final Lazy l;
    private final Lazy m;
    private final int n;

    public e(io.noties.markwon.core.c r5, c r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "theme");
        Intrinsics.checkNotNullParameter(r6, "info");
        this.f5208a = r5;
        this.f5209b = r6;
        this.c = r7;
        GradientDrawable r8 = new GradientDrawable();
        b r9 = r6.h();
        Integer r0 = null;
        if (r9 == null) goto L5;
        io.noties.markwon.scrollable.e r10 = r9.c();
    L7:
        if (r10 == null) goto L9;
        r8.setColor(r10.d());
        r8.setBounds(0, 0, r10.a(), r10.b());
        r8.setCornerRadius(r10.b() * 0.5f);
    L9:
        this.f = r8;
        TextPaint r11 = new TextPaint(1);
        r11.setTypeface(Typeface.MONOSPACE);
        r11.setTextSize(com.larus.business.markdown.impl.common.utils.c.e());
        b r2 = r6.h();
        if (r2 == null) goto L12;
        r11.setColor(r2.d());
    L12:
        this.g = r11;
        TextPaint r12 = new TextPaint(1);
        a r13 = r6.i();
        if (r13 == null) goto L15;
        r12.setTextSize(com.larus.business.markdown.impl.common.utils.c.e());
        r12.setColor(r13.c());
        r12.setTypeface(Typeface.MONOSPACE);
        r12.setTextAlign(Paint.Align.RIGHT);
    L15:
        this.h = r12;
        a r14 = r6.i();
        if (r14 == null) goto L18;
        r0 = Integer.valueOf(r14.b());
    L18:
        this.i = (int) r12.measureText(String.valueOf(r0));
        final Function2 r15 = (Function2) ZeusTransformUtils.preCheckCast(CodeBlockWithLineNumberScrollableSpan$layouts$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin");
        this.j = new TreeMap(new $$Lambda$e$ZJfE9WxXAJd2YBWvl_PXNkCg1cg(r15));
        this.k = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new CodeBlockWithLineNumberScrollableSpan$marginStart$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.l = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new CodeBlockWithLineNumberScrollableSpan$codeBlockWidth$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.m = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new CodeBlockWithLineNumberScrollableSpan$enableScroll$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.n = b() - getLeadingMargin(false);
        return;
    L5:
        r10 = null;
        goto L7
    }

    public static final /* synthetic */ int a(e r0) {
        return r0.i;
    }

    private static final int a(Function2 r2, Object r3, Object r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$tmp0");
        return ((Number) ZeusTransformUtils.preCheckCast(r5.invoke(r3, r4), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final Layout a(int r7, int r8) {
        Layout r0 = (Layout) ZeusTransformUtils.preCheckCast(this.j.get(new Point(r7, r8)), Layout.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L26;
        Set<Map.Entry<Point, Layout>> r6 = this.j.entrySet();
        Intrinsics.checkNotNullExpressionValue(r6, "layouts.entries");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r9.hasNext() == false) goto L15;
        Object r1 = r9.next();
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1, Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Point) ZeusTransformUtils.preCheckCast(r3.getKey(), Point.class, "com.obric.memorydata.plugin")).x == r7) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L6;
    L16:
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1, Map.Entry.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L20;
        return (Layout) ZeusTransformUtils.preCheckCast(r10.getValue(), Layout.class, "com.obric.memorydata.plugin");
    L20:
        return null;
    L10:
        if (((Point) ZeusTransformUtils.preCheckCast(r3.getKey(), Point.class, "com.obric.memorydata.plugin")).y < r8) goto L12;
        r4 = true;
        goto L13
    L15:
        r1 = null;
        goto L16
    L26:
        return r0;
    }

    private final Layout a(CharSequence r3, int r4, int r5) {
        SpannableStringBuilder r0 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4, r5);
        r0.removeSpan(this);
        CharSequence r6 = StringsKt.removeSuffix((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"));
        if (d() == false) goto L11;
        b r7 = this.f5209b.h();
        if (r7 == null) goto L7;
        io.noties.markwon.scrollable.b r8 = r7.b();
    L8:
        if (r8 == null) goto L11;
        return b(r6, Integer.MAX_VALUE, 1);
    L7:
        r8 = null;
    L11:
        return b(r6, c(), Integer.MAX_VALUE);
    }

    private final void a(TextPaint r3) {
        this.f5208a.d((Paint) ZeusTransformUtils.preCheckCast(r3, Paint.class, "com.obric.memorydata.plugin"));
    }

    private final void a(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, UpdateAppearance.class) == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, UpdateLayout.class) == true) goto L9;
        this.e = true;
        return;
    }

    private final int b() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.k.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final /* synthetic */ int b(e r0) {
        return r0.c;
    }

    private final Layout b(CharSequence r11, int r12, int r13) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L7;
        StaticLayout r10 = StaticLayout.Builder.obtain(r3, 0, r3.length(), this.g, r12).setIncludePad(false).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setMaxLines(r13).build();
        Intrinsics.checkNotNullExpressionValue(r10, "{\n            StaticLayo…       .build()\n        }");
        return (Layout) ZeusTransformUtils.preCheckCast(r10, Layout.class, "com.obric.memorydata.plugin");
    L7:
        return (Layout) ZeusTransformUtils.preCheckCast(new StaticLayout(r3, this.g, r12, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false), Layout.class, "com.obric.memorydata.plugin");
    }

    private final int c() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.l.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final /* synthetic */ int c(e r0) {
        return r0.b();
    }

    public static final /* synthetic */ c d(e r0) {
        return r0.f5209b;
    }

    private final boolean d() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.m.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public static /* synthetic */ int lambda$ZJfE9WxXAJd2YBWvl_PXNkCg1cg(Function2 r0, Object r1, Object r2) {
        return a(r0, r1, r2);
    }

    public boolean a() {
        return this.d;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r2, CharSequence r3, int r4, int r5, float r6, int r7, int r8, int r9, Paint r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "canvas");
        Intrinsics.checkNotNullParameter(r10, "paint");
        if (r11 != null) goto L6;
        return;
    L6:
        if (this.e == false) goto L8;
        Layout r12 = a(r11, r4, r5);
        ((Map) ZeusTransformUtils.preCheckCast(this.j, Map.class, "com.obric.memorydata.plugin")).put(new Point(r4, r5), r12);
    L9:
        int r13 = r2.save();
    L24:
        th = move-exception;
        r2.restoreToCount(r13);
        throw th;
    L11:
        if (d() == false) goto L13;
        r2.clipRect((int) (r6 + this.i), r7, this.c, r9);     // Catch: Throwable -> L24
    L13:
        b r14 = this.f5209b.h();     // Catch: Throwable -> L24
        if (r14 == null) goto L18;
        io.noties.markwon.scrollable.b r15 = r14.b();     // Catch: Throwable -> L24
        if (r15 == null) goto L18;
        float r16 = r15.b() + b();     // Catch: Throwable -> L24
    L19:
        r2.translate(r16, r7);     // Catch: Throwable -> L24
        if (r12 == null) goto L22;
        r12.draw(r2);     // Catch: Throwable -> L24
    L22:
        r2.restoreToCount(r13);
        return;
    L18:
        r16 = b();     // Catch: Throwable -> L24
        goto L19
    L8:
        r12 = a(r4, r5);
        goto L9
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, boolean r11, Layout r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "c");
        Intrinsics.checkNotNullParameter(r2, "p");
        Intrinsics.checkNotNullParameter(r13, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r12, "layout");
        a r14 = this.f5209b.i();
        io.noties.markwon.scrollable.e r15 = null;
        if (r14 == null) goto L7;
        Map<Integer, Integer> r16 = r14.a();
        if (r16 == null) goto L7;
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r16.get(Integer.valueOf(r9)), Integer.class, "com.obric.memorydata.plugin");
    L8:
        if (r17 == null) goto L10;
        r1.drawText(r17.toString(), (r3 + this.i) + getLeadingMargin(false), r5 + (this.h.descent() - this.h.ascent()), (Paint) ZeusTransformUtils.preCheckCast(this.h, Paint.class, "com.obric.memorydata.plugin"));
    L10:
        Integer r18 = this.f5209b.b();
        if (r18 != null) goto L14;
        return;
    L14:
        if (r10 != r18.intValue()) goto L34;
        b r19 = this.f5209b.h();
        if (r19 == null) goto L18;
        io.noties.markwon.scrollable.b r20 = r19.b();
    L19:
        b r21 = this.f5209b.h();
        if (r21 == null) goto L22;
        r15 = r21.c();
    L22:
        if (r20 != null) goto L24;
        return;
    L24:
        if (a() == false) goto L26;
        return;
    L26:
        if (d() == false) goto L39;
        if (r15 == null) goto L40;
        int r22 = r1.save();
        r1.translate((((-r20.b()) / r20.c()) * (c() - r15.a())) + b(), (r7 - r15.b()) - r15.c());     // Catch: Throwable -> L31
        this.f.draw(r1);     // Catch: Throwable -> L31
        r1.restoreToCount(r22);
        return;
    L31:
        th = move-exception;
        r1.restoreToCount(r22);
        throw th;
    L40:
        return;
    L39:
        return;
    L18:
        r20 = null;
        goto L19
    L34:
        return;
    L7:
        r17 = null;
        goto L8
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r1) {
        return com.larus.business.markdown.impl.common.utils.c.b();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r5, CharSequence r6, int r7, int r8, Paint.FontMetricsInt r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "paint");
        if (r10 != null) goto L5;
        return 0;
    L5:
        Layout r11 = a(r10, r7, r8);
        ((Map) ZeusTransformUtils.preCheckCast(this.j, Map.class, "com.obric.memorydata.plugin")).put(new Point(r7, r8), r11);
        b r12 = this.f5209b.h();
        io.noties.markwon.scrollable.e r0 = null;
        if (r12 == null) goto L8;
        io.noties.markwon.scrollable.b r13 = r12.b();
    L9:
        if (r13 != null) goto L11;
    L13:
        if (r9 == null) goto L34;
        Integer r1 = this.f5209b.b();
        if (r1 != null) goto L18;
    L20:
        boolean r14 = false;
    L21:
        b r2 = this.f5209b.h();
        if (r2 == null) goto L24;
        r0 = r2.c();
    L24:
        if (r14 == false) goto L29;
        if (r0 == null) goto L29;
        if (d() == false) goto L29;
        float r3 = r0.b() + r0.c();
    L30:
        r9.ascent = -r11.getHeight();
        if (r14 == false) goto L33;
        r9.ascent -= MathKt.roundToInt(r3);
    L33:
        r9.descent = 0;
        r9.top = r9.ascent;
        r9.bottom = 0;
        this.e = false;
    L29:
        r3 = 0.0f;
        goto L30
    L18:
        if (r8 != r1.intValue()) goto L20;
        r14 = true;
    L34:
        if (r13 == null) goto L39;
        if (d() == false) goto L39;
        return Math.min(c(), MathKt.roundToInt(r11.getLineWidth(0)));
    L39:
        return c();
    L11:
        if (d() == false) goto L13;
        r13.b(Math.max(r13.c(), r11.getLineWidth(0) - c()));
        goto L13
    L8:
        r13 = null;
        goto L9
    }

    @Override // android.text.SpanWatcher
    public void onSpanAdded(Spannable r1, Object r2, int r3, int r4) {
        Spannable r5 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r1, Spannable.class, "com.obric.memorydata.plugin");
        a(r2);
    }

    @Override // android.text.SpanWatcher
    public void onSpanChanged(Spannable r1, Object r2, int r3, int r4, int r5, int r6) {
        Spannable r7 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r1, Spannable.class, "com.obric.memorydata.plugin");
        a(r2);
    }

    @Override // android.text.SpanWatcher
    public void onSpanRemoved(Spannable r1, Object r2, int r3, int r4) {
        Spannable r5 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r1, Spannable.class, "com.obric.memorydata.plugin");
        a(r2);
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        a(r2);
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "p");
        a(r2);
    }
}
