package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import android.content.Context;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final boolean b(h r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if (r10.a == (-1)) goto L8;
        if (r10.b == (-1)) goto L8;
        return true;
    }

    public static final void a(h r10, Map<String, Integer> r11, Map<String, Integer> r12) {
        String r1 = r10.c;     // Catch: Exception -> L27
        boolean r13 = false;
        if (r1 != null) goto L6;
    L9:
        boolean r14 = true;
    L11:
        if (r14 == true) goto L44;
        String r15 = r10.c;     // Catch: Exception -> L27
        if (r15 != null) goto L15;
        Intrinsics.throwNpe();     // Catch: Exception -> L27
    L15:
        Integer r16 = r11.get(r15);     // Catch: Exception -> L27
        if (r16 == null) goto L19;
        int r17 = r16.intValue();     // Catch: Exception -> L27
    L21:
        if (r17 != (-1)) goto L23;
    L30:
        String r18 = r10.c;     // Catch: Exception -> L27
        if (r18 != null) goto L33;
        Intrinsics.throwNpe();     // Catch: Exception -> L27
    L33:
        Integer r19 = r12.get(r18);     // Catch: Exception -> L27
        if (r19 == null) goto L36;
        int r110 = r19.intValue();     // Catch: Exception -> L27
    L37:
        if (r110 == (-1)) goto L44;
        if (r110 == r10.a) goto L44;
        if (("autoReplace layoutIdName " + r10.c + " from " + r10.a + " to " + r110) == null) goto L43;
        Context r20 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L27
    L43:
        r10.a = r110;     // Catch: Exception -> L27
        goto L44
    L36:
        r110 = -1;
        goto L37
    L23:
        if (r17 == r10.a) goto L30;
        if (("autoReplace layoutIdName " + r10.c + " from " + r10.a + " to " + r17) == null) goto L29;
        Context r21 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L27
    L29:
        r10.a = r17;     // Catch: Exception -> L27
        goto L30
    L19:
        r17 = -1;
    L44:
        String r111 = r10.d;     // Catch: Exception -> L27
        if (r111 != null) goto L47;
    L48:
        r13 = true;
    L49:
        if (r13 == true) goto L64;
        String r112 = r10.d;     // Catch: Exception -> L27
        if (r112 != null) goto L53;
        Intrinsics.throwNpe();     // Catch: Exception -> L27
    L53:
        Integer r113 = r12.get(r112);     // Catch: Exception -> L27
        if (r113 == null) goto L56;
        int r114 = r113.intValue();     // Catch: Exception -> L27
    L57:
        if (r114 == (-1)) goto L64;
        if (r114 == r10.b) goto L64;
        if (("autoReplace viewIdName " + r10.d + " from " + r10.b + " to " + r114) == null) goto L63;
        Context r115 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L27
    L63:
        r10.b = r114;     // Catch: Exception -> L27
        goto L64
    L56:
        r114 = -1;
    L64:
        Unit r22 = Unit.INSTANCE;     // Catch: Exception -> L27
        return;
    L47:
        if (r111.length() != 0) goto L49;
    L6:
        if (r1.length() == 0) goto L9;
        r14 = false;
    L27:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L69;
        Context r23 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L69:
        Unit r24 = Unit.INSTANCE;
    }
}
