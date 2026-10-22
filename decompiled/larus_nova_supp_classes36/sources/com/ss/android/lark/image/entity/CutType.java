package com.ss.android.lark.image.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum CutType extends Enum<CutType> {
    public static final CutType BOTTOM = null;
    public static final CutType CENTER = null;
    public static final CutType FACE = null;
    public static final CutType LEFT = null;
    public static final CutType RIGHT = null;
    public static final CutType TOP = null;
    public static final /* synthetic */ CutType[] a = null;
    private int value;

    static {
        CutType r0 = new CutType("TOP", 0, 1);
        TOP = r0;
        CutType r1 = new CutType("BOTTOM", 1, 2);
        BOTTOM = r1;
        CutType r4 = new CutType("LEFT", 2, 3);
        LEFT = r4;
        CutType r6 = new CutType("RIGHT", 3, 4);
        RIGHT = r6;
        CutType r8 = new CutType("CENTER", 4, 5);
        CENTER = r8;
        CutType r10 = new CutType("FACE", 5, 6);
        FACE = r10;
        a = new CutType[]{r0, r1, r4, r6, r8, r10};
    }

    public static CutType[] values() {
        return (CutType[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static CutType forNumber(int r0) {
        switch(r0) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        return CENTER;
    L6:
        return FACE;
    L8:
        return CENTER;
    L10:
        return RIGHT;
    L12:
        return LEFT;
    L14:
        return BOTTOM;
    L16:
        return TOP;
    }

    public static CutType valueOf(String r1) {
        return (CutType) r27.a.a(CutType.class, r1);
    }

    public static CutType valueOf(int r0) {
        return forNumber(r0);
    }

    public CutType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
