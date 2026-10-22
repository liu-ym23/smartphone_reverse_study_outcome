package com.google.common.base;

/* JADX INFO: loaded from: classes2.dex */
final enum Functions$ToStringFunction extends Enum<Functions$ToStringFunction> implements q {
    public static final Functions$ToStringFunction INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Functions$ToStringFunction[] f8642a = null;

    static {
        Functions$ToStringFunction r5 = new Functions$ToStringFunction("INSTANCE", 0);
        INSTANCE = r5;
        f8642a = new Functions$ToStringFunction[]{r5};
    }

    public static Functions$ToStringFunction valueOf(String r5) {
        return (Functions$ToStringFunction) Enum.valueOf(Functions$ToStringFunction.class, r5);
    }

    public static Functions$ToStringFunction[] values() {
        return (Functions$ToStringFunction[]) f8642a.clone();
    }

    @Override // java.util.function.Function
    public /* bridge */ /* synthetic */ Object apply(Object r5) {
        return apply(r5);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Functions.toStringFunction()";
    }

    @Override // java.util.function.Function
    public String apply(Object r5) {
        r5.getClass();
        return r5.toString();
    }
}
