package lb;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class h<T> {
    public final Set<T> a;

    public h(Collection<? extends T> r10) {
        this.a = new LinkedHashSet(r10);
    }
}
