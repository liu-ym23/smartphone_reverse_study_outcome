package com.obric.livecard.api.utils;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J#\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/livecard/api/utils/GlobalCommonUtils;", "", "()V", "getThreadStackInfo", "", "limit", "", "getStackInfo", "", "Ljava/lang/StackTraceElement;", "([Ljava/lang/StackTraceElement;I)Ljava/lang/String;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class GlobalCommonUtils {
    public static final GlobalCommonUtils INSTANCE = null;

    static {
        INSTANCE = new GlobalCommonUtils();
    }

    private GlobalCommonUtils() {
    }

    public final String getThreadStackInfo(int r2) {
        return getStackInfo(ThreadMethodProxy.currentThread().getStackTrace(), r2);
    }

    public final String getStackInfo(StackTraceElement[] r10, int r11) {
        if (r10 == null) goto L8;
        List r12 = ArraysKt.drop(r10, 3);
        if (r12 == null) goto L8;
        List r13 = CollectionsKt.take(r12, r11);
        if (r13 == null) goto L8;
        return CollectionsKt.joinToString$default(r13, "\n", null, null, 0, null, getStackInfo.1.INSTANCE, 30, null);
    L8:
        return null;
    }

    public static /* synthetic */ String getThreadStackInfo$default(GlobalCommonUtils r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 7;
    L6:
        return r0.getThreadStackInfo(r1);
    }

    public static /* synthetic */ String getStackInfo$default(GlobalCommonUtils r0, StackTraceElement[] r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = 7;
    L6:
        return r0.getStackInfo(r1, r2);
    }
}
