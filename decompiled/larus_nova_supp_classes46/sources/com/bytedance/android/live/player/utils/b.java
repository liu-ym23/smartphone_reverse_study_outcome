package com.bytedance.android.live.player.utils;

import com.bytedance.android.livesdkapi.host.ILivePlayerALogger;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static volatile Map<Integer, ConcurrentLinkedQueue<String>> a;
    public static final Map<Integer, Integer> b = null;

    static {
        a = new LinkedHashMap();
        b = new LinkedHashMap();
    }

    @JvmStatic
    public static final void b(String r2) {
        ILivePlayerHostService r0 = is0.c.c().hostService();
        if (r0 == null) goto L7;
        ILivePlayerALogger r1 = r0.alog();
        if (r1 == null) goto L7;
        r1.d("tt_live_player", r2);
        return;
    L7:
        Intrinsics.checkNotNull(r2);
    }

    @JvmStatic
    public static final void d(String r2) {
        ILivePlayerHostService r0 = is0.c.c().hostService();
        if (r0 == null) goto L7;
        ILivePlayerALogger r1 = r0.alog();
        if (r1 == null) goto L7;
        r1.e("tt_live_player", r2);
        return;
    L7:
        Intrinsics.checkNotNull(r2);
    }

    @JvmStatic
    public static final void e(String r2) {
        Intrinsics.checkNotNullParameter("LiveVrEffect_VrEffectDownloader", "tag");
        ILivePlayerHostService r0 = is0.c.c().hostService();
        if (r0 == null) goto L7;
        ILivePlayerALogger r1 = r0.alog();
        if (r1 == null) goto L7;
        r1.e("LiveVrEffect_VrEffectDownloader", r2);
        return;
    L7:
        Intrinsics.checkNotNull(r2);
    }

    @JvmStatic
    public static final void f(String r2) {
        ILivePlayerHostService r0 = is0.c.c().hostService();
        if (r0 == null) goto L7;
        ILivePlayerALogger r1 = r0.alog();
        if (r1 == null) goto L7;
        r1.i("tt_live_player", r2);
        return;
    L7:
        Intrinsics.checkNotNull(r2);
    }

    @JvmStatic
    public static final void a(String r4, int r5) {
        Map<Integer, ConcurrentLinkedQueue<String>> r0 = a;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        if (r1.get(Integer.valueOf(r5)) != null) goto L10;
        Map<Integer, ConcurrentLinkedQueue<String>> r2 = a;
        Map<Integer, Integer> r3 = b;
        LinkedHashMap r6 = (LinkedHashMap) r3;
        LinkedHashMap r7 = (LinkedHashMap) r2;
        if (r7.get(r6.get(Integer.valueOf(r5))) != null) goto L7;
        ConcurrentLinkedQueue<String> r8 = new ConcurrentLinkedQueue();
        r8.add(String.valueOf(r4));
        a.put(Integer.valueOf(r5), r8);
        return;
    L7:
        Map<Integer, ConcurrentLinkedQueue<String>> r9 = a;
        LinkedHashMap r10 = (LinkedHashMap) r3;
        LinkedHashMap r11 = (LinkedHashMap) r9;
        ConcurrentLinkedQueue r12 = (ConcurrentLinkedQueue) r11.get(r10.get(Integer.valueOf(r5)));
        if (r12 == null) goto L15;
        r12.add(String.valueOf(r4));
        return;
    L15:
        return;
    L10:
        Map<Integer, ConcurrentLinkedQueue<String>> r13 = a;
        LinkedHashMap r14 = (LinkedHashMap) r13;
        ConcurrentLinkedQueue r15 = (ConcurrentLinkedQueue) r14.get(Integer.valueOf(r5));
        if (r15 == null) goto L17;
        r15.add(String.valueOf(r4));
        return;
    }

    @JvmStatic
    public static final void c(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        ILivePlayerHostService r0 = is0.c.c().hostService();
        if (r0 == null) goto L7;
        ILivePlayerALogger r3 = r0.alog();
        if (r3 == null) goto L7;
        r3.d(r1, r2);
        return;
    L7:
        Intrinsics.checkNotNull(r2);
    }

    @JvmStatic
    public static final void g(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        ILivePlayerHostService r0 = is0.c.c().hostService();
        if (r0 == null) goto L7;
        ILivePlayerALogger r3 = r0.alog();
        if (r3 == null) goto L7;
        r3.i(r1, r2);
        return;
    L7:
        Intrinsics.checkNotNull(r2);
    }
}
