package com.bytedance.android.livesdk.gift.platform.format.panel.adapter;

import android.os.Handler;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revenue.core.util.i;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.q;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.n;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/bytedance/android/livesdk/gift/platform/format/panel/adapter/FormatGiftDialogViewPagerAdapter$createRecyclerView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1 extends RecyclerView.OnScrollListener {
    public final Handler a;
    public final a b;
    public int c;
    public final /* synthetic */ RecyclerView d;
    public final /* synthetic */ FormatGiftDialogViewPagerAdapter e;
    public final /* synthetic */ int f;

    public final void onScrollStateChanged(RecyclerView r11, int r13) {
        Intrinsics.checkNotNullParameter(r11, "recyclerView");
        this.c = r13;
        RecyclerView.LayoutManager r14 = r11.getLayoutManager();
        List<AbsPanel<?>> r1 = null;
        if ((r14 instanceof LinearLayoutManager) == true) goto L5;
        r14 = null;
    L5:
        LinearLayoutManager r15 = (LinearLayoutManager) r14;
        if (r15 == null) goto L9;
        FormatGiftDialogViewPagerAdapter r0 = this.e;
        int r2 = r15.findFirstCompletelyVisibleItemPosition();
        int r16 = r15.findLastCompletelyVisibleItemPosition();
        int r3 = FormatGiftDialogViewPagerAdapter.o;
        r0.m(r2, r16);
    L9:
        if (r13 == 0) goto L17;
        if (r13 != 1) goto L12;
        this.e.i = System.currentTimeMillis();
        return;
    L12:
        if (r13 != 2) goto L50;
        this.a.postDelayed(this.b, 20);
        return;
    L50:
        return;
    L17:
        if ((!Intrinsics.areEqual(this.e.e, new IntRange(-1, -1))) == false) goto L48;
        FormatGiftDialogViewPagerAdapter r17 = this.e;
        if ((!Intrinsics.areEqual(r17.e, (IntRange) ((LinkedHashMap) r17.h).get(Integer.valueOf(this.f)))) == true) goto L21;
        return;
    L21:
        if (this.e.n.getDataCenter() != null) goto L23;
    L41:
        FormatGiftDialogViewPagerAdapter r18 = this.e;
        IntRange r19 = (IntRange) ((LinkedHashMap) r18.h).get(Integer.valueOf(this.f));
        if (r19 != null) goto L44;
        r19 = new IntRange(-1, -1);
    L44:
        r18.e = r19;
        return;
    L23:
        if (x.d() == false) goto L26;
        String r110 = h.a;
        int r4 = this.f;
        IntRange r5 = new IntRange((this.e.e.getFirst() / 4) + 1, (this.e.e.getLast() / 4) + 1);
        int r6 = (this.e.e.getLast() - this.e.e.getFirst()) + 1;
        long r7 = (System.currentTimeMillis() - this.e.i) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        boolean r8 = u.p();
        this.e.getClass();
        int r111 = i.a;
        q r112 = m.b;
        h.D(r4, r5, r6, r7, r8 ? 1 : 0, BuildConfig.FLAVOR);
        goto L41
    L26:
        if (x.b() == false) goto L41;
        FormatGiftDialogAdapter r113 = (FormatGiftDialogAdapter) ((LinkedHashMap) this.e.d).get(Integer.valueOf(this.f));
        if (r113 == null) goto L30;
        r1 = r113.a;
    L30:
        if (r1 == null) goto L40;
        GiftContext r114 = b.b();
        if (r114 == null) goto L38;
        n<Integer> r115 = r114.getCurrentSelectedGiftPosition();
        if (r115 == null) goto L38;
        Integer r116 = (Integer) r115.getValue();
        if (r116 == null) goto L38;
        int r117 = r116.intValue();
    L39:
        AbsPanel r118 = (AbsPanel) CollectionsKt.getOrNull(r1, r117);
    L38:
        r117 = 0;
    L40:
        int r119 = d22.a.a;
        d22.a.a(this.f, new IntRange((this.e.e.getFirst() / 4) + 1, (this.e.e.getLast() / 4) + 1), (this.e.e.getLast() - this.e.e.getFirst()) + 1, (System.currentTimeMillis() - this.e.i) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        goto L41
    }

    public FormatGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1(RecyclerView r1, FormatGiftDialogViewPagerAdapter r2, int r3) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.a = new Handler();
        this.b = new a(this);
        this.c = -1;
    }

    public final void onScrolled(RecyclerView r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        if (r4 != 0) goto L5;
        if (r5 != 0) goto L5;
    L6:
        this.a.removeCallbacks(this.b);
        if (this.c != 2) goto L10;
        this.a.postDelayed(this.b, 20);
        return;
    L10:
        return;
    L5:
        this.e.l(r3, this.f, false, true);
        goto L6
    }
}
