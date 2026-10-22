package t89;

import com.bytedance.ies.commerce.common_utils.event.EventCenter;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.ies.xbridge.s;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uq9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements JsEventSubscriber {
    public final i a;

    public static final class a {
    }

    static {
    }

    public c(i r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
    }

    public final void onReceiveJsEvent(Js2NativeEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "jsEvent");
        FLogger.a.i("ECEventSubscriber", "Receive event, name=" + r6.getEventName());
        XReadableMap r0 = r6.getParams();
        if (r0 == null) goto L34;
        String r1 = s.f(r0, "event_context", "");
        if (r1 == null) goto L35;
        String r2 = p0.a(r1);
        if (r2 == null) goto L37;
        String r3 = this.a.a();
        if (r3 == null) goto L36;
        String r4 = p0.a(r3);
        if (r4 == null) goto L38;
        Object r5 = null;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L21
        XReadableMap r8 = r6.getParams();     // Catch: Throwable -> L21
        if (r8 == null) goto L18;
        JSONObject r9 = new JSONObject(s.h(r8));     // Catch: Throwable -> L21
    L19:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r10) == true) goto L27;
        r5 = r10;
    L27:
        JSONObject r11 = (JSONObject) r5;
        if (r11 != null) goto L30;
        r11 = new JSONObject();
    L30:
        EventCenter.a(r2, r4, r11);
        FLogger.a.i("ECEventSubscriber", "Dispatch event, name=" + r4 + ", params=" + r11);
        return;
    L18:
        r9 = null;
    L21:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L38:
        return;
    L36:
        return;
    L37:
        return;
    L35:
        return;
    }
}
