package com.bumptech.glide.load.resource.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f831a = true;

    static {
    }

    public static Drawable a(Context r2, int r3, Resources.Theme r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return a(r5, r5, r3, r4);
    }

    public static Drawable a(Context r2, Context r3, int r4) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, null);
    }

    private static Drawable a(Context r2, Context r3, int r4, Resources.Theme r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
    L7:
        e = move-exception;
        if (r6.getPackageName().equals(r7.getPackageName()) == false) goto L11;
        throw e;
    L11:
        return ContextCompat.getDrawable(r7, r4);
    L13:
        f831a = false;
        goto L14
    L4:
        if (f831a == false) goto L14;
        return b(r7, r4, r5);
    L14:
        if (r5 != null) goto L18;
        r5 = r7.getTheme();
    L18:
        return c(r7, r4, r5);
    }

    private static Drawable b(Context r3, int r4, Resources.Theme r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L8;
        if (Build.VERSION.SDK_INT < 21) goto L8;
        ContextThemeWrapper r0 = new ContextThemeWrapper(r6, r5);
        r0.applyOverrideConfiguration(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getConfiguration());
        r6 = r0;
    L8:
        return AppCompatResources.getDrawable(r6, r4);
    }

    private static Drawable c(Context r2, int r3, Resources.Theme r4) {
        return ResourcesCompat.getDrawable(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin"), r3, r4);
    }
}
