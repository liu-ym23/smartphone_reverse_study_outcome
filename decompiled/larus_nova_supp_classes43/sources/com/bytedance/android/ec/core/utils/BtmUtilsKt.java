package com.bytedance.android.ec.core.utils;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BtmUtilsKt {
    public static final JSONObject f(kc.a r15) {
        String r0 = null;
        if (r15 != null) goto L6;
        return null;
    L6:
        if (r15.a.size() > 0) goto L8;
        return null;
    L8:
        kc.a.C0174a r1 = (kc.a.C0174a) CollectionsKt.getOrNull(r15.a, 0);
        kc.a.C0174a r10 = (kc.a.C0174a) CollectionsKt.getOrNull(r15.a, 1);
        kc.a.C0174a r11 = (kc.a.C0174a) CollectionsKt.getOrNull(r15.a, 2);
        List r16 = CollectionsKt.reversed(r15.a);
        JSONObject r12 = new JSONObject();
        List r17 = r16;
        r12.put("btm", CollectionsKt.joinToString$default(r17, ",", null, null, 0, null, BtmUtilsKt$getBtmChain$btmChain$1$1.INSTANCE, 30, null));
        r12.put("btm_show_id", CollectionsKt.joinToString$default(r17, ",", null, null, 0, null, BtmUtilsKt$getBtmChain$btmChain$1$2.INSTANCE, 30, null));
        JSONObject r18 = new JSONObject();
        if (r1 == null) goto L11;
        String r13 = r1.c;
    L12:
        String r14 = "";
        if (r13 != null) goto L15;
        r13 = "";
    L15:
        r18.put("btm", r13);
        r18.put("btm_chain", r12);
        if (r11 == null) goto L18;
        String r19 = r11.c;
    L19:
        if (r19 != null) goto L21;
        r19 = "";
    L21:
        r18.put("btm_ppre", r19);
        if (r10 == null) goto L24;
        String r20 = r10.c;
    L25:
        if (r20 != null) goto L27;
        r20 = "";
    L27:
        r18.put("btm_pre", r20);
        if (r1 == null) goto L30;
        r0 = r1.e;
    L30:
        if (r0 == null) goto L33;
        r14 = r0;
    L33:
        r18.put("btm_show_id", r14);
        return r18;
    L24:
        r20 = null;
        goto L25
    L18:
        r19 = null;
        goto L19
    L11:
        r13 = null;
        goto L12
    }

    public static final List<String> g(kc.a r10) {
        if (r10 == null) goto L12;
        List<kc.a.C0174a> r11 = r10.a;
        if (r11 == null) goto L12;
        List<kc.a.C0174a> r12 = r11;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
    L7:
        if (r13.hasNext() == false) goto L17;
        String r1 = ((kc.a.C0174a) r13.next()).c;
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        r0.add(r1);
        goto L7
    L17:
        return r0;
    L12:
        return null;
    }

    public static final com.bytedance.android.bst.api.d h(com.bytedance.android.bst.api.e r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$safeBuild");
        return r1.a();
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r1.a = "c0.d0";
        return r1.a();
    }

    public static final com.bytedance.android.btm.api.model.d a(com.bytedance.android.btm.api.model.d r1, Map<String, ? extends Object> r10) {
        if (r1 != null) goto L4;
        return r1;
    L4:
        if (r10 != null) goto L7;
        return r1;
    L7:
        if (r1.c != null) goto L9;
        r1.c = new BcmParams();
    L9:
        BcmParams r0 = r1.c;
        if (r0 == null) goto L12;
        BcmParams r11 = r0.merge(r10);
    L13:
        r1.c = r11;
        return r1;
    L12:
        r11 = null;
        goto L13
    }

    public static final String b(String r10, com.bytedance.android.btm.api.model.d r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$appendSourceBtmToken");
        UrlBuilderV2 r0 = new UrlBuilderV2(r10);
        if (r11 == null) goto L8;
        String r12 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r11);
        if (r12 == null) goto L9;
        r0.addOrReplaceParam("source_btm_token", r12);
        return r0.build();
    L9:
        return r10;
    L8:
        return r10;
    }

    public static final void c(UrlBuilderV2 r1, com.bytedance.android.btm.api.model.d r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$appendSourceBtmToken");
        if (r10 == null) goto L8;
        String r11 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r10);
        if (r11 == null) goto L9;
        r1.addOrReplaceParam("source_btm_token", r11);
        return;
    L9:
        return;
    }

    public static final com.bytedance.android.btm.api.model.d e(String r1, PageFinder r10) {
        com.bytedance.android.btm.api.model.d r0 = new com.bytedance.android.btm.api.model.d();
        if (r1 == null) goto L5;
        r0.a = r1;
    L5:
        if (r10 == null) goto L7;
        r0.b = PageFinder.via(BtmSDK.INSTANCE.getPageId(r10));
    L7:
        return r0;
    }

    public static final com.bytedance.android.btm.api.model.d d(String r1, BcmParams r10, PageFinder r11) {
        com.bytedance.android.btm.api.model.d r0 = new com.bytedance.android.btm.api.model.d();
        if (r1 == null) goto L5;
        r0.a = r1;
    L5:
        if (r11 == null) goto L7;
        r0.b = PageFinder.via(BtmSDK.INSTANCE.getPageId(r11));
    L7:
        if (r10 == null) goto L9;
        r0.c = r10;
    L9:
        return r0;
    }
}
