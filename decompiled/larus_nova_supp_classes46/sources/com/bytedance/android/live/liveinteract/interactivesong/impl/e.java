package com.bytedance.android.live.liveinteract.interactivesong.impl;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongSingState;
import com.bytedance.android.live.liveinteract.interactivesong.logger.InteractiveSongLoggerKt;
import com.bytedance.android.live.liveinteract.interactivesong.panel.InteractiveSongMvManager;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.h0;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVBaseInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.OrderSingItemAction;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.message.IMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.message.IOrderSingInfoV2;
import com.bytedance.android.livesdkapi.depend.message.IUserMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ InteractiveSongWidget a;

    public e(InteractiveSongWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r19) {
        final IOrderSingInfoV2 r1 = (IOrderSingInfoV2) r19;
        if (r1 == null) goto L195;
        InteractiveSongWidget r2 = this.a;
        List r3 = r1.getGiftIds();
        if (r3 == null) goto L9;
        List<Long> r4 = CollectionsKt.toMutableList(r3);
        if (r4 == null) goto L9;
    L10:
        int r5 = InteractiveSongWidget.C;
        r2.Eq(r4);
        InteractiveSongWidget r6 = this.a;
        List r7 = r1.getAuditionGiftIds();
        if (r7 == null) goto L14;
        List<Long> r8 = CollectionsKt.toMutableList(r7);
        if (r8 == null) goto L14;
    L15:
        r6.Fq(r8);
        InteractiveSongWidget r9 = this.a;
        Boolean r10 = r1.getShowGiftInfo();
        if (r10 == null) goto L18;
        boolean r11 = r10.booleanValue();
    L19:
        r9.n = r11;
        InteractiveSongContext.a r12 = InteractiveSongContext.Companion;
        InteractiveSongContext r13 = r12.getContext();
        if (r13 == null) goto L24;
        m<Boolean> r14 = r13.getShowGiftInfo();
        if (r14 == null) goto L24;
        r14.setValue(Boolean.valueOf(r11));
    L24:
        this.a.Cq(r1.getAutoEnlarge());
        this.a.Kq();
        this.a.g = r1.getAiLyricsSwitchOn();
        this.a.h = r1.getStageEffects();
        int r15 = com.bytedance.android.live.liveinteract.aimv.b.a;
        m r16 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a).getRoom();
        String r17 = null;
        if (r16 == null) goto L27;
        IRoom r18 = (IRoom) r16.getValue();
    L28:
        final boolean r20 = com.bytedance.android.live.liveinteract.aimv.b.b(r18);
        Integer r21 = r1.getStageEffects();
        if (r21 != null) goto L32;
    L34:
        boolean r22 = false;
    L35:
        InteractiveSongContext r23 = r12.getContext();
        if (r23 == null) goto L40;
        m<Boolean> r24 = r23.isAIMVStage();
        if (r24 == null) goto L40;
        r24.setValue(Boolean.valueOf(r22));
    L40:
        String r25 = "";
        if (Lists.notEmpty(r1.getUserMicrophoneList()) == false) goto L105;
        this.a.Jq(true, new InteractiveSongWidget$addObserver$4$1(this, r1, r20));
        InteractiveSongWidget r26 = this.a;
        List r27 = r1.getUserMicrophoneList();
        r26.getClass();
        List r110 = r27;
        if (r110 != null) goto L45;
    L48:
        boolean r111 = true;
    L49:
        if (r111 == false) goto L51;
        ALogger.d("InteractiveSongWidget", "updateMicSeatState ;; userMicrophoneList is null");
    L106:
        com.bytedance.android.live.liveinteract.interactivesong.speech.a r28 = this.a.z;
        if (r28 == null) goto L112;
        boolean r29 = r1.getAiLyricsSwitchOn();
        if ((!h0.a.booleanValue()) == false) goto L111;
        r28.a = false;
        goto L112
    L111:
        r28.a = r29;
    L112:
        InteractiveSongContext.a r30 = InteractiveSongContext.Companion;
        InteractiveSongContext r31 = r30.getContext();
        if (r31 == null) goto L117;
        m<Boolean> r32 = r31.isAiLyricsSwitchOn();
        if (r32 == null) goto L117;
        r32.setValue(Boolean.valueOf(r1.getAiLyricsSwitchOn()));
    L117:
        com.bytedance.android.live.liveinteract.interactivesong.speech.a r33 = this.a.z;
        if (r33 == null) goto L120;
        r33.h();
    L120:
        InteractiveSongWidget r34 = this.a;
        if (r34.a == true) goto L133;
        r34.a = true;
        if (r34.isAnchor() == true) goto L126;
        InteractiveSongLoggerKt.k(this.a.g);
        goto L133
    L126:
        if (qf0.b.c() == false) goto L128;
        TalkRoomLogUtils.t.put(19, Long.valueOf(System.currentTimeMillis()));
        goto L133
    L128:
        com.bytedance.android.live.liveinteract.voicechat.util.k r35 = InteractiveSongLoggerKt.a();
        if (r35 == null) goto L133;
        Map<Integer, Long> r36 = r35.d;
        if (r36 == null) goto L133;
        Long r37 = r36.put(19, Long.valueOf(System.currentTimeMillis()));
    L133:
        this.a.xq();
        if (this.a.isAnchor() == false) goto L146;
        IOrderSingMVInfo r38 = r1.getMvInfo();
        if (r38 == null) goto L146;
        if (r38.getMvType() != 2) goto L146;
        this.a.getClass();
        IOrderSingMVInfo r39 = r1.getMvInfo();
        if (r39 == null) goto L146;
        IMVBaseInfo r40 = r39.getMvBaseInfo();
        if (r40 == null) goto L146;
        if (r40.getVid() == null) goto L146;
        this.a.getClass();
    L146:
        InteractiveSongContext r41 = r30.getContext();
        if (r41 == null) goto L149;
        r41.setCurOrderSongItemId(r1.getCurSingItemId());
    L149:
        InteractiveSongViewModel r42 = this.a.b;
        if (r42 == null) goto L155;
        IOrderSingMVInfo r43 = r1.getMvInfo();
        if (r43 == null) goto L154;
        r17 = r43.getUserId();
    L154:
        r42.setCurOrderSongUser(String.valueOf(r17));
    L155:
        InteractiveSongMvManager r112 = this.a.x;
        if (r112 == null) goto L159;
        r112.i(r1.getMvInfo(), this.a.isAnchor(), false, this.a.B, new InteractiveSongWidget$addObserver$4$4(this));
    L159:
        if (r1.getMvInfo() != null) goto L161;
        return;
    L161:
        if (this.a.isAnchor() == true) goto L193;
        InteractiveSongWidget r44 = this.a;
        if (r44.y == false) goto L194;
        InteractiveSongMvManager r45 = r44.x;
        if (r45 == null) goto L174;
        IOrderSingMVInfo r46 = r45.g;
        if (r46 == null) goto L174;
        IMVBaseInfo r47 = r46.getMvBaseInfo();
        if (r47 == null) goto L174;
        String r48 = r47.getVid();
        if (r48 == null) goto L174;
        r25 = r48;
    L174:
        InteractiveSongMvManager r49 = this.a.x;
        if (r49 == null) goto L179;
        IOrderSingMVInfo r50 = r49.g;
        if (r50 == null) goto L179;
        boolean r51 = r50.isHighQuality();
    L180:
        InteractiveSongLoggerKt.c(r25, r51);
        this.a.y = false;
        return;
    L179:
        r51 = false;
        goto L180
    L194:
        return;
    L193:
        return;
    L51:
        InteractiveSongContext r52 = r12.getContext();
        if (r52 == null) goto L70;
        m<String> r53 = r52.getSingingGuestId();
        if (r53 == null) goto L70;
        Iterator<T> r113 = r27.iterator();
    L57:
        if (r113.hasNext() == false) goto L61;
        T r114 = r113.next();
        if (((IUserMicrophoneItem) r114).isSinging() == false) goto L57;
    L62:
        IUserMicrophoneItem r115 = (IUserMicrophoneItem) r114;
        if (r115 == null) goto L68;
        IBaseUser r116 = r115.getOrderUser();
        if (r116 == null) goto L68;
        String r117 = r116.getIdString();
        if (r117 == null) goto L68;
    L69:
        r53.setValue(r117);
    L68:
        r117 = "";
        goto L69
    L61:
        r114 = null;
    L70:
        Iterator<T> r54 = r27.iterator();
    L72:
        if (r54.hasNext() == false) goto L106;
        IUserMicrophoneItem r55 = (IUserMicrophoneItem) r54.next();
        IBaseUser r118 = r55.getOrderUser();
        if (r118 == null) goto L79;
        String r119 = r118.getIdString();
        if (r119 == null) goto L79;
        String r120 = r119;
    L81:
        if (r2.a(r120) == false) goto L72;
        if (r55.isSinging() == false) goto L85;
        int r121 = RequestSongSingState.STATE_SINGING.getValue();
    L87:
        if (r55.isSinging() == false) goto L93;
        InteractiveSongContext r122 = InteractiveSongContext.Companion.getContext();
        if (r122 == null) goto L93;
        m<String> r123 = r122.getSingingGuestId();
        if (r123 == null) goto L93;
        r123.setValue(r120);
    L93:
        InteractiveSongContext r124 = InteractiveSongContext.Companion.getContext();
        if (r124 == null) goto L99;
        ConcurrentHashMap<String, Integer> r125 = r124.getSingingStates();
        if (r125 == null) goto L99;
        r125.put(r120, Integer.valueOf(r121));
    L99:
        if (r55.isSinging() == false) goto L72;
        IMicrophoneItem r56 = qf0.b.b(r55.getMicrophoneList());
        if (r56 == null) goto L103;
        int r126 = r56.getMicroPhoneNum();
    L104:
        r26.Lq(new pf0.a(r120, r126, Integer.valueOf(OrderSingItemAction.ORDER_SING_START_ITEM.getValue()), null, null, 24));
        goto L72
    L103:
        r126 = 0;
        goto L104
    L85:
        r121 = RequestSongSingState.STATE_NOSING.getValue();
    L79:
        r120 = "";
        goto L81
    L45:
        if (r110.isEmpty() == true) goto L48;
        r111 = false;
        goto L49
    L105:
        this.a.Jq(false, new InteractiveSongWidget$addObserver$4$2(this, r20));
        goto L106
    L32:
        if (r21.intValue() != 2) goto L34;
        r22 = true;
        goto L35
    L27:
        r18 = null;
        goto L28
    L18:
        r11 = false;
    L14:
        r8 = new ArrayList();
    L9:
        r4 = new ArrayList();
        goto L10
    }
}
