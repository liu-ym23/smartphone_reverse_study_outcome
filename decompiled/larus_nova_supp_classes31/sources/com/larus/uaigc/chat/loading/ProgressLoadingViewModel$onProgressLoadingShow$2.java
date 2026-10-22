package com.larus.uaigc.chat.loading;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.creative.loading.ProgressLoadingUIState;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.loading.ProgressLoadingViewModel$onProgressLoadingShow$2", f = "ProgressLoadingViewModel.kt", i = {0}, l = {131, 149}, m = "invokeSuspend", n = {"newReplyId"}, s = {"L$0"})
public final class ProgressLoadingViewModel$onProgressLoadingShow$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, ProgressLoadingUIState> $cachedProgress;
    final /* synthetic */ String $loadingTaskId;
    final /* synthetic */ Message $newMsg;
    Object L$0;
    int label;
    final /* synthetic */ ProgressLoadingViewModel this$0;

    public ProgressLoadingViewModel$onProgressLoadingShow$2(Message r1, ProgressLoadingViewModel r2, String r3, Map<String, ProgressLoadingUIState> r4, Continuation<? super ProgressLoadingViewModel$onProgressLoadingShow$2> r5) {
        this.$newMsg = r1;
        this.this$0 = r2;
        this.$loadingTaskId = r3;
        this.$cachedProgress = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ProgressLoadingViewModel$onProgressLoadingShow$2(this.$newMsg, this.this$0, this.$loadingTaskId, this.$cachedProgress, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r3 = 1;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r18);
    L72:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r4 = r18;
    L10:
        String r5 = r2;
        Message r6 = (Message) r4;
        Ref.BooleanRef r7 = new Ref.BooleanRef();
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        Set r9 = ProgressLoadingViewModel.access$getCurrentLoadingMessageSet$p(this.this$0);
        ProgressLoadingViewModel r10 = this.this$0;
        monitor-enter(r9);
        ArrayList r11 = new ArrayList(ProgressLoadingViewModel.access$getCurrentLoadingMessageSet$p(r10));     // Catch: Throwable -> L73
        r8.element = r11;     // Catch: Throwable -> L73
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L73
        monitor-exit(r9);
        Message r13 = this.$newMsg;
        Iterator r14 = r11.iterator();
    L24:
        if (r14.hasNext() == false) goto L28;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((Message) r15).getLocalMessageId(), r13.getLocalMessageId()) == false) goto L24;
    L29:
        Message r16 = (Message) r15;
        int r17 = 0;
        if (r16 == null) goto L50;
        Message r19 = this.$newMsg;
        String r110 = r16.getReplyId();
        if (r6 == null) goto L34;
        String r111 = r6.getLocalMessageId();
    L36:
        if (Intrinsics.areEqual(r110, r111) == true) goto L44;
        String r112 = r16.getReplyId();
        if (r6 == null) goto L40;
        String r20 = r6.getMessageId();
    L42:
        if (Intrinsics.areEqual(r112, r20) == true) goto L44;
    L48:
        boolean r21 = false;
    L49:
        r7.element = r21;
        goto L50
    L40:
        r20 = null;
    L44:
        if (com.larus.im.bean.message.a.r0(r19) == false) goto L48;
        if (b0.h(r16) != true) goto L48;
        r21 = true;
        goto L49
    L34:
        r111 = null;
    L50:
        FLogger r22 = FLogger.a;
        r22.i("ProgressLoadingViewModel", "onProgressLoadingShow needMaintainProgress " + r7.element + ' ');
        ProgressLoadingViewModel.access$getCurrentLoadingMessageSet$p(this.this$0).add(this.$newMsg);
        if (r7.element == false) goto L54;
        Integer r23 = (Integer) this.this$0.getProgressMap().get(this.$loadingTaskId);
    L53:
        Integer r24 = r23;
        boolean r25 = Intrinsics.areEqual(ap8.a.b(this.$newMsg), "avatar_image");
        r22.i("ProgressLoadingViewModel", "onProgressLoadingShow initProgress " + r24 + ' ');
        ProgressLoadingViewModel r26 = this.this$0;
        if (r25 == false) goto L65;
        r3 = 3;
    L65:
        String r27 = this.$newMsg.getLocalMessageId();
        if (r27 != null) goto L68;
        r27 = "";
    L68:
        this.L$0 = null;
        this.label = 2;
        if (ProgressLoadingViewModel.resetProgressAndStart$default(r26, r3, r27, r5, null, r24, 0, 0.0d, this, 96, null) != r0) goto L72;
        return r0;
    L54:
        Map<String, ProgressLoadingUIState> r28 = this.$cachedProgress;
        if (r28 == null) goto L61;
        ProgressLoadingUIState r29 = r28.get(this.$loadingTaskId);
        if (r29 == null) goto L61;
        Integer r30 = r29.getProgress();
        if (r30 == null) goto L61;
        r17 = r30.intValue();
    L61:
        r23 = Boxing.boxInt(r17);
        goto L53
    L28:
        r15 = null;
    L73:
        th = move-exception;
        throw th;
    L11:
        ResultKt.throwOnFailure(r18);
        r2 = this.$newMsg.getReplyId();
        if (r2 == null) goto L14;
        IChatRepoService r31 = RepoDispatcherDelegate.b.e();
        this.L$0 = r2;
        this.label = 1;
        r4 = r31.E1(r2, this);
        if (r4 != r0) goto L10;
        return r0;
    L14:
        return Unit.INSTANCE;
    }
}
