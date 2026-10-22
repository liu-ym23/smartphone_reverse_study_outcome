package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import jg0.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends MultiLinkAnimViewBinder {
    public final a f;
    public final hg0.a g;
    public final SeatAnimEngineWrapper h;

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAnimViewBinder
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder d(LayoutInflater r1, ViewGroup r2) {
        return i(r1, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAnimViewBinder
    public final MultiLinkAnimViewBinder.ItemViewHolder i(LayoutInflater r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r6, "parent");
        int r0 = hg0.c.a;
        MicSeatScene r1 = MicSeatScene.AUDIO_LINK_C_POSITION;
        hg0.a r2 = this.g;
        SeatAnimEngineWrapper r3 = this.h;
        xg0.a r4 = this.e;
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "layerGetter");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        qg0.c r7 = new qg0.c(r2, r3, r1, r4);
        g r8 = new g(r6);
        r8.b(r7);
        r8.a(r6.getContext());
        return new MultiLinkAnimViewBinder.ItemViewHolder(r8);
    }

    public e(a r2, hg0.a r3, SeatAnimEngineWrapper r4, xg0.b r5) {
        Intrinsics.checkNotNullParameter(r2, "layoutConfigCallback");
        Intrinsics.checkNotNullParameter(r3, "layerGetter");
        Intrinsics.checkNotNullParameter(r5, "linkSeatAbilityProvider");
        super(r2, r3, r4, r5);
        this.f = r2;
        this.g = r3;
        this.h = r4;
    }
}
