package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import jg0.g;
import jg0.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkDynamicIslandViewBinder extends me.drakeet.multitype.b<tf0.e, ItemViewHolder> {
    public boolean b;
    public boolean c;
    public final DataCenter d;
    public final xg0.a e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkDynamicIslandViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhg0/b;", "Ltf0/e;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder implements hg0.b<tf0.e> {
        public final g<tf0.e> a;

        @Override // hg0.b
        public final g<tf0.e> l() {
            return this.a;
        }

        public ItemViewHolder(h r2) {
            Intrinsics.checkNotNullParameter(r2, "layer");
            super(r2.l());
            this.a = r2;
            r2.j(r2.c.getContext());
        }
    }

    public final long a(Object r3) {
        tf0.e r4 = (tf0.e) r3;
        Intrinsics.checkNotNullParameter(r4, "item");
        return r4.a;
    }

    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h((ItemViewHolder) r1, (tf0.e) r2);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r12, ViewGroup r13) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        Intrinsics.checkNotNullParameter(r13, "parent");
        this.e.getLinkWindowLayoutConfig();
        m r0 = this.e.getLinkWindowLayoutConfig();
        se0.c r1 = this.e.getAudioFeedLayerUIConfig();
        int r2 = hg0.c.a;
        MicSeatScene r3 = MicSeatScene.AUDIO_LINK_DYNAMIC_ISLAND;
        g r7 = hg0.c.c(r13, r3, r0, r1, this.e);
        g r8 = hg0.c.b(r13, r3, r1, r0, this.e);
        MicSeatScene r4 = MicSeatScene.AUDIO_LINK;
        g r9 = hg0.c.d(r13, r4, r0, this.e);
        g r10 = hg0.c.e(r13, r4, this.e);
        DataCenter r6 = this.d;
        Intrinsics.checkNotNullParameter(r13, "parent");
        Intrinsics.checkNotNullParameter(r7, "guestLayer");
        Intrinsics.checkNotNullParameter(r8, "emptyLayer");
        Intrinsics.checkNotNullParameter(r9, "specialItemLayer");
        Intrinsics.checkNotNullParameter(r10, "preOnlineLayer");
        h r14 = new h(r13, r6, r7, r8, r9, r10);
        r14.a(r13.getContext());
        int r15 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r16 = this.e.getDataCenter();
        IRoom r5 = this.e.getRoom();
        if (r5 == null) goto L5;
        long r11 = r5.getId();
    L6:
        MultiSceneEnterRoomStatisticsUtils r17 = MultiSceneEnterRoomStatisticsUtils.a.a(r16, Long.valueOf(r11));
        if (r17 == null) goto L9;
        r17.c();
    L9:
        System.currentTimeMillis();
        return new ItemViewHolder(r14);
    L5:
        r11 = 0;
        goto L6
    }

    public final void h(ItemViewHolder r9, tf0.e r10) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        Intrinsics.checkNotNullParameter(r10, "item");
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "itemData");
        r9.a.v(r10, r10.a);
        if (this.b == true) goto L39;
        int r0 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r1 = this.e.getDataCenter();
        IRoom r2 = this.e.getRoom();
        long r3 = 0;
        if (r2 == null) goto L7;
        long r4 = r2.getId();
    L8:
        MultiSceneEnterRoomStatisticsUtils r5 = MultiSceneEnterRoomStatisticsUtils.a.a(r1, Long.valueOf(r4));
        if (r5 == null) goto L11;
        r5.c();
    L11:
        System.currentTimeMillis();
        r9.getLayoutPosition();
        ((me.drakeet.multitype.b) this).a.getItemCount();
        r10.toString();
        if (r9.getLayoutPosition() != (((me.drakeet.multitype.b) this).a.getItemCount() - 1)) goto L40;
        Iterator r11 = ((me.drakeet.multitype.b) this).a.a.iterator();
    L15:
        if (r11.hasNext() == false) goto L19;
        Object r6 = r11.next();
        if ((!(r6 instanceof MultiLinkNormalEmptyViewBinder.a)) == false) goto L15;
    L20:
        if (r6 != null) goto L28;
        System.currentTimeMillis();
        r9.getLayoutPosition();
        ((me.drakeet.multitype.b) this).a.getItemCount();
        int r12 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r13 = this.e.getDataCenter();
        IRoom r14 = this.e.getRoom();
        if (r14 == null) goto L24;
        r3 = r14.getId();
    L24:
        MultiSceneEnterRoomStatisticsUtils r7 = MultiSceneEnterRoomStatisticsUtils.a.a(r13, Long.valueOf(r3));
        if (r7 == null) goto L27;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r7, "empty_seat_render", 0, 2, null);
    L27:
        this.b = true;
        return;
    L28:
        System.currentTimeMillis();
        r9.getLayoutPosition();
        ((me.drakeet.multitype.b) this).a.getItemCount();
        int r15 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r16 = this.e.getDataCenter();
        IRoom r17 = this.e.getRoom();
        if (r17 == null) goto L31;
        r3 = r17.getId();
    L31:
        MultiSceneEnterRoomStatisticsUtils r8 = MultiSceneEnterRoomStatisticsUtils.a.a(r16, Long.valueOf(r3));
        if (r8 == null) goto L34;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r8, "guest_seat_render", 0, 2, null);
    L34:
        this.c = true;
        return;
    L19:
        r6 = null;
        goto L20
    L40:
        return;
    L7:
        r4 = 0;
        goto L8
    }

    public MultiLinkDynamicIslandViewBinder(LiveTypeForMultiLink r2, DataCenter r3, xg0.b r4) {
        Intrinsics.checkNotNullParameter(r2, "liveTypeForMultiLink");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        this.d = r3;
        this.e = r4;
    }

    public final void c(RecyclerView.ViewHolder r8, Object r9, List r10) {
        ItemViewHolder r11 = (ItemViewHolder) r8;
        tf0.e r12 = (tf0.e) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(r12, "item");
        Intrinsics.checkNotNullParameter(r10, "payloads");
        if (r10.size() != 0) goto L5;
        h(r11, r12);
        return;
    L5:
        Iterator r13 = r10.iterator();
    L6:
        Object r1 = null;
        if (r13.hasNext() == false) goto L24;
        Object r0 = r13.next();
        if ((r0 instanceof Bundle) == false) goto L12;
        r1 = r0;
    L12:
        Bundle r2 = (Bundle) r1;
        if (r2 == null) goto L6;
        if (r2.size() == 0) goto L22;
        if (r2.containsKey("payload_key_is_not_same_class") == true) goto L22;
        if (r2.containsKey("payload_key_update_for_show_from") == true) goto L22;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "itemData");
        Intrinsics.checkNotNullParameter(r2, "payload");
        r11.a.w(r12, r12.a, r2);
    L22:
        h(r11, r12);
        goto L6
    L24:
        if (this.c == true) goto L63;
        int r14 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r15 = this.e.getDataCenter();
        IRoom r3 = this.e.getRoom();
        long r4 = 0;
        if (r3 == null) goto L28;
        long r5 = r3.getId();
    L29:
        MultiSceneEnterRoomStatisticsUtils r16 = MultiSceneEnterRoomStatisticsUtils.a.a(r15, Long.valueOf(r5));
        if (r16 == null) goto L32;
        r16.c();
    L32:
        System.currentTimeMillis();
        r11.getLayoutPosition();
        ((me.drakeet.multitype.b) this).a.getItemCount();
        Objects.toString(r12);
        if (r11.getLayoutPosition() != (((me.drakeet.multitype.b) this).a.getItemCount() - 1)) goto L64;
        Iterator r17 = ((me.drakeet.multitype.b) this).a.a.iterator();
    L36:
        if (r17.hasNext() == false) goto L40;
        Object r18 = r17.next();
        if ((!(r18 instanceof MultiLinkNormalEmptyViewBinder.a)) == false) goto L36;
        r1 = r18;
    L40:
        if (r1 == null) goto L65;
        System.currentTimeMillis();
        r11.getLayoutPosition();
        ((me.drakeet.multitype.b) this).a.getItemCount();
        int r19 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r20 = this.e.getDataCenter();
        IRoom r21 = this.e.getRoom();
        if (r21 == null) goto L44;
        r4 = r21.getId();
    L44:
        MultiSceneEnterRoomStatisticsUtils r6 = MultiSceneEnterRoomStatisticsUtils.a.a(r20, Long.valueOf(r4));
        if (r6 == null) goto L47;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r6, "guest_seat_render", 0, 2, null);
    L47:
        this.c = true;
        return;
    L65:
        return;
    L64:
        return;
    L28:
        r5 = 0;
        goto L29
    }
}
