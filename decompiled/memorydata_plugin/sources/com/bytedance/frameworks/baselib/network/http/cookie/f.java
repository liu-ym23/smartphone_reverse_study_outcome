package com.bytedance.frameworks.baselib.network.http.cookie;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.impl.SerializableHttpCookie;
import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class f implements c {
    private static String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Keva f2395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f2396b;
    private final Map<a, Set<e>> c;
    private final ReadWriteLock d;
    private boolean e;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f2398b;
        private final boolean c;

        public a(String r1, String r2, boolean r3) {
            this.f2397a = r1;
            this.f2398b = r2;
            this.c = r3;
        }

        public String a() {
            return this.f2397a;
        }

        public String b() {
            return this.f2398b;
        }

        public boolean c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L25:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L25;
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.c == r6.c) goto L13;
            return false;
        L13:
            String r1 = this.f2397a;
            String r2 = null;
            if (r1 == null) goto L16;
            String r3 = r1.toLowerCase(Locale.US);
        L17:
            String r4 = r6.f2397a;
            if (r4 == null) goto L21;
            r2 = r4.toLowerCase(Locale.US);
        L21:
            if (Objects.equals(r3, r2) == true) goto L24;
            return false;
        L24:
            return Objects.equals(this.f2398b, r6.f2398b);
        L16:
            r3 = null;
            goto L17
        }

        public int hashCode() {
            String r0 = this.f2397a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r2 * 31) + 17;
            String r4 = this.f2398b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return (r3 + (r1 * 31)) + ((this.c ? 1 : 0) * 31);
        L5:
            r2 = r0.toLowerCase(Locale.US).hashCode();
            goto L6
        }
    }

    public f() {
        this.f2396b = b.c;
        this.c = new LinkedHashMap();
        this.d = new ReentrantReadWriteLock();
        this.e = false;
        this.f2395a = Keva.getRepo("ttnetKevaCookieStorage", 1);
        d();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.e("PersistentCookieStore", "loadAllFromKeva error", th);
    }

    private String a(URI r11, c.a r12) {
        c.a r13 = (c.a) ZeusTransformUtils.wrapperContextForParams(r12, c.a.class, "com.obric.memorydata.plugin");
        HashSet r0 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        String r2 = d.a(r11);
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return null;
    L8:
        ArrayList r3 = new ArrayList();
        this.d.readLock().lock();
        Iterator<Map.Entry<a, Set<e>>> r4 = this.c.entrySet().iterator();     // Catch: Throwable -> L69
        HashSet r5 = null;
    L10:
        if (r4.hasNext() == false) goto L40;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
        a r7 = (a) ZeusTransformUtils.preCheckCast(r6.getKey(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
        Set r8 = (Set) ZeusTransformUtils.preCheckCast(r6.getValue(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
        if (r8 == null) goto L10;
        if (r8.isEmpty() == true) goto L10;
        if (d.a(r2, r7.a(), r7.c()) == false) goto L10;
        if (d.b(r7.b(), r11.getPath()) == false) goto L10;
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L69
    L25:
        if (r9.hasNext() == false) goto L10;
        e r10 = (e) ZeusTransformUtils.preCheckCast(r9.next(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
        if (r10 == null) goto L25;
        if (r10.k() == true) goto L31;
        if (d.a(r10, r11) == false) goto L25;
        r3.add(r10.toString());     // Catch: Throwable -> L69
        if (r13 == null) goto L25;
        r13.onCookieGet(r10);     // Catch: Throwable -> L69
        goto L25
    L31:
        if (r5 != null) goto L33;
        r5 = new HashSet();     // Catch: Throwable -> L69
    L33:
        r5.add(r7);     // Catch: Throwable -> L69
        goto L25
    L40:
        this.d.readLock().unlock();
        if (com.bytedance.common.utility.collection.a.a(r5) == true) goto L68;
        this.d.writeLock().lock();
        Iterator r14 = r5.iterator();     // Catch: Throwable -> L64
    L44:
        if (r14.hasNext() == false) goto L63;
        Set r15 = (Set) ZeusTransformUtils.preCheckCast(this.c.get((a) ZeusTransformUtils.preCheckCast(r14.next(), a.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        if (com.bytedance.common.utility.collection.a.a(r15) == true) goto L44;
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L64
    L51:
        if (r16.hasNext() == false) goto L60;
        e r17 = (e) ZeusTransformUtils.preCheckCast(r16.next(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        if (r17 == null) goto L51;
        if (r17.k() == false) goto L51;
        if (r0 != null) goto L58;
        r0 = new HashSet();     // Catch: Throwable -> L64
    L58:
        r0.add(r17);     // Catch: Throwable -> L64
        goto L51
    L60:
        if (com.bytedance.common.utility.collection.a.a(r0) == true) goto L44;
        a(r0);     // Catch: Throwable -> L64
        r15.removeAll(r0);     // Catch: Throwable -> L64
        r0.clear();     // Catch: Throwable -> L64
        goto L44
    L63:
        this.d.writeLock().unlock();
    L64:
        th = move-exception;
        this.d.writeLock().unlock();
        throw th;
    L68:
        return a(r3);
    L69:
        th = move-exception;
        this.d.readLock().unlock();
        throw th;
    }

    private String a(List<String> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L6;
        return null;
    L6:
        StringBuilder r6 = new StringBuilder();
        boolean r1 = true;
        Iterator r7 = r4.iterator();
    L8:
        if (r7.hasNext() == false) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        if (r1 == true) goto L11;
        r6.append("; ").append(r2);
        goto L8
    L11:
        r6.append(r2);
        r1 = false;
        goto L8
    L14:
        return r6.toString();
    }

    public static void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L17;
        return;
    L17:
        String r0 = f;     // Catch: Throwable -> L14
        if (r0 != null) goto L9;
        r0 = "cookieStore";
    L9:
        if (Build.VERSION.SDK_INT >= 11) goto L11;
        int r1 = 0;
    L12:
        r4.getSharedPreferences(r0, r1).edit().clear().apply();     // Catch: Throwable -> L14
        return;
    L11:
        r1 = 4;
    L14:
        th = move-exception;
        th.printStackTrace();
    }

    private static /* synthetic */ void a(Map r3, e r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(r5.get(r4.toString()), Set.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new HashSet();
        r5.put(r4.toString(), r0);
    L5:
        r0.add((e) ZeusTransformUtils.preCheckCast(r4.clone(), e.class, "com.obric.memorydata.plugin"));
    }

    private void a(Set<e> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.collection.a.a(r5) == false) goto L5;
        return;
    L5:
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r6.next(), e.class, "com.obric.memorydata.plugin");
        this.f2395a.erase(c(r0));
        goto L7
    }

    @Deprecated
    public static void b() {
        f = "ttnetCookieStore";
    }

    private void b(e r3) {
        String r0 = c(r3);
        if (r3.k() == false) goto L6;
        this.f2395a.erase(r0);
        return;
    L6:
        byte[] r4 = new SerializableHttpCookie(r3).encode();
        if (r4 == null) goto L10;
        this.f2395a.storeBytes(r0, r4);
        return;
    }

    private String c(e r3) {
        StringBuilder r2 = new StringBuilder().append(r3.a()).append("|").append(r3.d()).append("|").append(r3.c()).append("|");
        if (r3.b() == false) goto L5;
        String r4 = "1";
    L7:
        return r2.append(r4).toString();
    L5:
        r4 = "0";
        goto L7
    }

    private void d() {
        Map<String, ?> r1 = this.f2395a.getAll();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isEmpty() == true) goto L86;
        Iterator<Map.Entry<String, ?>> r2 = r1.entrySet().iterator();
        boolean r4 = false;
    L9:
        if (r2.hasNext() == false) goto L61;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        Object r6 = r5.getValue();
        if (r6 == null) goto L9;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r7) == true) goto L18;
        String[] r8 = r7.split("\\|", -1);     // Catch: Throwable -> L58
        if (r8.length != 4) goto L21;
        SerializableHttpCookie r10 = null;
        if (r8[0].isEmpty() == false) goto L26;
        String r9 = null;
    L28:
        if (r8[1].isEmpty() == false) goto L30;
        String r11 = null;
    L32:
        if (r8[2].isEmpty() == false) goto L34;
        String r12 = null;
    L36:
        if (r8[3].isEmpty() == false) goto L38;
    L40:
        boolean r13 = false;
    L42:
        if (TextUtils.isEmpty(r9) == true) goto L56;
        if (TextUtils.isEmpty(r12) == true) goto L56;
        r10 = SerializableHttpCookie.decode(r9, r11, r12, r13, (byte[]) ZeusTransformUtils.preCheckCast(r6, byte[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L48
    L50:
        if (r10 == null) goto L51;
        a r14 = new a(r9, r11, r13);     // Catch: Throwable -> L58
        Set<e> r15 = (Set) ZeusTransformUtils.preCheckCast(this.c.get(r14), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L58
        if (r15 != null) goto L55;
        r15 = new HashSet();     // Catch: Throwable -> L58
        this.c.put(r14, r15);     // Catch: Throwable -> L58
    L55:
        r15.add(r10.getHttpCookie());     // Catch: Throwable -> L58
        goto L9
    L51:
        Keva r16 = this.f2395a;     // Catch: Throwable -> L58
    L22:
        r16.erase(r7);     // Catch: Throwable -> L58
        goto L18
    L48:
        th = move-exception;
        Logger.e("PersistentCookieStore", "decode cookie error, name=" + r12, th);     // Catch: Throwable -> L58
    L56:
        r16 = this.f2395a;     // Catch: Throwable -> L58
        goto L22
    L38:
        if ("1".equalsIgnoreCase(r8[3]) == false) goto L40;
        r13 = true;
        goto L42
    L34:
        r12 = r8[2];     // Catch: Throwable -> L58
        goto L36
    L30:
        r11 = r8[1];     // Catch: Throwable -> L58
        goto L32
    L26:
        r9 = r8[0];     // Catch: Throwable -> L58
        goto L28
    L21:
        r16 = this.f2395a;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        Logger.e("PersistentCookieStore", "load cookie error, kevaStoreKey=" + r7, th);
    L18:
        r4 = true;
        goto L9
    L61:
        if (this.c.isEmpty() == true) goto L84;
        if (r4 == true) goto L85;
        this.e = true;
        return;
    L85:
        return;
    L84:
        return;
    }

    public static /* synthetic */ void lambda$aC2_OhkEA4k6yOs4RB55ms0uyQ4(Map r0, e r1) {
        a(r0, r1);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cookie.c
    public String a(URI r2) {
        return a(r2, null);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cookie.c
    public boolean a() {
        if (this.e == true) goto L5;
    L7:
        return false;
    L5:
        if (c() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cookie.c
    public boolean a(e r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (r5.g() < 0) goto L6;
    L8:
        a r0 = new a(r5.a(), r5.d(), r5.b());
        this.d.writeLock().lock();
        b(r5);     // Catch: Throwable -> L18
        Set<e> r1 = (Set) ZeusTransformUtils.preCheckCast(this.c.get(r0), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r1 != null) goto L12;
        r1 = new HashSet();     // Catch: Throwable -> L18
        this.c.put(r0, r1);     // Catch: Throwable -> L18
    L14:
        if (r5.k() == true) goto L16;
        r1.add(r5);     // Catch: Throwable -> L18
    L16:
        this.d.writeLock().unlock();
        return true;
    L12:
        r1.remove(r5);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        this.d.writeLock().unlock();
        throw th;
    L6:
        if (r5.g() == (-1)) goto L8;
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cookie.c
    public boolean a(URI r6, String r7, boolean r8) {
        if (r6 != null) goto L5;
    L26:
        return false;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L26;
        e r1 = null;
        r1 = e.a(r6, r7);     // Catch: Throwable -> L10
    L12:
        if (r1 != null) goto L15;
        return false;
    L15:
        if (r1.b() == false) goto L17;
    L19:
        if (r8 == false) goto L25;
        CookieMetricManager.a().a(r6, r1);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.printStackTrace();
    L25:
        return a(r1);
    L17:
        if (this.f2396b.a(r6, r1) == true) goto L19;
        return false;
    L10:
        th = move-exception;
        Logger.e("PersistentCookieStore", "parse cookie error, setCookieLine=" + r7 + ", uri=" + r6, th);
        goto L12
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cookie.c
    public Pair<String, Map<String, Set<e>>> b(URI r3) {
        final HashMap r0 = new HashMap();
        return new Pair(a(r3, new $$Lambda$f$aC2_OhkEA4k6yOs4RB55ms0uyQ4(r0)), r0);
    }

    public boolean c() {
        this.d.readLock().lock();
        Iterator<Map.Entry<a, Set<e>>> r1 = this.c.entrySet().iterator();     // Catch: Throwable -> L14
    L5:
        if (r1.hasNext() == false) goto L13;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r2 == null) goto L5;
        if (com.bytedance.common.utility.collection.a.a((Collection) ZeusTransformUtils.preCheckCast(r2.getValue(), Collection.class, "com.obric.memorydata.plugin")) == true) goto L5;
        boolean r0 = true;
    L11:
        this.d.readLock().unlock();
        return r0;
    L13:
        r0 = false;
    L14:
        th = move-exception;
        this.d.readLock().unlock();
        throw th;
    }
}
