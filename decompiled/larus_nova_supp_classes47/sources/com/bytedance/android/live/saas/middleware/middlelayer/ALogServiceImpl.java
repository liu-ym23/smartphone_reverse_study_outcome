package com.bytedance.android.live.saas.middleware.middlelayer;

import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.alog.ILogProtocol;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pm0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J-\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/middlelayer/ALogServiceImpl;", "Lpm0/a;", "", "tag", Constants.OperatorKey.MSG, "", "d", "e", "", "throwable", "i", "", "priority", "", "Ljava/lang/StackTraceElement;", "traceElement", "stacktrace", "(ILjava/lang/String;[Ljava/lang/StackTraceElement;)V", "v", "w", "<init>", "()V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class ALogServiceImpl implements a {
    public ALogServiceImpl() {
    }

    public void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.d(r2, r3);
        return;
    }

    public void e(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    public void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.i(r2, r3);
        return;
    }

    public void v(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.v(r2, r3);
        return;
    }

    public void w(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.w(r2, r3);
        return;
    }

    public void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    public void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.w(r2, r3);
        return;
    }

    public void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r4, "throwable");
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.e(r2, r3, r4);
        return;
    }

    public void stacktrace(int r2, String r3, StackTraceElement[] r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "traceElement");
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.stacktrace(r2, r3, r4);
        return;
    }

    public void w(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r4, "throwable");
        ILogProtocol r0 = BDLiveSdk.getALog();
        if (r0 == null) goto L6;
        r0.w(r2, r3, r4);
        return;
    }
}
