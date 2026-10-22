package com.larus.canvas.feature.component.logic;

import com.larus.bmhome.bigimg.ImageSave;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasImageBlock;
import com.larus.canvas.service.bean.CanvasInfo;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.uaigc.utils.DataConverterKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.CanvasImageOperatorComponent$saveImage$1$1", f = "CanvasImageOperatorComponent.kt", i = {0}, l = {127}, m = "invokeSuspend", n = {"exifMap"}, s = {"L$0"})
public final class CanvasImageOperatorComponent$saveImage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ky8.f $genImageTaskItem;
    final /* synthetic */ String $localId;
    final /* synthetic */ String $url;
    Object L$0;
    int label;
    final /* synthetic */ CanvasImageOperatorComponent this$0;

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.logic.CanvasImageOperatorComponent$saveImage$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.component.logic.CanvasImageOperatorComponent$saveImage$1$1$1", f = "CanvasImageOperatorComponent.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ky8.f $genImageTaskItem;
        int label;

        public AnonymousClass1(ky8.f r1, Continuation<? super AnonymousClass1> r2) {
            this.$genImageTaskItem = r1;
            super(1, r2);
        }

        public final Continuation<Unit> create(Continuation<?> r3) {
            return new AnonymousClass1(this.$genImageTaskItem, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r7 == null) goto L18;
            r7.w();
            com.larus.home.impl.sdk.k1 r8 = com.larus.home.impl.sdk.k1.a;
            UserCreationFromIM r2 = this.$genImageTaskItem.f();
            if (r2 == null) goto L13;
            String r3 = r2.getCreationId();
        L14:
            String r4 = this.$genImageTaskItem.j();
            String r5 = this.$genImageTaskItem.e();
            this.label = 1;
            if (r8.h1(r3, r4, r5, this) != r0) goto L18;
            return r0;
        L13:
            r3 = null;
            goto L14
        }
    }

    public CanvasImageOperatorComponent$saveImage$1$1(ky8.f r1, String r2, CanvasImageOperatorComponent r3, String r4, Continuation<? super CanvasImageOperatorComponent$saveImage$1$1> r5) {
        this.$genImageTaskItem = r1;
        this.$url = r2;
        this.this$0 = r3;
        this.$localId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CanvasImageOperatorComponent$saveImage$1$1(this.$genImageTaskItem, this.$url, this.this$0, this.$localId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Map r2 = (Map) this.L$0;
        ResultKt.throwOnFailure(r11);
        Map r5 = r2;
    L26:
        String r4 = (String) r11;
        this.this$0.h.put(r4, this.$localId);
        ImageSave.x(ImageSave.a, r4, r5, this.this$0.p, new AnonymousClass1(this.$genImageTaskItem, null), true, 16);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        IUgcAIGCService.Companion r12 = IUgcAIGCService.a;
        Map r3 = r12.L(this.$genImageTaskItem.f(), this.$genImageTaskItem.j());
        String r6 = this.$url;
        List<CanvasBlock> r7 = this.$genImageTaskItem.b;
        if (r7 == null) goto L19;
        CanvasBlock r8 = (CanvasBlock) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L19;
        CanvasImageBlock r9 = r8.content;
        if (r9 == null) goto L19;
        CanvasInfo r10 = r9.canvasInfo;
        if (r10 == null) goto L19;
        Integer r13 = r10.taskType;
        if (r13 == null) goto L19;
        String r14 = DataConverterKt.h(r13.intValue());
    L20:
        if (r14 != null) goto L22;
        r14 = "";
    L22:
        this.L$0 = r3;
        this.label = 1;
        r11 = IUgcAIGCService.a.b(r12, r6, r14, this);
        if (r11 != r0) goto L25;
        return r0;
    L25:
        r5 = r3;
    L19:
        r14 = null;
        goto L20
    }
}
