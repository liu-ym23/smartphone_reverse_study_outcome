package qha;

import com.larus.bmhome.actionbar.model.z0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f {
    public static final String a(z0 r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.H;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (String) r2.get("KEY_FILE_OR_WEB_ADDRESS");
    }
}
