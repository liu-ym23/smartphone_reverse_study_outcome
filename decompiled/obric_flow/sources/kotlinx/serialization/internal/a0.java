package kotlinx.serialization.internal;

import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a0 f19251c = null;

    static {
        Intrinsics.checkNotNullParameter(FloatCompanionObject.INSTANCE, "<this>");
        f19251c = new a0(b0.f19261a);
    }

    @Override // kotlinx.serialization.internal.r, kotlinx.serialization.internal.a
    public final void e(eu.a r5, int r10, Object r11, boolean r12) {
        z r13 = (z) r11;
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r13, "builder");
        float r14 = r5.a(this.f19273b, r10);
        r13.getClass();
        b1.c(r13);
        float[] r15 = r13.f19376a;
        int r16 = r13.f19377b;
        r13.f19377b = r16 + 1;
        r15[r16] = r14;
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        float[] r10 = (float[]) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r10, "bufferWithData");
        z r11 = new z();
        r11.f19376a = r10;
        r11.f19377b = r10.length;
        r11.b(10);
        return r11;
    }

    @Override // kotlinx.serialization.internal.d1
    public final Object i() {
        return new float[0];
    }
}
