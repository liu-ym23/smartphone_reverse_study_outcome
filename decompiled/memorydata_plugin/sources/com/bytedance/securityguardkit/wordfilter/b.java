package com.bytedance.securityguardkit.wordfilter;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.securityguardkit.securitylib.SecurityLibCompat;
import com.google.gson.Gson;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.securityguardkit.wordfilter.a f3171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3172b;
    private com.bytedance.securityguardkit.wordfilter.a c;
    private int d;
    private Set<String> e;
    private final Object f;
    private final Context g;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map<String, Set<String>> f3175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3176b;

        a(Map<String, Set<String>> r3, int r4) {
            this.f3175a = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            this.f3176b = r4;
        }
    }

    public b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.f3171a = null;
        this.f3172b = 0;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.f = new Object();
        this.g = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    private a a(Context r9, String r10, Set<String> r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        String r14 = c(r10);     // Catch: Exception -> L35
        Log.d("SensitiveWordFilter", "sensitiveWords:" + r14);     // Catch: Exception -> L35
        if (TextUtils.isEmpty(r14) == false) goto L7;
        Log.e("SensitiveWordFilter", "敏感词库为空");     // Catch: Exception -> L35
        return null;
    L7:
        JSONObject r3 = new JSONObject(r14);     // Catch: Exception -> L35
        int r15 = r3.getInt("version");     // Catch: Exception -> L35
        if (r15 >= 0) goto L11;
        Log.e("SensitiveWordFilter", "敏感词库版本号错误");     // Catch: Exception -> L35
        return null;
    L11:
        JSONObject r16 = a(r12, r3);     // Catch: Exception -> L35
        if (r16 != null) goto L15;
        Log.e("SensitiveWordFilter", "解析敏感词表错误");     // Catch: Exception -> L35
        return null;
    L15:
        Gson r4 = new Gson();     // Catch: Exception -> L35
        if (r13 != null) goto L18;
    L32:
        Map<String, Set<String>> r8 = (Map) ZeusTransformUtils.preCheckCast(r4.fromJson(r16.toString(), new AnonymousClass1(this).getType()), Map.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L35
    L34:
        return new a(r8, r15);
    L18:
        if (r13.isEmpty() == true) goto L32;
        HashSet r5 = new HashSet();     // Catch: Exception -> L35
        Iterator<String> r6 = r16.keys();     // Catch: Exception -> L35
    L22:
        if (r6.hasNext() == false) goto L24;
        r5.add((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L35
        goto L22
    L24:
        HashSet r7 = new HashSet();     // Catch: Exception -> L35
        Iterator r17 = r13.iterator();     // Catch: Exception -> L35
    L26:
        if (r17.hasNext() == false) goto L31;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L35
        if (r5.contains(r18) == true) goto L29;
        Log.w("SensitiveWordFilter", "指定的敏感词类别不存在：" + r18);     // Catch: Exception -> L35
        goto L26
    L29:
        r7.add(r18);     // Catch: Exception -> L35
        goto L26
    L31:
        r8 = a(r16, r7);     // Catch: Exception -> L35
    L35:
        e = move-exception;
        Log.e("SensitiveWordFilter", "load sens word failed, " + e.getMessage());
        return null;
    }

    public static String a(String r5, String r6) {
        byte[] r7 = Base64.decode(r5, 0);
        byte[] r2 = new byte[12];
        int r3 = r7.length - 12;
        byte[] r4 = new byte[r3];
        System.arraycopy(r7, 0, r2, 0, 12);
        System.arraycopy(r7, 12, r4, 0, r3);
        SecretKeySpec r8 = new SecretKeySpec(Base64.decode(r6, 0), CryptoConst.ALGORITHM_AES);
        Cipher r9 = Cipher.getInstance("AES/GCM/NoPadding");
        r9.init(2, r8, new GCMParameterSpec(128, r2));
        return new String(r9.doFinal(r4), RpcUtils.CHARSET_UTF8);
    }

    private Map<String, Set<String>> a(JSONObject r8, Set<String> r9) {
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        Iterator r2 = r10.iterator();     // Catch: Exception -> L8
    L5:
        if (r2.hasNext() == false) goto L9;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
        r0.put(r3, (Set) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r8.getString(r3), new AnonymousClass2(this).getType()), Set.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L8
    L9:
        return r0;
    L8:
        Log.w("SensitiveWordFilter", "加载指定类别失败：" + r10);
        goto L9
    }

    private JSONObject a(Context r7, JSONObject r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
    L16:
        e = move-exception;
        Log.e("SensitiveWordFilter", "getSensitiveWords occur exception, " + e.getMessage());
        return null;
    L4:
        if (r8.getString("encrypt_type").equals(WsConstants.KEY_PLATFORM) == false) goto L15;
        String r2 = r8.getString("public_key");     // Catch: Exception -> L16
        String r3 = r8.getString("words_key");     // Catch: Exception -> L16
        String r10 = r8.getString("words_cipher");     // Catch: Exception -> L16
        byte[] r6 = a(r9, d(), Base64.decode(r3, 0), Base64.decode(r2, 0), new Bundle());     // Catch: Exception -> L16
        if (r6 != null) goto L8;
    L12:
        Log.e("SensitiveWordFilter", "platformDecrypt return empty");     // Catch: Exception -> L16
        return null;
    L8:
        if (r6.length == 0) goto L12;
        return new JSONObject(a(r10, Base64.encodeToString(r6, 0)));
    L15:
        return r8.getJSONObject("words");
    }

    private static byte[] a(Context r2, int r3, byte[] r4, byte[] r5, Bundle r6) {
        return SecurityLibCompat.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
    L5:
        th = move-exception;
        Log.w("SensitiveWordFilter", "platformDecrypt failed", th);
        return null;
    }

    private static String c(String r12) {
        String[] r1 = {"android.security.obric.guard.ObricSecurityGuardStub", "android.security.aiassistant.guard.AssistantSecurityGuardStub"};
        int r3 = 0;
    L3:
        String r4 = null;
        if (r3 >= 2) goto L19;
        String r5 = r1[r3];
        Class r6 = ZeusTransformUtils.forName(r5, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16 ClassNotFoundException -> L20
        if (r6.getClassLoader() != null) goto L18;
        Method r7 = r6.getDeclaredMethod("getInstance", new Class[0]);     // Catch: Throwable -> L16 ClassNotFoundException -> L20
        r7.setAccessible(true);     // Catch: Throwable -> L16 ClassNotFoundException -> L20
        Object r8 = r7.invoke(null, new Object[0]);     // Catch: Throwable -> L16 ClassNotFoundException -> L20
        if (r8 == null) goto L18;
        Object r9 = r6.getMethod("getSecurityPolicy", new Class[]{String.class}).invoke(r8, new Object[]{r12});     // Catch: Throwable -> L16 ClassNotFoundException -> L20
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L15;
        r4 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16 ClassNotFoundException -> L20
    L15:
        return r4;
    L16:
        th = move-exception;
        Log.w("SensitiveWordFilter", "getSecurityPolicyFromFramework failed for " + r5, th);
    L18:
        r3 = r3 + 1;
        goto L3
    L19:
        return null;
    }

    private int d() {
        if (Build.SOC_MODEL.equalsIgnoreCase("SM7450") == false) goto L7;
        return -983039;
    L7:
        if (Build.SOC_MODEL.equalsIgnoreCase("SM8750") == false) goto L10;
        return -983038;
    L10:
        if (Build.SOC_MODEL.equalsIgnoreCase("SM8850") == false) goto L13;
        return -983037;
    L13:
        Log.e("SensitiveWordFilter", "unsupported platform: " + Build.SOC_MODEL);
        return -983038;
    }

    public Set<String> a(String r4) {
        Object r0 = this.f;
        monitor-enter(r0);
        com.bytedance.securityguardkit.wordfilter.a r1 = this.f3171a;     // Catch: Throwable -> L18
        if (r1 == null) goto L10;
        Set<String> r2 = r1.a(r4).keySet();     // Catch: Throwable -> L18
        if (r2.isEmpty() == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r2;
    L10:
        com.bytedance.securityguardkit.wordfilter.a r3 = this.c;     // Catch: Throwable -> L18
        if (r3 == null) goto L15;
        Set<String> r5 = r3.a(r4).keySet();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r5;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return null;
    L18:
        th = move-exception;
        throw th;
    }

    public void a() {
        if (this.f3171a == null) goto L5;
        return;
    L5:
        a r0 = a(this.g, "sens_words.json", null);
        if (r0 != null) goto L9;
        Log.e("SensitiveWordFilter", "解析敏感词库1失败");
        return;
    L9:
        Object r1 = this.f;
        monitor-enter(r1);
    L19:
        th = move-exception;
        throw th;
    L12:
        if (r0.f3175a.isEmpty() == false) goto L14;
        Log.w("SensitiveWordFilter", "敏感词库1为空");     // Catch: Throwable -> L19
        this.f3171a = null;     // Catch: Throwable -> L19
    L15:
        this.f3172b = r0.f3176b;     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        Log.i("SensitiveWordFilter", "解析敏感词库1成功");
        return;
    L14:
        com.bytedance.securityguardkit.wordfilter.a r2 = new com.bytedance.securityguardkit.wordfilter.a();     // Catch: Throwable -> L19
        this.f3171a = r2;     // Catch: Throwable -> L19
        r2.a(r0.f3175a);     // Catch: Throwable -> L19
        goto L15
    }

    public boolean a(Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        a r0 = a(this.g, "sens_words_2.json", r6);
        if (r0 != null) goto L6;
        Log.e("SensitiveWordFilter", "解析敏感词库2失败");
        return false;
    L6:
        Object r1 = this.f;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (r0.f3175a.isEmpty() == false) goto L11;
        Log.w("SensitiveWordFilter", "敏感词库2为空");     // Catch: Throwable -> L16
        this.c = null;     // Catch: Throwable -> L16
    L12:
        this.e = r6;     // Catch: Throwable -> L16
        this.d = r0.f3176b;     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        Log.i("SensitiveWordFilter", "解析敏感词库2成功");
        return true;
    L11:
        com.bytedance.securityguardkit.wordfilter.a r2 = new com.bytedance.securityguardkit.wordfilter.a();     // Catch: Throwable -> L16
        this.c = r2;     // Catch: Throwable -> L16
        r2.a(r0.f3175a);     // Catch: Throwable -> L16
        goto L12
    }

    public Set<String> b(String r4) {
        Object r0 = this.f;
        monitor-enter(r0);
        com.bytedance.securityguardkit.wordfilter.a r1 = this.f3171a;     // Catch: Throwable -> L20
        if (r1 == null) goto L12;
        Set<String> r2 = r1.b(r4);     // Catch: Throwable -> L20
        if (r2 == null) goto L12;
        if (r2.isEmpty() == true) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r2;
    L12:
        com.bytedance.securityguardkit.wordfilter.a r3 = this.c;     // Catch: Throwable -> L20
        if (r3 == null) goto L17;
        Set<String> r5 = r3.b(r4);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r5;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    public void b() {
        Object r0 = this.f;
        monitor-enter(r0);
        Set<String> r1 = this.e;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.clear();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public JSONObject c() {
        JSONObject r0 = new JSONObject();
        r0.put("base_version", this.f3172b);     // Catch: JSONException -> L5
        r0.put("usr_version", this.d);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        Log.e("SensitiveWordFilter", "getSensitiveCapability JSONException", e);
        goto L7
    }
}
