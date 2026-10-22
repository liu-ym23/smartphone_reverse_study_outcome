package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o1 {
    public static final ConcurrentHashMap<Integer, Long> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static Long a(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return null;
    L12:
        return a.get(Integer.valueOf(r1.hashCode()));
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void c(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        a.remove(Integer.valueOf(r2.hashCode()));
        Log.i("[URLPreview]CacheTime", "remove inline,card startTime,previewId: ".concat(r2));
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void b(String r1, Long r2) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        if (r2 == null) goto L14;
        a.put(Integer.valueOf(r1.hashCode()), r2);
        return;
    L14:
        return;
    L13:
        return;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void d(String r3, Long r4) {
        int r0 = ChatCoreModule.a().getWschannelDependency().getCurNetWorkLevel().getValue();
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (r0 >= 4) goto L16;
        Log.i("[URLPreview]CacheTime", " key:" + r3 + ",saveFirstStartTime: " + r4 + ",netStatus:" + r0);
        b(r3, r4);
        return;
    L16:
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
