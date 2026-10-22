package com.ss.android.lark.desktopmode.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LeftWindowParams extends MainWindowParams {
    public static final int TAB_LEFT_WIDTH_IN_DP = 300;
    private final int tabWidth;

    public static final class a extends MainWindowParams.a {
    }

    public int getTabWidth() {
        return this.tabWidth;
    }

    public LeftWindowParams(a r1) {
        super(r1);
        throw null;
    }

    public LeftWindowParams(ContainerType r1, String r2, int r3) {
        super(r1, r2);
        this.tabWidth = r3;
    }
}
