package kotlinx.coroutines.flow.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends kotlinx.coroutines.internal.r {
    @Override // kotlinx.coroutines.r1
    public final boolean A(Throwable r5) {
        if ((r5 instanceof ChildCancelledException) == false) goto L7;
        return true;
    L7:
        return w(r5);
    }
}
