package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadTaskState;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager", f = "MmMinutesFileUploadSessionManager.kt", i = {0}, l = {2297}, m = "getCurrentTasks", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class MmMinutesFileUploadSessionManager$getCurrentTasks$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$getCurrentTasks$1(MmMinutesFileUploadSessionManager r1, Continuation<? super MmMinutesFileUploadSessionManager$getCurrentTasks$1> r2) {
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
        MmMinutesFileUploadSessionManager$getCurrentTasks$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L12;
        if (r4 != 1) goto L11;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r2);
    L38:
    L35:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L17:
        if (r9.p.isEmpty() == false) goto L19;
        r9.z();     // Catch: Throwable -> L35
    L19:
        Collection<MmMinutesFileUploadSessionManager.e> r10 = r9.p.values();     // Catch: Throwable -> L35
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L35
        Iterator<T> r11 = r10.iterator();     // Catch: Throwable -> L35
    L21:
        if (r11.hasNext() == false) goto L28;
        Object r7 = r11.next();     // Catch: Throwable -> L35
        if (((eub.g) ((MmMinutesFileUploadSessionManager.e) r7).b.getValue()).a != MmMinutesFileUploadTaskState.UploadCompleted) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == true) goto L21;
        r6.add(r7);     // Catch: Throwable -> L35
        goto L21
    L25:
        r12 = false;
        goto L26
    L28:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));     // Catch: Throwable -> L35
        Iterator r14 = r6.iterator();     // Catch: Throwable -> L35
    L29:
        if (r14.hasNext() == false) goto L33;
        r13.add(((MmMinutesFileUploadSessionManager.e) r14.next()).a);     // Catch: Throwable -> L35
        goto L29
    L33:
        r5.unlock(null);
        Object r15 = r13;
    L34:
        return r15;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r2);
        kotlinx.coroutines.sync.a r16 = r9.g;
        r0.L$0 = r16;
        r0.label = 1;
        r15 = r3;
        if (r16.a(null, r0) == r3) goto L34;
        r5 = r16;
        goto L38
    L5:
        r0 = new MmMinutesFileUploadSessionManager$getCurrentTasks$1(r9, this);
        goto L6
    }
}
