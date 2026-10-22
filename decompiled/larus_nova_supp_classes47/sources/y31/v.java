package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.RecordFootViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v extends me.drakeet.multitype.b<a, RecordFootViewHolder> {

    public static final class a {
        public String a;

        public a() {
            this.a = "";
        }
    }

    public v() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        RecordFootViewHolder r4 = (RecordFootViewHolder) r2;
        a r5 = (a) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        String r6 = r5.a;
        TextView r7 = r4.a;
        if (r7 == null) goto L6;
        r7.setText(r6);
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new RecordFootViewHolder(r4.inflate(2131566382, r5, false));
    }
}
