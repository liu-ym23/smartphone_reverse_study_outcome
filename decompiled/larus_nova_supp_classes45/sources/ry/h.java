package ry;

import android.app.Application;
import com.bytedance.android.live.saas.middleware.alog.ALogConfig;
import com.bytedance.android.live.saas.middleware.applog.AppLogConfig;
import com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface h {

    public interface a {
    }

    e a();

    String b();

    String c();

    i d();

    a e();

    boolean f();

    o g();

    ALogConfig getALogConfig();

    int getAid();

    int getAppIcon();

    AppLogConfig getAppLogConfig();

    String getAppName();

    String getCJAppId();

    String getCJMerchantId();

    String getChannel();

    String getClientKey();

    Application getContext();

    boolean getDebug();

    g getHostAction();

    Class getHostActivity();

    String getVersion();

    int getVersionCode();

    String h();

    Map<String, String> i();

    IHostTokenInjectionAuth injectAccount();

    boolean isBoe();

    String j();

    p k();

    String l();

    String m();

    String n();
}
