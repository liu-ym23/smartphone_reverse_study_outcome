package com.obric.assistant.obric_action.handler.auth;

import afa.f;
import afa.g;
import afa.j;
import android.content.Context;
import bfa.b;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/auth/RequestDeviceCredentialAuthActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/auth/RequestDeviceCredentialAuthActionParams;", "Lcom/obric/assistant/obric_action/handler/auth/result/RequestAuthenticationActionResult;", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/auth/RequestDeviceCredentialAuthActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestDeviceCredentialAuthActionHandler implements IObricActionHandler<g, b> {
    public static final /* synthetic */ int c = 0;
    public final Class<g> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.c.a;
        return d.c.f;
    }

    public RequestDeviceCredentialAuthActionHandler() {
        this.b = g.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<g> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final g a(Context r1, String r2) {
        return (g) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r3, g r4, Continuation<? super h<? extends b>> r5) {
        final g r6 = r4;
        if (r6 != null) goto L5;
        r6 = new g(0);
    L5:
        final ISessionAuthenticationService r0 = j.d("RequestDeviceCredentialAuthActionHandler");
        if (r0 != null) goto L9;
        return h.a.a(h.d, "ISessionAuthenticationService is null", 2);
    L9:
        return j.c("RequestDeviceCredentialAuthActionHandler", new f(r0, r6), r5);
    }
}
