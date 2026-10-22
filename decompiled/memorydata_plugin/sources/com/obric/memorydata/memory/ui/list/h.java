package com.obric.memorydata.memory.ui.list;

import com.obric.aiproactive.api.DoubaoGlassesConnectionState;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/GlassesMemoryTabState;", "", "<init>", "()V", "KEY_EVER_HAD_DATA", "", "revision", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "changes", "Lkotlinx/coroutines/flow/StateFlow;", "getChanges", "()Lkotlinx/coroutines/flow/StateFlow;", "connectionHistoryChanges", "Lkotlinx/coroutines/flow/Flow;", "", "getConnectionHistoryChanges", "()Lkotlinx/coroutines/flow/Flow;", "hasDisplayHistory", "markDataSeen", "userId", "markHistory", "key", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f11312a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.flow.ae<Long> f11313b = null;
    private static final kotlinx.coroutines.flow.ar<Long> c = null;
    private static final kotlinx.coroutines.flow.i<Boolean> d = null;

    static {
        f11312a = new h();
        kotlinx.coroutines.flow.ae<Long> r0 = kotlinx.coroutines.flow.at.a(0L);
        f11313b = r0;
        c = kotlinx.coroutines.flow.k.a(r0);
        d = kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.b((Function2) ZeusTransformUtils.preCheckCast(new GlassesMemoryTabState$connectionHistoryChanges$1(null), Function2.class, "com.obric.memorydata.plugin")));
    }

    private h() {
    }

    private final synchronized boolean a(String r7, String r8) {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L4:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
    L24:
        monitor-exit(this);
        return false;
    L6:
        if (Intrinsics.areEqual(r7, AppContext.INSTANCE.getUserId()) == false) goto L24;
        IStore r0 = StoreManager.INSTANCE.getPersonalStore();     // Catch: Throwable -> L26
        if (r0 != null) goto L13;
        monitor-exit(this);
        return false;
    L13:
        if (Intrinsics.areEqual(r7, AppContext.INSTANCE.getUserId()) == true) goto L18;
        monitor-exit(this);
        return false;
    L18:
        if (r0.getBoolean(r8, false) == false) goto L21;
        monitor-exit(this);
        return true;
    L21:
        r0.save(r8, true);     // Catch: Throwable -> L26
        kotlinx.coroutines.flow.ae<Long> r9 = f11313b;     // Catch: Throwable -> L26
        r9.b(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r9.c(), Number.class, "com.obric.memorydata.plugin")).longValue() + 1));     // Catch: Throwable -> L26
        monitor-exit(this);
        return true;
    }

    public final kotlinx.coroutines.flow.ar<Long> a() {
        return c;
    }

    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        return a(r2, "collect_glasses_ever_had_data");
    }

    public final kotlinx.coroutines.flow.i<Boolean> b() {
        return d;
    }

    public final boolean c() {
        if (DoubaoGlassesConnectionState.INSTANCE.hasEverConnected() == false) goto L6;
        return true;
    L6:
        IStore r2 = StoreManager.INSTANCE.getPersonalStore();
        if (r2 != null) goto L10;
        return false;
    L10:
        return r2.getBoolean("collect_glasses_ever_had_data", false);
    }
}
