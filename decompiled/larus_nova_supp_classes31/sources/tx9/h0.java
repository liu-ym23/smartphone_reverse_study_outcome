package tx9;

import com.ixigua.lib.track.TrackParams;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h0 {
    public static final Map<String, i0> a = null;
    public static final Object b = null;

    static {
        a = new LinkedHashMap();
        b = new Object();
    }

    public static final JSONObject e(Map<String, String> r3) {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r4.next();
        r0.put(r1.getKey(), r1.getValue());
        goto L4
    L6:
        return r0;
    }

    public static final JSONObject f(String r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        Object r3 = Result.constructor-impl(new JSONObject(r2));     // Catch: Throwable -> L7
    L9:
        JSONObject r1 = new JSONObject();
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = r1;
    L13:
        return (JSONObject) r3;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public static final Long g(Object r2) {
        if ((r2 instanceof Number) == false) goto L6;
        return Long.valueOf(((Number) r2).longValue());
    L6:
        if ((r2 instanceof String) == true) goto L11;
        return null;
    L11:
        return g(r2);
    }

    public static final void b(String r1, JSONObject r2) {
        by7.a r0 = new by7.a(r1);
        TrackParams r3 = new TrackParams().merge(r2);
        r0.a.merge(r3);
        r0.b();
    }

    public static final void d(String r5, String r6, String r7, Long r8) {
        Intrinsics.checkNotNullParameter(r5, "conversationId");
        Intrinsics.checkNotNullParameter(r6, "sourceConversationId");
        Intrinsics.checkNotNullParameter(r7, "sourceMessageId");
        if (StringsKt.isBlank(r5) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r6) == true) goto L29;
        Object r0 = b;
        monitor-enter(r0);
        Map<String, i0> r1 = a;     // Catch: Throwable -> L23
        i0 r2 = (i0) ((LinkedHashMap) r1).get(r5);     // Catch: Throwable -> L23
        if (StringsKt.isBlank(r7) == false) goto L16;
        if (r2 == null) goto L13;
        r7 = r2.b;     // Catch: Throwable -> L23
    L14:
        if (r7 != null) goto L16;
        r7 = "";
        goto L16
    L13:
        r7 = null;
    L16:
        if (r8 != null) goto L20;
        if (r2 == null) goto L19;
        r8 = r2.c;     // Catch: Throwable -> L23
        goto L20
    L19:
        r8 = null;
    L20:
        r1.put(r5, new i0(r6, r7, r8));     // Catch: Throwable -> L23
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r0);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static final void a(JSONObject r4, String r5, String r6, boolean r7, Map<String, String> r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "conversationId");
        JSONObject r10 = f(r6);
        Object r0 = b;
        monitor-enter(r0);
        i0 r11 = (i0) ((LinkedHashMap) a).get(r5);     // Catch: Throwable -> L63
        monitor-exit(r0);
        boolean r1 = true;
        Object r2 = null;
        if (r11 == null) goto L10;
        String r3 = r11.a;
        if (r3 == null) goto L10;
    L22:
        if (r11 == null) goto L30;
        String r12 = r11.b;
        if (r12 == null) goto L30;
        if ((!StringsKt.isBlank(r12)) == true) goto L29;
        r12 = null;
    L29:
        if (r12 == null) goto L30;
    L40:
        r2 = r12;
    L41:
        if (r7 == false) goto L43;
    L52:
        r4.put("is_fork_conversation", r1);
        if (r9 == false) goto L68;
        if (r1 == true) goto L56;
        return;
    L56:
        if (r3 != null) goto L58;
        r3 = "";
    L58:
        r4.put("fork_from_conversation_id", r3);
        if (r2 != null) goto L61;
        r2 = "";
    L61:
        r4.put("fork_from_message_id", r2);
        return;
    L68:
        return;
    L43:
        if (r3 != null) goto L45;
    L48:
        boolean r13 = true;
    L49:
        if (r13 == false) goto L52;
        r1 = false;
        goto L52
    L45:
        if (StringsKt.isBlank(r3) == true) goto L48;
        r13 = false;
    L30:
        if (r8 == null) goto L36;
        r12 = r8.get("fork_from_message_id");
        if (r12 == null) goto L36;
        if ((!StringsKt.isBlank(r12)) == false) goto L36;
    L37:
        if (r12 != null) goto L40;
        r12 = r10.optString("fork_from_message_id");
        Intrinsics.checkNotNull(r12);
        if ((!StringsKt.isBlank(r12)) == false) goto L41;
    L36:
        r12 = null;
    L10:
        if (r8 == null) goto L16;
        r3 = r8.get("fork_from_conversation_id");
        if (r3 == null) goto L16;
        if ((!StringsKt.isBlank(r3)) == false) goto L16;
    L17:
        if (r3 != null) goto L22;
        r3 = r10.optString("fork_from_conversation_id");
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank(r3)) == true) goto L22;
        r3 = null;
    L16:
        r3 = null;
    L63:
        th = move-exception;
        throw th;
    }

    public static final void c(String r3, String r4, String r5, String r6, String r7, Long r8) {
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "sourceConversationId");
        Intrinsics.checkNotNullParameter(r5, "sourceMessageId");
        d(r3, r4, r5, r8);
        JSONObject r0 = new JSONObject();
        r0.put("current_page", "chat");
        r0.put("click_from", "fork");
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r0.put("mode_id", r6);
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r0.put("model_item_key", r7);
        r0.put("fork_from_conversation_id", r4);
        r0.put("fork_from_message_id", r5);
        r0.put("conversation_id", r3);
        if (r8 == null) goto L11;
        r0.put("fork_index", r8.longValue());
    L11:
        b("create_new_chat", r0);
    }
}
