package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager", f = "MmMinutesFileUploadSessionManager.kt", i = {0}, l = {430}, m = "submitTasks", n = {"result"}, s = {"L$0"})
final class MmMinutesFileUploadSessionManager$submitTasks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$submitTasks$1(MmMinutesFileUploadSessionManager r1, Continuation<? super MmMinutesFileUploadSessionManager$submitTasks$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        MmMinutesFileUploadSessionManager r9 = this.this$0;
        r9.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        MmMinutesFileUploadSessionManager$submitTasks$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 != 0) goto L9;
        ResultKt.throwOnFailure(r2);
        throw null;
    L9:
        if (r4 != 1) goto L20;
        ArrayList r5 = (ArrayList) r0.L$2;
        Iterator r6 = (Iterator) r0.L$1;
        ArrayList r7 = (ArrayList) r0.L$0;
        ResultKt.throwOnFailure(r2);
    L11:
        r5.add(r2);
        if (r6.hasNext() == false) goto L18;
        eub.f r10 = (eub.f) r6.next();
        r0.L$0 = r7;
        r0.L$1 = r6;
        r0.L$2 = r7;
        r0.label = 1;
        r2 = r9.H(r10, r0);
        if (r2 == r3) goto L25;
        r5 = r7;
        goto L11
    L25:
        return r3;
    L18:
        return r7;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r0 = new MmMinutesFileUploadSessionManager$submitTasks$1(r9, this);
        goto L6
    }
}
