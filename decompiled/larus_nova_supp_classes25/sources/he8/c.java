package he8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.spi.IAIChatService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements je8.a {
    public c() {
    }

    public final boolean a(Object r3) {
        Message r4 = (Message) r3;
        Intrinsics.checkNotNullParameter(r4, "sourceData");
        if (com.larus.im.bean.message.a.b0(r4) == true) goto L6;
    L13:
        return false;
    L6:
        if (r4.getMessageStatus() == MessageStatus.MessageStatus_INVISIBLE) goto L13;
        if (IAIChatService.a.B7(r4) != null) goto L13;
        if (com.larus.bmhome.chat.bean.d.G0(r4) == true) goto L13;
        return true;
    }

    public final ei9.f b(Object r2) {
        Message r3 = (Message) r2;
        Intrinsics.checkNotNullParameter(r3, "sourceData");
        return new b(r3);
    }
}
