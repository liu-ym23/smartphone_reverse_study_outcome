package com.larus.dora.dorag.res;

import com.byted.cast.common.api.IMonitor;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements IMonitor {
    public final Function2<String, Map<String, ? extends Object>, Unit> a;

    /* JADX INFO: renamed from: com.larus.dora.dorag.res.a$a, reason: collision with other inner class name */
    public static final class C0027a {
    }

    static {
    }

    public a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "reporter");
        this.a = r2;
    }

    public final void onAppLogEvent(String r6, JSONObject r7) {
        if (r6 != null) goto L5;
    L7:
        r6 = null;
    L9:
        if (r6 != null) goto L16;
        FLogger r8 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onAppLogEvent ignored: invalid eventName, paramCount=");
        if (r7 == null) goto L13;
        int r9 = r7.length();
    L14:
        r1.append(r9);
        r8.w("ByteCastAppLogMonitor", r1.toString());
        return;
    L13:
        r9 = 0;
        goto L14
    L16:
        LinkedHashMap r2 = new LinkedHashMap();
        if (r7 == null) goto L25;
        Iterator<String> r3 = r7.keys();
        if (r3 == null) goto L25;
    L21:
        if (r3.hasNext() == false) goto L25;
        String r4 = r3.next();
        Object r5 = r7.opt(r4);
        if (r5 == null) goto L21;
        r2.put(r4, r5);
    L25:
        FLogger r10 = FLogger.a;
        StringBuilder r11 = new StringBuilder("onAppLogEvent converted: event=");
        r11.append(r6);
        r11.append(", paramCount=");
        r11.append(r2.size());
        r11.append(", params=");
        Intrinsics.checkNotNullParameter(r2, "params");
        r11.append(MapsKt.toSortedMap(r2).toString());
        r10.i("ByteCastAppLogMonitor", r11.toString());
        this.a.invoke(r6, r2);
        return;
    L5:
        if ((!StringsKt.isBlank(r6)) == false) goto L7;
        goto L7
    }
}
