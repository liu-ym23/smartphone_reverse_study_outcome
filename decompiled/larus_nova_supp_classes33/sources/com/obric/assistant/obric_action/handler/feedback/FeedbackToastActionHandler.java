package com.obric.assistant.obric_action.handler.feedback;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import dfa.c;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.j;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/feedback/FeedbackToastActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/feedback/FeedbackToastActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/feedback/FeedbackToastActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackToastActionHandler implements IObricActionHandler<c, Unit> {
    public final Class<c> b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.e.a;
        return d.e.a;
    }

    public FeedbackToastActionHandler() {
        this.b = c.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<c> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final c a(Context r1, String r2) {
        return (c) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r9, c r10, Continuation<? super h<? extends Unit>> r11) {
        c r12 = r10;
        if (r12 == null) goto L71;
        String r0 = r12.c();
        String r1 = "";
        if (r0 != null) goto L8;
        String r4 = "";
    L9:
        boolean r2 = true;
        if (r4.length() != 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        FLogger.a.w("FeedbackToastActionHandler", "handle: text is empty");
        return h.a.a(h.d, "text is empty", 2);
    L15:
        Integer r13 = r12.a();
        if (r13 != null) goto L18;
    L23:
        Integer r5 = null;
    L24:
        String r14 = r12.b();
        if (r14 == null) goto L28;
        r1 = r14;
    L28:
        String r15 = StringsKt.trim(r1).toString().toLowerCase(Locale.ROOT);
        if (r15.length() == 0) goto L32;
        r2 = false;
    L32:
        if (r2 == false) goto L35;
        r15 = "default";
    L35:
        switch(r15.hashCode()) {
            case -1867169789: goto L63;
            case -1086574198: goto L57;
            case 3237038: goto L54;
            case 96784904: goto L51;
            case 97618667: goto L44;
            case 1124446108: goto L38;
            default: goto L68;
        };
    L68:
        s.j(s.a, r9, r4, r5, false, 24);
    L70:
        return h.a.c(h.d, null, null, 3);
    L38:
        if (r15.equals("warning") == false) goto L68;
        if (r5 != null) goto L42;
        s.a.getClass();
        s.t(r9, r4);
        goto L70
    L42:
        s r16 = s.a;
        int r17 = r5.intValue();
        r16.getClass();
        s.u(r9, r4, r17);
        goto L70
    L44:
        if (r15.equals("force") == false) goto L68;
        s.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "text");
        Context r18 = s.f(r9);
        if (r18 == null) goto L70;
        t0.e(new j(r4, r18, r5));
        goto L70
    L51:
        if (r15.equals("error") == false) goto L68;
    L59:
        if (r5 != null) goto L61;
        s.a.getClass();
        s.c(r9, r4);
        goto L70
    L61:
        s r19 = s.a;
        int r110 = r5.intValue();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r4, "text");
        s.l(r9, 2131243493, r4, Integer.valueOf(r110), null, false);
        goto L70
    L54:
        if (r15.equals("info") == false) goto L68;
        s.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r4, "text");
        s.i(r9, r4, r5, false, false, null);
        goto L70
    L57:
        if (r15.equals("failure") == true) goto L59;
    L63:
        if (r15.equals(WindowEvent.WindowOpenPerfResult.SUCCESS) == false) goto L68;
        if (r5 != null) goto L67;
        s.a.getClass();
        s.p(r9, r4);
        goto L70
    L67:
        s r111 = s.a;
        int r112 = r5.intValue();
        r111.getClass();
        s.q(r9, r4, r112);
        goto L70
    L18:
        if (r13.intValue() <= 0) goto L20;
        boolean r6 = true;
    L21:
        if (r6 == false) goto L23;
        r5 = r13;
        goto L24
    L20:
        r6 = false;
        goto L21
    L12:
        r3 = false;
        goto L13
    L8:
        r4 = r0;
        goto L9
    L71:
        return h.a.a(h.d, "params is null", 2);
    }
}
