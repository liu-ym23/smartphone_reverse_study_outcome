package fg;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final Gson e = null;
    public static volatile c f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f16897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap f16898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantReadWriteLock f16899c;
    public Context d;

    static {
        e = new Gson();
    }

    public c() {
        this.f16897a = null;
        this.f16898b = null;
        this.f16899c = new ReentrantReadWriteLock();
        this.d = null;
    }

    public static c a() {
        if (f != null) goto L16;
        monitor-enter(c.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L11;
        f = new c();     // Catch: Throwable -> L9
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L16:
        return f;
    }

    public static HashMap b(String r10) {
        if (r10 != null) goto L24;
    L21:
        return null;
    L24:
        Gson r5 = e;     // Catch: Throwable -> L14 Throwable -> L16
        JsonElement r11 = (JsonElement) r5.fromJson(r10, JsonElement.class);     // Catch: Throwable -> L14 Throwable -> L16
        if (r11 == null) goto L21;
        HashMap r12 = (HashMap) r5.fromJson(r11.getAsJsonObject(), HashMap.class);     // Catch: Throwable -> L14 Throwable -> L16
        LynxLog.b(2, "LynxSettingsManager", "Lynx load local cached settings success");     // Catch: Throwable -> L10 Throwable -> L12
        return r12;
    L12:
        Object e4 = e;
    L19:
        LynxLog.b(4, "LynxSettingsManager", "Lynx settings initialize exception " + e4);
    L20:
        return r12;
    L10:
        Object th2 = th;
    L18:
        LynxLog.b(4, "LynxSettingsManager", "Lynx settings unexpected exception " + th2);
        goto L20
    L16:
        e = move-exception;
        e4 = e;
        r12 = null;
    L14:
        th = move-exception;
        th2 = th;
        r12 = null;
        goto L18
    }

    public final void c(JsonObject r10, long r11) {
        String r5 = r10.toString();
        jk.a r12 = jk.a.m();
        Integer r13 = Integer.valueOf((int) r11);
        Context r14 = this.d;
        r12.getClass();
        Log.i("VmSdkSettingsManager", "setSettingsWithTime " + r5);
        Gson r15 = new Gson();     // Catch: Throwable -> L7
        JsonElement r16 = (JsonElement) r15.fromJson(r5, JsonElement.class);     // Catch: Throwable -> L7
        if (r16 == null) goto L10;
        r12.f18351c = (HashMap) r15.fromJson(r16.getAsJsonObject(), HashMap.class);     // Catch: Throwable -> L7
    L10:
        if (((Context) r12.e) != null) goto L14;
        if (r14 == null) goto L14;
        r12.e = r14;
    L14:
        if (((Context) r12.e) == null) goto L28;
        monitor-enter(r12);
        r12.f18350b = r13;     // Catch: Throwable -> L24
        SharedPreferences r17 = (SharedPreferences) r12.f18349a;     // Catch: Throwable -> L24
        if (r17 != null) goto L26;
        Context r18 = (Context) r12.e;     // Catch: Throwable -> L24
        r12.e = r18;     // Catch: Throwable -> L24
        if (r17 != null) goto L23;
        r17 = r18.getSharedPreferences("vmsdk_settings_manager_sp", 0);     // Catch: Throwable -> L24
    L23:
        r12.f18349a = r17;     // Catch: Throwable -> L24
    L26:
        ((SharedPreferences) r12.f18349a).edit().putString("vmsdk_settings", r5).apply();     // Catch: Throwable -> L24
        ((SharedPreferences) r12.f18349a).edit().putInt("vmsdk_settings_time", ((Integer) r12.f18350b).intValue()).apply();     // Catch: Throwable -> L24
        monitor-exit(r12);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    L28:
        monitor-enter(this);
        SharedPreferences r19 = this.f16897a;     // Catch: Throwable -> L32
        if (r19 == null) goto L34;
        r19.edit().putString("settings", r5).putLong("settings_time", r11).apply();     // Catch: Throwable -> L32
    L34:
        monitor-exit(this);     // Catch: Throwable -> L32
        d((HashMap) e.fromJson(r10, HashMap.class));
        return;
    L32:
        th = move-exception;
        throw th;
    L7:
        th = move-exception;
        Log.e("VmSdkSettingsManager", "setSettingsWithTime exception " + th.toString());
        goto L10
    }

    public final void d(HashMap r5) {
        ReentrantReadWriteLock r10 = this.f16899c;
        r10.readLock().lock();
        HashMap r11 = this.f16898b;
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        r10.readLock().unlock();
        if (r12 == false) goto L13;
        r10.writeLock().lock();
        this.f16898b = r5;
        r10.writeLock().unlock();
        LynxEnv.inst().setSettings(this.f16898b);
        return;
    L13:
        LynxLog.b(2, "LynxSettingsManager", "settings hash not changed");
        return;
    L5:
        if (r11.equals(r5) == false) goto L8;
        r12 = false;
        goto L9
    }

    public final String e() {
        SharedPreferences r5 = this.f16897a;
        if (r5 != null) goto L7;
        LynxLog.b(4, "LynxSettingsManager", "please call initialize first");
        return null;
    L7:
        if (r5.contains("settings") == true) goto L15;
        LynxLog.b(2, "LynxSettingsManager", "Lynx load local cached settings: no cached.");
        return null;
    L15:
        return this.f16897a.getString("settings", "");
    L12:
        e = move-exception;
        LynxLog.b(4, "LynxSettingsManager", "Lynx load local cached settings exception " + e);
        return null;
    }
}
