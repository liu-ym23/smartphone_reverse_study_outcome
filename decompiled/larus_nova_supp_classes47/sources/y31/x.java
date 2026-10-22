package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.RevLinkTitleViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x extends me.drakeet.multitype.b<s.a, RevLinkTitleViewHolder> {
    public x() {
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        RevLinkTitleViewHolder r6 = (RevLinkTitleViewHolder) r4;
        s.a r7 = (s.a) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "item");
        CharSequence r0 = r7.a;
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
    L7:
        r6.b = r1;
        ((TextView) r6.a.findViewById(2131388772)).setVisibility(0);
        ((TextView) r6.a.findViewById(2131388772)).setText(r7.a);
        return;
    L6:
        r1 = "";
        goto L7
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new RevLinkTitleViewHolder(r4.inflate(2131566385, r5, false));
    }
}
