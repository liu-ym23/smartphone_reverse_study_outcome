package com.bytedance.android.live.producer;

import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.context.PlatformExpRoomContext;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends i61.a {
    public final Lazy c;

    public final String a() {
        return "ForceDegradeProducer";
    }

    public final void launch() {
        fv1.c r0 = com.bytedance.android.live.room.api.experience.utils.a.a;
        if (r0.a() == true) goto L5;
        return;
    L5:
        int r1 = r0.b();
        if (r1 == 1) goto L8;
        LivePerfBizLevel r2 = LivePerfBizLevel.P0;
    L9:
        SimpleAlogArgsBuilder r3 = new SimpleAlogArgsBuilder();
        r3.d((String) this.c.getValue());
        r3.c("producer: force degrade to level" + r1);
        ExpOptLog.d(r3.b());
        f61.a r4 = getContext().getWorkshop();
        k61.a r5 = new k61.a(LivePerfBizType.Degrade, r2);
        r5.a = true;
        Unit r6 = Unit.INSTANCE;
        r4.handleResult(new j61.a(r5));
        return;
    L8:
        r2 = LivePerfBizLevel.P1;
        goto L9
    }

    public b(PlatformExpRoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = LazyKt.lazy(ForceDegradeProducer$tag$2.INSTANCE);
    }
}
