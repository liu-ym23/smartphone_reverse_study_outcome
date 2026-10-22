package com.larus.bmhome.bigimg;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.im.bean.message.AICreationTaskDurationInfo;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$performDownloadAction$1$checkBlock$1", f = "BigImagePhotoViewerDialog.kt", i = {}, l = {692}, m = "invokeSuspend", n = {}, s = {})
public final class BigImagePhotoViewerDialog$performDownloadAction$1$checkBlock$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ BigImagePhotoViewerDialog this$0;

    public BigImagePhotoViewerDialog$performDownloadAction$1$checkBlock$1(BigImagePhotoViewerDialog r1, Message r2, Continuation<? super BigImagePhotoViewerDialog$performDownloadAction$1$checkBlock$1> r3) {
        this.this$0 = r1;
        this.$message = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new BigImagePhotoViewerDialog$performDownloadAction$1$checkBlock$1(this.this$0, this.$message, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L27;
        r7.w();
        com.larus.home.impl.sdk.k1 r8 = com.larus.home.impl.sdk.k1.a;
        BigImagePhotoViewerDialog r2 = this.this$0;
        Map<String, Pair<String, Integer>> r3 = r2.Z;
        String r4 = null;
        if (r3 == null) goto L15;
        Pair<String, Integer> r5 = r3.get(String.valueOf(((PhotoViewerDialog) r2).f));
        if (r5 == null) goto L15;
        String r9 = (String) r5.getFirst();
    L16:
        Message r10 = this.$message;
        if (r10 == null) goto L23;
        List r11 = ap8.a.a(r10);
        if (r11 == null) goto L23;
        AICreationTaskDurationInfo r12 = (AICreationTaskDurationInfo) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L23;
        r4 = r12.taskId;
    L23:
        String r13 = this.this$0.t;
        this.label = 1;
        if (r8.h1(r9, r4, r13, this) != r0) goto L27;
        return r0;
    L15:
        r9 = null;
        goto L16
    }
}
