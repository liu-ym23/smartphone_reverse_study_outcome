package com.larus.uaigc.chat.loading;

import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.loading.ProgressLoadingViewModel$onMessageListChanged$1", f = "ProgressLoadingViewModel.kt", i = {0}, l = {256}, m = "invokeSuspend", n = {"lastLoadingMsg"}, s = {"L$3"})
public final class ProgressLoadingViewModel$onMessageListChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Message> $lastMsgList;
    final /* synthetic */ Message $latestMsg;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ProgressLoadingViewModel this$0;

    public ProgressLoadingViewModel$onMessageListChanged$1(Message r1, List<Message> r2, ProgressLoadingViewModel r3, Continuation<? super ProgressLoadingViewModel$onMessageListChanged$1> r4) {
        this.$latestMsg = r1;
        this.$lastMsgList = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ProgressLoadingViewModel$onMessageListChanged$1 r0 = new ProgressLoadingViewModel$onMessageListChanged$1(this.$latestMsg, this.$lastMsgList, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        Message r2 = (Message) this.L$3;
        ProgressLoadingViewModel r3 = (ProgressLoadingViewModel) this.L$2;
        List<Message> r6 = (List) this.L$1;
        Message r7 = (Message) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L89
    L40:
        Map r13 = (Map) r12;     // Catch: Throwable -> L89
        Message r8 = r2;
    L42:
        FLogger r5 = FLogger.a;     // Catch: Throwable -> L89
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L89
        r9.append("onMessageListChanged isFirstTime is ");     // Catch: Throwable -> L89
        r9.append(ProgressLoadingViewModel.access$isFirstTime$p(r3));     // Catch: Throwable -> L89
        r9.append(" cachedProgress is ");     // Catch: Throwable -> L89
        r9.append(r13);     // Catch: Throwable -> L89
        r9.append("  ");     // Catch: Throwable -> L89
        if (r8 == null) goto L45;
        String r10 = r8.getReplyId();     // Catch: Throwable -> L89
    L46:
        r9.append(r10);     // Catch: Throwable -> L89
        r5.i("ProgressLoadingViewModel", r9.toString());     // Catch: Throwable -> L89
        ProgressLoadingViewModel.access$onProgressLoadingShow(r3, r8, r13);     // Catch: Throwable -> L89
    L52:
        Iterator<T> r14 = r6.iterator();     // Catch: Throwable -> L89
    L54:
        if (r14.hasNext() == false) goto L71;
        final Message r11 = (Message) r14.next();     // Catch: Throwable -> L89
        if (d.a0(r11) == true) goto L57;
        if (d.k(r11) == true) goto L60;
        if (IAIChatUgcAIGCService.a.g0(r11) == true) goto L54;
        String r15 = DataConverterKt.a(r11.getLocalMessageId(), null);     // Catch: Throwable -> L89
        Job r16 = (Job) ProgressLoadingViewModel.access$getProgressJob$p(r3).get(r15);     // Catch: Throwable -> L89
        if (r16 == null) goto L66;
        Job.DefaultImpls.cancel$default(r16, null, 1, null);     // Catch: Throwable -> L89
    L66:
        Job r17 = (Job) ProgressLoadingViewModel.access$getProgressJob$p(r3).remove(r15);     // Catch: Throwable -> L89
        HashSet r18 = new HashSet();     // Catch: ConcurrentModificationException -> L69 Throwable -> L89
        r18.addAll(ProgressLoadingViewModel.access$getCurrentLoadingMessageSet$p(r3));     // Catch: ConcurrentModificationException -> L69 Throwable -> L89
        CollectionsKt.removeAll(r18, new c(r11));     // Catch: ConcurrentModificationException -> L69 Throwable -> L89
        ProgressLoadingViewModel.access$setCurrentLoadingMessageSet$p(r3, r18);     // Catch: ConcurrentModificationException -> L69 Throwable -> L89
    L69:
        FLogger.a.i("ProgressLoadingViewModel", "catching concurrent modification currentLoadingMessageSet");     // Catch: Throwable -> L89
        goto L54
    L60:
        ProgressLoadingViewModel.access$handleBlockContentMsgProgress(r3, r11, ProgressLoadingViewModel.access$isFirstTime$p(r3));     // Catch: Throwable -> L89
        goto L54
    L57:
        ProgressLoadingViewModel.access$handleCreationMsgProgress(r3, r11, ProgressLoadingViewModel.access$isFirstTime$p(r3));     // Catch: Throwable -> L89
        goto L54
    L71:
        if (ProgressLoadingViewModel.access$isFirstTime$p(r3) == false) goto L84;
        List<Message> r19 = r6;     // Catch: Throwable -> L89
        if ((r19 instanceof Collection) == true) goto L75;
    L77:
        Iterator<T> r110 = r19.iterator();     // Catch: Throwable -> L89
    L79:
        if (r110.hasNext() == false) goto L76;
        if (o0.d(((Message) r110.next()).getMessageId()) == false) goto L79;
    L82:
        if (r4 == false) goto L84;
        ProgressLoadingViewModel.access$setFirstTime$p(r3, false);     // Catch: Throwable -> L89
    L76:
        r4 = false;
        goto L82
    L75:
        if (r19.isEmpty() == false) goto L77;
    L84:
        ProgressLoadingViewModel$a r111 = ProgressLoadingViewModel.Companion;     // Catch: Throwable -> L89
        String r112 = r7.getReplyId();     // Catch: Throwable -> L89
        if (r112 != null) goto L87;
        r112 = "";
    L87:
        ProgressLoadingViewModel.access$setQuickCache$cp(TuplesKt.to(r112, null));     // Catch: Throwable -> L89
        Object r113 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L89
    L91:
        Throwable r114 = Result.exceptionOrNull-impl(r113);
        if (r114 == null) goto L96;
        FLogger.a.e("ProgressLoadingViewModel", "onMessageListChanged error", r114);
    L96:
        return Unit.INSTANCE;
    L45:
        r10 = null;
        goto L46
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r115 = (CoroutineScope) this.L$0;
        r7 = this.$latestMsg;
        r6 = this.$lastMsgList;
        r3 = this.this$0;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L89
        if (com.larus.im.bean.message.a.r0(r7) == false) goto L14;
        r8 = r7;
    L22:
        FLogger r117 = FLogger.a;     // Catch: Throwable -> L89
        StringBuilder r20 = new StringBuilder();     // Catch: Throwable -> L89
        r20.append("onMessageListChanged lastLoadingMsg is ");     // Catch: Throwable -> L89
        if (r8 == null) goto L25;
        String r118 = r8.getLocalMessageId();     // Catch: Throwable -> L89
    L26:
        r20.append(r118);     // Catch: Throwable -> L89
        r20.append("  ");     // Catch: Throwable -> L89
        if (r8 == null) goto L29;
        String r119 = r8.getReplyId();     // Catch: Throwable -> L89
    L30:
        r20.append(r119);     // Catch: Throwable -> L89
        r117.i("ProgressLoadingViewModel", r20.toString());     // Catch: Throwable -> L89
        if (r8 == null) goto L48;
        if (IAIChatUgcAIGCService.a.g0(r8) == false) goto L48;
        if (ProgressLoadingViewModel.access$isFirstTime$p(r3) == false) goto L41;
        this.L$0 = r7;     // Catch: Throwable -> L89
        this.L$1 = r6;     // Catch: Throwable -> L89
        this.L$2 = r3;     // Catch: Throwable -> L89
        this.L$3 = r8;     // Catch: Throwable -> L89
        this.label = 1;     // Catch: Throwable -> L89
        r12 = ProgressLoadingViewModel.access$initProgressCacheAtFirstTime(r3, r8, this);     // Catch: Throwable -> L89
        if (r12 != r0) goto L39;
        return r0;
    L39:
        r2 = r8;
        goto L40
    L41:
        r13 = null;
    L48:
        if (d.a0(r7) == true) goto L50;
    L51:
        ProgressLoadingViewModel.access$onProgressLoadingFinish(r3, r7);     // Catch: Throwable -> L89
        goto L52
    L50:
        if (d.k(r7) == true) goto L52;
    L29:
        r119 = null;
        goto L30
    L25:
        r118 = null;
        goto L26
    L14:
        ListIterator<Message> r120 = r6.listIterator(r6.size());     // Catch: Throwable -> L89
    L16:
        if (r120.hasPrevious() == false) goto L20;
        Message r21 = r120.previous();     // Catch: Throwable -> L89
        if (com.larus.im.bean.message.a.r0(r21) == false) goto L16;
    L21:
        r8 = r21;     // Catch: Throwable -> L89
        goto L22
    L20:
        r21 = null;
    L89:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L91
    }
}
