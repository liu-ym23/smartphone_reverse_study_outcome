package com.larus.voicecall.impl.utils;

import androidx.lifecycle.LiveData;
import com.larus.im.bean.bot.SceneModel;
import com.larus.network.http.HttpExtKt;
import com.obric.aivoice.core.data.NameKeys;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/voicecall/impl/utils/RealtimeCallSuggestManager$Repository$SuggestionData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.utils.RealtimeCallSuggestManager$Repository$getSuggestList$response$1", f = "RealtimeCallSuggestManager.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallSuggestManager$Repository$getSuggestList$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RealtimeCallSuggestManager.Repository.SuggestionData>, Object> {
    int label;
    final /* synthetic */ RealtimeCallSuggestManager.Repository this$0;

    public RealtimeCallSuggestManager$Repository$getSuggestList$response$1(RealtimeCallSuggestManager.Repository r1, Continuation<? super RealtimeCallSuggestManager$Repository$getSuggestList$response$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallSuggestManager$Repository$getSuggestList$response$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super RealtimeCallSuggestManager.Repository.SuggestionData> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L28:
        return ((com.larus.network.http.a) r14).b;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        RealtimeCallSuggestManager.Repository r5 = this.this$0;
        com.larus.voicecall.impl.component.scene.a r6 = r5.b;
        if (r6 != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r7 == false) goto L23;
        LiveData<com.larus.voicecall.impl.scene.m> r8 = r5.b.getCurrentScene();
        if (r8 == null) goto L23;
        com.larus.voicecall.impl.scene.m r9 = (com.larus.voicecall.impl.scene.m) r8.getValue();
        if (r9 == null) goto L23;
        SceneModel r10 = r9.a;
        if (r10 == null) goto L23;
        String r11 = r10.getKey();
        if (r11 == null) goto L23;
    L24:
        r4.put("app_scene", r11);
        r4.put("bot_id", ((h88.a) r5.a).d);
        r4.put("conversation_id", ((h88.a) r5.a).f);
        Unit r12 = Unit.INSTANCE;
        this.label = 1;
        r14 = HttpExtKt.k("Audio", RealtimeCallSuggestManager.Repository.SuggestionData.class, "/alice/call/get_suggestion", r4, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L28;
        return r0;
    L23:
        r11 = NameKeys.UnloadStrategy_No_Strategy;
        goto L24
    L11:
        if (r6.oY() != true) goto L13;
        r7 = true;
        goto L14
    }
}
