package io.noties.markwon.core.spans.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.i;
import io.noties.markwon.t;
import io.noties.markwon.w;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lio/noties/markwon/core/spans/codeblock/CodeBlockSpanFactory2;", "Lio/noties/markwon/SpanFactory;", "titleBgColor", "", "cornerRadius", "", "enableScroll", "", "enableLineNumber", "scrollBarTheme", "Lio/noties/markwon/scrollable/ScrollBarTheme;", "screenWidth", "lineNumberColor", "codeTextColor", "borderWidth", "borderColor", "enableBackground", "(IFZZLio/noties/markwon/scrollable/ScrollBarTheme;IIIFIZ)V", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f16447b;
    private final boolean c;
    private final boolean d;
    private final io.noties.markwon.scrollable.e e;
    private final int f;
    private final int g;
    private final int h;
    private final float i;
    private final int j;
    private final boolean k;

    public b(int r2, float r3, boolean r4, boolean r5, io.noties.markwon.scrollable.e r6, int r7, int r8, int r9, float r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r6, "scrollBarTheme");
        this.f16446a = r2;
        this.f16447b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }

    @Override // io.noties.markwon.w
    public Object a(i r19, t r20) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r20, t.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r19, "configuration");
        Intrinsics.checkNotNullParameter(r1, "props");
        if (this.d == false) goto L11;
        io.noties.markwon.core.c r4 = r19.a();
        Intrinsics.checkNotNullExpressionValue(r4, "configuration.theme()");
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r1.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.a()), Integer.class, "com.obric.memorydata.plugin");
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r1.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.b()), Integer.class, "com.obric.memorydata.plugin");
        int r9 = this.f16446a;
        float r10 = this.f16447b;
        float r11 = this.i;
        int r12 = this.j;
        boolean r13 = this.k;
        com.larus.business.markdown.impl.markwon.core.spans.codeblock.b r14 = new com.larus.business.markdown.impl.markwon.core.spans.codeblock.b(this.c, (io.noties.markwon.scrollable.b) ZeusTransformUtils.preCheckCast(r1.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.c()), io.noties.markwon.scrollable.b.class, "com.obric.memorydata.plugin"), this.e, this.h);
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(r1.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.e()), Map.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        r3 = MapsKt.emptyMap();
    L7:
        int r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.d()), Integer.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L13;
        r2 = 0;
    L13:
        return new com.larus.business.markdown.impl.markwon.core.spans.codeblock.e(r4, new com.larus.business.markdown.impl.markwon.core.spans.codeblock.c(r7, r8, r9, r10, r11, r12, r13, r14, new com.larus.business.markdown.impl.markwon.core.spans.codeblock.a(r3, ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue(), this.g)), this.f);
    L11:
        io.noties.markwon.core.c r5 = r19.a();
        Intrinsics.checkNotNullExpressionValue(r5, "configuration.theme()");
        return new a(r5, new com.larus.business.markdown.impl.markwon.core.spans.codeblock.c((Integer) ZeusTransformUtils.preCheckCast(r1.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.a()), Integer.class, "com.obric.memorydata.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r1.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.b()), Integer.class, "com.obric.memorydata.plugin"), this.f16446a, this.f16447b, this.i, this.j, this.k, null, null, 384, null));
    }
}
