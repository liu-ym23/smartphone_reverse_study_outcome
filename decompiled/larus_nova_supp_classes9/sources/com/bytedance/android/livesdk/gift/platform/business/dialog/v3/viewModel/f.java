package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.z1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.m0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.CardType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.GiftPanelIconSource;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements Runnable {
    public final /* synthetic */ vz1.e a;
    public final /* synthetic */ GiftPanelIconSource b;
    public final /* synthetic */ String c;
    public final /* synthetic */ List d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Ref.BooleanRef h;
    public final /* synthetic */ int i;
    public final /* synthetic */ int j;
    public final /* synthetic */ Ref.ObjectRef k;
    public final /* synthetic */ int l;
    public final /* synthetic */ GiftMVIVerticalListViewModel m;
    public final /* synthetic */ int n;
    public final /* synthetic */ z1 o;
    public final /* synthetic */ int p;
    public final /* synthetic */ String q;
    public final /* synthetic */ Ref.ObjectRef r;
    public final /* synthetic */ List s;

    public f(vz1.e r3, GiftPanelIconSource r4, String r5, List r6, boolean r7, String r8, String r9, Ref.BooleanRef r10, int r11, int r13, Ref.ObjectRef r14, int r15, GiftMVIVerticalListViewModel r16, int r17, z1 r18, int r19, String r110, Ref.ObjectRef r20, List r21) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
        this.p = r19;
        this.q = r110;
        this.r = r20;
        this.s = r21;
    }

    public final void a() {
        u1 r2 = this.m.b1;
        vz1.e r1 = this.a;
        long r3 = r1.b;
        h1 r5 = r1.a;
        boolean r6 = !r1.e;
        com.bytedance.android.livesdk.gift.platform.core.model.k r7 = r1.x;
        if (r7 == null) goto L5;
        int r8 = r7.a;
    L6:
        m0.e.getClass();
        boolean r9 = m0.a.a(r1);
        Integer r4 = (Integer) ((LinkedHashMap) this.m.L0.c).get(Integer.valueOf(this.n));
        if (r4 == null) goto L9;
        int r10 = r4.intValue();
    L10:
        int r11 = this.n;
        int r13 = this.m.B1(r11);
        GiftPanelIconSource r14 = this.b;
        String r15 = this.c;
        List r16 = this.d;
        boolean r17 = this.e;
        String r18 = this.f;
        String r19 = this.g;
        boolean r20 = this.h.element;
        int r21 = this.i;
        int r23 = this.j;
        Integer r24 = Integer.valueOf(this.a.a.getGiftSource());
        int r25 = this.p;
        vz1.e r26 = this.a;
        u1.x0(r2, r3, r5, r6, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26.y, this.q, this.m.T, (CardType) this.k.element, false, null, null, r26.z, (u1.b) this.r.element, 58720256);
        return;
    L9:
        r10 = 0;
        goto L10
    L5:
        r8 = this.l + 1;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
