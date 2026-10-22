package com.obric.memorydata.memory.ui.automemory.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/automemory/settings/AuditTaskResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity$auditRuleInput$2$relevanceDeferred$1", f = "MemoryInfoSectionEditActivity.kt", i = {}, l = {621}, m = "invokeSuspend", n = {}, s = {})
final class MemoryInfoSectionEditActivity$auditRuleInput$2$relevanceDeferred$1 extends SuspendLambda implements Function2<al, Continuation<? super a>, Object> {
    final /* synthetic */ String $candidateText;
    final /* synthetic */ String $kind;
    final /* synthetic */ e $memoryInfo;
    final /* synthetic */ List<String> $otherItems;
    Object L$0;
    int label;
    final /* synthetic */ MemoryInfoSectionEditActivity this$0;

    MemoryInfoSectionEditActivity$auditRuleInput$2$relevanceDeferred$1(MemoryInfoSectionEditActivity r3, String r4, e r5, List<String> r6, String r7, Continuation<? super MemoryInfoSectionEditActivity$auditRuleInput$2$relevanceDeferred$1> r8) {
        MemoryInfoSectionEditActivity r9 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r9;
        this.$kind = r4;
        this.$memoryInfo = r5;
        this.$otherItems = r10;
        this.$candidateText = r7;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryInfoSectionEditActivity$auditRuleInput$2$relevanceDeferred$1(this.this$0, this.$kind, this.$memoryInfo, this.$otherItems, this.$candidateText, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super a> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super a> r4) {
        return ((MemoryInfoSectionEditActivity$auditRuleInput$2$relevanceDeferred$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryInfoSectionEditActivity$auditRuleInput$2$relevanceDeferred$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        MemoryInfoSectionEditActivity r8 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.preCheckCast(this.L$0, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L13:
        return MemoryInfoSectionEditActivity.access$parseAuditTaskResult(r8, (JSONObject) ZeusTransformUtils.preCheckCast(r9, JSONObject.class, "com.obric.memorydata.plugin"));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        MemoryInfoSectionEditActivity r10 = this.this$0;
        JSONObject r2 = new JSONObject().put(MemoryInfoSectionEditActivity.EXTRA_KIND, this.$kind);
        MemoryInfoSectionEditActivity r4 = this.this$0;
        JSONObject r3 = r2.put("section_title", r4.getString(MemoryInfoSectionEditActivity.access$sectionTitleResId(r4, this.$kind))).put("task_title", this.$memoryInfo.a()).put("existing_items", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(this.$otherItems, Collection.class, "com.obric.memorydata.plugin"))).put("candidate_text", this.$candidateText);
        Intrinsics.checkNotNullExpressionValue(r3, "put(...)");
        Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r10;
        this.label = 1;
        Object r11 = MemoryInfoSectionEditActivity.access$runAlgoTask(r10, "auto_memory_pro_rule_relevance_audit", r3, r5);
        if (r11 != r0) goto L11;
        return r0;
    L11:
        r9 = r11;
        r8 = r10;
        goto L13
    }
}
