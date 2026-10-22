package com.obric.assistant.obric_action.handler.router;

import android.content.Context;
import com.bytedance.router.SmartRouter;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/router/DeepLinkActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepLinkActionHandler implements IObricActionHandler<String, Unit> {
    public final Class<String> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.i.a;
        return d.i.a;
    }

    public DeepLinkActionHandler() {
        this.b = String.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<String> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final String a(Context r1, String r2) {
        return (String) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r8, String r9, Continuation<? super h<? extends Unit>> r10) {
        String r11 = r9;
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        boolean r1 = true;
        if (r11.length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L30;
        FLogger r2 = FLogger.a;
        r2.i("DeepLinkActionHandler", "handle: deeplink = ".concat(r11));
        h.a r4 = h.d;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L18
        if (SmartRouter.canOpen(r11) == false) goto L15;
        SmartRouter.buildRoute(r8, r11).d();     // Catch: Throwable -> L18
    L16:
        Object r12 = Result.constructor-impl(Boxing.boxBoolean(r1));     // Catch: Throwable -> L18
    L20:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L23;
        FLogger.a.e("DeepLinkActionHandler", "handle: deeplink = ".concat(r11), r13);
    L23:
        Boolean r14 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r12) == false) goto L27;
        r12 = r14;
    L27:
        return r4.b(((Boolean) r12).booleanValue());
    L15:
        r2.w("DeepLinkActionHandler", "can not open deeplink: ".concat(r11));     // Catch: Throwable -> L18
        r1 = false;
    L18:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L30:
        return h.a.a(h.d, "deeplink is empty", 2);
    L8:
        r0 = false;
        goto L9
    }
}
