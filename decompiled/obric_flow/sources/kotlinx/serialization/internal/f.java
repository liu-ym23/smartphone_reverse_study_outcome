package kotlinx.serialization.internal;

import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f19279c = null;

    static {
        Intrinsics.checkNotNullParameter(BooleanCompanionObject.INSTANCE, "<this>");
        f19279c = new f(g.f19282a);
    }

    @Override // kotlinx.serialization.internal.r, kotlinx.serialization.internal.a
    public final void e(eu.a r5, int r10, Object r11, boolean r12) {
        e r13 = (e) r11;
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r13, "builder");
        boolean r14 = r5.e(this.f19273b, r10);
        r13.getClass();
        b1.c(r13);
        boolean[] r15 = r13.f19274a;
        int r16 = r13.f19275b;
        r13.f19275b = r16 + 1;
        r15[r16] = r14;
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        boolean[] r10 = (boolean[]) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r10, "bufferWithData");
        e r11 = new e();
        r11.f19274a = r10;
        r11.f19275b = r10.length;
        r11.b(10);
        return r11;
    }

    @Override // kotlinx.serialization.internal.d1
    public final Object i() {
        return new boolean[0];
    }
}
