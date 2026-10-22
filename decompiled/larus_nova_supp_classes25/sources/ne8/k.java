package ne8;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public k() {
    }

    public static /* synthetic */ void b(Context r10, String r11, boolean r12, Message r13, String r14, BotModel r15, Long r16, String r17, String r18) {
        a(r10, r11, r12, r13, r14, r15, r16, r17, r18, "chat");
    }

    public static void a(Context r3, String r4, boolean r5, Message r6, String r7, BotModel r8, Long r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "resourceId");
        if (r6 == null) goto L16;
        if (r7 == null) goto L17;
        if (r8 == null) goto L18;
        if (r5 == false) goto L9;
        String r0 = "//flow/deep_research_process";
    L10:
        com.bytedance.router.i r13 = SmartRouter.buildRoute(r3, r0);
        String r1 = r6.getMessageId();
        r13.c.putExtra("deep_research_message_id", r1);
        r13.c.putExtra("deep_research_message", r6);
        r13.c.putExtra("deep_research_bot_model", r8);
        r13.c.putExtra("deep_research_resource_id", r4);
        Map r14 = r6.getExt();
        if (r14 == null) goto L13;
        String r15 = (String) r14.get("deep_research_id");
    L14:
        r13.c.putExtra("deep_research_mob_research_id", r15);
        r13.c.putExtra("deep_research_conversation_id", r7);
        r13.c.putExtra("deep_research_unique_chat_key", r9);
        r13.c.putExtra("deep_research_is_process_resource", r5);
        r13.c.putExtra("deep_research_process_detail", r10);
        r13.c.putExtra("deep_research_enter_method", r11);
        r13.c.putExtra("deep_research_previous_page", r12);
        r13.d = 2130772401;
        r13.e = 2130772399;
        r13.d();
        return;
    L13:
        r15 = null;
        goto L14
    L9:
        r0 = "//flow/deep_research";
        goto L10
    L18:
        return;
    L17:
        return;
    }
}
