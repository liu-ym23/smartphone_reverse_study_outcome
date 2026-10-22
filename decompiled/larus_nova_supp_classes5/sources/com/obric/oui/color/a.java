package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final a c = null;
    public final int a;
    public final int b;

    /* JADX INFO: renamed from: com.obric.oui.color.a$a, reason: collision with other inner class name */
    public static final class C0004a {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    static {
        c = new a(0, BlendMode.SRC_OVER);
    }

    public final String toString() {
        return "BlendConfig#" + hashCode() + "(color=" + String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(this.a)}, 1)) + ", blendMode=" + this.b + ')';
    }

    public a(int r2, BlendMode r3) {
        Intrinsics.checkNotNullParameter(r3, "mode");
        this(r2, BlendMode.mapToLegacyObricBlend(r3));
    }

    public a(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
