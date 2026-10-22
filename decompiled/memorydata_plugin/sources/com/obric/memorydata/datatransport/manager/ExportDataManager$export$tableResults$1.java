package com.obric.memorydata.datatransport.manager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ExportDataManager$export$tableResults$1 extends FunctionReferenceImpl implements Function0<Unit> {
    final /* synthetic */ String $ownerUserId;

    ExportDataManager$export$tableResults$1(String r7) {
        this.$ownerUserId = r7;
        super(0, Intrinsics.Kotlin.class, "ensureOwner", "export$ensureOwner(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        l.a(this.$ownerUserId);
    }
}
