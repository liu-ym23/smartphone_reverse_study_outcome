package com.bytedance.android.livesdk.gecko.offline;

import android.net.Uri;
import com.bytedance.android.live.core.setting.f1;
import com.bytedance.ies.bullet.kit.resourceloader.j;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h {
    static {
    }

    public static boolean a(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (((Boolean) f1.a.getValue()).booleanValue() == false) goto L29;
        j r1 = j.a;
        Uri r4 = UriProtector.parse(r3);
        r1.getClass();
        if (r4 != null) goto L9;
    L22:
        boolean r5 = false;
    L23:
        if (r5 == false) goto L30;
        return true;
    L30:
        return false;
    L9:
        if (r4.getPath() == null) goto L22;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        Pattern r6 = j.b;     // Catch: Throwable -> L13
        String r7 = r4.getPath();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L13
        Object r8 = Result.constructor-impl(Boolean.valueOf(r6.matcher(r7).find()));     // Catch: Throwable -> L13
    L15:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L18;
        r9.printStackTrace();
    L18:
        Boolean r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r8) == false) goto L21;
        r8 = r10;
    L21:
        r5 = ((Boolean) r8).booleanValue();
    L13:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L29:
        return false;
    }
}
