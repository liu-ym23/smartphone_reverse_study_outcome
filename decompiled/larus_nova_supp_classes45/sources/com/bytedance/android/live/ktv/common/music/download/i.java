package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {

    public interface a {
        void a(long r1, int r3, String r4);

        void b(ub0.c r1);
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ i a;
        public final /* synthetic */ ub0.c b;
        public final /* synthetic */ a c;

        public b(i r1, ub0.c r2, a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void subscribe(ObservableEmitter<Object> r11) {
            Intrinsics.checkNotNullParameter(r11, "it");
            i r12 = this.a;
            ub0.c r0 = this.b;
            a r1 = this.c;
            r12.getClass();
            String r13 = r0.d;
            long r2 = System.currentTimeMillis();
            DownloadTask r14 = Downloader.with(s1.getContext()).url(r0.a).name(h.c(r13)).savePath(h.f(r13)).autoRemoveCallback(true).monitorScene("musicpack_lyrics");
            Class r5 = i.a();     // Catch: Exception -> L5
            Object r6 = r5.newInstance();     // Catch: Exception -> L5
            Method r7 = r5.getDeclaredMethod("setCacheLifeTimeMax", new Class[0]);     // Catch: Exception -> L5
            r7.setAccessible(true);     // Catch: Exception -> L5
            r7.invoke(r6, new Object[]{1209600});     // Catch: Exception -> L5
        L7:
            r14.mainThreadListener(new j(r0, r2, r1)).download();
            return;
        L5:
            e = move-exception;
            String r4 = "set cache life time max fail : " + e.getMessage();
            ALogger.i(bb0.b.b(), r4 + ", invoke class :" + i.class.getSimpleName());
            goto L7
        }
    }

    public i() {
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

    public final void b(ub0.c r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "lyricsDownloadInfo");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Observable.create(new b(this, r2, r3)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.user.h());
    }
}
