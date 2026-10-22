package com.obric.matrix.platform.sdk.ones.safecushion.ui;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", WindowEvent.Params.RESULT, "Lkotlin/Pair;", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class CushionActivity$CushionControllerImpl$startRepair$1 extends Lambda implements Function1<Pair<? extends Boolean, ? extends String>, Unit> {
    final /* synthetic */ Function2<Boolean, String, Unit> $onResult;

    /* JADX WARN: Multi-variable type inference failed */
    public CushionActivity$CushionControllerImpl$startRepair$1(Function2<? super Boolean, ? super String, Unit> r1) {
        this.$onResult = r1;
        super(1);
    }

    public final void invoke(Pair<Boolean, String> r3) {
        Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.RESULT);
        this.$onResult.invoke(r3.getFirst(), r3.getSecond());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Pair) r1);
        return Unit.INSTANCE;
    }
}
