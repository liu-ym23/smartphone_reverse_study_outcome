package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureChooseListFragmentV3 a;

    public e(LiveOpenFeatureChooseListFragmentV3 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        List r8 = (List) r7;
        if (r8 == null) goto L24;
        LiveOpenFeatureChooseListFragmentV3 r0 = this.a;
        int r1 = LiveOpenFeatureChooseListFragmentV3.F;
        if (r0.isAdded() == false) goto L25;
        Iterator<T> r2 = r8.iterator();
    L7:
        int r3 = 0;
    L9:
        if (r2.hasNext() == false) goto L13;
        T r4 = r2.next();
        if ((r4 instanceof f10.f) == false) goto L7;
        int r5 = r3 % 5;
        ((f10.f) r4).B = r5;
        r3 = r3 + 1;
        goto L9
    L13:
        RecyclerView r6 = r0.q;
        if (r6 == null) goto L16;
        UtilityKotlinExtentionsKt.v(r6, true);
    L16:
        MultiTypeAdapter r9 = r0.j;
        if (r9 == null) goto L19;
        r9.a = r8;
    L19:
        if (r9 == null) goto L26;
        r9.notifyDataSetChanged();
        return;
    L26:
        return;
    L25:
        return;
    }
}
