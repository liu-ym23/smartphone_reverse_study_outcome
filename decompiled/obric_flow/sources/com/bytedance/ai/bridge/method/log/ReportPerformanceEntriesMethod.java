package com.bytedance.ai.bridge.method.log;

import a3.b;
import a3.i;
import b2.d;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import m1.j;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/bridge/method/log/ReportPerformanceEntriesMethod;", "Lcom/bytedance/ai/bridge/method/log/AbsReportPerformanceEntriesMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "", ReportPerformanceEntriesMethod.KEY_CALLBACK_ID, "", "generateTraceId", "(Ln1/c;I)Ljava/lang/String;", "Lcom/bytedance/ai/bridge/method/log/AbsReportPerformanceEntriesMethodIDL$ReportPerformanceEntriesParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/log/AbsReportPerformanceEntriesMethodIDL$ReportPerformanceEntriesResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/log/AbsReportPerformanceEntriesMethodIDL$ReportPerformanceEntriesParamModel;Lo1/f;)V", "Companion", "b2/d", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReportPerformanceEntriesMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReportPerformanceEntriesMethod.kt\ncom/bytedance/ai/bridge/method/log/ReportPerformanceEntriesMethod\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,92:1\n808#2,11:93\n1863#2:104\n1864#2:106\n1#3:105\n*S KotlinDebug\n*F\n+ 1 ReportPerformanceEntriesMethod.kt\ncom/bytedance/ai/bridge/method/log/ReportPerformanceEntriesMethod\n*L\n34#1:93,11\n34#1:104\n34#1:106\n*E\n"})
public final class ReportPerformanceEntriesMethod extends AbsReportPerformanceEntriesMethodIDL {
    public static final d Companion = null;
    private static final String KEY_CALLBACK_ID = "callbackId";
    private static final String KEY_PERF_RECORD = "perfRecord";
    private static final String KEY_TYPE = "type";
    private static final String PERF_TYPE_IN_COMING_CALL = "InComingCall";
    private static final String PERF_TYPE_IN_COMING_EVENT = "InComingEvent";
    private static final String PERF_TYPE_OUT_GOING_CALL = "OutGoingCall";
    private static final String TIME_KEY_FE_RECEIVE_CALL = "feReceiveCallTime";
    private static final String TIME_KEY_FE_RECEIVE_CALLBACK = "feReceiveCallbackTime";
    private static final String TIME_KEY_FE_RECEIVE_EVENT = "feReceiveEventTime";
    private static final String TIME_KEY_FE_SEND_CALL = "feSendCallTime";
    private static final String TIME_KEY_FE_SEND_CALLBACK = "feSendCallbackTime";

    static {
        Companion = new d();
    }

    public ReportPerformanceEntriesMethod() {
    }

    public static /* synthetic */ Unit b(String r5, boolean r10) {
        return handle$lambda$12$lambda$5$lambda$4(r5, r10);
    }

    public static /* synthetic */ Unit c(String r5, boolean r10) {
        return handle$lambda$12$lambda$11$lambda$10(r5, r10);
    }

    public static /* synthetic */ Unit d(String r5, boolean r10) {
        return handle$lambda$12$lambda$8$lambda$7(r5, r10);
    }

    private final String generateTraceId(c r5, int r10) {
        StringBuilder r11 = new StringBuilder();
        j r12 = (j) ((n1.a) r5).b(j.class);
        if (r12 == null) goto L5;
        String r13 = r12.c();
    L6:
        r11.append(r13);
        r11.append('_');
        r11.append(r10);
        return r11.toString();
    L5:
        r13 = null;
        goto L6
    }

    private static final Unit handle$lambda$12$lambda$11$lambda$10(String r5, boolean r10) {
        if (r10 == false) goto L5;
        i r11 = i.f83a;
        Intrinsics.checkNotNullParameter(r5, "traceId");
        i.a(new a3.a(r5, 0));
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit handle$lambda$12$lambda$5$lambda$4(String r5, boolean r10) {
        if (r10 == false) goto L5;
        i r11 = i.f83a;
        Intrinsics.checkNotNullParameter(r5, "traceId");
        i.a(new a3.a(r5, 0));
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit handle$lambda$12$lambda$8$lambda$7(String r5, boolean r10) {
        if (r10 == false) goto L5;
        i r11 = i.f83a;
        Intrinsics.checkNotNullParameter(r5, "traceId");
        i.a(new a3.a(r5, 0));
    L5:
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsReportPerformanceEntriesMethodIDL.ReportPerformanceEntriesParamModel) r10, r11);
    }

    public void handle(c r11, AbsReportPerformanceEntriesMethodIDL.ReportPerformanceEntriesParamModel r12, f r13) {
        int r5 = 0;
        int r10 = 1;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r13, "callback");
        AtomicBoolean r14 = s0.a.f21798a;
        JsonArray r15 = r12.getEntries();
        ArrayList r16 = new ArrayList();
        Iterator<JsonElement> r17 = r15.iterator();
    L4:
        if (r17.hasNext() == false) goto L8;
        JsonElement r18 = r17.next();
        if ((r18 instanceof JsonObject) == false) goto L4;
        r16.add(r18);
        goto L4
    L8:
        Iterator r19 = r16.iterator();
    L10:
        if (r19.hasNext() == false) goto L85;
        JsonObject r20 = (JsonObject) r19.next();
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L14
        Object r22 = Result.m124constructorimpl(Integer.valueOf(r20.get(KEY_CALLBACK_ID).getAsInt()));     // Catch: Throwable -> L14
    L16:
        Object r23 = null;
        if (Result.m130isFailureimpl(r22) == false) goto L19;
        r22 = null;
    L19:
        Integer r24 = (Integer) r22;
        if (r24 == null) goto L10;
        int r25 = r24.intValue();
        Object r26 = Result.m124constructorimpl(r20.get("type").getAsString());     // Catch: Throwable -> L24
    L27:
        if (Result.m130isFailureimpl(r26) == false) goto L29;
        r26 = null;
    L29:
        String r27 = (String) r26;
        if (r27 == null) goto L10;
        Object r28 = Result.m124constructorimpl(r20.get(KEY_PERF_RECORD).getAsJsonObject());     // Catch: Throwable -> L34
    L37:
        if (Result.m130isFailureimpl(r28) == true) goto L40;
        r23 = r28;
    L40:
        JsonObject r29 = (JsonObject) r23;
        if (r29 == null) goto L10;
        int r30 = r27.hashCode();
        if (r30 != (-1154809878)) goto L46;
        if (r27.equals(PERF_TYPE_OUT_GOING_CALL) == false) goto L10;
        String r31 = generateTraceId(r11, r25);
        long r32 = r29.get(TIME_KEY_FE_SEND_CALL).getAsLong();     // Catch: Throwable -> L80
        long r33 = r29.get(TIME_KEY_FE_RECEIVE_CALLBACK).getAsLong();     // Catch: Throwable -> L80
        i r34 = i.f83a;     // Catch: Throwable -> L80
        Intrinsics.checkNotNullParameter(r31, "traceId");     // Catch: Throwable -> L80
        i.a(new b(r32, r31, 6));     // Catch: Throwable -> L80
        Intrinsics.checkNotNullParameter(r31, "traceId");     // Catch: Throwable -> L80
        i.a(new b(r33, r31, 9));     // Catch: Throwable -> L80
        Object r35 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L80
    L83:
        if (Result.m131isSuccessimpl(r35) == false) goto L10;
        Unit r36 = (Unit) r35;
        b2.c r37 = new b2.c(r31, 2);
        i r38 = i.f83a;
        Intrinsics.checkNotNullParameter(r31, "traceId");
        i.a(new a2.a(1, r31, r37));
    L80:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r35 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L83
    L46:
        if (r30 != 329290724) goto L48;
        if (r27.equals(PERF_TYPE_IN_COMING_CALL) == false) goto L10;
        String r40 = (String) ((n1.a) r11).d.get(r25);
        if (r40 == null) goto L10;
        long r41 = r29.get(TIME_KEY_FE_RECEIVE_CALL).getAsLong();     // Catch: Throwable -> L69
        long r42 = r29.get(TIME_KEY_FE_SEND_CALLBACK).getAsLong();     // Catch: Throwable -> L69
        i r43 = i.f83a;     // Catch: Throwable -> L69
        Intrinsics.checkNotNullParameter(r40, "traceId");     // Catch: Throwable -> L69
        i.a(new b(r41, r40, 0));     // Catch: Throwable -> L69
        Intrinsics.checkNotNullParameter(r40, "traceId");     // Catch: Throwable -> L69
        i.a(new b(r42, r40, 7));     // Catch: Throwable -> L69
        Object r44 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L69
    L72:
        if (Result.m131isSuccessimpl(r44) == false) goto L10;
        Unit r45 = (Unit) r44;
        b2.c r46 = new b2.c(r40, r10);
        i r47 = i.f83a;
        Intrinsics.checkNotNullParameter(r40, "traceId");
        i.a(new a2.a(1, r40, r46));
    L69:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r44 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L72
    L48:
        if (r30 != 1620543956) goto L10;
        if (r27.equals(PERF_TYPE_IN_COMING_EVENT) == false) goto L10;
        String r49 = generateTraceId(r11, r25);
        long r50 = r29.get(TIME_KEY_FE_RECEIVE_EVENT).getAsLong();     // Catch: Throwable -> L56
        i r51 = i.f83a;     // Catch: Throwable -> L56
        Intrinsics.checkNotNullParameter(r49, "traceId");     // Catch: Throwable -> L56
        i.a(new b(r49, r50, 8));     // Catch: Throwable -> L56
        Object r52 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L56
    L59:
        if (Result.m131isSuccessimpl(r52) == false) goto L10;
        Unit r53 = (Unit) r52;
        b2.c r54 = new b2.c(r49, r5);
        i r55 = i.f83a;
        Intrinsics.checkNotNullParameter(r49, "traceId");
        i.a(new a2.a(1, r49, r54));
    L56:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        r52 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L34:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        r28 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L24:
        th = move-exception;
        Result.Companion r58 = Result.Companion;
        r26 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r59 = Result.Companion;
        r22 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L16
    L85:
        Intrinsics.checkNotNullParameter(AbsReportPerformanceEntriesMethodIDL.ReportPerformanceEntriesResultModel.class, "<this>");
        r13.b((ResultModel) e.c(AbsReportPerformanceEntriesMethodIDL.ReportPerformanceEntriesResultModel.class), "");
    }
}
