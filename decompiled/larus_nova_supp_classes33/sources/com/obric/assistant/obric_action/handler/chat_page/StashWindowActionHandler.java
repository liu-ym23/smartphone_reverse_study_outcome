package com.obric.assistant.obric_action.handler.chat_page;

import android.content.Context;
import cfa.k;
import cfa.l;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/StashWindowActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/chat_page/WindowVisibilityActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/chat_page/WindowVisibilityActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StashWindowActionHandler implements IObricActionHandler<l, Unit> {
    public final Class<l> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.C0010d.a;
        return d.C0010d.c;
    }

    public StashWindowActionHandler() {
        this.b = l.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<l> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final l a(Context r1, String r2) {
        return (l) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r6, l r7, Continuation<? super h<? extends Unit>> r8) {
        l r9 = r7;
        if (r9 == null) goto L5;
        String r10 = r9.a();
    L6:
        WindowAnimationType r11 = k.a(r10);
        IAssistantChatWindow r12 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r12 != null) goto L10;
        FLogger.a.w("StashWindowActionHandler", "handle: AssistantChatWindow service is null");
        return h.a.a(h.d, "AssistantChatWindow service is null", 2);
    L10:
        if (r12.isWindowMode() == true) goto L13;
        FLogger.a.w("StashWindowActionHandler", "handle: stash window ignored, window mode disabled");
        return h.a.c(h.d, null, null, 3);
    L13:
        if (r12.isShowing() == true) goto L15;
        FLogger.a.w("StashWindowActionHandler", "handle: stash window ignored, window is not showing");
        return h.a.c(h.d, null, null, 3);
    L15:
        FLogger.a.i("StashWindowActionHandler", "handle: stash window, animation=" + r11);
        r12.stash(r11);
        return h.a.c(h.d, null, null, 3);
    L5:
        r10 = null;
        goto L6
    }
}
