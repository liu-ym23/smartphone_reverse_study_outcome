package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$resumeNetworkInterruptedUploads$1", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 0}, l = {2297, 1246}, m = "invokeSuspend", n = {"resumeActions", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
final class MmMinutesFileUploadSessionManager$resumeNetworkInterruptedUploads$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $trigger;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmMinutesFileUploadSessionManager.PendingResumeActionType.values().length];
            r0[MmMinutesFileUploadSessionManager.PendingResumeActionType.RESTART_PIPELINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MmMinutesFileUploadSessionManager.PendingResumeActionType.RESUME_DRIVE_UPLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MmMinutesFileUploadSessionManager.PendingResumeActionType.COMPLETE_AFTER_DRIVE_UPLOADED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public MmMinutesFileUploadSessionManager$resumeNetworkInterruptedUploads$1(MmMinutesFileUploadSessionManager r1, String r2, Continuation<? super MmMinutesFileUploadSessionManager$resumeNetworkInterruptedUploads$1> r3) {
        this.this$0 = r1;
        this.$trigger = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmMinutesFileUploadSessionManager$resumeNetworkInterruptedUploads$1(this.this$0, this.$trigger, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Iterator r2 = (Iterator) this.L$1;
        MmMinutesFileUploadSessionManager r5 = (MmMinutesFileUploadSessionManager) this.L$0;
        ResultKt.throwOnFailure(r14);
    L32:
        if (r2.hasNext() == false) goto L46;
        MmMinutesFileUploadSessionManager.c r15 = (MmMinutesFileUploadSessionManager.c) r2.next();
        int r6 = a.a[r15.getType().ordinal()];
        if (r6 != 1) goto L35;
        String r16 = r15.a;
        Set<String> r7 = MmMinutesFileUploadSessionManager.u;
        r5.o(r16);
        goto L32
    L35:
        if (r6 != 2) goto L37;
        String r17 = r15.a;
        Set<String> r8 = MmMinutesFileUploadSessionManager.u;
        r5.B(r17);
        goto L32
    L37:
        if (r6 != 3) goto L42;
        String r18 = r15.a;
        this.L$0 = r5;
        this.L$1 = r2;
        this.L$2 = null;
        this.label = 2;
        Set<String> r9 = MmMinutesFileUploadSessionManager.u;
        if (r5.m(r18, this) != r0) goto L32;
        return r0;
    L42:
        throw new NoWhenBranchMatchedException();
    L46:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        MmMinutesFileUploadSessionManager r3 = (MmMinutesFileUploadSessionManager) this.L$2;
        kotlinx.coroutines.sync.a r10 = (kotlinx.coroutines.sync.a) this.L$1;
        List r11 = (List) this.L$0;
        ResultKt.throwOnFailure(r14);
    L50:
        Iterator<T> r19 = r3.p.values().iterator();     // Catch: Throwable -> L47
    L15:
        if (r19.hasNext() == false) goto L27;
        MmMinutesFileUploadSessionManager.e r12 = (MmMinutesFileUploadSessionManager.e) r19.next();     // Catch: Throwable -> L47
        eub.b r13 = ((eub.g) r12.b.getValue()).g;     // Catch: Throwable -> L47
        if (r13 == null) goto L19;
        MmMinutesFileUploadErrorCode r20 = r13.a;     // Catch: Throwable -> L47
    L21:
        if (r20 != MmMinutesFileUploadErrorCode.NETWORK_ERROR) goto L15;
        MmMinutesFileUploadSessionManager.c r21 = r12.f();     // Catch: Throwable -> L47
        if (r21 == null) goto L15;
        eub.f r22 = r12.a;     // Catch: Throwable -> L47
        eub.f r23 = eub.f.a(r22, null, null, MapsKt.plus(r22.h, TuplesKt.to("retry_flag", "auto")), 383);     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r23, "<set-?>");     // Catch: Throwable -> L47
        r12.a = r23;     // Catch: Throwable -> L47
        r11.add(r21);     // Catch: Throwable -> L47
        goto L15
    L19:
        r20 = null;
        goto L21
    L27:
        if ((!r11.isEmpty()) == false) goto L29;
        r3.w();     // Catch: Throwable -> L47
    L29:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L47
        r10.unlock(null);
        lvb.a.e(this.this$0.d, "resumeNetworkInterruptedUploads: trigger=" + this.$trigger + ", actions=" + r11);
        r5 = this.this$0;
        r2 = r11.iterator();
    L47:
        th = move-exception;
        r10.unlock(null);
        throw th;
    L10:
        ResultKt.throwOnFailure(r14);
        r11 = new ArrayList();
        r3 = this.this$0;
        r10 = r3.g;
        this.L$0 = r11;
        this.L$1 = r10;
        this.L$2 = r3;
        this.label = 1;
        if (r10.a(null, this) != r0) goto L50;
        return r0;
    }
}
