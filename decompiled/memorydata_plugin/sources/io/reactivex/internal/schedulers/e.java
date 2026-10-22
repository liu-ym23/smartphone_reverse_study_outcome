package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.u;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends u {
    private static final RxThreadFactory d = null;
    final ThreadFactory c;

    static {
        d = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    }

    public e() {
        this(d);
    }

    public e(ThreadFactory r3) {
        this.c = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r3, ThreadFactory.class, "com.obric.memorydata.plugin");
    }

    @Override // io.reactivex.u
    public u.c a() {
        return new f(this.c);
    }
}
