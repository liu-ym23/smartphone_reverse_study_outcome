package il8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final boolean a(jc8.a r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.a.isFinish() == true) goto L17;
        Message r5 = r4.j();
        if (r5.getMessageStatusLocal() != 21) goto L7;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == true) goto L18;
        return false;
    L18:
        return true;
    L7:
        if (r5.getMessageStatusLocal() == 23) goto L12;
        if (r5.getMessageStatusLocal() == 22) goto L12;
        r6 = false;
        goto L13
    L17:
        return true;
    }
}
