package com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import hg0.c;
import java.util.Iterator;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkPreOnlineViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {
    public final xg0.a b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/audio/viewbinder/MultiLinkPreOnlineViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhg0/b;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/audio/viewbinder/MultiLinkPreOnlineViewBinder$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
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

    public static final class a extends e {
        public final IBaseUser k;
        public final int l;
        public final int m;
        public final LinkmicPositionItem n;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L14;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.k, r4.k) == true) goto L8;
            return false;
        L8:
            if (this.l == r4.l) goto L10;
            return false;
        L10:
            if (this.m == r4.m) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.n, r4.n) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            IBaseUser r0 = this.k;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((((r2 * 31) + this.l) * 31) + this.m) * 31;
            LinkmicPositionItem r4 = this.n;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "PreOnlineItemData(user=" + this.k + ", selfLinkPlayerStatus=" + this.l + ", position=" + this.m + ", positionNameItem=" + this.n + ")";
        }

        public a(IBaseUser r2, int r3, int r4, LinkmicPositionItem r5) {
            Intrinsics.checkNotNullParameter(r2, "user");
            this.k = r2;
            this.l = r3;
            this.m = r4;
            this.n = r5;
        }
    }

    public interface b {
        void V3(a r1);
    }

    public MultiLinkPreOnlineViewBinder(xg0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "linkSeatAbilityProvider");
        this.b = r2;
    }

    public static void h(ItemViewHolder r1, a r2) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        Intrinsics.checkNotNullParameter(r2, "item");
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "itemData");
        r1.a.v(r2, r2.a);
    }

    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h((ItemViewHolder) r1, (a) r2);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        m r5 = this.b.getLinkWindowLayoutConfig();
        if (r5.getUiLayout() != 21) goto L6;
        int r6 = c.a;
        g r7 = c.e(r4, MicSeatScene.AUDIO_LINK, this.b);
    L13:
        return new ItemViewHolder(r7);
    L6:
        if (r5.getUiLayout() != 22) goto L9;
        int r8 = c.a;
        r7 = c.e(r4, MicSeatScene.AUDIO_LINK_LARGE, this.b);
        goto L13
    L9:
        if (r5.getUiLayout() != 30) goto L11;
        int r9 = c.a;
        r7 = c.e(r4, MicSeatScene.AUDIO_LINK_STAGE_ENLARGE, this.b);
        goto L13
    L11:
        int r10 = c.a;
        r7 = c.e(r4, MicSeatScene.AUDIO_LINK, this.b);
        goto L13
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
        if (r1.containsKey("payload_key_is_not_same_class") == true) goto L19;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "itemData");
        Intrinsics.checkNotNullParameter(r1, "payload");
        r7.a.w(r8, r8.a, r1);
    L19:
        h(r7, r8);
        goto L7
    }
}
