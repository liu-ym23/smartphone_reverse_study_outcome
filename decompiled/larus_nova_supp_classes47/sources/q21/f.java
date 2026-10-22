package q21;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.AnchorLinkTitleViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends me.drakeet.multitype.b<a, AnchorLinkTitleViewHolder> {

    public static final class a {
        public String a;
        public CharSequence b;

        public a() {
        }
    }

    public f() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        AnchorLinkTitleViewHolder r4 = (AnchorLinkTitleViewHolder) r2;
        a r5 = (a) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.getClass();
        CharSequence r0 = r5.b;
        if (r0 == null) goto L5;
        r4.a.setText(r0);
        return;
    L5:
        r4.a.setText(r5.a);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new AnchorLinkTitleViewHolder(r4.inflate(2131566232, r5, false));
    }
}
