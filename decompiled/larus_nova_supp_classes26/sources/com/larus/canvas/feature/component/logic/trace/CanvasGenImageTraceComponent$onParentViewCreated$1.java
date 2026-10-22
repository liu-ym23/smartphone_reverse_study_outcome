package com.larus.canvas.feature.component.logic.trace;

import com.ixigua.lib.track.TrackParams;
import com.larus.canvas.feature.component.logic.n2;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.i1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.trace.CanvasGenImageTraceComponent$onParentViewCreated$1", f = "CanvasGenImageTraceComponent.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasGenImageTraceComponent$onParentViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CanvasGenImageTraceComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CanvasGenImageTraceComponent a;

        public a(CanvasGenImageTraceComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            Pair r7 = (Pair) r5;
            int r8 = ((Number) r7.getFirst()).intValue();
            CanvasGenImageTraceComponent r0 = this.a;
            if (r8 == r0.m) goto L38;
            boolean r9 = true;
            r0.p = true;
            n2 r1 = r0.L2();
            if (r1 == null) goto L16;
            i1<ky8.g> r2 = r1.bt();
            if (r2 == null) goto L16;
            ky8.g r3 = (ky8.g) r2.getValue();
            if (r3 == null) goto L16;
            Map<String, ky8.h> r4 = r3.a;
            if (r4 == null) goto L16;
            if (r4.size() != 1) goto L16;
        L17:
            if (r9 == false) goto L19;
            this.a.m = ((Number) r7.getFirst()).intValue();
            return Unit.INSTANCE;
        L19:
            int r10 = ((Number) r7.getFirst()).intValue();
            CanvasGenImageTraceComponent r11 = this.a;
            if (r10 >= r11.m) goto L22;
            String r12 = "left";
        L23:
            n2 r13 = r11.L2();
            if (r13 == null) goto L28;
            Long r14 = r13.XF();
            if (r14 == null) goto L28;
            String r15 = r14.toString();
        L29:
            JSONObject r16 = new JSONObject();
            Intrinsics.checkNotNullParameter(r16, "params");
            r16.putOpt("canvas_id", r15);     // Catch: JSONException -> L32
            r16.putOpt("slide_method", r12);     // Catch: JSONException -> L32
        L34:
            TrackParams r17 = new TrackParams().merge(r16);
            by7.a r18 = new by7.a("ai_generate_canvas_slide");
            r18.a.merge(r17);
            r18.b();
            this.a.m = ((Number) r7.getFirst()).intValue();
            return Unit.INSTANCE;
        L32:
            e = move-exception;
            FLogger.a.e("mobAIGenerateCanvasSlide", "error: " + e.getLocalizedMessage());
        L28:
            r15 = null;
            goto L29
        L22:
            r12 = "right";
        L16:
            r9 = false;
            goto L17
        L38:
            return Unit.INSTANCE;
        }
    }

    public CanvasGenImageTraceComponent$onParentViewCreated$1(CanvasGenImageTraceComponent r1, Continuation<? super CanvasGenImageTraceComponent$onParentViewCreated$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CanvasGenImageTraceComponent$onParentViewCreated$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        n2 r6 = this.this$0.L2();
        if (r6 == null) goto L18;
        b1 r7 = r6.tx();
        if (r7 == null) goto L18;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
