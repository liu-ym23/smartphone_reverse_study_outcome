package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class WorkSpecKt {
    public static final WorkGenerationalId generationalId(WorkSpec r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new WorkGenerationalId(r10.id, r10.getGeneration());
    }
}
