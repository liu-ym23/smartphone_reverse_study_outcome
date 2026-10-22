package com.larus.dora.impl.wlan.wifi;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.databinding.LarusDoraWifiHeaderLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/DoraWifiHeaderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiHeaderAdapter$ViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWifiHeaderAdapter extends RecyclerView.Adapter<ViewHolder> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/DoraWifiHeaderAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraWifiHeaderLayoutBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraWifiHeaderLayoutBinding;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(LarusDoraWifiHeaderLayoutBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
        }
    }

    public final int getItemCount() {
        return 1;
    }

    public DoraWifiHeaderAdapter() {
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        Intrinsics.checkNotNullParameter((ViewHolder) r1, "holder");
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ConstraintLayout r5 = LayoutInflater.from(r3.getContext()).inflate(2131562313, r3, false);
        if (((LinearLayout) ViewBindings.findChildViewById(r5, 2131370056)) == null) goto L7;
        return new ViewHolder(new LarusDoraWifiHeaderLayoutBinding(r5));
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131370056)));
    }
}
