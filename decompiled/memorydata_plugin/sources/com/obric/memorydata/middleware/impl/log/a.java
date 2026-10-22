package com.obric.memorydata.middleware.impl.log;

import com.ss.android.agilelogger.f;
import com.ss.android.agilelogger.utils.FormatUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/impl/log/ALogCacheCallback;", "Lcom/ss/android/agilelogger/ILogCacheCallback;", "<init>", "()V", "getCachedLog", "Ljava/util/Queue;", "Lcom/ss/android/agilelogger/LogItem;", "notifyCacheLogConsumed", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements com.ss.android.agilelogger.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11750a = null;

    static {
        f11750a = new a();
    }

    private a() {
    }

    @Override // com.ss.android.agilelogger.c
    public Queue<f> a() {
        LinkedList r6 = new LinkedList();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(b.f11751a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Object r1 = r0.next();
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin");
        c r2 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.memorydata.plugin");
        f r4 = new f();
        r4.f15012b = r2.a();
        r4.c = r2.b();
        r4.f = r2.c();
        r4.e = FormatUtils.TYPE.MSG;
        r3.add(r4);
        goto L4
    L6:
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin");
        return (Queue) ZeusTransformUtils.preCheckCast(r6, Queue.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.agilelogger.c
    public void b() {
    }
}
