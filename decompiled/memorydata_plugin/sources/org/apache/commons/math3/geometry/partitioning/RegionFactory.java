package org.apache.commons.math3.geometry.partitioning;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public class RegionFactory<S extends Space> {
    private final RegionFactory<S>.NodesCleaner nodeCleaner;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.partitioning.RegionFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = null;

        static {
            int[] r0 = new int[Side.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = r0;
            r0[Side.HYPER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.PLUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private class NodesCleaner implements BSPTreeVisitor<S> {
        final /* synthetic */ RegionFactory this$0;

        private NodesCleaner(RegionFactory r1) {
            this.this$0 = r1;
        }

        /* synthetic */ NodesCleaner(RegionFactory r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public void visitInternalNode(BSPTree<S> r1) {
            r1.setAttribute(null);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public void visitLeafNode(BSPTree<S> r1) {
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public BSPTreeVisitor.Order visitOrder(BSPTree<S> r1) {
            return BSPTreeVisitor.Order.PLUS_SUB_MINUS;
        }
    }

    private class UnionMerger implements BSPTree.LeafMerger<S> {
        final /* synthetic */ RegionFactory this$0;

        private UnionMerger(RegionFactory r1) {
            this.this$0 = r1;
        }

        /* synthetic */ UnionMerger(RegionFactory r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTree.LeafMerger
        public BSPTree<S> merge(BSPTree<S> r3, BSPTree<S> r4, BSPTree<S> r5, boolean r6, boolean r7) {
            if (((Boolean) ZeusTransformUtils.preCheckCast(r3.getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
            r3.insertInTree(r5, r6, new VanishingToLeaf(this.this$0, true));
            return r3;
        L6:
            r4.insertInTree(r5, r6, new VanishingToLeaf(this.this$0, false));
            return r4;
        }
    }

    private class VanishingToLeaf implements BSPTree.VanishingCutHandler<S> {
        private final boolean inside;
        final /* synthetic */ RegionFactory this$0;

        VanishingToLeaf(RegionFactory r1, boolean r2) {
            this.this$0 = r1;
            this.inside = r2;
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTree.VanishingCutHandler
        public BSPTree<S> fixNode(BSPTree<S> r3) {
            if (r3.getPlus().getAttribute().equals(r3.getMinus().getAttribute()) == false) goto L7;
            return new BSPTree(r3.getPlus().getAttribute());
        L7:
            return new BSPTree(Boolean.valueOf(this.inside));
        }
    }

    public RegionFactory() {
        this.nodeCleaner = new NodesCleaner(this, null);
    }

    private BSPTree<S> recurseComplement(BSPTree<S> r8) {
        HashMap r0 = new HashMap();
        BSPTree<S> r7 = recurseComplement(r8, r0);
        Iterator<Map.Entry<BSPTree<S>, BSPTree<S>>> r9 = r0.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((BSPTree) ZeusTransformUtils.preCheckCast(r1.getKey(), BSPTree.class, "com.obric.memorydata.plugin")).getCut() == null) goto L4;
        BoundaryAttribute r2 = (BoundaryAttribute) ZeusTransformUtils.preCheckCast(((BSPTree) ZeusTransformUtils.preCheckCast(r1.getKey(), BSPTree.class, "com.obric.memorydata.plugin")).getAttribute(), BoundaryAttribute.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        BoundaryAttribute r3 = (BoundaryAttribute) ZeusTransformUtils.preCheckCast(((BSPTree) ZeusTransformUtils.preCheckCast(r1.getValue(), BSPTree.class, "com.obric.memorydata.plugin")).getAttribute(), BoundaryAttribute.class, "com.obric.memorydata.plugin");
        Iterator<BSPTree<S>> r4 = r2.getSplitters().iterator();
    L11:
        if (r4.hasNext() == false) goto L4;
        BSPTree r5 = (BSPTree) ZeusTransformUtils.preCheckCast(r4.next(), BSPTree.class, "com.obric.memorydata.plugin");
        r3.getSplitters().add((BSPTree) ZeusTransformUtils.preCheckCast(r0.get(r5), BSPTree.class, "com.obric.memorydata.plugin"));
        goto L11
    L13:
        return r7;
    }

    private BSPTree<S> recurseComplement(BSPTree<S> r6, Map<BSPTree<S>, BSPTree<S>> r7) {
        Map<BSPTree<S>, BSPTree<S>> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r6.getCut() == null) goto L5;
        BoundaryAttribute r0 = (BoundaryAttribute) ZeusTransformUtils.preCheckCast(r6.getAttribute(), BoundaryAttribute.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L20;
        SubHyperplane<S> r2 = null;
        if (r0.getPlusInside() != null) goto L14;
        SubHyperplane<S> r1 = null;
    L16:
        if (r0.getPlusOutside() == null) goto L19;
        r2 = r0.getPlusOutside().copySelf();
    L19:
        r0 = new BoundaryAttribute(r1, r2, new NodesSet());
        goto L20
    L14:
        r1 = r0.getPlusInside().copySelf();
    L20:
        BSPTree<S> r5 = new BSPTree(r6.getCut().copySelf(), recurseComplement(r6.getPlus(), r8), recurseComplement(r6.getMinus(), r8), r0);
    L21:
        r8.put(r6, r5);
        return r5;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6.getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        Boolean r3 = Boolean.FALSE;
    L8:
        r5 = new BSPTree(r3);
        goto L21
    L7:
        r3 = Boolean.TRUE;
        goto L8
    }

    public Region<S> buildConvex(Hyperplane<S>... r14) {
        if (r14 != null) goto L5;
    L30:
        return null;
    L5:
        if (r14.length == 0) goto L30;
        Region<S> r2 = r14[0].wholeSpace();
        BSPTree<S> r3 = r2.getTree(false);
        r3.setAttribute(Boolean.TRUE);
        int r4 = r14.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L29;
        Hyperplane<S> r6 = r14[r5];
        if (r3.insertCut(r6) == false) goto L12;
        r3.setAttribute(null);
        r3.getPlus().setAttribute(Boolean.FALSE);
        r3 = r3.getMinus();
        r3.setAttribute(Boolean.TRUE);
    L28:
        r5 = r5 + 1;
        goto L8
    L12:
        SubHyperplane r7 = r6.wholeHyperplane();
        BSPTree<S> r8 = r3;
    L14:
        if (r8.getParent() == null) goto L28;
        if (r7 == null) goto L28;
        Hyperplane<S> r9 = r8.getParent().getCut().getHyperplane();
        SubHyperplane.SplitSubHyperplane<S> r10 = r7.split(r9);
        int r11 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[r10.getSide().ordinal()];
        if (r11 == 1) goto L24;
        if (r11 == 2) goto L22;
        r7 = r10.getMinus();
    L27:
        r8 = r8.getParent();
        goto L14
    L22:
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_CONVEX_HYPERPLANES, new Object[0]);
    L24:
        if (r6.sameOrientationAs(r9) == true) goto L27;
        return getComplement(r14[0].wholeSpace());
    L29:
        return r2;
    }

    public Region<S> getComplement(Region<S> r3) {
        Region r4 = (Region) ZeusTransformUtils.wrapperContextForParams(r3, Region.class, "com.obric.memorydata.plugin");
        return r4.buildNew(recurseComplement(r4.getTree(false)));
    }

    public Region<S> union(Region<S> r4, Region<S> r5) {
        Region r6 = (Region) ZeusTransformUtils.wrapperContextForParams(r4, Region.class, "com.obric.memorydata.plugin");
        Region r7 = (Region) ZeusTransformUtils.wrapperContextForParams(r5, Region.class, "com.obric.memorydata.plugin");
        BSPTree<S> r8 = r6.getTree(false).merge(r7.getTree(false), new UnionMerger(this, null));
        r8.visit(this.nodeCleaner);
        return r6.buildNew(r8);
    }
}
