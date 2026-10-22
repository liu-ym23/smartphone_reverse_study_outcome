package com.larus.share.impl.sdk;

import android.app.Application;
import com.google.gson.Gson;
import com.larus.bmhome.share.ShareScene;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.share.impl.util.e;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import jr9.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static jr9.c a(ShareScene r8) {
        Intrinsics.checkNotNullParameter(r8, "shareScene");
        z2 r0 = z2.a;
        d r1 = r0.getShareConfig().a();
        boolean r2 = true;
        if (r1 == null) goto L5;
    L29:
        jr9.c r3 = null;
        if (r1 == null) goto L95;
        List<jr9.c> r4 = r1.a();
        if (r4 == null) goto L95;
        Iterator<T> r5 = r4.iterator();
    L35:
        if (r5.hasNext() == false) goto L43;
        Object r6 = r5.next();
        jr9.c r7 = (jr9.c) r6;
        String r9 = r8.getScene();
        if (r7 == null) goto L39;
        String r10 = r7.b();
    L41:
        if (Intrinsics.areEqual(r9, r10) == false) goto L35;
    L44:
        jr9.c r11 = (jr9.c) r6;
        if (r11 == null) goto L95;
    L70:
        if (r1 == null) goto L85;
        List<jr9.c> r12 = r1.a();
        if (r12 == null) goto L85;
        Iterator<T> r13 = r12.iterator();
    L75:
        if (r13.hasNext() == false) goto L83;
        Object r14 = r13.next();
        jr9.c r15 = (jr9.c) r14;
        if (r15 == null) goto L79;
        String r16 = r15.b();
    L81:
        if (Intrinsics.areEqual(r16, ShareScene.UNKNOWN.getScene()) == false) goto L75;
    L84:
        jr9.c r17 = (jr9.c) r14;
    L86:
        if (r11 != null) goto L89;
        r2 = false;
    L89:
        if (r2 == false) goto L91;
        r3 = r11;
    L91:
        if (r3 != null) goto L94;
        return r17;
    L94:
        return r3;
    L79:
        r16 = null;
        goto L81
    L83:
        r14 = null;
    L85:
        r17 = null;
        goto L86
    L39:
        r10 = null;
        goto L41
    L43:
        r6 = null;
    L95:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L48
        Gson r19 = new Gson();     // Catch: Throwable -> L48
        e r20 = e.a;     // Catch: Throwable -> L48
        Application r21 = AppHost.a.getApplication();     // Catch: Throwable -> L48
        r20.getClass();     // Catch: Throwable -> L48
        Object r22 = Result.constructor-impl((d) r19.fromJson(e.e(r21), d.class));     // Catch: Throwable -> L48
    L51:
        if (Result.isFailure-impl(r22) == false) goto L53;
        r22 = null;
    L53:
        d r23 = (d) r22;
        if (r23 == null) goto L69;
        List<jr9.c> r24 = r23.a();
        if (r24 == null) goto L69;
        Iterator<T> r25 = r24.iterator();
    L59:
        if (r25.hasNext() == false) goto L67;
        Object r26 = r25.next();
        jr9.c r27 = (jr9.c) r26;
        String r28 = r8.getScene();
        if (r27 == null) goto L63;
        String r29 = r27.b();
    L65:
        if (Intrinsics.areEqual(r28, r29) == false) goto L59;
    L68:
        r11 = (jr9.c) r26;
        goto L70
    L63:
        r29 = null;
        goto L65
    L67:
        r26 = null;
    L69:
        r11 = null;
    L48:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L51
    L5:
        if (r8 != ShareScene.OFFICE_SHARE_CHAT) goto L7;
    L18:
        boolean r31 = true;
    L19:
        if (r31 == true) goto L29;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L23
        Gson r33 = new Gson();     // Catch: Throwable -> L23
        e r34 = e.a;     // Catch: Throwable -> L23
        Application r35 = AppHost.a.getApplication();     // Catch: Throwable -> L23
        r34.getClass();     // Catch: Throwable -> L23
        r0.getShareConfig().v((d) r33.fromJson(e.e(r35), d.class));     // Catch: Throwable -> L23
        Object r36 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r37 = Result.exceptionOrNull-impl(r36);
        if (r37 == null) goto L28;
        FLogger.a.i("SharePanelConfigManager", r37.toString());
    L28:
        r1 = z2.a.getShareConfig().a();
    L23:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L7:
        if (r8 == ShareScene.OFFICE_MY_QR_CODE) goto L18;
        if (r8 == ShareScene.OFFICE_SHARE_THREAD) goto L18;
        if (r8 == ShareScene.OFFICE_GROUP_QR_CODE) goto L18;
        if (r8 == ShareScene.SOCIAL_IMAGE_SHARE) goto L18;
        if (r8 == ShareScene.SOCIAL_VIDEO_SHARE) goto L18;
        r31 = false;
        goto L19
    }
}
