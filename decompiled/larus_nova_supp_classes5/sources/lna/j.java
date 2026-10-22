package lna;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j {
    public static final j a = null;
    public static final Set<Integer> b = null;
    public static final Set<String> c = null;
    public static final Set<String> d = null;
    public static final Set<String> e = null;

    public j() {
    }

    static {
        a = new j();
        b = new LinkedHashSet();
        c = new LinkedHashSet();
        d = new LinkedHashSet();
        e = SetsKt.mutableSetOf(new String[]{"sleep", "Unsafe.park"});
    }
}
