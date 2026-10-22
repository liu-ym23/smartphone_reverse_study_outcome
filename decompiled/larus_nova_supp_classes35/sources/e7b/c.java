package e7b;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends e7b.a {
    public static final /* synthetic */ int f = 0;
    public final ChatChatter c;
    public final MessageInfo d;
    public MessageInfo e;

    public static final class a {
        public final Chat a;
        public final String b;
        public ChatChatter c;
        public MessageInfo d;
        public MessageInfo e;

        public a(Chat r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "chat");
            Intrinsics.checkNotNullParameter(r3, "rootMsgId");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
    }

    static {
    }

    public c(a r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        Chat r0 = r5.a;
        String r1 = r5.b;
        ChatChatter r2 = r5.c;
        MessageInfo r3 = r5.d;
        MessageInfo r6 = r5.e;
        super(r0, r1);
        this.c = r2;
        this.d = r3;
        this.e = r6;
    }
}
