package com.bytedance.applog.priority.original;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applog.priority.original.AppSession$newSession$success$1", f = "AppSession.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class AppSession$newSession$success$1 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $extraParams;
    final /* synthetic */ boolean $isForegroundSession;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ b $sessionLaunch;
    int label;
    final /* synthetic */ a this$0;

    AppSession$newSession$success$1(a r3, b r4, String r5, boolean r6, String r7, Continuation<? super AppSession$newSession$success$1> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$sessionLaunch = r4;
        this.$sessionId = r5;
        this.$isForegroundSession = r6;
        this.$extraParams = r7;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AppSession$newSession$success$1(this.this$0, this.$sessionLaunch, this.$sessionId, this.$isForegroundSession, this.$extraParams, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
        return ((AppSession$newSession$success$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AppSession$newSession$success$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L12:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L18;
        if (a.a(this.this$0).a(this.$sessionId, this.$isForegroundSession, this.$extraParams, this.$sessionLaunch.d()) == true) goto L18;
        com.bytedance.applog.log.a r13 = this.this$0.getContext().b();
        final String r11 = this.$sessionId;
        r13.a("AppSession:newSession", null, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r11), Function0.class, "com.obric.memorydata.plugin"));
        return Boxing.boxBoolean(false);
    L18:
        return Boxing.boxBoolean(true);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        a r14 = this.this$0;
        b r2 = this.$sessionLaunch;
        Continuation<? super Boolean> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r12 = r14.a(r2, false, r5);
        if (r12 != r0) goto L12;
        return r0;
    }
}
