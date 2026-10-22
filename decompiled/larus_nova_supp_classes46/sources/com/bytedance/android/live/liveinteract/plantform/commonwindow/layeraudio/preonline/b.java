package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends MultiLinkPreOnlineMicSeatBasicLayer {
    @Override // jg0.c
    public final int o() {
        MicSeatScene r0 = this.b;
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return 2131566610;
    L5:
        if (r1 != 2) goto L7;
        return 2131566609;
    L7:
        if (r1 == 3) goto L9;
        return 0;
    L9:
        return 2131566577;
    }

    @Override // jg0.c
    public final String p() {
        MicSeatScene r0 = this.b;
        int r1 = a.b[r0.ordinal()];
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L11;
        return "";
    L11:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonLargePreOnlineLayer.name();
    L9:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonPreOnlineLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline.MultiLinkPreOnlineMicSeatBasicLayer
    public final void t() {
        MultiLinkPreOnlineViewBinder.a r0 = this.h;
        if (r0 == null) goto L8;
        xg0.a r1 = this.c;
        if (r1 == null) goto L9;
        r1.V3(r0);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline.MultiLinkPreOnlineMicSeatBasicLayer
    public final void u() {
        if (this.b != MicSeatScene.AUDIO_LINK_STAGE_ENLARGE) goto L8;
        TextView r0 = this.e;
        if (r0 == null) goto L9;
        r0.setTextSize(1, 8.0f);
        return;
    L9:
        return;
    }

    public b(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline.MultiLinkPreOnlineMicSeatBasicLayer, jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        r((MultiLinkPreOnlineViewBinder.a) r1, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline.MultiLinkPreOnlineMicSeatBasicLayer
    public final void r(MultiLinkPreOnlineViewBinder.a r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "itemData");
        super.r(r7, r8);
        MultiLinkPreOnlineViewBinder.a r9 = this.h;
        if (r9 == null) goto L5;
        IBaseUser r10 = r9.k;
    L6:
        if (r10 == null) goto L17;
        ImageView r0 = this.d;
        k r11 = r10.getAvatarThumbKt();
        MicSeatScene r1 = this.b;
        MicSeatScene r2 = MicSeatScene.AUDIO_LINK_LARGE;
        int r3 = 2131169249;
        if (r1 != r2) goto L10;
        int r4 = 2131169249;
    L11:
        int r5 = s1.j(r4);
        if (this.b == r2) goto L15;
        r3 = 2131169246;
    L15:
        a1.w(r0, r11, r5, s1.j(r3));
        goto L17
    L10:
        r4 = 2131169246;
    L17:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isVoiceMultiEnlargeSeat(o.d(), r8) == false) goto L22;
        TextView r12 = this.e;
        if (r12 == null) goto L22;
        r12.setTranslationY(s1.f(-7.0f));
    L22:
        if (o.d() != 28) goto L29;
        ImageView r13 = this.d;
        if (r13 == null) goto L30;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L31;
        r14.width = s1.f(37.0f);
        r14.height = s1.f(37.0f);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline.MultiLinkPreOnlineMicSeatBasicLayer, jg0.f
    public final /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        s((MultiLinkPreOnlineViewBinder.a) r1, r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline.MultiLinkPreOnlineMicSeatBasicLayer
    public final void s(MultiLinkPreOnlineViewBinder.a r7, int r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "itemData");
        Intrinsics.checkNotNullParameter(r9, "payload");
        super.s(r7, r8, r9);
        Iterator<String> r10 = r9.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L36;
        String r11 = r10.next();
        if (r11 == null) goto L4;
        int r0 = r11.hashCode();
        if (r0 != (-1993550306)) goto L11;
        if (r11.equals("payload_key_pre_online_user_update") == false) goto L4;
        MultiLinkPreOnlineViewBinder.a r12 = this.h;
        if (r12 == null) goto L4;
        IBaseUser r13 = r12.k;
        if (r13 == null) goto L4;
        ImageView r1 = this.d;
        k r14 = r13.getAvatarThumbKt();
        MicSeatScene r2 = this.b;
        MicSeatScene r3 = MicSeatScene.AUDIO_LINK_LARGE;
        int r4 = 2131169246;
        if (r2 != r3) goto L31;
        int r5 = 2131169249;
    L32:
        int r6 = s1.j(r5);
        if (this.b != r3) goto L35;
        r4 = 2131169249;
    L35:
        a1.w(r1, r14, r6, s1.j(r4));
        goto L4
    L31:
        r5 = 2131169246;
        goto L32
    L11:
        if (r0 != (-1199872866)) goto L13;
        if (r11.equals("payload_key_pre_online_link_player_status_update") == false) goto L4;
        v(r7.l);
        goto L4
    L13:
        if (r0 != (-117213154)) goto L4;
        if (r11.equals("payload_key_pre_online_position_item_update") == false) goto L4;
        w();
        goto L4
    }
}
