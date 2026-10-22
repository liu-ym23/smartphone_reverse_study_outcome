package com.obric.cae.utils.bridge;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.PowerManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\u000bH\u0007R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/cae/utils/bridge/CaeCoreBridgeApi;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "getAppVersionName", "", "getPackageName", "getSdkInt", "", "getSystemLocale", "getTemperatureState", "CommSenseAAR_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CaeCoreBridgeApi {
    private final Context appContext;

    public CaeCoreBridgeApi(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.appContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    @PythonBridgeMethod
    public final String getAppVersionName() {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        PackageInfo r3 = this.appContext.getPackageManager().getPackageInfo(this.appContext.getPackageName(), PackageManager.PackageInfoFlags.of(0));
    L6:
        String r4 = r3.versionName;
        if (r4 != null) goto L10;
        return "";
    L10:
        return r4;
    L5:
        r3 = this.appContext.getPackageManager().getPackageInfo(this.appContext.getPackageName(), 0);
        goto L6
    }

    @PythonBridgeMethod
    public final String getPackageName() {
        String r1 = this.appContext.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r1, "appContext.packageName");
        return r1;
    }

    @PythonBridgeMethod
    public final int getSdkInt() {
        return Build.VERSION.SDK_INT;
    }

    @PythonBridgeMethod
    public final String getSystemLocale() {
        String r1 = ZeusTransformUtils.getResources(this.appContext, "com.obric.memorydata.plugin").getConfiguration().getLocales().get(0).toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(r1, "appContext.resources.con…ocales[0].toLanguageTag()");
        return r1;
    }

    @PythonBridgeMethod
    public final int getTemperatureState() {
        PowerManager r2 = (PowerManager) ZeusTransformUtils.preCheckCast(this.appContext.getSystemService(PowerManager.class), PowerManager.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.getCurrentThermalStatus();
    }
}
