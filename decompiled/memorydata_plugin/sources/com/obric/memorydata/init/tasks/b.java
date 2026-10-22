package com.obric.memorydata.init.tasks;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001BQ\u0012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u000fR&\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/init/tasks/AiProactiveInitLifecycle;", "", "prepareDb", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "isBusinessEnabled", "Lkotlin/Function0;", "", "startBusiness", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "prepareDbAndStartBusinessIfEnabled", "enabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<Continuation<? super Unit>, Object> f9917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<Boolean> f9918b;
    private final Function1<Continuation<? super Unit>, Object> c;

    public b(Function1<? super Continuation<? super Unit>, ? extends Object> r3, Function0<Boolean> r4, Function1<? super Continuation<? super Unit>, ? extends Object> r5) {
        Function1<Continuation<? super Unit>, Object> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function1<Continuation<? super Unit>, Object> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "prepareDb");
        Intrinsics.checkNotNullParameter(r7, "isBusinessEnabled");
        Intrinsics.checkNotNullParameter(r8, "startBusiness");
        this.f9917a = r6;
        this.f9918b = r7;
        this.c = r8;
    }

    public final Object a(boolean r7, Continuation<? super Boolean> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, AiProactiveInitLifecycle$prepareDbAndStartBusinessIfEnabled$1.class) == false) goto L7;
        AiProactiveInitLifecycle$prepareDbAndStartBusinessIfEnabled$1 r0 = (AiProactiveInitLifecycle$prepareDbAndStartBusinessIfEnabled$1) ZeusTransformUtils.preCheckCast(r9, AiProactiveInitLifecycle$prepareDbAndStartBusinessIfEnabled$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
    L27:
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = r0.Z$0;
        b this = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L19:
        if (r7 == false) goto L29;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f9918b.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L29;
        Function1<Continuation<? super Unit>, Object> r6 = this.c;
        r0.L$0 = null;
        r0.label = 2;
        if (r6.invoke(r0) != r2) goto L27;
        return r2;
    L29:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r10);
        Function1<Continuation<? super Unit>, Object> r11 = this.f9917a;
        r0.L$0 = this;
        r0.Z$0 = r7;
        r0.label = 1;
        if (r11.invoke(r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new AiProactiveInitLifecycle$prepareDbAndStartBusinessIfEnabled$1(this, r9);
        goto L8
    }
}
