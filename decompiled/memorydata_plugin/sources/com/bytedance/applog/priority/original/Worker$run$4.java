package com.bytedance.applog.priority.original;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applog.priority.original.Worker$run$4", f = "Worker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class Worker$run$4 extends SuspendLambda implements Function2<al, Continuation<? super bx>, Object> {
    final /* synthetic */ o<JSONObject> $header;
    final /* synthetic */ long $runTimeSecs;
    final /* synthetic */ List<n> $runs;
    int label;
    final /* synthetic */ v this$0;

    /* JADX INFO: renamed from: com.bytedance.applog.priority.original.Worker$run$4$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applog.priority.original.Worker$run$4$1", f = "Worker.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ o<JSONObject> $header;
        final /* synthetic */ long $runTimeSecs;
        final /* synthetic */ List<n> $runs;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ v this$0;

        AnonymousClass1(List<? extends n> r3, v r4, o<JSONObject> r5, long r6, Continuation<? super AnonymousClass1> r8) {
            List<n> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.$runs = r7;
            this.this$0 = r4;
            this.$header = r5;
            this.$runTimeSecs = r6;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r12 = new AnonymousClass1(this.$runs, this.this$0, this.$header, this.$runTimeSecs, r8);
            r12.L$0 = r10;
            return (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r22) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r22);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r22);
            al r3 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.$runs, Iterable.class, "com.obric.memorydata.plugin");
            v r13 = this.this$0;
            o<JSONObject> r14 = this.$header;
            long r10 = this.$runTimeSecs;
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r5 = r4.iterator();
        L10:
            if (r5.hasNext() == false) goto L12;
            r15.add(kotlinx.coroutines.i.b(r3, null, null, (Function2) ZeusTransformUtils.preCheckCast(new Worker$run$4$1$1$1(r13, (n) ZeusTransformUtils.preCheckCast(r5.next(), n.class, "com.obric.memorydata.plugin"), r14, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
            r10 = r10;
            goto L10
        L12:
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.f.a(r6, r7) != r1) goto L16;
            return r1;
        }
    }

    Worker$run$4(v r3, List<? extends n> r4, o<JSONObject> r5, long r6, Continuation<? super Worker$run$4> r8) {
        List<n> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$runs = r7;
        this.$header = r5;
        this.$runTimeSecs = r6;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new Worker$run$4(this.this$0, this.$runs, this.$header, this.$runTimeSecs, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super bx> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super bx> r4) {
        return ((Worker$run$4) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), Worker$run$4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r11);
        return kotlinx.coroutines.i.a(v.b(this.this$0), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$runs, this.this$0, this.$header, this.$runTimeSecs, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
