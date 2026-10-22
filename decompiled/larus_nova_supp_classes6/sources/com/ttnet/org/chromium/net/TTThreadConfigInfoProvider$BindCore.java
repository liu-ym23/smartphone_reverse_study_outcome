package com.ttnet.org.chromium.net;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum TTThreadConfigInfoProvider$BindCore extends Enum<TTThreadConfigInfoProvider$BindCore> {
    private static final /* synthetic */ TTThreadConfigInfoProvider$BindCore[] $VALUES = null;
    public static final TTThreadConfigInfoProvider$BindCore BIG_CORE = null;
    public static final TTThreadConfigInfoProvider$BindCore CANCEL_BIND = null;
    public static final TTThreadConfigInfoProvider$BindCore DEFAULT = null;
    public static final TTThreadConfigInfoProvider$BindCore LITTLE_CORE = null;

    static {
        TTThreadConfigInfoProvider$BindCore r0 = new TTThreadConfigInfoProvider$BindCore("DEFAULT", 0);
        DEFAULT = r0;
        TTThreadConfigInfoProvider$BindCore r1 = new TTThreadConfigInfoProvider$BindCore("BIG_CORE", 1);
        BIG_CORE = r1;
        TTThreadConfigInfoProvider$BindCore r3 = new TTThreadConfigInfoProvider$BindCore("LITTLE_CORE", 2);
        LITTLE_CORE = r3;
        TTThreadConfigInfoProvider$BindCore r5 = new TTThreadConfigInfoProvider$BindCore("CANCEL_BIND", 3);
        CANCEL_BIND = r5;
        $VALUES = new TTThreadConfigInfoProvider$BindCore[]{r0, r1, r3, r5};
    }

    public static TTThreadConfigInfoProvider$BindCore[] values() {
        return (TTThreadConfigInfoProvider$BindCore[]) $VALUES.clone();
    }

    public static TTThreadConfigInfoProvider$BindCore valueOf(String r1) {
        return (TTThreadConfigInfoProvider$BindCore) a.a(TTThreadConfigInfoProvider$BindCore.class, r1);
    }

    private TTThreadConfigInfoProvider$BindCore(String r1, int r2) {
        super(r1, r2);
    }
}
