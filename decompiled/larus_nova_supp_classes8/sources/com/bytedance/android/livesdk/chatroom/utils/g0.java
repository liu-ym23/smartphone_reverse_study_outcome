package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g0 {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final void a() {
        jc1.k.n(IPerformanceManager.class).onMultiModuleStop("link_mic_user_count");
        b();
        jc1.k.n(IPerformanceManager.class).onMultiModuleStop("interactive_scene");
    }

    @JvmStatic
    public static final void b() {
        jc1.k.n(IPerformanceManager.class).onMultiModuleStop("link_mic_ui_layout");
    }

    static {
    }

    @JvmStatic
    public static final void c(int r2) {
        jc1.k.n(IPerformanceManager.class).onMultiModuleStart("interactive_scene", r2);
    }

    @JvmStatic
    public static final void d(int r2) {
        jc1.k.n(IPerformanceManager.class).onMultiModuleStart("link_mic_ui_layout", r2);
    }

    @JvmStatic
    public static final void e(int r2) {
        jc1.k.n(IPerformanceManager.class).onMultiModuleStart("link_mic_user_count", r2);
    }

    @JvmStatic
    public static final void f(int[] r6) {
        Intrinsics.checkNotNullParameter(r6, "playMode");
        jc1.k.n(IPerformanceManager.class).onMultiModuleStop("play_mode");
        IPerformanceManager r0 = jc1.k.n(IPerformanceManager.class);
        JSONArray r2 = new JSONArray();
        int r3 = r6.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        r2.put(r6[r4]);
        r4 = r4 + 1;
        goto L3
    L5:
        r0.onMultiModuleStart("play_mode", r2);
    }
}
