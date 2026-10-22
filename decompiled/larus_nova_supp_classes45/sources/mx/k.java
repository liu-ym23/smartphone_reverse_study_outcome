package mx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.adapter.binding.SimpleSettingViewHolder;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mx.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k<T extends j> extends me.drakeet.multitype.b<T, SimpleSettingViewHolder> {
    public Function1<? super SimpleSettingViewHolder, Unit> b;
    public final boolean c;

    public k(boolean r1) {
        this.c = r1;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        SimpleSettingViewHolder r4 = (SimpleSettingViewHolder) r2;
        j r5 = (j) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.T3(r5);
        ((RecyclerView.ViewHolder) r4).itemView.setOnClickListener(r5.l);
        if (this.c == false) goto L16;
        TextView r6 = r4.a;
        if (r6 == null) goto L7;
        r6.setTextColor(s1.h(2131107294));
    L7:
        TextView r7 = r4.b;
        if (r7 == null) goto L10;
        r7.setTextColor(s1.h(2131107300));
    L10:
        View r8 = ((RecyclerView.ViewHolder) r4).itemView;
        if (r8 == null) goto L17;
        ImageView r9 = (ImageView) r8.findViewById(2131375994);
        if (r9 == null) goto L18;
        r9.setImageDrawable(s1.m(2131252570));
        return;
    L18:
        return;
    L17:
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        SimpleSettingViewHolder r5 = new SimpleSettingViewHolder(r3.inflate(2131566400, r4, false));
        Function1<? super SimpleSettingViewHolder, Unit> r6 = this.b;
        if (r6 == null) goto L5;
        Unit r7 = (Unit) r6.invoke(r5);
    L5:
        return r5;
    }
}
