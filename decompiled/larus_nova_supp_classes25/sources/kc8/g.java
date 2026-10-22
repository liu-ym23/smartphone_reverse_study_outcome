package kc8;

import com.larus.im.bean.message.Message;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    @Deprecated(message = "Use renderContext and host bindings")
    public static final Message a(f r46) {
        Intrinsics.checkNotNullParameter(r46, "<this>");
        Message r0 = r46.a;
        if ((r0 instanceof Message) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    }
}
