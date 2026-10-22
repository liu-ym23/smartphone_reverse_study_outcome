package com.bytedance.lego.init.model;

/* JADX WARN: Unexpected interfaces in signature: [java.io.Serializable] */
/* JADX INFO: loaded from: classes.dex */
public final enum InitPeriod extends Enum<InitPeriod> {
    private static final /* synthetic */ InitPeriod[] $VALUES = null;
    public static final InitPeriod APP_ATTACHBASE2SUPER = null;
    public static final InitPeriod APP_ONCREATE2SUPER = null;
    public static final InitPeriod APP_SUPER2ATTACHBASEEND = null;
    public static final InitPeriod APP_SUPER2ONCREATEEND = null;
    public static final InitPeriod MAIN_ONCREATE2SUPER = null;
    public static final InitPeriod MAIN_ONRESUME2SUPER = null;
    public static final InitPeriod MAIN_SUPER2ONCREATEEND = null;
    public static final InitPeriod MAIN_SUPER2ONRESUMEEND = null;
    public static final InitPeriod NONE = null;
    public static final InitPeriod SPLASH_ONCREATE2SUPER = null;
    public static final InitPeriod SPLASH_ONRESUME2SUPER = null;
    public static final InitPeriod SPLASH_SUPER2ONCREATEEND = null;
    public static final InitPeriod SPLASH_SUPER2ONRESUMEEND = null;
    private int value;

    static {
        InitPeriod r10 = new InitPeriod("APP_ATTACHBASE2SUPER", 0, 0);
        APP_ATTACHBASE2SUPER = r10;
        InitPeriod r11 = new InitPeriod("APP_SUPER2ATTACHBASEEND", 1, 1);
        APP_SUPER2ATTACHBASEEND = r11;
        InitPeriod r12 = new InitPeriod("APP_ONCREATE2SUPER", 2, 2);
        APP_ONCREATE2SUPER = r12;
        InitPeriod r13 = new InitPeriod("APP_SUPER2ONCREATEEND", 3, 3);
        APP_SUPER2ONCREATEEND = r13;
        InitPeriod r14 = new InitPeriod("SPLASH_ONCREATE2SUPER", 4, 4);
        SPLASH_ONCREATE2SUPER = r14;
        InitPeriod r15 = new InitPeriod("SPLASH_SUPER2ONCREATEEND", 5, 5);
        SPLASH_SUPER2ONCREATEEND = r15;
        InitPeriod r16 = new InitPeriod("SPLASH_ONRESUME2SUPER", 6, 6);
        SPLASH_ONRESUME2SUPER = r16;
        InitPeriod r17 = new InitPeriod("SPLASH_SUPER2ONRESUMEEND", 7, 7);
        SPLASH_SUPER2ONRESUMEEND = r17;
        InitPeriod r18 = new InitPeriod("MAIN_ONCREATE2SUPER", 8, 8);
        MAIN_ONCREATE2SUPER = r18;
        InitPeriod r19 = new InitPeriod("MAIN_SUPER2ONCREATEEND", 9, 9);
        MAIN_SUPER2ONCREATEEND = r19;
        InitPeriod r110 = new InitPeriod("MAIN_ONRESUME2SUPER", 10, 10);
        MAIN_ONRESUME2SUPER = r110;
        InitPeriod r111 = new InitPeriod("MAIN_SUPER2ONRESUMEEND", 11, 11);
        MAIN_SUPER2ONRESUMEEND = r111;
        InitPeriod r20 = new InitPeriod("NONE", 12, 12);
        NONE = r20;
        $VALUES = new InitPeriod[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20};
    }

    private InitPeriod(String r10, int r11, int r12) {
        super(r10, r11);
        this.value = r12;
    }

    public static InitPeriod valueOf(String r10) {
        return (InitPeriod) Enum.valueOf(InitPeriod.class, r10);
    }

    public static InitPeriod[] values() {
        return (InitPeriod[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }
}
