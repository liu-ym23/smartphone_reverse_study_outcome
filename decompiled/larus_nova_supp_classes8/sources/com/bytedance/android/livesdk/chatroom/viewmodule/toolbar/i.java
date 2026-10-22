package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.config.we;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i extends ToolbarConstraints {
    public final List<ToolbarSlot> g;

    public static final class a {
    }

    static {
    }

    public i() {
        ToolbarSlot[] r0 = new ToolbarSlot[27];
        ToolbarSlot r1 = new ToolbarSlot();
        r1.setPriority(BubbleId.PadCast);
        r1.d().add(CollectionsKt.listOf(ToolbarButton.CHAT_CHANNEL_LANDSCAPE.name()));
        Unit r3 = Unit.INSTANCE;
        r0[0] = r1;
        ToolbarSlot r2 = new ToolbarSlot();
        r2.setPriority(BubbleId.PadCast);
        r2.d().add(CollectionsKt.listOf(ToolbarButton.ROOM_CHANNEL_LANDSCAPE.name()));
        r0[1] = r2;
        ToolbarSlot r4 = new ToolbarSlot();
        r4.setPriority(BubbleId.PadCast);
        r4.d().add(CollectionsKt.listOf(ToolbarButton.VS_FAST_PLAY.name()));
        r0[2] = r4;
        ToolbarSlot r5 = new ToolbarSlot();
        r5.setPriority(BubbleId.PadCast);
        r5.d().add(CollectionsKt.listOf(ToolbarButton.CAST_FEED_BACK.name()));
        r0[3] = r5;
        ToolbarSlot r6 = new ToolbarSlot();
        r6.setPriority(BubbleId.PadCast);
        r6.d().add(CollectionsKt.listOf(ToolbarButton.CAST_REFRESH.name()));
        r0[4] = r6;
        ToolbarSlot r7 = new ToolbarSlot();
        r7.setPriority(BubbleId.PadCast);
        r7.d().add(CollectionsKt.listOf(ToolbarButton.VS_VIDEO_QUALITY.name()));
        r0[5] = r7;
        ToolbarSlot r8 = new ToolbarSlot();
        r8.setPriority(500);
        r8.d().add(CollectionsKt.listOf(ToolbarButton.GAME_GUESS.name()));
        r0[6] = r8;
        ToolbarSlot r9 = new ToolbarSlot();
        r9.setPriority(490);
        r9.d().add(CollectionsKt.listOf(ToolbarButton.OPEN_PLATFORM_LYNX_GAME.name()));
        r0[7] = r9;
        ToolbarSlot r10 = new ToolbarSlot();
        r10.setPriority(499);
        r10.d().add(CollectionsKt.listOf(new String[]{ToolbarButton.INTERACTION_AUDIENCE.name(), ToolbarButton.INTERACTION.name()}));
        r0[8] = r10;
        ToolbarSlot r11 = new ToolbarSlot();
        r11.setPriority(501);
        we r13 = we.a;
        if (((Boolean) r13.getValue()).booleanValue() == false) goto L5;
        r11.d().add(CollectionsKt.listOf(ToolbarButton.OPEN_PLATFORM_MINI_APP.name()));
    L5:
        r0[9] = r11;
        ToolbarSlot r12 = new ToolbarSlot();
        r12.setPriority(502);
        if (((Boolean) r13.getValue()).booleanValue() == false) goto L8;
        List<String> r14 = CollectionsKt.listOf(new String[]{ToolbarButton.REPLAY_TICKET_SALE.name(), ToolbarButton.TICKET_SALE.name(), ToolbarButton.COMMERCE.name(), ToolbarButton.LITTLE_GAME.name(), ToolbarButton.OPEN_PLATFORM_GAME.name(), ToolbarButton.COMMERCE_LIVE_AD.name(), ToolbarButton.GROUP_PURCHASE_AUDIENCE.name(), ToolbarButton.EASTER_EGG.name(), ToolbarButton.WELFARE.name(), ToolbarButton.OPEN_PLATFORM_MINI_GAME.name(), ToolbarButton.GAME_PROMOTE_AUDIENCE.name()});
    L9:
        r12.d().add(r14);
        r0[10] = r12;
        ToolbarSlot r15 = new ToolbarSlot();
        r15.setPriority(400);
        r15.d().add(CollectionsKt.listOf(ToolbarButton.COUPON_EXCHANGE.name()));
        r15.d().add(CollectionsKt.listOf(ToolbarButton.CASH_EXCHANGE.name()));
        r15.d().add(CollectionsKt.listOf(ToolbarButton.AUTO_CAR.name()));
        r15.d().add(CollectionsKt.listOf(ToolbarButton.AIRDROP_GIFT.name()));
        r15.d().add(CollectionsKt.listOf(ToolbarButton.FAST_GIFT.name()));
        r0[11] = r15;
        ToolbarSlot r16 = new ToolbarSlot();
        r16.setPriority(999);
        r16.d().add(CollectionsKt.listOf(ToolbarButton.GIFT.name()));
        r0[12] = r16;
        ToolbarSlot r17 = new ToolbarSlot();
        r17.setPriority(996);
        r17.d().add(CollectionsKt.listOf(ToolbarButton.VR_MODE.name()));
        r0[13] = r17;
        ToolbarSlot r18 = new ToolbarSlot();
        r18.setPriority(997);
        r18.d().add(CollectionsKt.listOf(ToolbarButton.MULTI_CAMERA_LINKED_ROOM.name()));
        r0[14] = r18;
        ToolbarSlot r19 = new ToolbarSlot();
        r19.setPriority(990);
        r19.d().add(CollectionsKt.listOf(ToolbarButton.QUICK_SCREEN_SHOT.name()));
        r0[15] = r19;
        ToolbarSlot r20 = new ToolbarSlot();
        r20.setPriority(985);
        r20.d().add(CollectionsKt.listOf(ToolbarButton.ROOM_CHANNEL.name()));
        r0[16] = r20;
        ToolbarSlot r21 = new ToolbarSlot();
        r21.setPriority(501);
        r21.d().add(CollectionsKt.listOf(ToolbarButton.VS_MESSAGE_BOARD.name()));
        r0[17] = r21;
        ToolbarSlot r22 = new ToolbarSlot();
        r22.setPriority(980);
        r22.d().add(CollectionsKt.listOf(ToolbarButton.VS_ACTIVITY_ONE.name()));
        r0[18] = r22;
        ToolbarSlot r23 = new ToolbarSlot();
        r23.setPriority(BubbleId.PadCast);
        r23.d().add(CollectionsKt.listOf(ToolbarButton.VS_CAST_SCREEN.name()));
        r0[19] = r23;
        ToolbarSlot r24 = new ToolbarSlot();
        r24.setPriority(BubbleId.PadCast);
        r24.d().add(CollectionsKt.listOf(ToolbarButton.SHARE.name()));
        r0[20] = r24;
        ToolbarSlot r25 = new ToolbarSlot();
        r25.setPriority(BubbleId.PadCast);
        r25.d().add(CollectionsKt.listOf(ToolbarButton.MORE.name()));
        r0[21] = r25;
        ToolbarSlot r26 = new ToolbarSlot();
        r26.setPriority(501);
        r26.d().add(CollectionsKt.listOf(ToolbarButton.LIVE_IM_ENTRANCE.name()));
        r0[22] = r26;
        ToolbarSlot r27 = new ToolbarSlot();
        r27.setPriority(BubbleId.PadCast);
        r27.d().add(CollectionsKt.listOf(new String[]{ToolbarButton.DOUYIN_CLOSE.name(), ToolbarButton.CLOSE_ROOM.name()}));
        r0[23] = r27;
        ToolbarSlot r28 = new ToolbarSlot();
        r28.setPriority(2000);
        r28.d().add(CollectionsKt.listOf(ToolbarButton.SWITCH_VIDEO_QUALITY.name()));
        r0[24] = r28;
        ToolbarSlot r29 = new ToolbarSlot();
        r29.setPriority(2000);
        r29.d().add(CollectionsKt.listOf(ToolbarButton.LANDSCAPE_MULTI_TAB.name()));
        r0[25] = r29;
        ToolbarSlot r30 = new ToolbarSlot();
        r30.setPriority(1999);
        r30.d().add(CollectionsKt.listOf(ToolbarButton.VS_SELECT_EPISODE.name()));
        r0[26] = r30;
        this.g = CollectionsKt.listOf(r0);
        return;
    L8:
        r14 = CollectionsKt.listOf(new String[]{ToolbarButton.REPLAY_TICKET_SALE.name(), ToolbarButton.TICKET_SALE.name(), ToolbarButton.COMMERCE.name(), ToolbarButton.LITTLE_GAME.name(), ToolbarButton.OPEN_PLATFORM_MINI_APP.name(), ToolbarButton.OPEN_PLATFORM_GAME.name(), ToolbarButton.COMMERCE_LIVE_AD.name(), ToolbarButton.GROUP_PURCHASE_AUDIENCE.name(), ToolbarButton.EASTER_EGG.name(), ToolbarButton.WELFARE.name(), ToolbarButton.OPEN_PLATFORM_MINI_GAME.name(), ToolbarButton.GAME_PROMOTE_AUDIENCE.name()});
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarConstraints
    public final List<ToolbarSlot> a() {
        return this.g;
    }
}
