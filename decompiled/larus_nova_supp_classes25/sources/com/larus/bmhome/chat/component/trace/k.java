package com.larus.bmhome.chat.component.trace;

import by7.e;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k implements Function1 {
    public final /* synthetic */ ChatTraceComponent a;

    public /* synthetic */ k(ChatTraceComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        ChatTraceComponent r0 = this.a;
        boolean r7 = ((Boolean) r6).booleanValue();
        int r1 = ChatTraceComponent.L;
        e r2 = a.c(r0);
        if ((r2 instanceof e) == false) goto L5;
        e r3 = r2;
    L6:
        JSONObject r4 = new JSONObject();
        Intrinsics.checkNotNullParameter(r4, "params");
        r4.put("is_fullscreen", r7 ? 1 : 0);     // Catch: JSONException -> L9
    L11:
        TrackParams r8 = new TrackParams().merge(r4);
        by7.a r5 = new by7.a("enter_chat");
        if (r3 == null) goto L14;
        r5.b = r3;
    L14:
        r5.a.merge(r8);
        r5.b();
        return Unit.INSTANCE;
    L9:
        e = move-exception;
        FLogger.a.e("EnterEventHelper", "error in EnterEventHelper enterChat " + e.getLocalizedMessage());
        goto L11
    L5:
        r3 = null;
        goto L6
    }
}
