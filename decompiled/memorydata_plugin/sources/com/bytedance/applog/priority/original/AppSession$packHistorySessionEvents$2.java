package com.bytedance.applog.priority.original;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applog.priority.original.AppSession$packHistorySessionEvents$2", f = "AppSession.kt", i = {}, l = {157, 165, 174}, m = "invokeSuspend", n = {}, s = {})
final class AppSession$packHistorySessionEvents$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentSid;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ a this$0;

    AppSession$packHistorySessionEvents$2(a r3, String r4, Continuation<? super AppSession$packHistorySessionEvents$2> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$currentSid = r4;
        super(1, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AppSession$packHistorySessionEvents$2(this.this$0, this.$currentSid, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r3) {
        return ((AppSession$packHistorySessionEvents$2) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AppSession$packHistorySessionEvents$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r17) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L12;
        if (r2 != 3) goto L11;
        Iterator r3 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$1, Iterator.class, "com.obric.memorydata.plugin");
        a r5 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L15
    L28:
        if (r3.hasNext() == false) goto L33;
        d r9 = (d) ZeusTransformUtils.preCheckCast(r3.next(), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        this.L$0 = r5;     // Catch: Throwable -> L15
        this.L$1 = r3;     // Catch: Throwable -> L15
        this.label = 3;     // Catch: Throwable -> L15
        if (r5.a(r9, this) != r0) goto L28;
        return r0;
    L33:
        kotlinx.coroutines.sync.a.C0884a.b(a.b(this.this$0), null, 1, null);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        Iterator r4 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$1, Iterator.class, "com.obric.memorydata.plugin");
        a r10 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L15
    L23:
        if (r4.hasNext() == false) goto L27;
        b r11 = (b) ZeusTransformUtils.preCheckCast(r4.next(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        this.L$0 = r10;     // Catch: Throwable -> L15
        this.L$1 = r4;     // Catch: Throwable -> L15
        this.label = 2;     // Catch: Throwable -> L15
        if (a.a(r10, r11, false, this, 2, null) != r0) goto L23;
        return r0;
    L27:
        final List<d> r6 = a.a(this.this$0).c(this.$currentSid);     // Catch: Throwable -> L15
        com.bytedance.applog.log.a r7 = this.this$0.getContext().b();     // Catch: Throwable -> L15
        final a r12 = this.this$0;     // Catch: Throwable -> L15
        r7.a("AppSession:packHistoryTerminates", (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r12, r6), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        r5 = this.this$0;     // Catch: Throwable -> L15
        r3 = r8.iterator();     // Catch: Throwable -> L15
        goto L28
    L17:
        ResultKt.throwOnFailure(r17);
    L21:
        final List<b> r13 = a.a(this.this$0).d();     // Catch: Throwable -> L15
        com.bytedance.applog.log.a r14 = this.this$0.getContext().b();     // Catch: Throwable -> L15
        final a r15 = this.this$0;     // Catch: Throwable -> L15
        r14.a("AppSession:packHistorySessionEvents", (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r15, r13), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        r10 = this.this$0;     // Catch: Throwable -> L15
        r4 = r16.iterator();     // Catch: Throwable -> L15
        goto L23
    L18:
        ResultKt.throwOnFailure(r17);
        kotlinx.coroutines.sync.a r18 = a.b(this.this$0);
        Continuation r19 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (kotlinx.coroutines.sync.a.C0884a.a(r18, null, r19, 1, null) != r0) goto L21;
        return r0;
    L15:
        th = move-exception;
        com.bytedance.applog.log.a r20 = this.this$0.getContext().b();     // Catch: Throwable -> L38
        final a r21 = this.this$0;     // Catch: Throwable -> L38
        r20.a("AppSession:packHistoryTerminates", th, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass5(r21), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        kotlinx.coroutines.sync.a.C0884a.b(a.b(this.this$0), null, 1, null);
        throw th;
    }
}
