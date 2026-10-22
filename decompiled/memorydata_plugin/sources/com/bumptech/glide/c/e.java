package com.bumptech.glide.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f528a;

    public e(Context r3) {
        this.f528a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    private static c a(String r4) {
        Class r5 = ZeusTransformUtils.forName(r4, "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L15
        Object r1 = null;
        r1 = r5.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L7
    L10:
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L14;
        return (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.memorydata.plugin");
    L14:
        throw new RuntimeException("Expected instanceof GlideModule, but found: " + r1);
    L7:
        e = move-exception;
        a(r5, e);
    L15:
        e = move-exception;
        throw new IllegalArgumentException("Unable to find GlideModule implementation", e);
    }

    private static void a(Class<?> r3, Exception r4) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + r3, r4);
    }

    private ApplicationInfo b() {
        return this.f528a.getPackageManager().getApplicationInfo(this.f528a.getPackageName(), 128);
    }

    public List<c> a() {
        if (Log.isLoggable("ManifestParser", 3) == false) goto L5;
        Log.d("ManifestParser", "Loading Glide modules");
    L5:
        ArrayList r2 = new ArrayList();
        ApplicationInfo r7 = b();     // Catch: PackageManager.NameNotFoundException -> L29
        if (r7 == null) goto L26;
        if (r7.metaData == null) goto L26;
        if (Log.isLoggable("ManifestParser", 2) == false) goto L14;
        Log.v("ManifestParser", "Got app info metadata: " + r7.metaData);     // Catch: PackageManager.NameNotFoundException -> L29
    L14:
        Iterator<String> r3 = r7.metaData.keySet().iterator();     // Catch: PackageManager.NameNotFoundException -> L29
    L16:
        if (r3.hasNext() == false) goto L23;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");     // Catch: PackageManager.NameNotFoundException -> L29
        if ("GlideModule".equals(r7.metaData.get(r4)) == false) goto L16;
        r2.add(a(r4));     // Catch: PackageManager.NameNotFoundException -> L29
        if (Log.isLoggable("ManifestParser", 3) == false) goto L16;
        Log.d("ManifestParser", "Loaded Glide module: " + r4);     // Catch: PackageManager.NameNotFoundException -> L29
        goto L16
    L23:
        if (Log.isLoggable("ManifestParser", 3) == false) goto L33;
        Log.d("ManifestParser", "Finished loading Glide modules");     // Catch: PackageManager.NameNotFoundException -> L29
    L33:
        return r2;
    L26:
        if (Log.isLoggable("ManifestParser", 3) == false) goto L28;
        Log.d("ManifestParser", "Got null app info metadata");     // Catch: PackageManager.NameNotFoundException -> L29
    L28:
        return r2;
    L29:
        e = move-exception;
        if (Log.isLoggable("ManifestParser", 6) == false) goto L33;
        Log.e("ManifestParser", "Failed to parse glide modules", e);
        goto L33
    }
}
