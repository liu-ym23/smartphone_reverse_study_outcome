package com.bytedance.ies.abmock.datacenter.storage;

import android.util.Log;
import com.bytedance.keva.Keva;

/* JADX INFO: loaded from: classes2.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f2731a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static boolean f2732b = false;
    static boolean c = false;

    static {
        a();
    }

    private static void a() {
        Keva r0 = b();
        f2731a = r0.getBoolean("key_opt_open", false);
        f2732b = r0.getBoolean("key_keva_single_mode", false);
        c = r0.getBoolean("key_using_skip_lock", false);
        Log.i("UnregisteredRepo", "restoreNewFromKeva usingNewRepo:" + f2731a + " usingNewRepoSingleKeva:" + f2732b + " usingNewRepoSkipLock:" + c);
    }

    static void a(boolean r2, boolean r3, boolean r4) {
        Log.i("UnregisteredRepo", "storeNewModeToKeva newMode:" + r2 + " newModeSingleProcess:" + r3 + " newModeSkipLock:" + r4);
        Keva r0 = b();
        r0.storeBoolean("key_opt_open", r2);
        r0.storeBoolean("key_keva_single_mode", r3);
        r0.storeBoolean("key_using_skip_lock", r4);
    }

    private static Keva b() {
        return Keva.getRepoSync("repo_unregistered_opt_libra_config", 0);
    }
}
