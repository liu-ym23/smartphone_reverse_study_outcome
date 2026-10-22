package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.v3.OpenFeatureTabPageAdapterV3;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.widget.LivePagerSlidingTabStrip;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ LiveOpenFeatureChooseListFragmentV3 a;

    public d(LiveOpenFeatureChooseListFragmentV3 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        if (Intrinsics.areEqual((Boolean) r6, Boolean.TRUE) == false) goto L37;
        LiveOpenFeatureChooseListFragmentV3 r7 = this.a;
        int r0 = LiveOpenFeatureChooseListFragmentV3.F;
        if (r7.isAdded() == false) goto L38;
        LivePagerSlidingTabStrip r1 = r7.p;
        if (r1 == null) goto L9;
        UtilityKotlinExtentionsKt.v(r1, false);
    L9:
        ViewPager r2 = r7.r;
        if (r2 == null) goto L12;
        UtilityKotlinExtentionsKt.v(r2, false);
    L12:
        RecyclerView r3 = r7.q;
        if (r3 == null) goto L15;
        UtilityKotlinExtentionsKt.v(r3, true);
    L15:
        OpenFeatureTabPageAdapterV3 r4 = r7.e;
        if (r4 == null) goto L18;
        r4.g(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    L18:
        r7.ca0(r7.x, 60, 80);
        LinearLayout r5 = r7.o;
        if (r5 == null) goto L21;
        UtilityKotlinExtentionsKt.v(r5, true);
    L21:
        TextView r8 = r7.v;
        if (r8 == null) goto L24;
        UtilityKotlinExtentionsKt.v(r8, false);
    L24:
        TextView r9 = r7.w;
        if (r9 == null) goto L27;
        UtilityKotlinExtentionsKt.v(r9, false);
    L27:
        TextView r11 = r7.x;
        if (r11 == null) goto L30;
        UtilityKotlinExtentionsKt.v(r11, true);
    L30:
        SimpleDraweeView r12 = r7.s;
        if (r12 == null) goto L33;
        UtilityKotlinExtentionsKt.v(r12, false);
    L33:
        TextView r13 = r7.x;
        if (r13 == null) goto L39;
        r13.setText(s1.B(2131921028));
        return;
    L39:
        return;
    L38:
        return;
    }
}
