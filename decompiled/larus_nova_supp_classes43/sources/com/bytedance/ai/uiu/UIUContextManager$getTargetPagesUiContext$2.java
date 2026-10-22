package com.bytedance.ai.uiu;

import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager$getTargetPagesUiContext$2", f = "UIUContextManager.kt", i = {0, 0}, l = {110}, m = "invokeSuspend", n = {"jsonAry", "targetRunningPage"}, s = {"L$0", "L$1"})
final class UIUContextManager$getTargetPagesUiContext$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $callback;
    final /* synthetic */ String $cardId;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public UIUContextManager$getTargetPagesUiContext$2(Function1<? super String, Unit> r1, String r10, Continuation<? super UIUContextManager$getTargetPagesUiContext$2> r11) {
        this.$callback = r1;
        this.$cardId = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        UIUContextManager$getTargetPagesUiContext$2 r0 = new UIUContextManager$getTargetPagesUiContext$2(this.$callback, this.$cardId, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object r1 = this.label;
        int r10 = 0;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        Map r11 = (Map) this.L$1;
        JSONArray r12 = (JSONArray) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L54
        r1 = r12;
    L31:
        List r15 = (List) r14;     // Catch: Exception -> L54
        com.bytedance.ai.utils.g.a.d(a.b, "UIU pageContexts: " + r15);     // Catch: Exception -> L54
        Iterator r16 = r15.iterator();     // Catch: Exception -> L54
    L32:
        if (r16.hasNext() == false) goto L56;
        Object r13 = r16.next();     // Catch: Exception -> L54
        int r17 = r10 + 1;     // Catch: Exception -> L54
        if (r10 >= 0) goto L37;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L54
    L37:
        String r18 = (String) r13;     // Catch: Exception -> L54
        com.bytedance.ai.model.widgets.c r19 = (com.bytedance.ai.model.widgets.c) ((Pair) ListProtector.get(MapsKt.toList(r11), r10)).getSecond();     // Catch: Exception -> L54
        JSONObject r20 = new JSONObject();     // Catch: Exception -> L54
        if (com.bytedance.ai.utils.f.g(r19.getPageInfo().getMessageId()) == false) goto L40;
        String r21 = r19.getPageInfo().getMessageId();     // Catch: Exception -> L54
    L41:
        r20.put("cardId", r21);     // Catch: Exception -> L54
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L44
        Object r23 = Result.constructor-impl(new JSONObject(r18));     // Catch: Throwable -> L44
    L46:
        Throwable r24 = Result.exceptionOrNull-impl(r23);     // Catch: Exception -> L54
        if (r24 == null) goto L49;
        com.bytedance.ai.utils.g.a.d(a.b, "Convert pages " + r19.getPageInfo().getMessageId() + " uicontext e:" + r24);     // Catch: Exception -> L54
        Unit r25 = Unit.INSTANCE;     // Catch: Exception -> L54
    L49:
        JSONObject r26 = new JSONObject();     // Catch: Exception -> L54
        if (Result.isFailure-impl(r23) == false) goto L52;
        r23 = r26;
    L52:
        r20.put("cardContext", r23);     // Catch: Exception -> L54
        r1.put(r20);     // Catch: Exception -> L54
        r10 = r17;
        goto L32
    L44:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Exception -> L54
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L54
        goto L46
    L40:
        r21 = r19.getPageInfo().getPageId();     // Catch: Exception -> L54
    L56:
        Function1<String, Unit> r110 = this.$callback;
        JSONObject r28 = new JSONObject();
        r28.put("pageInfo", r1);
        r110.invoke(b.a(r28.toString()));
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        JSONArray r29 = new JSONArray();
        AppletRuntimeManager.INSTANCE.getClass();     // Catch: Exception -> L54
        LinkedHashMap<String, com.bytedance.ai.model.widgets.c> r30 = AppletRuntimeManager.b;     // Catch: Exception -> L54
        String r31 = this.$cardId;     // Catch: Exception -> L54
        LinkedHashMap r112 = new LinkedHashMap();     // Catch: Exception -> L54
        Iterator<Map.Entry<String, com.bytedance.ai.model.widgets.c>> r32 = r30.entrySet().iterator();     // Catch: Exception -> L54
    L13:
        if (r32.hasNext() == false) goto L23;
        Map.Entry<String, com.bytedance.ai.model.widgets.c> r33 = r32.next();     // Catch: Exception -> L54
        if (Intrinsics.areEqual(r33.getValue().getPageInfo().getMessageId(), r31) == false) goto L17;
    L20:
        boolean r34 = true;
    L21:
        if (r34 == false) goto L13;
        r112.put(r33.getKey(), r33.getValue());     // Catch: Exception -> L54
        goto L13
    L17:
        if (Intrinsics.areEqual(r33.getValue().getPageInfo().getPageId(), r31) == true) goto L20;
        r34 = false;
        goto L21
    L23:
        ArrayList r113 = new ArrayList(r112.size());     // Catch: Exception -> L54
        Iterator r114 = r112.entrySet().iterator();     // Catch: Exception -> L54
    L25:
        if (r114.hasNext() == false) goto L27;
        r113.add(BuildersKt.async$default(r111, null, null, new UIUContextManager$getTargetPagesUiContext$2$pageContextTasks$1$1((com.bytedance.ai.model.widgets.c) ((Map.Entry) r114.next()).getValue(), null), 3, null));     // Catch: Exception -> L54
        goto L25
    L27:
        Deferred[] r115 = (Deferred[]) r113.toArray(new Deferred[0]);     // Catch: Exception -> L54
        Deferred[] r116 = (Deferred[]) Arrays.copyOf(r115, r115.length);     // Catch: Exception -> L54
        this.L$0 = r29;     // Catch: Exception -> L54
        this.L$1 = r112;     // Catch: Exception -> L54
        this.label = 1;     // Catch: Exception -> L54
        r14 = AwaitKt.b(r116, this);     // Catch: Exception -> L54
        if (r14 != r0) goto L30;
        return r0;
    L30:
        r11 = r112;
        r1 = r29;
    L54:
        e = move-exception;
        com.bytedance.ai.utils.g.a.d(a.b, "Get pages ui context e:" + e);
        goto L56
    }
}
