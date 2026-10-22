package com.bytedance.ai.model;

import android.util.LruCache;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.e0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.AppletRuntime$realUrl$1", f = "AppletRuntime.kt", i = {}, l = {397}, m = "invokeSuspend", n = {}, s = {})
final class AppletRuntime$realUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2216c;
    public final /* synthetic */ PageInfo d;

    public AppletRuntime$realUrl$1(String r5, String r10, PageInfo r11, Continuation r12) {
        this.f2215b = r5;
        this.f2216c = r10;
        this.d = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AppletRuntime$realUrl$1(this.f2215b, this.f2216c, this.d, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super String> r10) {
        return ((AppletRuntime$realUrl$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2214a;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        Widget r12 = (Widget) r10;
        this.d.setWidget(true);
        if (r12 == null) goto L15;
        LruCache r13 = e0.f2711a;
        return e0.d(r12, r12.G);
    L15:
        return null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        com.bytedance.ai.resource.j r14 = com.bytedance.ai.resource.j.f2734a;
        String r15 = this.f2215b;
        String r16 = this.f2216c;
        this.f2214a = 1;
        r10 = r14.d(r15, r16, null, this);
        if (r10 != r5) goto L11;
        return r5;
    }
}
