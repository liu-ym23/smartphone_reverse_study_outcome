package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import java.util.Iterator;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkFirstUserViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {
    public final xg0.a b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkFirstUserViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhg0/b;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkGuestViewBinder$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
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

    public static final class a extends MultiLinkGuestViewBinder.a {
        public final ch0.e q;
        public final LinkmicPositionItem r;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.q, r4.q) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.r, r4.r) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ch0.e r0 = this.q;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            LinkmicPositionItem r4 = this.r;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.a
        public final String toString() {
            return "FirstUserItemData(linkUserMergeData=" + this.q + ", linkUserPositionName=" + this.r + ")";
        }

        public a(ch0.e r2, LinkmicPositionItem r3) {
            Intrinsics.checkNotNullParameter(r2, "linkUserMergeData");
            super(r2, r3, 60);
            this.q = r2;
            this.r = r3;
        }
    }

    public MultiLinkFirstUserViewBinder(xg0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "linkSeatAbilityProvider");
        this.b = r2;
    }

    public static void h(ItemViewHolder r1, a r2) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        Intrinsics.checkNotNullParameter(r2, "itemData");
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "itemData");
        r1.a.v(r2, r2.a);
    }

    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h((ItemViewHolder) r1, (a) r2);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r6, ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        Intrinsics.checkNotNullParameter(r7, "parent");
        m r0 = this.b.getLinkWindowLayoutConfig();
        int r1 = hg0.c.a;
        MicSeatScene r2 = MicSeatScene.VIDEO_LINK;
        xg0.a r3 = this.b;
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r0, "layoutConfig");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        if (r0.getUiLayout() != 7) goto L5;
    L12:
        MultiLinkCommonGuestMicSeatBasicLayer r8 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.d(r0, r2, r3);
    L14:
        if (r0.getUiLayout() == 7) goto L19;
        MultiLinkFrequencyOptConfig r4 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.k(Integer.valueOf(r0.m()), Integer.valueOf(r0.getUiLayout())) == true) goto L19;
        jg0.f r5 = new pg0.d(r8, r2, r3);
    L20:
        g r9 = new g(r7);
        r9.b(r8);
        r9.b(r5);
        r9.b(new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.theme.b(r8, r2, r3));
        boolean r10 = tb1.d.a;
        r9.b(new og0.a(r8, r3));
        r9.a(r7.getContext());
        return new ItemViewHolder(r9);
    L19:
        r5 = new pg0.c(r8, r2, r3);
        goto L20
    L5:
        if (r0.getUiLayout() == 25) goto L12;
        MultiLinkFrequencyOptConfig r11 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.k(Integer.valueOf(r0.m()), Integer.valueOf(r0.getUiLayout())) == true) goto L12;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.g(Integer.valueOf(r0.m()), Integer.valueOf(r0.getUiLayout())) == true) goto L12;
        r8 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.f(r0, r2, r3);
        goto L14
    }

    public final void c(RecyclerView.ViewHolder r4, Object r5, List r6) {
        ItemViewHolder r7 = (ItemViewHolder) r4;
        a r8 = (a) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if (r6.size() != 0) goto L5;
        h(r7, r8);
        return;
    L5:
        Iterator r9 = r6.iterator();
    L7:
        if (r9.hasNext() == false) goto L33;
        Object r0 = r9.next();
        if ((r0 instanceof Bundle) == true) goto L11;
        r0 = null;
    L11:
        Bundle r1 = (Bundle) r0;
        if (r1 == null) goto L7;
        if (r1.size() == 0) goto L21;
        if (r1.containsKey("payload_key_is_not_same_class") == true) goto L21;
        if (r1.containsKey("payload_key_update_for_show_from") == true) goto L21;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "itemData");
        Intrinsics.checkNotNullParameter(r1, "payload");
        r7.a.w(r8, r8.a, r1);
    L21:
        h(r7, r8);
        goto L7
    }
}
