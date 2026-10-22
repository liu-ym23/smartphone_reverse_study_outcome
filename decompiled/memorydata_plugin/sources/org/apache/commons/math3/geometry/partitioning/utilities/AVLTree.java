package org.apache.commons.math3.geometry.partitioning.utilities;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class AVLTree<T extends Comparable<T>> {
    private AVLTree<T>.Node top;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.partitioning.utilities.AVLTree$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$utilities$AVLTree$Skew = null;

        static {
            int[] r0 = new int[Skew.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$utilities$AVLTree$Skew = r0;
            r0[Skew.LEFT_HIGH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$utilities$AVLTree$Skew[Skew.RIGHT_HIGH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class Node {
        private T element;
        private AVLTree<T>.Node left;
        private AVLTree<T>.Node parent;
        private AVLTree<T>.Node right;
        private Skew skew;
        final /* synthetic */ AVLTree this$0;

        Node(AVLTree r3, T r4, AVLTree<T>.Node r5) {
            T r6 = (T) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.element = r6;
            this.left = null;
            this.right = null;
            this.parent = r5;
            this.skew = Skew.BALANCED;
        }

        static /* synthetic */ Comparable access$000(Node r0) {
            return r0.element;
        }

        static /* synthetic */ Node access$100(Node r0) {
            return r0.right;
        }

        static /* synthetic */ Node access$200(Node r0) {
            return r0.left;
        }

        private boolean rebalanceLeftGrown() {
            int r0 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$utilities$AVLTree$Skew[this.skew.ordinal()];
            if (r0 == 1) goto L10;
            if (r0 == 2) goto L7;
            this.skew = Skew.LEFT_HIGH;
            return true;
        L7:
            this.skew = Skew.BALANCED;
            return false;
        L10:
            if (this.left.skew != Skew.LEFT_HIGH) goto L13;
            rotateCW();
            this.skew = Skew.BALANCED;
            Node this = this.right;
        L12:
            this.skew = Skew.BALANCED;
            return false;
        L13:
            AVLTree<T>.Node r1 = this.left;
            Skew r4 = r1.right.skew;
            r1.rotateCCW();
            rotateCW();
            int r2 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$utilities$AVLTree$Skew[r4.ordinal()];
            if (r2 == 1) goto L19;
            if (r2 == 2) goto L17;
            AVLTree<T>.Node r3 = this.left;
            Skew r5 = Skew.BALANCED;
        L18:
            r3.skew = r5;
            AVLTree<T>.Node r6 = this.right;
            Skew r7 = Skew.BALANCED;
        L20:
            r6.skew = r7;
            goto L12
        L17:
            r3 = this.left;
            r5 = Skew.LEFT_HIGH;
            goto L18
        L19:
            AVLTree<T>.Node r8 = this.left;
            r8.skew = Skew.BALANCED;
            r6 = this.right;
            r7 = Skew.RIGHT_HIGH;
            goto L20
        }

        private boolean rebalanceLeftShrunk() {
            int r0 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$utilities$AVLTree$Skew[this.skew.ordinal()];
            if (r0 != 1) goto L5;
        L11:
            this.skew = Skew.BALANCED;
            return true;
        L5:
            if (r0 == 2) goto L9;
        L6:
            this.skew = Skew.RIGHT_HIGH;
            return false;
        L9:
            if (this.right.skew != Skew.RIGHT_HIGH) goto L14;
            rotateCCW();
            this.skew = Skew.BALANCED;
            Node this = this.left;
            goto L11
        L14:
            if (this.right.skew != Skew.BALANCED) goto L16;
            rotateCCW();
            this.skew = Skew.LEFT_HIGH;
            this = this.left;
            goto L6
        L16:
            AVLTree<T>.Node r1 = this.right;
            Skew r2 = r1.left.skew;
            r1.rotateCW();
            rotateCCW();
            int r3 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$utilities$AVLTree$Skew[r2.ordinal()];
            if (r3 == 1) goto L22;
            if (r3 == 2) goto L20;
            AVLTree<T>.Node r4 = this.left;
            Skew r5 = Skew.BALANCED;
        L21:
            r4.skew = r5;
            AVLTree<T>.Node r6 = this.right;
            Skew r7 = Skew.BALANCED;
        L23:
            r6.skew = r7;
            goto L11
        L20:
            r4 = this.left;
            r5 = Skew.LEFT_HIGH;
            goto L21
        L22:
            AVLTree<T>.Node r8 = this.left;
            r8.skew = Skew.BALANCED;
            r6 = this.right;
            r7 = Skew.RIGHT_HIGH;
            goto L23
        }

        private boolean rebalanceRightGrown() {
            int r0 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$utilities$AVLTree$Skew[this.skew.ordinal()];
            if (r0 != 1) goto L5;
            this.skew = Skew.BALANCED;
            return false;
        L5:
            if (r0 == 2) goto L9;
            this.skew = Skew.RIGHT_HIGH;
            return true;
        L9:
            if (this.right.skew != Skew.RIGHT_HIGH) goto L12;
            rotateCCW();
            this.skew = Skew.BALANCED;
            Node this = this.left;
        L11:
            this.skew = Skew.BALANCED;
            return false;
        L12:
            AVLTree<T>.Node r1 = this.right;
            Skew r4 = r1.left.skew;
            r1.rotateCW();
            rotateCCW();
            int r2 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$utilities$AVLTree$Skew[r4.ordinal()];
            if (r2 == 1) goto L18;
            if (r2 == 2) goto L16;
            AVLTree<T>.Node r3 = this.left;
            Skew r5 = Skew.BALANCED;
        L17:
            r3.skew = r5;
            AVLTree<T>.Node r6 = this.right;
            Skew r7 = Skew.BALANCED;
        L19:
            r6.skew = r7;
            goto L11
        L16:
            r3 = this.left;
            r5 = Skew.LEFT_HIGH;
            goto L17
        L18:
            AVLTree<T>.Node r8 = this.left;
            r8.skew = Skew.BALANCED;
            r6 = this.right;
            r7 = Skew.RIGHT_HIGH;
            goto L19
        }

        private boolean rebalanceRightShrunk() {
            int r0 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$utilities$AVLTree$Skew[this.skew.ordinal()];
            if (r0 == 1) goto L10;
            if (r0 == 2) goto L7;
        L5:
            this.skew = Skew.LEFT_HIGH;
            return false;
        L7:
            this.skew = Skew.BALANCED;
            return true;
        L10:
            if (this.left.skew != Skew.LEFT_HIGH) goto L13;
            rotateCW();
            this.skew = Skew.BALANCED;
            Node this = this.right;
            goto L7
        L13:
            if (this.left.skew != Skew.BALANCED) goto L15;
            rotateCW();
            this.skew = Skew.RIGHT_HIGH;
            this = this.right;
            goto L5
        L15:
            AVLTree<T>.Node r1 = this.left;
            Skew r2 = r1.right.skew;
            r1.rotateCCW();
            rotateCW();
            int r3 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$utilities$AVLTree$Skew[r2.ordinal()];
            if (r3 == 1) goto L21;
            if (r3 == 2) goto L19;
            AVLTree<T>.Node r4 = this.left;
            Skew r5 = Skew.BALANCED;
        L20:
            r4.skew = r5;
            AVLTree<T>.Node r6 = this.right;
            Skew r7 = Skew.BALANCED;
        L22:
            r6.skew = r7;
            goto L7
        L19:
            r4 = this.left;
            r5 = Skew.LEFT_HIGH;
            goto L20
        L21:
            AVLTree<T>.Node r8 = this.left;
            r8.skew = Skew.BALANCED;
            r6 = this.right;
            r7 = Skew.RIGHT_HIGH;
            goto L22
        }

        private void rotateCCW() {
            T r0 = this.element;
            AVLTree<T>.Node r1 = this.right;
            this.element = r1.element;
            r1.element = r0;
            this.right = r1.right;
            r1.right = r1.left;
            r1.left = this.left;
            this.left = r1;
            AVLTree<T>.Node r2 = this.right;
            if (r2 == null) goto L5;
            r2.parent = this;
        L5:
            AVLTree<T>.Node r3 = r1.left;
            if (r3 == null) goto L9;
            r3.parent = r1;
            return;
        }

        private void rotateCW() {
            T r0 = this.element;
            AVLTree<T>.Node r1 = this.left;
            this.element = r1.element;
            r1.element = r0;
            this.left = r1.left;
            r1.left = r1.right;
            r1.right = this.right;
            this.right = r1;
            AVLTree<T>.Node r2 = this.left;
            if (r2 == null) goto L5;
            r2.parent = this;
        L5:
            AVLTree<T>.Node r3 = r1.right;
            if (r3 == null) goto L9;
            r3.parent = r1;
            return;
        }

        public void delete() {
            AVLTree<T>.Node r0 = this.parent;
            AVLTree<T>.Node r1 = null;
            if (r0 == null) goto L5;
        L9:
            AVLTree<T>.Node r2 = this.left;
            if (r2 == null) goto L12;
        L17:
            if (r2 == null) goto L19;
            AVLTree<T>.Node r3 = r2.getLargest();
        L20:
            this.element = r3.element;
            if (r3 != r3.parent.left) goto L23;
            boolean r7 = true;
        L24:
            r1 = r3.left;
            if (r1 != null) goto L28;
            r1 = r3.right;
        L28:
            AVLTree<T>.Node r6 = r3;
            boolean r4 = r7;
            Node this = r6;
        L29:
            AVLTree<T>.Node r8 = this.parent;
            if (r4 == false) goto L32;
            r8.left = r1;
        L33:
            if (r1 == null) goto L35;
            r1.parent = r8;
        L35:
            if (r4 == false) goto L40;
            if (r8.rebalanceLeftShrunk() == false) goto L56;
        L41:
            AVLTree<T>.Node r5 = r8.parent;
            if (r5 == null) goto L43;
            if (r8 != r5.left) goto L47;
            boolean r9 = true;
        L48:
            r4 = r9;
            r8 = r5;
            goto L35
        L47:
            r9 = false;
            goto L48
        L43:
            return;
        L56:
            return;
        L40:
            if (r8.rebalanceRightShrunk() == true) goto L41;
            return;
        L32:
            r8.right = r1;
            goto L33
        L23:
            r7 = false;
            goto L24
        L19:
            r3 = this.right.getSmallest();
            goto L20
        L12:
            if (this.right != null) goto L17;
            this.element = null;
            if (this != r0.left) goto L16;
            r4 = true;
            goto L29
        L16:
            r4 = false;
            goto L29
        L5:
            if (this.left != null) goto L9;
            if (this.right != null) goto L9;
            this.element = null;
            AVLTree.access$302(this.this$0, null);
        }

        AVLTree<T>.Node getLargest() {
        L2:
            AVLTree<T>.Node r0 = this.right;
            if (r0 == null) goto L5;
            Node this = r0;
            goto L2
        L5:
            return this;
        }

        public AVLTree<T>.Node getNext() {
            AVLTree<T>.Node r0 = this.right;
            if (r0 == null) goto L7;
            AVLTree<T>.Node r1 = r0.getSmallest();
            if (r1 == null) goto L7;
            return r1;
        L7:
            AVLTree<T>.Node r2 = this.parent;
            if (r2 == null) goto L13;
            if (this != r2.right) goto L11;
            Node this = r2;
            goto L7
        L11:
            return r2;
        L13:
            return null;
        }

        AVLTree<T>.Node getSmallest() {
        L2:
            AVLTree<T>.Node r0 = this.left;
            if (r0 == null) goto L5;
            Node this = r0;
            goto L2
        L5:
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean insert(T r3) {
            Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            if (r4.compareTo(this.element) >= 0) goto L12;
            AVLTree<T>.Node r0 = this.left;
            if (r0 != 0) goto L9;
            this.left = new Node(this.this$0, r4, this);
            return rebalanceLeftGrown();
        L9:
            if (r0.insert(r4) == true) goto L11;
            return false;
        L11:
            return rebalanceLeftGrown();
        L12:
            AVLTree<T>.Node r1 = this.right;
            if (r1 != 0) goto L17;
            this.right = new Node(this.this$0, r4, this);
            return rebalanceRightGrown();
        L17:
            if (r1.insert(r4) == true) goto L19;
            return false;
        L19:
            return rebalanceRightGrown();
        }
    }

    private static final enum Skew extends Enum<Skew> {
        private static final /* synthetic */ Skew[] $VALUES = null;
        public static final Skew BALANCED = null;
        public static final Skew LEFT_HIGH = null;
        public static final Skew RIGHT_HIGH = null;

        static {
            Skew r0 = new Skew("LEFT_HIGH", 0);
            LEFT_HIGH = r0;
            Skew r1 = new Skew("RIGHT_HIGH", 1);
            RIGHT_HIGH = r1;
            Skew r3 = new Skew("BALANCED", 2);
            BALANCED = r3;
            $VALUES = new Skew[]{r0, r1, r3};
        }

        private Skew(String r1, int r2) {
            super(r1, r2);
        }

        public static Skew valueOf(String r2) {
            return (Skew) ZeusTransformUtils.preCheckCast(Enum.valueOf(Skew.class, r2), Skew.class, "com.obric.memorydata.plugin");
        }

        public static Skew[] values() {
            return (Skew[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Skew[].class, "com.obric.memorydata.plugin");
        }
    }

    static /* synthetic */ Node access$302(AVLTree r0, Node r1) {
        r0.top = r1;
        return r1;
    }

    public boolean delete(T r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L14;
        AVLTree<T>.Node r2 = getNotSmaller(r4);
    L5:
        if (r2 == null) goto L14;
        if (Node.access$000(r2) == r4) goto L8;
        if (Node.access$000(r2).compareTo(r4) > 0) goto L12;
        r2 = r2.getNext();
        goto L5
    L12:
        return false;
    L8:
        r2.delete();
        return true;
    L14:
        return false;
    }

    public AVLTree<T>.Node getNotSmaller(T r5) {
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        AVLTree<T>.Node r4 = this.top;
        AVLTree<T>.Node r1 = null;
    L3:
        if (r4 == null) goto L14;
        if (Node.access$000(r4).compareTo(r6) < 0) goto L7;
        if (Node.access$200(r4) == null) goto L12;
        r1 = r4;
        r4 = Node.access$200(r4);
        goto L3
    L12:
        return r4;
    L7:
        if (Node.access$100(r4) == null) goto L8;
        r4 = Node.access$100(r4);
        goto L3
    L8:
        return r1;
    L14:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void insert(T r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L9;
        AVLTree<T>.Node r0 = this.top;
        if (r0 != 0) goto L7;
        this.top = new Node(this, r4, null);
        return;
    L7:
        r0.insert(r4);
        return;
    }
}
