package com.larus.settings.performance;

import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final e a = null;
    public static final /* synthetic */ KProperty<Object>[] b = null;
    public static final a c = null;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.settings.performance.b, java.lang.Object] */
    static {
        b = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "systemBatteryRecorderConfig", "getSystemBatteryRecorderConfig()Lcom/larus/settings/performance/SystemBatteryRecorderConfig;", 0))};
        a = new e();
        ?? r0 = new b();
        Intrinsics.checkNotNullParameter(r0, "initializer");
        c = new a(r0);
    }

    public e() {
    }

    public static SystemBatteryRecorderConfig b() {
        int r0 = l0.a;
        SystemBatteryRecorderConfig r1 = (SystemBatteryRecorderConfig) l0.a(new SystemBatteryRecorderConfig(false, false, 0, 0, null, null, 63, null), new c());
        FLogger.a.i("PerfSettings", "systemBatteryRecorderConfig: " + r1);
        return r1;
    }

    public final SystemBatteryRecorderConfig a() {
        return (SystemBatteryRecorderConfig) c.getValue(this, b[0]);
    }
}
