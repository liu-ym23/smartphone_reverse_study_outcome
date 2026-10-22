package com.larus.canvas.feature.component.logic.provider;

import androidx.fragment.app.Fragment;
import com.larus.canvas.feature.component.logic.j2;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public int a;
    public int b;
    public final long c;
    public final c0 d;
    public final Map<String, Integer> e;
    public final Map<String, String> f;
    public boolean g;
    public final Fragment h;
    public final Map<String, Object> i;

    public j() {
        this(null, null, 511);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        long r1 = this.c;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        c0 r3 = this.d;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (((((r2 + r5) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        if (this.g == false) goto L9;
        int r7 = 1231;
    L10:
        int r8 = (r6 + r7) * 31;
        Fragment r9 = this.h;
        if (r9 == null) goto L15;
        r4 = r9.hashCode();
    L15:
        return ((r8 + r4) * 31) + this.i.hashCode();
    L9:
        r7 = 1237;
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasGalleryContext(initializedIndex=" + this.a + ", gallerySize=" + this.b + ", animationDuration=" + this.c + ", sidebarCallback=" + this.d + ", creationStateRecord=" + this.e + ", creationIdRecord=" + this.f + ", useNewStyle=" + this.g + ", fragment=" + this.h + ", traceParams=" + this.i + ')';
    }

    public j(j2 r7, Fragment r8, int r9) {
        if ((r9 & 4) == 0) goto L5;
        long r0 = 200;
    L6:
        LinkedHashMap r3 = null;
        if ((r9 & 8) == 0) goto L10;
        r7 = null;
    L10:
        if ((r9 & 16) == 0) goto L12;
        LinkedHashMap r2 = new LinkedHashMap();
    L14:
        if ((r9 & 32) == 0) goto L16;
        LinkedHashMap r4 = new LinkedHashMap();
    L18:
        if ((r9 & 128) == 0) goto L21;
        r8 = null;
    L21:
        if ((r9 & 256) == 0) goto L23;
        r3 = new LinkedHashMap();
    L23:
        Intrinsics.checkNotNullParameter(r2, "creationStateRecord");
        Intrinsics.checkNotNullParameter(r4, "creationIdRecord");
        Intrinsics.checkNotNullParameter(r3, "traceParams");
        this.a = 0;
        this.b = 0;
        this.c = r0;
        this.d = r7;
        this.e = r2;
        this.f = r4;
        this.g = false;
        this.h = r8;
        this.i = r3;
        return;
    L16:
        r4 = null;
        goto L18
    L12:
        r2 = null;
        goto L14
    L5:
        r0 = 0;
        goto L6
    }
}
