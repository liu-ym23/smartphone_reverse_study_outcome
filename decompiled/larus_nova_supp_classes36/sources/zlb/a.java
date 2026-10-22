package zlb;

import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static long c;
    public static final /* synthetic */ int d = 0;
    public Function0<? extends Map<String, String>> a;
    public final String b;

    /* JADX INFO: renamed from: zlb.a$a, reason: collision with other inner class name */
    public static final class C0355a {
        public static void d(ScenarioType r9) {
            Intrinsics.checkNotNullParameter(r9, "scenario");
            JSONObject r2 = new JSONObject();     // Catch: Exception -> L8
            r2.put("product_type", r9.name().toLowerCase(Locale.ROOT));     // Catch: Exception -> L8
            if (a.c == 0) goto L6;
            r2.put("cost", System.currentTimeMillis() - a.c);     // Catch: Exception -> L8
        L6:
            com.ss.android.lark.statistics.b.b("ccm_inline_ai_ui_show_dev", r2);     // Catch: Exception -> L8
            a.c = 0;     // Catch: Exception -> L8
            Log.d("InlineAIReport", "report, event = ccm_inline_ai_ui_show_dev, params = " + r2);     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            Log.e("InlineAIReport", "Exception: " + e);
        }

        public static void e(Integer r4, String r5, int r6) {
            JSONObject r2 = new JSONObject();     // Catch: Exception -> L5
            r2.put("errCode", r4);     // Catch: Exception -> L5
            r2.put("errReason", r5);     // Catch: Exception -> L5
            r2.put("cost", r6);     // Catch: Exception -> L5
            com.ss.android.lark.statistics.b.b("inlineai_performance_webview_load_fail_dev", r2);     // Catch: Exception -> L5
            Log.d("InlineAIReport", "report, event = inlineai_performance_webview_load_fail_dev, params = " + r2);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("InlineAIReport", "Exception: " + e);
        }

        public static void a(ScenarioType r6, int r7, String r8, int r9) {
            Intrinsics.checkNotNullParameter(r6, "scenario");
            Intrinsics.checkNotNullParameter(r8, INotificationHitPoint.NoticeType.MESSAGE);
            JSONObject r3 = new JSONObject();     // Catch: Exception -> L5
            r3.put("product_type", r6.name().toLowerCase(Locale.ROOT));     // Catch: Exception -> L5
            r3.put("code", r7);     // Catch: Exception -> L5
            r3.put(INotificationHitPoint.NoticeType.MESSAGE, r8);     // Catch: Exception -> L5
            r3.put("cost", r9);     // Catch: Exception -> L5
            com.ss.android.lark.statistics.b.b("ccm_inline_ai_get_prompt_dev", r3);     // Catch: Exception -> L5
            Log.d("InlineAIReport", "report, event = ccm_inline_ai_get_prompt_dev, params = " + r3);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("InlineAIReport", "Exception: " + e);
        }

        public static void c(ScenarioType r6, int r7, String r8, int r9, String r10, String r11) {
            Intrinsics.checkNotNullParameter(r6, "scenario");
            Intrinsics.checkNotNullParameter(r8, INotificationHitPoint.NoticeType.MESSAGE);
            Intrinsics.checkNotNullParameter(r10, "promptId");
            Intrinsics.checkNotNullParameter(r11, "promptType");
            JSONObject r3 = new JSONObject();     // Catch: Exception -> L5
            r3.put("product_type", r6.name().toLowerCase(Locale.ROOT));     // Catch: Exception -> L5
            r3.put("code", r7);     // Catch: Exception -> L5
            r3.put(INotificationHitPoint.NoticeType.MESSAGE, r8);     // Catch: Exception -> L5
            r3.put("cost", r9);     // Catch: Exception -> L5
            r3.put("prompt_id", r10);     // Catch: Exception -> L5
            r3.put("prompt_type", r11);     // Catch: Exception -> L5
            com.ss.android.lark.statistics.b.b("ccm_inline_ai_send_prompt_dev", r3);     // Catch: Exception -> L5
            Log.d("InlineAIReport", "report, event = ccm_inline_ai_send_prompt_dev, params = " + r3);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("InlineAIReport", "Exception: " + e);
        }

        public static void b(ScenarioType r5, String r6, String r7, int r8, String r9, int r10, int r11, int r12, int r13, int r14, int r15) {
            Intrinsics.checkNotNullParameter(r5, "scenario");
            Intrinsics.checkNotNullParameter(r6, "promptId");
            Intrinsics.checkNotNullParameter(r7, "promptType");
            Intrinsics.checkNotNullParameter(r9, "taskStatus");
            JSONObject r2 = new JSONObject();     // Catch: Exception -> L5
            r2.put("product_type", r5.name().toLowerCase(Locale.ROOT));     // Catch: Exception -> L5
            r2.put("prompt_id", r6);     // Catch: Exception -> L5
            r2.put("prompt_type", r7);     // Catch: Exception -> L5
            r2.put("status_code", r8);     // Catch: Exception -> L5
            r2.put("task_status", r9);     // Catch: Exception -> L5
            r2.put("first_push_cost", r10);     // Catch: Exception -> L5
            r2.put("push_cost", r11);     // Catch: Exception -> L5
            r2.put("total_cost", r12);     // Catch: Exception -> L5
            r2.put("content_length", r13);     // Catch: Exception -> L5
            r2.put("push_times", r14);     // Catch: Exception -> L5
            r2.put("waiting_time_before_cancel", r15);     // Catch: Exception -> L5
            com.ss.android.lark.statistics.b.b("ccm_inline_ai_push_dev", r2);     // Catch: Exception -> L5
            Log.d("InlineAIReport", "report, event = ccm_inline_ai_push_dev, params = " + r2);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("InlineAIReport", "Exception: " + e);
        }
    }

    static {
    }

    public final JSONObject a() throws JSONException {
        JSONObject r0 = new JSONObject();
        Function0<? extends Map<String, String>> r1 = this.a;
        if (r1 == null) goto L10;
        Map r2 = (Map) r1.invoke();
        if (r2 == null) goto L10;
        Iterator r3 = r2.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) r3.next();
        r0.put((String) r4.getKey(), r4.getValue());
    L10:
        r0.put("product_type", this.b);
        return r0;
    }

    public final void b() {
        JSONObject r2 = a();     // Catch: Exception -> L5
        com.ss.android.lark.statistics.b.b("ccm_ai_floating_window_view", r2);     // Catch: Exception -> L5
        Log.d("InlineAIReport", "report, event = ccm_ai_floating_window_view, params = " + r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("InlineAIReport", "Exception: " + e);
    }

    public a(ScenarioType r2) {
        Intrinsics.checkNotNullParameter(r2, "scenario");
        this.b = r2.name().toLowerCase(Locale.ROOT);
    }

    public final void d(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "commandType");
        Intrinsics.checkNotNullParameter(r7, "buttonType");
        JSONObject r2 = a();     // Catch: Exception -> L5
        r2.put("click", "button");     // Catch: Exception -> L5
        r2.put("target", "none");     // Catch: Exception -> L5
        r2.put("command_type", r6);     // Catch: Exception -> L5
        r2.put("button_type", r7);     // Catch: Exception -> L5
        com.ss.android.lark.statistics.b.b("ccm_doc_ai_quit_double_check_click", r2);     // Catch: Exception -> L5
        Log.d("InlineAIReport", "report, event = ccm_doc_ai_quit_double_check_click, params = " + r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("InlineAIReport", "Exception: " + e);
    }

    public final void c(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "commandType");
        Intrinsics.checkNotNullParameter(r8, "pathType");
        Intrinsics.checkNotNullParameter(r9, "taskId");
        JSONObject r3 = a();     // Catch: Exception -> L5
        r3.put("click", "command");     // Catch: Exception -> L5
        r3.put("target", "none");     // Catch: Exception -> L5
        r3.put("click_type", "click");     // Catch: Exception -> L5
        r3.put("command_type", r7);     // Catch: Exception -> L5
        r3.put("path_type", r8);     // Catch: Exception -> L5
        r3.put("taskID", r9);     // Catch: Exception -> L5
        com.ss.android.lark.statistics.b.b("ccm_ai_quick_command_click", r3);     // Catch: Exception -> L5
        Log.d("InlineAIReport", "report, event = ccm_ai_quick_command_click, params = " + r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("InlineAIReport", "Exception: " + e);
    }

    public final void e(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "quiteType");
        Intrinsics.checkNotNullParameter(r8, "status");
        JSONObject r3 = a();     // Catch: Exception -> L5
        r3.put("click", "quit");     // Catch: Exception -> L5
        r3.put("target", "none");     // Catch: Exception -> L5
        r3.put("quite_type", r7);     // Catch: Exception -> L5
        r3.put("status", r8);     // Catch: Exception -> L5
        r3.put("command_type", r9);     // Catch: Exception -> L5
        com.ss.android.lark.statistics.b.b("ccm_ai_quit_floating_window_click", r3);     // Catch: Exception -> L5
        Log.d("InlineAIReport", "report, event = ccm_ai_quit_floating_window_click, params = " + r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("InlineAIReport", "Exception: " + e);
    }

    public final void f(String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "actionType");
        Intrinsics.checkNotNullParameter(r7, "commandType");
        Intrinsics.checkNotNullParameter(r8, "taskId");
        JSONObject r2 = a();     // Catch: Exception -> L5
        r2.put("click", "action");     // Catch: Exception -> L5
        r2.put("target", "none");     // Catch: Exception -> L5
        r2.put("action_type", r6);     // Catch: Exception -> L5
        r2.put("command_type", r7);     // Catch: Exception -> L5
        r2.put("action_time_type", "after_output");     // Catch: Exception -> L5
        r2.put("taskID", r8);     // Catch: Exception -> L5
        com.ss.android.lark.statistics.b.b("ccm_ai_result_action_click", r2);     // Catch: Exception -> L5
        Log.d("InlineAIReport", "report, event = ccm_ai_result_action_click, params = " + r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("InlineAIReport", "Exception: " + e);
    }
}
