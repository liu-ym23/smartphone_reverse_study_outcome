package o2b;

import jdb.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static boolean a;
    public static boolean b;

    static {
    }

    public static boolean a(g r1) {
        Intrinsics.checkNotNullParameter(r1, "fgService");
        if (b == true) goto L6;
        a = r1.isEnable("im.messenger.new_recall");
        b = true;
    L6:
        return a;
    }
}
