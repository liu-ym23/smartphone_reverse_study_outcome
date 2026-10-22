package dmc;

import java.util.HashMap;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final LinkedList<tlc.d> a;
    public final HashMap<Integer, LinkedList<tlc.d>> b;
    public final HashMap<String, LinkedList<tlc.d>> c;
    public final c d;

    public final void a() {
        int r0 = this.d.a;
        if (r0 != (-1)) goto L5;
        return;
    L5:
        if (r0 <= 0) goto L19;
        int r1 = this.a.size() - this.d.a;
        if (r1 <= 0) goto L24;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L25;
        if ((!this.a.isEmpty()) == false) goto L18;
        tlc.d r3 = this.a.removeFirst();
        LinkedList<tlc.d> r4 = this.b.get(Integer.valueOf(r3.getIntType()));
        if (r4 == null) goto L15;
        r4.remove(r3);
    L15:
        LinkedList<tlc.d> r5 = this.c.get(r3.getMessageMethod());
        if (r5 == null) goto L18;
        r5.remove(r3);
    L18:
        r2 = r2 + 1;
        goto L9
    L25:
        return;
    L24:
        return;
    }

    public b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "replayBufferConfig");
        this.d = r2;
        this.a = new LinkedList();
        this.b = new HashMap();
        this.c = new HashMap();
    }
}
