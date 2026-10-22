package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.s0;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftVerticalPageItem extends BaseGiftPagerItem<PagerListData> {
    public final void k(com.bytedance.android.anya.dsl.a<PagerListData, GiftAction> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$registerListAdapters");
        r5.a(GiftVerticalPageItem$registerListAdapters$1.INSTANCE, new GiftVerticalPageItem$registerListAdapters$2(this), this.y, new GiftVerticalPageItem$registerListAdapters$3(this));
    }

    public final void b(com.bytedance.android.anya.k r7, MVIState r8) {
        PagerListData r9 = (PagerListData) r8;
        Intrinsics.checkNotNullParameter(r7, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r9, "state");
        r0<PagerListData, Long> r0 = r9.getSelectedTopicId();
        Object r1 = r7.c.a(r0);
        if (r1 == null) goto L8;
        r7.b.a.invoke(r0);
        long r2 = ((Number) r1).longValue();
        long r3 = this.C;
        if (r2 == r3) goto L7;
        this.D.put(Long.valueOf(r3), new IntRange(-1, -1));
    L7:
        this.C = r2;
    L8:
        com.bytedance.android.anya.internal.c r4 = r9.getHasHeader();
        com.bytedance.android.anya.internal.c r5 = r9.getItemDataList();
        Object r6 = r7.c.a(r4);
        Object r10 = null;
        if (r6 == null) goto L11;
        r7.b.a.invoke(r4);
    L12:
        Object r11 = r7.c.a(r5);
        if (r11 == null) goto L15;
        r7.b.a.invoke(r5);
        r10 = r11;
    L15:
        if (r6 != null) goto L17;
        if (r10 != null) goto L17;
    L54:
        r0<PagerListData, Boolean> r13 = r9.getHasMoreData();
        Object r14 = r7.c.a(r13);
        if (r14 == null) goto L57;
        r7.b.a.invoke(r13);
        this.m = ((Boolean) r14).booleanValue();
        this.y.invalidateItemDecorations();
    L57:
        r0<PagerListData, Integer> r15 = r9.getTabType();
        Object r16 = r7.c.a(r15);
        if (r16 == null) goto L60;
        r7.b.a.invoke(r15);
        int r17 = ((Number) r16).intValue();
        u(r17);
        this.l = r17;
    L60:
        r0<PagerListData, String> r18 = r9.getEmptyListDescription();
        Object r19 = r7.c.a(r18);
        if (r19 == null) goto L66;
        r7.b.a.invoke(r18);
        String r20 = (String) r19;
        TextView r21 = this.A;
        if (r21 == null) goto L67;
        r21.setText(r20);
        return;
    L67:
        return;
    L66:
        return;
    L17:
        if (r6 != null) goto L19;
        r6 = r4.c();
    L19:
        if (r10 != null) goto L21;
        r10 = r5.c();
    L21:
        s0 r23 = (s0) r10;
        boolean r24 = ((Boolean) r6).booleanValue();
        this.w = r24;
        int r25 = 0;
        if (r24 == false) goto L38;
        if (r23.size() <= 1) goto L26;
        v();
    L42:
        boolean r26 = false;
    L44:
        if (s() == false) goto L54;
        boolean r27 = true ^ r26;
        FirstRowTopPaddingDecoration r28 = this.x;
        if (r28.a == r24) goto L48;
    L49:
        r28.a = r24;
        if (r24 == true) goto L53;
        r25 = 3;
    L53:
        r28.c = r25;
        r28.b = r27;
        this.y.invalidateItemDecorations();
        goto L54
    L48:
        if (r28.b == r27) goto L54;
    L26:
        this.y.setVisibility(0);
        ImageView r29 = this.z;
        if (r29 == null) goto L29;
        r29.setVisibility(0);
    L29:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0 r30 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.d;
        r30.getClass();
        if (((com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.f0) com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.b.getValue(r30, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.a[0])).c() == false) goto L34;
        int r31 = ((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_LIST_EMPTY_ICON, 2131250536)).intValue();
        ImageView r33 = this.z;
        if (r33 == null) goto L34;
        r33.setImageResource(r31);
    L34:
        TextView r34 = this.A;
        if (r34 == null) goto L40;
        r34.setVisibility(0);
    L40:
        r26 = true;
        goto L44
    L38:
        if (r23.isEmpty() == false) goto L41;
        t();
        goto L40
    L41:
        v();
        goto L42
    L11:
        r6 = null;
        goto L12
    }

    public GiftVerticalPageItem(ViewGroup r2, int r3, Function0<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r4, "animationFun");
        super(r2, r3, -1, r4);
    }
}
