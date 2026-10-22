package jta;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.AppLog;
import com.bytedance.bdinstall.c1;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.k;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import i84.o;
import ita.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements l {
    public static volatile boolean d;
    public static volatile String[] e;
    public static volatile String f;
    public static volatile String g;
    public volatile eta.b a;
    public volatile int b;
    public volatile String c;

    @Override // jta.l
    public final void A() {
    }

    @Override // jta.l
    public final void a(Context r1) {
    }

    @Override // jta.l
    public final void c(boolean r1) {
    }

    @Override // jta.l
    public final void d(Context r1, boolean r2) {
    }

    @Override // jta.l
    public final void e() {
    }

    @Override // jta.l
    public final void g() {
    }

    @Override // jta.l
    public final void h(com.ss.android.common.applog.b r1) {
    }

    @Override // jta.l
    public final void i() {
    }

    @Override // jta.l
    public final void isLocalTest() {
    }

    @Override // jta.l
    public final void l(Context r1) {
    }

    @Override // jta.l
    public final void n(boolean r1) {
    }

    @Override // jta.l
    public final void o(boolean r1) {
    }

    @Override // jta.l
    public final void onPause() {
    }

    @Override // jta.l
    public final void onResume() {
    }

    @Override // jta.l
    public final void q(boolean r1) {
    }

    @Override // jta.l
    public final void s(Bundle r1) {
    }

    @Override // jta.l
    public final void z() {
    }

    @Override // jta.l
    public final int getAppId() {
        int r0 = this.b;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        if (this.a != null) goto L7;
        return r0;
    L7:
        return this.a.getAid();
    }

    @Override // jta.l
    public final String getRequestId() {
        return (String) o.a.b(new Object[0]);
    }

    @Override // jta.l
    public final String getVersionName() {
        String r0 = (String) AppLog.getHeaderValue(EffectConfiguration.KEY_APP_VERSION, "", String.class);
        if (TextUtils.isEmpty(r0) == false) goto L8;
        if (this.a == null) goto L8;
        r0 = this.a.getVersion();
    L8:
        if (TextUtils.equals(r0, null) == false) goto L10;
        return r0;
    L10:
        if (TextUtils.isEmpty(null) == false) goto L12;
        return r0;
    L12:
        return null;
    }

    @Override // jta.l
    public final boolean t() {
        k r0 = i.b;
        if (r0.h() != null) goto L7;
        return false;
    L7:
        return ((com.bytedance.bdinstall.b) r0.h()).a;
    }

    @Override // jta.l
    public final String getDeviceId() {
        String r0 = AppLog.getDid();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        return "";
    }

    @Override // jta.l
    public final String getInstallId() {
        return AppLog.getIid();
    }

    public b() {
    }

    @Override // jta.l
    public final void b(eta.b r2) {
        this.a = r2;
        i.b.b = new a(r2);
    }

    @Override // jta.l
    public final String getChannel(Context r4) {
        String r0 = this.c;
        if (TextUtils.isEmpty(r0) == false) goto L8;
        if (this.a == null) goto L8;
        r0 = this.a.getTweakedChannel();
    L8:
        if (TextUtils.isEmpty(r0) == false) goto L16;
        r0 = r4.getPackageManager().getApplicationInfo(r4.getPackageName(), 128).metaData.getString("UMENG_CHANNEL");     // Catch: Throwable -> L11
        this.c = r0;     // Catch: Throwable -> L11
        return r0;
    L11:
        th = move-exception;
        j.g("BdWrapperImpl getChannel", th);
        return r0;
    L16:
        return r0;
    }

    @Override // jta.l
    public final boolean k(boolean r1) {
        AppLog.clearWhenSwitchChildMode(r1);
        return true;
    }

    @Override // jta.l
    public final void p(g.a r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        AppLog.addDataObserver(new b(r2));
    }

    @Override // jta.l
    public final boolean r(Context r1) {
        return AppLog.isNewUserMode(r1);
    }

    @Override // jta.l
    public final void setAnonymous(boolean r1) {
        d = r1;
    }

    @Override // jta.l
    public final void setChannel(String r1) {
        this.c = r1;
    }

    @Override // jta.l
    public final void u(int r1) {
        this.b = r1;
    }

    @Override // jta.l
    public final void v(Context r1) {
        i.c();     // Catch: InterruptedException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jta.l
    public final void w(String r1) {
        g = r1;
    }

    @Override // jta.l
    public final void j(Context r1, String r2) {
        AppLog.setUserAgent(r2);
    }

    @Override // jta.l
    public final void x(Map<String, String> r2, Context r3) {
        AppLog.getSsidGroup(r2);
        String r4 = AppLog.getUserID();
        if (r4 == null) goto L6;
        ((HashMap) r2).put("user_id", r4);
        return;
    }

    @Override // jta.l
    public final void y(String[] r1, String[] r2) {
        e = r1;
        f = r2[0];
    }

    @Override // jta.l
    public final boolean f(Context r1, JSONObject r2, boolean r3) {
        JSONObject r4 = AppLog.getHeader();
        if (r4 == null) goto L6;
        c1.e(r2, r4);
        return true;
    L6:
        return false;
    }

    @Override // jta.l
    public final void m(boolean r3, long r4, n r6) {
        AppLog.resetDidWhenSwitchChildMode(AppLog.getContext(), r3, r4, new c(r6));
    }
}
