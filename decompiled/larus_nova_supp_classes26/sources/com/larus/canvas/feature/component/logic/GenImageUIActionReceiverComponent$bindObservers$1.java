package com.larus.canvas.feature.component.logic;

import com.bytedance.router.SmartRouter;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasPerfData;
import com.larus.common.apphost.AppHost;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImageUIActionReceiverComponent$bindObservers$1", f = "GenImageUIActionReceiverComponent.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
final class GenImageUIActionReceiverComponent$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GenImageUIActionReceiverComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GenImageUIActionReceiverComponent a;

        public a(GenImageUIActionReceiverComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r30, Continuation r31) {
            com.larus.canvas.feature.component.title.l r0 = (com.larus.canvas.feature.component.title.l) r30;
            GenImageUIActionReceiverComponent r2 = this.a;
            int r3 = GenImageUIActionReceiverComponent.y;
            r2.getClass();
            String r4 = null;
            ky8.f r5 = null;
            if ((r0 instanceof com.larus.canvas.feature.component.title.l.b) == false) goto L29;
            if (AppHost.a.isTestChannel() == false) goto L79;
            n2 r1 = r2.B3();
            if (r1 == null) goto L13;
            kotlinx.coroutines.flow.b1 r6 = r1.tx();
            if (r6 == null) goto L13;
            Pair r7 = (Pair) r6.getValue();
            if (r7 == null) goto L13;
            ky8.h r8 = (ky8.h) r7.getSecond();
        L15:
            if ((r8 instanceof ky8.f) == false) goto L17;
            r5 = (ky8.f) r8;
        L17:
            if (r5 == null) goto L79;
            List<CanvasBlock> r9 = r5.b;
            if (r9 == null) goto L79;
            CanvasBlock r10 = (CanvasBlock) CollectionsKt.firstOrNull(r9);
            if (r10 == null) goto L79;
            com.bytedance.router.i r11 = SmartRouter.buildRoute(r2.getContext(), "//flow/debug_activity");
            r11.c.putExtra("key_debug_canvas", r10);
            com.larus.canvas.feature.component.logic.trace.a r12 = (com.larus.canvas.feature.component.logic.trace.a) r2.s.getValue();
            if (r12 == null) goto L27;
            CanvasPerfData r13 = r12.pZ(r5.a);
            if (r13 == null) goto L27;
            r11.i("key_canvas_perf_data", r13);
        L27:
            r11.d();
        L13:
            r8 = null;
        L79:
            return Unit.INSTANCE;
        L29:
            if ((r0 instanceof com.larus.canvas.feature.component.title.l.a) == false) goto L83;
            com.larus.canvas.feature.component.title.a r14 = ((com.larus.canvas.feature.component.title.l.a) r0).a;
            if ((r14 instanceof com.larus.canvas.feature.component.title.a.b) == false) goto L34;
            r2.G3(true);
            goto L79
        L34:
            if ((r14 instanceof com.larus.canvas.feature.component.title.a.c) == false) goto L71;
            String r15 = ((com.larus.canvas.feature.component.title.a.c) r14).a;
            if (Intrinsics.areEqual(r15, "edit_again") == false) goto L68;
            com.larus.bmhome.instruction.helper.f r16 = r2.x;
            if (r16 == null) goto L40;
            com.larus.bmhome.instruction.helper.f.a.a(r16, null, 7);
        L40:
            my8.q r17 = r2.p3();
            if (r17 == null) goto L43;
            Intrinsics.checkNotNullParameter("edit_again", "<set-?>");
            r17.v = "edit_again";
        L43:
            my8.q r18 = r2.p3();
            if (r18 == null) goto L46;
            String r19 = r18.b();
        L47:
            my8.q r20 = r2.p3();
            if (r20 == null) goto L50;
            String r110 = r20.a();
        L51:
            my8.q r21 = r2.p3();
            if (r21 == null) goto L54;
            String r22 = r21.c();
        L55:
            my8.q r23 = r2.p3();
            if (r23 == null) goto L58;
            String r24 = r23.q;
        L59:
            my8.q r25 = r2.p3();
            if (r25 == null) goto L62;
            String r111 = r25.t;
        L63:
            my8.q r26 = r2.p3();
            if (r26 == null) goto L66;
            r4 = r26.d();
        L66:
            tx9.c0.H(r19, "edit_again", r24, null, r22, r111, r4, r110, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33554184);
            goto L79
        L62:
            r111 = null;
            goto L63
        L58:
            r24 = null;
            goto L59
        L54:
            r22 = null;
            goto L55
        L50:
            r110 = null;
            goto L51
        L46:
            r19 = null;
            goto L47
        L68:
            if (Intrinsics.areEqual(r15, "quit") == false) goto L79;
            r2.m3();
            goto L79
        L71:
            if (Intrinsics.areEqual(r14, com.larus.canvas.feature.component.title.a.d.a) == false) goto L74;
            r2.H3(null);
            goto L79
        L74:
            if (Intrinsics.areEqual(r14, com.larus.canvas.feature.component.title.a.C0095a.a) == false) goto L81;
            com.larus.canvas.feature.component.resultdisplay.image.r r27 = r2.D3();
            if (r27 == null) goto L79;
            r27.yS(new com.larus.canvas.feature.component.resultdisplay.image.t.a(0, true));
            goto L79
        L81:
            throw new NoWhenBranchMatchedException();
        L83:
            throw new NoWhenBranchMatchedException();
        }
    }

    public GenImageUIActionReceiverComponent$bindObservers$1(GenImageUIActionReceiverComponent r1, Continuation<? super GenImageUIActionReceiverComponent$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenImageUIActionReceiverComponent$bindObservers$1(this.this$0, r3);
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
        GenImageUIActionReceiverComponent r6 = this.this$0;
        int r2 = GenImageUIActionReceiverComponent.y;
        com.larus.canvas.feature.component.title.k r7 = (com.larus.canvas.feature.component.title.k) r6.m.getValue();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.a1 r8 = r7.U4();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
