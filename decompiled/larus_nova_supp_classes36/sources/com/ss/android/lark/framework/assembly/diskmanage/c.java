package com.ss.android.lark.framework.assembly.diskmanage;

import android.text.TextUtils;
import com.ss.android.lark.diskmanage.smalldisk.settings.DiskStrategyConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.o0;
import e0c.k;
import ebb.g;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final AtomicBoolean a = null;

    public static final class a {
    }

    public static final class b {
        public static final c a = null;

        static {
            a = new c();
        }
    }

    public c() {
    }

    static {
        a = new AtomicBoolean(false);
    }

    public static void a() {
        if (a.get() == false) goto L6;
        return;
    L6:
        if (o0.a(LarkContext.getApplication()) == false) goto L18;
        Iterator<T> r0 = ((d) k.a(LarkContext.getApplication(), d.class)).a().iterator();
    L9:
        if (r0.hasNext() == false) goto L18;
        g r1 = (g) r0.next();
        int r2 = ebb.b.c;
        ebb.b r3 = ebb.b.b.a;
        monitor-enter(r3);
        Intrinsics.checkNotNullParameter(r1, "task");     // Catch: Throwable -> L15
        r3.a.put(r1.getBiz(), r1);     // Catch: Throwable -> L15
        monitor-exit(r3);
    L15:
        th = move-exception;
        throw th;
    L18:
        a.set(true);
    }

    public static cbb.d b() {
        eac.a r0 = eac.a.a();
        String r1 = r0.getString("key_disk_manage_setting", "");
        Log.i("DiskManageProvider", "startRemoteClean, settingJson: " + r1);
        cbb.d r2 = new cbb.d(0);
        if (TextUtils.isEmpty(r1) == true) goto L13;
        JSONObject r5 = new JSONObject(r1);     // Catch: Exception -> L8
        JSONObject r3 = r5.optJSONObject("global");     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L8
        cbb.c r6 = r2.a;     // Catch: Exception -> L8
        r6.a = r3.optLong("clean_interval");     // Catch: Exception -> L8
        r6.b = r3.optLong("idle_delay");     // Catch: Exception -> L8
        r6.c = r3.optLong("sdk_task_cost_limit");     // Catch: Exception -> L8
        r6.d = r3.optLong("task_cost_limit");     // Catch: Exception -> L8
        r6.e = r3.optLong("cache_time_limit");     // Catch: Exception -> L8
        r6.f = r3.optLong("auto_clean_max_times");     // Catch: Exception -> L8
        String r4 = r5.optString("cache_config");     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter(r4, "<set-?>");     // Catch: Exception -> L8
        r2.b = r4;     // Catch: Exception -> L8
        DiskStrategyConfig.parse(r4);     // Catch: Exception -> L8
        if (r0.getBoolean("small_disk_on", false) == false) goto L14;
        float r7 = r0.getFloat("disk_timeout_factor", 1.0f);     // Catch: Exception -> L8
        r6.a = (long) (r6.a * r7);     // Catch: Exception -> L8
        r6.e = (long) (r6.e * r7);     // Catch: Exception -> L8
        return r2;
    L14:
        return r2;
    L8:
        e = move-exception;
        cbb.d r8 = new cbb.d(0);
        Log.e("DiskManageProvider", "parse remote config failed: " + e);
        return r8;
    L13:
        return r2;
    }
}
