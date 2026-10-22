package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentViewHolder extends RecyclerView.ViewHolder {
    private FragmentViewHolder(@NonNull FrameLayout r10) {
        super(r10);
    }

    @NonNull
    static FragmentViewHolder create(@NonNull ViewGroup r10) {
        FrameLayout r11 = new FrameLayout(r10.getContext());
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r11.setId(ViewCompat.generateViewId());
        r11.setSaveEnabled(false);
        return new FragmentViewHolder(r11);
    }

    @NonNull
    FrameLayout getContainer() {
        return (FrameLayout) this.itemView;
    }
}
