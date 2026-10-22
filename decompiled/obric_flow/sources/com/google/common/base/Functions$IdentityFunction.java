package com.google.common.base;

/* JADX INFO: loaded from: classes2.dex */
final enum Functions$IdentityFunction extends Enum<Functions$IdentityFunction> implements q {
    public static final Functions$IdentityFunction INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Functions$IdentityFunction[] f8641a = null;

    static {
        Functions$IdentityFunction r5 = new Functions$IdentityFunction("INSTANCE", 0);
        INSTANCE = r5;
        f8641a = new Functions$IdentityFunction[]{r5};
    }

    public static Functions$IdentityFunction valueOf(String r5) {
        return (Functions$IdentityFunction) Enum.valueOf(Functions$IdentityFunction.class, r5);
    }

    public static Functions$IdentityFunction[] values() {
        return (Functions$IdentityFunction[]) f8641a.clone();
    }

    @Override // java.util.function.Function
    public Object apply(Object r5) {
        return r5;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Functions.identity()";
    }
}
