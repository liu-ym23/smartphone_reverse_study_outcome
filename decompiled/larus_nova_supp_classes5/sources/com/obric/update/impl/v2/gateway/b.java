package com.obric.update.impl.v2.gateway;

import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public static void a(PolarisFileWrapper r6) {
        Intrinsics.checkNotNullParameter(r6, "apkFile");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L15
        AppHost.Companion r4 = AppHost.a;     // Catch: Throwable -> L15
        r3.append(r4.getApplication().getPackageName());     // Catch: Throwable -> L15
        r3.append(".obric.update");     // Catch: Throwable -> L15
        String r5 = r3.toString();     // Catch: Throwable -> L15
        ContextWrapper r7 = r4.a().getCurrentActivity();     // Catch: Throwable -> L15
        if (r7 != null) goto L6;
        r7 = r4.getApplication();     // Catch: Throwable -> L15
    L6:
        FLogger.a.i("ApkInstallGateway", "startInstaller:" + r7 + ", file:" + r6 + ", authority:" + r5);     // Catch: Throwable -> L15
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L15
        if (r1 < 24) goto L9;
        Uri r8 = FileProvider.getUriForFile(r7, r5, r6);     // Catch: Throwable -> L15
    L10:
        Intent r9 = new Intent("android.intent.action.VIEW");     // Catch: Throwable -> L15
        r9.setDataAndType(r8, "application/vnd.android.package-archive");     // Catch: Throwable -> L15
        r9.addFlags(268435456);     // Catch: Throwable -> L15
        if (r1 < 24) goto L13;
        r9.addFlags(1);     // Catch: Throwable -> L15
    L13:
        r7.startActivity(r9);     // Catch: Throwable -> L15
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L23;
        FLogger.a.e("ApkInstallGateway", "startInstaller fail : " + r11.getMessage());
        return;
    L23:
        return;
    L9:
        r8 = Uri.fromFile(r6);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
