package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p {
    public final v a;
    public boolean b;
    public MusicPanel c;
    public DownloadTask d;
    public boolean e;

    public interface a {
        void a(MusicPanel r1, String r2, String r3);

        void b(MusicPanel r1, int r2, String r3);

        void c(MusicPanel r1, int r2);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.socialbase.downloader.model.DownloadTask");
    }

    public final void e() {
        if (this.d == null) goto L6;
        this.e = true;
        Downloader.getInstance(s1.getContext()).pause(this.d.getDownloadId());
        return;
    }

    public final void f() {
        if (this.d == null) goto L11;
        this.e = false;
        if (this.b == false) goto L7;
        Downloader.getInstance(s1.getContext()).cancel(this.d.getDownloadId());
    L7:
        DownloadTask r0 = this.d;
        if (r0 == null) goto L10;
        r0.subThreadListener(null);
    L10:
        this.d = null;
    L11:
        this.b = false;
    }

    public p(v r2) {
        this.b = false;
        this.a = r2;
    }

    public final String b(KtvMusic r6) throws Exception {
        String r0 = this.a.b(r6);
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0);
        if (r1.exists() == true) goto L10;
        if (r1.mkdirs() == false) goto L7;
        h.a();
        goto L10
    L7:
        HashMap r2 = new HashMap();
        r2.put("cache_path", r0);
        r2.put("music_id", String.valueOf(r6.getId()));
        r2.put("music_name", r6.getTitle());
        throw new IOException("mkdirs return false, dir=" + r1);
    L10:
        return r0 + this.a.a(r6);
    }

    public final boolean c(long r5) {
        MusicPanel r0 = this.c;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.b == true) goto L8;
        return false;
    L8:
        if (r0.a.getId() != r5) goto L12;
        return true;
    L12:
        return false;
    }

    public final Boolean d(MusicPanel r5) {
        if (this.c != null) goto L7;
        return Boolean.FALSE;
    L7:
        if (Objects.equals(r5.g(), this.c.g()) == true) goto L9;
    L11:
        boolean r6 = false;
    L13:
        return Boolean.valueOf(r6);
    L9:
        if (r5.a.getId() != this.c.a.getId()) goto L11;
        r6 = true;
        goto L13
    }
}
