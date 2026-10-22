package com.larus.commercecredit.impl.page.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qz8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/commercecredit/impl/page/adapter/CommerceInviteInfoAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/commercecredit/impl/entity/Step;", "Lcom/larus/commercecredit/impl/page/adapter/CommerceInviteInfoAdapter$ViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "ViewHolder", "StepDiffCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommerceInviteInfoAdapter extends ListAdapter<o, ViewHolder> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/commercecredit/impl/page/adapter/CommerceInviteInfoAdapter$StepDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/commercecredit/impl/entity/Step;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StepDiffCallback extends DiffUtil.ItemCallback<o> {
        public StepDiffCallback() {
        }

        public final boolean areContentsTheSame(Object r3, Object r4) {
            o r5 = (o) r3;
            o r6 = (o) r4;
            Intrinsics.checkNotNullParameter(r5, "oldItem");
            Intrinsics.checkNotNullParameter(r6, "newItem");
            if (Intrinsics.areEqual(r5.b(), r6.b()) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(r5.a(), r6.a()) == false) goto L7;
            return true;
        }

        public final boolean areItemsTheSame(Object r3, Object r4) {
            o r5 = (o) r3;
            o r6 = (o) r4;
            Intrinsics.checkNotNullParameter(r5, "oldItem");
            Intrinsics.checkNotNullParameter(r6, "newItem");
            if (Intrinsics.areEqual(r5.b(), r6.b()) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(r5.a(), r6.a()) == false) goto L7;
            return true;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/commercecredit/impl/page/adapter/CommerceInviteInfoAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "description", "inviteInfoIndex", "bind", "", "step", "Lcom/larus/commercecredit/impl/entity/Step;", "index", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;
        public final TextView c;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131390815);
            this.b = (TextView) r2.findViewById(2131390813);
            this.c = (TextView) r2.findViewById(2131390814);
        }
    }

    public CommerceInviteInfoAdapter() {
        super(new StepDiffCallback());
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        ViewHolder r7 = (ViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        o r0 = (o) getItem(r6);
        Intrinsics.checkNotNull(r0);
        int r8 = r6 + 1;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "step");
        TextView r1 = r7.a;
        String r2 = r0.b();
        String r3 = "";
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        r1.setText(r2);
        TextView r4 = r7.b;
        String r9 = r0.a();
        if (r9 == null) goto L9;
        r3 = r9;
    L9:
        r4.setText(r3);
        r7.c.setText(String.valueOf(r8));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562519, r3, false);
        Intrinsics.checkNotNull(r5);
        return new ViewHolder(r5);
    }
}
