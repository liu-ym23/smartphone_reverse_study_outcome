package com.bytedance.android.anniex.detect;

import android.view.View;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$observeAViewResult$1", f = "AnnieXBlankDetectorManager.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
final class AnnieXBlankDetectorManager$observeAViewResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $config;
    final /* synthetic */ b $detector;
    final /* synthetic */ View $view;
    int label;

    public static final class a implements FlowCollector<g> {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final Object emit(Object r10, Continuation r11) {
            g r12 = (g) r10;
            HybridLogger r13 = HybridLogger.a;
            HybridLogger.m("AnnieXBlankDetect", "检测结束，检测结果: " + r12, null, null, 12);
            int r14 = com.bytedance.android.anniex.detect.a.a;
            e r15 = this.a;
            Intrinsics.checkNotNullParameter(r12, "detectionStatus");
            Intrinsics.checkNotNullParameter(r15, "config");
            s26.d r0 = s26.d.c;
            r r1 = s26.d.c.c(r.class);
            if (r1 == null) goto L20;
            c1 r16 = new c1("bdx_monitor_anniex_blank_detect_result", null, null, null, null, 254);
            r16.k = r15.getIdentifier();
            JSONObject r17 = new JSONObject();
            r17.put("is_detect_finish", r12.a);
            r17.put("is_pitaya_ready", r12.b);
            r17.put("is_enable_pure_blank_check", r12.h);
            r17.put("is_enable_partial_blank_check", r12.l);
            r17.put("is_pitaya_ready", r12.b);
            if (r12.e == false) goto L7;
        L10:
            boolean r18 = true;
        L11:
            r17.put("is_blank", r18);
            r17.put("is_pixel_copy_success", r12.c);
            r17.put("is_pixel_copy_cost", r12.d);
            r17.put("is_pure_blank", r12.e);
            r17.put("is_pure_blank_timeout", r12.f);
            r17.put("pure_blank_cost", r12.g);
            r17.put("is_partial_blank", r12.i);
            r17.put("is_partial_blank_timeout", r12.j);
            r17.put("partial_blank_cost", r12.k);
            r17.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r12.m.toString());
            r17.put("bboxs", r12.n);
            r17.put("class_labels", r12.o);
            r17.put("scores", r12.p);
            if (r12.i == false) goto L15;
            String r19 = "partial_blank";
        L18:
            r17.put("render_error_type", r19);
            r17.put("origin_schema_url", r15.d.toString());
            r16.d = r17;
            r16.j = r15.a;
            r1.S(r16);
            goto L20
        L15:
            if (r12.e == false) goto L17;
            r19 = "pure_blank";
            goto L18
        L17:
            r19 = "";
            goto L18
        L7:
            if (r12.i == true) goto L10;
            r18 = false;
        L20:
            return Unit.INSTANCE;
        }
    }

    public AnnieXBlankDetectorManager$observeAViewResult$1(b r1, View r10, e r11, Continuation<? super AnnieXBlankDetectorManager$observeAViewResult$1> r12) {
        this.$detector = r1;
        this.$view = r10;
        this.$config = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AnnieXBlankDetectorManager$observeAViewResult$1(this.$detector, this.$view, this.$config, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        b r11 = this.$detector;
        View r12 = this.$view;
        g r13 = new g(null);
        r13.h = Boxing.boxBoolean(AnnieXBlankDetectorManager.b().b);
        r13.l = Boxing.boxBoolean(AnnieXBlankDetectorManager.b().c);
        Unit r14 = Unit.INSTANCE;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r13, "detectionStatus");
        Flow r15 = kotlinx.coroutines.flow.e.w(kotlinx.coroutines.flow.e.w(new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(new kotlinx.coroutines.flow.c1(new AnnieXBlankDetector$asFlow$1(r12, r11, r13, null)), new AnnieXBlankDetector$asFlow$2(r13, null)), Dispatchers.getIO()), Dispatchers.getMain().getImmediate());
        a r16 = new a(this.$config);
        this.label = 1;
        if (r15.collect(r16, this) != r0) goto L12;
        return r0;
    }
}
