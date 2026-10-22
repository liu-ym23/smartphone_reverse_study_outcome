package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g8.g f18953a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.ai.applet.components.view.a f18954b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.ai.applet.components.view.a f18955c = null;
    public static final com.bytedance.ai.applet.components.view.a d = null;

    static {
        f18953a = new g8.g("NO_THREAD_ELEMENTS", 10);
        f18954b = new com.bytedance.ai.applet.components.view.a(5);
        f18955c = new com.bytedance.ai.applet.components.view.a(6);
        d = new com.bytedance.ai.applet.components.view.a(7);
    }

    public static final void a(CoroutineContext r5, Object r10) {
        if (r10 != f18953a) goto L6;
        return;
    L6:
        if ((r10 instanceof z) == false) goto L13;
        z r11 = (z) r10;
        a2[] r12 = r11.f18964c;
        int r13 = r12.length - 1;
        if (r13 < 0) goto L16;
    L9:
        int r14 = r13 - 1;
        a2 r15 = r12[r13];
        Intrinsics.checkNotNull(r15);
        r15.restoreThreadContext(r5, r11.f18963b[r13]);
        if (r14 < 0) goto L17;
        r13 = r14;
        goto L9
    L17:
        return;
    L16:
        return;
    L13:
        Object r16 = r5.fold(null, f18955c);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((a2) r16).restoreThreadContext(r5, r10);
    }

    public static final Object b(CoroutineContext r5) {
        Object r10 = r5.fold(0, f18954b);
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    public static final Object c(CoroutineContext r5, Object r10) {
        if (r10 != null) goto L5;
        r10 = b(r5);
    L5:
        if (r10 != 0) goto L8;
        return f18953a;
    L8:
        if ((r10 instanceof Integer) == true) goto L13;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((a2) r10).updateThreadContext(r5);
    L13:
        return r5.fold(new z(((Number) r10).intValue(), r5), d);
    }
}
