package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.message.model.t;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import s91.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/AnchorTextInfoChangeMonitor;", "Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/BaseTabDataMonitor;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorTextInfoChangeMonitor extends BaseTabDataMonitor {
    public List<String> h;
    public final LinkedList<tlc.d> i;
    public Disposable j;
    public final u91.a k;
    public final f l;
    public final f m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor
    public final void g() {
        this.h = null;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor, s91.b
    public final void reset() {
        super.reset();
        Disposable r0 = this.j;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor
    public final List<String> c() {
        return this.h;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor
    public final void d(tlc.d r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        if ((r6 instanceof t) == true) goto L5;
        return;
    L5:
        this.i.add(r6);
        if (this.i.size() != 1) goto L9;
        ALogger.i("AnchorTextInfoChangeMonitor", "run first task");
        b r7 = new b(this);
        this.j = du2.a.b(0, 10, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.a(r7), RxUtil.getNoOpThrowable());
        return;
    }

    public AnchorTextInfoChangeMonitor(DataContext r2, DataCenter r3, IRoom r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3, r4);
        ArrayList r6 = new ArrayList();
        r6.add("WebcastAnchorRoomDataChangeMessage");
        Unit r7 = Unit.INSTANCE;
        this.h = r6;
        this.i = new LinkedList();
        u91.a r8 = new u91.a(new o91.b.a());
        r8.c = r5;
        this.k = r8;
        int r9 = f.f;
        Intrinsics.checkNotNullParameter(r8, "tabInfo");
        f r10 = new f(s91.d.a.a, r8);
        r10.a = true;
        this.l = r10;
        Intrinsics.checkNotNullParameter(r8, "tabInfo");
        this.m = new f(s91.d.c.a, r8);
    }
}
