package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0 {
    public static final /* synthetic */ int e = 0;
    public final t1a.b a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        com.larus.bmhome.chat.component.cvs.y r2 = (com.larus.bmhome.chat.component.cvs.y) this.d.getValue();     // Catch: Throwable -> L16
        String r3 = null;
        if (r2 == null) goto L6;
        String r4 = r2.getBotId();     // Catch: Throwable -> L16
    L7:
        r0.put("bot_id", r4);     // Catch: Throwable -> L16
        com.larus.bmhome.chat.component.trace.z r5 = (com.larus.bmhome.chat.component.trace.z) this.b.getValue();     // Catch: Throwable -> L16
        if (r5 == null) goto L10;
        String r6 = r5.getChatType();     // Catch: Throwable -> L16
    L11:
        r0.put("chat_type", r6);     // Catch: Throwable -> L16
        r0.put("current_page", "chat");     // Catch: Throwable -> L16
        de8.c r7 = (de8.c) this.c.getValue();     // Catch: Throwable -> L16
        if (r7 == null) goto L14;
        r3 = r7.p();     // Catch: Throwable -> L16
    L14:
        Object r8 = Result.constructor-impl(r0.put("previous_page", r3));     // Catch: Throwable -> L16
    L18:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L21;
        FLogger.a.e("LatestPhotoShortcutComponent", "[buildCommonParams] failed, " + r9);
    L21:
        return r0;
    L10:
        r6 = null;
        goto L11
    L6:
        r4 = null;
    L16:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public g0(t1a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        this.a = r2;
        this.b = LazyKt.lazy(new d0(this));
        this.c = LazyKt.lazy(new e0(this));
        this.d = LazyKt.lazy(new f0(this));
    }
}
