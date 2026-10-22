package com.obric.assistant.obric_action.handler.feedback;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/obric_action/handler/feedback/FeedbackHapticActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/feedback/FeedbackHapticActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/feedback/FeedbackHapticActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveEffect", "Lcom/obric/assistant/interaction/base/feedback/VibratorSmtFeedbackEffect;", "effect", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackHapticActionHandler implements IObricActionHandler<dfa.a, Unit> {
    public final Class<dfa.a> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.e.a;
        return d.e.b;
    }

    public FeedbackHapticActionHandler() {
        this.b = dfa.a.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<dfa.a> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final dfa.a a(Context r1, String r2) {
        return (dfa.a) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r3, dfa.a r4, Continuation<? super h<? extends Unit>> r5) {
        dfa.a r6 = r4;
        String r7 = null;
        if (r6 == null) goto L5;
        String r8 = r6.a();
    L6:
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        String r9 = StringsKt.trim(r8).toString().toLowerCase(Locale.ROOT);
        if (r9.length() != 0) goto L11;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L16;
        r9 = "tick";
    L16:
        switch(r9.hashCode()) {
            case -326696768: goto L43;
            case 3535914: goto L39;
            case 3559837: goto L35;
            case 108511787: goto L31;
            case 951117504: goto L27;
            case 1117703958: goto L23;
            case 1124446108: goto L19;
            default: goto L46;
        };
    L46:
        VibratorSmtFeedbackEffect r10 = null;
    L47:
        if (r10 != null) goto L52;
        FLogger r11 = FLogger.a;
        StringBuilder r1 = new StringBuilder("handle: unsupported effect=");
        if (r6 == null) goto L51;
        r7 = r6.a();
    L51:
        r1.append(r7);
        r11.w("FeedbackHapticActionHandler", r1.toString());
        return h.a.a(h.d, "unsupported haptic effect", 2);
    L52:
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(r10);
        return h.a.c(h.d, null, null, 3);
    L19:
        if (r9.equals("warning") == false) goto L54;
        r10 = VibratorSmtFeedbackEffect.EFFECT_WARNING;
        goto L47
    L54:
        r10 = null;
        goto L47
    L23:
        if (r9.equals("wake_up") == false) goto L55;
        r10 = VibratorSmtFeedbackEffect.EFFECT_WAKE_UP;
        goto L47
    L55:
        r10 = null;
        goto L47
    L27:
        if (r9.equals("confirm") == false) goto L56;
        r10 = VibratorSmtFeedbackEffect.EFFECT_CONFIRM;
        goto L47
    L56:
        r10 = null;
        goto L47
    L31:
        if (r9.equals("rigid") == false) goto L57;
        r10 = VibratorSmtFeedbackEffect.EFFECT_RIGID;
        goto L47
    L57:
        r10 = null;
        goto L47
    L35:
        if (r9.equals("tick") == false) goto L58;
        r10 = VibratorSmtFeedbackEffect.EFFECT_TICK;
        goto L47
    L58:
        r10 = null;
        goto L47
    L39:
        if (r9.equals("soft") == false) goto L59;
        r10 = VibratorSmtFeedbackEffect.EFFECT_SOFT;
        goto L47
    L59:
        r10 = null;
        goto L47
    L43:
        if (r9.equals("long_press") == false) goto L60;
        r10 = VibratorSmtFeedbackEffect.EFFECT_LONG_PRESS;
        goto L47
    L60:
        r10 = null;
        goto L47
    L11:
        r0 = false;
        goto L13
    L5:
        r8 = null;
        goto L6
    }
}
