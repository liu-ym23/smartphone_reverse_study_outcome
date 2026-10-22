package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.AssetsFileCacheFactory;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftResourceFileCacheService implements com.bytedance.android.scope.o, dy0.c {
    public static final /* synthetic */ int p = 0;
    public final String a;
    public String b;
    public final ConcurrentHashMap<String, String> c;
    public m97.a d;
    public boolean e;
    public boolean f;
    public final Lazy g;
    public long h;
    public int i;
    public int j;
    public boolean k;
    public long l;
    public final BehaviorSubject<Boolean> m;
    public String n;
    public final Lazy o;

    public static final class a {
    }

    static {
    }

    public final uy0.b g() {
        return (uy0.b) this.o.getValue();
    }

    public final com.bytedance.android.livesdk.gift.configmodel.f h() {
        return (com.bytedance.android.livesdk.gift.configmodel.f) this.g.getValue();
    }

    public final void onStart() {
    }

    public final String f() {
        String r0 = this.n;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L21;
        if (com.bytedance.android.livesdk.gift.platform.business.i.b().getEnable() == false) goto L13;
        this.n = new AssetsFileCacheFactory().c();
        goto L21
    L13:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r2 = GiftResourceManagerFactory.a();
        if (r2 == null) goto L18;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r3 = r2.a();
        if (r3 == null) goto L18;
        String r4 = r3.a();
    L19:
        this.n = r4;
    L18:
        r4 = null;
    L21:
        return this.n;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void onStop() {
        m97.a r0 = this.d;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public GiftResourceFileCacheService() {
        this.a = "keva_delete";
        this.b = BuildConfig.FLAVOR;
        this.c = new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.g = LazyKt.lazy(GiftResourceFileCacheService$findOprConfig$2.INSTANCE);
        this.h = -1;
        int r0 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.m = BehaviorSubject.createDefault(Boolean.FALSE);
        this.o = LazyKt.lazy(GiftResourceFileCacheService$fileService$2.INSTANCE);
    }

    public final void x() {
        if (h().getEnable() == true) goto L7;
        jy0.b.c("GiftAssetClean", "setting未开启", null, 4);
        this.m.onNext(Boolean.TRUE);
        return;
    L7:
        if (this.e == false) goto L9;
        return;
    L9:
        boolean r0 = true;
        this.e = true;
        StringBuilder r2 = new StringBuilder();
        int r3 = uy0.a.a;
        String r4 = f();
        if (r4 != null) goto L12;
        r4 = BuildConfig.FLAVOR;
    L12:
        r2.append(uy0.a.a(r4));
        r2.append("zip");
        String r5 = r2.toString();
        jy0.b.a("GiftAssetClean", "makeDownloadDir, " + r5);
        if (g().Y4(r5) == true) goto L15;
        boolean r1 = com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class).k3(r5);
    L16:
        if (r1 == false) goto L19;
        this.b = r5;
    L19:
        if (h().o3() == false) goto L31;
        String r6 = f();
        if (r6 != null) goto L23;
    L26:
        if (r0 == true) goto L31;
        if (g().Y4(r6) == false) goto L31;
        com.bytedance.android.live.revenue.platform.file.impl.a r7 = g().H2(r6, new h2(this));
        r7.b();
        Unit r8 = Unit.INSTANCE;
        this.d = r7;
        goto L31
    L23:
        if (r6.length() == 0) goto L26;
        r0 = false;
    L31:
        int r9 = com.bytedance.revenue.platform.api.core.rx.q.a;
        Single r10 = Single.create(new e2(this));
        int r11 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r10.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f2(this), g2.a);
        return;
    L15:
        this.b = r5;
        r1 = false;
        goto L16
    }

    public final String a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        StringBuilder r0 = new StringBuilder();
        int r1 = uy0.a.a;
        r0.append(uy0.a.a(this.b));
        r0.append(r3.k);
        return r0.toString();
    }
}
