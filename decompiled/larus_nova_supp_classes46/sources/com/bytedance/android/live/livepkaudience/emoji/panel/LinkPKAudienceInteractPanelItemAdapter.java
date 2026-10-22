package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/panel/LinkPKAudienceInteractPanelItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/livepkaudience/emoji/panel/LinkPKAudienceInteractPanelItemBaseVH;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPKAudienceInteractPanelItemAdapter extends RecyclerView.Adapter<LinkPKAudienceInteractPanelItemBaseVH> {
    public final int a;
    public final List<g> b;

    public final int getItemCount() {
        return this.b.size();
    }

    public LinkPKAudienceInteractPanelItemAdapter(List<g> r2) {
        Intrinsics.checkNotNullParameter(r2, "panelItemList");
        this.b = r2;
        this.a = s1.f(10.0f);
    }

    public final int getItemViewType(int r2) {
        return ((g) ListProtector.get(this.b, r2)).a();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        LinkPKAudienceInteractPanelItemBaseVH r5 = (LinkPKAudienceInteractPanelItemBaseVH) r3;
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
        boolean r0 = true;
        if (r7 == 1) goto L11;
        View r8 = LayoutInflater.from(r6.getContext()).inflate(2131566321, r6, false);
        int r9 = s1.y();
        int r2 = s1.f(40.0f);
        int r3 = s1.f(68.0f);
        if (((this.b.size() * r3) + this.a) > (r9 + r2)) goto L7;
        r0 = false;
    L7:
        if (r0 == false) goto L12;
        double r1 = ((double) (s1.y() - this.a)) / 5.33d;
        int r4 = (int) r1;
        r8.getLayoutParams().width = r4;
    L12:
        return new LinkPKAudienceInteractPanelItemNormalVH(r8);
    L11:
        return new LinkPKAudienceInteractPanelDigitShowModeItemVH(LayoutInflater.from(r6.getContext()).inflate(2131566846, r6, false));
    }
}
