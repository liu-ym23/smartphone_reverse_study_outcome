package com.obric.memorydata.memory.contextsync;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005J\u001e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ&\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/contextsync/MemoryContextSyncPolicy;", "", "<init>", "()V", "MAX_RETRY_ATTEMPTS", "", "RETRY_BASE_DELAY_MS", "", "RETRY_MAX_DELAY_MS", "shouldHandleSemanticInvalidation", "", "isLoggedIn", "pendingCount", "shouldIgnoreProviderRefresh", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/memory/contextsync/MemoryContextAlignmentSource;", "hasState", "stateMatches", "shouldHandleAlignedSemanticChange", "providerFullRequired", "shouldForceFull", "isRetryExhausted", "attempt", "retryDelayMs", "isTerminalStatus", "status", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f10104a = null;

    static {
        f10104a = new g();
    }

    private g() {
    }

    public final boolean a(int r1) {
        if (r1 < 6) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean a(MemoryContextAlignmentSource r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, AILabCheckPermissionTask.KEY_SOURCE);
        if (r1 != MemoryContextAlignmentSource.PROVIDER_CHANGED) goto L7;
        if (r2 == false) goto L7;
        if (r3 == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean a(MemoryContextAlignmentSource r1, boolean r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, AILabCheckPermissionTask.KEY_SOURCE);
        if (r2 == false) goto L5;
    L10:
        return true;
    L5:
        if (r1 == MemoryContextAlignmentSource.PROVIDER_CHANGED) goto L10;
        if (r3 == false) goto L10;
        if (r4 == false) goto L10;
        return false;
    }

    public final boolean a(boolean r1, int r2) {
        if (r1 == false) goto L5;
        if (r2 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final long b(int r3) {
        return Math.min((1 << Math.min(RangesKt.coerceAtLeast(r3, 0), 10)) * 5000, 300000);
    }

    public final boolean b(MemoryContextAlignmentSource r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, AILabCheckPermissionTask.KEY_SOURCE);
        if (r1 != MemoryContextAlignmentSource.SEMANTIC_CHANGED) goto L7;
        if (r2 == true) goto L7;
        if (r3 == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean c(int r2) {
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L6;
        return true;
    L6:
        if (r2 == 4) goto L12;
        return false;
    L12:
        return true;
    L10:
        return true;
    }
}
