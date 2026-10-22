package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.GameCastStrategy;
import com.bytedance.android.live.broadcastgame.xplay.q1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.a3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ i a;

    public j(i r1) {
        this.a = r1;
    }

    public final void accept(Object r33) {
        a3 r0 = (a3) r33;
        i r2 = this.a;
        r2.getClass();
        int r3 = com.bytedance.android.live.broadcastgame.opengame.sonicgame.e.a;
        GameCastStrategy r4 = com.bytedance.android.live.broadcastgame.opengame.sonicgame.e.a(true, r2.f);
        com.bytedance.android.live.broadcastgame.api.model.r r5 = r2.g.c();
        String r6 = "";
        if (r5 == null) goto L8;
        String r7 = r5.C();
        if (r7 == null) goto L8;
        String r11 = r7;
    L10:
        if (r2.g.iconUrl.isEmpty() == false) goto L12;
        String r8 = "";
    L14:
        if (r4 != GameCastStrategy.NONE) goto L16;
    L18:
        boolean r9 = false;
    L19:
        IInteractService r12 = jc1.k.f(IInteractService.class);
        if (r12 != null) goto L22;
    L27:
        boolean r14 = true;
    L28:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r13 = AnchorGameContext.a.a();
        if (r13 == null) goto L34;
        com.bytedance.live.datacontext.m<Boolean> r15 = r13.getOpenGameIntroCardAutoShow();
        if (r15 == null) goto L34;
        r15.setValue(Boolean.valueOf(Intrinsics.areEqual(r0.b, "true")));
    L34:
        if (q1.g(r2.g.c()) == false) goto L51;
        com.bytedance.android.live.broadcastgame.api.xplay.j r16 = new com.bytedance.android.live.broadcastgame.api.xplay.j();
        String r17 = r0.d;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r16.a = r17;
        String r18 = r0.e;
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r16.b = r18;
        Context r19 = r2.e;
        long r110 = com.bytedance.android.live.core.utils.z.o(r2.f).getRoomId();
        String r21 = com.bytedance.android.live.core.utils.z.o(r2.f).getAnchorId();
        boolean r22 = com.bytedance.android.live.core.utils.z.e(r2.f, false);
        String r23 = jc1.k.n(IUserService.class).user().n();
        IInteractService r24 = jc1.k.f(IInteractService.class);
        if (r24 != null) goto L38;
    L40:
        boolean r25 = false;
    L41:
        if (r25 == false) goto L43;
        XplayScene r26 = XplayScene.TalkRoom;
    L44:
        XplayScene r27 = r26;
        com.bytedance.android.live.broadcastgame.api.xplay.l r28 = com.bytedance.android.live.broadcastgame.api.xplay.m.a(r2.g);
        DataCenter r29 = r2.f;
        IInteractService r31 = jc1.k.f(IInteractService.class);
        if (r31 != null) goto L47;
    L49:
        boolean r210 = false;
    L50:
        com.bytedance.android.live.broadcastgame.api.xplay.p r32 = new com.bytedance.android.live.broadcastgame.api.xplay.p(r19, r110, r21, r22, r23, r27, null, r28, r29, null, r16, r210, false, 4672);
        com.bytedance.android.live.broadcastgame.api.xplay.n.b.j(r32);
    L66:
        e r34 = r2.d;
        if (r34 == null) goto L76;
        Integer r1 = r0.c;
        if (r1 != null) goto L71;
        return;
    L71:
        if (r1.intValue() != 1) goto L73;
        boolean r35 = true;
    L74:
        r34.a(r35);
        return;
    L73:
        r35 = false;
        goto L74
    L76:
        return;
    L47:
        if (r31.isTalkRoomLoaded() != true) goto L49;
        r210 = true;
        goto L50
    L43:
        r26 = XplayScene.Video;
        goto L44
    L38:
        if (r24.isTalkRoomLoaded() != true) goto L40;
        r25 = true;
        goto L41
    L51:
        com.bytedance.android.live.broadcastgame.api.openplatform.b r36 = r2.h;
        com.bytedance.android.live.broadcastgame.api.model.r r37 = r2.g.c();
        if (r37 == null) goto L54;
        long r38 = r37.p();
    L55:
        com.bytedance.android.live.broadcastgame.api.model.r r111 = r2.g.c();
        if (r111 == null) goto L61;
        String r112 = r111.b();
        if (r112 == null) goto L61;
        r6 = r112;
    L61:
        Pair[] r113 = new Pair[5];
        r113[0] = TuplesKt.to("game", r2.g);
        r113[1] = TuplesKt.to("OPEN_APP_ICON_URL", r8);
        if (r4 != GameCastStrategy.VIDEO_SINGLE) goto L64;
        boolean r39 = true;
    L65:
        r113[2] = TuplesKt.to("is_support_single_game_cast", Boolean.valueOf(r39));
        r113[3] = TuplesKt.to("auto_cast_game", Boolean.valueOf(r9));
        r113[4] = TuplesKt.to("listener", r2.g.h);
        long r41 = r38;
        String r114 = r6;
        r36.i(r41, r114, r11, MapsKt.mutableMapOf(r113), false, r14);
        goto L66
    L64:
        r39 = false;
        goto L65
    L54:
        r38 = 0;
        goto L55
    L22:
        if (r12.isTalkRoomLoaded() != true) goto L27;
        if (q1.g(r2.g.c()) == false) goto L27;
        r14 = false;
        goto L28
    L16:
        if (Intrinsics.areEqual(r0.a, "true") == false) goto L18;
        r9 = true;
        goto L19
    L12:
        r8 = (String) ListProtector.get(r2.g.iconUrl, 0);
    L8:
        r11 = "";
        goto L10
    }
}
