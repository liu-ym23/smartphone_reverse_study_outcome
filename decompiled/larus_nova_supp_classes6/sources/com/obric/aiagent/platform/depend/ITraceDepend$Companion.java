package com.obric.aiagent.platform.depend;

import android.os.Bundle;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.common.applog.EventVerify;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s9a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J(\u0010\u0016\u001a\u00020\n2\u001e\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u0018H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\u001c\u0010\u001b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001cH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/obric/aiagent/platform/depend/ITraceDepend$Companion;", "Lcom/obric/aiagent/platform/depend/ITraceDepend;", "<init>", "()V", "impl", "getImpl", "()Lcom/obric/aiagent/platform/depend/ITraceDepend;", "impl$delegate", "Lkotlin/Lazy;", "report", "", EventVerify.TYPE_EVENT_V1, "", "params", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "enableETVerify", "getSessionId", "getDeviceId", "getInstallId", "getSsid", "awaitTraceId", "callback", "Lkotlin/Function3;", "getUserID", "getUUID", "addCommonParams", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ITraceDepend$Companion implements ITraceDepend {
    public static final /* synthetic */ ITraceDepend$Companion b = null;
    public static final Lazy<ITraceDepend> c = null;

    private ITraceDepend$Companion() {
    }

    static {
        b = new ITraceDepend$Companion();
        c = LazyKt.lazy(new d());
    }

    public final void a(Bundle r3) {
        Intrinsics.checkNotNullParameter("ipc_anomaly", EventVerify.TYPE_EVENT_V1);
        Intrinsics.checkNotNullParameter(r3, "bundleParams");
        ITraceDepend r0 = (ITraceDepend) c.getValue();
        if (r0 == null) goto L6;
        r0.a(r3);
        return;
    }
}
