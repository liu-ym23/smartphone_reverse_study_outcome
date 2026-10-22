package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmOfflineRecordingItem;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmOfflineRecordingItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl$getOfflineRecordingList$2", f = "MmRecordingCapacityImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingCapacityImpl$getOfflineRecordingList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MmOfflineRecordingItem>>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((MmOfflineRecordingItem) r4).getStartTimeMs()), Long.valueOf(((MmOfflineRecordingItem) r3).getStartTimeMs()));
        }
    }

    public MmRecordingCapacityImpl$getOfflineRecordingList$2(MmRecordingCapacityImpl r1, Continuation<? super MmRecordingCapacityImpl$getOfflineRecordingList$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingCapacityImpl$getOfflineRecordingList$2 r0 = new MmRecordingCapacityImpl$getOfflineRecordingList$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<MmOfflineRecordingItem>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L42;
        ResultKt.throwOnFailure(r12);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        Map<String, Long> r14 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e) this.this$0.m.getValue()).m();
        lvb.a.e(this.this$0.d, "[getOfflineRecordingList] index size=" + r14.size());
        if (r14.isEmpty() == true) goto L7;
        String r0 = this.this$0.i().getCurrentUserId();
        ArrayList r1 = new ArrayList();
        MmRecordingCapacityImpl r2 = this.this$0;
        Iterator<Map.Entry<String, Long>> r15 = r14.entrySet().iterator();
    L10:
        if (r15.hasNext() == false) goto L40;
        Map.Entry<String, Long> r3 = r15.next();
        String r6 = r3.getKey();
        long r7 = r3.getValue().longValue();
        MmRecordFileHelper.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "userId");
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        Object r5 = Result.constructor-impl(Boolean.valueOf(MmRecordFileHelper.f(r0, r6).exists()));     // Catch: Throwable -> L14
    L16:
        Boolean r8 = Boolean.FALSE;
        if (Result.isFailure-impl(r5) == false) goto L20;
        r5 = r8;
    L20:
        if (((Boolean) r5).booleanValue() == true) goto L45;
        lvb.a.e(r2.d, "[getOfflineRecordingList] stale index removed, sessionKey=" + r6);
        ((com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e) r2.m.getValue()).B(r6);
        goto L10
    L45:
        MmRecordingSessionManager r9 = r2.h();     // Catch: Throwable -> L32
        r9.getClass();     // Catch: Throwable -> L32
        Intrinsics.checkNotNullParameter(r6, "sessionId");     // Catch: Throwable -> L32
        MmRecordingSession r10 = r9.m(r6);     // Catch: Throwable -> L32
        if (r10 == null) goto L29;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r11 = r10.g();     // Catch: Throwable -> L32
        if (r11 == null) goto L29;
        boolean r16 = true;
        if (r11.a() != true) goto L29;
    L30:
        Object r17 = Result.constructor-impl(Boxing.boxBoolean(r16));     // Catch: Throwable -> L32
    L34:
        Boolean r18 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r17) == false) goto L37;
        r17 = r18;
    L37:
        Boxing.boxBoolean(r1.add(new MmOfflineRecordingItem(r6, r7, ((Boolean) r17).booleanValue(), ((com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e) r2.m.getValue()).r(r6))));
    L29:
        r16 = false;
    L32:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L40:
        return CollectionsKt.sortedWith(r1, new a());
    L7:
        return CollectionsKt.emptyList();
    L42:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
