package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.sdk.refactor.DefaultRustSDKDefinition;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.utils.LarkContext;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o extends DefaultRustSDKDefinition {
    public final Set<te6.b> b;

    @Inject
    public x c;

    public final Executor f() {
        com.ss.android.lark.sdk.d r0 = com.ss.android.lark.sdk.i.b;
        if (r0 != null) goto L5;
    L7:
        return null;
    L5:
        if (r0.d() == false) goto L7;
        return CoreThreadPool.getDefault().getScheduleThreadPool();
    }

    public final te6.d h() {
        x r0 = this.c;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("onlineResponseObserverInternal");
        return null;
    L7:
        return r0;
    }

    public final boolean a() {
        return com.larksuite.framework.utils.z.e(LarkContext.getApplication());
    }

    public final Set<te6.b> d() {
        return this.b;
    }

    @Inject
    public o(Set<te6.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "observers");
        this.b = r2;
    }

    public final boolean e(int r2) {
        if (r2 != Command.MAKE_USER_ONLINE.getValue()) goto L5;
    L18:
        return true;
    L5:
        if (r2 == Command.MAKE_USER_OFFLINE.getValue()) goto L18;
        if (r2 == Command.SET_DEVICE.getValue()) goto L18;
        if (r2 == Command.GET_INIT_SETTINGS.getValue()) goto L18;
        if (r2 == Command.MAKE_USER_ONLINE_V2.getValue()) goto L18;
        if (r2 == Command.MAKE_USER_OFFLINE_V2.getValue()) goto L18;
        if (r2 == Command.SWITCH_USER_STATE.getValue()) goto L18;
        return false;
    }
}
