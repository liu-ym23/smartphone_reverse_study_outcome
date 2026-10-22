package fu8;

import android.app.Application;
import android.net.Uri;
import android.os.Build;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.reparo.IReparoConfig;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import ita.i;
import ita.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends IReparoConfig {
    public final Application a;

    public final boolean enable() {
        return true;
    }

    public final String getAppId() {
        return String.valueOf(AppHost.a.getAppId());
    }

    public final String getChannel() {
        return AppHost.a.getBuildChannel();
    }

    public final String getDeviceId() {
        return IApplog.a.getDeviceId();
    }

    public final String getUpdateVersionCode() {
        return String.valueOf(AppHost.a.getUpdateVersionCode());
    }

    public final boolean isMainProcess() {
        Application r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        return k.i(r0);
    L5:
        th = move-exception;
        nu8.a.f("ProcessUtils", th, "isMainProcess failed ");
        return false;
    }

    public final Application getApplication() {
        return this.a;
    }

    public a(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        this.a = r2;
    }

    public final String executePatchRequest(int r5, String r6, byte[] r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, ShareType.URL);
        Intrinsics.checkNotNullParameter(r7, "localPatchInfoBytes");
        Intrinsics.checkNotNullParameter(r8, "contentType");
        Uri.Builder r9 = UriProtector.parse(r6).buildUpon();
        r9.appendQueryParameter("device_id", getDeviceId()).appendQueryParameter("channel", getChannel()).appendQueryParameter("aid", getAppId()).appendQueryParameter("device_platform", "android").appendQueryParameter("os_api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("update_version_code", getUpdateVersionCode());
        String r0 = Build.VERSION.RELEASE;     // Catch: Exception -> L10
        if (r0 != null) goto L6;
    L8:
        r9.appendQueryParameter("os_version", r0);     // Catch: Exception -> L10
    L13:
        return i.b(r5, r9.build().toString(), r7, NetworkUtils.CompressType.GZIP, r8);
    L6:
        if (r0.length() <= 10) goto L8;
        r0 = r0.substring(0, 10);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        FLogger.a.e("hot patch", e.getMessage(), e);
        goto L13
    }
}
