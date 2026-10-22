package com.bytedance.android.live.schema.api.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final com.bytedance.android.live.schema.api.b a = null;

    static {
        a = new com.bytedance.android.live.schema.api.b("sslocal://webcast_redirect?entry=initialize", "initialize", null, null, null);
    }

    @JvmStatic
    public static final Map<String, String> a(Uri r14) {
        Intrinsics.checkNotNullParameter(r14, "url");
        String r1 = r14.getEncodedQuery();
        if (r1 == null) goto L35;
        if (r1.length() != 0) goto L7;
        boolean r15 = true;
    L8:
        if (r15 == true) goto L35;
        HashMap r16 = new HashMap();
        Object[] r2 = StringsKt.split$default(r1, new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);
        if (r2 == null) goto L33;
        String[] r3 = (String[]) r2;
        int r4 = r3.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L31;
        Object[] r6 = StringsKt.split$default(r3[r5], new String[]{"="}, false, 0, 6, null).toArray(new String[0]);
        if (r6 == null) goto L30;
        String[] r7 = (String[]) r6;
        StringBuilder r8 = new StringBuilder();
        if (r7.length != 2) goto L19;
        String r9 = r7[0];
        r8.append(r7[1]);
    L21:
        if (r7.length <= 2) goto L26;
        r9 = r7[0];
        int r10 = r7.length;
        int r12 = 1;
    L23:
        if (r12 >= r10) goto L26;
        r8.append(r7[r12]);
        r8.append("=");
        r12 = r12 + 1;
    L26:
        if (TextUtils.isEmpty(r9) == true) goto L28;
        r16.put(r9, Uri.decode(r8.toString()));
    L28:
        r5 = r5 + 1;
        goto L13
    L19:
        r9 = "";
        goto L21
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L31:
        return r16;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L7:
        r15 = false;
    L35:
        return MapsKt.emptyMap();
    }

    @JvmStatic
    public static final com.bytedance.android.live.schema.api.b b(String r9) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (r9 != null) goto L6;
        return null;
    L6:
        Uri r2 = UriProtector.parse(r9);     // Catch: Throwable -> L11
        if (TextUtils.equals(r2.getHost(), "webcast_redirect") == false) goto L10;
        Map<String, String> r3 = a(r2);     // Catch: Throwable -> L11
        String r5 = r3.get("entry");     // Catch: Throwable -> L11
        String r6 = r3.get("scheme_query");     // Catch: Throwable -> L11
        String r7 = r3.get("url_query");     // Catch: Throwable -> L11
        String r8 = r3.get("default_schema");     // Catch: Throwable -> L11
        boolean r4 = Intrinsics.areEqual(r3.get("decode_query_value"), DataType.TRUE);     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L11
        com.bytedance.android.live.schema.api.b r10 = new com.bytedance.android.live.schema.api.b(r9, r5, r6, r7, r8);     // Catch: Throwable -> L11
        r10.a = r4;     // Catch: Throwable -> L11
        return r10;
    L10:
        return null;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Object r13 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r13) == true) goto L17;
        r0 = r13;
    L17:
        return (com.bytedance.android.live.schema.api.b) r0;
    }
}
