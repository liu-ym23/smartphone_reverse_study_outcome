package mx;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.adapter.binding.ECSimpleSettingViewHolder;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;
import mx.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T extends b> extends me.drakeet.multitype.b<T, ECSimpleSettingViewHolder> {
    public final boolean b;

    public c(boolean r1) {
        this.b = r1;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        ECSimpleSettingViewHolder r4 = (ECSimpleSettingViewHolder) r2;
        b r5 = (b) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.T3(r5);
        ((RecyclerView.ViewHolder) r4).itemView.setOnClickListener(r5.l);
        if (this.b == false) goto L11;
        TextView r6 = r4.a;
        if (r6 == null) goto L7;
        r6.setTextColor(s1.h(2131107294));
    L7:
        TextView r7 = r4.b;
        if (r7 == null) goto L12;
        r7.setTextColor(s1.h(2131107300));
        return;
    L12:
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ECSimpleSettingViewHolder(r3.inflate(2131566401, r4, false));
    }
}
