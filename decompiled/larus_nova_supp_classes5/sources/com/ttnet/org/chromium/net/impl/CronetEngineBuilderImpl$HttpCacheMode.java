package com.ttnet.org.chromium.net.impl;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum CronetEngineBuilderImpl$HttpCacheMode extends Enum<CronetEngineBuilderImpl$HttpCacheMode> {
    private static final /* synthetic */ CronetEngineBuilderImpl$HttpCacheMode[] $VALUES = null;
    public static final CronetEngineBuilderImpl$HttpCacheMode DISABLED = null;
    public static final CronetEngineBuilderImpl$HttpCacheMode DISK = null;
    public static final CronetEngineBuilderImpl$HttpCacheMode DISK_NO_HTTP = null;
    public static final CronetEngineBuilderImpl$HttpCacheMode MEMORY = null;
    private final boolean mContentCacheEnabled;
    private final int mType;

    static {
        CronetEngineBuilderImpl$HttpCacheMode r0 = new CronetEngineBuilderImpl$HttpCacheMode("DISABLED", 0, 0, false);
        DISABLED = r0;
        CronetEngineBuilderImpl$HttpCacheMode r1 = new CronetEngineBuilderImpl$HttpCacheMode("DISK", 1, 1, true);
        DISK = r1;
        CronetEngineBuilderImpl$HttpCacheMode r3 = new CronetEngineBuilderImpl$HttpCacheMode("DISK_NO_HTTP", 2, 1, false);
        DISK_NO_HTTP = r3;
        CronetEngineBuilderImpl$HttpCacheMode r5 = new CronetEngineBuilderImpl$HttpCacheMode("MEMORY", 3, 2, true);
        MEMORY = r5;
        $VALUES = new CronetEngineBuilderImpl$HttpCacheMode[]{r0, r1, r3, r5};
    }

    public static CronetEngineBuilderImpl$HttpCacheMode[] values() {
        return (CronetEngineBuilderImpl$HttpCacheMode[]) $VALUES.clone();
    }

    public int toPublicBuilderCacheMode() {
        int r0 = CronetEngineBuilderImpl.1.$SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[ordinal()];
        if (r0 == 1) goto L14;
        int r2 = 2;
        if (r0 == 2) goto L13;
        r2 = 3;
        if (r0 == 3) goto L13;
        if (r0 != 4) goto L12;
        return 1;
    L12:
        throw new IllegalArgumentException("Unknown internal builder cache mode");
    L13:
        return r2;
    L14:
        return 0;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isContentCacheEnabled() {
        return this.mContentCacheEnabled;
    }

    public static CronetEngineBuilderImpl$HttpCacheMode fromPublicBuilderCacheMode(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 != 3) goto L12;
        return DISK;
    L12:
        throw new IllegalArgumentException("Unknown public builder cache mode");
    L14:
        return DISK_NO_HTTP;
    L16:
        return MEMORY;
    L18:
        return DISABLED;
    }

    public static CronetEngineBuilderImpl$HttpCacheMode valueOf(String r1) {
        return (CronetEngineBuilderImpl$HttpCacheMode) a.a(CronetEngineBuilderImpl$HttpCacheMode.class, r1);
    }

    private CronetEngineBuilderImpl$HttpCacheMode(String r1, int r2, int r3, boolean r4) {
        super(r1, r2);
        this.mContentCacheEnabled = r4;
        this.mType = r3;
    }
}
