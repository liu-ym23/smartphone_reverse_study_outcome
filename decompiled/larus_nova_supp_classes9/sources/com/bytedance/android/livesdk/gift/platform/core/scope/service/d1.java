package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListCacheRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.business.normal.utils.GiftImageFormat;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListRepository;
import com.bytedance.android.livesdk.gift.platform.core.keva_store.RevDataStoreKevaUtil;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.keva.Keva;
import com.bytedance.live.kmp.core.KmpEnv;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d1 implements com.bytedance.android.scope.o, yz0.m {
    public long a;
    public long b;
    public boolean c;
    public boolean d;
    public final com.bytedance.android.livesdk.gift.configmodel.d0 e;
    public final CompositeDisposable f;
    public Disposable g;
    public Disposable h;
    public int i;
    public int j;
    public final yz0.k k;
    public final GiftListRepository l;
    public final GiftListCacheRepo m;
    public final AssetsService n;

    public final void onStart() {
        ArrayList<String> r0 = w12.b.a;
        boolean r1 = ((Boolean) GiftImageFormat.a.getValue()).booleanValue();
        String r2 = com.bytedance.android.livesdk.gift.platform.business.i.h().c0();
        String r3 = com.bytedance.android.livesdk.gift.platform.business.i.h().A2();
        w12.b.c = r1;
        if (r2 == null) goto L5;
        w12.b.e = r2;
    L5:
        if (r3 == null) goto L8;
        w12.b.f = r3;
        return;
    }

    public final void onStop() {
        if (this.f.isDisposed() == true) goto L6;
        this.f.dispose();
    L6:
        if (com.bytedance.android.livesdk.gift.platform.core.f.a().getEnable() == false) goto L18;
        long r0 = this.a;
        if (r0 <= 0) goto L12;
        Keva r4 = (Keva) RevDataStoreKevaUtil.a.getValue();
        if (r4 == null) goto L12;
        r4.storeLong("last_consume_time", r0);
    L12:
        long r1 = this.b;
        if (r1 <= 0) goto L19;
        Keva r2 = (Keva) RevDataStoreKevaUtil.a.getValue();
        if (r2 == null) goto L20;
        r2.storeLong("last_consume_fail_time", r1);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void i() {
        long r0 = System.currentTimeMillis();
        yz0.k r2 = this.k;
        if (r2 == null) goto L6;
        r2.xc(r0);
    L6:
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().b() != 1) goto L9;
        this.m.f();
    L9:
        if (this.l.f() != true) goto L11;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L18;
        if (this.e.f() != 1) goto L20;
        d("onRoomReady");
    L20:
        KmpEnv r3 = KmpEnv.a;
        if (KmpEnv.b() == false) goto L47;
        List r4 = this.k.getToolbarDataList();
        Boolean r5 = null;
        if (r4 == null) goto L37;
        Iterator r6 = r4.iterator();
    L26:
        if (r6.hasNext() == false) goto L33;
        Object r7 = r6.next();
        if (((IToolbarComponentData) r7).getId() != 30) goto L30;
        boolean r8 = true;
    L31:
        if (r8 == false) goto L26;
    L35:
        if (((IToolbarComponentData) r7) == null) goto L37;
        r5 = Boolean.TRUE;
        goto L37
    L30:
        r8 = false;
        goto L31
    L33:
        r7 = null;
    L37:
        if (r5 != null) goto L39;
    L40:
        d("DLite-onRoomReady");
        return;
    L39:
        if (Intrinsics.areEqual(r5, Boolean.FALSE) == true) goto L40;
        return;
    L47:
        return;
    L18:
        if (this.e.g() != 1) goto L20;
        d("onRoomReady");
        goto L20
    L11:
        r1 = false;
        goto L13
    }

    public final void onViewReady() {
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().e() == false) goto L8;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L8;
        GiftManagerKt.z.getClass();
        GiftManagerKt.C();
    L8:
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().b() != 2) goto L10;
        this.m.f();
    L10:
        boolean r2 = true;
        if (this.l.f() == true) goto L15;
        r2 = false;
    L15:
        if (r2 == true) goto L20;
        if (this.e.f() != 2) goto L23;
        d("onViewReady");
    L23:
        if (this.e.c() != 2) goto L26;
        f("GiftListRoomService-onViewReady");
        return;
    L26:
        return;
    L20:
        if (this.e.g() != 2) goto L23;
        d("onViewReady");
        goto L23
    }

    public final void onWidgetLoaded() {
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().b() != 4) goto L5;
        this.m.f();
    L5:
        boolean r2 = true;
        if (this.l.f() == true) goto L10;
        r2 = false;
    L10:
        if (r2 == true) goto L15;
        if (this.e.f() != 4) goto L18;
        d("onWidgetLoaded");
    L18:
        if (this.e.c() != 4) goto L21;
        f("GiftListRoomService-onWidgetLoaded");
        return;
    L21:
        return;
    L15:
        if (this.e.g() != 4) goto L18;
        d("onWidgetLoaded");
        goto L18
    }

    public final void x() {
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().b() != 3) goto L5;
        this.m.f();
    L5:
        int r3 = 0;
        if (this.l.f() != true) goto L8;
        boolean r0 = true;
    L9:
        Object r4 = null;
        if (r0 == true) goto L15;
        if (this.e.f() != 3) goto L39;
        d("onP0WidgetLoaded");
    L39:
        if (this.e.c() != 3) goto L42;
        f("GiftListRoomService-onP0WidgetLoaded");
        return;
    L42:
        if (this.e.c() != 5) goto L57;
        long r1 = this.e.a();
        if (this.e.e() == false) goto L58;
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        i12.e r6 = i12.o.b();
        if (r6 == null) goto L49;
        r4 = com.bytedance.android.scope.m.e.d(r6, GiftDataStorageService.class);
    L49:
        GiftDataStorageService r7 = (GiftDataStorageService) r4;
        r5.element = r7;
        if (r7 == null) goto L52;
        r3 = r7.p;
    L52:
        if (r3 > 0) goto L59;
        this.j = 1;
        Disposable r2 = Observable.timer(r1, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b1(this, r5));
        this.h = r2;
        CompositeDisposable r8 = this.f;
        Intrinsics.checkNotNull(r2);
        r8.add(r2);
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L15:
        if (this.e.g() != 3) goto L18;
        d("onP0WidgetLoaded");
        goto L39
    L18:
        if (this.e.g() != 5) goto L39;
        if (this.c == true) goto L39;
        if (this.e.e() == false) goto L39;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L39;
        long r9 = this.e.b();
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        i12.e r11 = i12.o.b();
        if (r11 == null) goto L30;
        Object r13 = com.bytedance.android.scope.m.e.d(r11, GiftDataStorageService.class);
    L31:
        GiftDataStorageService r14 = (GiftDataStorageService) r13;
        r10.element = r14;
        if (r14 == null) goto L34;
        int r15 = r14.p;
    L35:
        if (r15 > 0) goto L39;
        this.i = 1;
        Disposable r16 = Observable.timer(r9, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c1(this, r10));
        this.g = r16;
        CompositeDisposable r17 = this.f;
        Intrinsics.checkNotNull(r16);
        r17.add(r16);
        goto L39
    L34:
        r15 = 0;
        goto L35
    L30:
        r13 = null;
        goto L31
    L8:
        r0 = false;
        goto L9
    }

    public final void a(String r14) {
        Intrinsics.checkNotNullParameter(r14, "traceFlag");
        IRoom r0 = this.k.getRoom();
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = r0.getRoomLayout();
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("trace", r14);
        IRoomAuthStatus r15 = r0.getMRoomAuthStatus();
        if (r15 != null) goto L8;
    L10:
        r13.put("enable_gift", "0");
    L11:
        this.c = true;
        long r4 = r0.getRoomId();
        boolean r7 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h();
        IBaseUser r16 = r0.getOwner();
        if (r16 == null) goto L15;
        Intrinsics.checkNotNullParameter(r16, "$this$secUidExt");
        String r17 = r16.getCastSecUid();
        if (r17 == null) goto L15;
    L16:
        GiftListRepo.h(null, r4, 2, r7, r17, 0, (int) r1, r13);
        return;
    L15:
        r17 = BuildConfig.FLAVOR;
        goto L16
    L8:
        if (r15.getEnableGift() != true) goto L10;
        r13.put("enable_gift", "1");
        goto L11
    }

    public final void d(String r8) {
        if (this.c == false) goto L6;
        return;
    L6:
        if (this.e.e() == true) goto L9;
        return;
    L9:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L11;
        return;
    L11:
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L14;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftDataStorageService.class);
    L15:
        GiftDataStorageService r2 = (GiftDataStorageService) r1;
        boolean r3 = false;
        if (r2 == null) goto L18;
        int r4 = r2.p;
    L19:
        if (r4 <= 0) goto L22;
        return;
    L22:
        if (this.l.f() != true) goto L25;
        r3 = true;
    L25:
        if (this.e.d() == true) goto L31;
        long r5 = this.l.n & 1;
        if (r3 == false) goto L31;
        if (r5 != 1) goto L31;
        return;
    L31:
        this.c = true;
        a(r8);
        return;
    L18:
        r4 = 0;
        goto L19
    L14:
        r1 = null;
        goto L15
    }

    public final void f(String r9) {
        if (this.e.e() == true) goto L5;
        return;
    L5:
        yz0.k r0 = this.k;
        Long r1 = null;
        if (r0 == null) goto L8;
        Boolean r2 = Boolean.valueOf(r0.isAnchor());
    L9:
        boolean r4 = r2.booleanValue();
        yz0.k r3 = this.k;
        if (r3 == null) goto L14;
        IRoom r5 = r3.getRoom();
        if (r5 == null) goto L14;
        r1 = Long.valueOf(r5.getRoomId());
    L14:
        c(2, r4, r1.longValue(), r9);
        return;
    L8:
        r2 = null;
        goto L9
    }

    public d1(yz0.k r2, GiftListRepository r3, GiftListCacheRepo r4, AssetsService r5) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "giftListRepository");
        Intrinsics.checkNotNullParameter(r4, "listGlobalCacheRepo");
        Intrinsics.checkNotNullParameter(r5, "assetsService");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.a = -1;
        this.b = -1;
        this.e = (com.bytedance.android.livesdk.gift.configmodel.d0) com.bytedance.android.livesdk.gift.platform.core.h.H0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[84]);
        this.f = new CompositeDisposable();
    }

    public final void c(int r2, boolean r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "trace");
        if (r2 != (-1)) goto L6;
        return;
    L6:
        if (r2 == 2) goto L8;
        this.n.S0(r2, r3, String.valueOf(r4), r6);
        return;
    L8:
        if (this.d == false) goto L10;
        return;
    L10:
        this.d = true;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L13;
        return;
    L13:
        this.n.S0(r2, r3, String.valueOf(r4), r6);
    }
}
