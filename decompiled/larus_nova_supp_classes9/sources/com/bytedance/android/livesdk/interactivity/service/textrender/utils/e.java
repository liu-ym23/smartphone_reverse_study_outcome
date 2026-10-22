package com.bytedance.android.livesdk.interactivity.service.textrender.utils;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final LiveTracingMonitor.EventModule a = null;
    public static final a b = null;

    public static final class a {
        public long a;
        public long b;
        public long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;

        public a() {
        }
    }

    static {
        a = LiveTracingMonitor.EventModule.TEXT_RENDER_ENGINE;
        b = new a();
    }

    public static void b(String r2) {
        pm0.a r0 = om0.c.c();
        if (r0 == null) goto L6;
        r0.e("RenderTracer", r2);
        return;
    }

    public static LiveMonitor.a a(String r3, IRoom r4) {
        LiveMonitor.a r0 = new LiveMonitor.a(r3, a);
        r0.f = true;
        r0.h = true;
        if (r4 == null) goto L5;
        LiveMode r5 = r4.getStreamType();
        int r1 = h1.a;
        r0.c(i1.a(r5));
        r0.i("room_id", String.valueOf(r4.getRoomId()));
        r0.i("anchor_id", r4.getAnchorId());
    L5:
        return r0;
    }

    public static void d(String r4, k r5) {
        Intrinsics.checkNotNullParameter(r4, "loader");
        StringBuilder r0 = new StringBuilder("image error, url is empty, loader is ");
        r0.append(r4);
        r0.append(", image type is ");
        String r6 = null;
        if (r5 == null) goto L5;
        Integer r1 = r5.getImageType();
    L6:
        r0.append(r1);
        r0.append(", urls is ");
        if (r5 == null) goto L11;
        List r7 = r5.getUrls();
        if (r7 == null) goto L11;
        r6 = (String) CollectionsKt.firstOrNull(r7);
    L11:
        r0.append(r6);
        b(r0.toString());
        b.g++;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void c(String r2, k r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "loader");
        StringBuilder r0 = new StringBuilder("image error, convert failed, loader is ");
        r0.append(r2);
        r0.append(", image type is ");
        String r5 = null;
        if (r3 == null) goto L5;
        Integer r1 = r3.getImageType();
    L6:
        r0.append(r1);
        r0.append(", urls is ");
        if (r3 == null) goto L11;
        List r6 = r3.getUrls();
        if (r6 == null) goto L11;
        r5 = (String) CollectionsKt.firstOrNull(r6);
    L11:
        r0.append(r5);
        b(r0.toString());
        if (r4 == null) goto L16;
        pm0.a r7 = om0.c.c();
        if (r7 == null) goto L16;
        r7.e("RenderTracer", r4);
    L16:
        b.i++;
        return;
    L5:
        r1 = null;
        goto L6
    }
}
