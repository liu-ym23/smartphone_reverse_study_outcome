package com.ss.android.lark.integrator.security.compliance.screenshotprotection;

import dagger.internal.Factory;
import inb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ScreenshotProtectionModuleDependency_Factory implements Factory<b> {

    public static final class a {
        public static final ScreenshotProtectionModuleDependency_Factory a = null;

        static {
            a = new ScreenshotProtectionModuleDependency_Factory();
        }
    }

    public ScreenshotProtectionModuleDependency_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public b get() {
        return newInstance();
    }

    public static ScreenshotProtectionModuleDependency_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m956get() {
        return get();
    }
}
