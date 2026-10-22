package hm0;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import h71.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class a<Session> implements f.a<Session> {
    public final Session a;
    public final List<f<Session>> b;
    public final int c;

    public final Session d() {
        return this.a;
    }

    public final void a(Session r4) {
        if (this.c >= this.b.size()) goto L7;
        ((f) ListProtector.get(this.b, this.c)).a(new a(r4, this.b, this.c + 1));
        return;
    L7:
        throw new AssertionError("index out of size, AbsProcessChain is " + this);
    }

    public a(Session r2, List<? extends f<Session>> r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "processors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
