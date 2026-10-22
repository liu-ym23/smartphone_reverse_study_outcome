package com.larus.bmhome.chat.camera.command;

import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static Pair a(String r6, int r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl((IActionBarService) ServiceManager.get().getService(IActionBarService.class));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L10;
        FLogger.a.e("CameraActionBarConfigResolver", "get action bar service failed", r2);
        r1 = null;
    L10:
        IActionBarService r3 = (IActionBarService) r1;
        if (r3 != null) goto L13;
        return null;
    L13:
        List r8 = r3.f(r6);
        if (r8 == null) goto L31;
        Iterator r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L29;
        Object r4 = r9.next();
        com.larus.bmhome.actionbar.model.r r5 = ((z0) r4).q;
        if (r5 == null) goto L26;
        Integer r10 = r5.a;
        if (r10 == null) goto L26;
        if (r10.intValue() != r7) goto L26;
        boolean r11 = true;
    L27:
        if (r11 == false) goto L17;
    L30:
        z0 r12 = (z0) r4;
    L32:
        if (r12 != null) goto L34;
        e0 r13 = (e0) AuthModelDelegate.b.e().getValue();
        if (r13 == null) goto L40;
        LaunchInfo r14 = r13.a;
        if (r14 == null) goto L40;
        String r15 = r14.W();
    L41:
        List r16 = r3.f(r15);
        if (r16 == null) goto L74;
        Iterator r17 = r16.iterator();
    L45:
        if (r17.hasNext() == false) goto L57;
        Object r18 = r17.next();
        com.larus.bmhome.actionbar.model.r r19 = ((z0) r18).q;
        if (r19 == null) goto L54;
        Integer r20 = r19.a;
        if (r20 == null) goto L54;
        if (r20.intValue() != r7) goto L54;
        boolean r21 = true;
    L55:
        if (r21 == false) goto L45;
    L58:
        z0 r22 = (z0) r18;
        if (r22 != null) goto L61;
        return null;
    L61:
        return TuplesKt.to(r22, Boolean.TRUE);
    L54:
        r21 = false;
        goto L55
    L57:
        r18 = null;
        goto L58
    L74:
        return null;
    L40:
        r15 = null;
        goto L41
    L34:
        return TuplesKt.to(r12, Boolean.FALSE);
    L26:
        r11 = false;
        goto L27
    L29:
        r4 = null;
        goto L30
    L31:
        r12 = null;
    L4:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }
}
