package x02;

import com.bytedance.android.livesdk.gift.model.GiftMsgBoard;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.PropListService;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends d0 {
    public h() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final y a(com.bytedance.android.livesdk.gift.platform.core.model.t r16, y r17, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r18, Function1<? super y, Unit> r19) {
        Intrinsics.checkNotNullParameter(r16, "info");
        Intrinsics.checkNotNullParameter(r17, "response");
        Intrinsics.checkNotNullParameter(r18, "listener");
        Intrinsics.checkNotNullParameter(r19, "nextPlugin");
        if (r16.i().c == SendGiftSource.GiftDialog) goto L31;
        SendGiftSource r1 = r16.i().c;
        SendGiftSource r3 = SendGiftSource.JsbPage;
        if (r1 != r3) goto L25;
        i12.e r2 = i12.o.b();
        if (r2 == null) goto L9;
        Object r4 = com.bytedance.android.scope.m.e.d(r2, GiftExtraRepo.class);
    L10:
        GiftExtraRepo r5 = (GiftExtraRepo) r4;
        if (r5 == null) goto L15;
        g0 r6 = r5.q(r16.i().b);
        if (r6 == null) goto L15;
        com.bytedance.android.livesdk.gift.model.p r7 = r6.getDiyGiftToolbarInfo();
    L16:
        if (r7 != null) goto L31;
        h2 r8 = GiftManagerKt.l(r16.i().b);
        if (r8 == null) goto L22;
        Intrinsics.checkNotNullParameter(r8, "$this$isMessageBoardGift");
        GiftMsgBoard r9 = l0.b(r8);
        if (r9 == null) goto L22;
        boolean r10 = r9.forMsgBoard;
    L23:
        if (r10 == true) goto L31;
    L22:
        r10 = false;
    L15:
        r7 = null;
        goto L16
    L9:
        r4 = null;
    L25:
        if (r16.i().c != r3) goto L29;
        if (r16.i().O == true) goto L31;
    L29:
        if (r16.i().z != null) goto L31;
    L110:
        return r17;
    L31:
        if (r16.i().r == true) goto L33;
        long r11 = r16.i().b;
    L45:
        i12.e r13 = i12.o.b();
        if (r13 == null) goto L48;
        Object r14 = com.bytedance.android.scope.m.e.d(r13, GiftExtraRepo.class);
    L49:
        GiftExtraRepo r15 = (GiftExtraRepo) r14;
        if (r15 == null) goto L54;
        Long r20 = r15.s(r11);
        if (r20 == null) goto L54;
        r11 = r20.longValue();
    L54:
        int r21 = r16.i().l;
        String r23 = gz1.c.a(r16.i().n, 1);
        int r110 = r16.i().y;
        String r24 = r16.i().M;
        if (r11 <= 0) goto L110;
        GiftContext r25 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r25 == null) goto L62;
        com.bytedance.live.datacontext.m<GiftContext.a> r26 = r25.getLastSendGiftId();
        if (r26 == null) goto L62;
        r26.setValue(new GiftContext.a(r11, r21, r110));
    L62:
        i12.e r27 = i12.o.b();
        if (r27 == null) goto L65;
        Object r28 = com.bytedance.android.scope.m.e.d(r27, GiftExtraRepo.class);
    L66:
        GiftExtraRepo r29 = (GiftExtraRepo) r28;
        if (r29 == null) goto L78;
        g0 r30 = r29.q(r11);
        if (r30 == null) goto L78;
        List<l1> r31 = r30.getGiftBuffInfos();
        if (r31 == null) goto L78;
        if ((!r31.isEmpty()) == true) goto L76;
        r31 = null;
    L76:
        if (r31 == null) goto L78;
        HashMap<String, String> r33 = ay1.b.c();
        r33.put(String.valueOf(r11), String.valueOf(r21));
        Intrinsics.checkNotNullParameter(r33, "<set-?>");
        com.bytedance.tools.kcp.spongepreference.runtime.a r111 = ay1.b.G;
        KProperty[] r112 = ay1.b.a;
        r111.setValue(null, r112[37], r33);
        HashMap<String, String> r34 = ay1.b.d();
        r34.put(String.valueOf(r11), String.valueOf(vh6.c.b(vr2.e.class).w4() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
        Intrinsics.checkNotNullParameter(r34, "<set-?>");
        ay1.b.H.setValue(null, r112[38], r34);
    L78:
        i12.e r35 = i12.o.b();
        if (r35 == null) goto L81;
        Object r36 = com.bytedance.android.scope.m.e.d(r35, GiftExtraRepo.class);
    L82:
        GiftExtraRepo r37 = (GiftExtraRepo) r36;
        if (r37 == null) goto L87;
        l1 r38 = r37.o(r21, r11);
        if (r38 == null) goto L87;
        long r39 = r38.getBuffGiftId();
        HashMap<String, String> r40 = ay1.b.e();
        r40.put(String.valueOf(r39), "3");
        ay1.b.x(r40);
    L87:
        i12.e r41 = i12.o.b();
        if (r41 == null) goto L90;
        Object r43 = com.bytedance.android.scope.m.e.d(r41, GiftExtraRepo.class);
    L91:
        GiftExtraRepo r44 = (GiftExtraRepo) r43;
        if (r44 == null) goto L109;
        g0 r45 = r44.q(r11);
        if (r45 == null) goto L109;
        com.bytedance.android.livesdk.gift.model.p r46 = r45.getDiyGiftToolbarInfo();
        if (r46 == null) goto L109;
        HashMap<String, String> r47 = ay1.b.h();
        r47.put(String.valueOf(r11), String.valueOf(vh6.c.b(vr2.e.class).w4() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
        Intrinsics.checkNotNullParameter(r47, "<set-?>");
        com.bytedance.tools.kcp.spongepreference.runtime.a r48 = ay1.b.B;
        KProperty[] r113 = ay1.b.a;
        r48.setValue(null, r113[30], r47);
        HashMap<String, String> r49 = ay1.b.g();
        String r50 = String.valueOf(r11);
        if (r23 != null) goto L100;
        String r114 = BuildConfig.FLAVOR;
    L101:
        r49.put(r50, r114);
        Intrinsics.checkNotNullParameter(r49, "<set-?>");
        ay1.b.z.setValue(null, r113[28], r49);
        HashMap<String, String> r51 = ay1.b.f();
        String r53 = String.valueOf(r11);
        String r54 = gz1.a.a(r46, r23);
        if (r54 != null) goto L104;
        r54 = BuildConfig.FLAVOR;
    L104:
        r51.put(r53, r54);
        if ((!Intrinsics.areEqual(r24, BuildConfig.FLAVOR)) == false) goto L108;
        if (r24 == null) goto L108;
        r51.put(String.valueOf(r11), r24);
    L108:
        Intrinsics.checkNotNullParameter(r51, "<set-?>");
        ay1.b.A.setValue(null, r113[29], r51);
        goto L109
    L100:
        r114 = r23;
    L109:
        HashSet<String> r55 = ay1.b.j();
        r55.add(String.valueOf(r11));
        Intrinsics.checkNotNullParameter(r55, "<set-?>");
        ay1.b.o.setValue(null, ay1.b.a[17], r55);
        goto L110
    L90:
        r43 = null;
        goto L91
    L81:
        r36 = null;
        goto L82
    L65:
        r28 = null;
        goto L66
    L48:
        r14 = null;
        goto L49
    L33:
        i12.e r56 = i12.o.b();
        if (r56 == null) goto L36;
        Object r57 = com.bytedance.android.scope.m.e.d(r56, PropListService.class);
    L37:
        PropListService r58 = (PropListService) r57;
        if (r58 == null) goto L44;
        l2 r59 = r58.f(Long.valueOf(r16.i().b));
        if (r59 == null) goto L44;
        h1 r60 = r59.getGift();
        if (r60 == null) goto L44;
        r11 = r60.getId();
    L44:
        r11 = 0;
        goto L45
    L36:
        r57 = null;
        goto L37
    }
}
