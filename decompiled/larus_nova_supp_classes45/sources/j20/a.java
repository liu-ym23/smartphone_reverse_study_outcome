package j20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends RecyclerView.Adapter<b> {
    public List<String> a;
    public final View.OnClickListener b;

    public final int getItemCount() {
        List<String> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public a(InteractGameFeedbackDialog.b r1) {
        this.b = r1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        b r4 = (b) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        List<String> r0 = this.a;
        if (r0 == null) goto L6;
        String r5 = (String) ListProtector.get(r0, r3);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "tag");
        r4.a.setText(r5);
        ((RecyclerView.ViewHolder) r4).itemView.setTag(r5);
        ((RecyclerView.ViewHolder) r4).itemView.setSelected(false);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131566279, r3, false);
        r5.setOnClickListener(this.b);
        return new b(r5);
    }
}
