package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.TitleViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y extends me.drakeet.multitype.b<a, TitleViewHolder> {

    public static final class a {
        public String a;

        public a() {
        }
    }

    public y() {
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        TitleViewHolder r6 = (TitleViewHolder) r4;
        a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "titleViewBinderData");
        ((TextView) r6.a.findViewById(2131388772)).setVisibility(0);
        ((TextView) r6.a.findViewById(2131388772)).setText(r7.a);
        ((TextView) r6.a.findViewById(2131388772)).setTextColor(s1.h(2131107680));
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new TitleViewHolder(r4.inflate(2131566293, r5, false));
    }
}
