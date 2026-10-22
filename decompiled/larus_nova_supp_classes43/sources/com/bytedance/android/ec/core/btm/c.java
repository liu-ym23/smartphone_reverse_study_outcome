package com.bytedance.android.ec.core.btm;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.model.order.IOrderSchema;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final a h(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$buildBTMFields");
        Object r1 = r10.get("btm_code");
        Object r11 = null;
        if ((r1 instanceof String) == true) goto L5;
        r1 = null;
    L5:
        String r12 = (String) r1;
        Object r13 = r10.get("bcm_context");
        if ((r13 instanceof Map) == false) goto L10;
        r11 = r13;
    L10:
        return new a(r12, (Map) r11);
    }

    public static final String d(String r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$appendBtmToken");
        if (a2.d(r10) != null) goto L5;
        return r1;
    L5:
        return p0.g(r1, "source_btm_token", r10);
    }

    public static void g(IOrderSchema r10, PageFinder r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$appendBtmTokenWithPageFinder");
        Intrinsics.checkNotNullParameter(r11, "pageFinder");
        String r12 = a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken("a1.b5267.c7323.d7439", r11, null));
        if (r12 == null) goto L6;
        r10.replaceOrAppendParam("source_btm_token", r12);
        return;
    }

    public static final String i(View r10, Pair... r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        MapsKt.putAll(r0, SequencesKt.filterNotNull(ArraysKt.asSequence(r11)));
        BcmParams.Companion.getClass();
        BcmParams r12 = BcmParams.a.c(r0);
        return a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken("a1.b8094.c7963.d2435", PageFinder.via(r10), r12));
    }

    public static final Uri a(Uri r10, View r11, a r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$appendBtmToken");
        if (r12 != null) goto L5;
        return r10;
    L5:
        if (r12.b() == null) goto L16;
        BtmSDK r0 = BtmSDK.INSTANCE;
        String r1 = r12.b();
        PageFinder r13 = PageFinder.via(r11);
        BcmParams.a r14 = BcmParams.Companion;
        Map<String, Object> r15 = r12.a();
        r14.getClass();
        String r16 = a2.d(r0.createJumpSourceBtmToken(r1, r13, BcmParams.a.c(r15)));
        if (r16 == null) goto L15;
        Uri r17 = p0.e(r10, "source_btm_token", r16);
        if (r17 != null) goto L13;
        return r10;
    L13:
        return r17;
    L15:
        return r10;
    L16:
        return r10;
    }

    public static final void e(IOrderSchema r10, View r11, Pair... r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$appendBtmToken");
        Intrinsics.checkNotNullParameter(r12, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        MapsKt.putAll(r0, SequencesKt.filterNotNull(ArraysKt.asSequence(r12)));
        BcmParams.Companion.getClass();
        BcmParams r13 = BcmParams.a.c(r0);
        String r14 = a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken("a1.b5267.c7323.d7439", PageFinder.via(r11), r13));
        if (r14 == null) goto L6;
        r10.replaceOrAppendParam("source_btm_token", r14);
        return;
    }

    public static String f(String r10, PageFinder r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$appendBtmTokenWithPageFinder");
        Intrinsics.checkNotNullParameter(r11, "pageFinder");
        String r13 = a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken(r12, r11, null));
        if (r13 == null) goto L9;
        String r14 = d(r10, r13);
        if (r14 != null) goto L8;
        return r10;
    L8:
        return r14;
    L9:
        return r10;
    }

    public static final String b(String r1, View r10, String r11, BcmParams r12) {
        Intrinsics.checkNotNullParameter(r1, "$this$appendBtmToken");
        Intrinsics.checkNotNullParameter(r12, "bcmParams");
        if (r11 != null) goto L5;
        return r1;
    L5:
        String r13 = a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken(r11, PageFinder.via(r10), r12));
        if (r13 == null) goto L12;
        String r14 = d(r1, r13);
        if (r14 != null) goto L11;
        return r1;
    L11:
        return r14;
    L12:
        return r1;
    }

    public static final String c(String r1, View r10, String r11, Pair<String, ? extends Object>... r12) {
        Intrinsics.checkNotNullParameter(r1, "$this$appendBtmToken");
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r11 != null) goto L5;
        return r1;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        MapsKt.putAll(r0, SequencesKt.filterNotNull(ArraysKt.asSequence(r12)));
        BcmParams.Companion.getClass();
        BcmParams r13 = BcmParams.a.c(r0);
        String r14 = a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken(r11, PageFinder.via(r10), r13));
        if (r14 == null) goto L12;
        String r15 = d(r1, r14);
        if (r15 != null) goto L11;
        return r1;
    L11:
        return r15;
    L12:
        return r1;
    }
}
