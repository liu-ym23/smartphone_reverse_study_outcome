package com.larus.business.markdown.impl;

import android.app.Application;
import android.content.Context;
import com.larus.business.markdown.api.depend.c;
import com.larus.business.markdown.api.depend.h;
import com.larus.business.markdown.api.extplugin.latex.a;
import com.larus.business.markdown.api.extplugin.latex.b;
import com.larus.business.markdown.impl.markwon.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.larus.business.markdown.impl.MarkdownServiceImpl$init$1$1", f = "MarkdownServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MarkdownServiceImpl$init$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $config;
    final /* synthetic */ Application $context;
    int label;
    final /* synthetic */ MarkdownServiceImpl this$0;

    MarkdownServiceImpl$init$1$1(Application r3, c r4, MarkdownServiceImpl r5, Continuation<? super MarkdownServiceImpl$init$1$1> r6) {
        Application r7 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$context = r7;
        this.$config = r8;
        this.this$0 = r5;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MarkdownServiceImpl$init$1$1(this.$context, this.$config, this.this$0, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MarkdownServiceImpl$init$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MarkdownServiceImpl$init$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        a r5 = b.a();
        if (r5 == null) goto L11;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(this.$context, Context.class, "com.obric.memorydata.plugin");
        h r1 = this.$config.a();
        if (r1 == null) goto L9;
        com.larus.business.markdown.api.model.a.a r2 = r1.a();
    L10:
        r5.a(r0, r2);
        goto L11
    L9:
        r2 = null;
    L11:
        e.f5244a.a(MarkdownServiceImpl.access$getMarkdownConfigManager(this.this$0), "");
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
