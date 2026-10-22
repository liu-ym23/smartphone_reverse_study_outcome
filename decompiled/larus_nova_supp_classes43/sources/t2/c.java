package t2;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final String a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r0 = UriProtector.parse(r10).getPath();
        if (r0 == null) goto L11;
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        return r0;
    L11:
        return StringsKt.substringBefore$default(r10, '?', null, 2, null);
    }
}
