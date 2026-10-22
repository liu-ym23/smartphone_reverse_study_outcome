package com.obric.aikernel.runtime.utils;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J&\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J*\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019H\u0086\bø\u0001\u0000J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J\u0016\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J&\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J\u0016\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J\u0016\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J&\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J\u0016\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J \u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J\u0018\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J\u0016\u0010$\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J&\u0010$\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J\u0016\u0010%\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J&\u0010%\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006&"}, d2 = {"Lcom/obric/aikernel/runtime/utils/Logger;", "Lcom/obric/aikernel/runtime/utils/ILogger;", "()V", "default", "com/obric/aikernel/runtime/utils/Logger$default$1", "Lcom/obric/aikernel/runtime/utils/Logger$default$1;", "instance", "getInstance", "()Lcom/obric/aikernel/runtime/utils/ILogger;", "setInstance", "(Lcom/obric/aikernel/runtime/utils/ILogger;)V", "aeeLog", "", "priority", "", LocationMonitorConst.TAG, "", Params.CONTENT, "d", "message", ActivityLifecycle.NAME, "version", "debug", "isDebug", "", "Lkotlin/Function0;", "e", NotificationCompat.CATEGORY_ERROR, "i", "info", "log", "level", "tracking", "key", "data", "Lorg/json/JSONObject;", BaseSwitches.V, "w", "pyvm_utils_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f6216a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f6217b;
    private static final a c = null;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/obric/aikernel/runtime/utils/Logger$default$1", "Lcom/obric/aikernel/runtime/utils/ILogger;", "aeeLog", "", "priority", "", LocationMonitorConst.TAG, "", Params.CONTENT, "log", "message", "level", "tracking", "key", "data", "Lorg/json/JSONObject;", "pyvm_utils_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements c {
        a() {
        }

        @Override // com.obric.aikernel.runtime.utils.c
        public void a(int r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
            a(r3, r4, r2);
        }

        @Override // com.obric.aikernel.runtime.utils.c
        public void a(String r1, String r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, "message");
            switch(r3) {
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L6;
                case 6: goto L5;
                case 7: goto L5;
                default: goto L8;
            };
        L5:
            Log.e(r1, r2);
            return;
        L6:
            Log.w(r1, r2);
            return;
        L7:
            Log.i(r1, r2);
            return;
        L8:
            Log.d(r1, r2);
            return;
        L9:
            Log.v(r1, r2);
        }

        @Override // com.obric.aikernel.runtime.utils.c
        public void a(String r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "data");
            Log.i("TRACKING-" + r2, r3.toString(0));
        }
    }

    static {
        f6216a = new d();
        c = new a();
    }

    private d() {
    }

    @Override // com.obric.aikernel.runtime.utils.c
    public void a(int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
        c r2 = f6217b;
        if (r2 != null) goto L5;
        r2 = (c) ZeusTransformUtils.preCheckCast(c, c.class, "com.obric.memorydata.plugin");
    L5:
        r2.a(r3, r4, r5);
    }

    public final void a(c r2) {
        f6217b = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
    }

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        d(r2, r3);
    }

    @Override // com.obric.aikernel.runtime.utils.c
    public void a(String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r4, "message");
        c r2 = f6217b;
        if (r2 != null) goto L5;
        r2 = (c) ZeusTransformUtils.preCheckCast(c, c.class, "com.obric.memorydata.plugin");
    L5:
        r2.a(r3, r4, r5);
    }

    public final void a(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "version");
        Intrinsics.checkNotNullParameter(r5, "message");
        a(4, r2 + '-' + r3 + '@' + r4, r5);
    }

    @Override // com.obric.aikernel.runtime.utils.c
    public void a(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "data");
        c r2 = f6217b;
        if (r2 != null) goto L5;
        r2 = (c) ZeusTransformUtils.preCheckCast(c, c.class, "com.obric.memorydata.plugin");
    L5:
        r2.a(r3, r4);
    }

    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        e(r2, r3);
    }

    public final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        g(r2, r3);
    }

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        a(r2, r3, 3);
    }

    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        a(r2, r3, 4);
    }

    public final void f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        a(r2, r3, 5);
    }

    public final void g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        a(r2, r3, 6);
    }
}
