package com.bytedance.android.ec.core.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r10, Map r11) {
        Uri r1 = UriProtector.parse(r10);     // Catch: Exception -> L12
        Uri r12 = UriProtector.parse(UriProtector.getQueryParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL));     // Catch: Exception -> L12
        if (r12 == null) goto L16;
        if (r11 == null) goto L10;
        Iterator r13 = r11.entrySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Exception -> L12
        r12 = e(r12, (String) r14.getKey(), (String) r14.getValue());     // Catch: Exception -> L12
    L10:
        return String.valueOf(e(r1, com.bytedance.android.ec.core.event.a.KEY_URL, r12.toString()));
    L16:
        return r10;
    L17:
        return r10;
    }

    public static String b(String r10, Map r11) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Uri r1 = UriProtector.parse(r10);     // Catch: Throwable -> L12
        if (r11 == null) goto L10;
        Iterator r12 = r11.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r12.hasNext() == false) goto L9;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L12
        r1 = e(r1, (String) r13.getKey(), (String) r13.getValue());     // Catch: Throwable -> L12
        goto L6
    L9:
        return r1.toString();
    L10:
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Result.exceptionOrNull-impl(r14);
        return r10;
    L12:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static Uri f(Uri r10, Map r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$replaceOrAppendParameters");
        Intrinsics.checkNotNullParameter(r11, "paramsMap");
        Set r0 = UriProtector.getQueryParameterNames(r10);
        Uri.Builder r1 = r10.buildUpon().clearQuery();
        Iterator r12 = r0.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        String r13 = (String) r12.next();
        if (r11.containsKey(r13) == true) goto L7;
        r1.appendQueryParameter(r13, UriProtector.getQueryParameter(r10, r13));
        goto L4
    L7:
        r1.appendQueryParameter(r13, (String) r11.get(r13));
        r11.remove(r13);
        goto L4
    L9:
        Iterator r14 = r11.entrySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L14;
        Map.Entry r15 = (Map.Entry) r14.next();
        r1.appendQueryParameter((String) r15.getKey(), (String) r15.getValue());
        goto L11
    L14:
        return r1.build();
    }

    public static String c(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "originKey");
        Intrinsics.checkNotNullParameter(r12, "originValue");
        String r13 = Uri.encode(r11);
        String r14 = Uri.encode(r12);
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return r10;
    L5:
        if (TextUtils.isEmpty(r13) == false) goto L7;
        return r10;
    L7:
        return new Regex("(" + r13 + "=[^&]*)").replace(r10, r13 + '=' + r14);
    }

    public static String d(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return r10;
    L5:
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return r10;
    L7:
        if (StringsKt.contains$default(r10, r11, false, 2, null) == true) goto L17;
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return r10;
    L12:
        if (TextUtils.isEmpty(r11) == false) goto L14;
        return r10;
    L14:
        return UriProtector.parse(r10).buildUpon().appendQueryParameter(r11, r12).toString();
    L17:
        return c(r10, r11, r12);
    }

    public static Uri e(Uri r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        if (r11 == null) goto L25;
        if (r12 == null) goto L25;
        Uri.Builder r0 = r10.buildUpon();
    L23:
        e = move-exception;
        ECExceptionMonitor.f(e, "error uri: " + r10);
        goto L25
    L8:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r10, r11)) == false) goto L10;
        r0.appendQueryParameter(r11, r12);     // Catch: Exception -> L23
    L22:
        return r0.build();
    L10:
        r0.clearQuery();     // Catch: Exception -> L23
        Iterator r1 = UriProtector.getQueryParameterNames(r10).iterator();     // Catch: Exception -> L23
    L12:
        if (r1.hasNext() == false) goto L22;
        String r13 = (String) r1.next();     // Catch: Exception -> L23
        if ((!Intrinsics.areEqual(r13, r11)) == true) goto L15;
        r0.appendQueryParameter(r13, r12);     // Catch: Exception -> L23
        goto L12
    L15:
        Iterator r14 = UriProtector.getQueryParameters(r10, r13).iterator();     // Catch: Exception -> L23
    L17:
        if (r14.hasNext() == false) goto L12;
        r0.appendQueryParameter(r13, (String) r14.next());     // Catch: Exception -> L23
    L25:
        return r10;
    }

    public static String g(String r1, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
        return String.valueOf(e(UriProtector.parse(r1), r10, r11));
    }
}
