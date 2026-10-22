package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.gift.configmodel.t;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.a1;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends zr2.k implements o {
    public final String b;
    public final CompositeDisposable c;
    public String d;
    public zy0.d e;
    public final DataCenter f;
    public final Context g;
    public final com.bytedance.android.livesdk.revenue.service.toolbar.e h;
    public final a1 i;
    public final zz0.b j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ vy0.c b;

        public a(g r1, vy0.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Uri r6 = UriProtector.parse((String) r5);
            g r0 = this.a;
            r0.e = this.b.U0(r0.getContext(), r6, null);
            g r7 = this.a;
            if (r7.e == null) goto L7;
            g.w(r7, AttackAndDefenseLogType.CLICK);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r0 = this.a.b;
            Objects.toString((Throwable) r2);
        }
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final void onStart() {
        if (gb2.a.a(this.f, false) == false) goto L7;
        Disposable r0 = Observable.timer(((t) com.bytedance.android.livesdk.gift.platform.business.b.d0.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[54])).a(), TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this));
        this.c.add(r0);
        return;
    }

    public final void onStop() {
        this.c.dispose();
        zy0.d r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        zr2.c r1 = this.h.b9(this.f);
        RevToolbarButton r2 = RevToolbarButton.AttackAndDefense;
        if (r1.f(r2) == false) goto L9;
        this.h.b9(this.f).c(r2, this);
        return;
    }

    public final Context getContext() {
        return this.g;
    }

    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if ((!StringsKt.isBlank(this.d)) == false) goto L6;
        vy0.c r4 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class);
        com.bytedance.revenue.platform.api.core.rx.f.a(r4.v8(this.d, this.g).subscribe(new a(this, r4), new b(this)), this.c);
        return;
    }

    public static final void w(g r3, AttackAndDefenseLogType r4) {
        r3.getClass();
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("game_name", "攻防夺宝");
        String r6 = r4.getEventName();
        n r0 = new n();
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r1.putAll(r5);
        mz0.m r7 = new mz0.m();
        r7.b(LogCommon.ROOM);
        r7.b(LogCommon.PAGE_SOURCE_LOG);
        List r2 = r0.b;
        ArrayList r8 = (ArrayList) r2;
        r8.addAll(r7.a);
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((f80.a) r10).w3(r6, r0.a, r0.b);
    }

    public g(DataCenter r2, Context r3, com.bytedance.android.livesdk.revenue.service.toolbar.e r4, a1 r5, zz0.b r6) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "revToolbarManager");
        Intrinsics.checkNotNullParameter(r5, "giftLinkModeBroadcastService");
        Intrinsics.checkNotNullParameter(r6, "routerService");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.b = "GiftAttackAndDefense";
        this.c = new CompositeDisposable();
        this.d = BuildConfig.FLAVOR;
    }
}
