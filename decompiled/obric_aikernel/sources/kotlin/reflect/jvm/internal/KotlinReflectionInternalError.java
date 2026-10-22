package kotlin.reflect.jvm.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class KotlinReflectionInternalError extends Error {
    public KotlinReflectionInternalError(String r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        super(r10);
    }
}
