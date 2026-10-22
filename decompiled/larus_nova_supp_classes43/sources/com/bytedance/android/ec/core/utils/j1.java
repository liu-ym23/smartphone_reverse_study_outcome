package com.bytedance.android.ec.core.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j1 {
    public static final HashMap<String, String> a(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$getQueryMap");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L27
        HashMap r11 = new HashMap();     // Catch: Throwable -> L27
        Iterator r12 = UriProtector.getQueryParameterNames(r10).iterator();     // Catch: Throwable -> L27
    L5:
        if (r12.hasNext() == false) goto L25;
        String r13 = (String) r12.next();     // Catch: Throwable -> L27
        boolean r14 = false;
        if (r13 != null) goto L9;
    L12:
        boolean r15 = true;
    L13:
        if (r15 == true) goto L5;
        String r16 = UriProtector.getQueryParameter(r10, r13);     // Catch: Throwable -> L27
        if (r16 != null) goto L17;
    L18:
        r14 = true;
    L20:
        if ((!r14) == true) goto L23;
        r16 = null;
    L23:
        if (r16 == null) goto L5;
        String r17 = (String) r11.put(r13, r16);     // Catch: Throwable -> L27
        goto L5
    L17:
        if (StringsKt.isBlank(r16) == false) goto L20;
    L9:
        if (StringsKt.isBlank(r13) == true) goto L12;
        r15 = false;
        goto L13
    L25:
        Object r18 = Result.constructor-impl(r11);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r18) == true) goto L33;
        r0 = r18;
    L33:
        HashMap<String, String> r19 = (HashMap) r0;
        if (r19 == null) goto L36;
        return r19;
    L36:
        return new HashMap();
    L27:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }

    public static final Set<String> b(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$getQueryParameterNamesSafely");
        if (r10.isHierarchical() == true) goto L6;
        r10 = null;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        return UriProtector.getQueryParameterNames(r10);
    }

    public static final String c(Uri r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$getQueryParameterSafely");
        Intrinsics.checkNotNullParameter(r11, "key");
        if (r10.isHierarchical() == true) goto L6;
        r10 = null;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        return UriProtector.getQueryParameter(r10, r11);
    }

    public static final Uri d(Uri r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$removeQueryParameterSafely");
        Intrinsics.checkNotNullParameter(r11, "queryParameterName");
        if (r10.isHierarchical() == true) goto L5;
        return r10;
    L5:
        Uri.Builder r0 = r10.buildUpon().clearQuery();
        Iterator r1 = UriProtector.getQueryParameterNames(r10).iterator();
    L7:
        if (r1.hasNext() == false) goto L15;
        String r12 = (String) r1.next();
        if ((!Intrinsics.areEqual(r12, r11)) == false) goto L7;
        Iterator r13 = UriProtector.getQueryParameters(r10, r12).iterator();
    L12:
        if (r13.hasNext() == false) goto L7;
        r0.appendQueryParameter(r12, (String) r13.next());
        goto L12
    L15:
        return r0.build();
    }
}
