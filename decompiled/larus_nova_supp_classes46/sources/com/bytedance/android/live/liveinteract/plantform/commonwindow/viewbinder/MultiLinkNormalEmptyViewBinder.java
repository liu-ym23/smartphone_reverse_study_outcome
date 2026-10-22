package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tf0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class MultiLinkNormalEmptyViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {
    public boolean b;
    public final LiveTypeForMultiLink c;
    public final xg0.a d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkNormalEmptyViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhg0/b;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkNormalEmptyViewBinder$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
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
        public final int k;
        public LinkmicPositionItem l;
        public ch0.b m;
        public final boolean n;
        public final boolean o;
        public boolean p;
        public boolean q;
        public final boolean r;
        public final boolean s;
        public final int t;

        public void k() {
            this.q = true;
        }

        public ch0.b a() {
            return this.m;
        }

        public int b() {
            return this.k;
        }

        public LinkmicPositionItem c() {
            return this.l;
        }

        public boolean d() {
            return this.r;
        }

        public boolean e() {
            return this.o;
        }

        public boolean f() {
            return this.q;
        }

        public boolean g() {
            return this.n;
        }

        public boolean h() {
            return this.p;
        }

        public boolean i() {
            return this.s;
        }

        public void j(ch0.b r1) {
            this.m = r1;
        }

        public void l(LinkmicPositionItem r1) {
            this.l = r1;
        }

        public void m(boolean r1) {
            this.p = r1;
        }

        public a(int r3, LinkmicPositionItem r4, ch0.b r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, int r12) {
            if ((r12 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r12 & 4) == 0) goto L8;
            r5 = null;
        L8:
            int r1 = 0;
            if ((r12 & 8) == 0) goto L12;
            r6 = false;
        L12:
            if ((r12 & 16) == 0) goto L15;
            r7 = false;
        L15:
            if ((r12 & 32) == 0) goto L18;
            r8 = false;
        L18:
            if ((r12 & 64) == 0) goto L21;
            r9 = false;
        L21:
            if ((r12 & 128) == 0) goto L24;
            r10 = false;
        L24:
            if ((r12 & 256) == 0) goto L27;
            r11 = false;
        L27:
            if ((r12 & 512) == 0) goto L29;
            r1 = -1;
        L29:
            this.k = r3;
            this.l = r4;
            this.m = r5;
            this.n = r6;
            this.o = r7;
            this.p = r8;
            this.q = r9;
            this.r = r10;
            this.s = r11;
            this.t = r1;
        }
    }

    public interface b {
        void E5(ch0.b r1);

        void K3(a r1, boolean r2);

        void d2(a r1);
    }

    public MultiLinkNormalEmptyViewBinder(LiveTypeForMultiLink r2, xg0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "liveTypeForMultiLink");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        this.c = r2;
        this.d = r3;
    }

    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h((ItemViewHolder) r1, (a) r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder d(LayoutInflater r1, ViewGroup r2) {
        return i(r1, r2);
    }

    public final void h(ItemViewHolder r10, a r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        Intrinsics.checkNotNullParameter(r11, "item");
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "itemData");
        r10.a.v(r11, r11.a);
        m r1 = null;
        if (this.b == true) goto L28;
        int r0 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r2 = this.d.getDataCenter();
        IRoom r3 = this.d.getRoom();
        long r4 = 0;
        if (r3 == null) goto L7;
        long r6 = r3.getId();
    L8:
        MultiSceneEnterRoomStatisticsUtils r5 = MultiSceneEnterRoomStatisticsUtils.a.a(r2, Long.valueOf(r6));
        if (r5 == null) goto L11;
        r5.c();
    L11:
        System.currentTimeMillis();
        r10.getLayoutPosition();
        ((me.drakeet.multitype.b) this).a.getItemCount();
        r11.toString();
        if (r10.getLayoutPosition() != (((me.drakeet.multitype.b) this).a.getItemCount() - 1)) goto L28;
        Iterator r12 = ((me.drakeet.multitype.b) this).a.a.iterator();
    L15:
        if (r12.hasNext() == false) goto L19;
        Object r7 = r12.next();
        if ((!(r7 instanceof a)) == false) goto L15;
    L20:
        if (r7 != null) goto L28;
        System.currentTimeMillis();
        r10.getLayoutPosition();
        ((me.drakeet.multitype.b) this).a.getItemCount();
        int r13 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r14 = this.d.getDataCenter();
        IRoom r8 = this.d.getRoom();
        if (r8 == null) goto L24;
        r4 = r8.getId();
    L24:
        MultiSceneEnterRoomStatisticsUtils r9 = MultiSceneEnterRoomStatisticsUtils.a.a(r14, Long.valueOf(r4));
        if (r9 == null) goto L27;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r9, "empty_seat_render", 0, 2, null);
    L27:
        this.b = true;
        goto L28
    L19:
        r7 = null;
        goto L20
    L7:
        r6 = 0;
    L28:
        m r15 = b0.b();
        if ((r15 instanceof u) == false) goto L32;
        r1 = r15;
    L32:
        u r16 = (u) r1;
        if (r16 == null) goto L35;
        boolean r17 = r16.a;
    L36:
        if (r17 == false) goto L38;
        return;
    L38:
        if (r10.getLayoutPosition() != (((me.drakeet.multitype.b) this).a.getItemCount() - 1)) goto L46;
        if (r16 == null) goto L47;
        r16.b(System.currentTimeMillis());
        return;
    L47:
        return;
    L46:
        return;
    L35:
        r17 = true;
        goto L36
    }

    public ItemViewHolder i(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r6 = this.d.getLinkWindowLayoutConfig();
        if (this.c != LiveTypeForMultiLink.Video) goto L5;
        int r0 = hg0.c.a;
        g r7 = hg0.c.f(r5, MicSeatScene.VIDEO_LINK_EQUAL, r6, this.d);
    L21:
        int r8 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r9 = this.d.getDataCenter();
        IRoom r1 = this.d.getRoom();
        if (r1 == null) goto L24;
        long r2 = r1.getId();
    L25:
        MultiSceneEnterRoomStatisticsUtils r10 = MultiSceneEnterRoomStatisticsUtils.a.a(r9, Long.valueOf(r2));
        if (r10 == null) goto L28;
        r10.c();
    L28:
        System.currentTimeMillis();
        return new ItemViewHolder(r7);
    L24:
        r2 = 0;
        goto L25
    L5:
        se0.c r3 = this.d.getAudioFeedLayerUIConfig();
        if (aj0.b.c(r6.getUiLayout()) == false) goto L9;
        int r11 = hg0.c.a;
        r7 = hg0.c.f(r5, MicSeatScene.VIDEO_LINK_EQUAL, r6, this.d);
        goto L21
    L9:
        if (r6.getUiLayout() != 21) goto L12;
        int r12 = hg0.c.a;
        r7 = hg0.c.b(r5, MicSeatScene.AUDIO_LINK, r3, r6, this.d);
        goto L21
    L12:
        if (r6.getUiLayout() != 22) goto L15;
        int r13 = hg0.c.a;
        r7 = hg0.c.b(r5, MicSeatScene.AUDIO_LINK_LARGE, r3, r6, this.d);
        goto L21
    L15:
        if (r6.getUiLayout() != 28) goto L18;
        int r14 = hg0.c.a;
        r7 = hg0.c.b(r5, MicSeatScene.AUDIO_LINK_HAMLET_AVATAR, r3, r6, this.d);
        goto L21
    L18:
        if (r6.getUiLayout() != 30) goto L20;
        int r15 = hg0.c.a;
        r7 = hg0.c.b(r5, MicSeatScene.AUDIO_LINK_STAGE_ENLARGE, r3, r6, this.d);
        goto L21
    L20:
        int r16 = hg0.c.a;
        r7 = hg0.c.b(r5, MicSeatScene.AUDIO_LINK, r3, r6, this.d);
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
        if (r9.hasNext() == false) goto L30;
        Object r0 = r9.next();
        if ((r0 instanceof Bundle) == true) goto L11;
        r0 = null;
    L11:
        Bundle r1 = (Bundle) r0;
        if (r1 == null) goto L7;
        if (r1.size() == 0) goto L19;
        if (r1.containsKey("payload_key_update_for_show_from") == true) goto L19;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "itemData");
        Intrinsics.checkNotNullParameter(r1, "payload");
        r7.a.w(r8, r8.a, r1);
    L19:
        h(r7, r8);
        goto L7
    }
}
