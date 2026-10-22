package com.obric.assistant.interaction.impl.window;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class WindowHost$windowOperationExecutor$1 extends FunctionReferenceImpl implements Function2<String, List<? extends String>, Unit> {
    public WindowHost$windowOperationExecutor$1(Object r8) {
        super(2, r8, WindowHost.class, "reportPendingWindowOperations", "reportPendingWindowOperations(Ljava/lang/String;Ljava/util/List;)V", 0);
    }

    public final void invoke(String r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        WindowHost.access$reportPendingWindowOperations((WindowHost) ((CallableReference) this).receiver, r2, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (List) r2);
        return Unit.INSTANCE;
    }
}
