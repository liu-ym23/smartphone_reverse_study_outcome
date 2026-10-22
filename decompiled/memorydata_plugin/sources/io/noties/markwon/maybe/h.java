package io.noties.markwon.maybe;

import android.widget.TextView;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.html.jsoup.parser.ParseErrorList;
import io.noties.markwon.html.jsoup.parser.Token;
import io.noties.markwon.inlineparser.m;
import io.noties.markwon.inlineparser.o;
import io.noties.markwon.k;
import io.noties.markwon.n;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.internal.DocumentParser;
import org.commonmark.node.Block;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.Parser;
import org.commonmark.parser.PostProcessor;
import org.commonmark.parser.block.BlockParserFactory;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 +2\u00020\u0001:\u0003+,-B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020#H\u0014J\u0018\u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020%H\u0014J\u001c\u0010&\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(H\u0014J\u0018\u0010)\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020*H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lio/noties/markwon/maybe/MaybePlugin;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "feature", "", "hideFeature", "(II)V", "getFeature", "()I", "getHideFeature", "originMarkdown", "Ljava/util/concurrent/atomic/AtomicReference;", "", "afterSetText", "", "textView", "Landroid/widget/TextView;", "configure", "registry", "Lio/noties/markwon/MarkwonPlugin$Registry;", "configureParser", "builder", "Lorg/commonmark/parser/Parser$Builder;", "configureTheme", "Lio/noties/markwon/core/MarkwonTheme$Builder;", "configureVisitor", "Lio/noties/markwon/MarkwonVisitor$Builder;", "processMarkdown", "markdown", "visitHtmlInline", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "maybe", "Lorg/commonmark/node/HtmlInline;", "visitImage", "Lorg/commonmark/node/Image;", "visitLink", "Lorg/commonmark/node/Link;", "visitMaybe", "node", "Lio/noties/markwon/maybe/MaybeNode;", "visitTable", "Lorg/commonmark/ext/gfm/tables/TableBlock;", "Companion", "Feature", "MaybeChildVisitor", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
public class h extends io.noties.markwon.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16652a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<String> f16653b;
    private final int c;
    private final int d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/noties/markwon/maybe/MaybePlugin$Companion;", "", "()V", "CODE_BLOCK", "", "HTML", "IMG", "LINK", "TABLE", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0014\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lio/noties/markwon/maybe/MaybePlugin$MaybeChildVisitor;", "Lio/noties/markwon/DelegateVisitor;", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "(Lio/noties/markwon/MarkwonVisitor;)V", "visit", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Lorg/commonmark/node/Text;", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    protected static class b extends io.noties.markwon.c {
        public b(n r3) {
            n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "visitor");
            super(r4);
        }

        @Override // io.noties.markwon.c, org.commonmark.node.Visitor
        public void visit(Text r1) {
        }
    }

    static {
        f16652a = new a(null);
    }

    public h() {
        int r0 = 0;
        this(r0, r0, 3, null);
    }

    public h(int r1, int r2) {
        this.c = r1;
        this.d = r2;
        this.f16653b = new AtomicReference();
    }

    public /* synthetic */ h(int r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 29;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 2;
    L8:
        this(r1, r2);
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public String a(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "markdown");
        this.f16653b.set(r2);
        String r1 = super.a(r2);
        Intrinsics.checkExpressionValueIsNotNull(r1, "super.processMarkdown(markdown)");
        return r1;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r2) {
        Intrinsics.checkParameterIsNotNull(r2, "textView");
        super.a(r2);
        this.f16653b.set("");
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(io.noties.markwon.core.c.a r2) {
        Intrinsics.checkParameterIsNotNull(r2, "builder");
        if ((this.c & 2) == 0) goto L5;
        boolean r1 = true;
    L6:
        r2.b(r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(k.b r5) {
        k.b r6 = (k.b) ZeusTransformUtils.wrapperContextForParams(r5, k.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "registry");
        if ((this.c & 1) == 0) goto L5;
    L6:
        ((m) ZeusTransformUtils.preCheckCast(r6.a(m.class), m.class, "com.obric.memorydata.plugin")).b().a((io.noties.markwon.inlineparser.i) ZeusTransformUtils.preCheckCast(new d(this.f16653b), io.noties.markwon.inlineparser.i.class, "com.obric.memorydata.plugin"));
    L8:
        if ((this.c & 2) == 0) goto L10;
    L11:
        ((m) ZeusTransformUtils.preCheckCast(r6.a(m.class), m.class, "com.obric.memorydata.plugin")).b().a(io.noties.markwon.inlineparser.d.class).a((io.noties.markwon.inlineparser.i) ZeusTransformUtils.preCheckCast(new e(this.f16653b), io.noties.markwon.inlineparser.i.class, "com.obric.memorydata.plugin"));
    L13:
        if ((this.c & 4) == 0) goto L15;
    L16:
        ((m) ZeusTransformUtils.preCheckCast(r6.a(m.class), m.class, "com.obric.memorydata.plugin")).b().a(o.class).a((io.noties.markwon.inlineparser.i) ZeusTransformUtils.preCheckCast(new f(this.f16653b), io.noties.markwon.inlineparser.i.class, "com.obric.memorydata.plugin"));
    L18:
        if ((this.c & 8) == 0) goto L20;
    L21:
        ((m) ZeusTransformUtils.preCheckCast(r6.a(m.class), m.class, "com.obric.memorydata.plugin")).b().a((io.noties.markwon.inlineparser.i) ZeusTransformUtils.preCheckCast(new j(this.f16653b), io.noties.markwon.inlineparser.i.class, "com.obric.memorydata.plugin"));
        return;
    L20:
        if ((this.d & 8) != 0) goto L21;
        return;
    L15:
        if ((this.d & 4) == 0) goto L18;
    L10:
        if ((this.d & 2) == 0) goto L13;
    L5:
        if ((this.d & 1) == 0) goto L8;
        goto L6
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(n.b r5) {
        n.b r6 = (n.b) ZeusTransformUtils.wrapperContextForParams(r5, n.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "builder");
        r6.a(g.class, (n.c) ZeusTransformUtils.preCheckCast(new i((Function2) ZeusTransformUtils.preCheckCast(new MaybePlugin$configureVisitor$1((h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.memorydata.plugin")), Function2.class, "com.obric.memorydata.plugin")), n.c.class, "com.obric.memorydata.plugin"));
    }

    public void a(n r4, g<?> r5) {
        n r6 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "visitor");
        Intrinsics.checkParameterIsNotNull(r5, "node");
        if ((this.c & 1) == 0) goto L10;
        if (ZeusTransformUtils.instanceOf(r5.f16650a, HtmlInline.class) == false) goto L10;
        if (a(r6, (HtmlInline) ZeusTransformUtils.preCheckCast(r5.f16650a, HtmlInline.class, "com.obric.memorydata.plugin")) == false) goto L10;
        return;
    L10:
        if ((this.c & 2) == 0) goto L17;
        if (ZeusTransformUtils.instanceOf(r5.f16650a, Image.class) == false) goto L17;
        if (a(r6, (Image) ZeusTransformUtils.preCheckCast(r5.f16650a, Image.class, "com.obric.memorydata.plugin")) == false) goto L17;
        return;
    L17:
        if ((this.c & 4) == 0) goto L24;
        if (ZeusTransformUtils.instanceOf(r5.f16650a, Link.class) == false) goto L24;
        if (a(r6, (Link) ZeusTransformUtils.preCheckCast(r5.f16650a, Link.class, "com.obric.memorydata.plugin")) == false) goto L24;
        return;
    L24:
        if ((this.c & 8) != 0) goto L26;
    L30:
        new b(r6).c((Node) ZeusTransformUtils.preCheckCast(r5, Node.class, "com.obric.memorydata.plugin"));
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(r5.f16650a, TableBlock.class) == false) goto L30;
        if (a(r6, (TableBlock) ZeusTransformUtils.preCheckCast(r5.f16650a, TableBlock.class, "com.obric.memorydata.plugin")) == false) goto L30;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(Parser.Builder r4) {
        Intrinsics.checkParameterIsNotNull(r4, "builder");
        if (this.c == 0) goto L6;
        r4.postProcessor((PostProcessor) ZeusTransformUtils.preCheckCast(new io.noties.markwon.maybe.a(), PostProcessor.class, "com.obric.memorydata.plugin"));
    L6:
        if ((this.c & 16) == 0) goto L9;
        Set<Class<? extends Block>> r3 = DocumentParser.getDefaultBlockParserTypes();
        Intrinsics.checkExpressionValueIsNotNull(r3, "DocumentParser.getDefaultBlockParserTypes()");
        Set<Class<? extends Block>> r5 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));
        r5.remove(FencedCodeBlock.class);
        r4.enabledBlockTypes(r5);
        r4.customBlockParserFactory((BlockParserFactory) ZeusTransformUtils.preCheckCast(new io.noties.markwon.maybe.b.C0869b(), BlockParserFactory.class, "com.obric.memorydata.plugin"));
        return;
    }

    public boolean a(n r3, TableBlock r4) {
        n r2 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r2, "visitor");
        Intrinsics.checkParameterIsNotNull(r4, "maybe");
        n.c<Node> r5 = r2.a((Node) ZeusTransformUtils.preCheckCast(r4, Node.class, "com.obric.memorydata.plugin"));
        if (r5 == null) goto L6;
        r5.a(r2, (Node) ZeusTransformUtils.preCheckCast(r4, Node.class, "com.obric.memorydata.plugin"));
        return true;
    L6:
        return false;
    }

    public boolean a(n r3, HtmlInline r4) {
        final n r2 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r2, "visitor");
        Intrinsics.checkParameterIsNotNull(r4, "maybe");
        Function1<HtmlInline, Unit> r5 = new MaybePlugin$visitHtmlInline$1(r2);
        io.noties.markwon.html.jsoup.parser.c r6 = new io.noties.markwon.html.jsoup.parser.c(new io.noties.markwon.html.jsoup.parser.a(r4.getLiteral()), ParseErrorList.noTracking());
        if (r6.a().f16583a != Token.TokenType.EOF) goto L9;
        Token.h r7 = r6.b();
        if (r7 == null) goto L11;
        HtmlInline r8 = new HtmlInline();
        r8.setLiteral(r7.toString());
        r5.invoke2(r8);
        return false;
    L11:
        return false;
    L9:
        r5.invoke2(r4);
        return true;
    }

    public boolean a(n r3, Image r4) {
        n r2 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r2, "visitor");
        Intrinsics.checkParameterIsNotNull(r4, "maybe");
        n.c<Node> r5 = r2.a((Node) ZeusTransformUtils.preCheckCast(r4, Node.class, "com.obric.memorydata.plugin"));
        if (r5 == null) goto L6;
        r5.a(r2, (Node) ZeusTransformUtils.preCheckCast(r4, Node.class, "com.obric.memorydata.plugin"));
        return true;
    L6:
        return false;
    }

    public boolean a(n r2, Link r3) {
        n r1 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r1, "visitor");
        Intrinsics.checkParameterIsNotNull(r3, "maybe");
        r1.c().a(r3.getTitle());
        return true;
    }
}
