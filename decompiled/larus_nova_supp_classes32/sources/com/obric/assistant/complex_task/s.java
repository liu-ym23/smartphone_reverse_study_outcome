package com.obric.assistant.complex_task;

import com.larus.applog.api.IApplog;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.chat.IObricChatService;
import java.util.Map;
import kl9.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1, String r2, int r3, u r4) {
        if (r4 == null) goto L6;
        Map r5 = r4.s;
        if (r5 == null) goto L6;
        String r6 = (String) r5.get("source_from");
    L6:
        b("obric_omni_asynctask_item_enter", r1, r2, r3);
    }

    public static void b(String r3, String r4, String r5, int r6) {
        JSONObject r0 = new JSONObject();
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
        if (r4 != null) goto L5;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r0.put("instruction_id", r4);
        if (r5 != null) goto L8;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        r0.put("o_reference_message_id", r5);
        IObricChatService.a.getClass();
        IObricChatService r7 = IObricChatService.a.a();
        if (r7 == null) goto L13;
        BotModel r8 = r7.j0();
        if (r8 == null) goto L13;
        String r9 = r8.getBotId();
    L14:
        if (r9 == null) goto L17;
        r1 = r9;
    L17:
        r0.put("bot_id", r1);
        r0.put("total_task_cnt", r6);
        r0.optString("bot_id");
        FLogger.a.i("ObricAsyncTaskMobHelper", "reportTaskEvent: event=" + r3 + ", params=" + r0);
        IApplog.a.reportEvent(r3, r0);
        return;
    L13:
        r9 = null;
        goto L14
    }
}
