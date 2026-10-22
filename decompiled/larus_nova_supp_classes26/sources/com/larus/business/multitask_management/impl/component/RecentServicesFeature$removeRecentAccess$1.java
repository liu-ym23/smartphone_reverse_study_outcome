package com.larus.business.multitask_management.impl.component;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import ll9.t;
import ll9.v;
import ll9.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.component.RecentServicesFeature$removeRecentAccess$1", f = "RecentServicesFeature.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
public final class RecentServicesFeature$removeRecentAccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ t $node;
    int label;
    final /* synthetic */ RecentServicesFeature this$0;

    public RecentServicesFeature$removeRecentAccess$1(RecentServicesFeature r1, t r2, Continuation<? super RecentServicesFeature$removeRecentAccess$1> r3) {
        this.this$0 = r1;
        this.$node = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RecentServicesFeature$removeRecentAccess$1(this.this$0, this.$node, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L25:
        if (((x) r12) != null) goto L28;
        FLogger.a.e("multitask-RecentServicesFeature", "removeRecentAccess node " + this.$node + " failed");
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        StateFlowImpl r13 = this.this$0.j;
        i r2 = (i) r13.getValue();
        List<t> r3 = ((i) this.this$0.j.getValue()).a;
        t r4 = this.$node;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r3.iterator();
    L9:
        boolean r7 = false;
        if (r6.hasNext() == false) goto L18;
        Object r8 = r6.next();
        t r9 = (t) r8;
        if (r9.a == r4.a) goto L14;
    L16:
        if (r7 == true) goto L9;
        r5.add(r8);
        goto L9
    L14:
        if (Intrinsics.areEqual(r9.b, r4.b) == false) goto L16;
        r7 = true;
        goto L16
    L18:
        r13.setValue(i.a(r2, r5, 0, 6));
        il9.b r14 = (il9.b) ServiceManager.get().getService(il9.b.class);
        if (r14 == null) goto L21;
        RecentServicesFeature r10 = this.this$0;
        r14.U0(new v(RecentServicesFeature.F2(r10, ((i) r10.j.getValue()).a), Boxing.boxBoolean(this.this$0.l)));
    L21:
        CoroutineDispatcher r15 = Dispatchers.getIO();
        RecentServicesFeature$removeRecentAccess$1$resp$1 r11 = new RecentServicesFeature$removeRecentAccess$1$resp$1(this.$node, null);
        this.label = 1;
        r12 = BuildersKt.withContext(r15, r11, this);
        if (r12 != r0) goto L25;
        return r0;
    }
}
