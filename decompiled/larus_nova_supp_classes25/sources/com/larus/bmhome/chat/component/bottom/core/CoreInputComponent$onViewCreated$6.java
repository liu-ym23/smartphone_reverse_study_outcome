package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class CoreInputComponent$onViewCreated$6 extends FunctionReferenceImpl implements Function0<Integer> {
    public CoreInputComponent$onViewCreated$6(Object r8) {
        super(0, r8, CoreInputComponent.class, "actionShownInterceptor", "actionShownInterceptor()Ljava/lang/Integer;", 0);
    }

    public final Integer invoke() {
        CoreInputComponent r0 = (CoreInputComponent) ((CallableReference) this).receiver;
        int r1 = CoreInputComponent.d3;
        com.larus.bmhome.instruction.g r2 = r0.vc();
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L12;
        return null;
    L12:
        return 1;
    L5:
        if (r2.HM() != true) goto L7;
        r3 = true;
        goto L8
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m57invoke() {
        return invoke();
    }
}
