package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/DiggTemporaryDataMonitor;", "Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/BaseTabDataMonitor;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DiggTemporaryDataMonitor extends BaseTabDataMonitor {
    public Disposable h;
    public final u91.a i;
    public final Lazy j;
    public final Lazy k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor, s91.b
    public final void a() {
        INavigationProxyService r0 = (INavigationProxyService) k.f(INavigationProxyService.class);
        if (r0 == null) goto L14;
        l81.d r1 = r0.getDiggContext(this.f);
        if (r1 == null) goto L15;
        m<Long> r2 = r1.c(this.e);
        if (r2 == null) goto L16;
        Observable r3 = r2.a();
        if (r3 == null) goto L17;
        Disposable r4 = r3.subscribe(new d(this));
        if (r4 == null) goto L18;
        Intrinsics.checkNotNullParameter(r4, "$this$autoBind");
        this.b.add(r4);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor, s91.b
    public final void reset() {
        super.reset();
        Disposable r0 = this.h;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.h = null;
    }

    public DiggTemporaryDataMonitor(int r2, int r3, DataContext r4, DataCenter r5, IRoom r6) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        super(r4, r5, r6);
        u91.a r7 = new u91.a(new o91.b.g());
        r7.a = r2;
        r7.c = r3;
        r7.b = a0.d(r5, false);
        Unit r8 = Unit.INSTANCE;
        this.i = r7;
        this.j = LazyKt.lazy(new DiggTemporaryDataMonitor$addParams$2(this));
        this.k = LazyKt.lazy(new DiggTemporaryDataMonitor$removeParams$2(this));
    }
}
