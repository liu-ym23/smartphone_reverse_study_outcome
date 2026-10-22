package mx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.simple.SimpleViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends me.drakeet.multitype.b<e, RecyclerView.ViewHolder> {
    public f() {
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        e r5 = (e) r4;
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        View r6 = r3.itemView;
        r6.setBackgroundColor(s1.h(r5.a));
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L13;
        r0.height = s1.f(r5.b);
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        ViewGroup.LayoutParams r1 = null;
    L8:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L11;
        int r7 = s1.f(r5.c);
        r2.leftMargin = r7;
        r2.rightMargin = r7;
    L11:
        r6.setLayoutParams(r0);
        return;
    L7:
        r1 = r0;
        goto L8
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new SimpleViewHolder(r3.inflate(2131566271, r4, false));
    }
}
