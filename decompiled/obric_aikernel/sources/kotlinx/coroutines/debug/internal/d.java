package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
public final class d<T> extends WeakReference<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final int f10374a;

    public d(T r10, ReferenceQueue<T> r11) {
        super(r10, r11);
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        this.f10374a = r12;
        return;
    L5:
        r12 = 0;
        goto L6
    }
}
