package g4b;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.r0;
import com.ss.android.lark.chat.utils.w;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(ImageSet r2, Message r3, Chat r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "chat");
        r2.setMessageIdentity(r0.b(r3));
        r2.getMessageIdentity().setSourceId(r3.getId());
        r2.setTranslated(r5);
        r2.setHasPreviewPermission(MessagePermissionUtil.c(r3, r4, null));
        w.a(r2, r3.getValidateIMFileResult());
        r2.setResourceIsCleaned(lpc.a.c(r3));
        r2.setResourceCleanScene(lpc.a.a(r3));
    }
}
