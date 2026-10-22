package com.obric.assistant.feedback;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public static final d a = null;

    public static final class a {
        public static final /* synthetic */ int d = 0;
        public final String a;
        public final String b;
        public final String c;

        /* JADX INFO: renamed from: com.obric.assistant.feedback.d$a$a, reason: collision with other inner class name */
        public static final class C0005a {
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "FeedbackEventContext(botId=" + this.a + ", conversationId=" + this.b + ", messageId=" + this.c + ')';
        }

        public a(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "botId");
            Intrinsics.checkNotNullParameter(r3, "conversationId");
            Intrinsics.checkNotNullParameter(r4, "messageId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "FeedbackTrackInfo(feedbackBizType=" + this.a + ", searchTool=" + this.b + ')';
        }

        public b(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = new d();
    }

    public d() {
    }

    public static JSONObject a(Message r5) {
        Map r0 = r5.getExt();
        if (r0 != null) goto L5;
        r0 = MapsKt.emptyMap();
    L5:
        JSONObject r1 = new JSONObject();
        String r3 = (String) r0.get("o_omni_err_code");
        if (r3 == null) goto L10;
        Integer r4 = StringsKt.toIntOrNull(r3);
        if (r4 == null) goto L10;
        int r6 = r4.intValue();
    L11:
        r1.put("o_omni_err_code", r6);
        String r7 = (String) r0.get("o_complete_result");
        String r8 = "";
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        r1.put("o_complete_result", r7);
        String r2 = (String) r0.get("inner_log_id");
        if (r2 != null) goto L17;
        r2 = "";
    L17:
        r1.put("inner_log_id", r2);
        r1.put("device_id", o.a.getDeviceId());
        String r9 = r5.getMessageId();
        if (r9 == null) goto L21;
        r8 = r9;
    L21:
        r1.put("message_id", r8);
        return r1;
    L10:
        r6 = 0;
        goto L11
    }

    public static b d(String r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        Object r3 = null;
        if (r2 == false) goto L41;
        return null;
    L41:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L33
        String r6 = UriProtector.getQueryParameter(UriProtector.parse(r4), "data");     // Catch: Throwable -> L33
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        if (r6.length() != 0) goto L18;
        r0 = true;
    L18:
        if (r0 == true) goto L30;
        JSONObject r1 = new JSONObject(r6);     // Catch: Throwable -> L33
        String r7 = r1.optString("feedbackBizType");     // Catch: Throwable -> L33
        IObricFeedbackService.a.getClass();     // Catch: Throwable -> L33
        if (IObricFeedbackService.a.b(r7) == true) goto L24;
        r7 = null;
    L24:
        if (r7 == null) goto L30;
        String r8 = r1.optString("searchTool");     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L33
        if ((true ^ StringsKt.isBlank(r8)) == true) goto L29;
        r8 = null;
    L29:
        b r9 = new b(r7, r8);     // Catch: Throwable -> L33
    L31:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r10) == true) goto L40;
        r3 = r10;
    L40:
        return (b) r3;
    L30:
        r9 = null;
    L33:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static boolean f(b r1) {
        IObricFeedbackService.a r0 = IObricFeedbackService.a;
        if (r1 == null) goto L5;
        String r2 = r1.a;
    L6:
        r0.getClass();
        return IObricFeedbackService.a.b(r2);
    L5:
        r2 = null;
        goto L6
    }

    public static JSONObject b(Message r4, b r5, String r6) {
        int r0 = a.d;
        Intrinsics.checkNotNullParameter(r4, "message");
        String r1 = r4.getSenderId();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r3 = r4.getConversationId();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        String r7 = r4.getMessageId();
        if (r7 == null) goto L13;
        r2 = r7;
    L13:
        return c(new a(r1, r3, r2), r5, r6);
    }

    public static JSONObject c(a r4, b r5, String r6) {
        if (r5 == null) goto L5;
        String r1 = r5.a;
    L6:
        if (r1 == null) goto L25;
        int r2 = r1.hashCode();
        if (r2 == (-906336856)) goto L22;
        if (r2 == 960552006) goto L18;
        if (r2 != 1507218089) goto L25;
        if (r1.equals("memory_delete") == false) goto L25;
    L20:
        String r3 = "active_memory_operate";
    L26:
        JSONObject r7 = new JSONObject();
        r7.put("feedback_module", r3);
        if (r5 == null) goto L36;
        String r8 = r5.b;
        if (r8 == null) goto L36;
        if ((!StringsKt.isBlank(r8)) == true) goto L34;
        r8 = null;
    L34:
        if (r8 == null) goto L36;
        r7.put("search_tool", r8);
    L36:
        r7.put("bot_id", r4.a);
        r7.put("conversation_id", r4.b);
        r7.put("message_id", r4.c);
        if ((!StringsKt.isBlank(r6)) == true) goto L40;
        r6 = null;
    L40:
        if (r6 == null) goto L42;
        r7.put("obric_window_mode", r6);
    L42:
        return r7;
    L18:
        if (r1.equals("memory_operate") == true) goto L20;
    L22:
        if (r1.equals("search") == false) goto L25;
        r3 = "all_search";
    L25:
        r3 = "";
        goto L26
    L5:
        r1 = null;
        goto L6
    }

    public static void e(a r1, b r2, String r3, String r4, String r5, String r6, Boolean r7) {
        Intrinsics.checkNotNullParameter(r1, "eventContext");
        Intrinsics.checkNotNullParameter(r4, "popupType");
        Intrinsics.checkNotNullParameter(r5, "clickAction");
        if (f(r2) == true) goto L5;
        return;
    L5:
        JSONObject r8 = c(r1, r2, r3);
        r8.put("popup_type", r4);
        r8.put("click_action", r5);
        if (r6 != null) goto L8;
    L13:
        if (r7 == null) goto L15;
        r8.put("is_consent_checked", String.valueOf(r7.booleanValue()));
    L15:
        o.a.reportEvent("obric_popup_click", r8);
        return;
    L8:
        if ((!StringsKt.isBlank(r6)) == true) goto L11;
        r6 = null;
    L11:
        if (r6 == null) goto L13;
        r8.put("feedback_label", r6);
        goto L13
    }
}
