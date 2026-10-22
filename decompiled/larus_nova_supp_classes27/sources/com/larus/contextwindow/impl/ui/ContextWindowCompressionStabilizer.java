package com.larus.contextwindow.impl.ui;

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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ContextWindowCompressionStabilizer {
    public final CoroutineScope a;
    public final long b;
    public final StateFlowImpl c;
    public boolean d;
    public Job e;
    public final b1 f;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.ui.ContextWindowCompressionStabilizer$update$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.contextwindow.impl.ui.ContextWindowCompressionStabilizer$update$1", f = "ContextWindowCompressionStabilizer.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextWindowCompressionStabilizer this$0;

        public AnonymousClass1(ContextWindowCompressionStabilizer r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
        L11:
            ContextWindowCompressionStabilizer r7 = this.this$0;
            if (r7.d == false) goto L14;
            r7.c.setValue(Boxing.boxBoolean(true));
        L14:
            this.this$0.e = null;
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            long r3 = this.this$0.b;
            this.label = 1;
            if (DelayKt.delay(r3, this) != r0) goto L11;
            return r0;
        }
    }

    static {
    }

    public final void update(boolean r9) {
        if (this.d != r9) goto L5;
        return;
    L5:
        this.d = r9;
        Job r0 = this.e;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        this.e = null;
        if (r9 == true) goto L13;
        this.c.setValue(Boolean.FALSE);
        return;
    L13:
        if (((Boolean) this.c.getValue()).booleanValue() == false) goto L15;
        return;
    L15:
        this.e = BuildersKt.launch$default(this.a, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public ContextWindowCompressionStabilizer(CoroutineScope r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.a = r3;
        this.b = 1000;
        StateFlowImpl r5 = j1.a(Boolean.valueOf(r4));
        this.c = r5;
        this.d = r4;
        this.f = kotlinx.coroutines.flow.e.b(r5);
    }
}
