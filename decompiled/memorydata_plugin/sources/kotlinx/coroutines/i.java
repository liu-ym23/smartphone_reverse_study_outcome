package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
public final class i {
    public static final <T> T a(CoroutineContext r2, Function2<? super al, ? super Continuation<? super T>, ? extends Object> r3) {
        return (T) j.a((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object a(CoroutineContext r2, Function2 r3, int r4, Object r5) {
        return j.a((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public static final <T> Object a(CoroutineContext r2, Function2<? super al, ? super Continuation<? super T>, ? extends Object> r3, Continuation<? super T> r4) {
        return k.a((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final bx a(al r2, CoroutineContext r3, CoroutineStart r4, Function2<? super al, ? super Continuation<? super Unit>, ? extends Object> r5) {
        return k.a((al) ZeusTransformUtils.wrapperContextForParams(r2, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin"), r4, (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ bx a(al r8, CoroutineContext r9, CoroutineStart r10, Function2 r11, int r12, Object r13) {
        return k.a((al) ZeusTransformUtils.wrapperContextForParams(r8, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r9, CoroutineContext.class, "com.obric.memorydata.plugin"), r10, (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin"), r12, r13);
    }

    public static final <T> ar<T> b(al r2, CoroutineContext r3, CoroutineStart r4, Function2<? super al, ? super Continuation<? super T>, ? extends Object> r5) {
        return k.b((al) ZeusTransformUtils.wrapperContextForParams(r2, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin"), r4, (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ ar b(al r8, CoroutineContext r9, CoroutineStart r10, Function2 r11, int r12, Object r13) {
        return k.b((al) ZeusTransformUtils.wrapperContextForParams(r8, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r9, CoroutineContext.class, "com.obric.memorydata.plugin"), r10, (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin"), r12, r13);
    }
}
