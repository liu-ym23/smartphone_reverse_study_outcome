package com.bytedance.android.live.profit.taskcenter.preload;

import android.os.Build;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.kmp.core.KmpEnv;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;
import org.json.JSONObject;
import yz0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements com.bytedance.android.live.profit.taskcenter.preload.a, o, m {
    public static final /* synthetic */ int g = 0;
    public final CompositeDisposable a;
    public final com.bytedance.android.live.profit.taskcenter.preload.b b;
    public Disposable c;
    public boolean d;
    public long e;
    public final yz0.k f;

    public static final class a {
    }

    public static final class b implements wp2.i {
        public final WeakReference<d> a;

        public final void a(wp2.d r4) {
            if (this.a.get() == null) goto L9;
            boolean r0 = r4 instanceof wp2.h;
            if (r0 == true) goto L7;
            int r5 = ((wp2.k) r4).b;
            int r1 = d.g;
            Map<? extends String, ? extends String> r6 = MapsKt.mapOf(new Pair[]{TuplesKt.to("success", String.valueOf(r0)), TuplesKt.to("desc", String.valueOf(false)), TuplesKt.to(Constants.OperatorKey.CODE, String.valueOf(r5))});
            n r2 = new n();
            Map<String, String> r3 = r2.a;
            Intrinsics.checkNotNullParameter(r3, "map");
            Intrinsics.checkNotNullParameter(r6, "map");
            r3.putAll(r6);
            mz0.m r7 = new mz0.m();
            r7.b(LogCommon.ROOM);
            r7.b(LogCommon.PAGE_SOURCE_LOG);
            ((ArrayList) r2.b).addAll(r7.a);
            cy0.e.a.getClass();
            cy0.j r8 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r9);
            ((mz0.i) ((f80.a) r9)).w3("livesdk_excitation_panel_preload_clientAI", r2.a, r2.b);
            return;
        L7:
            wp2.h r10 = (wp2.h) r4;
            throw null;
        L9:
            TaskApiPreloadService$InnerCallBack$onCompleted$2 r12 = TaskApiPreloadService$InnerCallBack$onCompleted$2.INSTANCE;
        }

        public b(WeakReference<d> r1, long r2, String r4) {
            Intrinsics.checkNotNullParameter(r1, "serviceRef");
            Intrinsics.checkNotNullParameter(r4, "anchorId");
            this.a = r1;
        }
    }

    static {
    }

    @Override // yz0.m
    public final void i() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    public final void onStart() {
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.b() == true) goto L5;
        return;
    L5:
        if (this.b.getType() != 1) goto L8;
        RxUtilKt.c(Observable.timer(this.b.a(), TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this, this.f.getRoom().getRoomId(), this.f.getRoom().getOwnerUserIdString()), j.a), this.a);
    L17:
        this.e = System.currentTimeMillis();
        RxUtilKt.c(vh6.c.b(com.bytedance.android.livesdk.revenue.service.hybrid.d.class).registerJsEventSubscriber("webcast.coin_box_pendant.on_click").observeOn(AndroidSchedulers.mainThread()).take(1).subscribe(new k(this)), this.a);
        return;
    L8:
        if (this.b.getType() != 2) goto L17;
        if (this.b.b() > 0) goto L12;
        ALogger.e("TaskCenterService", "interval config invalid: " + this.b.b());
        goto L17
    L12:
        long r4 = this.f.getRoom().getRoomId();
        String r6 = this.f.getRoom().getOwnerUserIdString();
        JSONObject r3 = new JSONObject();
        IBaseUser r1 = this.f.getRoom().getOwner();
        if (r1 == null) goto L15;
        boolean r2 = r1.isFollowing();
    L16:
        d60.b.a(r3, "is_fans", Boolean.valueOf(r2));
        d60.b.a(r3, "age_range", Integer.valueOf(this.f.getUser().getAgeRange()));
        d60.b.a(r3, "gender", Integer.valueOf(this.f.getUser().getGender()));
        d60.b.a(r3, "device_type", Build.MODEL);
        d60.b.a(r3, "city", this.f.getUser().getCity());
        d60.b.a(r3, "city_level", "");
        d60.b.a(r3, "edu_level", "");
        d60.b.a(r3, "consume_level", com.bytedance.android.livesdk.sharedpref.b.J.getValue());
        Disposable r5 = Observable.interval(this.b.a(), this.b.b(), TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r3, r4, r6), h.a);
        RxUtilKt.c(r5, this.a);
        this.c = r5;
        goto L17
    L15:
        r2 = false;
        goto L16
    }

    public final void onStop() {
        this.a.clear();
        this.d = true;
    }

    public d(yz0.k r3) {
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        this.f = r3;
        this.a = new CompositeDisposable();
        this.b = (com.bytedance.android.live.profit.taskcenter.preload.b) com.bytedance.android.live.profit.taskcenter.k.d.getValue(null, com.bytedance.android.live.profit.taskcenter.k.a[2]);
        this.c = Disposables.disposed();
        this.d = true;
    }

    public static String a(String r2) {
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r0 = ((mz0.c) com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class)).W2(LogCommon.PAGE_SOURCE_LOG);
        if (r0 == null) goto L5;
        Map<String, String> r1 = r0.getMap();
    L6:
        if (r1 == null) goto L9;
        String r3 = r1.get(r2);
        if (r3 == null) goto L9;
        return r3;
    L9:
        return "";
    L5:
        r1 = null;
        goto L6
    }
}
