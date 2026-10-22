package com.obric.flow.cardlistpage.apm;

import com.lynx.tasm.utils.k;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.apm.FpsMonitor$stopAndReport$1", f = "FpsMonitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FpsMonitor$stopAndReport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $capturedFrames;
    final /* synthetic */ int $dropped;
    final /* synthetic */ String $scene;
    final /* synthetic */ int $total;
    int label;
    final /* synthetic */ e this$0;

    public FpsMonitor$stopAndReport$1(int r5, e r10, String r11, int r12, int r13, Continuation<? super FpsMonitor$stopAndReport$1> r14) {
        this.$capturedFrames = r5;
        this.this$0 = r10;
        this.$scene = r11;
        this.$dropped = r12;
        this.$total = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new FpsMonitor$stopAndReport$1(this.$capturedFrames, this.this$0, this.$scene, this.$dropped, this.$total, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r12);
        Ref.DoubleRef r13 = new Ref.DoubleRef();
        double r5 = 0.0d;
        int r10 = 0;
        double r11 = 0.0d;
    L5:
        int r14 = this.$capturedFrames;
        if (r10 >= r14) goto L11;
        double r15 = this.this$0.d[r10];
        r11 = r11 + r15;
        if (r15 <= r13.element) goto L10;
        r13.element = r15;
    L10:
        r10 = r10 + 1;
        goto L5
    L11:
        if (r14 <= 0) goto L13;
        double r16 = r11 / ((double) r14);
    L15:
        if (r16 <= 0.0d) goto L17;
        r5 = Math.min(((Number) this.this$0.f11453h.getValue()).floatValue(), 1000.0d / r16);
    L17:
        String r17 = this.$scene;
        int r18 = (int) ((Number) this.this$0.f11453h.getValue()).floatValue();
        int r19 = (int) r5;
        StringCompanionObject r20 = StringCompanionObject.INSTANCE;
        String r21 = String.format("%.2f", Arrays.copyOf(new Object[]{Boxing.boxDouble(r16)}, 1));
        String r22 = String.format("%.2f", Arrays.copyOf(new Object[]{Boxing.boxDouble(r13.element)}, 1));
        int r23 = this.$dropped;
        int r24 = this.$total;
        StringBuilder r25 = new StringBuilder("[");
        r25.append(r17);
        r25.append("] Report: Target=");
        r25.append(r18);
        r25.append("Hz, FPS=");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r25, r19, ", AvgTime=", r21, "ms, MaxTime=");
        r25.append(r22);
        r25.append("ms, DroppedFrames=");
        r25.append(r23);
        r25.append("/");
        r25.append(r24);
        String r26 = r25.toString();
        Intrinsics.checkNotNullParameter("APM_FpsMonitor", "tag");
        Intrinsics.checkNotNullParameter(r26, "msg");
        org.koin.core.a r27 = su.a.f22013b;
        if (r27 == null) goto L22;
        ((ju.b) r27.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("APM_FpsMonitor", r26);
        JSONObject r28 = new JSONObject();
        String r29 = this.$scene;
        e r30 = this.this$0;
        int r31 = this.$dropped;
        int r110 = this.$total;
        r28.put("scene", r29);
        r28.put("target_fps", (int) ((Number) r30.f11453h.getValue()).floatValue());
        r28.put("avg_fps", r19);
        r28.put("avg_time_ms", r16);
        r28.put("max_time_ms", r13.element);
        r28.put("dropped_frames", r31);
        r28.put("total_frames", r110);
        r28.put("metric_type", "fps");
        k.r().a("apm_stat", r28);
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("KoinApplication has not been started");
    L13:
        r16 = 0.0d;
        goto L15
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((FpsMonitor$stopAndReport$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
