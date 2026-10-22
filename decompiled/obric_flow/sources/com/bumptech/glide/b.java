package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import com.bumptech.glide.load.data.h;
import com.bumptech.glide.load.data.m;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.resource.bitmap.i;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.p;
import com.bumptech.glide.load.resource.bitmap.w;
import com.bumptech.glide.load.resource.bitmap.z;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.k;
import d0.a0;
import d0.c0;
import d0.e0;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile b f1380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f1381j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.a f1382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0.d f1383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f1384c;
    public final d d;
    public final com.bumptech.glide.load.engine.bitmap_recycle.f e;
    public final k0.f f;
    public final s6.b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f1385h;

    public b(Context r24, s r25, b0.d r26, com.bumptech.glide.load.engine.bitmap_recycle.a r27, com.bumptech.glide.load.engine.bitmap_recycle.f r28, k0.f r29, s6.b r30, ib.d r31, ArrayMap r32, List r33) {
        this.f1385h = new ArrayList();
        this.f1382a = r27;
        this.e = r28;
        this.f1383b = r26;
        this.f = r29;
        this.g = r30;
        Resources r5 = r24.getResources();
        d r10 = new d();
        this.d = r10;
        i r11 = new i();
        bd.d r12 = r10.g;
        monitor-enter(r12);
        ((ArrayList) r12.f905a).add(r11);     // Catch: Throwable -> L18
        monitor-exit(r12);
        p r13 = new p();
        bd.d r14 = r10.g;
        monitor-enter(r14);
        ((ArrayList) r14.f905a).add(r13);     // Catch: Throwable -> L14
        monitor-exit(r14);
        ArrayList r15 = r10.e();
        com.bumptech.glide.load.resource.gif.b r16 = new com.bumptech.glide.load.resource.gif.b(r24, r15, r27, r28);
        z r17 = new z(r27, new com.lynx.tasm.behavior.d(3));
        l r18 = new l(r10.e(), r5.getDisplayMetrics(), r27, r28);
        com.bumptech.glide.load.resource.bitmap.e r19 = new com.bumptech.glide.load.resource.bitmap.e(r18, 0);
        com.bumptech.glide.load.resource.bitmap.a r110 = new com.bumptech.glide.load.resource.bitmap.a(2, r18, r28);
        com.bumptech.glide.load.resource.bitmap.e r111 = new com.bumptech.glide.load.resource.bitmap.e(r24);
        a0 r112 = new a0(r5, 2);
        a0 r113 = new a0(r5, 3);
        a0 r114 = new a0(r5, 1);
        a0 r20 = new a0(r5, 0);
        com.bumptech.glide.load.resource.bitmap.b r21 = new com.bumptech.glide.load.resource.bitmap.b(r28);
        al.a r22 = new al.a(7);
        j0.c r115 = new j0.c(1);
        ContentResolver r23 = r24.getContentResolver();
        r10.b(ByteBuffer.class, new d0.c(2));
        r10.b(InputStream.class, new zm.c(r28, 6));
        r10.d("Bitmap", ByteBuffer.class, Bitmap.class, r19);
        r10.d("Bitmap", InputStream.class, Bitmap.class, r110);
        r10.d("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new com.bumptech.glide.load.resource.bitmap.e(r18, 1));
        r10.d("Bitmap", ParcelFileDescriptor.class, Bitmap.class, r17);
        r10.d("Bitmap", AssetFileDescriptor.class, Bitmap.class, new z(r27, new com.bytedance.frameworks.baselib.network.http.cronet.b(3)));
        c0 r34 = c0.f16532b;
        r10.a(Bitmap.class, Bitmap.class, r34);
        r10.d("Bitmap", Bitmap.class, Bitmap.class, new w(0));
        r10.c(Bitmap.class, r21);
        r10.d("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(r5, r19));
        r10.d("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(r5, r110));
        r10.d("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(r5, r17));
        r10.c(BitmapDrawable.class, new ym.p(2, r27, r21));
        r10.d("Gif", InputStream.class, GifDrawable.class, new k(r15, r16, r28));
        r10.d("Gif", ByteBuffer.class, GifDrawable.class, r16);
        r10.c(GifDrawable.class, new f9.a(3));
        r10.a(x.a.class, x.a.class, r34);
        r10.d("Bitmap", x.a.class, Bitmap.class, new com.bumptech.glide.load.resource.gif.i(r27));
        r10.d("legacy_append", Uri.class, Drawable.class, r111);
        r10.d("legacy_append", Uri.class, Bitmap.class, new com.bumptech.glide.load.resource.bitmap.a(1, r111, r27));
        r10.g(new h(2));
        r10.a(File.class, ByteBuffer.class, new c0(3));
        r10.a(File.class, InputStream.class, new d0.f(new d0.c(5)));
        r10.d("legacy_append", File.class, File.class, new w(2));
        r10.a(File.class, ParcelFileDescriptor.class, new d0.f(new d0.c(4)));
        r10.a(File.class, File.class, r34);
        r10.g(new m(r28));
        r10.g(new h(1));
        Class r35 = Integer.TYPE;
        r10.a(r35, InputStream.class, r112);
        r10.a(r35, ParcelFileDescriptor.class, r114);
        r10.a(Integer.class, InputStream.class, r112);
        r10.a(Integer.class, ParcelFileDescriptor.class, r114);
        r10.a(Integer.class, Uri.class, r113);
        r10.a(r35, AssetFileDescriptor.class, r20);
        r10.a(Integer.class, AssetFileDescriptor.class, r20);
        r10.a(r35, Uri.class, r113);
        r10.a(String.class, InputStream.class, new y.b(1));
        r10.a(Uri.class, InputStream.class, new y.b(1));
        r10.a(String.class, InputStream.class, new c0(6));
        r10.a(String.class, ParcelFileDescriptor.class, new c0(5));
        r10.a(String.class, AssetFileDescriptor.class, new c0(4));
        r10.a(Uri.class, InputStream.class, new e0.b(0));
        r10.a(Uri.class, InputStream.class, new d0.a(r24.getAssets(), 1));
        r10.a(Uri.class, ParcelFileDescriptor.class, new d0.a(r24.getAssets(), 0));
        r10.a(Uri.class, InputStream.class, new d0.l(r24, 1));
        r10.a(Uri.class, InputStream.class, new d0.l(r24, 2));
        r10.a(Uri.class, InputStream.class, new e0.d(r24, InputStream.class));
        r10.a(Uri.class, ParcelFileDescriptor.class, new e0.d(r24, ParcelFileDescriptor.class));
        r10.a(Uri.class, InputStream.class, new e0(r23, 2));
        r10.a(Uri.class, ParcelFileDescriptor.class, new e0(r23, 1));
        r10.a(Uri.class, AssetFileDescriptor.class, new e0(r23, 0));
        r10.a(Uri.class, InputStream.class, new c0(7));
        r10.a(URL.class, InputStream.class, new e0.b(1));
        r10.a(Uri.class, File.class, new d0.l(r24, 0));
        r10.a(d0.g.class, InputStream.class, new y.b(2));
        r10.a(byte[].class, ByteBuffer.class, new c0(1));
        r10.a(byte[].class, InputStream.class, new c0(2));
        r10.a(Uri.class, Uri.class, r34);
        r10.a(Drawable.class, Drawable.class, r34);
        r10.d("legacy_append", Drawable.class, Drawable.class, new w(1));
        r10.h(Bitmap.class, BitmapDrawable.class, new mn.i(r5));
        r10.h(Bitmap.class, byte[].class, r22);
        r10.h(Drawable.class, byte[].class, new i4.a(r27, 5, r22, r115));
        r10.h(GifDrawable.class, byte[].class, r115);
        z r36 = new z(r27, new com.bytedance.ies.bullet.service.base.c(3));
        r10.d("legacy_append", ByteBuffer.class, Bitmap.class, r36);
        r10.d("legacy_append", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(r5, r36));
        this.f1384c = new c(r24, r28, r10, new s6.b(12), r31, r32, r33, r25);
        return;
    L14:
        th = move-exception;
        throw th;
    L18:
        th = move-exception;
        throw th;
    }

    public static void a(Context r29, GeneratedAppGlideModule r30) {
        if (f1381j == true) goto L94;
        f1381j = true;
        ArrayMap r10 = new ArrayMap();
        ib.d r11 = new ib.d(2);
        Context r12 = r29.getApplicationContext();
        Collections.emptyList();
        if (Log.isLoggable("ManifestParser", 3) == false) goto L7;
        Log.d("ManifestParser", "Loading Glide modules");
    L7:
        ArrayList r13 = new ArrayList();
        ApplicationInfo r5 = r12.getPackageManager().getApplicationInfo(r12.getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L13
        if (r5.metaData != null) goto L16;
        if (Log.isLoggable("ManifestParser", 3) == false) goto L31;
        Log.d("ManifestParser", "Got null app info metadata");     // Catch: PackageManager.NameNotFoundException -> L13
    L31:
        if (r30 == null) goto L45;
        if (r30.q().isEmpty() == true) goto L45;
        Set r14 = r30.q();
        Iterator r15 = r13.iterator();
    L36:
        if (r15.hasNext() == false) goto L45;
        OkHttpGlideModule r16 = (OkHttpGlideModule) r15.next();
        if (r14.contains(r16.getClass()) == false) goto L36;
        if (Log.isLoggable("Glide", 3) == false) goto L43;
        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + r16);
    L43:
        r15.remove();
    L45:
        if (Log.isLoggable("Glide", 3) == false) goto L50;
        Iterator r17 = r13.iterator();
    L48:
        if (r17.hasNext() == false) goto L50;
        Log.d("Glide", "Discovered GlideModule from manifest: " + ((OkHttpGlideModule) r17.next()).getClass());
    L50:
        Iterator r18 = r13.iterator();
    L52:
        if (r18.hasNext() == false) goto L55;
        ((OkHttpGlideModule) r18.next()).getClass();
        goto L52
    L55:
        if (c0.b.f1098c != 0) goto L57;
        c0.b.f1098c = Math.min(4, Runtime.getRuntime().availableProcessors());
    L57:
        int r19 = c0.b.f1098c;
        if (TextUtils.isEmpty("source") == true) goto L90;
        TimeUnit r20 = TimeUnit.MILLISECONDS;
        c0.b r21 = new c0.b(new ThreadPoolExecutor(r19, r19, 0, r20, new PriorityBlockingQueue(), new c0.a("source", false)));
        if (TextUtils.isEmpty("disk-cache") == true) goto L88;
        c0.b r22 = new c0.b(new ThreadPoolExecutor(1, 1, 0, r20, new PriorityBlockingQueue(), new c0.a("disk-cache", true)));
        if (c0.b.f1098c != 0) goto L65;
        c0.b.f1098c = Math.min(4, Runtime.getRuntime().availableProcessors());
    L65:
        if (c0.b.f1098c < 4) goto L67;
        int r110 = 2;
    L69:
        if (TextUtils.isEmpty("animation") == true) goto L86;
        c0.b r23 = new c0.b(new ThreadPoolExecutor(r110, r110, 0, r20, new PriorityBlockingQueue(), new c0.a("animation", true)));
        b0.f r24 = new b0.f(new b0.e(r12));
        s6.b r25 = new s6.b(11);
        int r26 = r24.f813a;
        if (r26 <= 0) goto L73;
        com.bumptech.glide.load.engine.bitmap_recycle.a r27 = new com.bumptech.glide.load.engine.bitmap_recycle.g(r26);
    L74:
        com.bumptech.glide.load.engine.bitmap_recycle.f r28 = new com.bumptech.glide.load.engine.bitmap_recycle.f(r24.f815c);
        b0.d r111 = new b0.d(r24.f814b);
        com.bumptech.glide.load.engine.bitmap_recycle.a r31 = r27;
        b r112 = new b(r12, new s(r111, new sj.k(r12), r22, r21, new c0.b(new ThreadPoolExecutor(0, Integer.MAX_VALUE, c0.b.f1097b, r20, new SynchronousQueue(), new c0.a("source-unlimited", false))), r23), r111, r31, r28, new k0.f(), r25, r11, r10, Collections.emptyList());
        Iterator r32 = r13.iterator();
    L76:
        if (r32.hasNext() == false) goto L83;
        OkHttpGlideModule r33 = (OkHttpGlideModule) r32.next();
        r33.a(r112.d);     // Catch: AbstractMethodError -> L80
    L80:
        e = move-exception;
        throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ".concat(r33.getClass().getName()), e);
    L83:
        r12.registerComponentCallbacks(r112);
        f1380i = r112;
        f1381j = false;
        return;
    L73:
        r27 = new t9.a();
        goto L74
    L86:
        throw new IllegalArgumentException("Name must be non-null and non-empty, but given: animation");
    L67:
        r110 = 1;
        goto L69
    L88:
        throw new IllegalArgumentException("Name must be non-null and non-empty, but given: disk-cache");
    L90:
        throw new IllegalArgumentException("Name must be non-null and non-empty, but given: source");
    L16:
        if (Log.isLoggable("ManifestParser", 2) == false) goto L18;
        Log.v("ManifestParser", "Got app info metadata: " + r5.metaData);     // Catch: PackageManager.NameNotFoundException -> L13
    L18:
        Iterator<String> r34 = r5.metaData.keySet().iterator();     // Catch: PackageManager.NameNotFoundException -> L13
    L20:
        if (r34.hasNext() == false) goto L28;
        String r35 = r34.next();     // Catch: PackageManager.NameNotFoundException -> L13
        if ("GlideModule".equals(r5.metaData.get(r35)) == false) goto L20;
        r13.add(xq.b.u(r35));     // Catch: PackageManager.NameNotFoundException -> L13
        if (Log.isLoggable("ManifestParser", 3) == false) goto L20;
        Log.d("ManifestParser", "Loaded Glide module: " + r35);     // Catch: PackageManager.NameNotFoundException -> L13
        goto L20
    L28:
        if (Log.isLoggable("ManifestParser", 3) == false) goto L31;
        Log.d("ManifestParser", "Finished loading Glide modules");
    L13:
        e = move-exception;
        throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
    L94:
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    public static b b(Context r5) {
        if (f1380i != null) goto L39;
        Context r10 = r5.getApplicationContext();
        GeneratedAppGlideModule r11 = (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{r10.getApplicationContext()});     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L9 IllegalAccessException -> L11 InstantiationException -> L13 ClassNotFoundException -> L23
    L28:
        monitor-enter(b.class);
    L32:
        th = move-exception;
        throw th;
    L30:
        if (f1380i != null) goto L34;
        a(r5, r11);     // Catch: Throwable -> L32
    L34:
        monitor-exit(b.class);     // Catch: Throwable -> L32
    L11:
        e = move-exception;
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e);
    L13:
        e = move-exception;
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e);
    L9:
        e = move-exception;
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e);
    L7:
        e = move-exception;
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e);
    L24:
        if (Log.isLoggable("Glide", 5) == false) goto L26;
        Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
    L26:
        r11 = null;
    L39:
        return f1380i;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r5) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        char[] r5 = q0.i.f21459a;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L14;
        this.f1383b.f(0);
        this.f1382a.f();
        com.bumptech.glide.load.engine.bitmap_recycle.f r10 = this.e;
        monitor-enter(r10);
        r10.b(0);     // Catch: Throwable -> L10
        monitor-exit(r10);
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalArgumentException("You must call this method on the main thread");
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r10) {
        char[] r5 = q0.i.f21459a;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L40;
        Iterator r11 = this.f1385h.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        ((g) r11.next()).getClass();
        goto L6
    L8:
        b0.d r12 = this.f1383b;
        r12.getClass();
        if (r10 < 40) goto L11;
        r12.f(0);
    L17:
        this.f1382a.e(r10);
        com.bumptech.glide.load.engine.bitmap_recycle.f r13 = this.e;
        monitor-enter(r13);
        if (r10 < 40) goto L28;
        monitor-enter(r13);     // Catch: Throwable -> L33
        r13.b(0);     // Catch: Throwable -> L25
        monitor-exit(r13);     // Catch: Throwable -> L33
    L31:
        monitor-exit(r13);
        return;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L28:
        if (r10 >= 20) goto L30;
        if (r10 != 15) goto L31;
    L30:
        r13.b(r13.f1454a / 2);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    L11:
        if (r10 >= 20) goto L13;
        if (r10 != 15) goto L17;
    L13:
        monitor-enter(r12);
        long r14 = r12.f9665a;     // Catch: Throwable -> L36
        monitor-exit(r12);
        r12.f(r14 / 2);
    L36:
        th = move-exception;
        throw th;
    L40:
        throw new IllegalArgumentException("You must call this method on the main thread");
    }
}
