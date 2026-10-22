package org.checkerframework.checker.units.qual;

/* JADX INFO: loaded from: classes3.dex */
public final enum Prefix extends Enum<Prefix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Prefix[] f20984a = null;
    public static final Prefix atto = null;
    public static final Prefix centi = null;
    public static final Prefix deca = null;
    public static final Prefix deci = null;
    public static final Prefix exa = null;
    public static final Prefix femto = null;
    public static final Prefix giga = null;
    public static final Prefix hecto = null;
    public static final Prefix kilo = null;
    public static final Prefix mega = null;
    public static final Prefix micro = null;
    public static final Prefix milli = null;
    public static final Prefix nano = null;
    public static final Prefix one = null;
    public static final Prefix peta = null;
    public static final Prefix pico = null;
    public static final Prefix tera = null;
    public static final Prefix yocto = null;
    public static final Prefix yotta = null;
    public static final Prefix zepto = null;
    public static final Prefix zetta = null;

    static {
        Prefix r5 = new Prefix("yotta", 0);
        yotta = r5;
        Prefix r10 = new Prefix("zetta", 1);
        zetta = r10;
        Prefix r11 = new Prefix("exa", 2);
        exa = r11;
        Prefix r12 = new Prefix("peta", 3);
        peta = r12;
        Prefix r13 = new Prefix("tera", 4);
        tera = r13;
        Prefix r14 = new Prefix("giga", 5);
        giga = r14;
        Prefix r15 = new Prefix("mega", 6);
        mega = r15;
        Prefix r16 = new Prefix("kilo", 7);
        kilo = r16;
        Prefix r17 = new Prefix("hecto", 8);
        hecto = r17;
        Prefix r18 = new Prefix("deca", 9);
        deca = r18;
        Prefix r19 = new Prefix("one", 10);
        one = r19;
        Prefix r110 = new Prefix("deci", 11);
        deci = r110;
        Prefix r111 = new Prefix("centi", 12);
        centi = r111;
        Prefix r112 = new Prefix("milli", 13);
        milli = r112;
        Prefix r113 = new Prefix("micro", 14);
        micro = r113;
        Prefix r114 = new Prefix("nano", 15);
        nano = r114;
        Prefix r115 = new Prefix("pico", 16);
        pico = r115;
        Prefix r116 = new Prefix("femto", 17);
        femto = r116;
        Prefix r117 = new Prefix("atto", 18);
        atto = r117;
        Prefix r118 = new Prefix("zepto", 19);
        zepto = r118;
        Prefix r119 = new Prefix("yocto", 20);
        yocto = r119;
        f20984a = new Prefix[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119};
    }

    public static Prefix valueOf(String r5) {
        return (Prefix) Enum.valueOf(Prefix.class, r5);
    }

    public static Prefix[] values() {
        return (Prefix[]) f20984a.clone();
    }
}
