package com.bytedance.android.live.producer;

import com.bytedance.android.live.core.setting.o4;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.context.PlatformExpRoomContext;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends i61.a {
    public final Lazy c;
    public final Lazy d;

    public final String a() {
        return "BasicPerfSourceProducer";
    }

    public final String c() {
        return (String) this.c.getValue();
    }

    public final void launch() {
        if (((Boolean) o4.a.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        SimpleAlogArgsBuilder r0 = new SimpleAlogArgsBuilder();
        r0.d(c());
        r0.c("注册基础技术性能框架回调，开始监听");
        ExpOptLog.d(r0.b());
        k.n(IPerformanceStrategyManager.class).registerPerformanceStrategyTask(200, (BasePerformanceStrategyTask) this.d.getValue());
        if (PlatformExpUtils.b() == true) goto L8;
        return;
    L8:
        if (o61.a.c != null) goto L16;
        int r1 = k.n(IPerformanceStrategyManager.class).getCurrentPerformanceLevel();
        SimpleAlogArgsBuilder r2 = new SimpleAlogArgsBuilder();
        r2.d(c());
        r2.c("主动获取性能等级");
        ExpOptLog.d(r2.b());
        int r3 = n61.a.d;
        if (r1 != 11) goto L12;
        n61.b.a r4 = n61.b.a.a;
    L13:
        n61.a r5 = n61.a.a.a(r4, r1);
        o61.a.c = r5;
        Unit r6 = Unit.INSTANCE;
        b(r5);
        return;
    L12:
        r4 = n61.b.b.a;
        goto L13
    }

    public a(PlatformExpRoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = LazyKt.lazy(BasicPerfSourceProducer$tag$2.INSTANCE);
        this.d = LazyKt.lazy(new BasicPerfSourceProducer$liveExpStrategyTask$2(this));
    }
}
