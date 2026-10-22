package com.bytedance.android.livesdk.gamesticker.hok.machine;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.gamesticker.hok.HokGameStickerView;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class BattleMachine {
    public final StateMachine<c, a, b> a;
    public final HokGameStickerView b;

    public BattleMachine(HokGameStickerView r2) {
        Intrinsics.checkNotNullParameter(r2, "stickerView");
        this.b = r2;
        StateMachine.a r3 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r0 = new BattleMachine$machine$1(this);
        r3.getClass();
        this.a = StateMachine.a.a(r0);
    }

    public final void a(a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Objects.toString(r3);
        StateMachine<c, a, b> r0 = this.a;
        StateMachine.a r1 = StateMachine.c;
        r0.d(r3, null);
    }
}
