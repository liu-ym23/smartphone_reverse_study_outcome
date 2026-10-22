package com.ss.android.lark.officesdk;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.api.init.OfficeSDKInitConfig;
import com.ss.android.lark.officesdk.api.init.RuntimeStrategy;
import com.ss.android.lark.officesdk.executor.OfficeSDKRuntime;
import com.ss.android.lark.officesdk.experiment.LaunchExperiment;
import com.ss.android.lark.officesdk.internal.OfficeSDKProvider;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDK {
    public static final AtomicBoolean a = null;
    public static volatile ptb.a b;
    public static volatile OfficeSDKRuntime c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSDKInitConfig.RuntimeType.values().length];
            r0[OfficeSDKInitConfig.RuntimeType.ASYNC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
        a = new AtomicBoolean(false);
        b = new ptb.a(LaunchExperiment.LAUNCH_ONLY_OFFICE_SDK);
    }

    @JvmStatic
    public static final IUserManager a() {
        return OfficeSDKProvider.INSTANCE.getInstance().getUserManager();
    }

    @JvmStatic
    public static final void b(final OfficeSDKInitConfig r5) {
        Intrinsics.checkNotNullParameter(r5, "initConfig");
        long r0 = SystemClock.elapsedRealtime();
        OfficeSDKInitConfig.InitStageConfig r2 = r5.getInitStage();
        if (r2 == null) goto L5;
        OfficeSDKInitConfig.RuntimeType r3 = r2.getRuntimeType();
    L6:
        if (r3 != null) goto L8;
        int r4 = -1;
    L10:
        if (r4 != 1) goto L12;
        final RuntimeStrategy r6 = RuntimeStrategy.ASYNC_NORMAL;
    L13:
        Lazy<OfficeSDKRuntime.OfficeSerialThreadExecutor> r7 = OfficeSDKRuntime.d;
        Function1<IOfficeSDKRuntime, Unit> r8 = new OfficeSDK$init$1(r5, r6);
        Intrinsics.checkNotNullParameter(r6, "runtimeStrategy");
        Intrinsics.checkNotNullParameter(r8, "block");
        OfficeSDKRuntime r9 = new OfficeSDKRuntime(r6);
        r9.run(r8);
        c = r9;
        long r10 = SystemClock.elapsedRealtime() - r0;
        Log.i("OfficeSDK", "OfficeSDK_Boot_Init_Api_End: " + r10 + "ms, strategy=" + r6);
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r11 = com.ss.android.lark.officesdk.internal.g.a;
        String r12 = r6.name();
        Intrinsics.checkNotNullParameter(r12, "strategy");
        JSONObject r1 = new JSONObject();
        r1.put("cost_ms", r10);
        r1.put("strategy", r12);
        return;
    L12:
        r6 = RuntimeStrategy.MAIN;
        goto L13
    L8:
        r4 = a.a[r3.ordinal()];
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
