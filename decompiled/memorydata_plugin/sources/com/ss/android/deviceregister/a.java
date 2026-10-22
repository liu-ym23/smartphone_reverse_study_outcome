package com.ss.android.deviceregister;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.common.utility.Logger;
import com.obric.memorydata.plugin.R;
import com.ss.android.common.applog.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements com.ss.android.deviceregister.b.a.a {
    private static String f;
    private static String g;
    private static volatile String h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f15124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final boolean f15125b;
    protected final String c;
    private com.ss.android.deviceregister.b.a.a.b d;
    private final com.ss.android.deviceregister.b.a.a.a e;

    a(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.c = b(r4);
        this.f15125b = r4;
        Context r6 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f15124a = r6;
        c r0 = new c(r5, com.ss.android.deviceregister.a.b.b());
        this.d = new com.ss.android.deviceregister.b.a.a.e(r6);
        com.ss.android.deviceregister.b.a.a.a r1 = new com.ss.android.deviceregister.b.a.a.a(r6);
        this.e = r1;
        this.d.a(r1);
        if (com.ss.android.deviceregister.d.e.w() == false) goto L7;
        if (com.ss.android.deviceregister.d.e.b(r5) == false) goto L7;
    L10:
        if (f.n() == true) goto L12;
        return;
    L12:
        if (f.m() == true) goto L16;
        r0.a();
        return;
    L16:
        return;
    L7:
        if (f.m() == false) goto L10;
        a(r0, r1);
        goto L10
    }

    static String a(Context r13) {
        String r14 = ((Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.key_external_derectory_device_parameter, TypedValues.Custom.S_STRING, "key_external_derectory_device_parameter")) + com.ss.android.deviceregister.b.a.a.c.a();
        return new String(new char[]{r14.charAt(1), r14.charAt(3), r14.charAt(1), r14.charAt(11), r14.charAt(15), r14.charAt(10), r14.charAt(8), r14.charAt(17), r14.charAt(9), r14.charAt(9), r14.charAt(12), r14.charAt(13), r14.charAt(13), r14.charAt(5), r14.charAt(18), r14.charAt(13), r14.charAt(14), r14.charAt(11), r14.charAt(4), r14.charAt(19), r14.charAt(7)}).substring(2, 18);
    }

    private String b(boolean r1) {
        if (r1 == false) goto L4;
        return "_local";
    L4:
        return "";
    }

    @Override // com.ss.android.deviceregister.b.a.a
    public String a() {
        if (TextUtils.isEmpty(g) == false) goto L5;
        SharedPreferences r1 = this.f15124a.getSharedPreferences(com.ss.android.deviceregister.a.b.c(), 0);     // Catch: Exception -> L14
        String r2 = r1.getString("clientudid", null);     // Catch: Exception -> L14
        if (com.ss.android.deviceregister.d.b.a(r2) == true) goto L10;
        r2 = UUID.randomUUID().toString();     // Catch: Exception -> L14
        SharedPreferences.Editor r3 = r1.edit();     // Catch: Exception -> L14
        r3.putString("clientudid", r2);     // Catch: Exception -> L14
        r3.commit();     // Catch: Exception -> L14
    L10:
        if (com.bytedance.common.utility.h.a(r2) == true) goto L12;
        r2 = r2 + this.c;     // Catch: Exception -> L14
    L12:
        g = r2;     // Catch: Exception -> L14
        return r2;
    L14:
        e = move-exception;
        Logger.w("DeviceParamsProvider", "exception when making client_udid: " + e);
        e.printStackTrace();
        return "";
    L5:
        return g;
    }

    @Override // com.ss.android.deviceregister.b.a.a
    public String a(boolean r8) {
        if (com.bytedance.common.utility.h.a(f) == false) goto L5;
        String r0 = com.ss.android.deviceregister.d.c.c(this.f15124a);
        if (r0 != null) goto L34;
    L12:
        SharedPreferences r2 = this.f15124a.getSharedPreferences(com.ss.android.deviceregister.a.b.c(), 0);     // Catch: Exception -> L25
        String r3 = r2.getString("openudid", null);     // Catch: Exception -> L25
        if (com.ss.android.deviceregister.d.b.a(r3) == true) goto L24;
        r3 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L25
        if (r3.charAt(0) != '-') goto L17;
        r3 = r3.substring(1);     // Catch: Exception -> L25
    L17:
        int r1 = 13 - r3.length();     // Catch: Exception -> L25
        if (r1 <= 0) goto L23;
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L25
    L20:
        if (r1 <= 0) goto L22;
        r4.append('F');     // Catch: Exception -> L25
        r1 = r1 - 1;     // Catch: Exception -> L25
        goto L20
    L22:
        r4.append(r3);     // Catch: Exception -> L25
        r3 = r4.toString();     // Catch: Exception -> L25
    L23:
        SharedPreferences.Editor r5 = r2.edit();     // Catch: Exception -> L25
        r5.putString("openudid", r3);     // Catch: Exception -> L25
        r5.commit();     // Catch: Exception -> L25
    L25:
        e = move-exception;
        Logger.w("DeviceParamsProvider", "exception when making openudid: " + e);
    L28:
        if (com.bytedance.common.utility.h.a(r0) == true) goto L31;
        r0 = r0 + this.c;
    L31:
        if (com.bytedance.common.utility.h.a(r0) == true) goto L33;
        f = r0;
    L33:
        return r0;
    L24:
        r0 = r3;
        goto L28
    L34:
        if (r0.equals(IInstallParameters.FAKE_ANDROID_ID) == true) goto L12;
        if (r0.length() >= 13) goto L28;
    L5:
        return f;
    }

    public void a(Account r1) {
        this.e.a(r1);
    }

    public void a(Context r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return;
    L5:
        h = null;
        String r0 = Api.KEY_CLEAR_KEY_PREFIX + r7;
        SharedPreferences r9 = com.ss.android.deviceregister.a.b.a(r8);
        if (r9.getBoolean(r0, false) == true) goto L17;
        SharedPreferences.Editor r1 = r9.edit();
        r1.putBoolean(r0, true);
        if (r9.contains("device_id") == false) goto L11;
        r1.remove("device_id");
    L11:
        if (r9.contains("install_id") == false) goto L13;
        r1.remove("install_id");
    L13:
        r1.commit();
        this.d.b("device_id");
        if (Logger.debug() == false) goto L20;
        StringBuilder r10 = new StringBuilder().append("clearKey : ").append(r7);
        String r11 = " :clear installId and deviceId finish";
    L19:
        Logger.d("DeviceParamsProvider", r10.append(r11).toString());
    L20:
        l.b(l.f15219a, "DeviceParamsProvider#clear mCacheHandler.loadDeviceId()=" + this.d.b("", ""));
        return;
    L17:
        if (Logger.debug() == false) goto L20;
        r10 = new StringBuilder().append("clearKey : ").append(r7);
        r11 = " : is already cleared";
        goto L19
    }

    public void a(c r1, com.ss.android.deviceregister.b.a.a.b r2) {
    }

    @Override // com.ss.android.deviceregister.b.a.a
    public void a(String r2) {
        if (y.a(r2) == false) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.h.a(r2, h) == true) goto L10;
        h = this.d.b(r2, h);
        return;
    }

    public void a(JSONArray r5, String r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() == 0) goto L19;
        int r4 = 0;
    L7:
        if (r4 >= r5.length()) goto L20;
        JSONObject r0 = r5.optJSONObject(r4);
        if (r0 == null) goto L13;
        String r2 = r0.optString(OaidModel.KEY_ID);
        if (TextUtils.isEmpty(r2) == true) goto L13;
        r0.remove(OaidModel.KEY_ID);
        r0.put(OaidModel.KEY_ID, r2 + r6);
    L13:
        r4 = r4 + 1;
        goto L7
    L20:
        return;
    }

    @Override // com.ss.android.deviceregister.b.a.a
    public String b() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (com.bytedance.common.utility.h.a(h) == true) goto L8;
        String r0 = h;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r0;
    L8:
        h = this.d.b("", "");     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return h;
    }

    @Override // com.ss.android.deviceregister.b.a.a
    public void b(String r3) {
        if (TextUtils.equals(r3, "device_id") == false) goto L6;
        h = null;
    L6:
        if (TextUtils.equals(r3, "openudid") == false) goto L9;
        f = null;
    L9:
        if (TextUtils.equals(r3, "clientudid") == false) goto L11;
        g = null;
    L11:
        this.d.b(r3);
    }
}
