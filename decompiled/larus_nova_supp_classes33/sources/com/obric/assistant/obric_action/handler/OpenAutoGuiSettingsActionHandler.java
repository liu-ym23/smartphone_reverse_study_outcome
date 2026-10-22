package com.obric.assistant.obric_action.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.settings.autogui.ObricAutoGuiSettingsActivity;
import com.obric.assistant.settings.c0;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/OpenAutoGuiSettingsActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenAutoGuiSettingsActionHandler implements IObricActionHandler<String, Unit> {

    public static final class a {
    }

    static {
    }

    public OpenAutoGuiSettingsActionHandler() {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.k.a;
        return d.k.a;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<String> b() {
        return String.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final String a(Context r1, String r2) {
        return (String) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r4, String r5, Continuation<? super h<? extends Unit>> r6) {
        int r7 = com.obric.assistant.settings.autogui.d.a;
        boolean r0 = true;
        if (Build.VERSION.SDK_INT < 23) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == true) goto L8;
    L12:
        r0 = false;
    L14:
        if (r0 == true) goto L26;
        FLogger.a.w("OpenAutoGuiSettingsActionHandler", "execute: auto gui settings unavailable");
        return h.a.a(h.d, "auto gui settings unavailable", 2);
    L26:
        Intent r1 = new Intent(r4, ObricAutoGuiSettingsActivity.class);     // Catch: Exception -> L21 CancellationException -> L24
        c0.b(r1, r4);     // Catch: Exception -> L21 CancellationException -> L24
        if ((r4 instanceof Activity) == true) goto L19;
        r1.addFlags(268435456);     // Catch: Exception -> L21 CancellationException -> L24
    L19:
        r4.startActivity(r1);     // Catch: Exception -> L21 CancellationException -> L24
    L29:
        return h.a.c(h.d, null, null, 3);
    L24:
        e = move-exception;
        throw e;
    L21:
        e = move-exception;
        FLogger.a.w("OpenAutoGuiSettingsActionHandler", "startActivity failed. " + e.getMessage(), e);
        return h.a.a(h.d, e.getMessage(), 2);
    L8:
        if (com.obric.assistant.settings.autogui.d.a() == false) goto L12;
        if (com.obric.assistant.settings.autogui.d.b() == true) goto L12;
    L5:
        r8 = false;
        goto L6
    }
}
