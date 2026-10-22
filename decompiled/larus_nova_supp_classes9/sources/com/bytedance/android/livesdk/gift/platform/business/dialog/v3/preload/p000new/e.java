package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelPreloadView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPreloadSettingsKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.d;
import com.bytedance.android.livesdk.gift.platform.business.i;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelMonitorService;
import i12.m;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import jy0.b;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements k<View> {
    public final b a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final d e;
    public boolean f;
    public final j g;

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final void clear() {
        this.a.a.clear();
    }

    public final void g() {
        if (this.b == false) goto L5;
        int r0 = 2;
    L6:
        b r2 = this.a;
        r2.getClass();
        b.a r3 = new b.a(r2);
        r3.a(GiftPanelPreloadView.GiftOnlineReceiverView, 1);
        r3.a(GiftPanelPreloadView.GiftOnlineReceiverViewOld, 1);
        r3.a(GiftPanelPreloadView.GiftComboView, r0);
        r3.a(GiftPanelPreloadView.ComboViewOpt, r0);
        r3.a(GiftPanelPreloadView.GiftVerticalListView, 1);
        r3.a(GiftPanelPreloadView.GiftTabView, 1);
        r3.a(GiftPanelPreloadView.GiftGroupTopView, 1);
        f(r3);
        r3.a(GiftPanelPreloadView.VerticalPageItem, this.e.i());
        r3.a(GiftPanelPreloadView.TabViewHolder, 6);
        if (this.b == false) goto L9;
        r3.a(GiftPanelPreloadView.GiftSearchView, 1);
    L9:
        r3.a(GiftPanelPreloadView.GridViewHolderItem, this.e.f());
        e(r3);
        r3.a(GiftPanelPreloadView.SendGiftView, 1);
        r3.b();
        return;
    L5:
        r0 = 1;
        goto L6
    }

    public final void h() {
        if (this.b == false) goto L5;
        int r0 = 2;
    L6:
        b r3 = this.a;
        r3.getClass();
        b.a r4 = new b.a(r3);
        r4.a(GiftPanelPreloadView.GiftOnlineReceiverView, 1);
        r4.a(GiftPanelPreloadView.GiftOnlineReceiverViewOld, 1);
        r4.a(GiftPanelPreloadView.GiftComboView, r0);
        r4.a(GiftPanelPreloadView.ComboViewOpt, r0);
        r4.a(GiftPanelPreloadView.GiftVerticalListView, 1);
        r4.a(GiftPanelPreloadView.GiftTabView, 1);
        r4.a(GiftPanelPreloadView.GiftGroupTopView, 1);
        f(r4);
        if (this.b == false) goto L9;
        r4.a(GiftPanelPreloadView.GiftSearchView, 1);
    L9:
        r4.a(GiftPanelPreloadView.VerticalPageItem, 2);
        e(r4);
        r4.b();
        return;
    L5:
        r0 = 1;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final GiftPreloadResType a() {
        return GiftPreloadResType.GIFT_PANEL_VIEW;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final void b(h r4) {
        Intrinsics.checkNotNullParameter(r4, "trigger");
        this.f = true;
        if ((r4 instanceof h.f) == false) goto L6;
        h();
    L38:
        this.f = false;
        return;
    L6:
        if ((r4 instanceof h.i) == false) goto L9;
        g();
        goto L38
    L9:
        if ((r4 instanceof h.g) == false) goto L12;
        g();
        goto L38
    L12:
        if ((r4 instanceof h.c) == false) goto L14;
        h();
        goto L38
    L14:
        int r2 = 12;
        if ((r4 instanceof h.e) == false) goto L27;
        GiftPanelMonitorService.b r5 = ((h.e) r4).a;
        if (r5 == null) goto L38;
        if (r5.d > 0) goto L25;
        int r6 = r5.c;
        if (r6 <= 1) goto L38;
        r2 = Math.min(12, r6 * 4);
    L25:
        b r7 = this.a;
        r7.getClass();
        b.a r0 = new b.a(r7);
        r0.a(GiftPanelPreloadView.GridViewHolderItem, r2);
        r0.b();
        goto L38
    L27:
        if ((r4 instanceof h.C0045h) == false) goto L30;
        b r8 = this.a;
        r8.getClass();
        b.a r1 = new b.a(r8);
        r1.a(GiftPanelPreloadView.GridViewHolderItem, 12);
        r1.b();
        goto L38
    L30:
        if ((r4 instanceof h.a) == false) goto L33;
        b r9 = this.a;
        r9.getClass();
        b.a r3 = new b.a(r9);
        r3.a(GiftPanelPreloadView.GridViewHolderItem, 12);
        r3.b();
        goto L38
    L33:
        if ((r4 instanceof h.d) == false) goto L36;
        g();
        goto L38
    L36:
        if ((r4 instanceof h.b) == false) goto L38;
        b r10 = this.a;
        r10.getClass();
        b.a r11 = new b.a(r10);
        r11.a(GiftPanelPreloadView.SendGiftView, 1);
        r11.b();
        goto L38
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final boolean c(h r5) {
        Intrinsics.checkNotNullParameter(r5, "trigger");
        if (this.f == false) goto L7;
        b.c("ttlive_gift_preload_new", "view preloading is in progress, skip", null, 4);
        return false;
    L7:
        if ((r5 instanceof h.f) == false) goto L10;
        return this.g.a();
    L10:
        if ((r5 instanceof h.i) == false) goto L13;
    L37:
        return true;
    L13:
        if ((r5 instanceof h.g) == true) goto L37;
        if ((r5 instanceof h.c) == true) goto L37;
        if ((r5 instanceof h.d) == false) goto L22;
        return this.e.c();
    L22:
        if ((r5 instanceof h.e) == false) goto L25;
        return this.e.d();
    L25:
        if ((r5 instanceof h.C0045h) == false) goto L32;
        if (((h.C0045h) r5).a == true) goto L29;
        return false;
    L29:
        if (this.e.e() == true) goto L37;
        return false;
    L32:
        if ((r5 instanceof h.a) == false) goto L37;
        if (this.e.b() == true) goto L36;
        return false;
    L36:
        if (((h.a) r5).a <= 3) goto L37;
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final View d(f r5) {
        Intrinsics.checkNotNullParameter(r5, "cacheKey");
        Object r6 = r5.a;
        if (r6 == null) goto L35;
        int r7 = ((Integer) r6).intValue();
        b r0 = this.a;
        Map<Integer, GiftPanelPreloadView> r1 = r0.b;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        GiftPanelPreloadView r8 = (GiftPanelPreloadView) r2.get(Integer.valueOf(r7));
        Object r3 = null;
        if (r8 == null) goto L15;
        LinkedList<View> r4 = r0.a.get(r8);
        if (r4 != null) goto L9;
    L12:
        boolean r9 = true;
    L13:
        if (r9 == true) goto L15;
        Pair r10 = TuplesKt.to(r4.poll(), r8);
    L16:
        View r11 = (View) r10.component1();
        GiftPanelPreloadView r13 = (GiftPanelPreloadView) r10.component2();
        if (r11 != null) goto L19;
        Objects.toString(r13);
    L33:
        return r11;
    L19:
        if (r13 != GiftPanelPreloadView.GiftSearchView) goto L23;
        if (this.b == false) goto L23;
    L26:
        i12.d r14 = m.e2.a();
        if (r14 == null) goto L29;
        r3 = com.bytedance.android.scope.m.e.d(r14, GiftPanelMonitorService.class);
    L29:
        GiftPanelMonitorService r15 = (GiftPanelMonitorService) r3;
        if (r15 == null) goto L33;
        r15.n = true;
    L23:
        if (r13 != GiftPanelPreloadView.VerticalPageItem) goto L33;
        if (this.b == true) goto L33;
    L9:
        if (r4.isEmpty() == true) goto L12;
        r9 = false;
    L15:
        r10 = TuplesKt.to(null, r8);
        goto L16
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void e(b.a r3) {
        if (v.h() == false) goto L6;
        r3.a(GiftPanelPreloadView.TopicViewPageItem, 1);
    L6:
        if (i.n().getEnable() == false) goto L9;
        r3.a(GiftPanelPreloadView.GiftMostlyUsedHeaderViewHolderItem, 1);
    L9:
        if (this.c == false) goto L12;
        r3.a(GiftPanelPreloadView.GiftDynamicPanel, 1);
        return;
    }

    public final void f(b.a r3) {
        if (this.d == true) goto L6;
        r3.a(GiftPanelPreloadView.GiftRechargeView, 1);
        r3.a(GiftPanelPreloadView.GiftMinorsNoticeView, 1);
    L6:
        if (this.c == true) goto L9;
        r3.a(GiftPanelPreloadView.GiftTopView, 1);
        r3.a(GiftPanelPreloadView.GiftActivityTopView, 1);
        r3.a(GiftPanelPreloadView.GiftCustomBarTopView, 1);
        r3.a(GiftPanelPreloadView.GiftDetailTopView, 1);
        r3.a(GiftPanelPreloadView.GiftDIYTopView, 1);
        r3.a(GiftPanelPreloadView.GiftLynxGrowthTouchView, 1);
        r3.a(GiftPanelPreloadView.GiftMarketingTopView, 1);
        r3.a(GiftPanelPreloadView.GiftSeriesTopView, 1);
        r3.a(GiftPanelPreloadView.GiftBuffCardTopView, 1);
        r3.a(GiftPanelPreloadView.GiftLynxCarnivalTopView, 1);
        return;
    }

    public e(Context r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "preloadContext");
        this.g = r3;
        this.a = new b(r2);
        this.b = v.c();
        this.c = v.a();
        this.d = v.e();
        this.e = GiftPreloadSettingsKt.a();
    }
}
