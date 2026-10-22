package d7;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final String b(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEME);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEME);
        Object r11 = null;
        if (StringsKt.startsWith$default(r10, "http", false, 2, null) == true) goto L20;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r12 = Result.constructor-impl(UriProtector.getQueryParameter(UriProtector.parse(r10), com.bytedance.android.ec.core.event.a.KEY_URL));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r12) == true) goto L13;
        r11 = r12;
    L13:
        String r13 = (String) r11;
        if (r13 != null) goto L19;
        return "";
    L19:
        return r13;
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L20:
        return r10;
    }

    @JvmStatic
    public static final String a(String r11, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "params");
        if (StringsKt.isBlank(r11) == false) goto L5;
        return r11;
    L5:
        Object r1 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L52
        Uri r13 = UriProtector.parse(b(r11));     // Catch: Throwable -> L52
        Uri.Builder r14 = r13.buildUpon().clearQuery();     // Catch: Throwable -> L52
        String r15 = UriProtector.getQueryParameter(UriProtector.parse(r11), "fallback_url");     // Catch: Throwable -> L52
        if (r15 == null) goto L21;
        String r16 = b(r15);     // Catch: Throwable -> L52
        if (StringsKt.isBlank(r16) == false) goto L11;
        boolean r17 = true;
    L13:
        if ((!r17) == true) goto L16;
        r16 = null;
    L16:
        if (r16 == null) goto L21;
        Uri r18 = UriProtector.parse(r16);     // Catch: Throwable -> L52
        if (r18 == null) goto L20;
        Uri.Builder r19 = r18.buildUpon();     // Catch: Throwable -> L52
    L22:
        Set r20 = UriProtector.getQueryParameterNames(r13);     // Catch: Throwable -> L52
        ArrayList r21 = new ArrayList();     // Catch: Throwable -> L52
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L52
    L24:
        if (r22.hasNext() == false) goto L28;
        Object r23 = r22.next();     // Catch: Throwable -> L52
        if ((!Intrinsics.areEqual((String) r23, "fallback_url")) == false) goto L24;
        r21.add(r23);     // Catch: Throwable -> L52
        goto L24
    L28:
        Iterator r24 = r21.iterator();     // Catch: Throwable -> L52
    L30:
        if (r24.hasNext() == false) goto L32;
        String r25 = (String) r24.next();     // Catch: Throwable -> L52
        r14.appendQueryParameter(r25, UriProtector.getQueryParameter(r13, r25));     // Catch: Throwable -> L52
        goto L30
    L32:
        Iterator<T> r110 = r12.entrySet().iterator();     // Catch: Throwable -> L52
    L34:
        if (r110.hasNext() == false) goto L44;
        Map.Entry r26 = (Map.Entry) r110.next();     // Catch: Throwable -> L52
        if (UriProtector.getQueryParameter(r13, (String) r26.getKey()) != null) goto L38;
        r14.appendQueryParameter((String) r26.getKey(), (String) r26.getValue());     // Catch: Throwable -> L52
    L38:
        if (r18 == null) goto L40;
        String r27 = UriProtector.getQueryParameter(r18, (String) r26.getKey());     // Catch: Throwable -> L52
    L41:
        if (r27 != null) goto L34;
        if (r19 == null) goto L34;
        r19.appendQueryParameter((String) r26.getKey(), (String) r26.getValue());     // Catch: Throwable -> L52
        goto L34
    L40:
        r27 = null;
        goto L41
    L44:
        if (r19 == null) goto L49;
        Uri r111 = r19.build();     // Catch: Throwable -> L52
        if (r111 == null) goto L49;
        String r112 = r111.toString();     // Catch: Throwable -> L52
        if (r112 == null) goto L49;
    L50:
        r14.appendQueryParameter("fallback_url", r112);     // Catch: Throwable -> L52
        Object r113 = Result.constructor-impl(r14.build().toString());     // Catch: Throwable -> L52
    L55:
        if (Result.isFailure-impl(r113) == true) goto L58;
        r1 = r113;
    L58:
        String r28 = (String) r1;
        if (r28 != null) goto L62;
        return r11;
    L62:
        return r28;
    L49:
        r112 = "";
        goto L50
    L20:
        r19 = null;
        goto L22
    L11:
        r17 = false;
    L21:
        r18 = null;
        r19 = null;
    L52:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    }
}
