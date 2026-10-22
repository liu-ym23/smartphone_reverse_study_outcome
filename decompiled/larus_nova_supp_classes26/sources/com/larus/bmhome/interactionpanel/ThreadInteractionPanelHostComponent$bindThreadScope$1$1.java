package com.larus.bmhome.interactionpanel;

import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
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
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.interactionpanel.ThreadInteractionPanelHostComponent$bindThreadScope$1$1", f = "ThreadInteractionPanelHostComponent.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
final class ThreadInteractionPanelHostComponent$bindThreadScope$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $hostId;
    final /* synthetic */ n.b $scope;
    int label;
    final /* synthetic */ ThreadInteractionPanelHostComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.interactionpanel.ThreadInteractionPanelHostComponent$bindThreadScope$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "snapshot", "Lcom/larus/bmhome/interactionpanel/InteractionPanelSnapshot;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.interactionpanel.ThreadInteractionPanelHostComponent$bindThreadScope$1$1$1", f = "ThreadInteractionPanelHostComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<v, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $hostId;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ThreadInteractionPanelHostComponent this$0;

        public AnonymousClass1(ThreadInteractionPanelHostComponent r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$hostId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$hostId, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(v r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((v) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L54;
            ResultKt.throwOnFailure(r8);
            v r9 = (v) this.L$0;
            ThreadInteractionPanelHostComponent r0 = this.this$0;
            String r1 = this.$hostId;
            int r2 = ThreadInteractionPanelHostComponent.r;
            r0.getClass();
            m r10 = r9.c;
            fe8.a r3 = r0.Y2();
            boolean r4 = true;
            if (r3 != null) goto L7;
        L9:
            boolean r5 = false;
        L11:
            if ((!r5) == false) goto L13;
            if (r10 == null) goto L17;
            fe8.c r6 = s1a.d.a(r0).getAbility(fe8.c.class);
            if (r6 == null) goto L25;
            List r7 = r6.nL();
            if (r7 == null) goto L25;
            r4 = e.a(r7);
        L25:
            if (r4 == true) goto L37;
            u r11 = r0.h3();
            m r12 = r0.q;
            if (r12 == null) goto L29;
            o r13 = r12.a;
        L31:
            if (Intrinsics.areEqual(r13, r10.a) == true) goto L34;
            r12 = null;
        L34:
            if (r12 != null) goto L36;
            r12 = r10;
        L36:
            r11.a(r12, "streaming_finished");
            g r14 = r0.m;
            o r15 = r10.a;
            r14.m(r15.a, r15.b, CollectionsKt.listOf(r15), "streaming_finished");
            r0.q = null;
        L52:
            return Unit.INSTANCE;
        L29:
            r13 = null;
            goto L31
        L37:
            m r16 = r0.q;
            if (r16 == null) goto L40;
            o r17 = r16.a;
        L42:
            if (Intrinsics.areEqual(r17, r10.a) == false) goto L44;
            boolean r18 = r0.h3().update(r10, r1);
            FLogger.a.d("ThreadInteractionPanelHost", "update active entry, key=" + r10.a + ", updated=" + r18);
            r0.q = r10;
            goto L52
        L44:
            if (r16 == null) goto L46;
            r0.h3().a(r16, "active_changed");
        L46:
            boolean r19 = r0.h3().b(r10, r1);
            FLogger.a.i("ThreadInteractionPanelHost", "render active entry, key=" + r10.a + ", rendered=" + r19);
            if (r19 == true) goto L50;
            r10 = null;
        L50:
            r0.q = r10;
            goto L52
        L40:
            r17 = null;
            goto L42
        L17:
            if (r0.q == null) goto L52;
            r0.h3().a(r0.q, "active_cleared");
            r0.q = null;
            goto L52
        L13:
            if (r0.q == null) goto L52;
            r0.h3().a(r0.q, "host_gate_blocked");
            r0.q = null;
            goto L52
        L7:
            if (r3.Ny() != true) goto L9;
            r5 = true;
            goto L11
        L54:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ThreadInteractionPanelHostComponent$bindThreadScope$1$1(ThreadInteractionPanelHostComponent r1, n.b r2, String r3, Continuation<? super ThreadInteractionPanelHostComponent$bindThreadScope$1$1> r4) {
        this.this$0 = r1;
        this.$scope = r2;
        this.$hostId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ThreadInteractionPanelHostComponent$bindThreadScope$1$1(this.this$0, this.$scope, this.$hostId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        i1 r8 = this.this$0.m.h(this.$scope);
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$hostId, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r8, r2, this) != r0) goto L12;
        return r0;
    }
}
