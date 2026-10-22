package com.lynx.clay.embedding.android;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum TransparencyMode extends Enum<TransparencyMode> {
    public static final /* synthetic */ TransparencyMode[] a = null;
    public static final TransparencyMode opaque = null;
    public static final TransparencyMode transparent = null;

    static {
        TransparencyMode r0 = new TransparencyMode("opaque", 0);
        opaque = r0;
        TransparencyMode r1 = new TransparencyMode("transparent", 1);
        transparent = r1;
        a = new TransparencyMode[]{r0, r1};
    }

    public static TransparencyMode[] values() {
        return (TransparencyMode[]) a.clone();
    }

    public static TransparencyMode valueOf(String r1) {
        return (TransparencyMode) r27.a.a(TransparencyMode.class, r1);
    }

    public TransparencyMode(String r1, int r2) {
        super(r1, r2);
    }
}
