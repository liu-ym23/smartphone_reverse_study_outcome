package com.obric.matrixpro.sdk.deviceinfoclient;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\"\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\fJ\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ*\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tRx\u0010\u0003\u001a`\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/obric/matrixpro/sdk/deviceinfoclient/MatrixProDeviceInfoClientLogger;", "", "()V", "logger", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "level", "", LocationMonitorConst.TAG, NotificationCompat.CATEGORY_MESSAGE, "", "error", "", "getLogger", "()Lkotlin/jvm/functions/Function4;", "setLogger", "(Lkotlin/jvm/functions/Function4;)V", "d", "e", "throwable", "i", "log", "w", "deviceinfoclient_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8271a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function4<? super Integer, ? super String, ? super String, ? super Throwable, Unit> f8272b;

    static {
        f8271a = new b();
    }

    private b() {
    }

    private final void a(int r1, String r2, String r3, Throwable r4) {
        Function4<? super Integer, ? super String, ? super String, ? super Throwable, Unit> r0 = f8272b;
        if (r0 == null) goto L6;
        Unit r5 = (Unit) ZeusTransformUtils.preCheckCast(r0.invoke(Integer.valueOf(r1), r2, r3, r4), Unit.class, "com.obric.memorydata.plugin");
        return;
    }

    public final void a(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        a(6, r2, r3, r4);
    }
}
