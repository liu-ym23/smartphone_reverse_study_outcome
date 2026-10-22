package com.larus.bmhome.chat.component.receive;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l0 {
    static {
    }

    public static boolean a(List r6) {
        Intrinsics.checkNotNullParameter(r6, "uris");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L20;
        Object r0 = r7.next();
        Uri r1 = (Uri) r0;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        InputStream r3 = ContentResolverWrapper.openInputStream(AppHost.a.getApplication().getContentResolver(), r1);     // Catch: Throwable -> L11
        if (r3 == null) goto L9;
        r3.close();     // Catch: Throwable -> L11
    L9:
        Object r4 = Result.constructor-impl(Boolean.FALSE);     // Catch: Throwable -> L11
    L13:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L18;
        FLogger.a.e("ChatReceiveServiceHelper", "open uri:" + r1 + ", failed:" + r5);
        r4 = Boolean.TRUE;
    L18:
        if (((Boolean) r4).booleanValue() == false) goto L4;
    L21:
        if (r0 != null) goto L23;
        return true;
    L23:
        return false;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L20:
        r0 = null;
        goto L21
    }
}
