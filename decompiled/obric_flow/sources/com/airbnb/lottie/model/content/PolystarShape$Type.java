package com.airbnb.lottie.model.content;

/* JADX INFO: loaded from: classes.dex */
public final enum PolystarShape$Type extends Enum<PolystarShape$Type> {
    public static final PolystarShape$Type POLYGON = null;
    public static final PolystarShape$Type STAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PolystarShape$Type[] f1287a = null;
    private final int value;

    static {
        PolystarShape$Type r5 = new PolystarShape$Type("STAR", 0, 1);
        STAR = r5;
        PolystarShape$Type r10 = new PolystarShape$Type("POLYGON", 1, 2);
        POLYGON = r10;
        f1287a = new PolystarShape$Type[]{r5, r10};
    }

    public PolystarShape$Type(String r5, int r10, int r11) {
        super(r5, r10);
        this.value = r11;
    }

    public static PolystarShape$Type forValue(int r5) {
        PolystarShape$Type[] r10 = values();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        PolystarShape$Type r13 = r10[r12];
        if (r13.value == r5) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L8:
        return null;
    }

    public static PolystarShape$Type valueOf(String r5) {
        return (PolystarShape$Type) Enum.valueOf(PolystarShape$Type.class, r5);
    }

    public static PolystarShape$Type[] values() {
        return (PolystarShape$Type[]) f1287a.clone();
    }
}
