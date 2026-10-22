package com.larus.bmhome.instruction.suggest;

import com.larus.bmhome.chat.bean.PromptContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.suggest.PromptSelectActionDispatcher$doDispatch$17", f = "PromptSelectActionDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PromptSelectActionDispatcher$doDispatch$17 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ c this$0;

    public PromptSelectActionDispatcher$doDispatch$17(c r1, Continuation<? super PromptSelectActionDispatcher$doDispatch$17> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PromptSelectActionDispatcher$doDispatch$17(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L46;
        ResultKt.throwOnFailure(r8);
        c r9 = this.this$0;
        PromptContent.CursorPosition r0 = r9.b.getCursorPosition();
        if (r0 == null) goto L7;
        Integer r1 = r0.getStartPos();
    L8:
        PromptContent.CursorPosition r2 = r9.b.getCursorPosition();
        if (r2 == null) goto L11;
        Integer r3 = r2.getEndPos();
    L12:
        if (r1 == null) goto L24;
        if (r3 == null) goto L24;
        if (r3.intValue() > r1.intValue()) goto L24;
        eq8.a r4 = r9.e;
        String r5 = "start:" + r1 + ",end:" + r3;
        JSONObject r6 = new JSONObject();
        String r7 = r9.b.getSuggestActionType();
        String r10 = "";
        if (r7 != null) goto L19;
        r7 = "";
    L19:
        r6.put("suggest_action_type", r7);
        String r11 = r9.g;
        if (r11 == null) goto L23;
        r10 = r11;
    L23:
        r6.put("user_prompt", r10);
        Unit r12 = Unit.INSTANCE;
        r4.c("check position", r5, r6);
    L24:
        String r13 = r9.g;
        if (r13 != null) goto L27;
    L30:
        boolean r14 = true;
    L32:
        if (r14 == false) goto L41;
        if (Intrinsics.areEqual(r9.b.getSuggestActionType(), "CALL") == true) goto L44;
        if (Intrinsics.areEqual(r9.b.getSuggestActionType(), "IMAGE_TEMPLATE") == true) goto L44;
        if (Intrinsics.areEqual(r9.b.getSuggestActionType(), "BOT_RECOMMEND") == true) goto L44;
        eq8.a r15 = r9.e;
        int r16 = eq8.a.d;
        r15.c("check userPrompt", "userPrompt is null", null);
    L44:
        return Unit.INSTANCE;
    L41:
        if (StringsKt.contains$default(r9.g, ":", false, 2, null) == false) goto L44;
        eq8.a.b(r9.e, "check userPrompt", "userPrompt has:");
        goto L44
    L27:
        if (r13.length() == 0) goto L30;
        r14 = false;
        goto L32
    L11:
        r3 = null;
        goto L12
    L7:
        r1 = null;
        goto L8
    L46:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
