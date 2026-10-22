package com.obric.memorydata.personalcontext.model;

import com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.q;
import com.obric.memorydata.personalcontext.search.d;
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
@DebugMetadata(c = "com.obric.memorydata.personalcontext.model.ModelPreloadManager$startLoadInAppSearchModels$1", f = "ModelPreloadManager.kt", i = {0, 1}, l = {142, 153, 160, 163}, m = "invokeSuspend", n = {"taskPackageName", "taskPackageName"}, s = {"L$0", "L$0"})
final class ModelPreloadManager$startLoadInAppSearchModels$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $loadLora;
    final /* synthetic */ String $packageName;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;

    ModelPreloadManager$startLoadInAppSearchModels$1(String r3, boolean r4, Continuation<? super ModelPreloadManager$startLoadInAppSearchModels$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$packageName = r3;
        this.$loadLora = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ModelPreloadManager$startLoadInAppSearchModels$1(this.$packageName, this.$loadLora, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ModelPreloadManager$startLoadInAppSearchModels$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ModelPreloadManager$startLoadInAppSearchModels$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r19) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L10;
        Iterator r1 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$0, Iterator.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);
    L35:
        if (r1.hasNext() == false) goto L40;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        MemoryScriptEngineEnv r3 = MemoryScriptEngineEnv.INSTANCE;
        this.L$0 = r1;
        this.label = 4;
        if (r3.preloadPkg(r2, this) != r11) goto L35;
        return r11;
    L40:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r19);
    L33:
        r1 = ((Iterable) ZeusTransformUtils.preCheckCast(a.f12232a.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        goto L35
    L12:
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);
    L30:
        MemoryScriptEngineEnv r5 = MemoryScriptEngineEnv.INSTANCE;
        this.L$0 = null;
        this.label = 3;
        if (r5.preloadPkg(r4, this) != r11) goto L33;
        return r11;
    L13:
        boolean r6 = this.Z$0;
        String r7 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);
        boolean r9 = r6;
        String r10 = r7;
        String r12 = r8;
        Object r13 = r19;
    L20:
        Map r14 = (Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.preCheckCast(r14.get("model"), List.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L23;
        r15 = CollectionsKt.emptyList();
    L23:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r14.get("lora"), List.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L26;
        r16 = CollectionsKt.emptyList();
    L26:
        String[] r17 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(ArraysKt.toSet(ArraysKt.plus(((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), q.f12255a.r())), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        String[] r18 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(ArraysKt.toSet(ArraysKt.plus(((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), q.f12255a.s())), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        com.obric.memorydata.aikernelcore.a r20 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        String r21 = r10 + "_in_app_search";
        this.L$0 = r12;
        this.L$1 = null;
        this.label = 2;
        String r110 = r12;
        if (com.obric.memorydata.aikernelcore.a.a(r20, r21, r17, r18, r10, null, r9, this, 16, null) != r11) goto L29;
        return r11;
    L29:
        r4 = r110;
        goto L30
    L14:
        ResultKt.throwOnFailure(r19);
        String r22 = (String) ZeusTransformUtils.preCheckCast(d.f12308a.a().get(this.$packageName), String.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ModelPreloadManager", "loadModels packageName: " + this.$packageName + ", taskPackageName: " + r22, false, 4, null);
        if (r22 == null) goto L33;
        String r23 = this.$packageName;
        boolean r24 = this.$loadLora;
        com.obric.memorydata.aikernelcore.a r25 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        this.L$0 = r22;
        this.L$1 = r23;
        this.Z$0 = r24;
        this.label = 1;
        r13 = r25.a(r22, this);
        if (r13 != r11) goto L19;
        return r11;
    L19:
        r12 = r22;
        r9 = r24;
        r10 = r23;
        goto L20
    }
}
