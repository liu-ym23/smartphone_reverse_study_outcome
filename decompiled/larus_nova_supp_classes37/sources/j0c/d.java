package j0c;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class d {
    public final f0c.b a;
    public final a b;
    public final List<f0c.b> c;

    public /* synthetic */ d(f0c.b r2, a r3) {
        this(r2, r3, new ArrayList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(f0c.b r2, a r3, List<? extends f0c.b> r4) {
        Intrinsics.checkNotNullParameter(r2, "globalState");
        Intrinsics.checkNotNullParameter(r3, "taskResult");
        Intrinsics.checkNotNullParameter(r4, "backgroundStateList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
