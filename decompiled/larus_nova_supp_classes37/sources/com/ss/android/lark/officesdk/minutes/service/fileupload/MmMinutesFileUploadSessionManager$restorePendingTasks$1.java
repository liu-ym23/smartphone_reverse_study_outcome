package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$restorePendingTasks$1", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 1}, l = {2297, 285}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "taskIds"}, s = {"L$0", "L$0"})
public final class MmMinutesFileUploadSessionManager$restorePendingTasks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$restorePendingTasks$1(MmMinutesFileUploadSessionManager r1, Continuation<? super MmMinutesFileUploadSessionManager$restorePendingTasks$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmMinutesFileUploadSessionManager$restorePendingTasks$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        List r2 = (List) this.L$0;
        ResultKt.throwOnFailure(r9);
    L27:
        List r10 = r2;
    L29:
        lvb.a.e(this.this$0.d, "restorePendingTasks: restoredTaskIds=" + r10);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        MmMinutesFileUploadSessionManager r3 = (MmMinutesFileUploadSessionManager) this.L$1;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r9);
    L34:
    L31:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L14:
        if (r3.p.isEmpty() == false) goto L16;
        r3.z();     // Catch: Throwable -> L31
    L16:
        List r11 = MmMinutesFileUploadSessionManager.b(r3);     // Catch: Throwable -> L31
        List r4 = r11;     // Catch: Throwable -> L31
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));     // Catch: Throwable -> L31
        Iterator r7 = r4.iterator();     // Catch: Throwable -> L31
    L18:
        if (r7.hasNext() == false) goto L20;
        r6.add(((MmMinutesFileUploadSessionManager.f) r7.next()).a.a);     // Catch: Throwable -> L31
        goto L18
    L20:
        Pair r12 = TuplesKt.to(r11, r6);     // Catch: Throwable -> L31
        r5.unlock(null);
        List r8 = (List) r12.component1();
        r10 = (List) r12.component2();
        if ((true ^ r8.isEmpty()) == false) goto L28;
        MmMinutesFileUploadSessionManager r13 = this.this$0;
        this.L$0 = r10;
        this.L$1 = null;
        this.label = 2;
        if (MmMinutesFileUploadSessionManager.a(r13, r8, this) != r0) goto L26;
        return r0;
    L26:
        r2 = r10;
        goto L27
    L28:
        lvb.a.e(this.this$0.d, "restorePendingTasks: skip snapshot emit, already restored");
        goto L29
    L10:
        ResultKt.throwOnFailure(r9);
        r3 = this.this$0;
        r5 = r3.g;
        this.L$0 = r5;
        this.L$1 = r3;
        this.label = 1;
        if (r5.a(null, this) != r0) goto L34;
        return r0;
    }
}
