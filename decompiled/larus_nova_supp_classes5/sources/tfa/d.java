package tfa;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import ei9.f;
import kotlin.jvm.internal.Intrinsics;
import xc8.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements g {
    public final int c() {
        return 101;
    }

    public d() {
    }

    public final boolean a(Object r3) {
        Message r4 = (Message) r3;
        Intrinsics.checkNotNullParameter(r4, "sourceData");
        if (r4.getMessageStatus() != MessageStatus.MessageStatus_INVISIBLE) goto L6;
    L10:
        return false;
    L6:
        if (r4.getContentType() != 800) goto L10;
        if (Intrinsics.areEqual(r4.getBizContentType(), "obric_remote_card") == false) goto L10;
        return true;
    }

    public final f b(Object r2) {
        Message r3 = (Message) r2;
        Intrinsics.checkNotNullParameter(r3, "sourceData");
        return new c(r3);
    }
}
