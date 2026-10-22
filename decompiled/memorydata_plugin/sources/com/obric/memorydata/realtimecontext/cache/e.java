package com.obric.memorydata.realtimecontext.cache;

import android.content.ComponentName;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.obric.memorydata.realtimecontext.cache.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J3\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u00002\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0012J\u0006\u0010\u001a\u001a\u00020\u0012R\u0010\u0010\u0005\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/realtimecontext/cache/SafeCache;", "K", "C", "Lcom/obric/memorydata/realtimecontext/cache/BaseCache;", "", "cache", "<init>", "(Lcom/obric/memorydata/realtimecontext/cache/BaseCache;)V", "Lcom/obric/memorydata/realtimecontext/cache/BaseCache;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "readAndUpdateKey", "Lcom/obric/memorydata/realtimecontext/cache/CacheResult;", "componentName", "Landroid/content/ComponentName;", "key", "(Landroid/content/ComponentName;Ljava/lang/Object;)Lcom/obric/memorydata/realtimecontext/cache/CacheResult;", "writeValue", "", "newMetaValues", "", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "newAppEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;)V", "clearCaching", "clear", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class e<K, C extends a<K>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C f12455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReentrantLock f12456b;

    public e(C r2) {
        Intrinsics.checkNotNullParameter(r2, "cache");
        this.f12455a = r2;
        this.f12456b = new ReentrantLock();
    }

    public final c a(ComponentName r4, K r5) {
        Intrinsics.checkNotNullParameter(r4, "componentName");
        this.f12456b.lock();
        C r0 = this.f12455a;     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(r0.c(), r4) == true) goto L6;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L11;
        r0.a(r5);     // Catch: Throwable -> L14
        r0.a(State.CACHING);     // Catch: Throwable -> L14
        r0.a(r4);     // Catch: Throwable -> L14
        r0.b(CollectionsKt.emptyList());     // Catch: Throwable -> L14
        r0.a(CollectionsKt.emptyList());     // Catch: Throwable -> L14
    L11:
        c r6 = new c(r1, r0.b(), r0.e(), r0.d());     // Catch: Throwable -> L14
        this.f12456b.unlock();
        return r6;
    L6:
        if (r0.b(r5) == false) goto L8;
        r1 = true;
    L14:
        th = move-exception;
        this.f12456b.unlock();
        throw th;
    }

    public final void a() {
        this.f12456b.lock();
    L8:
        th = move-exception;
        this.f12456b.unlock();
        throw th;
    L4:
        if (this.f12455a.b() != State.CACHING) goto L6;
        this.f12455a.f();     // Catch: Throwable -> L8
    L6:
        this.f12456b.unlock();
    }

    public final void a(K r4, List<? extends MetaValue> r5, List<? extends AppEntity> r6) {
        List<? extends MetaValue> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<? extends AppEntity> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.f12456b.lock();
        if (r7 == null) goto L18;
        if (r8 == null) goto L18;
        C r0 = this.f12455a;     // Catch: Throwable -> L21
        if (r4 != r0.a()) goto L9;
        boolean r9 = true;
    L10:
        if (r9 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L15;
        r0.a(State.CACHED);     // Catch: Throwable -> L21
        r0.b(r7);     // Catch: Throwable -> L21
        r0.a(r8);     // Catch: Throwable -> L21
    L16:
        this.f12456b.unlock();
        return;
    L15:
        ((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin")).f12455a.f();     // Catch: Throwable -> L21
        goto L16
    L9:
        r9 = false;
    L18:
        this.f12455a.f();     // Catch: Throwable -> L21
        this.f12456b.unlock();
        return;
    L21:
        th = move-exception;
        this.f12456b.unlock();
        throw th;
    }

    public final void b() {
        this.f12456b.lock();
        this.f12455a.f();     // Catch: Throwable -> L6
        this.f12456b.unlock();
        return;
    L6:
        th = move-exception;
        this.f12456b.unlock();
        throw th;
    }
}
