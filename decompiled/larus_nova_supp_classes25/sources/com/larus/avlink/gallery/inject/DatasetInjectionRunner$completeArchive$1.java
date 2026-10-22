package com.larus.avlink.gallery.inject;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.inject.DatasetInjectionRunner", f = "DatasetInjectionRunner.kt", i = {0}, l = {428}, m = "completeArchive", n = {"uniqId"}, s = {"L$0"})
public final class DatasetInjectionRunner$completeArchive$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DatasetInjectionRunner this$0;

    public DatasetInjectionRunner$completeArchive$1(DatasetInjectionRunner r1, Continuation<? super DatasetInjectionRunner$completeArchive$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DatasetInjectionRunner r3 = this.this$0;
        DatasetInjectionRunner r0 = DatasetInjectionRunner.a;
        return r3.e(null, null, this);
    }
}
