package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.u0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftMVICarnivalDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ComboState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftComboState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.q2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ GiftMVIVerticalListViewModel a;
    public final /* synthetic */ l0 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ GiftVerticalState d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ vz1.e g;
    public final /* synthetic */ int h;
    public final /* synthetic */ int i;
    public final /* synthetic */ n j;

    public k(GiftMVIVerticalListViewModel r1, l0 r2, int r3, GiftVerticalState r4, int r5, int r6, vz1.e r7, int r8, int r9, n r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public final void accept(Object r15) {
        if (((Boolean) r15).booleanValue() == false) goto L32;
        int r16 = this.c;
        l0 r0 = this.b;
        u0<GiftVerticalState, GiftComboState> r1 = this.d.getComboState();
        r0.getClass();
        int r4 = r16 - ((Number) com.bytedance.android.anya.h.b(((GiftComboState) com.bytedance.android.anya.h.b(r1)).getComboNum())).intValue();
        GiftMVIVerticalListViewModel r17 = this.a;
        l0 r2 = this.b;
        GiftVerticalState r3 = this.d;
        int r5 = this.e;
        int r6 = this.f;
        r17.getClass();
        GiftMVIVerticalListViewModel.y3(r2, r3, r5, r6, r4);
        l0 r18 = this.b;
        u0<GiftVerticalState, GiftComboState> r7 = this.d.getComboState();
        r18.getClass();
        boolean r8 = true;
        if (((ComboState) com.bytedance.android.anya.h.b(((GiftComboState) com.bytedance.android.anya.h.b(r7)).getComboStatus())) != ComboState.IDLE) goto L22;
        vz1.e r19 = this.g;
        if (r19 == null) goto L9;
        Long r110 = Long.valueOf(r19.b);
    L10:
        String r111 = String.valueOf(r110);
        GiftMVICarnivalDataStore r9 = this.a.g2;
        vz1.e r10 = this.g;
        if (r10 != null) goto L13;
    L15:
        String r11 = null;
    L16:
        if (r10 != null) goto L18;
    L20:
        String r13 = null;
    L21:
        r9.k.K5().onNext(new q2.a(r11, r13, 0, false, 0, null, 60));
        goto L22
    L18:
        if (r10.e != true) goto L20;
        r13 = r111;
        goto L21
    L13:
        if (r10.e == true) goto L15;
        r11 = r111;
        goto L16
    L9:
        r110 = null;
    L22:
        SubStatePropertyImpl r112 = this.d.getComboState();
        new k0.a();
        GiftComboState r113 = (GiftComboState) r112.c();
        r113.getComboNum().a(Integer.valueOf(this.c));
        r113.getComboStatus().a(ComboState.ON_SINGLE_CLICK);
        r113.getPositionX().a(Integer.valueOf(this.h));
        r113.getPositionY().a(Integer.valueOf(this.i));
        com.bytedance.android.anya.internal.c r114 = r113.isSingleTap();
        vz1.e r14 = this.g;
        if (r14 == null) goto L30;
        h1 r20 = r14.a;
        if (r20 == null) goto L30;
        if (r20.isSupportLongPressCombo() != true) goto L30;
        r8 = false;
    L30:
        r114.a(Boolean.valueOf(r8));
        GiftMVIVerticalListViewModel r21 = this.a;
        r21.D3(this.b, this.d, r4, 4, this.g, r21.A, r21.B, this.j);
        return;
    L32:
        if (this.a.p1.j() == true) goto L36;
        GiftMVIVerticalListViewModel r115 = this.a;
        y.d(r115.L2, r115.H2.a);
        return;
    }
}
