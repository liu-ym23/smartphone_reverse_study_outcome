package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q extends ToolbarConstraints {
    public final List<ToolbarSlot> g;

    public q() {
        ToolbarSlot[] r0 = new ToolbarSlot[14];
        ToolbarSlot r1 = new ToolbarSlot();
        r1.setPriority(BubbleId.PadCast);
        r1.d().add(CollectionsKt.listOf(ToolbarButton.CHANNEL_COMMENT.name()));
        Unit r3 = Unit.INSTANCE;
        r0[0] = r1;
        ToolbarSlot r2 = new ToolbarSlot();
        r2.setPriority(BubbleId.PadCast);
        r2.d().add(CollectionsKt.listOf(ToolbarButton.SQUARE_COMMENT.name()));
        r0[1] = r2;
        ToolbarSlot r4 = new ToolbarSlot();
        r4.setPriority(BubbleId.PadCast);
        r4.d().add(CollectionsKt.listOf(new String[]{ToolbarButton.GAME_GUESS.name(), ToolbarButton.OPEN_PLATFORM_LYNX_GAME.name()}));
        r0[2] = r4;
        ToolbarSlot r5 = new ToolbarSlot();
        r5.setPriority(602);
        r5.d().add(CollectionsKt.listOf(ToolbarButton.AUTO_CAR.name()));
        r0[3] = r5;
        ToolbarSlot r6 = new ToolbarSlot();
        r6.setPriority(BubbleId.PadCast);
        r6.d().add(CollectionsKt.listOf(ToolbarButton.INTERACT_GAME.name()));
        r0[4] = r6;
        ToolbarSlot r7 = new ToolbarSlot();
        r7.setPriority(BubbleId.PadCast);
        r7.d().add(CollectionsKt.listOf(ToolbarButton.BROADCAST_EFFECT.name()));
        r0[5] = r7;
        ToolbarSlot r8 = new ToolbarSlot();
        r8.setPriority(BubbleId.PadCast);
        r8.d().add(CollectionsKt.listOf(ToolbarButton.VIRTUAL_LIVE.name()));
        r0[6] = r8;
        ToolbarSlot r9 = new ToolbarSlot();
        r9.setPriority(601);
        ToolbarButton r10 = ToolbarButton.GAME_PROMOTE;
        List<String> r11 = CollectionsKt.listOf(new String[]{ToolbarButton.COMMERCE.name(), ToolbarButton.LITTLE_GAME.name(), ToolbarButton.TRANSFORM_WIDGET.name(), ToolbarButton.GROUP_PURCHASE.name(), ToolbarButton.WELFARE.name(), r10.name(), ToolbarButton.TICKET_SALE_ANCHOR.name()});
        com.bytedance.android.livesdk.config.c r12 = com.bytedance.android.livesdk.config.c.a;
        if (((Boolean) r12.getValue()).booleanValue() == false) goto L5;
        List r13 = CollectionsKt.toMutableList(r11);
        r13.remove(r10.name());
        r11 = CollectionsKt.toList(r13);
    L5:
        r9.d().add(r11);
        r0[7] = r9;
        ToolbarSlot r14 = new ToolbarSlot();
        r14.setPriority(602);
        r14.d().add(CollectionsKt.listOf(ToolbarButton.OPEN_PLATFORM_MINI_APP.name()));
        r0[8] = r14;
        ToolbarSlot r15 = new ToolbarSlot();
        r15.setPriority(603);
        if (((Boolean) r12.getValue()).booleanValue() == false) goto L8;
        r15.d().add(CollectionsKt.listOf(r10.name()));
    L8:
        r0[9] = r15;
        ToolbarSlot r16 = new ToolbarSlot();
        r16.setPriority(800);
        r16.d().add(CollectionsKt.listOf(ToolbarButton.ATTACK_AND_DEFENSE.name()));
        r0[10] = r16;
        ToolbarSlot r17 = new ToolbarSlot();
        r17.setPriority(BubbleId.PadCast);
        r17.d().add(CollectionsKt.listOf(ToolbarButton.CLOSE_ROOM.name()));
        r0[11] = r17;
        ToolbarSlot r18 = new ToolbarSlot();
        r18.setPriority(BubbleId.PadCast);
        r18.d().add(CollectionsKt.listOf(ToolbarButton.MORE.name()));
        r0[12] = r18;
        ToolbarSlot r19 = new ToolbarSlot();
        r19.setPriority(600);
        r19.d().add(CollectionsKt.listOf(ToolbarButton.LIVE_IM_ENTRANCE.name()));
        r0[13] = r19;
        this.g = CollectionsKt.listOf(r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarConstraints
    public final List<ToolbarSlot> a() {
        return this.g;
    }
}
