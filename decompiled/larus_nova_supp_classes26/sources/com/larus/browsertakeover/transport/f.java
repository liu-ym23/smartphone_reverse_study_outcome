package com.larus.browsertakeover.transport;

import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final f a = null;
    public static final Set<String> b = null;

    public f() {
    }

    static {
        a = new f();
        b = SetsKt.setOf(new String[]{"Page.screencastVisibilityChanged", "Page.frameNavigated", "Page.navigatedWithinDocument", "Page.loadEventFired", "Inspector.targetCrashed", "Inspector.detached"});
    }

    public static boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(new JSONObject(r2));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = null;
    L10:
        JSONObject r4 = (JSONObject) r3;
        if (r4 != null) goto L14;
        return true;
    L14:
        if (r4.has("id") == false) goto L16;
        return true;
    L16:
        String r5 = r4.optString("method");
        Intrinsics.checkNotNullParameter(r5, "method");
        if (Intrinsics.areEqual(r5, "Page.screencastFrame") == false) goto L20;
        return false;
    L20:
        return b.contains(r5);
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
