package sw9;

import com.larus.office.OfficeInputParam;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static pw9.c a;
    public static volatile ew4.a b;
    public static volatile int c;
    public static volatile boolean d;
    public static volatile boolean e;
    public static OfficeInputParam f;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final CopyOnWriteArrayList<vm9.c> j = null;

    static {
        e = true;
        g = LazyKt.lazy(new d());
        h = LazyKt.lazy(new e());
        i = LazyKt.lazy(new f());
        j = new CopyOnWriteArrayList();
    }

    public static a a() {
        return (a) g.getValue();
    }

    public static vm9.c b() {
        return (vm9.c) CollectionsKt.lastOrNull(j);
    }

    public static b c() {
        return (b) h.getValue();
    }
}
