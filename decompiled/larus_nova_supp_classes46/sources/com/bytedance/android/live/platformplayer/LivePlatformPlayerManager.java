package com.bytedance.android.live.platformplayer;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.platformplayer.utils.h;
import com.bytedance.android.livesdkapi.model.PlayerModularizationConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LivePlatformPlayerManager {
    public static final ConcurrentHashMap<String, as0.a> a = null;
    public static final ConcurrentHashMap<Long, com.bytedance.android.live.platformplayer.layout.c> b = null;
    public static long c;
    public static boolean d;
    public static final ConcurrentHashMap<Long, as0.a.c> e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;

    public static final PlayerModularizationConfig g() {
        return (PlayerModularizationConfig) g.getValue();
    }

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = LazyKt.lazy(LivePlatformPlayerManager$playerConfig$2.INSTANCE);
        g = LazyKt.lazy(LivePlatformPlayerManager$modularizationConfig$2.INSTANCE);
    }

    public static as0.a b() {
        return e(c, d);
    }

    public static final ILivePlayerClient f() {
        return c(c, d).player();
    }

    public static boolean i() {
        ILivePlayerClient r0 = f();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isVideoHorizontal();
    }

    @JvmStatic
    public static final void j(h r1) {
        Intrinsics.checkNotNullParameter(r1, "client");
        ILivePlayerClient r0 = f();
        if (r0 == null) goto L6;
        r1.a(r0);
        return;
    }

    @JvmStatic
    public static final ILivePlayerClient a(long r0, boolean r2) {
        return c(r0, r2).player();
    }

    @JvmStatic
    public static final as0.a c(long r5, boolean r7) {
        String r8 = h(r5, r7);
        ConcurrentHashMap<String, as0.a> r0 = a;
        as0.a r1 = r0.get(r8);
        if (r1 != null) goto L13;
        com.bytedance.android.live.platformplayer.service.a r2 = (com.bytedance.android.live.platformplayer.service.a) k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r2 == null) goto L19;
        LivePlatformPlayer r3 = r2.m2(r5);
        r0.put(r8, r3);
        r3.log("create room player context, identifier : " + r8);
        Iterator<T> r9 = e.values().iterator();
    L9:
        if (r9.hasNext() == false) goto L20;
        as0.a.c r4 = (as0.a.c) r9.next();
        if (r4.b != r5) goto L9;
        r3.j(r4);
        goto L9
    L20:
        return r3;
    L19:
        return new a();
    L13:
        return r1;
    }

    @JvmStatic
    public static final as0.a e(long r1, boolean r3) {
        return a.get(h(r1, r3));
    }

    public static String h(long r6, boolean r8) {
        as0.a.c r0 = e.get(Long.valueOf(r6));
        if (r0 == null) goto L14;
        Long r1 = Long.valueOf(r0.b);
        if (r1.longValue() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L14;
        r6 = r1.longValue();
        goto L14
    L7:
        r3 = false;
    L14:
        if (r6 < 0) goto L20;
        StringBuilder r2 = new StringBuilder();
        if (r8 == false) goto L18;
        String r9 = "shadow_";
    L19:
        r2.append(r9);
        r2.append("inner_room:");
        r2.append(r6);
        return r2.toString();
    L18:
        r9 = "";
        goto L19
    L20:
        return "default_room";
    }

    @JvmStatic
    public static final void k(long r9, boolean r11) {
        ConcurrentHashMap<Long, as0.a.c> r0 = e;
        Long r4 = null;
        if (r0.containsKey(Long.valueOf(r9)) == false) goto L9;
        as0.a r1 = e(r9, r11);
        if (r1 == null) goto L7;
        r1.j(null);
    L7:
        r0.remove(Long.valueOf(r9));
        ALogger.i("LivePlayerView", "unBindSameRoom: roomId:" + r9 + " isShadow:" + r11);
        return;
    L9:
        if ((!r0.isEmpty()) == false) goto L33;
        Iterator<T> r2 = r0.values().iterator();
    L12:
        if (r2.hasNext() == false) goto L19;
        Object r3 = r2.next();
        if (((as0.a.c) r3).b != r9) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L12;
    L20:
        as0.a.c r5 = (as0.a.c) r3;
        if (r5 == null) goto L23;
        r4 = Long.valueOf(r5.a);
    L23:
        if (r4 == null) goto L25;
        as0.a.c r10 = e.remove(Long.valueOf(r4.longValue()));
    L25:
        ALogger.i("LivePlayerView", "unBindSameRoom: newRoomId:" + r4 + " isShadow:" + r11);
        return;
    L16:
        r6 = false;
        goto L17
    L19:
        r3 = null;
        goto L20
    }

    @JvmStatic
    public static final boolean d(long r2, boolean r4, Context r5) {
        String r3 = h(r2, r4);
        ConcurrentHashMap<String, as0.a> r6 = a;
        as0.a r7 = r6.get(r3);
        if (r7 != null) goto L5;
    L10:
        if (r7 == null) goto L12;
        r7.log("failed remove player context from pool");
    L12:
        return false;
    L5:
        if (r7.q(r5) != true) goto L10;
        r7.log("success remove player context from pool");
        if (r6.remove(r3) == null) goto L13;
        return true;
    L13:
        return false;
    }
}
