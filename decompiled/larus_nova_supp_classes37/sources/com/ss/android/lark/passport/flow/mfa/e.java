package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.TitlebarConfig;
import com.ss.android.lark.chameleon.WebviewConfig;
import com.ss.android.lark.chameleonv2.Chameleon;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.idp_auth.FlowMfaIdpChameleonPlugin;
import com.ss.android.lark.utils.ApiUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public static String d(String r5) {
        String r0 = UriProtector.parse(r5).getScheme();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return r5;
    L11:
        int r2 = com.ss.android.lark.passport.flow.core.network.a.a;
        String r3 = StringsKt.trimEnd(com.ss.android.lark.passport.flow.core.network.a.a((gpb.a) ApiUtils.getApi(gpb.a.class)), new char[]{'/'});
        if (StringsKt.startsWith$default(r5, "/", false, 2, null) == true) goto L16;
        r5 = "/" + r5;
    L16:
        return r3 + r5;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static ChameleonConfig a(String r17, String r18) {
        ChameleonConfig.Builder r0 = new ChameleonConfig.Builder().bizName("passport_mfa").loadUrl(r17);
        OpenConfig r15 = new OpenConfig(null, false, false, false, false, 0, false, false, false, null, null, 2047, null);
        r15.setShowLoading(true);
        r15.setNestedEnable(true);
        r15.setTitlebarConfig(new TitlebarConfig(true, null, 2, null));
        ChameleonConfig.Builder r1 = r0.openConfig(r15);
        if (r18 != null) goto L5;
        String r4 = "";
    L7:
        return r1.webviewConfig(new WebviewConfig(null, null, r4, false, null, 27, null)).build();
    L5:
        r4 = r18;
        goto L7
    }

    public static boolean c(Activity r11, String r12, FlowMfaFlowSession r13) {
        PassportLog.d("FlowMfaChameleonWebOpener", "open external BIDP browser start");
    L3:
        a r1 = r13.v.get();
        if (r1.a != ExternalBidpCallbackPhase.IDLE) goto L5;
        a r2 = new a(ExternalBidpCallbackPhase.WAITING_CALLBACK, r1.b + 1);
        AtomicReference<a> r3 = r13.v;
    L8:
        if (r3.compareAndSet(r1, r2) == true) goto L9;
        if (r3.get() == r1) goto L8;
        boolean r4 = false;
    L13:
        if (r4 == false) goto L3;
        PassportLog.d("FlowMfaSession", "prepare external BIDP callback success: attempt=" + r2.b);
        boolean r5 = true;
    L15:
        if (r5 == true) goto L49;
        PassportLog.b("FlowMfaChameleonWebOpener", "open external BIDP browser failed: callback state not prepared");
        return false;
    L49:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L20
        Intent r7 = new Intent("android.intent.action.VIEW", UriProtector.parse(r12));     // Catch: Throwable -> L20
        r7.addFlags(268435456);     // Catch: Throwable -> L20
        r11.startActivity(r7);     // Catch: Throwable -> L20
        Object r14 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L20
    L22:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 != null) goto L25;
    L29:
        Boolean r16 = Boolean.FALSE;
        if (Result.isFailure-impl(r14) == false) goto L32;
        r14 = r16;
    L32:
        boolean r17 = ((Boolean) r14).booleanValue();
        if (r17 == true) goto L47;
    L34:
        a r18 = r13.v.get();
        if (r18.a != ExternalBidpCallbackPhase.WAITING_CALLBACK) goto L46;
        a r8 = a.a(r18, ExternalBidpCallbackPhase.IDLE);
        AtomicReference<a> r9 = r13.v;
    L39:
        if (r9.compareAndSet(r18, r8) == true) goto L40;
        if (r9.get() == r18) goto L39;
        boolean r10 = false;
    L44:
        if (r10 == false) goto L34;
        PassportLog.d("FlowMfaSession", "clear external BIDP callback: attempt=" + r18.b);
        goto L46
    L40:
        r10 = true;
    L46:
        r13.m(FlowMfaBidpWebActivityType.EXTERNAL_BROWSER_LOADING);
    L47:
        PassportLog.d("FlowMfaChameleonWebOpener", "open external BIDP browser result: opened=" + r17);
        return r17;
    L25:
        if ((r15 instanceof ActivityNotFoundException) == false) goto L27;
        String r19 = "ActivityNotFoundException";
    L28:
        PassportLog.b("FlowMfaChameleonWebOpener", "open BIDP url with browser failed: ".concat(r19));
        goto L29
    L27:
        r19 = r15.getClass().getSimpleName();
    L20:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L9:
        r4 = true;
        goto L13
    L5:
        PassportLog.b("FlowMfaSession", "prepare external BIDP callback failed: phase=" + r1.a);
        r5 = false;
        goto L15
    }

    public static boolean b(Activity r4, String r5, String r6, String r7, FlowMfaFlowSession r8, FlowMfaBidpWebActivityType r9) {
        if (r8 == null) goto L23;
        Intrinsics.checkNotNullParameter(r9, "type");
        r8.k(r9).set(false);
        r8.c(r9).set(null);
    L23:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        Chameleon r10 = Chameleon.a;     // Catch: Throwable -> L11
        ChameleonConfig r11 = a(r5, r7);     // Catch: Throwable -> L11
        if (r8 == null) goto L8;
        List r12 = CollectionsKt.listOf(new FlowMfaIdpChameleonPlugin(r8, r9));     // Catch: Throwable -> L11
    L9:
        Chameleon.b(r4, r11, r12);     // Catch: Throwable -> L11
        Object r13 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L11
    L13:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L18;
        if (r8 == null) goto L17;
        Intrinsics.checkNotNullParameter(r9, "type");
        r8.c(r9).set(null);
        r8.k(r9).set(false);
    L17:
        PassportLog.b("FlowMfaChameleonWebOpener", "open " + r6 + " url with Chameleon failed: " + r14.getClass().getSimpleName());
    L18:
        Boolean r15 = Boolean.FALSE;
        if (Result.isFailure-impl(r13) == false) goto L22;
        r13 = r15;
    L22:
        return ((Boolean) r13).booleanValue();
    L8:
        r12 = null;
    L11:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
