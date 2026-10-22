package e7b;

import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a {
    public final Chat a;
    public final String b;

    public a(Chat r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        Intrinsics.checkNotNullParameter(r3, "rootMsgId");
        this.a = r2;
        this.b = r3;
    }
}
