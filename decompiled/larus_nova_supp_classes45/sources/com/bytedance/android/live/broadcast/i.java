package com.bytedance.android.live.broadcast;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.jc1;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public static i d;
    public static final Map<String, Pair<Boolean, String>> e = null;
    public final Context a;
    public boolean b;
    public com.bytedance.android.live.effect.api.c c;

    static {
        e = new LinkedHashMap();
        new String[]{"c++_shared", "yuv", "ttffmpeg", "audioeffect", "bytenn", NewBroadcastMonitor.STAGE.EFFECT};
        new String[]{"IESSaliency", "ttquic", "avframework", "ies_render", "agora", "zegoliveroom", "bytertc", "bytevc1enc", "byteaudio"};
        new String[]{"avframework", "bytertc", "byteaudio"};
    }

    public static void b() {
        JavaCalls.callStaticMethodWithClassLoader("com.bytedance.ies.common.IESAppLogger", "sharedInstance", i.class.getClassLoader(), new Object[0]);     // Catch: Exception -> L5
        ALogger.e("LiveBroadcastContext", "loadIESAppLogger success:");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ALogger.e("LiveBroadcastContext", "loadIESAppLogger:", e);
    }

    public final com.bytedance.android.live.effect.api.c a() {
        if (this.c != null) goto L9;
        h r0 = (h) com.bytedance.android.scope.m.e.d(f00.a.b, h.class);
        if (r0 != null) goto L7;
        this.c = new j90.a();
        ALogger.e("LiveBroadcastContext", "init effectHostService error.");
        goto L9
    L7:
        this.c = r0.a();
        ALogger.i("LiveBroadcastContext", "init effectHostService " + this.c.hashCode());
    L9:
        return this.c;
    }

    public i() {
        this.b = false;
        ((Boolean) jc1.a.getValue()).booleanValue();
        this.a = s1.getContext();
    }

    public Context getContext() {
        return this.a;
    }
}
