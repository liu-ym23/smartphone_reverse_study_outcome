package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMessageStrategy$observePipelineProgress$1", f = "CreationMessageStrategy.kt", i = {}, l = {1490}, m = "invokeSuspend", n = {}, s = {})
final class CreationMessageStrategy$observePipelineProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $imageMsg;
    final /* synthetic */ com.larus.bmhome.resource.access.b0 $task;
    int label;
    final /* synthetic */ CreationMessageStrategy this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.sendmessage.CreationMessageStrategy$observePipelineProgress$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/bmhome/resource/access/ResourceAccessState;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMessageStrategy$observePipelineProgress$1$1", f = "CreationMessageStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<com.larus.bmhome.resource.access.a0, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Message $imageMsg;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CreationMessageStrategy this$0;

        public AnonymousClass1(CreationMessageStrategy r1, Message r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$imageMsg = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$imageMsg, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(com.larus.bmhome.resource.access.a0 r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.larus.bmhome.resource.access.a0) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L46;
            ResultKt.throwOnFailure(r7);
            com.larus.bmhome.resource.access.a0.e r8 = (com.larus.bmhome.resource.access.a0) this.L$0;
            if (Intrinsics.areEqual(r8, com.larus.bmhome.resource.access.a0.b.a) == false) goto L7;
            CreationMessageStrategy r0 = this.this$0;
            Message r1 = this.$imageMsg;
            int r2 = CreationMessageStrategy.e;
            r0.u(r1, 5);
        L36:
            if ((r8 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L38;
        L42:
            boolean r9 = false;
        L44:
            return Boxing.boxBoolean(r9);
        L38:
            if ((r8 instanceof com.larus.bmhome.resource.access.a0.c) == true) goto L42;
            if ((r8 instanceof com.larus.bmhome.resource.access.a0.a) == true) goto L42;
            r9 = true;
            goto L44
        L7:
            String r3 = null;
            if ((r8 instanceof com.larus.bmhome.resource.access.a0.e) == false) goto L17;
            CreationMessageStrategy r4 = this.this$0;
            Message r5 = this.$imageMsg;
            com.larus.bmhome.resource.access.a0.e r6 = r8;
            com.larus.bmhome.resource.access.j0.b r10 = r6.c;
            if ((r10 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L12;
            com.larus.bmhome.resource.access.j0.b r11 = r10;
        L13:
            if (r11 == null) goto L15;
            r3 = r11.b;
        L15:
            int r12 = CreationMessageStrategy.e;
            r4.getClass();
            CreationMessageStrategy.C(r5, r3);
            this.this$0.u(this.$imageMsg, com.larus.uaigc.createpage.utils.a.a(r6));
            goto L36
        L12:
            r11 = null;
            goto L13
        L17:
            if ((r8 instanceof com.larus.bmhome.resource.access.a0.f) == false) goto L20;
            CreationMessageStrategy r13 = this.this$0;
            Message r14 = this.$imageMsg;
            int r15 = com.larus.uaigc.createpage.utils.a.a;
            int r16 = com.larus.uaigc.createpage.utils.a.b(Boxing.boxLong(((com.larus.bmhome.resource.access.a0.f) r8).a));
            int r17 = CreationMessageStrategy.e;
            r13.u(r14, r16);
            goto L36
        L20:
            if ((r8 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L29;
            CreationMessageStrategy r18 = this.this$0;
            Message r19 = this.$imageMsg;
            com.larus.bmhome.resource.access.j0.b r20 = ((com.larus.bmhome.resource.access.a0.d) r8).a.b;
            if ((r20 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L24;
            com.larus.bmhome.resource.access.j0.b r21 = r20;
        L25:
            if (r21 == null) goto L27;
            r3 = r21.b;
        L27:
            int r22 = CreationMessageStrategy.e;
            r18.getClass();
            CreationMessageStrategy.C(r19, r3);
            this.this$0.u(this.$imageMsg, 98);
            goto L36
        L24:
            r21 = null;
            goto L25
        L29:
            if ((r8 instanceof com.larus.bmhome.resource.access.a0.c) == true) goto L36;
            if ((r8 instanceof com.larus.bmhome.resource.access.a0.a) == true) goto L36;
            throw new NoWhenBranchMatchedException();
        L46:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a<T> implements FlowCollector {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object emit(Object r1, Continuation r2) {
            com.larus.bmhome.resource.access.a0 r3 = (com.larus.bmhome.resource.access.a0) r1;
            return Unit.INSTANCE;
        }
    }

    public CreationMessageStrategy$observePipelineProgress$1(com.larus.bmhome.resource.access.b0 r1, CreationMessageStrategy r2, Message r3, Continuation<? super CreationMessageStrategy$observePipelineProgress$1> r4) {
        this.$task = r1;
        this.this$0 = r2;
        this.$imageMsg = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationMessageStrategy$observePipelineProgress$1(this.$task, this.this$0, this.$imageMsg, r5);
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
        FlowKt__LimitKt$takeWhile$.inlined.unsafeFlow.1 r3 = new FlowKt__LimitKt$takeWhile$.inlined.unsafeFlow.1(this.$task.a(), new AnonymousClass1(this.this$0, this.$imageMsg, null));
        FlowCollector r8 = a.a;
        this.label = 1;
        if (r3.collect(r8, this) != r0) goto L12;
        return r0;
    }
}
