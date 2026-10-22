package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import android.content.Context;
import com.bytedance.android.live.base.model.message.m5;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.incentiveinfo.model.CarouselTabType;
import com.bytedance.android.livesdk.config.f31;
import com.bytedance.android.livesdk.config.setting.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/AnchorTrafficSupportDataChangeMonitor;", "Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/BaseItemDataChangeMonitor;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorTrafficSupportDataChangeMonitor extends BaseItemDataChangeMonitor {
    public static final long o = 0;
    public final w81.a h;
    public final HashMap<Long, w81.a> i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final HashMap<Long, Boolean> m;
    public final HashMap<Long, Disposable> n;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ AnchorTrafficSupportDataChangeMonitor b;
        public final /* synthetic */ tlc.d c;

        public b(long r1, AnchorTrafficSupportDataChangeMonitor r3, tlc.d r4) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
        }

        public final void accept(Object r7) {
            String r8 = (String) r7;
            this.c.setStatus(Long.valueOf(2));
            w81.a r9 = this.b.i.get(Long.valueOf(this.a));
            if (r9 == null) goto L5;
            r9.a = this.c;
        L5:
            AnchorTrafficSupportDataChangeMonitor r10 = this.b;
            int r0 = w81.b.e;
            w81.a r1 = r10.i.get(Long.valueOf(this.a));
            if (r1 != null) goto L8;
            r1 = this.b.h;
        L8:
            r10.f(w81.b.a.a(r1));
            HashMap<Long, Disposable> r12 = this.b.n;
            Long r2 = Long.valueOf(this.a);
            AnchorTrafficSupportDataChangeMonitor r3 = this.b;
            Disposable r4 = Observable.just("").delay(9500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.room.incentiveinfo.datamonitor.b(this));
            r3.c(r4);
            r12.put(r2, r4);
        }
    }

    static {
        int r0 = j.a;
        o = ((f31) LiveInfraSettingKeys.LIVE_FLOW_STIMULATE_CONFIG.getValue()).messageWaitTime;
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final List<String> d() {
        return CollectionsKt.listOf("WebcastTrafficSceneMessage");
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final void e(tlc.d r9) {
        Intrinsics.checkNotNullParameter(r9, "message");
        if ((r9 instanceof m5) == false) goto L48;
        m5 r0 = (m5) r9;
        Long r1 = r0.getMType();
        if (r1 == null) goto L7;
        long r2 = r1.longValue();
        HashMap<Long, w81.a> r3 = this.i;
        Long r4 = Long.valueOf(r2);
        w81.a r5 = new w81.a(CarouselTabType.ANCHOR_TRAFFIC_SUPPORT);
        r5.a = r9;
        r5.c = r0.getIcon();
        r5.d = Integer.valueOf((int) r2);
        Unit r6 = Unit.INSTANCE;
        w81.a r7 = r3.put(r4, r5);
    L7:
        Disposable r8 = this.n.get(r0.getMType());
        if (r8 == null) goto L11;
        r8.dispose();
    L11:
        if (Intrinsics.areEqual(r0.isKeep(), Boolean.TRUE) == false) goto L41;
        Long r10 = r0.getStatus();
        if (r10 == null) goto L15;
        Integer r12 = Integer.valueOf((int) r10.longValue());
    L16:
        if (r12 != null) goto L19;
    L21:
        if (r12 != null) goto L24;
        return;
    L24:
        if (r12.intValue() != 2) goto L50;
        Long r13 = r0.getMType();
        if (r13 == null) goto L51;
        long r14 = r13.longValue();
        HashMap<Long, Boolean> r15 = this.m;
        Long r16 = Long.valueOf(r14);
        Boolean r17 = r15.get(r16);
        if (r17 != null) goto L31;
        r17 = Boolean.FALSE;
        r15.put(r16, r17);
    L31:
        if (r17.booleanValue() == false) goto L55;
        int r18 = w81.b.e;
        w81.a r19 = this.i.get(Long.valueOf(r14));
        if (r19 != null) goto L36;
        r19 = this.h;
    L36:
        f(w81.b.a.a(r19));
        HashMap<Long, Disposable> r20 = this.n;
        Long r22 = r0.getMType();
        if (r22 == null) goto L39;
        long r23 = r22.longValue();
    L40:
        Long r24 = Long.valueOf(r23);
        Disposable r25 = Observable.just("").delay(9500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.room.incentiveinfo.datamonitor.a(r14, this, r0));
        c(r25);
        r20.put(r24, r25);
        return;
    L39:
        r23 = 0;
        goto L40
    L55:
        return;
    L51:
        return;
    L50:
        return;
    L19:
        if (r12.intValue() != 1) goto L21;
        g(r0);
        return;
    L15:
        r12 = null;
        goto L16
    L41:
        Long r26 = r0.getMType();
        if (r26 == null) goto L53;
        long r27 = r26.longValue();
        r0.setStatus(1L);
        w81.a r28 = this.i.get(Long.valueOf(r27));
        if (r28 == null) goto L46;
        r28.a = r9;
    L46:
        g(r0);
        HashMap<Long, Disposable> r29 = this.n;
        Long r30 = Long.valueOf(r27);
        Disposable r32 = Observable.just("").delay(o, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r27, this, r9));
        c(r32);
        r29.put(r30, r32);
        return;
    L53:
        return;
    }

    public final void g(m5 r5) {
        Long r6 = r5.getMType();
        if (r6 == null) goto L18;
        long r0 = r6.longValue();
        HashMap<Long, Boolean> r7 = this.m;
        Long r2 = Long.valueOf(r0);
        Boolean r3 = r7.get(r2);
        if (r3 != null) goto L8;
        r3 = Boolean.FALSE;
        r7.put(r2, r3);
    L8:
        if (r3.booleanValue() == true) goto L13;
        this.m.put(Long.valueOf(r0), Boolean.TRUE);
        int r8 = w81.b.e;
        w81.a r9 = this.i.get(Long.valueOf(r0));
        if (r9 != null) goto L12;
        r9 = this.h;
    L12:
        f(w81.b.a.a(r9));
        return;
    L13:
        int r10 = w81.b.e;
        w81.a r12 = this.i.get(Long.valueOf(r0));
        if (r12 != null) goto L16;
        r12 = this.h;
    L16:
        f(w81.b.a.c(r12));
        return;
    }

    public AnchorTrafficSupportDataChangeMonitor(DataCenter r2, IRoom r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        super(r2, r3, r4);
        this.h = new w81.a(CarouselTabType.ANCHOR_TRAFFIC_SUPPORT);
        this.i = new HashMap();
        this.j = LazyKt.lazy(new AnchorTrafficSupportDataChangeMonitor$addParams$2(this));
        this.k = LazyKt.lazy(new AnchorTrafficSupportDataChangeMonitor$removeParams$2(this));
        this.l = LazyKt.lazy(new AnchorTrafficSupportDataChangeMonitor$updateParams$2(this));
        this.m = new HashMap();
        this.n = new HashMap();
    }
}
