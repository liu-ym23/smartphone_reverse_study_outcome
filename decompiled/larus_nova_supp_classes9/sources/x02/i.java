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
public final class i extends d0 {
    public i() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final y b(com.bytedance.android.livesdk.gift.platform.core.model.t r17, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r18, Function1<? super y, Unit> r19) {
        Intrinsics.checkNotNullParameter(r17, "info");
        Intrinsics.checkNotNullParameter(r18, "listener");
        Intrinsics.checkNotNullParameter(r19, "nextPlugin");
        if (r17.i().c == SendGiftSource.GiftDialog) goto L25;
        if (r17.i().c != SendGiftSource.JsbPage) goto L105;
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L9;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftExtraRepo.class);
    L10:
        GiftExtraRepo r2 = (GiftExtraRepo) r1;
        if (r2 == null) goto L15;
        g0 r3 = r2.q(r17.i().b);
        if (r3 == null) goto L15;
        com.bytedance.android.livesdk.gift.model.p r4 = r3.getDiyGiftToolbarInfo();
    L16:
        if (r4 != null) goto L25;
        h2 r5 = GiftManagerKt.l(r17.i().b);
        if (r5 == null) goto L22;
        Intrinsics.checkNotNullParameter(r5, "$this$isMessageBoardGift");
        GiftMsgBoard r6 = l0.b(r5);
        if (r6 == null) goto L22;
        boolean r7 = r6.forMsgBoard;
    L23:
        if (r7 == false) goto L105;
    L22:
        r7 = false;
    L15:
        r4 = null;
        goto L16
    L9:
        r1 = null;
    L105:
        return y.d.c;
    L25:
        if (r17.i().r == true) goto L27;
        long r8 = r17.i().b;
    L39:
        i12.e r9 = i12.o.b();
        if (r9 == null) goto L42;
        Object r10 = com.bytedance.android.scope.m.e.d(r9, GiftExtraRepo.class);
    L43:
        GiftExtraRepo r11 = (GiftExtraRepo) r10;
        if (r11 == null) goto L48;
        Long r13 = r11.s(r8);
        if (r13 == null) goto L48;
        r8 = r13.longValue();
    L48:
        int r14 = r17.i().l;
        String r15 = gz1.c.a(r17.i().n, 1);
        int r16 = r17.i().y;
        String r20 = r17.i().M;
        if (r8 <= 0) goto L105;
        GiftContext r21 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r21 == null) goto L56;
        com.bytedance.live.datacontext.m<GiftContext.a> r23 = r21.getLastSendGiftId();
        if (r23 == null) goto L56;
        r23.setValue(new GiftContext.a(r8, r14, r16));
    L56:
        i12.e r24 = i12.o.b();
        if (r24 == null) goto L59;
        Object r25 = com.bytedance.android.scope.m.e.d(r24, GiftExtraRepo.class);
    L60:
        GiftExtraRepo r26 = (GiftExtraRepo) r25;
        if (r26 == null) goto L72;
        g0 r27 = r26.q(r8);
        if (r27 == null) goto L72;
        List<l1> r28 = r27.getGiftBuffInfos();
        if (r28 == null) goto L72;
        if ((!r28.isEmpty()) == true) goto L70;
        r28 = null;
    L70:
        if (r28 == null) goto L72;
        HashMap<String, String> r29 = ay1.b.c();
        r29.put(String.valueOf(r8), String.valueOf(r14));
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        com.bytedance.tools.kcp.spongepreference.runtime.a r110 = ay1.b.G;
        KProperty[] r111 = ay1.b.a;
        r110.setValue(null, r111[37], r29);
        HashMap<String, String> r30 = ay1.b.d();
        r30.put(String.valueOf(r8), String.valueOf(vh6.c.b(vr2.e.class).w4() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        ay1.b.H.setValue(null, r111[38], r30);
    L72:
        i12.e r31 = i12.o.b();
        if (r31 == null) goto L75;
        Object r33 = com.bytedance.android.scope.m.e.d(r31, GiftExtraRepo.class);
    L76:
        GiftExtraRepo r34 = (GiftExtraRepo) r33;
        if (r34 == null) goto L81;
        l1 r35 = r34.o(r14, r8);
        if (r35 == null) goto L81;
        long r112 = r35.getBuffGiftId();
        HashMap<String, String> r36 = ay1.b.e();
        r36.put(String.valueOf(r112), "3");
        ay1.b.x(r36);
    L81:
        i12.e r37 = i12.o.b();
        if (r37 == null) goto L84;
        Object r38 = com.bytedance.android.scope.m.e.d(r37, GiftExtraRepo.class);
    L85:
        GiftExtraRepo r39 = (GiftExtraRepo) r38;
        if (r39 == null) goto L103;
        g0 r40 = r39.q(r8);
        if (r40 == null) goto L103;
        com.bytedance.android.livesdk.gift.model.p r41 = r40.getDiyGiftToolbarInfo();
        if (r41 == null) goto L103;
        HashMap<String, String> r43 = ay1.b.h();
        r43.put(String.valueOf(r8), String.valueOf(vh6.c.b(vr2.e.class).w4() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
        Intrinsics.checkNotNullParameter(r43, "<set-?>");
        com.bytedance.tools.kcp.spongepreference.runtime.a r44 = ay1.b.B;
        KProperty[] r113 = ay1.b.a;
        r44.setValue(null, r113[30], r43);
        HashMap<String, String> r45 = ay1.b.g();
        String r46 = String.valueOf(r8);
        if (r15 != null) goto L94;
        String r114 = BuildConfig.FLAVOR;
    L95:
        r45.put(r46, r114);
        Intrinsics.checkNotNullParameter(r45, "<set-?>");
        ay1.b.z.setValue(null, r113[28], r45);
        HashMap<String, String> r47 = ay1.b.f();
        String r48 = String.valueOf(r8);
        String r49 = gz1.a.a(r41, r15);
        if (r49 != null) goto L98;
        r49 = BuildConfig.FLAVOR;
    L98:
        r47.put(r48, r49);
        if ((!Intrinsics.areEqual(r20, BuildConfig.FLAVOR)) == false) goto L102;
        if (r20 == null) goto L102;
        r47.put(String.valueOf(r8), r20);
    L102:
        Intrinsics.checkNotNullParameter(r47, "<set-?>");
        ay1.b.A.setValue(null, r113[29], r47);
        goto L103
    L94:
        r114 = r15;
    L103:
        HashSet<String> r50 = ay1.b.j();
        r50.add(String.valueOf(r8));
        Intrinsics.checkNotNullParameter(r50, "<set-?>");
        ay1.b.o.setValue(null, ay1.b.a[17], r50);
        goto L105
    L84:
        r38 = null;
        goto L85
    L75:
        r33 = null;
        goto L76
    L59:
        r25 = null;
        goto L60
    L42:
        r10 = null;
        goto L43
    L27:
        i12.e r51 = i12.o.b();
        if (r51 == null) goto L30;
        Object r53 = com.bytedance.android.scope.m.e.d(r51, PropListService.class);
    L31:
        PropListService r54 = (PropListService) r53;
        if (r54 == null) goto L38;
        l2 r55 = r54.f(Long.valueOf(r17.i().b));
        if (r55 == null) goto L38;
        h1 r56 = r55.getGift();
        if (r56 == null) goto L38;
        r8 = r56.getId();
    L38:
        r8 = 0;
        goto L39
    L30:
        r53 = null;
        goto L31
    }
}
