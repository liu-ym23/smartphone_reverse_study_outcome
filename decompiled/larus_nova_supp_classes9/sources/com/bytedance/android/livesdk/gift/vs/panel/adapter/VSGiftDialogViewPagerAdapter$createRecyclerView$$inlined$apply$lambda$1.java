package com.bytedance.android.livesdk.gift.vs.panel.adapter;

import android.os.Handler;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.n;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/bytedance/android/livesdk/gift/vs/panel/adapter/VSGiftDialogViewPagerAdapter$createRecyclerView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1 extends RecyclerView.OnScrollListener {
    public final Handler a;
    public final a b;
    public int c;
    public final /* synthetic */ RecyclerView d;
    public final /* synthetic */ VSGiftDialogViewPagerAdapter e;
    public final /* synthetic */ int f;

    public final void onScrollStateChanged(RecyclerView r11, int r13) {
        Intrinsics.checkNotNullParameter(r11, "recyclerView");
        this.c = r13;
        RecyclerView.LayoutManager r14 = r11.getLayoutManager();
        List<AbsPanel<?>> r1 = null;
        String r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        if ((r14 instanceof LinearLayoutManager) == true) goto L5;
        r14 = null;
    L5:
        LinearLayoutManager r15 = (LinearLayoutManager) r14;
        if (r15 == null) goto L9;
        VSGiftDialogViewPagerAdapter r0 = this.e;
        int r3 = r15.findFirstCompletelyVisibleItemPosition();
        int r16 = r15.findLastCompletelyVisibleItemPosition();
        int r4 = VSGiftDialogViewPagerAdapter.p;
        r0.m(r3, r16);
    L9:
        if (r13 == 0) goto L17;
        if (r13 != 1) goto L12;
        this.e.i = System.currentTimeMillis();
        return;
    L12:
        if (r13 != 2) goto L69;
        this.a.postDelayed(this.b, 20);
        return;
    L69:
        return;
    L17:
        if ((!Intrinsics.areEqual(this.e.e, new IntRange(-1, -1))) == false) goto L67;
        VSGiftDialogViewPagerAdapter r17 = this.e;
        if ((!Intrinsics.areEqual(r17.e, (IntRange) ((LinkedHashMap) r17.h).get(Integer.valueOf(this.f)))) == true) goto L21;
        return;
    L21:
        if (this.e.n.getDataCenter() != null) goto L23;
    L60:
        VSGiftDialogViewPagerAdapter r18 = this.e;
        IntRange r19 = (IntRange) ((LinkedHashMap) r18.h).get(Integer.valueOf(this.f));
        if (r19 != null) goto L63;
        r19 = new IntRange(-1, -1);
    L63:
        r18.e = r19;
        return;
    L23:
        if (x.d() == false) goto L45;
        String r110 = h.a;
        int r5 = this.f;
        IntRange r6 = new IntRange((this.e.e.getFirst() / 4) + 1, (this.e.e.getLast() / 4) + 1);
        int r7 = (this.e.e.getLast() - this.e.e.getFirst()) + 1;
        long r8 = (System.currentTimeMillis() - this.e.i) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        boolean r9 = u.p();
        this.e.getClass();
        j.a r111 = j.C0;
        k r112 = f.d(r111.a(), k.class);
        n01.a r113 = f.d(r111.a(), n01.a.class);
        if (r113 == null) goto L32;
        Episode r114 = r113.jf();
        if (r114 == null) goto L32;
        String r115 = r114.getSeasonIdFlex();
        if (r115 == null) goto L32;
        r2 = r115;
    L40:
        if (r2 != null) goto L42;
        String r10 = BuildConfig.FLAVOR;
    L43:
        h.D(r5, r6, r7, r8, r9 ? 1 : 0, r10);
        goto L60
    L42:
        r10 = r2;
    L32:
        if (r112 == null) goto L40;
        IRoom r116 = r112.getRoom();
        if (r116 == null) goto L40;
        IEpisodeExtraInfo r117 = r116.getEpisodeExtra();
        if (r117 == null) goto L40;
        Long r118 = r117.getSeasonId();
        if (r118 == null) goto L40;
        r2 = String.valueOf(r118.longValue());
        goto L40
    L45:
        if (x.b() == false) goto L60;
        VSGiftDialogAdapterNew r119 = (VSGiftDialogAdapterNew) ((LinkedHashMap) this.e.d).get(Integer.valueOf(this.f));
        if (r119 == null) goto L49;
        r1 = r119.a;
    L49:
        if (r1 == null) goto L59;
        GiftContext r120 = b.b();
        if (r120 == null) goto L57;
        n<Integer> r121 = r120.getCurrentSelectedGiftPosition();
        if (r121 == null) goto L57;
        Integer r122 = (Integer) r121.getValue();
        if (r122 == null) goto L57;
        int r123 = r122.intValue();
    L58:
        AbsPanel r124 = (AbsPanel) CollectionsKt.getOrNull(r1, r123);
    L57:
        r123 = 0;
    L59:
        int r125 = d22.a.a;
        d22.a.a(this.f, new IntRange((this.e.e.getFirst() / 4) + 1, (this.e.e.getLast() / 4) + 1), (this.e.e.getLast() - this.e.e.getFirst()) + 1, (System.currentTimeMillis() - this.e.i) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        goto L60
    }

    public VSGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1(RecyclerView r1, VSGiftDialogViewPagerAdapter r2, int r3) {
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
