package com.obric.assistant.obric_action.handler.android;

import android.content.Context;
import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/android/ServiceActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Landroid/content/Intent;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ServiceActionHandler implements IObricActionHandler<Intent, Unit> {
    public final Class<Intent> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d.b r0 = d.b.a;
        return d.b.c;
    }

    public ServiceActionHandler() {
        this.b = Intent.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<Intent> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Intent a(Context r1, String r2) {
        return (Intent) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r5, Intent r6, Continuation<? super h<? extends Unit>> r7) {
        Intent r8 = r6;
        if (r8 == null) goto L20;
        FLogger.a.i("ServiceActionHandler", "handle: intent = " + r8);
        h.a r9 = h.d;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        r8.setPackage(r5.getPackageName());     // Catch: Throwable -> L8
        r5.startService(r8);     // Catch: Throwable -> L8
        Object r10 = Result.constructor-impl(Boxing.boxBoolean(true));     // Catch: Throwable -> L8
    L10:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L13;
        FLogger.a.w("ServiceActionHandler", "startService failed. " + r11.getMessage(), r11);
    L13:
        Boolean r12 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r10) == false) goto L17;
        r10 = r12;
    L17:
        return r9.b(((Boolean) r10).booleanValue());
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L20:
        return h.a.a(h.d, "intent is null", 2);
    }
}
