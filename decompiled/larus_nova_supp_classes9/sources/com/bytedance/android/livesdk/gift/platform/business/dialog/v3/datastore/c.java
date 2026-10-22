package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.g1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.m0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends BaseMVIDataStore<c> implements com.bytedance.android.scope.o {
    public static final /* synthetic */ KProperty[] u = null;
    public final ReadOnlyProperty e;
    public final ReadOnlyProperty f;
    public final com.bytedance.android.anya.t g;
    public final com.bytedance.android.anya.t h;
    public boolean i;
    public final ReadOnlyProperty j;
    public final CompositeDisposable k;
    public HashMap<String, String> l;
    public HashMap<String, String> m;
    public HashMap<String, String> n;
    public HashMap<String, String> o;
    public HashMap<String, String> p;
    public final ny0.a q;
    public final m0 r;
    public final GiftDialogStateDataStore s;
    public final g1 t;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            final lc6.f r5 = (lc6.f) r4;
            if (this.a.i == false) goto L13;
            GiftPanelBizBoostUtils.E.getClass();
            if (GiftPanelBizBoostUtils.A.R1() == false) goto L13;
            if (this.a.q() != null) goto L13;
            if (r5.a() != null) goto L13;
            if (Intrinsics.areEqual(this.a.t.c, r5.b()) == false) goto L13;
            jy0.b.d("ttlive_gift_panel", "intercept same buff info " + r5.a() + ' ' + r5.b());
            return;
        L13:
            c r0 = this.a;
            r0.i = true;
            StringBuilder r1 = new StringBuilder("observeSelectBuffCard_");
            if (r5 == null) goto L16;
            l1 r2 = r5.a();
        L17:
            r1.append(r2);
            r0.g(r1.toString(), new GiftCardDataStore$onStart$1$1(this, r5));
            return;
        L16:
            r2 = null;
            goto L17
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            final lc6.g r4 = (lc6.g) r3;
            this.a.g("observeSelectDIYCard", new GiftCardDataStore$onStart$2$1(this, r4));
        }
    }

    static {
        u = new KProperty[]{Reflection.property1(new PropertyReference1Impl(c.class, "selectedBuffCard", "getSelectedBuffCard()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "selectedDIYCard", "getSelectedDIYCard()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "_selectedBuffCard", "get_selectedBuffCard()Lcom/bytedance/android/livesdk/gift/model/IGiftBuffInfo;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "_selectedDIYCard", "get_selectedDIYCard()Lcom/bytedance/android/livesdk/gift/model/DIYGiftCardInfo;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "currentDIYSelectPosition", "getCurrentDIYSelectPosition()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0))};
    }

    public final com.bytedance.android.anya.t<c, l1> n() {
        return (com.bytedance.android.anya.t) this.e.getValue(this, u[0]);
    }

    public final com.bytedance.android.anya.t<c, com.bytedance.android.livesdk.gift.model.n> o() {
        return (com.bytedance.android.anya.t) this.f.getValue(this, u[1]);
    }

    public final l1 q() {
        return (l1) this.g.getValue(this, u[2]);
    }

    public final boolean f() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.e.getClass();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.a() == false) goto L7;
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.A.g4() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final com.bytedance.android.livesdk.gift.model.n k() {
        return (com.bytedance.android.livesdk.gift.model.n) this.h.getValue(this, u[3]);
    }

    public final void onStop() {
        this.k.clear();
    }

    public final void s() {
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.c() == true) goto L5;
        return;
    L5:
        this.l = ay1.b.h();
        this.m = ay1.b.g();
        this.n = ay1.b.f();
        this.o = ay1.b.c();
        this.p = ay1.b.d();
    }

    public final void onStart() {
        if (nz1.a.h().c() == false) goto L5;
    L6:
        ay1.b.h();
        ay1.b.b();
        ay1.b.g();
        ay1.b.f();
        ay1.b.c();
        ay1.b.d();
    L8:
        if (nz1.a.h().c() == false) goto L11;
        RxUtilKt.c(((pc6.a) ny0.a.a.a(this.q, Reflection.getOrCreateKotlinClass(pc6.a.class))).observeCurrentSelectCard().subscribe(new a(this)), this.k);
    L11:
        if (nz1.a.h().d() == false) goto L14;
        RxUtilKt.c(((pc6.b) ny0.a.a.a(this.q, Reflection.getOrCreateKotlinClass(pc6.b.class))).observeCurrentSelectCard().subscribe(new b(this)), this.k);
        return;
    L14:
        return;
    L5:
        if (nz1.a.h().d() == false) goto L8;
        goto L6
    }

    public c(ny0.a r2, m0 r3, GiftDialogStateDataStore r4, g1 r5) {
        Intrinsics.checkNotNullParameter(r2, "rpcService");
        Intrinsics.checkNotNullParameter(r3, "diyservice");
        Intrinsics.checkNotNullParameter(r4, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r5, "giftLogService");
        this.q = r2;
        this.r = r3;
        this.s = r4;
        this.t = r5;
        com.bytedance.android.anya.internal.k r6 = j(null).a();
        KProperty[] r7 = u;
        this.e = r6.a(r7[0]);
        this.f = j(null).a().a(r7[1]);
        this.g = n();
        this.h = o();
        this.j = i(-1).a().a(r7[4]);
        this.k = new CompositeDisposable();
        this.l = new HashMap();
        this.m = new HashMap();
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = new HashMap();
    }
}
