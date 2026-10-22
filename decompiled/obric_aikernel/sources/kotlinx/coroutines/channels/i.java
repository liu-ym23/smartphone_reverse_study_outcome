package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(ReceiveChannel r10, Continuation r11) {
        return ChannelsKt__DeprecatedKt.a(r10, r11);
    }

    @PublishedApi
    public static final void b(ReceiveChannel<?> r10, Throwable r11) {
        ChannelsKt__Channels_commonKt.a(r10, r11);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object c(ReceiveChannel r10, Continuation r11) {
        return ChannelsKt__DeprecatedKt.b(r10, r11);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object d(ReceiveChannel r10, int r11, Continuation r12) {
        return ChannelsKt__DeprecatedKt.c(r10, r11, r12);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object e(ReceiveChannel r10, int r11, Continuation r12) {
        return ChannelsKt__DeprecatedKt.d(r10, r11, r12);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object f(ReceiveChannel r10, Collection r11, Continuation r12) {
        return ChannelsKt__DeprecatedKt.e(r10, r11, r12);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object g(ReceiveChannel r10, n r11, Continuation r12) {
        return ChannelsKt__DeprecatedKt.f(r10, r11, r12);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object h(ReceiveChannel r10, Continuation r11) {
        return ChannelsKt__DeprecatedKt.g(r10, r11);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object i(ReceiveChannel r10, Continuation r11) {
        return ChannelsKt__DeprecatedKt.h(r10, r11);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object j(ReceiveChannel r10, Object r11, Continuation r12) {
        return ChannelsKt__DeprecatedKt.i(r10, r11, r12);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object k(ReceiveChannel r10, Continuation r11) {
        return ChannelsKt__DeprecatedKt.j(r10, r11);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object l(ReceiveChannel r10, Object r11, Continuation r12) {
        return ChannelsKt__DeprecatedKt.k(r10, r11, r12);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object m(ReceiveChannel r10, Continuation r11) {
        return ChannelsKt__DeprecatedKt.l(r10, r11);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object n(ReceiveChannel r10, Comparator r11, Continuation r12) {
        return ChannelsKt__DeprecatedKt.m(r10, r11, r12);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object o(ReceiveChannel r10, Comparator r11, Continuation r12) {
        return ChannelsKt__DeprecatedKt.n(r10, r11, r12);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object p(ReceiveChannel r10, Continuation r11) {
        return ChannelsKt__DeprecatedKt.o(r10, r11);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object q(ReceiveChannel r10, Continuation r11) {
        return ChannelsKt__DeprecatedKt.p(r10, r11);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object r(ReceiveChannel r10, Continuation r11) {
        return ChannelsKt__DeprecatedKt.q(r10, r11);
    }

    @PublishedApi
    public static final <E, C extends n<? super E>> Object s(ReceiveChannel<? extends E> r10, C r11, Continuation<? super C> r12) {
        return ChannelsKt__DeprecatedKt.r(r10, r11, r12);
    }

    @PublishedApi
    public static final <E, C extends Collection<? super E>> Object t(ReceiveChannel<? extends E> r10, C r11, Continuation<? super C> r12) {
        return ChannelsKt__DeprecatedKt.s(r10, r11, r12);
    }

    public static final <E> Object u(ReceiveChannel<? extends E> r10, Continuation<? super List<? extends E>> r11) {
        return ChannelsKt__Channels_commonKt.d(r10, r11);
    }

    @PublishedApi
    public static final <K, V, M extends Map<? super K, ? super V>> Object v(ReceiveChannel<? extends Pair<? extends K, ? extends V>> r10, M r11, Continuation<? super M> r12) {
        return ChannelsKt__DeprecatedKt.t(r10, r11, r12);
    }
}
