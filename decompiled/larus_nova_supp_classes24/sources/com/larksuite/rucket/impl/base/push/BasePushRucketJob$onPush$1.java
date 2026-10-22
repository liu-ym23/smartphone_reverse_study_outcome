package com.larksuite.rucket.impl.base.push;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import g38.d;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.rucket.impl.base.push.BasePushRucketJob$onPush$1", f = "BasePushRucketJob.kt", i = {0, 1}, l = {53, 56}, m = "invokeSuspend", n = {"pbResponse", "e"}, s = {"L$0", "L$0"})
final class BasePushRucketJob$onPush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $request;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ a<Message<?, ?>> this$0;

    public BasePushRucketJob$onPush$1(a<Message<?, ?>> r1, byte[] r2, Continuation<? super BasePushRucketJob$onPush$1> r3) {
        this.this$0 = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BasePushRucketJob$onPush$1(this.this$0, this.$request, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        Iterator r0 = (Iterator) this.L$1;
        Exception r3 = (Exception) this.L$0;
        ResultKt.throwOnFailure(r7);
    L22:
        if (r0.hasNext() == false) goto L27;
        RucketJob r8 = (RucketJob) r0.next();
        ErrorResult r4 = new ErrorResult(r3);
        this.L$0 = r3;
        this.L$1 = r0;
        this.label = 2;
        if (r8.setError(r4, this) != r1) goto L22;
        return r1;
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Iterator r5 = (Iterator) this.L$1;
        Message r6 = (Message) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L19
    L14:
        if (r5.hasNext() == false) goto L27;
        RucketJob r9 = (RucketJob) r5.next();     // Catch: Exception -> L19
        this.L$0 = r6;     // Catch: Exception -> L19
        this.L$1 = r5;     // Catch: Exception -> L19
        this.label = 1;     // Catch: Exception -> L19
        if (r9.setResult(r6, this) != r1) goto L14;
        return r1;
    L12:
        ResultKt.throwOnFailure(r7);
        int r10 = d.a;     // Catch: Exception -> L19
        Class<T> r11 = this.this$0.a;     // Catch: Exception -> L19
        Intrinsics.checkNotNullParameter(r11, "clazz");     // Catch: Exception -> L19
        r6 = (Message) ProtoAdapter.get(r11).decode(this.$request);     // Catch: Exception -> L19
        Log.d("BasePushRucketJob", "onPush thread: " + ThreadMethodProxy.currentThread());     // Catch: Exception -> L19
        r5 = this.this$0.b.iterator();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        r3 = e;
        Log.e("BasePushRucketJob", "parse pbResponse Failed, Exception is : " + r3);
        r0 = this.this$0.b.iterator();
        goto L22
    }
}
