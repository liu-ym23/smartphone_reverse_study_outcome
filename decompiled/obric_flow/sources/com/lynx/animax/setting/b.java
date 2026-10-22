package com.lynx.animax.setting;

import com.lynx.animax.service.IAnimaXService;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.utils.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements IAnimaXService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f9703a;

    public b() {
        this.f9703a = new ConcurrentHashMap();
    }

    public static a b(Collection r5) {
        List r10 = Collections.EMPTY_LIST;
        if (r5.isEmpty() == true) goto L5;
        ArrayList r11 = new ArrayList(r5.size());
        Iterator r12 = r5.iterator();
    L8:
        if (r12.hasNext() == false) goto L18;
        Object r13 = r12.next();
        if ((r13 instanceof String) == false) goto L12;
        r11.add((String) r13);
        goto L8
    L12:
        if (r13 == null) goto L14;
        String r14 = r13.getClass().getName();
    L15:
        String r15 = "Collection contains non-string element: ".concat(r14);
        AnimaXLog.a(AnimaXLog.LogLevel.f9714b, "LynxAnimaXSettingService", r15);
        List r16 = Collections.EMPTY_LIST;
        return new a(r10);
    L14:
        r14 = "null";
        goto L15
    L18:
        return new a(r11);
    L5:
        return new a(r10);
    }

    public final a a(String r10) {
        if (r10 == null) goto L5;
        ConcurrentHashMap r5 = this.f9703a;
        a r11 = (a) r5.get(r10);
        if (r11 == null) goto L9;
        return r11;
    L9:
        ILynxTrailService r12 = (ILynxTrailService) r.g().e(ILynxTrailService.class);
        if (r12 != null) goto L31;
        AnimaXLog.a(AnimaXLog.LogLevel.f9714b, "LynxAnimaXSettingService", "Trail service not available");
        a r13 = new a("");
    L27:
        a r14 = (a) r5.putIfAbsent(r10, r13);
        if (r14 != null) goto L30;
        return r13;
    L30:
        return r14;
    L31:
        Object r15 = r12.objectValueForTrailKey(r10);     // Catch: Throwable -> L15
        if (r15 != null) goto L18;
        r13 = new a("");     // Catch: Throwable -> L15
        goto L27
    L18:
        if ((r15 instanceof String) == false) goto L21;
        r13 = new a((String) r15);     // Catch: Throwable -> L15
        goto L27
    L21:
        if ((r15 instanceof Collection) == false) goto L23;
        r13 = b((Collection) r15);     // Catch: Throwable -> L15
        goto L27
    L23:
        String r16 = "Unsupported value type: ".concat(r15.getClass().getName());     // Catch: Throwable -> L15
        AnimaXLog.a(AnimaXLog.LogLevel.f9714b, "LynxAnimaXSettingService", r16);     // Catch: Throwable -> L15
    L26:
        r13 = new a("");
    L15:
        th = move-exception;
        String r17 = androidx.room.jarjarred.org.antlr.runtime.a.x(th, e.b("Failed to get value for key: ", r10, ", message: "));
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "LynxAnimaXSettingService", r17);
        goto L26
    L5:
        return new a("");
    }
}
