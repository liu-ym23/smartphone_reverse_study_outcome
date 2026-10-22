package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import java.util.Iterator;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class MultiLinkAnimViewBinder extends me.drakeet.multitype.b<MultiLinkGuestViewBinder.a, ItemViewHolder> {
    public final a b;
    public final hg0.a c;
    public final SeatAnimEngineWrapper d;
    public final xg0.a e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkAnimViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhg0/b;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkGuestViewBinder$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder implements hg0.b<MultiLinkGuestViewBinder.a> {
        public final g<MultiLinkGuestViewBinder.a> a;

        @Override // hg0.b
        public final g<MultiLinkGuestViewBinder.a> l() {
            return this.a;
        }

        public ItemViewHolder(g<MultiLinkGuestViewBinder.a> r2) {
            Intrinsics.checkNotNullParameter(r2, "layer");
            super(r2.l());
            this.a = r2;
            r2.j(r2.c.getContext());
        }
    }

    public static void h(ItemViewHolder r2, MultiLinkGuestViewBinder.a r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "item");
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "itemData");
        r2.a.v(r3, r3.a);
        g<MultiLinkGuestViewBinder.a> r4 = r2.a;
        if (r3.j == false) goto L5;
        int r5 = 0;
    L6:
        r4.x(r5);
        return;
    L5:
        r5 = 4;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h((ItemViewHolder) r1, (MultiLinkGuestViewBinder.a) r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder d(LayoutInflater r1, ViewGroup r2) {
        return i(r1, r2);
    }

    public ItemViewHolder i(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "parent");
        m r0 = this.b.getLinkWindowLayoutConfig();
        if (r0.j() != 5) goto L15;
        int r10 = r0.getUiLayout();
        if (r10 != 21) goto L7;
        int r11 = hg0.c.a;
        g r12 = hg0.c.a(r9, MicSeatScene.AUDIO_LINK, this.c, this.d, this.e);
    L17:
        return new ItemViewHolder(r12);
    L7:
        if (r10 == 22) goto L13;
        switch(r10) {
            case 28: goto L12;
            case 29: goto L11;
            case 30: goto L10;
            default: goto L9;
        };
    L9:
        int r13 = hg0.c.a;
        r12 = hg0.c.a(r9, MicSeatScene.AUDIO_LINK, this.c, this.d, this.e);
        goto L17
    L10:
        int r14 = hg0.c.a;
        r12 = hg0.c.a(r9, MicSeatScene.AUDIO_LINK_STAGE_ENLARGE, this.c, this.d, this.e);
        goto L17
    L11:
        int r15 = hg0.c.a;
        r12 = hg0.c.a(r9, MicSeatScene.AUDIO_LINK_HEAD_RADIO, this.c, this.d, this.e);
        goto L17
    L12:
        int r16 = hg0.c.a;
        r12 = hg0.c.a(r9, MicSeatScene.AUDIO_LINK_HAMLET_AVATAR, this.c, this.d, this.e);
        goto L17
    L13:
        int r17 = hg0.c.a;
        r12 = hg0.c.a(r9, MicSeatScene.AUDIO_LINK_LARGE, this.c, this.d, this.e);
        goto L17
    L15:
        int r1 = hg0.c.a;
        MicSeatScene r5 = MicSeatScene.VIDEO_LINK_EQUAL;
        hg0.a r2 = this.c;
        SeatAnimEngineWrapper r4 = this.d;
        xg0.a r6 = this.e;
        Intrinsics.checkNotNullParameter(r9, "parent");
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r2, "layerGetter");
        Intrinsics.checkNotNullParameter(r6, "linkSeatAbilityProvider");
        ig0.b r18 = new ig0.b(r2, 12, r4, r5, r6);
        g r3 = new g(r9);
        r3.b(r18);
        r3.a(r9.getContext());
        r12 = r3;
        goto L17
    }

    public final void c(RecyclerView.ViewHolder r4, Object r5, List r6) {
        ItemViewHolder r7 = (ItemViewHolder) r4;
        MultiLinkGuestViewBinder.a r8 = (MultiLinkGuestViewBinder.a) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if (r6.size() != 0) goto L5;
        h(r7, r8);
        return;
    L5:
        Iterator r9 = r6.iterator();
    L7:
        if (r9.hasNext() == false) goto L44;
        Object r0 = r9.next();
        if ((r0 instanceof Bundle) == true) goto L11;
        r0 = null;
    L11:
        Bundle r1 = (Bundle) r0;
        if (r1 == null) goto L7;
        if (r1.size() == 0) goto L28;
        if (r1.containsKey("payload_key_is_not_same_class") == true) goto L28;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "itemData");
        Intrinsics.checkNotNullParameter(r1, "payload");
        r7.a.w(r8, r8.a, r1);
        if (r1.containsKey("payload_key_is_visible") == true) goto L20;
        if (r1.containsKey("payload_key_update_for_show_from") == false) goto L7;
        r7.a.v(r8, r8.a);
        goto L7
    L20:
        g<MultiLinkGuestViewBinder.a> r2 = r7.a;
        if (r8.j == false) goto L23;
        int r3 = 0;
    L24:
        r2.x(r3);
        goto L7
    L23:
        r3 = 4;
    L28:
        h(r7, r8);
        goto L7
    }

    public MultiLinkAnimViewBinder(a r2, hg0.a r3, SeatAnimEngineWrapper r4, xg0.b r5) {
        Intrinsics.checkNotNullParameter(r2, "layoutConfigCallback");
        Intrinsics.checkNotNullParameter(r3, "layerGetter");
        Intrinsics.checkNotNullParameter(r5, "linkSeatAbilityProvider");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
