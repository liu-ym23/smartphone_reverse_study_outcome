package com.larus.bmhome.chat.helper;

import android.os.Bundle;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.helper.CocoSubConversationSettingMenuTrigger$doCreateSubConversation$1", f = "CocoSubConversationHelper.kt", i = {}, l = {418}, m = "invokeSuspend", n = {}, s = {})
final class CocoSubConversationSettingMenuTrigger$doCreateSubConversation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ wc9.e $cvs;
    final /* synthetic */ qy8.f $interceptor;
    final /* synthetic */ Bundle $modeExtraParams;
    final /* synthetic */ by7.e $trackNode;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CocoSubConversationSettingMenuTrigger this$0;

    public CocoSubConversationSettingMenuTrigger$doCreateSubConversation$1(qy8.f r1, CocoSubConversationSettingMenuTrigger r2, String r3, wc9.e r4, by7.e r5, Bundle r6, Continuation<? super CocoSubConversationSettingMenuTrigger$doCreateSubConversation$1> r7) {
        this.$interceptor = r1;
        this.this$0 = r2;
        this.$botId = r3;
        this.$cvs = r4;
        this.$trackNode = r5;
        this.$modeExtraParams = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CocoSubConversationSettingMenuTrigger$doCreateSubConversation$1 r8 = new CocoSubConversationSettingMenuTrigger$doCreateSubConversation$1(this.$interceptor, this.this$0, this.$botId, this.$cvs, this.$trackNode, this.$modeExtraParams, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L15
        Object r2 = r17;
    L13:
        Object r3 = Result.constructor-impl((Bundle) r2);     // Catch: Throwable -> L15
    L17:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L21;
        FLogger.a.e("CocoSubConversationSettingMenuTrigger", "getSubConversationFragmentBundle failed", r4);
    L21:
        if (Result.isFailure-impl(r3) == false) goto L23;
        r3 = null;
    L23:
        Bundle r5 = (Bundle) r3;
        if (r5 != null) goto L27;
        FLogger.a.w("CocoSubConversationSettingMenuTrigger", "createSubCvsInterceptor skip because chatBundle is null");
        return Unit.INSTANCE;
    L27:
        FLogger.a.i("CocoSubConversationSettingMenuTrigger", "createSubCvsInterceptor with resolved bundle");
        this.$interceptor.b(this.this$0.d, r5);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r17);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        CocoSubConversationSettingMenuTrigger r7 = this.this$0;
        String r8 = this.$botId;
        wc9.e r9 = this.$cvs;
        by7.e r10 = this.$trackNode;
        Bundle r11 = this.$modeExtraParams;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L15
        ChatRouterHelper r13 = ChatRouterHelper.a;     // Catch: Throwable -> L15
        String r14 = r7.g;     // Catch: Throwable -> L15
        String r15 = r7.h;     // Catch: Throwable -> L15
        ChatPassThroughParams r16 = (ChatPassThroughParams) r7.d.WF().a(ChatPassThroughParams.class);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r2 = ChatRouterHelper.g(r8, r9, null, r14, r15, null, true, true, r10, r16, r11, this, 85988);     // Catch: Throwable -> L15
        if (r2 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
