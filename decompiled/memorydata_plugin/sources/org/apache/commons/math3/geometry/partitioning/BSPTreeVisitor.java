package org.apache.commons.math3.geometry.partitioning;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public interface BSPTreeVisitor<S extends Space> {

    public static final enum Order extends Enum<Order> {
        private static final /* synthetic */ Order[] $VALUES = null;
        public static final Order MINUS_PLUS_SUB = null;
        public static final Order MINUS_SUB_PLUS = null;
        public static final Order PLUS_MINUS_SUB = null;
        public static final Order PLUS_SUB_MINUS = null;
        public static final Order SUB_MINUS_PLUS = null;
        public static final Order SUB_PLUS_MINUS = null;

        static {
            Order r0 = new Order("PLUS_MINUS_SUB", 0);
            PLUS_MINUS_SUB = r0;
            Order r1 = new Order("PLUS_SUB_MINUS", 1);
            PLUS_SUB_MINUS = r1;
            Order r3 = new Order("MINUS_PLUS_SUB", 2);
            MINUS_PLUS_SUB = r3;
            Order r5 = new Order("MINUS_SUB_PLUS", 3);
            MINUS_SUB_PLUS = r5;
            Order r7 = new Order("SUB_PLUS_MINUS", 4);
            SUB_PLUS_MINUS = r7;
            Order r9 = new Order("SUB_MINUS_PLUS", 5);
            SUB_MINUS_PLUS = r9;
            $VALUES = new Order[]{r0, r1, r3, r5, r7, r9};
        }

        private Order(String r1, int r2) {
            super(r1, r2);
        }

        public static Order valueOf(String r2) {
            return (Order) ZeusTransformUtils.preCheckCast(Enum.valueOf(Order.class, r2), Order.class, "com.obric.memorydata.plugin");
        }

        public static Order[] values() {
            return (Order[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Order[].class, "com.obric.memorydata.plugin");
        }
    }

    void visitInternalNode(BSPTree<S> r1);

    void visitLeafNode(BSPTree<S> r1);

    Order visitOrder(BSPTree<S> r1);
}
