package com.larus.extension.summary_card.impl.component;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.message.TextContent;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.IFlowMessageService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ic8.w;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wc9.e;
import yc9.f0;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ SummaryCardComponentFeature a;
    public final /* synthetic */ String b;

    public /* synthetic */ c(SummaryCardComponentFeature r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r10) {
        SummaryCardComponentFeature r0 = this.a;
        String r1 = this.b;
        w r11 = (w) r10;
        int r2 = SummaryCardComponentFeature.l;
        Intrinsics.checkNotNullParameter(r11, "strategy");
        IFlowMessageService r3 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
        Object r4 = null;
        if (r3 == null) goto L12;
        y r5 = (y) r0.i.getValue();
        if (r5 == null) goto L10;
        e r6 = r5.h();
        if (r6 == null) goto L10;
        String r7 = r6.a;
        if (r7 == null) goto L10;
    L11:
        f0 r12 = r3.c(r11, r7, null);
    L13:
        if (r12 == null) goto L15;
        Map r8 = r12.r;
    L16:
        r0.getClass();
        boolean r9 = false;
        if (r8 != null) goto L20;
    L24:
        boolean r13 = false;
    L26:
        if (r13 == false) goto L65;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L55
        h r15 = h.a;     // Catch: Throwable -> L55
        if (r12 == null) goto L30;
        String r16 = r12.f;     // Catch: Throwable -> L55
    L31:
        if (r16 != null) goto L33;
    L36:
        boolean r17 = true;
    L37:
        if (r17 == false) goto L66;
    L48:
        Object r18 = null;
    L49:
        TextContent r19 = (TextContent) r18;     // Catch: Throwable -> L55
        if (r19 == null) goto L52;
        String r110 = r19.text;     // Catch: Throwable -> L55
    L53:
        Object r111 = Result.constructor-impl(r110);     // Catch: Throwable -> L55
    L58:
        if (Result.isFailure-impl(r111) == true) goto L62;
        r4 = r111;
    L62:
        if (Intrinsics.areEqual(r4, r1) == false) goto L65;
        r9 = true;
        goto L65
    L52:
        r110 = null;
        goto L53
    L66:
        r15.getClass();     // Catch: Throwable -> L41
        r18 = Result.constructor-impl(h.b.fromJson(r16, new SummaryCardComponentFeature$c().getType()));     // Catch: Throwable -> L41
    L43:
        Throwable r20 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L55
        if (r20 == null) goto L47;
        c0 r21 = c0.b;     // Catch: Throwable -> L55
        StringBuilder r22 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L55
        Intrinsics.checkNotNullParameter(r20, "<this>");     // Catch: Throwable -> L55
        r22.append(ExceptionsKt.stackTraceToString(r20));     // Catch: Throwable -> L55
        r21.e("GsonHolder", r22.toString());     // Catch: Throwable -> L55
    L47:
        if (Result.isFailure-impl(r18) == false) goto L49;
    L41:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L55
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L55
        goto L43
    L33:
        if (StringsKt.isBlank(r16) == true) goto L36;
        r17 = false;
        goto L37
    L30:
        r16 = null;
    L55:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
    L65:
        return Boolean.valueOf(r9);
    L20:
        if (Intrinsics.areEqual(r8.get("from_video_suggest"), "1") == false) goto L22;
    L25:
        r13 = true;
        goto L26
    L22:
        if (Intrinsics.areEqual(r8.get("send_message_scene"), "related_video_suggested_prompt") == false) goto L24;
    L15:
        r8 = null;
    L10:
        r7 = "";
        goto L11
    L12:
        r12 = null;
        goto L13
    }
}
