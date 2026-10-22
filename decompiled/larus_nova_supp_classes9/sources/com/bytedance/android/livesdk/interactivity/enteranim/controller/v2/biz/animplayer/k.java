package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.android.livesdk.interactivity.enteranim.view.GameDownloadEnterView;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import javax.annotation.Nonnull;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends AnimPlayer<y72.a> {
    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    @Nonnull
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.GameDownLoad;
    }

    public k(InteractivityPlatformContext r1, DataCenter r2) {
        super(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.livesdk.interactivity.enteranim.view.GameDownloadEnterView] */
    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(@Nonnull k32.a r20, @Nonnull Context r21, @Nonnull AnimPlayer.a r23, @Nonnull ViewGroup r24, @Nonnull a r25) {
        y72.a r3 = (y72.a) r20;
        ?? r4 = new GameDownloadEnterView(r24.getContext());
        r4.setX(r24.getWidth());
        r4.setY(0.0f);
        Intrinsics.checkNotNullParameter(r3, "gameDownloadData");
        long r5 = r3.u;
        if (((int) r5) != 1) goto L5;
        String r6 = r3.t + ' ' + r3.v + r3.w;
    L6:
        TextView r7 = r4.a;
        if (r7 == null) goto L10;
        r7.setText(r6);
    L10:
        if (r3.x != 1) goto L45;
        int r8 = com.bytedance.android.livesdk.interactivity.enteranim.utils.l.a;
        String r9 = r3.w;
        Intrinsics.checkNotNullParameter(r9, "gameName");
        Intrinsics.checkNotNullParameter(r6, "showMsg");
        IRoomContextService r10 = jc1.k.f(IRoomContextService.class);
        LiveMode r15 = null;
        if (r10 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.o r11 = IRoomContextService.a.a(r10, null, 0, 3);
        if (r11 == null) goto L16;
        com.bytedance.live.datacontext.m r13 = r11.getRoom();
    L17:
        IMiddlewareUserService r16 = jc1.k.f(IMiddlewareUserService.class);
        if (r16 == null) goto L22;
        com.bytedance.android.livesdk.user.e r17 = r16.user();
        if (r17 == null) goto L22;
        String r18 = r17.n();
    L23:
        Pair[] r14 = new Pair[6];
        if (r13 == null) goto L28;
        IRoom r19 = (IRoom) r13.getValue();
        if (r19 == null) goto L28;
        Long r110 = Long.valueOf(r19.getRoomId());
    L29:
        r14[0] = TuplesKt.to("room_id", String.valueOf(r110));
        if (r13 == null) goto L34;
        IRoom r26 = (IRoom) r13.getValue();
        if (r26 == null) goto L34;
        String r27 = r26.getAnchorId();
    L35:
        r14[1] = TuplesKt.to("anchor_id", String.valueOf(r27));
        r14[2] = TuplesKt.to("user_id", String.valueOf(r18));
        IRoomContextService r28 = jc1.k.f(IRoomContextService.class);
        if (r28 == null) goto L44;
        com.bytedance.android.livesdk.chatroom.o r29 = IRoomContextService.a.a(r28, null, 0, 3);
        if (r29 == null) goto L44;
        com.bytedance.live.datacontext.m r30 = r29.getRoom();
        if (r30 == null) goto L44;
        IRoom r31 = (IRoom) r30.getValue();
        if (r31 == null) goto L44;
        r15 = r31.getStreamType();
    L44:
        int r33 = h1.a;
        r14[3] = TuplesKt.to("live_type", i1.a(r15));
        r14[4] = TuplesKt.to("game_name", r9);
        r14[5] = TuplesKt.to("message_detail", r6);
        j0.l().sendLog("livesdk_game_promote_user_book_message_show", MapsKt.mapOf(r14), new Object[]{am2.x.class, IRoom.class});
    L34:
        r27 = null;
    L28:
        r110 = null;
    L22:
        r18 = null;
    L16:
        r13 = null;
    L45:
        FrameLayout.LayoutParams r34 = new FrameLayout.LayoutParams(-2, -2);
        r34.gravity = 80;
        r24.addView(r4, r34);
        ViewGroup.MarginLayoutParams r35 = (ViewGroup.MarginLayoutParams) r4.getLayoutParams();
        r35.bottomMargin = r23.a;
        r4.setLayoutParams(r35);
        Animator r36 = com.bytedance.android.livesdk.interactivity.enteranim.utils.a.c(r4, new j(r24, r4, r25), c());
        r36.start();
        ((v72.c.a) r25).a.i = r36;
        RevenueUtils.a("GameDownload", r24, r3, r23.b);
        return;
    L5:
        r6 = r4.getContext().getString(2131916759, new Object[]{r3.t, IESUIUtils.getDisplayCount(r5, "w"), r3.v, r3.w});
        goto L6
    }
}
