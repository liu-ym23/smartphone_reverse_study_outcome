package com.obric.assistant.obric_action.handler.auth;

import afa.b;
import afa.c;
import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.spi.keyguard.IKeyguardService$a;
import com.obric.assistant.spi.keyguard.KeyguardService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/auth/DismissKeyguardActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/auth/DismissKeyguardActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/auth/DismissKeyguardActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DismissKeyguardActionHandler implements IObricActionHandler<c, Unit> {
    public final Class<c> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.c.a;
        return d.c.a;
    }

    public DismissKeyguardActionHandler() {
        this.b = c.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<c> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final c a(Context r1, String r2) {
        return (c) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r12, c r13, Continuation<? super h<? extends Unit>> r14) {
        c r15 = r13;
        if (r15 != null) goto L5;
        r15 = new c(0);
    L5:
        FLogger r1 = FLogger.a;
        r1.i("DismissKeyguardActionHandler", "handle: context=" + r12 + ", params=" + r15);
        KeyguardService r3 = KeyguardService.a;
        boolean r16 = r3.isKeyguardLocked();
        Boolean r4 = r15.e();
        if (r4 == null) goto L8;
        boolean r5 = r4.booleanValue();
    L9:
        Boolean r6 = r15.a();
        if (r6 == null) goto L12;
        boolean r7 = r6.booleanValue();
    L13:
        Boolean r8 = r15.d();
        if (r8 == null) goto L16;
        boolean r9 = r8.booleanValue();
    L17:
        Boolean r10 = r15.c();
        if (r10 == null) goto L20;
        boolean r11 = r10.booleanValue();
    L21:
        Boolean r17 = r15.b();
        if (r17 == null) goto L24;
        boolean r18 = r17.booleanValue();
    L25:
        if (r5 == false) goto L28;
        if (r16 == true) goto L28;
        r1.i("DismissKeyguardActionHandler", "skipWhenKeyguardDismissed and keyguard not locked, return success");
        return h.a.c(h.d, null, null, 3);
    L28:
        j r19 = new j(IntrinsicsKt.intercepted(r14), 1);
        r19.C();
        AtomicBoolean r2 = new AtomicBoolean(false);
        r19.i(new afa.a(r2));
        IKeyguardService$a.a(r3, new b(r2, r19), r11, r9, r7, r18, null, 32);
        Object r110 = r19.B();
        if (r110 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        DebugProbesKt.probeCoroutineSuspended(r14);
        return r110;
    L33:
        return r110;
    L24:
        r18 = false;
        goto L25
    L20:
        r11 = false;
        goto L21
    L16:
        r9 = true;
        goto L17
    L12:
        r7 = true;
        goto L13
    L8:
        r5 = true;
        goto L9
    }

    public static final void e(AtomicBoolean r2, i r3, h r4, String r5) {
        if (r2.compareAndSet(false, true) == true) goto L6;
        FLogger.a.w("DismissKeyguardActionHandler", r5.concat(" ignored because dismissKeyguard result already completed"));
        return;
    L6:
        if (r3.isActive() == true) goto L13;
        FLogger.a.w("DismissKeyguardActionHandler", r5.concat(" ignored because dismissKeyguard continuation is inactive"));
        return;
    L13:
        r3.resumeWith(Result.constructor-impl(r4));     // Catch: IllegalStateException -> L10
        return;
    L10:
        e = move-exception;
        FLogger.a.e("DismissKeyguardActionHandler", r5 + " resume dismissKeyguard result failed. " + e.getMessage(), e);
    }
}
