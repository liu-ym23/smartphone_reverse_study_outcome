package com.ss.android.common.applog;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.compat.Level;
import com.bytedance.common.utility.CommonHttpException;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.ss.android.common.a f15110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f15111b = null;
    private static final ConcurrentHashMap<String, String> c = null;

    public interface a {
        void a(Context r1, Map<String, String> r2);
    }

    public interface b {
        HashMap<String, String> a(Level r1);
    }

    static {
        f15111b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public static String a() {
        return z.a();
    }

    public static String a(com.bytedance.applog.k r12, String r13, byte[] r14, Context r15, boolean r16, String[] r17, Map<String, String> r18, String r19, boolean r20, boolean r21) {
        return z.a((com.bytedance.applog.k) ZeusTransformUtils.wrapperContextForParams(r12, com.bytedance.applog.k.class, "com.obric.memorydata.plugin"), r13, r14, (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin"), r16, r17, (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin"), r19, r20, r21);
    }

    @Deprecated
    public static String a(String r1, boolean r2) {
        return a(r1, r2, Level.L0);
    }

    public static String a(String r2, boolean r3, Level r4) {
        Level r5 = (Level) ZeusTransformUtils.wrapperContextForParams(r4, Level.class, "com.obric.memorydata.plugin");
        com.ss.android.common.a r0 = f15110a;
        if (com.bytedance.common.utility.h.a(r2) == true) goto L8;
        if (r0 == null) goto L9;
        StringBuilder r1 = new StringBuilder(r2);
        a(r1, r3, r5);
        return r1.toString();
    L9:
        return r2;
    L8:
        return r2;
    }

    public static String a(String r2, byte[] r3, boolean r4, String r5, boolean r6, Map<String, String> r7, final boolean r8, boolean r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        if (r4 == false) goto L10;
        r3 = com.bytedance.common.utility.f.a(r3);     // Catch: Exception -> L6
        r0.put(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        throw new CommonHttpException(0, e.getMessage());
    L10:
        if (com.bytedance.common.utility.h.a(r5) == true) goto L12;
        r0.put(NetConst.KEY_CONTENT_TYPE, r5);
    L12:
        if (r10 == null) goto L14;
        r0.putAll(r10);
    L14:
        if (r9 == false) goto L23;
    L21:
        com.bytedance.common.utility.f.a r11 = new com.bytedance.common.utility.f.a();
        r11.f1986a = r6;
        return com.bytedance.common.utility.f.a().a(r2, r3, r0, r11);
    L23:
        Pair<String, String> r12 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass1(r8));     // Catch: Throwable -> L19
        if (r12 == null) goto L21;
        r0.put(r12.first, r12.second);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
        goto L21
    }

    public static void a(StringBuilder r7, Map<String, String> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Uri r0 = Uri.parse(r7.toString());
        Set<String> r2 = r0.getQueryParameterNames();
        Uri.Builder r1 = r0.buildUpon();
        Iterator r10 = r9.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.memorydata.plugin");
        if (r2.contains(r4) == true) goto L4;
        if (TextUtils.isEmpty(r5) == true) goto L4;
        r1.appendQueryParameter(r4, (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    L10:
        r7.delete(0, r7.length());
        r7.append(r1.build().toString());
    }

    public static void a(StringBuilder r6, boolean r7, Level r8) {
        Level r9 = (Level) ZeusTransformUtils.wrapperContextForParams(r8, Level.class, "com.obric.memorydata.plugin");
        if (f15110a == null) goto L26;
        if (r6 == null) goto L27;
        String r0 = r6.toString();
        if (TextUtils.isEmpty(r0) == false) goto L9;
        return;
    L9:
        Uri r1 = Uri.parse(r0);
        Set<String> r2 = r1.getQueryParameterNames();
        Uri.Builder r3 = r1.buildUpon();
        LinkedHashMap r4 = new LinkedHashMap();
        a(r4, r7, r9);
        Iterator r10 = r4.entrySet().iterator();
    L11:
        if (r10.hasNext() == false) goto L17;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.getValue(), String.class, "com.obric.memorydata.plugin");
        if (r2.contains(r5) == true) goto L11;
        if (TextUtils.isEmpty(r12) == true) goto L11;
        r3.appendQueryParameter(r5, (String) ZeusTransformUtils.preCheckCast(r11.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L11
    L17:
        r6.delete(0, r6.length());
        r6.append(r3.build().toString());
        return;
    L27:
        return;
    }

    public static void a(Map<String, String> r3, boolean r4, Level r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Level r7 = (Level) ZeusTransformUtils.wrapperContextForParams(r5, Level.class, "com.obric.memorydata.plugin");
        com.ss.android.common.a r0 = f15110a;
        if (r0 != null) goto L5;
        return;
    L5:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (com.ss.android.deviceregister.f.a() == false) goto L8;
        BDInstall.putCommonParams(r1, r6, r4, r7);
        return;
    L8:
        z.a(r6, r4, r7);
    }

    public static boolean a(String r5) {
        if (com.bytedance.common.utility.h.a(r5) == false) goto L6;
        return true;
    L6:
        if (r5.equalsIgnoreCase("unknown") == false) goto L9;
        return true;
    L9:
        if (r5.equalsIgnoreCase("None") == false) goto L11;
        return true;
    L11:
        int r2 = 0;
    L13:
        if (r2 >= r5.length()) goto L21;
        if (r5.charAt(r2) != '0') goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return false;
    L21:
        return true;
    }
}
