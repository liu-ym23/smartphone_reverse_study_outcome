package com.bytedance.ies.bullet.core;

import android.app.Application;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final h g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f5316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f5317c;
    public String d;
    public String e;
    public String f;

    static {
        g = g.f5314a;
    }

    public static void a(LynxView r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        r5.setTag(305419896, "AnnieX");
    }
}
