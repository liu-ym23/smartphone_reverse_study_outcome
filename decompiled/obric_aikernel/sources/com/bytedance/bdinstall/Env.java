package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes.dex */
public class Env extends AbsEnv {
    public static Env CHINA;
    public static Env CHINA_BOE;
    public static final Env DEFAULT = null;

    static {
        CHINA = new Env(InstallUrl.createUriByDomain("https://log.snssdk.com"), false, false);
        CHINA_BOE = new Env(InstallUrl.createUriByDomain("https://boe.i.snssdk.com"), false, true);
        DEFAULT = CHINA;
    }

    public Env(InstallUrl r10, boolean r11, boolean r12) {
        this(r10, r11, r12, false);
    }

    public Env(InstallUrl r10, boolean r11, boolean r12, boolean r13) {
        super(r10, r11, r12, r13);
    }
}
