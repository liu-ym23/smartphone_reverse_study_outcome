package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "sharedParam", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/TryFileUploadParam;", "sharedProcessConfig", "Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader$processBeforeUploadFile$2", f = "FileUploader.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
public final class FileUploader$processBeforeUploadFile$2 extends SuspendLambda implements Function3<q, ns8.b, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public FileUploader$processBeforeUploadFile$2(Continuation<? super FileUploader$processBeforeUploadFile$2> r2) {
        super(3, r2);
    }

    public final Object invoke(q r2, ns8.b r3, Continuation<? super Unit> r4) {
        FileUploader$processBeforeUploadFile$2 r0 = new FileUploader$processBeforeUploadFile$2(r4);
        r0.L$0 = r2;
        r0.L$1 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((q) r1, (ns8.b) r2, (Continuation) r3);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        q r7 = (q) this.L$0;
        ns8.b r2 = (ns8.b) this.L$1;
        FileUploader r3 = FileUploader.a;
        this.L$0 = null;
        this.label = 1;
        if (r3.h(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
