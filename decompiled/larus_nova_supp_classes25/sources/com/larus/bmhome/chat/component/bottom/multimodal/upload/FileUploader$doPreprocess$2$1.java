package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import android.app.Application;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t19.s;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader$doPreprocess$2$1", f = "FileUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FileUploader$doPreprocess$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ q $this_run;
    int label;

    public FileUploader$doPreprocess$2$1(q r1, Continuation<? super FileUploader$doPreprocess$2$1> r2) {
        this.$this_run = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FileUploader$doPreprocess$2$1(this.$this_run, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r3);
        if (n1.d(this.$this_run.e) == false) goto L8;
        int r4 = 2131906513;
    L11:
        s r0 = s.a;
        Application r1 = AppHost.a.getApplication();
        r0.getClass();
        s.s(r1, r4);
        return Unit.INSTANCE;
    L8:
        if (n1.e(this.$this_run.e) == false) goto L10;
        r4 = 2131910959;
        goto L11
    L10:
        r4 = 2131905682;
        goto L11
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
