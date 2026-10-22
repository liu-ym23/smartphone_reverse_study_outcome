package com.larus.chat.job.impl.page.edit;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ChatJobEditFragment$showDatePicker$picker$1$1 extends FunctionReferenceImpl implements Function3<Integer, Integer, Integer, Unit> {
    public ChatJobEditFragment$showDatePicker$picker$1$1(Object r8) {
        super(3, r8, ChatJobEditViewModel.class, "selectDate", "selectDate(III)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke(((Number) r1).intValue(), ((Number) r2).intValue(), ((Number) r3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r2, int r3, int r4) {
        ((ChatJobEditViewModel) ((CallableReference) this).receiver).selectDate(r2, r3, r4);
    }
}
