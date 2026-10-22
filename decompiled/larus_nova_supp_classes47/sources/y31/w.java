package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.ReserveTabViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w extends me.drakeet.multitype.b<a, ReserveTabViewHolder> {

    public static final class a {
        public String a;
        public int b;
        public b c;
        public boolean d;

        public a() {
            this.a = "";
        }
    }

    public w() {
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        ReserveTabViewHolder r5 = (ReserveTabViewHolder) r3;
        a r6 = (a) r4;
        Intrinsics.checkNotNullParameter(r5, "p0");
        Intrinsics.checkNotNullParameter(r6, "p1");
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "tip");
        r5.a = r6;
        TextView r0 = r5.b;
        if (r0 == null) goto L5;
        r0.setText(r6.a);
    L5:
        a r1 = r5.a;
        if (r1 != null) goto L8;
    L15:
        TextView r2 = r5.b;
        if (r2 == null) goto L19;
        r2.setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.u(r5, r6));
        return;
    L19:
        return;
    L8:
        if (r1.d != true) goto L15;
        TextView r7 = r5.b;
        if (r7 == null) goto L12;
        r7.setBackground(s1.m(2131252606));
    L12:
        TextView r8 = r5.b;
        if (r8 == null) goto L15;
        r8.setTextColor(s1.h(2131100641));
        goto L15
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ReserveTabViewHolder(r4.inflate(2131566383, r5, false));
    }
}
