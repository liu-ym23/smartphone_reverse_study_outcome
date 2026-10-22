package com.obric.assistant.login;

import android.app.Activity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class x {
    public final String a;
    public final Activity b;
    public final Function1<ua7.h, Unit> c;
    public final Function2<ua7.h, String, Unit> d;
    public final Function0<Unit> e;
    public final Function0<Unit> f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L8;
        return false;
    L8:
        x r6 = (x) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Activity r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((((((r3 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ObricLoginRequest(loginSource=" + this.a + ", activity=" + this.b + ", onSuccess=" + this.c + ", onError=" + this.d + ", authLoginStart=" + this.e + ", authLoginFinish=" + this.f + ')';
    }

    public final Activity getActivity() {
        return this.b;
    }

    public x(String r2, Activity r3, Function1<? super ua7.h, Unit> r4, Function2<? super ua7.h, ? super String, Unit> r5, Function0<Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r4, "onSuccess");
        Intrinsics.checkNotNullParameter(r5, "onError");
        Intrinsics.checkNotNullParameter(r6, "authLoginStart");
        Intrinsics.checkNotNullParameter(r7, "authLoginFinish");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
