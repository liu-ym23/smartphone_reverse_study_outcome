package com.google.common.hash;

/* JADX INFO: loaded from: classes2.dex */
final enum Funnels$IntegerFunnel extends Enum<Funnels$IntegerFunnel> implements Funnel<Integer> {
    public static final Funnels$IntegerFunnel INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Funnels$IntegerFunnel[] f9257a = null;

    static {
        Funnels$IntegerFunnel r5 = new Funnels$IntegerFunnel("INSTANCE", 0);
        INSTANCE = r5;
        f9257a = new Funnels$IntegerFunnel[]{r5};
    }

    public static Funnels$IntegerFunnel valueOf(String r5) {
        return (Funnels$IntegerFunnel) Enum.valueOf(Funnels$IntegerFunnel.class, r5);
    }

    public static Funnels$IntegerFunnel[] values() {
        return (Funnels$IntegerFunnel[]) f9257a.clone();
    }

    @Override // com.google.common.hash.Funnel
    public /* bridge */ /* synthetic */ void funnel(Integer r5, z r10) {
        funnel2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Funnels.integerFunnel()";
    }

    /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
    public void funnel2(Integer r5, z r10) {
        r10.putInt(r5.intValue());
    }
}
