package com.bytedance.frameworks.baselib.network.d;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.j;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2321a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f2322b = null;
    private static final List<Pair<String, b>> c = null;

    static {
        f2322b = new AtomicBoolean(false);
        c = new CopyOnWriteArrayList();
    }

    public d() {
    }

    private static Request.Builder a(Request.Builder r5, Request r6, Pair<String, String> r7, Map<String, List<String>> r8, Set<String> r9, Map<String, List<String>> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (r12.isEmpty() == true) goto L12;
        Iterator r14 = r12.iterator();
    L6:
        if (r14.hasNext() == false) goto L11;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r0) == true) goto L6;
        r11.remove(r0);
        goto L6
    L11:
        boolean r15 = true;
    L14:
        if (r13.isEmpty() == true) goto L25;
        Iterator r16 = r13.entrySet().iterator();
    L17:
        if (r16.hasNext() == false) goto L26;
        Map.Entry r17 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L17;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r11.get(r17.getKey()), List.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L24;
        r1 = new ArrayList();
        r11.put((String) ZeusTransformUtils.preCheckCast(r17.getKey(), String.class, "com.obric.memorydata.plugin"), r1);
    L24:
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(r17.getValue(), Collection.class, "com.obric.memorydata.plugin"));
    L26:
        if (r7 == null) goto L35;
        if (r2 == false) goto L35;
        String r18 = a(r6.getUrl(), r7, r11);
        if (TextUtils.isEmpty(r18) == true) goto L35;
        if (r18.equals(r6.getUrl()) == true) goto L35;
        if (r5 != null) goto L34;
        r5 = r6.newBuilder();
    L34:
        r5.url(r18);
    L35:
        return r5;
    L25:
        r2 = r15;
        goto L26
    L12:
        r15 = false;
        goto L14
    }

    private static Request.Builder a(Request r2, Set<Header> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L5;
        return null;
    L5:
        if (r2.getHeaders() == null) goto L7;
        ArrayList r0 = new ArrayList(r2.getHeaders());
    L8:
        r0.removeAll(r4);
        Request.Builder r5 = r2.newBuilder();
        r5.headers(r0);
        return r5;
    L7:
        r0 = new ArrayList();
        goto L8
    }

    public static Request a(Request r12, com.bytedance.frameworks.baselib.network.http.b r13) {
        if (f2322b.get() == true) goto L46;
        List<Pair<String, b>> r0 = c;
        if (r0.isEmpty() == true) goto L46;
        r13.d.requestAuditStart();
        LinkedHashMap r5 = new LinkedHashMap();
        HashSet r1 = new HashSet();
        HashSet r6 = new HashSet();
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<Pair<String, b>> r2 = r0.iterator();
        Pair<String, String> r4 = null;
        c r8 = null;
    L9:
        if (r2.hasNext() == false) goto L38;
        Pair r3 = (Pair) ZeusTransformUtils.preCheckCast(r2.next(), Pair.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r3.first, String.class, "com.obric.memorydata.plugin");
        b r10 = (b) ZeusTransformUtils.preCheckCast(r3.second, b.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L9;
        if (TextUtils.isEmpty(r9) == true) goto L9;
        e r11 = r10.a(new a(r12.getUrl(), r12.getHeaders()));     // Catch: Throwable -> L36
        if (r11 == null) goto L9;
        c.a r14 = new c.a(r9);
        a(r11, r12, r14, r1);
        if (com.bytedance.common.utility.collection.a.a(r11.f2324b) == true) goto L24;
    L27:
        if (r4 == null) goto L48;
    L29:
        if (r4 == null) goto L32;
        a(r11, r5, r14, r6, r7);
    L32:
        if (r14.a() == true) goto L9;
        if (r8 != null) goto L35;
        r8 = new c();
    L35:
        r8.a(r14);
        goto L9
    L48:
        r4 = k.b(r12.getUrl(), r5);     // Catch: Throwable -> L47
        goto L29
    L24:
        if (r11.c == null) goto L32;
        if (r11.c.isEmpty() == true) goto L32;
    L36:
        th = move-exception;
        Log.e(f2321a, "onCallToRequestAudit failed, callbackIdentify:" + r9, th);
        goto L9
    L38:
        Request.Builder r15 = a(r12, r1);
        if (r4 == null) goto L41;
        r15 = a(r15, r12, r4, r5, r6, r7);
    L41:
        if (r15 == null) goto L43;
        r12 = r15.build();
    L43:
        if (r8 == null) goto L45;
        r13.d.setRequestAuditLog(r8.a());
    L45:
        r13.d.requestAuditEnd();
    L46:
        return r12;
    }

    public static String a(String r6, Pair<String, String> r7, Map<String, List<String>> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L29;
        return r6;
    L29:
        j r0 = new j(((String) ZeusTransformUtils.preCheckCast(r7.first, String.class, "com.obric.memorydata.plugin")) + ((String) ZeusTransformUtils.preCheckCast(r7.second, String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L28
        if (r9.isEmpty() == true) goto L24;
        Iterator r10 = r9.entrySet().iterator();     // Catch: Throwable -> L28
    L9:
        if (r10.hasNext() == false) goto L24;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r11 == null) goto L9;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r11.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L9;
        List r2 = (List) ZeusTransformUtils.preCheckCast(r11.getValue(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r2 == null) goto L9;
        if (r2.isEmpty() == true) goto L9;
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L28
    L22:
        if (r3.hasNext() == false) goto L9;
        r0.a((String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L28
    L24:
        String r12 = r0.a();     // Catch: Throwable -> L28
        String r13 = Uri.parse(r6).getEncodedFragment();     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r13) == true) goto L44;
        return r12 + "#" + r13;
    L44:
        return r12;
    L28:
        return r6;
    }

    private static void a() {
        f2322b.set(false);
    }

    private static void a(e r4, Request r5, c.a r6, Set<Header> r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.collection.a.a(r5.getHeaders()) == false) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.collection.a.a(r4.f2323a) == true) goto L27;
        Iterator<String> r9 = r4.f2323a.iterator();
    L9:
        if (r9.hasNext() == false) goto L28;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r0) == true) goto L9;
        List<Header> r2 = r5.headers(r0);
        if (com.bytedance.common.utility.collection.a.a(r2) == true) goto L9;
        if (r6.f2319a != null) goto L18;
        r6.f2319a = new HashSet();
    L18:
        r6.f2319a.add(r0);
        r8.addAll(r2);
        goto L9
    L28:
        return;
    }

    private static void a(e r4, Map<String, List<String>> r5, c.a r6, Set<String> r7, Map<String, List<String>> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        if (r9.isEmpty() == true) goto L19;
        if (com.bytedance.common.utility.collection.a.a(r4.f2324b) == true) goto L19;
        Iterator<String> r0 = r4.f2324b.iterator();
    L8:
        if (r0.hasNext() == false) goto L19;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r2) == true) goto L8;
        if (r9.containsKey(r2) == false) goto L8;
        if (r6.f2320b != null) goto L17;
        r6.f2320b = new HashSet();
    L17:
        r6.f2320b.add(r2);
        r10.add(r2);
    L19:
        if (r4.c != null) goto L21;
        return;
    L21:
        if (r4.c.isEmpty() == true) goto L53;
        Iterator<Map.Entry<String, String>> r12 = r4.c.entrySet().iterator();
    L24:
        if (r12.hasNext() == false) goto L54;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r14) == true) goto L24;
        if (r13.getValue() == null) goto L24;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r11.get(r14), List.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L34;
        r1 = new ArrayList();
        r11.put(r14, r1);
    L34:
        r1.add((String) ZeusTransformUtils.preCheckCast(r13.getValue(), String.class, "com.obric.memorydata.plugin"));
        if (r6.c != null) goto L37;
        r6.c = new HashSet();
    L37:
        r6.c.add(r14);
        goto L24
    L54:
        return;
    }

    public static void a(JSONObject r3) {
        if (r3 != null) goto L10;
        return;
    L10:
        a();     // Catch: Throwable -> L9
        AtomicBoolean r0 = f2322b;     // Catch: Throwable -> L9
        boolean r2 = false;
        if (r3.optInt("req_audit_disabled", 0) <= 0) goto L7;
        r2 = true;
    L7:
        r0.set(r2);     // Catch: Throwable -> L9
        return;
    }
}
