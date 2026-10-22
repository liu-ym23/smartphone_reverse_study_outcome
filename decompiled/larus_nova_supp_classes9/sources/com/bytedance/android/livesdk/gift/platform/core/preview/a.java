package com.bytedance.android.livesdk.gift.platform.core.preview;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final a a = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.core.preview.a$a, reason: collision with other inner class name */
    public static final class RunnableC0069a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;

        public RunnableC0069a(String r1, Map r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            String r0 = this.a;
            n r1 = new n();
            Map r2 = r1.a;
            Intrinsics.checkNotNullParameter(r2, "map");
            Map r4 = this.b;
            Intrinsics.checkNotNullParameter(r4, "map");
            r2.putAll(r4);
            m r3 = new m();
            r3.b(LogCommon.LIVE_SHARE_LOG);
            r3.b(LogCommon.ROOM);
            r3.b(LogCommon.RECOMMEND_SOURCE_LOG);
            com.bytedance.android.livesdk.revenue.log.i r5 = vh6.c.b(kr2.a.class).ud();
            Intrinsics.checkNotNullParameter(r5, "pageSourceLog");
            List r6 = r3.a;
            ArrayList r7 = (ArrayList) r6;
            r7.add(r5.a);
            List r8 = r1.b;
            ArrayList r9 = (ArrayList) r8;
            r9.addAll(r3.a);
            cy0.e.a.getClass();
            cy0.j r10 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r11 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r11);
            ((f80.a) r11).w3(r0, r1.a, r1.b);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;

        public b(String r1, Map r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            String r0 = this.a;
            n r1 = new n();
            Map r2 = r1.a;
            Intrinsics.checkNotNullParameter(r2, "map");
            Map r4 = this.b;
            Intrinsics.checkNotNullParameter(r4, "map");
            r2.putAll(r4);
            m r3 = new m();
            r3.b(LogCommon.LIVE_SHARE_LOG);
            r3.b(LogCommon.RECOMMEND_SOURCE_LOG);
            com.bytedance.android.livesdk.revenue.log.i r5 = vh6.c.b(kr2.a.class).ud();
            Intrinsics.checkNotNullParameter(r5, "pageSourceLog");
            List r6 = r3.a;
            ArrayList r7 = (ArrayList) r6;
            r7.add(r5.a);
            List r8 = r1.b;
            ArrayList r9 = (ArrayList) r8;
            r9.addAll(r3.a);
            cy0.e.a.getClass();
            cy0.j r10 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r11 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r11);
            ((f80.a) r11).w3(r0, r1.a, r1.b);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a() {
    }

    static {
        a = new a();
    }

    public static void c(String r2, Map r3) {
        new Handler(Looper.getMainLooper()).post(new RunnableC0069a(r2, r3));
    }

    public static void d(String r2, Map r3) {
        new Handler(Looper.getMainLooper()).post(new b(r2, r3));
    }

    public static void a(int r3, int r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "request_page");
        Intrinsics.checkNotNullParameter(r6, "clickType");
        LinkedHashMap r1 = new LinkedHashMap();
        if (r4 != 1) goto L5;
        String r7 = "live_take_page";
    L6:
        r1.put("event_page", r7);
        r1.put("gift_cnt", String.valueOf(r3));
        r1.put("request_page", r5);
        r1.put("click_type", r6);
        k r8 = u.h();
        if (r8 == null) goto L14;
        IRoom r9 = r8.getRoom();
        if (r9 == null) goto L14;
        String r10 = r9.getAnchorId();
        if (r10 != null) goto L13;
        r10 = BuildConfig.FLAVOR;
    L13:
        r1.put("anchor_id", r10);
        r1.put("room_id", String.valueOf(r9.getRoomId()));
        a.getClass();
        c("livesdk_interactive_gift_panel_click", r1);
        return;
    L14:
        r1.put("live_type", "video_live");
        r1.put("anchor_id", vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).getCurrentUserId());
        a.getClass();
        d("livesdk_interactive_gift_panel_click", r1);
        return;
    L5:
        r7 = "live";
        goto L6
    }

    public static void b(int r4, String r5, long r6, int r8) {
        Intrinsics.checkNotNullParameter(r5, "request_page");
        LinkedHashMap r1 = new LinkedHashMap();
        int r2 = (r8 / 4) + 1;
        int r9 = (r8 % 4) + 1;
        if (r4 != 1) goto L5;
        String r7 = "live_take_page";
    L6:
        r1.put("event_page", r7);
        r1.put("request_page", r5);
        r1.put("gift_id", String.valueOf(r6));
        r1.put("row_location", String.valueOf(r2));
        r1.put("column_location", String.valueOf(r9));
        k r10 = u.h();
        if (r10 == null) goto L14;
        IRoom r11 = r10.getRoom();
        if (r11 == null) goto L14;
        String r13 = r11.getAnchorId();
        if (r13 != null) goto L13;
        r13 = BuildConfig.FLAVOR;
    L13:
        r1.put("anchor_id", r13);
        r1.put("room_id", String.valueOf(r11.getRoomId()));
        a.getClass();
        c("livesdk_interactive_gift_panel_gift_remove_click", r1);
        return;
    L14:
        r1.put("live_type", "video_live");
        r1.put("anchor_id", vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).getCurrentUserId());
        a.getClass();
        d("livesdk_interactive_gift_panel_gift_remove_click", r1);
        return;
    L5:
        r7 = "live";
        goto L6
    }
}
