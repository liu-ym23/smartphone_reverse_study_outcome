package q7b;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(y6b.c<?> r3, m2b.a r4) {
        Intrinsics.checkNotNullParameter(r4, "chatContent");
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.i == true) goto L8;
        return false;
    L8:
        if (r4.X() == false) goto L10;
        return false;
    L10:
        if (r4.h() == false) goto L12;
        return false;
    L12:
        if (r4.o() == false) goto L14;
        return false;
    L14:
        if (MessageDLPState.BLOCK != r3.D) goto L16;
        return false;
    L16:
        if (r4.B8() == false) goto L18;
        return false;
    L18:
        if (r3.z == false) goto L20;
        return false;
    L20:
        if (r4.isAIChat() == false) goto L22;
        return false;
    L22:
        if (r3.getType() == Message.Type.TEXT) goto L24;
    L25:
        return true;
    L24:
        if (r3.N == true) goto L25;
        return false;
    }
}
