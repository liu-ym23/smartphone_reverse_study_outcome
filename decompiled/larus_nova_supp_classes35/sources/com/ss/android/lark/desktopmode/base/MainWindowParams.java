package com.ss.android.lark.desktopmode.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MainWindowParams extends FragmentParams {
    private final String tabName;

    public static class a extends FragmentParams.a<a, MainWindowParams> {
    }

    public String getTabName() {
        return this.tabName;
    }

    public MainWindowParams(a r1) {
        throw null;
    }

    public MainWindowParams(ContainerType r2, String r3) {
        super(r2, false);
        this.tabName = r3;
    }
}
