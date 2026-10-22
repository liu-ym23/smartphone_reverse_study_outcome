package com.google.common.hash;

/* JADX INFO: loaded from: classes2.dex */
final enum Funnels$LongFunnel extends Enum<Funnels$LongFunnel> implements Funnel<Long> {
    public static final Funnels$LongFunnel INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Funnels$LongFunnel[] f9258a = null;

    static {
        Funnels$LongFunnel r5 = new Funnels$LongFunnel("INSTANCE", 0);
        INSTANCE = r5;
        f9258a = new Funnels$LongFunnel[]{r5};
    }

    public static Funnels$LongFunnel valueOf(String r5) {
        return (Funnels$LongFunnel) Enum.valueOf(Funnels$LongFunnel.class, r5);
    }

    public static Funnels$LongFunnel[] values() {
        return (Funnels$LongFunnel[]) f9258a.clone();
    }

    @Override // com.google.common.hash.Funnel
    public /* bridge */ /* synthetic */ void funnel(Long r5, z r10) {
        funnel2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Funnels.longFunnel()";
    }

    /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
    public void funnel2(Long r5, z r10) {
        r10.putLong(r5.longValue());
    }
}
