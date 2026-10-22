package com.google.common.graph;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Traverser<N> {

    /* JADX INFO: renamed from: com.google.common.graph.Traverser$1, reason: invalid class name */
    class AnonymousClass1 extends Traverser<N> {
    }

    private static abstract enum InsertionOrder extends Enum<InsertionOrder> {
        private static final /* synthetic */ InsertionOrder[] $VALUES = null;
        public static final InsertionOrder BACK = null;
        public static final InsertionOrder FRONT = null;

        private static /* synthetic */ InsertionOrder[] $values() {
            return new InsertionOrder[]{FRONT, BACK};
        }

        static {
            final String r1 = "FRONT";
            final int r2 = 0;
            FRONT = new AnonymousClass1(r1, r2);
            final String r3 = "BACK";
            final int r4 = 1;
            BACK = new AnonymousClass2(r3, r4);
            $VALUES = $values();
        }

        private InsertionOrder(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ InsertionOrder(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static InsertionOrder valueOf(String r2) {
            return (InsertionOrder) ZeusTransformUtils.preCheckCast(Enum.valueOf(InsertionOrder.class, r2), InsertionOrder.class, "com.obric.memorydata.plugin");
        }

        public static InsertionOrder[] values() {
            return (InsertionOrder[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), InsertionOrder[].class, "com.obric.memorydata.plugin");
        }

        abstract <T> void insertInto(Deque<T> r1, T r2);
    }
}
