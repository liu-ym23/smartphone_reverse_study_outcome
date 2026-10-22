package com.obric.aikernel.middleware.interfaces;

import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
final class IResponseHandler$ok$1 extends Lambda implements Function1<Bundle, Unit> {
    public static final IResponseHandler$ok$1 INSTANCE = null;

    static {
        INSTANCE = new IResponseHandler$ok$1();
    }

    IResponseHandler$ok$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Bundle r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
    }
}
