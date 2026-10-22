package com.bytedance.android.live.producer;

import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.context.PlatformExpRoomContext;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends i61.a {
    public static final Keva d = null;
    public final Lazy c;

    public static final class a {
    }

    public final String a() {
        return "KeepLastPerfProducer";
    }

    static {
        d = Keva.getRepo("exp_opt_keep_last_perf");
    }

    public final void onRelease() {
        if (o61.a.c == null) goto L5;
        long r2 = System.currentTimeMillis();
        d.storeLong("key_last_perf_sp", r2);
    L6:
        super.onRelease();
        return;
    L5:
        d.storeLong("key_last_perf_sp", -1);
        goto L6
    }

    public final void launch() {
        long r0 = System.currentTimeMillis();
        Keva r2 = d;
        boolean r8 = true;
        if ((r0 - r2.getLong("key_last_perf_sp", -1)) <= (PlatformExpUtils.c().d() * ((long) 1000))) goto L5;
    L7:
        boolean r1 = false;
    L8:
        o61.a.m = false;
        if (r1 == true) goto L11;
        o61.a.c = null;
    L11:
        boolean r3 = o61.a.d;
        if (PlatformExpUtils.b() == false) goto L14;
        r3 = ((Boolean) o61.a.f.a).booleanValue();
    L14:
        if (r3 == true) goto L16;
    L19:
        r8 = false;
    L20:
        if (r8 == false) goto L25;
        n61.a r4 = o61.a.c;
        if (r4 != null) goto L24;
        return;
    L24:
        ExpOptLog.c.a("性能等级继承:" + r4);
        b(r4);
        return;
    L25:
        o61.a.j.clear();
        SimpleAlogArgsBuilder r5 = new SimpleAlogArgsBuilder();
        r5.d((String) this.c.getValue());
        r5.c("条件不满足，不继承上次的性能等级");
        ExpOptLog.d(r5.b());
        return;
    L16:
        if (r2.getLong("key_last_perf_sp", -1) <= 0) goto L19;
        if (r1 == false) goto L19;
    L5:
        if (o61.a.m == true) goto L7;
        r1 = true;
        goto L8
    }

    public c(PlatformExpRoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = LazyKt.lazy(KeepLastPerfProducer$tag$2.INSTANCE);
    }
}
