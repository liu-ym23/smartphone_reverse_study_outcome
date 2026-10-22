package io.noties.markwon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
public class c implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f16404a;

    public c(n r3) {
        this.f16404a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.n
    public i a() {
        return this.f16404a.a();
    }

    @Override // io.noties.markwon.n
    public n.c<Node> a(Node r1) {
        return this.f16404a.a(r1);
    }

    @Override // io.noties.markwon.n
    public void a(int r1, Object r2) {
        this.f16404a.a(r1, r2);
    }

    @Override // io.noties.markwon.n
    public <N extends Node> void a(N r1, int r2) {
        this.f16404a.a(r1, r2);
    }

    @Override // io.noties.markwon.n
    public t b() {
        return this.f16404a.b();
    }

    public void b(Node r2) {
        n.c<Node> r0 = a(r2);
        if (r0 == null) goto L5;
        r0.a(this, r2);
        return;
    L5:
        c(r2);
    }

    @Override // io.noties.markwon.n
    public <N extends Node> void b(N r1, int r2) {
        this.f16404a.b(r1, r2);
    }

    @Override // io.noties.markwon.n
    public x c() {
        return this.f16404a.c();
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
        this.f16404a.d();
    }

    @Override // io.noties.markwon.n
    public boolean d(Node r1) {
        return this.f16404a.d(r1);
    }

    @Override // io.noties.markwon.n
    public void e() {
        this.f16404a.e();
    }

    @Override // io.noties.markwon.n
    public void e(Node r1) {
        this.f16404a.e(r1);
    }

    @Override // io.noties.markwon.n
    public int f() {
        return this.f16404a.f();
    }

    @Override // io.noties.markwon.n
    public void f(Node r1) {
        this.f16404a.f(r1);
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
