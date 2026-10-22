package com.ss.android.lark.flow.chat.message.system;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.compat.CallbackCompatRucketJob;
import com.larksuite.rucket.job.extension.EmptyResultException;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import h7b.i;
import java.util.List;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.system.FlowExecuteActionSystemActionHandler$addGroupChatMember$1", f = "FlowExecuteActionSystemActionHandler.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
final class FlowExecuteActionSystemActionHandler$addGroupChatMember$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ List<String> $chatterIds;
    final /* synthetic */ Context $context;
    final /* synthetic */ Fragment $fragment;
    int label;
    final /* synthetic */ FlowExecuteActionSystemActionHandler this$0;

    public FlowExecuteActionSystemActionHandler$addGroupChatMember$1(Context r1, Fragment r2, String r3, List<String> r4, FlowExecuteActionSystemActionHandler r5, Continuation<? super FlowExecuteActionSystemActionHandler$addGroupChatMember$1> r6) {
        this.$context = r1;
        this.$fragment = r2;
        this.$chatId = r3;
        this.$chatterIds = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FlowExecuteActionSystemActionHandler$addGroupChatMember$1(this.$context, this.$fragment, this.$chatId, this.$chatterIds, this.this$0, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        com.larksuite.rucket.job.base.b r7 = (com.larksuite.rucket.job.base.b) r6;
        ErrorResult r3 = r7.a();
        if ((r7 instanceof com.larksuite.rucket.job.base.b.c) == false) goto L16;
        return Unit.INSTANCE;
    L16:
        if ((r3 instanceof EmptyResultException) == true) goto L18;
        if (r3 != null) goto L23;
        return Unit.INSTANCE;
    L23:
        if (r3.getErrorCode() != 7006) goto L26;
        Boxing.boxBoolean(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.a(this.$context, ChatService.c.a, this.$fragment).a(r3, false));
    L40:
        return Unit.INSTANCE;
    L26:
        if (r3.getErrorCode() == 5020) goto L38;
        String r8 = r3.getDisplayMsg();
        if (r8 != null) goto L30;
    L33:
        if (r2 == true) goto L40;
        Context r9 = this.$context;
        String r4 = r3.getDisplayMsg();
        if (r4 != null) goto L37;
        r4 = "";
    L37:
        i.b(r9, null, r4);
        goto L40
    L30:
        if (r8.length() == 0) goto L33;
        r2 = false;
        goto L33
    L38:
        ChatCoreModule.a().getChatSettingDependency().b();
        goto L40
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        final String r5 = this.$chatId;
        final List<String> r10 = this.$chatterIds;
        CallbackCompatRucketJob r11 = com.larksuite.rucket.job.compat.f.a(new FlowExecuteActionSystemActionHandler$addGroupChatMember$1$response$1(r5, r10));
        this.label = 1;
        r6 = r11.awaitGet(this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
