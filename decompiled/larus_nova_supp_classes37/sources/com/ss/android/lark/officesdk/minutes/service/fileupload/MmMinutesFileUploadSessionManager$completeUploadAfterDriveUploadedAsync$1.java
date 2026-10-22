package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploadedAsync$1", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 0, 3}, l = {2297, 1318, 1321, 2308}, m = "invokeSuspend", n = {"$this$launchFileUpload", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
final class MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploadedAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $taskId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploadedAsync$1(MmMinutesFileUploadSessionManager r1, String r2, Continuation<? super MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploadedAsync$1> r3) {
        this.this$0 = r1;
        this.$taskId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploadedAsync$1 r0 = new MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploadedAsync$1(this.this$0, this.$taskId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r3 = true;
        if (r0 == 0) goto L17;
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L10;
        String r1 = (String) this.L$2;
        MmMinutesFileUploadSessionManager r2 = (MmMinutesFileUploadSessionManager) this.L$1;
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r16);
    L62:
        MmMinutesFileUploadSessionManager.e r5 = r2.p.get(r1);     // Catch: Throwable -> L56
        if (r5 == null) goto L53;
        r5.s = false;     // Catch: Throwable -> L56
    L53:
        r2.w();     // Catch: Throwable -> L56
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L56
        r4.unlock(null);
        return Unit.INSTANCE;
    L56:
        th = move-exception;
        r4.unlock(null);
        throw th;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r16);
    L47:
        r2 = this.this$0;
        r4 = r2.g;
        r1 = this.$taskId;
        this.L$0 = r4;
        this.L$1 = r2;
        this.L$2 = r1;
        this.L$3 = null;
        this.label = 4;
        if (r4.a(null, this) != r11) goto L62;
        return r11;
    L12:
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L14
    L36:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L39:
        MmMinutesFileUploadSessionManager r8 = this.this$0;
        String r9 = this.$taskId;
        Throwable r10 = Result.exceptionOrNull-impl(r7);
        if (r10 == null) goto L47;
        lvb.a.b(r8.d, "completeUploadAfterDriveUploadedAsync: failed, taskId=" + r9 + ", err=" + r10);
        MmMinutesFileUploadErrorCode r12 = MmMinutesFileUploadErrorCode.FINISH_REQUEST_ERROR;
        String r13 = r10.getMessage();
        if (r13 != null) goto L44;
        r13 = "";
    L44:
        this.L$0 = r7;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 3;
        if (MmMinutesFileUploadSessionManager.P(r8, r9, r12, r13, null, null, null, this, 56) != r11) goto L47;
        return r11;
    L16:
        String r14 = (String) this.L$3;
        MmMinutesFileUploadSessionManager r15 = (MmMinutesFileUploadSessionManager) this.L$2;
        kotlinx.coroutines.sync.a r17 = (kotlinx.coroutines.sync.a) this.L$1;
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r16);
    L66:
        MmMinutesFileUploadSessionManager.e r19 = r15.p.get(r14);     // Catch: Throwable -> L59
        if (r19 != null) goto L25;
    L26:
        r3 = false;
    L28:
        r17.unlock(null);
        if (r3 == true) goto L32;
        lvb.a.e(this.this$0.d, "completeUploadAfterDriveUploadedAsync: skip, task already running. taskId=" + this.$taskId);
        return Unit.INSTANCE;
    L32:
        MmMinutesFileUploadSessionManager r20 = this.this$0;
        String r21 = this.$taskId;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L14
        this.L$0 = null;     // Catch: Throwable -> L14
        this.L$1 = null;     // Catch: Throwable -> L14
        this.L$2 = null;     // Catch: Throwable -> L14
        this.L$3 = null;     // Catch: Throwable -> L14
        this.label = 2;     // Catch: Throwable -> L14
        if (r20.m(r21, this) != r11) goto L36;
        return r11;
    L25:
        if (r19.s == true) goto L26;
        r19.s = true;     // Catch: Throwable -> L59
        r15.w();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        r17.unlock(null);
        throw th;
    L17:
        ResultKt.throwOnFailure(r16);
        CoroutineScope r23 = (CoroutineScope) this.L$0;
        r15 = this.this$0;
        r17 = r15.g;
        String r24 = this.$taskId;
        this.L$0 = r23;
        this.L$1 = r17;
        this.L$2 = r15;
        this.L$3 = r24;
        this.label = 1;
        if (r17.a(null, this) != r11) goto L20;
        return r11;
    L20:
        r14 = r24;
    L14:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    }
}
