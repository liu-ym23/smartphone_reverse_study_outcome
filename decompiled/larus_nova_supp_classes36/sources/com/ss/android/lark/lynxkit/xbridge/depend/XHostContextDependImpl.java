package com.ss.android.lark.lynxkit.xbridge.depend;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.component.appcontext.ILarkAppContext;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.component.appcontext.model.LarkBuildConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.ApiUtils;
import epb.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s56.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0'H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J\b\u00100\u001a\u00020,H\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u00061"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/depend/XHostContextDependImpl;", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostContextDepend;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "appContext", "larkAppContext", "Lcom/ss/android/lark/component/appcontext/ILarkAppContext;", "getLarkAppContext", "()Lcom/ss/android/lark/component/appcontext/ILarkAppContext;", "buildConfig", "Lcom/ss/android/lark/component/appcontext/model/LarkBuildConfig;", "getBuildConfig", "()Lcom/ss/android/lark/component/appcontext/model/LarkBuildConfig;", "appIdInfo", "Lcom/ss/android/lark/component/appcontext/model/AppIdInfo;", "getAppIdInfo", "()Lcom/ss/android/lark/component/appcontext/model/AppIdInfo;", "getApplication", "Landroid/app/Application;", "getAppId", "", "getAppName", "", "getChannel", "getDeviceId", "getLanguage", "getVersionName", "getVersionCode", "", "getUpdateVersion", "getPackageName", "getBoeChannel", "getPPEChannel", "getCurrentTelcomCarrier", "getSkinName", "getSkinType", "getSettings", "", "Lcom/bytedance/ies/xbridge/base/runtime/model/SettingValueEntry;", "settingKeys", "Lcom/bytedance/ies/xbridge/base/runtime/model/SettingKeyEntry;", "isBaseMode", "", "isBoeEnable", "isDebuggable", "isPPEEnable", "isTeenMode", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class XHostContextDependImpl implements IHostContextDepend {
    private final Context appContext;

    public String getAppName() {
        return "feishu";
    }

    public String getBoeChannel() {
        return "";
    }

    public String getCurrentTelcomCarrier() {
        return null;
    }

    public String getPPEChannel() {
        return "";
    }

    public String getSkinName() {
        return "";
    }

    public String getSkinType() {
        return "";
    }

    public boolean isBaseMode() {
        return false;
    }

    public boolean isPPEEnable() {
        return false;
    }

    public boolean isTeenMode() {
        return false;
    }

    private final ILarkAppContext getLarkAppContext() {
        LarkAppContext.Companion.getClass();
        return LarkAppContext.access$getInstance$cp();
    }

    public String getChannel() {
        Bundle r1 = this.appContext.getPackageManager().getApplicationInfo(this.appContext.getPackageName(), 128).metaData;     // Catch: Throwable -> L10
        if (r1 == null) goto L13;
        String r2 = r1.getString("CHANNEL");     // Catch: Throwable -> L10
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2;
    L13:
        return "";
    L15:
        return "";
    }

    public String getDeviceId() {
        return ((a) ApiUtils.getApi(a.class)).getDeviceIdFromLocal();
    L4:
        return "";
    }

    public String getPackageName() {
        return this.appContext.getPackageName();
    }

    public String getUpdateVersion() {
        return String.valueOf(ApkUtil.getUpdateVersionCode(this.appContext));
    }

    public long getVersionCode() {
        return ApkUtil.getAppVersionCode(this.appContext);
    }

    public String getVersionName() {
        String r0 = ApkUtil.getAppVersionName(this.appContext);
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    private final b8b.a getAppIdInfo() {
        return getLarkAppContext().appIdInfo();
    }

    private final LarkBuildConfig getBuildConfig() {
        return getLarkAppContext().buildConfig();
    }

    public int getAppId() {
        return getAppIdInfo().a;
    }

    public Application getApplication() {
        return getLarkAppContext().getContext();
    }

    public Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public boolean isBoeEnable() {
        return getBuildConfig().getInHouse();
    }

    public boolean isDebuggable() {
        return getBuildConfig().getDebug();
    }

    public XHostContextDependImpl(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.appContext = r2.getApplicationContext();
    }

    public List<b> getSettings(List<s56.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "settingKeys");
        return new ArrayList();
    }
}
