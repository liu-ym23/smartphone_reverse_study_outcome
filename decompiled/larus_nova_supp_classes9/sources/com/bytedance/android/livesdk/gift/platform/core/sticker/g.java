package com.bytedance.android.livesdk.gift.platform.core.sticker;

import android.os.Handler;
import ca0.u;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.resources.h;
import com.bytedance.android.live.gift.RevStickerPanel;
import com.bytedance.android.live.revenue.common.y;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.model.w;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.bdlocation.BuildConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import cy0.j;
import ft1.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {
    public final /* synthetic */ StickerMessageService a;
    public final /* synthetic */ StickerMessageInfo b;
    public final /* synthetic */ StickerMessageService.StickerType c;

    public static final class a implements Runnable {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        public final void a() {
            g r1 = this.a;
            StickerMessageService r2 = r1.a;
            StickerMessageService.StickerType r3 = r1.c;
            StickerMessageInfo r4 = (StickerMessageInfo) ((LinkedHashMap) r2.b).get(r3);
            if (r4 != null) goto L6;
            return;
        L6:
            if (r4.c == null) goto L83;
            int r5 = e.a;
            o7 r6 = r4.d;
            LinkedHashMap r7 = new LinkedHashMap();
            if (r6 == null) goto L11;
            r7.put("gift_id", String.valueOf(r6.getGiftId()));
            r7.put("gift_cnt", String.valueOf(1));
            Intrinsics.checkNotNullParameter(r6, "$this$getTotalMoney");
            r7.put("gift_price", String.valueOf(r6.getTotalMoney()));
        L11:
            n r8 = new n();
            Map r9 = r8.a;
            Intrinsics.checkNotNullParameter(r9, "map");
            Intrinsics.checkNotNullParameter(r7, "map");
            r9.putAll(r7);
            m r10 = new m();
            LogCommon r11 = LogCommon.PAGE_SOURCE_LOG;
            r10.b(r11);
            LogCommon r13 = LogCommon.ROOM;
            r10.b(r13);
            r10.b(LogCommon.LIVE_SHARE_LOG);
            ((ArrayList) r8.b).addAll(r10.a);
            cy0.e.a.getClass();
            j r14 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(i.class));
            Intrinsics.checkNotNull(r15);
            ((f80.a) r15).w3("livesdk_face_gift_show", r8.a, r8.b);
            w r16 = r4.c;
            Intrinsics.checkNotNull(r16);
            IRoomBase r17 = r2.n.getRoomContext().getCommonRoom();
            boolean r18 = r2.n.getRoomContext().getCommonIsAnchor();
            boolean r19 = r2.E();
            Intrinsics.checkNotNullParameter(r16, "msg");
            Intrinsics.checkNotNullParameter(r17, "room");
            LinkedHashMap r110 = new LinkedHashMap();
            long r111 = 0;
            if (r19 == true) goto L14;
        L16:
            long r112 = r111;
        L17:
            r110.put("room_id", r17.getIdStr());
            IBaseUser r0 = r17.getOwnerKt();
            if (r0 == null) goto L21;
            String r20 = r0.getIdString();
            if (r20 == null) goto L21;
        L22:
            r110.put("anchor_id", r20);
            if (r18 == false) goto L25;
            Object r113 = "1";
        L26:
            r110.put("is_anchor", r113);
            r110.put("gift_id", String.valueOf(r16.c));
            r110.put("effect_id", String.valueOf(r16.h));
            r110.put("gift_type", String.valueOf(r16.d));
            r110.put("ies_effect", "1");
            r110.put("gift_effect_type", String.valueOf(5));
            long r114 = r16.m;
            r110.put("all_duration", String.valueOf(com.bytedance.live.kmp.util.e.b() - r114));
            r110.put("gift_role", "1");
            r110.put("free_display", "0");
            r16.getClass();
            r110.put("asset_predownload", String.valueOf(0));
            long r115 = r112 - r114;
            r110.put("msg_dispatch", String.valueOf(r115));
            r110.put("all_queue_size", String.valueOf(r115));
            long r21 = r16.z;
            long r116 = r16.A;
            long r23 = r21 - r116;
            long r117 = r16.C - r16.B;
            long r118 = r116 - r16.m;
            r110.put("dequeue_duration", String.valueOf(r23));
            r110.put("send_api_duration", String.valueOf(r118));
            r110.put("fetch_assets_duration", String.valueOf(r117));
            r110.put("queue_size", String.valueOf(r16.D));
            if (m12.b.a() == false) goto L29;
            String r24 = "livesdk_gift_effect_show_anchor";
        L30:
            n r25 = new n();
            Map r26 = r25.a;
            Intrinsics.checkNotNullParameter(r26, "map");
            Intrinsics.checkNotNullParameter(r110, "map");
            r26.putAll(r110);
            m r27 = new m();
            r27.b(r11);
            r27.b(r13);
            ((ArrayList) r25.b).addAll(r27.a);
            Object r28 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(i.class));
            Intrinsics.checkNotNull(r28);
            ((f80.a) r28).w3(r24, r25.a, r25.b);
            HashMap r29 = new HashMap();
            w r30 = r4.c;
            Intrinsics.checkNotNull(r30);
            r29.put("gift_id", String.valueOf(r30.c));
            d r31 = (d) r2.h.getValue();
            w r33 = r4.c;
            Intrinsics.checkNotNull(r33);
            String r34 = String.valueOf(r33.c);
            r31.getClass();
            Intrinsics.checkNotNullParameter(r34, "<set-?>");
            w r35 = r4.c;
            Intrinsics.checkNotNull(r35);
            long r36 = r35.y;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r37 = r2.k;
            w r38 = r4.c;
            Intrinsics.checkNotNull(r38);
            com.bytedance.android.live.core.resources.e r39 = r37.G1(r38.h);
            String r40 = null;
            if (r39 == null) goto L44;
            Intrinsics.checkNotNullParameter(r39, "$this$getLokiExtraModel");
            h r41 = r39.getLokiExtraModel();
            if (r41 == null) goto L44;
            Long r43 = Long.valueOf(r41.getDuration());
            if (r43.longValue() == r111) goto L37;
            boolean r44 = true;
        L38:
            if (r44 == true) goto L41;
            r43 = null;
        L41:
            if (r43 == null) goto L44;
            r36 = r43.longValue();
            goto L44
        L37:
            r44 = false;
        L44:
            if (r3 != StickerMessageService.StickerType.Special) goto L55;
            if (r39 == null) goto L55;
            Long r45 = Long.valueOf(r39.getMinPlayTime());
            if (r45.longValue() == r111) goto L49;
            boolean r46 = true;
        L50:
            if (r46 == true) goto L53;
            r45 = null;
        L53:
            if (r45 == null) goto L55;
            r4.j = (long) Math.min(r36, r45.longValue());
            goto L55
        L49:
            r46 = false;
        L55:
            i97.a r47 = i97.a.a;
            r4.g = System.currentTimeMillis();
            w r48 = r4.c;
            Intrinsics.checkNotNull(r48);
            u r49 = new u();
            long r119 = r48.c;
            String r120 = r48.i;
            Intrinsics.checkNotNull(r120);
            Intrinsics.checkNotNullParameter(r120, "<set-?>");
            RevStickerPanel.EFFECT_GIFT.getValue();
            com.bytedance.android.live.core.resources.e r50 = r2.k.G1(r48.h);
            if (r50 == null) goto L58;
            r49.a = r50.isHighCostAsset();
        L58:
            String r51 = v12.f.a;
            w r53 = r4.c;
            Intrinsics.checkNotNull(r53);
            boolean r121 = true;
            v12.f.u(r53, "effect_engine_start", 0, null, e.d(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", Long.valueOf(r36)), TuplesKt.to("isHighCostAsset", Boolean.valueOf(r49.a))})));
            w r54 = r4.c;
            HashMap r55 = new HashMap();
            boolean r56 = r2.n.getRoomContext().getCommonIsAnchor();
            if (r54 == null) goto L73;
            if (r56 == false) goto L73;
            if (r39 == null) goto L73;
            r55.put("gift_id", String.valueOf(r54.c));
            r55.put("asset_id", String.valueOf(r39.getId()));
            IBaseUser r57 = r54.e;
            if (r57 == null) goto L73;
            String r58 = com.bytedance.android.live.base.model.user.m.a(r57);
            if (r58.length() > 0) goto L69;
            r121 = false;
        L69:
            if (r121 == false) goto L71;
            r40 = r58;
        L71:
            if (r40 == null) goto L73;
            r55.put("from_user_id", r40);
        L73:
            long r59 = com.bytedance.live.kmp.util.e.b();
            w r60 = r4.c;
            Intrinsics.checkNotNull(r60);
            r60.z = r59;
            if (r3 != StickerMessageService.StickerType.Normal) goto L76;
            Handler r61 = r4.k;
            r61.sendMessageDelayed(r61.obtainMessage(140001), r36);
            return;
        L76:
            Handler r63 = r4.k;
            r63.sendMessageDelayed(r63.obtainMessage(140002), r36);
            if (r4.j <= 0) goto L81;
            r4.k.removeMessages(140003);
            Handler r64 = r4.k;
            r64.sendMessageDelayed(r64.obtainMessage(140003), r4.j);
            return;
        L81:
            return;
        L29:
            r24 = "livesdk_gift_effect_show";
            goto L30
        L25:
            r113 = "0";
        L21:
            r20 = BuildConfig.FLAVOR;
            goto L22
        L14:
            if (((LinkedHashMap) r16.x).get(2) == null) goto L16;
            Object r65 = ((LinkedHashMap) r16.x).get(2);
            Intrinsics.checkNotNull(r65);
            r112 = ((Number) r65).longValue();
            goto L17
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

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onProgress(int r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r5) {
        w r0 = this.b.c;
        if (r0 == null) goto L5;
        String r2 = v12.f.a;
        int r3 = e.a;
        v12.f.u(r0, "resource_check_state", 4, "downloadAssets onCancel", e.d(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("resourceId", Long.valueOf(r5))})));
    L5:
        StickerMessageInfo r6 = this.b;
        r6.b = false;
        if (this.c != StickerMessageService.StickerType.Special) goto L9;
        r6.j = -1;
        r6.i = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void b(boolean r1) {
        w r2 = this.b.c;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "t");
        w r6 = this.b.c;
        if (r6 == null) goto L5;
        v12.f.u(r6, "resource_check_state", 4, "downloadAssets onFailed", null);
    L5:
        StickerMessageInfo r7 = this.b;
        r7.b = false;
        if (this.c != StickerMessageService.StickerType.Special) goto L9;
        r7.j = -1;
        r7.i = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void c(long r10, String r13) {
        Intrinsics.checkNotNullParameter(r13, "path");
        w r1 = this.b.c;
        if (r1 == null) goto L5;
        long r3 = com.bytedance.live.kmp.util.e.b();
        r1.C = r3;
        String r5 = r1.i;
        boolean r6 = false;
        if (r5 != null) goto L13;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == false) goto L26;
        if (((com.bytedance.android.livesdk.gift.platform.core.sticker.a) this.a.g.getValue()).h8() == true) goto L21;
    L23:
        String r8 = this.a.k.H0(r1.h);
    L24:
        r1.i = r8;
        goto L26
    L21:
        if (this.c != StickerMessageService.StickerType.Normal) goto L23;
        r8 = r13;
    L26:
        if ((!Intrinsics.areEqual(r13, r1.i)) == false) goto L31;
        String r4 = v12.f.a;
        int r9 = e.a;
        v12.f.u(r1, "resource_check_state", 3, "downloadAssets returns path not match local path", e.d(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("path", r13), TuplesKt.to("messageLocalPath", r1.i), TuplesKt.to("resourceId", Long.valueOf(r10))})));
        if (((com.bytedance.android.livesdk.gift.platform.core.sticker.a) this.a.g.getValue()).v2() == false) goto L88;
        this.b.b = true;
        return;
    L88:
        return;
    L31:
        StickerMessageService r0 = this.a;
        if (this.c != StickerMessageService.StickerType.Normal) goto L34;
        String r11 = "gift_normal_face_gift";
    L36:
        if (((Boolean) r0.f.getValue()).booleanValue() == false) goto L71;
        LinkedHashMap r2 = new LinkedHashMap();
        if (r13.length() <= 0) goto L40;
        boolean r14 = true;
    L41:
        if (r14 == false) goto L69;
        List r15 = new Regex("/").split(r13, 0);
        if (r15.isEmpty() == true) goto L53;
        ListIterator r16 = r15.listIterator(r15.size());
    L46:
        if (r16.hasPrevious() == false) goto L53;
        if (((String) r16.previous()).length() != 0) goto L50;
        boolean r17 = true;
    L51:
        if (r17 == true) goto L46;
        List r18 = CollectionsKt.take(r15, r16.nextIndex() + 1);
    L54:
        Object[] r19 = r18.toArray(new String[0]);
        if (r19 == null) goto L68;
        String[] r110 = (String[]) r19;
        if (r110.length <= 0) goto L69;
        String r20 = r110[r110.length - 1];
        if (r20 != null) goto L61;
    L62:
        r6 = true;
    L63:
        if (r6 == true) goto L65;
    L70:
        r2.put(r11, r10 + ',' + r20);
        int r111 = y.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        k.a(r2);
        goto L71
    L65:
        if (r110.length <= 1) goto L70;
        r20 = r110[r110.length - 2];
        goto L70
    L61:
        if (r20.length() != 0) goto L63;
    L68:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L50:
        r17 = false;
    L53:
        r18 = CollectionsKt.emptyList();
    L69:
        r20 = BuildConfig.FLAVOR;
        goto L70
    L40:
        r14 = false;
    L71:
        long r112 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        if (((Number) this.a.c.getValue()).longValue() <= 0) goto L75;
        r112 = ((Number) this.a.c.getValue()).longValue();
    L75:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.b.n.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.b.a[12])).booleanValue() == true) goto L79;
        long r21 = r1.F;
        if (r21 <= r3) goto L79;
        r112 = r112 + (r21 - r3);
    L79:
        this.b.k.postDelayed(new a(this), r112);
        return;
    L34:
        r11 = "gift_adornment_face_gift";
        goto L36
    L13:
        if (r5.length() == 0) goto L16;
        r7 = false;
        goto L17
    L5:
        if (((com.bytedance.android.livesdk.gift.platform.core.sticker.a) this.a.g.getValue()).v2() == true) goto L7;
        return;
    L7:
        if (this.c != StickerMessageService.StickerType.Normal) goto L87;
        this.b.b = true;
        return;
    }

    public g(StickerMessageService r1, StickerMessageInfo r2, StickerMessageService.StickerType r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
