package com.obric.memorydata.personalcontext.model;

import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.personalcontext.q;
import com.obric.memorydata.personalcontext.search.global.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.model.ModelPreloadManager$cancelUseAssistantSearchModels$1", f = "ModelPreloadManager.kt", i = {1, 1, 2, 2}, l = {94, 100, 112}, m = "invokeSuspend", n = {"searchAppEntityModelNameList", "searchAppEntityLoraList", "allModelNameList", "allLoraNameList"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class ModelPreloadManager$cancelUseAssistantSearchModels$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $loadLora;
    Object L$0;
    Object L$1;
    int label;

    ModelPreloadManager$cancelUseAssistantSearchModels$1(boolean r3, Continuation<? super ModelPreloadManager$cancelUseAssistantSearchModels$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$loadLora = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ModelPreloadManager$cancelUseAssistantSearchModels$1(this.$loadLora, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ModelPreloadManager$cancelUseAssistantSearchModels$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ModelPreloadManager$cancelUseAssistantSearchModels$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        String[] r3 = (String[]) ZeusTransformUtils.preCheckCast(this.L$1, String[].class, "com.obric.memorydata.plugin");
        String[] r4 = (String[]) ZeusTransformUtils.preCheckCast(this.L$0, String[].class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L34:
        f.f12331a.b(AppInfo.OAssistant.getPackageName(), this.$loadLora, r4, r3);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        List r5 = (List) ZeusTransformUtils.preCheckCast(this.L$1, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
        List r7 = r6;
        Object r8 = r17;
    L24:
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.preCheckCast(r9.get("model"), List.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L27;
        r10 = CollectionsKt.emptyList();
    L27:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r9.get("lora"), List.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L30;
        r11 = CollectionsKt.emptyList();
    L30:
        String[] r12 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(ArraysKt.toSet(ArraysKt.plus(ArraysKt.plus(((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), ((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0])), q.f12255a.r())), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        String[] r13 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(ArraysKt.toSet(ArraysKt.plus(ArraysKt.plus(((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), ((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0])), q.f12255a.s())), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        com.obric.memorydata.aikernelcore.a r14 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        String r15 = AppInfo.OAssistant.getPackageName();
        boolean r16 = this.$loadLora;
        Continuation<? super Unit> r18 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r12;
        this.L$1 = r13;
        this.label = 3;
        if (r14.a("assistant_search", r12, r13, r15, r16, r18) != r1) goto L33;
        return r1;
    L33:
        r3 = r13;
        r4 = r12;
        goto L34
    L11:
        ResultKt.throwOnFailure(r17);
        Object r19 = r17;
    L15:
        Map r20 = (Map) ZeusTransformUtils.preCheckCast(r19, Map.class, "com.obric.memorydata.plugin");
        r7 = (List) ZeusTransformUtils.preCheckCast(r20.get("model"), List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L18;
        r7 = CollectionsKt.emptyList();
    L18:
        r5 = (List) ZeusTransformUtils.preCheckCast(r20.get("lora"), List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L21;
        r5 = CollectionsKt.emptyList();
    L21:
        com.obric.memorydata.aikernelcore.a r21 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        Continuation<? super Map<String, ? extends List<String>>> r110 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r7;
        this.L$1 = r5;
        this.label = 2;
        r8 = r21.a("in_app_search_photo", r110);
        if (r8 != r1) goto L24;
        return r1;
    L12:
        ResultKt.throwOnFailure(r17);
        com.obric.memorydata.aikernelcore.a r22 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        Continuation<? super Map<String, ? extends List<String>>> r23 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r19 = r22.a("search_app_entity", r23);
        if (r19 != r1) goto L15;
        return r1;
    }
}
