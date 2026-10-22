package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.JsonDecodingException;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f19449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.serialization.descriptors.h f19450b = null;

    static {
        f19449a = new v();
        f19450b = kotlinx.serialization.descriptors.k.c("kotlinx.serialization.json.JsonNull", kotlinx.serialization.descriptors.m.f19242b, new kotlinx.serialization.descriptors.g[0]);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        u8.a.k(r5);
        if (r5.B() == true) goto L7;
        return u.INSTANCE;
    L7:
        throw new JsonDecodingException("Expected 'null' literal");
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19450b;
    }
}
