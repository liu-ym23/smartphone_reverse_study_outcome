package com.obric.matrix.platform.sdk.ones.internal.b;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J$\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J$\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J$\u0010\u0013\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J$\u0010\u0014\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/util/MLog;", "", "()V", "TAG", "", "sPrintable", "", "d", "", NotificationCompat.CATEGORY_MESSAGE, LocationMonitorConst.TAG, "tr", "", "e", "i", "proxyDebugLog", "proxyInfoLog", "setEnabled", "enabled", BaseSwitches.V, "w", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8109a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f8110b;

    static {
        f8109a = new b();
    }

    private b() {
    }

    @JvmStatic
    public static final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        b("matrix_ones", r3, null, 4, null);
    }

    @JvmStatic
    public static final void a(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (f8110b == false) goto L5;
        Log.d(r1, r2, r3);
    L5:
        f8109a.e(r1, r2, r3);
    }

    public static /* synthetic */ void a(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        a(r0, r1, r2);
    }

    @JvmStatic
    public static final void b(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (f8110b == false) goto L5;
        Log.i(r1, r2, r3);
    L5:
        f8109a.f(r1, r2, r3);
    }

    public static /* synthetic */ void b(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        b(r0, r1, r2);
    }

    @JvmStatic
    public static final void c(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (f8110b == false) goto L5;
        Log.w(r1, r2, r3);
    L5:
        f8109a.f(r1, r2, r3);
    }

    public static /* synthetic */ void c(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        c(r0, r1, r2);
    }

    @JvmStatic
    public static final void d(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (f8110b == false) goto L5;
        Log.e(r1, r2, r3);
    L5:
        f8109a.f(r1, r2, r3);
    }

    public static /* synthetic */ void d(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        d(r0, r1, r2);
    }

    private final void e(String r3, String r4, Throwable r5) {
        com.obric.matrix.platform.sdk.ones.a r2 = com.obric.matrix.platform.sdk.ones.b.f8082a.b();
        if (r2 == null) goto L6;
        r2.a(r3, "MatrixOnesSdk: " + r4, r5);
        return;
    }

    private final void f(String r3, String r4, Throwable r5) {
        com.obric.matrix.platform.sdk.ones.a r2 = com.obric.matrix.platform.sdk.ones.b.f8082a.b();
        if (r2 == null) goto L6;
        r2.b(r3, "MatrixOnesSdk: " + r4, r5);
        return;
    }
}
