package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSNoMessageValueNode;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.message.IRoomMessageExtra;
import com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends c {
    public final String q;
    public long r;
    public long s;

    public l() {
        this.q = "gift_message";
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void e() {
        super.e();
        this.r = 0;
        this.s = 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r9) {
        super.a(r9);
        if (r9 == null) goto L59;
        T r0 = r9.b;
        if (r0 != 0) goto L8;
        return;
    L8:
        if ((r0 instanceof c4) == false) goto L10;
        z32.d.a(PSNoMessageValueNode.RoomMessageCount);
    L10:
        c4 r1 = r9.b;
        if ((r1 instanceof c4) == true) goto L13;
        r1 = null;
    L13:
        c4 r2 = r1;
        int r3 = 0;
        if (r2 == null) goto L40;
        if (r2.isGiftTypeMessage() != true) goto L40;
        c4 r10 = r9.b;
        if (r10 == null) goto L38;
        IRoomMessageExtra r11 = r10.getRoomMessageExtra();
        if (r11 == null) goto L60;
        IRoomMessageGiftExtra r13 = r11.getGiftExtra();
        if (r13 == null) goto L61;
        String r4 = r13.getGiftCount();
        long r5 = 0;
        if (r4 == null) goto L26;
        long r6 = CastLongProtector.parseLong(r4);
    L27:
        this.r += r6;
        boolean r7 = com.bytedance.android.live.revenue.core.util.h.a;
        ca0.j r8 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class);
        Long r14 = r13.getGiftId();
        if (r14 == null) goto L30;
        r5 = r14.longValue();
    L30:
        h2 r15 = r8.findLiteGiftById(r5);
        if (r15 == null) goto L33;
        this.s += ((long) r15.getDiamondCount()) * r6;
        return;
    L33:
        long r16 = this.s;
        Integer r17 = r13.getDiamondCount();
        if (r17 == null) goto L36;
        r3 = r17.intValue();
    L36:
        this.s = r16 + (r6 * ((long) r3));
        Unit r18 = Unit.INSTANCE;
        return;
    L26:
        r6 = 0;
        goto L27
    L61:
        return;
    L60:
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.IRoomMessage");
    L40:
        if ((r9 instanceof com.bytedance.android.livesdk.interactivity.textmessage.model.m) == false) goto L51;
        o7 r19 = ((com.bytedance.android.livesdk.interactivity.textmessage.model.m) r9).b;
        if (r19 == null) goto L64;
        this.r += r19.getRepeatCount();
        boolean r20 = com.bytedance.android.live.revenue.core.util.h.a;
        h2 r21 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).findLiteGiftById(r19.getGiftId());
        if (r21 == null) goto L46;
        this.s += ((long) r21.getDiamondCount()) * r19.getRepeatCount();
        return;
    L46:
        long r23 = this.s;
        long r24 = r19.getRepeatCount();
        h1 r25 = r19.getGift();
        if (r25 == null) goto L49;
        r3 = r25.getDiamondCount();
    L49:
        this.s = r23 + (r24 * ((long) r3));
        Unit r26 = Unit.INSTANCE;
        return;
    L64:
        return;
    L51:
        if ((r9 instanceof com.bytedance.android.livesdk.interactivity.textmessage.model.l) == false) goto L67;
        kc2.b r27 = (kc2.b) ((com.bytedance.android.livesdk.interactivity.textmessage.model.l) r9).b;
        if (r27 == null) goto L68;
        this.r += r27.f;
        h2 r28 = r27.d();
        if (r28 == null) goto L57;
        this.s += ((long) r28.getDiamondCount()) * r27.f;
        return;
    L57:
        this.s += ((long) r27.e) * r27.f;
        Unit r29 = Unit.INSTANCE;
        return;
    L68:
        return;
    L67:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void b(Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "statMap");
        r6.put(this.q + this.j, String.valueOf(this.c));
        r6.put(this.q + this.o, String.valueOf(c(this.f, this.c)));
        r6.put(this.q + this.k, String.valueOf(c(this.g, this.c)));
        r6.put(this.q + this.l, String.valueOf(c(this.h, this.c)));
        r6.put(this.q + this.m, String.valueOf(this.d));
        r6.put(this.q + this.n, String.valueOf(this.e));
        r6.put(this.q + "_dashang_num_avg", String.valueOf(c(this.r, this.c)));
        r6.put(this.q + "_dashang_money_avg", String.valueOf(c(this.s, this.c)));
    }
}
