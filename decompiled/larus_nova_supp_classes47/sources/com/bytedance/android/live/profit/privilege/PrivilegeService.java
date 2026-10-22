package com.bytedance.android.live.profit.privilege;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.profit.privilege.datalayer.h;
import com.bytedance.android.live.profit.privilege.datalayer.i;
import com.bytedance.android.live.profit.privilege.datalayer.k;
import com.bytedance.android.live.profit.privilege.datalayer.l;
import com.bytedance.android.live.profit.privilege.datalayer.n;
import com.bytedance.android.live.profit.privilege.datalayer.q;
import com.bytedance.android.live.profit.privilege.datalayer.r;
import com.bytedance.android.live.profit.privilege.model.danmu.DanmakuTabList;
import com.bytedance.android.live.profit.privilege.model.danmu.PrivilegeBarrageResponse;
import com.bytedance.android.live.profit.privilege.model.danmu.SendPrivilegeBarrageArgs;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.live.profit.privilege.model.touch.GiftPanelTouchData;
import com.bytedance.android.live.profit.privilege.model.touch.GrowthTouchData$Position;
import com.bytedance.android.live.profit.privilege.model.touch.TouchPositionData;
import com.bytedance.android.live.profit.privilege.model.touch.g;
import com.bytedance.android.live.profit.privilege.model.touch.j;
import com.bytedance.android.live.profit.privilege.service.PrivilegeFuncService;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.m;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PrivilegeService implements o, a {
    public PrivilegeContext a;
    public Disposable b;
    public final com.bytedance.android.live.revenue.core.a c;
    public final xu0.a d;
    public final PrivilegeFuncService e;
    public final com.bytedance.android.live.profit.privilege.datalayer.a f;
    public final com.bytedance.android.live.profit.privilege.datalayer.d g;

    @Override // com.bytedance.android.live.profit.privilege.a
    public final void Te() {
        com.bytedance.android.live.profit.privilege.datalayer.a r1 = this.f;
        long r2 = ((Number) getBubbleRefId().getValue()).longValue();
        com.bytedance.android.live.profit.privilege.datalayer.d r3 = r1.b;
        r3.d.setValue(new TouchPositionData(null, false, null, 7, null));
        com.bytedance.live.kmp.util.c r4 = com.bytedance.live.kmp.util.c.a;
        long r5 = System.currentTimeMillis();
        List r6 = CollectionsKt.mutableListOf(new Long[]{Long.valueOf(GrowthTouchData$Position.PositionGiftPanelTop.getValue()), Long.valueOf(GrowthTouchData$Position.PositionGiftPanelEntrance.getValue())});
        int r7 = vu0.a.a;
        String r8 = r3.c();
        long r9 = r3.d();
        String r10 = r6.toString();
        Intrinsics.checkNotNullParameter(r8, "anchorId");
        Intrinsics.checkNotNullParameter(r10, "positions");
        tz0.b r12 = tz0.b.a;
        uz0.c r13 = new uz0.c();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "$this$beforeConfigureRequest");
        Map<String, String> r14 = r13.b;
        Intrinsics.checkNotNullParameter(r14, "queriesMap");
        Intrinsics.checkNotNullParameter("anchor_open_id", "$this$setTo");
        r14.put("anchor_open_id", r8);
        String r15 = Long.valueOf(r9).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r15 == null) goto L5;
        r14.put("room_id", r15);
    L5:
        Intrinsics.checkNotNullParameter("positions", "$this$setTo");
        if (r10 == null) goto L8;
        r14.put("positions", r10);
    L8:
        String r16 = Long.valueOf(r2).toString();
        Intrinsics.checkNotNullParameter("ref_id", "$this$setTo");
        if (r16 == null) goto L11;
        r14.put("ref_id", r16);
    L11:
        Intrinsics.checkNotNullParameter(r13, "$this$afterConfigureRequest");
        Observable r17 = ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/growth/touch_position/list/", TypesJVMKt.getJavaType(Reflection.typeOf(j.class)), Extra.class, r13.d, r13.a, r13.b, r13.c);
        int r18 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r17.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(r3, r5), new l(r3)), r3.a);
    }

    @Override // com.bytedance.android.live.profit.privilege.a
    public final m<Long> getBubbleRefId() {
        PrivilegeContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getBubbleRefId();
    }

    @Override // com.bytedance.android.live.profit.privilege.a
    public final m<? extends DanmakuTabList> getDanmakuTabList() {
        PrivilegeContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getDanmakuTabList();
    }

    @Override // com.bytedance.android.live.profit.privilege.a
    public final m<? extends GiftPanelTouchData> getGiftPanelTouchData() {
        PrivilegeContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getGiftPanelTouchData();
    }

    @Override // com.bytedance.android.live.profit.privilege.a
    public final m<? extends PayGrade> getPayGrade() {
        PrivilegeContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getPayGrade();
    }

    @Override // com.bytedance.android.live.profit.privilege.a
    public final m<? extends TouchPositionData> getTouchPositionData() {
        PrivilegeContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getTouchPositionData();
    }

    @Override // com.bytedance.android.live.profit.privilege.a
    public final m<Boolean> isInDanmakuMode() {
        PrivilegeContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.isInDanmakuMode();
    }

    @Override // com.bytedance.android.live.profit.privilege.a
    public final void jl() {
        com.bytedance.android.live.profit.privilege.datalayer.d r1 = this.f.b;
        r1.getClass();
        com.bytedance.live.kmp.util.c r2 = com.bytedance.live.kmp.util.c.a;
        long r3 = System.currentTimeMillis();
        boolean r4 = com.bytedance.android.live.base.model.user.o.b(r1.b());
        boolean r5 = Intrinsics.areEqual(r1.f(), r1.c());
        int r6 = vu0.a.a;
        long r7 = r1.d();
        String r8 = r1.c();
        if (r4 == true) goto L7;
        if (r5 == true) goto L7;
        boolean r9 = false;
    L8:
        tz0.b r10 = tz0.b.a;
        uz0.e r12 = new uz0.e();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r12, "$this$beforeConfigureRequest");
        Map<String, String> r13 = r12.e;
        Intrinsics.checkNotNullParameter(r13, "fieldsMap");
        String r14 = Long.valueOf(r7).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r14 == null) goto L11;
        r13.put("room_id", r14);
    L11:
        Intrinsics.checkNotNullParameter("anchor_open_id", "$this$setTo");
        r13.put("anchor_open_id", r8);
        String r15 = String.valueOf(r9);
        Intrinsics.checkNotNullParameter("send_admin_tab", "$this$setTo");
        if (r15 == null) goto L14;
        r13.put("send_admin_tab", r15);
    L14:
        Intrinsics.checkNotNullParameter(r12, "$this$afterConfigureRequest");
        Observable r16 = ((INetworkService) f.a(INetworkService.class)).L4(INetworkService.Biz.Revenue, "/webcast/privilege/screen_chat/tab/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.privilege.model.danmu.a.class)), Extra.class, r12.d, r12.a, r12.b, r12.c, r12.e, r12.f, r12.g);
        int r17 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r16.observeOn(AndroidSchedulers.mainThread()).map(h.a).subscribe(new i(r1, r3), new com.bytedance.android.live.profit.privilege.datalayer.j(r1)), r1.a);
        return;
    L7:
        r9 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.profit.privilege.a
    public final void k6() {
        com.bytedance.android.live.profit.privilege.datalayer.d r0 = this.f.b;
        r0.getClass();
        com.bytedance.live.kmp.util.c r1 = com.bytedance.live.kmp.util.c.a;
        long r2 = System.currentTimeMillis();
        int r3 = vu0.a.a;
        long r4 = r0.d();
        tz0.b r5 = tz0.b.a;
        uz0.c r6 = new uz0.c();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "$this$beforeConfigureRequest");
        Map<String, String> r7 = r6.b;
        Intrinsics.checkNotNullParameter(r7, "queriesMap");
        String r8 = Long.valueOf(r4).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r8 == null) goto L5;
        r7.put("room_id", r8);
    L5:
        Intrinsics.checkNotNullParameter(r6, "$this$afterConfigureRequest");
        Observable r9 = ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/privilege/gift_panel_touch/", TypesJVMKt.getJavaType(Reflection.typeOf(g.class)), Extra.class, r6.d, r6.a, r6.b, r6.c);
        int r10 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r9.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(com.bytedance.android.live.profit.privilege.datalayer.e.a).subscribe(new com.bytedance.android.live.profit.privilege.datalayer.f(r0, r2), new com.bytedance.android.live.profit.privilege.datalayer.g(r0)), r0.a);
    }

    public final void onStart() {
        Pair r0 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        PrivilegeContext r1 = (PrivilegeContext) r0.component1();
        Disposable r2 = (Disposable) r0.component2();
        this.a = r1;
        this.b = r2;
        com.bytedance.android.live.profit.privilege.datalayer.d r3 = this.g;
        yu0.e.a(r3.c, r1.getDanmakuTabList());
        yu0.e.a(r3.e, r1.getTouchPositionData());
        yu0.e.a(r3.g, r1.getPayGrade());
        yu0.e.a(r3.i, r1.getGiftPanelTouchData());
        this.c.d(Reflection.getOrCreateKotlinClass(a.class), this.d);
    }

    public final void onStop() {
        this.b.dispose();
    }

    @Override // com.bytedance.android.live.profit.privilege.a
    public final Single<PrivilegeBarrageResponse> V3(SendPrivilegeBarrageArgs r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        return this.f.a(r2);
    }

    @Override // com.bytedance.android.live.profit.privilege.a
    public final void k0(int r17) {
        com.bytedance.android.live.profit.privilege.datalayer.d r1 = this.f.b;
        r1.getClass();
        com.bytedance.live.kmp.util.c r2 = com.bytedance.live.kmp.util.c.a;
        long r3 = System.currentTimeMillis();
        int r4 = vu0.a.a;
        long r5 = r1.d();
        tz0.b r6 = tz0.b.a;
        uz0.c r7 = new uz0.c();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "$this$beforeConfigureRequest");
        Map<String, String> r8 = r7.b;
        Intrinsics.checkNotNullParameter(r8, "queriesMap");
        String r9 = Long.valueOf(r5).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r9 == null) goto L5;
        r8.put("room_id", r9);
    L5:
        String r10 = Integer.valueOf(r17).toString();
        Intrinsics.checkNotNullParameter("request_from", "$this$setTo");
        if (r10 == null) goto L8;
        r8.put("request_from", r10);
    L8:
        Intrinsics.checkNotNullParameter(r7, "$this$afterConfigureRequest");
        Observable r12 = ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/privilege/paygrade/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.privilege.model.paygrade.a.class)), Extra.class, r7.d, r7.a, r7.b, r7.c);
        int r13 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r12.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(com.bytedance.android.live.profit.privilege.datalayer.p.a).subscribe(new q(r1, r3), new r(r1)), r1.a);
    }

    @Override // com.bytedance.android.live.profit.privilege.a
    public final void nl(Long r15) {
        com.bytedance.android.live.profit.privilege.datalayer.d r0 = this.f.b;
        r0.getClass();
        int r1 = vu0.a.a;
        String r2 = r0.c();
        long r3 = r0.d();
        Intrinsics.checkNotNullParameter(r2, "anchorId");
        tz0.b r4 = tz0.b.a;
        uz0.c r5 = new uz0.c();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "$this$beforeConfigureRequest");
        Map<String, String> r6 = r5.b;
        Intrinsics.checkNotNullParameter(r6, "queriesMap");
        Intrinsics.checkNotNullParameter("anchor_open_id", "$this$setTo");
        r6.put("anchor_open_id", r2);
        String r7 = Long.valueOf(r3).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r7 == null) goto L5;
        r6.put("room_id", r7);
    L5:
        if (r15 == null) goto L9;
        String r8 = r15.toString();
        Intrinsics.checkNotNullParameter("meta_id", "$this$setTo");
        if (r8 == null) goto L9;
        r6.put("meta_id", r8);
    L9:
        Long r9 = 1L;
        String r10 = r9.toString();
        Intrinsics.checkNotNullParameter("ack_type", "$this$setTo");
        if (r10 == null) goto L12;
        r6.put("ack_type", r10);
    L12:
        Intrinsics.checkNotNullParameter(r5, "$this$afterConfigureRequest");
        Observable r12 = ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/growth/touch_position/ack/", TypesJVMKt.getJavaType(Reflection.typeOf(Unit.class)), Extra.class, r5.d, r5.a, r5.b, r5.c);
        int r13 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r12.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(r0, r15), new com.bytedance.android.live.profit.privilege.datalayer.o(r0, r15)), r0.a);
    }

    @Override // com.bytedance.android.live.profit.privilege.a
    public final void vo(long r7, String r9, String r10, String r12) {
        this.e.c(r7, r9, r10, r12);
    }

    public PrivilegeService(com.bytedance.android.live.revenue.core.a r2, xu0.a r3, PrivilegeFuncService r4, com.bytedance.android.live.profit.privilege.datalayer.a r5, com.bytedance.android.live.profit.privilege.datalayer.d r6) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        Intrinsics.checkNotNullParameter(r3, "myScope");
        Intrinsics.checkNotNullParameter(r4, "funService");
        Intrinsics.checkNotNullParameter(r5, "dataService");
        Intrinsics.checkNotNullParameter(r6, "repository");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.b = new CompositeDisposable();
    }
}
