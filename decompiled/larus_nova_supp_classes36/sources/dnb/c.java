package dnb;

import a2b.l;
import com.ss.android.lark.chat.entity.chat.Chat;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class c implements l {
    @Inject
    public c() {
    }

    public final void a(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "chat");
    }

    public final void reset(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
    }
}
