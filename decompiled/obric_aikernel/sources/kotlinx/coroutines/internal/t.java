package kotlinx.coroutines.internal;

import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f10584a = null;

    static {
        f10584a = new i0("CONDITION_FALSE");
    }

    public static final Object a() {
        return f10584a;
    }

    @PublishedApi
    public static final LockFreeLinkedListNode b(Object r10) {
        if ((r10 instanceof c0) == false) goto L5;
        c0 r11 = (c0) r10;
    L6:
        if (r11 == null) goto L9;
        LockFreeLinkedListNode r12 = r11.f10543a;
        if (r12 == null) goto L9;
        return r12;
    L9:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (LockFreeLinkedListNode) r10;
    L5:
        r11 = null;
        goto L6
    }
}
