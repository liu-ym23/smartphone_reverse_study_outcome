package com.bytedance.android.live.effect.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.base.RenderTriggerType;
import com.bytedance.android.livesdk.config.pb;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveEffectMonitor {
    public static PthreadHandlerThreadV2 a;
    public static Handler b;
    public static boolean c;

    public static final class a implements Runnable {
        public final /* synthetic */ LiveEffectMonitor$monitorRenderEffect$1 a;

        public a(LiveEffectMonitor$monitorRenderEffect$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.m839invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public LiveEffectMonitor() {
    }

    public static void h() {
        Intrinsics.checkNotNullParameter("", "extra");
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.TTLIVE_ANCHOR_PREFIX_GET_LINK_OBJ_STICKERS, null, null, 14);
        r0.l(-1);
        r0.i("origin_extra", "");
        r0.a().report();
    }

    static {
    }

    public static void a(boolean r3) {
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_BEAUTY_EFFECT_STATUS, null, null, 14);
        if (r3 == false) goto L5;
        String r4 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L6:
        r0.c(r4);
        r0.a().report();
        return;
    L5:
        r4 = "0";
        goto L6
    }

    public static void j(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_RENDER_EFFECT, null, null, 14);
        r0.i("mutex_type", r3);
        r0.a().report();
    }

    public static void k(boolean r3) {
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_NO_BEAUTIFY_STATUS, null, null, 14);
        if (r3 == false) goto L5;
        String r4 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L6:
        r0.c(r4);
        r0.a().report();
        return;
    L5:
        r4 = "0";
        goto L6
    }

    @JvmStatic
    public static final void f(String r3, List<EffectCategoryModel> r4) {
        Intrinsics.checkNotNullParameter(r3, "panel");
        Intrinsics.checkNotNullParameter(r4, "categoryList");
        List<EffectCategoryModel> r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add(((EffectCategoryModel) r6.next()).getKey());
        goto L4
    L6:
        NewBroadcastMonitor.a r7 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_FETCH_EFFECT_PANEL, null, null, 14);
        r7.l(0);
        r7.c(r3);
        r7.i("err_msg", r0);
        r7.a().report();
    }

    public static void g(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "panel");
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_GET_CAMPAIGN_STICKER, null, null, 14);
        r0.l(r4);
        r0.c(r3);
        r0.a().report();
    }

    public static void l(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "extra");
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_GET_RECOMMEND_STICKER, null, null, 14);
        r0.l(r3);
        r0.i("origin_extra", r4);
        r0.a().report();
    }

    @JvmStatic
    public static final void d(String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "panel");
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_FETCH_EFFECT_LIST, null, null, 14);
        r0.l(r4);
        r0.c(r3);
        r0.i("err_msg", r5);
        r0.a().report();
    }

    @JvmStatic
    public static final void e(String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "panel");
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_FETCH_EFFECT_PANEL, null, null, 14);
        r0.l(r4);
        r0.c(r3);
        r0.i("err_msg", r5);
        r0.a().report();
    }

    @JvmStatic
    public static final void b(String r3, String r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "panel");
        Intrinsics.checkNotNullParameter(r4, "category");
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_FETCH_EFFECT_LIST_BY_CATEGORY, null, null, 14);
        r0.l(r5);
        r0.c(r3);
        r0.d(r4);
        r0.i("err_msg", r6);
        r0.a().report();
    }

    @JvmStatic
    public static final void c(String r2, String r3, List<? extends Effect> r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "category");
        Intrinsics.checkNotNullParameter(r4, "effectList");
        NewBroadcastMonitor.a r6 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_FETCH_EFFECT_LIST_BY_CATEGORY, null, null, 14);
        r6.l(0);
        r6.c(r2);
        r6.d(r3);
        r6.g("duration", r5);
        r6.a().report();
    }

    public static void i(boolean r3, String r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "effectID");
        Intrinsics.checkNotNullParameter(r6, "failReason");
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_GIFT_MENU_STICKER_RENDER, null, null, 14);
        if (r5 == false) goto L5;
        int r7 = 0;
    L6:
        r0.l(r7);
        if (r3 == false) goto L9;
        String r8 = "add";
    L10:
        r0.c(r8);
        r0.i("effect_id", r4);
        r0.i("fail_reason", r6);
        r0.a().report();
        return;
    L9:
        r8 = "remove";
        goto L10
    L5:
        r7 = -1;
        goto L6
    }

    public static /* synthetic */ void n(String r9, String r11, int r12, String r13, String r14, String r15, String r16, String r17) {
        m(r9, r11, r12, r13, r14, r15, r16, r17, null);
    }

    public static void m(String r11, String r12, int r13, String r14, String r15, String r16, String r17, String r18, RenderTriggerType r19) {
        Intrinsics.checkNotNullParameter(r11, "reason");
        Intrinsics.checkNotNullParameter(r12, "trace");
        Intrinsics.checkNotNullParameter(r14, "curList");
        Intrinsics.checkNotNullParameter(r15, "addList");
        Intrinsics.checkNotNullParameter(r16, "removeList");
        Intrinsics.checkNotNullParameter(r17, "endType");
        Intrinsics.checkNotNullParameter(r18, "extraLog");
        LiveEffectMonitor$monitorRenderEffect$1 r0 = new LiveEffectMonitor$monitorRenderEffect$1(r13, r11, r12, r14, r15, r16, r17, r18, r19);
        if ((!((Boolean) pb.a.getValue()).booleanValue()) == true) goto L5;
        r0.m839invoke();
        return;
    L5:
        if (c == true) goto L13;
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("LiveEffectMonitor");
        a = r1;
        ThreadMethodProxy.start(r1);
        PthreadHandlerThreadV2 r2 = a;
        if (r2 == null) goto L12;
        Looper r3 = r2.getLooper();
        if (r3 == null) goto L12;
        b = new Handler(r3);
    L12:
        c = true;
    L13:
        Handler r4 = b;
        if (r4 == null) goto L18;
        r4.post(new a(r0));
        return;
    }
}
