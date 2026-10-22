package com.bytedance.android.live.ktv.common.karaokestation.view;

import androidx.viewpager.widget.ViewPager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ CommonOrderSongDialog a;

    public b(CommonOrderSongDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Pair r6 = (Pair) r5;
        if (r6 == null) goto L28;
        int r7 = ((Number) r6.component1()).intValue();
        Iterator r0 = ((ArrayList) this.a.d).iterator();
        int r2 = 0;
    L7:
        if (r0.hasNext() == false) goto L15;
        if (((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r0.next()).VL().getValue() != r7) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L16;
        r2 = r2 + 1;
    L16:
        ViewPager r8 = this.a.m;
        if (r8 != null) goto L19;
    L20:
        ViewPager r9 = this.a.m;
        if (r9 == null) goto L27;
        r9.setCurrentItem(r2, false);
        return;
    L27:
        return;
    L19:
        if (r8.getCurrentItem() != r2) goto L20;
        return;
    L11:
        r3 = false;
        goto L12
    L15:
        r2 = -1;
        goto L16
    }
}
