package com.obric.memorydata.recommend.context;

import com.obric.memorydata.utils.aw;
import com.obric.memorydata.utils.r;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/recommend/context/ContextManager;", "", "<init>", "()V", "run", "", "stop", "latestJulianDay", "", "latestIsWorkingDay", "", "isWorkingDay", "ts", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextManager {
    public static final ContextManager INSTANCE = null;
    private static boolean latestIsWorkingDay;
    private static int latestJulianDay;

    static {
        INSTANCE = new ContextManager();
    }

    private ContextManager() {
    }

    public final boolean isWorkingDay(long r2) {
        int r1 = aw.f13185a.b(r2);
        if (r1 == latestJulianDay) goto L5;
        latestJulianDay = r1;
        boolean r3 = r.d(r2);
        latestIsWorkingDay = r3;
        return r3;
    L5:
        return latestIsWorkingDay;
    }

    public final void run() {
    }

    public final void stop() {
    }
}
