package com.obric.assistant.card.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public static String b(String r8, Map r9) {
        Intrinsics.checkNotNullParameter(r8, "fullUrl");
        Intrinsics.checkNotNullParameter(r9, LynxResourceModule.PARAMS_KEY);
        boolean r2 = false;
        if (r8.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return r8;
    L8:
        if (r9.isEmpty() == true) goto L84;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r10 = r9.entrySet().iterator();
    L12:
        if (r10.hasNext() == false) goto L30;
        Map.Entry r4 = (Map.Entry) r10.next();
        String r5 = (String) r4.getKey();
        String r6 = (String) r4.getValue();
        if (r5.length() <= 0) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L26;
        if (r6 != null) goto L20;
    L23:
        boolean r11 = true;
    L24:
        if (r11 == true) goto L26;
        boolean r12 = true;
    L27:
        if (r12 == false) goto L12;
        r3.put(r4.getKey(), r4.getValue());
        goto L12
    L20:
        if (r6.length() == 0) goto L23;
        r11 = false;
    L26:
        r12 = false;
        goto L27
    L16:
        r7 = false;
        goto L17
    L30:
        if (r3.isEmpty() == false) goto L69;
        return r8;
    L69:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L61
        Uri r14 = UriProtector.parse(r8);     // Catch: Throwable -> L61
        String r15 = UriProtector.getQueryParameter(r14, LynxResourceModule.DATA_KEY);     // Catch: Throwable -> L61
        if (r15 != null) goto L37;
        r15 = NameKeys.UnloadStrategy_No_Strategy;
    L37:
        if (r15.length() != 0) goto L39;
        r2 = true;
    L39:
        if (r2 == false) goto L41;
        String r16 = r8;
    L59:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L61
    L63:
        Object r18 = r8;
        if (Result.isFailure-impl(r17) == true) goto L68;
        r18 = r17;
    L68:
        return (String) r18;
    L41:
        Iterator r19 = r3.entrySet().iterator();     // Catch: Throwable -> L61
    L43:
        if (r19.hasNext() == false) goto L48;
        Map.Entry r20 = (Map.Entry) r19.next();     // Catch: Throwable -> L61
        String r21 = (String) r20.getKey();     // Catch: Throwable -> L61
        String r22 = (String) r20.getValue();     // Catch: Throwable -> L61
        if (r22 != null) goto L47;
        r22 = NameKeys.UnloadStrategy_No_Strategy;
    L47:
        r15 = a(r15, r21, r22);     // Catch: Throwable -> L61
        goto L43
    L48:
        Uri.Builder r23 = r14.buildUpon().clearQuery();     // Catch: Throwable -> L61
        Iterator r24 = UriProtector.getQueryParameterNames(r14).iterator();     // Catch: Throwable -> L61
    L50:
        if (r24.hasNext() == false) goto L58;
        String r25 = (String) r24.next();     // Catch: Throwable -> L61
        Iterator r26 = UriProtector.getQueryParameters(r14, r25).iterator();     // Catch: Throwable -> L61
    L53:
        if (r26.hasNext() == false) goto L50;
        String r27 = (String) r26.next();     // Catch: Throwable -> L61
        if (Intrinsics.areEqual(r25, LynxResourceModule.DATA_KEY) == false) goto L57;
        r27 = r15;
    L57:
        r23.appendQueryParameter(r25, r27);     // Catch: Throwable -> L61
        goto L53
    L58:
        String r28 = r23.build().toString();     // Catch: Throwable -> L61
        Intrinsics.checkNotNull(r28);     // Catch: Throwable -> L61
        r16 = r28;
    L61:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L63
    L84:
        return r8;
    L5:
        r1 = false;
        goto L6
    }

    public static String a(String r6, String r7, String r8) {
        boolean r1 = true;
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r6;
    L8:
        if (r8.length() == 0) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        return r6;
    L13:
        if (StringsKt.contains$default(r6, ";end", false, 2, null) == false) goto L23;
        String r9 = Uri.encode(r8);
        String r10 = ";S." + r7 + '=';
        Regex r2 = new Regex(Regex.Companion.escape(r10) + "[^;]*");
        if (r2.containsMatchIn(r6) == false) goto L19;
        return r2.replace(r6, r10 + r9);
    L19:
        return StringsKt.replace$default(r6, ";end", r10 + r9 + ";end", false, 4, null);
    L23:
        return r6;
    L5:
        r0 = false;
        goto L6
    }
}
