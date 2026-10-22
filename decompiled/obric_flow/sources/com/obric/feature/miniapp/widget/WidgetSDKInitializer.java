package com.obric.feature.miniapp.widget;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.ai.ex.widget.WidgetSDK;
import com.obric.feature.miniapp.widget.depend.ObricLauncherHostDependServiceImpl;
import com.obric.feature.miniapp.widget.depend.ObricLauncherHostLocationPermissionServiceImpl;
import com.obric.feature.miniapp.widget.depend.ObricLauncherHostSystemActionServiceImpl;
import com.obric.feature.miniapp.widget.depend.ObricLauncherHostUserDependImpl;
import com.obric.feature.miniapp.widget.jsb.AppletOpenPageMethod;
import com.obric.feature.miniapp.widget.jsb.GetSystemTimeMethod;
import com.obric.feature.miniapp.widget.jsb.LauncherOnViewClickMethod;
import com.obric.feature.miniapp.widget.jsb.LogMethod;
import com.obric.feature.miniapp.widget.jsb.WidgetRefreshAffectedMethod;
import com.obric.feature.miniapp.widget.jsb.WidgetSendPayloadMethod;
import com.obric.feature.miniapp.widget.jsb.WidgetUpdateMethod;
import k5.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import o1.i;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001J=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/feature/miniapp/widget/WidgetSDKInitializer;", "", "Landroid/app/Application;", "context", "Lcom/obric/feature/miniapp/widget/AISdkInitController;", "aiSdkInitController", "Lkotlin/Function0;", "Landroid/app/Activity;", "currentActivity", "findMainActivity", "", "init", "(Landroid/app/Application;Lcom/obric/feature/miniapp/widget/AISdkInitController;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetSDKInitializer {
    public static final WidgetSDKInitializer INSTANCE = null;

    static {
        INSTANCE = new WidgetSDKInitializer();
    }

    public WidgetSDKInitializer() {
    }

    public static void a(Application r5) {
        ObricLauncherHostUserDependImpl r10 = new ObricLauncherHostUserDependImpl();     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r10, "hostUserDepend");     // Catch: Exception -> L5
        d.f = r10;     // Catch: Exception -> L5
        ObricLauncherHostDependServiceImpl r11 = new ObricLauncherHostDependServiceImpl(r5);     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r11, "hostContextDepend");     // Catch: Exception -> L5
        d.f18600a = r11;     // Catch: Exception -> L5
        ObricLauncherHostLocationPermissionServiceImpl r12 = new ObricLauncherHostLocationPermissionServiceImpl();     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r12, "hostLocationPermissionDepend");     // Catch: Exception -> L5
        d.e = r12;     // Catch: Exception -> L5
        ObricLauncherHostSystemActionServiceImpl r13 = new ObricLauncherHostSystemActionServiceImpl();     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r13, "hostSystemActionDepend");     // Catch: Exception -> L5
        d.g = r13;     // Catch: Exception -> L5
        Log.i("OMiniApp-WidgetSDKInitializer", "AIBridge dependencies initialized successfully");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("OMiniApp-WidgetSDKInitializer", "Failed to initialize AIBridge dependencies", e);
    }

    public final void init(Application r10, AISdkInitController r11, Function0<? extends Activity> r12, Function0<? extends Activity> r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "aiSdkInitController");
        Intrinsics.checkNotNullParameter(r12, "currentActivity");
        Intrinsics.checkNotNullParameter(r13, "findMainActivity");
        a(r10);     // Catch: Exception -> L10
        com.bytedance.ai.multiprocess.a r14 = new com.bytedance.ai.multiprocess.a();     // Catch: Exception -> L6
        Intrinsics.checkNotNullParameter(r14, NotificationCompat.CATEGORY_SERVICE);     // Catch: Exception -> L6
        com.bytedance.ai.multiprocess.d.f2406a = r14;     // Catch: Exception -> L6
        Log.i("OMiniApp-WidgetSDKInitializer", "AISDK multi-process service registered");     // Catch: Exception -> L6
    L8:
        WidgetSDK.INSTANCE.init(r10, r11.getConfig().f22195b, r11.getConfig(), r11.getAbility(), LauncherGeckoConfigs.INSTANCE, new WidgetSDKLogProxy(r10.getApplicationInfo().flags));     // Catch: Exception -> L10
        i r15 = i.f20397c;     // Catch: Exception -> L10
        r15.b(AppletOpenPageMethod.class);     // Catch: Exception -> L10
        r15.b(LauncherOnViewClickMethod.class);     // Catch: Exception -> L10
        r15.b(WidgetUpdateMethod.class);     // Catch: Exception -> L10
        r15.b(WidgetRefreshAffectedMethod.class);     // Catch: Exception -> L10
        r15.b(WidgetSendPayloadMethod.class);     // Catch: Exception -> L10
        r15.b(LogMethod.class);     // Catch: Exception -> L10
        r15.b(GetSystemTimeMethod.class);     // Catch: Exception -> L10
        Log.i("OMiniApp-WidgetSDKInitializer", "WidgetSDK initialized successfully");     // Catch: Exception -> L10
        return;
    L6:
        e = move-exception;
        Log.e("OMiniApp-WidgetSDKInitializer", "Failed to register AISDK multi-process service", e);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e("OMiniApp-WidgetSDKInitializer", "Failed to initialize WidgetSDK", e);
    }
}
