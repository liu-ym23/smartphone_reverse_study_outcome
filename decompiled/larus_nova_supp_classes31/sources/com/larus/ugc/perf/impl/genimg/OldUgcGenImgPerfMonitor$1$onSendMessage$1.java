package com.larus.ugc.perf.impl.genimg;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor$1$onSendMessage$1", f = "UgcGenImgPerfMonitor.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
public final class OldUgcGenImgPerfMonitor$1$onSendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ OldUgcGenImgPerfMonitor this$0;

    public OldUgcGenImgPerfMonitor$1$onSendMessage$1(OldUgcGenImgPerfMonitor r1, Continuation<? super OldUgcGenImgPerfMonitor$1$onSendMessage$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OldUgcGenImgPerfMonitor$1$onSendMessage$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0074 -> B:17:0x0079). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator<String> r2 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r11);
        Iterator<String> r3 = r2;
        Object r4 = r0;
        OldUgcGenImgPerfMonitor$1$onSendMessage$1 r5 = this;
    L17:
        Message r12 = (Message) r11;
        if (r12 == null) goto L22;
        OldUgcGenImgPerfMonitor r6 = r5.this$0;
        r6.getClass();
        com.larus.ugc.perf.impl.e r7 = com.larus.ugc.perf.impl.d.a.a(r12);
        if (r7 == null) goto L22;
        FLogger.a.i("OldUgcGenImgPerfMonitor", "onSendMessage: interrupt msg:" + r12.getMessageId());
        r6.j(r7, 30013);
    L22:
        OldUgcGenImgPerfMonitor$1$onSendMessage$1 r13 = r5;
        r0 = r4;
        Iterator<String> r8 = r3;
    L10:
        if (r8.hasNext() == false) goto L24;
        String r9 = r8.next();
        Job.DefaultImpls.cancel$default(r13.this$0.b.get(r9), null, 1, null);
        if (Intrinsics.areEqual(r13.this$0.a.get(r9), Boxing.boxBoolean(false)) == false) goto L10;
        IChatRepoService r10 = RepoDispatcherDelegate.b.e();
        Intrinsics.checkNotNull(r9);
        r13.L$0 = r8;
        r13.label = 1;
        Object r14 = r10.E1(r9, r13);
        if (r14 != r0) goto L16;
        return r0;
    L16:
        Object r15 = r0;
        r5 = r13;
        r11 = r14;
        r3 = r8;
        r4 = r15;
        goto L17
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r8 = this.this$0.b.snapshot().keySet().iterator();
        r13 = this;
        goto L10
    }
}
