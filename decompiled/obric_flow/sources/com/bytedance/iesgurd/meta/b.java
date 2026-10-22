package com.bytedance.iesgurd.meta;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.keva.Keva;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6646a = null;

    static {
        f6646a = new b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Keva r5 = e.f6649a;
        GeckoLogger.a("ChannelMetaManager migrateRes");
        e.f6650b = Keva.getRepo("gecko_channel_meta_migrate", 1);
        ConcurrentHashMap r10 = df.c.d;
        df.c.f16649b.set(true);
        Iterator r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) r11.next();
        e.e((String) r12.getKey(), (String) r12.getValue());
        goto L4
    }
}
