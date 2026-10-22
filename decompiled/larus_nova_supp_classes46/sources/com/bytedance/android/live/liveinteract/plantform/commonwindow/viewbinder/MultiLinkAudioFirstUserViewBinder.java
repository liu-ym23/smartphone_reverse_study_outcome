package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ch0.l;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.h;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.i;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.j;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.k;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.n;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import java.util.Iterator;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkAudioFirstUserViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {
    public final xg0.a b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkAudioFirstUserViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhg0/b;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkGuestViewBinder$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
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
        public final l s;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.q, r4.q) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.r, r4.r) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.s, r4.s) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
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
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            l r7 = this.s;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.a
        public final String toString() {
            return "AudioFirstUserItemData(linkUserMergeData=" + this.q + ", linkUserPositionName=" + this.r + ", voiceAnchorGuideInfo=" + this.s + ")";
        }

        public a(ch0.e r2, LinkmicPositionItem r3, l r4) {
            Intrinsics.checkNotNullParameter(r2, "linkUserMergeData");
            Intrinsics.checkNotNullParameter(r4, "voiceAnchorGuideInfo");
            super(r2, r3, 60);
            this.q = r2;
            this.r = r3;
            this.s = r4;
        }
    }

    public MultiLinkAudioFirstUserViewBinder(xg0.b r2) {
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

    public final RecyclerView.ViewHolder d(LayoutInflater r9, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        Intrinsics.checkNotNullParameter(r10, "parent");
        m r0 = this.b.getLinkWindowLayoutConfig();
        se0.c r1 = this.b.getAudioFeedLayerUIConfig();
        if (r0.getUiLayout() != 27) goto L5;
    L19:
        int r2 = hg0.c.a;
        MicSeatScene r3 = MicSeatScene.AUDIO_LINK_C_POSITION_V2;
        xg0.a r4 = this.b;
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r0, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        i r11 = new i(r3, r0, r4);
        r11.d = r1;
        sg0.b r5 = new sg0.b(r3, r0, r4);
        g r6 = new g(r10);
        r6.b(r11);
        r6.b(new tg0.a(r11, r3, r4));
        r6.b(r5);
        r6.b(new rg0.a(r3, r5, r11, r4));
        r6.a(r10.getContext());
    L21:
        return new ItemViewHolder(r6);
    L5:
        if (r0.getUiLayout() == 26) goto L19;
        if (r0.getUiLayout() != 28) goto L11;
        int r7 = hg0.c.a;
        MicSeatScene r8 = MicSeatScene.AUDIO_LINK_C_POSITION_V2;
        xg0.a r12 = this.b;
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r8, "scene");
        Intrinsics.checkNotNullParameter(r0, "layoutConfig");
        Intrinsics.checkNotNullParameter(r12, "linkSeatAbilityProvider");
        n r13 = new n(r8, r0, r12);
        r13.d = r1;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.m r14 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.m(r8, r0, r12);
        r14.d = r1;
        r6 = new g(r10);
        r6.b(r14);
        r6.b(r13);
        r6.a(r10.getContext());
        goto L21
    L11:
        if (r0.getUiLayout() != 30) goto L18;
        List<Integer> r15 = r0.e;
        if (r15 != null) goto L15;
    L17:
        int r16 = hg0.c.a;
        MicSeatScene r17 = MicSeatScene.AUDIO_LINK_STAGE_ENLARGE_MAIN;
        xg0.a r18 = this.b;
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r17, "scene");
        Intrinsics.checkNotNullParameter(r0, "layoutConfig");
        Intrinsics.checkNotNullParameter(r18, "linkSeatAbilityProvider");
        k r19 = new k(r17, r0, r18);
        r19.d = r1;
        r6 = new g(r10);
        r6.b(r19);
        r6.b(new rg0.b(r17, r19, r18));
        r6.a(r10.getContext());
        goto L21
    L15:
        if (r15.contains(8) != true) goto L17;
        int r20 = hg0.c.a;
        MicSeatScene r21 = MicSeatScene.AUDIO_LINK_STAGE_ENLARGE_MAIN;
        xg0.a r22 = this.b;
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r21, "scene");
        Intrinsics.checkNotNullParameter(r0, "layoutConfig");
        Intrinsics.checkNotNullParameter(r22, "linkSeatAbilityProvider");
        j r23 = new j(r21, r0, r22);
        r23.d = r1;
        r6 = new g(r10);
        r6.b(r23);
        r6.b(new rg0.b(r21, r23, r22));
        r6.a(r10.getContext());
        goto L21
    L18:
        gh0.b.a("audio_layer_update", "MultiLinkAudioFirstUserViewBinder#onCreateViewHolder", false);
        int r24 = hg0.c.a;
        MicSeatScene r25 = MicSeatScene.AUDIO_LINK_C_POSITION;
        xg0.a r26 = this.b;
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r25, "scene");
        Intrinsics.checkNotNullParameter(r0, "layoutConfig");
        Intrinsics.checkNotNullParameter(r26, "linkSeatAbilityProvider");
        h r27 = new h(r25, r0, r26);
        r27.d = r1;
        sg0.b r28 = new sg0.b(r25, r0, r26);
        r6 = new g(r10);
        r6.b(r27);
        r6.b(new tg0.a(r27, r25, r26));
        r6.b(r28);
        r6.b(new rg0.a(r25, r28, r27, r26));
        r6.a(r10.getContext());
        goto L21
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
