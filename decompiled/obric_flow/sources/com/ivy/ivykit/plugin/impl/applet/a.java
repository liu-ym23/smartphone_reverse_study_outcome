package com.ivy.ivykit.plugin.impl.applet;

import android.app.Application;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends IXResourceLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f9506a = 0;

    static {
        Application r5 = k5.d.s;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("application");
        r5 = null;
    L6:
        r5.getFilesDir().getPath();
    }
}
