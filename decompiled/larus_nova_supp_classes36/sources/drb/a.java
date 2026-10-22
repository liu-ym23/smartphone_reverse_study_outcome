package drb;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a<D, VH extends RecyclerView.ViewHolder> {
    public static final int a = 0;

    long a(D r1);

    VH b(ViewGroup r1);

    void c(RecyclerView.ViewHolder r1, BaseAtBean r2, int r3);

    void d(RecyclerView.ViewHolder r1, BaseAtBean r2, int r3, List r4);

    static {
        a = UIHelper.dp2px(40.0f);
        UIHelper.dp2px(24.0f);
    }
}
