package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.avlink.record.page.Action;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.RecordMinutesSettingManager$getListener$1$onRecordingStop$1", f = "RecordMinutesSettingManager.kt", i = {}, l = {578}, m = "invokeSuspend", n = {}, s = {})
public final class RecordMinutesSettingManager$getListener$1$onRecordingStop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $messageId;
    int label;

    /* JADX INFO: renamed from: com.larus.avlink.record.util.RecordMinutesSettingManager$getListener$1$onRecordingStop$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.record.util.RecordMinutesSettingManager$getListener$1$onRecordingStop$1$1", f = "RecordMinutesSettingManager.kt", i = {}, l = {580}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends String>>, Object> {
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

        public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<String>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L15:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            n1.d("RecordMinutesSettingManager", "GRecord updateRecordStatus in onRecordingStop, update " + this.$messageId + " to RECORD_FINISHED");
            IChatRepoService r11 = zh8.a.a;
            IChatRepoService r3 = zh8.a.a;
            String r4 = this.$messageId;
            String r12 = this.$meetingId;
            if (r12 == null) goto L11;
            Long r13 = StringsKt.toLongOrNull(r12);
        L12:
            this.label = 1;
            r10 = r3.q1(r4, 3, null, r13, this);
            if (r10 != r0) goto L15;
            return r0;
        L11:
            r13 = null;
            goto L12
        }
    }

    public RecordMinutesSettingManager$getListener$1$onRecordingStop$1(String r1, String r2, Continuation<? super RecordMinutesSettingManager$getListener$1$onRecordingStop$1> r3) {
        this.$messageId = r1;
        this.$meetingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RecordMinutesSettingManager$getListener$1$onRecordingStop$1(this.$messageId, this.$meetingId, r4);
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
    L11:
        Iterator<T> r8 = RecordMinutesSettingManager.g.iterator();
    L13:
        if (r8.hasNext() == false) goto L15;
        ((Function1) r8.next()).invoke(Action.END_PULL);
        goto L13
    L15:
        Iterator<T> r9 = RecordMinutesSettingManager.h.iterator();
    L17:
        if (r9.hasNext() == false) goto L20;
        ((Function1) r9.next()).invoke(Boxing.boxBoolean(false));
        goto L17
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r10 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$messageId, this.$meetingId, null);
        this.label = 1;
        if (BuildersKt.withContext(r10, r2, this) != r0) goto L11;
        return r0;
    }
}
