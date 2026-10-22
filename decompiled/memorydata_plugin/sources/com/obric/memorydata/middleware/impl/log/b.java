package com.obric.memorydata.middleware.impl.log;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/middleware/impl/log/PendingALogCache;", "", "<init>", "()V", "MAX_SIZE", "", "lock", "cacheList", "Ljava/util/LinkedList;", "Lcom/obric/memorydata/middleware/impl/log/PendingALogItem;", "add", "", "item", "consumeCache", "Ljava/util/Queue;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11751a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f11752b = null;
    private static LinkedList<c> c;

    static {
        f11751a = new b();
        f11752b = new Object();
        c = new LinkedList();
    }

    private b() {
    }

    public final Queue<c> a() {
        Object r3 = f11752b;
        monitor-enter(r3);
        LinkedList<c> r0 = c;     // Catch: Throwable -> L7
        c = new LinkedList();     // Catch: Throwable -> L7
        Queue<c> r1 = (Queue) ZeusTransformUtils.preCheckCast(r0, Queue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r3);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(c r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Object r2 = f11752b;
        monitor-enter(r2);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (c.size() < 2000) goto L7;
        c.removeFirst();     // Catch: Throwable -> L10
    L7:
        c.add(r3);     // Catch: Throwable -> L10
        monitor-exit(r2);
    }
}
