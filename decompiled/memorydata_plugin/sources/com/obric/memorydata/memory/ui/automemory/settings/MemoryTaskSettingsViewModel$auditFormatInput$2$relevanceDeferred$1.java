package com.obric.memorydata.memory.ui.automemory.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$auditFormatInput$2$relevanceDeferred$1", f = "MemoryTaskSettingsActivity.kt", i = {}, l = {1257}, m = "invokeSuspend", n = {}, s = {})
final class MemoryTaskSettingsViewModel$auditFormatInput$2$relevanceDeferred$1 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $candidateText;
    final /* synthetic */ String $kind;
    final /* synthetic */ String $sectionTitle;
    final /* synthetic */ String $taskTitle;
    Object L$0;
    int label;
    final /* synthetic */ MemoryTaskSettingsViewModel this$0;

    MemoryTaskSettingsViewModel$auditFormatInput$2$relevanceDeferred$1(MemoryTaskSettingsViewModel r3, String r4, String r5, String r6, String r7, Continuation<? super MemoryTaskSettingsViewModel$auditFormatInput$2$relevanceDeferred$1> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$kind = r4;
        this.$sectionTitle = r5;
        this.$taskTitle = r6;
        this.$candidateText = r7;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryTaskSettingsViewModel$auditFormatInput$2$relevanceDeferred$1(this.this$0, this.$kind, this.$sectionTitle, this.$taskTitle, this.$candidateText, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
        return ((MemoryTaskSettingsViewModel$auditFormatInput$2$relevanceDeferred$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryTaskSettingsViewModel$auditFormatInput$2$relevanceDeferred$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        MemoryTaskSettingsViewModel r7 = (MemoryTaskSettingsViewModel) ZeusTransformUtils.preCheckCast(this.L$0, MemoryTaskSettingsViewModel.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L13:
        return Boxing.boxBoolean(MemoryTaskSettingsViewModel.access$parseAuditPassed(r7, (JSONObject) ZeusTransformUtils.preCheckCast(r8, JSONObject.class, "com.obric.memorydata.plugin")));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        MemoryTaskSettingsViewModel r9 = this.this$0;
        JSONObject r2 = new JSONObject().put(MemoryInfoSectionEditActivity.EXTRA_KIND, this.$kind).put("section_title", this.$sectionTitle).put("task_title", this.$taskTitle).put("existing_items", new JSONArray()).put("candidate_text", this.$candidateText);
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r9;
        this.label = 1;
        Object r10 = MemoryTaskSettingsViewModel.access$runAlgoTask(r9, "auto_memory_pro_rule_relevance_audit", r2, r4);
        if (r10 != r0) goto L11;
        return r0;
    L11:
        r8 = r10;
        r7 = r9;
        goto L13
    }
}
