package com.larus.bmhome.instruction.suggest;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.suggest.PromptSelectActionDispatcher$doDispatch$2$3", f = "PromptSelectActionDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PromptSelectActionDispatcher$doDispatch$2$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ c this$0;

    public PromptSelectActionDispatcher$doDispatch$2$3(c r1, Continuation<? super PromptSelectActionDispatcher$doDispatch$2$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PromptSelectActionDispatcher$doDispatch$2$3(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L42;
        ResultKt.throwOnFailure(r4);
        c r5 = this.this$0;
        String r0 = r5.b.getSuggestActionType();
        if (r0 == null) goto L35;
        int r1 = r0.hashCode();
        if (r1 == (-1854658143)) goto L20;
        if (r1 == 2060894) goto L17;
        if (r1 != 574713598) goto L35;
        if (r0.equals("IMAGE_TEMPLATE") == false) goto L35;
    L40:
        return Unit.INSTANCE;
    L17:
        if (r0.equals("CALL") == false) goto L35;
    L43:
        String r2 = r5.b.getSchemaUrl();     // Catch: Exception -> L34
        if (r2 == null) goto L40;
        String r3 = UriProtector.getQueryParameter(UriProtector.parse(r2), "bot_say_hello_text_key");     // Catch: Exception -> L34
        if (r3 != null) goto L27;
    L30:
        boolean r6 = true;
    L31:
        if (r6 == false) goto L40;
        eq8.a r7 = r5.e;     // Catch: Exception -> L34
        int r8 = eq8.a.d;     // Catch: Exception -> L34
        r7.c("handleMainBotCall", "bot_say_hello_text_key is null", null);     // Catch: Exception -> L34
        goto L40
    L27:
        if (r3.length() == 0) goto L30;
        r6 = false;
    L34:
        Unit r9 = Unit.INSTANCE;
        goto L40
    L20:
        if (r0.equals("SCHEMA") == true) goto L43;
    L35:
        eq8.a r10 = r5.e;
        JSONObject r11 = new JSONObject();
        String r12 = r5.b.getSchemaUrl();
        if (r12 != null) goto L38;
        r12 = "";
    L38:
        r11.put("invalid_schema", r12);
        Unit r13 = Unit.INSTANCE;
        r10.c("openSchema", "invalid openSchema", r11);
        goto L40
    L42:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
