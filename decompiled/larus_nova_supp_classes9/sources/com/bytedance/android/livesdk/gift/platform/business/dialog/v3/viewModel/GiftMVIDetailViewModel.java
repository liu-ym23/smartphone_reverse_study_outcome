package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.j0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.t;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.m;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDetailViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GroupViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowDetail;
import com.bytedance.android.scope.o;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIDetailViewModel extends com.bytedance.android.anya.f<GiftPanelState, GiftDetailViewState, GiftAction> implements o {
    public final Set<BaseMVIDataStore<?>> u;
    public final CompositeDisposable v;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.h w;
    public final GiftDialogStateDataStore x;
    public final GiftExtraRepo y;
    public final m z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ GiftMVIDetailViewModel a;

        public a(GiftMVIDetailViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            GiftExtraRepo r0 = this.a.y;
            h1 r5 = ((lc6.j) r4).a();
            if (r5 == null) goto L5;
            long r1 = r5.getId();
        L6:
            g0 r6 = r0.q(r1);
            if (r6 != null) goto L9;
            return;
        L9:
            if ((!r6.getGiftBuffInfos().isEmpty()) == true) goto L15;
            if (r6.getDiyGiftToolbarInfo() != null) goto L15;
            if (r6.getSeriesGift() != null) goto L15;
            return;
        L15:
            if (v.e() == true) goto L20;
            this.a.K0(new ShowDetail(false));
            return;
        L20:
            return;
        L5:
            r1 = 0;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GiftMVIDetailViewModel a;

        public b(GiftMVIDetailViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Integer r4 = (Integer) r3;
            if (v.e() == true) goto L6;
            this.a.K0(new ShowDetail(false));
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ GiftMVIDetailViewModel a;

        public c(GiftMVIDetailViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Integer r6 = (Integer) r5;
            if (v.e() == true) goto L15;
            m r0 = this.a.z;
            if (((Boolean) r0.j.getValue(r0, m.n[5])).booleanValue() == false) goto L16;
            GiftMVIDetailViewModel r1 = this.a;
            if (r6 != null) goto L10;
        L12:
            boolean r7 = false;
        L13:
            r1.K0(new ShowDetail(r7));
            return;
        L10:
            if (r6.intValue() != 2) goto L12;
            r7 = true;
            goto L13
        L16:
            return;
        }
    }

    public final void onStop() {
        this.v.clear();
    }

    public final void onStart() {
        if (v.a() == true) goto L5;
        return;
    L5:
        com.bytedance.revenue.platform.api.core.rx.f.a(this.x.observeSelectedGift().subscribeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)), this.v);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.x.k.subscribeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)), this.v);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.w.h.subscribeOn(AndroidSchedulers.mainThread()).subscribe(new c(this)), this.v);
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.u;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftDetailViewState();
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIDetailViewModel$bindToParent$1 r0 = GiftMVIDetailViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r5, MVIState r6) {
        final GiftDetailViewState r7 = (GiftDetailViewState) r6;
        Intrinsics.checkNotNullParameter(r5, "$this$reduce");
        Intrinsics.checkNotNullParameter(r7, "state");
        m r0 = this.z;
        r5.e((t) r0.g.getValue(r0, m.n[2]), new GiftMVIDetailViewModel$reduce$1(this, r7));
        r5.e(this.y.R(), new GiftMVIDetailViewModel$reduce$2(this, r7));
    }

    public final void w0(j0 r7, MVIState r8, p r9) {
        GiftDetailViewState r10 = (GiftDetailViewState) r8;
        Intrinsics.checkNotNullParameter(r7, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter((GiftAction) r9, "action");
        com.bytedance.android.anya.internal.p r11 = r7.getContext();
        com.bytedance.android.anya.internal.p.b r13 = r11.b(r11.c(GiftPanelState.class), GiftMVIDetailViewModel$postReduce$1$1.INSTANCE);
        boolean r0 = false;
        Object r1 = 0;
        com.bytedance.android.anya.internal.c r14 = (com.bytedance.android.anya.v) r13.a.invoke();
        if (r14 == null) goto L26;
        com.bytedance.android.anya.internal.c r2 = r14;
        Object r3 = r14.c();     // Catch: Throwable -> L21
        int r4 = r14.c;     // Catch: Throwable -> L21
        Object r5 = ((LinkedHashMap) r7.d).get(r14);     // Catch: Throwable -> L21
        if (r5 == null) goto L11;
        r1 = r5;
    L11:
        if (r4 <= ((Number) r1).intValue()) goto L13;
        r0 = true;
    L13:
        if (r0 == false) goto L17;
        j0.a r6 = j0.a.a;     // Catch: Throwable -> L21
        r0<GroupViewState, Boolean> r15 = ((GroupViewState) r3).getVisibility();     // Catch: Throwable -> L21
        r6.getClass();     // Catch: Throwable -> L21
        if (((Boolean) com.bytedance.android.anya.h.b(r15)).booleanValue() == false) goto L17;
        GiftDetailViewState r16 = (GiftDetailViewState) r7.g.f();     // Catch: Throwable -> L21
        l0.h(r10.getNeedShowTopDetail(), Boolean.FALSE);     // Catch: Throwable -> L21
    L17:
        if (r0 == false) goto L19;
        r7.a();     // Catch: Throwable -> L21
    L19:
        r7.c.put(r14, Integer.valueOf(r2.c));
        return;
    L21:
        th = move-exception;
        r7.c.put(r14, Integer.valueOf(r2.c));
        throw th;
    }

    public GiftMVIDetailViewModel(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.h r3, GiftDialogStateDataStore r4, GiftExtraRepo r5, m r6) {
        Intrinsics.checkNotNullParameter(r3, "operationDataStore");
        Intrinsics.checkNotNullParameter(r4, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r5, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r6, "profitDataStore");
        this.w = r3;
        this.x = r4;
        this.y = r5;
        this.z = r6;
        this.u = SetsKt.setOf(new BaseMVIDataStore[]{r3, r4, r5, r6});
        this.v = new CompositeDisposable();
    }
}
