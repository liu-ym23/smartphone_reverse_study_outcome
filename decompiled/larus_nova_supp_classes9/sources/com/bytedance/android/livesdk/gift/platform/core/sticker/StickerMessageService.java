package com.bytedance.android.livesdk.gift.platform.core.sticker;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.h;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.j;
import com.bytedance.android.livesdk.gift.platform.core.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.w;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class StickerMessageService implements o, com.bytedance.android.livesdk.gift.platform.core.sticker.c {
    public final b a;
    public final Map<StickerType, StickerMessageInfo> b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public long i;
    public final Lazy j;
    public final j k;
    public final h l;
    public final com.bytedance.android.livesdk.revenue.service.user.a m;
    public final com.bytedance.android.livesdk.revenue.service.room.c n;
    public final ha0.a o;
    public final com.bytedance.android.livesdk.gift.platform.core.sticker.b p;
    public final vy0.b q;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/sticker/StickerMessageService$StickerType;", BuildConfig.FLAVOR, "Normal", "Special", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum StickerType extends Enum<StickerType> {
        public static final StickerType Normal = null;
        public static final StickerType Special = null;
        public static final /* synthetic */ StickerType[] a = null;

        static {
            StickerType r1 = new StickerType("Normal", 0);
            Normal = r1;
            StickerType r2 = new StickerType("Special", 1);
            Special = r2;
            a = new StickerType[]{r1, r2};
        }

        public static StickerType valueOf(String r1) {
            return (StickerType) r27.a.a(StickerType.class, r1);
        }

        public static StickerType[] values() {
            return (StickerType[]) a.clone();
        }

        public StickerType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b implements Handler.Callback {
        public final /* synthetic */ StickerMessageService a;

        public b(StickerMessageService r1) {
            this.a = r1;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r8) {
            Intrinsics.checkNotNullParameter(r8, "msg");
            StickerMessageService r0 = this.a;
            r0.getClass();
            switch(r8.what) {
                case 140001: goto L19;
                case 140002: goto L18;
                case 140003: goto L17;
                case 140004: goto L35;
                case 140005: goto L11;
                case 140006: goto L5;
                default: goto L35;
            };
        L5:
            Object r9 = ((LinkedHashMap) r0.b).get(StickerType.Special);
            Intrinsics.checkNotNull(r9);
            StickerMessageInfo r10 = (StickerMessageInfo) r9;
            if (r10.k.hasMessages(140002) == false) goto L8;
            r10.k.removeMessages(140002);
        L8:
            w r1 = r10.c;
            if (r1 == null) goto L28;
            Handler r11 = r10.k;
            r11.sendMessageDelayed(r11.obtainMessage(140002), r1.y);
            return true;
        L28:
            return true;
        L11:
            Object r13 = ((LinkedHashMap) r0.b).get(StickerType.Normal);
            Intrinsics.checkNotNull(r13);
            StickerMessageInfo r14 = (StickerMessageInfo) r13;
            if (r14.k.hasMessages(140001) == false) goto L14;
            r14.k.removeMessages(140001);
        L14:
            w r2 = r14.c;
            if (r2 == null) goto L30;
            Handler r15 = r14.k;
            r15.sendMessageDelayed(r15.obtainMessage(140001), r2.y);
            return true;
        L30:
            return true;
        L17:
            r0.y();
            return true;
        L18:
            Object r16 = ((LinkedHashMap) r0.b).get(StickerType.Special);
            Intrinsics.checkNotNull(r16);
            StickerMessageInfo r17 = (StickerMessageInfo) r16;
            int r3 = e.a;
            e.a(r17, r0.n.getRoomContext());
            r17.f = 0;
            HashMap r4 = new HashMap();
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r17.e = r4;
            r0.I();
            return true;
        L19:
            Map<StickerType, StickerMessageInfo> r18 = r0.b;
            StickerType r5 = StickerType.Normal;
            Object r19 = ((LinkedHashMap) r18).get(r5);
            Intrinsics.checkNotNull(r19);
            StickerMessageInfo r20 = (StickerMessageInfo) r19;
            int r6 = e.a;
            Object r7 = ((LinkedHashMap) r0.b).get(r5);
            Intrinsics.checkNotNull(r7);
            e.b((StickerMessageInfo) r7);
            if (r20.h == false) goto L22;
            Object r21 = ((LinkedHashMap) r0.b).get(r5);
            Intrinsics.checkNotNull(r21);
            e.c((StickerMessageInfo) r21, r0.n.getRoomContext());
        L22:
            Object r23 = ((LinkedHashMap) r0.b).get(r5);
            Intrinsics.checkNotNull(r23);
            e.a((StickerMessageInfo) r23, r0.n.getRoomContext());
            r20.f = 0;
            r20.c = null;
            r20.b = false;
            r20.h = false;
            r20.getClass();
            HashMap r24 = new HashMap();
            Intrinsics.checkNotNullParameter(r24, "<set-?>");
            r20.e = r24;
            if (com.bytedance.android.livesdk.gift.platform.business.effect.b.c() <= 0) goto L25;
            r20.k.postDelayed(new f(r0), com.bytedance.android.livesdk.gift.platform.business.effect.b.c());
            return true;
        L25:
            r0.J(r5);
            return true;
        L35:
            return true;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ StickerMessageService a;

        public c(StickerMessageService r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.J(StickerType.Special);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final boolean E() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    public final void a() {
    }

    public final void c(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "nodes");
    }

    public final void d(String[] r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r2, "nodes");
        Intrinsics.checkNotNullParameter(r3, "tags");
    }

    public final void f(String[] r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r2, "nodes");
        Intrinsics.checkNotNullParameter(r3, "tags");
    }

    public final void g() {
    }

    public final void h(ca0.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "msgListener");
    }

    public final void i(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "nodes");
    }

    public final void j(int r1, int r2, int r3, String r4) {
    }

    public final void k(String[] r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r2, "nodes");
        Intrinsics.checkNotNullParameter(r3, "tags");
    }

    public final void n(o7 r2) {
        Intrinsics.checkNotNullParameter(r2, "giftMessage");
    }

    public final void o(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "nodes");
    }

    public final void q() {
    }

    public final void release() {
    }

    public final void s(int r1, int r2, int r3, String r4) {
    }

    public final void w(String[] r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r2, "nodes");
        Intrinsics.checkNotNullParameter(r3, "tags");
    }

    public final void x(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "nodes");
    }

    public final void I() {
        Map<StickerType, StickerMessageInfo> r0 = this.b;
        StickerType r1 = StickerType.Special;
        Object r2 = ((LinkedHashMap) r0).get(r1);
        Intrinsics.checkNotNull(r2);
        StickerMessageInfo r3 = (StickerMessageInfo) r2;
        e.b(r3);
        if (r3.h == false) goto L5;
        e.c(r3, this.n.getRoomContext());
    L5:
        r3.c = null;
        r3.b = false;
        r3.j = -1;
        long r4 = 0;
        r3.g = r4;
        r3.getClass();
        r3.i = false;
        r3.k.removeMessages(140003);
        r3.k.removeMessages(140002);
        if (com.bytedance.android.livesdk.gift.platform.business.effect.b.c() <= r4) goto L8;
        r3.k.postDelayed(new c(this), com.bytedance.android.livesdk.gift.platform.business.effect.b.c());
        return;
    L8:
        J(r1);
    }

    public final void onStart() {
        this.n.getRoomContext().getCommonIsAnchor();
    }

    public final void onStop() {
        this.n.getRoomContext().getCommonIsAnchor();
    }

    public final void stopAnimation() {
        Iterator r0 = ((LinkedHashMap) this.b).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) r0.next();
        StickerType r2 = (StickerType) r1.getKey();
        StickerMessageInfo r3 = (StickerMessageInfo) r1.getValue();
        if (r2 != StickerType.Normal) goto L8;
        int r4 = 140001;
    L10:
        if (r3.k.hasMessages(r4) == false) goto L12;
        r3.k.removeMessages(r4);
    L12:
        Handler r5 = r3.k;
        r5.sendMessage(r5.obtainMessage(r4));
        goto L4
    L8:
        r4 = 140002;
        goto L10
    }

    public final void y() {
        Map<StickerType, StickerMessageInfo> r0 = this.b;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Object r2 = r1.get(StickerType.Special);
        Intrinsics.checkNotNull(r2);
        StickerMessageInfo r3 = (StickerMessageInfo) r2;
        if (r3.i == true) goto L5;
        return;
    L5:
        if (r3.j <= 0) goto L11;
        i97.a r4 = i97.a.a;
        if ((System.currentTimeMillis() - r3.g) <= r3.j) goto L12;
        I();
        return;
    L12:
        return;
    }

    public final h1 A(o7 r4) {
        if (r4.getClientGiftSource() != 1) goto L6;
        return r4.getGift();
    L6:
        return this.l.findGiftById(r4.getGiftId());
    }

    public final w F(o7 r7) {
        if (r7.getMessageId() != 0) goto L5;
    L15:
        return null;
    L5:
        if (r7.getFromUser() == null) goto L15;
        h1 r0 = A(r7);
        if (r0 != null) goto L10;
        return null;
    L10:
        String r1 = this.k.H0(r0.getPrimaryEffectId());
        w r2 = new w();
        r2.y = r0.getDuration();
        Intrinsics.checkNotNullParameter(r7, "$this$getGiftTimeStamp");
        r2.A = r7.getGiftTimeStamp();
        r2.F = r7.getEffectDisplayTs();
        r2.b = r7.getMessageId();
        r2.c = r0.getId();
        r2.h = r0.getPrimaryEffectId();
        r2.w = r0.getDiamondCount();
        r2.i = r1;
        Intrinsics.checkNotNullParameter(r7, "$this$isUrgent");
        r7.isUrgent();
        r2.f = r7.getToUser();
        r2.e = r7.getFromUser();
        r2.m = r7.getSendGiftTime();
        r2.d = r0.getType();
        r2.s = r0.getDescribe();
        r2.u = r7.getTraceId();
        r2.j = r7.getSendTogetherInfo();
        r7.getClientGiftSource();
        r2.g = r7.getGift();
        String r8 = r7.getLogId();
        if (r8 != null) goto L13;
        r8 = BuildConfig.FLAVOR;
    L13:
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r2.n = r8;
        return r2;
    }

    public final void J(StickerType r26) {
        StickerMessageInfo r2 = (StickerMessageInfo) ((LinkedHashMap) this.b).get(r26);
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.b == false) goto L8;
        return;
    L8:
        ed6.b<o7> r3 = r2.a;
        if (r3.b == 0) goto L11;
        o7 r4 = (o7) r3.poll();
        r2.d = r4;
        if (r4 != null) goto L19;
        return;
    L19:
        long r6 = r4.getTimeStamp();
        long r11 = 0;
        if (r6 != r11) goto L22;
    L27:
        boolean r5 = false;
    L29:
        if (r5 == false) goto L37;
        long r14 = r4.getGiftId();
        String r7 = r4.getLogId();
        long r9 = r4.getTimeStamp();
        long r8 = ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW) * com.bytedance.android.livesdk.gift.platform.business.effect.b.b();
        i97.a r10 = i97.a.a;
        long r13 = System.currentTimeMillis() - r4.getTimeStamp();
        b0.a.b(r14, r11, r7, r9, r8, r13);
        jy0.b.c("IGiftMessage", "sticker message expired giftId:" + r14 + "，asset_id:0，log_id:" + r7 + "，receive_time_mills:" + r9 + "，expired_time_mills:" + r8 + "，total_spend_time:" + r13, null, 4);
        v12.f.s(r4, "effect_task_dequeue", 1, "message has been expired", null);
        if (E() == true) goto L33;
    L35:
        J(r26);
        return;
    L33:
        if (r26 != StickerType.Normal) goto L35;
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("render_result", "gift_expire");
        com.bytedance.android.livesdk.gift.platform.core.utils.e.c(r15);
        goto L35
    L37:
        r2.b = true;
        w r16 = F(r4);
        if (r16 == null) goto L57;
        v12.f.u(r16, "effect_task_dequeue", 0, null, null);
        StickerMessageInfo r17 = (StickerMessageInfo) ((LinkedHashMap) this.b).get(r26);
        if (r17 == null) goto L62;
        r17.c = r16;
        if (E() == true) goto L45;
    L53:
        StickerMessageInfo r18 = (StickerMessageInfo) ((LinkedHashMap) this.b).get(r26);
        if (r18 == null) goto L63;
        g r19 = new g(this, r18, r26);
        r16.B = com.bytedance.live.kmp.util.e.b();
        this.k.r0(r16.h, r19, 4, null);
        return;
    L63:
        return;
    L45:
        if (r26 != StickerType.Normal) goto L53;
        o7 r20 = r17.d;
        if (r20 == null) goto L53;
        Intrinsics.checkNotNullParameter(r20, "$this$getMaps");
        Map r21 = r20.getMaps();
        if (r21 == null) goto L53;
        Long r23 = (Long) r21.get(11);
        if (r23 == null) goto L53;
        r16.D = r23.longValue();
        goto L53
    L62:
        return;
    L57:
        r2.b = false;
        v12.f.s(r4, "effect_task_dequeue_error", 1, "getStickerEffectMessage failed", null);
        return;
    L22:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.b.b() <= 0) goto L27;
        i97.a r24 = i97.a.a;
        if ((r6 + (com.bytedance.android.livesdk.gift.platform.business.effect.b.b() * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW))) >= System.currentTimeMillis()) goto L27;
        r5 = true;
        goto L29
    L11:
        if (E() == true) goto L13;
        return;
    L13:
        if (r26 != StickerType.Normal) goto L60;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("receive_stick", String.valueOf(this.i));
        this.i = 0;
        com.bytedance.android.livesdk.gift.platform.core.utils.e.c(r1);
        return;
    }

    public StickerMessageService(j r2, h r3, com.bytedance.android.livesdk.revenue.service.user.a r4, com.bytedance.android.livesdk.revenue.service.room.c r5, ha0.a r6, com.bytedance.android.livesdk.gift.platform.core.sticker.b r7, vy0.b r8, l02.c r9) {
        Intrinsics.checkNotNullParameter(r2, "assetsManager");
        Intrinsics.checkNotNullParameter(r3, "giftManager");
        Intrinsics.checkNotNullParameter(r4, "userService");
        Intrinsics.checkNotNullParameter(r5, "roomService");
        Intrinsics.checkNotNullParameter(r6, "effectStatisticsService");
        Intrinsics.checkNotNullParameter(r7, "stickerHandlerProviderService");
        Intrinsics.checkNotNullParameter(r8, "hybridService");
        Intrinsics.checkNotNullParameter(r9, "effectDataService");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.o = r6;
        this.p = r7;
        this.q = r8;
        this.a = new b(this);
        LinkedHashMap r10 = new LinkedHashMap();
        StickerType[] r11 = StickerType.values();
        int r13 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r10.put(r11[r14], new StickerMessageInfo(new Handler(this.a)));
        r14 = r14 + 1;
        goto L3
    L5:
        Unit r15 = Unit.INSTANCE;
        this.b = r10;
        this.c = LazyKt.lazy(StickerMessageService$mDurationOpt$2.INSTANCE);
        this.d = LazyKt.lazy(StickerMessageService$mEffectTraceOpt$2.INSTANCE);
        this.e = LazyKt.lazy(StickerMessageService$mEnableCreatePng$2.INSTANCE);
        this.f = LazyKt.lazy(StickerMessageService$mAddReportNpth$2.INSTANCE);
        this.g = LazyKt.lazy(StickerMessageService$giftStickerSettingConfig$2.INSTANCE);
        this.h = LazyKt.lazy(new StickerMessageService$mGiftEffectMsgController$2(this));
        this.i = 0;
        new HashMap();
        this.j = LazyKt.lazy(new StickerMessageService$messageCenterListener$2(this));
    }
}
