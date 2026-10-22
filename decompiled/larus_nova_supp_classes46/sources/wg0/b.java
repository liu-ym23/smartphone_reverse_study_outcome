package wg0;

import androidx.recyclerview.widget.RecyclerView;
import jg0.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements ne0.a {
    public final /* synthetic */ e a;

    public b(e r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "store");
        RecyclerView r6 = this.a.e.a;
        if (r6 == null) goto L5;
        RecyclerView.Adapter r7 = r6.getAdapter();
    L6:
        if (r6 == null) goto L19;
        if (r7 == null) goto L24;
        int r8 = r7.getItemCount();
        int r0 = 0;
    L9:
        if (r0 >= r8) goto L25;
        hg0.b r1 = r6.findViewHolderForAdapterPosition(r0);
        if ((r1 instanceof hg0.b) == false) goto L18;
        g r2 = r1.l();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b r3 = r2.g();
        if (r3 == null) goto L15;
        r3.y();
    L15:
        pg0.e r9 = r2.s();
        if (r9 == null) goto L18;
        r9.y();
    L18:
        r0 = r0 + 1;
        goto L9
    L25:
        return;
    L24:
        return;
    L19:
        return;
    L5:
        r7 = null;
        goto L6
    }
}
