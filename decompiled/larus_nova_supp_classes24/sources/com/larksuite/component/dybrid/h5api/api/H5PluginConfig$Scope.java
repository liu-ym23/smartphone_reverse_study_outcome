package com.larksuite.component.dybrid.h5api.api;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum H5PluginConfig$Scope extends Enum<H5PluginConfig$Scope> {
    public static final H5PluginConfig$Scope PAGE = null;
    public static final H5PluginConfig$Scope SERVICE = null;
    public static final H5PluginConfig$Scope SESSION = null;
    public static final /* synthetic */ H5PluginConfig$Scope[] a = null;

    static {
        H5PluginConfig$Scope r0 = new H5PluginConfig$Scope("SERVICE", 0);
        SERVICE = r0;
        H5PluginConfig$Scope r1 = new H5PluginConfig$Scope("SESSION", 1);
        SESSION = r1;
        H5PluginConfig$Scope r3 = new H5PluginConfig$Scope("PAGE", 2);
        PAGE = r3;
        a = new H5PluginConfig$Scope[]{r0, r1, r3};
    }

    public static H5PluginConfig$Scope[] values() {
        return (H5PluginConfig$Scope[]) a.clone();
    }

    public static H5PluginConfig$Scope valueOf(String r1) {
        return (H5PluginConfig$Scope) a.a(H5PluginConfig$Scope.class, r1);
    }

    public H5PluginConfig$Scope(String r1, int r2) {
        super(r1, r2);
    }
}
