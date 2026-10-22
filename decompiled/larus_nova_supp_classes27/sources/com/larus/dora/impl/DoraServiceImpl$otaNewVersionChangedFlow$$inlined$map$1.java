package com.larus.dora.impl;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraServiceImpl$otaNewVersionChangedFlow$$inlined$map$1 implements Flow<Unit> {
    public final /* synthetic */ Flow a;

    /* JADX INFO: renamed from: com.larus.dora.impl.DoraServiceImpl$otaNewVersionChangedFlow$$inlined$map$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {
        public final /* synthetic */ FlowCollector a;

        /* JADX INFO: renamed from: com.larus.dora.impl.DoraServiceImpl$otaNewVersionChangedFlow$$inlined$map$1$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl$otaNewVersionChangedFlow$$inlined$map$1$2", f = "DoraServiceImpl.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
        public static final class AnonymousClass1 extends ContinuationImpl {
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ AnonymousClass2 this$0;

            public AnonymousClass1(AnonymousClass2 r1, Continuation r2) {
                this.this$0 = r1;
                super(r2);
            }

            public final Object invokeSuspend(Object r2) {
                this.result = r2;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            if ((r6 instanceof AnonymousClass1) == false) goto L7;
            AnonymousClass1 r0 = (AnonymousClass1) r6;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r7 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            ResultKt.throwOnFailure(r7);
        L18:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r7);
            FlowCollector r8 = this.a;
            Map r9 = (Map) r5;
            Unit r10 = Unit.INSTANCE;
            r0.label = 1;
            if (r8.emit(r10, r0) != r2) goto L18;
            return r2;
        L7:
            r0 = new AnonymousClass1(this, r6);
            goto L8
        }
    }

    public DoraServiceImpl$otaNewVersionChangedFlow$$inlined$map$1(b1 r1) {
        this.a = r1;
    }

    public final Object collect(FlowCollector r3, Continuation r4) {
        Object r5 = this.a.collect(new AnonymousClass2(r3), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }
}
