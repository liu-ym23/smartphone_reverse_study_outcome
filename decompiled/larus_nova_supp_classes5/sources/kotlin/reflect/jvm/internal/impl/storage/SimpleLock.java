package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface SimpleLock {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final DefaultSimpleLock simpleLock(Runnable r2, Function1<? super InterruptedException, Unit> r3) {
            if (r2 == null) goto L6;
            if (r3 == null) goto L6;
            return new CancellableSimpleLock(r2, r3);
        L6:
            return new DefaultSimpleLock(null, 1, null);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void lock();

    void unlock();
}
