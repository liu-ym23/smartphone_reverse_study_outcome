package com.google.common.graph;

import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
abstract enum Traverser$InsertionOrder extends Enum<Traverser$InsertionOrder> {
    public static final Traverser$InsertionOrder BACK = null;
    public static final Traverser$InsertionOrder FRONT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Traverser$InsertionOrder[] f9254a = null;

    static {
        final String r5 = "FRONT";
        final int r10 = 0;
        Traverser$InsertionOrder r11 = new AnonymousClass1(r5, r10);
        FRONT = r11;
        final String r12 = "BACK";
        final int r13 = 1;
        Traverser$InsertionOrder r14 = new AnonymousClass2(r12, r13);
        BACK = r14;
        f9254a = new Traverser$InsertionOrder[]{r11, r14};
    }

    public Traverser$InsertionOrder(String r5, int r10, a r11) {
        super(r5, r10);
    }

    public static Traverser$InsertionOrder valueOf(String r5) {
        return (Traverser$InsertionOrder) Enum.valueOf(Traverser$InsertionOrder.class, r5);
    }

    public static Traverser$InsertionOrder[] values() {
        return (Traverser$InsertionOrder[]) f9254a.clone();
    }

    public abstract <T> void insertInto(Deque<T> r5, T r10);
}
