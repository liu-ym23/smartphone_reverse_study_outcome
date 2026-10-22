package com.ss.android.lark.integrator.im.impl;

import com.bytedance.lark.lark_biz_feed_android.n;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.integrator.im.impl.IIMUserServiceImpl$onPrepared$1$1$1$onLarkFeedInfoChanged$1", f = "IIMUserServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class IIMUserServiceImpl$onPrepared$1$1$1$onLarkFeedInfoChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n $feedInfo;
    int label;
    final /* synthetic */ IIMUserServiceImpl this$0;

    public IIMUserServiceImpl$onPrepared$1$1$1$onLarkFeedInfoChanged$1(IIMUserServiceImpl r1, n r2, Continuation<? super IIMUserServiceImpl$onPrepared$1$1$1$onLarkFeedInfoChanged$1> r3) {
        this.this$0 = r1;
        this.$feedInfo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new IIMUserServiceImpl$onPrepared$1$1$1$onLarkFeedInfoChanged$1(this.this$0, this.$feedInfo, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r4);
        IIMUserServiceImpl r5 = this.this$0;
        int r0 = IIMUserServiceImpl.o;
        Iterator r6 = ((CopyOnWriteArrayList) r5.l.getValue()).iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        ((hza.b) r6.next()).a(this.this$0.n(this.$feedInfo));
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
