package s1a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b extends FragmentManager.FragmentLifecycleCallbacks {
    public static final b a = null;
    public static final WeakHashMap<Fragment, t1a.b> b = null;
    public static final WeakHashMap<FragmentManager, Unit> c = null;

    static {
        a = new b();
        b = new WeakHashMap();
        c = new WeakHashMap();
    }

    public b() {
    }

    public final synchronized void onFragmentDetached(FragmentManager r2, Fragment r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r3, "fragment");     // Catch: Throwable -> L10
        if (r3.isRemoving() == false) goto L6;
    L7:
        b.remove(r3);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L6:
        if (r2.isDestroyed() == false) goto L8;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized t1a.b a(Fragment r3, FragmentManager r4, t1a.b r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "fragment");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r4, "manager");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r5, "context");     // Catch: Throwable -> L13
        if (c.put(r4, Unit.INSTANCE) != null) goto L6;
        r4.registerFragmentLifecycleCallbacks(this, false);     // Catch: Throwable -> L13
    L6:
        WeakHashMap<Fragment, t1a.b> r6 = b;     // Catch: Throwable -> L13
        t1a.b r0 = r6.get(r3);     // Catch: Throwable -> L13
        if (r0 != null) goto L9;
        r6.put(r3, r5);     // Catch: Throwable -> L13
    L10:
        t1a.b r7 = r5;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r7;
    L9:
        r5 = r0;
    L13:
        th = move-exception;
        throw th;
    }
}
