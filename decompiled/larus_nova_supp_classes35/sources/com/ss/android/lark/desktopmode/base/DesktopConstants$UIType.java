package com.ss.android.lark.desktopmode.base;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum DesktopConstants$UIType extends Enum<DesktopConstants$UIType> {
    public static final DesktopConstants$UIType DRAWER_MAX_C2 = null;
    public static final DesktopConstants$UIType DRAWER_NORMAL_C1 = null;
    public static final DesktopConstants$UIType FLOAT_MODAL_THIN_M2 = null;
    public static final DesktopConstants$UIType FLOAT_MODAL_WIDE_M1 = null;
    public static final DesktopConstants$UIType FLOAT_POPOVER_P1 = null;
    public static final DesktopConstants$UIType UNKNOWN = null;
    public static final DesktopConstants$UIType WINDOW_CENTER_D3 = null;
    public static final DesktopConstants$UIType WINDOW_NORMAL_D1 = null;
    public static final DesktopConstants$UIType WINDOW_WIDE_D2 = null;
    public static final /* synthetic */ DesktopConstants$UIType[] a = null;
    private String value;

    static {
        DesktopConstants$UIType r0 = new DesktopConstants$UIType("UNKNOWN", 0, "UNKNOWN");
        UNKNOWN = r0;
        DesktopConstants$UIType r1 = new DesktopConstants$UIType("FLOAT_MODAL_WIDE_M1", 1, "M1");
        FLOAT_MODAL_WIDE_M1 = r1;
        DesktopConstants$UIType r3 = new DesktopConstants$UIType("FLOAT_MODAL_THIN_M2", 2, "M2");
        FLOAT_MODAL_THIN_M2 = r3;
        DesktopConstants$UIType r4 = new DesktopConstants$UIType("FLOAT_POPOVER_P1", 3, "P1");
        FLOAT_POPOVER_P1 = r4;
        DesktopConstants$UIType r6 = new DesktopConstants$UIType("DRAWER_NORMAL_C1", 4, "C1");
        DRAWER_NORMAL_C1 = r6;
        DesktopConstants$UIType r8 = new DesktopConstants$UIType("DRAWER_MAX_C2", 5, "C2");
        DRAWER_MAX_C2 = r8;
        DesktopConstants$UIType r10 = new DesktopConstants$UIType("WINDOW_NORMAL_D1", 6, "D1");
        WINDOW_NORMAL_D1 = r10;
        DesktopConstants$UIType r12 = new DesktopConstants$UIType("WINDOW_WIDE_D2", 7, "D2");
        WINDOW_WIDE_D2 = r12;
        DesktopConstants$UIType r14 = new DesktopConstants$UIType("WINDOW_CENTER_D3", 8, "D3");
        WINDOW_CENTER_D3 = r14;
        a = new DesktopConstants$UIType[]{r0, r1, r3, r4, r6, r8, r10, r12, r14};
    }

    public static DesktopConstants$UIType[] values() {
        return (DesktopConstants$UIType[]) a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static DesktopConstants$UIType forValue(String r2) {
        r2.getClass();
        byte r1 = -1;
        switch(r2.hashCode()) {
            case 2126: goto L34;
            case 2127: goto L30;
            case 2157: goto L26;
            case 2158: goto L22;
            case 2159: goto L18;
            case 2436: goto L14;
            case 2437: goto L10;
            case 2529: goto L6;
            default: goto L37;
        };
    L37:
        switch(r1) {
            case 0: goto L55;
            case 1: goto L53;
            case 2: goto L51;
            case 3: goto L49;
            case 4: goto L47;
            case 5: goto L45;
            case 6: goto L43;
            case 7: goto L41;
            default: goto L39;
        };
    L39:
        return UNKNOWN;
    L41:
        return FLOAT_POPOVER_P1;
    L43:
        return FLOAT_MODAL_THIN_M2;
    L45:
        return FLOAT_MODAL_WIDE_M1;
    L47:
        return WINDOW_CENTER_D3;
    L49:
        return WINDOW_WIDE_D2;
    L51:
        return WINDOW_NORMAL_D1;
    L53:
        return DRAWER_MAX_C2;
    L55:
        return DRAWER_NORMAL_C1;
    L6:
        if (r2.equals("P1") == false) goto L37;
        r1 = 7;
        goto L37
    L10:
        if (r2.equals("M2") == false) goto L37;
        r1 = 6;
        goto L37
    L14:
        if (r2.equals("M1") == false) goto L37;
        r1 = 5;
        goto L37
    L18:
        if (r2.equals("D3") == false) goto L37;
        r1 = 4;
        goto L37
    L22:
        if (r2.equals("D2") == false) goto L37;
        r1 = 3;
        goto L37
    L26:
        if (r2.equals("D1") == false) goto L37;
        r1 = 2;
        goto L37
    L30:
        if (r2.equals("C2") == false) goto L37;
        r1 = 1;
        goto L37
    L34:
        if (r2.equals("C1") == false) goto L37;
        r1 = 0;
        goto L37
    }

    public static DesktopConstants$UIType valueOf(String r1) {
        return (DesktopConstants$UIType) a.a(DesktopConstants$UIType.class, r1);
    }

    public DesktopConstants$UIType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
