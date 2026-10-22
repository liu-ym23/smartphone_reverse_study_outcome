package com.ss.android.lark.chameleon.pluginsystem.plugin.lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum PluginMountStrategy extends Enum<PluginMountStrategy> {
    private static final /* synthetic */ PluginMountStrategy[] $VALUES = null;
    public static final PluginMountStrategy FirstFind = null;
    public static final PluginMountStrategy FirstJSCall = null;
    public static final PluginMountStrategy Immediate = null;
    public static final PluginMountStrategy LoadFinish = null;

    static {
        PluginMountStrategy r0 = new PluginMountStrategy("Immediate", 0);
        Immediate = r0;
        PluginMountStrategy r1 = new PluginMountStrategy("FirstFind", 1);
        FirstFind = r1;
        PluginMountStrategy r3 = new PluginMountStrategy("FirstJSCall", 2);
        FirstJSCall = r3;
        PluginMountStrategy r5 = new PluginMountStrategy("LoadFinish", 3);
        LoadFinish = r5;
        $VALUES = new PluginMountStrategy[]{r0, r1, r3, r5};
    }

    public static PluginMountStrategy[] values() {
        return (PluginMountStrategy[]) $VALUES.clone();
    }

    public static PluginMountStrategy valueOf(String r1) {
        return (PluginMountStrategy) r27.a.a(PluginMountStrategy.class, r1);
    }

    private PluginMountStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
