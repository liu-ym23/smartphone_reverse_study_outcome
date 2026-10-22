package com.bytedance.android.anniex.utils;

import android.net.Uri;
import com.bytedance.android.anniex.engine.AnnieXLynxEngine;
import com.bytedance.anniex.bd.foundation.impl.u;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.salamander.anniex.l7;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.b2;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static final void e(AnnieXLynxEngine r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Map r12 = com.bytedance.android.anniex.monitor.salamander.c.a.a(r11).v();
        b2 r0 = new b2();
        LinkedHashMap r13 = (LinkedHashMap) r12;
        Long r1 = (Long) r13.get("open_time");
        if (r1 == null) goto L5;
        r0.a = r1.longValue();
    L5:
        Long r14 = (Long) r13.get("container_init_start");
        if (r14 == null) goto L8;
        r0.b = r14.longValue();
    L8:
        Long r15 = (Long) r13.get("container_init_end");
        if (r15 == null) goto L11;
        r0.c = r15.longValue();
    L11:
        Long r16 = (Long) r13.get("prepare_template_start");
        if (r16 == null) goto L14;
        r0.d = r16.longValue();
    L14:
        Long r17 = (Long) r13.get("prepare_template_end");
        if (r17 == null) goto L17;
        r0.e = r17.longValue();
    L17:
        LynxTemplateRender r18 = r10.b;
        if ((r18 instanceof LynxTemplateRender) == true) goto L21;
        r18 = null;
    L21:
        if (r18 == null) goto L24;
        r18.setExtraTiming(r0);
        return;
    }

    public static /* synthetic */ void b(LynxView r10, String r11, String r12) {
        a(r10, r11, r12, null, null, null);
    }

    public static final void d(LynxView r1, String r10, JavaOnlyArray r11) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "params");
        if (r1.enableJSRuntime() == false) goto L5;
        r1.sendGlobalEvent(r10, r11);
        return;
    L5:
        r1.triggerEventBus(r10, r11);
    }

    public static final void c(LynxView r10, String r11, String r12, String r13, Long r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        if (r12 != null) goto L5;
    L8:
        boolean r15 = true;
    L9:
        String r16 = null;
        if (r15 == false) goto L32;
        if (r13 != null) goto L13;
    L16:
        boolean r17 = true;
    L17:
        if (r17 == false) goto L32;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L26
        Uri r19 = UriProtector.parse(r11);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r19, "<this>");     // Catch: Throwable -> L26
        String r20 = a36.b.e(r19, "channel");     // Catch: Throwable -> L26
        if (r20 != null) goto L21;
        r20 = a36.b.e(r19, "gecko_channel");     // Catch: Throwable -> L26
    L21:
        String r0 = a36.b.e(r19, "bundle");     // Catch: Throwable -> L26
        if (r0 != null) goto L24;
        r0 = a36.b.e(r19, "gecko_bundle");     // Catch: Throwable -> L26
    L24:
        Object r21 = Result.constructor-impl(TuplesKt.to(r20, r0));     // Catch: Throwable -> L26
    L28:
        Pair r22 = TuplesKt.to(null, null);
        if (Result.isFailure-impl(r21) == false) goto L31;
        r21 = r22;
    L31:
        Pair r23 = (Pair) r21;
    L33:
        String r24 = (String) r23.component1();
        String r25 = (String) r23.component2();
        int r1 = l7.a;
        if (r24 != null) goto L36;
    L41:
        if (r11 != null) goto L43;
    L78:
        String r26 = "unknown";
    L79:
        Map r27 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, r26)});
        r27.put("container_name", "Anniex");
        r27.put("container_sdk_version", "10.4.0");
        r27.put(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r11);
        if (r14 == null) goto L82;
        r27.put("res_version", Long.valueOf(r14.longValue()));
    L82:
        r10.putParamsForReportingEvents(r27);
        return;
    L43:
        if (Intrinsics.areEqual(r11, "") == true) goto L78;
        int r28 = u.c;
        u r29 = u.a.a(r11);
        if (r29 == null) goto L78;
        Intrinsics.checkNotNullParameter(r29, "schemaUri");
        Uri r30 = r29.a;
        if (r30 == null) goto L51;
        String r31 = r30.getScheme();
    L53:
        if (Intrinsics.areEqual(r31, "http") == false) goto L55;
    L74:
        r29.a();
        r26 = r29.e();
    L76:
        if (Intrinsics.areEqual(r26, "") == true) goto L78;
    L55:
        if (Intrinsics.areEqual(r31, "https") == true) goto L74;
        if (r29.c("a_surl") == null) goto L61;
        r16 = r29.c("a_surl");
        Intrinsics.checkNotNull(r16);
    L66:
        if (r16 != null) goto L68;
    L73:
        r26 = "";
        goto L76
    L68:
        if (Intrinsics.areEqual(r16, "") == true) goto L73;
        u r32 = u.a.a(r16);
        if (r32 == null) goto L73;
        r32.a();
        r26 = r32.e();
        goto L76
    L61:
        if (r29.c("surl") == null) goto L64;
        r16 = r29.c("surl");
        Intrinsics.checkNotNull(r16);
        goto L66
    L64:
        if (r29.c(com.bytedance.android.ec.core.event.a.KEY_URL) == null) goto L66;
        r16 = r29.c(com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNull(r16);
        goto L66
    L51:
        r31 = null;
        goto L53
    L36:
        if (Intrinsics.areEqual(r24, "") == true) goto L41;
        if (r25 == null) goto L41;
        if (Intrinsics.areEqual(r25, "") == true) goto L41;
        r26 = r24 + '/' + r25;
    L26:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L13:
        if (StringsKt.isBlank(r13) == true) goto L16;
        r17 = false;
    L32:
        r23 = TuplesKt.to(r12, r13);
        goto L33
    L5:
        if (StringsKt.isBlank(r12) == true) goto L8;
        r15 = false;
        goto L9
    }

    public static final void a(LynxView r10, String r11, String r12, String r13, String r14, Long r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        r10.setExtraTiming(com.bytedance.android.anniex.monitor.salamander.c.a.a(r11).v());
        c(r10, r12, r13, r14, r15);
    }
}
