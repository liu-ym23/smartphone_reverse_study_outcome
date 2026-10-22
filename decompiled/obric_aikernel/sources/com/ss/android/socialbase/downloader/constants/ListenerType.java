package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes2.dex */
public final enum ListenerType extends Enum<ListenerType> {
    private static final /* synthetic */ ListenerType[] $VALUES = null;
    public static final ListenerType MAIN = null;
    public static final ListenerType NONE = null;
    public static final ListenerType NOTIFICATION = null;
    public static final ListenerType SUB = null;

    static {
        ListenerType r10 = new ListenerType("MAIN", 0);
        MAIN = r10;
        ListenerType r11 = new ListenerType("SUB", 1);
        SUB = r11;
        ListenerType r12 = new ListenerType("NOTIFICATION", 2);
        NOTIFICATION = r12;
        ListenerType r13 = new ListenerType("NONE", 3);
        NONE = r13;
        $VALUES = new ListenerType[]{r10, r11, r12, r13};
    }

    private ListenerType(String r10, int r11) {
        super(r10, r11);
    }

    public static ListenerType valueOf(String r10) {
        return (ListenerType) Enum.valueOf(ListenerType.class, r10);
    }

    public static ListenerType[] values() {
        return (ListenerType[]) $VALUES.clone();
    }
}
