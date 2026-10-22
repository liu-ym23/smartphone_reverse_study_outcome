package com.bytedance.ai.uiu;

import com.bytedance.ai.uiu.objects.ConversionScene;
import com.bytedance.ai.uiu.objects.PageSetting;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager$getTargetPagesUiContext$1", f = "UIUContextManager.kt", i = {0, 0}, l = {60}, m = "invokeSuspend", n = {"jsonAry", "targetRunningPages"}, s = {"L$0", "L$1"})
final class UIUContextManager$getTargetPagesUiContext$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $callback;
    final /* synthetic */ ConversionScene $csvScene;
    final /* synthetic */ PageSetting $pageSetting;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public UIUContextManager$getTargetPagesUiContext$1(ConversionScene r1, PageSetting r10, Function1<? super String, Unit> r11, Continuation<? super UIUContextManager$getTargetPagesUiContext$1> r12) {
        this.$csvScene = r1;
        this.$pageSetting = r10;
        this.$callback = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        UIUContextManager$getTargetPagesUiContext$1 r0 = new UIUContextManager$getTargetPagesUiContext$1(this.$csvScene, this.$pageSetting, this.$callback, r11);
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
        Set r11 = (Set) this.L$1;
        JSONArray r12 = (JSONArray) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L38
        r1 = r12;
    L19:
        List r15 = (List) r14;     // Catch: Exception -> L38
        com.bytedance.ai.utils.g.a.d(a.b, "UIU pageContexts: " + r15);     // Catch: Exception -> L38
        Iterator r16 = r15.iterator();     // Catch: Exception -> L38
    L20:
        if (r16.hasNext() == false) goto L40;
        Object r13 = r16.next();     // Catch: Exception -> L38
        int r17 = r10 + 1;     // Catch: Exception -> L38
        if (r10 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L38
    L25:
        String r18 = (String) r13;     // Catch: Exception -> L38
        k2.i r19 = (k2.i) ListProtector.get(CollectionsKt.toList(r11), r10);     // Catch: Exception -> L38
        JSONObject r20 = new JSONObject();     // Catch: Exception -> L38
        r20.put("cardId", r19.getPageID());     // Catch: Exception -> L38
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L28
        Object r22 = Result.constructor-impl(new JSONObject(r18));     // Catch: Throwable -> L28
    L30:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Exception -> L38
        if (r23 == null) goto L33;
        com.bytedance.ai.utils.g.a.e(a.b, "Convert pages " + r19.getPageID() + " ui context e:" + r23);     // Catch: Exception -> L38
        Unit r24 = Unit.INSTANCE;     // Catch: Exception -> L38
    L33:
        JSONObject r25 = new JSONObject();     // Catch: Exception -> L38
        if (Result.isFailure-impl(r22) == false) goto L36;
        r22 = r25;
    L36:
        r20.put("cardContext", r22);     // Catch: Exception -> L38
        r1.put(r20);     // Catch: Exception -> L38
        r10 = r17;
        goto L20
    L28:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Exception -> L38
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L38
    L40:
        Function1<String, Unit> r110 = this.$callback;
        JSONObject r27 = new JSONObject();
        r27.put("pageInfo", r1);
        r110.invoke(b.a(r27.toString()));
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        JSONArray r28 = new JSONArray();
        a r29 = a.a;     // Catch: Exception -> L38
        Set r112 = a.b(this.$csvScene, this.$pageSetting);     // Catch: Exception -> L38
        Set r30 = r112;     // Catch: Exception -> L38
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));     // Catch: Exception -> L38
        Iterator r114 = r30.iterator();     // Catch: Exception -> L38
    L13:
        if (r114.hasNext() == false) goto L15;
        r113.add(BuildersKt.async$default(r111, null, null, new UIUContextManager$getTargetPagesUiContext$1$pageContextTasks$1$1((k2.i) r114.next(), null), 3, null));     // Catch: Exception -> L38
        goto L13
    L15:
        Deferred[] r115 = (Deferred[]) r113.toArray(new Deferred[0]);     // Catch: Exception -> L38
        Deferred[] r116 = (Deferred[]) Arrays.copyOf(r115, r115.length);     // Catch: Exception -> L38
        this.L$0 = r28;     // Catch: Exception -> L38
        this.L$1 = r112;     // Catch: Exception -> L38
        this.label = 1;     // Catch: Exception -> L38
        r14 = AwaitKt.b(r116, this);     // Catch: Exception -> L38
        if (r14 != r0) goto L18;
        return r0;
    L18:
        r11 = r112;
        r1 = r28;
    L38:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e(a.b, "Get pages ui context e:" + e);
        goto L40
    }
}
