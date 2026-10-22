package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m extends MultiLinkAudioCommonGuestMicSeatBasicLayer {
    public TextView A;
    public View z;

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final int o() {
        return 2131565185;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer
    public final void O(int r3) {
        View r0 = this.z;
        if (r0 == null) goto L5;
        r0.setVisibility(r3);
    L5:
        ILinkPlayerInfoBridge r4 = J();
        String r1 = null;
        if (r4 == null) goto L10;
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L10;
        String r6 = r5.getIdString();
    L11:
        IRoom r2 = je0.d.e(null);
        if (r2 == null) goto L15;
        r1 = r2.getOwnerUserIdString();
    L15:
        if (Intrinsics.areEqual(r6, r1) == false) goto L19;
        TextView r7 = this.A;
        if (r7 == null) goto L23;
        r7.setText(s1.B(2131919212));
        return;
    L23:
        return;
    L19:
        TextView r8 = this.A;
        if (r8 == null) goto L25;
        r8.setText(s1.B(2131919274));
        return;
    L25:
        return;
    L10:
        r6 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        this.z = q().findViewById(2131377681);
        this.A = (TextView) q().findViewById(2131377691);
    }

    public m(MicSeatScene r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r3, r4);
    }
}
