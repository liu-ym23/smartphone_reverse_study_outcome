package urb;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.statistics.Statistics;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static void a(String r1, String r2, String r3, Message.Type r4) {
            Intrinsics.checkNotNullParameter(r1, "chatId");
            Intrinsics.checkNotNullParameter(r2, "messageId");
            Intrinsics.checkNotNullParameter(r3, "cId");
            Intrinsics.checkNotNullParameter(r4, "messageType");
            Map r5 = ChatParamUtils.f(r1);
            if (r5 != null) goto L5;
            return;
        L5:
            Statistics.sendEvent("im_chat_main_click", new JSONObject(r5).put("msg_id", r2).put("cid", r3).put("msg_type", ChatParamUtils.k(r4)).put("click", "card").put("target", "none"));
        }
    }

    static {
    }
}
