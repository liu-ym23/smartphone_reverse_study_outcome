package com.obric.memorydata.personalcontext.model;

import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.q;
import com.obric.memorydata.personalcontext.search.d;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.model.ModelPreloadManager$cancelUseInAppSearchModels$1", f = "ModelPreloadManager.kt", i = {}, l = {187, 198}, m = "invokeSuspend", n = {}, s = {})
final class ModelPreloadManager$cancelUseInAppSearchModels$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $loadLora;
    final /* synthetic */ String $packageName;
    Object L$0;
    boolean Z$0;
    int label;

    ModelPreloadManager$cancelUseInAppSearchModels$1(String r3, boolean r4, Continuation<? super ModelPreloadManager$cancelUseInAppSearchModels$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$packageName = r3;
        this.$loadLora = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ModelPreloadManager$cancelUseInAppSearchModels$1(this.$packageName, this.$loadLora, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ModelPreloadManager$cancelUseInAppSearchModels$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ModelPreloadManager$cancelUseInAppSearchModels$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L33:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        boolean r2 = this.Z$0;
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
        boolean r11 = r2;
        String r10 = r4;
    L23:
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.preCheckCast(r15.get("model"), List.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L26;
        r3 = CollectionsKt.emptyList();
    L26:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r15.get("lora"), List.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L29;
        r16 = CollectionsKt.emptyList();
    L29:
        String[] r8 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(ArraysKt.toSet(ArraysKt.plus(((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), q.f12255a.r())), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        String[] r9 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(ArraysKt.toSet(ArraysKt.plus(((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), q.f12255a.s())), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        com.obric.memorydata.aikernelcore.a r6 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        String r7 = r10 + "_in_app_search";
        this.L$0 = null;
        this.label = 2;
        if (r6.a(r7, r8, r9, r10, r11, this) != r0) goto L33;
        return r0;
    L10:
        ResultKt.throwOnFailure(r14);
        if (Intrinsics.areEqual(this.$packageName, AppInfo.FileManager.getPackageName()) == false) goto L13;
    L16:
        Map<String, String> r17 = d.f12308a.a();
        String r5 = AppInfo.Gallery.getPackageName();
    L17:
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.get(r5), String.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ModelPreloadManager", "cancelPreloadModels packageName: " + this.$packageName + ", taskPackageName: " + r18, false, 4, null);
        if (r18 == null) goto L34;
        String r12 = this.$packageName;
        boolean r13 = this.$loadLora;
        com.obric.memorydata.aikernelcore.a r19 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        this.L$0 = r12;
        this.Z$0 = r13;
        this.label = 1;
        r14 = r19.a(r18, this);
        if (r14 != r0) goto L22;
        return r0;
    L22:
        r10 = r12;
        r11 = r13;
        goto L23
    L34:
        return null;
    L13:
        if (Intrinsics.areEqual(this.$packageName, AppInfo.QuickSearch.getPackageName()) == true) goto L16;
        r17 = d.f12308a.a();
        r5 = this.$packageName;
        goto L17
    }
}
