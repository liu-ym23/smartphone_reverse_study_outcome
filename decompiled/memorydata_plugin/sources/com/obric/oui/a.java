package com.obric.oui;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.oui.c.a.b;
import com.obric.oui.common.style.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/OUISdk;", "Landroid/content/ComponentCallbacks2;", "()V", "TAG", "", "initialized", "", "getApplicationReflect", "Landroid/app/Application;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "onTrimMemory", "level", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13270a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f13271b;

    static {
        f13270a = new a();
    }

    private a() {
    }

    private final Application b() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.memorydata.plugin").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]), Application.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        b.a("OUISdk", "getApplicationReflect failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return (Application) ZeusTransformUtils.preCheckCast(null, Application.class, "com.obric.memorydata.plugin");
    }

    public final void a() {
    L13:
        e = move-exception;
        b.a("OUISdk", "init failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L4:
        if (f13271b == true) goto L11;
        long r2 = System.currentTimeMillis();     // Catch: Exception -> L13
        Application r4 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
        if (r4 == null) goto L9;
        r4.registerComponentCallbacks((ComponentCallbacks) ZeusTransformUtils.preCheckCast(this, ComponentCallbacks.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L13
    L9:
        f13271b = true;     // Catch: Exception -> L13
        String r6 = "init success, cost: " + (System.currentTimeMillis() - r2) + " ms";     // Catch: Exception -> L13
    L10:
        b.b("OUISdk", r6);     // Catch: Exception -> L13
        return;
    L11:
        r6 = "init already";
        goto L10
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        Intrinsics.checkNotNullParameter(r1, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        h.f13489a.a();
        return;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r1) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        h.f13489a.a();
        return;
    }
}
