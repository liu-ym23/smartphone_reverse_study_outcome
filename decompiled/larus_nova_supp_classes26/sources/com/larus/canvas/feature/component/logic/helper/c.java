package com.larus.canvas.feature.component.logic.helper;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final c a = null;
    public static final Gson b = null;

    public c() {
    }

    static {
        a = new c();
        b = new Gson();
    }

    public static String a(String r3) {
        Uri r0 = b(r3);
        if (r0 != null) goto L6;
        return r3;
    L6:
        return c(r0, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method", "in_app_push"), TuplesKt.to("current_page", "image_generate_canvas")})).toString();
    }

    public static Uri b(String r1) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(UriProtector.parse(r1));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        return (Uri) r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static String d(Uri r2) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(UriProtector.getQueryParameter(r2, "target_url"));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r3) == false) goto L11;
        r3 = null;
    L11:
        return (String) r3;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static Uri c(Uri r5, Map r6) {
        Uri.Builder r0 = r5.buildUpon().clearQuery();
        Iterator r1 = UriProtector.getQueryParameterNames(r5).iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) r1.next();
        if (r6.containsKey(r2) == true) goto L4;
        Iterator r3 = UriProtector.getQueryParameters(r5, r2).iterator();
    L10:
        if (r3.hasNext() == false) goto L4;
        r0.appendQueryParameter(r2, (String) r3.next());
        goto L10
    L12:
        Iterator r7 = r6.entrySet().iterator();
    L14:
        if (r7.hasNext() == false) goto L17;
        Map.Entry r8 = (Map.Entry) r7.next();
        r0.appendQueryParameter((String) r8.getKey(), (String) r8.getValue());
        goto L14
    L17:
        return r0.build();
    }
}
