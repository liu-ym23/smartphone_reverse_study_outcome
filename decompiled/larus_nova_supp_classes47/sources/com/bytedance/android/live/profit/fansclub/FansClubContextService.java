package com.bytedance.android.live.profit.fansclub;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anya.BaseMVIComposableView;
import com.bytedance.android.anya.internal.MVIBindingImpl;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.d0;
import com.bytedance.android.live.profit.fansclub.panel.FansClubPanelService;
import com.bytedance.android.live.profit.fansclub.widget.entrance.facade.EntranceMVIFacade;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FansClubContextService implements com.bytedance.android.scope.o, o {
    public FansClubContext a;
    public Disposable b;
    public final com.bytedance.android.live.revenue.core.a c;
    public final h d;
    public final FansClubRepository e;
    public final FansClubDataService f;
    public final FansClubPanelService g;
    public final com.bytedance.android.live.profit.fansclub.widget.a h;

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final ViewGroup D5() {
        com.bytedance.android.live.profit.fansclub.widget.a r0 = this.h;
        BaseMVIComposableView<eu0.j, eu0.h> r1 = r0.b;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L6:
        if ((r1 instanceof com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.b) == false) goto L14;
        BaseMVIComposableView<eu0.j, eu0.h> r2 = r0.b;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L10:
        if (r2 == null) goto L13;
        return ((com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.b) r2).q;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.EntranceMVIWithCacheView");
    L14:
        return null;
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final void E5() {
        com.bytedance.android.live.profit.fansclub.widget.a r0 = this.h;
        BaseMVIComposableView<eu0.j, eu0.h> r1 = r0.b;
        if (r1 == null) goto L13;
        r1.i();
        MVIBindingImpl r2 = r0.a;
        if (r2 == null) goto L7;
        r2.unbind();
    L7:
        StringBuilder r3 = new StringBuilder("unloadEntranceMVIView：On EntranceContainer unload All Views. code: ");
        MVIBindingImpl r4 = r0.a;
        if (r4 == null) goto L10;
        int r5 = r4.hashCode();
    L11:
        r3.append(r5);
        ALogger.i("EntranceMVI", r3.toString());
        return;
    L10:
        r5 = 0;
        goto L11
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final View e1() {
        com.bytedance.android.live.profit.fansclub.widget.a r0 = this.h;
        BaseMVIComposableView<eu0.j, eu0.h> r1 = r0.b;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L6:
        if ((r1 instanceof com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.b) == false) goto L14;
        BaseMVIComposableView<eu0.j, eu0.h> r2 = r0.b;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L10:
        if (r2 == null) goto L13;
        return ((com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.b) r2).o;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.EntranceMVIWithCacheView");
    L14:
        return null;
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final com.bytedance.live.datacontext.m<Map<String, String>> getExtra() {
        FansClubContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getExtra();
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final com.bytedance.live.datacontext.m<l> getFansGroupInfo() {
        FansClubContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getFansGroupInfo();
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final com.bytedance.live.datacontext.m<e> getParticipateIncentive() {
        FansClubContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getParticipateIncentive();
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final com.bytedance.live.datacontext.m<g> getProfile() {
        FansClubContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getProfile();
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final com.bytedance.live.datacontext.m<Integer> getScene() {
        FansClubContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getScene();
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final com.bytedance.live.datacontext.m<r> getShopFansClubData() {
        FansClubContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getShopFansClubData();
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final ViewGroup na() {
        com.bytedance.android.live.profit.fansclub.widget.a r0 = this.h;
        BaseMVIComposableView<eu0.j, eu0.h> r1 = r0.b;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L6:
        if ((r1 instanceof com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.b) == false) goto L14;
        BaseMVIComposableView<eu0.j, eu0.h> r2 = r0.b;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L10:
        if (r2 == null) goto L13;
        return ((com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.b) r2).r;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.EntranceMVIWithCacheView");
    L14:
        return null;
    }

    public final void onStart() {
        ALogger.d("FansClubContextService", "onStart");
        Pair r0 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        FansClubContext r1 = (FansClubContext) r0.component1();
        Disposable r2 = (Disposable) r0.component2();
        this.a = r1;
        this.b = r2;
        FansClubRepository r3 = this.e;
        d0.a(r3.i, getProfile());
        PropertyOwner r4 = r3.c;
        FansClubContext r5 = this.a;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L5:
        d0.a(r4, r5.getUrl());
        d0.a(r3.m, getParticipateIncentive());
        d0.a(r3.e, getScene());
        d0.a(r3.s, getFansGroupInfo());
        d0.a(r3.k, getShopFansClubData());
        d0.a(r3.q, getExtra());
        FansClubDataService r6 = this.f;
        d0.b(r6.c, r1.getEvents());
        d0.b(r6.d, r1.getSelfEvents());
        this.c.b(o.class, this.d);
    }

    public final void onStop() {
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("disposable");
    L5:
        r0.dispose();
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final Observable<c> r1() {
        FansClubContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getSelfEvents().onEvent();
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final ViewGroup yl() {
        com.bytedance.android.live.profit.fansclub.widget.a r0 = this.h;
        BaseMVIComposableView<eu0.j, eu0.h> r1 = r0.b;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L6:
        if ((r1 instanceof com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.b) == false) goto L14;
        BaseMVIComposableView<eu0.j, eu0.h> r2 = r0.b;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L10:
        if (r2 == null) goto L13;
        return ((com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.b) r2).p;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.EntranceMVIWithCacheView");
    L14:
        return null;
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final int R2() {
        return ((g) getProfile().getValue()).b();
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final boolean isMember() {
        return ((g) getProfile().getValue()).c();
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final boolean Ei(DataCenter r4) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r5 = fu0.b.a(r4);
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.c() == true) goto L16;
        o r1 = yt0.d.a(r5.f).a();
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == true) goto L16;
        boolean r3 = false;
    L17:
        if (r3 == false) goto L19;
    L20:
        return true;
    L19:
        if (r5.x() == true) goto L20;
        return false;
    L10:
        if (r1.isMember() != true) goto L12;
        r2 = true;
    L16:
        r3 = true;
        goto L17
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final void Gd(int r2) {
        this.e.j(r2);
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final g P5(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        com.bytedance.android.live.base.model.user.t r3 = r2.getFansClub();
        if (r3 != null) goto L7;
        return null;
    L7:
        return com.bytedance.android.live.profit.fansclub.transfer.m.e(r3);
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final p Z8(FansClubEntranceParams r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return this.g.c(r2);
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final boolean h5(DataCenter r5) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r6 = fu0.b.a(r5);
        if (r6 != null) goto L5;
        return false;
    L5:
        boolean r1 = !r6.E();
        if (r6.F() == true) goto L8;
    L10:
        boolean r7 = false;
    L11:
        if (r1 == false) goto L15;
        if (r7 == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L8:
        if (r6.K() == true) goto L10;
        r7 = true;
        goto L11
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final void p1(Context r12, DataCenter r13, ViewGroup r14, boolean r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        Intrinsics.checkNotNullParameter(r14, "containerView");
        com.bytedance.android.live.profit.fansclub.widget.a r3 = this.h;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        Intrinsics.checkNotNullParameter(r14, "containerView");
        r3.b = new com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.a(r12, r13, r14, r15, r16);
        EntranceMVIFacade r17 = fu0.b.b(r13);
        if (r17 == null) goto L8;
        BaseMVIComposableView<eu0.j, eu0.h> r18 = r3.b;
        if (r18 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L7:
        MVIBindingImpl r19 = r17.c(r18, com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel.a.class);
    L9:
        r3.a = r19;
        if (r19 == null) goto L12;
        r19.a();
    L12:
        StringBuilder r110 = new StringBuilder("loadEntranceMVIView：On EntranceContainer load All Views. code: ");
        MVIBindingImpl r111 = r3.a;
        if (r111 == null) goto L15;
        int r112 = r111.hashCode();
    L16:
        r110.append(r112);
        ALogger.i("EntranceMVI", r110.toString());
        BaseMVIComposableView<eu0.j, eu0.h> r113 = r3.b;
        if (r113 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L20:
        if ((r113 instanceof com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.a) == false) goto L30;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r114 = fu0.b.a(r13);
        if (r114 == null) goto L31;
        BaseMVIComposableView<eu0.j, eu0.h> r115 = r3.b;
        if (r115 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L26:
        if (r115 == null) goto L29;
        r114.y(((com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.a) r115).getContext(), r13);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.EntranceMVIView");
    L31:
        return;
    L30:
        return;
    L15:
        r112 = 0;
        goto L16
    L8:
        r19 = null;
        goto L9
    }

    public FansClubContextService(com.bytedance.android.live.revenue.core.a r2, h r3, FansClubRepository r4, FansClubDataService r5, FansClubPanelService r6, com.bytedance.android.live.profit.fansclub.widget.a r7) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        Intrinsics.checkNotNullParameter(r3, "myScope");
        Intrinsics.checkNotNullParameter(r4, "repository");
        Intrinsics.checkNotNullParameter(r5, "dataService");
        Intrinsics.checkNotNullParameter(r6, "panelService");
        Intrinsics.checkNotNullParameter(r7, "widgetService");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
    }

    @Override // com.bytedance.android.live.profit.fansclub.o
    public final void ae(Context r13, DataCenter r14, ViewGroup r15, View r16, ViewGroup r17, ViewGroup r18, ViewGroup r19) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "dataCenter");
        Intrinsics.checkNotNullParameter(r15, "containerView");
        com.bytedance.android.live.profit.fansclub.widget.a r10 = this.h;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "dataCenter");
        Intrinsics.checkNotNullParameter(r15, "containerView");
        r10.b = new com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.b(r13, r14, r15, r16, r17, r18, r19);
        EntranceMVIFacade r0 = fu0.b.b(r14);
        if (r0 == null) goto L8;
        BaseMVIComposableView<eu0.j, eu0.h> r2 = r10.b;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L7:
        MVIBindingImpl r1 = r0.c(r2, com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel.a.class);
    L9:
        r10.a = r1;
        if (r1 == null) goto L12;
        r1.a();
    L12:
        StringBuilder r3 = new StringBuilder("loadEntranceMVIViewWithCache：On EntranceContainer load All Views. code: ");
        MVIBindingImpl r4 = r10.a;
        if (r4 == null) goto L15;
        int r5 = r4.hashCode();
    L16:
        r3.append(r5);
        ALogger.i("EntranceMVI", r3.toString());
        BaseMVIComposableView<eu0.j, eu0.h> r6 = r10.b;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L20:
        if ((r6 instanceof com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.b) == false) goto L30;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r7 = fu0.b.a(r14);
        if (r7 == null) goto L31;
        BaseMVIComposableView<eu0.j, eu0.h> r8 = r10.b;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L26:
        if (r8 == null) goto L29;
        r7.y(((com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.b) r8).getContext(), r14);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.EntranceMVIWithCacheView");
    L31:
        return;
    L30:
        return;
    L15:
        r5 = 0;
        goto L16
    L8:
        r1 = null;
        goto L9
    }
}
