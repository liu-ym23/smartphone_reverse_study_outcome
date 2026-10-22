package com.ss.android.socialbase.downloader.constants;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum ListenerType extends Enum<ListenerType> {
    private static final /* synthetic */ ListenerType[] $VALUES = null;
    public static final ListenerType MAIN = null;
    public static final ListenerType NONE = null;
    public static final ListenerType NOTIFICATION = null;
    public static final ListenerType SUB = null;

    static {
        ListenerType r0 = new ListenerType("MAIN", 0);
        MAIN = r0;
        ListenerType r1 = new ListenerType("SUB", 1);
        SUB = r1;
        ListenerType r3 = new ListenerType("NOTIFICATION", 2);
        NOTIFICATION = r3;
        ListenerType r5 = new ListenerType("NONE", 3);
        NONE = r5;
        $VALUES = new ListenerType[]{r0, r1, r3, r5};
    }

    public static ListenerType[] values() {
        return (ListenerType[]) $VALUES.clone();
    }

    public static ListenerType valueOf(String r1) {
        return (ListenerType) a.a(ListenerType.class, r1);
    }

    private ListenerType(String r1, int r2) {
        super(r1, r2);
    }
}
