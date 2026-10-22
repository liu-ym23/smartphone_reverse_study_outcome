package com.bytedance.android.live.emoji.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.live.user.IUserService;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static a c;
    public static volatile String d;
    public final SharedPreferences a;
    public final SharedPreferences b;

    public static synchronized a a() {
        monitor-enter(a.class);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (k.f(IUserService.class) == null) goto L7;
        String r1 = k.f(IUserService.class).user().n();     // Catch: Throwable -> L26
    L9:
        if (c == null) goto L13;
        if (TextUtils.equals(r1, d) == false) goto L13;
    L20:
        a r2 = c;     // Catch: Throwable -> L26
        monitor-exit(a.class);
        return r2;
    L13:
        monitor-enter(a.class);     // Catch: Throwable -> L26
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L15:
        if (c != null) goto L17;
    L18:
        c = new a();     // Catch: Throwable -> L23
    L19:
        monitor-exit(a.class);     // Catch: Throwable -> L23
    L17:
        if (TextUtils.equals(r1, d) == true) goto L19;
    L7:
        r1 = "0";
        goto L9
    }

    public a() {
        if (k.f(IUserService.class) == null) goto L5;
        d = k.f(IUserService.class).user().n();
    L6:
        this.a = jc1.a.b().getSharedPreferences("aweme_emoji_" + d, 0);
        this.b = jc1.a.b().getSharedPreferences("aweme_emoji", 0);
        return;
    L5:
        d = "0";
        goto L6
    }
}
