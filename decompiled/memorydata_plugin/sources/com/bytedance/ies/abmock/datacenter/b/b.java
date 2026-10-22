package com.bytedance.ies.abmock.datacenter.b;

import android.os.Build;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\b\u0010\u000e\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/record/ThreadWithBlockingQueue;", "", "()V", "isStopped", "", "isWorking", "queue", "Ljava/util/concurrent/BlockingQueue;", "", "thread", "Ljava/lang/Thread;", "record", "", "key", CommonConsts.APM_INNER_EVENT_COST_START, "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f2671a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Thread f2672b;
    private static final BlockingQueue<String> c = null;
    private static volatile boolean d;
    private static volatile boolean e;

    static {
        f2671a = new b();
        if (Build.VERSION.SDK_INT <= 21) goto L5;
        Object r0 = new LinkedTransferQueue();
    L6:
        c = (BlockingQueue) ZeusTransformUtils.preCheckCast(r0, BlockingQueue.class, "com.obric.memorydata.plugin");
        return;
    L5:
        r0 = new LinkedBlockingQueue();
        goto L6
    }

    private b() {
    }

    private final void a() {
        if (d == true) goto L5;
    L7:
        d = true;
        f2672b = new Thread($$Lambda$b$24GYCrSSfVn4rvTjU7rY8fZy8I.INSTANCE, "ABMockRecord");
        Thread r2 = f2672b;
        if (r2 == null) goto L11;
        r2.start();
        return;
    L11:
        return;
    L5:
        if (f2672b == null) goto L7;
    }

    private static final void b() {
        if (a.f2669a.b() <= 0) goto L8;
        Thread.sleep(a.f2669a.b());
    L8:
        String r0 = (String) ZeusTransformUtils.preCheckCast(c.take(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        a r1 = a.f2669a;     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r0, "key");     // Catch: Throwable -> L7
        r1.a(r0, com.bytedance.ies.abmock.datacenter.storage.b.a().a(r0));     // Catch: Throwable -> L7
    L7:
        e = true;
        goto L8
    }

    /* JADX INFO: renamed from: lambda$24GYCrSS-fVn4rvTjU7rY8fZy8I, reason: not valid java name */
    public static /* synthetic */ void m93lambda$24GYCrSSfVn4rvTjU7rY8fZy8I() {
        b();
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (e == false) goto L5;
        return;
    L5:
        c.offer(r2);
        if (d == true) goto L9;
        a();
        return;
    }
}
