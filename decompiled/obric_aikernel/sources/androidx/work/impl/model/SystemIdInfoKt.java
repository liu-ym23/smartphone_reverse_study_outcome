package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SystemIdInfoKt {
    public static final SystemIdInfo systemIdInfo(WorkGenerationalId r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "generationalId");
        return new SystemIdInfo(r10.getWorkSpecId(), r10.getGeneration(), r11);
    }
}
