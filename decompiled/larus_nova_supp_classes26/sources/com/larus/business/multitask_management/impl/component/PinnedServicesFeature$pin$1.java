package com.larus.business.multitask_management.impl.component;

import android.content.Context;
import android.content.res.Resources;
import com.larus.common.apphost.AppHost;
import com.larus.multitask_management.api.data.quick_access.NodeType;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import ll9.r;
import ll9.t;
import ll9.v;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.component.PinnedServicesFeature$pin$1", f = "PinnedServicesFeature.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
public final class PinnedServicesFeature$pin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ t $node;
    int label;
    final /* synthetic */ PinnedServicesFeature this$0;

    public PinnedServicesFeature$pin$1(PinnedServicesFeature r1, t r2, Continuation<? super PinnedServicesFeature$pin$1> r3) {
        this.this$0 = r1;
        this.$node = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PinnedServicesFeature$pin$1(this.this$0, this.$node, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r23);
        Object r3 = r23;
        Long r5 = null;
    L38:
        r r4 = (r) r3;
        if (r4 == null) goto L41;
        Long r6 = r4.a;
    L42:
        if (r6 != null) goto L45;
        FLogger.a.e("multitask-PinnedServicesFeature", "pin node " + this.$node + " failed");
    L45:
        return Unit.INSTANCE;
    L41:
        r6 = r5;
        goto L42
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        int r7 = ((i) this.this$0.l.getValue()).a.size();
        PinnedServicesFeature r8 = this.this$0;
        if (r7 < r8.o) goto L12;
        s r9 = s.a;
        Context r10 = r8.getContext();
        Resources r11 = AppHost.a.getApplication().getResources();
        int r12 = this.this$0.o;
        String r13 = r11.getQuantityString(2131755119, r12, new Object[]{String.valueOf(r12)});
        r9.getClass();
        s.c(r10, r13);
        return Unit.INSTANCE;
    L12:
        List<t> r14 = ((i) r8.l.getValue()).a;
        t r15 = this.$node;
        if ((r14 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r16 = r14.iterator();
    L19:
        if (r16.hasNext() == false) goto L28;
        t r17 = (t) r16.next();
        if (r17.a == r15.a) goto L23;
    L25:
        boolean r18 = false;
    L26:
        if (r18 == false) goto L19;
        boolean r19 = false;
    L29:
        if (r19 == false) goto L35;
        PinnedServicesFeature r20 = this.this$0;
        if (r20.i == true) goto L35;
        StateFlowImpl r21 = r20.l;
        i r22 = (i) r21.getValue();
        List<t> r24 = ((i) this.this$0.l.getValue()).a;
        t r25 = this.$node;
        Long r26 = Boxing.boxLong(System.currentTimeMillis() * 1000);
        NodeType r110 = r25.a;
        String r111 = r25.b;
        String r112 = r25.c;
        String r113 = r25.d;
        String r27 = r25.e;
        String r114 = r25.f;
        String r115 = r25.g;
        ll9.a r28 = r25.h;
        Map r29 = r25.i;
        t.b r116 = t.Companion;
        Intrinsics.checkNotNullParameter(r110, "nodeType");
        Intrinsics.checkNotNullParameter(r111, "referenceId");
        Intrinsics.checkNotNullParameter(r112, "title");
        Intrinsics.checkNotNullParameter(r113, "iconUrl");
        r21.setValue(i.a(r22, CollectionsKt.plus(r24, CollectionsKt.listOf(new t(r110, r111, r112, r113, r27, r114, r115, r28, r29, r26))), 0, 6));
        il9.b r30 = (il9.b) ServiceManager.get().getService(il9.b.class);
        if (r30 == null) goto L35;
        r30.z(new v(CollectionsKt.take(((i) this.this$0.l.getValue()).a, this.this$0.m), Boxing.boxBoolean(this.this$0.k)));
    L35:
        s r31 = s.a;
        Context r32 = this.this$0.getContext();
        int r33 = j0.a;
        String r34 = j0.d(2131899889);
        r31.getClass();
        s.p(r32, r34);
        CoroutineDispatcher r35 = Dispatchers.getIO();
        r5 = null;
        PinnedServicesFeature$pin$1$resp$1 r36 = new PinnedServicesFeature$pin$1$resp$1(this.$node, null);
        this.label = 1;
        r3 = BuildersKt.withContext(r35, r36, this);
        if (r3 != r1) goto L38;
        return r1;
    L23:
        if (Intrinsics.areEqual(r17.b, r15.b) == false) goto L25;
        r18 = true;
    L28:
        r19 = true;
        goto L29
    L15:
        if (r14.isEmpty() == false) goto L17;
        goto L17
    }
}
