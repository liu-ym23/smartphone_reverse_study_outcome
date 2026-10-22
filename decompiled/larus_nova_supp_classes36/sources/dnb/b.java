package dnb;

import a2b.l;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class b implements l {
    @Inject
    public b() {
    }

    public final void a(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "chat");
    }

    public final void reset(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
    }
}
