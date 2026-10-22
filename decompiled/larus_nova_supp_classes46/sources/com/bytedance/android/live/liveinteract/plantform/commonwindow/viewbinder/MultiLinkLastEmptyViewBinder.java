package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.MultiLinkDynamicFloatEmptyMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.MultiLinkDynamicFloatEmptyMicSeatBasicLayerOld;
import java.util.Iterator;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkLastEmptyViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {
    public final xg0.a b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkLastEmptyViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public final g<MultiLinkNormalEmptyViewBinder.a> a;

        public ItemViewHolder(g<MultiLinkNormalEmptyViewBinder.a> r2) {
            Intrinsics.checkNotNullParameter(r2, "layer");
            super(r2.l());
            this.a = r2;
            r2.j(r2.c.getContext());
        }
    }

    public static final class a extends MultiLinkNormalEmptyViewBinder.a {
        public boolean A;
        public final boolean B;
        public final boolean C;
        public final int u;
        public LinkmicPositionItem v;
        public ch0.b w;
        public final boolean x;
        public final boolean y;
        public boolean z;

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.a
        public final void k() {
            this.A = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11, types: [int] */
        /* JADX WARN: Type inference failed for: r1v13, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        public final int hashCode() {
            int r0 = this.u * 31;
            LinkmicPositionItem r1 = this.v;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            ch0.b r5 = this.w;
            if (r5 == null) goto L9;
            r2 = r5.hashCode();
        L9:
            int r6 = (r4 + r2) * 31;
            boolean r7 = this.x;
            ?? r8 = 1;
            ?? r9 = r7;
            if (r7 == false) goto L12;
            r9 = 1;
        L12:
            int r10 = (r6 + r9) * 31;
            boolean r11 = this.y;
            ?? r12 = r11;
            if (r11 == false) goto L15;
            r12 = 1;
        L15:
            int r13 = (r10 + r12) * 31;
            boolean r14 = this.z;
            ?? r15 = r14;
            if (r14 == false) goto L18;
            r15 = 1;
        L18:
            int r16 = (r13 + r15) * 31;
            boolean r17 = this.A;
            ?? r18 = r17;
            if (r17 == false) goto L21;
            r18 = 1;
        L21:
            int r19 = (r16 + r18) * 31;
            boolean r20 = this.B;
            ?? r21 = r20;
            if (r20 == false) goto L24;
            r21 = 1;
        L24:
            int r22 = (r19 + r21) * 31;
            boolean r23 = this.C;
            if (r23 == true) goto L29;
            r8 = r23;
        L29:
            return r22 + r8;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "LastEmptyItemData(position=" + this.u + ", positionNameItem=" + this.v + ", friendOnlineInviteeInfo=" + this.w + ", isPaidLinkOn=" + this.x + ", isGuestBattleShowing=" + this.y + ", isSelfInteracting=" + this.z + ", isInviteGuideOn=" + this.A + ", isFromFeed=" + this.B + ", isThemedCompetitionOn=" + this.C + ")";
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.a
        public final ch0.b a() {
            return this.w;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.a
        public final int b() {
            return this.u;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.a
        public final LinkmicPositionItem c() {
            return this.v;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.a
        public final boolean d() {
            return this.B;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.a
        public final boolean e() {
            return this.y;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.a
        public final boolean f() {
            return this.A;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.a
        public final boolean g() {
            return this.x;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.a
        public final boolean h() {
            return this.z;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.a
        public final boolean i() {
            return this.C;
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L24;
            a r4 = (a) r3;
            if (this.u == r4.u) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.v, r4.v) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.w, r4.w) == true) goto L12;
            return false;
        L12:
            if (this.x == r4.x) goto L14;
            return false;
        L14:
            if (this.y == r4.y) goto L16;
            return false;
        L16:
            if (this.z == r4.z) goto L18;
            return false;
        L18:
            if (this.A == r4.A) goto L20;
            return false;
        L20:
            if (this.B == r4.B) goto L22;
            return false;
        L22:
            if (this.C == r4.C) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.a
        public final void j(ch0.b r1) {
            this.w = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.a
        public final void l(LinkmicPositionItem r1) {
            this.v = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.a
        public final void m(boolean r1) {
            this.z = r1;
        }

        public a(int r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, int r25) {
            if ((r25 & 8) == 0) goto L5;
            boolean r14 = false;
        L7:
            if ((r25 & 16) == 0) goto L9;
            boolean r15 = false;
        L11:
            if ((r25 & 32) == 0) goto L13;
            boolean r10 = false;
        L15:
            if ((r25 & 128) == 0) goto L17;
            boolean r7 = false;
        L19:
            if ((r25 & 256) == 0) goto L21;
            boolean r8 = false;
        L22:
            boolean r26 = r7;
            boolean r27 = r8;
            super(r19, null, null, r14, r15, r10, false, r26, r27, 512);
            this.u = r19;
            this.v = null;
            this.w = null;
            this.x = r14;
            this.y = r15;
            this.z = r10;
            this.A = false;
            this.B = r26;
            this.C = r27;
            return;
        L21:
            r8 = r24;
            goto L22
        L17:
            r7 = r23;
            goto L19
        L13:
            r10 = r22;
            goto L15
        L9:
            r15 = r21;
            goto L11
        L5:
            r14 = r20;
            goto L7
        }
    }

    public MultiLinkLastEmptyViewBinder(xg0.b r2) {
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

    public final RecyclerView.ViewHolder d(LayoutInflater r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r6, "parent");
        int r0 = hg0.c.a;
        MicSeatScene r1 = MicSeatScene.VIDEO_LINK_EQUAL;
        int r2 = this.b.getLinkWindowLayoutConfig().getUiLayout();
        xg0.a r3 = this.b;
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        if (vm2.d.f0() != 0) goto L5;
    L8:
        jg0.f r7 = new MultiLinkDynamicFloatEmptyMicSeatBasicLayer(r1, r2, r3);
    L9:
        g r4 = new g(r6);
        r4.b(r7);
        r4.a(r6.getContext());
        return new ItemViewHolder(r4);
    L5:
        if (vm2.d.f0() == 2) goto L8;
        r7 = new MultiLinkDynamicFloatEmptyMicSeatBasicLayerOld(r1, r3);
        goto L9
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
