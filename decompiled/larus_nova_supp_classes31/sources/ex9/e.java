package ex9;

import com.larus.office.OfficeInputParam;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static ax9.c a;
    public static OfficeInputParam b;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final CopyOnWriteArrayList<vm9.c> e = null;

    static {
        c = LazyKt.lazy(new c());
        d = LazyKt.lazy(new d());
        e = new CopyOnWriteArrayList();
    }

    public static a a() {
        return (a) c.getValue();
    }

    public static vm9.c b() {
        return (vm9.c) CollectionsKt.lastOrNull(e);
    }
}
