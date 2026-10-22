package com.google.common.hash;

/* JADX INFO: loaded from: classes2.dex */
final enum Funnels$ByteArrayFunnel extends Enum<Funnels$ByteArrayFunnel> implements Funnel<byte[]> {
    public static final Funnels$ByteArrayFunnel INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Funnels$ByteArrayFunnel[] f9256a = null;

    static {
        Funnels$ByteArrayFunnel r5 = new Funnels$ByteArrayFunnel("INSTANCE", 0);
        INSTANCE = r5;
        f9256a = new Funnels$ByteArrayFunnel[]{r5};
    }

    public static Funnels$ByteArrayFunnel valueOf(String r5) {
        return (Funnels$ByteArrayFunnel) Enum.valueOf(Funnels$ByteArrayFunnel.class, r5);
    }

    public static Funnels$ByteArrayFunnel[] values() {
        return (Funnels$ByteArrayFunnel[]) f9256a.clone();
    }

    @Override // com.google.common.hash.Funnel
    public /* bridge */ /* synthetic */ void funnel(byte[] r5, z r10) {
        funnel2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Funnels.byteArrayFunnel()";
    }

    /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
    public void funnel2(byte[] r5, z r10) {
        r10.a(r5);
    }
}
