package ouc;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.ClassDiscriminatorMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class w {
    public static v a(Function1 r20) {
        a.C0027a r1 = a.d;
        Intrinsics.checkNotNullParameter(r1, "from");
        Intrinsics.checkNotNullParameter(r20, "builderAction");
        e r2 = new e(r1);
        r20.invoke(r2);
        boolean r3 = false;
        if (r2.p == false) goto L17;
        if (Intrinsics.areEqual(r2.h, EffectConfiguration.KEY_TYPE) == false) goto L15;
        if (r2.i != ClassDiscriminatorMode.POLYMORPHIC) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L17;
        throw new IllegalArgumentException("useArrayPolymorphism option can only be used if classDiscriminatorMode in a default POLYMORPHIC state.".toString());
    L9:
        r0 = false;
        goto L10
    L15:
        throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
    L17:
        if (r2.e == true) goto L24;
        if (Intrinsics.areEqual(r2.f, "    ") == true) goto L48;
        throw new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
    L48:
        return new v(new f(r2.a, r2.c, r2.d, r2.o, r2.e, r2.b, r2.f, r2.g, r2.p, r2.h, r2.n, r2.j, r2.k, r2.l, r2.m, r2.i), r2.q);
    L24:
        if (Intrinsics.areEqual(r2.f, "    ") == true) goto L48;
        String r4 = r2.f;
        int r5 = 0;
    L27:
        if (r5 >= r4.length()) goto L42;
        char r6 = r4.charAt(r5);
        if (r6 != ' ') goto L31;
    L38:
        boolean r7 = true;
    L39:
        if (r7 == false) goto L43;
        r5 = r5 + 1;
    L43:
        if (r3 == true) goto L48;
        throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + r2.f).toString());
    L31:
        if (r6 == '\t') goto L38;
        if (r6 == '\r') goto L38;
        if (r6 == '\n') goto L38;
        r7 = false;
        goto L39
    L42:
        r3 = true;
        goto L43
    }
}
