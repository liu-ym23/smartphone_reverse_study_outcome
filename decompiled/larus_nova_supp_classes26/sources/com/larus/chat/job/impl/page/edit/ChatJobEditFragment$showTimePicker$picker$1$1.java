package com.larus.chat.job.impl.page.edit;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ChatJobEditFragment$showTimePicker$picker$1$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, Unit> {
    public ChatJobEditFragment$showTimePicker$picker$1$1(Object r8) {
        super(2, r8, ChatJobEditViewModel.class, "selectTime", "selectTime(II)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).intValue(), ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r2, int r3) {
        ((ChatJobEditViewModel) ((CallableReference) this).receiver).selectTime(r2, r3);
    }
}
