package com.larus.uaigc.chat.block.widget.video;

import android.content.Context;
import android.widget.ImageView;
import com.larus.bmhome.utils.c4;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.chat.markdown.helper.LocalCreationChatItemClickHelper;
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
@DebugMetadata(c = "com.larus.uaigc.chat.block.widget.video.LocalVideoSuccessViewBinder$initClickListener$2$1", f = "LocalVideoSuccessViewBinder.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, s = {})
public final class LocalVideoSuccessViewBinder$initClickListener$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageView $it;
    int label;
    final /* synthetic */ LocalVideoSuccessViewBinder this$0;

    public LocalVideoSuccessViewBinder$initClickListener$2$1(LocalVideoSuccessViewBinder r1, ImageView r2, Continuation<? super LocalVideoSuccessViewBinder$initClickListener$2$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LocalVideoSuccessViewBinder$initClickListener$2$1(this.this$0, this.$it, r4);
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
        cz9.n r6 = this.this$0.f;
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
        cz9.n r16 = this.this$0.f;
        if (r16 == null) goto L33;
        CreationItem r17 = r16.d;
        if (r17 == null) goto L33;
        nr9.g r18 = bz9.c.p(r17);
    L34:
        kc8.q r19 = this.this$0.g();
        if (r19 == null) goto L39;
        a0 r20 = r19.d;
        if (r20 == null) goto L39;
        String r110 = r20.getBotId();
    L40:
        cz9.n r21 = this.this$0.f;
        if (r21 == null) goto L45;
        Message r22 = r21.e;
        if (r22 == null) goto L45;
        String r111 = r22.getMessageId();
    L46:
        IAIChatControlTraceService.Companion r23 = IAIChatControlTraceService.a;
        String r112 = r23.bb(r23.gb());
        if (this.this$0.j() == false) goto L49;
        String r24 = "1";
    L50:
        String r25 = r24;
        cz9.n r26 = this.this$0.f;
        if (r26 == null) goto L55;
        CreationItem r27 = r26.d;
        if (r27 == null) goto L55;
        String r28 = r27.id;
    L56:
        if (r26 == null) goto L58;
        r10 = r26.f;
    L58:
        int r29 = r10 + 1;
        if (r26 == null) goto L63;
        Message r30 = r26.e;
        if (r30 == null) goto L63;
        String r210 = tz9.a.a(r30);
    L64:
        cz9.n r31 = this.this$0.f;
        if (r31 == null) goto L67;
        Message r211 = r31.e;
    L68:
        if (r31 == null) goto L72;
        Message r33 = r31.e;
        if (r33 == null) goto L72;
        Boolean r212 = Boxing.boxBoolean(com.larus.im.bean.message.a.C0(r33));
    L73:
        c4 r34 = new c4(r110, r111, r112, null, null, null, r25, r28, Boxing.boxInt(r29), r210, r212, r211, null, null, 12344);
        CoroutineScope r113 = this.this$0.c();
        boolean r114 = z2.a.Q3();
        cz9.n r35 = this.this$0.f;
        if (r35 == null) goto L82;
        CreationItem r36 = r35.d;
        if (r36 == null) goto L82;
        CreationGenDetail r37 = r36.genDetail;
        if (r37 == null) goto L82;
        Integer r38 = r37.taskType;
        if (r38 == null) goto L82;
        r4 = DataConverterKt.h(r38.intValue());
    L82:
        final LocalVideoSuccessViewBinder r39 = this.this$0;
        final ImageView r40 = this.$it;
        com.larus.bmhome.video.save_share.a.a.a(r12, r15, r18, r34, "overview_click", r113, false, r114, r13, r14, r4, true, new i(r39, r40), 32);
        return Unit.INSTANCE;
    L72:
        r212 = null;
        goto L73
    L67:
        r211 = null;
    L63:
        r210 = null;
    L55:
        r28 = null;
        goto L56
    L49:
        r24 = "0";
    L45:
        r111 = null;
    L39:
        r110 = null;
    L33:
        r18 = null;
        goto L34
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
        LocalCreationChatItemClickHelper r41 = LocalCreationChatItemClickHelper.a;
        cz9.n r42 = this.this$0.f;
        if (r42 == null) goto L11;
        Message r43 = r42.e;
    L12:
        this.label = 1;
        r3 = LocalCreationChatItemClickHelper.g(r43, this);
        if (r3 != r1) goto L15;
        return r1;
    L11:
        r43 = null;
        goto L12
    }
}
