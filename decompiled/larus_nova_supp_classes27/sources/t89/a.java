package t89;

import com.bytedance.ies.commerce.common_utils.event.EventCenter;
import com.bytedance.ies.commerce.common_utils.event.api.ISubscriber;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.settings.value.e10;
import com.larus.settings.value.ry;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import l3.d;
import org.json.JSONObject;
import uq9.h;
import uq9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final AtomicBoolean a = null;
    public static final C0140a b = null;

    /* JADX INFO: renamed from: t89.a$a, reason: collision with other inner class name */
    public static final class C0140a implements ISubscriber {
        public C0140a() {
        }

        public final void onEvent(String r4, String r5, JSONObject r6) {
            Intrinsics.checkNotNullParameter(r4, "sessionId");
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r6, "data");
            FLogger.a.i("ECAppletBridgeRelay", "relay event=" + r5 + " sessionId=" + r4);
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
            Object r8 = Result.constructor-impl(JsonParser.parseString(r6.toString()).getAsJsonObject());     // Catch: Throwable -> L5
        L8:
            if (Result.isFailure-impl(r8) == false) goto L10;
            r8 = null;
        L10:
            JsonObject r9 = (JsonObject) r8;
            if (r9 != null) goto L13;
            r9 = new JsonObject();
        L13:
            l3.a r10 = new l3.a(r5, r9, 4);
            r10.d = "com.flow.shorthand";
            d.c(r10);
            return;
        L5:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L8
        }
    }

    static {
        a = new AtomicBoolean(false);
        b = new C0140a();
    }

    public static void a() {
        if (a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        e10 r0 = e10.a;
        Map r1 = ((h) l0.a(new h(null), new ry())).a();
        if (r1 == null) goto L24;
        Iterator r2 = r1.entrySet().iterator();
    L9:
        if (r2.hasNext() == false) goto L34;
        i r3 = (i) ((Map.Entry) r2.next()).getValue();
        if (r3 == null) goto L9;
        String r4 = r3.a();
        if (r4 == null) goto L9;
        String r5 = p0.a(r4);
        if (r5 == null) goto L9;
        Lazy r6 = EventCenter.a;
        C0140a r7 = b;
        if (com.bytedance.ies.commerce.common_utils.event.a.a(r5) == null) goto L23;
        if (r7 == null) goto L23;
        ((ConcurrentHashMap) EventCenter.a.getValue()).put(r5, r7);
    L23:
        FLogger.a.i("ECAppletBridgeRelay", "registerEvent redirect=".concat(r5));
        goto L9
    L34:
        return;
    }
}
