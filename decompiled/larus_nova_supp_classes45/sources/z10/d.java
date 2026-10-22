package z10;

import a20.e;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.v3.OpenFeatureGroupRecentUsedListItemViewHolderV3;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.v3.OpenFeatureRecentUsedGroupListAdapterV3;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.OpenFeatureRecentUsedListRecyclerViewV3;
import f10.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends me.drakeet.multitype.b<f10.d, OpenFeatureGroupRecentUsedListItemViewHolderV3> {
    public final e b;

    public d(a20.d r1) {
        this.b = r1;
    }

    public final void b(RecyclerView.ViewHolder r5, Object r6) {
        OpenFeatureGroupRecentUsedListItemViewHolderV3 r7 = (OpenFeatureGroupRecentUsedListItemViewHolderV3) r5;
        f10.d r8 = (f10.d) r6;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "recentUsedGroupList");
        Object r9 = ((RecyclerView.ViewHolder) r7).itemView;
        if ((r9 instanceof OpenFeatureRecentUsedListRecyclerViewV3) == true) goto L5;
        r9 = null;
    L5:
        OpenFeatureRecentUsedListRecyclerViewV3 r11 = (OpenFeatureRecentUsedListRecyclerViewV3) r9;
        if (r11 == null) goto L33;
        List<f> r12 = r8.a;
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r12.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        Object r2 = r1.next();
        if (((f) r2).u == false) goto L9;
        r0.add(r2);
        goto L9
    L13:
        ArrayList r3 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L19;
        Object r4 = r13.next();
        if (((f) r4).u == true) goto L15;
        r3.add(r4);
        goto L15
    L19:
        List<f> r14 = CollectionsKt.plus(r0, r3);
        Intrinsics.checkNotNullParameter(r14, "itemList");
        OpenFeatureRecentUsedGroupListAdapterV3 r15 = r11.a;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r15.a = r14;
        RecyclerView.Adapter r16 = r11.getAdapter();
        if (r16 == null) goto L34;
        r16.notifyDataSetChanged();
        return;
    L34:
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new OpenFeatureGroupRecentUsedListItemViewHolderV3(new OpenFeatureRecentUsedListRecyclerViewV3(r5.getContext(), new OpenFeatureRecentUsedGroupListAdapterV3(CollectionsKt.emptyList(), this.b)));
    }
}
