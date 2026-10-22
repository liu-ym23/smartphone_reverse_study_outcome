package com.bytedance.android.live.messagewindow.framework.ability;

import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements SingleOnSubscribe {
    public final /* synthetic */ CardAbilityPlatformImpl a;

    public e(CardAbilityPlatformImpl r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        i r5 = this.a.p;
        if (r5 == null) goto L6;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r0 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_msg_card_show_success");
        r0.b("card_id", this.a.q.j);
        Unit r1 = Unit.INSTANCE;
        r5.b(r0.a());
        return;
    }
}
