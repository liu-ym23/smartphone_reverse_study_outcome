package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineContext f10364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<StackTraceElement> f10365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineStackFrame f10366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<StackTraceElement> f10367d;

    public b(DebugCoroutineInfoImpl r10, CoroutineContext r11) {
        this.f10364a = r11;
        r10.d();
        this.f10365b = r10.e();
        r10.g();
        this.f10366c = r10.f();
        this.f10367d = r10.h();
    }
}
