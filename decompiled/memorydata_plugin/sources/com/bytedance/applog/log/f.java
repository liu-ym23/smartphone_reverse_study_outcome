package com.bytedance.applog.log;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/applog/log/EmptyLogger;", "Lcom/bytedance/applog/log/AbsLogger;", "()V", NotificationCompat.CATEGORY_ERROR, "", LocationMonitorConst.TAG, "", "throwable", "", "message", "Lkotlin/Function0;", "info", "log_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f implements a {
    public f() {
    }

    @Override // com.bytedance.applog.log.a
    public void a(String r1, Throwable r2, Function0<String> r3) {
        Function0 r0 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r0, "message");
    }

    @Override // com.bytedance.applog.log.a
    public void a(String r2, Function0<String> r3) {
        Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r1, "message");
    }
}
