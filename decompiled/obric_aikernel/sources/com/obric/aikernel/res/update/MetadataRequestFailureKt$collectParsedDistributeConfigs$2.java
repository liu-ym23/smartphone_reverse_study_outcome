package com.obric.aikernel.res.update;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
final class MetadataRequestFailureKt$collectParsedDistributeConfigs$2 extends Lambda implements Function1<Throwable, Unit> {
    public static final MetadataRequestFailureKt$collectParsedDistributeConfigs$2 INSTANCE = null;

    static {
        INSTANCE = new MetadataRequestFailureKt$collectParsedDistributeConfigs$2();
    }

    MetadataRequestFailureKt$collectParsedDistributeConfigs$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
    }
}
