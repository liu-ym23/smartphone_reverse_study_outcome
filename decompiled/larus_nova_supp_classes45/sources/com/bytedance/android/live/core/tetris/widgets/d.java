package com.bytedance.android.live.core.tetris.widgets;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LiveInteractOptConfig;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final SettingKey<LiveInteractOptConfig> a = null;
    public static final SettingKey<a0> b = null;

    static {
        a = new SettingKey("live_preload_interaction_switch", "直播间是否开启预加载交互层", new LiveInteractOptConfig(), new LiveInteractOptConfig(), false);
        b = new SettingKey("live_widget_priority_split", "组件优先级打散", new a0(), new a0(), false);
    }

    @JvmStatic
    public static final boolean d() {
        return b.getValue().a();
    }

    public static LiveInteractOptConfig f() {
        return a.getValue();
    }

    @JvmStatic
    public static final boolean a() {
        if (f().isTurnon() == true) goto L5;
    L7:
        return false;
    L5:
        if (f().getEnablePreEnter() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean b() {
        return f().isTurnon();
    }

    @JvmStatic
    public static final boolean c() {
        if (f().isTurnon() == true) goto L5;
    L7:
        return false;
    L5:
        if (f().getEnableWidgetLoadPriority() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final void g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.i("LiveInteractionOpt", r3);
    }

    @JvmStatic
    public static final void e(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "errorService");
        LocalTestManager.a(new Class[]{wy.a.class});
        JSONObject r0 = new JSONObject();
        Iterator r5 = ((HashMap) r4).entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r5.next();
        r0.put((String) r1.getKey(), r1.getValue());
        goto L4
    L6:
        LiveTracingMonitor.d(r3, LiveTracingMonitor.EventModule.INTERACTION_OPT, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r0);
    }
}
