package q28;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface c<VH extends RecyclerView.ViewHolder> {
    long getHeaderId(int r1);

    int getItemCount();

    void onBindHeaderViewHolder(VH r1, int r2);

    VH onCreateHeaderViewHolder(ViewGroup r1);
}
