package com.ss.android.pushmanager.setting;

import com.bytedance.android.service.manager.push.settings.ISettingsUpdateListener;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.ss.android.message.AppProvider;
import j77.i;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static b c;
    public final Set<ISettingsUpdateListener> a;
    public Boolean b;

    public static b b() {
        if (c != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public final boolean a() {
        Boolean r0 = this.b;
        if (r0 != null) goto L5;
        Boolean r1 = Boolean.valueOf(d().Q());
        this.b = r1;
        return r1.booleanValue();
    L5:
        return r0.booleanValue();
    }

    public b() {
        this.a = new HashSet();
        this.b = null;
        PushMultiProcessSharedProvider.e(AppProvider.getApp());
    }

    public static LocalSettings c() {
        return (LocalSettings) i.a(AppProvider.getApp(), LocalSettings.class);
    }

    public static PushOnlineSettings d() {
        return (PushOnlineSettings) i.a(AppProvider.getApp(), PushOnlineSettings.class);
    }

    public static boolean e() {
        if (c().l() == true) goto L5;
    L7:
        return false;
    L5:
        if (d().l() == false) goto L7;
        return true;
    }

    public final void f(ISettingsUpdateListener r3) {
        Set<ISettingsUpdateListener> r0 = this.a;
        monitor-enter(r0);
        ((HashSet) this.a).add(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
