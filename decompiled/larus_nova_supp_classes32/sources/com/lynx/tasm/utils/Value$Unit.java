package com.lynx.tasm.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum Value$Unit extends Enum<Value$Unit> {
    public static final Value$Unit PERCENTAGE = null;
    public static final Value$Unit PX = null;
    public static final /* synthetic */ Value$Unit[] a = null;

    static {
        Value$Unit r0 = new Value$Unit("PX", 0);
        PX = r0;
        Value$Unit r1 = new Value$Unit("PERCENTAGE", 1);
        PERCENTAGE = r1;
        a = new Value$Unit[]{r0, r1};
    }

    public static Value$Unit[] values() {
        return (Value$Unit[]) a.clone();
    }

    public static Value$Unit valueOf(String r1) {
        return (Value$Unit) r27.a.a(Value$Unit.class, r1);
    }

    public Value$Unit(String r1, int r2) {
        super(r1, r2);
    }
}
