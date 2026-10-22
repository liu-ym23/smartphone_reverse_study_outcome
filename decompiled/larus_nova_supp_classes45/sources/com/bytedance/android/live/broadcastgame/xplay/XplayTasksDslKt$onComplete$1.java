package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/l1;", "Lcom/bytedance/android/live/broadcastgame/xplay/m1;", "it", "", "invoke", "(Lcom/bytedance/android/live/broadcastgame/xplay/l1;Lcom/bytedance/android/live/broadcastgame/xplay/m1;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class XplayTasksDslKt$onComplete$1 extends Lambda implements Function2<l1, m1, Unit> {
    final /* synthetic */ Function2 $callback;

    public XplayTasksDslKt$onComplete$1(Function2 r1) {
        this.$callback = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((l1) r1, (m1) r2);
        return Unit.INSTANCE;
    }

    public final void invoke(l1 r2, m1 r3) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        Intrinsics.checkNotNullParameter(r3, "it");
        if ((r3 instanceof m1.b) == false) goto L6;
        this.$callback.invoke(r2, r3);
        return;
    }
}
