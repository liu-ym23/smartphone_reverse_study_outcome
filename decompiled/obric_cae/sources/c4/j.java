package c4;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<h> f3347a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f3348b = null;

    static {
        f3347a = new CopyOnWriteArraySet();
        f3348b = new ConcurrentHashMap();
    }

    public static void a(i r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        CopyOnWriteArraySet<h> r10 = f3347a;
        if (r10.isEmpty() == false) goto L7;
        return;
    L7:
        Iterator<h> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        r11.next().a(r8);
        goto L9
    }
}
