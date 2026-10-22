package gd;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f17087a = null;

    static {
        f17087a = new LinkedHashMap();
    }

    public static void a() {
        LinkedHashMap r5 = f17087a;
        monitor-enter(r5);
        Iterator r10 = r5.entrySet().iterator();     // Catch: Throwable -> L9
        if (r10.hasNext() == true) goto L12;
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r5);
        return;
    L12:
        if (((Map.Entry) r10.next()).getValue() != null) goto L16;
        throw null;     // Catch: Throwable -> L9
    L16:
        throw new ClassCastException();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
