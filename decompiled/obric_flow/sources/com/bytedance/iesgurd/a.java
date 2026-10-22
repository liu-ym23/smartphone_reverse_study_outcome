package com.bytedance.iesgurd;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.statistic.model.CleanStrategy;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.tasm.utils.j;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.LazyKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f6593a = null;

    static {
        f6593a = new ConcurrentHashMap();
        LazyKt.lazy(IESGurdKit$debuggable$2.f6586a);
    }

    public static void a(String r5, String r10) {
        if (r5.length() != 0) goto L6;
        return;
    L6:
        if (r10.length() == 0) goto L21;
        String r11 = (String) df.c.d.get(r5);
        if (r11 == null) goto L19;
        GeckoLogger.a("IESGurdKit.cleanCache: " + r5 + '-' + r10);
        com.bytedance.iesgurd.meta.e.g(r5, r10);
        StringBuilder r12 = sk.a.a(r11);
        String r13 = File.separator;
        com.bytedance.geckox.utils.d.j(new File(androidx.constraintlayout.motion.widget.a.u(r12, r13, r5, r13, r10)));
        CleanStrategy r14 = CleanStrategy.f6698a;
        if ((240 & 32) == 0) goto L13;
        int r15 = 200;
    L14:
        JSONObject r16 = new JSONObject();
        r16.put("clean_strategy", r14.ordinal());
        r16.put("clean_type", 1);
        r16.put("stats_type", r15);
        r16.put("access_key", r5);
        r16.put(LynxMonitorService.KEY_CHANNEL, r10);
        if (0 == 0) goto L17;
        r16.put("id", 0);
    L17:
        j.g("geckosdk_clean_stats", r16);
        dn.a.M(r5, r10);
        return;
    L13:
        r15 = 0;
        goto L14
    L19:
        return;
    }
}
