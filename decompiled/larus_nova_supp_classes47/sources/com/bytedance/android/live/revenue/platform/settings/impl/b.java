package com.bytedance.android.live.revenue.platform.settings.impl;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static volatile boolean a;

    public static final class a implements com.bytedance.tools.kcp.ultrasettings.runtime.b {
        public a() {
        }

        public final <T> ReadOnlyProperty<Object, T> a(final String r4, final T r5, final Type r6, final boolean r7, KProperty<?> r8) {
            Intrinsics.checkNotNullParameter(r4, "name");
            Intrinsics.checkNotNullParameter(r6, "type");
            Intrinsics.checkNotNullParameter(r8, "property");
            Boolean r9 = f.a;
            Intrinsics.checkNotNullParameter(r4, "name");
            Intrinsics.checkNotNullParameter(r6, "type");
            return new d(new UltraSettingsServiceImpl$createUltraSettings$1(r4, r5, r6, r7));
        }
    }

    public static void a() {
        if (a == false) goto L5;
        return;
    L5:
        ConcurrentHashMap r0 = UltraSettingsManager.a;
        a r1 = new a();
        Intrinsics.checkNotNullParameter(r1, "factory");
        UltraSettingsManager.b = r1;
        a = true;
    }

    static {
    }
}
