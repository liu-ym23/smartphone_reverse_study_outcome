package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$resumeExistingUploads$1", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 1, 1, 2, 2}, l = {2297, 2308, 2318}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "uploadTaskId", "$this$withLock_u24default$iv", "uploadTaskId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$4", "L$5", "L$4", "L$5"})
public final class MmMinutesFileUploadSessionManager$resumeExistingUploads$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $taskId;
    final /* synthetic */ fub.a $uploader;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$resumeExistingUploads$1(MmMinutesFileUploadSessionManager r1, String r2, fub.a r3, Continuation<? super MmMinutesFileUploadSessionManager$resumeExistingUploads$1> r4) {
        this.this$0 = r1;
        this.$taskId = r2;
        this.$uploader = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmMinutesFileUploadSessionManager$resumeExistingUploads$1(this.this$0, this.$taskId, this.$uploader, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x01bf -> B:67:0x01c1). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r5 = 2;
        boolean r6 = true;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$5;
        final String r8 = (String) this.L$4;
        Iterator r9 = (Iterator) this.L$3;
        fub.a r10 = (fub.a) this.L$2;
        String r11 = (String) this.L$1;
        MmMinutesFileUploadSessionManager r12 = (MmMinutesFileUploadSessionManager) this.L$0;
        ResultKt.throwOnFailure(r18);
        MmMinutesFileUploadSessionManager$resumeExistingUploads$1 r7 = this;
    L67:
        MmMinutesFileUploadSessionManager.e r13 = r12.p.get(r11);     // Catch: Throwable -> L51
        if (r13 == null) goto L49;
        Intrinsics.checkNotNullParameter(r8, "uploadTaskId");     // Catch: Throwable -> L51
        r13.l.remove(r8);     // Catch: Throwable -> L51
    L49:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L51
        r3.unlock(null);
        Iterator r4 = r9;
        String r15 = r11;
        MmMinutesFileUploadSessionManager r16 = r12;
        MmMinutesFileUploadSessionManager$resumeExistingUploads$1 r17 = r7;
    L55:
        r5 = 2;
        r6 = true;
    L23:
        if (r4.hasNext() == false) goto L60;
        String r19 = (String) r4.next();
        kotlinx.coroutines.sync.a r110 = r16.g;
        r17.L$0 = r16;
        r17.L$1 = r15;
        r17.L$2 = r10;
        r17.L$3 = r4;
        r17.L$4 = r19;
        r17.L$5 = r110;
        r17.label = r5;
        if (r110.a(null, r17) != r0) goto L27;
        return r0;
    L27:
        String r111 = r15;
        r9 = r4;
        kotlinx.coroutines.sync.a r20 = r110;
        MmMinutesFileUploadSessionManager r112 = r16;
        r8 = r19;
        MmMinutesFileUploadSessionManager$resumeExistingUploads$1 r113 = r17;
        r11 = r111;
    L65:
        MmMinutesFileUploadSessionManager.e r114 = r112.p.get(r11);     // Catch: Throwable -> L56
        if (r114 != null) goto L32;
    L36:
        boolean r21 = false;
    L37:
        r20.unlock(null);
        if (r21 == true) goto L40;
        lvb.a.e(r112.d, "resumeExistingUploads: skip duplicate resume uploadTaskId=" + r8 + ", taskId=" + r11);
    L54:
        r4 = r9;
        r15 = r11;
        r17 = r113;
        r16 = r112;
        goto L55
    L40:
        lvb.a.e(r112.d, "resumeExistingUploads: resume uploadTaskId=" + r8 + ", taskId=" + r11);
        boolean r22 = r10.W(r8, new MmMinutesFileUploadSessionManager$buildUploadCallback$1(new MmMinutesFileUploadSessionManager$resumeExistingUploads$1$1$resumed$1(r8), r112, r11));
        lvb.a.e(r112.d, "resumeExistingUploads: resume result uploadTaskId=" + r8 + ", taskId=" + r11 + ", resumed=" + r22);
        if (r22 == true) goto L54;
        r3 = r112.g;
        r113.L$0 = r112;
        r113.L$1 = r11;
        r113.L$2 = r10;
        r113.L$3 = r9;
        r113.L$4 = r8;
        r113.L$5 = r3;
        r113.label = 3;
        if (r3.a(null, r113) != r0) goto L45;
        return r0;
    L45:
        r7 = r113;
        r12 = r112;
        goto L67
    L69:
        r4 = r9;
        r15 = r11;
        r17 = r113;
        r16 = r112;
        goto L55
    L32:
        if (Intrinsics.areEqual(((LinkedHashMap) r114.f).get(r8), Boxing.boxBoolean(r6)) == true) goto L36;
        Intrinsics.checkNotNullParameter(r8, "uploadTaskId");     // Catch: Throwable -> L56
        if (r114.l.add(r8) == false) goto L36;
        r21 = true;
    L56:
        th = move-exception;
        r20.unlock(null);
        throw th;
    L60:
        return Unit.INSTANCE;
    L51:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r20 = (kotlinx.coroutines.sync.a) this.L$5;
        r8 = (String) this.L$4;
        r9 = (Iterator) this.L$3;
        r10 = (fub.a) this.L$2;
        r11 = (String) this.L$1;
        MmMinutesFileUploadSessionManager r115 = (MmMinutesFileUploadSessionManager) this.L$0;
        ResultKt.throwOnFailure(r18);
        r112 = r115;
        r113 = this;
        goto L65
    L11:
        String r23 = (String) this.L$2;
        MmMinutesFileUploadSessionManager r24 = (MmMinutesFileUploadSessionManager) this.L$1;
        kotlinx.coroutines.sync.a r25 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r18);
    L64:
        MmMinutesFileUploadSessionManager.e r26 = r24.p.get(r23);     // Catch: Throwable -> L61
        if (r26 != null) goto L20;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L61
        r25.unlock(null);
        return r1;
    L20:
        Pair r27 = TuplesKt.to(r26.a.b, CollectionsKt.toList(r26.e));     // Catch: Throwable -> L61
        r25.unlock(null);
        this.this$0.e.b(this.$taskId, (MmRecordingSource) r27.getFirst());
        List r28 = (List) r27.getSecond();
        lvb.a.e(this.this$0.d, "resumeExistingUploads: taskId=" + this.$taskId + ", uploadTaskIds=" + r28);
        r16 = this.this$0;
        r15 = this.$taskId;
        r10 = this.$uploader;
        r4 = r28.iterator();
        r17 = this;
    L61:
        th = move-exception;
        r25.unlock(null);
        throw th;
    L12:
        ResultKt.throwOnFailure(r18);
        r24 = this.this$0;
        r25 = r24.g;
        r23 = this.$taskId;
        this.L$0 = r25;
        this.L$1 = r24;
        this.L$2 = r23;
        this.label = 1;
        if (r25.a(null, this) != r0) goto L64;
        return r0;
    }
}
