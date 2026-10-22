package com.obric.memorydata.memory;

import android.os.Bundle;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\u000b\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/memorydata/memory/MemoryManagerWrapper$registerMemoryAction$1", "Lcom/obric/memorydata/utils/framework/MemoryManagerProxy$MemoryActionCallbackWrapper;", "onAction", "", "from", "", "bundle", "Landroid/os/Bundle;", "onEnterpriseAction", "actionType", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryManagerWrapper$registerMemoryAction$1 implements com.obric.memorydata.utils.c.b.a {
    MemoryManagerWrapper$registerMemoryAction$1() {
    }

    /* JADX INFO: renamed from: lambda$RM6lF4mjTEbjugUPs45e_X7h-Fk, reason: not valid java name */
    public static /* synthetic */ Unit m684lambda$RM6lF4mjTEbjugUPs45e_X7hFk(int r0, boolean r1, com.obric.memorydata.middleware.api.logging.g r2) {
        return onAction$lambda$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$jo1rHF-4nygdin1uyAXrtZsLew0, reason: not valid java name */
    public static /* synthetic */ Unit m685lambda$jo1rHF4nygdin1uyAXrtZsLew0(int r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return onAction$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit lambda$oDT451PqVY5dQua8m7AnwX_bvKw(int r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return onAction$lambda$2(r0, r1);
    }

    private static final Unit onAction$lambda$0(int r1, boolean r2, com.obric.memorydata.middleware.api.logging.g r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
        r3.a("from", Integer.valueOf(r1));
        r3.a("has_extra_package", Boolean.valueOf(r2));
        return Unit.INSTANCE;
    }

    private static final Unit onAction$lambda$1(int r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$mainTrace");
        r2.a("from", Integer.valueOf(r1));
        r2.a(InfoRequestQPSOptTraceLogger.REASON, "enterprise_account");
        return Unit.INSTANCE;
    }

    private static final Unit onAction$lambda$2(int r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$mainTrace");
        r2.a("from", Integer.valueOf(r1));
        r2.a(InfoRequestQPSOptTraceLogger.REASON, "gate_busy");
        return Unit.INSTANCE;
    }

    @Override // com.obric.memorydata.utils.c.b.a
    public void onAction(final int r21, Bundle r22) {
        Intrinsics.checkNotNullParameter(r22, "bundle");
        Bundle r3 = new Bundle(r22);
        if (com.obric.memorydata.utils.c.a.f13197a.a(r3, "com.aiassistant.memorydata.EXTRA_PACKAGE") == null) goto L5;
        final boolean r0 = true;
    L6:
        com.obric.memorydata.middleware.api.logging.e r2 = new com.obric.memorydata.middleware.api.logging.e(null, null, "trigger", 3, null);
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "系统主动记忆操作已触发", "operation_received", r2, new $$Lambda$MemoryManagerWrapper$registerMemoryAction$1$RM6lF4mjTEbjugUPs45e_X7hFk(r21, r0), null, 16, null);
        if (UserSettings.INSTANCE.isEnterpriseAccount() == false) goto L10;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "系统主动记忆已跳过企业账号", "operation_skipped", r2, new $$Lambda$MemoryManagerWrapper$registerMemoryAction$1$jo1rHF4nygdin1uyAXrtZsLew0(r21), null, 16, null);
        v.a(v.f11572a, r21, "wrapper_guard");
        return;
    L10:
        long r14 = v.a(v.f11572a, "onAction:from=" + r21);
        if (r14 >= 0) goto L14;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "系统主动记忆因已有任务而丢弃", "operation_skipped", r2, new $$Lambda$MemoryManagerWrapper$registerMemoryAction$1$oDT451PqVY5dQua8m7AnwX_bvKw(r21), null, 16, null);
        return;
    L14:
        v.a(v.f11572a, r14, "onAction:from=" + r21, v.a(v.f11572a, r21, r3), (Function1) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$registerMemoryAction$1$onAction$4(r21, r2, r3, r14, null), Function1.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.utils.c.b.a
    public void onEnterpriseAction(int r2) {
        v.a(v.f11572a, r2, "proxy_blocked");
    }
}
