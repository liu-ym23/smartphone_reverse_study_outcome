package jta;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface l {
    void A();

    void a(Context r1);

    void b(eta.b r1);

    void c(boolean r1);

    void d(Context r1, boolean r2);

    void e();

    boolean f(Context r1, JSONObject r2, boolean r3);

    void g();

    int getAppId();

    String getChannel(Context r1);

    String getDeviceId();

    String getInstallId();

    String getRequestId();

    String getVersionName();

    void h(com.ss.android.common.applog.b r1);

    void i();

    void isLocalTest();

    void j(Context r1, String r2);

    boolean k(boolean r1);

    void l(Context r1);

    void m(boolean r1, long r2, n r4);

    void n(boolean r1);

    void o(boolean r1);

    void onPause();

    void onResume();

    void p(g.a r1);

    void q(boolean r1);

    boolean r(Context r1);

    void s(Bundle r1);

    void setAnonymous(boolean r1);

    void setChannel(String r1);

    boolean t();

    void u(int r1);

    void v(Context r1);

    void w(String r1);

    void x(Map<String, String> r1, Context r2);

    void y(String[] r1, String[] r2);

    void z();
}
