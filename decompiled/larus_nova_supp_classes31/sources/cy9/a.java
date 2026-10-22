package cy9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.net.URLDecoder;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final a a = null;
    public static Bundle b;

    static {
        a = new a();
    }

    public a() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        b = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static String b(Bundle r6) {
        if (r6 == null) goto L6;
        String r0 = r6.getString("ai_creation_applet_path");
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (r6 == null) goto L10;
        Bundle r7 = r6.getBundle("__applet_app_ext_bundle__");
        if (r7 == null) goto L10;
        String r8 = r7.getString("url");
    L11:
        if (r8 != null) goto L14;
        r8 = "";
    L14:
        if (r8.length() != 0) goto L16;
        boolean r1 = true;
    L17:
        if (r1 == true) goto L48;
        String r2 = StringsKt.substringBefore$default(r8, "?", null, 2, null);
        if (Intrinsics.areEqual(r2, "index") == true) goto L40;
        if (StringsKt.startsWith$default(r2, "/", false, 2, null) == true) goto L40;
        MatchResult r9 = Regex.find$default(new Regex("(?:^|[?&])path=([^&]+)"), r8, 0, 2, null);
        if (r9 == null) goto L44;
        List r10 = r9.getGroupValues();
        if (r10 == null) goto L45;
        String r11 = (String) CollectionsKt.getOrNull(r10, 1);
        if (r11 == null) goto L46;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L32
        Object r4 = Result.constructor-impl(URLDecoder.decode(r11, "UTF-8"));     // Catch: Throwable -> L32
    L34:
        Object r12 = r11;
        if (Result.isFailure-impl(r4) == true) goto L47;
        r12 = r4;
    L47:
        return (String) r12;
    L32:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L46:
        return null;
    L45:
        return null;
    L44:
        return null;
    L40:
        return r2;
    L48:
        return null;
    L16:
        r1 = false;
    L10:
        r8 = null;
        goto L11
    }

    public static boolean d(Activity r3) {
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getClass().getName();
    L7:
        if (Intrinsics.areEqual(r1, "com.bytedance.ai.applet.app.AppletFullScreenActivity") == false) goto L14;
        Intent r4 = r3.getIntent();
        if (r4 == null) goto L12;
        r0 = r4.getDataString();
    L12:
        if (Intrinsics.areEqual(r0, "db_2UHTeIU") == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public static boolean e(Bundle r4) {
        if (r4 == null) goto L5;
        Object r1 = r4.get("from_ai_creation_applet");
    L7:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L9;
    L22:
        return true;
    L9:
        if (Intrinsics.areEqual(r1, "1") == true) goto L22;
        if (Intrinsics.areEqual(r1, 1) == true) goto L22;
        if (r4 == null) goto L17;
        Bundle r5 = r4.getBundle("__applet_app_ext_bundle__");
        if (r5 == null) goto L17;
        String r6 = r5.getString("url");
    L18:
        if (r6 != null) goto L21;
        r6 = "";
    L21:
        return StringsKt.contains$default(r6, "from_ai_creation_applet=1", false, 2, null);
    L17:
        r6 = null;
        goto L18
    L5:
        r1 = null;
        goto L7
    }

    public static boolean f(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return true;
    L11:
        if (Intrinsics.areEqual(r3, "index") == false) goto L13;
        return true;
    L13:
        if (Intrinsics.areEqual(r3, "/creation/home") == true) goto L19;
        return false;
    L19:
        return true;
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static boolean g(Bundle r4) {
        if (e(r4) == true) goto L5;
        return false;
    L5:
        if (r4 == null) goto L7;
        Object r0 = r4.get("ai_creation_applet_is_root_page");
    L9:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L11;
    L23:
        return true;
    L11:
        if (Intrinsics.areEqual(r0, "1") == true) goto L23;
        if (Intrinsics.areEqual(r0, 1) == true) goto L23;
        if (Intrinsics.areEqual(r0, Boolean.FALSE) == false) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(r0, "0") == false) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(r0, 0) == false) goto L27;
        return false;
    L27:
        return f(b(r4));
    L7:
        r0 = null;
        goto L9
    }

    public static boolean h(Bundle r1) {
        if (e(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (g(r1) == true) goto L7;
        return true;
    }

    public final synchronized Bundle c(Bundle r3) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        Bundle r1 = null;
        if (e(r3) == true) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (g(r3) == true) goto L11;
    L14:
        Bundle r4 = b;     // Catch: Throwable -> L19
        if (r4 == null) goto L17;
        r1 = new Bundle(r4);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return r1;
    L11:
        if (f(b(r3)) == true) goto L14;
        monitor-exit(this);
        return null;
    }

    public static boolean i(Bundle r1, String r2) {
        if (r1 == null) goto L4;
        Object r3 = r1.get(r2);
    L6:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L8;
        return true;
    L8:
        if (Intrinsics.areEqual(r3, "1") == false) goto L10;
        return true;
    L10:
        if (Intrinsics.areEqual(r3, 1) == true) goto L16;
        return false;
    L16:
        return true;
    L4:
        r3 = null;
        goto L6
    }
}
