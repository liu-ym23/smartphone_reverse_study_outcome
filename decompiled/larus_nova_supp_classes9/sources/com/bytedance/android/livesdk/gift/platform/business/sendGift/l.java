package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.m2;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.y1;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.utils.c0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ GiftTransaction a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ String e;

    public l(GiftTransaction r1, int r2, int r3, long r4, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    public final void accept(Object r13) {
        ExtraResponse r14 = (ExtraResponse) r13;
        long r8 = com.bytedance.live.kmp.util.e.b();
        int r0 = c0.a;
        m2 r1 = (m2) r14.data;
        Intrinsics.checkNotNullParameter(r1, "data");
        p2 r2 = (p2) vh7.f.c(p2.class);
        String r3 = r1.getLogId();
        String r4 = BuildConfig.FLAVOR;
        if (r3 != null) goto L5;
        r3 = BuildConfig.FLAVOR;
    L5:
        r2.setLogId(r3);
        r2.setDisplayText(r1.getDisplayText());
        r2.setFanTicketCount(r1.getFanTicketCount());
        r2.setLeftDiamonds(r1.getLeftDiamonds());
        String r5 = r1.getDescribe();
        if (r5 == null) goto L9;
        r4 = r5;
    L9:
        r2.setDescribe(r4);
        r2.setGiftId(r1.getGiftId());
        r2.setGroupCount(r1.getGroupCount());
        r2.setGroupId(r1.getGroupId());
        r2.setRepeatCount(r1.getRepeatCount());
        r2.setGiftCnt(r1.getGiftCnt());
        r2.setComboCount(r1.getComboCount());
        String r6 = r1.getMsgId();
        long r7 = 0;
        if (r6 != null) goto L31;
    L14:
        long r9 = 0;
    L15:
        r2.setMsgId(r9);
        r2.setPropId(r1.getPropId());
        r2.setPropType(r1.getPropType());
        List<l2> r10 = r1.getProps();
        Intrinsics.checkNotNull(r10);
        r2.setProps(r10);
        List<y1> r11 = r1.getGifts();
        Intrinsics.checkNotNull(r11);
        r2.setGifts(r11);
        r2.setTraceId(r1.getTraceId());
        r2.setGift(g12.c.a(r1));
        r2.setConsumeDiamonds(r1.getConsumeDiamonds());
        Intrinsics.checkNotNullParameter(r1, "$this$getClientGiftSource");
        g12.b r15 = (g12.b) r1.castToOrNull(g12.b.class);
        if (r15 == null) goto L18;
        r7 = r15.getClientGiftSource();
    L18:
        r2.setClientGiftSource((int) r7);
        GiftTransaction r16 = this.a;
        String r17 = r14.logId;
        String r18 = r14.b;
        int r19 = this.b;
        r16.getClass();
        r2.setLogId(r17);
        r2.setTraceId(r18);
        r2.setReqIndex(r19);
        this.a.f.onNext(r14);
        GiftTransaction.k(this.a, r2, this.c, this.b, this.d, r8);
        if (com.bytedance.android.livesdk.gift.platform.core.f.a().J4() == false) goto L33;
        String r20 = this.e;
        b0 r21 = this.a.x;
        int r23 = this.c;
        long r24 = this.d;
        h1 r110 = g12.c.a((m2) r14.data);
        Integer r111 = null;
        if (r110 == null) goto L23;
        Integer r112 = Integer.valueOf(r110.getType());
    L24:
        h1 r113 = g12.c.a((m2) r14.data);
        if (r113 == null) goto L29;
        List<Long> r114 = r113.getAssetIds();
        if (r114 == null) goto L29;
        r111 = Integer.valueOf(r114.size());
    L29:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.O(r20, r21, r23, "1", "0", -1, r24, r8, r112, r111);
        return;
    L23:
        r112 = null;
        goto L24
    L33:
        return;
    L31:
        r9 = CastLongProtector.parseLong(r6);     // Catch: NumberFormatException -> L13
    L13:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("SendGiftResultUtils", "parse failed, msgId is ".concat(r6));
        goto L14
    }
}
