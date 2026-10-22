package org.apache.commons.math3.geometry.partitioning;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
class Characterization<S extends Space> {
    private final NodesSet<S> insideSplitters;
    private SubHyperplane<S> insideTouching;
    private final NodesSet<S> outsideSplitters;
    private SubHyperplane<S> outsideTouching;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.partitioning.Characterization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = null;

        static {
            int[] r0 = new int[Side.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = r0;
            r0[Side.PLUS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.MINUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.BOTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    Characterization(BSPTree<S> r3, SubHyperplane<S> r4) {
        SubHyperplane<S> r5 = (SubHyperplane) ZeusTransformUtils.wrapperContextForParams(r4, SubHyperplane.class, "com.obric.memorydata.plugin");
        this.outsideTouching = null;
        this.insideTouching = null;
        this.outsideSplitters = new NodesSet();
        this.insideSplitters = new NodesSet();
        characterize(r3, r5, new ArrayList());
    }

    private void addInsideTouching(SubHyperplane<S> r3, List<BSPTree<S>> r4) {
        SubHyperplane<S> r5 = (SubHyperplane) ZeusTransformUtils.wrapperContextForParams(r3, SubHyperplane.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        SubHyperplane<S> r0 = this.insideTouching;
        if (r0 == null) goto L6;
        r5 = r0.reunite(r5);
    L6:
        this.insideTouching = r5;
        this.insideSplitters.addAll(r6);
    }

    private void addOutsideTouching(SubHyperplane<S> r3, List<BSPTree<S>> r4) {
        SubHyperplane<S> r5 = (SubHyperplane) ZeusTransformUtils.wrapperContextForParams(r3, SubHyperplane.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        SubHyperplane<S> r0 = this.outsideTouching;
        if (r0 == null) goto L6;
        r5 = r0.reunite(r5);
    L6:
        this.outsideTouching = r5;
        this.outsideSplitters.addAll(r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void characterize(BSPTree<S> r5, SubHyperplane<S> r6, List<BSPTree<S>> r7) {
        SubHyperplane r8 = (SubHyperplane) ZeusTransformUtils.wrapperContextForParams(r6, SubHyperplane.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (r5.getCut() == null) goto L5;
        SubHyperplane.SplitSubHyperplane<S> r0 = r8.split(r5.getCut().getHyperplane());
        int r1 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[r0.getSide().ordinal()];
        if (r1 != 1) goto L11;
        BSPTree<S> r10 = r5.getPlus();
    L19:
        characterize(r10, r8, r9);
        return;
    L11:
        if (r1 != 2) goto L13;
        r10 = r5.getMinus();
        goto L19
    L13:
        if (r1 != 3) goto L16;
        r9.add(r5);
        characterize(r5.getPlus(), r0.getPlus(), r9);
        characterize(r5.getMinus(), r0.getMinus(), r9);
        r9.remove(r9.size() - 1);
        return;
    L16:
        throw new MathInternalError();
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5.getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        addInsideTouching(r8, r9);
        return;
    L7:
        addOutsideTouching(r8, r9);
    }

    public NodesSet<S> getInsideSplitters() {
        return this.insideSplitters;
    }

    public NodesSet<S> getOutsideSplitters() {
        return this.outsideSplitters;
    }

    public SubHyperplane<S> insideTouching() {
        return this.insideTouching;
    }

    public SubHyperplane<S> outsideTouching() {
        return this.outsideTouching;
    }

    public boolean touchInside() {
        SubHyperplane<S> r0 = this.insideTouching;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return true;
    }

    public boolean touchOutside() {
        SubHyperplane<S> r0 = this.outsideTouching;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return true;
    }
}
