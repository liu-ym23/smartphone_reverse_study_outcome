package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkPCLandscapeViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {
    public final xg0.a b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkPCLandscapeViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public final g<a> a;

        public ItemViewHolder(g<a> r2) {
            Intrinsics.checkNotNullParameter(r2, "layer");
            super(r2.l());
            this.a = r2;
        }
    }

    public static final class a extends MultiLinkGuestViewBinder.a {
        public final ch0.e q;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.q, ((a) r2).q) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ch0.e r0 = this.q;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.a
        public final String toString() {
            return "PCLandscapeItemData(linkUserMergeData=" + this.q + ")";
        }

        public a(ch0.e r3) {
            Intrinsics.checkNotNullParameter(r3, "linkUserMergeData");
            super(r3, null, 60);
            this.q = r3;
        }
    }

    public interface b {
        void K1(String r1);
    }

    public MultiLinkPCLandscapeViewBinder(xg0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "linkSeatAbilityProvider");
        this.b = r2;
    }

    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h((ItemViewHolder) r1, (a) r2);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        int r0 = hg0.c.a;
        MicSeatScene r1 = MicSeatScene.VIDEO_LINK;
        xg0.a r2 = this.b;
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "linkSeatAbilityProvider");
        mg0.a r5 = new mg0.a(r1, r2);
        g r6 = new g(r4);
        r6.b(r5);
        r6.a(r4.getContext());
        return new ItemViewHolder(r6);
    }

    public final void h(ItemViewHolder r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "item");
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "item");
        r2.a.v(r3, r3.a);
        xg0.a r4 = this.b;
        if (r4 == null) goto L9;
        String r5 = r3.k.a.getInteractId();
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        r4.K1(r5);
        return;
    }

    public final void c(RecyclerView.ViewHolder r2, Object r3, List r4) {
        ItemViewHolder r5 = (ItemViewHolder) r2;
        a r6 = (a) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        h(r5, r6);
    }
}
