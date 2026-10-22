package com.ss.android.deviceregister.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.bdinstall.Cdid;
import com.ss.android.deviceregister.a.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15206b;
    private ConcurrentHashMap<String, String> c;
    private WeakReference<Context> d;
    private String e;

    d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f15205a = false;
        this.f15206b = false;
        this.c = new ConcurrentHashMap();
        this.d = new WeakReference(r4);
        if (d() == false) goto L6;
        e();
        return;
    }

    private void a(String r3) {
        SharedPreferences.Editor r2 = ((Context) ZeusTransformUtils.preCheckCast(this.d.get(), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("debug_new_user_mode_sp", 0).edit();
        r2.putString("new_user_mode_json_str", r3);
        r2.apply();
    }

    private void b(String r5) {
        JSONObject r0 = new JSONObject(r5);
        this.f15205a = r0.optBoolean("is_new_user_mode", false);
        this.f15206b = r0.optBoolean("auto_mode", false);
        JSONObject r1 = new JSONObject(r0.optString("debug_custom_param", ""));
        Iterator<String> r6 = r1.keys();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        String r3 = r1.optString(r2);
        this.c.put(r2, r3);
        goto L4
    }

    private boolean d() {
        if (TextUtils.isEmpty(this.e) == false) goto L6;
        this.e = u.d();
    L6:
        return "local_test".equals(this.e);
    }

    private void e() {
        String r0 = f();
        if (TextUtils.isEmpty(r0) == false) goto L11;
        r0 = e.a((Context) ZeusTransformUtils.preCheckCast(this.d.get(), Context.class, "com.obric.memorydata.plugin"));
    L11:
        b(r0);     // Catch: JSONException -> L7
    L9:
        a(r0);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    private String f() {
        return ((Context) ZeusTransformUtils.preCheckCast(this.d.get(), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("debug_new_user_mode_sp", 0).getString("new_user_mode_json_str", "");
    }

    @Override // com.ss.android.deviceregister.c.b
    public void a(Map<String, String> r3) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")).putAll(this.c);
    }

    @Override // com.ss.android.deviceregister.c.b
    public boolean a() {
        return this.f15205a;
    }

    @Override // com.ss.android.deviceregister.c.b
    public boolean b() {
        return this.f15206b;
    }

    @Override // com.ss.android.deviceregister.c.b
    public void c() {
        if (d() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r0 = ((Context) ZeusTransformUtils.preCheckCast(this.d.get(), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("device_param_fake", 0).edit();
        r0.clear();
        r0.apply();
        if (Build.VERSION.SDK_INT < 21) goto L8;
        CookieManager.getInstance().removeAllCookies(null);
    L8:
        SharedPreferences.Editor r1 = ((Context) ZeusTransformUtils.preCheckCast(this.d.get(), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("cookieStore", 0).edit();
        r1.clear();
        r1.apply();
        SharedPreferences.Editor r2 = ((Context) ZeusTransformUtils.preCheckCast(this.d.get(), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("tt_new_token_save_sp", 0).edit();
        r2.putString("X-Tt-Token", "");
        r2.apply();
        SharedPreferences.Editor r5 = ((Context) ZeusTransformUtils.preCheckCast(this.d.get(), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("com.ss.android.deviceregister.utils.Cdid", 0).edit();
        r5.putString(Cdid.KEY_CDID, "");
        r5.apply();
    }
}
