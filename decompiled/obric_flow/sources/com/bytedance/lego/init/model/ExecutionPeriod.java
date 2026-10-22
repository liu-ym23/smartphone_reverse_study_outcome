package com.bytedance.lego.init.model;

/* JADX INFO: loaded from: classes2.dex */
public final enum ExecutionPeriod extends Enum<ExecutionPeriod> {
    public static final ExecutionPeriod MAIN_ON_ANY = null;
    public static final ExecutionPeriod MAIN_ON_CREATE = null;
    public static final ExecutionPeriod MAIN_ON_DESTROY = null;
    public static final ExecutionPeriod MAIN_ON_PAUSE = null;
    public static final ExecutionPeriod MAIN_ON_RESUME = null;
    public static final ExecutionPeriod MAIN_ON_START = null;
    public static final ExecutionPeriod MAIN_ON_STOP = null;
    public static final ExecutionPeriod SPLASH_ON_ANY = null;
    public static final ExecutionPeriod SPLASH_ON_CREATE = null;
    public static final ExecutionPeriod SPLASH_ON_DESTROY = null;
    public static final ExecutionPeriod SPLASH_ON_PAUSE = null;
    public static final ExecutionPeriod SPLASH_ON_RESUME = null;
    public static final ExecutionPeriod SPLASH_ON_START = null;
    public static final ExecutionPeriod SPLASH_ON_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExecutionPeriod[] f6753a = null;

    static {
        ExecutionPeriod r5 = new ExecutionPeriod("SPLASH_ON_CREATE", 0);
        SPLASH_ON_CREATE = r5;
        ExecutionPeriod r10 = new ExecutionPeriod("SPLASH_ON_START", 1);
        SPLASH_ON_START = r10;
        ExecutionPeriod r11 = new ExecutionPeriod("SPLASH_ON_RESUME", 2);
        SPLASH_ON_RESUME = r11;
        ExecutionPeriod r12 = new ExecutionPeriod("SPLASH_ON_PAUSE", 3);
        SPLASH_ON_PAUSE = r12;
        ExecutionPeriod r13 = new ExecutionPeriod("SPLASH_ON_STOP", 4);
        SPLASH_ON_STOP = r13;
        ExecutionPeriod r14 = new ExecutionPeriod("SPLASH_ON_DESTROY", 5);
        SPLASH_ON_DESTROY = r14;
        ExecutionPeriod r15 = new ExecutionPeriod("SPLASH_ON_ANY", 6);
        SPLASH_ON_ANY = r15;
        ExecutionPeriod r16 = new ExecutionPeriod("MAIN_ON_CREATE", 7);
        MAIN_ON_CREATE = r16;
        ExecutionPeriod r17 = new ExecutionPeriod("MAIN_ON_START", 8);
        MAIN_ON_START = r17;
        ExecutionPeriod r18 = new ExecutionPeriod("MAIN_ON_RESUME", 9);
        MAIN_ON_RESUME = r18;
        ExecutionPeriod r19 = new ExecutionPeriod("MAIN_ON_PAUSE", 10);
        MAIN_ON_PAUSE = r19;
        ExecutionPeriod r110 = new ExecutionPeriod("MAIN_ON_STOP", 11);
        MAIN_ON_STOP = r110;
        ExecutionPeriod r111 = new ExecutionPeriod("MAIN_ON_DESTROY", 12);
        MAIN_ON_DESTROY = r111;
        ExecutionPeriod r112 = new ExecutionPeriod("MAIN_ON_ANY", 13);
        MAIN_ON_ANY = r112;
        f6753a = new ExecutionPeriod[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112};
    }

    public static ExecutionPeriod from(String r5) {
        r5.getClass();
        byte r10 = -1;
        switch(r5.hashCode()) {
            case -1604499520: goto L58;
            case -364577614: goto L54;
            case 236883538: goto L50;
            case 735015050: goto L46;
            case 901014614: goto L42;
            case 1307299406: goto L38;
            case 1310616762: goto L34;
            case 1318882183: goto L30;
            case 1514603396: goto L26;
            case 1583537628: goto L22;
            case 1824808004: goto L18;
            case 1841695548: goto L14;
            case 1845012904: goto L10;
            case 1932470965: goto L6;
            default: goto L61;
        };
    L61:
        switch(r10) {
            case 0: goto L91;
            case 1: goto L89;
            case 2: goto L87;
            case 3: goto L85;
            case 4: goto L83;
            case 5: goto L81;
            case 6: goto L79;
            case 7: goto L77;
            case 8: goto L75;
            case 9: goto L73;
            case 10: goto L71;
            case 11: goto L69;
            case 12: goto L67;
            case 13: goto L65;
            default: goto L62;
        };
    L62:
        return null;
    L65:
        return SPLASH_ON_RESUME;
    L67:
        return MAIN_ON_START;
    L69:
        return MAIN_ON_PAUSE;
    L71:
        return SPLASH_ON_ANY;
    L73:
        return MAIN_ON_STOP;
    L75:
        return SPLASH_ON_CREATE;
    L77:
        return MAIN_ON_RESUME;
    L79:
        return SPLASH_ON_START;
    L81:
        return SPLASH_ON_PAUSE;
    L83:
        return MAIN_ON_CREATE;
    L85:
        return SPLASH_ON_STOP;
    L87:
        return SPLASH_ON_DESTROY;
    L89:
        return MAIN_ON_ANY;
    L91:
        return MAIN_ON_DESTROY;
    L6:
        if (r5.equals("SPLASH_ON_RESUME") == false) goto L61;
        r10 = 13;
        goto L61
    L10:
        if (r5.equals("MAIN_ON_START") == false) goto L61;
        r10 = 12;
        goto L61
    L14:
        if (r5.equals("MAIN_ON_PAUSE") == false) goto L61;
        r10 = 11;
        goto L61
    L18:
        if (r5.equals("SPLASH_ON_ANY") == false) goto L61;
        r10 = 10;
        goto L61
    L22:
        if (r5.equals("MAIN_ON_STOP") == false) goto L61;
        r10 = 9;
        goto L61
    L26:
        if (r5.equals("SPLASH_ON_CREATE") == false) goto L61;
        r10 = 8;
        goto L61
    L30:
        if (r5.equals("MAIN_ON_RESUME") == false) goto L61;
        r10 = 7;
        goto L61
    L34:
        if (r5.equals("SPLASH_ON_START") == false) goto L61;
        r10 = 6;
        goto L61
    L38:
        if (r5.equals("SPLASH_ON_PAUSE") == false) goto L61;
        r10 = 5;
        goto L61
    L42:
        if (r5.equals("MAIN_ON_CREATE") == false) goto L61;
        r10 = 4;
        goto L61
    L46:
        if (r5.equals("SPLASH_ON_STOP") == false) goto L61;
        r10 = 3;
        goto L61
    L50:
        if (r5.equals("SPLASH_ON_DESTROY") == false) goto L61;
        r10 = 2;
        goto L61
    L54:
        if (r5.equals("MAIN_ON_ANY") == false) goto L61;
        r10 = 1;
        goto L61
    L58:
        if (r5.equals("MAIN_ON_DESTROY") == false) goto L61;
        r10 = 0;
        goto L61
    }

    public static ExecutionPeriod valueOf(String r5) {
        return (ExecutionPeriod) Enum.valueOf(ExecutionPeriod.class, r5);
    }

    public static ExecutionPeriod[] values() {
        return (ExecutionPeriod[]) f6753a.clone();
    }
}
