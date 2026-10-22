package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadTaskState;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 0, 0, 0, 0, 0, 1, 1}, l = {2297, 583}, m = "retryTask", n = {"taskId", "uploadTaskIdsToCancel", "action", "retryStatus", "$this$withLock_u24default$iv", "restartFromInit", "taskId", "action"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1"})
final class MmMinutesFileUploadSessionManager$retryTask$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$retryTask$1(MmMinutesFileUploadSessionManager r1, Continuation<? super MmMinutesFileUploadSessionManager$retryTask$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r17) {
        this.result = r17;
        this.label |= Integer.MIN_VALUE;
        MmMinutesFileUploadSessionManager r0 = this.this$0;
        r0.getClass();
        int r3 = this.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r3 - Integer.MIN_VALUE;
        MmMinutesFileUploadSessionManager$retryTask$1 r2 = this;
    L6:
        Object r4 = r2.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r2.label;
        if (r6 == 0) goto L14;
        if (r6 == 1) goto L13;
        if (r6 != 2) goto L12;
        Ref.ObjectRef r7 = (Ref.ObjectRef) r2.L$1;
        String r8 = (String) r2.L$0;
        ResultKt.throwOnFailure(r4);
    L61:
        Object r9 = r7.element;
        if (r9 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("action");
        MmMinutesFileUploadSessionManager.c r10 = null;
    L65:
        int r11 = MmMinutesFileUploadSessionManager.g.a[r10.getType().ordinal()];
        if (r11 != 1) goto L68;
        r0.o(r8);
    L77:
        return Boxing.boxBoolean(true);
    L68:
        if (r11 != 2) goto L70;
        r0.B(r8);
        goto L77
    L70:
        if (r11 != 3) goto L73;
        r0.r("completeUploadAfterDriveUploadedAsync", new MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploadedAsync$1(r0, r8, null));
        goto L77
    L73:
        throw new NoWhenBranchMatchedException();
    L64:
        r10 = (MmMinutesFileUploadSessionManager.c) r9;
        goto L65
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        boolean r12 = r2.Z$0;
        kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) r2.L$4;
        Ref.ObjectRef r14 = (Ref.ObjectRef) r2.L$3;
        Ref.ObjectRef r15 = (Ref.ObjectRef) r2.L$2;
        List r16 = (List) r2.L$1;
        String r18 = (String) r2.L$0;
        ResultKt.throwOnFailure(r4);
        Ref.ObjectRef r19 = r15;
    L81:
        MmMinutesFileUploadSessionManager.e r110 = r0.p.get(r18);     // Catch: Throwable -> L78
        if (r110 != null) goto L22;
        Boolean r1 = Boxing.boxBoolean(false);     // Catch: Throwable -> L78
    L21:
        Boolean r20 = r1;
        r13.unlock(null);
        return r20;
    L22:
        MmMinutesFileUploadTaskState r21 = ((eub.g) r110.b.getValue()).a;     // Catch: Throwable -> L78
        if (r21 != MmMinutesFileUploadTaskState.Interrupted) goto L25;
    L28:
        boolean r22 = true;
    L29:
        if (r22 == true) goto L33;
        r1 = Boxing.boxBoolean(false);     // Catch: Throwable -> L78
        goto L21
    L33:
        eub.f r23 = r110.a;     // Catch: Throwable -> L78
        eub.f r24 = eub.f.a(r23, null, null, MapsKt.plus(r23.h, TuplesKt.to("retry_flag", "manual")), 383);     // Catch: Throwable -> L78
        Intrinsics.checkNotNullParameter(r24, "<set-?>");     // Catch: Throwable -> L78
        r110.a = r24;     // Catch: Throwable -> L78
        if (r12 == false) goto L36;
        boolean r111 = true;
    L37:
        r19.element = r110.d(r111);     // Catch: Throwable -> L78
        r14.element = r110.b.getValue();     // Catch: Throwable -> L78
        Object r25 = r19.element;     // Catch: Throwable -> L78
        if (r25 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("action");     // Catch: Throwable -> L78
        MmMinutesFileUploadSessionManager.c r26 = null;
    L42:
        if (r26.getType() != MmMinutesFileUploadSessionManager.PendingResumeActionType.RESTART_PIPELINE) goto L44;
        r16.addAll(r110.p);     // Catch: Throwable -> L78
    L44:
        r0.w();     // Catch: Throwable -> L78
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L78
        r13.unlock(null);
        MmMinutesFileUploadBusinessTracker r28 = r0.b;
        r28.getClass();
        Intrinsics.checkNotNullParameter(r18, "taskId");
        r28.a.remove(r18);
        r28.b.remove(r18);
        if ((!r16.isEmpty()) == false) goto L53;
        fub.a r29 = r0.a.C();
        Iterator r30 = r16.iterator();
    L49:
        if (r30.hasNext() == false) goto L53;
        String r31 = (String) r30.next();
        if (r29 == null) goto L49;
        Boxing.boxBoolean(r29.J0(r31));
    L53:
        MutableSharedFlow<eub.c> r32 = r0.o;
        Object r33 = r14.element;
        if (r33 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("retryStatus");
        eub.g r34 = null;
    L57:
        eub.c.f r35 = new eub.c.f(r18, r34);
        r2.L$0 = r18;
        r2.L$1 = r19;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.label = 2;
        if (r32.emit(r35, r2) == r5) goto L89;
        r7 = r19;
        r8 = r18;
        goto L61
    L89:
        return r5;
    L56:
        r34 = (eub.g) r33;
        goto L57
    L40:
        r26 = (MmMinutesFileUploadSessionManager.c) r25;     // Catch: Throwable -> L78
        goto L42
    L36:
        r111 = false;
        goto L37
    L25:
        if (r21 == MmMinutesFileUploadTaskState.Idle) goto L28;
        r22 = false;
    L78:
        th = move-exception;
        r13.unlock(null);
        throw th;
    L14:
        ResultKt.throwOnFailure(r4);
        r16 = new ArrayList();
        r12 = r0.E();
        r19 = new Ref.ObjectRef();
        r14 = new Ref.ObjectRef();
        r13 = r0.g;
        r2.L$0 = null;
        r2.L$1 = r16;
        r2.L$2 = r19;
        r2.L$3 = r14;
        r2.L$4 = r13;
        r2.Z$0 = r12;
        r2.label = 1;
        if (r13.a(null, r2) == r5) goto L88;
        r18 = null;
        goto L81
    L88:
        return r5;
    L5:
        r2 = new MmMinutesFileUploadSessionManager$retryTask$1(r0, this);
        goto L6
    }
}
