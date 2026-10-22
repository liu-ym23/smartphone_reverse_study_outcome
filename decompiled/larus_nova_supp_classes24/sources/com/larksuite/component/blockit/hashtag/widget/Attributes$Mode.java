package com.larksuite.component.blockit.hashtag.widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum Attributes$Mode extends Enum<Attributes$Mode> {
    public static final Attributes$Mode Multiple = null;
    public static final Attributes$Mode Single = null;
    public static final /* synthetic */ Attributes$Mode[] a = null;

    static {
        Attributes$Mode r0 = new Attributes$Mode("Single", 0);
        Single = r0;
        Attributes$Mode r1 = new Attributes$Mode("Multiple", 1);
        Multiple = r1;
        a = new Attributes$Mode[]{r0, r1};
    }

    public static Attributes$Mode[] values() {
        return (Attributes$Mode[]) a.clone();
    }

    public static Attributes$Mode valueOf(String r1) {
        return (Attributes$Mode) r27.a.a(Attributes$Mode.class, r1);
    }

    public Attributes$Mode(String r1, int r2) {
        super(r1, r2);
    }
}
