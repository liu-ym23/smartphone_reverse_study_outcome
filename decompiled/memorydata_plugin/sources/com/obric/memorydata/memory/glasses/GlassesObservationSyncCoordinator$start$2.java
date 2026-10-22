package com.obric.memorydata.memory.glasses;

import com.obric.aiproactive.api.DoubaoGlassesConnectionSnapshot;
import com.obric.aiproactive.api.DoubaoGlassesConnectionState;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.recommend.RecommendApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.j;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.glasses.GlassesObservationSyncCoordinator$start$2", f = "GlassesObservationSyncCoordinator.kt", i = {}, l = {295}, m = "invokeSuspend", n = {}, s = {})
final class GlassesObservationSyncCoordinator$start$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.glasses.GlassesObservationSyncCoordinator$start$2$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1<T> f10136a = null;

        static {
            f10136a = new AnonymousClass1();
        }

        AnonymousClass1() {
        }

        private static final Unit a(boolean r1, DoubaoGlassesConnectionSnapshot r2, g r3) {
            Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
            r3.a("cellular_upload_enabled", Boolean.valueOf(r1));
            r3.a("connected", Boolean.valueOf(r2.getConnected()));
            r3.a("wearing", Boolean.valueOf(r2.getWearing()));
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$REQm5rln4cwGfi9WXgy9jOc_Bm4(boolean r0, DoubaoGlassesConnectionSnapshot r1, g r2) {
            return a(r0, r1, r2);
        }

        public final Object a(final boolean r9, Continuation<? super Unit> r10) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            final DoubaoGlassesConnectionSnapshot r11 = DoubaoGlassesConnectionState.INSTANCE.currentSnapshot();
            o.a(c.b(), "眼镜同步：蜂窝上传策略已更新", "cellular_policy_changed", c.a(c.f10140a, r11, "policy"), new $$Lambda$GlassesObservationSyncCoordinator$start$2$1$REQm5rln4cwGfi9WXgy9jOc_Bm4(r9, r11), null, 16, null);
            c.c().b();
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.j
        public /* synthetic */ Object emit(Object r3, Continuation r4) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r5);
        }
    }

    GlassesObservationSyncCoordinator$start$2(Continuation<? super GlassesObservationSyncCoordinator$start$2> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new GlassesObservationSyncCoordinator$start$2((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((GlassesObservationSyncCoordinator$start$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), GlassesObservationSyncCoordinator$start$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ar<Boolean> r7 = RecommendApi.INSTANCE.screenObservationCellularEnabled();
        j<? super Boolean> r2 = (j) ZeusTransformUtils.preCheckCast(AnonymousClass1.f10136a, j.class, "com.obric.memorydata.plugin");
        Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r7.collect(r2, r3) != r0) goto L12;
        return r0;
    }
}
