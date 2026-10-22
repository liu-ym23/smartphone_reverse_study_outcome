package com.ss.ugc.live.sdk.msg.dispatch;

import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j {
    public static final Set<Long> a = null;
    public static final Map<Long, Map<String, xlc.b>> b = null;
    public static final Map<Long, Map<String, tlc.c>> c = null;

    static {
        a = new CopyOnWriteArraySet();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public static String a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, TabAppInfo.IMAGE_JSON_KEY);
        if (r2 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return r1;
    L12:
        return r1 + "_" + r2;
    L5:
        if (r2.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
