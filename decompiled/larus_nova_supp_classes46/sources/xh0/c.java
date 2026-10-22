package xh0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final String a(g r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$getString");
        StringBuilder r0 = new StringBuilder();
        r0.append("{tag: " + r4.a + ' ');
        r0.append("key: " + r4.b + ' ');
        r0.append("result: " + r4.c + ' ');
        r0.append("reason: " + r4.d + ' ');
        r0.append("toast: " + r4.e + '}');
        return r0.toString();
    }
}
