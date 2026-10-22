package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import android.content.Context;
import com.bytedance.android.live.base.model.message.a4;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.incentiveinfo.model.BizStatus;
import com.bytedance.android.live.room.incentiveinfo.model.CarouselTabType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/RoomIndicatorDataChangeMonitor;", "Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/BaseItemDataChangeMonitor;", "Lcom/bytedance/android/live/base/model/message/a4;", "message", "", "update", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomIndicatorDataChangeMonitor extends BaseItemDataChangeMonitor {
    public final w81.a h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final HashMap<Long, w81.a> l;
    public final HashMap<Long, Boolean> m;
    public final HashMap<Long, w81.a> n;
    public final HashMap<Long, Disposable> o;
    public final HashMap<Long, Long> p;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final List<String> d() {
        return CollectionsKt.listOf("WebcastRoomIndicatorMessage");
    }

    private final void update(a4 r5) {
        Long r0 = r5.G();
        Disposable r2 = null;
        if (Intrinsics.areEqual(this.m.get(r0), Boolean.TRUE) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L18;
        long r1 = r0.longValue();
        g(r5);
        Disposable r6 = this.o.get(Long.valueOf(r1));
        if (r6 != null) goto L10;
    L14:
        w81.a r7 = this.l.get(Long.valueOf(r1));
        if (r7 == null) goto L19;
        int r3 = w81.b.e;
        f(w81.b.a.c(r7));
        return;
    L19:
        return;
    L10:
        if ((!r6.isDisposed()) == false) goto L12;
        r2 = r6;
    L12:
        if (r2 == null) goto L14;
        r2.dispose();
        goto L14
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final void e(tlc.d r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        if ((r10 instanceof a4) == false) goto L138;
        a4 r12 = (a4) r10;
        Long r0 = r12.G();
        Disposable r1 = null;
        if (r0 == null) goto L51;
        r0.longValue();
        w81.a r2 = this.l.get(r12.G());
        if (r2 == null) goto L9;
        tlc.d r3 = r2.a;
    L11:
        if ((r3 instanceof a4) == true) goto L13;
        r3 = null;
    L13:
        a4 r4 = (a4) r3;
        if (r4 == null) goto L16;
        Long r5 = r4.getStatus();
    L17:
        Long r6 = r12.getStatus();
        BizStatus r7 = BizStatus.NEW_ORDER;
        long r8 = r7.getValue();
        if (r6 == null) goto L51;
        if (r6.longValue() != r8) goto L51;
        long r9 = r7.getValue();
        if (r5 != null) goto L26;
    L27:
        w81.a r13 = this.n.get(r12.G());
        if (r13 == null) goto L30;
        tlc.d r14 = r13.a;
    L32:
        if ((r14 instanceof a4) == true) goto L34;
        r14 = null;
    L34:
        a4 r15 = (a4) r14;
        if (r15 == null) goto L37;
        Long r16 = r15.getStatus();
    L38:
        BizStatus r17 = BizStatus.UPDATE;
        long r18 = r17.getValue();
        if (r5 != null) goto L42;
    L43:
        long r19 = r17.getValue();
        if (r16 != null) goto L47;
    L48:
        w81.a r20 = this.l.get(r12.G());
        if (r20 == null) goto L51;
        HashMap<Long, w81.a> r22 = this.n;
        Long r23 = r12.G();
        Intrinsics.checkNotNull(r23);
        r22.put(r23, r20);
        goto L51
    L47:
        if (r16.longValue() == r19) goto L51;
    L42:
        if (r5.longValue() == r18) goto L48;
    L37:
        r16 = null;
        goto L38
    L30:
        r14 = null;
        goto L32
    L26:
        if (r5.longValue() == r9) goto L51;
    L16:
        r5 = null;
        goto L17
    L9:
        r3 = null;
    L51:
        Long r24 = r12.getStatus();
        long r25 = BizStatus.START.getValue();
        if (r24 != null) goto L55;
    L71:
        long r26 = BizStatus.UPDATE.getValue();
        if (r24 != null) goto L75;
    L77:
        long r27 = BizStatus.END.getValue();
        if (r24 != null) goto L81;
    L114:
        long r28 = BizStatus.NEW_ORDER.getValue();
        if (r24 != null) goto L118;
        return;
    L118:
        if (r24.longValue() != r28) goto L144;
        Long r29 = r12.G();
        if (Intrinsics.areEqual(this.m.get(r29), Boolean.TRUE) == true) goto L123;
        r29 = null;
    L123:
        if (r29 == null) goto L145;
        long r30 = r29.longValue();
        g(r12);
        Disposable r110 = this.o.get(Long.valueOf(r30));
        if (r110 != null) goto L127;
    L131:
        w81.a r111 = this.l.get(Long.valueOf(r30));
        if (r111 == null) goto L134;
        int r32 = w81.b.e;
        f(w81.b.a.a(r111));
    L134:
        w81.a r112 = this.n.get(Long.valueOf(r30));
        if (r112 == null) goto L146;
        int r33 = w81.b.e;
        f(w81.b.a.c(r112));
        return;
    L146:
        return;
    L127:
        if ((!r110.isDisposed()) == false) goto L129;
        r1 = r110;
    L129:
        if (r1 == null) goto L131;
        r1.dispose();
        goto L131
    L145:
        return;
    L144:
        return;
    L81:
        if (r24.longValue() != r27) goto L114;
        Long r34 = r12.G();
        if (Intrinsics.areEqual(this.m.get(r34), Boolean.TRUE) == true) goto L86;
        r34 = null;
    L86:
        if (r34 == null) goto L99;
        long r35 = r34.longValue();
        g(r12);
        w81.a r36 = this.l.get(Long.valueOf(r35));
        if (r36 == null) goto L90;
        int r37 = w81.b.e;
        f(w81.b.a.a(r36));
    L90:
        this.m.put(Long.valueOf(r35), Boolean.FALSE);
        Disposable r38 = this.o.get(Long.valueOf(r35));
        if (r38 != null) goto L93;
    L98:
        HashMap<Long, Disposable> r39 = this.o;
        Long r40 = Long.valueOf(r35);
        Disposable r42 = Observable.just("").delay(9500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r35, this));
        c(r42);
        r39.put(r40, r42);
        goto L99
    L93:
        if ((!r38.isDisposed()) == true) goto L96;
        r38 = null;
    L96:
        if (r38 == null) goto L98;
        r38.dispose();
    L99:
        HashMap r43 = new HashMap();
        Long r44 = this.p.get(r12.G());
        if (r44 == null) goto L102;
        long r45 = r44.longValue();
    L104:
        if (r45 <= 0) goto L106;
        String r46 = String.valueOf(System.currentTimeMillis() - r45);
    L107:
        r43.put(Constants.Keys.duration, r46);
        if (r12.G() == null) goto L110;
        HashMap<Long, Long> r47 = this.p;
        Long r48 = r12.G();
        Intrinsics.checkNotNull(r48);
        r47.put(r48, -1L);
    L110:
        r43.put("biz_type", String.valueOf(r12.G()));
        int r49 = x81.c.a;
        DataCenter r50 = this.e;
        mm2.b r113 = r12.E();
        if (r113 == null) goto L113;
        r1 = r113.extra;
    L113:
        x81.c.a("livesdk_new_anchor_support_plan_exit", r50, r1, r43);
        return;
    L106:
        r46 = "-1";
        goto L107
    L102:
        r45 = -1;
        goto L104
    L75:
        if (r24.longValue() != r26) goto L77;
        update(r12);
        return;
    L55:
        if (r24.longValue() != r25) goto L71;
        Long r52 = r12.G();
        Boolean r53 = this.m.get(r52);
        Boolean r54 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r53, r54)) == true) goto L60;
        r52 = null;
    L60:
        if (r52 == null) goto L139;
        long r55 = r52.longValue();
        g(r12);
        Disposable r114 = this.o.get(Long.valueOf(r55));
        if (r114 != null) goto L64;
    L68:
        this.m.put(Long.valueOf(r55), r54);
        this.p.put(Long.valueOf(r55), Long.valueOf(System.currentTimeMillis()));
        w81.a r115 = this.l.get(Long.valueOf(r55));
        if (r115 == null) goto L140;
        int r56 = w81.b.e;
        f(w81.b.a.a(r115));
        return;
    L140:
        return;
    L64:
        if ((!r114.isDisposed()) == false) goto L66;
        r1 = r114;
    L66:
        if (r1 == null) goto L68;
        r1.dispose();
        goto L68
    L139:
        return;
    }

    public final void g(a4 r6) {
        Long r0 = r6.G();
        if (r0 == null) goto L6;
        HashMap<Long, w81.a> r1 = this.l;
        w81.a r2 = new w81.a(CarouselTabType.ROOM_INDICATOR);
        r2.a = r6;
        r2.d = Integer.valueOf((int) r0.longValue());
        Unit r7 = Unit.INSTANCE;
        r1.put(r0, r2);
        return;
    }

    public RoomIndicatorDataChangeMonitor(DataCenter r2, IRoom r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        super(r2, r3, r4);
        this.h = new w81.a(CarouselTabType.ROOM_INDICATOR);
        this.i = LazyKt.lazy(new RoomIndicatorDataChangeMonitor$addParams$2(this));
        this.j = LazyKt.lazy(new RoomIndicatorDataChangeMonitor$removeParams$2(this));
        this.k = LazyKt.lazy(new RoomIndicatorDataChangeMonitor$updateParams$2(this));
        this.l = new HashMap();
        this.m = new HashMap();
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = new HashMap();
    }
}
