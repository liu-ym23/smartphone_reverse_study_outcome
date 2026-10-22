package f20;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a<T, V extends RecyclerView.ViewHolder> extends c {
    V a(LayoutInflater r1, ViewGroup r2);

    void d(V r1, T r2);
}
