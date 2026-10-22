package com.obric.assistant.obric_action.handler.feedback;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import dfa.b;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/feedback/FeedbackSoundActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/feedback/FeedbackSoundActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/feedback/FeedbackSoundActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackSoundActionHandler implements IObricActionHandler<b, Unit> {
    public final Class<b> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.e.a;
        return d.e.c;
    }

    public FeedbackSoundActionHandler() {
        this.b = b.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<b> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final b a(Context r1, String r2) {
        return (b) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r3, b r4, Continuation<? super h<? extends Unit>> r5) {
        b r6 = r4;
        String r7 = null;
        if (r6 == null) goto L5;
        String r8 = r6.a();
    L6:
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        String r9 = StringsKt.trim(r8).toString().toLowerCase(Locale.ROOT);
        switch(r9.hashCode()) {
            case -1996763020: goto L50;
            case -1655974669: goto L46;
            case -1218715461: goto L42;
            case -624136624: goto L38;
            case 3127582: goto L34;
            case 3540994: goto L30;
            case 1090594823: goto L26;
            case 1117703958: goto L23;
            case 1124446108: goto L19;
            case 1224578480: goto L16;
            case 1957667673: goto L12;
            default: goto L53;
        };
    L53:
        FLogger r10 = FLogger.a;
        StringBuilder r0 = new StringBuilder("handle: unsupported sound=");
        if (r6 == null) goto L56;
        r7 = r6.a();
    L56:
        r0.append(r7);
        r10.w("FeedbackSoundActionHandler", r0.toString());
        return h.a.a(h.d, "unsupported sound", 2);
    L12:
        if (r9.equals("call_user_clarify_notify") == false) goto L53;
        SoundEffectHelper.INSTANCE.playCallUserClarifyNotify();
        return h.a.c(h.d, null, null, 3);
    L16:
        if (r9.equals("thinking") == false) goto L53;
    L40:
        SoundEffectHelper.INSTANCE.playSendMessage();
        return h.a.c(h.d, null, null, 3);
    L19:
        if (r9.equals("warning") == false) goto L53;
        SoundEffectHelper.INSTANCE.playWarning();
        return h.a.c(h.d, null, null, 3);
    L23:
        if (r9.equals("wake_up") == false) goto L53;
    L48:
        SoundEffectHelper.INSTANCE.playActivate();
        return h.a.c(h.d, null, null, 3);
    L26:
        if (r9.equals("release") == false) goto L53;
        SoundEffectHelper.INSTANCE.playRelease();
        return h.a.c(h.d, null, null, 3);
    L30:
        if (r9.equals("stop") == false) goto L53;
        SoundEffectHelper.INSTANCE.stopAsync();
        return h.a.c(h.d, null, null, 3);
    L34:
        if (r9.equals("exit") == false) goto L53;
        SoundEffectHelper.INSTANCE.playExit();
        return h.a.c(h.d, null, null, 3);
    L38:
        if (r9.equals("send_message") == true) goto L40;
    L42:
        if (r9.equals("listening") == false) goto L53;
        SoundEffectHelper.INSTANCE.playListening();
        return h.a.c(h.d, null, null, 3);
    L46:
        if (r9.equals("activate") == true) goto L48;
    L50:
        if (r9.equals("deactivate") == false) goto L53;
        SoundEffectHelper.INSTANCE.playDeactivate();
        return h.a.c(h.d, null, null, 3);
    L5:
        r8 = null;
        goto L6
    }
}
