package j7b;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.k;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final Map<Chat.MessagePosition, d> a;

    /* JADX INFO: renamed from: j7b.a$a, reason: collision with other inner class name */
    public static class C0239a {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public a() {
        this.a = new HashMap(2);
    }

    public final d a(Chat r3) {
        Chat.MessagePosition r4 = k.c(r3);
        d r0 = (d) ((HashMap) this.a).get(r4);
        if (r0 == null) goto L5;
    L9:
        return r0;
    L5:
        if (r4 != Chat.MessagePosition.NEWEST_UNREAD) goto L7;
        r0 = new b();
    L8:
        ((HashMap) this.a).put(r4, r0);
        goto L9
    L7:
        r0 = new c();
        goto L8
    }
}
