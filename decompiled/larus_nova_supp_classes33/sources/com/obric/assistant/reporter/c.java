package com.obric.assistant.reporter;

import android.os.Bundle;
import by7.g;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Bundle r5, boolean r6) {
        g r0 = g.d;
        JSONObject r1 = new JSONObject();
        if (r5 == null) goto L10;
        Set<String> r2 = r5.keySet();
        if (r2 == null) goto L10;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        String r4 = (String) r3.next();
        r1.put(r4, r5.get(r4));
    L10:
        r1.put("is_success", r6 ? 1 : 0);
        Unit r7 = Unit.INSTANCE;
        r0.onEvent("obric_lockscreen_auth_result", r1);
    }
}
