package zf0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.linkpanel.util.HighScoreSongBadgeProvider;
import com.bytedance.android.live.liveinteract.linkpanel.util.y;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.SimpleGuestApplyViewHolder;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends me.drakeet.multitype.b<n0, SimpleGuestApplyViewHolder> {
    public final Function1<n0, Integer> b;

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function1<? super n0, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "getItemPosition");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        SimpleGuestApplyViewHolder r4 = (SimpleGuestApplyViewHolder) r2;
        n0 r5 = (n0) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.T3(r5, this.b);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "parent");
        View r10 = r8.inflate(2131566296, r9, false);
        List r0 = CollectionsKt.listOf(new com.bytedance.android.live.liveinteract.linkpanel.util.a[]{com.bytedance.android.live.liveinteract.linkpanel.viewholder.b.b, HighScoreSongBadgeProvider.d, y.c, com.bytedance.android.live.liveinteract.linkpanel.util.e.c, com.bytedance.android.live.liveinteract.linkpanel.util.d.c});
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r3 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r1.next();
        Pair r4 = new Pair(r3.b(), r3.a(r8.getContext(), (ViewGroup) r10.findViewById(2131380597)));
        r2.put(r4.getFirst(), r4.getSecond());
        goto L4
    L7:
        return new SimpleGuestApplyViewHolder(r10, r2);
    }
}
