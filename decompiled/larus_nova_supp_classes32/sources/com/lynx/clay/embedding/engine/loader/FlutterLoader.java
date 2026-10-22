package com.lynx.clay.embedding.engine.loader;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.utils.logger.FLogger;
import com.lynx.clay.embedding.android.FunctorView;
import com.lynx.clay.embedding.engine.FlutterJNI;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.textra.TTText;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlutterLoader {
    public boolean a;
    public c b;
    public long c;
    public com.lynx.clay.embedding.engine.loader.b d;
    public FlutterJNI e;
    public Future<b> f;

    public interface a {
        void a() throws UnsatisfiedLinkError;
    }

    public static class b {
        public final String a;
        public final String b;

        public b(String r2) {
            this.a = NameKeys.UnloadStrategy_No_Strategy;
            this.b = r2;
        }
    }

    public static class c {
        public String a;

        public c() {
        }
    }

    public FlutterLoader() {
        FlutterJNI r0 = new FlutterJNI();
        this.a = false;
        this.e = r0;
    }

    public final JSONObject b() {
        String r1 = this.b.a;
        if (TextUtils.isEmpty(r1) == false) goto L12;
        return null;
    L12:
        JSONObject r2 = new JSONObject(r1);     // Catch: Exception -> L9
        if (r2.has("clay") == false) goto L14;
        return JSONObjectProtectorUtils.getJSONObject(r2, "clay");
    L14:
        return null;
    L9:
        e = move-exception;
        c5a.c.b("FlutterLoader", "getClaySettings error", e);
        return null;
    }

    public FlutterJNI getFlutterJNI() {
        FlutterJNI r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        FlutterJNI r1 = new FlutterJNI();
        this.e = r1;
        return r1;
    }

    public static void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r3));
        com.bytedance.librarian.a.c(r3);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r3));
    }

    public final synchronized void f(Context r5) {
        monitor-enter(this);
        Flipped.invokeHiddenApiRestrictions();     // Catch: Throwable -> L12
        Context r0 = r5.getApplicationContext();     // Catch: Throwable -> L12
        JSONObject r1 = b();     // Catch: Throwable -> L12
        this.c = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        this.d = com.lynx.clay.embedding.engine.loader.a.a(r0);     // Catch: Throwable -> L12
        FlutterJNI.setAsyncWaitForVsyncDelegate(w5a.a.a((DisplayManager) r0.getSystemService("display"), this.e).c);     // Catch: Throwable -> L12
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
        com.lynx.clay.embedding.engine.loader.c r3 = new com.lynx.clay.embedding.engine.loader.c(this, r5, r1);     // Catch: Throwable -> L12
        this.f = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("FlutterLoader")).submit(r3);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L9:
        this.f = CompletableFuture.completedFuture(d(r5, this.e, r1));     // Catch: Throwable -> L12
        goto L10
    L6:
        r2 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(Context r20, String[] r21) {
        monitor-enter(this);
        TraceEvent.beginSection("clay", "FlutterLoader.EnsureInitializationComplete");     // Catch: Throwable -> L52
    L49:
        th = move-exception;
        TraceEvent.endSection("clay", "FlutterLoader.EnsureInitializationComplete");     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L6:
        if (this.a == false) goto L11;
        TraceEvent.endSection("clay", "FlutterLoader.EnsureInitializationComplete");     // Catch: Throwable -> L52
        monitor-exit(this);
        return;
    L11:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L48;
        if (this.b == null) goto L46;
    L42:
        e = move-exception;
        c5a.c.b("FlutterLoader", "Flutter initialization failed.", e);     // Catch: Throwable -> L49
        throw new RuntimeException(e);     // Catch: Throwable -> L49
    L15:
        if (this.f != null) goto L17;
        c5a.c.d(6, "FlutterLoader", "FlutterLoader#startInitialization has not finished yet");     // Catch: Exception -> L42 Throwable -> L49
        f(r20);     // Catch: Exception -> L42 Throwable -> L49
    L17:
        b r6 = this.f.get();     // Catch: Exception -> L42 Throwable -> L49
        w5a.a.b r8 = w5a.a.g;     // Catch: Exception -> L42 Throwable -> L49
        if (r8 == null) goto L20;
        r8.a();     // Catch: Exception -> L42 Throwable -> L49
    L20:
        ArrayList r9 = new ArrayList();     // Catch: Exception -> L42 Throwable -> L49
        r9.add("--icu-symbol-prefix=_binary_icudtl_dat");     // Catch: Exception -> L42 Throwable -> L49
        r9.add("--icu-native-lib-path=" + this.d.c + File.separator + "libclay.so");     // Catch: Exception -> L42 Throwable -> L49
        if (r21 == null) goto L23;
        Collections.addAll(r9, r21);     // Catch: Exception -> L42 Throwable -> L49
    L23:
        int r0 = r20.getResources().getConfiguration().uiMode & 15;     // Catch: Exception -> L42 Throwable -> L49
        if (r0 != 1) goto L26;
        r9.add("--enable-stencil-buffer");     // Catch: Exception -> L42 Throwable -> L49
        r9.add("--gpu-cache-multiplier=12");     // Catch: Exception -> L42 Throwable -> L49
    L30:
        r9.add("--cache-dir-path=" + r6.b);     // Catch: Exception -> L42 Throwable -> L49
        if (this.d.b == null) goto L33;
        r9.add("--domain-network-policy=" + this.d.b);     // Catch: Exception -> L42 Throwable -> L49
    L33:
        Bundle r1 = r20.getPackageManager().getApplicationInfo(r20.getPackageName(), LynxTouchEvent.kPseudoStateFocusTransition).metaData;     // Catch: Exception -> L42 Throwable -> L49
        if (r1 != null) goto L36;
    L38:
        this.e.init(r20, (String[]) r9.toArray(new String[0]), null, r6.a, r6.b, SystemClock.uptimeMillis() - this.c);     // Catch: Exception -> L42 Throwable -> L49
        this.a = true;     // Catch: Exception -> L42 Throwable -> L49
        TraceEvent.endSection("clay", "FlutterLoader.EnsureInitializationComplete");     // Catch: Throwable -> L52
        monitor-exit(this);
        return;
    L36:
        if (r1.getBoolean("com.lynx.clay.embedding.android.EnableSkParagraph") == false) goto L38;
        r9.add("--enable-skparagraph");     // Catch: Exception -> L42 Throwable -> L49
        goto L38
    L26:
        if (r0 == 4) goto L28;
        c5a.c.d(6, "FlutterLoader", "Unknow ui mode? mode=" + r0);     // Catch: Exception -> L42 Throwable -> L49
        goto L30
    L28:
        r9.add("--gpu-cache-multiplier=1");     // Catch: Exception -> L42 Throwable -> L49
        goto L30
    L46:
        throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");     // Catch: Throwable -> L49
    L48:
        throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");     // Catch: Throwable -> L49
    L52:
        th = move-exception;
        throw th;
    }

    public final synchronized void e(Context r3, c r4) {
        monitor-enter(this);
        TraceEvent.beginSection("clay", "FlutterLoader.StartInitialization");     // Catch: Throwable -> L17
    L14:
        th = move-exception;
        TraceEvent.endSection("clay", "FlutterLoader.StartInitialization");     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L5:
        if (this.b == null) goto L10;
        TraceEvent.instant("clay", "FlutterLoader.StartInitializationSkipped");     // Catch: Throwable -> L14
        TraceEvent.endSection("clay", "FlutterLoader.StartInitialization");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L10:
        this.b = r4;     // Catch: Throwable -> L14
        f(r3);     // Catch: Throwable -> L14
        TraceEvent.endSection("clay", "FlutterLoader.StartInitialization");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static b d(Context r7, FlutterJNI r8, JSONObject r9) {
        TraceEvent.beginSection("clay", "FlutterLoader.PerformInnerInitializationTasks");
        TraceEvent.beginSection("clay", "FlutterLoader.LoadLibrary");     // Catch: Throwable -> L41
        r8.loadLibrary(null);     // Catch: Throwable -> L38
        TraceEvent.endSection("clay", "FlutterLoader.LoadLibrary");     // Catch: Throwable -> L41
        boolean r4 = false;
        c("kryptoni18n");     // Catch: RuntimeException -> L12 UnsatisfiedLinkError -> L14 Throwable -> L41
        c("tttext_lite");     // Catch: RuntimeException -> L12 UnsatisfiedLinkError -> L14 Throwable -> L41
        if (TTText.PreloadSelfRendering(false) == true) goto L16;
        c5a.c.d(6, "FlutterLoader", "TTText self-rendering preload failed.");     // Catch: RuntimeException -> L12 UnsatisfiedLinkError -> L14 Throwable -> L41
    L16:
        r8.updateRefreshRate();     // Catch: Throwable -> L41
        FunctorView.f();     // Catch: Throwable -> L41
        if (r9 == null) goto L24;
        String r10 = r9.optString("disablePrefetchDefaultFontManager", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L41
        if ("1".equals(r10) == false) goto L22;
    L23:
        r4 = true;
        goto L24
    L22:
        if ("true".equalsIgnoreCase(r10) == true) goto L23;
    L24:
        if (r4 == true) goto L44;
        TraceEvent.beginSection("clay", "FlutterLoader.PrefetchDefaultFontManager");     // Catch: Throwable -> L41
        r8.prefetchDefaultFontManager();     // Catch: Throwable -> L28
        TraceEvent.endSection("clay", "FlutterLoader.PrefetchDefaultFontManager");     // Catch: Throwable -> L41
        goto L44
    L28:
        th = move-exception;
        TraceEvent.endSection("clay", "FlutterLoader.PrefetchDefaultFontManager");     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L44:
        String r11 = r7.getCodeCacheDir().getPath();     // Catch: Exception -> L34 Throwable -> L41
    L35:
        b r12 = new b(r11);     // Catch: Throwable -> L41
        TraceEvent.endSection("clay", "FlutterLoader.PerformInnerInitializationTasks");
        return r12;
    L34:
        r11 = r7.getCacheDir().getPath();     // Catch: Throwable -> L41
    L12:
        e = move-exception;
        c5a.c.b("FlutterLoader", "Skip TTText self-rendering preload because native library load failed.", e);     // Catch: Throwable -> L41
    L14:
        e = move-exception;
        c5a.c.b("FlutterLoader", "Skip TTText self-rendering preload because native libraries are unavailable.", e);     // Catch: Throwable -> L41
        goto L16
    L38:
        th = move-exception;
        TraceEvent.endSection("clay", "FlutterLoader.LoadLibrary");     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        TraceEvent.endSection("clay", "FlutterLoader.PerformInnerInitializationTasks");
        throw th;
    }
}
