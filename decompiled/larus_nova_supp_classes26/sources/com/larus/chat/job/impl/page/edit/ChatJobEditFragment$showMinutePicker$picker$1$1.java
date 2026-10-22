package com.larus.chat.job.impl.page.edit;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ChatJobEditFragment$showMinutePicker$picker$1$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public ChatJobEditFragment$showMinutePicker$picker$1$1(Object r8) {
        super(1, r8, ChatJobEditViewModel.class, "selectHourlyMinute", "selectHourlyMinute(I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r2) {
        ((ChatJobEditViewModel) ((CallableReference) this).receiver).selectHourlyMinute(r2);
    }
}
