package kotlinx.coroutines.channels;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
public final class o {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(y r2, int r3, Continuation r4) {
        return r.a((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(y r2, Object r3, Continuation r4) {
        return r.a((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(y r2, Collection r3, Continuation r4) {
        return r.a((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(y r2, Comparator r3, Continuation r4) {
        return r.a((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> Object a(y<? extends Pair<? extends K, ? extends V>> r2, M r3, Continuation<? super M> r4) {
        return r.a((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <E> Object a(y<? extends E> r2, Continuation<? super List<? extends E>> r3) {
        return q.a((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(y r2, z r3, Continuation r4) {
        return r.a((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (z) ZeusTransformUtils.wrapperContextForParams(r3, z.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final void a(y<?> r2, Throwable r3) {
        q.a((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), r3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object b(y r2, int r3, Continuation r4) {
        return r.b((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object b(y r2, Object r3, Continuation r4) {
        return r.b((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <E, C extends Collection<? super E>> Object b(y<? extends E> r2, C r3, Continuation<? super C> r4) {
        return r.b((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object b(y r2, Comparator r3, Continuation r4) {
        return r.b((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object b(y r2, Continuation r3) {
        return r.a((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <E, C extends z<? super E>> Object b(y<? extends E> r2, C r3, Continuation<? super C> r4) {
        return r.b((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (z) ZeusTransformUtils.wrapperContextForParams(r3, z.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object c(y r2, Continuation r3) {
        return r.b((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object d(y r2, Continuation r3) {
        return r.c((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object e(y r2, Continuation r3) {
        return r.d((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object f(y r2, Continuation r3) {
        return r.e((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object g(y r2, Continuation r3) {
        return r.f((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object h(y r2, Continuation r3) {
        return r.g((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object i(y r2, Continuation r3) {
        return r.h((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object j(y r2, Continuation r3) {
        return r.i((y) ZeusTransformUtils.wrapperContextForParams(r2, y.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
