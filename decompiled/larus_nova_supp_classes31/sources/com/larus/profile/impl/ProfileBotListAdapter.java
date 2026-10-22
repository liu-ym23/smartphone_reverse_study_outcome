package com.larus.profile.impl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.profile.impl.databinding.LarusItemProfileBotBinding;
import com.larus.profile.impl.view.BotProfileView;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B'\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0014\u0010\u0015\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017J\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/profile/impl/ProfileBotListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/profile/impl/ProfileBotListAdapter$BotListViewHolder;", "botList", "Ljava/util/ArrayList;", "Lcom/larus/profile/api/bean/ProfileBot;", "Lkotlin/collections/ArrayList;", "clickListener", "Lcom/larus/profile/impl/OnMyBotClickListener;", "<init>", "(Ljava/util/ArrayList;Lcom/larus/profile/impl/OnMyBotClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "updateData", "list", "", "getDataList", "BotListViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileBotListAdapter extends RecyclerView.Adapter<BotListViewHolder> {
    public final ArrayList<fs9.n> a;
    public final a b;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/profile/impl/ProfileBotListAdapter$BotListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "profile", "Lcom/larus/profile/impl/view/BotProfileView;", "kotlin.jvm.PlatformType", "bindData", "", "data", "Lcom/larus/profile/api/bean/ProfileBot;", "clickListener", "Lcom/larus/profile/impl/OnMyBotClickListener;", "position", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class BotListViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int b = 0;
        public final BotProfileView a;

        public BotListViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (BotProfileView) r2.findViewById(2131364380);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public ProfileBotListAdapter(ArrayList r2, ProfileBotListFragment$initRecyclerView$1$1 r3) {
        Intrinsics.checkNotNullParameter(r2, "botList");
        Intrinsics.checkNotNullParameter(r3, "clickListener");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, final int r8) {
        final BotListViewHolder r9 = (BotListViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        final fs9.n r0 = (fs9.n) ListProtector.get(this.a, r8);
        final a r1 = this.b;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "data");
        Intrinsics.checkNotNullParameter(r1, "clickListener");
        BotProfileView r2 = r9.a;
        if (r2 == null) goto L5;
        r2.R5(r0);
    L5:
        com.larus.utils.e1.u(r9.a, 0.0f, 2131102529, 2131103188);
        com.larus.utils.e1.d(((RecyclerView.ViewHolder) r9).itemView, new c(r1, r0));
        BotProfileView r3 = r9.a;
        if (r3 == null) goto L9;
        r3.setAddItemClick(new d(r9, r0, r1, r8));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        return new BotListViewHolder(LarusItemProfileBotBinding.a(LayoutInflater.from(r1.getContext()), r1).a);
    }
}
