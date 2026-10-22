package eq8;

import com.larus.bmhome.instruction.monitor.SuggestPromptErrorType;
import com.larus.platform.service.g;
import com.larus.platform.service.o;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int d = 0;
    public String a;
    public String b;
    public String c;

    /* JADX INFO: renamed from: eq8.a$a, reason: collision with other inner class name */
    public static final class C0107a {
    }

    static {
    }

    public a() {
        this.a = "";
        this.b = "";
        this.c = "";
    }

    public static void b(a r2, String r3, String r4) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        r2.a(SuggestPromptErrorType.ERROR_TYPE_DEFAULT, r3, r4, null);
    }

    public final void c(String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "errorMsg");
        a(SuggestPromptErrorType.ERROR_TYPE_SERIOUS_PROBLEMS, r2, r3, r4);
    }

    public final void d(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "enterMethod");
        Intrinsics.checkNotNullParameter(r3, "suggestActionType");
        Intrinsics.checkNotNullParameter(r4, "userPrompt");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void a(@SuggestPromptErrorType String r3, String r4, String r5, JSONObject r6) {
        if (r6 == null) goto L9;
    L4:
        r6.put("enter_method", this.a);     // Catch: Exception -> L6
        r6.put("suggest_action_type", this.b);     // Catch: Exception -> L6
        r6.put("user_prompt", this.c);     // Catch: Exception -> L6
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
        r0.put("error_type", r3);     // Catch: Exception -> L6
        r0.put("action_type", r4);     // Catch: Exception -> L6
        r0.put("error_msg", r5);     // Catch: Exception -> L6
        r0.put("extra", r6);     // Catch: Exception -> L6
        o.a.reportEvent("prompt_multi_actions_error_monitor", r0);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        g.a.ensureNotReachHere(e);
        return;
    L9:
        r6 = new JSONObject();     // Catch: Exception -> L6
        goto L4
    }
}
