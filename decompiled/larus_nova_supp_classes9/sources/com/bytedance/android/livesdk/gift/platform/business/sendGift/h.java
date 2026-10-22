package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.s2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.keva_store.RevDataStoreKevaUtil;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftMessageService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.d1;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.keva.Keva;
import i12.o;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ GiftTransaction a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public h(GiftTransaction r1, int r2, long r3, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
    }

    public final void accept(Object r23) {
        Disposable r1 = (Disposable) r23;
        if (this.b == 1) goto L5;
    L116:
        int r6 = -1;
    L118:
        if (com.bytedance.android.livesdk.gift.platform.core.f.a().J4() == false) goto L121;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.R(this.d, this.a.x, this.b, this.e, "0", r6);
        return;
    L121:
        return;
    L5:
        if (com.bytedance.android.livesdk.gift.platform.core.f.a().getEnable() == false) goto L116;
        long r3 = this.c;
        GiftTransaction r2 = this.a;
        b0 r5 = r2.x;
        String r7 = this.d;
        DataCenter r4 = r2.z;
        Intrinsics.checkNotNullParameter(r5, "giftParams");
        Intrinsics.checkNotNullParameter(r7, "sendTransactionId");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        int r10 = 2;
        if (r5.H != null) goto L10;
    L115:
        r6 = r10;
        goto L118
    L10:
        if (r5.q == 1) goto L12;
        r10 = 3;
        goto L115
    L12:
        List<IBaseUser> r9 = r5.w;
        if (r9 == null) goto L15;
        int r11 = r9.size();
    L16:
        if (r11 <= 1) goto L18;
        r10 = 4;
        goto L115
    L18:
        long r13 = r5.b;
        Object r15 = null;
        if (r5.l <= 0) goto L29;
        i12.e r14 = o.b();
        if (r14 == null) goto L23;
        Object r16 = com.bytedance.android.scope.m.e.d(r14, GiftExtraRepo.class);
    L24:
        GiftExtraRepo r17 = (GiftExtraRepo) r16;
        if (r17 == null) goto L29;
        long r18 = r3;
        l1 r8 = r17.o(r5.l, r5.b);
        if (r8 == null) goto L30;
        r13 = r8.getBuffGiftId();
    L30:
        h1 r19 = GiftManagerKt.j(r13, null);
        if (r19 != null) goto L33;
    L114:
        r10 = 5;
        goto L115
    L33:
        if (r19.getType() != 2) goto L114;
        List<Long> r20 = r19.getAssetIds();
        if (r20 != null) goto L38;
    L41:
        boolean r21 = true;
    L42:
        if (r21 == false) goto L44;
    L113:
        r10 = 6;
        goto L115
    L44:
        if (r19.getAssetIds().size() > 1) goto L113;
        i12.e r24 = o.b();
        if (r24 == null) goto L49;
        Object r25 = com.bytedance.android.scope.m.e.d(r24, GiftExtraRepo.class);
    L50:
        GiftExtraRepo r26 = (GiftExtraRepo) r25;
        if (r26 == null) goto L112;
        g0 r27 = r26.q(r13);
        if (r27 == null) goto L112;
        if (r27.getGiftPlayNowStrategy() == 1) goto L58;
        r10 = 8;
        goto L115
    L58:
        i12.e r28 = o.b();
        if (r28 == null) goto L61;
        Object r29 = com.bytedance.android.scope.m.e.d(r28, d1.class);
    L62:
        d1 r30 = (d1) r29;
        long r110 = -1;
        if (r30 != null) goto L65;
        long r31 = -1;
    L73:
        long r210 = com.bytedance.live.kmp.util.e.b();
        if (r30 != null) goto L76;
    L83:
        long r33 = r210 - r31;
        long r211 = r210 - r110;
        int r34 = (com.bytedance.android.livesdk.gift.platform.core.f.a().S8() * 60) * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        int r111 = (com.bytedance.android.livesdk.gift.platform.core.f.a().s0() * 60) * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        if (r33 <= r34) goto L86;
    L111:
        r10 = 9;
        goto L115
    L86:
        if (r211 < r111) goto L111;
        com.bytedance.android.live.core.resources.e r35 = ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).G1(r19.getPrimaryEffectId());
        if (r35 != null) goto L91;
    L110:
        r10 = 10;
        goto L115
    L91:
        if (r35.getResourceType() != 4) goto L110;
        IBaseUser r36 = (IBaseUser) r4.get("data_user_in_room", null);
        if (r36 != null) goto L96;
        r10 = 11;
        goto L115
    L96:
        List<IBaseUser> r37 = r5.w;
        if (r37 == null) goto L99;
        IBaseUser r38 = (IBaseUser) CollectionsKt.firstOrNull(r37);
    L100:
        IRoom r39 = r5.H;
        Intrinsics.checkNotNull(r39);
        long r40 = r39.getRoomId();
        Intrinsics.checkNotNullParameter(r5, "giftParams");
        Intrinsics.checkNotNullParameter(r36, "userInRoom");
        Intrinsics.checkNotNullParameter(r7, "sendTransactionId");
        Intrinsics.checkNotNullParameter(r19, "gift");
        o7 r41 = vh7.f.c(o7.class);
        m0 r43 = vh7.f.c(m0.class);
        r43.setRoomId(r40);
        r43.setMessageId(System.currentTimeMillis());
        r43.setShowMsg(true);
        r41.setCommonData(r43);
        r41.setFromUser(r36);
        r41.setGift(r19);
        r41.setRepeatCount(1);
        r41.setGiftId(r19.getId());
        r41.setToUser(r38);
        r41.setComboCount(1);
        r41.setGroupCount(1);
        r41.setLocal(true);
        r41.setLocalInsertMsg(true);
        r41.setTraceId(r7);
        r41.setSendGiftTime(r18);
        r41.setClientGiftSource(r5.g);
        r41.setCount(1);
        if (r38 == null) goto L103;
        r41.setToUserIdString(CollectionsKt.listOf(r38.getIdString()));
    L103:
        s2 r44 = new s2(r41);
        ConcurrentHashMap<String, Map<String, Long>> r45 = v12.e.a;
        v12.e.b(r7, "send_success", com.bytedance.live.kmp.util.e.b());
        i12.e r46 = o.b();
        if (r46 == null) goto L106;
        r15 = com.bytedance.android.scope.m.e.d(r46, GiftMessageService.class);
    L106:
        GiftMessageService r112 = (GiftMessageService) r15;
        if (r112 == null) goto L109;
        Intrinsics.checkNotNullParameter(r44, "mockLocalGiftMessage");
        r112.d.setValue(r44);
    L109:
        r10 = 0;
        goto L115
    L99:
        r38 = null;
        goto L100
    L76:
        if (r30.b != (-1)) goto L82;
        Keva r113 = (Keva) RevDataStoreKevaUtil.a.getValue();
        if (r113 == null) goto L80;
        long r114 = r113.getLong("last_consume_fail_time", 0);
    L81:
        r30.b = r114;
        goto L82
    L80:
        r114 = -10;
    L82:
        r110 = r30.b;
        goto L83
    L65:
        if (r30.a != (-1)) goto L71;
        Keva r47 = (Keva) RevDataStoreKevaUtil.a.getValue();
        if (r47 == null) goto L69;
        long r48 = r47.getLong("last_consume_time", 0);
    L70:
        r30.a = r48;
        goto L71
    L69:
        r48 = -10;
    L71:
        r31 = r30.a;
        goto L73
    L61:
        r29 = null;
    L112:
        r10 = 7;
        goto L115
    L49:
        r25 = null;
        goto L50
    L38:
        if (r20.isEmpty() == true) goto L41;
        r21 = false;
        goto L42
    L23:
        r16 = null;
    L29:
        r18 = r3;
        goto L30
    L15:
        r11 = 0;
        goto L16
    }
}
