package com.larus.bmhome.view.actionbar.bot;

import com.larus.bmhome.chat.api.ActionBarApi;
import com.larus.bmhome.chat.api.ActionBarTempData;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/api/ActionBarTempData;", "Lcom/larus/bmhome/chat/api/ActionBarApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.bot.ActionBarViewModel$executeApiCall$2$result$1", f = "ActionBarViewModel.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class ActionBarViewModel$executeApiCall$2$result$1 extends SuspendLambda implements Function2<ActionBarApi, Continuation<? super BizResponse<ActionBarTempData>>, Object> {
    final /* synthetic */ Boolean $isColdStart;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ActionBarViewModel this$0;

    public ActionBarViewModel$executeApiCall$2$result$1(ActionBarViewModel r1, Boolean r2, Continuation<? super ActionBarViewModel$executeApiCall$2$result$1> r3) {
        this.this$0 = r1;
        this.$isColdStart = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ActionBarViewModel$executeApiCall$2$result$1 r0 = new ActionBarViewModel$executeApiCall$2$result$1(this.this$0, this.$isColdStart, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(ActionBarApi r1, Continuation<? super BizResponse<ActionBarTempData>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ActionBarApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        ActionBarApi r3 = (ActionBarApi) this.L$0;
        long r4 = this.this$0.getCursor();
        String r7 = ActionBarViewModel.access$getLang$p(this.this$0);
        Boolean r8 = this.$isColdStart;
        this.label = 1;
        r11 = r3.getTemplates(r4, 20, r7, r8, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
