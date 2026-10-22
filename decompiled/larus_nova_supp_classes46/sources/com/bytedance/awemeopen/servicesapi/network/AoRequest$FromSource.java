package com.bytedance.awemeopen.servicesapi.network;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final enum AoRequest$FromSource extends Enum<AoRequest$FromSource> {
    public static final /* synthetic */ AoRequest$FromSource[] a = null;
    public static final AoRequest$FromSource ad = null;
    public static final AoRequest$FromSource bdp = null;
    public static final AoRequest$FromSource cp = null;
    public static final AoRequest$FromSource dns = null;
    public static final AoRequest$FromSource download = null;
    public static final AoRequest$FromSource empty = null;
    public static final AoRequest$FromSource image = null;
    public static final AoRequest$FromSource inner = null;
    public static final AoRequest$FromSource launch = null;
    public static final AoRequest$FromSource loader = null;
    public static final AoRequest$FromSource locate = null;
    public static final AoRequest$FromSource netbus = null;
    public static final AoRequest$FromSource opendata = null;
    public static final AoRequest$FromSource permission = null;
    public static final AoRequest$FromSource platform = null;
    public static final AoRequest$FromSource plugin = null;
    public static final AoRequest$FromSource prefetch = null;
    public static final AoRequest$FromSource sentry = null;
    public static final AoRequest$FromSource settings = null;
    public static final AoRequest$FromSource shortcut = null;
    public static final AoRequest$FromSource sonic = null;
    public static final AoRequest$FromSource stream = null;
    public static final AoRequest$FromSource test = null;
    public static final AoRequest$FromSource upload = null;
    private final String fromSource;

    static {
        AoRequest$FromSource r0 = new AoRequest$FromSource("bdp", 0, "bdp");
        bdp = r0;
        AoRequest$FromSource r1 = new AoRequest$FromSource("prefetch", 1, "prefetch");
        prefetch = r1;
        AoRequest$FromSource r3 = new AoRequest$FromSource("cp", 2, "cp");
        cp = r3;
        AoRequest$FromSource r5 = new AoRequest$FromSource("inner", 3, "inner");
        inner = r5;
        AoRequest$FromSource r7 = new AoRequest$FromSource("download", 4, "download");
        download = r7;
        AoRequest$FromSource r9 = new AoRequest$FromSource("sentry", 5, "sentry");
        sentry = r9;
        AoRequest$FromSource r11 = new AoRequest$FromSource("stream", 6, "stream");
        stream = r11;
        AoRequest$FromSource r13 = new AoRequest$FromSource("image", 7, "image");
        image = r13;
        AoRequest$FromSource r15 = new AoRequest$FromSource("settings", 8, "settings");
        settings = r15;
        AoRequest$FromSource r14 = new AoRequest$FromSource("upload", 9, "upload");
        upload = r14;
        AoRequest$FromSource r12 = new AoRequest$FromSource("ad", 10, "ad");
        ad = r12;
        AoRequest$FromSource r10 = new AoRequest$FromSource("shortcut", 11, "shortcut");
        shortcut = r10;
        AoRequest$FromSource r4 = new AoRequest$FromSource("loader", 12, "loader");
        loader = r4;
        AoRequest$FromSource r2 = new AoRequest$FromSource("locate", 13, "locate");
        locate = r2;
        AoRequest$FromSource r6 = new AoRequest$FromSource("dns", 14, "dns");
        dns = r6;
        AoRequest$FromSource r8 = new AoRequest$FromSource("permission", 15, "permission");
        permission = r8;
        AoRequest$FromSource r16 = new AoRequest$FromSource("platform", 16, "platform");
        platform = r16;
        AoRequest$FromSource r17 = new AoRequest$FromSource("opendata", 17, "opendata");
        opendata = r17;
        AoRequest$FromSource r18 = new AoRequest$FromSource("launch", 18, "launch");
        launch = r18;
        AoRequest$FromSource r19 = new AoRequest$FromSource("plugin", 19, "plugin");
        plugin = r19;
        AoRequest$FromSource r20 = new AoRequest$FromSource("netbus", 20, "netbus");
        netbus = r20;
        AoRequest$FromSource r21 = new AoRequest$FromSource("sonic", 21, "sonic");
        sonic = r21;
        AoRequest$FromSource r22 = new AoRequest$FromSource("test", 22, "test");
        test = r22;
        AoRequest$FromSource r23 = new AoRequest$FromSource("empty", 23, "empty");
        empty = r23;
        a = new AoRequest$FromSource[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r4, r2, r6, r8, r16, r17, r18, r19, r20, r21, r22, r23};
    }

    public static AoRequest$FromSource[] values() {
        return (AoRequest$FromSource[]) a.clone();
    }

    public String getValue() {
        return this.fromSource;
    }

    public static AoRequest$FromSource valueOf(String r1) {
        return (AoRequest$FromSource) a.a(AoRequest$FromSource.class, r1);
    }

    public AoRequest$FromSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.fromSource = r3;
    }
}
