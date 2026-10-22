package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.RecordMinutesSettingManager$getListener$1$onRecordingStart$1", f = "RecordMinutesSettingManager.kt", i = {}, l = {533}, m = "invokeSuspend", n = {}, s = {})
public final class RecordMinutesSettingManager$getListener$1$onRecordingStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $messageId;
    int label;

    /* JADX INFO: renamed from: com.larus.avlink.record.util.RecordMinutesSettingManager$getListener$1$onRecordingStart$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.record.util.RecordMinutesSettingManager$getListener$1$onRecordingStart$1$1", f = "RecordMinutesSettingManager.kt", i = {}, l = {535}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $meetingId;
        final /* synthetic */ String $messageId;
        int label;

        public AnonymousClass1(String r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$messageId = r1;
            this.$meetingId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$messageId, this.$meetingId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            n1.d("RecordMinutesSettingManager", "GRecord updateRecordStatus in onRecordingStart, update " + this.$messageId + " to RECORDING");
            IChatRepoService r11 = zh8.a.a;
            IChatRepoService r3 = zh8.a.a;
            String r4 = this.$messageId;
            Long r7 = StringsKt.toLongOrNull(this.$meetingId);
            this.label = 1;
            if (r3.q1(r4, 2, null, r7, this) != r0) goto L12;
            return r0;
        }
    }

    public RecordMinutesSettingManager$getListener$1$onRecordingStart$1(String r1, String r2, Continuation<? super RecordMinutesSettingManager$getListener$1$onRecordingStart$1> r3) {
        this.$messageId = r1;
        this.$meetingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RecordMinutesSettingManager$getListener$1$onRecordingStart$1(this.$messageId, this.$meetingId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r8 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$messageId, this.$meetingId, null);
        this.label = 1;
        if (BuildersKt.withContext(r8, r2, this) != r0) goto L12;
        return r0;
    }
}
