package com.obric.aikernel.phx.core.conn;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"AUTO_CREATE_BIND_FLAGS", "", "CHILD_PROCESS_IMPORTANT_BIND_FLAGS", "bindAutoCreate", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "executor", "Ljava/util/concurrent/Executor;", WsConstants.KEY_CONNECTION, "Landroid/content/ServiceConnection;", "bindForChildProcessPriority", "sdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ProcessPriorityBindingKt {
    public static final int AUTO_CREATE_BIND_FLAGS = 33;
    public static final int CHILD_PROCESS_IMPORTANT_BIND_FLAGS = 65;

    public static final boolean bindAutoCreate(Context r2, Intent r3, Executor r4, ServiceConnection r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        ServiceConnection r8 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r5, ServiceConnection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r7, "executor");
        Intrinsics.checkNotNullParameter(r8, WsConstants.KEY_CONNECTION);
        return r6.bindService(r3, 33, r7, r8);
    }

    public static final boolean bindForChildProcessPriority(Context r2, Intent r3, Executor r4, ServiceConnection r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        ServiceConnection r8 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r5, ServiceConnection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r7, "executor");
        Intrinsics.checkNotNullParameter(r8, WsConstants.KEY_CONNECTION);
        return r6.bindService(r3, 65, r7, r8);
    }
}
