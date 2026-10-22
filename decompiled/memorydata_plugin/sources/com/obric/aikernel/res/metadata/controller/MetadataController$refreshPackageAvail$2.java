package com.obric.aikernel.res.metadata.controller;

import androidx.exifinterface.media.ExifInterface;
import com.obric.aikernel.res.metadata.data.b;
import com.obric.aikernel.res.metadata.data.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.metadata.controller.MetadataController$refreshPackageAvail$2", f = "MetadataController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MetadataController$refreshPackageAvail$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ com.obric.aikernel.res.metadata.controller.a this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            d r1 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
            Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(b.e.a(r1.t())), Comparable.class, "com.obric.memorydata.plugin");
            d r5 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.memorydata.plugin");
            return ComparisonsKt.compareValues(r4, (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(b.e.a(r5.t())), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    MetadataController$refreshPackageAvail$2(com.obric.aikernel.res.metadata.controller.a r3, Continuation<? super MetadataController$refreshPackageAvail$2> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MetadataController$refreshPackageAvail$2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MetadataController$refreshPackageAvail$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MetadataController$refreshPackageAvail$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r12);
        com.obric.aikernel.res.metadata.controller.a.c r13 = (com.obric.aikernel.res.metadata.controller.a.c) ZeusTransformUtils.preCheckCast(this.this$0.b().a().get("package"), com.obric.aikernel.res.metadata.controller.a.c.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L26;
        Map<String, Map<String, d>> r14 = r13.a();
        if (r14 == null) goto L26;
        Collection<Map<String, d>> r15 = r14.values();
        if (r15 == null) goto L26;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.res.metadata.controller.a r11 = this.this$0;
        Iterator r17 = r16.iterator();
    L12:
        if (r17.hasNext() == false) goto L26;
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r17.next(), Map.class, "com.obric.memorydata.plugin");
        monitor-enter(r9);
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r9.values(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L22
    L17:
        if (r10.hasNext() == false) goto L19;
        final d r0 = (d) ZeusTransformUtils.preCheckCast(r10.next(), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.data.AIPackage");     // Catch: Throwable -> L22
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        com.obric.aikernel.res.metadata.controller.a.a(r11, r0.s(), r0.t(), null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new MetadataController$refreshPackageAvail$2$1$1$2$1(r0), Function1.class, "com.obric.memorydata.plugin"), 28, null);     // Catch: Throwable -> L22
        goto L17
    L19:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r9);
    L22:
        th = move-exception;
        throw th;
    L26:
        return Unit.INSTANCE;
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
