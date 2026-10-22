package com.larus.bmhome.taskskill;

import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r4) {
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter(r4, "toStatus");
        o r0 = o.a;
        JSONObject r2 = new JSONObject();
        r2.put("current_page", "chat");
        r2.put("to_status", r4);
        Unit r5 = Unit.INSTANCE;
        r0.reportEvent("local_computer_use_entrance_click", r2);
    }

    public static void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "clickFrom");
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("current_page", "chat");
        r1.put("setting_item", "operation_permission");
        r1.put("click_from", r4);
        Unit r5 = Unit.INSTANCE;
        r0.reportEvent("super_task_setting_confirm", r1);
    }
}
