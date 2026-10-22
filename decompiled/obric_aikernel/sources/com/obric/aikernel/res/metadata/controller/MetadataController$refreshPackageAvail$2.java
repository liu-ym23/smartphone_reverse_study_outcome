package com.obric.aikernel.res.metadata.controller;

import com.obric.aikernel.res.metadata.data.AIPackage;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.metadata.controller.MetadataController$refreshPackageAvail$2", f = "MetadataController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MetadataController$refreshPackageAvail$2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MetadataController this$0;

    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n*L\n1#1,328:1\n*E\n"})
    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r10, T r11) {
            AIPackage.a r12 = AIPackage.f5062u;
            return ComparisonsKt.compareValues(Integer.valueOf(r12.b(((com.obric.aikernel.res.metadata.data.b) r11).D())), Integer.valueOf(r12.b(((com.obric.aikernel.res.metadata.data.b) r10).D())));
        }
    }

    MetadataController$refreshPackageAvail$2(MetadataController r10, Continuation<? super MetadataController$refreshPackageAvail$2> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MetadataController$refreshPackageAvail$2(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((MetadataController$refreshPackageAvail$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r12);
        MetadataController.c r13 = this.this$0.p().a().get("package");
        if (r13 == null) goto L26;
        Map<String, Map<String, com.obric.aikernel.res.metadata.data.b>> r14 = r13.a();
        if (r14 == null) goto L26;
        Collection<Map<String, com.obric.aikernel.res.metadata.data.b>> r15 = r14.values();
        if (r15 == null) goto L26;
        MetadataController r11 = this.this$0;
        Iterator<T> r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L26;
        Map r10 = (Map) r16.next();
        monitor-enter(r10);
        Iterator r17 = CollectionsKt.sortedWith(r10.values(), new a()).iterator();     // Catch: Throwable -> L22
    L17:
        if (r17.hasNext() == false) goto L19;
        final com.obric.aikernel.res.metadata.data.b r18 = (com.obric.aikernel.res.metadata.data.b) r17.next();     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.data.AIPackage");     // Catch: Throwable -> L22
        AIPackage r19 = (AIPackage) r18;     // Catch: Throwable -> L22
        MetadataController.x(r11, r18.w(), r18.D(), null, false, false, new MetadataController$refreshPackageAvail$2$1$1$2$1(r18), 28, null);     // Catch: Throwable -> L22
        goto L17
    L19:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r10);
    L22:
        th = move-exception;
        throw th;
    L26:
        return Unit.INSTANCE;
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
