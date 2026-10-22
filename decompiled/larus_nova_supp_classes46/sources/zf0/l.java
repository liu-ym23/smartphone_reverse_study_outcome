package zf0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.linkpanel.util.y;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.SimplePreApplyViewHolder;
import com.bytedance.android.live.liveinteract.plantform.model.c1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends me.drakeet.multitype.b<c1, SimplePreApplyViewHolder> {
    public l() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        SimplePreApplyViewHolder r4 = (SimplePreApplyViewHolder) r2;
        c1 r5 = (c1) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.T3(r5, r4.getAdapterPosition());
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "parent");
        if (((Boolean) vm2.d.c2.getValue(null, vm2.d.a[156(0x9c, float:2.19E-43)])).booleanValue() == false) goto L5;
        View r10 = r8.inflate(2131566292, r9, false);
    L6:
        List r0 = CollectionsKt.listOf(new com.bytedance.android.live.liveinteract.linkpanel.util.a[]{y.c, com.bytedance.android.live.liveinteract.linkpanel.util.e.c, com.bytedance.android.live.liveinteract.linkpanel.util.d.c});
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L11;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r3 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r1.next();
        Pair r4 = new Pair(r3.b(), r3.a(r8.getContext(), (ViewGroup) r10.findViewById(2131380597)));
        r2.put(r4.getFirst(), r4.getSecond());
        goto L8
    L11:
        return new SimplePreApplyViewHolder(r10, r2);
    L5:
        r10 = r8.inflate(2131566296, r9, false);
        goto L6
    }
}
