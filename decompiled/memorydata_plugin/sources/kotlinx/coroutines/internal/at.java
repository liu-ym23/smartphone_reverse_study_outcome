package kotlinx.coroutines.internal;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.cv;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/ThreadState;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "n", "", "(Lkotlin/coroutines/CoroutineContext;I)V", "elements", "", "Lkotlinx/coroutines/ThreadContextElement;", "[Lkotlinx/coroutines/ThreadContextElement;", "i", "values", "[Ljava/lang/Object;", "append", "", "element", EventBody.KEY_VALUE, "restore", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f17571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f17572b;
    private final cv<Object>[] c;
    private int d;

    public at(CoroutineContext r3, int r4) {
        this.f17571a = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        this.f17572b = new Object[r4];
        this.c = new cv[r4];
    }

    public final void a(CoroutineContext r5) {
        CoroutineContext r6 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin");
        int r0 = this.c.length - 1;
        if (r0 < 0) goto L8;
    L4:
        int r1 = r0 - 1;
        cv<Object> r2 = this.c[r0];
        Intrinsics.checkNotNull(r2);
        r2.a(r6, this.f17572b[r0]);
        if (r1 < 0) goto L10;
        r0 = r1;
        goto L4
    L10:
        return;
    }

    public final void a(cv<?> r3, Object r4) {
        cv<Object> r5 = (cv) ZeusTransformUtils.wrapperContextForParams(r3, cv.class, "com.obric.memorydata.plugin");
        Object[] r0 = this.f17572b;
        int r1 = this.d;
        r0[r1] = r4;
        cv<Object>[] r6 = this.c;
        this.d = r1 + 1;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        r6[r1] = r5;
    }
}
