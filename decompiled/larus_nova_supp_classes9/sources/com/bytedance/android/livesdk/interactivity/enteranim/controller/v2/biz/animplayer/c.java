package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public final HashMap<AnimPlayer.PlayerType, AnimPlayer<?>> a;
    public boolean b;

    public c() {
        this.a = new HashMap();
        this.b = false;
    }

    @Nonnull
    public static AnimPlayer.PlayerType a(@Nonnull k32.a r2) {
        va.a r0 = r2.k;
        if ((r2 instanceof k32.d) == false) goto L7;
        return AnimPlayer.PlayerType.WindScreen;
    L7:
        if ((r2 instanceof k32.b) == false) goto L11;
        return AnimPlayer.PlayerType.Ecom;
    L11:
        if ((r2 instanceof y72.a) == false) goto L15;
        return AnimPlayer.PlayerType.GameDownLoad;
    L15:
        if ((r2 instanceof k32.c) == true) goto L17;
        if (r0 == null) goto L58;
        if (r0.getType() != 4) goto L24;
        return AnimPlayer.PlayerType.Vigo;
    L24:
        if (r0.getType() != 5) goto L28;
        return AnimPlayer.PlayerType.WebpEnter;
    L28:
        if (r0.getType() != 3) goto L32;
        return AnimPlayer.PlayerType.SpecialEnterAnim;
    L32:
        if (r0.getType() != 2) goto L36;
        return AnimPlayer.PlayerType.BigEnterAnim;
    L36:
        if (r0.getType() != 1) goto L40;
        return AnimPlayer.PlayerType.SmallEnterAnim;
    L40:
        if (r0.getType() != 6) goto L44;
        return AnimPlayer.PlayerType.HotsoonDriveEnter;
    L44:
        if (r0.getType() != 7) goto L48;
        return AnimPlayer.PlayerType.HotsoonDriveWebp;
    L48:
        if (r0.getType() != 8) goto L52;
        return AnimPlayer.PlayerType.CustomEnter;
    L52:
        if (r0.getType() != 9) goto L56;
        return AnimPlayer.PlayerType.Mp4EnhancedEnter;
    L56:
        return AnimPlayer.PlayerType.UnKnownEffect;
    L58:
        return AnimPlayer.PlayerType.DouyinDefault;
    L17:
        return AnimPlayer.PlayerType.OpenAssetVideo;
    }

    public final void b(InteractivityPlatformContext r7, DataCenter r8) {
        if (r7 == null) goto L11;
        if (r8 == null) goto L12;
        int r3 = 0;
        AnimPlayer<?>[] r1 = {new i(r7, r8), new k(r7, r8), new u(r7, r8), new d(r7, r8), new g(r7, r8), new w(r7, r8), new v(r7, r8), new a0(r7, r8), new n(r7, r8), new l(r7, r8), new m(r7, r8), new t(r7, r8), new OpenAssetVideoPlayer(r7, r8), new Mp4EnhancedEnterPlayer(r7, r8)};
    L6:
        if (r3 >= 14) goto L8;
        AnimPlayer<?> r9 = r1[r3];
        this.a.put(r9.getType(), r9);
        r3 = r3 + 1;
        goto L6
    L8:
        this.b = true;
        return;
    L12:
        return;
    }
}
