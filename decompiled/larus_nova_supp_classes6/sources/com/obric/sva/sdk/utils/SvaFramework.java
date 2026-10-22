package com.obric.sva.sdk.utils;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.framework.log.AiagentLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/utils/SvaFramework;", "", "<init>", "()V", "init", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SvaFramework {
    public static final SvaFramework INSTANCE = null;

    static {
        INSTANCE = new SvaFramework();
    }

    private SvaFramework() {
    }

    public static /* synthetic */ Unit a(String r0, String r1) {
        return init$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit b(String r0, String r1) {
        return init$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit c(String r0, String r1) {
        return init$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit d(String r0, String r1) {
        return init$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit e(String r0, String r1) {
        return init$lambda$4(r0, r1);
    }

    public final void init() {
        AiagentLog.init(new c(), new d(), new e(), new f(), new g());
    }

    private static final Unit init$lambda$0(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "t");
        Intrinsics.checkNotNullParameter(r2, "m");
        LogUtils.v(r1, r2, new Object[0]);
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$1(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "t");
        Intrinsics.checkNotNullParameter(r2, "m");
        LogUtils.d(r1, r2, new Object[0]);
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$2(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "t");
        Intrinsics.checkNotNullParameter(r2, "m");
        LogUtils.i(r1, r2, new Object[0]);
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$3(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "t");
        Intrinsics.checkNotNullParameter(r2, "m");
        LogUtils.w(r1, r2, new Object[0]);
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$4(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "t");
        Intrinsics.checkNotNullParameter(r2, "m");
        LogUtils.e(r1, r2, new Object[0]);
        return Unit.INSTANCE;
    }
}
