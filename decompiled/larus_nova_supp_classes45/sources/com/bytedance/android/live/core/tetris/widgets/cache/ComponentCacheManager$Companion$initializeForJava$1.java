package com.bytedance.android.live.core.tetris.widgets.cache;

import androidx.core.util.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/widgets/cache/c$a;", "", "invoke", "(Lcom/bytedance/android/live/core/tetris/widgets/cache/c$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ComponentCacheManager$Companion$initializeForJava$1 extends Lambda implements Function1<c.a, Unit> {
    final /* synthetic */ Consumer $consumer;

    public ComponentCacheManager$Companion$initializeForJava$1(Consumer r1) {
        this.$consumer = r1;
        super(1);
    }

    public final void invoke(c.a r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        this.$consumer.accept(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((c.a) r1);
        return Unit.INSTANCE;
    }
}
