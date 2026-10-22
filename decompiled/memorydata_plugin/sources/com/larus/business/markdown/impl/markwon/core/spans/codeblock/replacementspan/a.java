package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan;

import com.larus.business.markdown.impl.markwon.core.spans.codeblock.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.i;
import io.noties.markwon.scrollable.e;
import io.noties.markwon.t;
import io.noties.markwon.w;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00130\u0012\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/CodeBlockSpanFactory3;", "Lio/noties/markwon/SpanFactory;", "titleBgColor", "", "cornerRadius", "", "enableScroll", "", "enableLineNumber", "scrollBarTheme", "Lio/noties/markwon/scrollable/ScrollBarTheme;", "screenWidth", "lineNumberColor", "codeTextColor", "borderWidth", "borderColor", "enableBackground", "getPayload", "Lkotlin/Function0;", "", "", "", "customCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "contentMaxWidth", "(IFZZLio/noties/markwon/scrollable/ScrollBarTheme;IIIFIZLkotlin/jvm/functions/Function0;Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;I)V", "getSpans", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "node", "Lorg/commonmark/node/Node;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f5215b;
    private final boolean c;
    private final boolean d;
    private final e e;
    private final int f;
    private final int g;
    private final int h;
    private final float i;
    private final int j;
    private final boolean k;
    private final Function0<Map<String, Object>> l;
    private final com.larus.business.markdown.api.extplugin.a.a m;
    private final int n;

    public a(int r7, float r8, boolean r9, boolean r10, e r11, int r12, int r13, int r14, float r15, int r16, boolean r17, Function0<? extends Map<String, ? extends Object>> r18, com.larus.business.markdown.api.extplugin.a.a r19, int r20) {
        Function0<Map<String, Object>> r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r18, Function0.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.extplugin.a.a r3 = (com.larus.business.markdown.api.extplugin.a.a) ZeusTransformUtils.wrapperContextForParams(r19, com.larus.business.markdown.api.extplugin.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "scrollBarTheme");
        Intrinsics.checkNotNullParameter(r2, "getPayload");
        this.f5214a = r7;
        this.f5215b = r8;
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r2;
        this.m = r3;
        this.n = r20;
    }

    @Override // io.noties.markwon.w
    public Object a(i r3, t r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "configuration");
        Intrinsics.checkNotNullParameter(r5, "props");
        return a(r3, r5, null);
    }

    public final Object a(i r17, t r18, Node r19) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r18, t.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "configuration");
        Intrinsics.checkNotNullParameter(r1, "props");
        if (this.d == false) goto L13;
        io.noties.markwon.core.c r4 = r17.a();
        Intrinsics.checkNotNullExpressionValue(r4, "configuration.theme()");
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r1.a(d.a()), Integer.class, "com.obric.memorydata.plugin");
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r1.a(d.b()), Integer.class, "com.obric.memorydata.plugin");
        int r9 = this.f5214a;
        float r10 = this.f5215b;
        float r11 = this.i;
        int r12 = this.j;
        boolean r13 = this.k;
        com.larus.business.markdown.impl.markwon.core.spans.codeblock.b r14 = new com.larus.business.markdown.impl.markwon.core.spans.codeblock.b(this.c, (io.noties.markwon.scrollable.b) ZeusTransformUtils.preCheckCast(r1.a(d.c()), io.noties.markwon.scrollable.b.class, "com.obric.memorydata.plugin"), this.e, this.h);
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(r1.a(d.e()), Map.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        r3 = MapsKt.emptyMap();
    L7:
        int r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.a(d.d()), Integer.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L11;
        r2 = 0;
    L11:
        return new com.larus.business.markdown.impl.markwon.core.spans.codeblock.e(r4, new com.larus.business.markdown.impl.markwon.core.spans.codeblock.c(r7, r8, r9, r10, r11, r12, r13, r14, new com.larus.business.markdown.impl.markwon.core.spans.codeblock.a(r3, ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue(), this.g)), this.f);
    L13:
        return new b((Map) ZeusTransformUtils.preCheckCast(this.l.invoke(), Map.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.a(CoreProps.l), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.a(CoreProps.k), String.class, "com.obric.memorydata.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r1.a(d.a()), Integer.class, "com.obric.memorydata.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r1.a(d.b()), Integer.class, "com.obric.memorydata.plugin"), this.n, this.m);
    }
}
