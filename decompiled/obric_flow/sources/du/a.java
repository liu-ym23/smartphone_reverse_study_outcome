package du;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.c;
import kotlinx.serialization.internal.m1;
import kotlinx.serialization.internal.v0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final c a(c r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getDescriptor().b() == false) goto L6;
        return r5;
    L6:
        return new v0(r5);
    }

    public static final void b(StringCompanionObject r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        m1 r10 = m1.f19311a;
    }
}
