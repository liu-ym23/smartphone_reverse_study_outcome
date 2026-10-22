package com.bytedance.android.live.revlink.impl.rtc;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenuelink.rtc.f;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.impl.utils.w;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.live.datacontext.DataContext;
import gd0.v;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;
import org.json.JSONObject;
import pc0.e;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/rtc/AnchorRtcLinkerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/revlink/impl/rtc/a;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorRtcLinkerWidget extends LiveWidget implements a {
    public IRoom a;
    public final CompositeDisposable b;
    public final w c;

    public AnchorRtcLinkerWidget() {
        this.b = new CompositeDisposable();
        this.c = new w();
    }

    @Override // com.bytedance.android.live.revlink.impl.rtc.a
    public final e e() {
        f r0 = com.bytedance.android.live.revlink.impl.global.b.d();
        if (r0 == null) goto L7;
        i r1 = r0.getRtcManager();
        if (r1 == null) goto L7;
        return r1.e();
    L7:
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        j.a r0 = j.C0;
        k r1 = (k) com.bytedance.android.live.revenue.core.util.f.d(r0.a(), k.class);
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L6:
        this.a = r2;
        com.bytedance.android.livesdk.revenue.service.room.c r3 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r3 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r4 = r3.getRoomContext();
        if (r4 == null) goto L11;
        r4.getCommonIsAnchor();
    L11:
        Pair r5 = com.bytedance.live.datacontext.d.a(AnchorRtcLinkerWidget$onCreate$pair$1.INSTANCE);
        ((RtcLinkerContext) r5.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r5.getFirst(), "rtc_linker_service");
        this.b.add((Disposable) r5.getSecond());
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        this.b.dispose();
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.i
    public final void fk(int r9, Map<String, String> r10) {
        w r0 = this.c;
        int r1 = w.a(r0.c);
        int r2 = w.a(r0.b);
        int r3 = w.a(r0.a);
        r0.c.clear();
        r0.b.clear();
        r0.a.clear();
        if (r2 <= 0) goto L25;
        if (r3 <= 0) goto L26;
        if (r1 > 0) goto L8;
        return;
    L8:
        if (r9 != 1) goto L10;
        LiveTracingMonitorKt.EventModule r12 = LiveTracingMonitorKt.EventModule.PK;
    L11:
        HashMap r4 = new HashMap();
        r4.put("android_event_key", "link_widget_destroy");
        JSONObject r5 = new JSONObject();
        if (r10 == null) goto L17;
        Iterator<Map.Entry<String, String>> r13 = r10.entrySet().iterator();
    L15:
        if (r13.hasNext() == false) goto L17;
        Map.Entry<String, String> r6 = r13.next();
        r5.putOpt(r6.getKey(), r6.getValue());
    L17:
        r5.put("video_fps", r1);
        r5.put("preview_fps", r2);
        r5.put("stream_fps", r3);
        com.bytedance.android.live.revenuelink.f r7 = com.bytedance.android.live.revlink.impl.global.b.g0();
        if (r7 == null) goto L20;
        com.bytedance.android.live.revenuelink.f.a.a(r7, "link_widget_destroy", r12, r4, r5);
    L20:
        d31.f r14 = com.bytedance.android.live.revlink.impl.global.b.e0();
        if (r14 == null) goto L27;
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("video_fps", String.valueOf(r1));
        r8.put("preview_fps", String.valueOf(r2));
        r8.put("streamFps", String.valueOf(r3));
        r14.b(r8);
        n r15 = new n();
        Map<String, String> r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r16.putAll(r8);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        m.e.getClass();
        Object r18 = m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3("livesdk_rd_revenue_link_stream_info", r15.a, r15.b);
        return;
    L27:
        return;
    L10:
        r12 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
        goto L11
    L26:
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.i
    public final void updatePushStreamInfo(double r8, double r10, double r12) {
        w r0 = this.c;
        r0.getClass();
        com.bytedance.android.live.revlink.impl.service.internal.a r1 = com.bytedance.android.live.revlink.impl.global.b.n();
        Integer r5 = 0;
        if (r1 == null) goto L11;
        int r2 = r1.getCurrentMode();
        if (v.a(r2, 64) == false) goto L7;
    L10:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L40;
        int r9 = (int) r8;
        if (r0.c.containsKey(Integer.valueOf(r9)) == false) goto L20;
        HashMap<Integer, Integer> r13 = r0.c;
        Integer r4 = Integer.valueOf(r9);
        Integer r14 = r0.c.get(Integer.valueOf(r9));
        if (r14 != null) goto L19;
        r14 = r5;
    L19:
        r13.put(r4, Integer.valueOf(r14.intValue() + 1));
    L22:
        if (r10 <= 0) goto L30;
        int r15 = (int) r10;
        if (r0.a.containsKey(Integer.valueOf(r15)) == false) goto L29;
        HashMap<Integer, Integer> r16 = r0.a;
        Integer r17 = Integer.valueOf(r15);
        Integer r18 = r0.a.get(Integer.valueOf(r15));
        if (r18 != null) goto L28;
        r18 = r5;
    L28:
        r16.put(r17, Integer.valueOf(r18.intValue() + 1));
        goto L30
    L29:
        r0.a.put(Integer.valueOf(r15), 1);
    L30:
        int r19 = (int) r12;
        if (r0.b.containsKey(Integer.valueOf(r19)) == false) goto L37;
        HashMap<Integer, Integer> r20 = r0.b;
        Integer r110 = Integer.valueOf(r19);
        Integer r22 = r0.b.get(Integer.valueOf(r19));
        if (r22 == null) goto L36;
        r5 = r22;
    L36:
        r20.put(r110, Integer.valueOf(r5.intValue() + 1));
        return;
    L37:
        r0.b.put(Integer.valueOf(r19), 1);
        return;
    L20:
        r0.c.put(Integer.valueOf(r9), 1);
        goto L22
    L40:
        return;
    L7:
        if (v.a(r2, DefaultConfig.MAX_CACHE_ENTRIES) == true) goto L10;
        if (v.a(r2, 4) == true) goto L10;
    L11:
        r3 = false;
        goto L12
    }
}
