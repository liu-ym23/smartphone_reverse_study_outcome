package com.bytedance.lego.init.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final enum InitPeriod extends Enum<InitPeriod> implements Serializable {
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InitPeriod[] f6754a = null;
    private int value;

    static {
        InitPeriod r5 = new InitPeriod("APP_ATTACHBASE2SUPER", 0, 0);
        APP_ATTACHBASE2SUPER = r5;
        InitPeriod r10 = new InitPeriod("APP_SUPER2ATTACHBASEEND", 1, 1);
        APP_SUPER2ATTACHBASEEND = r10;
        InitPeriod r11 = new InitPeriod("APP_ONCREATE2SUPER", 2, 2);
        APP_ONCREATE2SUPER = r11;
        InitPeriod r12 = new InitPeriod("APP_SUPER2ONCREATEEND", 3, 3);
        APP_SUPER2ONCREATEEND = r12;
        InitPeriod r13 = new InitPeriod("SPLASH_ONCREATE2SUPER", 4, 4);
        SPLASH_ONCREATE2SUPER = r13;
        InitPeriod r14 = new InitPeriod("SPLASH_SUPER2ONCREATEEND", 5, 5);
        SPLASH_SUPER2ONCREATEEND = r14;
        InitPeriod r15 = new InitPeriod("SPLASH_ONRESUME2SUPER", 6, 6);
        SPLASH_ONRESUME2SUPER = r15;
        InitPeriod r16 = new InitPeriod("SPLASH_SUPER2ONRESUMEEND", 7, 7);
        SPLASH_SUPER2ONRESUMEEND = r16;
        InitPeriod r17 = new InitPeriod("MAIN_ONCREATE2SUPER", 8, 8);
        MAIN_ONCREATE2SUPER = r17;
        InitPeriod r18 = new InitPeriod("MAIN_SUPER2ONCREATEEND", 9, 9);
        MAIN_SUPER2ONCREATEEND = r18;
        InitPeriod r19 = new InitPeriod("MAIN_ONRESUME2SUPER", 10, 10);
        MAIN_ONRESUME2SUPER = r19;
        InitPeriod r110 = new InitPeriod("MAIN_SUPER2ONRESUMEEND", 11, 11);
        MAIN_SUPER2ONRESUMEEND = r110;
        InitPeriod r111 = new InitPeriod("NONE", 12, 12);
        NONE = r111;
        f6754a = new InitPeriod[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111};
    }

    public InitPeriod(String r5, int r10, int r11) {
        super(r5, r10);
        this.value = r11;
    }

    public static InitPeriod valueOf(String r5) {
        return (InitPeriod) Enum.valueOf(InitPeriod.class, r5);
    }

    public static InitPeriod[] values() {
        return (InitPeriod[]) f6754a.clone();
    }

    public int getValue() {
        return this.value;
    }
}
