package com.larus.canvas.feature.component.logic;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$reportSubCanvasCancel$1", f = "GenImagePlannerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GenImagePlannerComponent$reportSubCanvasCancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $canvasId;
    final /* synthetic */ String $reason;
    final /* synthetic */ List<ky8.f> $toCancelTasks;
    int label;

    public GenImagePlannerComponent$reportSubCanvasCancel$1(List<ky8.f> r1, Long r2, String r3, Continuation<? super GenImagePlannerComponent$reportSubCanvasCancel$1> r4) {
        this.$toCancelTasks = r1;
        this.$canvasId = r2;
        this.$reason = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GenImagePlannerComponent$reportSubCanvasCancel$1(this.$toCancelTasks, this.$canvasId, this.$reason, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r8);
        List<ky8.f> r9 = this.$toCancelTasks;
        Long r0 = this.$canvasId;
        String r1 = this.$reason;
        Iterator<T> r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L24;
        ky8.f r2 = (ky8.f) r10.next();
        String r3 = null;
        if (r0 == null) goto L10;
        String r4 = r0.toString();
    L11:
        String r5 = r2.a;
        ky8.h r6 = r2.c;
        if ((r6 instanceof ky8.f) == false) goto L14;
        ky8.f r7 = (ky8.f) r6;
    L15:
        if (r7 == null) goto L17;
        r3 = r7.a;
    L17:
        JSONObject r11 = new JSONObject();
        Intrinsics.checkNotNullParameter(r11, "params");
        r11.putOpt("canvas_id", r4);     // Catch: JSONException -> L20
        r11.putOpt("local_id", r5);     // Catch: JSONException -> L20
        r11.putOpt("based_local_id", r3);     // Catch: JSONException -> L20
        r11.putOpt("reason", r1);     // Catch: JSONException -> L20
    L22:
        TrackParams r12 = new TrackParams().merge(r11);
        by7.a r13 = new by7.a("ai_generate_sub_canvas_cancel");
        r13.a.merge(r12);
        r13.b();
    L20:
        e = move-exception;
        FLogger.a.e("mobAIGenerateSubCanvasCancel", "error: " + e.getLocalizedMessage());
        goto L22
    L14:
        r7 = null;
        goto L15
    L10:
        r4 = null;
        goto L11
    L24:
        return Unit.INSTANCE;
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
