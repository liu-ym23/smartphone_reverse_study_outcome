package com.larus.uaigc.chat.block.widget.video;

import android.content.Context;
import android.widget.ImageView;
import com.larus.bmhome.utils.c4;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.utils.DataConverterKt;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kc8.a0;
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
@DebugMetadata(c = "com.larus.uaigc.chat.block.widget.video.VideoSuccessViewBinder$initClickListener$3$1", f = "VideoSuccessViewBinder.kt", i = {}, l = {529}, m = "invokeSuspend", n = {}, s = {})
public final class VideoSuccessViewBinder$initClickListener$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageView $it;
    int label;
    final /* synthetic */ VideoSuccessViewBinder this$0;

    public VideoSuccessViewBinder$initClickListener$3$1(VideoSuccessViewBinder r1, ImageView r2, Continuation<? super VideoSuccessViewBinder$initClickListener$3$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VideoSuccessViewBinder$initClickListener$3$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r32) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r4 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r32);
        Object r3 = r32;
    L15:
        JSONObject r13 = (JSONObject) r3;
        ICreationMetadataService.Companion r5 = ICreationMetadataService.a;
        cz9.o r6 = this.this$0.f;
        if (r6 == null) goto L18;
        Message r7 = r6.e;
    L19:
        if (r6 == null) goto L23;
        CreationItem r8 = r6.d;
        if (r8 == null) goto L23;
        String r9 = r8.id;
    L24:
        int r10 = 0;
        if (r6 == null) goto L27;
        int r11 = r6.f;
    L28:
        Map<String, String> r14 = r5.s(r5.I(r7, r9, String.valueOf(r11)), null);
        com.larus.bmhome.video.save_share.a r12 = IAIChatUgcAIGCService.a.G();
        Context r15 = this.$it.getContext();
        cz9.o r16 = this.this$0.f;
        if (r16 == null) goto L35;
        CreationItem r17 = r16.d;
        if (r17 == null) goto L35;
        VideoData r18 = r17.video;
        if (r18 == null) goto L35;
        nr9.g r19 = bz9.a.l(r18);
    L36:
        kc8.q r20 = this.this$0.g();
        if (r20 == null) goto L41;
        a0 r21 = r20.d;
        if (r21 == null) goto L41;
        String r110 = r21.getBotId();
    L42:
        cz9.o r22 = this.this$0.f;
        if (r22 == null) goto L47;
        Message r23 = r22.e;
        if (r23 == null) goto L47;
        String r111 = r23.getMessageId();
    L48:
        IAIChatControlTraceService.Companion r24 = IAIChatControlTraceService.a;
        String r112 = r24.bb(r24.gb());
        cz9.o r25 = this.this$0.f;
        if (r25 == null) goto L53;
        CreationItem r26 = r25.d;
        if (r26 == null) goto L53;
        String r27 = r26.id;
    L54:
        if (r25 == null) goto L56;
        r10 = r25.f;
    L56:
        int r28 = r10 + 1;
        if (r25 == null) goto L61;
        Message r29 = r25.e;
        if (r29 == null) goto L61;
        String r210 = tz9.a.a(r29);
    L62:
        cz9.o r30 = this.this$0.f;
        if (r30 == null) goto L65;
        Message r211 = r30.e;
    L66:
        if (r30 == null) goto L70;
        Message r31 = r30.e;
        if (r31 == null) goto L70;
        Boolean r212 = Boxing.boxBoolean(com.larus.im.bean.message.a.C0(r31));
    L71:
        c4 r33 = new c4(r110, r111, r112, null, null, null, "0", r27, Boxing.boxInt(r28), r210, r212, r211, null, null, 12344);
        CoroutineScope r113 = this.this$0.c();
        boolean r114 = z2.a.Q3();
        cz9.o r34 = this.this$0.f;
        if (r34 == null) goto L80;
        CreationItem r35 = r34.d;
        if (r35 == null) goto L80;
        CreationGenDetail r36 = r35.genDetail;
        if (r36 == null) goto L80;
        Integer r37 = r36.taskType;
        if (r37 == null) goto L80;
        r4 = DataConverterKt.h(r37.intValue());
    L80:
        final VideoSuccessViewBinder r38 = this.this$0;
        final ImageView r39 = this.$it;
        com.larus.bmhome.video.save_share.a.a.a(r12, r15, r19, r33, "overview_click", r113, false, r114, r13, r14, r4, true, new u(r38, r39), 32);
        return Unit.INSTANCE;
    L70:
        r212 = null;
        goto L71
    L65:
        r211 = null;
    L61:
        r210 = null;
    L53:
        r27 = null;
    L47:
        r111 = null;
    L41:
        r110 = null;
    L35:
        r19 = null;
        goto L36
    L27:
        r11 = 0;
    L23:
        r9 = null;
        goto L24
    L18:
        r7 = null;
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r32);
        CreationChatItemClickHelper r40 = CreationChatItemClickHelper.a;
        cz9.o r41 = this.this$0.f;
        if (r41 == null) goto L11;
        Message r42 = r41.e;
    L12:
        this.label = 1;
        r40.getClass();
        r3 = CreationChatItemClickHelper.n(r42, this);
        if (r3 != r1) goto L15;
        return r1;
    L11:
        r42 = null;
        goto L12
    }
}
