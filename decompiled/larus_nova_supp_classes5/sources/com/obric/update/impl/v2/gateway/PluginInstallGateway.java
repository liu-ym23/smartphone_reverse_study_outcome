package com.obric.update.impl.v2.gateway;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class PluginInstallGateway {

    public static final class a {
    }

    static {
    }

    public PluginInstallGateway() {
    }

    public final Object b(PolarisFileWrapper r4, Continuation r5) {
        if (r4 == null) goto L7;
        boolean r2 = true;
        if (r4.exists() != true) goto L7;
    L8:
        if (r2 == true) goto L12;
        FLogger.a.i("PluginInstallGateway", "isPluginPreInstalled apkFile not exists:" + r4);
        return Boxing.boxBoolean(false);
    L12:
        return BuildersKt.withContext(Dispatchers.getIO(), new isPluginPreInstalled.2(this, r4, null), r5);
    L7:
        r2 = false;
        goto L8
    }

    public final Object c(File r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof preInstallPlugin.1) == false) goto L7;
        preInstallPlugin.1 r1 = (preInstallPlugin.1) r8;
        int r2 = r1.label;
        if ((r2 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r9 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L17;
        if (r4 != 1) goto L16;
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L13
    L25:
        Unit r10 = (Unit) r9;     // Catch: Exception -> L13
    L30:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r9);
        if (r7 != null) goto L20;
    L26:
        FLogger.a.i("PluginInstallGateway", "preInstallPlugin apkFile not exists:" + r7);     // Catch: Exception -> L13
        return Unit.INSTANCE;
    L20:
        if (r7.exists() == false) goto L26;
        CoroutineDispatcher r11 = Dispatchers.getIO();     // Catch: Exception -> L13
        preInstallPlugin.2 r0 = new preInstallPlugin.2(r7, null);     // Catch: Exception -> L13
        r1.label = 1;     // Catch: Exception -> L13
        r9 = BuildersKt.withContext(r11, r0, r1);     // Catch: Exception -> L13
        if (r9 != r3) goto L25;
        return r3;
    L13:
        e = move-exception;
        FLogger.a.e("PluginInstallGateway", "preInstallPlugin fail:" + e);
    L7:
        r1 = new preInstallPlugin.1(this, r8);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final long a(PluginInstallGateway r5, Context r6, String r7) {
        r5.getClass();
        String r8 = "PluginInstallGateway";
        long r1 = -1;
        PackageInfo r9 = r6.getPackageManager().getPackageArchiveInfo(r7, 0);     // Catch: Exception -> L11
        if (r9 != null) goto L6;
        FLogger.a.w("PluginInstallGateway", "getApkVersionCode failed, packageInfo is null, path: " + r7);     // Catch: Exception -> L11
        r8 = r8;
    L14:
    L13:
        return r1;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L8;
        r1 = r9.getLongVersionCode();     // Catch: Exception -> L11
        r8 = r8;
        goto L14
    L8:
        int r10 = r9.versionCode;     // Catch: Exception -> L11
        r1 = r10;
        r8 = r10;
    L11:
        e = move-exception;
        FLogger.a.e(r8, "getApkVersionCode error, path: " + r7, e);
        goto L13
    }
}
