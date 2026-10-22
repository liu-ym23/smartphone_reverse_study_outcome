package com.larus.dora.impl.serviceimpl;

import android.os.SystemClock;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
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
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.SessionService$syncVUIErrorAsync$2", f = "SessionService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SessionService$syncVUIErrorAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ int $error;
    final /* synthetic */ Map<String, Object> $maps;
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ SessionService this$0;

    public SessionService$syncVUIErrorAsync$2(SessionService r1, int r2, Map<String, ? extends Object> r3, String r4, Continuation<? super SessionService$syncVUIErrorAsync$2> r5) {
        this.this$0 = r1;
        this.$error = r2;
        this.$maps = r3;
        this.$source = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SessionService$syncVUIErrorAsync$2(this.this$0, this.$error, this.$maps, this.$source, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L47;
        ResultKt.throwOnFailure(r14);
        SessionService r15 = this.this$0;
        int r0 = this.$error;
        Map<String, Object> r1 = this.$maps;
        String r2 = this.$source;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r1, "maps");
        Intrinsics.checkNotNullParameter(r2, "source");
        IDoraAVLinkService r16 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        boolean r3 = true;
        int r4 = 0;
        if (r16 != null) goto L7;
    L9:
        boolean r17 = false;
    L10:
        if (r17 == false) goto L12;
    L13:
        IDoraService r18 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r18 == null) goto L20;
        DeviceService r110 = r18.device();
        if (r110 == null) goto L20;
        if (r110.n0("vuiAbilityShift") != true) goto L20;
        boolean r111 = true;
    L21:
        if (r111 == false) goto L43;
        long r6 = SystemClock.elapsedRealtime();
        SessionService.a r112 = SessionService.e;
        monitor-enter(r112);
    L40:
        th = move-exception;
        throw th;
    L26:
        if ((r6 - SessionService.f) >= 2000) goto L29;
        monitor-exit(r112);
    L32:
        if (r3 == false) goto L34;
        FLogger.a.i("DoraOTA", "playPrompt error ignored by debounce");
    L45:
        return Boxing.boxInt(r4);
    L34:
        IDoraService r113 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r113 == null) goto L39;
        f r114 = r113.M0();
        if (r114 == null) goto L39;
        r114.b(2);
    L39:
        FLogger.a.i("DoraOTA", "zchhhhh, syncVUIError from " + r2);
        goto L43
    L29:
        SessionService.f = r6;     // Catch: Throwable -> L40
        monitor-exit(r112);
        r3 = false;
    L43:
        r4 = a.g().syncVUIError(r0, r1);
    L20:
        r111 = false;
        goto L21
    L12:
        if (h49.a.e != 8) goto L43;
    L7:
        if (r16.c1(2) == true) goto L9;
        r17 = true;
        goto L10
    L47:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
