package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import android.widget.FrameLayout;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.BannerAdapter;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.SimpleCarouselViewPager;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ MiniAppChooseListFragment a;

    public m(MiniAppChooseListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        a r8 = (a) r7;
        if ((r8 instanceof a.c) == false) goto L23;
        ((FrameLayout) this.a.T90(2131363960)).setVisibility(0);
        a.c r9 = (a.c) r8;
        if (r9.a.size() != 1) goto L7;
        ((SimpleCarouselViewPager) this.a.T90(2131363959)).setEnableAutoCarousel(false);
        ((SimpleCarouselViewPager) this.a.T90(2131363959)).setEnableInfiniteCarousel(false);
    L8:
        BannerAdapter r0 = this.a.m;
        if (r0 == null) goto L12;
        List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "newBannerList");
        r0.a = new ArrayList(r10);
        r0.notifyDataSetChanged();
    L12:
        if (lp0.b.a(this.a.g) == null) goto L30;
        boolean r11 = lp0.b.d(this.a.g);
        com.bytedance.android.livesdk.log.g r1 = u.l();
        Pair[] r2 = new Pair[2];
        r2[0] = TuplesKt.to("_param_for_special", "micro_app");
        if (r11 == false) goto L16;
        String r3 = "in_live";
    L17:
        r2[1] = TuplesKt.to("live_status", r3);
        Map r4 = MapsKt.mutableMapOf(r2);
        Object[] r5 = new Object[1];
        if (r11 == false) goto L20;
        Class<Room> r12 = Room.class;
    L21:
        r5[0] = r12;
        r1.e("mp_live_bind_landing_page_banner_show", r4, r5);
        return;
    L20:
        r12 = null;
        goto L21
    L16:
        r3 = "before_live";
        goto L17
    L30:
        return;
    L7:
        ((SimpleCarouselViewPager) this.a.T90(2131363959)).setEnableAutoCarousel(true);
        ((SimpleCarouselViewPager) this.a.T90(2131363959)).setEnableInfiniteCarousel(true);
        goto L8
    L23:
        if ((r8 instanceof a.C0143a) == false) goto L25;
    L26:
        ((FrameLayout) this.a.T90(2131363960)).setVisibility(8);
        BannerAdapter r13 = this.a.m;
        if (r13 == null) goto L33;
        List r6 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r6, "newBannerList");
        r13.a = new ArrayList(r6);
        r13.notifyDataSetChanged();
        return;
    L33:
        return;
    L25:
        if (Intrinsics.areEqual(r8, a.b.a) == true) goto L26;
    }
}
