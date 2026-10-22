package com.obric.feature.miniapp.widget.depend;

import android.app.Application;
import android.content.Context;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\nJ\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u0011\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0016\u0010\nJ\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u001b\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/obric/feature/miniapp/widget/depend/ObricLauncherHostDependServiceImpl;", "Lcom/bytedance/ai/bridge/service/IHostContextDepend;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "getApplication", "()Landroid/app/Application;", "", "getDeviceId", "()Ljava/lang/String;", "", "getAppId", "()I", "getAppName", "getChannel", "getClientDid", "getVersionName", "getUpdateVersion", "getLanguage", "getPackageName", "getSkinName", "getHttpEnv", "", "isTeenMode", "()Z", "isBaseMode", "getCurrentTelcomCarrier", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricLauncherHostDependServiceImpl implements IHostContextDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f11427a;

    public ObricLauncherHostDependServiceImpl(Application r5) {
        Intrinsics.checkNotNullParameter(r5, "application");
        this.f11427a = r5;
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public int getAppId() {
        return 123456;
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public String getAppName() {
        return "ObricLauncher";
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public Application getApplication() {
        return this.f11427a;
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public String getChannel() {
        return "obric";
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public String getClientDid() {
        return getDeviceId();
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public String getCurrentTelcomCarrier() {
        return null;
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public String getDeviceId() {
        String r5 = null;
        Object r10 = MatrixTeaManager.class.getMethod("getInstance", null).invoke(null, null);     // Catch: Exception -> L9
        Object r11 = MatrixTeaManager.class.getMethod("getDeviceId", null).invoke(r10, null);     // Catch: Exception -> L9
        if ((r11 instanceof String) == false) goto L6;
        r5 = (String) r11;     // Catch: Exception -> L9
    L6:
        if (r5 != null) goto L8;
        return "";
    L8:
        return r5;
    L9:
        return "";
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public String getHttpEnv() {
        return null;
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public String getPackageName() {
        return this.f11427a.getPackageName();
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public String getSkinName() {
        return "";
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public String getUpdateVersion() {
        return getVersionName();
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public String getVersionName() {
        String r5 = this.f11427a.getPackageManager().getPackageInfo(this.f11427a.getPackageName(), 0).versionName;     // Catch: Exception -> L7
        if (r5 != null) goto L6;
        return "";
    L6:
        return r5;
    L7:
        return "";
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public boolean isBaseMode() {
        return true;
    }

    @Override // com.bytedance.ai.bridge.service.IHostContextDepend
    public boolean isTeenMode() {
        return false;
    }
}
