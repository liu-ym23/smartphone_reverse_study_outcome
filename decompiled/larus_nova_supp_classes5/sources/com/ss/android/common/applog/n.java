package com.ss.android.common.applog;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.applog.m;
import com.obric.sva.sdk.applog.InteractorAppLogLogger;
import eta.b;
import iqa.a;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface n {
    void A();

    void B();

    JSONObject C();

    void D();

    a E();

    void F(Context r1, boolean r2, m0 r3);

    void G();

    int H();

    void a(String r1);

    void b(b r1);

    void c(boolean r1);

    void d(Bundle r1);

    AppLog e(Context r1);

    void f(boolean r1);

    void g(Map<String, String> r1);

    String getCurrentSessionId();

    String getInstallId();

    String getServerDeviceId();

    String getSessionKey();

    String getUserId();

    m h();

    void i(String r1, JSONObject r2);

    void j(boolean r1);

    void k();

    void l(a0.a r1);

    JSONObject m();

    void n(InteractorAppLogLogger r1);

    void o(com.obric.sva.sdk.applog.a r1);

    void onPause(Context r1);

    void onResume(Context r1);

    void p();

    void q();

    void r();

    void registerHeaderCustomCallback(a r1);

    void s(String r1, String r2, String r3, long r4, long r6, boolean r8, JSONObject r9);

    void setAnonymous(boolean r1);

    void setSessionKey(String r1);

    void setUserId(long r1);

    void t(String r1);

    void u(AppLog.f r1);

    void v(String r1);

    String w();

    void x(String r1);

    boolean y(String r1);

    void z(m r1);
}
