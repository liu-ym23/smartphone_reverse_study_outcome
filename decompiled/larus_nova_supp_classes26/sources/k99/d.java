package k99;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final boolean a(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("is_offline_msg");
    L7:
        return Intrinsics.areEqual(r3, "1");
    L5:
        r3 = null;
        goto L7
    }
}
