package com.larus.common.account.bdauth.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.account.bdauth.impl.databinding.LarusItemAuthHeaderBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/common/account/bdauth/ui/BDAuthorizeHeaderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/common/account/bdauth/ui/BDAuthorizeHeaderAdapter$HeaderViewHolder;", "<init>", "()V", "title", "", "subTitle", "update", "", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "HeaderViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BDAuthorizeHeaderAdapter extends RecyclerView.Adapter<HeaderViewHolder> {
    public String a;
    public String b;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/common/account/bdauth/ui/BDAuthorizeHeaderAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/account/bdauth/impl/databinding/LarusItemAuthHeaderBinding;", "<init>", "(Lcom/larus/account/bdauth/impl/databinding/LarusItemAuthHeaderBinding;)V", "bind", "", "title", "", "subTitle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HeaderViewHolder extends RecyclerView.ViewHolder {
        public final LarusItemAuthHeaderBinding a;

        public HeaderViewHolder(LarusItemAuthHeaderBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public final int getItemCount() {
        return 1;
    }

    public BDAuthorizeHeaderAdapter() {
        this.a = "";
        this.b = "";
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        HeaderViewHolder r5 = (HeaderViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        String r6 = this.a;
        String r0 = this.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "title");
        Intrinsics.checkNotNullParameter(r0, "subTitle");
        r5.a.c.setText(r6);
        r5.a.b.setText(r0);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        ConstraintLayout r6 = LayoutInflater.from(r4.getContext()).inflate(2131562494, r4, false);
        int r0 = 2131363535;
        if (((ImageView) ViewBindings.findChildViewById(r6, 2131363535)) == null) goto L11;
        r0 = 2131363537;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r6, 2131363537);
        if (r1 == null) goto L11;
        r0 = 2131363538;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r6, 2131363538);
        if (r2 == null) goto L11;
        return new HeaderViewHolder(new LarusItemAuthHeaderBinding(r6, r1, r2));
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }

    public final void update(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "subTitle");
        this.a = r2;
        this.b = r3;
        notifyItemChanged(0);
    }
}
