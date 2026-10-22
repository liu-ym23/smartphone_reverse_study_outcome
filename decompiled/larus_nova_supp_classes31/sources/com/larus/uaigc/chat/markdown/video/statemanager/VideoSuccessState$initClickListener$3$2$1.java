package com.larus.uaigc.chat.markdown.video.statemanager;

import android.view.View;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
import com.larus.uaigc.helper.h0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.video.statemanager.VideoSuccessState$initClickListener$3$2$1", f = "VideoSuccessState.kt", i = {}, l = {491}, m = "invokeSuspend", n = {}, s = {})
final class VideoSuccessState$initClickListener$3$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ VideoPlayView $it;
    final /* synthetic */ Message $msg;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ i this$0;

    public VideoSuccessState$initClickListener$3$2$1(VideoPlayView r1, Message r2, i r3, Continuation<? super VideoSuccessState$initClickListener$3$2$1> r4) {
        this.$it = r1;
        this.$msg = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new VideoSuccessState$initClickListener$3$2$1(this.$it, this.$msg, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r27) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        q0.a r3 = (q0.a) this.L$6;
        AiGenVideoContentData r4 = (AiGenVideoContentData) this.L$5;
        Message r5 = (Message) this.L$4;
        View r6 = (View) this.L$3;
        IAIChatUgcAIGCService.Companion r7 = (IAIChatUgcAIGCService.Companion) this.L$2;
        JSONObject r8 = (JSONObject) this.L$1;
        JSONObject r9 = (JSONObject) this.L$0;
        ResultKt.throwOnFailure(r27);
        q0.a r10 = r3;
        JSONObject r11 = r9;
        AiGenVideoContentData r12 = r4;
        Message r13 = r5;
        Object r14 = r27;
    L6:
        IAIChatUgcAIGCService.Companion r25 = r7;
        View r15 = r6;
        h0.a(r8, (JSONObject) r14);
        Unit r16 = Unit.INSTANCE;
        r25.T(r15, r13, r12, r10, r11);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r27);
        r7 = IAIChatUgcAIGCService.a;
        r6 = this.$it;
        r13 = this.$msg;
        CreationTask r17 = this.this$0.c;
        String r18 = null;
        if (r17 == null) goto L18;
        CreationAsset r19 = r17.asset;
        if (r19 == null) goto L18;
        ep8.a r20 = r19.videoContent;
        if (r20 == null) goto L18;
        AiGenVideoContentData r21 = r20.videoInfo;
        if (r21 == null) goto L18;
        AiGenVideoContentData r22 = AiGenVideoContentData.copy$default(r21, null, null, null, null, null, null, null, null, null, null, null, null, r17.taskType, 4095, null);
    L19:
        r10 = this.this$0.f();
        r11 = new JSONObject();
        i r110 = this.this$0;
        Message r111 = this.$msg;
        CreationTask r112 = r110.c;
        if (r112 == null) goto L22;
        r18 = r112.id;
    L22:
        r11.putOpt("creation_task_id", r18);
        CreationTask r23 = r110.c;
        if (r23 == null) goto L27;
        Integer r24 = r23.index;
        if (r24 == null) goto L27;
        int r26 = r24.intValue();
    L28:
        r11.putOpt("position", Boxing.boxInt(r26 + 1));
        r11.putOpt("is_upload_video", "0");
        CreationChatItemClickHelper r28 = CreationChatItemClickHelper.a;
        this.L$0 = r11;
        this.L$1 = r11;
        this.L$2 = r7;
        this.L$3 = r6;
        this.L$4 = r13;
        this.L$5 = r22;
        this.L$6 = r10;
        this.label = 1;
        r28.getClass();
        r14 = CreationChatItemClickHelper.n(r111, this);
        if (r14 != r1) goto L31;
        return r1;
    L31:
        r12 = r22;
        r8 = r11;
    L27:
        r26 = 0;
    L18:
        r22 = null;
        goto L19
    }
}
