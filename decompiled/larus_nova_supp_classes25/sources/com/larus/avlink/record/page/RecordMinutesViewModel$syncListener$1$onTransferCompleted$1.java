package com.larus.avlink.record.page;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Comparator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$syncListener$1$onTransferCompleted$1", f = "RecordMinutesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RecordMinutesViewModel$syncListener$1$onTransferCompleted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.dora.api.offline.record.e $recording;
    int label;
    final /* synthetic */ RecordMinutesViewModel this$0;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r5, T r6) {
            Long r7 = ((i0) r6).g;
            long r0 = Long.MIN_VALUE;
            if (r7 == null) goto L5;
            long r2 = r7.longValue();
        L6:
            Long r8 = Long.valueOf(r2);
            Long r9 = ((i0) r5).g;
            if (r9 == null) goto L10;
            r0 = r9.longValue();
        L10:
            return ComparisonsKt.compareValues(r8, Long.valueOf(r0));
        L5:
            r2 = Long.MIN_VALUE;
            goto L6
        }
    }

    public RecordMinutesViewModel$syncListener$1$onTransferCompleted$1(RecordMinutesViewModel r1, com.larus.dora.api.offline.record.e r2, Continuation<? super RecordMinutesViewModel$syncListener$1$onTransferCompleted$1> r3) {
        this.this$0 = r1;
        this.$recording = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RecordMinutesViewModel$syncListener$1$onTransferCompleted$1(this.this$0, this.$recording, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r5);
        RecordMinutesModel r6 = RecordMinutesViewModel.access$getModel(this.this$0);
        com.larus.dora.api.offline.record.e r0 = this.$recording;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "recording");
        if (r0.o.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        com.larus.avlink.n1.d("RecordMinutesModel", "skip completed recording with empty path, vuiId=" + r0.a);
        final i0 r7 = null;
    L15:
        if (r7 == null) goto L17;
        final RecordMinutesViewModel r2 = this.this$0;
        final com.larus.dora.api.offline.record.e r3 = this.$recording;
        RecordMinutesViewModel.access$withState(r2, new l1(r7, r3, r2));
        return Unit.INSTANCE;
    L17:
        return Unit.INSTANCE;
    L10:
        String r4 = "external_opus_glasses_" + r0.o.hashCode();
        monitor-enter(r6);
        Map<String, com.larus.dora.api.offline.record.e> r8 = MapsKt.toMutableMap(r6.e);     // Catch: Throwable -> L20
        r8.put(r4, r0);     // Catch: Throwable -> L20
        r6.e = r8;     // Catch: Throwable -> L20
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r6);
        r7 = r6.n(r0, r4);
    L20:
        th = move-exception;
        throw th;
    L7:
        r1 = false;
        goto L8
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
