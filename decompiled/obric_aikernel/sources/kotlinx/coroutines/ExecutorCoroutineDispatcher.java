package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.ExperimentalStdlibApi;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {

    @ExperimentalStdlibApi
    public static final class Key extends AbstractCoroutineContextKey<CoroutineDispatcher, ExecutorCoroutineDispatcher> {
        private Key() {
            super(CoroutineDispatcher.Key, AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ Key(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new Key(null);
    }

    public ExecutorCoroutineDispatcher() {
    }

    public abstract Executor c0();
}
