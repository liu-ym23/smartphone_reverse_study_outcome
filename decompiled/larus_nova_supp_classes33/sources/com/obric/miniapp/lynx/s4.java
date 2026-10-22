package com.obric.miniapp.lynx;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.button.OButton;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s4 extends RecyclerView.Adapter<v4> {
    public final List<t4> a;
    public final Function2<t4, Integer, Unit> b;

    public final int getItemCount() {
        return this.a.size();
    }

    public final int getItemViewType(int r2) {
        return ((t4) ListProtector.get(this.a, r2)).b;
    }

    public s4(List r2, p r3) {
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r3, "onClick");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, final int r6) {
        v4 r7 = (v4) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        final t4 r0 = (t4) ListProtector.get(this.a, r6);
        final Function2<t4, Integer, Unit> r1 = this.b;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        Intrinsics.checkNotNullParameter(r1, "onClick");
        r7.a.setText(r0.a);
        r7.a.setEnabled(!r0.d);
        OButton r2 = r7.a;
        if (r0.d == false) goto L5;
        float r3 = 0.4f;
    L6:
        r2.setAlpha(r3);
        r7.a.requestLayout();
        r7.a.setOnClickListener(new u4(r1, r0, r6));
        return;
    L5:
        r3 = 1.0f;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new v4((OButton) vma.e.a(r3.getContext(), r4, new q()));
    }
}
