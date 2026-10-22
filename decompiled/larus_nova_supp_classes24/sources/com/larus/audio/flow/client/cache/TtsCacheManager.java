package com.larus.audio.flow.client.cache;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import m58.h;
import m58.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class TtsCacheManager {
    public static final Lazy a = null;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static boolean f;
    public static String g;
    public static volatile boolean h;
    public static String i;

    public TtsCacheManager() {
    }

    static {
        a = LazyKt.lazy(new e());
    }

    public static final void a() {
        String r1 = "";
        if (h == false) goto L9;
        a r0 = d();
        String r2 = i;
        if (r2 == null) goto L8;
        r1 = r2;
    L8:
        r0.a(r1, true);
    L14:
        i = null;
        return;
    L9:
        a r3 = d();
        String r4 = i;
        if (r4 == null) goto L13;
        r1 = r4;
    L13:
        r3.a(r1, false);
        goto L14
    }

    public static a d() {
        return (a) a.getValue();
    }

    public static void e() {
        t r0 = h.m;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L13;
        c68.b.d("TtsCacheManager", "tts cache is disabled");
        return;
    L13:
        if (f == false) goto L16;
        c68.b.d("TtsCacheManager", "tts cache is already init");
        return;
    L16:
        c68.b.a("TtsCacheManager", "registerListener");
        GlobalScope r2 = GlobalScope.INSTANCE;
        BuildersKt.launch$default(r2, Dispatchers.getIO(), null, new TtsCacheManager$registerTtsEventListener$1(null), 2, null);
        BuildersKt.launch$default(r2, Dispatchers.getIO(), null, new TtsCacheManager$registerTtsEventListener$2(null), 2, null);
        BuildersKt.launch$default(r2, Dispatchers.getIO(), null, new TtsCacheManager$registerTtsEventListener$3(null), 2, null);
        f = true;
        return;
    L5:
        if (r0.enableTtsCache() != true) goto L7;
        r1 = true;
        goto L9
    }

    public static boolean b(String r3) {
        boolean r0 = d().contains(r3);
        int r1 = c68.b.a;
        c68.b.a("TtsCacheManager", "contains key = " + r3 + " result = " + r0);
        return r0;
    }

    public static void c(String r8) {
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        int r1 = c68.b.a;
        c68.b.d("TtsCacheManager", "deleteCacheByMessageId messageId = " + r8 + ", cacheId = " + i);
        g = r8;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new TtsCacheManager$deleteByKey$1(null), 2, null);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
