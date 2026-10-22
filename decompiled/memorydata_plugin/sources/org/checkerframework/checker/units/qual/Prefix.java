package org.checkerframework.checker.units.qual;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum Prefix extends Enum<Prefix> {
    private static final /* synthetic */ Prefix[] $VALUES = null;
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

    private static /* synthetic */ Prefix[] $values() {
        return new Prefix[]{yotta, zetta, exa, peta, tera, giga, mega, kilo, hecto, deca, one, deci, centi, milli, micro, nano, pico, femto, atto, zepto, yocto};
    }

    static {
        yotta = new Prefix("yotta", 0);
        zetta = new Prefix("zetta", 1);
        exa = new Prefix("exa", 2);
        peta = new Prefix("peta", 3);
        tera = new Prefix("tera", 4);
        giga = new Prefix("giga", 5);
        mega = new Prefix("mega", 6);
        kilo = new Prefix("kilo", 7);
        hecto = new Prefix("hecto", 8);
        deca = new Prefix("deca", 9);
        one = new Prefix("one", 10);
        deci = new Prefix("deci", 11);
        centi = new Prefix("centi", 12);
        milli = new Prefix("milli", 13);
        micro = new Prefix("micro", 14);
        nano = new Prefix("nano", 15);
        pico = new Prefix("pico", 16);
        femto = new Prefix("femto", 17);
        atto = new Prefix("atto", 18);
        zepto = new Prefix("zepto", 19);
        yocto = new Prefix("yocto", 20);
        $VALUES = $values();
    }

    private Prefix(String r1, int r2) {
        super(r1, r2);
    }

    public static Prefix valueOf(String r2) {
        return (Prefix) ZeusTransformUtils.preCheckCast(Enum.valueOf(Prefix.class, r2), Prefix.class, "com.obric.memorydata.plugin");
    }

    public static Prefix[] values() {
        return (Prefix[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Prefix[].class, "com.obric.memorydata.plugin");
    }
}
