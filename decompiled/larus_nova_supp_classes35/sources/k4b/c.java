package k4b;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Function1<f5b.b, Boolean> {
    public final Map<String, String> a;

    public c(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "userIdList");
        this.a = r2;
    }

    public final Object invoke(Object r2) {
        f5b.b r3 = (f5b.b) r2;
        Intrinsics.checkNotNullParameter(r3, "p1");
        Map<String, String> r0 = this.a;
        ChatChatter r4 = r3.getMessageSender();
        if (r4 == null) goto L5;
        String r5 = r4.getId();
    L7:
        return Boolean.valueOf(r0.containsKey(r5));
    L5:
        r5 = null;
        goto L7
    }
}
