package j4;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.services.apm.api.IEnsure;
import f4.e;
import f4.h;

/* JADX INFO: loaded from: classes.dex */
class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f9766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences.Editor f9767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IEnsure f9768c;

    public d(Context r10, String r11, boolean r12) {
        SettingsConfigProvider r13 = (SettingsConfigProvider) c4.d.a(SettingsConfigProvider.class);
        if (r13 != null) goto L5;
    L30:
    L11:
        e = move-exception;
        if (b(r10) == true) goto L15;
        throw e;
    L15:
        if (Build.VERSION.SDK_INT < 24) goto L27;
        Context r14 = r10.createDeviceProtectedStorageContext();
        if (r14.moveSharedPreferencesFrom(r10, r11 + ".sp") == true) goto L25;
        if (r13 == null) goto L25;
        if (r13.getConfig() == null) goto L25;
        e r15 = r13.getConfig().k();
        if (r15 == null) goto L25;
        r15.e("SharedPreferenceStorage", "Failed to migrate shared preferences = " + r11 + ".sp");
    L25:
        if (this.f9766a != null) goto L27;
        this.f9766a = r14.getSharedPreferences(r11 + ".sp", 0);
    L27:
        this.f9767b = this.f9766a.edit();
        this.f9768c = (IEnsure) c4.d.a(IEnsure.class);
        return;
    L8:
        if (this.f9766a != null) goto L27;
        this.f9766a = r10.getSharedPreferences(r11 + ".sp", 0);     // Catch: IllegalStateException -> L11
        goto L27
    L5:
        if (r13.getConfig() == null) goto L30;
        this.f9766a = r13.getConfig().l(r10, r11 + ".sp", 0, r12);
        goto L30
    }

    private static boolean b(Context r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        DevicePolicyManager r11 = (DevicePolicyManager) r10.getSystemService("device_policy");
        if (r11 == null) goto L18;
        int r12 = r11.getStorageEncryptionStatus();     // Catch: IllegalStateException -> L13
        if (r12 == 5) goto L20;
        if (r12 == 3) goto L20;
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

    private void c(Exception r10) {
        IEnsure r11 = this.f9768c;
        if (r11 == null) goto L6;
        r11.reportLogException(r10);
        return;
    }

    @Override // f4.h
    public String a(String r10) {
        return getString(r10, "");
    }

    @Override // f4.h
    public void apply() {
        this.f9767b.apply();
    }

    @Override // f4.h
    public boolean contains(String r10) {
        return this.f9766a.contains(r10);
    }

    @Override // f4.h
    public String getString(String r10, String r11) {
        return this.f9766a.getString(r10, r11);
    L4:
        e = move-exception;
        c(e);
        return r11;
    }

    @Override // f4.h
    public void putString(String r10, String r11) {
        this.f9767b.putString(r10, r11);
    }
}
