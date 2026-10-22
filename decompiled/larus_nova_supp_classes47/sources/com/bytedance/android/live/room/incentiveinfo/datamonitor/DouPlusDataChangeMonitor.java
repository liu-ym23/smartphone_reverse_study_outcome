package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import android.content.Context;
import com.bytedance.android.live.base.model.message.s0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.incentiveinfo.model.CarouselTabType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/DouPlusDataChangeMonitor;", "Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/BaseItemDataChangeMonitor;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DouPlusDataChangeMonitor extends BaseItemDataChangeMonitor {
    public final List<String> h;
    public final w81.a i;
    public Disposable j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ DouPlusDataChangeMonitor a;

        public b(DouPlusDataChangeMonitor r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            DouPlusDataChangeMonitor r4 = this.a;
            r4.f((w81.b) r4.l.getValue());
            this.a.d = false;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor, u81.h
    public final void a() {
        super.a();
        c(xs2.b.a().b(x.class).subscribe(new c(this)));
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final List<String> d() {
        return this.h;
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final void e(tlc.d r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        if ((r6 instanceof s0) == false) goto L42;
        this.i.a = r6;
        Disposable r0 = this.j;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        s0 r7 = (s0) r6;
        Long r1 = r7.getStatus();
        if (r1 == null) goto L10;
        long r2 = r1.longValue();
    L12:
        switch(((int) r2)) {
            case 1: goto L38;
            case 2: goto L34;
            case 3: goto L18;
            case 4: goto L38;
            case 5: goto L14;
            case 6: goto L14;
            default: goto L49;
        };
    L14:
        String r8 = r7.getToast();
        if (r8 == null) goto L43;
        String r3 = rm3.c.a;
        rm3.c.g(getContext(), r8, 0, false, 28);
        return;
    L43:
        return;
    L49:
        return;
    L18:
        if (this.d == false) goto L45;
        f((w81.b) this.k.getValue());
        tlc.d r9 = this.i.a;
        s0 r4 = null;
        if ((r9 instanceof s0) == true) goto L22;
        r9 = null;
    L22:
        s0 r10 = (s0) r9;
        if (r10 == null) goto L25;
        r10.setStatus(1L);
    L25:
        s0 r12 = this.i.a;
        if ((r12 instanceof s0) == false) goto L29;
        r4 = r12;
    L29:
        s0 r5 = r4;
        if (r5 == null) goto L32;
        r5.setBuyerNickname("");
    L32:
        f((w81.b) this.m.getValue());
        return;
    L45:
        return;
    L34:
        if (this.d == true) goto L36;
        return;
    L36:
        f((w81.b) this.k.getValue());
        this.j = Observable.just("").delay(9500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this));
        return;
    L38:
        if (this.d == true) goto L40;
        this.d = true;
        f((w81.b) this.k.getValue());
        return;
    L40:
        f((w81.b) this.m.getValue());
        return;
    L10:
        r2 = 0;
        goto L12
    }

    public DouPlusDataChangeMonitor(DataCenter r2, IRoom r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        super(r2, r3, r4);
        this.h = CollectionsKt.listOf("WebcastDouplusIndicatorMessage");
        this.i = new w81.a(CarouselTabType.DOU_PLUS);
        this.k = LazyKt.lazy(new DouPlusDataChangeMonitor$addParams$2(this));
        this.l = LazyKt.lazy(new DouPlusDataChangeMonitor$removeParams$2(this));
        this.m = LazyKt.lazy(new DouPlusDataChangeMonitor$updateParams$2(this));
    }
}
