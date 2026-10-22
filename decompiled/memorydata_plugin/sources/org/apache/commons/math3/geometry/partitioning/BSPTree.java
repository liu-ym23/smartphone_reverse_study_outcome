package org.apache.commons.math3.geometry.partitioning;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public class BSPTree<S extends Space> {
    private Object attribute;
    private SubHyperplane<S> cut;
    private BSPTree<S> minus;
    private BSPTree<S> parent;
    private BSPTree<S> plus;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.partitioning.BSPTree$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = null;

        static {
            int[] r0 = new int[Side.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = r0;
            r0[Side.PLUS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L27:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.MINUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L33:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.BOTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L8:
            int[] r3 = new int[BSPTreeVisitor.Order.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order = r3;
            r3[BSPTreeVisitor.Order.PLUS_MINUS_SUB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L41:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.PLUS_SUB_MINUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L25:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.MINUS_PLUS_SUB.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L31:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.MINUS_SUB_PLUS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L39:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.SUB_PLUS_MINUS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L29:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.SUB_MINUS_PLUS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
            return;
        }
    }

    public interface LeafMerger<S extends Space> {
        BSPTree<S> merge(BSPTree<S> r1, BSPTree<S> r2, BSPTree<S> r3, boolean r4, boolean r5);
    }

    public interface VanishingCutHandler<S extends Space> {
        BSPTree<S> fixNode(BSPTree<S> r1);
    }

    public BSPTree() {
        this.cut = null;
        this.plus = null;
        this.minus = null;
        this.parent = null;
        this.attribute = null;
    }

    public BSPTree(Object r2) {
        this.cut = null;
        this.plus = null;
        this.minus = null;
        this.parent = null;
        this.attribute = r2;
    }

    public BSPTree(SubHyperplane<S> r3, BSPTree<S> r4, BSPTree<S> r5, Object r6) {
        this.cut = (SubHyperplane) ZeusTransformUtils.wrapperContextForParams(r3, SubHyperplane.class, "com.obric.memorydata.plugin");
        this.plus = r4;
        this.minus = r5;
        this.parent = null;
        this.attribute = r6;
        r4.parent = this;
        r5.parent = this;
    }

    private void chopOffMinus(Hyperplane<S> r3, VanishingCutHandler<S> r4) {
        Hyperplane<S> r5 = (Hyperplane) ZeusTransformUtils.wrapperContextForParams(r3, Hyperplane.class, "com.obric.memorydata.plugin");
        VanishingCutHandler<S> r6 = (VanishingCutHandler) ZeusTransformUtils.wrapperContextForParams(r4, VanishingCutHandler.class, "com.obric.memorydata.plugin");
        SubHyperplane<S> r0 = this.cut;
        if (r0 == null) goto L8;
        this.cut = (SubHyperplane<S>) r0.split(r5).getPlus();
        this.plus.chopOffMinus(r5, r6);
        this.minus.chopOffMinus(r5, r6);
        if (this.cut != null) goto L9;
        BSPTree<S> r7 = r6.fixNode(this);
        this.cut = r7.cut;
        this.plus = r7.plus;
        this.minus = r7.minus;
        this.attribute = r7.attribute;
        return;
    L9:
        return;
    }

    private void chopOffPlus(Hyperplane<S> r3, VanishingCutHandler<S> r4) {
        Hyperplane<S> r5 = (Hyperplane) ZeusTransformUtils.wrapperContextForParams(r3, Hyperplane.class, "com.obric.memorydata.plugin");
        VanishingCutHandler<S> r6 = (VanishingCutHandler) ZeusTransformUtils.wrapperContextForParams(r4, VanishingCutHandler.class, "com.obric.memorydata.plugin");
        SubHyperplane<S> r0 = this.cut;
        if (r0 == null) goto L8;
        this.cut = (SubHyperplane<S>) r0.split(r5).getMinus();
        this.plus.chopOffPlus(r5, r6);
        this.minus.chopOffPlus(r5, r6);
        if (this.cut != null) goto L9;
        BSPTree<S> r7 = r6.fixNode(this);
        this.cut = r7.cut;
        this.plus = r7.plus;
        this.minus = r7.minus;
        this.attribute = r7.attribute;
        return;
    L9:
        return;
    }

    private void condense() {
        if (this.cut == null) goto L20;
        BSPTree<S> r0 = this.plus;
        if (r0.cut != null) goto L21;
        BSPTree<S> r1 = this.minus;
        if (r1.cut != null) goto L22;
        Object r2 = r0.attribute;
        if (r2 == null) goto L11;
    L12:
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.equals(r1.attribute) == false) goto L24;
    L15:
        Object r3 = this.plus.attribute;
        if (r3 != null) goto L18;
        r3 = this.minus.attribute;
    L18:
        this.attribute = r3;
        this.cut = null;
        this.plus = null;
        this.minus = null;
        return;
    L24:
        return;
    L11:
        if (r1.attribute == null) goto L15;
    L22:
        return;
    L21:
        return;
    }

    private SubHyperplane<S> fitToCell(SubHyperplane<S> r3) {
        SubHyperplane<S> r4 = (SubHyperplane) ZeusTransformUtils.wrapperContextForParams(r3, SubHyperplane.class, "com.obric.memorydata.plugin");
    L3:
        BSPTree<S> r0 = this.parent;
        if (r0 == null) goto L11;
        if (r4 == null) goto L11;
        BSPTree<S> r1 = r0.plus;
        SubHyperplane.SplitSubHyperplane<S> r5 = r4.split(r0.cut.getHyperplane());
        if (this != r1) goto L9;
        r4 = r5.getPlus();
    L10:
        BSPTree<S> this = this.parent;
        goto L3
    L9:
        r4 = r5.getMinus();
    L11:
        return r4;
    }

    private BSPTree<S> merge(BSPTree<S> r7, LeafMerger<S> r8, BSPTree<S> r9, boolean r10) {
        LeafMerger<S> r0 = (LeafMerger) ZeusTransformUtils.wrapperContextForParams(r8, LeafMerger.class, "com.obric.memorydata.plugin");
        SubHyperplane<S> r11 = this.cut;
        if (r11 != null) goto L8;
        boolean r5 = true;
        BSPTree<S> r1 = this;
        BSPTree<S> r2 = r7;
    L6:
        return r0.merge(r1, r2, r9, r10, r5);
    L8:
        if (r7.cut != null) goto L10;
        r5 = false;
        r1 = r7;
        r2 = this;
        goto L6
    L10:
        BSPTree<S> r12 = r7.split(r11);
        if (r9 == null) goto L16;
        r12.parent = r9;
        if (r10 == false) goto L15;
        r9.plus = r12;
        goto L16
    L15:
        r9.minus = r12;
    L16:
        this.plus.merge(r12.plus, r0, r12, true);
        this.minus.merge(r12.minus, r0, r12, false);
        r12.condense();
        SubHyperplane<S> r6 = r12.cut;
        if (r6 == null) goto L19;
        r12.cut = r12.fitToCell(r6.getHyperplane().wholeHyperplane());
    L19:
        return r12;
    }

    public BSPTree<S> copySelf() {
        if (this.cut != null) goto L7;
        return new BSPTree(this.attribute);
    L7:
        return new BSPTree(this.cut.copySelf(), this.plus.copySelf(), this.minus.copySelf(), this.attribute);
    }

    public Object getAttribute() {
        return this.attribute;
    }

    public SubHyperplane<S> getCut() {
        return this.cut;
    }

    public BSPTree<S> getMinus() {
        return this.minus;
    }

    public BSPTree<S> getParent() {
        return this.parent;
    }

    public BSPTree<S> getPlus() {
        return this.plus;
    }

    public boolean insertCut(Hyperplane<S> r3) {
        Hyperplane r4 = (Hyperplane) ZeusTransformUtils.wrapperContextForParams(r3, Hyperplane.class, "com.obric.memorydata.plugin");
        if (this.cut == null) goto L5;
        this.plus.parent = null;
        this.minus.parent = null;
    L5:
        SubHyperplane<S> r5 = fitToCell(r4.wholeHyperplane());
        if (r5 != null) goto L8;
    L12:
        this.cut = null;
        this.plus = null;
        this.minus = null;
        return false;
    L8:
        if (r5.isEmpty() == true) goto L12;
        this.cut = r5;
        BSPTree<S> r6 = new BSPTree();
        this.plus = r6;
        r6.parent = this;
        BSPTree<S> r7 = new BSPTree();
        this.minus = r7;
        r7.parent = this;
        return true;
    }

    public void insertInTree(BSPTree<S> r3, boolean r4, VanishingCutHandler<S> r5) {
        VanishingCutHandler<S> r6 = (VanishingCutHandler) ZeusTransformUtils.wrapperContextForParams(r5, VanishingCutHandler.class, "com.obric.memorydata.plugin");
        this.parent = r3;
        if (r3 == null) goto L8;
        if (r4 == false) goto L6;
        r3.plus = this;
        goto L8
    L6:
        r3.minus = this;
    L8:
        if (this.cut == null) goto L28;
        BSPTree<S> r7 = this;
    L10:
        BSPTree<S> r8 = r7.parent;
        if (r8 == null) goto L22;
        Hyperplane<S> r9 = r8.cut.getHyperplane();
        if (r7 != r7.parent.plus) goto L15;
        this.cut = (SubHyperplane<S>) this.cut.split(r9).getPlus();
        this.plus.chopOffMinus(r9, r6);
        this.minus.chopOffMinus(r9, r6);
    L17:
        if (this.cut != null) goto L21;
        BSPTree<S> r10 = r6.fixNode(this);
        SubHyperplane<S> r0 = r10.cut;
        this.cut = r0;
        this.plus = r10.plus;
        this.minus = r10.minus;
        this.attribute = r10.attribute;
        if (r0 == null) goto L22;
    L21:
        r7 = r7.parent;
        goto L10
    L15:
        this.cut = (SubHyperplane<S>) this.cut.split(r9).getMinus();
        this.plus.chopOffPlus(r9, r6);
        this.minus.chopOffPlus(r9, r6);
    L22:
        condense();
        return;
    }

    public BSPTree<S> merge(BSPTree<S> r3, LeafMerger<S> r4) {
        return merge(r3, (LeafMerger) ZeusTransformUtils.wrapperContextForParams(r4, LeafMerger.class, "com.obric.memorydata.plugin"), null, false);
    }

    public void setAttribute(Object r1) {
        this.attribute = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public BSPTree<S> split(SubHyperplane<S> r7) {
        SubHyperplane<S> r8 = (SubHyperplane) ZeusTransformUtils.wrapperContextForParams(r7, SubHyperplane.class, "com.obric.memorydata.plugin");
        SubHyperplane<S> r0 = this.cut;
        if (r0 == null) goto L5;
        Hyperplane<S> r1 = r0.getHyperplane();
        Hyperplane<S> r2 = r8.getHyperplane();
        SubHyperplane.SplitSubHyperplane<S> r3 = r8.split(r1);
        int r4 = AnonymousClass2.$SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[r3.getSide().ordinal()];
        if (r4 != 1) goto L9;
        BSPTree<S> r9 = this.plus.split(r8);
        if (this.cut.split(r2).getSide() != Side.PLUS) goto L28;
        BSPTree<S> r5 = new BSPTree(this.cut.copySelf(), r9.plus, this.minus.copySelf(), this.attribute);
        r9.plus = r5;
        r5.condense();
        BSPTree<S> r6 = r9.plus;
    L29:
        r6.parent = r9;
        return r9;
    L28:
        BSPTree<S> r10 = new BSPTree(this.cut.copySelf(), r9.minus, this.minus.copySelf(), this.attribute);
        r9.minus = r10;
        r10.condense();
        r6 = r9.minus;
        goto L29
    L9:
        if (r4 != 2) goto L11;
        BSPTree<S> r11 = this.minus.split(r8);
        if (this.cut.split(r2).getSide() != Side.PLUS) goto L22;
        BSPTree<S> r12 = new BSPTree(this.cut.copySelf(), this.plus.copySelf(), r11.plus, this.attribute);
        r11.plus = r12;
        r12.condense();
        BSPTree<S> r13 = r11.plus;
    L23:
        r13.parent = r11;
        return r11;
    L22:
        BSPTree<S> r14 = new BSPTree(this.cut.copySelf(), this.plus.copySelf(), r11.minus, this.attribute);
        r11.minus = r14;
        r14.condense();
        r13 = r11.minus;
        goto L23
    L11:
        if (r4 != 3) goto L13;
        SubHyperplane.SplitSubHyperplane<S> r15 = this.cut.split(r2);
        BSPTree<S> r16 = new BSPTree(r8, this.plus.split(r3.getPlus()), this.minus.split(r3.getMinus()), null);
        BSPTree<S> r17 = r16.plus;
        r17.cut = (SubHyperplane<S>) r15.getPlus();
        BSPTree<S> r18 = r16.minus;
        r18.cut = (SubHyperplane<S>) r15.getMinus();
        BSPTree<S> r19 = r16.plus;
        BSPTree<S> r20 = r19.minus;
        BSPTree<S> r21 = r16.minus.plus;
        r19.minus = r21;
        r21.parent = r19;
        BSPTree<S> r22 = r16.minus;
        r22.plus = r20;
        r20.parent = r22;
        r16.plus.condense();
        r16.minus.condense();
        return r16;
    L13:
        if (r1.sameOrientationAs(r2) == false) goto L16;
        return new BSPTree(r8, this.plus.copySelf(), this.minus.copySelf(), this.attribute);
    L16:
        return new BSPTree(r8, this.minus.copySelf(), this.plus.copySelf(), this.attribute);
    L5:
        return new BSPTree(r8, copySelf(), new BSPTree(this.attribute), null);
    }

    public void visit(BSPTreeVisitor<S> r3) {
        BSPTreeVisitor<S> r4 = (BSPTreeVisitor) ZeusTransformUtils.wrapperContextForParams(r3, BSPTreeVisitor.class, "com.obric.memorydata.plugin");
        if (this.cut != null) goto L6;
        r4.visitLeafNode(this);
        return;
    L6:
        switch(AnonymousClass2.$SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[r4.visitOrder(this).ordinal()]) {
            case 1: goto L17;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        r4.visitInternalNode(this);
        this.minus.visit(r4);
    L12:
        BSPTree<S> r2 = this.plus;
    L16:
        r2.visit(r4);
        return;
    L10:
        r4.visitInternalNode(this);
        this.plus.visit(r4);
    L15:
        r2 = this.minus;
        goto L16
    L11:
        this.minus.visit(r4);
        r4.visitInternalNode(this);
        goto L12
    L13:
        this.minus.visit(r4);
        BSPTree<S> r0 = this.plus;
    L18:
        r0.visit(r4);
        r4.visitInternalNode(this);
        return;
    L14:
        this.plus.visit(r4);
        r4.visitInternalNode(this);
        goto L15
    L17:
        this.plus.visit(r4);
        r0 = this.minus;
        goto L18
    L8:
        throw new MathInternalError();
    }
}
