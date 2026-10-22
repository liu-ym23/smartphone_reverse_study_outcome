package com.bytedance.geckox.pcdn;

import android.text.TextUtils;
import com.bytedance.android.live.pcdn.api.IPCDNDownloader;
import com.bytedance.android.live.pcdn.api.IPCDNDownloaderListener;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.settings.SettingsExtra;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static IPCDNDownloaderListener a() {
        return (IPCDNDownloaderListener) d.f4775j.getValue();
    }

    public final String b() {
        monitor-enter(this);
        df.c.f16652i.a();     // Catch: Throwable -> L11
        GeckoGlobalConfig r5 = df.c.f;     // Catch: Throwable -> L11
        if (r5 != null) goto L7;
        String r10 = "config not exist";
    L54:
        monitor-exit(this);
        return r10;
    L7:
        if (d.f4773h == null) goto L13;
        GeckoLogger.a("[pcdn]Odl already initialized");     // Catch: Throwable -> L11
        monitor-exit(this);
        return null;
    L13:
        SettingsExtra r11 = com.bytedance.iesgurd.settings.d.f6697j;     // Catch: Throwable -> L11
        if (r11 == null) goto L16;
        SettingsExtra.a r12 = r11.getPcdnInfo();     // Catch: Throwable -> L11
    L17:
        if (r12 != null) goto L20;
        r10 = "p2p struct not exists";
        goto L54
    L20:
        if (r12.a() != null) goto L58;
        r10 = "sid not exists";
        goto L54
    L58:
        Class<?> r13 = Class.forName("com.bytedance.android.live.pcdn.impl.PCDNDownloader");     // Catch: Throwable -> L51
    L61:
    L27:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        IPCDNDownloader r14 = (IPCDNDownloader) null;     // Catch: Throwable -> L11
        d.f4773h = null;     // Catch: Throwable -> L11
        GeckoLogger.a("[pcdn]Odl initialize failed, cause=" + th);     // Catch: Throwable -> L11
        return th.getMessage();
    L25:
        if (TextUtils.isEmpty(r5.getDeviceId()) == false) goto L29;
        r10 = "device_id is empty";
        goto L54
    L29:
        GeckoLogger.a("[pcdn]Starting to build odl config...");     // Catch: Throwable -> L27
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L27
        d.f4774i = new File(r5.getContext().getFilesDir(), "geckox_odl_root");     // Catch: Throwable -> L27
        File r16 = d.f4774i;     // Catch: Throwable -> L27
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("odlBaseAbsPath");     // Catch: Throwable -> L27
    L32:
        r15.put("pcdn_basepath", new File(r16, "base").getAbsolutePath());     // Catch: Throwable -> L27
        File r17 = d.f4774i;     // Catch: Throwable -> L27
        if (r17 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("odlBaseAbsPath");     // Catch: Throwable -> L27
    L35:
        r15.put("pcdn_cachepath", new File(r17, "meta_cache").getAbsolutePath());     // Catch: Throwable -> L27
        File r18 = d.f4774i;     // Catch: Throwable -> L27
        if (r18 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("odlBaseAbsPath");     // Catch: Throwable -> L27
    L38:
        r15.put("odl_cachepath", new File(r18, "odl_cache").getAbsolutePath());     // Catch: Throwable -> L27
        r15.put("pcdn_cachesize", 20);     // Catch: Throwable -> L27
        r15.put("pcdn_memorysize", 1);     // Catch: Throwable -> L27
        r15.put("pcdn_businessid", r12.a());     // Catch: Throwable -> L27
        r15.put("pcdn_groupid", r12.b());     // Catch: Throwable -> L27
        r15.put("pcdn_testid", r12.c());     // Catch: Throwable -> L27
        r15.put("deviceid", r5.getDeviceId());     // Catch: Throwable -> L27
        r15.put("appid", r5.getAppId());     // Catch: Throwable -> L27
        GeckoLogger.a("[pcdn]Starting to init odl downloader...");     // Catch: Throwable -> L27
        d.f4773h = (IPCDNDownloader) r13.getConstructor(null).newInstance(null);     // Catch: Throwable -> L27
        IPCDNDownloader r19 = d.f4773h;     // Catch: Throwable -> L27
        if (r19 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L27
    L41:
        String r20 = r15.toString();     // Catch: Throwable -> L27
        AtomicInteger r21 = d.g;     // Catch: Throwable -> L27
        int r22 = r19.init(r20, a());     // Catch: Throwable -> L27
        if (r22 != 0) goto L47;
        GeckoLogger.a("[pcdn]Odl initialize success");     // Catch: Throwable -> L27
        monitor-exit(this);
        return null;
    L47:
        throw new IllegalStateException("initDownloader failed, ret=" + r22);     // Catch: Throwable -> L27
    L51:
        th = move-exception;
        GeckoLogger.a("[pcdn]Odl plugin not installed yet..., cause by " + th);     // Catch: Throwable -> L11
        r10 = th.toString();     // Catch: Throwable -> L11
        goto L54
    L16:
        r12 = null;
    L11:
        th = move-exception;
        throw th;
    }
}
