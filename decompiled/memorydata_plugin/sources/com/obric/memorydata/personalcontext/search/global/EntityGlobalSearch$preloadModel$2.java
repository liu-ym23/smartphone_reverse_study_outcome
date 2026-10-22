package com.obric.memorydata.personalcontext.search.global;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.global.EntityGlobalSearch$preloadModel$2", f = "EntityGlobalSearch.kt", i = {}, l = {835, 842}, m = "invokeSuspend", n = {}, s = {})
final class EntityGlobalSearch$preloadModel$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callPkg;
    final /* synthetic */ String[] $excludeLoraList;
    final /* synthetic */ String[] $excludeModelList;
    final /* synthetic */ boolean $loadLora;
    int label;

    EntityGlobalSearch$preloadModel$2(String r3, boolean r4, String[] r5, String[] r6, Continuation<? super EntityGlobalSearch$preloadModel$2> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$callPkg = r3;
        this.$loadLora = r4;
        this.$excludeModelList = r5;
        this.$excludeLoraList = r6;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$preloadModel$2(this.$callPkg, this.$loadLora, this.$excludeModelList, this.$excludeLoraList, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((EntityGlobalSearch$preloadModel$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntityGlobalSearch$preloadModel$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r19);
    L39:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r19);
        Object r3 = r19;
    L13:
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(r4.get("model"), List.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L23;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        String[] r8 = this.$excludeModelList;
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r7.iterator();
    L17:
        if (r10.hasNext() == false) goto L21;
        Object r11 = r10.next();
        if ((!ArraysKt.contains(r8, (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin"))) == false) goto L17;
        r9.add(r11);
        goto L17
    L21:
        String[] r12 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L23;
    L24:
        String[] r13 = r12;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r4.get("lora"), List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L34;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        String[] r15 = this.$excludeLoraList;
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r14.iterator();
    L28:
        if (r17.hasNext() == false) goto L32;
        Object r18 = r17.next();
        if ((!ArraysKt.contains(r15, (String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.memorydata.plugin"))) == false) goto L28;
        r16.add(r18);
        goto L28
    L32:
        String[] r20 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L34;
    L35:
        String[] r110 = r20;
        com.obric.memorydata.aikernelcore.a r21 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        String r111 = this.$callPkg;
        boolean r112 = this.$loadLora;
        Continuation r113 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (com.obric.memorydata.aikernelcore.a.a(r21, "global_search", r13, r110, r111, null, r112, r113, 16, null) != r1) goto L39;
        return r1;
    L34:
        r20 = new String[0];
    L23:
        r12 = new String[0];
        goto L24
    L10:
        ResultKt.throwOnFailure(r19);
        com.obric.memorydata.aikernelcore.a r22 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        Continuation<? super Map<String, ? extends List<String>>> r23 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r3 = r22.a("personal_context_kg_retrieval", r23);
        if (r3 != r1) goto L13;
        return r1;
    }
}
