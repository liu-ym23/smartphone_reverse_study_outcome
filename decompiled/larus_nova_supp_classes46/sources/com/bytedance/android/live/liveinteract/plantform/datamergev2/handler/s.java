package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s<T> implements Predicate {
    public final /* synthetic */ p a;

    public s(p r1) {
        this.a = r1;
    }

    public final boolean test(Object r6) {
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b r7 = (com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C0054b) r6;
        Intrinsics.checkNotNullParameter(r7, "data");
        long r0 = this.a.g.get();
        if (r7.b.getTimestamp() <= r0) goto L5;
        this.a.g.set(r7.b.getTimestamp());
        return true;
    L5:
        ALogger.e("MultiLinkDzy", "call sei sampling failure XXX, timestamp: " + r7.b.getTimestamp() + ", last = " + r0 + ", compareResult[" + r7.c + ", " + r7.d + ']');
        return false;
    }
}
