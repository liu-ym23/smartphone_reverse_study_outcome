package com.lynx.tasm.resourceprovider.media;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum OptionalBool extends Enum<OptionalBool> {
    public static final OptionalBool FALSE = null;
    public static final OptionalBool TRUE = null;
    public static final OptionalBool UNDEFINED = null;
    public static final /* synthetic */ OptionalBool[] a = null;

    static {
        OptionalBool r0 = new OptionalBool("TRUE", 0);
        TRUE = r0;
        OptionalBool r1 = new OptionalBool("FALSE", 1);
        FALSE = r1;
        OptionalBool r3 = new OptionalBool("UNDEFINED", 2);
        UNDEFINED = r3;
        a = new OptionalBool[]{r0, r1, r3};
    }

    public static OptionalBool[] values() {
        return (OptionalBool[]) a.clone();
    }

    public static OptionalBool valueOf(String r1) {
        return (OptionalBool) a.a(OptionalBool.class, r1);
    }

    public OptionalBool(String r1, int r2) {
        super(r1, r2);
    }
}
