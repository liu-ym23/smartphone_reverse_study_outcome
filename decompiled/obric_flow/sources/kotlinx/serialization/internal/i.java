package kotlinx.serialization.internal;

import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f19294c = null;

    static {
        Intrinsics.checkNotNullParameter(ByteCompanionObject.INSTANCE, "<this>");
        f19294c = new i(j.f19297a);
    }

    @Override // kotlinx.serialization.internal.r, kotlinx.serialization.internal.a
    public final void e(eu.a r5, int r10, Object r11, boolean r12) {
        h r13 = (h) r11;
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r13, "builder");
        byte r14 = r5.d(this.f19273b, r10);
        r13.getClass();
        b1.c(r13);
        byte[] r15 = r13.f19288a;
        int r16 = r13.f19289b;
        r13.f19289b = r16 + 1;
        r15[r16] = r14;
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        byte[] r10 = (byte[]) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r10, "bufferWithData");
        h r11 = new h();
        r11.f19288a = r10;
        r11.f19289b = r10.length;
        r11.b(10);
        return r11;
    }

    @Override // kotlinx.serialization.internal.d1
    public final Object i() {
        return new byte[0];
    }
}
