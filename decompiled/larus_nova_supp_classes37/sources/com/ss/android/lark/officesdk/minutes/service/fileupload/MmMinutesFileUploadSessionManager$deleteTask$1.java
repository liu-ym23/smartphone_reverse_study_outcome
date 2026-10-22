package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadDeleteReason;
import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadTaskState;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4}, l = {2297, 620, 633, 643, 646}, m = "deleteTask", n = {"taskId", "reason", "uploadTaskIds", "$this$withLock_u24default$iv", "reason", "removed", "reason", "removed", "reason", "removed", "removed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0"})
final class MmMinutesFileUploadSessionManager$deleteTask$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$deleteTask$1(MmMinutesFileUploadSessionManager r1, Continuation<? super MmMinutesFileUploadSessionManager$deleteTask$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r35) {
        this.result = r35;
        this.label |= Integer.MIN_VALUE;
        MmMinutesFileUploadSessionManager r0 = this.this$0;
        r0.getClass();
        int r3 = this.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r3 - Integer.MIN_VALUE;
        MmMinutesFileUploadSessionManager$deleteTask$1 r2 = this;
    L6:
        Object r4 = r2.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r2.label;
        boolean r11 = true;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 == 3) goto L16;
        if (r6 == 4) goto L16;
        if (r6 != 5) goto L15;
        MmMinutesFileUploadSessionManager.e r1 = (MmMinutesFileUploadSessionManager.e) r2.L$0;
        ResultKt.throwOnFailure(r4);
    L68:
        if (r1 != null) goto L72;
        r11 = false;
    L72:
        return Boxing.boxBoolean(r11);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        MmMinutesFileUploadSessionManager.e r7 = (MmMinutesFileUploadSessionManager.e) r2.L$1;
        MmMinutesFileUploadDeleteReason r8 = (MmMinutesFileUploadDeleteReason) r2.L$0;
        ResultKt.throwOnFailure(r4);
    L63:
        eub.f r9 = r7.a;
        String r10 = "upload_task_deleted_" + r8.name();
        r2.L$0 = r7;
        r2.L$1 = null;
        r2.label = 5;
        if (r0.l(r9, r10, r2) == r5) goto L88;
        r1 = r7;
        goto L68
    L88:
        return r5;
    L17:
        kotlinx.coroutines.sync.a r12 = (kotlinx.coroutines.sync.a) r2.L$3;
        List r13 = (List) r2.L$2;
        MmMinutesFileUploadDeleteReason r14 = (MmMinutesFileUploadDeleteReason) r2.L$1;
        String r15 = (String) r2.L$0;
        ResultKt.throwOnFailure(r4);
    L76:
        MmMinutesFileUploadSessionManager.e r16 = r0.p.remove(r15);     // Catch: Throwable -> L73
        if (r16 != null) goto L25;
        r16 = null;
    L33:
        r12.unlock(null);
        fub.a r17 = r0.a.C();
        r0.e.a(r15);
        Iterator r18 = r13.iterator();
    L35:
        if (r18.hasNext() == false) goto L39;
        String r19 = (String) r18.next();
        if (r17 == null) goto L35;
        Boxing.boxBoolean(r17.J0(r19));
        goto L35
    L39:
        if (r16 == null) goto L67;
        int r20 = m.a;
        m.a(r16.a);
        MmMinutesFileUploadBusinessTracker r21 = r0.b;
        eub.f r22 = r16.a;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r22, "param");
        Intrinsics.checkNotNullParameter(r14, "reason");
        if (r14 != MmMinutesFileUploadDeleteReason.DUPLICATE_IN_SERVER) goto L43;
        MmMinutesFileUploadBusinessTracker.p(r21, r22, "prepare", UserInfo.NONE_NAME_CARD_ID, new eub.b(MmMinutesFileUploadErrorCode.DUPLICATE_IN_SERVER, "duplicate in server", null, 12), null, 16);
    L43:
        int r23 = MmMinutesFileUploadSessionManager.g.b[r14.ordinal()];
        if (r23 == 1) goto L59;
        if (r23 != 2) goto L47;
        eub.g r24 = eub.g.a((eub.g) r16.b.getValue(), MmMinutesFileUploadTaskState.UploadCompleted, 0, 0, null, null, null, new eub.b(MmMinutesFileUploadErrorCode.DUPLICATE_IN_SERVER, "duplicate in server", null, 12), null, 62);
        MutableSharedFlow<eub.c> r25 = r0.o;
        eub.c.i r26 = new eub.c.i(r15, r16.a, r24);
        r2.L$0 = r14;
        r2.L$1 = r16;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.label = 3;
        if (r25.emit(r26, r2) == r5) goto L86;
    L62:
        r7 = r16;
        r8 = r14;
        goto L63
    L86:
        return r5;
    L47:
        if (r23 != 3) goto L49;
    L53:
        MutableSharedFlow<eub.c> r27 = r0.o;
        eub.c.b r28 = new eub.c.b(r15, r14);
        r2.L$0 = r14;
        r2.L$1 = r16;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.label = 4;
        if (r27.emit(r28, r2) != r5) goto L62;
        return r5;
    L49:
        if (r23 == 4) goto L53;
        throw new NoWhenBranchMatchedException();
    L59:
        MutableSharedFlow<eub.c> r29 = r0.o;
        eub.c.h r30 = new eub.c.h(r15, r16.a, r14);
        r2.L$0 = r14;
        r2.L$1 = r16;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.label = 2;
        if (r29.emit(r30, r2) != r5) goto L62;
        return r5;
    L67:
        r1 = r16;
        goto L68
    L25:
        r13.addAll(r16.e);     // Catch: Throwable -> L73
        Iterator r110 = ((ArrayList) r16.e).iterator();     // Catch: Throwable -> L73
    L27:
        if (r110.hasNext() == false) goto L29;
        r0.q.remove((String) r110.next());     // Catch: Throwable -> L73
        goto L27
    L29:
        CompletableDeferred<Unit> r31 = r16.r;     // Catch: Throwable -> L73
        if (r31 == null) goto L32;
        Job.DefaultImpls.cancel$default(r31, null, 1, null);     // Catch: Throwable -> L73
    L32:
        r0.w();     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        r12.unlock(null);
        throw th;
    L18:
        ResultKt.throwOnFailure(r4);
        lvb.a.e(r0.d, "deleteTask: null, reason: null");
        r13 = new ArrayList();
        r12 = r0.g;
        r2.L$0 = null;
        r2.L$1 = null;
        r2.L$2 = r13;
        r2.L$3 = r12;
        r2.label = 1;
        if (r12.a(null, r2) == r5) goto L84;
        r14 = null;
        r15 = null;
        goto L76
    L84:
        return r5;
    L5:
        r2 = new MmMinutesFileUploadSessionManager$deleteTask$1(r0, this);
        goto L6
    }
}
