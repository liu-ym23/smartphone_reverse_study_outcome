package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.model.b1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import s91.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/DoubleLikeDataMonitor;", "Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/BaseTabDataMonitor;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DoubleLikeDataMonitor extends BaseTabDataMonitor {
    public final u91.a h;
    public final Lazy i;
    public final Lazy j;
    public Disposable k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor, s91.b
    public final void a() {
        this.f.observe("cmd_user_info_sub_title_anim", this);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor, s91.b
    public final void reset() {
        super.reset();
        Disposable r0 = this.k;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.k = null;
        this.f.removeObserver(this);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor
    public final void f(KVData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        String r0 = r5.getKey();
        if (r0.hashCode() == (-777370727)) goto L8;
        return;
    L8:
        if (r0.equals("cmd_user_info_sub_title_anim") == false) goto L19;
        Object r6 = r5.getData();
        if ((r6 instanceof b1) == true) goto L12;
        r6 = null;
    L12:
        b1 r7 = (b1) r6;
        if (r7 == null) goto L20;
        this.h.d = r7;
        e((f) this.i.getValue());
        Disposable r1 = this.k;
        if (r1 == null) goto L17;
        r1.dispose();
    L17:
        long r2 = r7.c + 300;
        this.k = Observable.just("").delay(r2, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this));
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        f((KVData) r1);
    }

    public DoubleLikeDataMonitor(int r2, int r3, DataContext r4, DataCenter r5, IRoom r6) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        super(r4, r5, r6);
        u91.a r7 = new u91.a(new o91.b.h());
        r7.a = r2;
        r7.c = r3;
        r7.b = a0.d(r5, false);
        Unit r8 = Unit.INSTANCE;
        this.h = r7;
        this.i = LazyKt.lazy(new DoubleLikeDataMonitor$addParams$2(this));
        this.j = LazyKt.lazy(new DoubleLikeDataMonitor$removeParams$2(this));
    }
}
