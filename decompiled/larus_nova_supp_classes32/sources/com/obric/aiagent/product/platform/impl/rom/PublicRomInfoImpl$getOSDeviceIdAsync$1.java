package com.obric.aiagent.product.platform.impl.rom;

import android.content.Context;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.product.platform.impl.rom.PublicRomInfoImpl$getOSDeviceIdAsync$1", f = "PublicRomInfoImpl.kt", i = {0}, l = {83}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class PublicRomInfoImpl$getOSDeviceIdAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $callback;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ PublicRomInfoImpl this$0;

    public static final class a implements com.obric.matrixpro.sdk.deviceinfoclient.a.a {
        public final /* synthetic */ PublicRomInfoImpl a;
        public final /* synthetic */ Function1<String, Unit> b;

        public final void onError(String r4) {
            Intrinsics.checkNotNullParameter(r4, "errorMsg");
            ILogDepend.a.i("PublicRomInfoImpl", "errorMsg: " + r4);
        }

        public final void onSuccess(String r3) {
            Intrinsics.checkNotNullParameter(r3, "osDid");
            this.a.b = r3;
            this.b.invoke(r3);
            ILogDepend.a.i("PublicRomInfoImpl", "getOSDeviceIdAsync: " + this.a.b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(PublicRomInfoImpl r1, Function1<? super String, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PublicRomInfoImpl$getOSDeviceIdAsync$1(PublicRomInfoImpl r1, Function1<? super String, Unit> r2, Continuation<? super PublicRomInfoImpl$getOSDeviceIdAsync$1> r3) {
        this.this$0 = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PublicRomInfoImpl$getOSDeviceIdAsync$1(this.this$0, this.$callback, r4);
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
        PublicRomInfoImpl r2 = (PublicRomInfoImpl) this.L$2;
        Function1<String, Unit> r3 = (Function1) this.L$1;
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r7);
    L22:
        com.obric.matrixpro.sdk.deviceinfoclient.a r8 = com.obric.matrixpro.sdk.deviceinfoclient.a.e;     // Catch: Throwable -> L14
        Context r5 = IAppContext.a.getContext();     // Catch: Throwable -> L14
        a r6 = new a(r2, r3);     // Catch: Throwable -> L14
        r8.getClass();     // Catch: Throwable -> L14
        com.obric.matrixpro.sdk.deviceinfoclient.a.b(r5, r6);     // Catch: Throwable -> L14
    L16:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r4.unlock(null);
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        r3.invoke(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L19
        ILogDepend.a.e("PublicRomInfoImpl", "catch getOSDeviceIdAsync crash", th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r4.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        PublicRomInfoImpl r10 = this.this$0;
        kotlinx.coroutines.sync.a r11 = r10.c;
        Function1<String, Unit> r12 = this.$callback;
        this.L$0 = r11;
        this.L$1 = r12;
        this.L$2 = r10;
        this.label = 1;
        if (r11.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r10;
        r4 = r11;
        r3 = r12;
        goto L22
    }
}
