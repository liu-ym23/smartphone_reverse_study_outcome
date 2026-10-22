package kotlinx.coroutines.channels;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [R, E] */
/* JADX INFO: loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$zip$1<E, R> extends Lambda implements Function2<E, R, Pair<? extends E, ? extends R>> {
    public static final ChannelsKt__DeprecatedKt$zip$1 INSTANCE = null;

    static {
        INSTANCE = new ChannelsKt__DeprecatedKt$zip$1();
    }

    ChannelsKt__DeprecatedKt$zip$1() {
        super(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r10, Object r11) {
        return invoke(r10, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Pair<E, R> invoke(E r10, R r11) {
        return TuplesKt.to(r10, r11);
    }
}
