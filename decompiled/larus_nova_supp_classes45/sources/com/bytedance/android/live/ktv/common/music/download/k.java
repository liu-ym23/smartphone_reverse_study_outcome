package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
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
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k {
    public static final a a = null;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.music.download.k$a$a, reason: collision with other inner class name */
        public static final class C0216a<T> implements ObservableOnSubscribe {
            public final /* synthetic */ c a;
            public final /* synthetic */ WeakReference b;

            public C0216a(c r1, WeakReference r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void subscribe(ObservableEmitter<Object> r8) {
                Intrinsics.checkNotNullParameter(r8, "it");
                a r9 = k.a;
                c r0 = this.a;
                WeakReference r1 = this.b;
                r9.getClass();
                DownloadTask r11 = Downloader.with(s1.getContext()).url(r0.b).name(h.c(r0.c)).savePath(h.f(r0.c)).monitorScene("musicpack_midi");
                Class r2 = a.a();     // Catch: Exception -> L5
                Object r3 = r2.newInstance();     // Catch: Exception -> L5
                Method r4 = r2.getDeclaredMethod("setCacheLifeTimeMax", new Class[0]);     // Catch: Exception -> L5
                r4.setAccessible(true);     // Catch: Exception -> L5
                r4.invoke(r3, new Object[]{1209600});     // Catch: Exception -> L5
            L7:
                Ref.IntRef r5 = new Ref.IntRef();
                r5.element = r11.getDownloadId();
                r11.subThreadListener(new l(r1, r0, r5)).download();
                return;
            L5:
                e = move-exception;
                String r6 = "set cache life time max fail : " + e.getMessage();
                ALogger.i(bb0.b.b(), r6 + ", invoke class :" + a.class.getSimpleName());
                goto L7
            }
        }

        public a() {
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

        public static void b(c r1, WeakReference r2) {
            Intrinsics.checkNotNullParameter(r1, "info");
            Intrinsics.checkNotNullParameter(r2, "callback");
            Observable.create(new C0216a(r1, r2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.user.h());
        }
    }

    public interface b {
        void a(long r1, String r3, int r4);

        void onFailed(String r1, int r2);
    }

    public static final class c {
        public final long a;
        public final String b;
        public final String c;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof c) == false) goto L12;
            c r7 = (c) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.hashCode();
        L6:
            int r5 = (r1 + r4) * 31;
            String r6 = this.c;
            if (r6 == null) goto L10;
            r3 = r6.hashCode();
        L10:
            return r5 + r3;
        L5:
            r4 = 0;
            goto L6
        }

        public final String toString() {
            return "KtvMidiDownloadInfo(musicId=" + this.a + ", url=" + this.b + ", midiSavePath=" + this.c + ")";
        }

        public c(long r2, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, LiveSlardarConstants.EXTRA_KEY_URL);
            Intrinsics.checkNotNullParameter(r5, "midiSavePath");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    static {
        a = new a();
    }
}
