package com.bytedance.bmf;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final enum Timestamp extends Enum<Timestamp> {
    private static final /* synthetic */ Timestamp[] $VALUES = null;
    public static final Timestamp BMF_PAUSE = null;
    public static final Timestamp DONE = null;
    public static final Timestamp EOF = null;
    public static final Timestamp EOS = null;
    public static final Timestamp INF_SRC = null;
    public static final Timestamp UNSET = null;
    private long value;

    static {
        Timestamp r0 = new Timestamp("UNSET", 0, -1);
        UNSET = r0;
        Timestamp r1 = new Timestamp("BMF_PAUSE", 1, 9223372036854775802L);
        BMF_PAUSE = r1;
        Timestamp r10 = new Timestamp("EOF", 2, 9223372036854775804L);
        EOF = r10;
        Timestamp r11 = new Timestamp("EOS", 3, 9223372036854775805L);
        EOS = r11;
        Timestamp r12 = new Timestamp("INF_SRC", 4, 9223372036854775806L);
        INF_SRC = r12;
        Timestamp r13 = new Timestamp("DONE", 5, Long.MAX_VALUE);
        DONE = r13;
        $VALUES = new Timestamp[]{r0, r1, r10, r11, r12, r13};
    }

    public static Timestamp[] values() {
        return (Timestamp[]) $VALUES.clone();
    }

    public long getValue() {
        return this.value;
    }

    public static Timestamp valueOf(String r1) {
        return (Timestamp) a.a(Timestamp.class, r1);
    }

    private Timestamp(String r1, int r10, long r11) {
        super(r1, r10);
        this.value = r11;
    }
}
