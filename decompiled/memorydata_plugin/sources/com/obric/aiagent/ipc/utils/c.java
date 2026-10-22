package com.obric.aiagent.ipc.utils;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.platform.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/ipc/utils/IPCLog;", "", "<init>", "()V", "onCall", "", LocationMonitorConst.TAG, "", "event", "onInvoke", "onEvent", "onResult", "onFail", "tr", "", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f5945a = null;

    static {
        f5945a = new c();
    }

    private c() {
    }

    public static /* synthetic */ void a(c r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    public final void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r4, "event");
        d.f5954a.b("IPC-BASE", "--- [" + r3 + "] " + r4);
    }

    public final void a(String r5, String r6, Throwable r7) {
        Intrinsics.checkNotNullParameter(r5, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r6, "event");
        if (r7 != null) goto L5;
        d.f5954a.c("IPC-BASE", "*** [" + r5 + "] " + r6);
        return;
    L5:
        d.f5954a.a("IPC-BASE", "*** [" + r5 + "] " + r6, r7);
    }
}
