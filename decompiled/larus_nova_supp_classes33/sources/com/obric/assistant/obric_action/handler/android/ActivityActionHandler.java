package com.obric.assistant.obric_action.handler.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.oauto.IOAutoApi;
import com.obric.assistant.oauto.b;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/android/ActivityActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Landroid/content/Intent;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityActionHandler implements IObricActionHandler<Intent, Unit> {
    public final Class<Intent> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        return d.b.a.getActivity();
    }

    public ActivityActionHandler() {
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
    public final Object d(Context r6, Intent r7, Continuation<? super h<? extends Unit>> r8) {
        Intent r9 = r7;
        if (r9 == null) goto L37;
        FLogger.a.i("ActivityActionHandler", "handle: intent = " + r9);
        h.a r10 = h.d;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L25
        r9.setPackage(r6.getPackageName());     // Catch: Throwable -> L25
        IOAutoApi r3 = b.a();     // Catch: Throwable -> L25
        boolean r4 = true;
        if (r3 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        if (r5 == false) goto L20;
        IOAutoApi r11 = b.a();     // Catch: Throwable -> L25
        if (r11 != null) goto L16;
    L18:
        r4 = false;
    L23:
        Object r12 = Result.constructor-impl(Boxing.boxBoolean(r4));     // Catch: Throwable -> L25
    L27:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L30;
        FLogger.a.w("ActivityActionHandler", "startActivity failed. " + r13.getMessage(), r13);
    L30:
        Boolean r14 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r12) == false) goto L34;
        r12 = r14;
    L34:
        return r10.b(((Boolean) r12).booleanValue());
    L16:
        if (r11.g(r6, r9, false) != true) goto L18;
    L20:
        if ((r6 instanceof Activity) == true) goto L22;
        r9.addFlags(268435456);     // Catch: Throwable -> L25
    L22:
        r6.startActivity(r9);     // Catch: Throwable -> L25
        goto L23
    L9:
        if (r3.c(r9) != true) goto L11;
        r5 = true;
    L25:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L37:
        return h.a.a(h.d, "intent is null", 2);
    }
}
