package com.larus.bmhome.resource.access;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class DelegatingResourceNode implements l0 {
    public final String a;
    public final ResourcePhase b;
    public final List<String> c;
    public final boolean d;
    public final ResourceNodeCompletionMode e;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            ((ResourceNodeHandler) r1).getPriority();
            ((ResourceNodeHandler) r2).getPriority();
            return ComparisonsKt.compareValues(0, 0);
        }
    }

    public static final class b<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(((ResourceNodeHandler) r2).getKey(), ((ResourceNodeHandler) r3).getKey());
        }
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final Object c(h0 r1, Continuation<? super g> r2) {
        return a(this, r1, r2);
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourcePhase d() {
        return this.b;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final List<String> f() {
        return this.c;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourceNodeCompletionMode g() {
        return this.e;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final String getKey() {
        return this.a;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean h() {
        return this.d;
    }

    public final ResourceNodeHandler b(h0 r8) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        Set r1 = ServiceManager.get().getServices(ResourceNodeHandler.class, true);     // Catch: Throwable -> L18
        if (r1 != null) goto L5;
        r1 = SetsKt.emptySet();     // Catch: Throwable -> L18
    L5:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L18
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L18
    L7:
        if (r3.hasNext() == false) goto L16;
        Object r4 = r3.next();     // Catch: Throwable -> L18
        ResourceNodeHandler r5 = (ResourceNodeHandler) r4;     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(r5.a(), this.a) == true) goto L11;
    L13:
        boolean r6 = false;
    L14:
        if (r6 == false) goto L7;
        r2.add(r4);     // Catch: Throwable -> L18
        goto L7
    L11:
        if (r5.b(r8) == false) goto L13;
        r6 = true;
        goto L14
    L16:
        Object r9 = Result.constructor-impl((ResourceNodeHandler) CollectionsKt.maxWithOrNull(r2, new b(new a())));     // Catch: Throwable -> L18
    L20:
        Throwable r7 = Result.exceptionOrNull-impl(r9);
        if (r7 == null) goto L24;
        FLogger.a.e("ResourceAccessPipeline", "[findHandler] collect handler failed, node=" + this.a, r7);
    L24:
        if (Result.isFailure-impl(r9) == false) goto L27;
        r9 = null;
    L27:
        return (ResourceNodeHandler) r9;
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean e(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (b(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static Object a(DelegatingResourceNode r9, h0 r10, Continuation<? super g> r11) {
        if ((r11 instanceof DelegatingResourceNode$execute$1) == false) goto L7;
        DelegatingResourceNode$execute$1 r0 = (DelegatingResourceNode$execute$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        DelegatingResourceNode r13 = (DelegatingResourceNode) r0.L$2;
        ResourceNodeHandler r14 = (ResourceNodeHandler) r0.L$1;
        DelegatingResourceNode r4 = (DelegatingResourceNode) r0.L$0;
        ResultKt.throwOnFailure(r12);
        DelegatingResourceNode r15 = r13;
        r9 = r4;
        Object r5 = r12;
        ResourceNodeHandler r16 = r14;
    L22:
        g r6 = (g) r5;
        String r17 = r9.a;
        String r18 = r16.getKey();
        r15.getClass();
        Map r19 = MapsKt.mapOf(TuplesKt.to(r17 + "_handler", r18));
        if ((r6 instanceof g.a) == false) goto L26;
        i0 r110 = ((g.a) r6).a;
        Map r7 = MapsKt.plus(r110.g, r19);
        j0 r8 = r110.a;
        mr9.c r20 = r110.b;
        Long r21 = r110.c;
        mr9.h r22 = r110.d;
        String r23 = r110.e;
        f0 r24 = r110.f;
        Intrinsics.checkNotNullParameter(r7, "attributes");
        i0 r25 = new i0(r8, r20, r21, r22, r23, r24, r7);
        Intrinsics.checkNotNullParameter(r25, "update");
        return new g.a(r25);
    L26:
        if ((r6 instanceof g.d) == false) goto L29;
        f0 r111 = ((g.d) r6).a;
        f0 r26 = f0.a(r111, MapsKt.plus(r111.f, r19));
        Intrinsics.checkNotNullParameter(r26, "artifact");
        return new g.d(r26);
    L29:
        if ((r6 instanceof g.b) == false) goto L31;
        return r6;
    L31:
        if ((r6 instanceof g.c) == false) goto L33;
        return r6;
    L33:
        if (Intrinsics.areEqual(r6, g.e.a) == false) goto L36;
        return r6;
    L36:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r16 = r9.b(r10);
        if (r16 == null) goto L17;
        FLogger.a.i("ResourceAccessPipeline", "[execute] node=" + r9.a + " hit handler=" + r16.getKey());
        r0.L$0 = r9;
        r0.L$1 = r16;
        r0.L$2 = r9;
        r0.label = 1;
        Object r112 = r16.c(r10, r0);
        if (r112 != r2) goto L21;
        return r2;
    L21:
        r5 = r112;
        r15 = r9;
        goto L22
    L17:
        return g.e.a;
    L7:
        r0 = new DelegatingResourceNode$execute$1(r9, r11);
        goto L8
    }

    public DelegatingResourceNode(String r2, ResourcePhase r3, List<String> r4, boolean r5, ResourceNodeCompletionMode r6) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "phase");
        Intrinsics.checkNotNullParameter(r4, "dependsOn");
        Intrinsics.checkNotNullParameter(r6, "completionMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ DelegatingResourceNode(String r7, ResourcePhase r8, List r9, boolean r10, int r11) {
        if ((r11 & 4) == 0) goto L5;
        r9 = CollectionsKt.emptyList();
    L5:
        List r3 = r9;
        if ((r11 & 8) == 0) goto L8;
        boolean r4 = false;
    L10:
        if ((r11 & 16) == 0) goto L12;
        ResourceNodeCompletionMode r12 = ResourceNodeCompletionMode.BLOCKING;
    L13:
        this(r7, r8, r3, r4, r12);
        return;
    L12:
        r12 = null;
        goto L13
    L8:
        r4 = r10;
        goto L10
    }
}
