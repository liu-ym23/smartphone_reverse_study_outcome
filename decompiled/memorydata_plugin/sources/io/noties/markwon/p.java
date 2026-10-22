package io.noties.markwon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.CustomBlock;
import org.commonmark.node.CustomNode;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: classes6.dex */
class p implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f16657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t f16658b;
    private final x c;
    private final Map<Class<? extends Node>, n.c<? extends Node>> d;
    private final n.a e;

    static class a implements n.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Class<? extends Node>, n.c<? extends Node>> f16659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private n.a f16660b;

        a() {
            this.f16659a = new HashMap();
        }

        @Override // io.noties.markwon.n.b
        public n.b a(n.a r3) {
            this.f16660b = (n.a) ZeusTransformUtils.wrapperContextForParams(r3, n.a.class, "com.obric.memorydata.plugin");
            return this;
        }

        @Override // io.noties.markwon.n.b
        public <N extends Node> n.b a(Class<N> r3, n.c<? super N> r4) {
            n.c<? extends Node> r5 = (n.c) ZeusTransformUtils.wrapperContextForParams(r4, n.c.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L5;
            this.f16659a.remove(r3);
        L6:
            return this;
        L5:
            this.f16659a.put(r3, r5);
            goto L6
        }

        @Override // io.noties.markwon.n.b
        public n a(i r7, t r8) {
            t r2 = (t) ZeusTransformUtils.wrapperContextForParams(r8, t.class, "com.obric.memorydata.plugin");
            n.a r9 = this.f16660b;
            if (r9 != null) goto L5;
            r9 = new b();
        L5:
            x r3 = new x();
            Map r4 = Collections.unmodifiableMap(this.f16659a);
            return new p(r7, r2, r3, r4, r9);
        }
    }

    p(i r3, t r4, x r5, Map<Class<? extends Node>, n.c<? extends Node>> r6, n.a r7) {
        t r8 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        Map<Class<? extends Node>, n.c<? extends Node>> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        n.a r10 = (n.a) ZeusTransformUtils.wrapperContextForParams(r7, n.a.class, "com.obric.memorydata.plugin");
        this.f16657a = r3;
        this.f16658b = r8;
        this.c = r5;
        this.d = r9;
        this.e = r10;
    }

    private void b(Node r2) {
        n.c<Node> r0 = a(r2);
        if (r0 == null) goto L5;
        r0.a(this, r2);
        io.noties.markwon.g.g.f16546a.a(r2, this);
        return;
    L5:
        c(r2);
    }

    @Override // io.noties.markwon.n
    public i a() {
        return this.f16657a;
    }

    @Override // io.noties.markwon.n
    public n.c<Node> a(Node r2) {
        return (n.c) ZeusTransformUtils.preCheckCast(this.d.get(r2.getClass()), n.c.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.n
    public void a(int r2, Object r3) {
        x r1 = this.c;
        x.a(r1, r3, r2, r1.length());
    }

    public <N extends Node> void a(Class<N> r3, int r4) {
        a(r4, this.f16657a.f().b(r3).a(this.f16657a, this.f16658b));
    }

    @Override // io.noties.markwon.n
    public <N extends Node> void a(N r1, int r2) {
        a(r1.getClass(), r2);
    }

    @Override // io.noties.markwon.n
    public t b() {
        return this.f16658b;
    }

    public <N extends Node> void b(Class<N> r3, int r4) {
        w r5 = this.f16657a.f().a(r3);
        if (r5 == null) goto L6;
        a(r4, r5.a(this.f16657a, this.f16658b));
        return;
    }

    @Override // io.noties.markwon.n
    public <N extends Node> void b(N r1, int r2) {
        b(r1.getClass(), r2);
    }

    @Override // io.noties.markwon.n
    public x c() {
        return this.c;
    }

    @Override // io.noties.markwon.n
    public void c(Node r2) {
        Node r3 = r2.getFirstChild();
    L3:
        if (r3 == null) goto L5;
        Node r0 = r3.getNext();
        r3.accept(this);
        r3 = r0;
        goto L3
    }

    @Override // io.noties.markwon.n
    public void d() {
        if (this.c.length() > 0) goto L5;
        return;
    L5:
        if ('\n' == this.c.a()) goto L9;
        this.c.a('\n');
        return;
    }

    @Override // io.noties.markwon.n
    public boolean d(Node r1) {
        if (r1.getNext() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.noties.markwon.n
    public void e() {
        this.c.a('\n');
    }

    @Override // io.noties.markwon.n
    public void e(Node r2) {
        this.e.b(this, r2);
    }

    @Override // io.noties.markwon.n
    public int f() {
        return this.c.length();
    }

    @Override // io.noties.markwon.n
    public void f(Node r2) {
        this.e.a(this, r2);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(BlockQuote r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(BulletList r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Code r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(CustomBlock r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(CustomNode r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Document r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Emphasis r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(FencedCodeBlock r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(HardLineBreak r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Heading r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(HtmlBlock r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(HtmlInline r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Image r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(IndentedCodeBlock r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Link r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(LinkReferenceDefinition r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(ListItem r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(OrderedList r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Paragraph r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(SoftLineBreak r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(StrongEmphasis r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Text r1) {
        b(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(ThematicBreak r1) {
        b(r1);
    }
}
