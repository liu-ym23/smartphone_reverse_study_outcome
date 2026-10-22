package com.obric.oui.view;

import android.os.Build;
import android.view.DisplayCutout;
import androidx.core.util.ObjectsCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f14817a;

    private a(Object r1) {
        this.f14817a = r1;
    }

    static a a(Object r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return new a(r1);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return ((DisplayCutout) ZeusTransformUtils.preCheckCast(this.f14817a, DisplayCutout.class, "com.obric.memorydata.plugin")).getSafeInsetTop();
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return ((DisplayCutout) ZeusTransformUtils.preCheckCast(this.f14817a, DisplayCutout.class, "com.obric.memorydata.plugin")).getSafeInsetBottom();
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return ((DisplayCutout) ZeusTransformUtils.preCheckCast(this.f14817a, DisplayCutout.class, "com.obric.memorydata.plugin")).getSafeInsetLeft();
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return ((DisplayCutout) ZeusTransformUtils.preCheckCast(this.f14817a, DisplayCutout.class, "com.obric.memorydata.plugin")).getSafeInsetRight();
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() != r3.getClass()) goto L13;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
        return ObjectsCompat.equals(this.f14817a, r4.f14817a);
    L13:
        return false;
    }

    public int hashCode() {
        Object r0 = this.f14817a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f14817a + "}";
    }
}
