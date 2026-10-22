package com.obric.assistant.obric_action.handler.chat_page;

import android.content.Context;
import cfa.b;
import cfa.c;
import cfa.j;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/ShowKeyboardActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/chat_page/ShowKeyboardActionParams;", "Lcom/obric/assistant/obric_action/handler/chat_page/KeyboardActionResult;", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/chat_page/ShowKeyboardActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowKeyboardActionHandler implements IObricActionHandler<j, c> {
    public final Class<j> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.C0010d.a;
        return d.C0010d.g;
    }

    public ShowKeyboardActionHandler() {
        this.b = j.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<j> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final j a(Context r1, String r2) {
        return (j) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r6, j r7, Continuation<? super h<? extends c>> r8) {
        j r9 = r7;
        ICoreInputAbility r10 = b.a();
        if (r10 != null) goto L6;
        FLogger.a.w("ShowKeyboardActionHandler", "handle: no available chat input ability");
        return h.a.a(h.d, "no available chat input ability", 2);
    L6:
        if (r9 == null) goto L8;
        boolean r11 = Intrinsics.areEqual(r9.a(), Boxing.boxBoolean(false));
    L10:
        if (r11 == true) goto L21;
        int r12 = r10.Rp();
        if (r12 != 1) goto L14;
    L18:
        boolean r13 = true;
    L19:
        if (r13 == true) goto L21;
        FLogger.a.i("ShowKeyboardActionHandler", "handle: switch to text input before showing keyboard");
        r10.BU(true, true, "ShowKeyboardActionHandler");
        return h.a.c(h.d, new c(true), null, 2);
    L14:
        if (r12 == 3) goto L18;
        if (r12 == 4) goto L18;
        r13 = false;
    L21:
        ICoreInputAbility.b.e(r10, "ShowKeyboardActionHandler", null, false, 6);
        return h.a.c(h.d, new c(true), null, 2);
    L8:
        r11 = false;
        goto L10
    }
}
