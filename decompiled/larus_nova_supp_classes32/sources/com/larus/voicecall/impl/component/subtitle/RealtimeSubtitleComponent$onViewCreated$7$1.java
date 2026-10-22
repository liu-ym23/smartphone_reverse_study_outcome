package com.larus.voicecall.impl.component.subtitle;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.subtitle.q0;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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
import kotlinx.coroutines.flow.StateFlowImpl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.subtitle.RealtimeSubtitleComponent$onViewCreated$7$1", f = "RealtimeSubtitleComponent.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeSubtitleComponent$onViewCreated$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ q0 $this_apply;
    int label;
    final /* synthetic */ RealtimeSubtitleComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ RealtimeSubtitleComponent a;
        public final /* synthetic */ q0 b;

        public a(RealtimeSubtitleComponent r1, q0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r6, Continuation r7) {
            Pair r8 = (Pair) r6;
            if (r8 == null) goto L36;
            String r9 = ((x3a.a) r8.getSecond()).e;
            List r0 = ((com.larus.bmhome.upload.audio.i) r8.getFirst()).a();
            String r1 = null;
            if (r0 == null) goto L10;
            com.larus.bmhome.upload.audio.h r2 = (com.larus.bmhome.upload.audio.h) CollectionsKt.firstOrNull(r0);
            if (r2 == null) goto L10;
            String r3 = r2.a();
        L12:
            if (Intrinsics.areEqual(r9, r3) == true) goto L19;
            FLogger r10 = FLogger.a;
            StringBuilder r4 = new StringBuilder("key err! first_key=");
            List r5 = ((com.larus.bmhome.upload.audio.i) r8.getFirst()).a();
            if (r5 == null) goto L18;
            com.larus.bmhome.upload.audio.h r11 = (com.larus.bmhome.upload.audio.h) CollectionsKt.firstOrNull(r5);
            if (r11 == null) goto L18;
            r1 = r11.a();
        L18:
            r4.append(r1);
            r4.append(" second_key=");
            r4.append(((x3a.a) r8.getSecond()).e);
            r10.e("RealtimeSubtitleComponent", r4.toString());
            return Unit.INSTANCE;
        L19:
            JSONArray r12 = new JSONArray();
            JSONObject r13 = new JSONObject();
            r13.put("key", ((x3a.a) r8.getSecond()).e);
            List r14 = ((com.larus.bmhome.upload.audio.i) r8.getFirst()).a();
            if (r14 == null) goto L24;
            com.larus.bmhome.upload.audio.h r15 = (com.larus.bmhome.upload.audio.h) CollectionsKt.firstOrNull(r14);
            if (r15 == null) goto L24;
            r1 = r15.b();
        L24:
            r13.put(LynxResourceModule.URI_KEY, r1);
            r13.put("md5", ((x3a.a) r8.getSecond()).a.f);
            r13.put("width", ((x3a.a) r8.getSecond()).b);
            r13.put("height", ((x3a.a) r8.getSecond()).c);
            r13.put("local_upload_timestamp", ((x3a.a) r8.getSecond()).f / ((long) 1000));
            r12.put(r13);
            JSONObject r16 = new JSONObject();
            r16.put("image_list", r12.toString());
            RealtimeSubtitleComponent r17 = this.a;
            int r18 = RealtimeSubtitleComponent.J;
            com.larus.voicecall.impl.component.core.a r19 = (com.larus.voicecall.impl.component.core.a) r17.u.getValue();
            if (r19 == null) goto L27;
            r19.ZQ(r16.toString());
        L27:
            q0 r20 = this.a.H;
            if (r20 == null) goto L30;
            r20.onInterrupt();
        L30:
            IRealtimeCallTracer r21 = this.b.c;
            RealtimeCallParam r22 = (RealtimeCallParam) this.a.p.getValue();
            if (((x3a.a) r8.getSecond()).d != 0) goto L33;
            boolean r23 = true;
        L34:
            r21.m(r22, r23);
            return Unit.INSTANCE;
        L33:
            r23 = false;
        L10:
            r3 = null;
            goto L12
        L36:
            return Unit.INSTANCE;
        }
    }

    public RealtimeSubtitleComponent$onViewCreated$7$1(q0 r1, RealtimeSubtitleComponent r2, Continuation<? super RealtimeSubtitleComponent$onViewCreated$7$1> r3) {
        this.$this_apply = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeSubtitleComponent$onViewCreated$7$1(this.$this_apply, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

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
        q0 r7 = this.$this_apply;
        StateFlowImpl r2 = r7.w;
        a r3 = new a(this.this$0, r7);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
