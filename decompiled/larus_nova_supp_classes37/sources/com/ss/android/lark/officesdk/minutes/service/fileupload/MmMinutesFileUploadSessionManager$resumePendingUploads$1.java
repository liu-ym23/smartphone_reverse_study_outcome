package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$resumePendingUploads$1", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 0, 1}, l = {2297, 337, 347}, m = "invokeSuspend", n = {"resumeActions", "$this$withLock_u24default$iv", "resumeActions"}, s = {"L$0", "L$1", "L$0"})
public final class MmMinutesFileUploadSessionManager$resumePendingUploads$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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

    public MmMinutesFileUploadSessionManager$resumePendingUploads$1(MmMinutesFileUploadSessionManager r1, Continuation<? super MmMinutesFileUploadSessionManager$resumePendingUploads$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmMinutesFileUploadSessionManager$resumePendingUploads$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        Iterator r3 = (Iterator) this.L$1;
        MmMinutesFileUploadSessionManager r7 = (MmMinutesFileUploadSessionManager) this.L$0;
        ResultKt.throwOnFailure(r18);
    L66:
        if (r3.hasNext() == false) goto L79;
        MmMinutesFileUploadSessionManager.c r8 = (MmMinutesFileUploadSessionManager.c) r3.next();
        int r9 = a.a[r8.getType().ordinal()];
        if (r9 != 1) goto L69;
        String r10 = r8.a;
        Set<String> r11 = MmMinutesFileUploadSessionManager.u;
        r7.o(r10);
        goto L66
    L69:
        if (r9 != 2) goto L70;
        String r12 = r8.a;
        Set<String> r13 = MmMinutesFileUploadSessionManager.u;
        r7.B(r12);
        goto L66
    L70:
        if (r9 != 3) goto L75;
        String r14 = r8.a;
        this.L$0 = r7;
        this.L$1 = r3;
        this.L$2 = null;
        this.label = 3;
        Set<String> r15 = MmMinutesFileUploadSessionManager.u;
        if (r7.m(r14, this) != r0) goto L66;
        return r0;
    L75:
        throw new NoWhenBranchMatchedException();
    L79:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        List r4 = (List) this.L$0;
        ResultKt.throwOnFailure(r18);
    L58:
        List r16 = r4;
    L60:
        if (this.this$0.s == true) goto L62;
    L64:
        lvb.a.e(this.this$0.d, "resumePendingUploads: actions=" + r16);
        r7 = this.this$0;
        r3 = r16.iterator();
        goto L66
    L62:
        if (r16.isEmpty() == false) goto L64;
        lvb.a.e(this.this$0.d, "resumePendingUploads: no task needs resume");
        goto L64
    L11:
        MmMinutesFileUploadSessionManager r5 = (MmMinutesFileUploadSessionManager) this.L$2;
        kotlinx.coroutines.sync.a r17 = (kotlinx.coroutines.sync.a) this.L$1;
        r16 = (List) this.L$0;
        ResultKt.throwOnFailure(r18);
    L83:
    L80:
        th = move-exception;
        r17.unlock(null);
        throw th;
    L17:
        if (r5.s == false) goto L20;
        lvb.a.e(r5.d, "resumePendingUploads: skip, already resumed");     // Catch: Throwable -> L80
        List r6 = CollectionsKt.emptyList();     // Catch: Throwable -> L80
    L52:
        r17.unlock(null);
        if ((!r6.isEmpty()) == false) goto L60;
        MmMinutesFileUploadSessionManager r19 = this.this$0;
        this.L$0 = r16;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        if (MmMinutesFileUploadSessionManager.a(r19, r6, this) != r0) goto L57;
        return r0;
    L57:
        r4 = r16;
        goto L58
    L20:
        if (r5.p.isEmpty() == false) goto L22;
        r5.z();     // Catch: Throwable -> L80
    L22:
        Collection<MmMinutesFileUploadSessionManager.e> r20 = r5.p.values();     // Catch: Throwable -> L80
        if ((r20 instanceof Collection) == true) goto L25;
    L27:
        Iterator<T> r21 = r20.iterator();     // Catch: Throwable -> L80
    L29:
        if (r21.hasNext() == false) goto L33;
        if (((MmMinutesFileUploadSessionManager.e) r21.next()).c == false) goto L29;
        boolean r22 = false;
    L34:
        if (r22 == false) goto L36;
        lvb.a.e(r5.d, "resumePendingUploads: skip, no restored task");     // Catch: Throwable -> L80
        r6 = CollectionsKt.emptyList();     // Catch: Throwable -> L80
        goto L52
    L36:
        r5.s = true;     // Catch: Throwable -> L80
        Iterator<T> r23 = r5.p.values().iterator();     // Catch: Throwable -> L80
    L38:
        if (r23.hasNext() == false) goto L51;
        MmMinutesFileUploadSessionManager.e r110 = (MmMinutesFileUploadSessionManager.e) r23.next();     // Catch: Throwable -> L80
        int r111 = j.a;     // Catch: Throwable -> L80
        boolean r112 = r110.c;     // Catch: Throwable -> L80
        boolean r113 = r110.s;     // Catch: Throwable -> L80
        if (r112 == false) goto L43;
        if (r113 == true) goto L43;
        boolean r114 = true;
    L44:
        if (r114 == false) goto L45;
        MmMinutesFileUploadSessionManager.c r115 = r110.f();     // Catch: Throwable -> L80
        if (r115 == null) goto L38;
        eub.f r116 = r110.a;     // Catch: Throwable -> L80
        eub.f r117 = eub.f.a(r116, null, null, MapsKt.plus(r116.h, TuplesKt.to("retry_flag", "auto")), 383);     // Catch: Throwable -> L80
        Intrinsics.checkNotNullParameter(r117, "<set-?>");     // Catch: Throwable -> L80
        r110.a = r117;     // Catch: Throwable -> L80
        r16.add(r115);     // Catch: Throwable -> L80
        goto L38
    L45:
        if (r112 == false) goto L38;
        if (r113 == false) goto L38;
        lvb.a.e(r5.d, "resumePendingUploads: skip running restored taskId=" + r110.a.a);     // Catch: Throwable -> L80
    L43:
        r114 = false;
        goto L44
    L51:
        r5.w();     // Catch: Throwable -> L80
        r6 = MmMinutesFileUploadSessionManager.b(r5);     // Catch: Throwable -> L80
    L33:
        r22 = true;
        goto L34
    L25:
        if (r20.isEmpty() == false) goto L27;
    L12:
        ResultKt.throwOnFailure(r18);
        ArrayList r24 = new ArrayList();
        MmMinutesFileUploadSessionManager r25 = this.this$0;
        kotlinx.coroutines.sync.a r26 = r25.g;
        this.L$0 = r24;
        this.L$1 = r26;
        this.L$2 = r25;
        this.label = 1;
        if (r26.a(null, this) != r0) goto L15;
        return r0;
    L15:
        r16 = r24;
        r5 = r25;
        r17 = r26;
        goto L83
    }
}
