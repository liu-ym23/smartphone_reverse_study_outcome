package com.bytedance.news.common.settings.a;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.news.common.settings.api.f;
import com.bytedance.news.common.settings.api.i;
import com.bytedance.services.apm.api.IEnsure;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f2914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences.Editor f2915b;
    private IEnsure c;

    public d(Context r7, String r8, boolean r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        SettingsConfigProvider r0 = (SettingsConfigProvider) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(SettingsConfigProvider.class), SettingsConfigProvider.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L30:
    L11:
        e = move-exception;
        if (a(r10) == true) goto L15;
        throw e;
    L15:
        if (Build.VERSION.SDK_INT < 24) goto L27;
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.createDeviceProtectedStorageContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r11.moveSharedPreferencesFrom(r10, r8 + ".sp") == true) goto L25;
        if (r0 == null) goto L25;
        if (r0.getConfig() == null) goto L25;
        f r12 = r0.getConfig().f();
        if (r12 == null) goto L25;
        r12.b("SharedPreferenceStorage", "Failed to migrate shared preferences = " + r8 + ".sp");
    L25:
        if (this.f2914a != null) goto L27;
        this.f2914a = r11.getSharedPreferences(r8 + ".sp", 0);
    L27:
        this.f2915b = this.f2914a.edit();
        this.c = (IEnsure) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IEnsure.class), IEnsure.class, "com.obric.memorydata.plugin");
        return;
    L8:
        if (this.f2914a != null) goto L27;
        this.f2914a = r10.getSharedPreferences(r8 + ".sp", 0);     // Catch: IllegalStateException -> L11
        goto L27
    L5:
        if (r0.getConfig() == null) goto L30;
        this.f2914a = r0.getConfig().a(r10, r8 + ".sp", 0, r9);
        goto L30
    }

    private void a(Exception r1) {
        IEnsure r0 = this.c;
        if (r0 == null) goto L6;
        r0.reportLogException(r1);
        return;
    }

    private static boolean a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        DevicePolicyManager r6 = (DevicePolicyManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("device_policy"), DevicePolicyManager.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L18;
        int r7 = r6.getStorageEncryptionStatus();     // Catch: IllegalStateException -> L13
        if (r7 == 5) goto L20;
        if (r7 == 3) goto L20;
        return false;
    L20:
        return true;
    L13:
        e = move-exception;
        e.printStackTrace();
        return false;
    L18:
        return false;
    }

    @Override // com.bytedance.news.common.settings.api.i
    public String a(String r2) {
        return b(r2, "");
    }

    @Override // com.bytedance.news.common.settings.api.i
    public void a() {
        this.f2915b.apply();
    }

    @Override // com.bytedance.news.common.settings.api.i
    public void a(String r1, String r2) {
        this.f2915b.putString(r1, r2);
    }

    @Override // com.bytedance.news.common.settings.api.i
    public String b(String r2, String r3) {
        return this.f2914a.getString(r2, r3);
    L4:
        e = move-exception;
        a(e);
        return r3;
    }

    @Override // com.bytedance.news.common.settings.api.i
    public boolean b(String r1) {
        return this.f2914a.contains(r1);
    }
}
