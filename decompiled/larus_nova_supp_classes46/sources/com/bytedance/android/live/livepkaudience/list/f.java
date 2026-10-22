package com.bytedance.android.live.livepkaudience.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.livepkaudience.dialog.PkAudienceListInviteDialogFragment;
import dl0.s;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends me.drakeet.multitype.b<e, PkControlViewHolder> {
    public final xk0.c b;
    public final int c;

    public f(PkAudienceListInviteDialogFragment.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
        this.c = 1;
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        PkControlViewHolder r6 = (PkControlViewHolder) r4;
        e r7 = (e) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        if (this.c == 1) goto L9;
        r7.getClass();
        r6.getClass();
        Intrinsics.checkNotNullParameter(null, "linkPlayerInfo");
        xk0.c r8 = r6.d;
        if (r8 == null) goto L7;
        r8.isGame();
    L7:
        UtilityKotlinExtentionsKt.w(r6.a);
        r6.a.setOnClickListener(new d(r6));
        throw null;
    L9:
        r7.getClass();
        throw null;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "parent");
        View r10 = r8.inflate(2131566284, r9, false);
        List r0 = CollectionsKt.listOf(new dl0.a[]{s.c, dl0.o.c, dl0.g.c, dl0.e.c, dl0.i.c});
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        dl0.a r3 = (dl0.a) r1.next();
        Pair r4 = new Pair(r3.b(), r3.a(r8.getContext(), (ViewGroup) r10.findViewById(2131380597)));
        r2.put(r4.getFirst(), r4.getSecond());
        goto L4
    L7:
        return new PkControlViewHolder(r10, this.c, this.b, r2);
    }
}
