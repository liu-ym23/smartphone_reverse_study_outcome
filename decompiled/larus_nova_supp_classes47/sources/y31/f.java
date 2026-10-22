package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKActEmptyViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends me.drakeet.multitype.b<a, PKActEmptyViewHolder> {

    public static final class a {
        public final String a;

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a = r2;
        }
    }

    public f() {
    }

    public final void g(RecyclerView.ViewHolder r2) {
        PKActEmptyViewHolder r3 = (PKActEmptyViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.getClass();
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        PKActEmptyViewHolder r4 = (PKActEmptyViewHolder) r2;
        a r5 = (a) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        TextView r6 = (TextView) ((RecyclerView.ViewHolder) r4).itemView.findViewById(2131371602);
        if (r5 == null) goto L5;
        String r7 = r5.a;
    L6:
        r6.setText(r7);
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new PKActEmptyViewHolder(r4.inflate(2131566350, r5, false));
    }
}
