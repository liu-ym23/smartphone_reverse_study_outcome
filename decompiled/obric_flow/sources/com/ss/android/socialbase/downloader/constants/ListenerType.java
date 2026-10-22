package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes3.dex */
public final enum ListenerType extends Enum<ListenerType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ListenerType f15280a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ListenerType f15281b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ListenerType f15282c = null;
    public static final ListenerType d = null;
    public static final /* synthetic */ ListenerType[] e = null;

    static {
        ListenerType r5 = new ListenerType("MAIN", 0);
        f15280a = r5;
        ListenerType r10 = new ListenerType("SUB", 1);
        f15281b = r10;
        ListenerType r11 = new ListenerType("NOTIFICATION", 2);
        f15282c = r11;
        ListenerType r12 = new ListenerType("NONE", 3);
        d = r12;
        e = new ListenerType[]{r5, r10, r11, r12};
    }

    public ListenerType(String r5, int r10) {
        super(r5, r10);
    }

    public static ListenerType valueOf(String r5) {
        return (ListenerType) Enum.valueOf(ListenerType.class, r5);
    }

    public static ListenerType[] values() {
        return (ListenerType[]) e.clone();
    }
}
