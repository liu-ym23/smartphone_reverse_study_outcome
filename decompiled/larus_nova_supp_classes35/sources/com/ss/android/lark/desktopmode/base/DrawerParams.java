package com.ss.android.lark.desktopmode.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DrawerParams extends FragmentParams {
    private final boolean dimBehind;
    private final int drawerWidth;

    public static final class a extends FragmentParams.a<a, DrawerParams> {
    }

    public int getDrawerWidth() {
        return this.drawerWidth;
    }

    public boolean isDimBehind() {
        return this.dimBehind;
    }

    public DrawerParams(boolean r3) {
        super(ContainerType.Drawer, false);
        this.dimBehind = r3;
        this.drawerWidth = 320;
    }

    public DrawerParams(a r1) {
        ContainerType r2 = ContainerType.Float;
        throw null;
    }

    public DrawerParams(boolean r3, int r4) {
        super(ContainerType.Drawer, false);
        this.dimBehind = r3;
        this.drawerWidth = r4;
    }
}
