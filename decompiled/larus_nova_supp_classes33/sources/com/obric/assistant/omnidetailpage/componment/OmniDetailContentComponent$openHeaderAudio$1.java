package com.obric.assistant.omnidetailpage.componment;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.nestedfile.NestFileService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileInfo;
import com.obric.assistant.chat.IObricChatService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent$openHeaderAudio$1", f = "OmniDetailContentComponent.kt", i = {}, l = {716}, m = "invokeSuspend", n = {}, s = {})
final class OmniDetailContentComponent$openHeaderAudio$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ifa.a $attachment;
    final /* synthetic */ UplinkFileInfo $fileInfo;
    final /* synthetic */ String $identifier;
    final /* synthetic */ String $messageId;
    final /* synthetic */ View $view;
    int label;
    final /* synthetic */ OmniDetailContentComponent this$0;

    public OmniDetailContentComponent$openHeaderAudio$1(OmniDetailContentComponent r1, String r2, View r3, ifa.a r4, String r5, UplinkFileInfo r6, Continuation<? super OmniDetailContentComponent$openHeaderAudio$1> r7) {
        this.this$0 = r1;
        this.$messageId = r2;
        this.$view = r3;
        this.$attachment = r4;
        this.$identifier = r5;
        this.$fileInfo = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new OmniDetailContentComponent$openHeaderAudio$1(this.this$0, this.$messageId, this.$view, this.$attachment, this.$identifier, this.$fileInfo, r10);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        Message r6 = (Message) r12;
        if (r6 != null) goto L15;
        OmniDetailContentComponent r13 = this.this$0;
        View r2 = this.$view;
        ifa.a r3 = this.$attachment;
        int r4 = OmniDetailContentComponent.I;
        r13.getClass();
        OmniDetailContentComponent.c4(r2, r3, "entry message not found");
        return Unit.INSTANCE;
    L15:
        NestFileService r5 = NestFileService.b;
        String r7 = this.$identifier;
        OmniDetailContentComponent r14 = this.this$0;
        ifa.a r8 = this.$attachment;
        int r9 = OmniDetailContentComponent.I;
        r14.getClass();
        String r10 = OmniDetailContentComponent.Q3(r8);
        Context r11 = this.$view.getContext();
        UplinkFileInfo r15 = this.$fileInfo;
        ifa.e r16 = this.this$0.V3();
        if (r16 == null) goto L24;
        String r17 = r16.f;
        if (r17 == null) goto L24;
        if ((!StringsKt.isBlank(r17)) == true) goto L23;
        r17 = null;
    L23:
        if (r17 == null) goto L24;
    L29:
        String r18 = r17;
    L31:
        r5.g(r7, r10, r6, r11, r15, r18, (OmniDetailContentComponent.b) this.this$0.A.getValue());
        return Unit.INSTANCE;
    L24:
        IObricChatService.a.getClass();
        IObricChatService r19 = IObricChatService.a.a();
        if (r19 == null) goto L30;
        BotModel r110 = r19.j0();
        if (r110 == null) goto L30;
        r17 = r110.getBotId();
    L30:
        r18 = null;
        goto L31
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        OmniDetailContentComponent r111 = this.this$0;
        String r20 = this.$messageId;
        this.label = 1;
        r12 = OmniDetailContentComponent.p3(r111, r20, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}
