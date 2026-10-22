package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import jg0.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends MultiLinkNormalEmptyViewBinder {
    public final xg0.a e;

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
            return "AudioHamletFirstEmptyItemData(position=" + this.u + ", positionNameItem=" + this.v + ", friendOnlineInviteeInfo=" + this.w + ", isPaidLinkOn=" + this.x + ", isGuestBattleShowing=" + this.y + ", isSelfInteracting=" + this.z + ", isInviteGuideOn=" + this.A + ", isFromFeed=" + this.B + ", isThemedCompetitionOn=" + this.C + ")";
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

        public a(int r13, LinkmicPositionItem r14, ch0.b r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21) {
            super(r13, r14, r15, r16, r17, r18, r19, r20, r21, 512);
            this.u = r13;
            this.v = r14;
            this.w = r15;
            this.x = r16;
            this.y = r17;
            this.z = r18;
            this.A = r19;
            this.B = r20;
            this.C = r21;
        }
    }

    public c(LiveTypeForMultiLink r2, xg0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "liveTypeForMultiLink");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r2, r3);
        this.e = r3;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder d(LayoutInflater r1, ViewGroup r2) {
        return i(r1, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder
    public final MultiLinkNormalEmptyViewBinder.ItemViewHolder i(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        this.e.getLinkWindowLayoutConfig();
        se0.c r0 = this.e.getAudioFeedLayerUIConfig();
        int r1 = hg0.c.a;
        MicSeatScene r2 = MicSeatScene.AUDIO_LINK_HAMLET_AVATAR_C_POSITION;
        xg0.a r3 = this.e;
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.empty.d r6 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.empty.d(r2, r3);
        r6.d = r0;
        g r7 = new g(r5);
        r7.b(r6);
        r7.a(r5.getContext());
        return new MultiLinkNormalEmptyViewBinder.ItemViewHolder(r7);
    }
}
