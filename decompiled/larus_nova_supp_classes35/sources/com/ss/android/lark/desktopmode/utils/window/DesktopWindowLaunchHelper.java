package com.ss.android.lark.desktopmode.utils.window;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DesktopWindowLaunchHelper {
    public static final Lazy<DesktopWindowLaunchHelper> a = null;

    public static final class a {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DesktopWindowLaunchHelper$Companion$instance$2.INSTANCE);
    }

    public DesktopWindowLaunchHelper() {
    }
}
