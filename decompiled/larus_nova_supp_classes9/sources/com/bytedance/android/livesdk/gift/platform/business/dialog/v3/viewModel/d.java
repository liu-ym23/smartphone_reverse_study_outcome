package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.internal.t;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.anya.u0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftMVICarnivalDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ComboState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftComboState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemStatus;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.q2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ GiftMVISearchViewModel a;
    public final /* synthetic */ l0 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ GiftSearchViewState d;
    public final /* synthetic */ int e;
    public final /* synthetic */ vz1.e f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ n i;

    public d(GiftMVISearchViewModel r1, l0 r2, int r3, GiftSearchViewState r4, int r5, vz1.e r6, int r7, int r8, n r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public final void accept(Object r15) {
        if (((Boolean) r15).booleanValue() == false) goto L45;
        int r16 = this.c;
        l0 r0 = this.b;
        u0<GiftSearchViewState, GiftComboState> r1 = this.d.getComboState();
        r0.getClass();
        int r4 = r16 - ((Number) com.bytedance.android.anya.h.b(((GiftComboState) com.bytedance.android.anya.h.b(r1)).getComboNum())).intValue();
        l0 r17 = this.b;
        GiftSearchViewState r2 = this.d;
        int r3 = this.e;
        t0<GiftSearchViewState, ItemListData> r5 = r2.getSearchItemDataList();
        r17.getClass();
        int r18 = com.bytedance.android.anya.h.a(r5);
        boolean r6 = true;
        if (r18 <= r3) goto L17;
        if (r3 < 0) goto L17;
        u r19 = r2.getSearchItemDataList();
        MVIState r7 = (MVIState) ((s0) r19.c()).get(r3);
        new k0.a();     // Catch: Throwable -> L12
        ((ItemListData) r7).getItemStatus().a(ItemStatus.GONE);     // Catch: Throwable -> L12
        if ((!r7.modifiedProperties.isEmpty()) == false) goto L17;
        ((t) r19.c()).d(r3);
    L12:
        th = move-exception;
        if ((!r7.modifiedProperties.isEmpty()) == false) goto L16;
        ((t) r19.c()).d(r3);
    L16:
        throw th;
    L17:
        l0 r110 = this.b;
        u0<GiftSearchViewState, GiftComboState> r8 = this.d.getComboState();
        r110.getClass();
        if (((ComboState) com.bytedance.android.anya.h.b(((GiftComboState) com.bytedance.android.anya.h.b(r8)).getComboStatus())) != ComboState.IDLE) goto L35;
        vz1.e r111 = this.f;
        if (r111 == null) goto L22;
        Long r112 = Long.valueOf(r111.b);
    L23:
        String r113 = String.valueOf(r112);
        GiftMVICarnivalDataStore r9 = this.a.Y;
        vz1.e r10 = this.f;
        if (r10 != null) goto L26;
    L28:
        String r11 = null;
    L29:
        if (r10 != null) goto L31;
    L33:
        String r13 = null;
    L34:
        r9.k.K5().onNext(new q2.a(r11, r13, 0, false, 0, null, 60));
        goto L35
    L31:
        if (r10.e != true) goto L33;
        r13 = r113;
        goto L34
    L26:
        if (r10.e == true) goto L28;
        r11 = r113;
        goto L29
    L22:
        r112 = null;
    L35:
        SubStatePropertyImpl r114 = this.d.getComboState();
        new k0.a();
        GiftComboState r115 = (GiftComboState) r114.c();
        r115.getComboNum().a(Integer.valueOf(this.c));
        r115.getComboStatus().a(ComboState.ON_SINGLE_CLICK);
        r115.getPositionX().a(Integer.valueOf(this.g));
        r115.getPositionY().a(Integer.valueOf(this.h));
        com.bytedance.android.anya.internal.c r116 = r115.isSingleTap();
        vz1.e r14 = this.f;
        if (r14 == null) goto L43;
        h1 r20 = r14.a;
        if (r20 == null) goto L43;
        if (r20.isSupportLongPressCombo() != true) goto L43;
        r6 = false;
    L43:
        r116.a(Boolean.valueOf(r6));
        GiftMVISearchViewModel r21 = this.a;
        r21.x1(this.b, this.d, r4, 4, this.f, r21.y, r21.z, this.i);
        return;
    L45:
        if (this.a.S.j() == true) goto L51;
        GiftMVISearchViewModel r117 = this.a;
        y.d(r117.p0, r117.G.a);
        return;
    }
}
