package com.obric.aiagent.messenger.stub;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.FlowUIIDLStub$openChatActivity$1", f = "FlowUIIDLStub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowUIIDLStub$openChatActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $windowMode;
    int label;
    final /* synthetic */ FlowUIIDLStub this$0;

    public FlowUIIDLStub$openChatActivity$1(int r1, FlowUIIDLStub r2, Continuation<? super FlowUIIDLStub$openChatActivity$1> r3) {
        this.$windowMode = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowUIIDLStub$openChatActivity$1(this.$windowMode, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r21);
        FLogger r1 = FLogger.a;
        r1.i("FlowUIIDLStub", "openChatActivity: windowMode=" + this.$windowMode);
        Intent r2 = new Intent();
        if (AccountService.a.isLogin().booleanValue() == true) goto L8;
        AppHost.Companion r6 = AppHost.a;
        r2.setComponent(new ComponentName(r6.getApplication(), HomeServiceV2.a.a()));
        r2.setFlags(335577088);
        r6.getApplication().startActivity(r2);
        r1.i("FlowUIIDLStub", "noLoin, launch chat activity");
        return Unit.INSTANCE;
    L8:
        Bundle r11 = FlowUIIDLStub.access$buildAgentChatLaunchExtras(this.this$0, this.$windowMode);
        if (FlowUIIDLStub.access$shouldOpenAgentChatWindow(this.this$0, this.$windowMode) == false) goto L15;
        r1.i("FlowUIIDLStub", "launch chat window, windowMode=" + this.$windowMode);
        IAssistantChatWindow r7 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r7 == null) goto L14;
        IAssistantChatWindow.DefaultImpls.openChatWindow$default(r7, "agent", false, null, r11, false, false, null, null, false, false, 1008, null);
    L14:
        return Unit.INSTANCE;
    L15:
        r2.putExtras(r11);
        AppHost.Companion r8 = AppHost.a;
        r2.setComponent(new ComponentName(r8.getApplication(), HomeService.a.r()));
        r2.setFlags(335577088);
        r8.getApplication().startActivity(r2);
        r1.i("FlowUIIDLStub", "launch chat activity");
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
