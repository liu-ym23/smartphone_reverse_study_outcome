package com.larus.canvas.feature.component.logic.canvasGenerator;

import com.larus.canvas.service.ICanvasRepoService;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.ImageObject;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/larus/canvas/feature/component/logic/canvasGenerator/SseUpdateData;", "", "Lcom/larus/canvas/service/bean/CanvasBlock;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.canvasGenerator.CanvasGenerator$startStreamGenerate$1", f = "CanvasImageGenerator.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
final class CanvasGenerator$startStreamGenerate$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.k<? super k<? extends List<? extends CanvasBlock>>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ky8.c $requestParam;
    final /* synthetic */ long $timeoutMs;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements ny8.j {
        public final /* synthetic */ ky8.c a;
        public final /* synthetic */ Job b;

        @Override // ny8.j
        public final void cancel() {
            h r0 = h.a;
            by8.a r1 = h.e();
            if (r1 == null) goto L5;
            r1.cancel(this.a.c);
        L5:
            Job.DefaultImpls.cancel$default(this.b, null, 1, null);
        }

        public a(ky8.c r1, Job r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements ny8.c {
        public final /* synthetic */ kotlinx.coroutines.channels.k<k<? extends List<CanvasBlock>>> a;
        public final /* synthetic */ Ref.ObjectRef<Job> b;
        public final /* synthetic */ long c;

        @Override // ny8.c
        public final void onCancel() {
            SendChannel.a.a(this.a);
        }

        @Override // ny8.c
        public final void a(List<CanvasBlock> r4) {
            Intrinsics.checkNotNullParameter(r4, "canvasBlocks");
            this.a.trySend-JP2dKIU(new k.b(r4, false));
            CanvasGenerator$startStreamGenerate$1.access$invokeSuspend$startTimer(this.b, this.a, this.c);
        }

        @Override // ny8.c
        public final void b(List<CanvasBlock> r4) {
            Intrinsics.checkNotNullParameter(r4, "canvasBlocks");
            this.a.trySend-JP2dKIU(new k.b(r4, true));
            SendChannel.a.a(this.a);
        }

        @Override // ny8.c
        public final void onError(int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            this.a.trySend-JP2dKIU(new k.a(r3, r4));
            SendChannel.a.a(this.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(kotlinx.coroutines.channels.k<? super k<? extends List<CanvasBlock>>> r1, Ref.ObjectRef<Job> r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public CanvasGenerator$startStreamGenerate$1(ky8.c r1, long r2, Continuation<? super CanvasGenerator$startStreamGenerate$1> r4) {
        this.$requestParam = r1;
        this.$timeoutMs = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        CanvasGenerator$startStreamGenerate$1 r0 = new CanvasGenerator$startStreamGenerate$1(this.$requestParam, this.$timeoutMs, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((kotlinx.coroutines.channels.k) r1, (Continuation) r2);
    }

    public final Object invoke(kotlinx.coroutines.channels.k<? super k<? extends List<CanvasBlock>>> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r30) {
        CanvasGenerator$startStreamGenerate$1 r0 = this;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r30);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r30);
        kotlinx.coroutines.channels.k r3 = (kotlinx.coroutines.channels.k) r0.L$0;
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        b r4 = new b(r3, r10, r0.$timeoutMs);
        boolean r5 = z2.a.y1();
        h r6 = h.a;
        by8.a r7 = h.e();
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("SSE_KMP startStreamGenerate gateOn=");
        r9.append(r5);
        r9.append(" abilityNonNil=");
        if (r7 == null) goto L11;
        boolean r11 = true;
    L12:
        r9.append(r11);
        r9.append(" localId=");
        r9.append(r0.$requestParam.c);
        r8.i("CanvasGenerator", r9.toString());
        if (r5 == false) goto L15;
        Job r12 = BuildersKt.launch$default(r3, Dispatchers.getIO(), null, new CanvasGenerator$startStreamGenerate$1$kmpJob$1(r0.$requestParam, r4, null), 2, null);
        ConcurrentHashMap<String, ny8.j> r13 = h.d;
        ky8.c r14 = r0.$requestParam;
        r13.put(r14.c, new a(r14, r12));
    L16:
        final ky8.c r15 = r0.$requestParam;
        Function0 r16 = new g(r15, r10);
        r0.label = 1;
        if (ProduceKt.a(r3, r16, r0) != r1) goto L20;
        return r1;
    L15:
        ky8.c r17 = r0.$requestParam;
        r8.i("CanvasGenerator", "startGenerate, localId = " + r17.c);
        ICanvasRepoService.Companion r18 = ICanvasRepoService.a;
        int r19 = r17.a;
        int r20 = r17.b;
        String r110 = r17.c;
        Long r21 = r17.d;
        Long r111 = r17.e;
        List<InstructionTab> r112 = r17.f;
        ImageObject r113 = r17.g;
        String r114 = r17.h;
        List<ImageObject> r22 = r17.i;
        h.d.put(r17.c, r18.a(new ny8.k(Integer.valueOf(r19), Integer.valueOf(r20), r110, r17.j, r17.k, r17.l, r112, r113, null, r21, r111, r114, r17.m, r22, 16640), new d(r17, r4)));
        r0 = this;
        goto L16
    L11:
        r11 = false;
        goto L12
    }

    public static final void access$invokeSuspend$startTimer(Ref.ObjectRef r9, kotlinx.coroutines.channels.k r10, long r11) {
        Job r0 = (Job) r9.element;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        r9.element = BuildersKt.launch$default(r10, null, null, new CanvasGenerator$startStreamGenerate$1$startTimer$1(r11, r10, null), 3, null);
    }
}
