package com.bytedance.ai.applet.render.core.camera;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x {
    public final WeakReference<b> a;
    public String b;
    public int c;
    public boolean d;
    public boolean e;
    public WeakReference<Object> f;

    public x() {
        throw null;
    }

    public final boolean a() {
        if (this.a.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public x(WeakReference r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "client");
        Intrinsics.checkNotNullParameter(r11, "devicePosition");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = false;
        this.e = false;
        this.f = null;
    }
}
