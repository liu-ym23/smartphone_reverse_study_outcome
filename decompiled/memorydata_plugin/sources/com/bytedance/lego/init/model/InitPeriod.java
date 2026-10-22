package com.bytedance.lego.init.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final enum InitPeriod extends Enum<InitPeriod> implements Serializable {
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
        InitPeriod r0 = new InitPeriod("APP_ATTACHBASE2SUPER", 0, 0);
        APP_ATTACHBASE2SUPER = r0;
        InitPeriod r1 = new InitPeriod("APP_SUPER2ATTACHBASEEND", 1, 1);
        APP_SUPER2ATTACHBASEEND = r1;
        InitPeriod r3 = new InitPeriod("APP_ONCREATE2SUPER", 2, 2);
        APP_ONCREATE2SUPER = r3;
        InitPeriod r5 = new InitPeriod("APP_SUPER2ONCREATEEND", 3, 3);
        APP_SUPER2ONCREATEEND = r5;
        InitPeriod r7 = new InitPeriod("SPLASH_ONCREATE2SUPER", 4, 4);
        SPLASH_ONCREATE2SUPER = r7;
        InitPeriod r9 = new InitPeriod("SPLASH_SUPER2ONCREATEEND", 5, 5);
        SPLASH_SUPER2ONCREATEEND = r9;
        InitPeriod r11 = new InitPeriod("SPLASH_ONRESUME2SUPER", 6, 6);
        SPLASH_ONRESUME2SUPER = r11;
        InitPeriod r13 = new InitPeriod("SPLASH_SUPER2ONRESUMEEND", 7, 7);
        SPLASH_SUPER2ONRESUMEEND = r13;
        InitPeriod r15 = new InitPeriod("MAIN_ONCREATE2SUPER", 8, 8);
        MAIN_ONCREATE2SUPER = r15;
        InitPeriod r14 = new InitPeriod("MAIN_SUPER2ONCREATEEND", 9, 9);
        MAIN_SUPER2ONCREATEEND = r14;
        InitPeriod r12 = new InitPeriod("MAIN_ONRESUME2SUPER", 10, 10);
        MAIN_ONRESUME2SUPER = r12;
        InitPeriod r10 = new InitPeriod("MAIN_SUPER2ONRESUMEEND", 11, 11);
        MAIN_SUPER2ONRESUMEEND = r10;
        InitPeriod r8 = new InitPeriod("NONE", 12, 12);
        NONE = r8;
        $VALUES = new InitPeriod[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
    }

    private InitPeriod(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static InitPeriod valueOf(String r2) {
        return (InitPeriod) ZeusTransformUtils.preCheckCast(Enum.valueOf(InitPeriod.class, r2), InitPeriod.class, "com.obric.memorydata.plugin");
    }

    public static InitPeriod[] values() {
        return (InitPeriod[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), InitPeriod[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
