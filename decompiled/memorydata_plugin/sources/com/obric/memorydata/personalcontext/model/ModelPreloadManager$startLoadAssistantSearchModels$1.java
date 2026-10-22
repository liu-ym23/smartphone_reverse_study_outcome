package com.obric.memorydata.personalcontext.model;

import com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.personalcontext.q;
import com.obric.memorydata.personalcontext.search.global.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
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
@DebugMetadata(c = "com.obric.memorydata.personalcontext.model.ModelPreloadManager$startLoadAssistantSearchModels$1", f = "ModelPreloadManager.kt", i = {1, 1, 2, 2}, l = {50, 56, 67, 81}, m = "invokeSuspend", n = {"searchAppEntityModelNameList", "searchAppEntityLoraList", "allModelNameList", "allLoraNameList"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class ModelPreloadManager$startLoadAssistantSearchModels$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $loadLora;
    Object L$0;
    Object L$1;
    int label;

    ModelPreloadManager$startLoadAssistantSearchModels$1(boolean r3, Continuation<? super ModelPreloadManager$startLoadAssistantSearchModels$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$loadLora = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ModelPreloadManager$startLoadAssistantSearchModels$1(this.$loadLora, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ModelPreloadManager$startLoadAssistantSearchModels$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ModelPreloadManager$startLoadAssistantSearchModels$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        Iterator r3 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$0, Iterator.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r21);
    L38:
        if (r3.hasNext() == false) goto L43;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        MemoryScriptEngineEnv r5 = MemoryScriptEngineEnv.INSTANCE;
        this.L$0 = r3;
        this.L$1 = null;
        this.label = 4;
        if (r5.preloadPkg(r4, this) != r1) goto L38;
        return r1;
    L43:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        String[] r6 = (String[]) ZeusTransformUtils.preCheckCast(this.L$1, String[].class, "com.obric.memorydata.plugin");
        String[] r7 = (String[]) ZeusTransformUtils.preCheckCast(this.L$0, String[].class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r21);
    L36:
        f.f12331a.a(AppInfo.OAssistant.getPackageName(), this.$loadLora, r7, r6);
        r3 = ((Iterable) ZeusTransformUtils.preCheckCast(a.f12232a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        goto L38
    L12:
        List r8 = (List) ZeusTransformUtils.preCheckCast(this.L$1, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r21);
        List r10 = r9;
        Object r11 = r21;
    L26:
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.preCheckCast(r12.get("model"), List.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L29;
        r13 = CollectionsKt.emptyList();
    L29:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r12.get("lora"), List.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L32;
        r14 = CollectionsKt.emptyList();
    L32:
        String[] r15 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(ArraysKt.toSet(ArraysKt.plus(ArraysKt.plus(((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), ((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0])), q.f12255a.r())), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        r6 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(ArraysKt.toSet(ArraysKt.plus(ArraysKt.plus(((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), ((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0])), q.f12255a.s())), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        com.obric.memorydata.aikernelcore.a r16 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        String r17 = AppInfo.OAssistant.getPackageName();
        boolean r18 = this.$loadLora;
        Continuation r19 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r15;
        this.L$1 = r6;
        this.label = 3;
        if (com.obric.memorydata.aikernelcore.a.a(r16, "assistant_search", r15, r6, r17, null, r18, r19, 16, null) != r1) goto L35;
        return r1;
    L35:
        r7 = r15;
        goto L36
    L13:
        ResultKt.throwOnFailure(r21);
        Object r20 = r21;
    L17:
        Map r22 = (Map) ZeusTransformUtils.preCheckCast(r20, Map.class, "com.obric.memorydata.plugin");
        r10 = (List) ZeusTransformUtils.preCheckCast(r22.get("model"), List.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L20;
        r10 = CollectionsKt.emptyList();
    L20:
        r8 = (List) ZeusTransformUtils.preCheckCast(r22.get("lora"), List.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L23;
        r8 = CollectionsKt.emptyList();
    L23:
        com.obric.memorydata.aikernelcore.a r110 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        Continuation<? super Map<String, ? extends List<String>>> r111 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r10;
        this.L$1 = r8;
        this.label = 2;
        r11 = r110.a("in_app_search_photo", r111);
        if (r11 != r1) goto L26;
        return r1;
    L14:
        ResultKt.throwOnFailure(r21);
        com.obric.memorydata.aikernelcore.a r23 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        Continuation<? super Map<String, ? extends List<String>>> r112 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r20 = r23.a("search_app_entity", r112);
        if (r20 != r1) goto L17;
        return r1;
    }
}
