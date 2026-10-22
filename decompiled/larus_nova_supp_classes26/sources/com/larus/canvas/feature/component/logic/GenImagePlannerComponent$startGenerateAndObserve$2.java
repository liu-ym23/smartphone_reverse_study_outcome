package com.larus.canvas.feature.component.logic;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasImageBlock;
import com.larus.canvas.service.bean.CanvasInfo;
import com.larus.platform.IFlowSdkDepend;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$startGenerateAndObserve$2", f = "GenImagePlannerComponent.kt", i = {}, l = {1027}, m = "invokeSuspend", n = {}, s = {})
final class GenImagePlannerComponent$startGenerateAndObserve$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ky8.c $param;
    final /* synthetic */ CompletableDeferred<Unit> $releaseSignal;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.logic.GenImagePlannerComponent$startGenerateAndObserve$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/canvas/feature/component/logic/canvasGenerator/SseUpdateData;", "", "Lcom/larus/canvas/service/bean/CanvasBlock;", "t", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$startGenerateAndObserve$2$1", f = "GenImagePlannerComponent.kt", i = {}, l = {1016, 1019}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super com.larus.canvas.feature.component.logic.canvasGenerator.k<? extends List<? extends CanvasBlock>>>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<List<CanvasBlock>> $cachedBlockList;
        final /* synthetic */ ky8.c $param;
        final /* synthetic */ CompletableDeferred<Unit> $releaseSignal;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ GenImagePlannerComponent this$0;

        public AnonymousClass1(Ref.ObjectRef<List<CanvasBlock>> r1, GenImagePlannerComponent r2, ky8.c r3, CompletableDeferred<Unit> r4, Continuation<? super AnonymousClass1> r5) {
            this.$cachedBlockList = r1;
            this.this$0 = r2;
            this.$param = r3;
            this.$releaseSignal = r4;
            super(3, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((FlowCollector) r1, (Throwable) r2, (Continuation) r3);
        }

        public final Object invoke(FlowCollector<? super com.larus.canvas.feature.component.logic.canvasGenerator.k<? extends List<CanvasBlock>>> r7, Throwable r8, Continuation<? super Unit> r9) {
            AnonymousClass1 r10 = new AnonymousClass1(this.$cachedBlockList, this.this$0, this.$param, this.$releaseSignal, r9);
            r10.L$0 = r8;
            return r10.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r11);
        L39:
            GenImagePlannerComponent.C3(this.this$0, this.$param.c, (List) r11);
            this.this$0.e4().cancelProgress(this.$param.c);
        L41:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
        L35:
            Boxing.boxBoolean(this.$releaseSignal.complete(Unit.INSTANCE));
            goto L41
        L10:
            ResultKt.throwOnFailure(r11);
            Throwable r12 = (Throwable) this.L$0;
            FLogger.a.e("GenImagePlannerComponent", "generate error, msg: " + r12.getMessage(), r12);
            CanvasBlock r2 = (CanvasBlock) CollectionsKt.firstOrNull((List) this.$cachedBlockList.element);
            if (r2 == null) goto L22;
            CanvasImageBlock r3 = r2.content;
            if (r3 == null) goto L22;
            CanvasInfo r4 = r3.canvasInfo;
            if (r4 == null) goto L22;
            Integer r5 = r4.canvasStatus;
            if (r5 == null) goto L22;
            if (r5.intValue() != 10) goto L22;
            boolean r6 = true;
        L23:
            if (r6 == true) goto L36;
            ky8.f r7 = this.this$0.O30(this.$param.c);
            if (r7 == null) goto L32;
            GenImagePlannerComponent r8 = this.this$0;
            com.larus.canvas.feature.component.logic.trace.a r9 = r8.X3();
            if (r9 == null) goto L29;
            r9.Xv(r7, true);
        L29:
            com.larus.canvas.feature.component.logic.trace.a r10 = r8.X3();
            if (r10 == null) goto L32;
            com.larus.canvas.feature.component.logic.trace.a.C0094a.a(r10, r7, true);
        L32:
            GenImagePlannerComponent r13 = this.this$0;
            String r14 = this.$param.c;
            List r15 = (List) this.$cachedBlockList.element;
            String r16 = r12.getMessage();
            this.label = 1;
            if (GenImagePlannerComponent.j4(r13, r14, r15, r16, this, 8) != r0) goto L35;
            return r0;
        L36:
            GenImagePlannerComponent r17 = this.this$0;
            String r18 = this.$param.c;
            List r19 = (List) this.$cachedBlockList.element;
            this.label = 2;
            r11 = GenImagePlannerComponent.p3(r17, r18, r19, this);
            if (r11 != r0) goto L39;
            return r0;
        L22:
            r6 = false;
            goto L23
        }
    }

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.logic.GenImagePlannerComponent$startGenerateAndObserve$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {
        public final /* synthetic */ CoroutineScope a;
        public final /* synthetic */ Ref.ObjectRef<List<CanvasBlock>> b;
        public final /* synthetic */ GenImagePlannerComponent c;
        public final /* synthetic */ ky8.c d;
        public final /* synthetic */ CompletableDeferred<Unit> e;

        public AnonymousClass2(CoroutineScope r1, Ref.ObjectRef<List<CanvasBlock>> r2, GenImagePlannerComponent r3, ky8.c r4, CompletableDeferred<Unit> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final Object a(com.larus.canvas.feature.component.logic.canvasGenerator.k<? extends List<CanvasBlock>> r33, Continuation<? super Unit> r34) {
            if ((r34 instanceof GenImagePlannerComponent$startGenerateAndObserve$2$2$emit$1) == false) goto L7;
            GenImagePlannerComponent$startGenerateAndObserve$2$2$emit$1 r3 = (GenImagePlannerComponent$startGenerateAndObserve$2$2$emit$1) r34;
            int r4 = r3.label;
            if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
            r3.label = r4 - Integer.MIN_VALUE;
        L8:
            GenImagePlannerComponent$startGenerateAndObserve$2$2$emit$1 r8 = r3;
            Object r2 = r8.result;
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r6 = r8.label;
            if (r6 == 0) goto L18;
            if (r6 == 1) goto L17;
            if (r6 == 2) goto L16;
            if (r6 != 3) goto L15;
            CompletableDeferred<Unit> r1 = (CompletableDeferred) r8.L$0;
            ResultKt.throwOnFailure(r2);
        L133:
            r1.complete(Unit.INSTANCE);
        L135:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            CompletableDeferred<Unit> r7 = (CompletableDeferred) r8.L$1;
            com.larus.canvas.feature.component.logic.canvasGenerator.k r9 = (com.larus.canvas.feature.component.logic.canvasGenerator.k) r8.L$0;
            ResultKt.throwOnFailure(r2);
        L96:
            Boxing.boxBoolean(r7.complete(Unit.INSTANCE));
            goto L135
        L17:
            CompletableDeferred<Unit> r10 = (CompletableDeferred) r8.L$4;
            ky8.c r11 = (ky8.c) r8.L$3;
            GenImagePlannerComponent r12 = (GenImagePlannerComponent) r8.L$2;
            Ref.ObjectRef<List<CanvasBlock>> r13 = (Ref.ObjectRef) r8.L$1;
            com.larus.canvas.feature.component.logic.canvasGenerator.k r14 = (com.larus.canvas.feature.component.logic.canvasGenerator.k) r8.L$0;
            ResultKt.throwOnFailure(r2);
        L40:
            List r15 = (List) r2;
            r13.element = r15;
            IFlowSdkDepend r16 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r16 == null) goto L43;
            r16.r0();
            com.larus.home.impl.sdk.e2.a.x();
        L43:
            GenImagePlannerComponent.C3(r12, r11.c, r15);
            r12.e4().cancelProgress(r11.c);
            Boxing.boxBoolean(r10.complete(Unit.INSTANCE));
            goto L135
        L18:
            ResultKt.throwOnFailure(r2);
            Integer r17 = null;
            if ((r33 instanceof com.larus.canvas.feature.component.logic.canvasGenerator.k.b) == false) goto L21;
            com.larus.canvas.feature.component.logic.canvasGenerator.k.b r18 = (com.larus.canvas.feature.component.logic.canvasGenerator.k.b) r33;
        L22:
            boolean r19 = false;
            if (r18 == null) goto L97;
            Ref.ObjectRef<List<CanvasBlock>> r20 = this.b;
            GenImagePlannerComponent r110 = this.c;
            ky8.c r111 = this.d;
            CompletableDeferred<Unit> r112 = this.e;
            T r113 = r18.a;
            r20.element = r113;
            CanvasBlock r114 = (CanvasBlock) CollectionsKt.firstOrNull((List) r113);
            if (r114 == null) goto L32;
            CanvasImageBlock r115 = r114.content;
            if (r115 == null) goto L32;
            CanvasInfo r116 = r115.canvasInfo;
            if (r116 == null) goto L32;
            r17 = r116.canvasStatus;
        L32:
            if (r17 != null) goto L35;
        L44:
            if (r17 == null) goto L49;
            if (r17.intValue() != 11) goto L49;
        L84:
            ky8.f r21 = r110.O30(r111.c);
            if (r21 == null) goto L92;
            com.larus.canvas.feature.component.logic.trace.a r22 = r110.X3();
            if (r22 == null) goto L89;
            r22.Xv(r21, true);
        L89:
            com.larus.canvas.feature.component.logic.trace.a r23 = r110.X3();
            if (r23 == null) goto L92;
            com.larus.canvas.feature.component.logic.trace.a.C0094a.a(r23, r21, true);
        L92:
            String r24 = r111.c;
            List r25 = (List) r18.a;
            r8.L$0 = r33;
            r8.L$1 = r112;
            r8.label = 2;
            if (GenImagePlannerComponent.j4(r110, r24, r25, null, r8, 12) != r5) goto L95;
            return r5;
        L95:
            r7 = r112;
        L49:
            if (r18.b == false) goto L55;
            if (r17 == null) goto L84;
            if (r17.intValue() != 10) goto L84;
        L55:
            String r117 = r111.c;
            List r26 = (List) r18.a;
            int r27 = GenImagePlannerComponent.W;
            r110.getClass();
            CanvasBlock r28 = (CanvasBlock) CollectionsKt.firstOrNull(r26);
            if (r28 == null) goto L67;
            CanvasImageBlock r29 = r28.content;
            if (r29 == null) goto L67;
            CanvasInfo r30 = r29.canvasInfo;
            if (r30 == null) goto L67;
            Integer r31 = r30.canvasStatus;
            if (r31 == null) goto L67;
            if (r31.intValue() != 10) goto L67;
            boolean r32 = true;
        L68:
            if (r32 == true) goto L81;
            List r118 = GenImagePlannerComponent.Q3(r26);
            if (((ArrayList) r118).isEmpty() == true) goto L81;
            StringBuilder r35 = new StringBuilder();
            r35.append(r117);
            r35.append(':');
            CreationNoWatermarkManager.a.getClass();
            CreationNoWatermarkManager.f r36 = CreationNoWatermarkManager.i(r118);
            if (r36.a() == false) goto L76;
            String r37 = "";
        L77:
            r35.append(r37);
            String r38 = r35.toString();
            if (r110.T.get(r38) != null) goto L81;
            r110.T.put(r38, Unit.INSTANCE);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110), Dispatchers.getIO(), null, new GenImagePlannerComponent$prefetchNoWatermarkBlocksForReview$1(r118, r110, r117, r26, r38, null), 2, null);
            goto L81
        L76:
            r37 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{"image:" + CollectionsKt.joinToString$default(CollectionsKt.sorted(r36.a), ",", null, null, 0, null, null, 62, null), "video:" + CollectionsKt.joinToString$default(CollectionsKt.sorted(r36.b), ",", null, null, 0, null, null, 62, null)}), "|", null, null, 0, null, null, 62, null);
        L81:
            GenImagePlannerComponent.C3(r110, r111.c, (List) r18.a);
            if (r18.b == false) goto L135;
            r110.e4().cancelProgress(r111.c);
        L67:
            r32 = false;
            goto L68
        L35:
            if (r17.intValue() != 10) goto L44;
            String r39 = r111.c;
            List r40 = (List) r18.a;
            r8.L$0 = r33;
            r8.L$1 = r20;
            r8.L$2 = r110;
            r8.L$3 = r111;
            r8.L$4 = r112;
            r8.label = 1;
            r2 = GenImagePlannerComponent.p3(r110, r39, r40, r8);
            if (r2 != r5) goto L39;
            return r5;
        L39:
            r13 = r20;
            r10 = r112;
            r11 = r111;
            r12 = r110;
            goto L40
        L97:
            GenImagePlannerComponent r41 = this.c;
            ky8.c r42 = this.d;
            CompletableDeferred<Unit> r119 = this.e;
            FLogger r43 = FLogger.a;
            StringBuilder r120 = new StringBuilder("generate error, code: ");
            boolean r121 = r33 instanceof com.larus.canvas.feature.component.logic.canvasGenerator.k.a;
            if (r121 == false) goto L100;
            com.larus.canvas.feature.component.logic.canvasGenerator.k.a r122 = (com.larus.canvas.feature.component.logic.canvasGenerator.k.a) r33;
        L101:
            if (r122 == null) goto L103;
            Integer r123 = Boxing.boxInt(r122.a);
        L104:
            r120.append(r123);
            r120.append(", msg: ");
            if (r121 == false) goto L107;
            com.larus.canvas.feature.component.logic.canvasGenerator.k.a r124 = (com.larus.canvas.feature.component.logic.canvasGenerator.k.a) r33;
        L108:
            if (r124 == null) goto L110;
            String r125 = r124.b;
        L111:
            r120.append(r125);
            r43.i("GenImagePlannerComponent", r120.toString());
            ky8.f r44 = r41.O30(r42.c);
            if (r44 == null) goto L122;
            com.larus.canvas.feature.component.logic.trace.a r126 = r41.X3();
            if (r126 != null) goto L116;
        L119:
            com.larus.canvas.feature.component.logic.trace.a r45 = r41.X3();
            if (r45 == null) goto L122;
            com.larus.canvas.feature.component.logic.trace.a.C0094a.a(r45, r44, true);
            goto L122
        L116:
            if (r44.a() == null) goto L118;
            r19 = true;
        L118:
            r126.Xv(r44, r19);
        L122:
            String r46 = r42.c;
            if (r121 == false) goto L125;
            com.larus.canvas.feature.component.logic.canvasGenerator.k.a r47 = (com.larus.canvas.feature.component.logic.canvasGenerator.k.a) r33;
        L126:
            if (r47 == null) goto L128;
            String r48 = Boxing.boxInt(r47.a).toString();
        L129:
            r8.L$0 = r119;
            r8.L$1 = null;
            r8.L$2 = null;
            r8.L$3 = null;
            r8.L$4 = null;
            r8.label = 3;
            if (GenImagePlannerComponent.j4(r41, r46, null, r48, r8, 8) != r5) goto L132;
            return r5;
        L132:
            r1 = r119;
            goto L133
        L128:
            r48 = null;
            goto L129
        L125:
            r47 = null;
            goto L126
        L110:
            r125 = null;
            goto L111
        L107:
            r124 = null;
            goto L108
        L103:
            r123 = null;
            goto L104
        L100:
            r122 = null;
            goto L101
        L21:
            r18 = null;
        L7:
            r3 = new GenImagePlannerComponent$startGenerateAndObserve$2$2$emit$1(this, r34);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a((com.larus.canvas.feature.component.logic.canvasGenerator.k) r1, r2);
        }
    }

    public GenImagePlannerComponent$startGenerateAndObserve$2(GenImagePlannerComponent r1, ky8.c r2, CompletableDeferred<Unit> r3, Continuation<? super GenImagePlannerComponent$startGenerateAndObserve$2> r4) {
        this.this$0 = r1;
        this.$param = r2;
        this.$releaseSignal = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        GenImagePlannerComponent$startGenerateAndObserve$2 r0 = new GenImagePlannerComponent$startGenerateAndObserve$2(this.this$0, this.$param, this.$releaseSignal, r6);
        r0.L$0 = r5;
        return r0;
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
    L12:
        if (this.$releaseSignal.isCompleted() == true) goto L15;
        this.$releaseSignal.complete(Unit.INSTANCE);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = CollectionsKt.emptyList();
        GenImagePlannerComponent r2 = this.this$0;
        int r3 = GenImagePlannerComponent.W;
        FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 r9 = new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(kotlinx.coroutines.flow.e.n(((com.larus.canvas.feature.component.logic.canvasGenerator.j) r2.z.getValue()).a(this.$param, com.larus.canvas.feature.component.logic.canvasGenerator.h.b)), new AnonymousClass1(r13, this.this$0, this.$param, this.$releaseSignal, null));
        AnonymousClass2 r5 = new AnonymousClass2(r4, r13, this.this$0, this.$param, this.$releaseSignal);
        this.label = 1;
        if (r9.collect(r5, this) != r0) goto L12;
        return r0;
    }
}
