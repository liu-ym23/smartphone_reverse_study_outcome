package yp0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.grouptitle.AnchorShelfDisplayGroupTitleItemViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends me.drakeet.multitype.b<b, AnchorShelfDisplayGroupTitleItemViewHolder> {
    public a() {
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        AnchorShelfDisplayGroupTitleItemViewHolder r6 = (AnchorShelfDisplayGroupTitleItemViewHolder) r4;
        b r7 = (b) r5;
        Intrinsics.checkNotNullParameter(r6, "vh");
        Intrinsics.checkNotNullParameter(r7, "groupTitle");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "groupTitle");
        ViewGroup.LayoutParams r0 = ((RecyclerView.ViewHolder) r6).itemView.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L10;
        int r2 = r1.topMargin;
        int r3 = r7.b;
        if (r2 == r3) goto L10;
        r1.topMargin = r3;
        ((RecyclerView.ViewHolder) r6).itemView.setLayoutParams(r1);
    L10:
        r6.a.setText(r7.a);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new AnchorShelfDisplayGroupTitleItemViewHolder(r3.inflate(2131566968, r4, false));
    }
}
