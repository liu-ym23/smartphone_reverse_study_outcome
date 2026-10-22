package com.larus.dora.impl.serviceimpl;

import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kj4.a;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.SessionService$syncVUIErrorAsync$1", f = "SessionService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SessionService$syncVUIErrorAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ int $error;
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ SessionService this$0;

    public SessionService$syncVUIErrorAsync$1(SessionService r1, int r2, String r3, Continuation<? super SessionService$syncVUIErrorAsync$1> r4) {
        this.this$0 = r1;
        this.$error = r2;
        this.$source = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SessionService$syncVUIErrorAsync$1(this.this$0, this.$error, this.$source, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r7);
        SessionService r8 = this.this$0;
        int r0 = this.$error;
        String r1 = this.$source;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, "source");
        IDoraAVLinkService r9 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        boolean r2 = false;
        if (r9 != null) goto L7;
    L9:
        boolean r10 = false;
    L10:
        if (r10 == false) goto L12;
    L13:
        IDoraService r11 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r11 == null) goto L20;
        DeviceService r12 = r11.device();
        if (r12 == null) goto L20;
        if (r12.n0("vuiAbilityShift") != true) goto L20;
        r2 = true;
    L20:
        if (r2 == false) goto L28;
        IDoraService r13 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r13 == null) goto L26;
        f r14 = r13.M0();
        if (r14 == null) goto L26;
        r14.b(2);
    L26:
        FLogger.a.i("DoraOTA", "zchhhhh, syncVUIError no maps, from " + r1);
    L28:
        return Boxing.boxInt(a.g().syncVUIError(r0));
    L12:
        if (h49.a.e != 8) goto L28;
    L7:
        if (r9.c1(2) == true) goto L9;
        r10 = true;
        goto L10
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
