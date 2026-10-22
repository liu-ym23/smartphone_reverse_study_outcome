package com.bytedance.applog.log;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\u001e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/applog/log/GlobalLogger;", "Lcom/bytedance/applog/log/AbsLogger;", LocationMonitorConst.TAG, "", "(Ljava/lang/String;)V", "tags", "", "getTags", "()Ljava/util/List;", "tags$delegate", "Lkotlin/Lazy;", NotificationCompat.CATEGORY_ERROR, "", "throwable", "", "message", "Lkotlin/Function0;", "info", "log_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f1634a;

    private final List<String> a() {
        return (List) ZeusTransformUtils.preCheckCast(this.f1634a.getValue(), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.applog.log.a
    public void a(String r4, Throwable r5, Function0<String> r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r7, "message");
        q.a().a(a(), r4 + ": " + ((String) ZeusTransformUtils.preCheckCast(r7.invoke(), String.class, "com.obric.memorydata.plugin")), r5, new Object[0]);
    }

    @Override // com.bytedance.applog.log.a
    public void a(String r4, Function0<String> r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r6, "message");
        q.a().a(a(), r4 + ": " + ((String) ZeusTransformUtils.preCheckCast(r6.invoke(), String.class, "com.obric.memorydata.plugin")), new Object[0]);
    }
}
