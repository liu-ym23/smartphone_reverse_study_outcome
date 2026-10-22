package com.ss.android.lark.feed.shared.data.utils;

import android.app.Application;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public static final Map<String, String> a = null;
    public static c7c.a b;

    static {
        a = new ConcurrentHashMap();
    }

    public static String a(long r3) {
        if (r3 != 0) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        Application r0 = LarkContext.getApplication();
        Date r1 = new Date(r3);
        if (b != null) goto L22;
        monitor-enter(f.class);
        heb.a.a.getSettingDependency().a();     // Catch: Throwable -> L18
        c7c.a r4 = b;     // Catch: Throwable -> L18
        if (r4 != null) goto L12;
    L15:
        c7c.a r5 = new c7c.a();     // Catch: Throwable -> L18
        r5.b(DisplayPattern.RELATIVE);     // Catch: Throwable -> L18
        r5.c(LengthType.SHORT);     // Catch: Throwable -> L18
        r5.d(TimePreciseness.MINUTE);     // Catch: Throwable -> L18
        r5.j = true;     // Catch: Throwable -> L18
        r5.h = false;     // Catch: Throwable -> L18
        b = r5;     // Catch: Throwable -> L18
        ((ConcurrentHashMap) a).clear();     // Catch: Throwable -> L18
        monitor-exit(f.class);
        goto L22
    L12:
        if (r4.h == true) goto L15;
        monitor-exit(f.class);
    L18:
        th = move-exception;
        throw th;
    L22:
        return c7c.b.c(r0, r1, b);
    }

    public static void b(UIFeedCard r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.getId() == null) goto L8;
        Map<String, String> r0 = a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.put(r4.getId(), a(r4.getDisplayTime()));
        return;
    }
}
