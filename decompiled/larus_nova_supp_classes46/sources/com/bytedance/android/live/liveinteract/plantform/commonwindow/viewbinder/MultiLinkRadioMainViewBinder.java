package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import java.util.Iterator;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkRadioMainViewBinder extends me.drakeet.multitype.b<MultiLinkGuestViewBinder.a, RadioMainItemViewHolder> {
    public final xg0.a b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkRadioMainViewBinder$RadioMainItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhg0/b;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkGuestViewBinder$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class RadioMainItemViewHolder extends RecyclerView.ViewHolder implements hg0.b<MultiLinkGuestViewBinder.a> {
        public final g<MultiLinkGuestViewBinder.a> a;

        @Override // hg0.b
        public final g<MultiLinkGuestViewBinder.a> l() {
            return this.a;
        }

        public RadioMainItemViewHolder(g<MultiLinkGuestViewBinder.a> r2) {
            Intrinsics.checkNotNullParameter(r2, "layer");
            super(r2.l());
            this.a = r2;
            r2.j(r2.c.getContext());
        }
    }

    public MultiLinkRadioMainViewBinder(xg0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "linkSeatAbilityProvider");
        this.b = r2;
    }

    public final long a(Object r3) {
        MultiLinkGuestViewBinder.a r4 = (MultiLinkGuestViewBinder.a) r3;
        Intrinsics.checkNotNullParameter(r4, "item");
        return r4.a;
    }

    public static void h(RadioMainItemViewHolder r1, MultiLinkGuestViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        Intrinsics.checkNotNullParameter(r2, "item");
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "itemData");
        r1.a.v(r2, r2.a);
    }

    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h((RadioMainItemViewHolder) r1, (MultiLinkGuestViewBinder.a) r2);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        int r0 = hg0.c.a;
        MicSeatScene r1 = MicSeatScene.AUDIO_LINK_HEAD_RADIO;
        xg0.a r2 = this.b;
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "linkSeatAbilityProvider");
        ng0.b r5 = new ng0.b(r1, r2);
        g r6 = new g(r4);
        r6.b(r5);
        r6.a(r4.getContext());
        return new RadioMainItemViewHolder(r6);
    }

    public final void c(RecyclerView.ViewHolder r4, Object r5, List r6) {
        RadioMainItemViewHolder r7 = (RadioMainItemViewHolder) r4;
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
