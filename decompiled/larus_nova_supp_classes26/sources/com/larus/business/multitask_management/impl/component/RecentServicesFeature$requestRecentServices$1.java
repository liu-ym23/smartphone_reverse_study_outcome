package com.larus.business.multitask_management.impl.component;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ll9.t;
import ll9.v;
import ll9.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.component.RecentServicesFeature$requestRecentServices$1", f = "RecentServicesFeature.kt", i = {0}, l = {91}, m = "invokeSuspend", n = {"shouldSchedulePrefetch"}, s = {"I$0"})
public final class RecentServicesFeature$requestRecentServices$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enablePrefetch;
    final /* synthetic */ int $pageSize;
    int I$0;
    int label;
    final /* synthetic */ RecentServicesFeature this$0;

    public RecentServicesFeature$requestRecentServices$1(RecentServicesFeature r1, boolean r2, int r3, Continuation<? super RecentServicesFeature$requestRecentServices$1> r4) {
        this.this$0 = r1;
        this.$enablePrefetch = r2;
        this.$pageSize = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RecentServicesFeature$requestRecentServices$1(this.this$0, this.$enablePrefetch, this.$pageSize, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r4 = 1;
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L9;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L98
    L15:
        x r14 = (x) r13;     // Catch: Throwable -> L98
        if (r14 == null) goto L89;
        RecentServicesFeature r5 = this.this$0;     // Catch: Throwable -> L98
        if (Intrinsics.areEqual(r14.d, Boxing.boxBoolean(true)) == true) goto L21;
    L23:
        boolean r6 = false;
    L24:
        r5.i = r6;     // Catch: Throwable -> L98
        List r7 = r14.b;     // Catch: Throwable -> L98
        if (r7 == null) goto L28;
        List r8 = CollectionsKt.filterNotNull(r7);     // Catch: Throwable -> L98
        if (r8 == null) goto L28;
    L29:
        RecentServicesFeature r9 = this.this$0;     // Catch: Throwable -> L98
        if (r9.h != null) goto L32;
        boolean r10 = true;
    L33:
        long r11 = 0;
        if (r10 == false) goto L41;
        r9.k = true;     // Catch: Throwable -> L98
        r9.l = r9.i;     // Catch: Throwable -> L98
        t r0 = (t) CollectionsKt.lastOrNull(r8);     // Catch: Throwable -> L98
        if (r0 == null) goto L40;
        Long r12 = r0.j;     // Catch: Throwable -> L98
        if (r12 == null) goto L40;
        r11 = r12.longValue();     // Catch: Throwable -> L98
    L40:
        r9.m = r11;     // Catch: Throwable -> L98
    L78:
        int r15 = 8;
        if (r10 == true) goto L82;
        r15 = RangesKt.coerceAtLeast(((i) this.this$0.j.getValue()).b, 8);     // Catch: Throwable -> L98
    L82:
        RecentServicesFeature r16 = this.this$0;     // Catch: Throwable -> L98
        r16.j.setValue(new i(r8, r15, r16.i));     // Catch: Throwable -> L98
        il9.b r17 = (il9.b) ServiceManager.get().getService(il9.b.class);     // Catch: Throwable -> L98
        if (r17 == null) goto L85;
        r17.U0(new v(RecentServicesFeature.F2(this.this$0, r8), Boxing.boxBoolean(this.this$0.l)));     // Catch: Throwable -> L98
    L85:
        FLogger.a.i("multitask-RecentServicesFeature", "getRecentAccessList, mergedList.size = " + r8.size() + ", hasMore = " + this.this$0.i + ", cursor = " + this.this$0.h + ", nextCursor = " + r14.c);     // Catch: Throwable -> L98
        RecentServicesFeature r18 = this.this$0;     // Catch: Throwable -> L98
        String r19 = r14.c;     // Catch: Throwable -> L98
        if (r19 != null) goto L88;
        r19 = r18.h;     // Catch: Throwable -> L98
    L88:
        r18.h = r19;     // Catch: Throwable -> L98
    L91:
        RecentServicesFeature r110 = this.this$0;
        r110.p = false;
        if (r4 == 0) goto L97;
        if (this.$enablePrefetch == false) goto L97;
        RecentServicesFeature.L2(r110);
    L97:
        return Unit.INSTANCE;
    L41:
        t r20 = (t) CollectionsKt.firstOrNull(r8);     // Catch: Throwable -> L98
        if (r20 == null) goto L46;
        Long r21 = r20.j;     // Catch: Throwable -> L98
        if (r21 == null) goto L46;
        long r22 = r21.longValue();     // Catch: Throwable -> L98
    L47:
        t r23 = (t) CollectionsKt.lastOrNull(((i) this.this$0.j.getValue()).a);     // Catch: Throwable -> L98
        if (r23 == null) goto L53;
        Long r24 = r23.j;     // Catch: Throwable -> L98
        if (r24 == null) goto L53;
        r11 = r24.longValue();     // Catch: Throwable -> L98
    L53:
        if (r22 <= r11) goto L77;
        FLogger.a.e("multitask-RecentServicesFeature", "getRecentAccessList find invalid data, newTimestamp = " + r22 + ", oldTimestamp = " + r11);     // Catch: Throwable -> L98
        List r25 = CollectionsKt.toMutableList(((i) this.this$0.j.getValue()).a);     // Catch: Throwable -> L98
        RecentServicesFeature r26 = this.this$0;     // Catch: Throwable -> L98
        Iterator r27 = r8.iterator();     // Catch: Throwable -> L98
    L56:
        if (r27.hasNext() == false) goto L76;
        t r28 = (t) r27.next();     // Catch: Throwable -> L98
        List<t> r29 = ((i) r26.j.getValue()).a;     // Catch: Throwable -> L98
        if ((r29 instanceof Collection) == true) goto L60;
    L62:
        Iterator<T> r30 = r29.iterator();     // Catch: Throwable -> L98
    L64:
        if (r30.hasNext() == false) goto L73;
        t r31 = (t) r30.next();     // Catch: Throwable -> L98
        if (r31.a == r28.a) goto L68;
    L70:
        boolean r32 = false;
    L71:
        if (r32 == false) goto L64;
        boolean r33 = false;
    L74:
        if (r33 == false) goto L56;
        r25.add(r28);     // Catch: Throwable -> L98
        goto L56
    L68:
        if (Intrinsics.areEqual(r31.b, r28.b) == false) goto L70;
        r32 = true;
    L73:
        r33 = true;
        goto L74
    L60:
        if (r29.isEmpty() == false) goto L62;
    L76:
        r8 = r25;
        goto L78
    L77:
        r8 = CollectionsKt.plus(((i) this.this$0.j.getValue()).a, r8);     // Catch: Throwable -> L98
    L46:
        r22 = 0;
        goto L47
    L32:
        r10 = false;
    L28:
        r8 = CollectionsKt.emptyList();     // Catch: Throwable -> L98
        goto L29
    L21:
        if (r14.c == null) goto L23;
        r6 = true;
        goto L24
    L89:
        FLogger.a.e("multitask-RecentServicesFeature", "getRecentAccessList failed resp is null");     // Catch: Throwable -> L98
        r4 = r3;
        goto L91
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r13);
        this.this$0.p = true;
        CoroutineDispatcher r111 = Dispatchers.getIO();     // Catch: Throwable -> L98
        RecentServicesFeature$requestRecentServices$1$resp$1 r34 = new RecentServicesFeature$requestRecentServices$1$resp$1(this.$pageSize, this.this$0, null);     // Catch: Throwable -> L98
        this.I$0 = 0;     // Catch: Throwable -> L98
        this.label = 1;     // Catch: Throwable -> L98
        r13 = BuildersKt.withContext(r111, r34, this);     // Catch: Throwable -> L98
        if (r13 != r1) goto L14;
        return r1;
    L14:
        r3 = 0;
    L98:
        th = move-exception;
        this.this$0.p = false;
        throw th;
    }
}
