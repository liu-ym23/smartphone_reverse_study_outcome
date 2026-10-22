package com.lynx.animax.setting;

import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.service.ILynxTrailService;
import com.obric.aivoice.core.data.NameKeys;
import i8a.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import w4a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements c {
    public final ConcurrentHashMap<String, AnimaXSettingValue> a;

    public a() {
        this.a = new ConcurrentHashMap();
    }

    public static AnimaXSettingValue c(Collection r3) {
        if (r3.isEmpty() == false) goto L10;
        List r4 = Collections.emptyList();
        if (r4 != null) goto L9;
        r4 = Collections.emptyList();
    L9:
        return new AnimaXSettingValue(r4);
    L10:
        ArrayList r0 = new ArrayList(r3.size());
        Iterator r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L27;
        Object r1 = r5.next();
        if ((r1 instanceof String) == false) goto L17;
        r0.add((String) r1);
        goto L12
    L17:
        if (r1 == null) goto L19;
        String r6 = r1.getClass().getName();
    L20:
        AnimaXLog.d("LynxAnimaXSettingService", "Collection contains non-string element: ".concat(r6));
        List r7 = Collections.emptyList();
        if (r7 != null) goto L25;
        r7 = Collections.emptyList();
    L25:
        return new AnimaXSettingValue(r7);
    L19:
        r6 = "null";
        goto L20
    L27:
        return new AnimaXSettingValue(r0);
    }

    @Override // w4a.c
    public final AnimaXSettingValue a(String r6) {
        if (r6 == null) goto L5;
        AnimaXSettingValue r1 = this.a.get(r6);
        if (r1 == null) goto L9;
        return r1;
    L9:
        ILynxTrailService r2 = (ILynxTrailService) n.c().a(ILynxTrailService.class);
        if (r2 != null) goto L30;
        AnimaXLog.d("LynxAnimaXSettingService", "Trail service not available");
        AnimaXSettingValue r3 = new AnimaXSettingValue(NameKeys.UnloadStrategy_No_Strategy);
    L26:
        AnimaXSettingValue r7 = this.a.putIfAbsent(r6, r3);
        if (r7 != null) goto L29;
        return r3;
    L29:
        return r7;
    L30:
        Object r4 = r2.objectValueForTrailKey(r6);     // Catch: Throwable -> L23
        if (r4 != null) goto L16;
        r3 = new AnimaXSettingValue(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L23
        goto L26
    L16:
        if ((r4 instanceof String) == false) goto L19;
        r3 = new AnimaXSettingValue((String) r4);     // Catch: Throwable -> L23
        goto L26
    L19:
        if ((r4 instanceof Collection) == false) goto L21;
        r3 = c((Collection) r4);     // Catch: Throwable -> L23
        goto L26
    L21:
        AnimaXLog.d("LynxAnimaXSettingService", "Unsupported value type: ".concat(r4.getClass().getName()));     // Catch: Throwable -> L23
    L25:
        r3 = new AnimaXSettingValue(NameKeys.UnloadStrategy_No_Strategy);
    L23:
        th = move-exception;
        AnimaXLog.a("LynxAnimaXSettingService", "Failed to get value for key: " + r6 + ", message: " + th.getMessage());
        goto L25
    L5:
        return new AnimaXSettingValue(NameKeys.UnloadStrategy_No_Strategy);
    }
}
