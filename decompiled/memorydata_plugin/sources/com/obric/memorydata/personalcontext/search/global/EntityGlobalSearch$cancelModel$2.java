package com.obric.memorydata.personalcontext.search.global;

import com.google.protobuf.DescriptorProtos;
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
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.global.EntityGlobalSearch$cancelModel$2", f = "EntityGlobalSearch.kt", i = {}, l = {991, DescriptorProtos.Edition.EDITION_PROTO2_VALUE}, m = "invokeSuspend", n = {}, s = {})
final class EntityGlobalSearch$cancelModel$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callPkg;
    final /* synthetic */ String[] $excludeLoraList;
    final /* synthetic */ String[] $excludeModelList;
    final /* synthetic */ boolean $loadLora;
    int label;

    EntityGlobalSearch$cancelModel$2(String r3, boolean r4, String[] r5, String[] r6, Continuation<? super EntityGlobalSearch$cancelModel$2> r7) {
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
        return (Continuation) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$cancelModel$2(this.$callPkg, this.$loadLora, this.$excludeModelList, this.$excludeLoraList, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((EntityGlobalSearch$cancelModel$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EntityGlobalSearch$cancelModel$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L39:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L13:
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.preCheckCast(r15.get("model"), List.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L23;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        String[] r6 = this.$excludeModelList;
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r3.iterator();
    L17:
        if (r4.hasNext() == false) goto L21;
        Object r8 = r4.next();
        if ((!ArraysKt.contains(r6, (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin"))) == false) goto L17;
        r7.add(r8);
        goto L17
    L21:
        String[] r5 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L23;
    L24:
        String[] r9 = r5;
        List r16 = (List) ZeusTransformUtils.preCheckCast(r15.get("lora"), List.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L34;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        String[] r10 = this.$excludeLoraList;
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r17.iterator();
    L28:
        if (r18.hasNext() == false) goto L32;
        Object r12 = r18.next();
        if ((!ArraysKt.contains(r10, (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin"))) == false) goto L28;
        r11.add(r12);
        goto L28
    L32:
        String[] r19 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L34;
    L35:
        String[] r13 = r19;
        com.obric.memorydata.aikernelcore.a r20 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        String r110 = this.$callPkg;
        boolean r111 = this.$loadLora;
        Continuation<? super Unit> r112 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (r20.a("global_search", r9, r13, r110, r111, r112) != r0) goto L39;
        return r0;
    L34:
        r19 = new String[0];
    L23:
        r5 = new String[0];
        goto L24
    L10:
        ResultKt.throwOnFailure(r14);
        com.obric.memorydata.aikernelcore.a r113 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        Continuation<? super Map<String, ? extends List<String>>> r21 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r14 = r113.a("personal_context_kg_retrieval", r21);
        if (r14 != r0) goto L13;
        return r0;
    }
}
