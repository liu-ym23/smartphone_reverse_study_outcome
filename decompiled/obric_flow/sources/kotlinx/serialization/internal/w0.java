package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Unit f19363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f19364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f19365c;

    public w0(Unit r5) {
        final String r10 = "kotlin.Unit";
        Intrinsics.checkNotNullParameter("kotlin.Unit", "serialName");
        Intrinsics.checkNotNullParameter(r5, "objectInstance");
        this.f19363a = r5;
        this.f19364b = CollectionsKt.emptyList();
        this.f19365c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ObjectSerializer$descriptor$2(r10, this));
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        kotlinx.serialization.descriptors.g r10 = getDescriptor();
        eu.a r11 = r5.i(r10);
        int r12 = r11.l(getDescriptor());
        if (r12 != (-1)) goto L7;
        Unit r13 = Unit.INSTANCE;
        r11.u(r10);
        return this.f19363a;
    L7:
        throw new SerializationException(ai.j0.g(r12, "Unexpected index "));
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return (kotlinx.serialization.descriptors.g) this.f19365c.getValue();
    }
}
