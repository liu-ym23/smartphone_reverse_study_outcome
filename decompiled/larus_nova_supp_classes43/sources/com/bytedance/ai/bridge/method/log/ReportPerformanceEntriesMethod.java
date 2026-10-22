package com.bytedance.ai.bridge.method.log;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import d3.a0;
import e3.d;
import f3.h;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l5.b;
import l5.c;
import l5.e;
import l5.i;
import l5.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/method/log/ReportPerformanceEntriesMethod;", "Lcom/bytedance/ai/bridge/method/log/AbsReportPerformanceEntriesMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/log/AbsReportPerformanceEntriesMethodIDL$ReportPerformanceEntriesParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/log/AbsReportPerformanceEntriesMethodIDL$ReportPerformanceEntriesResultModel;", "generateTraceId", "", "callbackId", "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportPerformanceEntriesMethod extends AbsReportPerformanceEntriesMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public ReportPerformanceEntriesMethod() {
    }

    public static String b(d r1, int r10) {
        StringBuilder r0 = new StringBuilder();
        a0 r11 = r1.getContainerContext();
        if (r11 == null) goto L5;
        String r12 = r11.getContainerId();
    L6:
        r0.append(r12);
        r0.append('_');
        r0.append(r10);
        return r0.toString();
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsReportPerformanceEntriesMethodIDL.a r13 = (AbsReportPerformanceEntriesMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        JsonArray r14 = r13.getEntries();
        ArrayList r0 = new ArrayList();
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L8;
        Object r1 = r15.next();
        if ((r1 instanceof JsonObject) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        Iterator r16 = r0.iterator();
    L10:
        if (r16.hasNext() == false) goto L85;
        JsonObject r17 = (JsonObject) r16.next();
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L14
        Object r19 = Result.constructor-impl(Integer.valueOf(r17.get("callbackId").getAsInt()));     // Catch: Throwable -> L14
    L16:
        Object r20 = null;
        if (Result.isFailure-impl(r19) == false) goto L19;
        r19 = null;
    L19:
        Integer r21 = (Integer) r19;
        if (r21 == null) goto L10;
        int r22 = r21.intValue();
        Object r23 = Result.constructor-impl(r17.get("type").getAsString());     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r23) == false) goto L29;
        r23 = null;
    L29:
        String r24 = (String) r23;
        if (r24 == null) goto L10;
        Object r25 = Result.constructor-impl(r17.get("perfRecord").getAsJsonObject());     // Catch: Throwable -> L34
    L37:
        if (Result.isFailure-impl(r25) == true) goto L40;
        r20 = r25;
    L40:
        JsonObject r26 = (JsonObject) r20;
        if (r26 == null) goto L10;
        int r27 = r24.hashCode();
        if (r27 != (-1154809878)) goto L46;
        if (r24.equals("OutGoingCall") == false) goto L10;
        final String r28 = b(r10, r22);
        final long r29 = r26.get("feSendCallTime").getAsLong();     // Catch: Throwable -> L80
        final long r30 = r26.get("feReceiveCallbackTime").getAsLong();     // Catch: Throwable -> L80
        w r31 = w.b;     // Catch: Throwable -> L80
        Intrinsics.checkNotNullParameter(r28, "traceId");     // Catch: Throwable -> L80
        w.m(new l5.h(r29, r28));     // Catch: Throwable -> L80
        Intrinsics.checkNotNullParameter(r28, "traceId");     // Catch: Throwable -> L80
        w.m(new e(r30, r28));     // Catch: Throwable -> L80
        Object r32 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L80
    L83:
        if (Result.isSuccess-impl(r32) == false) goto L10;
        Unit r33 = (Unit) r32;
        w r34 = w.b;
        final Function1 r35 = new a4.a(r28);
        Intrinsics.checkNotNullParameter(r28, "traceId");
        w.m(new b(r28, r35));
    L80:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L83
    L46:
        if (r27 != 329290724) goto L48;
        if (r24.equals("InComingCall") == false) goto L10;
        final String r37 = r10.c(r22);
        if (r37 == null) goto L10;
        final long r38 = r26.get("feReceiveCallTime").getAsLong();     // Catch: Throwable -> L69
        final long r39 = r26.get("feSendCallbackTime").getAsLong();     // Catch: Throwable -> L69
        w r40 = w.b;     // Catch: Throwable -> L69
        Intrinsics.checkNotNullParameter(r37, "traceId");     // Catch: Throwable -> L69
        w.m(new c(r38, r37));     // Catch: Throwable -> L69
        Intrinsics.checkNotNullParameter(r37, "traceId");     // Catch: Throwable -> L69
        w.m(new l5.d(r39, r37));     // Catch: Throwable -> L69
        Object r41 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L69
    L72:
        if (Result.isSuccess-impl(r41) == false) goto L10;
        Unit r42 = (Unit) r41;
        w r43 = w.b;
        final Function1 r44 = new a4.b(r37);
        Intrinsics.checkNotNullParameter(r37, "traceId");
        w.m(new b(r37, r44));
    L69:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L72
    L48:
        if (r27 != 1620543956) goto L10;
        if (r24.equals("InComingEvent") == false) goto L10;
        final String r46 = b(r10, r22);
        final long r47 = r26.get("feReceiveEventTime").getAsLong();     // Catch: Throwable -> L56
        w r48 = w.b;     // Catch: Throwable -> L56
        Intrinsics.checkNotNullParameter(r46, "traceId");     // Catch: Throwable -> L56
        w.m(new i(r46, r47));     // Catch: Throwable -> L56
        Object r49 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L56
    L59:
        if (Result.isSuccess-impl(r49) == false) goto L10;
        Unit r50 = (Unit) r49;
        w r51 = w.b;
        final Function1 r52 = new a4.c(r46);
        Intrinsics.checkNotNullParameter(r46, "traceId");
        w.m(new b(r46, r52));
    L56:
        th = move-exception;
        Result.Companion r53 = Result.Companion;
        r49 = Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L85:
        Intrinsics.checkNotNullParameter(AbsReportPerformanceEntriesMethodIDL.b.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsReportPerformanceEntriesMethodIDL.b.class), "");
    }
}
