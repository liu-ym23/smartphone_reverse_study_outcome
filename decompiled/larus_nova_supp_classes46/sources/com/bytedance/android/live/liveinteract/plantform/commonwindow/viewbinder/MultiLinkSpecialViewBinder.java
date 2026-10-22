package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkSpecialViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {
    public final LiveTypeForMultiLink b;
    public final xg0.a c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkSpecialViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public final g<a> a;

        public ItemViewHolder(g<a> r2) {
            Intrinsics.checkNotNullParameter(r2, "layer");
            super(r2.l());
            this.a = r2;
        }
    }

    public static final class a extends tf0.e {
        public final int k;
        public final int l;
        public final LinkmicPositionItem m;
        public final boolean n;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L14;
            a r4 = (a) r3;
            if (this.k == r4.k) goto L8;
            return false;
        L8:
            if (this.l == r4.l) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.m, r4.m) == true) goto L12;
            return false;
        L12:
            if (this.n == r4.n) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v8 */
        public final int hashCode() {
            int r0 = ((this.k * 31) + this.l) * 31;
            LinkmicPositionItem r1 = this.m;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L6:
            int r3 = (r0 + r2) * 31;
            boolean r4 = this.n;
            ?? r5 = r4;
            if (r4 == false) goto L10;
            r5 = 1;
        L10:
            return r3 + r5;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "SpecialItemData(position=" + this.k + ", lockStatus=" + this.l + ", positionNameItem=" + this.m + ", isSelfInteracting=" + this.n + ")";
        }

        public a(int r1, int r2, LinkmicPositionItem r3, boolean r4) {
            this.k = r1;
            this.l = r2;
            this.m = r3;
            this.n = r4;
        }
    }

    public interface b {
        void Q3(a r1);
    }

    public MultiLinkSpecialViewBinder(LiveTypeForMultiLink r2, xg0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "liveTypeForMultiLink");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        ItemViewHolder r4 = (ItemViewHolder) r2;
        a r5 = (a) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.a.v(r5, r5.a);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        m r5 = this.c.getLinkWindowLayoutConfig();
        if (this.b != LiveTypeForMultiLink.Video) goto L5;
        int r6 = hg0.c.a;
        g r7 = hg0.c.h(r4, MicSeatScene.VIDEO_LINK_EQUAL, this.c);
    L19:
        return new ItemViewHolder(r7);
    L5:
        int r0 = r5.getUiLayout();
        if (r0 != 21) goto L8;
        int r1 = hg0.c.a;
        r7 = hg0.c.d(r4, MicSeatScene.AUDIO_LINK, r5, this.c);
        goto L19
    L8:
        if (r0 != 22) goto L10;
        int r2 = hg0.c.a;
        r7 = hg0.c.d(r4, MicSeatScene.AUDIO_LINK_LARGE, r5, this.c);
        goto L19
    L10:
        if (r0 != 30) goto L12;
        int r8 = hg0.c.a;
        r7 = hg0.c.d(r4, MicSeatScene.AUDIO_LINK_STAGE_ENLARGE, r5, this.c);
        goto L19
    L12:
        if (aj0.b.c(r5.getUiLayout()) == false) goto L14;
        int r9 = hg0.c.a;
        r7 = hg0.c.h(r4, MicSeatScene.VIDEO_LINK_EQUAL, this.c);
        goto L19
    L14:
        int r10 = hg0.c.a;
        r7 = hg0.c.d(r4, MicSeatScene.AUDIO_LINK, r5, this.c);
        goto L19
    }

    public final void c(RecyclerView.ViewHolder r4, Object r5, List r6) {
        ItemViewHolder r7 = (ItemViewHolder) r4;
        a r8 = (a) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "item");
        r7.a.v(r8, r8.a);
    }
}
