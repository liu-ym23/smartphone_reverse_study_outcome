package com.larus.voicecall.impl.component.core;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;
import com.obric.aivoice.core.data.NameKeys;
import java.util.UUID;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.core.RealtimeCoreComponent$listenOnRetryCommands$1", f = "RealtimeCoreComponent.kt", i = {}, l = {540}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCoreComponent$listenOnRetryCommands$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCoreComponent this$0;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.core.RealtimeCoreComponent$listenOnRetryCommands$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "it", "Lcom/larus/voicecall/impl/RealtimeRetryRequest;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.component.core.RealtimeCoreComponent$listenOnRetryCommands$1$3", f = "RealtimeCoreComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<com.larus.voicecall.impl.c0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RealtimeCoreComponent this$0;

        public AnonymousClass3(RealtimeCoreComponent r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public final Object invoke(com.larus.voicecall.impl.c0 r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.larus.voicecall.impl.c0) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r5);
            RealtimeCoreComponent r6 = this.this$0;
            int r0 = RealtimeCoreComponent.P;
            e3a.b r1 = r6.W3();
            r6.X3().i0();
            n3a.a r2 = (n3a.a) r6.y.getValue();
            if (r2 == null) goto L7;
            r2.u00("automatic_click");
        L7:
            RealtimeCallParam.d r3 = r1.a().l;
            String r4 = UUID.randomUUID().toString();
            r3.getClass();
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r3.a = r4;
            if (((h88.b) r1).n == false) goto L19;
            ((h88.b) r1).n = false;
            g3a.a r7 = r6.V3();
            if (r7 == null) goto L19;
            VoiceCallContentLayout r8 = r7.dg();
            if (r8 == null) goto L19;
            if (r8.a.w.getVisibility() != 0) goto L16;
            boolean r9 = true;
        L17:
            if (r9 == false) goto L19;
            com.larus.voicecall.impl.utils.c.d(r8.a.w, false);
            goto L19
        L16:
            r9 = false;
        L19:
            r6.Q3().v(r1.a());
            return Unit.INSTANCE;
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public RealtimeCoreComponent$listenOnRetryCommands$1(RealtimeCoreComponent r1, Continuation<? super RealtimeCoreComponent$listenOnRetryCommands$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCoreComponent$listenOnRetryCommands$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.voicecall.impl.component.core.t0] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.voicecall.impl.component.core.r0] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.voicecall.impl.component.core.s0] */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        RealtimeCoreComponent r9 = this.this$0;
        int r2 = RealtimeCoreComponent.P;
        kotlinx.coroutines.flow.b r10 = ((com.larus.voicecall.impl.d0) r9.Q3().w.getValue()).b;
        final RealtimeCoreComponent r3 = this.this$0;
        ?? r4 = new r0(r3);
        ?? r5 = new s0(r3);
        AnonymousClass3 r6 = new AnonymousClass3(r3, null);
        ?? r7 = new t0();
        this.label = 1;
        Object r11 = r10.collect(new com.larus.voicecall.impl.e0(r4, r5, r6, r7), this);
        if (r11 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r11 = Unit.INSTANCE;
    L12:
        if (r11 != r0) goto L15;
        return r0;
    }
}
