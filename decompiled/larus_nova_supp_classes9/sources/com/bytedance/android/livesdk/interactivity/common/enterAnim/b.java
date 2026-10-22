package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.content.Context;
import android.graphics.Typeface;
import com.bytedance.android.live.base.model.message.g4;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.CombinedTextRenderView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.DisplayImageListView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.DisplayTextView;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements WindScreenCombinedAnimTrayView.c {
    public static final a a = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean a(g4 r2) {
            Intrinsics.checkNotNullParameter(r2, "$this$isEcomAdvancedOrderStat");
            if (Intrinsics.areEqual(r2.getScene(), "ecom_advanced_order_stat_single") == false) goto L5;
        L10:
            return true;
        L5:
            if (Intrinsics.areEqual(r2.getScene(), "ecom_advanced_order_stat_group") == true) goto L10;
            if (Intrinsics.areEqual(r2.getScene(), "local_life_recommend_product_card") == true) goto L10;
            return false;
        }
    }

    public b() {
    }

    static {
        a = new a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.WindScreenCombinedAnimTrayView.c
    public final CombinedTextRenderView.a a(CombinedTextRenderView.a r7, g4 r8) {
        Intrinsics.checkNotNullParameter(r7, "config");
        Typeface r0 = null;
        if (r8 == null) goto L5;
        String r1 = r8.getScene();
    L7:
        if (Intrinsics.areEqual(r1, "traffic_strategy") == false) goto L9;
        r7.a.c = 0;
    L22:
        return r7;
    L9:
        if (r8 == null) goto L21;
        a.getClass();
        if (a.a(r8) != true) goto L21;
        r7.a.a = UtilityKotlinExtentionsKt.h(14);
        r7.a.b = Float.valueOf(UtilityKotlinExtentionsKt.h(15));
        DisplayTextView.a r9 = r7.a;
        r9.j = true;
        ConcurrentHashMap<String, com.bytedance.android.livesdk.interactivity.common.utils.a> r3 = com.bytedance.android.livesdk.interactivity.common.utils.e.a;
        Context r4 = s1.getContext();
        Intrinsics.checkNotNullParameter(r4, "context");
        com.bytedance.android.livesdk.interactivity.common.utils.a r5 = com.bytedance.android.livesdk.interactivity.common.utils.e.a.get("fonts/douyin_number_abc_bold.otf");
        if (r5 == null) goto L23;
        r0 = r5.a;
    L20:
        r9.k = r0;
        r7.b.a = UtilityKotlinExtentionsKt.i(22);
        r7.b.b = UtilityKotlinExtentionsKt.i(22);
        DisplayImageListView.a r10 = r7.b;
        r10.c = false;
        r10.d = UtilityKotlinExtentionsKt.h(6);
        r7.b.e = s1.m(2131250228);
        r7.b.f = true;
        goto L22
    L23:
        r0 = Typeface.createFromAsset(r4.getAssets(), "fonts/douyin_number_abc_bold.otf");     // Catch: Throwable -> L17
    L19:
        com.bytedance.android.livesdk.interactivity.common.utils.e.a.put("fonts/douyin_number_abc_bold.otf", new com.bytedance.android.livesdk.interactivity.common.utils.a(r0));
    L17:
        th = move-exception;
        th.printStackTrace();
    L21:
        r7.a.c = null;
        goto L22
    L5:
        r1 = null;
        goto L7
    }
}
