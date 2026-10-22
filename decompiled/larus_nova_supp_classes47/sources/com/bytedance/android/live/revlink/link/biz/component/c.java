package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectUtilsKt;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.livesdk.link.model.bridge.z1;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final CompositeDisposable b;
    public Disposable c;
    public Map<Long, ? extends z1> d;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            sh6.b r2 = (sh6.b) r1;
            this.a.a();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void accept(Object r19) {
            Long r0 = (Long) r19;
            c r1 = this.a;
            AnchorRtcConnectModel r2 = r1.getContext().Hb();
            if (r2 == null) goto L99;
            com.bytedance.live.datacontext.n<Map<Long, z1>> r3 = r2.getPreRtcInfoMap();
            if (r3 == null) goto L100;
            Map r4 = (Map) r3.getValue();
            if (r4 == null) goto L101;
            LinkedHashMap r5 = new LinkedHashMap();
            Iterator r6 = r4.entrySet().iterator();
        L9:
            boolean r7 = true;
            if (r6.hasNext() == false) goto L19;
            Map.Entry r8 = (Map.Entry) r6.next();
            if ((!Intrinsics.areEqual(((z1) r8.getValue()).getLinkmicIdStr(), r1.getContext().Zl())) == true) goto L14;
        L16:
            r7 = false;
        L17:
            if (r7 == false) goto L9;
            r5.put(r8.getKey(), r8.getValue());
            goto L9
        L14:
            if (AnchorRtcConnectUtilsKt.d((z1) r8.getValue()) == false) goto L16;
        L19:
            Map<Long, ? extends z1> r9 = r1.d;
            if (r9.size() != r5.size()) goto L27;
            Iterator<Map.Entry<Long, ? extends z1>> r10 = r9.entrySet().iterator();
        L24:
            if (r10.hasNext() == false) goto L28;
            Map.Entry<Long, ? extends z1> r12 = r10.next();
            long r13 = r12.getKey().longValue();
            z1 r14 = r12.getValue();
            if (r5.containsKey(Long.valueOf(r13)) == true) goto L24;
        L28:
            boolean r15 = true;
        L29:
            if (r15 == true) goto L103;
            r1.d = r5;
            int r16 = r5.size();
            AnchorRtcConnectModel r17 = r1.getContext().Hb();
            com.bytedance.android.live.revenuelink.f r18 = null;
            if (r17 == null) goto L44;
            com.bytedance.live.datacontext.n<Map<String, Boolean>> r20 = r17.getFrameRenderState();
            if (r20 == null) goto L44;
            Map r22 = (Map) r20.getValue();
            if (r22 == null) goto L44;
            LinkedHashMap r23 = new LinkedHashMap();
            Iterator r24 = r22.entrySet().iterator();
        L39:
            if (r24.hasNext() == false) goto L43;
            Map.Entry r110 = (Map.Entry) r24.next();
            if (StringsKt.startsWith$default((String) r110.getKey(), "1_", false, 2, null) == false) goto L39;
            r23.put(r110.getKey(), r110.getValue());
            goto L39
        L43:
            int r25 = r23.size();
        L45:
            AnchorRtcConnectModel r26 = r1.getContext().Hb();
            if (r26 == null) goto L63;
            com.bytedance.live.datacontext.n<Map<String, Boolean>> r27 = r26.getFrameRenderState();
            if (r27 == null) goto L63;
            Map r28 = (Map) r27.getValue();
            if (r28 == null) goto L63;
            LinkedHashMap r111 = new LinkedHashMap();
            Iterator r29 = r28.entrySet().iterator();
        L53:
            if (r29.hasNext() == false) goto L62;
            Map.Entry r112 = (Map.Entry) r29.next();
            if (StringsKt.startsWith$default((String) r112.getKey(), "1_", false, 2, null) == true) goto L57;
        L59:
            boolean r113 = false;
        L60:
            if (r113 == false) goto L53;
            r111.put(r112.getKey(), r112.getValue());
            goto L53
        L57:
            if (((Boolean) r112.getValue()).booleanValue() == false) goto L59;
            r113 = true;
            goto L60
        L62:
            int r30 = r111.size();
        L64:
            float r32 = r30 / RangesKt.coerceAtLeast(r16, 1);
            RangesKt.coerceAtLeast(r16, 1);
            float r33 = (r25 - r30) / RangesKt.coerceAtLeast(r25, 1);
            float r114 = 100;
            float r115 = ((1 - r33) * r32) * r114;
            float r34 = r32 * r114;
            float r35 = r33 * r114;
            if (r115 <= r114) goto L68;
            int r116 = 1;
        L71:
            jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r1), "statisticsFrameMatchScore: " + r115 + ", expected: " + r16 + ", received: " + r25 + ", matched: " + r30 + ", matchRate: " + r34 + ", redundancyRate: " + r35, null, 4);
            v r36 = com.bytedance.android.live.revlink.link.biz.service.i.H(r1);
            r36.getClass();
            JSONObject r37 = new JSONObject();
            int r38 = y50.b.a;
            y50.b.a.d(r37, "business_api_name", "live_pk_frame_match_score");
            y50.b.a.a(r37, "match_score", r115);
            y50.b.a.b(r37, "expected_frames", r16);
            y50.b.a.b(r37, "received_frames", r25);
            y50.b.a.b(r37, "matched_frames", r30);
            y50.b.a.a(r37, "match_rate", r34);
            y50.b.a.a(r37, "redundancy_rate", r35);
            if (r116 == 0) goto L74;
            r36.c(r37);
        L74:
            HashMap r39 = new HashMap();
            r39.put("business_api_name", "live_pk_frame_match_score");
            r39.put("android_event_key", "live_pk_frame_match_score");
            com.bytedance.android.live.revlink.impl.global.c r40 = r36.d;
            if (r40 == null) goto L77;
            r18 = r40.getRevenueLinkTraceMonitor();
        L77:
            com.bytedance.android.live.revenuelink.f r117 = r18;
            if (r117 == null) goto L102;
            r117.c0("ttlive_pk_business_api_call", LiveTracingMonitorKt.EventModule.MULTI_LINKER, r116, "", r39, r37);
            return;
        L102:
            return;
        L68:
            if (r115 >= r114) goto L70;
            r116 = -1;
            goto L71
        L70:
            r116 = 0;
        L63:
            r30 = 0;
        L44:
            r25 = 0;
            goto L45
        L103:
            return;
        L27:
            r15 = false;
            goto L29
        L101:
            return;
        L100:
            return;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    public final void a() {
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.c = null;
        com.bytedance.revenue.platform.api.core.rx.l r1 = com.bytedance.revenue.platform.api.core.rx.l.a;
        z41.g r2 = z41.g.o;
        r2.getClass();
        long r3 = ((Number) z41.g.h.getValue(r2, z41.g.a[6])).intValue();
        int r4 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.c = Observable.timer(r3, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.c = null;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        AnchorRtcConnectModel r0 = getContext().Hb();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.n<Map<Long, z1>> r1 = r0.getPreRtcInfoMap();
        if (r1 == null) goto L11;
        Observable r2 = r1.a();
        if (r2 == null) goto L11;
        Disposable r3 = r2.subscribe(new a(this));
        if (r3 == null) goto L11;
        com.bytedance.revenue.platform.api.core.rx.f.a(r3, this.b);
    L11:
        a();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.e;
    }

    public c(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.e = r2;
        this.a = "FrameMonitorComponent";
        this.b = new CompositeDisposable();
        this.d = MapsKt.emptyMap();
    }
}
