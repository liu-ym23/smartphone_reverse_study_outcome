package com.obric.assistant.cocreationreview;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMError;
import gd8.g;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/cocreationreview/CocreationTaskLauncher$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationTaskLauncher$run$3", f = "CocreationTaskLauncher.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
public final class CocreationTaskLauncher$run$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CocreationTaskLauncher.a>, Object> {
    final /* synthetic */ Map<String, String> $messageExt;
    final /* synthetic */ String $query;
    final /* synthetic */ CocreationTaskLauncher.b $target;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public static final class a implements Function2<Message, IIMError, Unit> {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ kotlinx.coroutines.i<CocreationTaskLauncher.a> b;

        public a(AtomicBoolean r1, kotlinx.coroutines.j r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke(Object r4, Object r5) {
            Message r6 = (Message) r4;
            IIMError r7 = (IIMError) r5;
            boolean r1 = false;
            if (this.a.compareAndSet(false, true) == false) goto L15;
            if (this.b.isActive() == false) goto L15;
            if (r6 == null) goto L9;
            if (r7 != null) goto L9;
            r1 = true;
        L9:
            int r8 = s3.a;
            s3.b("task.run", "send callback success=" + r1);
            kotlinx.coroutines.i<CocreationTaskLauncher.a> r9 = this.b;
            Result.Companion r10 = Result.Companion;
            if (r1 == false) goto L12;
            String r0 = null;
        L13:
            r9.resumeWith(Result.constructor-impl(new CocreationTaskLauncher.a(r1, r0)));
            goto L15
        L12:
            r0 = "任务发送失败，请稍后重试";
        L15:
            return Unit.INSTANCE;
        }
    }

    public CocreationTaskLauncher$run$3(CocreationTaskLauncher.b r1, String r2, Map<String, String> r3, Continuation<? super CocreationTaskLauncher$run$3> r4) {
        this.$target = r1;
        this.$query = r2;
        this.$messageExt = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CocreationTaskLauncher$run$3(this.$target, this.$query, this.$messageExt, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super CocreationTaskLauncher.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        Map r3 = (Map) this.L$2;
        String r4 = (String) this.L$1;
        CocreationTaskLauncher.b r5 = (CocreationTaskLauncher.b) this.L$0;
        ResultKt.throwOnFailure(r17);
        return r17;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        CocreationTaskLauncher.b r6 = this.$target;
        String r7 = this.$query;
        Map<String, String> r8 = this.$messageExt;
        this.L$0 = r6;
        this.L$1 = r7;
        this.L$2 = r8;
        this.label = 1;
        kotlinx.coroutines.j r15 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r15.C();
        AtomicBoolean r9 = new AtomicBoolean(false);
        g.a.b(r6.b, r6.a, r7, "cocreation_task_center", r8, false, null, null, null, new a(r9, r15), null, 1776);
        Object r10 = r15.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r10 != r1) goto L14;
        return r1;
    L14:
        return r10;
    }
}
