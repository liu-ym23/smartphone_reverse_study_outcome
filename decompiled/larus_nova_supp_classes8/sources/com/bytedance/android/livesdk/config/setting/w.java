package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.android.livesdk.config.q4;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w {
    public static q4 a;

    public static final class a implements b70.a {
        public a() {
        }

        public final void onSuccess() {
            q4 r0 = w.a;
            w.a = (q4) b.a.getValue();
            ALogger.i("SlowFuncOpt", "update live_enter_room_slow_fun_opt: " + w.a);
        }
    }

    public static final class b extends SettingKey<q4> {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
            super("live_enter_room_slow_fun_opt", "进房慢函数优化一期", new q4(), new q4());
        }
    }

    static {
        a = (q4) b.a.getValue();
        SettingIncStrategy.a(new a());
    }

    @JvmStatic
    public static final boolean a() {
        if (a.a() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
