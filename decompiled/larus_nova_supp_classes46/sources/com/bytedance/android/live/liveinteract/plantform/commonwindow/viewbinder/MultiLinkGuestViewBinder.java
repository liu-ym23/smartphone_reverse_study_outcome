package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkGuestViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {
    public boolean b;
    public final LiveTypeForMultiLink c;
    public final xg0.a d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkGuestViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhg0/b;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkGuestViewBinder$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder implements hg0.b<a> {
        public final g<a> a;

        @Override // hg0.b
        public final g<a> l() {
            return this.a;
        }

        public ItemViewHolder(g<a> r2) {
            Intrinsics.checkNotNullParameter(r2, "layer");
            super(r2.l());
            this.a = r2;
            r2.j(r2.c.getContext());
        }
    }

    public static class a extends tf0.e {
        public ch0.e k;
        public LinkmicPositionItem l;
        public pf0.a m;
        public wg0.a n;
        public List<Integer> o;
        public ch0.c p;

        public final a a() {
            a r7 = new a(this.k, this.l, this.m, this.n, this.o, this.p);
            r7.a = this.a;
            r7.b = this.b;
            r7.c = this.c;
            r7.d = this.d;
            r7.e = this.e;
            r7.f = this.f;
            List<Integer> r0 = this.g;
            Intrinsics.checkNotNullParameter(r0, "<set-?>");
            r7.g = r0;
            r7.h = this.h;
            HashMap<String, tf0.d> r1 = this.i;
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r7.i = r1;
            r7.j = this.j;
            return r7;
        }

        public String toString() {
            return this.k.a.toString();
        }

        public /* synthetic */ a(ch0.e r8, LinkmicPositionItem r9, int r10) {
            if ((r10 & 2) == 0) goto L5;
            r9 = null;
        L5:
            this(r8, r9, null, null, null, null);
        }

        public a(ch0.e r2, LinkmicPositionItem r3, pf0.a r4, wg0.a r5, List<Integer> r6, ch0.c r7) {
            Intrinsics.checkNotNullParameter(r2, "mergeData");
            this.k = r2;
            this.l = r3;
            this.m = r4;
            this.n = r5;
            this.o = r6;
            this.p = r7;
        }
    }

    public interface b {
        void N0(w8 r1);

        void e4(a r1);

        int getCurrentWindowCount();

        void m3(a r1, boolean r2);

        void w1(a r1);
    }

    public final long a(Object r3) {
        a r4 = (a) r3;
        Intrinsics.checkNotNullParameter(r4, "item");
        return r4.a;
    }

    public final void f(RecyclerView.ViewHolder r2) {
        ItemViewHolder r3 = (ItemViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.a.onDetach();
    }

    public MultiLinkGuestViewBinder(LiveTypeForMultiLink r2, xg0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "liveTypeForMultiLink");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        this.c = r2;
        this.d = r3;
    }

    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h((ItemViewHolder) r1, (a) r2);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r6, ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        Intrinsics.checkNotNullParameter(r7, "parent");
        m r0 = this.d.getLinkWindowLayoutConfig();
        r0.getClass();
        int r1 = r0.getUiLayout();
        m r2 = this.d.getLinkWindowLayoutConfig();
        if (this.c != LiveTypeForMultiLink.Audio) goto L24;
        se0.c r8 = this.d.getAudioFeedLayerUIConfig();
        if (r1 != 21) goto L7;
        int r3 = hg0.c.a;
        g r9 = hg0.c.c(r7, MicSeatScene.AUDIO_LINK, r2, r8, this.d);
    L41:
        int r10 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r11 = this.d.getDataCenter();
        IRoom r4 = this.d.getRoom();
        if (r4 == null) goto L44;
        long r5 = r4.getId();
    L45:
        MultiSceneEnterRoomStatisticsUtils r12 = MultiSceneEnterRoomStatisticsUtils.a.a(r11, Long.valueOf(r5));
        if (r12 == null) goto L48;
        r12.c();
    L48:
        System.currentTimeMillis();
        return new ItemViewHolder(r9);
    L44:
        r5 = 0;
        goto L45
    L7:
        if (r1 != 22) goto L9;
        int r13 = hg0.c.a;
        r9 = hg0.c.c(r7, MicSeatScene.AUDIO_LINK_LARGE, r2, r8, this.d);
        goto L41
    L9:
        if (r1 != 24) goto L11;
        int r14 = hg0.c.a;
        r9 = hg0.c.c(r7, MicSeatScene.AUDIO_LINK_DYNAMIC_ISLAND, r2, r8, this.d);
        goto L41
    L11:
        if (r1 != 28) goto L13;
        int r15 = hg0.c.a;
        r9 = hg0.c.c(r7, MicSeatScene.AUDIO_LINK_HAMLET_AVATAR, r2, r8, this.d);
        goto L41
    L13:
        if (r1 != 30) goto L15;
        int r16 = hg0.c.a;
        r9 = hg0.c.c(r7, MicSeatScene.AUDIO_LINK_STAGE_ENLARGE, r2, r8, this.d);
        goto L41
    L15:
        if (aj0.b.c(r1) == false) goto L17;
        int r17 = hg0.c.a;
        r9 = hg0.c.g(r7, MicSeatScene.VIDEO_LINK_EQUAL, this.d);
        goto L41
    L17:
        int r18 = hg0.c.a;
        r9 = hg0.c.c(r7, MicSeatScene.AUDIO_LINK, r2, r8, this.d);
        goto L41
    L24:
        if (r1 != 4) goto L26;
        int r19 = hg0.c.a;
        r9 = hg0.c.g(r7, MicSeatScene.VIDEO_LINK_EQUAL, this.d);
        goto L41
    L26:
        if (r1 == 15) goto L39;
        if (r1 != 21) goto L29;
    L38:
        int r20 = hg0.c.a;
        MicSeatScene r21 = MicSeatScene.VIDEO_LINK_EQUAL;
        xg0.a r22 = this.d;
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r21, "scene");
        Intrinsics.checkNotNullParameter(r22, "linkSeatAbilityProvider");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.a r23 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.a(r21, r22);
        pg0.a r24 = new pg0.a(r21, r23, r22);
        g r25 = new g(r7);
        r25.b(r23);
        r25.b(new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.theme.b(r23, r21, r22));
        r25.b(r24);
        boolean r26 = tb1.d.a;
        r25.b(new og0.a(r23, r22));
        r25.b(new lg0.a(r21, r24, r23, r22));
        r25.a(r7.getContext());
        r9 = r25;
        goto L41
    L29:
        if (r1 == 109) goto L38;
        if (r1 == 111) goto L38;
        if (r1 == 112) goto L38;
        if (aj0.b.c(r1) == false) goto L37;
        int r27 = hg0.c.a;
        r9 = hg0.c.g(r7, MicSeatScene.VIDEO_LINK_EQUAL, this.d);
        goto L41
    L37:
        int r28 = hg0.c.a;
        r9 = hg0.c.g(r7, MicSeatScene.VIDEO_LINK_EQUAL, this.d);
        goto L41
    L39:
        int r29 = hg0.c.a;
        MicSeatScene r30 = MicSeatScene.VIDEO_LINK_EQUAL;
        xg0.a r31 = this.d;
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r30, "scene");
        Intrinsics.checkNotNullParameter(r31, "linkSeatAbilityProvider");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.a r32 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.a(r30, r31);
        g r33 = new g(r7);
        r33.b(r32);
        r33.b(new com.bytedance.android.live.liveinteract.revenue.game.layer.c(r30, r32, r31));
        r33.a(r7.getContext());
        r9 = r33;
        goto L41
    }

    public final void h(ItemViewHolder r9, a r10) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        Intrinsics.checkNotNullParameter(r10, "item");
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "itemData");
        r9.a.v(r10, r10.a);
        g<a> r0 = r9.a;
        int r2 = 0;
        if (r10.j == false) goto L5;
        int r1 = 0;
    L6:
        r0.x(r1);
        if (this.b == true) goto L35;
        int r3 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r4 = this.d.getDataCenter();
        IRoom r5 = this.d.getRoom();
        long r6 = 0;
        if (r5 == null) goto L11;
        long r7 = r5.getId();
    L12:
        MultiSceneEnterRoomStatisticsUtils r8 = MultiSceneEnterRoomStatisticsUtils.a.a(r4, Long.valueOf(r7));
        if (r8 == null) goto L15;
        r8.c();
    L15:
        System.currentTimeMillis();
        r9.getLayoutPosition();
        ((me.drakeet.multitype.b) this).a.getItemCount();
        r10.toString();
        Iterator r11 = CollectionsKt.reversed(((me.drakeet.multitype.b) this).a.a).iterator();
    L16:
        int r12 = -1;
        if (r11.hasNext() == false) goto L22;
        if ((!(r11.next() instanceof MultiLinkNormalEmptyViewBinder.a)) == true) goto L23;
        r2 = r2 + 1;
    L23:
        if (r2 < 0) goto L25;
        r12 = (((me.drakeet.multitype.b) this).a.getItemCount() - 1) - r2;
    L25:
        if (r12 < 0) goto L35;
        if (r9.getLayoutPosition() != r12) goto L35;
        System.currentTimeMillis();
        r9.getLayoutPosition();
        ((me.drakeet.multitype.b) this).a.getItemCount();
        int r13 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r14 = this.d.getDataCenter();
        IRoom r15 = this.d.getRoom();
        if (r15 == null) goto L31;
        r6 = r15.getId();
    L31:
        MultiSceneEnterRoomStatisticsUtils r16 = MultiSceneEnterRoomStatisticsUtils.a.a(r14, Long.valueOf(r6));
        if (r16 == null) goto L34;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r16, "guest_seat_render", 0, 2, null);
    L34:
        this.b = true;
        goto L35
    L22:
        r2 = -1;
        goto L23
    L11:
        r7 = 0;
    L35:
        tf0.m r17 = b0.b();
        if ((r17 instanceof u) == true) goto L38;
        r17 = null;
    L38:
        u r18 = (u) r17;
        if (r18 == null) goto L41;
        boolean r19 = r18.a;
    L42:
        if (r19 == false) goto L44;
        return;
    L44:
        if (r9.getLayoutPosition() != (((me.drakeet.multitype.b) this).a.getItemCount() - 1)) goto L51;
        if (r18 == null) goto L52;
        r18.b(System.currentTimeMillis());
        return;
    L52:
        return;
    L51:
        return;
    L41:
        r19 = true;
        goto L42
    L5:
        r1 = 4;
        goto L6
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
        g<a> r2 = r7.a;
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
}
