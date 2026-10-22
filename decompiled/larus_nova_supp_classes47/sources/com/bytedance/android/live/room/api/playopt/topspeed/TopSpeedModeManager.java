package com.bytedance.android.live.room.api.playopt.topspeed;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.playopt.topspeed.log.TopSpeedTrace;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdkapi.service.IPerfBalanceService;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import l61.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class TopSpeedModeManager {
    public static final TopSpeedModeManager l = null;
    public final e<Boolean> a;
    public final Lazy b;
    public final Set<String> c;
    public int d;
    public final PropertyOwner<Integer> e;
    public final PropertyOwner<Integer> f;
    public final PropertyOwner<Boolean> g;
    public final PropertyOwner<Boolean> h;
    public final HashMap<String, List<g61.a>> i;
    public final PropertyOwner<Integer> j;
    public final PropertyOwner<String> k;

    public static final class a {
    }

    public final IPerfBalanceService b() {
        return (IPerfBalanceService) this.b.getValue();
    }

    static {
        l = new TopSpeedModeManager();
    }

    public static int a() {
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.c.a).booleanValue() == true) goto L5;
    L18:
        return 0;
    L5:
        if (TopSpeedModeUtils.a() == false) goto L18;
        PropertyOwner r0 = com.bytedance.android.live.room.api.playopt.base.a.e;
        if (((Boolean) r0.a).booleanValue() == false) goto L12;
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.g.a).booleanValue() == false) goto L12;
        return 4;
    L12:
        if (((Boolean) r0.a).booleanValue() == false) goto L15;
        return 3;
    L15:
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.g.a).booleanValue() == false) goto L17;
        return 2;
    L17:
        return 1;
    }

    public TopSpeedModeManager() {
        new CompositeDisposable();
        Boolean r1 = Boolean.FALSE;
        this.a = new e("is_close_by_user", r1);
        this.b = LazyKt.lazy(TopSpeedModeManager$balanceService$2.INSTANCE);
        this.c = new LinkedHashSet();
        this.e = new PropertyOwner(0);
        this.f = new PropertyOwner(0);
        this.g = new PropertyOwner(r1);
        this.h = new PropertyOwner(r1);
        this.i = new HashMap();
        this.j = new PropertyOwner(0);
        this.k = new PropertyOwner("");
    }

    public final void c() {
        if (TopSpeedModeUtils.a() == true) goto L5;
        return;
    L5:
        this.c.clear();
        if (TopSpeedModeUtils.d().j() == true) goto L8;
    L15:
        this.d = a();
        IPerfBalanceService r0 = b();
        if (r0 == null) goto L18;
        r0.updateFastModePermission(this.d);
    L18:
        TopSpeedTrace.b.a("TopSpeedAuthCode init update:::  code :  " + this.d);
        IPerfBalanceService r1 = b();
        if (r1 == null) goto L21;
        r1.subscribePerfCode(new TopSpeedModeManager$init$1(this));
    L21:
        IPerfBalanceService r2 = b();
        if (r2 == null) goto L24;
        r2.subscribeProcess(new TopSpeedModeManager$init$2(this));
    L24:
        IPerfBalanceService r3 = b();
        if (r3 == null) goto L27;
        r3.subscribeNotify(new TopSpeedModeManager$init$3(this));
    L27:
        IPerfBalanceService r4 = b();
        if (r4 == null) goto L31;
        r4.subscribeUserSceneChanged(new TopSpeedModeManager$init$4(this));
        return;
    L31:
        return;
    L8:
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.c.a).booleanValue() == true) goto L15;
        if (TopSpeedModeUtils.d().h() == true) goto L12;
        com.bytedance.android.live.room.api.playopt.base.a.b(true);
        goto L15
    L12:
        if (((Boolean) this.a.getValue()).booleanValue() == true) goto L15;
        com.bytedance.android.live.room.api.playopt.base.a.b(true);
        goto L15
    }

    public final void e() {
        int r0 = a();
        if (r0 == this.d) goto L14;
        this.d = r0;
        IPerfBalanceService r1 = b();
        if (r1 == null) goto L8;
        r1.updateFastModePermission(this.d);
    L8:
        if (this.d != 0) goto L10;
    L11:
        this.c.clear();
    L12:
        TopSpeedTrace.b.a("更新用户授权:::  " + this.d);
        return;
    L10:
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.g.a).booleanValue() == false) goto L12;
    }

    public final void d(b r6, g61.a r7) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        Intrinsics.checkNotNullParameter(r7, "listener");
        String r8 = "live_resource_" + r6.getKey();
        if (this.i.containsKey(r8) == false) goto L8;
        List<g61.a> r0 = this.i.get(r8);
        if (r0 == null) goto L7;
        r0.add(r7);
    L7:
        ALogger.i("LiveTopSpeedLog", "the scene " + r8 + " add listener");
        return;
    L8:
        this.i.put(r8, CollectionsKt.mutableListOf(new g61.a[]{r7}));
        ALogger.i("LiveTopSpeedLog", "the scene " + r8 + " register");
        IPerfBalanceService r9 = b();
        if (r9 == null) goto L13;
        r9.registerAtomicAbility(r8, "community", new com.bytedance.android.live.room.api.playopt.topspeed.a(r8));
        return;
    }
}
