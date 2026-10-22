package com.obric.memorydata.personalcontext.search.bridge.a;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\tJ\u001c\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\tJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\bJ\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\bJ\b\u0010\u0014\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/context/SearchVariablesManager;", "", "<init>", "()V", "counter", "Ljava/util/concurrent/atomic/AtomicLong;", "entitySearchVariableData", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "isDestroyed", "", "onDestroy", "", "saveVariables", "variable", "updateVariables", OaidModel.KEY_ID, "deleteVariables", "getVariable", "generateId", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f12288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Long, List<Object>> f12289b;
    private boolean c;

    public e() {
        this.f12288a = new AtomicLong(1);
        this.f12289b = new ConcurrentHashMap();
    }

    private final long b() {
        return this.f12288a.getAndIncrement();
    }

    public final long a(List<? extends Object> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "variable");
        if (this.c == false) goto L6;
        return 0;
    L6:
        long r2 = b();
        Long r0 = Long.valueOf(r2);
        ((Map) ZeusTransformUtils.preCheckCast(this.f12289b, Map.class, "com.obric.memorydata.plugin")).put(r0, r7);
        return r2;
    }

    public final List<Object> a(long r3) {
        if (this.c == false) goto L7;
        return null;
    L7:
        if (r3 != 0) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return (List) ZeusTransformUtils.preCheckCast(this.f12289b.get(Long.valueOf(r3)), List.class, "com.obric.memorydata.plugin");
    }

    public final void a() {
        this.f12289b.clear();
        this.c = true;
    }
}
