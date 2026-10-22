package com.google.common.base;

/* JADX INFO: loaded from: classes2.dex */
final enum Suppliers$SupplierFunctionImpl extends Enum<Suppliers$SupplierFunctionImpl> implements q {
    public static final Suppliers$SupplierFunctionImpl INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Suppliers$SupplierFunctionImpl[] f8646a = null;

    static {
        Suppliers$SupplierFunctionImpl r5 = new Suppliers$SupplierFunctionImpl("INSTANCE", 0);
        INSTANCE = r5;
        f8646a = new Suppliers$SupplierFunctionImpl[]{r5};
    }

    public static Suppliers$SupplierFunctionImpl valueOf(String r5) {
        return (Suppliers$SupplierFunctionImpl) Enum.valueOf(Suppliers$SupplierFunctionImpl.class, r5);
    }

    public static Suppliers$SupplierFunctionImpl[] values() {
        return (Suppliers$SupplierFunctionImpl[]) f8646a.clone();
    }

    @Override // java.util.function.Function
    public /* bridge */ /* synthetic */ Object apply(Object r5) {
        return apply((e0) r5);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Suppliers.supplierFunction()";
    }

    public Object apply(e0 r5) {
        return r5.get();
    }
}
