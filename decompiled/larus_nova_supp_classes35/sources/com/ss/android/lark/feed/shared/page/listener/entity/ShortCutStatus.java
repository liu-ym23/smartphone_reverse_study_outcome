package com.ss.android.lark.feed.shared.page.listener.entity;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum ShortCutStatus extends Enum<ShortCutStatus> {
    public static final ShortCutStatus CLOSE = null;
    public static final ShortCutStatus OPEN = null;
    public static final ShortCutStatus OPENDING = null;
    public static final /* synthetic */ ShortCutStatus[] a = null;
    private int value;

    static {
        ShortCutStatus r0 = new ShortCutStatus("OPEN", 0, 1);
        OPEN = r0;
        ShortCutStatus r1 = new ShortCutStatus("OPENDING", 1, 2);
        OPENDING = r1;
        ShortCutStatus r4 = new ShortCutStatus("CLOSE", 2, 3);
        CLOSE = r4;
        a = new ShortCutStatus[]{r0, r1, r4};
    }

    public static ShortCutStatus[] values() {
        return (ShortCutStatus[]) a.clone();
    }

    public static ShortCutStatus valueOf(String r1) {
        return (ShortCutStatus) a.a(ShortCutStatus.class, r1);
    }

    public ShortCutStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
