package com.loc;

import android.os.Build;
import com.obric.aivoice.core.data.NameKeys;
import n4a.f5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum al extends Enum<al> {
    public static final al a = null;
    public static final al b = null;
    public static final al c = null;
    public static final al d = null;
    public static final al e = null;
    public static final al f = null;
    public static final al g = null;
    public static final al h = null;
    public static final al i = null;
    public static final al j = null;
    public static final al k = null;
    public static final al l = null;
    public static final al m = null;
    public static final /* synthetic */ al[] s = null;
    private String n;
    private int o;
    private String p;
    private String q;
    private String r;

    static {
        al r0 = new al("MIUI", 0, f5.o("IeGlhb21p"));
        a = r0;
        al r1 = new al("Flyme", 1, f5.o("IbWVpenU"));
        b = r1;
        al r2 = new al("RH", 2, f5.o("IaHVhd2Vp"));
        c = r2;
        al r4 = new al("ColorOS", 3, f5.o("Ib3Bwbw"));
        d = r4;
        al r6 = new al("FuntouchOS", 4, f5.o("Idml2bw"));
        e = r6;
        al r8 = new al("SmartisanOS", 5, f5.o("Mc21hcnRpc2Fu"));
        f = r8;
        al r10 = new al("AmigoOS", 6, f5.o("IYW1pZ28"));
        g = r10;
        al r12 = new al("EUI", 7, f5.o("IbGV0dg"));
        h = r12;
        al r14 = new al("Sense", 8, f5.o("EaHRj"));
        i = r14;
        al r13 = new al("LG", 9, f5.o("EbGdl"));
        j = r13;
        al r11 = new al("Google", 10, f5.o("IZ29vZ2xl"));
        k = r11;
        al r9 = new al("NubiaUI", 11, f5.o("IbnViaWE"));
        l = r9;
        al r7 = new al("Other", 12, NameKeys.UnloadStrategy_No_Strategy);
        m = r7;
        s = new al[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7};
    }

    public al(String r1, int r2, String r3) {
        super(r1, r2);
        this.r = Build.MANUFACTURER;
        this.n = r3;
    }

    public static al valueOf(String r1) {
        return (al) r27.a.a(al.class, r1);
    }

    public static al[] values() {
        return (al[]) s.clone();
    }

    public final String a() {
        return this.n;
    }

    public final void a(int r1) {
        this.o = r1;
    }

    public final void a(String r1) {
        this.p = r1;
    }

    public final String b() {
        return this.p;
    }

    public final void b(String r1) {
        this.q = r1;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.o + ", versionName='" + this.q + "',ma=" + this.n + "',manufacturer=" + this.r + "'}";
    }
}
