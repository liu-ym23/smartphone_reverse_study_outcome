package com.larus.bmhome.chat.list.trace;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.utils.o0;
import java.util.Locale;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final Set<String> a = null;

    public a() {
    }

    static {
        a = SetsKt.setOf(new String[]{"http", "https"});
    }

    public static String a(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (d(r2) == false) goto L9;
        return "long_url";
    L9:
        String r3 = c(r2).optString("link_type");
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank(r3)) == true) goto L12;
        return null;
    L12:
        return r3;
    }

    public static JSONObject b(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        String r2 = UriProtector.getQueryParameter(r1, "flow_extra");     // Catch: Throwable -> L13
        if (r2 == null) goto L6;
        String r3 = o0.b(r2);     // Catch: Throwable -> L13
        if (r3 == null) goto L10;
        Object r4 = Result.constructor-impl(new JSONObject(r3));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r4) == false) goto L18;
        r4 = null;
    L18:
        JSONObject r5 = (JSONObject) r4;
        if (r5 == null) goto L21;
        return r5;
    L21:
        return new JSONObject();
    L10:
        return new JSONObject();
    L6:
        return new JSONObject();
    L13:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public static JSONObject c(String r1) {
        if (r1 == null) goto L4;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        String r2 = UriProtector.getQueryParameter(UriProtector.parse(r1), "flow_extra");     // Catch: Throwable -> L15
        if (r2 == null) goto L8;
        String r3 = o0.b(r2);     // Catch: Throwable -> L15
        if (r3 == null) goto L12;
        Object r4 = Result.constructor-impl(new JSONObject(r3));     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r4) == false) goto L20;
        r4 = null;
    L20:
        JSONObject r5 = (JSONObject) r4;
        if (r5 == null) goto L23;
        return r5;
    L23:
        return new JSONObject();
    L12:
        return new JSONObject();
    L8:
        return new JSONObject();
    L15:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L4:
        return new JSONObject();
    }

    public static boolean d(String r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        Uri r3 = UriProtector.parse(r2);
        Set<String> r0 = a;
        String r4 = r3.getScheme();
        if (r4 == null) goto L8;
        String r5 = r4.toLowerCase(Locale.ROOT);
    L10:
        return CollectionsKt.contains(r0, r5);
    L8:
        r5 = null;
        goto L10
    }

    public static void e(HighlightWordShowScene r1, q0 r2, String r3, String r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r5, "block");
        Triple r0 = new Triple(r1, r3, r4);
        Set r6 = null;
        if (r2 == null) goto L7;
        ChatMessageList r7 = r2.B7();
        if (r7 == null) goto L7;
        Object r8 = r7.getTag(2131384073);
    L9:
        if (TypeIntrinsics.isMutableSet(r8) == false) goto L11;
        r6 = (Set) r8;
    L11:
        if (r6 != null) goto L13;
    L15:
        boolean r9 = false;
    L16:
        if (r9 == false) goto L19;
        r5.invoke();
        r6.add(r0);
        return;
    L19:
        return;
    L13:
        if (r6.contains(r0) == true) goto L15;
        r9 = true;
    L7:
        r8 = null;
        goto L9
    }
}
