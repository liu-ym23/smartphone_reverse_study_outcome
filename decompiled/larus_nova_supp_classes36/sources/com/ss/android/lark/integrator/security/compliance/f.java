package com.ss.android.lark.integrator.security.compliance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.TitlebarConfig;
import com.ss.android.lark.chameleon.WebviewConfig;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.suite.lark.emm.impl.clipboard.utils.TextViewMenuUtilsKt;
import java.util.Locale;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final f a = null;
    public static final Set<String> b = null;

    public f() {
    }

    static {
        a = new f();
        b = SetsKt.setOf(new String[]{"tel", "telprompt"});
    }

    public static ChameleonConfig a(String r17) {
        Intrinsics.checkNotNullParameter(r17, "url");
        ChameleonConfig.Builder r0 = new ChameleonConfig.Builder().bizName("officesdk_security_web").loadUrl(r17);
        OpenConfig r15 = new OpenConfig(null, false, false, false, false, 0, false, false, false, null, null, 2047, null);
        r15.setShowLoading(true);
        r15.setTitlebarConfig(new TitlebarConfig(true, null, 2, null));
        return r0.openConfig(r15).webviewConfig(new WebviewConfig(null, null, "OfficeSDKSecurity", true, null, 19, null)).build();
    }

    public static boolean b(Context r14, String r15) {
        String r16 = StringsKt.trim(r15).toString();
        Uri r6 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        String r1 = UriProtector.parse(r16).getScheme();     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        String r2 = r1.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L9
    L7:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r3) == false) goto L14;
        r3 = null;
    L14:
        String r7 = (String) r3;
        if (r7 != null) goto L17;
    L41:
        return false;
    L17:
        if (b.contains(r7) == false) goto L41;
        String r9 = r7.concat(":");
        if (StringsKt.regionMatches(r16, 0, r9, 0, r9.length(), true) == false) goto L23;
        r16 = r16.substring(r9.length());
    L23:
        if (StringsKt.startsWith$default(r16, "/", false, 2, null) == false) goto L25;
        r16 = StringsKt.drop(r16, 1);
        goto L23
    L25:
        String r17 = StringsKt.replace$default(StringsKt.trim(Uri.decode(r16)).toString(), " ", "", false, 4, null);
        if (StringsKt.isBlank(r17) == true) goto L30;
        r6 = Uri.fromParts("tel", r17, null);
    L30:
        if (r6 != null) goto L44;
        ScsLogger.c("OfficeSDKSecWebCtn", "openTelephoneUrlIfNeeded telephone number is blank, skip");
        return true;
    L44:
        Intent r4 = new Intent("android.intent.action.DIAL", r6);     // Catch: Throwable -> L38
        TextViewMenuUtilsKt.a(r4);     // Catch: Throwable -> L38
        if ((r14 instanceof Activity) == true) goto L36;
        r4.addFlags(268435456);     // Catch: Throwable -> L38
    L36:
        r14.startActivity(r4);     // Catch: Throwable -> L38
        int r18 = ScsLogger.a;     // Catch: Throwable -> L38
        ScsLogger.d("OfficeSDKSecWebCtn", "open telephone url with system, scheme: " + r7);     // Catch: Throwable -> L38
    L40:
        return true;
    L38:
        th = move-exception;
        int r5 = ScsLogger.a;
        ScsLogger.c("OfficeSDKSecWebCtn", "open telephone url failed: " + ExceptionsKt.stackTraceToString(th));
        goto L40
    L6:
        r2 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
