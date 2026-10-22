package com.larus.voicecall.impl.util;

import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.g;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.lynx.canvas.camera.CameraSize;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import yp9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t0 {
    public static final t0 a = null;
    public static final Lazy b = null;
    public static final Keva c = null;
    public static final Lazy d = null;
    public static final AtomicBoolean e = null;
    public static final b f = null;
    public static final b g = null;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;

        public final String toString() {
            return "url:" + this.a + ",channel:" + this.b + ",saveKey:" + this.c;
        }

        public a(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, LynxEventReporter.PROP_NAME_URL);
            Intrinsics.checkNotNullParameter(r4, "channel");
            Intrinsics.checkNotNullParameter("PATH_KEY_BALL_BIG_VIDEO", "saveKey");
            this.a = r3;
            this.b = r4;
            this.c = "PATH_KEY_BALL_BIG_VIDEO";
        }
    }

    public static final class b {
        public final String a;
        public final int b;
        public final int c;
        public final int d;
        public final String e;
        public final String f;

        public final boolean a() {
            String r0 = this.e;
            if (r0 != null) goto L5;
            t0 r1 = t0.a;
            String r3 = this.a;
            r1.getClass();
            if (t0.f(r3) == true) goto L17;
            return false;
        L17:
            if (this.c > 0) goto L19;
            return false;
        L19:
            if (this.d <= 0) goto L27;
        L20:
            return true;
        L27:
            return false;
        L5:
            if (r0.length() <= 0) goto L7;
            boolean r2 = true;
        L8:
            if (r2 == true) goto L10;
            return false;
        L10:
            if (this.c > 0) goto L12;
            return false;
        L12:
            if (this.d > 0) goto L20;
            return false;
        L7:
            r2 = false;
            goto L8
        }

        public final String toString() {
            return "localUri:" + this.a + ",networkUrl:" + this.e + ",firstFrame:" + this.b + ",width:" + this.c + ",height:" + this.d;
        }

        public /* synthetic */ b(String r8, int r9, int r10, int r11) {
            this(r8, r9, r10, r11, null, null);
        }

        public b(String r2, int r3, int r4, int r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r2, "localUri");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public t0() {
    }

    static {
        a = new t0();
        b = LazyKt.lazy(new r0());
        c = Keva.getRepo("REALTIME_BIG_VIDEO_PATH");
        d = LazyKt.lazy(new s0());
        e = new AtomicBoolean(false);
        File r0 = e(AppHost.a.getApplication().getCacheDir().getPath() + "/realtime");
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getPath();
    L6:
        String r3 = NameKeys.UnloadStrategy_No_Strategy;
        if (r2 != null) goto L9;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        File r4 = e(r2.concat("/video"));
        if (r4 == null) goto L12;
        r1 = r4.getPath();
    L12:
        if (r1 == null) goto L15;
        r3 = r1;
    L15:
        String r5 = r3.concat("/bg_small_video.mp4");
        String r6 = r3.concat("/ball_small_video.mp4");
        f = new b(r5, 2131239475, 400, 866);
        int r7 = CameraSize.mediumWidth;
        g = new b(r6, 2131238532, r7, r7);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static b c() {
        String r0 = c.getString("PATH_KEY_BALL_BIG_VIDEO", NameKeys.UnloadStrategy_No_Strategy);
        Intrinsics.checkNotNull(r0);
        int r3 = 900;
        return new b(r0, 2131238532, r3, r3);
    }

    public static b d() {
        Lazy r0 = d;
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L8;
        if (c().a() == false) goto L8;
        return c();
    L8:
        if (((Boolean) r0.getValue()).booleanValue() == true) goto L10;
    L13:
        b r1 = g;
        if (r1.a() == true) goto L22;
        b("ball_small_video.mp4", r1.a);
        if (r1.a() == false) goto L20;
        return r1;
    L20:
        return null;
    L22:
        return r1;
    L10:
        if (e.getAndSet(true) == true) goto L13;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeDiskExt$preloadBigVideoIfNeed$1(null), 2, null);
        goto L13
    }

    public static File e(String r1) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        PolarisFileWrapper r2 = new PolarisFileWrapper(r1);     // Catch: Throwable -> L7
        if (r2.exists() == true) goto L5;
        r2.mkdirs();     // Catch: Throwable -> L7
    L5:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = null;
    L13:
        return (File) r3;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static boolean f(String r4) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        if (new PolarisFileWrapper(r4).exists() == true) goto L6;
        return false;
    L6:
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 != null) goto L14;
        return true;
    L14:
        FLogger.a.e("RealtimeDiskExt", "isFileExits failed:" + r6);
        return false;
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static final void a(t0 r5, a r6) {
        r5.getClass();
        long r0 = System.currentTimeMillis();
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L5;
        r7.a0();
        String r8 = g.a.c(r6.a, r6.b, false);
    L6:
        if (r8 != null) goto L8;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        boolean r2 = f(r8);
        if (r2 == false) goto L11;
        c.storeString(r6.c, r8);
    L11:
        long r3 = System.currentTimeMillis() - r0;
        FLogger.a.i("RealtimeDiskExt", "loadSyncGeckoResource, config:" + r6 + ",isSuccess:" + r2 + ",costTime:" + r3);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public static void b(String r7, String r8) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L19
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L19
        PolarisFileWrapper r4 = new PolarisFileWrapper(r8);     // Catch: Throwable -> L19
        InputStream r9 = AppHost.a.getApplication().getAssets().open(r7);     // Catch: Throwable -> L19
        PolarisFileOutputStreamWrapper r10 = new PolarisFileOutputStreamWrapper(r4);     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L9
        ByteStreamsKt.copyTo$default(r9, r10, 0, 2, null);     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L19
        long r11 = System.currentTimeMillis() - r3;     // Catch: Throwable -> L19
        FLogger.a.i("RealtimeDiskExt", "copyFromAssets, costTime:" + r11);     // Catch: Throwable -> L19
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L34;
        String r14 = r13.toString();
        d.b.a("RealtimeDiskExt", r14);
        FLogger.a.e("RealtimeDiskExt", "copy from asset failed:" + r14);
        return;
    L34:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }
}
