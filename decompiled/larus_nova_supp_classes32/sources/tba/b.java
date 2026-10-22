package tba;

import com.obric.assistant.component.z3;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final Lazy<LinkedHashMap<Integer, Integer>> h = null;
    public final int a;
    public final String b;
    public final String c;
    public final Map<String, Object> d;
    public final Function1<String, Unit> e;
    public final Function0<Unit> f;
    public final Function0<Boolean> g;

    public static final class a {
    }

    public b() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.d.hashCode()) * 31;
        Function1<String, Unit> r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Function0<Unit> r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Function0<Boolean> r14 = this.g;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ObricBanner(bannerType=" + this.a + ", bannerContent=" + this.b + ", bannerSubContent=" + this.c + ", ext=" + this.d + ", onBusinessButtonClick=" + this.e + ", onCloseButtonClick=" + this.f + ", canShow=" + this.g + ')';
    }

    static {
        h = LazyKt.lazy(new tba.a());
    }

    public b(int r3, String r4, String r5, Map r6, Function1 r7, Function0 r8, z3 r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r10 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r10 & 8) == 0) goto L12;
        r6 = MapsKt.emptyMap();
    L12:
        if ((r10 & 16) == 0) goto L15;
        r7 = null;
    L15:
        if ((r10 & 32) == 0) goto L18;
        r8 = null;
    L18:
        if ((r10 & 64) == 0) goto L20;
        r9 = null;
    L20:
        Intrinsics.checkNotNullParameter(r6, "ext");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
