package com.larus.business.markdown.impl.markwon;

import androidx.core.util.PatternsCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.k;
import io.noties.markwon.n;
import io.noties.markwon.t;
import io.noties.markwon.w;
import io.noties.markwon.x;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.Link;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/IgnoreMentionLinkifyPlugin;", "Lio/noties/markwon/linkify/LinkifyPlugin2;", "autoLinkMaxLimit", "", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "configure", "", "registry", "Lio/noties/markwon/MarkwonPlugin$Registry;", "LinkifyParser", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c extends io.noties.markwon.linkify.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f5194a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0017R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/IgnoreMentionLinkifyPlugin$LinkifyParser;", "Lio/noties/markwon/linkify/LinkifyPlugin2$InlineLinkifyParser;", "autoLinkMaxLimit", "", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "onTextAdded", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class a extends io.noties.markwon.linkify.a.C0867a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0218a f5195a = null;
        private static final Pattern d = null;
        private final Integer c;

        /* JADX INFO: renamed from: com.larus.business.markdown.impl.markwon.c$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/IgnoreMentionLinkifyPlugin$LinkifyParser$Companion;", "", "()V", "excludeMatcher", "Ljava/util/regex/Pattern;", "getExcludeMatcher", "()Ljava/util/regex/Pattern;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class C0218a {
            private C0218a() {
            }

            public /* synthetic */ C0218a(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            f5195a = new C0218a(null);
            Pattern r0 = Pattern.compile("[a-zA-Z]*\\.[a-zA-Z]*");
            Intrinsics.checkNotNullExpressionValue(r0, "compile(\"[a-zA-Z]*\\\\.[a-zA-Z]*\")");
            d = r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public a(Integer r1) {
            this.c = r1;
        }

        public /* synthetic */ a(Integer r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }

        @Override // io.noties.markwon.linkify.a.C0867a, io.noties.markwon.core.a.b
        public void a(n r9, String r10, int r11) {
            n r12 = (n) ZeusTransformUtils.wrapperContextForParams(r9, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "visitor");
            Intrinsics.checkNotNullParameter(r10, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            if (this.c != null) goto L5;
        L7:
            w r8 = r12.a().f().a(Link.class);
            if (r8 != null) goto L10;
            return;
        L10:
            Matcher r13 = io.noties.markwon.linkify.a.C0867a.f16644b.a().matcher((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"));
        L12:
            if (r13.find() == false) goto L22;
            int r0 = r13.start();
            int r2 = r13.end();
            String r3 = r13.group();
            Intrinsics.checkNotNullExpressionValue(r3, "url");
            if (StringsKt.startsWith$default(r3, "@", false, 2, null) == true) goto L12;
            if (d.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).matches() == true) goto L12;
            if (PatternsCompat.EMAIL_ADDRESS.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).find() == true) goto L12;
            t r4 = r12.b();
            Intrinsics.checkNotNullExpressionValue(r4, "visitor.renderProps()");
            x r5 = r12.c();
            Intrinsics.checkNotNullExpressionValue(r5, "visitor.builder()");
            CoreProps.g.b(r4, r3);
            io.noties.markwon.core.b.f16425a.a().c(r4);
            x.a(r5, r8.a(r12.a(), r4), r0 + r11, r2 + r11);
            goto L12
        L22:
            return;
        L5:
            if (r10.length() <= this.c.intValue()) goto L7;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "corePlugin", "Lio/noties/markwon/core/CorePlugin;", "apply"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b<P extends k> implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f5196a;

        b(c r1) {
            this.f5196a = r1;
        }

        public final void a(io.noties.markwon.core.a r3) {
            Intrinsics.checkNotNullParameter(r3, "corePlugin");
            r3.a((io.noties.markwon.core.a.b) ZeusTransformUtils.preCheckCast(new a(c.a(this.f5196a)), io.noties.markwon.core.a.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.noties.markwon.k.a
        public /* synthetic */ void a(k r3) {
            a((io.noties.markwon.core.a) ZeusTransformUtils.preCheckCast((k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin"), io.noties.markwon.core.a.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public c(Integer r1) {
        this.f5194a = r1;
    }

    public /* synthetic */ c(Integer r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public static final /* synthetic */ Integer a(c r0) {
        return r0.f5194a;
    }

    @Override // io.noties.markwon.linkify.a, io.noties.markwon.a, io.noties.markwon.k
    public void a(k.b r4) {
        k.b r5 = (k.b) ZeusTransformUtils.wrapperContextForParams(r4, k.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "registry");
        r5.a(io.noties.markwon.core.a.class, (k.a) ZeusTransformUtils.preCheckCast(new b(this), k.a.class, "com.obric.memorydata.plugin"));
    }
}
