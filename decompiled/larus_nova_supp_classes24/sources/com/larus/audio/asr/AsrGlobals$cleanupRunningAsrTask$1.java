package com.larus.audio.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.IFlowAsrClientService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IRepoDispatcherService;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.asr.AsrGlobals$cleanupRunningAsrTask$1", f = "AsrGlobals.kt", i = {0, 0}, l = {793}, m = "invokeSuspend", n = {"taskId", "chatRepo"}, s = {"L$1", "L$2"})
public final class AsrGlobals$cleanupRunningAsrTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $taskIds;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public AsrGlobals$cleanupRunningAsrTask$1(List<String> r1, Continuation<? super AsrGlobals$cleanupRunningAsrTask$1> r2) {
        this.$taskIds = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AsrGlobals$cleanupRunningAsrTask$1(this.$taskIds, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x009a -> B:20:0x00a1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00a4 -> B:22:0x00aa). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        IChatRepoService r2 = (IChatRepoService) this.L$2;
        String r4 = (String) this.L$1;
        Iterator r5 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r12);
        Iterator r6 = r5;
        String r7 = r4;
        IChatRepoService r8 = r2;
        Object r3 = r0;
        AsrGlobals$cleanupRunningAsrTask$1 r9 = this;
    L20:
        Message r13 = (Message) r12;
    L22:
        if (r13 == null) goto L30;
        u1 r10 = r8.u1();
        IFlowAsrClientService.a.getClass();
        y58.a r11 = IFlowAsrClientService.a.a().g(r7);
        if (r11 == null) goto L26;
        String r14 = r11.e;
    L27:
        if (r14 != null) goto L29;
        r14 = "";
    L29:
        r10.a(r13, r14, IFlowAsrClientService.a.a().p(r7));
        goto L30
    L26:
        r14 = null;
    L30:
        AsrGlobals$cleanupRunningAsrTask$1 r15 = r9;
        r0 = r3;
        Iterator r16 = r6;
    L10:
        if (r16.hasNext() == false) goto L32;
        String r17 = (String) r16.next();
        IRepoDispatcherService r19 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
        if (r19 == null) goto L14;
        IChatRepoService r20 = r19.e();
    L15:
        if (r20 == null) goto L21;
        r15.L$0 = r16;
        r15.L$1 = r17;
        r15.L$2 = r20;
        r15.label = 1;
        Object r21 = r20.E1(r17, r15);
        if (r21 != r0) goto L19;
        return r0;
    L19:
        Object r110 = r0;
        r9 = r15;
        r12 = r21;
        r6 = r16;
        r7 = r17;
        r8 = r20;
        r3 = r110;
        goto L20
    L21:
        r6 = r16;
        r7 = r17;
        r8 = r20;
        r3 = r0;
        r9 = r15;
        r13 = null;
        goto L22
    L14:
        r20 = null;
        goto L15
    L32:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        f2a.c r111 = com.larus.audio.utils.c.a.b("try to clean up ASRTask");
        LinkedHashMap r22 = new LinkedHashMap();
        r22.put(new f2a.f("task_id_size"), String.valueOf(this.$taskIds.size()));
        r111.d(r22);
        r111.c.d = "AsrGlobals.cleanupRunningAsrTask";
        f2a.c.c(r111, null, 15);
        r16 = this.$taskIds.iterator();
        r15 = this;
        goto L10
    }
}
