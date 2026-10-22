package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$resumeHistoryRecording$1", f = "MmRecordingSessionManager.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3}, l = {1187, 1188, 1189, 1205}, m = "invokeSuspend", n = {"userId", "localStorage", "userId", "localStorage", "userId", "localStorage", "localMeetingIds", "userId", "localStorage"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"})
public final class MmRecordingSessionManager$resumeHistoryRecording$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public MmRecordingSessionManager$resumeHistoryRecording$1(MmRecordingSessionManager r1, Continuation<? super MmRecordingSessionManager$resumeHistoryRecording$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingSessionManager$resumeHistoryRecording$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L22;
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L16;
        if (r2 == 3) goto L13;
        if (r2 != 4) goto L12;
        Iterator r0 = (Iterator) this.L$3;
        MmRecordingSessionManager r3 = (MmRecordingSessionManager) this.L$2;
        e r4 = (e) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L55
    L49:
        if (r0.hasNext() == false) goto L58;
        String r16 = (String) r0.next();     // Catch: Throwable -> L55
        this.L$0 = r5;     // Catch: Throwable -> L55
        this.L$1 = r4;     // Catch: Throwable -> L55
        this.L$2 = r3;     // Catch: Throwable -> L55
        this.L$3 = r0;     // Catch: Throwable -> L55
        this.label = 4;     // Catch: Throwable -> L55
        if (MmRecordingSessionManager.a(r3, r5, r16, r4, this) != r1) goto L49;
        return r1;
    L58:
        this.this$0.o.set(false);
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Set r6 = (Set) this.L$2;
        e r7 = (e) this.L$1;
        String r8 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L55
        r5 = r8;
        r4 = r7;
    L37:
        Set r17 = (Set) r15;     // Catch: Throwable -> L55
        Set<String> r9 = r4.n();     // Catch: Throwable -> L55
        Set r10 = SetsKt.plus(SetsKt.minus(r6, r17), r9);     // Catch: Throwable -> L55
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));     // Catch: Throwable -> L55
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L55
    L39:
        if (r12.hasNext() == false) goto L48;
        String r13 = (String) r12.next();     // Catch: Throwable -> L55
        String r14 = r4.i(r13);     // Catch: Throwable -> L55
        if ((!StringsKt.isBlank(r14)) == true) goto L44;
        r14 = null;
    L44:
        if (r14 == null) goto L47;
        r13 = r14;
    L47:
        r11.add(r13);     // Catch: Throwable -> L55
        goto L39
    L48:
        Set r18 = CollectionsKt.toSet(r11);     // Catch: Throwable -> L55
        lvb.a.e(this.this$0.b, "[resumeHistoryRecording] localMeetingIds=" + r6 + ", d1204OfflineLocalIds=" + r17 + ", pendingUploadCompletedMeetingIds=" + r9 + ", meetingIds=" + r18);     // Catch: Throwable -> L55
        r3 = this.this$0;     // Catch: Throwable -> L55
        r0 = r18.iterator();     // Catch: Throwable -> L55
        goto L49
    L16:
        e r19 = (e) this.L$1;
        String r20 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L55
    L30:
        List r110 = (List) r15;     // Catch: Throwable -> L55
        if (r110 != null) goto L33;
        r110 = CollectionsKt.emptyList();     // Catch: Throwable -> L55
    L33:
        Set r111 = CollectionsKt.toSet(r110);     // Catch: Throwable -> L55
        MmRecordingSessionManager r21 = this.this$0;     // Catch: Throwable -> L55
        this.L$0 = r20;     // Catch: Throwable -> L55
        this.L$1 = r19;     // Catch: Throwable -> L55
        this.L$2 = r111;     // Catch: Throwable -> L55
        this.label = 3;     // Catch: Throwable -> L55
        Object r22 = MmRecordingSessionManager.d(r21, r20, r111, r19, this);     // Catch: Throwable -> L55
        if (r22 != r1) goto L36;
        return r1;
    L36:
        r5 = r20;
        e r112 = r19;
        r6 = r111;
        r15 = r22;
        r4 = r112;
        goto L37
    L19:
        r19 = (e) this.L$1;
        r20 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L55
    L27:
        MmRecordFileHelper r113 = MmRecordFileHelper.a;     // Catch: Throwable -> L55
        this.L$0 = r20;     // Catch: Throwable -> L55
        this.L$1 = r19;     // Catch: Throwable -> L55
        this.label = 2;     // Catch: Throwable -> L55
        r113.getClass();     // Catch: Throwable -> L55
        r15 = MmRecordFileHelper.d(r20, this);     // Catch: Throwable -> L55
        if (r15 != r1) goto L30;
        return r1;
    L22:
        ResultKt.throwOnFailure(r15);
        String r114 = this.this$0.a.getCurrentUserId();     // Catch: Throwable -> L55
        lvb.a.e(this.this$0.b, "[resumeHistoryRecording] start recovery, userId=" + r114);     // Catch: Throwable -> L55
        r19 = new e(this.this$0.a);     // Catch: Throwable -> L55
        MmRecordingSessionManager r23 = this.this$0;     // Catch: Throwable -> L55
        this.L$0 = r114;     // Catch: Throwable -> L55
        this.L$1 = r19;     // Catch: Throwable -> L55
        this.label = 1;     // Catch: Throwable -> L55
        if (MmRecordingSessionManager.e(r23, r114, r19, this) != r1) goto L26;
        return r1;
    L26:
        r20 = r114;
    L55:
        th = move-exception;
        lvb.a.b(this.this$0.b, "[resumeHistoryRecording] failed, error=" + th);     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        this.this$0.o.set(false);
        throw th;
    }
}
