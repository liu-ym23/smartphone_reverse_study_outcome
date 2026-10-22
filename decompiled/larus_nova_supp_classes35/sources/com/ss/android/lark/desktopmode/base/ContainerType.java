package com.ss.android.lark.desktopmode.base;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType ALL = null;
    public static final ContainerType Drawer = null;
    public static final ContainerType Float = null;
    public static final ContainerType Left = null;
    public static final ContainerType Right = null;
    public static final /* synthetic */ ContainerType[] a = null;

    static {
        ContainerType r0 = new ContainerType("Float", 0);
        Float = r0;
        ContainerType r1 = new ContainerType("Left", 1);
        Left = r1;
        ContainerType r3 = new ContainerType("Right", 2);
        Right = r3;
        ContainerType r5 = new ContainerType("ALL", 3);
        ALL = r5;
        ContainerType r7 = new ContainerType("Drawer", 4);
        Drawer = r7;
        a = new ContainerType[]{r0, r1, r3, r5, r7};
    }

    public static ContainerType[] values() {
        return (ContainerType[]) a.clone();
    }

    public static ContainerType valueOf(String r1) {
        return (ContainerType) a.a(ContainerType.class, r1);
    }

    public ContainerType(String r1, int r2) {
        super(r1, r2);
    }
}
