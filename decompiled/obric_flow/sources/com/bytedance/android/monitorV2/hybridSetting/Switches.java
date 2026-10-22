package com.bytedance.android.monitorV2.hybridSetting;

import d5.b;
import mn.h;
import z4.e;

/* JADX INFO: loaded from: classes2.dex */
public final enum Switches extends Enum<Switches> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Switches f3587b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Switches f3588c = null;
    public static final Switches d = null;
    public static final Switches e = null;
    public static final Switches f = null;
    public static final Switches g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Switches f3589h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Switches f3590i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Switches f3591j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Switches f3592k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Switches f3593l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Switches f3594m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Switches f3595n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Switches f3596o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Switches f3597p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Switches f3598q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Switches f3599r = null;
    public static final /* synthetic */ Switches[] s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3600a;

    static {
        Switches r5 = new Switches("monitor", 0, true, 0);
        f3587b = r5;
        Switches r10 = new Switches("webMonitor", 1, true, 1);
        f3588c = r10;
        Switches r11 = new Switches("webBlank", 2, true, 2);
        d = r11;
        Switches r12 = new Switches("webFetch", 3, true, 3);
        Switches r13 = new Switches("webJSB", 4, true, 4);
        e = r13;
        Switches r14 = new Switches("webInject", 5, true, 5);
        f = r14;
        Switches r15 = new Switches("lynxMonitor", 6, true, 6);
        g = r15;
        Switches r16 = new Switches("lynxPerf", 7, true, 7);
        f3589h = r16;
        Switches r17 = new Switches("lynxBlank", 8, true, 8);
        f3590i = r17;
        Switches r18 = new Switches("lynxFetch", 9, true, 9);
        Switches r19 = new Switches("lynxJsb", 10, true, 10);
        f3591j = r19;
        Switches r110 = new Switches("webAutoReport", 11, true, 11);
        Switches r111 = new Switches("webUpdatePageData", 12, true, 12);
        Switches r20 = new Switches("webTTWebDelegate", 13, true, 24);
        f3592k = r20;
        Switches r21 = new Switches("teaReport", 14, true, 25);
        f3593l = r21;
        Switches r22 = new Switches("webResourceLoader", 15, true, 26);
        Switches r23 = new Switches("lynxResourceLoader", 16, true, 27);
        Switches r24 = new Switches("checkSelf", 17, true, 28);
        f3594m = r24;
        Switches r25 = new Switches("eventStream", 18, true, 29);
        f3595n = r25;
        Switches r26 = new Switches("blankBitmap", 19, true, 30);
        f3596o = r26;
        Switches r27 = new Switches("webDomainWhiteList", 20, false, 31);
        f3597p = r27;
        Switches r28 = new Switches("logType", 21, false, 32);
        f3598q = r28;
        Switches r29 = new Switches("appSettings", 22, false, 35);
        f3599r = r29;
        s = new Switches[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29};
    }

    public Switches(String r5, int r10, boolean r11, int r12) {
        super(r5, r10);
        this.f3600a = r11;
        e.f23395a.put(Integer.valueOf(r12), this);
        if (r12 <= e.f23396b) goto L6;
        e.f23396b = r12;
        return;
    }

    public static void a(long r10) {
        int r5 = 0;
    L22:
    L15:
        th = move-exception;
        h.g("startup_handle", th);
        return;
    L4:
        if (r5 > e.f23396b) goto L18;
        boolean r11 = true;
        if (r5 == 0) goto L8;
        r10 = r10 >> 1;     // Catch: Throwable -> L15
    L8:
        Switches r12 = (Switches) e.f23395a.get(Integer.valueOf(r5));     // Catch: Throwable -> L15
        if (r12 == null) goto L17;
        if ((r10 % 2) != 0) goto L14;
        r11 = false;
    L14:
        r12.f3600a = r11;     // Catch: Throwable -> L15
    L17:
        r5 = r5 + 1;     // Catch: Throwable -> L15
        goto L22
    L18:
        b.f("Switches", "Switches: " + e.a());     // Catch: Throwable -> L15
    }

    public static Switches valueOf(String r5) {
        return (Switches) Enum.valueOf(Switches.class, r5);
    }

    public static Switches[] values() {
        return (Switches[]) s.clone();
    }
}
