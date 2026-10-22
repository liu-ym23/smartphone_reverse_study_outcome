package androidx.room.parser;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.antlr.v4.runtime.Parser;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeVisitor;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.TerminalNode;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005JX\u0010\u0007\u001a\n \t*\u0004\u0018\u0001H\bH\b\"\u0010\b\u0000\u0010\b*\n \t*\u0004\u0018\u00010\n0\n2.\u0010\u000b\u001a*\u0012\u000e\b\u0001\u0012\n \t*\u0004\u0018\u0001H\bH\b \t*\u0014\u0012\u000e\b\u0001\u0012\n \t*\u0004\u0018\u0001H\bH\b\u0018\u00010\f0\fH\u0096\u0001¢\u0006\u0002\u0010\rJ\t\u0010\u000e\u001a\u00020\u0001HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\nHÖ\u0003J\u0019\u0010\u0013\u001a\n \t*\u0004\u0018\u00010\u00140\u00142\u0006\u0010\u000b\u001a\u00020\u0015H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010\u0017\u001a\n \t*\u0004\u0018\u00010\u00140\u0014H\u0096\u0001J\u0011\u0010\u0018\u001a\n \t*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0011\u0010\u0019\u001a\n \t*\u0004\u0018\u00010\u001a0\u001aH\u0096\u0001J\u0011\u0010\u001b\u001a\n \t*\u0004\u0018\u00010\u001c0\u001cH\u0096\u0001J\u0011\u0010\u001d\u001a\n \t*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0015HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u000e\u0010\u000b\u001a\n \t*\u0004\u0018\u00010\"0\"H\u0096\u0001J\t\u0010#\u001a\u00020\u001eHÖ\u0001J\u0011\u0010$\u001a\n \t*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001J!\u0010$\u001a\n \t*\u0004\u0018\u00010\u001e0\u001e2\u000e\u0010\u000b\u001a\n \t*\u0004\u0018\u00010%0%H\u0096\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/room/parser/BindParameterNode;", "Landroidx/room/jarjarred/org/antlr/v4/runtime/tree/TerminalNode;", "node", "isMultiple", "", "(Lorg/antlr/v4/runtime/tree/TerminalNode;Z)V", "()Z", "accept", ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "", "p0", "Landroidx/room/jarjarred/org/antlr/v4/runtime/tree/ParseTreeVisitor;", "(Lorg/antlr/v4/runtime/tree/ParseTreeVisitor;)Ljava/lang/Object;", "component1", "component2", "copy", "equals", "other", "getChild", "Landroidx/room/jarjarred/org/antlr/v4/runtime/tree/ParseTree;", "", "getChildCount", "getParent", "getPayload", "getSourceInterval", "Landroidx/room/jarjarred/org/antlr/v4/runtime/misc/Interval;", "getSymbol", "Landroidx/room/jarjarred/org/antlr/v4/runtime/Token;", "getText", "", "hashCode", "setParent", "", "Landroidx/room/jarjarred/org/antlr/v4/runtime/RuleContext;", "toString", "toStringTree", "Landroidx/room/jarjarred/org/antlr/v4/runtime/Parser;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BindParameterNode implements TerminalNode {
    private final boolean isMultiple;
    private final TerminalNode node;

    public BindParameterNode(TerminalNode r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "node");
        this.node = r5;
        this.isMultiple = r10;
    }

    private final TerminalNode component1() {
        return this.node;
    }

    public static /* synthetic */ BindParameterNode copy$default(BindParameterNode r5, TerminalNode r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.node;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.isMultiple;
    L9:
        return r5.copy(r10, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
    public <T> T accept(ParseTreeVisitor<? extends T> r5) {
        return (T) this.node.accept(r5);
    }

    public final boolean component2() {
        return this.isMultiple;
    }

    public final BindParameterNode copy(TerminalNode r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "node");
        return new BindParameterNode(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BindParameterNode) == true) goto L8;
        return false;
    L8:
        BindParameterNode r10 = (BindParameterNode) r5;
        if (Intrinsics.areEqual(this.node, r10.node) == true) goto L12;
        return false;
    L12:
        if (this.isMultiple == r10.isMultiple) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public ParseTree getChild(int r5) {
        return this.node.getChild(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public int getChildCount() {
        return this.node.getChildCount();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public ParseTree getParent() {
        return this.node.getParent();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public Object getPayload() {
        return this.node.getPayload();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.SyntaxTree
    public Interval getSourceInterval() {
        return this.node.getSourceInterval();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.TerminalNode
    public Token getSymbol() {
        return this.node.getSymbol();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
    public String getText() {
        return this.node.getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        int r5 = this.node.hashCode() * 31;
        boolean r10 = this.isMultiple;
        ?? r11 = r10;
        if (r10 == false) goto L6;
        r11 = 1;
    L6:
        return r5 + r11;
    }

    public final boolean isMultiple() {
        return this.isMultiple;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
    public void setParent(RuleContext r5) {
        this.node.setParent(r5);
    }

    public String toString() {
        return "BindParameterNode(node=" + this.node + ", isMultiple=" + this.isMultiple + ")";
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public String toStringTree() {
        return this.node.toStringTree();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree getChild(int r5) {
        return getChild(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree getParent() {
        return getParent();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
    public String toStringTree(Parser r5) {
        return this.node.toStringTree(r5);
    }
}
