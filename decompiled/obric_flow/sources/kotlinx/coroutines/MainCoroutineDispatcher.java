package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0005¢\u0006\u0004\b\f\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/z;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "parallelism", "name", "limitedParallelism", "(ILjava/lang/String;)Lkotlinx/coroutines/z;", "toStringInternalImpl", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "immediate", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class MainCoroutineDispatcher extends z {
    public MainCoroutineDispatcher() {
    }

    public abstract MainCoroutineDispatcher getImmediate();

    @Override // kotlinx.coroutines.z
    public z limitedParallelism(int r5, String r10) {
        kotlinx.coroutines.internal.f.c(r5);
        if (r10 != null) goto L5;
        return this;
    L5:
        return new kotlinx.coroutines.internal.o(this, r10);
    }

    @Override // kotlinx.coroutines.z
    public String toString() {
        String r5 = toStringInternalImpl();
        if (r5 == null) goto L5;
        return r5;
    L5:
        return getClass().getSimpleName() + '@' + j0.f(this);
    }

    public final String toStringInternalImpl() {
        MainCoroutineDispatcher r5 = Dispatchers.getMain();
        if (this != r5) goto L14;
        return "Dispatchers.Main";
    L14:
        MainCoroutineDispatcher r10 = r5.getImmediate();     // Catch: UnsupportedOperationException -> L9
    L10:
        if (this != r10) goto L13;
        return "Dispatchers.Main.immediate";
    L13:
        return null;
    L9:
        r10 = null;
        goto L10
    }
}
