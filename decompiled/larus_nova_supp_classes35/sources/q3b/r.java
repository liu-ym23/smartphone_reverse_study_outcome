package q3b;

import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r implements a2b.j.a {
    public final Chat a;

    @Override // a2b.j.a
    public final String a() {
        return this.a.getAnonymousId();
    }

    public r(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "currentChat");
        this.a = r2;
    }
}
