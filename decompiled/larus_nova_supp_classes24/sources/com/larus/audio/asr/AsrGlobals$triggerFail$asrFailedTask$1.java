package com.larus.audio.asr;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.asr.AsrGlobals$triggerFail$asrFailedTask$1", f = "AsrGlobals.kt", i = {1, 1}, l = {594, 619, 620}, m = "invokeSuspend", n = {"realMsg", "chatRepo"}, s = {"L$0", "L$1"})
public final class AsrGlobals$triggerFail$asrFailedTask$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ long $audioDuration;
    final /* synthetic */ int $errorCode;
    final /* synthetic */ Message $msg;
    final /* synthetic */ String $path;
    final /* synthetic */ String $taskId;
    final /* synthetic */ c0 $traceInfo;
    Object L$0;
    Object L$1;
    int label;

    public AsrGlobals$triggerFail$asrFailedTask$1(String r1, Message r2, c0 r3, String r4, long r5, int r7, Continuation<? super AsrGlobals$triggerFail$asrFailedTask$1> r8) {
        this.$taskId = r1;
        this.$msg = r2;
        this.$traceInfo = r3;
        this.$path = r4;
        this.$audioDuration = r5;
        this.$errorCode = r7;
        super(1, r8);
    }

    public final Continuation<Unit> create(Continuation<?> r11) {
        return new AsrGlobals$triggerFail$asrFailedTask$1(this.$taskId, this.$msg, this.$traceInfo, this.$path, this.$audioDuration, this.$errorCode, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r17);
    L74:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        IChatRepoService r3 = (IChatRepoService) this.L$1;
        Message r4 = (Message) this.L$0;
        ResultKt.throwOnFailure(r17);
    L60:
        if (r3 == null) goto L72;
        u1 r5 = r3.u1();
        if (r5 == null) goto L73;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        if (r5.n(r4, this) != r1) goto L74;
        return r1;
    L73:
        return null;
    L72:
        return null;
    L11:
        ResultKt.throwOnFailure(r17);
        Object r6 = r17;
    L26:
        Message r7 = (Message) r6;
    L28:
        f2a.c r8 = com.larus.audio.utils.c.a.b("trigger onFail but use fallback strategy");
        LinkedHashMap r9 = new LinkedHashMap();
        String r10 = this.$path;
        long r11 = this.$audioDuration;
        int r13 = this.$errorCode;
        Message r14 = this.$msg;
        String r15 = this.$taskId;
        r9.put(new f2a.f("path"), r10);
        r9.put(new f2a.f("audio_duration"), String.valueOf(r11));
        r9.put(new f2a.f("error_code"), String.valueOf(r13));
        f2a.f r12 = new f2a.f("msg_local_message_id");
        String r16 = "";
        if (r14 == null) goto L32;
        String r19 = r14.getLocalMessageId();
        if (r19 == null) goto L32;
    L33:
        r9.put(r12, r19);
        f2a.f r20 = new f2a.f("real_msg_local_message_id");
        if (r7 == null) goto L39;
        String r110 = r7.getLocalMessageId();
        if (r110 == null) goto L39;
        r16 = r110;
    L39:
        r9.put(r20, r16);
        r9.put(new f2a.f("callback_map_size"), String.valueOf(AsrGlobals.k.size()));
        r9.put(f2a.f.c, r15);
        r8.d(r9);
        List r21 = CollectionsKt.listOf(this.$traceInfo.a);
        f2a.g r22 = r8.c;
        r22.b = r21;
        r22.e = this.$traceInfo.b;
        r22.d = "AsrGlobals.triggerFail";
        f2a.c.c(r8, null, 15);
        if (r7 == null) goto L67;
        IRepoDispatcherService r23 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
        if (r23 == null) goto L44;
        IChatRepoService r24 = r23.e();
    L46:
        if (this.$path.length() <= 0) goto L48;
        boolean r25 = true;
    L49:
        if (r25 == true) goto L51;
    L56:
        FLogger.a.e("AsrGlobals", "ASR failed with no retrying, path=" + this.$path);
        this.L$0 = r7;
        this.L$1 = r24;
        this.label = 2;
        if (DelayKt.delay(200, this) != r1) goto L59;
        return r1;
    L59:
        r4 = r7;
        r3 = r24;
        goto L60
    L51:
        if (new PolarisFileWrapper(this.$path).exists() == false) goto L56;
        if (r24 == null) goto L69;
        u1 r26 = r24.u1();
        if (r26 == null) goto L70;
        r26.a(r7, this.$path, this.$audioDuration);
        return Unit.INSTANCE;
    L70:
        return null;
    L69:
        return null;
    L48:
        r25 = false;
        goto L49
    L44:
        r24 = null;
        goto L46
    L67:
        FLogger.a.e("AsrGlobals", "ASR error msgReq is null");
        return Unit.INSTANCE;
    L32:
        r19 = "";
        goto L33
    L12:
        ResultKt.throwOnFailure(r17);
        String r27 = this.$taskId;
        Message r29 = this.$msg;
        if (r29 == null) goto L15;
        String r30 = r29.getLocalMessageId();
    L17:
        if (Intrinsics.areEqual(r27, r30) == false) goto L19;
        f2a.c r31 = com.larus.audio.utils.c.a.b("trigger fail callback use parameter[msg]");
        List r32 = CollectionsKt.listOf(this.$traceInfo.a);
        f2a.g r33 = r31.c;
        r33.b = r32;
        r33.e = this.$traceInfo.b;
        f2a.c.c(r31, null, 15);
        r7 = this.$msg;
        goto L28
    L19:
        f2a.c r34 = com.larus.audio.utils.c.a.b("trigger fail callback use db[msg]");
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
