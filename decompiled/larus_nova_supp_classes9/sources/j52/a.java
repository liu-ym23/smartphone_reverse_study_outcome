package j52;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class a {
    public final Queue<h52.c> a;
    public final int b;

    public a(int r1) {
        this.b = r1;
        this.a = new ArrayDeque();
    }

    public void a(h52.c r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Queue<h52.c> r6 = this.a;
        int r7 = this.b;
        Intrinsics.checkNotNullParameter(r6, "$this$addWithCheckMaxSize");
        ArrayDeque r8 = (ArrayDeque) r6;
        r8.add(r3);
        if (r8.size() <= r7) goto L12;
        ArrayList r9 = new ArrayList();
        int r0 = r8.size() - r7;
        if (r0 <= 0) goto L16;
        int r10 = 0;
    L7:
        if (r10 >= r0) goto L17;
        Object r1 = r8.poll();
        if (r1 == null) goto L11;
        r9.add(r1);
    L11:
        r10 = r10 + 1;
        goto L7
    L17:
        return;
    L16:
        return;
    }
}
