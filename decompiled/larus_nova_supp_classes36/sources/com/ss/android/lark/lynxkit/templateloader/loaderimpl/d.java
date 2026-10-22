package com.ss.android.lark.lynxkit.templateloader.loaderimpl;

import com.bytedance.ee.bear.bitable.anniex.env.BitableLynxEnv;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final Regex g = null;
    public final String a;
    public final String b;
    public final boolean c;
    public final String d;
    public final String e;
    public final com.ss.android.lark.lynxkit.templateloader.loaderimpl.a f;

    public static final class a {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        String r3 = this.d;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        String r7 = this.e;
        if (r7 == null) goto L15;
        r4 = r7.hashCode();
    L15:
        return ((r6 + r4) * 31) + this.f.hashCode();
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "BuiltInZstdTemplateLoaderConfig(accessKey=" + this.a + ", channel=" + this.b + ", enabled=" + this.c + ", bundlePath=" + this.d + ", bundleDir=" + this.e + ", resolver=" + this.f + ')';
    }

    static {
        g = new Regex("^[a-zA-Z][a-zA-Z0-9+.-]*:");
    }

    public d(String r3, BitableLynxEnv.b r4) {
        Intrinsics.checkNotNullParameter(r3, "accessKey");
        Intrinsics.checkNotNullParameter("bitable_lynx_channel", "channel");
        Intrinsics.checkNotNullParameter(r4, "resolver");
        this.a = r3;
        this.b = "bitable_lynx_channel";
        this.c = true;
        this.d = null;
        this.e = null;
        this.f = r4;
    }
}
