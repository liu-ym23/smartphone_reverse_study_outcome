package com.google.common.collect;

import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final enum MultimapBuilder$LinkedListSupplier extends Enum<MultimapBuilder$LinkedListSupplier> implements com.google.common.base.e0 {
    public static final MultimapBuilder$LinkedListSupplier INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultimapBuilder$LinkedListSupplier[] f8852a = null;

    static {
        MultimapBuilder$LinkedListSupplier r5 = new MultimapBuilder$LinkedListSupplier("INSTANCE", 0);
        INSTANCE = r5;
        f8852a = new MultimapBuilder$LinkedListSupplier[]{r5};
    }

    public static <V> com.google.common.base.e0 instance() {
        return INSTANCE;
    }

    public static MultimapBuilder$LinkedListSupplier valueOf(String r5) {
        return (MultimapBuilder$LinkedListSupplier) Enum.valueOf(MultimapBuilder$LinkedListSupplier.class, r5);
    }

    public static MultimapBuilder$LinkedListSupplier[] values() {
        return (MultimapBuilder$LinkedListSupplier[]) f8852a.clone();
    }

    @Override // java.util.function.Supplier
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    @Override // java.util.function.Supplier
    public List<?> get() {
        return new LinkedList();
    }
}
