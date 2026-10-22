package iz9;

import android.app.Application;
import android.util.Base64;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.creation.AwemeAnchor;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final c a = null;
    public static final boolean b = false;
    public static final Lazy c = null;

    public c() {
    }

    static {
        a = new c();
        b = AppHost.a.isOversea();
        c = LazyKt.lazy(new b());
    }

    public static String a(String r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Charset r1 = Charsets.UTF_8;     // Catch: Throwable -> L4
        byte[] r4 = Base64.encode(r3.getBytes(r1), 2);     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(new String(r4, r1));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r5);
        if (r2 == null) goto L11;
        FLogger.a.e("MetaDataConverter", "Base64 encoding failed: " + r2.getMessage());
        r5 = "";
    L11:
        return (String) r5;
    L4:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static String b(String r4, boolean r5) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return r4;
    L10:
        if (r5 == false) goto L12;
        String r6 = z2.a.getImgCreationFallbackAnchorName();
    L27:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        Application r2 = AppHost.a.getApplication();     // Catch: Throwable -> L15
        Object r7 = Result.constructor-impl(r2.getResources().getString(r2.getResources().getIdentifier(r6, "string", r2.getPackageName())));     // Catch: Throwable -> L15
    L17:
        Throwable r3 = Result.exceptionOrNull-impl(r7);
        if (r3 == null) goto L21;
        FLogger.a.e("MetaDataConverter", "getAnchorNameOrDefault failed for isImage(" + r5 + "): " + r3.getMessage());
    L21:
        if (Result.isFailure-impl(r7) == false) goto L23;
        r7 = null;
    L23:
        String r8 = (String) r7;
        if (r8 != null) goto L29;
        return "";
    L29:
        return r8;
    L15:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L12:
        r6 = z2.a.getVideoCreationFallbackAnchorName();
        goto L27
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static Map e(UserCreationFromIM r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (b == false) goto L5;
        return null;
    L5:
        boolean r2 = true;
        String r5 = c(r3, "UserCreationFromIM image", r4, true);
        if (r5.length() == 0) goto L9;
        r2 = false;
    L9:
        if (r2 == false) goto L12;
        return null;
    L12:
        return MapsKt.mapOf(TuplesKt.to("UserComment", r5));
    }

    public static Map f(UserCreation r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (b == false) goto L5;
        return null;
    L5:
        String r0 = r5.a;
        AwemeAnchor r7 = r5.q;
        if (r7 == null) goto L8;
        String r2 = r7.a;
    L9:
        if (r7 == null) goto L11;
        String r8 = r7.b;
    L12:
        boolean r3 = false;
        String r9 = d(r0, r2, b(r8, false), "UserCreation video", r6);
        if (r9.length() != 0) goto L15;
        r3 = true;
    L15:
        if (r3 == false) goto L18;
        return null;
    L18:
        return MapsKt.mapOf(TuplesKt.to("LvMetaInfo", r9));
    L11:
        r8 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    }

    public static Map g(UserCreationFromIM r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (b == false) goto L5;
        return null;
    L5:
        boolean r2 = false;
        String r5 = c(r3, "UserCreationFromIM video", r4, false);
        if (r5.length() != 0) goto L8;
        r2 = true;
    L8:
        if (r2 == false) goto L11;
        return null;
    L11:
        return MapsKt.mapOf(TuplesKt.to("LvMetaInfo", r5));
    }

    public static String c(UserCreationFromIM r3, String r4, String r5, boolean r6) {
        Gson r0 = (Gson) c.getValue();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl((AwemeAnchor) r0.fromJson(r3.getAwemeAnchor(), AwemeAnchor.class));     // Catch: Throwable -> L5
    L7:
        String r7 = null;
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        AwemeAnchor r8 = (AwemeAnchor) r2;
        String r9 = r3.getCreationId();
        if (r8 == null) goto L13;
        String r10 = r8.a;
    L14:
        if (r8 == null) goto L17;
        r7 = r8.b;
    L17:
        return d(r9, r10, b(r7, r6), r4, r5);
    L13:
        r10 = null;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static String d(String r10, String r11, String r12, String r13, String r14) {
        if (r10 == null) goto L6;
        boolean r1 = true;
        if (o0.d(r10) != true) goto L6;
    L7:
        String r8 = "";
        if (r1 == false) goto L17;
        String r3 = AppHost.a.getVersionName();
        if (r11 != null) goto L12;
        String r5 = r10;
    L13:
        if (r12 != null) goto L15;
        String r0 = "";
    L16:
        a r9 = new a("android", "doubao", r3, r10, r5, a(r0), 64);
    L25:
        String r2 = HttpExtKt.p(new d(r9, 2));
        if (r2 == null) goto L29;
        r8 = r2;
    L29:
        FLogger.a.i("MetaDataConverter", "tag:" + r13 + " getImageMetaDataExif: " + r8);
        return r8;
    L15:
        r0 = r12;
        goto L16
    L12:
        r5 = r11;
        goto L13
    L17:
        String r4 = AppHost.a.getVersionName();
        if (r11 != null) goto L20;
        String r6 = r14;
    L21:
        if (r12 != null) goto L23;
        String r7 = "";
    L24:
        r9 = new a("android", "doubao", r4, r10, r6, a(r7), r14);
        goto L25
    L23:
        r7 = r12;
        goto L24
    L20:
        r6 = r11;
    L6:
        r1 = false;
        goto L7
    }
}
