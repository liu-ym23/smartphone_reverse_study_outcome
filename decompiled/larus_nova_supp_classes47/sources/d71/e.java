package d71;

import kotlin.jvm.internal.Intrinsics;
import v61.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class e<Window extends v61.c> {
    public final long a;
    public final Window b;

    public e(Window r3) {
        Intrinsics.checkNotNullParameter(r3, "msgWindow");
        this.b = r3;
        this.a = System.currentTimeMillis();
    }
}
