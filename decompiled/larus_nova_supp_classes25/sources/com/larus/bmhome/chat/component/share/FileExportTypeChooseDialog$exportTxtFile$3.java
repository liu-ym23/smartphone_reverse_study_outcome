package com.larus.bmhome.chat.component.share;

import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.FileExportTypeChooseDialog$exportTxtFile$3", f = "FileExportTypeChooseDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FileExportTypeChooseDialog$exportTxtFile$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cacheFilePath;
    int label;
    final /* synthetic */ FileExportTypeChooseDialog this$0;

    public FileExportTypeChooseDialog$exportTxtFile$3(FileExportTypeChooseDialog r1, String r2, Continuation<? super FileExportTypeChooseDialog$exportTxtFile$3> r3) {
        this.this$0 = r1;
        this.$cacheFilePath = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FileExportTypeChooseDialog$exportTxtFile$3(this.this$0, this.$cacheFilePath, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        i r5 = SmartRouter.buildRoute(this.this$0.getActivity(), "//flow/file_preview");
        String r0 = this.$cacheFilePath;
        r5.c.putExtra("arg_file_path", r0);
        String r1 = this.this$0.k;
        r5.c.putExtra("arg_bot_id", r1);
        r5.c.putExtra("arg_previous_page", "chat");
        r5.d();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
