package kuc;

import juc.d;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;
import nuc.a1;
import nuc.f;
import nuc.o2;
import nuc.r1;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final f b(d r1) {
        Intrinsics.checkNotNullParameter(r1, "elementSerializer");
        return new f(r1);
    }

    public static final <T> d<T> d(d<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getDescriptor().a() == false) goto L6;
        return r1;
    L6:
        return new r1(r1);
    }

    public static final void e(IntCompanionObject r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        w0 r2 = w0.a;
    }

    public static final void f(StringCompanionObject r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        v2 r2 = v2.a;
    }

    @ExperimentalSerializationApi
    public static final o2 a(KClass r1, d r2) {
        Intrinsics.checkNotNullParameter(r1, "kClass");
        Intrinsics.checkNotNullParameter(r2, "elementSerializer");
        return new o2(r1, r2);
    }

    public static final a1 c(d r1, d r2) {
        Intrinsics.checkNotNullParameter(r1, "keySerializer");
        Intrinsics.checkNotNullParameter(r2, "valueSerializer");
        return new a1(r1, r2);
    }
}
