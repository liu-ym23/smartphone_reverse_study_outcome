package com.larus.bach.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Handler;
import android.util.LruCache;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final LruCache<String, Boolean> a = null;
    public static final ConcurrentHashMap<String, Runnable> b = null;
    public static final ConcurrentHashMap<String, String> c = null;
    public static final Lazy d = null;
    public static final Handler e = null;
    public static final CoroutineContext f = null;

    public static final class a extends CoroutineDispatcher {
        public a() {
        }

        public final void dispatch(CoroutineContext r2, Runnable r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "block");
            e.e.post(r3);
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DetectType.values().length];
            r0[DetectType.AVATAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public e() {
    }

    static {
        a = new LruCache(10);
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = LazyKt.lazy(new com.larus.bach.impl.b());
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("bach-detect-center-thread");
        ThreadMethodProxy.start(r0);
        e = new Handler(r0.getLooper());
        a r1 = new a();
        f = SupervisorKt.SupervisorJob$default(null, 1, null).plus(r1);
    }

    public static void a(Uri r3) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        ConcurrentHashMap<String, Runnable> r0 = b;
        Runnable r1 = r0.get(r3.toString());
        if (r1 == null) goto L6;
        e.removeCallbacks(r1);
        r0.remove(r3.toString());
        FLogger.a.i("BachDetectCenterManager", "[cancelBachDetectTask] cancel detect task, uri: " + r3);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.bach.impl.c, java.lang.Object] */
    public static void b(final Uri r5) {
        Intrinsics.checkNotNullParameter(r5, "uri");
        final g r0 = new g(r5, DetectType.AVATAR);
        ConcurrentHashMap<String, Runnable> r1 = b;
        if (r1.get(r5.toString()) == null) goto L6;
        FLogger.a.i("BachDetectCenterManager", "[detectAvatar] already executing detect task, uri: " + r5);
        return;
    L6:
        final ?? r2 = new c(r5);
        Intrinsics.checkNotNullParameter(r0, "bachDetectTask");
        Intrinsics.checkNotNullParameter(r2, "executeCallback");
        if (b.a[r0.b.ordinal()] != 1) goto L11;
        Runnable r6 = new d(r0, r2);
        r1.put(r0.a.toString(), r6);
        e.post(r6);
        FLogger.a.i("BachDetectCenterManager", "[executeDetectAvatarTask] post detect avatar uri: " + r0.a);
        return;
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public static Bitmap c(Uri r14) {
        Intrinsics.checkNotNullParameter(r14, "uri");
        AppHost.Companion r0 = AppHost.a;
        InputStream r1 = ContentResolverWrapper.openInputStream(r0.getApplication().getContentResolver(), r14);
        BitmapFactory.Options r2 = new BitmapFactory.Options();
        boolean r3 = true;
        r2.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(r1, null, r2);
        if (r1 == null) goto L5;
        r1.close();
    L5:
        float r5 = 1 / Math.max(1.0f, (r2.outWidth * r2.outHeight) / (9000000 * 1.0f));
        Matrix r12 = new Matrix();
        r12.setScale(r5, r5);
        r2.inJustDecodeBounds = false;
        InputStream r15 = ContentResolverWrapper.openInputStream(r0.getApplication().getContentResolver(), r14);
        Bitmap r7 = BitmapFactory.decodeStream(r15, null, r2);
        if (r15 == null) goto L9;
        r15.close();
    L9:
        if (r5 == 1.0f) goto L12;
        r3 = false;
    L12:
        if (r3 == true) goto L17;
        if (r7 == null) goto L18;
        FLogger.a.i("BachDetectCenterManager", "getBitmapFromUri: called, new bitmap size outWidth: " + r2.outWidth + " outHeight: " + r2.outHeight);
        return Bitmap.createBitmap(r7, 0, 0, r7.getWidth(), r7.getHeight(), r12, true);
    L18:
        return r7;
    L17:
        return r7;
    }
}
