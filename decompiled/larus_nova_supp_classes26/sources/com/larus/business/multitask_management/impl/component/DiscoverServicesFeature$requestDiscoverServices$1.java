package com.larus.business.multitask_management.impl.component;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.component.DiscoverServicesFeature$requestDiscoverServices$1", f = "DiscoverServicesFeature.kt", i = {0}, l = {93}, m = "invokeSuspend", n = {"shouldSchedulePrefetch"}, s = {"I$0"})
public final class DiscoverServicesFeature$requestDiscoverServices$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enablePrefetch;
    final /* synthetic */ int $pageSize;
    int I$0;
    int label;
    final /* synthetic */ DiscoverServicesFeature this$0;

    public DiscoverServicesFeature$requestDiscoverServices$1(DiscoverServicesFeature r1, boolean r2, int r3, Continuation<? super DiscoverServicesFeature$requestDiscoverServices$1> r4) {
        this.this$0 = r1;
        this.$enablePrefetch = r2;
        this.$pageSize = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DiscoverServicesFeature$requestDiscoverServices$1(this.this$0, this.$enablePrefetch, this.$pageSize, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r3 = 1;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L81
    L15:
        ll9.e r16 = (ll9.e) r15;     // Catch: Throwable -> L81
        if (r16 == null) goto L72;
        DiscoverServicesFeature r4 = this.this$0;     // Catch: Throwable -> L81
        if (Intrinsics.areEqual(r16.c, Boxing.boxBoolean(true)) == true) goto L21;
    L23:
        boolean r5 = false;
    L24:
        r4.i = r5;     // Catch: Throwable -> L81
        List r6 = r16.a;     // Catch: Throwable -> L81
        if (r6 == null) goto L28;
        List<t> r7 = CollectionsKt.filterNotNull(r6);     // Catch: Throwable -> L81
        if (r7 == null) goto L28;
    L29:
        DiscoverServicesFeature r8 = this.this$0;     // Catch: Throwable -> L81
        if (r8.h != null) goto L32;
        boolean r9 = true;
    L33:
        if (r9 == false) goto L35;
        r8.j = true;     // Catch: Throwable -> L81
        r8.k = r8.i;     // Catch: Throwable -> L81
    L61:
        int r10 = 50;
        if (r9 == true) goto L65;
        r10 = RangesKt.coerceAtLeast(((i) this.this$0.l.getValue()).b, 50);     // Catch: Throwable -> L81
    L65:
        DiscoverServicesFeature r11 = this.this$0;     // Catch: Throwable -> L81
        r11.m = r7;     // Catch: Throwable -> L81
        r11.l.setValue(new i(r7, r10, r11.i));     // Catch: Throwable -> L81
        il9.b r12 = (il9.b) ServiceManager.get().getService(il9.b.class);     // Catch: Throwable -> L81
        if (r12 == null) goto L68;
        r12.I1(new v(CollectionsKt.take(r7, this.this$0.n), Boxing.boxBoolean(this.this$0.k)));     // Catch: Throwable -> L81
    L68:
        FLogger.a.i("multitask-DiscoverServicesFeature", "getDiscoverList, mergedList.size = " + r7.size() + ", hasMore = " + this.this$0.i + ", cursor = " + this.this$0.h + ", nextCursor = " + r16.b);     // Catch: Throwable -> L81
        DiscoverServicesFeature r13 = this.this$0;     // Catch: Throwable -> L81
        String r17 = r16.b;     // Catch: Throwable -> L81
        if (r17 != null) goto L71;
        r17 = r13.h;     // Catch: Throwable -> L81
    L71:
        r13.h = r17;     // Catch: Throwable -> L81
    L74:
        DiscoverServicesFeature r18 = this.this$0;
        r18.p = false;
        if (r3 == 0) goto L80;
        if (this.$enablePrefetch == false) goto L80;
        DiscoverServicesFeature.F2(r18);
    L80:
        return Unit.INSTANCE;
    L35:
        List<t> r14 = ((i) r8.l.getValue()).a;     // Catch: Throwable -> L81
        if (r7.isEmpty() == false) goto L38;
        r7 = r14;
        goto L61
    L38:
        List<t> r19 = r14;     // Catch: Throwable -> L81
        ArrayList r20 = new ArrayList();     // Catch: Throwable -> L81
        Iterator<T> r21 = r7.iterator();     // Catch: Throwable -> L81
    L40:
        if (r21.hasNext() == false) goto L60;
        Object r22 = r21.next();     // Catch: Throwable -> L81
        t r23 = (t) r22;     // Catch: Throwable -> L81
        List<t> r110 = r14;     // Catch: Throwable -> L81
        if ((r110 instanceof Collection) == true) goto L44;
    L46:
        Iterator<T> r111 = r110.iterator();     // Catch: Throwable -> L81
    L48:
        if (r111.hasNext() == false) goto L57;
        t r112 = (t) r111.next();     // Catch: Throwable -> L81
        if (r112.a == r23.a) goto L52;
    L54:
        boolean r113 = false;
    L55:
        if (r113 == false) goto L48;
        boolean r24 = false;
    L58:
        if (r24 == false) goto L40;
        r20.add(r22);     // Catch: Throwable -> L81
        goto L40
    L52:
        if (Intrinsics.areEqual(r112.b, r23.b) == false) goto L54;
        r113 = true;
    L57:
        r24 = true;
        goto L58
    L44:
        if (r110.isEmpty() == false) goto L46;
    L60:
        r7 = CollectionsKt.plus(r19, r20);     // Catch: Throwable -> L81
        goto L61
    L32:
        r9 = false;
    L28:
        r7 = CollectionsKt.emptyList();     // Catch: Throwable -> L81
        goto L29
    L21:
        if (r16.b == null) goto L23;
        r5 = true;
        goto L24
    L72:
        FLogger.a.e("multitask-DiscoverServicesFeature", "getDiscoverList failed resp is null");     // Catch: Throwable -> L81
        r3 = r2;
        goto L74
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r15);
        this.this$0.p = true;
        CoroutineDispatcher r114 = Dispatchers.getIO();     // Catch: Throwable -> L81
        DiscoverServicesFeature$requestDiscoverServices$1$resp$1 r25 = new DiscoverServicesFeature$requestDiscoverServices$1$resp$1(this.$pageSize, this.this$0, null);     // Catch: Throwable -> L81
        this.I$0 = 0;     // Catch: Throwable -> L81
        this.label = 1;     // Catch: Throwable -> L81
        r15 = BuildersKt.withContext(r114, r25, this);     // Catch: Throwable -> L81
        if (r15 != r0) goto L14;
        return r0;
    L14:
        r2 = 0;
    L81:
        th = move-exception;
        this.this$0.p = false;
        throw th;
    }
}
