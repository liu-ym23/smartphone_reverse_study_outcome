package sr9;

import android.content.Context;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u implements t0 {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
    }

    public final List<ot8.a> a(Context r1, Message r2, Function0<Message> r3, q0 r4, BotModel r5, wc9.e r6, q0.a r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r5, "chatBot");
        return CollectionsKt.emptyList();
    }
}
