package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentViewHolder extends RecyclerView.ViewHolder {
    private FragmentViewHolder(@NonNull FrameLayout r5) {
        super(r5);
    }

    @NonNull
    public static FragmentViewHolder create(@NonNull ViewGroup r5) {
        FrameLayout r10 = new FrameLayout(r5.getContext());
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r10.setId(ViewCompat.generateViewId());
        r10.setSaveEnabled(false);
        return new FragmentViewHolder(r10);
    }

    @NonNull
    public FrameLayout getContainer() {
        return (FrameLayout) this.itemView;
    }
}
