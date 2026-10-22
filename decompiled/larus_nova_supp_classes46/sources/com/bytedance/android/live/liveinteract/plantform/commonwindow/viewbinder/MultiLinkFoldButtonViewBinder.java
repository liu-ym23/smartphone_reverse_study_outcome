package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkFoldButtonViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {
    public final xg0.a b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkFoldButtonViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhg0/b;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkFoldButtonViewBinder$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
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
        }
    }

    public static final class a extends tf0.e {
        public final boolean k;
        public final boolean l;
        public final int m;
        public final boolean n;
        public final boolean o;
        public final MultiLinkNormalEmptyViewBinder.a p;
        public final MultiLinkFirstUserViewBinder.a q;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L20;
            a r4 = (a) r3;
            if (this.k == r4.k) goto L8;
            return false;
        L8:
            if (this.l == r4.l) goto L10;
            return false;
        L10:
            if (this.m == r4.m) goto L12;
            return false;
        L12:
            if (this.n == r4.n) goto L14;
            return false;
        L14:
            if (this.o == r4.o) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.p, r4.p) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.q, r4.q) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9 */
        public final int hashCode() {
            boolean r0 = this.k;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.l;
            ?? r5 = r4;
            if (r4 == false) goto L8;
            r5 = 1;
        L8:
            int r6 = (((r3 + r5) * 31) + this.m) * 31;
            boolean r7 = this.n;
            ?? r8 = r7;
            if (r7 == false) goto L11;
            r8 = 1;
        L11:
            int r9 = (r6 + r8) * 31;
            boolean r10 = this.o;
            if (r10 == true) goto L15;
            r1 = r10;
        L15:
            int r11 = (r9 + r1) * 31;
            MultiLinkNormalEmptyViewBinder.a r12 = this.p;
            int r13 = 0;
            if (r12 == null) goto L18;
            int r14 = r12.hashCode();
        L19:
            int r15 = (r11 + r14) * 31;
            MultiLinkFirstUserViewBinder.a r16 = this.q;
            if (r16 == null) goto L23;
            r13 = r16.hashCode();
        L23:
            return r15 + r13;
        L18:
            r14 = 0;
            goto L19
        }

        public final String toString() {
            return "FoldButtonData(clickable=" + this.k + ", isMicSeatFold=" + this.l + ", guestCount=" + this.m + ", seatFoldShow=" + this.n + ", lastEmptyShow=" + this.o + ", emptyItemData=" + this.p + ", firstItemData=" + this.q + ")";
        }

        public a(boolean r1, boolean r2, int r3, boolean r4, boolean r5, MultiLinkNormalEmptyViewBinder.a r6, MultiLinkFirstUserViewBinder.a r7) {
            this.k = r1;
            this.l = r2;
            this.m = r3;
            this.n = r4;
            this.o = r5;
            this.p = r6;
            this.q = r7;
        }
    }

    public interface b {
        void w0(boolean r1);
    }

    public MultiLinkFoldButtonViewBinder(xg0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "linkSeatAbilityProvider");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        ItemViewHolder r4 = (ItemViewHolder) r2;
        a r5 = (a) r3;
        Intrinsics.checkNotNullParameter(r4, "itemViewHolder");
        Intrinsics.checkNotNullParameter(r5, "data");
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.a.v(r5, r5.a);
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
        com.bytedance.android.live.liveinteract.revenue.game.layer.a r5 = new com.bytedance.android.live.liveinteract.revenue.game.layer.a(r1, r2);
        g r6 = new g(r4);
        r6.b(r5);
        r6.a(r4.getContext());
        return new ItemViewHolder(r6);
    }
}
