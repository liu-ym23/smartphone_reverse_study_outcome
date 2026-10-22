package mx;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n extends m {
    public n() {
        super(false);
    }

    @Override // mx.m
    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h(r1, (o) r2);
    }

    @Override // mx.m
    public final void h(RecyclerView.ViewHolder r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "item");
        super.h(r2, r3);
        View r4 = r2.itemView;
        if (r4 == null) goto L7;
        ((TextView) r4).setTextColor(ColorProtector.parseColor("#80161823"));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
