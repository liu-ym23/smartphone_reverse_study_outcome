package com.obric.aikernel.runtime.utils;

import androidx.annotation.Keep;
import com.obric.aee.utils.AsyncContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class CommonExtension {

    /* JADX INFO: renamed from: com.obric.aikernel.runtime.utils.CommonExtension$trackingEvent$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.runtime.utils.CommonExtension$trackingEvent$1", f = "CommonExtension.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ JSONObject $data;
        final /* synthetic */ String $key;
        int label;

        AnonymousClass1(String r10, JSONObject r11, Continuation<? super AnonymousClass1> r12) {
            this.$key = r10;
            this.$data = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$key, this.$data, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r10);
            d.f5417a.b(this.$key, this.$data);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CommonExtension() {
    }

    @com.obric.aee.utils.a
    public final boolean getDozeMode() {
        return b.f5415a.b();
    }

    @com.obric.aee.utils.a
    public final String getPyVmSDKVersion() {
        return h.f5430a.a();
    }

    @com.obric.aee.utils.a
    public final void trackingEvent(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "data");
        kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new AnonymousClass1(r10, r11, null), 3, null);
    }

    @com.obric.aee.utils.a(runIn = AsyncContext.IO)
    public final Object waitDozeMode(Continuation<? super Boolean> r10) {
        return b.f5415a.c(r10);
    }
}
