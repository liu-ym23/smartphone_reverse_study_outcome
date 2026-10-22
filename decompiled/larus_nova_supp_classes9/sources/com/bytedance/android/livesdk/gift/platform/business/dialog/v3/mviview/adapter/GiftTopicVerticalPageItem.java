package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.TopicPagerListData;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftTopicVerticalPageItem extends BaseGiftPagerItem<TopicPagerListData> {
    public final void k(com.bytedance.android.anya.dsl.a<TopicPagerListData, GiftAction> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$registerListAdapters");
        r5.a(GiftTopicVerticalPageItem$registerListAdapters$1.INSTANCE, new GiftTopicVerticalPageItem$registerListAdapters$2(this), this.y, new GiftTopicVerticalPageItem$registerListAdapters$3(this));
    }

    public final void b(com.bytedance.android.anya.k r7, MVIState r8) {
        TopicPagerListData r9 = (TopicPagerListData) r8;
        Intrinsics.checkNotNullParameter(r7, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r9, "state");
        r0<TopicPagerListData, Boolean> r0 = r9.getVisibility();
        Object r1 = r7.c.a(r0);
        if (r1 == null) goto L8;
        r7.b.a.invoke(r0);
        if (((Boolean) r1).booleanValue() == false) goto L7;
        ((com.bytedance.android.anya.c) this).k.setVisibility(0);
        goto L8
    L7:
        ((com.bytedance.android.anya.c) this).k.setVisibility(8);
    L8:
        t0<TopicPagerListData, ItemListData> r2 = r9.getItemDataList();
        Object r3 = r7.c.a(r2);
        if (r3 == null) goto L14;
        r7.b.a.invoke(r2);
        if (((s0) r3).isEmpty() == false) goto L13;
        t();
        goto L14
    L13:
        v();
    L14:
        r0<TopicPagerListData, Integer> r4 = r9.getTopicId();
        Object r5 = r7.c.a(r4);
        if (r5 == null) goto L20;
        r7.b.a.invoke(r4);
        long r6 = ((Number) r5).intValue();
        long r10 = this.C;
        if (r6 == r10) goto L19;
        this.D.put(Long.valueOf(r10), new IntRange(-1, -1));
    L19:
        this.C = r6;
    L20:
        r0<TopicPagerListData, Integer> r11 = r9.getTabType();
        Object r13 = r7.c.a(r11);
        if (r13 == null) goto L23;
        r7.b.a.invoke(r11);
        int r14 = ((Number) r13).intValue();
        u(r14);
        this.l = r14;
    L23:
        r0<TopicPagerListData, Boolean> r15 = r9.getHasMoreData();
        Object r16 = r7.c.a(r15);
        if (r16 == null) goto L27;
        r7.b.a.invoke(r15);
        this.m = ((Boolean) r16).booleanValue();
        return;
    }

    public GiftTopicVerticalPageItem(ViewGroup r2, int r3, int r4, Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r5, "animationFun");
        super(r2, r3, r4, r5);
    }
}
