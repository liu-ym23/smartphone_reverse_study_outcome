package com.ss.android.deviceregister;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.bytedance.bdinstall.migrate.MigrateDetector;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f15221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PackageManager f15222b;
    private final ComponentName c;
    private final boolean d;

    n(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.f15221a = r0.getSharedPreferences("device_register_migrate_detector", 0);
        this.f15222b = r0.getPackageManager();
        this.c = new ComponentName(r5, AActivity.class);
        boolean r6 = d();
        this.d = r6;
        l.b(l.f15219a, "MigrateDetector#constructor migrate=" + r6);
    }

    private static String a(int r1) {
        if (r1 != 0) goto L4;
        return "STATE_DEFAULT";
    L4:
        if (r1 != 1) goto L6;
        return "STATE_ENABLED";
    L6:
        if (r1 == 2) goto L9;
        return "UNKNOWN";
    L9:
        return "STATE_DISABLED";
    }

    private int c() {
        return this.f15222b.getComponentEnabledSetting(this.c);
    }

    private boolean d() {
        int r0 = c();
        int r5 = this.f15221a.getInt(MigrateDetector.KEY_COMPONENT_STATE, 0);
        l.b(l.f15219a, "MigrateDetector#isMigrateInternal cs=" + a(r0) + " ss=" + a(r5));
        if (r0 == 0) goto L5;
    L8:
        return false;
    L5:
        if (r5 != 2) goto L8;
        return true;
    }

    void a() {
        l.b(l.f15219a, "MigrateDetector#disableComponent");
        ZeusTransformUtils.setComponentEnabledSetting(this.f15222b, this.c, 2, 1);
        this.f15221a.edit().putInt(MigrateDetector.KEY_COMPONENT_STATE, 2).apply();
    }

    boolean b() {
        return this.d;
    }
}
