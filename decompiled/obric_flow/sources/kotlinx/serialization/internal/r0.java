package kotlinx.serialization.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile SoftReference f19338a;

    public final synchronized Object a(Function0 r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "factory");     // Catch: Throwable -> L10
        Object r10 = this.f19338a.get();     // Catch: Throwable -> L10
        if (r10 == null) goto L7;
        monitor-exit(this);
        return r10;
    L7:
        Object r11 = r5.invoke();     // Catch: Throwable -> L10
        this.f19338a = new SoftReference(r11);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r11;
    L10:
        th = move-exception;
        throw th;
    }
}
