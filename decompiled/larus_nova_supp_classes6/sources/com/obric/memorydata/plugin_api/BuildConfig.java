package com.obric.memorydata.plugin_api;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class BuildConfig {
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String LIBRARY_PACKAGE_NAME = "com.obric.memorydata.plugin_api";
    public static final String PLUGIN_API_VERSION_NAME = null;
    public static final String PLUGIN_PKG_NAME = "com.obric.memorydata.plugin";
    public static final int PLUGIN_VERSION_CODE = 0;
    public static final String PLUGIN_VERSION_NAME = null;

    public BuildConfig() {
    }

    static {
        PLUGIN_API_VERSION_NAME = new String("15.2.0.72");
        PLUGIN_VERSION_CODE = CastIntegerProtector.parseInt("150200101");
        PLUGIN_VERSION_NAME = new String("15.2.0.1.1");
    }
}
