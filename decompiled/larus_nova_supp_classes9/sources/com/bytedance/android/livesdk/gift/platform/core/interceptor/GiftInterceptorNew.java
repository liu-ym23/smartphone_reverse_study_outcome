package com.bytedance.android.livesdk.gift.platform.core.interceptor;

import android.util.LongSparseArray;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profit.privilege.c;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.manager.g;
import com.bytedance.android.livesdk.gift.platform.core.manager.h;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.q0;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.message.model.o6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.message.i;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import i12.e;
import io.reactivex.disposables.CompositeDisposable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import tlc.d;
import yz0.k;
import yz0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftInterceptorNew implements o, vlc.b {
    public final String a;
    public final Lazy b;
    public boolean c;
    public final LongSparseArray<ArrayList<o7>> d;
    public final a e;
    public final l f;
    public final k g;
    public final l h;

    public static final class a implements h.b {
        public final /* synthetic */ GiftInterceptorNew a;

        public a(GiftInterceptorNew r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.manager.h.b
        public final void a(long r4) {
            GiftInterceptorNew r0 = this.a;
            if (r0.c == true) goto L5;
            return;
        L5:
            ArrayList<o7> r1 = r0.d.get(r4);
            if (r1 == null) goto L8;
            r1.clear();
        L8:
            jy0.b.b(this.a.a, "can't find giftId = " + r4, null);
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.manager.h.b
        public final void b(h1 r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            GiftInterceptorNew r0 = this.a;
            if (r0.c == true) goto L7;
            return;
        L7:
            long r1 = r5.getId();
            ArrayList<o7> r2 = r0.d.get(r1);
            if (r2 != null) goto L11;
            r2 = CollectionsKt.emptyList();
        L11:
            if (Lists.isEmpty(r2) == false) goto L13;
            return;
        L13:
            Iterator r3 = CollectionsKt.filterNotNull(r2).iterator();
        L15:
            if (r3.hasNext() == false) goto L20;
            o7 r4 = (o7) r3.next();
            if (com.bytedance.android.livesdk.gift.platform.core.h.i() == true) goto L18;
            this.a.f.insert(r4, true);
            goto L15
        L18:
            this.a.f.insert(r4, false);
            goto L15
        L20:
            GiftInterceptorNew r6 = this.a;
            long r7 = r5.getId();
            ArrayList<o7> r8 = r6.d.get(r7);
            if (r8 == null) goto L30;
            r8.clear();
            return;
        }
    }

    public final void onStart() {
        this.c = true;
        if (com.bytedance.android.livesdk.gift.platform.core.h.i() == true) goto L6;
        this.f.h(this);
        return;
    }

    public final void onStop() {
        this.d.clear();
        this.c = false;
    }

    public final boolean onMessage(d r30) {
        d r1 = r30;
        Intrinsics.checkNotNullParameter(r1, "msg");
        String r2 = f.a(l01.d.class).b().getIdString();
        if ((r1 instanceof o6) == false) goto L17;
        o6 r3 = (o6) r1;
        if (r3.getGiftMessage() == null) goto L10;
        o7 r5 = r3.getGiftMessage();
        Intrinsics.checkNotNull(r5);
        r5.setDisplayForSelf(false);
        o7 r6 = r3.getGiftMessage();
        if (r6 == null) goto L10;
        r6.setGroupCount(1);
    L10:
        if ((r3.getGiftMessage() instanceof d) == false) goto L17;
        r1 = r3.getGiftMessage();
        if (r1 != null) goto L17;
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.IMessage");
    L17:
        if (r2 != null) goto L19;
    L22:
        boolean r7 = true;
    L24:
        if (r7 == true) goto L74;
        if ((r1 instanceof o7) == false) goto L74;
        o7 r8 = (o7) r1;
        if (r8.getDisplayForSelf() != true) goto L37;
        IBaseUser r10 = r8.getFromUser();
        if (r10 == null) goto L32;
        String r11 = r10.getIdString();
    L34:
        if (Intrinsics.areEqual(r2, r11) == false) goto L37;
        r8.setLocal(true);
        goto L37
    L32:
        r11 = null;
    L37:
        if (r8.isLocal() == true) goto L56;
        IBaseUser r13 = r8.getFromUser();
        if (r13 == null) goto L41;
        String r14 = r13.getIdString();
    L43:
        if (Intrinsics.areEqual(r2, r14) == false) goto L56;
        if (r8.getDisplayForSelf() == true) goto L56;
        if (r8.getRepeatEnd() == 1) goto L56;
        LinkedHashMap r4 = new LinkedHashMap();
        h2 r9 = u.f(r8);
        if (r9 == null) goto L51;
        r4.put("gift_id", Long.valueOf(r9.getId()));
    L51:
        if (r9 == null) goto L53;
        r4.put("asset_id", Long.valueOf(r9.getPrimaryEffectId()));
    L53:
        boolean r15 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(c.class).B1(ProfitCheckType.GIFT_EFFECT_SELF_IM, r4, null);
        return true;
    L41:
        r14 = null;
    L56:
        if (r8.isLocal() == false) goto L74;
        IBaseUser r16 = r8.getFromUser();
        if (r16 == null) goto L60;
        String r17 = r16.getIdString();
    L62:
        if (Intrinsics.areEqual(r2, r17) == false) goto L74;
        KProperty[] r18 = s.a;
        e r19 = i12.o.b();
        if (r19 == null) goto L66;
        Object r20 = m.e.d(r19, q0.class);
    L67:
        q0 r21 = (q0) r20;
        if (r21 == null) goto L74;
        String r23 = r8.getLogId();
        if (r23 != null) goto L72;
        r23 = BuildConfig.FLAVOR;
    L72:
        r21.a(r23, 2, System.currentTimeMillis());
        goto L74
    L66:
        r20 = null;
        goto L67
    L60:
        r17 = null;
    L74:
        if ((r1 instanceof o7) == false) goto L208;
        o7 r24 = (o7) r1;
        if (r24.isLocal() == false) goto L78;
    L93:
        h1 r25 = r24.getGift();
        if (r25 != null) goto L96;
    L158:
        String r110 = BuildConfig.FLAVOR;
    L159:
        r24.setTimeStampMap(0, com.bytedance.live.kmp.util.e.b());
        if (r24.getFromUser() != null) goto L163;
        jy0.b.b(this.a, "giftMessage#fromUser is null! messageId = " + r24.getMessageId(), null);
        return true;
    L163:
        h2 r26 = u.f(r24);
        if (r24.getClientGiftSource() == 0) goto L166;
    L173:
        if (r26 != null) goto L175;
        jy0.b.d(this.a, "收到 未找到礼物的GiftMessage: giftId = " + r24.getGiftId());
        long r27 = r24.getGiftId();
        c0 r28 = c0.a;
        String r111 = z.b("ttlive_gift_id_not_found");
        JSONObject r29 = new JSONObject();
        JSONObject r31 = new JSONObject();
        JSONObject r33 = new JSONObject();
        Intrinsics.checkNotNullParameter(r33, "extra");
        Intrinsics.checkNotNullParameter(r31, "metric");
        EventModule r34 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r34, "eventModule");
        String r210 = r34.getValue();
        r31.put("status", String.valueOf(1));
        Intrinsics.checkNotNullParameter(r33, "map");
        Long r35 = Long.valueOf(r27);
        Intrinsics.checkNotNullParameter("gift_id", "key");
        Intrinsics.checkNotNullParameter(r35, "value");
        r33.put("gift_id", r35);
        k r36 = f.d(j.C0.a(), k.class);
        if (r36 == null) goto L181;
        IRoom r37 = r36.getRoom();
    L183:
        if ((r37 instanceof Room) == true) goto L185;
        r37 = null;
    L185:
        Room r38 = (Room) r37;
        if (r38 == null) goto L191;
        Integer r39 = Integer.valueOf(r38.orientation);
        Intrinsics.checkNotNullParameter("room_type", "key");
        Intrinsics.checkNotNullParameter(r39, "value");
        r33.put("room_type", r39);
        Long r40 = Long.valueOf(r38.id);
        Intrinsics.checkNotNullParameter("room_id", "key");
        Intrinsics.checkNotNullParameter(r40, "value");
        r33.put("room_id", r40);
        String r41 = r38.getAnchorId();
        if (r41 != null) goto L190;
        r41 = r110;
    L190:
        Intrinsics.checkNotNullParameter("anchor_id", "key");
        Intrinsics.checkNotNullParameter(r41, "value");
        r33.put("anchor_id", r41);
    L191:
        GiftContext r43 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r43 == null) goto L194;
        Object r44 = r43.getGiftListResultLogId().getValue();
        Intrinsics.checkNotNullParameter("log_id", "key");
        Intrinsics.checkNotNullParameter(r44, "value");
        r33.put("log_id", r44);
    L194:
        cy0.e.a.getClass();
        cy0.j r45 = cy0.e.a.a;
        m.e.getClass();
        Object r46 = m.b(r45).b(n97.a.class);
        Intrinsics.checkNotNull(r46);
        ((com.bytedance.live.kmp.core.c) r46).g(r111, r210, "bussiness_api_call", r29, r31, r33);
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.k.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[9])).booleanValue() == false) goto L206;
        ArrayList<o7> r47 = this.d.get(r24.getGiftId());
        if (r47 != null) goto L199;
        r47 = new ArrayList();
    L199:
        r47.add(r24);
        this.d.put(r24.getGiftId(), r47);
        h r48 = (h) this.b.getValue();
        long r49 = r24.getGiftId();
        long r112 = this.g.getRoom().getRoomId();
        g r50 = new g(r49, r112, this.e);
        List<g> r51 = r48.b.get(Long.valueOf(r112));
        if (r51 != null) goto L203;
        r51 = new ArrayList();
        r48.b.put(Long.valueOf(r112), r51);
        r48.a.put(Long.valueOf(r112), 0);
    L203:
        if (r51.contains(r50) == true) goto L205;
        r51.add(r50);
    L205:
        r48.a();
    L206:
        return true;
    L181:
        r37 = null;
        goto L183
    L175:
        if (l0.d(r26) == false) goto L177;
        jy0.b.d(this.a, "收到 IGiftMessage: giftId = " + r24.getGiftId());
    L177:
        return false;
    L166:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.g.j.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.a[7])).booleanValue() == false) goto L173;
        if (r26 == null) goto L173;
        if (l0.d(r26) == false) goto L218;
        jy0.b.d(this.a, "收到 IGiftMessage: giftId = " + r24.getGiftId());
        return false;
    L218:
        return false;
    L96:
        if (r24.getRepeatEnd() != 1) goto L98;
    L100:
        boolean r113 = false;
    L101:
        if (r113 == true) goto L104;
        r25 = null;
    L104:
        if (r25 == null) goto L158;
        e r114 = i12.o.b();
        if (r114 == null) goto L108;
        Object r115 = m.e.d(r114, com.bytedance.android.livesdk.gift.platform.core.preview.c.class);
    L109:
        com.bytedance.android.livesdk.gift.platform.core.preview.c r116 = (com.bytedance.android.livesdk.gift.platform.core.preview.c) r115;
        if (r116 == null) goto L158;
        IRoom r117 = this.g.getRoom();
        long r118 = r24.getMessageId();
        Intrinsics.checkNotNullParameter(r25, "gift");
        Intrinsics.checkNotNullParameter(r117, "room");
        if (r116.d == false) goto L158;
        if (r116.a == false) goto L158;
        if (r116.c == 0) goto L158;
        Iterator<T> r53 = r116.g.N3().c.iterator();
    L119:
        if (r53.hasNext() == false) goto L127;
        Object r119 = r53.next();
        if (((w1) r119).getPageType() != 15) goto L123;
        boolean r54 = true;
    L124:
        if (r54 == false) goto L119;
    L128:
        w1 r120 = (w1) r119;
        if (r120 == null) goto L131;
        List<h1> r55 = r120.getGifts();
    L132:
        if (r55 == null) goto L144;
        Iterator<T> r56 = r55.iterator();
    L135:
        if (r56.hasNext() == false) goto L142;
        Object r57 = r56.next();
        if (((h1) r57).getId() != r25.getId()) goto L139;
        boolean r58 = true;
    L140:
        if (r58 == false) goto L135;
    L143:
        h1 r59 = (h1) r57;
    L145:
        if (r59 == null) goto L147;
        boolean r60 = true;
    L148:
        if (r60 == false) goto L158;
        com.bytedance.tools.kcp.spongepreference.runtime.a r61 = ay1.b.r0;
        KProperty[] r63 = ay1.b.a;
        r110 = BuildConfig.FLAVOR;
        if (((Number) r61.getValue(null, r63[83])).intValue() < r116.b) goto L152;
        r116.d = false;
        goto L159
    L152:
        r116.c--;
        r61.setValue(null, r63[83], Integer.valueOf(((Number) r61.getValue(null, r63[83])).intValue() + 1));
        i r121 = r116.f.getMessageManager();
        if (r121 == null) goto L159;
        com.bytedance.android.livesdk.gift.platform.core.preview.a.a.getClass();
        Intrinsics.checkNotNullParameter(r117, "room");
        Intrinsics.checkNotNullParameter(r25, "gift");
        LinkedHashMap r64 = new LinkedHashMap();
        String r65 = r117.getAnchorId();
        if (r65 != null) goto L157;
        r65 = r110;
    L157:
        r64.put("anchor_id", r65);
        r64.put("room_id", String.valueOf(r117.getRoomId()));
        r64.put("event_page", "live");
        r64.put("gift_id", String.valueOf(r25.getId()));
        com.bytedance.android.livesdk.gift.platform.core.preview.a.c("livesdk_interactive_gift_message_show", r64);
        r116.e.a(r121, r117.getRoomId(), (r118 + System.currentTimeMillis()) + ((long) new SecureRandom().nextInt()), r25.getName(), r25.getId(), com.bytedance.android.livesdk.gift.platform.business.a.d().d(), com.bytedance.android.livesdk.gift.platform.business.a.d().e());
        goto L159
    L147:
        r60 = false;
        goto L148
    L139:
        r58 = false;
        goto L140
    L142:
        r57 = null;
        goto L143
    L144:
        r59 = null;
        goto L145
    L131:
        r55 = null;
        goto L132
    L123:
        r54 = false;
        goto L124
    L127:
        r119 = null;
        goto L128
    L108:
        r115 = null;
        goto L109
    L98:
        if (this.g.isAnchor() == false) goto L100;
        r113 = true;
        goto L101
    L78:
        if (this.g.isAnchor() == false) goto L93;
        if (r24.getRepeatEnd() == 1) goto L93;
        LinkedHashMap r66 = new LinkedHashMap();
        h2 r67 = u.f(r24);
        if (r67 == null) goto L85;
        r66.put("gift_id", Long.valueOf(r67.getId()));
    L85:
        if (r67 == null) goto L87;
        r66.put("asset_id", Long.valueOf(r67.getPrimaryEffectId()));
    L87:
        IBaseUser r68 = r24.getFromUser();
        if (r68 == null) goto L92;
        String r69 = r68.getIdString();
        if (r69 == null) goto L92;
        r66.put("from_user_id", r69);
    L92:
        boolean r70 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(c.class).B1(ProfitCheckType.ANCHOR_GIFT_IM, r66, null);
        goto L93
    L208:
        return false;
    L19:
        if (r2.length() == 0) goto L22;
        r7 = false;
        goto L24
    }

    public GiftInterceptorNew(l r2, k r3, l r4) {
        Intrinsics.checkNotNullParameter(r2, "messageService");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "roomMessageService");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = "GiftInterceptorNew";
        this.b = LazyKt.lazy(new GiftInterceptorNew$giftFinder$2(this));
        new CompositeDisposable();
        this.d = new LongSparseArray();
        this.e = new a(this);
    }
}
