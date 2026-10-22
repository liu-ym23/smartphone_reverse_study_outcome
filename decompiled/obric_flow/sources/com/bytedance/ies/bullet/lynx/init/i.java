package com.bytedance.ies.bullet.lynx.init;

import android.app.Application;
import com.lynx.tasm.LynxEnv;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f5682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f5683b;

    static {
        LynxEnv.inst().getLynxVersion();
    }

    public static Application a() {
        Application r5 = f5682a;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }
}
