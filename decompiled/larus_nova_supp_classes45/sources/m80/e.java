package m80;

import com.bytedance.android.live.core.utils.rxutils.autodispose.OutsideScopeException;
import com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle.LifecycleEndedException;
import com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle.LifecycleNotStartedException;
import com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle.LifecycleScopeProvider;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final b a = null;

    /* JADX WARN: Type inference failed for: r0v0, types: [m80.b] */
    static {
        a = new b();
    }

    public static Completable a(LifecycleScopeProvider r3) throws OutsideScopeException {
        Object r0 = r3.peekLifecycle();
        a r1 = r3.correspondingEvents();
        if (r0 == null) goto L20;
        final Object r2 = r1.apply(r0);     // Catch: Exception -> L13
        Observable r4 = r3.lifecycle();
        if ((r2 instanceof Comparable) == false) goto L8;
        final b r5 = a;
    L9:
        if (r5 == null) goto L11;
        Predicate r6 = new c(r5, r2);
    L23:
        return r4.skip(1).takeUntil(r6).ignoreElements();
    L11:
        r6 = new d(r2);
        goto L23
    L8:
        r5 = null;
    L13:
        e = move-exception;
        if ((e instanceof LifecycleEndedException) == false) goto L17;
        throw e;
    L17:
        return Completable.error(e);
    L20:
        throw new LifecycleNotStartedException();
    }
}
