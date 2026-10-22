package com.bytedance.android.live.initialize.scheduler;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import wa0.b;
import wa0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class WTOSchedulerNotify {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public final CopyOnWriteArrayList<c> a() {
        return (CopyOnWriteArrayList) this.a.getValue();
    }

    public WTOSchedulerNotify() {
        this.a = LazyKt.lazy(WTOSchedulerNotify$taskListenerList$2.INSTANCE);
        this.b = LazyKt.lazy(WTOSchedulerNotify$scheduleListenerList$2.INSTANCE);
        this.c = LazyKt.lazy(new WTOSchedulerNotify$msgDispatcher$2(this));
    }

    public final com.bytedance.android.live.initialize.model.a b(final b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((CopyOnWriteArrayList) this.b.getValue()).add(r3);
        return new com.bytedance.android.live.initialize.model.a(this, new WTOSchedulerNotify$registerScheduleListener$1(r3));
    }

    public final com.bytedance.android.live.initialize.model.a c(final c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        a().add(r3);
        return new com.bytedance.android.live.initialize.model.a(this, new WTOSchedulerNotify$registerTaskListener$1(r3));
    }

    public final void d(int r3, Object r4) {
        ((Handler) this.c.getValue()).sendMessage(((Handler) this.c.getValue()).obtainMessage(r3, r4));
    }
}
