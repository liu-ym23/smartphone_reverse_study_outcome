package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g8.g f18926a = null;

    static {
        f18926a = new g8.g("CLOSED", 10);
    }

    public static final Object a(s r5, long r10, Function2 r11) {
    L3:
        if (r5.f18950c >= r10) goto L5;
    L8:
        Object r12 = b.f18927a.get(r5);
        g8.g r13 = f18926a;
        if (r12 == r13) goto L10;
        s r14 = (s) ((b) r12);
        if (r14 != null) goto L13;
        r14 = (s) r11.mo2invoke(Long.valueOf(r5.f18950c + 1), r5);
    L15:
        AtomicReferenceFieldUpdater r15 = b.f18927a;
        if (r15.compareAndSet(r5, null, r14) == true) goto L18;
        if (r15.get(r5) == null) goto L15;
    L18:
        if (r5.d() == false) goto L13;
        r5.e();
    L13:
        r5 = r14;
        goto L3
    L10:
        return r13;
    L5:
        if (r5.d() == true) goto L8;
        return r5;
    }
}
