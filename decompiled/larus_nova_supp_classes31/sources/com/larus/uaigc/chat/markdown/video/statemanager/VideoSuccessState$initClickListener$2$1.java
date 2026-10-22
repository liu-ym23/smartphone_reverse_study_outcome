package com.larus.uaigc.chat.markdown.video.statemanager;

import android.content.Context;
import android.widget.ImageView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.utils.c4;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.utils.DataConverterKt;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
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
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.video.statemanager.VideoSuccessState$initClickListener$2$1", f = "VideoSuccessState.kt", i = {}, l = {373}, m = "invokeSuspend", n = {}, s = {})
final class VideoSuccessState$initClickListener$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageView $it;
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ i this$0;

    public VideoSuccessState$initClickListener$2$1(Message r1, i r2, ImageView r3, Continuation<? super VideoSuccessState$initClickListener$2$1> r4) {
        this.$message = r1;
        this.this$0 = r2;
        this.$it = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new VideoSuccessState$initClickListener$2$1(this.$message, this.this$0, this.$it, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r31) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r31);
        Object r3 = r31;
    L11:
        JSONObject r12 = (JSONObject) r3;
        ICreationMetadataService.Companion r4 = ICreationMetadataService.a;
        Message r5 = this.$message;
        CreationTask r6 = this.this$0.c;
        if (r6 == null) goto L14;
        String r7 = r6.id;
    L15:
        int r8 = 0;
        if (r6 == null) goto L20;
        Integer r9 = r6.index;
        if (r9 == null) goto L20;
        int r10 = r9.intValue();
    L21:
        Map<String, String> r13 = r4.s(r4.I(r5, r7, String.valueOf(r10)), null);
        com.larus.bmhome.video.save_share.a r11 = IAIChatUgcAIGCService.a.G();
        Context r14 = this.$it.getContext();
        CreationTask r15 = this.this$0.c;
        if (r15 == null) goto L30;
        CreationAsset r16 = r15.asset;
        if (r16 == null) goto L30;
        ep8.a r17 = r16.videoContent;
        if (r17 == null) goto L30;
        AiGenVideoContentData r18 = r17.videoInfo;
        if (r18 == null) goto L30;
        nr9.g r19 = ff8.a.a(r18);
    L31:
        q0.a r20 = this.this$0.f();
        if (r20 == null) goto L36;
        y r21 = r20.u0();
        if (r21 == null) goto L36;
        String r110 = r21.getBotId();
    L37:
        Message r22 = this.$message;
        if (r22 == null) goto L40;
        String r111 = r22.getMessageId();
    L41:
        IAIChatControlTraceService.Companion r23 = IAIChatControlTraceService.a;
        String r112 = r23.bb(r23.gb());
        CreationTask r24 = this.this$0.c;
        if (r24 == null) goto L44;
        String r25 = r24.id;
    L45:
        if (r24 == null) goto L49;
        Integer r26 = r24.index;
        if (r26 == null) goto L49;
        r8 = r26.intValue();
    L49:
        int r27 = r8 + 1;
        Message r28 = this.$message;
        if (r28 == null) goto L52;
        String r29 = tz9.a.a(r28);
    L53:
        Message r30 = this.$message;
        if (r30 == null) goto L56;
        Boolean r210 = Boxing.boxBoolean(com.larus.im.bean.message.a.C0(r30));
    L57:
        c4 r32 = new c4(r110, r111, r112, null, null, null, "0", r25, Boxing.boxInt(r27), r29, r210, this.$message, null, null, 12344);
        CoroutineScope r33 = this.this$0.c();
        boolean r113 = z2.a.Q3();
        CreationTask r34 = this.this$0.c;
        if (r34 == null) goto L62;
        Integer r35 = r34.taskType;
        if (r35 == null) goto L62;
        String r114 = DataConverterKt.h(r35.intValue());
    L63:
        final i r36 = this.this$0;
        final ImageView r37 = this.$it;
        final Message r38 = this.$message;
        com.larus.bmhome.video.save_share.a.a.a(r11, r14, r19, r32, "overview_click", r33, false, r113, r12, r13, r114, true, new k(r36, r37, r38), 32);
        return Unit.INSTANCE;
    L62:
        r114 = null;
        goto L63
    L56:
        r210 = null;
        goto L57
    L52:
        r29 = null;
        goto L53
    L44:
        r25 = null;
        goto L45
    L40:
        r111 = null;
    L36:
        r110 = null;
    L30:
        r19 = null;
    L20:
        r10 = 0;
        goto L21
    L14:
        r7 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r31);
        CreationChatItemClickHelper r39 = CreationChatItemClickHelper.a;
        Message r40 = this.$message;
        this.label = 1;
        r39.getClass();
        r3 = CreationChatItemClickHelper.n(r40, this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
