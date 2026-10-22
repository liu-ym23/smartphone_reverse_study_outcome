package com.obric.oui.color;

import ai.j0;
import com.obric.oui.graphic.BlendMode;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f12397c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12399b;

    static {
        f12397c = new a(0, BlendMode.SRC_OVER);
    }

    public a(int r5, int r10) {
        this.f12398a = r5;
        this.f12399b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        int r11 = r10.f12398a;
        if (this.f12398a == r11) goto L12;
        return false;
    L12:
        if (this.f12399b == r10.f12399b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f12398a) * 31;
        return Integer.hashCode(this.f12399b) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("BlendConfig#");
        r5.append(hashCode());
        r5.append("(color=");
        r5.append(String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(this.f12398a)}, 1)));
        r5.append(", blendMode=");
        return j0.n(r5, this.f12399b, ')');
    }

    public a(int r5, BlendMode r10) {
        Intrinsics.checkNotNullParameter(r10, "mode");
        this(r5, BlendMode.mapToLegacyObricBlend(r10));
    }
}
