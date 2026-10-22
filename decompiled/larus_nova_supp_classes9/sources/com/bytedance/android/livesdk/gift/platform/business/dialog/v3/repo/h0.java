package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftSearchDataStore;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftStrategy;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h0 implements com.bytedance.android.scope.o {
    public GiftTransaction a;
    public final i12.e b;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a c;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.b d;
    public final u1 e;
    public final com.bytedance.android.livesdk.gift.platform.core.scope.service.w0 f;
    public final yz0.k g;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f h;
    public final GiftSearchDataStore i;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y j;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void a(int r61, vz1.e r63, com.bytedance.android.livesdk.gift.platform.core.model.n r64, String r65, String r66, Function0 r67) {
        Intrinsics.checkNotNullParameter(r63, "iconModel");
        Intrinsics.checkNotNullParameter(r64, "showInfo");
        Intrinsics.checkNotNullParameter(r67, "finishAction");
        boolean r58 = this.c.j();
        GiftTransaction r2 = this.a;
        if (r2 != null) goto L5;
    L11:
        if (r2 == null) goto L13;
        r2.finish();
    L13:
        long r3 = r63.b;
        SendGiftSource r4 = SendGiftSource.GiftDialog;
        IBaseUser r5 = this.h.a;
        Long r6 = Long.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r5));
        boolean r13 = r63.e;
        if (r58 == false) goto L16;
        List<IBaseUser> r9 = this.c.i();
    L17:
        List<IBaseUser> r25 = r9;
        String r10 = r63.g.m;
        com.bytedance.android.livesdk.gift.platform.core.model.k r11 = this.e.g;
        int r14 = com.bytedance.android.livesdk.gift.platform.core.model.k.f;
        com.bytedance.android.livesdk.gift.platform.core.model.k r43 = com.bytedance.android.livesdk.gift.platform.core.model.k.a.a(r63.x);
        String r46 = r63.a.getSortExtra();
        String r15 = this.f.a;
        boolean r48 = this.i.s();
        String r49 = this.i.q();
        String r16 = this.i.j;
        com.bytedance.android.livesdk.gift.platform.core.model.a r1 = r63.z;
        GiftTransaction r7 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.p(new com.bytedance.android.livesdk.gift.platform.core.model.b0(r3, r4, r5, r6, 0, 0, null, null, null, null, 0, null, null, false, null, r61, r13, r10, 0, null, r58, r25, false, 0, null, null, null, r64, null, null, this.h.c, null, 0, 0, null, null, false, r11, r43, r65, r66, r46, r15, r48, r49, r16, null, r1, 0, null, null, -1211596832, 7995647));
        this.a = r7;
        if (r7 == null) goto L20;
        r7.h(new f0(r67));
    L20:
        if (r58 == false) goto L22;
    L24:
        GiftTransaction r8 = this.a;
        if (r8 == null) goto L28;
        r8.d(r61);
        return;
    L28:
        return;
    L22:
        if (iy0.e.b(this.g.getRoom()) == true) goto L24;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y.d(this.j, this.h.a);
        goto L24
    L16:
        r9 = null;
        goto L17
    L5:
        if (r2.b == true) goto L11;
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.gift.platform.core.model.b0 r17 = r2.x;
        if (r17 == null) goto L11;
        if (r17.q == r61) goto L24;
        goto L11
    }

    public static /* synthetic */ void d(h0 r9, int r10, vz1.e r11, com.bytedance.android.livesdk.gift.platform.core.model.n r13, l1 r14, com.bytedance.android.livesdk.gift.model.n r15, String r16, Function0 r17) {
        r9.c(r10, r11, r13, r14, r15, r16, null, r17);
    }

    public final void c(int r61, vz1.e r63, com.bytedance.android.livesdk.gift.platform.core.model.n r64, l1 r65, com.bytedance.android.livesdk.gift.model.n r66, String r67, String r68, Function0 r69) {
        Intrinsics.checkNotNullParameter(r63, "iconModel");
        Intrinsics.checkNotNullParameter(r64, "showInfo");
        Intrinsics.checkNotNullParameter(r69, "finishAction");
        if (r65 != null) goto L5;
    L7:
        l1 r2 = this.d.a;
        if (r2 == null) goto L11;
        int r3 = r2.getBuffLevel();
    L10:
        int r16 = r3;
    L12:
        List<IBaseUser> r4 = null;
        if (r66 != null) goto L15;
    L17:
        com.bytedance.android.livesdk.gift.model.n r5 = this.d.b;
        if (r5 == null) goto L21;
        ArrayList<e3> r6 = gz1.c.g(r5);
    L20:
        ArrayList<e3> r17 = r6;
    L22:
        boolean r58 = this.c.j();
        GiftTransaction r7 = this.a;
        if (r7 != null) goto L25;
    L31:
        if (r7 == null) goto L33;
        r7.finish();
    L33:
        long r8 = r63.b;
        SendGiftSource r9 = SendGiftSource.GiftDialog;
        IBaseUser r10 = this.h.a;
        Long r11 = Long.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r10));
        boolean r13 = r63.e;
        if (r58 == false) goto L36;
        r4 = this.c.i();
    L36:
        List<IBaseUser> r25 = r4;
        com.bytedance.android.livesdk.gift.model.n r14 = this.d.b;
        if (r14 == null) goto L39;
        long r15 = r14.getConfigId();
    L40:
        String r18 = r63.g.m;
        com.bytedance.android.livesdk.gift.platform.core.model.k r19 = this.e.g;
        int r20 = com.bytedance.android.livesdk.gift.platform.core.model.k.f;
        com.bytedance.android.livesdk.gift.platform.core.model.k r43 = com.bytedance.android.livesdk.gift.platform.core.model.k.a.a(r63.x);
        String r46 = r63.a.getSortExtra();
        String r21 = this.f.a;
        com.bytedance.android.livesdk.gift.platform.core.model.a r1 = r63.z;
        int r110 = r16;
        ArrayList<e3> r111 = r17;
        GiftTransaction r23 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.p(new com.bytedance.android.livesdk.gift.platform.core.model.b0(r8, r9, r10, r11, 0, 0, null, null, null, null, r110, null, r111, false, null, r61, r13, r18, 0, null, r58, r25, false, 0, null, null, null, r64, null, null, this.h.c, null, 0, r15, null, null, false, r19, r43, r67, r68, r46, r21, false, null, null, null, r1, 0, null, null, -1211601952, 8110327));
        this.a = r23;
        if (r23 == null) goto L43;
        r23.h(new g0(r69));
    L43:
        if (r58 == false) goto L45;
    L47:
        GiftTransaction r24 = this.a;
        if (r24 == null) goto L51;
        r24.d(r61);
        return;
    L51:
        return;
    L45:
        if (iy0.e.b(this.g.getRoom()) == true) goto L47;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y.d(this.j, this.h.a);
        goto L47
    L39:
        r15 = 0;
        goto L40
    L25:
        if (r7.b == true) goto L31;
        if (r7 == null) goto L31;
        com.bytedance.android.livesdk.gift.platform.core.model.b0 r26 = r7.x;
        if (r26 == null) goto L31;
        if (r26.q == r61) goto L47;
    L21:
        r17 = null;
        goto L22
    L15:
        if (nz1.a.s() == false) goto L17;
        r6 = gz1.c.g(r66);
        goto L20
    L11:
        r16 = 0;
        goto L12
    L5:
        if (nz1.a.r() == false) goto L7;
        r3 = r65.getBuffLevel();
        goto L10
    }

    public h0(i12.e r2, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r3, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.b r4, u1 r5, com.bytedance.android.livesdk.gift.platform.core.scope.service.w0 r6, yz0.k r7, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r8, GiftSearchDataStore r9, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y r10) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "allMicService");
        Intrinsics.checkNotNullParameter(r4, "buffRepository");
        Intrinsics.checkNotNullParameter(r5, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r6, "giftPanelLogServiceKmp");
        Intrinsics.checkNotNullParameter(r7, "roomDataService");
        Intrinsics.checkNotNullParameter(r8, "receiverService");
        Intrinsics.checkNotNullParameter(r9, "giftSearchDataStore");
        Intrinsics.checkNotNullParameter(r10, "giftSelectReceiverService");
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

    public final void f(int r63, int r64, vz1.e r65, int r66, ArrayList r67, boolean r68, Function0 r69, long r70, int r73, com.bytedance.android.livesdk.gift.platform.core.model.n r74, com.bytedance.android.livesdk.gift.platform.core.model.k r75, String r76, String r77) {
        Intrinsics.checkNotNullParameter(r65, "iconModel");
        Intrinsics.checkNotNullParameter(r69, "finishAction");
        Intrinsics.checkNotNullParameter(r74, "showInfo");
        boolean r3 = this.c.j();
        GiftTransaction r4 = this.a;
        if (r4 != null) goto L5;
    L11:
        if (r4 == null) goto L13;
        r4.finish();
    L13:
        long r5 = r65.b;
        SendGiftSource r7 = SendGiftSource.GiftDialog;
        IBaseUser r8 = this.h.a;
        Long r9 = Long.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r8));
        SendGiftStrategy r20 = SendGiftStrategy.REQUEST_AFTER_RESPONSE;
        boolean r10 = r65.e;
        if (r3 == false) goto L16;
        List<IBaseUser> r6 = this.c.i();
    L17:
        List<IBaseUser> r28 = r6;
        String r11 = r65.g.m;
        int r13 = com.bytedance.android.livesdk.gift.platform.core.model.k.f;
        com.bytedance.android.livesdk.gift.platform.core.model.k r46 = com.bytedance.android.livesdk.gift.platform.core.model.k.a.a(r65.x);
        String r49 = r65.a.getSortExtra();
        String r14 = this.f.a;
        boolean r51 = this.i.s();
        String r53 = this.i.q();
        String r15 = this.i.j;
        com.bytedance.android.livesdk.gift.platform.core.model.a r1 = r65.z;
        GiftTransaction r2 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.p(new com.bytedance.android.livesdk.gift.platform.core.model.b0(r5, r7, r8, r9, r64, 0, null, null, null, null, r66, null, r67, r68, r20, 0, r10, r11, 0, null, r3, r28, false, r73, null, null, null, r74, null, null, this.h.c, null, 0, r70, null, null, false, r75, r46, r76, r77, r49, r14, r51, r53, r15, null, r1, 0, null, null, -1219982368, 7995639));
        this.a = r2;
        if (r2 == null) goto L20;
        r2.h(new e0(r69));
    L20:
        if (r3 == false) goto L22;
    L24:
        GiftTransaction r16 = this.a;
        if (r16 == null) goto L28;
        r16.d(r63);
        return;
    L28:
        return;
    L22:
        if (iy0.e.b(this.g.getRoom()) == true) goto L24;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y.d(this.j, this.h.a);
        goto L24
    L16:
        r6 = null;
        goto L17
    L5:
        if (r4.b == true) goto L11;
        if (r4 == null) goto L11;
        com.bytedance.android.livesdk.gift.platform.core.model.b0 r17 = r4.x;
        if (r17 == null) goto L11;
        if (r17.q == 1) goto L24;
        goto L11
    }
}
