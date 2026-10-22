package com.bytedance.android.live.saas.middleware.console;

import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J \u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/console/Console;", "", "()V", "mIsNeedPrintLog", "", "d", "", "tag", "", Constants.OperatorKey.MSG, "tr", "", "e", "i", "init", "isNeedPrintLog", "v", "w", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class Console {
    public static final Console INSTANCE = null;
    private static boolean mIsNeedPrintLog;

    private Console() {
    }

    @JvmStatic
    public static final void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
    }

    @JvmStatic
    public static final void d(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
        Intrinsics.checkNotNullParameter(r3, "tr");
    }

    @JvmStatic
    public static final void e(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
    }

    @JvmStatic
    public static final void e(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
        Intrinsics.checkNotNullParameter(r3, "tr");
    }

    @JvmStatic
    public static final void i(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
    }

    @JvmStatic
    public static final void i(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
        Intrinsics.checkNotNullParameter(r3, "tr");
    }

    @JvmStatic
    public static final void v(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
    }

    @JvmStatic
    public static final void v(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
        Intrinsics.checkNotNullParameter(r3, "tr");
    }

    @JvmStatic
    public static final void w(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
    }

    @JvmStatic
    public static final void w(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
        Intrinsics.checkNotNullParameter(r3, "tr");
    }

    static {
        INSTANCE = new Console();
    }

    @JvmStatic
    public static final void init(boolean r0) {
        mIsNeedPrintLog = r0;
    }
}
