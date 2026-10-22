package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends e {
    @Override // jg0.c
    public final int o() {
        return 2131566598;
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkCommonSpecialMicSeatBasicLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special.e
    public final void r() {
        if (GuestBattleContext.Companion.e() == false) goto L6;
        int r0 = o00.a.a;
        o00.a.a(this.f);
        return;
    L6:
        int r1 = o00.a.a;
        o00.a.a(this.f);
        View r2 = this.g;
        k r3 = null;
        if (r2 == null) goto L9;
        r2.setBackground(null);
    L9:
        MultiLinkSpecialViewBinder.a r4 = this.e;
        if (r4 == null) goto L12;
        IVoiceLiveTheme r5 = r4.c;
    L13:
        IVoiceLiveTheme.Companion r6 = IVoiceLiveTheme.Companion;
        if (r5 == null) goto L16;
        k r7 = r5.getIconMicLock();
    L18:
        if (r6.isImageModelValid(r7) == false) goto L24;
        ImageView r8 = this.h;
        if (r5 == null) goto L22;
        r3 = r5.getIconMicLock();
    L22:
        ImageUtil.loadImage(r8, r3, 0);
        return;
    L24:
        return;
    L16:
        r7 = null;
        goto L18
    L12:
        r5 = null;
        goto L13
    }

    public d(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r2, r3);
    }

    @Override // jg0.f
    public final void d(Object r1, int r2) {
        MultiLinkSpecialViewBinder.a r3 = (MultiLinkSpecialViewBinder.a) r1;
        Intrinsics.checkNotNullParameter(r3, "itemData");
        super.s(r3);
        if (n() != 0) goto L6;
        q().setOnClickListener(x0.a(new MultiLinkCommonSpecialMicSeatBasicLayer$onBind$1(this)));
        return;
    }
}
