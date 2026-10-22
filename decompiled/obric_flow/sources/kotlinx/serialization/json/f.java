package kotlinx.serialization.json;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f19393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f19394b = null;

    static {
        f19393a = new f();
        f19394b = e.f19390b;
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        u8.a.k(r5);
        n r10 = n.f19442a;
        Intrinsics.checkNotNullParameter(r10, "elementSerializer");
        return new d((List) new kotlinx.serialization.internal.d(r10, 0).a(r5));
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19394b;
    }
}
