package com.obric.assistant.obric_action.handler.chat_page;

import android.content.Context;
import android.widget.Toast;
import cfa.g;
import cfa.i;
import com.larus.account.base.api.ILoginService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindow$DefaultImpls;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/OpenWindowActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/chat_page/OpenWindowActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/chat_page/OpenWindowActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenWindowActionHandler implements IObricActionHandler<i, Unit> {
    public static final /* synthetic */ int c = 0;
    public final Class<i> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.C0010d.a;
        return d.C0010d.a;
    }

    public OpenWindowActionHandler() {
        this.b = i.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<i> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final i a(Context r1, String r2) {
        return (i) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r19, i r20, Continuation<? super h<? extends Unit>> r21) {
        i r0 = r20;
        if (r0 != null) goto L5;
        r0 = new i(0);
    L5:
        FLogger r2 = FLogger.a;
        r2.i("OpenWindowActionHandler", "handle: params=" + r0);
        IAssistantChatWindow r5 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r5 != null) goto L8;
        r2.w("OpenWindowActionHandler", "handle: AssistantChatWindow service is null");
        return h.a.a(h.d, "AssistantChatWindow service is null", 2);
    L8:
        String r6 = r0.a();
        if (ILoginService.a.getAccountInfo().a == true) goto L12;
        r2.i("OpenWindowActionHandler", "handle: user not login, launch login");
        com.obric.assistant.spi.keyguard.a.a(new g(), new cfa.h(), null, false, 28);
        return h.a.a(h.d, "user not login", 2);
    L12:
        if (r0.d() == true) goto L16;
        if (r5.isWindowMode() != true) goto L16;
    L18:
        r2.i("OpenWindowActionHandler", "handle: open window, params=" + r0);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        IAssistantChatWindow$DefaultImpls.openChatWindow$default(r5, r6, r0.b(), r0.g(), null, r0.c(), r0.f(), MapsKt.mapOf(TuplesKt.to("scene", r6)), null, r0.e(), r0.d(), 136, null);     // Catch: Throwable -> L21
        Object r3 = Result.constructor-impl(h.a.c(h.d, null, null, 3));     // Catch: Throwable -> L21
    L23:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L26;
        FLogger.a.w("OpenWindowActionHandler", "handle: open window failed. " + r4.getMessage(), r4);
    L26:
        h r7 = h.a.a(h.d, "open window failed", 2);
        if (Result.isFailure-impl(r3) == true) goto L29;
        return r3;
    L29:
        return r7;
    L21:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        if (r19.getResources().getConfiguration().orientation != 2) goto L18;
        r2.i("OpenWindowActionHandler", "handle: activity mode does not support landscape");
        Toast.makeText(r19.getApplicationContext(), 2131912394, 0).show();
        return h.a.a(h.d, "activity mode does not support landscape", 2);
    }
}
