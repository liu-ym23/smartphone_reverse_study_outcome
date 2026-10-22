package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.o;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import jg0.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends MultiLinkAnimViewBinder {
    public final a f;
    public final hg0.a g;
    public final SeatAnimEngineWrapper h;

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAnimViewBinder
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder d(LayoutInflater r1, ViewGroup r2) {
        return i(r1, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAnimViewBinder
    public final MultiLinkAnimViewBinder.ItemViewHolder i(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "parent");
        m r0 = this.f.getLinkWindowLayoutConfig();
        if (r0.getUiLayout() != 27) goto L5;
    L14:
        int r10 = hg0.c.a;
        g r1 = hg0.c.a(r9, MicSeatScene.AUDIO_LINK_C_POSITION_V2, this.g, this.h, this.e);
    L16:
        return new MultiLinkAnimViewBinder.ItemViewHolder(r1);
    L5:
        if (r0.getUiLayout() == 26) goto L14;
        if (r0.getUiLayout() != 28) goto L11;
        int r2 = hg0.c.a;
        MicSeatScene r3 = MicSeatScene.AUDIO_LINK_HAMLET_AVATAR_C_POSITION;
        hg0.a r4 = this.g;
        SeatAnimEngineWrapper r5 = this.h;
        xg0.a r6 = this.e;
        Intrinsics.checkNotNullParameter(r9, "parent");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "layerGetter");
        Intrinsics.checkNotNullParameter(r6, "linkSeatAbilityProvider");
        o r11 = new o(r4, r5, r3, r6);
        r1 = new g(r9);
        r1.b(r11);
        r1.a(r9.getContext());
        goto L16
    L11:
        if (r0.j() != 5) goto L13;
        int r12 = hg0.c.a;
        r1 = hg0.c.a(r9, MicSeatScene.AUDIO_LINK_C_POSITION, this.g, this.h, this.e);
        goto L16
    L13:
        int r7 = hg0.c.a;
        MicSeatScene r13 = MicSeatScene.VIDEO_LINK_EQUAL;
        hg0.a r14 = this.g;
        SeatAnimEngineWrapper r15 = this.h;
        xg0.a r16 = this.e;
        Intrinsics.checkNotNullParameter(r9, "parent");
        Intrinsics.checkNotNullParameter(r13, "scene");
        Intrinsics.checkNotNullParameter(r14, "layerGetter");
        Intrinsics.checkNotNullParameter(r16, "linkSeatAbilityProvider");
        ig0.a r17 = new ig0.a(r14, r15, r13, r16);
        r1 = new g(r9);
        r1.b(r17);
        r1.a(r9.getContext());
        goto L16
    }

    public d(a r2, hg0.a r3, SeatAnimEngineWrapper r4, xg0.b r5) {
        Intrinsics.checkNotNullParameter(r2, "layoutConfigCallback");
        Intrinsics.checkNotNullParameter(r3, "layerGetter");
        Intrinsics.checkNotNullParameter(r5, "linkSeatAbilityProvider");
        super(r2, r3, r4, r5);
        this.f = r2;
        this.g = r3;
        this.h = r4;
    }
}
