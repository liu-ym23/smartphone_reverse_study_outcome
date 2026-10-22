package com.obric.assistant.awareness;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.awareness.IAwarenessEventReporter;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.AwarenessEventData;
import com.obric.memorydata.sdk.awareness.e;
import com.obric.memorydata.sdk.awareness.l;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tka.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/awareness/AwarenessEventReporter;", "Lcom/larus/dora/api/awareness/IAwarenessEventReporter;", "<init>", "()V", "report", NameKeys.UnloadStrategy_No_Strategy, "key", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "timestamp", NameKeys.UnloadStrategy_No_Strategy, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwarenessEventReporter implements IAwarenessEventReporter {

    public static final class a {
    }

    static {
    }

    public AwarenessEventReporter() {
    }

    public final void a(String r12, Object r13, long r14) {
        Intrinsics.checkNotNullParameter(r12, "key");
        Intrinsics.checkNotNullParameter(r13, "value");
        e r0 = e.a;
        Context r1 = AppHost.a.getApplication().getApplicationContext();
        Parcelable r10 = new AwarenessEventData(r12, r13, r14, null, 8, null);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "event");
        Context r15 = r1.getApplicationContext();
        Bundle r16 = new Bundle();
        r16.putParcelable("awareness_event", r10);
        Unit r2 = Unit.INSTANCE;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        c.c("ContextAwareness", "call awareness provider method=report_awareness_event");     // Catch: Throwable -> L13
        Uri r4 = UriProtector.parse("content://com.obric.memorydata.awareness.provider");     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L13
        Bundle r17 = e.k(r15, r4, r16);     // Catch: Throwable -> L13
        int r18 = l.a;     // Catch: Throwable -> L13
        if (r17 != null) goto L6;
        MemoryResponse r19 = new MemoryResponse(400, "provider returns null", 4);     // Catch: Throwable -> L13
    L8:
        if (r19.a() == false) goto L10;
        c.c("ContextAwareness", "call awareness provider success method=report_awareness_event");     // Catch: Throwable -> L13
    L11:
        Object r110 = Result.constructor-impl(r19);     // Catch: Throwable -> L13
    L15:
        Throwable r111 = Result.exceptionOrNull-impl(r110);
        if (r111 == null) goto L19;
        c.b("ContextAwareness", "call provider failed method=report_awareness_event", r111);
        r110 = new MemoryResponse(400, r111.getMessage(), 4);
    L19:
        MemoryResponse r112 = (MemoryResponse) r110;
        if (r112.a() == false) goto L22;
        FLogger.a.i("AwarenessEventReporter", "感知事件已上报，key=" + r12);
        return;
    L22:
        FLogger.a.e("AwarenessEventReporter", "感知事件上报失败，key=" + r12 + ", code=" + r112.a);
        return;
    L10:
        c.d("ContextAwareness", "call awareness provider failed method=report_awareness_event code=" + r19.a + " msg=" + r19.b);     // Catch: Throwable -> L13
        goto L11
    L6:
        r19 = new MemoryResponse(r17.getInt("result_code", 400), r17.getString("result_message"), 4);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }
}
