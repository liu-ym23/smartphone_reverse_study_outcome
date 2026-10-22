package com.obric.aikernel.phx.core.conn;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final boolean a(Context r10, Intent r11, Executor r12, ServiceConnection r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "intent");
        Intrinsics.checkNotNullParameter(r12, "executor");
        Intrinsics.checkNotNullParameter(r13, WsConstants.KEY_CONNECTION);
        return r10.bindService(r11, 33, r12, r13);
    }

    public static final boolean b(Context r10, Intent r11, Executor r12, ServiceConnection r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "intent");
        Intrinsics.checkNotNullParameter(r12, "executor");
        Intrinsics.checkNotNullParameter(r13, WsConstants.KEY_CONNECTION);
        return r10.bindService(r11, 65, r12, r13);
    }
}
