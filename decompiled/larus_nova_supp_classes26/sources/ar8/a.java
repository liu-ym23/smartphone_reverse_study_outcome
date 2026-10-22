package ar8;

import com.larus.bmhome.miniartifact.input.MiniArtifactInputComponent;
import com.larus.platform.service.o;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r2, String r3, String r4, String r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r2 == null) goto L5;
        r0.put("current_page", r2);
    L5:
        if (r3 == null) goto L7;
        r0.put("previous_page", r3);
    L7:
        if (r4 == null) goto L9;
        r0.put("enter_method", r4);
    L9:
        if (r5 == null) goto L11;
        r0.put("artifact_id", r5);
    L11:
        if (r6 == null) goto L13;
        r0.put("artifact_name", r6);
    L13:
        o.a.reportEvent("enter_page", r0);
    }

    public static void b(String r10, List r11, String r12, String r13, Boolean r14, String r15) {
        JSONObject r0 = new JSONObject();
        if (r11 == null) goto L5;
        r0.put("uris", CollectionsKt.joinToString$default(r11, ",", null, null, 0, null, null, 62, null));
    L5:
        if (r15 == null) goto L7;
        r0.put("current_page", r15);
    L7:
        if (r12 == null) goto L9;
        r0.put("template_id", r12);
    L9:
        if (r13 == null) goto L11;
        r0.put("template_version", r13);
    L11:
        if (r14 == null) goto L13;
        r0.put("enable_config", r14.booleanValue() ? 1 : 0);
    L13:
        int r16 = MiniArtifactInputComponent.A;
        r0.put("is_input_downgrade", MiniArtifactInputComponent.a.a() ? 1 : 0);
        if (r10 == null) goto L16;
        r0.put("input_id", r10);
    L16:
        o.a.reportEvent("rd_mini_artifact_input_send", r0);
    }

    public static void c(String r2, boolean r3, String r4, int r5, long r6, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "status");
        JSONObject r1 = new JSONObject();
        r1.put("status", r2);
        r1.put("has_cache", r3 ? 1 : 0);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r1.put("error_msg", r4);
        r1.put("template_count", r5);
        r1.put("load_duration", r6);
        r1.put("is_first_request", r8 ? 1 : 0);
        r1.put("is_input_downgrade", r9 ? 1 : 0);
        o.a.reportEvent("rd_mini_artifact_list_page_result", r1);
    }
}
