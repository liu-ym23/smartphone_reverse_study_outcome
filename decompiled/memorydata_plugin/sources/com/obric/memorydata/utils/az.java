package com.obric.memorydata.utils;

import android.net.Uri;
import android.os.Build;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\f\n\u0000\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u0001\u001a\f\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u0001\u001a\f\u0010\u0007\u001a\u00020\u0005*\u0004\u0018\u00010\u0001\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0005\u001a\f\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u0001\u001a\f\u0010\u000b\u001a\u00020\n*\u0004\u0018\u00010\u0005\u001a\u0018\u0010\f\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0001\u001a\u001e\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u001a\u001e\u0010\u0010\u001a\u00020\u0005*\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u001a\u001e\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u001a\u001e\u0010\u0011\u001a\u00020\u0005*\u00020\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0013\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0016\u001a\u00020\u0001*\u00020\u0001\u001a\f\u0010\u0017\u001a\u00020\n*\u00020\u0001H\u0002\u001a\f\u0010\u0018\u001a\u00020\n*\u00020\u0019H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"TAG", "", "SCHEMA_HTTP", "SCHEMA_HTTPS", "toUri", "Landroid/net/Uri;", "toNotNullUri", "safeToUri", "toUrl", "isHttpUrl", "", "isHttpUri", "queryParameter", "key", "replaceQueryParameter", EventBody.KEY_VALUE, "appendQueryParameter", "putParams", "newParams", "", "", "safeUrlEncode", "safeUrlDecode", "hasOnlyValidPercentEscapes", "isHexDigit", "", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class az {
    public static final Uri a(Uri r5, Map<String, ? extends Object> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r7, "newParams");
        Uri.Builder r0 = r5.buildUpon().clearQuery();
        Iterator<String> r2 = r5.getQueryParameterNames().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r7.containsKey(r3) == true) goto L4;
        r0.appendQueryParameter(r3, r5.getQueryParameter(r3));
        goto L4
    L8:
        Iterator r8 = r7.entrySet().iterator();
    L10:
        if (r8.hasNext() == false) goto L17;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9.getValue().toString(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L10;
        r0.appendQueryParameter((String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.memorydata.plugin"), r9.getValue().toString());
        goto L10
    L14:
        r4 = false;
        goto L15
    L17:
        Uri r10 = r0.build();
        Intrinsics.checkNotNullExpressionValue(r10, "build(...)");
        return r10;
    }

    public static final Uri a(String r2) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return null;
    L12:
        return Uri.parse(r2);
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private static final boolean a(char r3) {
        if ('0' <= r3) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return true;
    L10:
        if ('a' <= r3) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L17;
        return true;
    L17:
        if ('A' <= r3) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == false) goto L25;
        return true;
    L25:
        return false;
    L19:
        if (r3 >= 'G') goto L21;
        r5 = true;
        goto L22
    L12:
        if (r3 >= 'g') goto L14;
        r4 = true;
        goto L15
    L5:
        if (r3 >= ':') goto L7;
        r2 = true;
        goto L8
    }

    public static final String b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return r7;
    L5:
        String r1 = URLEncoder.encode(r7, StandardCharsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r1, "encode(...)");
        return StringsKt.replace$default(r1, Marker.ANY_NON_NULL_MARKER, "%20", false, 4, null);
    }

    public static final String c(String r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return r7;
    L5:
        Object r5 = null;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '%', false, 2, null) == true) goto L9;
        return r7;
    L9:
        if (d(r7) == true) goto L26;
        return r7;
    L26:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        Object r1 = Result.m1421constructorimpl(URLDecoder.decode(r7, StandardCharsets.UTF_8));     // Catch: Throwable -> L13
    L16:
        if (Result.m1427isFailureimpl(r1) == false) goto L18;
        r1 = r7;
    L18:
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r2);
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), Utf8.REPLACEMENT_CHARACTER, false, 2, null) == true) goto L21;
        r5 = r1;
    L21:
        String r3 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L25;
        return r7;
    L25:
        return r3;
    L13:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    private static final boolean d(String r9) {
        int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), '%', 0, false, 6, null);
    L3:
        if (r0 < 0) goto L14;
        int r2 = r0 + 2;
        if (r2 >= r9.length()) goto L12;
        if (a(r9.charAt(r0 + 1)) == false) goto L20;
        if (a(r9.charAt(r2)) == false) goto L21;
        r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), '%', r0 + 3, false, 4, null);
        goto L3
    L21:
        return false;
    L20:
        return false;
    L12:
        return false;
    L14:
        return true;
    }
}
