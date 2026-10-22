package wc0;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final String a(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getFirstUrl");
        List r2 = r1.getUrls();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (String) ListProtector.get(r2, 0);
    }
}
