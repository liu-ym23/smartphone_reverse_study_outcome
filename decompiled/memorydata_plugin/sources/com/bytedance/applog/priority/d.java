package com.bytedance.applog.priority;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/applog/priority/PriorityCallbackLogger;", "Lcom/bytedance/applog/log/AbsLogger;", "priorityCallback", "Lcom/bytedance/applog/priority/PriorityCallback;", "(Lcom/bytedance/applog/priority/PriorityCallback;)V", "getPriorityCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", NotificationCompat.CATEGORY_ERROR, "", LocationMonitorConst.TAG, "", "throwable", "", "message", "Lkotlin/Function0;", "info", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d implements com.bytedance.applog.log.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PriorityCallback f1784a;

    public d(PriorityCallback r3) {
        PriorityCallback r4 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r3, PriorityCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "priorityCallback");
        this.f1784a = r4;
    }

    @Override // com.bytedance.applog.log.a
    public void a(String r4, Throwable r5, Function0<String> r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r7, "message");
        this.f1784a.printLog(4, "Priority-" + r4 + ": " + ((String) ZeusTransformUtils.preCheckCast(r7.invoke(), String.class, "com.obric.memorydata.plugin")) + ", throwable: " + r5);
    }

    @Override // com.bytedance.applog.log.a
    public void a(String r4, Function0<String> r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r6, "message");
        this.f1784a.printLog(2, "Priority-" + r4 + ": " + ((String) ZeusTransformUtils.preCheckCast(r6.invoke(), String.class, "com.obric.memorydata.plugin")));
    }
}
