package com.bytedance.ai.model;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.resource.AIManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.AppletRuntime$createPage$1", f = "AppletRuntime.kt", i = {}, l = {511}, m = "invokeSuspend", n = {}, s = {})
public final class AppletRuntime$createPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventType;
    final /* synthetic */ Function3<k2.j, Boolean, String, Unit> $jsCallback;
    final /* synthetic */ k2.j $page;
    final /* synthetic */ PageInfo $pageInfo;
    final /* synthetic */ String $realData;
    final /* synthetic */ String $realUrl;
    final /* synthetic */ String $traceId;
    int label;
    final /* synthetic */ AppletRuntime this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AppletRuntime$createPage$1(AppletRuntime r1, String r10, String r11, k2.j r12, Function3<? super k2.j, ? super Boolean, ? super String, Unit> r13, PageInfo r14, String r15, String r16, Continuation<? super AppletRuntime$createPage$1> r17) {
        this.this$0 = r1;
        this.$traceId = r10;
        this.$eventType = r11;
        this.$page = r12;
        this.$jsCallback = r13;
        this.$pageInfo = r14;
        this.$realData = r15;
        this.$realUrl = r16;
        super(2, r17);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new AppletRuntime$createPage$1(this.this$0, this.$traceId, this.$eventType, this.$page, this.$jsCallback, this.$pageInfo, this.$realData, this.$realUrl, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        ResultKt.throwOnFailure(r25);
        Object r11 = r25;
    L13:
        AIManager.a r12 = (AIManager.a) r11;
        if ((r12 instanceof AIManager.a.b) == false) goto L17;
        ((AIManager.a.b) r12).getClass();
    L33:
        k2.j r13 = this.$page;
        PageInfo r14 = new PageInfo(this.$pageInfo.getPageName(), this.$realData, this.$pageInfo.getContext(), this.$realUrl, this.$pageInfo.getPageType(), this.$pageInfo.getBotId(), this.$pageInfo.getPageId(), this.$pageInfo.getPageSettings(), null, this.$pageInfo.getPos(), this.$pageInfo.getAlignLeft(), this.$pageInfo.getReplyFor(), null, null, null, null, 61696, null);
        PageInfo r15 = this.$pageInfo;
        r14.setTraceInfo(r15.getTraceInfo());
        r14.setPackageName(r15.getPackageName());
        final Function3<k2.j, Boolean, String, Unit> r16 = this.$jsCallback;
        final k2.j r17 = this.$page;
        r13.createPage(r14, null, new s(r16, r17), new t(r16, r17));
        return Unit.INSTANCE;
    L17:
        if ((r12 instanceof AIManager.a.C0046a) == false) goto L32;
        AIManager.a.C0046a r18 = (AIManager.a.C0046a) r12;
        String r19 = r18.b;
        if (r19 != null) goto L21;
        r19 = "Applet page resources are not ready";
    L21:
        com.bytedance.ai.utils.g.a.e("WorkerRuntime", "createPage failed before resource ready. appletId=" + this.this$0.h.o() + ", errorCode=" + r18.a + ", errorMsg=" + r19);
        String r20 = this.$traceId;
        if (r20 == null) goto L26;
        String r21 = this.$eventType;
        if (r21 == null) goto L26;
        i1 r22 = y0.a;
        y0.b(r20, r19, r18.a, r21);
    L26:
        AppletRuntimeManager r23 = AppletRuntimeManager.INSTANCE;
        String r24 = this.$page.getPageID();
        r23.getClass();
        AppletRuntimeManager.m(r24);
        Function3<k2.j, Boolean, String, Unit> r26 = this.$jsCallback;
        if (r26 == null) goto L30;
        r26.invoke(null, Boxing.boxBoolean(false), r19);
    L30:
        return Unit.INSTANCE;
    L32:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r25);
        Applet r27 = this.this$0.h;
        if (r27.y != AIPackage.PackageStatus.BASE_READY) goto L33;
        AIManager r28 = AIManager.a;
        String r29 = r27.o();
        long r30 = this.this$0.h.c;
        this.label = 1;
        r11 = AIManager.h(r29, r30, this);
        if (r11 != r1) goto L13;
        return r1;
    }
}
