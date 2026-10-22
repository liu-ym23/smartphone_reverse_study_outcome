package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelItemBaseVH;", "DiffUtilCallback", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatRoomPanelItemAdapter extends RecyclerView.Adapter<ChatRoomPanelItemBaseVH> {
    public final int a;
    public final List<g> b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelItemAdapter$DiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class DiffUtilCallback extends DiffUtil.Callback {
        public final List<g> a;
        public final List<g> b;

        public final int getNewListSize() {
            return this.a.size();
        }

        public final int getOldListSize() {
            return this.b.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DiffUtilCallback(List<? extends g> r2, List<? extends g> r3) {
            Intrinsics.checkNotNullParameter(r2, "newList");
            Intrinsics.checkNotNullParameter(r3, "oldList");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r3, int r4) {
            g r5 = (g) ListProtector.get(this.b, r3);
            g r6 = (g) ListProtector.get(this.a, r4);
            if (r5.i() == r6.i()) goto L5;
        L9:
            return false;
        L5:
            if (TextUtils.equals(r5.f(), r6.f()) == false) goto L9;
            if (TextUtils.equals(r5.j(), r6.j()) == false) goto L9;
            return true;
        }

        public final boolean areItemsTheSame(int r2, int r3) {
            if (r2 == r3) goto L4;
        L6:
            return false;
        L4:
            if (Intrinsics.areEqual((g) ListProtector.get(this.a, r3), (g) ListProtector.get(this.b, r2)) == false) goto L6;
            return true;
        }
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public ChatRoomPanelItemAdapter(List<g> r2) {
        Intrinsics.checkNotNullParameter(r2, "panelItemList");
        this.b = r2;
        this.a = s1.f(10.0f);
    }

    public final int getItemViewType(int r2) {
        return ((g) ListProtector.get(this.b, r2)).b();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        ChatRoomPanelItemBaseVH r3 = (ChatRoomPanelItemBaseVH) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled(r3);
        r3.U3(r3);
    }

    public final void y2(List<? extends g> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.b.clear();
        this.b.addAll(r2);
        notifyDataSetChanged();
    }

    public final void z2(List<g> r3) {
        Intrinsics.checkNotNullParameter(r3, "newList");
        DiffUtil.DiffResult r0 = DiffUtil.calculateDiff(new DiffUtilCallback(r3, this.b));
        this.b.clear();
        this.b.addAll(r3);
        r0.dispatchUpdatesTo(this);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        ChatRoomPanelItemBaseVH r5 = (ChatRoomPanelItemBaseVH) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        r5.T3((g) ListProtector.get(this.b, r4));
        View r6 = ((RecyclerView.ViewHolder) r5).itemView;
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L13;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        r1.leftMargin = 0;
        r1.rightMargin = 0;
        if (r4 != 0) goto L8;
        r1.leftMargin = this.a;
    L10:
        r6.setLayoutParams(r1);
        return;
    L8:
        if (r4 != (this.b.size() - 1)) goto L10;
        r1.rightMargin = this.a;
        goto L10
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        boolean r0 = false;
        if (r7 == 1) goto L15;
        if (r7 == 2) goto L17;
        View r8 = LayoutInflater.from(r6.getContext()).inflate(2131566278, r6, false);
        int r9 = s1.y();
        int r2 = s1.f(40.0f);
        int r3 = s1.f(68.0f);
        if (((this.b.size() * r3) + this.a) <= (r9 + r2)) goto L10;
        r0 = true;
    L10:
        if (r0 == false) goto L16;
        double r1 = ((double) (s1.y() - this.a)) / 5.33d;
        int r4 = (int) r1;
        r8.getLayoutParams().width = r4;
    L16:
        return new ChatRoomPanelItemNormalVH(r8);
    L17:
        return new ChatRoomPanelLynxItemVH(LayoutInflater.from(r6.getContext()).inflate(2131566277, r6, false));
    L15:
        return new ChatRoomPanelDigitShowModeItemVH(LayoutInflater.from(r6.getContext()).inflate(2131566276, r6, false));
    }
}
