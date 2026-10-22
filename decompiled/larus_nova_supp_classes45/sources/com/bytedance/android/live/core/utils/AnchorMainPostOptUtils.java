package com.bytedance.android.live.core.utils;

import android.os.Handler;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AnchorMainPostOptUtils {
    public static final Lazy a = null;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ Runnable b;

        public a(String r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            AnchorMainPostOptUtils.b(this.a, this.b);
        }
    }

    @JvmStatic
    public static final void a() {
        com.bytedance.android.livesdk.config.b0.a = false;
        ((Handler) a.getValue()).removeCallbacksAndMessages(null);
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AnchorMainPostOptUtils$sHandler$2.INSTANCE);
    }

    @JvmStatic
    public static final void b(String r1, Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        if (com.bytedance.android.livesdk.config.b0.a() == false) goto L10;
        if (r1 != null) goto L7;
        r1 = "UnKnown";
    L7:
        if (v.a() == false) goto L9;
        r2 = new c(r2, r1);
    L9:
        ((Handler) a.getValue()).post(r2);
        return;
    L10:
        r2.run();
    }

    @JvmStatic
    public static final void d(DataCenter r3, LifecycleOwner r4, Runnable r5) {
        Intrinsics.checkNotNullParameter("showCountDownView", "methodName");
        Intrinsics.checkNotNullParameter(r4, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r5, "runnable");
        if (com.bytedance.android.livesdk.config.b0.a() == false) goto L16;
        if (r3 == null) goto L18;
        Observable r6 = RxUtilKt.b(r3, "cmd_p0_widget_loaded", true);
        if (r6 == null) goto L19;
        Observable r7 = r6.take(1);
        if (r7 == null) goto L20;
        Observable r8 = r7.delay(300, TimeUnit.MILLISECONDS);
        if (r8 == null) goto L21;
        Observable r9 = r8.observeOn(AndroidSchedulers.mainThread());
        if (r9 == null) goto L22;
        ObservableSubscribeProxy r11 = (ObservableSubscribeProxy) r9.as(AutoDispose.bind(r4));
        if (r11 == null) goto L23;
        r11.subscribe(new b(r5));
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L16:
        r5.run();
    }

    @JvmStatic
    public static final void c(String r3, DataCenter r4, LifecycleOwner r5, Runnable r6) {
        Intrinsics.checkNotNullParameter(r3, "methodName");
        Intrinsics.checkNotNullParameter(r5, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r6, "runnable");
        if (com.bytedance.android.livesdk.config.b0.a() == false) goto L16;
        if (r4 == null) goto L18;
        Observable r7 = RxUtilKt.b(r4, "cmd_widget_loaded", true);
        if (r7 == null) goto L19;
        Observable r8 = r7.take(1);
        if (r8 == null) goto L20;
        Observable r9 = r8.delay(200, TimeUnit.MILLISECONDS);
        if (r9 == null) goto L21;
        Observable r11 = r9.observeOn(AndroidSchedulers.mainThread());
        if (r11 == null) goto L22;
        ObservableSubscribeProxy r12 = (ObservableSubscribeProxy) r11.as(AutoDispose.bind(r5));
        if (r12 == null) goto L23;
        r12.subscribe(new a(r3, r6));
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L16:
        r6.run();
    }
}
