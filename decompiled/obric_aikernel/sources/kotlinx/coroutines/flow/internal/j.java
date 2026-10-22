package kotlinx.coroutines.flow.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final void a(AbortFlowException r10, kotlinx.coroutines.flow.d<?> r11) {
        if (r10.owner != r11) goto L5;
        return;
    L5:
        throw r10;
    }
}
