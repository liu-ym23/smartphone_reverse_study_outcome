package com.ss.android.lark.maincore;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum TabType extends Enum<TabType> {
    public static final TabType Main = null;
    public static final TabType Navigation = null;
    public static final TabType Others = null;
    public static final /* synthetic */ TabType[] a = null;

    static {
        TabType r0 = new TabType("Main", 0);
        Main = r0;
        TabType r1 = new TabType("Navigation", 1);
        Navigation = r1;
        TabType r3 = new TabType("Others", 2);
        Others = r3;
        a = new TabType[]{r0, r1, r3};
    }

    public static TabType[] values() {
        return (TabType[]) a.clone();
    }

    public static TabType valueOf(String r1) {
        return (TabType) a.a(TabType.class, r1);
    }

    public TabType(String r1, int r2) {
        super(r1, r2);
    }
}
