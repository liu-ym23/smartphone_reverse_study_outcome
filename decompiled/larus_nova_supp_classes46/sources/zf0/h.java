package zf0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.linkpanel.util.HighScoreSongBadgeProvider;
import com.bytedance.android.live.liveinteract.linkpanel.util.x;
import com.bytedance.android.live.liveinteract.linkpanel.util.y;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.LinkPanelGuestViewHolder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends me.drakeet.multitype.b<ILinkPlayerInfoBridge, LinkPanelGuestViewHolder> {
    public final boolean b;
    public final com.bytedance.android.live.liveinteract.linkpanel.list.o c;
    public final int d;

    public final void b(RecyclerView.ViewHolder r9, Object r10) {
        LinkPanelGuestViewHolder r11 = (LinkPanelGuestViewHolder) r9;
        ILinkPlayerInfoBridge r12 = (ILinkPlayerInfoBridge) r10;
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(r12, "item");
        if (this.d == 1) goto L5;
    L9:
        r11.T3(r12);
        return;
    L5:
        if (r12.getListUserType() != 1) goto L9;
        if (r12.isHasExposed() == true) goto L9;
        boolean r2 = this.b;
        IBaseUser r0 = r12.getUser();
        Intrinsics.checkNotNull(r0);
        String r3 = r0.getIdString();
        boolean r4 = r12.isActive();
        boolean r5 = r12.isHasInvited();
        IBaseUser r1 = r12.getUser();
        Intrinsics.checkNotNull(r1);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.i(r2, r3, r4, r5, r1.isSubscriber(), "audience");
        r12.setHasExposed(true);
        goto L9
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "parent");
        View r10 = r8.inflate(2131566275, r9, false);
        List r0 = CollectionsKt.listOf(new com.bytedance.android.live.liveinteract.linkpanel.util.a[]{com.bytedance.android.live.liveinteract.linkpanel.util.f.c, HighScoreSongBadgeProvider.d, y.c, x.e, com.bytedance.android.live.liveinteract.linkpanel.util.e.c, com.bytedance.android.live.liveinteract.linkpanel.util.d.c});
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r3 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r1.next();
        Pair r4 = new Pair(r3.b(), r3.a(r8.getContext(), (ViewGroup) r10.findViewById(2131380597)));
        r2.put(r4.getFirst(), r4.getSecond());
        goto L4
    L7:
        return new LinkPanelGuestViewHolder(r10, this.d, this.c, r2);
    }

    public h(boolean r2, com.bytedance.android.live.liveinteract.linkpanel.list.o r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
