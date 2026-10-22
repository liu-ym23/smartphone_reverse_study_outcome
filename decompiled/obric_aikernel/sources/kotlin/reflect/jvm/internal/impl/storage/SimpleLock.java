package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public interface SimpleLock {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final DefaultSimpleLock simpleLock(Runnable r10, Function1<? super InterruptedException, Unit> r11) {
            if (r10 == null) goto L6;
            if (r11 == null) goto L6;
            return new CancellableSimpleLock(r10, r11);
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
