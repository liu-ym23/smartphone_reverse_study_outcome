package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/panel/h;", "", "invoke", "(Lcom/bytedance/android/live/broadcastgame/opengame/panel/h;)V", "com/bytedance/android/live/broadcastgame/opengame/sonicgame/SonicGamePlugin$getGameCastAbility$1$1$onEndCast$1", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class SonicGamePlugin$getGameCastAbility$$inlined$let$lambda$1$1 extends Lambda implements Function1<com.bytedance.android.live.broadcastgame.opengame.panel.h, Unit> {
    final /* synthetic */ SonicGamePlugin.c this$0;

    public SonicGamePlugin$getGameCastAbility$$inlined$let$lambda$1$1(SonicGamePlugin.c r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(com.bytedance.android.live.broadcastgame.opengame.panel.h r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        ALogger.v("SonicGamePlugin", "忽略，解决编译问题 " + this.this$0.a);
        r3.F();
        r3.i1(true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.live.broadcastgame.opengame.panel.h) r1);
        return Unit.INSTANCE;
    }
}
