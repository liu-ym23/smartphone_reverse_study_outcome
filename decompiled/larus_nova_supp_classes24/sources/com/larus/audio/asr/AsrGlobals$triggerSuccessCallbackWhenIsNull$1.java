package com.larus.audio.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IRepoDispatcherService;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.asr.AsrGlobals$triggerSuccessCallbackWhenIsNull$1", f = "AsrGlobals.kt", i = {1, 1}, l = {527, 556, 557}, m = "invokeSuspend", n = {"realMsg", "chatRepo"}, s = {"L$0", "L$1"})
final class AsrGlobals$triggerSuccessCallbackWhenIsNull$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $asrResult;
    final /* synthetic */ long $audioDuration;
    final /* synthetic */ Message $msg;
    final /* synthetic */ String $path;
    final /* synthetic */ String $taskId;
    final /* synthetic */ c0 $traceInfo;
    Object L$0;
    Object L$1;
    int label;

    public AsrGlobals$triggerSuccessCallbackWhenIsNull$1(String r1, Message r2, c0 r3, String r4, String r5, long r6, Continuation<? super AsrGlobals$triggerSuccessCallbackWhenIsNull$1> r8) {
        this.$taskId = r1;
        this.$msg = r2;
        this.$traceInfo = r3;
        this.$asrResult = r4;
        this.$path = r5;
        this.$audioDuration = r6;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AsrGlobals$triggerSuccessCallbackWhenIsNull$1(this.$taskId, this.$msg, this.$traceInfo, this.$asrResult, this.$path, this.$audioDuration, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r19);
    L67:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        IChatRepoService r3 = (IChatRepoService) this.L$1;
        Message r4 = (Message) this.L$0;
        ResultKt.throwOnFailure(r19);
    L56:
        if (r3 == null) goto L67;
        u1 r5 = r3.u1();
        if (r5 == null) goto L67;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        if (r5.n(r4, this) != r1) goto L67;
        return r1;
    L11:
        ResultKt.throwOnFailure(r19);
        Object r6 = r19;
    L26:
        Message r7 = (Message) r6;
    L28:
        FLogger r8 = FLogger.a;
        r8.e("AsrGlobals", "ASR triggerSuccessCallbackIsNull");
        f2a.c r10 = com.larus.audio.utils.c.a.b("trigger success callback but use fallback strategy");
        LinkedHashMap r11 = new LinkedHashMap();
        String r12 = this.$path;
        long r13 = this.$audioDuration;
        Message r15 = this.$msg;
        String r9 = this.$asrResult;
        String r14 = this.$taskId;
        r11.put(new f2a.f("path"), r12);
        r11.put(new f2a.f("audio_duration"), String.valueOf(r13));
        f2a.f r16 = new f2a.f("msg_local_message_id");
        String r17 = "";
        if (r15 == null) goto L32;
        String r110 = r15.getLocalMessageId();
        if (r110 == null) goto L32;
    L33:
        r11.put(r16, r110);
        f2a.f r20 = new f2a.f("real_msg_local_message_id");
        if (r7 == null) goto L39;
        String r111 = r7.getLocalMessageId();
        if (r111 == null) goto L39;
        r17 = r111;
    L39:
        r11.put(r20, r17);
        r11.put(new f2a.f("asr_result_size"), String.valueOf(r9.length()));
        r11.put(new f2a.f("callback_map_size"), String.valueOf(AsrGlobals.k.size()));
        r11.put(f2a.f.c, r14);
        r10.d(r11);
        List r21 = CollectionsKt.listOf(this.$traceInfo.a);
        f2a.g r22 = r10.c;
        r22.b = r21;
        r22.e = this.$traceInfo.b;
        r22.d = "AsrGlobals.triggerSuccessCallbackWhenIsNull";
        f2a.c.c(r10, null, 15);
        if (r7 != null) goto L43;
        r8.e("AsrGlobals", "ASR error msgReq is null");
        return Unit.INSTANCE;
    L43:
        IRepoDispatcherService r23 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
        if (r23 == null) goto L46;
        IChatRepoService r24 = r23.e();
    L48:
        if (this.$asrResult.length() != 0) goto L50;
        boolean r25 = true;
    L51:
        if (r25 == false) goto L62;
        r8.e("AsrGlobals", "ASR failed with no retrying");
        this.L$0 = r7;
        this.L$1 = r24;
        this.label = 2;
        if (DelayKt.delay(200, this) != r1) goto L55;
        return r1;
    L55:
        IChatRepoService r112 = r24;
        r4 = r7;
        r3 = r112;
        goto L56
    L62:
        if (r24 == null) goto L67;
        u1 r26 = r24.u1();
        if (r26 == null) goto L67;
        r26.a(r7, this.$path, this.$audioDuration);
        goto L67
    L50:
        r25 = false;
        goto L51
    L46:
        r24 = null;
    L32:
        r110 = "";
        goto L33
    L12:
        ResultKt.throwOnFailure(r19);
        String r27 = this.$taskId;
        Message r29 = this.$msg;
        if (r29 == null) goto L15;
        String r30 = r29.getLocalMessageId();
    L17:
        if (Intrinsics.areEqual(r27, r30) == false) goto L19;
        f2a.c r31 = com.larus.audio.utils.c.a.b("trigger success callback use parameter[msg]");
        List r32 = CollectionsKt.listOf(this.$traceInfo.a);
        f2a.g r33 = r31.c;
        r33.b = r32;
        r33.e = this.$traceInfo.b;
        f2a.c.c(r31, null, 15);
        r7 = this.$msg;
        goto L28
    L19:
        f2a.c r34 = com.larus.audio.utils.c.a.b("trigger success callback use db[msg]");
        List r35 = CollectionsKt.listOf(this.$traceInfo.a);
        f2a.g r36 = r34.c;
        r36.b = r35;
        r36.e = this.$traceInfo.b;
        f2a.c.c(r34, null, 15);
        IRepoDispatcherService r37 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
        if (r37 == null) goto L27;
        IChatRepoService r38 = r37.e();
        if (r38 == null) goto L27;
        String r39 = this.$taskId;
        this.label = 1;
        r6 = r38.E1(r39, this);
        if (r6 != r1) goto L26;
        return r1;
    L27:
        r7 = null;
        goto L28
    L15:
        r30 = null;
        goto L17
    }
}
