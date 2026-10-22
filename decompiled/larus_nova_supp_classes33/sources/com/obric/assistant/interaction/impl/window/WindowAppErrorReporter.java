package com.obric.assistant.interaction.impl.window;

import com.bytedance.apm.ApmAgent;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eJ\u001e\u0010\u000f\u001a\u00020\b*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowAppErrorReporter;", "", "<init>", "()V", "TAG", "", "EVENT_OBRIC_APP_ERROR", "report", "", "category", "error", "", "errorStage", "extra", "", "putValue", "Lorg/json/JSONObject;", "key", "value", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowAppErrorReporter {
    private static final String EVENT_OBRIC_APP_ERROR = "obric_app_error";
    public static final WindowAppErrorReporter INSTANCE = null;
    private static final String TAG = "WindowAppErrorReporter";

    static {
        INSTANCE = new WindowAppErrorReporter();
    }

    private WindowAppErrorReporter() {
    }

    private final void putValue(JSONObject r2, String r3, Object r4) {
        if (r4 != null) goto L5;
        r4 = JSONObject.NULL;
    L12:
        r2.put(r3, r4);
        return;
    L5:
        if ((r4 instanceof Boolean) == true) goto L12;
        if ((r4 instanceof Number) == true) goto L12;
        if ((r4 instanceof String) == true) goto L12;
        r4 = r4.toString();
        goto L12
    }

    public final void report(String r5, Throwable r6, String r7, Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r5, "category");
        Intrinsics.checkNotNullParameter(r6, "error");
        Intrinsics.checkNotNullParameter(r7, "errorStage");
        Intrinsics.checkNotNullParameter(r8, "extra");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L18
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L18
        r3.put("error", r6.getClass().getName());     // Catch: Throwable -> L18
        String r4 = r6.getMessage();     // Catch: Throwable -> L18
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        r3.put("message", r4);     // Catch: Throwable -> L18
        r3.put("stacktrace", ExceptionsKt.stackTraceToString(r6));     // Catch: Throwable -> L18
        if (r7.length() <= 0) goto L9;
        boolean r9 = true;
    L10:
        if (r9 == false) goto L12;
        r3.put("error_stage", r7);     // Catch: Throwable -> L18
    L12:
        Iterator<Map.Entry<String, ? extends Object>> r10 = r8.entrySet().iterator();     // Catch: Throwable -> L18
    L14:
        if (r10.hasNext() == false) goto L16;
        Map.Entry<String, ? extends Object> r11 = r10.next();     // Catch: Throwable -> L18
        putValue(r3, r11.getKey(), r11.getValue());     // Catch: Throwable -> L18
        goto L14
    L16:
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L18
        r12.put("category", r5);     // Catch: Throwable -> L18
        ApmAgent.monitorEvent(EVENT_OBRIC_APP_ERROR, r12, null, r3);     // Catch: Throwable -> L18
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L24;
        FLogger.a.e(TAG, "report window app error failed, category=" + r5, r14);
    L24:
        if (Result.isSuccess-impl(r13) == false) goto L30;
        Unit r15 = (Unit) r13;
        FLogger.a.d(TAG, "report window app error success, category=" + r5);
        return;
    L30:
        return;
    L9:
        r9 = false;
    L18:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void report$default(WindowAppErrorReporter r0, String r1, Throwable r2, String r3, Map r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = MapsKt.emptyMap();
    L8:
        r0.report(r1, r2, r3, r4);
    }
}
