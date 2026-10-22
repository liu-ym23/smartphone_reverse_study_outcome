package com.obric.assistant.component;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricIntercomComponent$listeningViewController$2$1 extends FunctionReferenceImpl implements Function1<Runnable, Unit> {
    public ObricIntercomComponent$listeningViewController$2$1(Object r8) {
        super(1, r8, ObricIntercomComponent.class, "runInUiTread", "runInUiTread(Ljava/lang/Runnable;)V", 0);
    }

    public final void invoke(Runnable r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        ObricIntercomComponent r0 = (ObricIntercomComponent) ((CallableReference) this).receiver;
        int r1 = ObricIntercomComponent.h1;
        r0.getClass();
        ObricIntercomComponent.q4(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Runnable) r1);
        return Unit.INSTANCE;
    }
}
