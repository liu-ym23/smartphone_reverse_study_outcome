package org.commonmark.node;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractVisitor implements Visitor {
    public AbstractVisitor() {
    }

    @Override // org.commonmark.node.Visitor
    public void visit(BlockQuote r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(BulletList r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Code r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(CustomBlock r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(CustomNode r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Document r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Emphasis r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(FencedCodeBlock r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(HardLineBreak r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Heading r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(HtmlBlock r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(HtmlInline r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Image r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(IndentedCodeBlock r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Link r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(LinkReferenceDefinition r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(ListItem r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(OrderedList r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Paragraph r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(SoftLineBreak r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(StrongEmphasis r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(Text r1) {
        visitChildren(r1);
    }

    @Override // org.commonmark.node.Visitor
    public void visit(ThematicBreak r1) {
        visitChildren(r1);
    }

    public void visitChildren(Node r2) {
        Node r3 = r2.getFirstChild();
    L3:
        if (r3 == null) goto L5;
        Node r0 = r3.getNext();
        r3.accept(this);
        r3 = r0;
        goto L3
    }
}
