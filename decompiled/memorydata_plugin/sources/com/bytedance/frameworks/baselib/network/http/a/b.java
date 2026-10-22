package com.bytedance.frameworks.baselib.network.http.a;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.f;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f2359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f2360b;
    private volatile boolean c;

    private b() {
        this.c = false;
    }

    public static b a() {
        if (f2359a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2359a != null) goto L9;
        f2359a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f2359a;
    }

    private String a(Map<String, String> r7, String r8, boolean r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L5;
    L32:
        return r8;
    L5:
        if (r10.isEmpty() == true) goto L32;
        StringBuilder r0 = new StringBuilder(r8);
        if (r8.indexOf(63) >= 0) goto L10;
        String r11 = "?";
    L11:
        r0.append(r11);
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.entrySet().iterator();
    L13:
        if (r13.hasNext() == false) goto L27;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L13;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.getValue(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L13;
        Set<String> r3 = this.f2360b.k();
        if (r9 == false) goto L26;
        if (a(r3) == true) goto L26;
        if (r3.contains(r2.getKey()) == true) goto L13;
    L26:
        r12.add(new Pair((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L13
    L27:
        r0.append(NetworkUtils.a(r12, RpcUtils.CHARSET_UTF8));
        if (Logger.debug() == false) goto L31;
        Logger.d("CommonParamManager", "addCommonParamsByQueryMap url: " + r0.toString());
    L31:
        return r0.toString();
    L10:
        r11 = "&";
        goto L11
    }

    private static boolean a(Set<?> r2) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return true;
    L5:
        if (r3.isEmpty() == true) goto L11;
        return false;
    L11:
        return true;
    }

    private boolean a(Set<String> r4, Set<String> r5, Set<Pattern> r6, String r7) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        if (a(r3) == true) goto L11;
        Iterator r10 = r3.iterator();
    L6:
        if (r10.hasNext() == false) goto L11;
        if (r7.equals((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L6;
        return true;
    L11:
        if (a(r8) == true) goto L19;
        Iterator r11 = r8.iterator();
    L14:
        if (r11.hasNext() == false) goto L19;
        if (r7.startsWith((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L14;
        return true;
    L19:
        if (a(r9) == true) goto L28;
        Iterator r12 = r9.iterator();
    L22:
        if (r12.hasNext() == false) goto L45;
        Pattern r13 = (Pattern) ZeusTransformUtils.preCheckCast(r12.next(), Pattern.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L22;
        if (r13.matcher(r7).matches() == false) goto L22;
        return true;
    L45:
        return false;
    L28:
        return false;
    }

    public String a(Request r8, String r9, RetrofitMetrics r10) {
        if (this.f2360b.b() == true) goto L5;
        Set<String> r0 = this.f2360b.d();
        if (a(r0) == false) goto L12;
        return r9;
    L12:
        Iterator<String> r1 = r0.iterator();
    L14:
        if (r1.hasNext() == false) goto L18;
        if (k.a(r8.getHost(), (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L14;
        boolean r2 = true;
    L19:
        if (r2 == true) goto L25;
        if (Logger.debug() == false) goto L23;
        Logger.d("CommonParamManager", "Domain not match: " + r9);
    L23:
        return r9;
    L25:
        if (TextUtils.isEmpty(r8.getPath()) == false) goto L31;
        if (Logger.debug() == false) goto L29;
        Logger.d("CommonParamManager", "Path is empty: " + r8.getPath());
    L29:
        return r9;
    L31:
        if (this.c == false) goto L38;
        if (Logger.debug() == false) goto L36;
        Logger.d("CommonParamManager", "ForceAddMinParams match url: " + r9);
    L36:
        return a(f.a(1, r10), r9, true);
    L38:
        if (a(this.f2360b.e(), this.f2360b.f(), this.f2360b.g(), r8.getPath()) == false) goto L45;
        if (Logger.debug() == false) goto L43;
        Logger.d("CommonParamManager", "AddMaxParamsPathFilterMap match: " + r9);
    L43:
        return a(f.a(0, r10), r9, false);
    L45:
        if (a(this.f2360b.h(), this.f2360b.i(), this.f2360b.j(), r8.getPath()) == false) goto L52;
        if (Logger.debug() == false) goto L50;
        Logger.d("CommonParamManager", "AddMinParamsPathFilterMap match: " + r9);
    L50:
        return a(f.a(1, r10), r9, true);
    L52:
        if (this.f2360b.c() == false) goto L59;
        if (Logger.debug() == false) goto L57;
        Logger.d("CommonParamManager", "addMinCommonParamsWhenDomainMatch is enabled.");
    L57:
        return a(f.a(1, r10), r9, true);
    L59:
        if (Logger.debug() == false) goto L62;
        Logger.d("CommonParamManager", "add max common params by default.");
    L62:
        return a(f.a(0, r10), r9, false);
    L18:
        r2 = false;
        goto L19
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d("CommonParamManager", "addCommonParamsByLevel commonParamLevel: " + r8.getCommonParamLevel());
    L8:
        return a(f.a(r9, true, r8.getCommonParamLevel(), r10), r9, false);
    }

    public a b() {
        return this.f2360b;
    }
}
