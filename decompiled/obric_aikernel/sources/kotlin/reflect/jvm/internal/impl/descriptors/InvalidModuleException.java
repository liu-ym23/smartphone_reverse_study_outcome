package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class InvalidModuleException extends IllegalStateException {
    public InvalidModuleException(String r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        super(r10);
    }
}
