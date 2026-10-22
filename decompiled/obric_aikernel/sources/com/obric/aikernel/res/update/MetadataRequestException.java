package com.obric.aikernel.res.update;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class MetadataRequestException extends IllegalStateException {
    private final MetadataRequestFailureKind kind;

    public MetadataRequestException(MetadataRequestFailureKind r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "message");
        super(r11, r12);
        this.kind = r10;
    }

    public /* synthetic */ MetadataRequestException(MetadataRequestFailureKind r10, String r11, Throwable r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        this(r10, r11, r12);
    }

    public final MetadataRequestFailureKind getKind() {
        return this.kind;
    }
}
