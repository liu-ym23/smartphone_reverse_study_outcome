package com.larus.uaigc.createpage.utils;

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
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.ImageEditSendMessageStrategy$observePipelineState$1", f = "ImageEditSendMessageStrategy.kt", i = {}, l = {878}, m = "invokeSuspend", n = {}, s = {})
public final class ImageEditSendMessageStrategy$observePipelineState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $imageMsg;
    final /* synthetic */ com.larus.bmhome.resource.access.b0 $task;
    int label;
    final /* synthetic */ ImageEditSendMessageStrategy this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.utils.ImageEditSendMessageStrategy$observePipelineState$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/bmhome/resource/access/ResourceAccessState;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.utils.ImageEditSendMessageStrategy$observePipelineState$1$1", f = "ImageEditSendMessageStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<com.larus.bmhome.resource.access.a0, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Message $imageMsg;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ImageEditSendMessageStrategy this$0;

        public AnonymousClass1(ImageEditSendMessageStrategy r1, Message r2, Continuation<? super AnonymousClass1> r3) {
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

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L46;
            ResultKt.throwOnFailure(r8);
            com.larus.bmhome.resource.access.a0.e r9 = (com.larus.bmhome.resource.access.a0) this.L$0;
            String r1 = null;
            boolean r2 = true;
            if ((r9 instanceof com.larus.bmhome.resource.access.a0.e) == false) goto L14;
            ImageEditSendMessageStrategy r0 = this.this$0;
            Message r3 = this.$imageMsg;
            com.larus.bmhome.resource.access.a0.e r4 = r9;
            com.larus.bmhome.resource.access.j0.b r5 = r4.c;
            if ((r5 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L9;
            com.larus.bmhome.resource.access.j0.b r6 = r5;
        L10:
            if (r6 == null) goto L12;
            r1 = r6.b;
        L12:
            ImageEditSendMessageStrategy.f(r0, r3, r1);
            this.this$0.l(this.$imageMsg, com.larus.uaigc.createpage.utils.a.a(r4), true);
        L36:
            if ((r9 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L38;
        L42:
            r2 = false;
        L44:
            return Boxing.boxBoolean(r2);
        L38:
            if ((r9 instanceof com.larus.bmhome.resource.access.a0.c) == true) goto L42;
            if ((r9 instanceof com.larus.bmhome.resource.access.a0.a) == true) goto L42;
        L9:
            r6 = null;
            goto L10
        L14:
            if ((r9 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L23;
            ImageEditSendMessageStrategy r7 = this.this$0;
            Message r10 = this.$imageMsg;
            com.larus.bmhome.resource.access.j0.b r11 = ((com.larus.bmhome.resource.access.a0.d) r9).a.b;
            if ((r11 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L18;
            com.larus.bmhome.resource.access.j0.b r12 = r11;
        L19:
            if (r12 == null) goto L21;
            r1 = r12.b;
        L21:
            ImageEditSendMessageStrategy.f(r7, r10, r1);
            this.this$0.l(this.$imageMsg, 98, true);
            goto L36
        L18:
            r12 = null;
            goto L19
        L23:
            if ((r9 instanceof com.larus.bmhome.resource.access.a0.c) == true) goto L36;
            if ((r9 instanceof com.larus.bmhome.resource.access.a0.a) == true) goto L36;
            if (Intrinsics.areEqual(r9, com.larus.bmhome.resource.access.a0.b.a) == false) goto L31;
            this.this$0.l(this.$imageMsg, 5, true);
            goto L36
        L31:
            if ((r9 instanceof com.larus.bmhome.resource.access.a0.f) == false) goto L34;
            ImageEditSendMessageStrategy r13 = this.this$0;
            Message r14 = this.$imageMsg;
            int r15 = com.larus.uaigc.createpage.utils.a.a;
            r13.l(r14, com.larus.uaigc.createpage.utils.a.b(Boxing.boxLong(((com.larus.bmhome.resource.access.a0.f) r9).a)), true);
            goto L36
        L34:
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

    public ImageEditSendMessageStrategy$observePipelineState$1(com.larus.bmhome.resource.access.b0 r1, ImageEditSendMessageStrategy r2, Message r3, Continuation<? super ImageEditSendMessageStrategy$observePipelineState$1> r4) {
        this.$task = r1;
        this.this$0 = r2;
        this.$imageMsg = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageEditSendMessageStrategy$observePipelineState$1(this.$task, this.this$0, this.$imageMsg, r5);
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
