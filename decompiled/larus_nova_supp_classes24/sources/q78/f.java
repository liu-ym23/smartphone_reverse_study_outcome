package q78;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class f {
    public final Lazy a;

    public abstract void a(List<c> r1);

    public f() {
        this.a = LazyKt.lazy(new d(this));
    }
}
