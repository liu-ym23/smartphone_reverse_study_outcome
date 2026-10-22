package kotlinx.serialization.internal;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q0 extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.serialization.c f19334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.serialization.c f19335b;

    public q0(kotlinx.serialization.c r5, kotlinx.serialization.c r10) {
        this.f19334a = r5;
        this.f19335b = r10;
    }

    @Override // kotlinx.serialization.internal.a
    public final void e(eu.a r5, int r10, Object r11, boolean r12) {
        Map r13 = (Map) r11;
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r13, "builder");
        Object r14 = r5.y(getDescriptor(), r10, this.f19334a, null);
        if (r12 == false) goto L9;
        int r15 = r5.l(getDescriptor());
        if (r15 != (r10 + 1)) goto L8;
    L10:
        boolean r16 = r13.containsKey(r14);
        kotlinx.serialization.c r17 = this.f19335b;
        if (r16 == true) goto L13;
    L15:
        Object r18 = r5.y(getDescriptor(), r15, r17, null);
    L16:
        r13.put(r14, r18);
        return;
    L13:
        if ((r17.getDescriptor().getKind() instanceof kotlinx.serialization.descriptors.f) == true) goto L15;
        r18 = r5.y(getDescriptor(), r15, r17, MapsKt.getValue(r13, r14));
        goto L16
    L8:
        throw new IllegalArgumentException(ai.j0.f(r10, r15, "Value must follow key in a map, index for key: ", ", returned index for value: ").toString());
    L9:
        r15 = r10 + 1;
        goto L10
    }
}
