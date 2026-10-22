package com.obric.common.oea.foundation.a;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b*\u0001\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\"\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\u000fJ\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\tJ\u0016\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/obric/common/oea/foundation/util/OEALogger;", "", "()V", "TAG", "", "defaultLogger", "com/obric/common/oea/foundation/util/OEALogger$defaultLogger$1", "Lcom/obric/common/oea/foundation/util/OEALogger$defaultLogger$1;", "loggerDelegate", "Lcom/obric/common/oea/foundation/util/OEALog;", "getLoggerDelegate", "()Lcom/obric/common/oea/foundation/util/OEALog;", "setLoggerDelegate", "(Lcom/obric/common/oea/foundation/util/OEALog;)V", "d", "", LocationMonitorConst.TAG, NotificationCompat.CATEGORY_MESSAGE, "e", "throwable", "", "enableAndroidDebugLog", "i", "r", "setLogDelegate", "delegate", BaseSwitches.V, "w", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7661a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.obric.common.oea.foundation.a.a f7662b;
    private static final a c = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"com/obric/common/oea/foundation/util/OEALogger$defaultLogger$1", "Lcom/obric/common/oea/foundation/util/OEALog;", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "throwable", "", "i", BaseSwitches.V, "w", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements com.obric.common.oea.foundation.a.a {
        a() {
        }

        @Override // com.obric.common.oea.foundation.a.a
        public void a(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            Log.v("OEA_SDK", r1 + "->" + r2);
        }

        @Override // com.obric.common.oea.foundation.a.a
        public void a(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            Log.e("OEA_SDK", r1 + "->" + r2, r3);
        }

        @Override // com.obric.common.oea.foundation.a.a
        public void b(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            Log.d("OEA_SDK", r1 + "->" + r2);
        }

        @Override // com.obric.common.oea.foundation.a.a
        public void c(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            Log.i("OEA_SDK", r1 + "->" + r2);
        }

        @Override // com.obric.common.oea.foundation.a.a
        public void d(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            Log.w("OEA_SDK", r1 + "->" + r2);
        }
    }

    static {
        f7661a = new b();
        c = new a();
    }

    private b() {
    }

    public static /* synthetic */ void a(b r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin");
    L5:
        r0.a(r1, r2, r3);
    }

    public final void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.common.oea.foundation.a.a r0 = f7662b;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public final void a(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.common.oea.foundation.a.a r0 = f7662b;
        if (r0 == null) goto L6;
        if (r0 == null) goto L8;
        r0.a(r1, r2, r3);
        return;
    L8:
        return;
    L6:
        c.a(r1, r2, r3);
    }

    public final void b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.common.oea.foundation.a.a r0 = f7662b;
        if (r0 == null) goto L6;
        r0.b(r1, r2);
        return;
    }

    public final void c(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.common.oea.foundation.a.a r0 = f7662b;
        if (r0 == null) goto L6;
        r0.c(r1, r2);
        return;
    }

    public final void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.common.oea.foundation.a.a r0 = f7662b;
        if (r0 == null) goto L6;
        if (r0 == null) goto L8;
        r0.d(r1, r2);
        return;
    L8:
        return;
    L6:
        c.d(r1, r2);
    }

    public final void e(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.common.oea.foundation.a.a r0 = f7662b;
        if (r0 == null) goto L6;
        if (r0 == null) goto L8;
        r0.c(r1, r2);
        return;
    L8:
        return;
    L6:
        c.c(r1, r2);
    }
}
