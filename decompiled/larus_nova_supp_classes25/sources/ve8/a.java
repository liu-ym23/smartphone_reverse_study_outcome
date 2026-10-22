package ve8;

import android.net.Uri;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        LinkedHashMap r0 = new LinkedHashMap();
        String r2 = UriProtector.getQueryParameter(r10, "appletId");
        if (r2 == null) goto L5;
        r0.put("appletId", r2);
    L5:
        String r3 = UriProtector.getQueryParameter(r10, "pageId");
        if (r3 == null) goto L8;
        r0.put("pageId", r3);
    L8:
        String r4 = UriProtector.getQueryParameter(r10, "pageData");
        if (r4 != null) goto L79;
    L27:
        String r5 = UriProtector.getQueryParameter(r10, "pageType");
        if (r5 == null) goto L30;
        r0.put("pageType", r5);
    L30:
        String r6 = UriProtector.getQueryParameter(r10, "pageSettings");
        if (r6 != null) goto L75;
    L41:
        String r1 = UriProtector.getQueryParameter(r10, "conversationId");
        if (r1 == null) goto L44;
        r0.put("conversationId", r1);
    L44:
        LinkedHashMap r7 = new LinkedHashMap();
        String r8 = UriProtector.getQueryParameter(r10, "botId");
        if (r8 == null) goto L47;
        r7.put("botId", r8);
    L47:
        String r9 = UriProtector.getQueryParameter(r10, "messageId");
        if (r9 == null) goto L50;
        r7.put("msgId", r9);
    L50:
        String r11 = UriProtector.getQueryParameter(r10, "conversationId");
        if (r11 == null) goto L53;
        r7.put("conversationId", r11);
    L53:
        String r12 = UriProtector.getQueryParameter(r10, "replyFor");
        if (r12 == null) goto L56;
        r7.put("replyFor", r12);
    L56:
        String r13 = UriProtector.getQueryParameter(r10, "bot_state");
        if (r13 == null) goto L59;
        r7.put("bot_state", r13);
    L59:
        String r14 = UriProtector.getQueryParameter(r10, "fpa_common_param");
        if (r14 == null) goto L62;
        r7.put("fpa_common_param", r14);
    L62:
        String r15 = UriProtector.getQueryParameter(r10, "context");
        if (r15 != null) goto L77;
    L73:
        r0.put("context", r7);
        return r0;
    L77:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L70
        JSONObject r17 = new JSONObject(r15);     // Catch: Throwable -> L70
        Iterator<String> r18 = r17.keys();     // Catch: Throwable -> L70
    L66:
        if (r18.hasNext() == false) goto L68;
        String r19 = r18.next();     // Catch: Throwable -> L70
        r7.put(r19, JSONObjectProtectorUtils.getString(r17, r19));     // Catch: Throwable -> L70
        goto L66
    L68:
        Object r110 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L70
    L72:
        Result.box-impl(r110);
    L70:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L72
    L75:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L38
        LinkedHashMap r22 = new LinkedHashMap();     // Catch: Throwable -> L38
        JSONObject r23 = new JSONObject(r6);     // Catch: Throwable -> L38
        Iterator<String> r24 = r23.keys();     // Catch: Throwable -> L38
    L34:
        if (r24.hasNext() == false) goto L36;
        String r25 = r24.next();     // Catch: Throwable -> L38
        r22.put(r25, JSONObjectProtectorUtils.getString(r23, r25));     // Catch: Throwable -> L38
        goto L34
    L36:
        r0.put("pageSettings", r22);     // Catch: Throwable -> L38
        Object r26 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        Result.box-impl(r26);
    L38:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L79:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L21
        JSONObject r29 = new JSONObject(r4);     // Catch: Throwable -> L21
        String r30 = UriProtector.getQueryParameter(r10, "botId");     // Catch: Throwable -> L21
        if (r30 == null) goto L13;
        r29.put("botId", r30);     // Catch: Throwable -> L21
    L13:
        String r31 = UriProtector.getQueryParameter(r10, "conversationId");     // Catch: Throwable -> L21
        if (r31 == null) goto L16;
        r29.put("conversationId", r31);     // Catch: Throwable -> L21
    L16:
        String r32 = UriProtector.getQueryParameter(r10, "messageId");     // Catch: Throwable -> L21
        if (r32 == null) goto L19;
        r29.put("messageId", r32);     // Catch: Throwable -> L21
    L19:
        r0.put("pageData", r29.toString());     // Catch: Throwable -> L21
        Object r33 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r34 = Result.exceptionOrNull-impl(r33);
        if (r34 == null) goto L26;
        r0.put("pageData", r34);
    L26:
        Result.box-impl(r33);
    L21:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
