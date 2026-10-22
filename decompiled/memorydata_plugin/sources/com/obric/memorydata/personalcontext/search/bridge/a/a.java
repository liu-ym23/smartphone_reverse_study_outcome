package com.obric.memorydata.personalcontext.search.bridge.a;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/context/EntitySearchContext;", "", "<init>", "()V", "isDestroyed", "", "searchParamsManager", "Lcom/obric/memorydata/personalcontext/search/bridge/context/SearchParamsManager;", "getSearchParamsManager", "()Lcom/obric/memorydata/personalcontext/search/bridge/context/SearchParamsManager;", "parallelTaskManager", "Lcom/obric/memorydata/personalcontext/search/bridge/context/ParallelTaskManager;", "getParallelTaskManager", "()Lcom/obric/memorydata/personalcontext/search/bridge/context/ParallelTaskManager;", "paginationTaskManager", "Lcom/obric/memorydata/personalcontext/search/bridge/context/SearchPaginationTaskManager;", "getPaginationTaskManager", "()Lcom/obric/memorydata/personalcontext/search/bridge/context/SearchPaginationTaskManager;", "searchVariablesManager", "Lcom/obric/memorydata/personalcontext/search/bridge/context/SearchVariablesManager;", "getSearchVariablesManager", "()Lcom/obric/memorydata/personalcontext/search/bridge/context/SearchVariablesManager;", "destroy", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0659a f12280a = null;
    private static final AtomicLong g = null;
    private static final ConcurrentHashMap<String, a> h = null;
    private static final Lazy<a> i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12281b;
    private final d c;
    private final b d;
    private final c e;
    private final e f;

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.search.bridge.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/context/EntitySearchContext$Companion;", "", "<init>", "()V", "counter", "Ljava/util/concurrent/atomic/AtomicLong;", "instances", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/memorydata/personalcontext/search/bridge/context/EntitySearchContext;", "mockEntitySearchContext", "getMockEntitySearchContext", "()Lcom/obric/memorydata/personalcontext/search/bridge/context/EntitySearchContext;", "mockEntitySearchContext$delegate", "Lkotlin/Lazy;", "generateId", "createEntitySearchContext", "getInstance", OaidModel.KEY_ID, "destroyEntitySearchContext", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0659a {
        private C0659a() {
        }

        public /* synthetic */ C0659a(DefaultConstructorMarker r1) {
            this();
        }

        private final a b() {
            return (a) ZeusTransformUtils.preCheckCast(a.g().getValue(), a.class, "com.obric.memorydata.plugin");
        }

        private final String c() {
            return new StringBuilder().append(UUID.randomUUID()).append('_').append(System.currentTimeMillis()).append('_').append(a.h().getAndIncrement()).toString();
        }

        public final a a(String r3) {
            Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
            a r4 = (a) ZeusTransformUtils.preCheckCast(a.i().get(r3), a.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L5;
            return r4;
        L5:
            return b();
        }

        public final String a() {
            monitor-enter(this);
            String r0 = a.f12280a.c();     // Catch: Throwable -> L6
            ((Map) ZeusTransformUtils.preCheckCast(a.i(), Map.class, "com.obric.memorydata.plugin")).put(r0, new a());     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public final void b(String r3) {
            Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
            monitor-enter(this);
            a r4 = (a) ZeusTransformUtils.preCheckCast(a.i().remove(r3), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r4 == null) goto L7;
            r4.e();     // Catch: Throwable -> L10
        L7:
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        f12280a = new C0659a(null);
        g = new AtomicLong(1);
        h = new ConcurrentHashMap();
        i = LazyKt.lazy($$Lambda$a$FLsubojF5uFZgumeWrddNpHO1BA.INSTANCE);
    }

    public a() {
        this.c = new d();
        this.d = new b();
        this.e = new c();
        this.f = new e();
    }

    public static final /* synthetic */ Lazy g() {
        return i;
    }

    public static final /* synthetic */ AtomicLong h() {
        return g;
    }

    public static final /* synthetic */ ConcurrentHashMap i() {
        return h;
    }

    private static final a j() {
        a r0 = new a();
        r0.e();
        return r0;
    }

    public static /* synthetic */ a lambda$FLsubojF5uFZgumeWrddNpHO1BA() {
        return j();
    }

    public final d a() {
        return this.c;
    }

    public final b b() {
        return this.d;
    }

    public final c c() {
        return this.e;
    }

    public final e d() {
        return this.f;
    }

    public final void e() {
        if (this.f12281b == false) goto L5;
        return;
    L5:
        this.f12281b = true;
        this.c.c();
        this.d.b();
        this.e.d();
        this.f.a();
    }

    public final boolean f() {
        return this.f12281b;
    }
}
