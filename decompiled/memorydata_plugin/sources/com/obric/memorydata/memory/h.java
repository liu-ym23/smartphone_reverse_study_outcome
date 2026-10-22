package com.obric.memorydata.memory;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/InAppSignalCollectionPolicy;", "", "<init>", "()V", "shouldPersist", "", "isDebug", "reviewEnabled", "debugPersistenceEnabled", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f10145a = null;

    static {
        f10145a = new h();
    }

    private h() {
    }

    public final boolean a(boolean r1, boolean r2, boolean r3) {
        if (r2 == true) goto L7;
        if (r1 == false) goto L6;
        if (r3 == true) goto L7;
    L6:
        return false;
    L7:
        return true;
    }
}
