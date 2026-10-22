package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureTabPageAdapter;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureChooseListFragment a;

    public k(LiveOpenFeatureChooseListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        c20.c r12 = (c20.c) r11;
        if (r12 == null) goto L56;
        int r1 = 0;
        if (r12.c.isEmpty() == false) goto L7;
        LiveOpenFeatureChooseListFragment.V90(this.a, false);
    L8:
        LiveOpenFeatureChooseListFragment r0 = this.a;
        if (r0.isAdded() == false) goto L57;
        r0.m.clear();
        Iterator<T> r3 = r12.d.iterator();
        int r4 = 0;
    L12:
        if (r3.hasNext() == false) goto L20;
        T r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        c20.d r7 = (c20.d) r5;
        if (r0.m.containsKey(Integer.valueOf(r4)) == true) goto L19;
        r0.m.put(Integer.valueOf(r4), new LiveOpenFeatureChooseListFragment.b(-1, -1));
    L19:
        r4 = r6;
        goto L12
    L20:
        UtilityKotlinExtentionsKt.v(r0.T90(2131372179), true);
        UtilityKotlinExtentionsKt.v(r0.T90(2131372190), true);
        UtilityKotlinExtentionsKt.v(r0.T90(2131371747), false);
        if (r12.d.size() != 1) goto L23;
        r0.T90(2131372179).setTextColorResource(2131107979);
        r0.T90(2131372179).setIndicatorColorResource(2131106784);
    L24:
        OpenFeatureTabPageAdapter r8 = r0.f;
        if (r8 == null) goto L28;
        r8.f(r12.c, r12.d);
    L28:
        if (((k81) ft0.a.getValue()).b() == false) goto L39;
        if (r12.d.size() <= 1) goto L39;
        if (r0.k == false) goto L39;
        r0.k = false;     // Catch: Exception -> L37
        OpenFeatureTabPageAdapter r2 = r0.f;     // Catch: Exception -> L37
        if (r2 == null) goto L39;
        r2.g(r12.d, r0.g, MapsKt.mapOf(TuplesKt.to("selected_group_id", Long.valueOf(r12.e))));     // Catch: Exception -> L37
    L39:
        if (r12.f == true) goto L58;
        OpenFeatureTabPageAdapter r13 = r0.f;
        if (r13 == null) goto L59;
        ArrayList<c20.d> r14 = r13.b;
        if (r14 == null) goto L60;
        ViewPager r9 = r0.g;
        if (r9 == null) goto L47;
        r1 = r9.getCurrentItem();
    L47:
        c20.d r15 = (c20.d) ListProtector.get(r14, r1);
        if (r15 == null) goto L61;
        int r16 = d20.a.a;
        d20.a.d(r15.b);
        return;
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L23:
        r0.T90(2131372179).setTextColorResource(2131107973);
        r0.T90(2131372179).setIndicatorColorResource(2131107975);
        goto L24
    L57:
        return;
    L7:
        LiveOpenFeatureChooseListFragment.V90(this.a, true);
        goto L8
    }
}
