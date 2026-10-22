package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import android.content.Context;
import com.bytedance.android.live.base.model.message.x0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.incentiveinfo.model.CarouselTabType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/FreshmanSupportInfoDataChangeMonitor;", "Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/BaseItemDataChangeMonitor;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FreshmanSupportInfoDataChangeMonitor extends BaseItemDataChangeMonitor {
    public final List<String> h;
    public Disposable i;
    public long j;
    public final w81.a k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FreshmanSupportInfoDataChangeMonitor a;

        public b(FreshmanSupportInfoDataChangeMonitor r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            FreshmanSupportInfoDataChangeMonitor r4 = this.a;
            r4.f((w81.b) r4.m.getValue());
            this.a.d = false;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final List<String> d() {
        return this.h;
    }

    @Override // com.bytedance.android.live.room.incentiveinfo.datamonitor.BaseItemDataChangeMonitor
    public final void e(tlc.d r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        if ((r7 instanceof x0) == false) goto L32;
        w81.a r0 = this.k;
        r0.a = r7;
        x0 r8 = (x0) r7;
        r0.c = r8.getIcon();
        Disposable r1 = this.i;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        Long r2 = r8.getStatus();
        if (r2 == null) goto L10;
        Integer r3 = Integer.valueOf((int) r2.longValue());
    L11:
        if (r3 != null) goto L14;
    L19:
        if (r3 != null) goto L22;
        return;
    L22:
        if (r3.intValue() == 2) goto L24;
        return;
    L24:
        if (this.d == true) goto L26;
        return;
    L26:
        HashMap r4 = new HashMap();
        if (this.j <= 0) goto L29;
        String r5 = String.valueOf(System.currentTimeMillis() - this.j);
    L30:
        r4.put(Constants.Keys.duration, r5);
        this.j = -1;
        r4.put("biz_type", "4");
        int r6 = x81.c.a;
        x81.c.a("livesdk_new_anchor_support_plan_exit", this.e, r8.getExtra(), r4);
        f((w81.b) this.l.getValue());
        this.i = Observable.just("").delay(9500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this));
        return;
    L29:
        r5 = "-1";
        goto L30
    L14:
        if (r3.intValue() != 1) goto L19;
        if (this.d == true) goto L18;
        this.d = true;
        this.j = System.currentTimeMillis();
        f((w81.b) this.l.getValue());
        return;
    L18:
        f((w81.b) this.n.getValue());
        return;
    L10:
        r3 = null;
        goto L11
    }

    public FreshmanSupportInfoDataChangeMonitor(DataCenter r2, IRoom r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        super(r2, r3, r4);
        this.h = CollectionsKt.listOf("WebcastFreshmanSupportMessage");
        this.j = -1;
        this.k = new w81.a(CarouselTabType.FRESHMAN_SUPPORT);
        this.l = LazyKt.lazy(new FreshmanSupportInfoDataChangeMonitor$addParams$2(this));
        this.m = LazyKt.lazy(new FreshmanSupportInfoDataChangeMonitor$removeParams$2(this));
        this.n = LazyKt.lazy(new FreshmanSupportInfoDataChangeMonitor$updateParams$2(this));
    }
}
