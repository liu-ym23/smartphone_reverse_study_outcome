package dmc;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class e implements l {
    public final Set<Integer> a;
    public final Set<String> b;
    public final d c;

    public e(Set<Integer> r2, Set<String> r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "messageTypes");
        Intrinsics.checkNotNullParameter(r3, "messageMethods");
        Intrinsics.checkNotNullParameter(r4, "replayConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public /* synthetic */ e(Set r2, Set r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r3 = SetsKt.emptySet();
    L6:
        if ((r4 & 4) == 0) goto L8;
        d r5 = new d(0);
    L9:
        this(r2, r3, r5);
        return;
    L8:
        r5 = null;
        goto L9
    }
}
