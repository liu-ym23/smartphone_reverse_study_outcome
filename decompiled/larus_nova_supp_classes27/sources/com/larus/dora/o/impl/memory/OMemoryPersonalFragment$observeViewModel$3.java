package com.larus.dora.o.impl.memory;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryPersonalFragment$observeViewModel$3", f = "OMemoryPersonalFragment.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
final class OMemoryPersonalFragment$observeViewModel$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OMemoryPersonalFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.o.impl.memory.OMemoryPersonalFragment$observeViewModel$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "code", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryPersonalFragment$observeViewModel$3$1", f = "OMemoryPersonalFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ OMemoryPersonalFragment this$0;

        public AnonymousClass1(OMemoryPersonalFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(Long r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Long) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r6);
            Long r7 = (Long) this.L$0;
            if (r7 != null) goto L9;
            return Unit.INSTANCE;
        L9:
            if (r7.longValue() != 1) goto L12;
            t19.s r8 = t19.s.a;
            Context r0 = this.this$0.getContext();
            r8.getClass();
            t19.s.s(r0, 2131902531);
        L15:
            OMemoryPersonalFragment r9 = this.this$0;
            int r1 = OMemoryPersonalFragment.h;
            r9.U90().resetSaveRejectCode();
            return Unit.INSTANCE;
        L12:
            if (r7.longValue() != 3) goto L14;
            t19.s r10 = t19.s.a;
            Context r2 = this.this$0.getContext();
            r10.getClass();
            t19.s.s(r2, 2131902530);
            goto L15
        L14:
            t19.s r11 = t19.s.a;
            Context r3 = this.this$0.getContext();
            r11.getClass();
            t19.s.b(r3, 2131903465, false);
            goto L15
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public OMemoryPersonalFragment$observeViewModel$3(OMemoryPersonalFragment r1, Continuation<? super OMemoryPersonalFragment$observeViewModel$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OMemoryPersonalFragment$observeViewModel$3(this.this$0, r3);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        OMemoryPersonalFragment r7 = this.this$0;
        int r2 = OMemoryPersonalFragment.h;
        i1<Long> r8 = r7.U90().getSaveRejectCode();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r8, r3, this) != r0) goto L12;
        return r0;
    }
}
