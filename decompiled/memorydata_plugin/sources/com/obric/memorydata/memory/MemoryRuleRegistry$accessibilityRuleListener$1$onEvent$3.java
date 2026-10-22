package com.obric.memorydata.memory;

import android.graphics.Bitmap;
import com.obric.memorydata.sdk.screencapture.ScreenData;
import com.obric.memorydata.sdk.screencapture.ViewTreeNode;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.MemoryRuleRegistry$accessibilityRuleListener$1$onEvent$3", f = "MemoryRuleRegistry.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
final class MemoryRuleRegistry$accessibilityRuleListener$1$onEvent$3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appName;
    final /* synthetic */ ScreenData $data;
    final /* synthetic */ ScreenEvent $event;
    final /* synthetic */ com.obric.memorydata.middleware.api.logging.e $logContext;
    final /* synthetic */ boolean $pageContextCaptureDisabled;
    final /* synthetic */ String $type;
    final /* synthetic */ boolean $useCloudModel;
    int label;

    MemoryRuleRegistry$accessibilityRuleListener$1$onEvent$3(ScreenEvent r3, String r4, ScreenData r5, String r6, boolean r7, boolean r8, com.obric.memorydata.middleware.api.logging.e r9, Continuation<? super MemoryRuleRegistry$accessibilityRuleListener$1$onEvent$3> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        this.$event = r3;
        this.$appName = r4;
        this.$data = r5;
        this.$type = r6;
        this.$useCloudModel = r7;
        this.$pageContextCaptureDisabled = r8;
        this.$logContext = r9;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryRuleRegistry$accessibilityRuleListener$1$onEvent$3(this.$event, this.$appName, this.$data, this.$type, this.$useCloudModel, this.$pageContextCaptureDisabled, this.$logContext, r9), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryRuleRegistry$accessibilityRuleListener$1$onEvent$3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryRuleRegistry$accessibilityRuleListener$1$onEvent$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r21);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        com.obric.memorydata.memory.utils.t r3 = com.obric.memorydata.memory.utils.t.f11563a;
        String r4 = this.$event.getPackageName();
        String r5 = this.$appName;
        Bitmap r6 = this.$data.getScreenshot();
        Intrinsics.checkNotNull(r6);
        String r7 = this.$type;
        List<ViewTreeNode> r8 = this.$data.getViewTree();
        boolean r9 = this.$useCloudModel;
        boolean r10 = this.$pageContextCaptureDisabled;
        com.obric.memorydata.middleware.api.logging.e r15 = this.$logContext;
        Continuation r17 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (com.obric.memorydata.memory.utils.t.a(r3, r4, r5, r6, r7, r8, r9, r10, null, null, null, null, r15, r17, 1920, null) != r1) goto L12;
        return r1;
    }
}
