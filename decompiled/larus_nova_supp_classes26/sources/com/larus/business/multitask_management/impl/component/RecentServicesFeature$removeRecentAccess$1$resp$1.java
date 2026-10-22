package com.larus.business.multitask_management.impl.component;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ll9.t;
import ll9.x;
import ll9.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/multitask_management/api/data/quick_access/RecentAccessData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.component.RecentServicesFeature$removeRecentAccess$1$resp$1", f = "RecentServicesFeature.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
public final class RecentServicesFeature$removeRecentAccess$1$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super x>, Object> {
    final /* synthetic */ t $node;
    int label;

    public RecentServicesFeature$removeRecentAccess$1$resp$1(t r1, Continuation<? super RecentServicesFeature$removeRecentAccess$1$resp$1> r2) {
        this.$node = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RecentServicesFeature$removeRecentAccess$1$resp$1(this.$node, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super x> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L16:
        return (x) r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        il9.b r7 = (il9.b) ServiceManager.get().getService(il9.b.class);
        if (r7 == null) goto L14;
        t r3 = this.$node;
        y r2 = new y(r3.a, r3.b);
        this.label = 1;
        r6 = r7.t2(r2, this);
        if (r6 != r0) goto L16;
        return r0;
    L14:
        return null;
    }
}
