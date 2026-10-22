package com.obric.memorydata.union.build;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/union/build/UnionUserInsightRetryPolicy;", "", "<init>", "()V", "RETRY_DELAY_MS", "", "retryDelayMs", "responseCode", "", "beforeCount", "afterCount", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f13109a = null;

    static {
        f13109a = new r();
    }

    private r() {
    }

    public final long a(int r5, int r6, int r7) {
        if (r7 > 0) goto L6;
        return 0;
    L6:
        if (r5 == 0) goto L8;
        return 60000;
    L8:
        if (r6 > 0) goto L10;
        return 60000;
    L10:
        if (r7 < r6) goto L12;
        return 60000;
    L12:
        return 0;
    }
}
