package io.noties.markwon.core.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.CustomLinkSpan;
import io.noties.markwon.core.spans.CustomMentionSpan;
import io.noties.markwon.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/core/factory/CustomLinkSpanFactory;", "Lio/noties/markwon/core/factory/LinkSpanFactory;", "handler", "Lcom/larus/business/markdown/api/citation/ICitationHandler;", "(Lcom/larus/business/markdown/api/citation/ICitationHandler;)V", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.larus.business.markdown.api.a.a f16417a;

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public e(com.larus.business.markdown.api.a.a r3) {
        this.f16417a = (com.larus.business.markdown.api.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.larus.business.markdown.api.a.a.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ e(com.larus.business.markdown.api.a.a r2, int r3, DefaultConstructorMarker r4) {
        com.larus.business.markdown.api.a.a r5 = (com.larus.business.markdown.api.a.a) ZeusTransformUtils.wrapperContextForParams(r2, com.larus.business.markdown.api.a.a.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }

    @Override // io.noties.markwon.core.a.i, io.noties.markwon.w
    public Object a(io.noties.markwon.i r9, t r10) {
        t r11 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "configuration");
        Intrinsics.checkNotNullParameter(r11, "props");
        String r0 = CoreProps.g.b(r11);
        Intrinsics.checkNotNullExpressionValue(r0, "LINK_DESTINATION.require(props)");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(io.noties.markwon.core.b.f16425a.a().b(r11), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
    L6:
        String r4 = r12;
        Intrinsics.checkNotNullExpressionValue(r4, "try {\n            CorePl…\n            \"\"\n        }");
        com.larus.business.markdown.api.a.a r13 = this.f16417a;
        if (r13 != null) goto L9;
    L11:
        boolean r14 = false;
    L13:
        if (r14 == false) goto L16;
        io.noties.markwon.core.c r1 = r9.a();
        Intrinsics.checkNotNullExpressionValue(r1, "configuration.theme()");
        io.noties.markwon.d r6 = r9.d();
        Intrinsics.checkNotNullExpressionValue(r6, "configuration.linkResolver()");
        return new io.noties.markwon.core.spans.g(r1, r4, r5, r6, this.f16417a);
    L16:
        if (StringsKt.startsWith$default(r5, "mention://", false, 2, null) == true) goto L23;
        io.noties.markwon.core.c r8 = r9.a();
        Intrinsics.checkNotNullExpressionValue(r8, "configuration.theme()");
        io.noties.markwon.d r15 = r9.d();
        Intrinsics.checkNotNullExpressionValue(r15, "configuration.linkResolver()");
        return new CustomLinkSpan(r8, r5, r15);
    L23:
        return new CustomMentionSpan(1);
    L9:
        if (r13.a(r4) != true) goto L11;
        r14 = true;
    L5:
        r12 = "";
        goto L6
    }
}
