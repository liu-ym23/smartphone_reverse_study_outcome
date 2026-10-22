package com.bytedance.ai.model;

import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.AppletResourceTool;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.AppletRuntime$realUrl$1", f = "AppletRuntime.kt", i = {}, l = {447}, m = "invokeSuspend", n = {}, s = {})
final class AppletRuntime$realUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $packageName;
    final /* synthetic */ String $pageName;
    final /* synthetic */ PageInfo $this_realUrl;
    int label;

    public AppletRuntime$realUrl$1(String r1, String r10, PageInfo r11, Continuation<? super AppletRuntime$realUrl$1> r12) {
        this.$packageName = r1;
        this.$pageName = r10;
        this.$this_realUrl = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletRuntime$realUrl$1(this.$packageName, this.$pageName, this.$this_realUrl, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        Widget r11 = (Widget) r10;
        this.$this_realUrl.setWidget(true);
        if (r11 != null) goto L14;
        return null;
    L14:
        return AppletResourceTool.m(AppletResourceTool.a, r11, r11.L);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AIManager r12 = AIManager.a;
        String r13 = this.$packageName;
        String r14 = this.$pageName;
        this.label = 1;
        r10 = r12.E(r13, r14, null, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
