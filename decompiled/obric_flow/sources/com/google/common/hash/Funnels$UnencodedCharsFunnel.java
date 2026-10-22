package com.google.common.hash;

/* JADX INFO: loaded from: classes2.dex */
final enum Funnels$UnencodedCharsFunnel extends Enum<Funnels$UnencodedCharsFunnel> implements Funnel<CharSequence> {
    public static final Funnels$UnencodedCharsFunnel INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Funnels$UnencodedCharsFunnel[] f9259a = null;

    static {
        Funnels$UnencodedCharsFunnel r5 = new Funnels$UnencodedCharsFunnel("INSTANCE", 0);
        INSTANCE = r5;
        f9259a = new Funnels$UnencodedCharsFunnel[]{r5};
    }

    public static Funnels$UnencodedCharsFunnel valueOf(String r5) {
        return (Funnels$UnencodedCharsFunnel) Enum.valueOf(Funnels$UnencodedCharsFunnel.class, r5);
    }

    public static Funnels$UnencodedCharsFunnel[] values() {
        return (Funnels$UnencodedCharsFunnel[]) f9259a.clone();
    }

    @Override // com.google.common.hash.Funnel
    public /* bridge */ /* synthetic */ void funnel(CharSequence r5, z r10) {
        funnel2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Funnels.unencodedCharsFunnel()";
    }

    /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
    public void funnel2(CharSequence r5, z r10) {
        com.lynx.tasm.utils.d r11 = (com.lynx.tasm.utils.d) r10;
        r11.getClass();
        int r12 = r5.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.v(r5.charAt(r13));
        r13 = r13 + 1;
        goto L3
    }
}
