package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.d3;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.interactivity.api.IRoomChannelService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelData;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "roomChannelData", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelData;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class RoomChatChannelCreator$tryInitChatChannel$1 extends Lambda implements Function1<RoomChannelData, Unit> {
    final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.f $interactivityContext;
    final /* synthetic */ Room $room;
    final /* synthetic */ RoomContext $roomContext;
    final /* synthetic */ RoomChatChannelCreator this$0;

    public RoomChatChannelCreator$tryInitChatChannel$1(RoomChatChannelCreator r1, Room r2, RoomContext r3, com.bytedance.android.livesdk.interactivity.api.f r4) {
        this.this$0 = r1;
        this.$room = r2;
        this.$roomContext = r3;
        this.$interactivityContext = r4;
        super(1);
    }

    public final void invoke(RoomChannelData r19) {
        this.$room.roomChannel = r19;
        com.bytedance.android.livesdk.log.filter.a0 r2 = null;
        boolean r3 = false;
        if (r19 != null) goto L5;
    L48:
        Room r1 = this.$room;
        long r4 = r1.id;
        boolean r6 = ((Boolean) this.$roomContext.isAnchor().getValue()).booleanValue();
        int r7 = f.a;
        Intrinsics.checkNotNullParameter(r1, "room");
        if (e.a == true) goto L51;
        String r5 = "localSetting";
    L72:
        k.g(r4, false, r5);
        RoomChatChannelCreator r8 = this.this$0;
        final Function1<d3, Unit> r9 = new AnonymousClass2(this);
        RxUtilKt.c(i80.a.b(r8.j.getImChannelInviteId(), new RoomChatChannelCreator$tryObserveJoinChannel$1(r9)), r8.a);
        return;
    L51:
        RoomAuthStatus r10 = r1.getRoomAuthStatus();
        if (r10 != null) goto L54;
    L56:
        RoomAuthStatus r11 = r1.getRoomAuthStatus();
        if (r11 != null) goto L59;
    L61:
        RoomAuthStatus r13 = r1.getRoomAuthStatus();
        if (r13 != null) goto L64;
    L66:
        if (r6 == false) goto L69;
        r5 = "anchor";
        goto L72
    L69:
        if (f.c(RoomContext.a.c(RoomContext.Companion, null, 0, 3)) == false) goto L71;
        r5 = "MultiTabWithoutChatTab";
        goto L72
    L71:
        r5 = CardLockInfo.sUNKNOWN;
        goto L72
    L64:
        if (r13.isEnableRoomChannelByAnchor() == true) goto L66;
        r5 = "RoomAuth.isEnableRoomChannelByAnchor";
        goto L72
    L59:
        if (r11.isEnableRoomChannel() == true) goto L61;
        r5 = "RoomAuth.isEnableRoomChannel";
        goto L72
    L54:
        if (r10.getEnableChat() == true) goto L56;
        r5 = "RoomAuth.enableChat";
        goto L72
    L5:
        if (f.a(this.$roomContext) == false) goto L48;
        k.g(this.$room.id, true, null);
        DataCenter r14 = this.this$0.k;
        RoomChannelData r15 = this.$room.roomChannel;
        Intrinsics.checkNotNull(r15);
        boolean r16 = com.bytedance.android.live.core.utils.z.o(r14).isMediaRoom();
        nm1.r r17 = pm1.f.o();
        if (r17 == null) goto L9;
        r17.a();
        boolean r18 = MultiTabManagerImpl.e.i(r14);
    L11:
        if (r18 == false) goto L13;
        ContainerType r20 = ContainerType.MultiTab;
    L14:
        ContainerType r21 = r20;
        if (r16 == false) goto L17;
    L19:
        boolean r110 = false;
    L20:
        if (r18 == true) goto L22;
    L24:
        boolean r23 = false;
    L25:
        boolean r111 = r15.getCanLinkMic();
        s22.e.b r24 = new s22.e.b(r21, r23, r110, e.b, e.c, e.d, e.e, e.g, r111, r18);
        IRoomChannelService r25 = (IRoomChannelService) jc1.k.f(IRoomChannelService.class);
        if (r25 == null) goto L28;
        RoomContext r26 = this.$roomContext;
        RoomChatChannelCreator r27 = this.this$0;
        s22.e r28 = r25.createChatChannelManager(r26, r27.k, r27.l, r24);
    L29:
        this.$interactivityContext.getChatChannelManager().d(r28);
        RoomChatChannelCreator r29 = this.this$0;
        r29.i = true;
        r29.k.observe("data_user_in_room", r29);
        com.bytedance.android.livesdk.log.filter.a0 r30 = com.bytedance.android.livesdk.log.u.l().c(com.bytedance.android.livesdk.log.filter.n.class);
        if ((r30 instanceof com.bytedance.android.livesdk.log.filter.a0) == false) goto L33;
        r2 = r30;
    L33:
        com.bytedance.android.livesdk.log.filter.a0 r31 = r2;
        if (r31 != null) goto L36;
    L43:
        if (r28 == null) goto L45;
        r28.onRoomEnter(this.$room.roomChannel, "RoomObserver");
    L45:
        if (r28 == null) goto L47;
        r28.addListener(this.this$0);
    L47:
        RoomChatChannelCreator r33 = this.this$0;
        final Function1<d3, Unit> r34 = new AnonymousClass1(this);
        RxUtilKt.c(i80.a.b(r33.j.getImChannelInviteId(), new RoomChatChannelCreator$tryObserveJoinChannel$1(r34)), r33.a);
        return;
    L36:
        if (r24.a != ContainerType.MultiTab) goto L38;
        r3 = true;
    L38:
        r31.c = r3;
        Map r35 = ((com.bytedance.android.livesdk.log.filter.a) r31).b;
        if (r3 == false) goto L41;
        String r36 = "1";
    L42:
        r35.put("is_tab_mode", r36);
        goto L43
    L41:
        r36 = "0";
        goto L42
    L28:
        r28 = null;
        goto L29
    L22:
        if (r15.getHideLandscapeEntry() == true) goto L24;
        r23 = true;
        goto L25
    L17:
        if (r15.getHideLandscapeEntry() == true) goto L19;
        r110 = true;
        goto L20
    L13:
        r20 = ContainerType.PublicScreen;
        goto L14
    L9:
        r18 = false;
        goto L11
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((RoomChannelData) r1);
        return Unit.INSTANCE;
    }
}
