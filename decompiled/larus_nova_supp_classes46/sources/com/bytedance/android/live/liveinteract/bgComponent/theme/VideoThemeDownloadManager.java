package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class VideoThemeDownloadManager {
    public static final Lazy a = null;
    public static final HashMap<String, a> b = null;

    public static final class a {
        public final String a;
        public final ArrayList<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> b;

        public a(String r2, String r3, ArrayList<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> r4) {
            Intrinsics.checkNotNullParameter(r2, "url");
            Intrinsics.checkNotNullParameter(r3, "id");
            Intrinsics.checkNotNullParameter(r4, "listeners");
            this.a = r3;
            this.b = r4;
        }
    }

    static {
        a = LazyKt.lazy(VideoThemeDownloadManager$STORAGE_ROOT_DIR$2.INSTANCE);
        b = new HashMap();
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

    public static String c() {
        StringBuilder r0 = new StringBuilder();
        r0.append((String) a.getValue());
        String r1 = File.separator;
        r0.append(r1);
        r0.append("theme");
        r0.append(r1);
        r0.append("video");
        r0.append(r1);
        return r0.toString();
    }

    public static String d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "videoUrl");
        return c() + String.valueOf(r2.hashCode());
    }

    public static boolean e(String r1) {
        Intrinsics.checkNotNullParameter(r1, "id");
        return new PolarisFileWrapper(d(r1)).exists();
    }

    public static void f(String r2, com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "downloadStateListener");
        HashMap<String, a> r0 = b;
        if (r0.containsKey(r2) == false) goto L10;
        a r4 = r0.get(r2);
        if (r4 == null) goto L11;
        ArrayList<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> r5 = r4.b;
        if (r5 == null) goto L12;
        r5.add(new WeakReference(r3));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void b(String r4, String r5, VideoThemeView.e r6) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        HashMap<String, a> r3 = b;
        if (r3.containsKey(r5) == false) goto L15;
        return;
    L15:
        if (e(r5) == false) goto L17;
        return;
    L17:
        if (r4 != null) goto L19;
    L22:
        if (r0 == false) goto L24;
        return;
    L24:
        r3.put(r5, new a(r4, r5, new ArrayList()));
        a r1 = r3.get(r5);
        if (r1 == null) goto L29;
        ArrayList<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> r7 = r1.b;
        if (r7 == null) goto L29;
        r7.add(new WeakReference(r6));
    L29:
        Downloader.with(s1.getContext()).url(r4).name(String.valueOf(r5.hashCode())).savePath(c()).subThreadListener(new g(r4, r5)).download();
        return;
    L19:
        if (r4.length() == 0) goto L22;
        r0 = false;
        goto L22
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
