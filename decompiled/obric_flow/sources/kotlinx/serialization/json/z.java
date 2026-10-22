package kotlinx.serialization.json;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.m1;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f19455a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f19456b = null;

    static {
        f19455a = new z();
        f19456b = y.f19452b;
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        u8.a.k(r5);
        du.a.b(StringCompanionObject.INSTANCE);
        m1 r10 = m1.f19311a;
        n r11 = n.f19442a;
        m1 r12 = m1.f19311a;
        n r13 = n.f19442a;
        Intrinsics.checkNotNullParameter(r12, "keySerializer");
        Intrinsics.checkNotNullParameter(r13, "valueSerializer");
        return new x((Map) new d0(r12, r13, 1).a(r5));
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19456b;
    }
}
